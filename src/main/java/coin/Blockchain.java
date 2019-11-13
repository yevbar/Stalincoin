package coin;

import java.security.Security;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;

import com.google.gson.GsonBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Blockchain {
  // Well, I guess this is where I peak
  // I'm making a fricking _*blockchain*_ in 2019 :sigh:
  public static ArrayList<Block> blockchain;

  public static int difficulty = 5;

  public Blockchain() {
    this.blockchain = new ArrayList<Block>();
    Security.addProvider(new BouncyCastleProvider());
  }

  public Blockchain(boolean withDummyValues) {
    blockchain = new ArrayList<Block>();
    Security.addProvider(new BouncyCastleProvider());

    Wallet walletA = new Wallet();
    Wallet walletB = new Wallet();

    System.out.println("Public and private keys");
    System.out.println(StringUtil.getStringFromKey(walletA.publicKey));
    System.out.println(StringUtil.getStringFromKey(walletA.privateKey));

    blockchain.add(new Block("Hi I'm the first block", "0"));
    System.out.println("Now mining the first block...");
    blockchain.get(0).mine(difficulty);

    blockchain.add(new Block("Yo I'm the second block", blockchain.get(blockchain.size()-1).hash));
    System.out.println("Now mining the second  block...");
    blockchain.get(1).mine(difficulty);

    blockchain.add(new Block("Hey I'm the third block", blockchain.get(blockchain.size()-1).hash));
    System.out.println("Now mining the third block...");
    blockchain.get(2).mine(difficulty);

    System.out.println("Blockchain is valid? " + isValid());

    String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
    System.out.println("The blockchain:");
    System.out.println(blockchainJson);
  }

  public boolean isValid() {
    Block currentBlock;
    Block previousBlock;
    String target = new String(new char[difficulty]).replace('\0', '0');

    for (int i = 1; i < blockchain.size(); i++) {
      currentBlock = blockchain.get(i);
      previousBlock = blockchain.get(i-1);

      if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
        System.out.println("Current hash does not have expected value");
        return false;
      }

      if (!previousBlock.hash.equals(currentBlock.previousHash)) {
        System.out.println("Previous hash does not have expected value");
        return false;
      }

      if (!currentBlock.hash.substring(0,difficulty).equals(target)) {
        System.out.println("Current hash does not satisfy difficulty (it hasn't been mined)");
        return false;
      }
    }

    return true;
  }
}

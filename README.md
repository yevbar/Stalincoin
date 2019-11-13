# Stalincoin

This is the second version, I've created a simple Java Spring application following [this tutorial](https://spring.io/guides/gs/spring-boot/) and also introduced some simple crypto stuff by following [this article series](https://medium.com/programmers-blockchain/create-simple-blockchain-java-tutorial-from-scratch-6eeed3cb03fa) however everything's been typed out by hand so I did legitimately write out this project thus far.

## Requirements

* JDK
* Gradle

## Usage

Clone the repository locally

```bash
$ git clone https://github.com/yevbar/Stalincoin.git
$ cd Stalincoin
```

Once there, install dependencies (you can simply run `gradle build` but I have a small makefile so everything can be a `make X` command)

```bash
$ make gradle
```

To run locally, run the generated jar file in `/build` or just use my dandy makefile

```bash
$ make run
```

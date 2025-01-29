plugins {
    `java-library`
    `maven-publish`
    id("pl.allegro.tech.build.axion-release") version "1.18.16"
}

scmVersion {
    releaseOnlyOnReleaseBranches = true
    unshallowRepoOnCI = true
}

group = "dev.panuszewski"
version = scmVersion.version

publishing {
    publications {
        create<MavenPublication>("library") {
            from(components["java"])
        }
    }

    repositories {
        maven {
            name = "githubPackages"
            url = uri("https://maven.pkg.github.com/semidude/another-playground-library")
            credentials {
                username = "random-username"
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
}
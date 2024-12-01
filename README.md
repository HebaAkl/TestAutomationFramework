# TestAutomationFramework
This is a test automation framework for API and E2E tests and it also could be used for mobile but just change the driver creation.

Once cloning this project, you can remove any extra unused packages according to your project. example: you can remove all packages related to API tests as long as it's not required to write API tests.

Login & Product  tests are just an example to demonstrate the idea of the structure.

# Build Tools:
Gradle

# Pre-requisite
You will need to install Java, Gradle, docker

# Add environment vars (.env)
Create .env file in the app directory and add the env vars that exist in env_example

# Visualizing E2E Tests
Install VNC to view the running tests visually[optional]

# Steps to Run Tests
Open project directory in terminal

Run docker compose up 

Open http://localhost:4444/ui/index.html#/ and make sure browser nodes are up

Open VNC and open the following ports for different browsers:

chrome1: 0.0.0.0:5901
chrome2: 0.0.0.0:5903
firefox: 0.0.0.0:5904
edge: 0.0.0.0:5905

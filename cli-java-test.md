## This is a base prototype with mostly hardcoded values on existing sample code

This deployment is set to use 50% of the cpu on 1 core, with 80% bandwidth and by default runs for 1 hour before self termination.
If using a different unregistered client id for each run, please send your settings and profile information with the custom clientid to profile@weave.sh so that we can let you know how many work units were successully completed in the hour.   

This base test client does not communicate directly with the weave.sh manager and is provided solely as a way to validate the environment for free with the first active vendor (Plura Processing).

```bash
usage: java -Xmx256m -Xms256m -XX:+CMSClassUnloadingEnabled -XX:+CMSPermGenSweepingEnabled weave.Fiber_Weave_1c5b8t1hr example-clientId-101112-2250

```

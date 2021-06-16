$ ./wait-for-it.sh -t 0 mysql:3306 -- echo "mysql ok"
wait-for-it.sh: waiting for  mysql:3306 without a timeout
wait-for-it.sh: mysql:3306 is available after 0 seconds
mysql ok

java -jar /usr/local/lib/demo.jar

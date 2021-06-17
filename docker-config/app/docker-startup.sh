wait-for-it.sh -t 0 $MYSQL_HOST:$MYSQL_INTERNAL_PORT -- echo "mysql ok"

java -jar /usr/local/lib/demo.jar


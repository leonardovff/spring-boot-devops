# wait for the mysql docker to be running
while ! nc $MYSQL_HOST $MYSQL_INTERNAL_PORT; do
  >&2 echo "Mysql is unavailable - sleeping"
  sleep 1
done

>&2 echo "Mysql is up - executing command"

java -jar /usr/local/lib/demo.jar
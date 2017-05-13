call mvn clean package
echo ---------------------------------------
echo ---------------------------------------
echo Starts local dice image building:
echo ---------------------------------------
echo ---------------------------------------
pause
docker build -t dice .
echo ---------------------------------------
echo ---------------------------------------
echo Executing dice image:
echo ---------------------------------------
echo ---------------------------------------
pause
docker run -p 4000:8080 dice

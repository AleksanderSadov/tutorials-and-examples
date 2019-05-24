FROM alpine:3.5
RUN apk add --update py2-pip
COPY requirements.txt /usr/src/app/requirements.txt
RUN pip install --no-cache-dir -r /usr/src/app/requirements.txt
COPY app.py /usr/src/app/app.py
COPY templates/index.html /usr/src/app/templates/index.html
EXPOSE 5000
CMD ["python", "/usr/src/app/app.py"]

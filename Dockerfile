FROM harbor.bluestembrands.com/core/openjre:8

ADD . /source
WORKDIR /source
CMD ["/source/util/startApp.sh"]
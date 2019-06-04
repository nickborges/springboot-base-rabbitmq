#imagem base
FROM gradle:jdk8

#nome do criador da imagem
MAINTAINER Nick Kras Borges

#variáveis de ambiente
#ENV JAVA_ENV=producao
#ENV PORT=8085

#copia o código fonte para dentro da imagem(. copia tudo que ta dentro da pasta definida)
COPY . /home/gradle/project

#diretrório raiz do container(RUN e ENTRYPOINT são executados dentro deste diretório)
WORKDIR /home/gradle/project

#comando executado durante o build da imagem
#RUN gradle clean build

#adiciona o jar buildado
ADD build/libs/springboot-base-rabbitmq-1.0.0.jar springboot-base-rabbitmq-1.0.0.jar

#comando executado após o start do container
ENTRYPOINT ["gradle", "build"]

ENTRYPOINT ["java", "-jar", "springboot-base-rabbitmq-1.0.0.jar"]

#expões o container na porta definida
EXPOSE 8081
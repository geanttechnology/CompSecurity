.class final Lcom/amazon/sdk/availability/AwsUtil;
.super Ljava/lang/Object;
.source "AwsUtil.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 139
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 140
    return-void
.end method

.method public static hmacSha1(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 7
    .param p0, "key"    # Ljava/lang/String;
    .param p1, "data"    # Ljava/lang/String;

    .prologue
    .line 123
    const/4 v3, 0x0

    .line 125
    .local v3, "result":Ljava/lang/String;
    :try_start_0
    const-string/jumbo v5, "HmacSHA1"

    invoke-static {v5}, Ljavax/crypto/Mac;->getInstance(Ljava/lang/String;)Ljavax/crypto/Mac;

    move-result-object v1

    .line 126
    .local v1, "mac":Ljavax/crypto/Mac;
    new-instance v4, Ljavax/crypto/spec/SecretKeySpec;

    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object v5

    invoke-virtual {v1}, Ljavax/crypto/Mac;->getAlgorithm()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v4, v5, v6}, Ljavax/crypto/spec/SecretKeySpec;-><init>([BLjava/lang/String;)V

    .line 127
    .local v4, "signingKey":Ljavax/crypto/spec/SecretKeySpec;
    invoke-virtual {v1, v4}, Ljavax/crypto/Mac;->init(Ljava/security/Key;)V

    .line 128
    invoke-virtual {p1}, Ljava/lang/String;->getBytes()[B

    move-result-object v5

    invoke-virtual {v1, v5}, Ljavax/crypto/Mac;->doFinal([B)[B

    move-result-object v2

    .line 129
    .local v2, "rawHmac":[B
    const/4 v5, 0x2

    invoke-static {v2, v5}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 133
    .end local v1    # "mac":Ljavax/crypto/Mac;
    .end local v2    # "rawHmac":[B
    .end local v4    # "signingKey":Ljavax/crypto/spec/SecretKeySpec;
    :goto_0
    return-object v3

    .line 130
    :catch_0
    move-exception v0

    .line 131
    .local v0, "e":Ljava/lang/Exception;
    const-string/jumbo v5, "failed to generate HMAC"

    invoke-static {v5, v0}, Lcom/amazon/sdk/availability/Logger;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public static putObject(Lcom/amazonaws/auth/AWSCredentials;Ljava/lang/String;Ljava/lang/String;Ljava/io/File;Ljava/util/Map;)Z
    .locals 11
    .param p0, "creds"    # Lcom/amazonaws/auth/AWSCredentials;
    .param p1, "s3Bucket"    # Ljava/lang/String;
    .param p2, "s3Key"    # Ljava/lang/String;
    .param p3, "file"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazonaws/auth/AWSCredentials;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/io/File;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .line 45
    .local p4, "metadata":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v8, 0x0

    .line 47
    .local v8, "success":Z
    :try_start_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    .line 48
    .local v6, "start":J
    new-instance v5, Lcom/amazonaws/services/s3/AmazonS3Client;

    invoke-direct {v5, p0}, Lcom/amazonaws/services/s3/AmazonS3Client;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    .line 49
    .local v5, "s3Client":Lcom/amazonaws/services/s3/AmazonS3Client;
    new-instance v4, Lcom/amazonaws/services/s3/model/PutObjectRequest;

    invoke-direct {v4, p1, p2, p3}, Lcom/amazonaws/services/s3/model/PutObjectRequest;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)V

    .line 50
    .local v4, "por":Lcom/amazonaws/services/s3/model/PutObjectRequest;
    if-eqz p4, :cond_1

    .line 51
    invoke-virtual {v4}, Lcom/amazonaws/services/s3/model/PutObjectRequest;->getMetadata()Lcom/amazonaws/services/s3/model/ObjectMetadata;

    move-result-object v3

    .line 52
    .local v3, "objectMetadata":Lcom/amazonaws/services/s3/model/ObjectMetadata;
    if-nez v3, :cond_0

    .line 53
    new-instance v3, Lcom/amazonaws/services/s3/model/ObjectMetadata;

    .end local v3    # "objectMetadata":Lcom/amazonaws/services/s3/model/ObjectMetadata;
    invoke-direct {v3}, Lcom/amazonaws/services/s3/model/ObjectMetadata;-><init>()V

    .line 55
    .restart local v3    # "objectMetadata":Lcom/amazonaws/services/s3/model/ObjectMetadata;
    :cond_0
    invoke-virtual {v3, p4}, Lcom/amazonaws/services/s3/model/ObjectMetadata;->setUserMetadata(Ljava/util/Map;)V

    .line 57
    invoke-virtual {v4, v3}, Lcom/amazonaws/services/s3/model/PutObjectRequest;->setMetadata(Lcom/amazonaws/services/s3/model/ObjectMetadata;)V

    .line 60
    .end local v3    # "objectMetadata":Lcom/amazonaws/services/s3/model/ObjectMetadata;
    :cond_1
    invoke-virtual {v5, v4}, Lcom/amazonaws/services/s3/AmazonS3Client;->putObject(Lcom/amazonaws/services/s3/model/PutObjectRequest;)Lcom/amazonaws/services/s3/model/PutObjectResult;

    .line 61
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v9

    sub-long v1, v9, v6

    .line 62
    .local v1, "elapsed":J
    const/4 v8, 0x1

    .line 63
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v10, "put object elapsed time: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Lcom/amazon/sdk/availability/Logger;->i(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 67
    .end local v1    # "elapsed":J
    .end local v4    # "por":Lcom/amazonaws/services/s3/model/PutObjectRequest;
    .end local v5    # "s3Client":Lcom/amazonaws/services/s3/AmazonS3Client;
    .end local v6    # "start":J
    :goto_0
    return v8

    .line 64
    :catch_0
    move-exception v0

    .line 65
    .local v0, "e":Ljava/lang/Throwable;
    const-string/jumbo v9, "failed to put S3 object from file"

    invoke-static {v9, v0}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public static sendMessage(Lcom/amazonaws/auth/AWSCredentials;Ljava/lang/String;Lorg/json/JSONObject;)Z
    .locals 6
    .param p0, "creds"    # Lcom/amazonaws/auth/AWSCredentials;
    .param p1, "queueName"    # Ljava/lang/String;
    .param p2, "payload"    # Lorg/json/JSONObject;

    .prologue
    .line 100
    const/4 v3, 0x0

    .line 102
    .local v3, "success":Z
    :try_start_0
    new-instance v2, Lcom/amazonaws/services/sqs/AmazonSQSClient;

    invoke-direct {v2, p0}, Lcom/amazonaws/services/sqs/AmazonSQSClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    .line 103
    .local v2, "sqsClient":Lcom/amazonaws/services/sqs/AmazonSQSClient;
    new-instance v4, Lcom/amazonaws/services/sqs/model/SendMessageRequest;

    invoke-virtual {p2}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, p1, v5}, Lcom/amazonaws/services/sqs/model/SendMessageRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v2, v4}, Lcom/amazonaws/services/sqs/AmazonSQSClient;->sendMessage(Lcom/amazonaws/services/sqs/model/SendMessageRequest;)Lcom/amazonaws/services/sqs/model/SendMessageResult;

    move-result-object v1

    .line 105
    .local v1, "sendResult":Lcom/amazonaws/services/sqs/model/SendMessageResult;
    const/4 v3, 0x1

    .line 106
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "send message id: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazonaws/services/sqs/model/SendMessageResult;->getMessageId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/sdk/availability/Logger;->i(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 110
    .end local v1    # "sendResult":Lcom/amazonaws/services/sqs/model/SendMessageResult;
    .end local v2    # "sqsClient":Lcom/amazonaws/services/sqs/AmazonSQSClient;
    :goto_0
    return v3

    .line 107
    :catch_0
    move-exception v0

    .line 108
    .local v0, "e":Ljava/lang/Throwable;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "failed to submit SQS submission notification: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v0}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

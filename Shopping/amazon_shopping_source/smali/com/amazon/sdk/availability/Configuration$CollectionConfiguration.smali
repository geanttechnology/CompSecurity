.class public Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;
.super Ljava/lang/Object;
.source "Configuration.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/sdk/availability/Configuration;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CollectionConfiguration"
.end annotation


# instance fields
.field private awsAccessId:Ljava/lang/String;

.field private awsSecretKey:Ljava/lang/String;

.field private awsSessionToken:Ljava/lang/String;

.field protected localStorageEncryptionKey:Ljava/lang/String;

.field protected localStorageEncryptionScheme:Ljava/lang/String;

.field protected localStorageMaxRollover:Ljava/lang/Long;

.field protected localStoragePersistenceFormat:Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;

.field protected localStorageRolloverFilesize:Ljava/lang/Long;

.field private publicKeySerial:J

.field private publicKeyString:Ljava/lang/String;

.field private s3Bucket:Ljava/lang/String;

.field private s3DateFormatKey:Ljava/lang/String;

.field private sqsQueueName:Ljava/lang/String;

.field private submissionPolicies:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/sdk/availability/Configuration$Policy;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lorg/json/JSONObject;)V
    .locals 7
    .param p1, "json"    # Lorg/json/JSONObject;

    .prologue
    const-wide/16 v5, 0x0

    .line 354
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 355
    if-eqz p1, :cond_2

    .line 356
    new-instance v3, Ljava/util/LinkedList;

    invoke-direct {v3}, Ljava/util/LinkedList;-><init>()V

    iput-object v3, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->submissionPolicies:Ljava/util/List;

    .line 357
    const-string/jumbo v3, "policies"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v1

    .line 358
    .local v1, "policies":Lorg/json/JSONArray;
    if-eqz v1, :cond_1

    .line 359
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-virtual {v1}, Lorg/json/JSONArray;->length()I

    move-result v3

    if-ge v0, v3, :cond_1

    .line 360
    invoke-virtual {v1, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v2

    .line 361
    .local v2, "policy":Lorg/json/JSONObject;
    if-eqz v2, :cond_0

    .line 362
    iget-object v3, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->submissionPolicies:Ljava/util/List;

    new-instance v4, Lcom/amazon/sdk/availability/Configuration$Policy;

    invoke-direct {v4, v2}, Lcom/amazon/sdk/availability/Configuration$Policy;-><init>(Lorg/json/JSONObject;)V

    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 359
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 366
    .end local v0    # "i":I
    .end local v2    # "policy":Lorg/json/JSONObject;
    :cond_1
    const-string/jumbo v3, "awsAccessId"

    const-string/jumbo v4, ""

    invoke-static {p1, v3, v4}, Lcom/amazon/sdk/availability/Configuration;->optJsonString(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->awsAccessId:Ljava/lang/String;

    .line 367
    const-string/jumbo v3, "awsSecretKey"

    const-string/jumbo v4, ""

    invoke-static {p1, v3, v4}, Lcom/amazon/sdk/availability/Configuration;->optJsonString(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->awsSecretKey:Ljava/lang/String;

    .line 368
    const-string/jumbo v3, "awsSessionToken"

    const-string/jumbo v4, ""

    invoke-static {p1, v3, v4}, Lcom/amazon/sdk/availability/Configuration;->optJsonString(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->awsSessionToken:Ljava/lang/String;

    .line 369
    const-string/jumbo v3, "s3Bucket"

    const-string/jumbo v4, ""

    invoke-static {p1, v3, v4}, Lcom/amazon/sdk/availability/Configuration;->optJsonString(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->s3Bucket:Ljava/lang/String;

    .line 370
    const-string/jumbo v3, "s3DateFormatKey"

    const-string/jumbo v4, ""

    invoke-static {p1, v3, v4}, Lcom/amazon/sdk/availability/Configuration;->optJsonString(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->s3DateFormatKey:Ljava/lang/String;

    .line 371
    const-string/jumbo v3, "sqsQueueName"

    const/4 v4, 0x0

    invoke-static {p1, v3, v4}, Lcom/amazon/sdk/availability/Configuration;->optJsonString(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->sqsQueueName:Ljava/lang/String;

    .line 372
    const-string/jumbo v3, "localStorageEncryptionKey"

    const-string/jumbo v4, ""

    invoke-static {p1, v3, v4}, Lcom/amazon/sdk/availability/Configuration;->optJsonString(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->localStorageEncryptionKey:Ljava/lang/String;

    .line 373
    const-string/jumbo v3, "localStorageEncryptionScheme"

    const-string/jumbo v4, ""

    invoke-static {p1, v3, v4}, Lcom/amazon/sdk/availability/Configuration;->optJsonString(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->localStorageEncryptionScheme:Ljava/lang/String;

    .line 374
    const-string/jumbo v3, "localStorageMaxRollover"

    invoke-virtual {p1, v3, v5, v6}, Lorg/json/JSONObject;->optLong(Ljava/lang/String;J)J

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->localStorageMaxRollover:Ljava/lang/Long;

    .line 375
    const-string/jumbo v3, "localStoragePersistenceType"

    const-string/jumbo v4, ""

    invoke-static {p1, v3, v4}, Lcom/amazon/sdk/availability/Configuration;->optJsonString(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;->fromString(Ljava/lang/String;)Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->localStoragePersistenceFormat:Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;

    .line 378
    const-string/jumbo v3, "localStorageRolloverFilesize"

    invoke-virtual {p1, v3, v5, v6}, Lorg/json/JSONObject;->optLong(Ljava/lang/String;J)J

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->localStorageRolloverFilesize:Ljava/lang/Long;

    .line 379
    const-string/jumbo v3, "s3EncryptionPublicKey"

    const-string/jumbo v4, ""

    invoke-static {p1, v3, v4}, Lcom/amazon/sdk/availability/Configuration;->optJsonString(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->publicKeyString:Ljava/lang/String;

    .line 380
    const-string/jumbo v3, "s3EncryptionPublicKeySerial"

    const-wide/16 v4, -0x1

    invoke-virtual {p1, v3, v4, v5}, Lorg/json/JSONObject;->optLong(Ljava/lang/String;J)J

    move-result-wide v3

    iput-wide v3, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->publicKeySerial:J

    .line 382
    .end local v1    # "policies":Lorg/json/JSONArray;
    :cond_2
    return-void
.end method


# virtual methods
.method public getAwsAccessId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 399
    iget-object v0, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->awsAccessId:Ljava/lang/String;

    return-object v0
.end method

.method public getAwsSecretKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 407
    iget-object v0, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->awsSecretKey:Ljava/lang/String;

    return-object v0
.end method

.method public getAwsSesssionToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 415
    iget-object v0, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->awsSessionToken:Ljava/lang/String;

    return-object v0
.end method

.method public getLocalStorageEncryptionKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 447
    iget-object v0, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->localStorageEncryptionKey:Ljava/lang/String;

    return-object v0
.end method

.method public getLocalStorageEncryptionScheme()Ljava/lang/String;
    .locals 1

    .prologue
    .line 455
    iget-object v0, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->localStorageEncryptionScheme:Ljava/lang/String;

    return-object v0
.end method

.method public getLocalStorageMaxRollover()Ljava/lang/Long;
    .locals 1

    .prologue
    .line 463
    iget-object v0, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->localStorageMaxRollover:Ljava/lang/Long;

    return-object v0
.end method

.method public getLocalStoragePersistenceFormat()Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;
    .locals 1

    .prologue
    .line 479
    iget-object v0, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->localStoragePersistenceFormat:Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;

    return-object v0
.end method

.method public getLocalStorageRolloverFilesize()Ljava/lang/Long;
    .locals 1

    .prologue
    .line 471
    iget-object v0, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->localStorageRolloverFilesize:Ljava/lang/Long;

    return-object v0
.end method

.method public getPublicKeySerial()J
    .locals 2

    .prologue
    .line 495
    iget-wide v0, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->publicKeySerial:J

    return-wide v0
.end method

.method public getPublicKeyString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 487
    iget-object v0, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->publicKeyString:Ljava/lang/String;

    return-object v0
.end method

.method public getS3Bucket()Ljava/lang/String;
    .locals 1

    .prologue
    .line 423
    iget-object v0, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->s3Bucket:Ljava/lang/String;

    return-object v0
.end method

.method public getS3DateFormatKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 431
    iget-object v0, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->s3DateFormatKey:Ljava/lang/String;

    return-object v0
.end method

.method public getSqsQueueName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 439
    iget-object v0, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->sqsQueueName:Ljava/lang/String;

    return-object v0
.end method

.method public getSubmissionPolicies()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/sdk/availability/Configuration$Policy;",
            ">;"
        }
    .end annotation

    .prologue
    .line 391
    iget-object v0, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->submissionPolicies:Ljava/util/List;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 6

    .prologue
    .line 503
    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    .line 504
    .local v2, "sb":Ljava/lang/StringBuffer;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "{\n\t\"localStorageEncryptionKey\" : \""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->localStorageEncryptionKey:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "\",\n\t\"localStorageEncryptionScheme\" : \""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->localStorageEncryptionScheme:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "\",\n\t\"localStorageMaxRollover\" : \""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->localStorageMaxRollover:Ljava/lang/Long;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "\",\n\t\"localStorageRolloverFilesize\" : \""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->localStorageRolloverFilesize:Ljava/lang/Long;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "\",\n\t\"localStoragePersistenceFormat\" : \""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->localStoragePersistenceFormat:Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "\",\n\t\"submissionPolicies\" : [\n"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 512
    iget-object v3, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->submissionPolicies:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/sdk/availability/Configuration$Policy;

    .line 513
    .local v1, "policy":Lcom/amazon/sdk/availability/Configuration$Policy;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1}, Lcom/amazon/sdk/availability/Configuration$Policy;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, ",\n"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_0

    .line 515
    .end local v1    # "policy":Lcom/amazon/sdk/availability/Configuration$Policy;
    :cond_0
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "\t],\n\",\n\t\"awsAccessId\" : \""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->awsAccessId:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "\",\n\t\"awsSecretKey\" : \""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->awsSecretKey:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "\",\n\t\"awsSessionToken\" : \""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->awsSessionToken:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "\",\n\t\"s3Bucket\" : \""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->s3Bucket:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "\",\n\t\"s3DateFormatKey\" : \""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->s3DateFormatKey:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "\",\n\t\"s3EncryptionPublicKey\" : \""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->publicKeyString:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "\",\n\t\"s3EncryptionPublicKeySerial\" : \""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-wide v4, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->publicKeySerial:J

    invoke-virtual {v3, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "\",\n\t\"sqsQueueName\" : \""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/sdk/availability/Configuration$CollectionConfiguration;->sqsQueueName:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "\"\n}"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 526
    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3
.end method

.class Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;
.super Lcom/amazon/identity/auth/device/api/AuthenticationMethod;
.source "InProcessAdpAuthenticationMethod.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/api/ADPCorpusSigningAuthenticationMethod;


# static fields
.field private static final GET_CENTRAL_CREDENTIAL_TIME_OUT_MS:J

.field private static final NEW_LINE:[B

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mContext:Landroid/content/Context;

.field private final mDirectedId:Ljava/lang/String;

.field private final mPackageName:Ljava/lang/String;

.field private final mTokenManagement:Lcom/amazon/identity/auth/device/api/TokenManagement;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 48
    const-class v0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->TAG:Ljava/lang/String;

    .line 50
    const-wide/16 v0, 0x2

    sget-object v2, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/utils/TimeUtil;->fromMinutesTo(JLjava/util/concurrent/TimeUnit;)J

    move-result-wide v0

    sput-wide v0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->GET_CENTRAL_CREDENTIAL_TIME_OUT_MS:J

    .line 52
    const-string/jumbo v0, "\n"

    invoke-virtual {v0}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->NEW_LINE:[B

    return-void
.end method

.method constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/AuthenticationType;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "directedId"    # Ljava/lang/String;
    .param p3, "packageName"    # Ljava/lang/String;
    .param p4, "authType"    # Lcom/amazon/identity/auth/device/api/AuthenticationType;

    .prologue
    .line 67
    invoke-direct {p0, p1, p2, p4}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;-><init>(Landroid/content/Context;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/AuthenticationType;)V

    .line 69
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->mContext:Landroid/content/Context;

    .line 71
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "dcp_token_mangement"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/api/TokenManagement;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->mTokenManagement:Lcom/amazon/identity/auth/device/api/TokenManagement;

    .line 73
    iput-object p2, p0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->mDirectedId:Ljava/lang/String;

    .line 75
    iput-object p3, p0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->mPackageName:Ljava/lang/String;

    .line 76
    return-void
.end method

.method constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "directedId"    # Ljava/lang/String;
    .param p3, "packageName"    # Ljava/lang/String;
    .param p4, "authType"    # Ljava/lang/String;

    .prologue
    .line 83
    invoke-direct {p0, p1, p2, p4}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 85
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->mContext:Landroid/content/Context;

    .line 87
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "dcp_token_mangement"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/api/TokenManagement;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->mTokenManagement:Lcom/amazon/identity/auth/device/api/TokenManagement;

    .line 89
    iput-object p2, p0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->mDirectedId:Ljava/lang/String;

    .line 91
    iput-object p3, p0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->mPackageName:Ljava/lang/String;

    .line 92
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;[B)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;
    .param p1, "x1"    # [B

    .prologue
    .line 45
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->signBufferAsBase64([B)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$100()Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    sget-object v0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method private getCorpus$3335907d(Landroid/net/Uri;Ljava/lang/String;[BLjava/lang/String;)[B
    .locals 12
    .param p1, "serviceUri"    # Landroid/net/Uri;
    .param p2, "verb"    # Ljava/lang/String;
    .param p3, "requestBody"    # [B
    .param p4, "timestamp"    # Ljava/lang/String;

    .prologue
    .line 422
    :try_start_0
    new-instance v8, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v8}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 424
    .local v8, "corpus":Ljava/io/ByteArrayOutputStream;
    if-nez p2, :cond_0

    .line 426
    sget-object v0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "No verb specified. Cannot create corpus"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 427
    const/4 v0, 0x0

    .line 492
    .end local v8    # "corpus":Ljava/io/ByteArrayOutputStream;
    :goto_0
    return-object v0

    .line 430
    .restart local v8    # "corpus":Ljava/io/ByteArrayOutputStream;
    :cond_0
    if-nez p1, :cond_1

    const/4 v11, 0x0

    .line 431
    .local v11, "path":Ljava/lang/String;
    :goto_1
    if-nez v11, :cond_6

    .line 433
    sget-object v0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "No path specified. Cannot create corpus"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 434
    const/4 v0, 0x0

    goto :goto_0

    .line 430
    .end local v11    # "path":Ljava/lang/String;
    :cond_1
    const-string/jumbo v0, "BustedIdentityADPAuthenticator"

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->getAuthenticationType()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-virtual {p1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v11

    goto :goto_1

    :cond_2
    invoke-virtual {p1}, Landroid/net/Uri;->getEncodedPath()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_3

    const-string/jumbo v0, ""

    :cond_3
    const-string/jumbo v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_4

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "/"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :cond_4
    invoke-virtual {p1}, Landroid/net/Uri;->getEncodedQuery()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_5

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v2, "?"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :cond_5
    move-object v11, v0

    goto :goto_1

    .line 437
    .restart local v11    # "path":Ljava/lang/String;
    :cond_6
    const-string/jumbo v0, "BustedIdentityADPAuthenticator"

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->getAuthenticationType()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_7

    const/4 v0, 0x0

    new-array v7, v0, [B

    .line 439
    .local v7, "body":[B
    :goto_2
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->mTokenManagement:Lcom/amazon/identity/auth/device/api/TokenManagement;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->mDirectedId:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->mPackageName:Ljava/lang/String;

    invoke-static {v2}, Lcom/amazon/identity/auth/device/api/TokenKeys;->getAdpTokenKeyForPackage(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->getOptions()Landroid/os/Bundle;

    move-result-object v3

    sget-wide v4, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->GET_CENTRAL_CREDENTIAL_TIME_OUT_MS:J

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/device/api/TokenManagement;->getValue(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;J)Ljava/lang/String;

    move-result-object v6

    .line 444
    .local v6, "adpToken":Ljava/lang/String;
    if-nez v6, :cond_9

    .line 446
    sget-object v0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "No adp token specified for the given account. Cannot create corpus"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 447
    const/4 v0, 0x0

    goto/16 :goto_0

    .line 437
    .end local v6    # "adpToken":Ljava/lang/String;
    .end local v7    # "body":[B
    :cond_7
    if-nez p3, :cond_8

    const/4 v0, 0x0

    new-array v7, v0, [B

    goto :goto_2

    :cond_8
    move-object v7, p3

    goto :goto_2

    .line 450
    .restart local v6    # "adpToken":Ljava/lang/String;
    .restart local v7    # "body":[B
    :cond_9
    invoke-virtual {p2}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    invoke-virtual {v8, v0}, Ljava/io/ByteArrayOutputStream;->write([B)V

    .line 451
    sget-object v0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->NEW_LINE:[B

    invoke-virtual {v8, v0}, Ljava/io/ByteArrayOutputStream;->write([B)V

    .line 452
    invoke-virtual {v11}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    invoke-virtual {v8, v0}, Ljava/io/ByteArrayOutputStream;->write([B)V

    .line 453
    sget-object v0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->NEW_LINE:[B

    invoke-virtual {v8, v0}, Ljava/io/ByteArrayOutputStream;->write([B)V

    .line 454
    invoke-virtual/range {p4 .. p4}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    invoke-virtual {v8, v0}, Ljava/io/ByteArrayOutputStream;->write([B)V

    .line 455
    sget-object v0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->NEW_LINE:[B

    invoke-virtual {v8, v0}, Ljava/io/ByteArrayOutputStream;->write([B)V

    .line 456
    invoke-virtual {v8, v7}, Ljava/io/ByteArrayOutputStream;->write([B)V

    .line 457
    sget-object v0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->NEW_LINE:[B

    invoke-virtual {v8, v0}, Ljava/io/ByteArrayOutputStream;->write([B)V

    .line 458
    invoke-virtual {v6}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    invoke-virtual {v8, v0}, Ljava/io/ByteArrayOutputStream;->write([B)V

    .line 460
    invoke-virtual {v8}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_0 .. :try_end_0} :catch_4

    move-result-object v0

    goto/16 :goto_0

    .line 462
    .end local v6    # "adpToken":Ljava/lang/String;
    .end local v7    # "body":[B
    .end local v8    # "corpus":Ljava/io/ByteArrayOutputStream;
    .end local v11    # "path":Ljava/lang/String;
    :catch_0
    move-exception v9

    .line 464
    .local v9, "e":Ljava/io/IOException;
    sget-object v0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Could not construct a corpus because an IOException occured"

    invoke-static {v0, v1, v9}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 492
    .end local v9    # "e":Ljava/io/IOException;
    :goto_3
    const/4 v0, 0x0

    goto/16 :goto_0

    .line 466
    :catch_1
    move-exception v0

    const/4 v9, 0x0

    .local v9, "e":Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;->getErrorBundle()Landroid/os/Bundle;

    move-result-object v10

    .line 469
    .local v10, "errorBundle":Landroid/os/Bundle;
    sget-object v0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "Getting ADP Token during corpus generation failed because of callback error. Error Bundle: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v10}, Lcom/amazon/identity/auth/device/utils/BundleUtils;->toString(Landroid/os/Bundle;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_3

    .line 473
    .end local v9    # "e":Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;
    .end local v10    # "errorBundle":Landroid/os/Bundle;
    :catch_2
    move-exception v9

    .line 475
    .local v9, "e":Ljava/lang/InterruptedException;
    sget-object v0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "Getting ADP Token during corpus generation failed because of InterruptedException: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v9}, Ljava/lang/InterruptedException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_3

    .line 479
    .end local v9    # "e":Ljava/lang/InterruptedException;
    :catch_3
    move-exception v9

    .line 481
    .local v9, "e":Ljava/util/concurrent/ExecutionException;
    sget-object v0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "Getting ADP Token during corpus generation failed because of ExecutionException: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v9}, Ljava/util/concurrent/ExecutionException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_3

    .line 485
    .end local v9    # "e":Ljava/util/concurrent/ExecutionException;
    :catch_4
    move-exception v9

    .line 487
    .local v9, "e":Ljava/util/concurrent/TimeoutException;
    sget-object v0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "Getting ADP Token during corpus generation failed because of TimeoutException: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v9}, Ljava/util/concurrent/TimeoutException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_3
.end method

.method private getOptions()Landroid/os/Bundle;
    .locals 3

    .prologue
    .line 558
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 559
    .local v0, "options":Landroid/os/Bundle;
    const-string/jumbo v1, "ignore.platform.restrictions"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 560
    return-object v0
.end method

.method private getPrivateKey()Ljava/security/PrivateKey;
    .locals 14

    .prologue
    const/4 v13, 0x0

    .line 294
    const/4 v12, 0x0

    .line 297
    .local v12, "privateKey":Ljava/security/PrivateKey;
    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->mTokenManagement:Lcom/amazon/identity/auth/device/api/TokenManagement;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->mDirectedId:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->mPackageName:Ljava/lang/String;

    invoke-static {v2}, Lcom/amazon/identity/auth/device/api/TokenKeys;->getPrivateKeyKeyForPackage(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->getOptions()Landroid/os/Bundle;

    move-result-object v3

    sget-wide v4, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->GET_CENTRAL_CREDENTIAL_TIME_OUT_MS:J

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/device/api/TokenManagement;->getValue(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;J)Ljava/lang/String;

    move-result-object v9

    .line 302
    .local v9, "key":Ljava/lang/String;
    if-nez v9, :cond_0

    move-object v0, v13

    .line 345
    .end local v9    # "key":Ljava/lang/String;
    :goto_0
    return-object v0

    .line 307
    .restart local v9    # "key":Ljava/lang/String;
    :cond_0
    invoke-static {v9}, Lcom/amazon/identity/auth/device/utils/KeyFactoryUtils;->getKeyFactoryForKey(Ljava/lang/String;)Ljava/security/KeyFactory;

    move-result-object v10

    .line 308
    .local v10, "keyFactory":Ljava/security/KeyFactory;
    if-nez v10, :cond_1

    move-object v0, v13

    .line 310
    goto :goto_0

    .line 313
    :cond_1
    invoke-static {v9}, Lcom/amazon/identity/auth/device/utils/KeyFactoryUtils;->replacePrivateKeyHeaderAndFooter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 315
    invoke-virtual {v0}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    const/4 v1, 0x0

    invoke-static {v0, v1}, Landroid/util/Base64;->decode([BI)[B

    move-result-object v6

    .line 317
    .local v6, "decodedKey":[B
    new-instance v11, Ljava/security/spec/PKCS8EncodedKeySpec;

    invoke-direct {v11, v6}, Ljava/security/spec/PKCS8EncodedKeySpec;-><init>([B)V

    .line 319
    .local v11, "ks":Ljava/security/spec/KeySpec;
    invoke-virtual {v10, v11}, Ljava/security/KeyFactory;->generatePrivate(Ljava/security/spec/KeySpec;)Ljava/security/PrivateKey;
    :try_end_0
    .catch Ljava/security/spec/InvalidKeySpecException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_0 .. :try_end_0} :catch_4

    move-result-object v12

    .end local v6    # "decodedKey":[B
    .end local v9    # "key":Ljava/lang/String;
    .end local v10    # "keyFactory":Ljava/security/KeyFactory;
    .end local v11    # "ks":Ljava/security/spec/KeySpec;
    :goto_1
    move-object v0, v12

    .line 345
    goto :goto_0

    .line 321
    :catch_0
    move-exception v7

    .line 323
    .local v7, "e":Ljava/security/spec/InvalidKeySpecException;
    sget-object v0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Could not sign request because there was an invalid key"

    invoke-static {v0, v1, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1

    .line 325
    .end local v7    # "e":Ljava/security/spec/InvalidKeySpecException;
    :catch_1
    move-exception v0

    const/4 v7, 0x0

    .local v7, "e":Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;->getErrorBundle()Landroid/os/Bundle;

    move-result-object v8

    .line 328
    .local v8, "errorBundle":Landroid/os/Bundle;
    sget-object v0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "Getting private key failed because of callback error. Error Bundle: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v8}, Lcom/amazon/identity/auth/device/utils/BundleUtils;->toString(Landroid/os/Bundle;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 332
    .end local v7    # "e":Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;
    .end local v8    # "errorBundle":Landroid/os/Bundle;
    :catch_2
    move-exception v7

    .line 334
    .local v7, "e":Ljava/lang/InterruptedException;
    sget-object v0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "Getting private key failed because of InterruptedException: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7}, Ljava/lang/InterruptedException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 336
    .end local v7    # "e":Ljava/lang/InterruptedException;
    :catch_3
    move-exception v7

    .line 338
    .local v7, "e":Ljava/util/concurrent/ExecutionException;
    sget-object v0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "Getting private key failed because of ExecutionException: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7}, Ljava/util/concurrent/ExecutionException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 340
    .end local v7    # "e":Ljava/util/concurrent/ExecutionException;
    :catch_4
    move-exception v7

    .line 342
    .local v7, "e":Ljava/util/concurrent/TimeoutException;
    sget-object v0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "Getting private key failed because of TimeoutException: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7}, Ljava/util/concurrent/TimeoutException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method private signBufferAsBase64([B)Ljava/lang/String;
    .locals 4
    .param p1, "buffer"    # [B

    .prologue
    .line 266
    const/4 v2, 0x0

    .line 267
    .local v2, "signature":Ljava/lang/String;
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->getPrivateKey()Ljava/security/PrivateKey;

    move-result-object v1

    .line 270
    .local v1, "privateKey":Ljava/security/PrivateKey;
    if-nez v1, :cond_0

    .line 272
    const/4 v3, 0x0

    .line 289
    :goto_0
    return-object v3

    .line 275
    :cond_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->useLegacyAuth()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 277
    invoke-direct {p0, p1, v1}, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->signWithOldAuth([BLjava/security/PrivateKey;)[B

    move-result-object v0

    .line 284
    .local v0, "encodedBytes":[B
    :goto_1
    if-eqz v0, :cond_1

    .line 286
    new-instance v2, Ljava/lang/String;

    .end local v2    # "signature":Ljava/lang/String;
    const/4 v3, 0x2

    invoke-static {v0, v3}, Landroid/util/Base64;->encode([BI)[B

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/String;-><init>([B)V

    .restart local v2    # "signature":Ljava/lang/String;
    :cond_1
    move-object v3, v2

    .line 289
    goto :goto_0

    .line 281
    .end local v0    # "encodedBytes":[B
    :cond_2
    invoke-direct {p0, p1, v1}, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->signWithNewAuth([BLjava/security/PrivateKey;)[B

    move-result-object v0

    .restart local v0    # "encodedBytes":[B
    goto :goto_1
.end method

.method private signWithNewAuth([BLjava/security/PrivateKey;)[B
    .locals 5
    .param p1, "buffer"    # [B
    .param p2, "privateKey"    # Ljava/security/PrivateKey;

    .prologue
    .line 389
    const/4 v1, 0x0

    .line 393
    .local v1, "signature":[B
    :try_start_0
    const-string/jumbo v3, "SHA256WithRSA"

    invoke-static {v3}, Ljava/security/Signature;->getInstance(Ljava/lang/String;)Ljava/security/Signature;

    move-result-object v2

    .line 394
    .local v2, "signer":Ljava/security/Signature;
    invoke-virtual {v2, p2}, Ljava/security/Signature;->initSign(Ljava/security/PrivateKey;)V

    .line 396
    invoke-virtual {v2, p1}, Ljava/security/Signature;->update([B)V

    .line 397
    invoke-virtual {v2}, Ljava/security/Signature;->sign()[B
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/security/InvalidKeyException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/security/SignatureException; {:try_start_0 .. :try_end_0} :catch_2

    move-result-object v1

    .line 411
    .end local v2    # "signer":Ljava/security/Signature;
    :goto_0
    return-object v1

    .line 399
    :catch_0
    move-exception v0

    .line 401
    .local v0, "e":Ljava/security/NoSuchAlgorithmException;
    sget-object v3, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Request signing failed because of No such algorithm found."

    invoke-static {v3, v4, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 403
    .end local v0    # "e":Ljava/security/NoSuchAlgorithmException;
    :catch_1
    move-exception v0

    .line 405
    .local v0, "e":Ljava/security/InvalidKeyException;
    sget-object v3, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Request signing failed because it was given an invalid key"

    invoke-static {v3, v4, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 407
    .end local v0    # "e":Ljava/security/InvalidKeyException;
    :catch_2
    move-exception v0

    .line 409
    .local v0, "e":Ljava/security/SignatureException;
    sget-object v3, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Request signing failed because there was a problem with the signature"

    invoke-static {v3, v4, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private signWithOldAuth([BLjava/security/PrivateKey;)[B
    .locals 8
    .param p1, "buffer"    # [B
    .param p2, "privateKey"    # Ljava/security/PrivateKey;

    .prologue
    .line 350
    const/4 v4, 0x0

    .line 353
    .local v4, "encryptedData":[B
    :try_start_0
    const-string/jumbo v5, "SHA-256"

    invoke-static {v5}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v1

    .line 354
    .local v1, "digest":Ljava/security/MessageDigest;
    invoke-virtual {v1, p1}, Ljava/security/MessageDigest;->update([B)V

    .line 355
    invoke-virtual {v1}, Ljava/security/MessageDigest;->digest()[B

    move-result-object v2

    .line 357
    .local v2, "digestedData":[B
    const-string/jumbo v5, "RSA/ECB/PKCS1Padding"

    invoke-static {v5}, Ljavax/crypto/Cipher;->getInstance(Ljava/lang/String;)Ljavax/crypto/Cipher;

    move-result-object v0

    .line 358
    .local v0, "cipher":Ljavax/crypto/Cipher;
    const/4 v5, 0x1

    invoke-virtual {v0, v5, p2}, Ljavax/crypto/Cipher;->init(ILjava/security/Key;)V

    .line 359
    invoke-virtual {v0, v2}, Ljavax/crypto/Cipher;->update([B)[B

    .line 360
    invoke-virtual {v0}, Ljavax/crypto/Cipher;->doFinal()[B
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljavax/crypto/NoSuchPaddingException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljavax/crypto/IllegalBlockSizeException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljavax/crypto/BadPaddingException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljava/security/InvalidKeyException; {:try_start_0 .. :try_end_0} :catch_4

    move-result-object v4

    .line 384
    .end local v0    # "cipher":Ljavax/crypto/Cipher;
    .end local v1    # "digest":Ljava/security/MessageDigest;
    .end local v2    # "digestedData":[B
    :goto_0
    return-object v4

    .line 362
    :catch_0
    move-exception v3

    .line 364
    .local v3, "e":Ljava/security/NoSuchAlgorithmException;
    sget-object v5, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string/jumbo v7, "Signing request with old auth failed because of NoSuchAlgorithmException: "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/security/NoSuchAlgorithmException;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 367
    .end local v3    # "e":Ljava/security/NoSuchAlgorithmException;
    :catch_1
    move-exception v3

    .line 369
    .local v3, "e":Ljavax/crypto/NoSuchPaddingException;
    sget-object v5, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string/jumbo v7, "Signing request with old auth failed because of NoSuchPaddingException: "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljavax/crypto/NoSuchPaddingException;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 371
    .end local v3    # "e":Ljavax/crypto/NoSuchPaddingException;
    :catch_2
    move-exception v3

    .line 373
    .local v3, "e":Ljavax/crypto/IllegalBlockSizeException;
    sget-object v5, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string/jumbo v7, "Signing request with old auth failed because of IllegalBlockSizeException: "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljavax/crypto/IllegalBlockSizeException;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 376
    .end local v3    # "e":Ljavax/crypto/IllegalBlockSizeException;
    :catch_3
    move-exception v3

    .line 378
    .local v3, "e":Ljavax/crypto/BadPaddingException;
    sget-object v5, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string/jumbo v7, "Signing request with old auth failed because of BadPaddingException: "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljavax/crypto/BadPaddingException;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 380
    .end local v3    # "e":Ljavax/crypto/BadPaddingException;
    :catch_4
    move-exception v3

    .line 382
    .local v3, "e":Ljava/security/InvalidKeyException;
    sget-object v5, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string/jumbo v7, "Signing request with old auth failed because of InvalidKeyException: "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/security/InvalidKeyException;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0
.end method

.method private useLegacyAuth()Z
    .locals 2

    .prologue
    .line 544
    sget-object v0, Lcom/amazon/identity/auth/device/api/AuthenticationType;->DeviceAuthenticator:Lcom/amazon/identity/auth/device/api/AuthenticationType;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticationType;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->getAuthenticationType()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method


# virtual methods
.method protected getAuthenticationBundle(Landroid/net/Uri;Ljava/lang/String;Ljava/util/Map;[BLcom/amazon/identity/auth/device/callback/CallbackFuture;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 13
    .param p1, "serviceUri"    # Landroid/net/Uri;
    .param p2, "verb"    # Ljava/lang/String;
    .param p3, "headers"    # Ljava/util/Map;
    .param p4, "body"    # [B
    .param p5, "callbackFuture"    # Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/net/Uri;",
            "Ljava/lang/String;",
            "Ljava/util/Map;",
            "[B",
            "Lcom/amazon/identity/auth/device/callback/CallbackFuture;",
            ")",
            "Lcom/amazon/identity/auth/device/api/MAPFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 103
    :try_start_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->mTokenManagement:Lcom/amazon/identity/auth/device/api/TokenManagement;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->mDirectedId:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->mPackageName:Ljava/lang/String;

    invoke-static {v3}, Lcom/amazon/identity/auth/device/api/TokenKeys;->getAdpTokenKeyForPackage(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->getOptions()Landroid/os/Bundle;

    move-result-object v4

    sget-wide v5, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->GET_CENTRAL_CREDENTIAL_TIME_OUT_MS:J

    invoke-virtual/range {v1 .. v6}, Lcom/amazon/identity/auth/device/api/TokenManagement;->getValue(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;J)Ljava/lang/String;

    move-result-object v9

    .line 109
    .local v9, "adpToken":Ljava/lang/String;
    if-nez v9, :cond_1

    .line 111
    const/4 v1, 0x2

    const-string/jumbo v2, "Could not sign request because we could not get an ADP Signature"

    move-object/from16 v0, p5

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V

    .line 114
    sget-object v1, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Could not sign request because we could not get an ADP Signature"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 190
    .end local v9    # "adpToken":Ljava/lang/String;
    :cond_0
    :goto_0
    return-object p5

    .line 118
    .restart local v9    # "adpToken":Ljava/lang/String;
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->getCurrentTimestamp()Ljava/lang/String;

    move-result-object v1

    move-object/from16 v0, p4

    invoke-direct {p0, p1, p2, v0, v1}, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->getCorpus$3335907d(Landroid/net/Uri;Ljava/lang/String;[BLjava/lang/String;)[B

    move-result-object v2

    if-eqz v2, :cond_2

    if-nez v1, :cond_4

    :cond_2
    sget-object v1, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Could not sign request because we were unable to create a corpus"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v8, 0x0

    .line 119
    .local v8, "adpSignature":Ljava/lang/String;
    :goto_1
    if-eqz v8, :cond_3

    if-nez v9, :cond_6

    .line 121
    :cond_3
    const/4 v1, 0x3

    const-string/jumbo v2, "Could not sign request because we could not generate an ADP signature, please check your parameters!"

    move-object/from16 v0, p5

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V

    .line 124
    sget-object v1, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Could not sign request because we could not generate an ADP signature"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_0 .. :try_end_0} :catch_3

    goto :goto_0

    .line 145
    .end local v8    # "adpSignature":Ljava/lang/String;
    .end local v9    # "adpToken":Ljava/lang/String;
    :catch_0
    move-exception v1

    const/4 v10, 0x0

    .local v10, "e":Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;
    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;->getErrorBundle()Landroid/os/Bundle;

    move-result-object v11

    .line 148
    .local v11, "errorBundle":Landroid/os/Bundle;
    const/4 v1, 0x6

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Getting ADP Token failed because of callback error. Error Bundle: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v11}, Lcom/amazon/identity/auth/device/utils/BundleUtils;->toString(Landroid/os/Bundle;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p5

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V

    .line 152
    sget-object v1, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Getting ADP Token failed because of callback error. Error Bundle: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v11}, Lcom/amazon/identity/auth/device/utils/BundleUtils;->toString(Landroid/os/Bundle;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 118
    .end local v10    # "e":Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;
    .end local v11    # "errorBundle":Landroid/os/Bundle;
    .restart local v9    # "adpToken":Ljava/lang/String;
    :cond_4
    :try_start_1
    invoke-direct {p0, v2}, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->signBufferAsBase64([B)Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_5

    const/4 v8, 0x0

    goto :goto_1

    :cond_5
    const-string/jumbo v3, "%s:%s"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v2, v4, v5

    const/4 v2, 0x1

    aput-object v1, v4, v2

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    goto :goto_1

    .line 128
    .restart local v8    # "adpSignature":Ljava/lang/String;
    :cond_6
    new-instance v12, Landroid/os/Bundle;

    invoke-direct {v12}, Landroid/os/Bundle;-><init>()V

    .line 129
    .local v12, "response":Landroid/os/Bundle;
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->useLegacyAuth()Z

    move-result v1

    if-eqz v1, :cond_8

    const-string/jumbo v1, "X-ADP-Request-Digest"

    :goto_2
    invoke-static {v12, v1, v8}, Lcom/amazon/identity/auth/request/AuthenticatedRequestHelpers;->setHeaderInBundle(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)V

    .line 130
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->useLegacyAuth()Z

    move-result v1

    if-eqz v1, :cond_9

    const-string/jumbo v1, "X-ADP-Authentication-Token"

    :goto_3
    invoke-static {v12, v1, v9}, Lcom/amazon/identity/auth/request/AuthenticatedRequestHelpers;->setHeaderInBundle(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)V

    .line 132
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->useLegacyAuth()Z

    move-result v1

    if-eqz v1, :cond_a

    const/4 v7, 0x0

    .line 133
    .local v7, "adpAlgoHeaderName":Ljava/lang/String;
    :goto_4
    if-eqz v7, :cond_7

    .line 135
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->useLegacyAuth()Z

    move-result v1

    if-eqz v1, :cond_b

    const/4 v1, 0x0

    :goto_5
    invoke-static {v12, v7, v1}, Lcom/amazon/identity/auth/request/AuthenticatedRequestHelpers;->setHeaderInBundle(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)V

    .line 138
    :cond_7
    if-eqz p5, :cond_0

    .line 140
    move-object/from16 v0, p5

    invoke-virtual {v0, v12}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->onSuccess(Landroid/os/Bundle;)V
    :try_end_1
    .catch Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_1 .. :try_end_1} :catch_3

    goto/16 :goto_0

    .line 156
    .end local v7    # "adpAlgoHeaderName":Ljava/lang/String;
    .end local v8    # "adpSignature":Ljava/lang/String;
    .end local v9    # "adpToken":Ljava/lang/String;
    .end local v12    # "response":Landroid/os/Bundle;
    :catch_1
    move-exception v10

    .line 158
    .local v10, "e":Ljava/lang/InterruptedException;
    const/4 v1, 0x6

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Getting ADP Token failed because of InterruptedException. This can happen if the caller kills the thread or asnc task that is calling MAP\'s api. Exception message: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v10}, Ljava/lang/InterruptedException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p5

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V

    .line 162
    sget-object v1, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Getting ADP Token failed because of InterruptedException. This can happen if the caller kills the thread or asnc task that is calling MAP\'s api. Exception message: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v10}, Ljava/lang/InterruptedException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v10}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_0

    .line 129
    .end local v10    # "e":Ljava/lang/InterruptedException;
    .restart local v8    # "adpSignature":Ljava/lang/String;
    .restart local v9    # "adpToken":Ljava/lang/String;
    .restart local v12    # "response":Landroid/os/Bundle;
    :cond_8
    :try_start_2
    const-string/jumbo v1, "x-adp-signature"

    goto :goto_2

    .line 130
    :cond_9
    const-string/jumbo v1, "x-adp-token"

    goto :goto_3

    .line 132
    :cond_a
    const-string/jumbo v7, "x-adp-alg"

    goto :goto_4

    .line 135
    .restart local v7    # "adpAlgoHeaderName":Ljava/lang/String;
    :cond_b
    const-string/jumbo v1, "SHA256WithRSA:1.0"
    :try_end_2
    .catch Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/lang/InterruptedException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_2 .. :try_end_2} :catch_2
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_2 .. :try_end_2} :catch_3

    goto :goto_5

    .line 167
    .end local v7    # "adpAlgoHeaderName":Ljava/lang/String;
    .end local v8    # "adpSignature":Ljava/lang/String;
    .end local v9    # "adpToken":Ljava/lang/String;
    .end local v12    # "response":Landroid/os/Bundle;
    :catch_2
    move-exception v10

    .line 169
    .local v10, "e":Ljava/util/concurrent/ExecutionException;
    const/4 v1, 0x6

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Getting ADP Token failed because of ExecutionException. This can happen when the thread or task was aborted. Exception message: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v10}, Ljava/util/concurrent/ExecutionException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p5

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V

    .line 173
    sget-object v1, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Getting ADP Token failed because of ExecutionException. This can happen when the thread or task was aborted. Exception message: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v10}, Ljava/util/concurrent/ExecutionException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v10}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_0

    .line 178
    .end local v10    # "e":Ljava/util/concurrent/ExecutionException;
    :catch_3
    move-exception v10

    .line 180
    .local v10, "e":Ljava/util/concurrent/TimeoutException;
    const/4 v1, 0x6

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Getting ADP Token failed because of TimeoutException. This happens when the timeout passed into the future object occurs. Exception message: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v10}, Ljava/util/concurrent/TimeoutException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p5

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V

    .line 184
    sget-object v1, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Getting ADP Token failed because of TimeoutException. This happens when the timeout passed into the future object occurs. Exception message: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v10}, Ljava/util/concurrent/TimeoutException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v10}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_0
.end method

.method protected getCurrentTimestamp()Ljava/lang/String;
    .locals 4

    .prologue
    .line 550
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string/jumbo v2, "yyyy-MM-dd\'T\'HH:mm:ss\'Z\'"

    sget-object v3, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-direct {v0, v2, v3}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 551
    .local v0, "dateFormatter":Ljava/text/SimpleDateFormat;
    new-instance v1, Ljava/util/Date;

    invoke-direct {v1}, Ljava/util/Date;-><init>()V

    .line 553
    .local v1, "now":Ljava/util/Date;
    invoke-virtual {v0, v1}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method public signCorpus([BLandroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 6
    .param p1, "corpus"    # [B
    .param p2, "signCorpusOption"    # Landroid/os/Bundle;
    .param p3, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([B",
            "Landroid/os/Bundle;",
            "Lcom/amazon/identity/auth/device/api/Callback;",
            ")",
            "Lcom/amazon/identity/auth/device/api/MAPFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .prologue
    .line 566
    new-instance v0, Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-direct {v0, p3}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;-><init>(Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 567
    .local v0, "callbackFuture":Lcom/amazon/identity/auth/device/callback/CallbackFuture;
    if-nez p1, :cond_0

    .line 569
    sget-object v1, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->TAG:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/ADPCorpusSigningCallbackHelpers;->nullCorpusCallbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;Ljava/lang/String;)V

    .line 619
    :goto_0
    return-object v0

    .line 573
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->mDirectedId:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_1

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->mMapAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->mDirectedId:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->isAccountRegistered(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 575
    :cond_1
    const/4 v1, 0x2

    const-string/jumbo v2, "The account is not valid or no longer registered."

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/utils/ADPCorpusSigningCallbackHelpers;->callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V

    goto :goto_0

    .line 581
    :cond_2
    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->mTokenManagement:Lcom/amazon/identity/auth/device/api/TokenManagement;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->mDirectedId:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->mPackageName:Ljava/lang/String;

    invoke-static {v3}, Lcom/amazon/identity/auth/device/api/TokenKeys;->getAdpTokenKeyForPackage(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->getOptions()Landroid/os/Bundle;

    move-result-object v4

    new-instance v5, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod$1;

    invoke-direct {v5, p0, p1, v0}, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod$1;-><init>(Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;[BLcom/amazon/identity/auth/device/callback/CallbackFuture;)V

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/amazon/identity/auth/device/api/TokenManagement;->getToken(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    goto :goto_0
.end method

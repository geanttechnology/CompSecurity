.class Lcom/amazon/identity/auth/device/api/InProcessOauthAuthenticationMethod;
.super Lcom/amazon/identity/auth/device/api/AuthenticationMethod;
.source "InProcessOauthAuthenticationMethod.java"


# static fields
.field private static final GET_OAUTH_CREDENTIAL_TIME_OUT_MS:J

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
    .line 24
    const-class v0, Lcom/amazon/identity/auth/device/api/InProcessOauthAuthenticationMethod;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/api/InProcessOauthAuthenticationMethod;->TAG:Ljava/lang/String;

    .line 26
    const-wide/16 v0, 0x2

    sget-object v2, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/utils/TimeUtil;->fromMinutesTo(JLjava/util/concurrent/TimeUnit;)J

    move-result-wide v0

    sput-wide v0, Lcom/amazon/identity/auth/device/api/InProcessOauthAuthenticationMethod;->GET_OAUTH_CREDENTIAL_TIME_OUT_MS:J

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/AuthenticationType;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "directedId"    # Ljava/lang/String;
    .param p3, "packageName"    # Ljava/lang/String;
    .param p4, "authType"    # Lcom/amazon/identity/auth/device/api/AuthenticationType;

    .prologue
    .line 40
    invoke-direct {p0, p1, p2, p4}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;-><init>(Landroid/content/Context;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/AuthenticationType;)V

    .line 42
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/InProcessOauthAuthenticationMethod;->mContext:Landroid/content/Context;

    .line 44
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/InProcessOauthAuthenticationMethod;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "dcp_token_mangement"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/api/TokenManagement;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/InProcessOauthAuthenticationMethod;->mTokenManagement:Lcom/amazon/identity/auth/device/api/TokenManagement;

    .line 46
    iput-object p3, p0, Lcom/amazon/identity/auth/device/api/InProcessOauthAuthenticationMethod;->mPackageName:Ljava/lang/String;

    .line 47
    iput-object p2, p0, Lcom/amazon/identity/auth/device/api/InProcessOauthAuthenticationMethod;->mDirectedId:Ljava/lang/String;

    .line 48
    return-void
.end method


# virtual methods
.method protected getAuthenticationBundle(Landroid/net/Uri;Ljava/lang/String;Ljava/util/Map;[BLcom/amazon/identity/auth/device/callback/CallbackFuture;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 10
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
    .line 59
    :try_start_0
    const-string/jumbo v0, "https"

    invoke-virtual {p1}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v1

    sget-object v3, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v1, v3}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 61
    const/4 v0, 0x3

    const-string/jumbo v1, "OAuth authentication has to be over https"

    invoke-static {p5, v0, v1}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V

    .line 64
    sget-object v0, Lcom/amazon/identity/auth/device/api/InProcessOauthAuthenticationMethod;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "OAuth authentication has to be over https"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 136
    :cond_0
    :goto_0
    return-object p5

    .line 68
    :cond_1
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/InProcessOauthAuthenticationMethod;->mPackageName:Ljava/lang/String;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/api/TokenKeys;->getAccessTokenKeyForPackage(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 70
    .local v2, "accessTokenKey":Ljava/lang/String;
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/InProcessOauthAuthenticationMethod;->mTokenManagement:Lcom/amazon/identity/auth/device/api/TokenManagement;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/InProcessOauthAuthenticationMethod;->mDirectedId:Ljava/lang/String;

    const/4 v3, 0x0

    sget-wide v4, Lcom/amazon/identity/auth/device/api/InProcessOauthAuthenticationMethod;->GET_OAUTH_CREDENTIAL_TIME_OUT_MS:J

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/device/api/TokenManagement;->getValue(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;J)Ljava/lang/String;

    move-result-object v6

    .line 73
    .local v6, "accessToken":Ljava/lang/String;
    if-nez v6, :cond_2

    .line 75
    const/4 v0, 0x2

    const-string/jumbo v1, "Could not authenticate request because we could not get an access token"

    invoke-static {p5, v0, v1}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V

    .line 78
    sget-object v0, Lcom/amazon/identity/auth/device/api/InProcessOauthAuthenticationMethod;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Could not authenticate request because we could not get an access token"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_0 .. :try_end_0} :catch_3

    goto :goto_0

    .line 91
    .end local v2    # "accessTokenKey":Ljava/lang/String;
    .end local v6    # "accessToken":Ljava/lang/String;
    :catch_0
    move-exception v0

    const/4 v7, 0x0

    .local v7, "e":Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;->getErrorBundle()Landroid/os/Bundle;

    move-result-object v8

    .line 94
    .local v8, "errorBundle":Landroid/os/Bundle;
    const/4 v0, 0x6

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Getting Access Token failed because of callback error. Error Bundle: "

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v8}, Lcom/amazon/identity/auth/device/utils/BundleUtils;->toString(Landroid/os/Bundle;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {p5, v0, v1}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V

    .line 98
    sget-object v0, Lcom/amazon/identity/auth/device/api/InProcessOauthAuthenticationMethod;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Getting Access Token failed because of callback error. Error Bundle: "

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v8}, Lcom/amazon/identity/auth/device/utils/BundleUtils;->toString(Landroid/os/Bundle;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 82
    .end local v7    # "e":Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;
    .end local v8    # "errorBundle":Landroid/os/Bundle;
    .restart local v2    # "accessTokenKey":Ljava/lang/String;
    .restart local v6    # "accessToken":Ljava/lang/String;
    :cond_2
    :try_start_1
    new-instance v9, Landroid/os/Bundle;

    invoke-direct {v9}, Landroid/os/Bundle;-><init>()V

    .line 83
    .local v9, "response":Landroid/os/Bundle;
    const-string/jumbo v0, "x-amz-access-token"

    invoke-static {v9, v0, v6}, Lcom/amazon/identity/auth/request/AuthenticatedRequestHelpers;->setHeaderInBundle(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)V

    .line 85
    if-eqz p5, :cond_0

    .line 87
    invoke-virtual {p5, v9}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->onSuccess(Landroid/os/Bundle;)V
    :try_end_1
    .catch Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_1 .. :try_end_1} :catch_3

    goto :goto_0

    .line 102
    .end local v2    # "accessTokenKey":Ljava/lang/String;
    .end local v6    # "accessToken":Ljava/lang/String;
    .end local v9    # "response":Landroid/os/Bundle;
    :catch_1
    move-exception v7

    .line 104
    .local v7, "e":Ljava/lang/InterruptedException;
    const/4 v0, 0x6

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Getting Access Token failed because of InterruptedException. This can happen if the caller kills the thread or asnc task that is calling MAP\'s api. Exception message: "

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7}, Ljava/lang/InterruptedException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {p5, v0, v1}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V

    .line 108
    sget-object v0, Lcom/amazon/identity/auth/device/api/InProcessOauthAuthenticationMethod;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Getting Access Token failed because of InterruptedException. This can happen if the caller kills the thread or asnc task that is calling MAP\'s api. Exception message: "

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7}, Ljava/lang/InterruptedException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_0

    .line 113
    .end local v7    # "e":Ljava/lang/InterruptedException;
    :catch_2
    move-exception v7

    .line 115
    .local v7, "e":Ljava/util/concurrent/ExecutionException;
    const/4 v0, 0x6

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Getting Access Token failed failed because of ExecutionException. This can happen when the thread or task was aborted. Exception message: "

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7}, Ljava/util/concurrent/ExecutionException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {p5, v0, v1}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V

    .line 119
    sget-object v0, Lcom/amazon/identity/auth/device/api/InProcessOauthAuthenticationMethod;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Getting Access Token failed failed because of ExecutionException. This can happen when the thread or task was aborted. Exception message: "

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7}, Ljava/util/concurrent/ExecutionException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_0

    .line 124
    .end local v7    # "e":Ljava/util/concurrent/ExecutionException;
    :catch_3
    move-exception v7

    .line 126
    .local v7, "e":Ljava/util/concurrent/TimeoutException;
    const/4 v0, 0x6

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Getting Access Token failed because of TimeoutException. This happens when the timeout passed into the future object occurs. Exception message: "

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7}, Ljava/util/concurrent/TimeoutException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {p5, v0, v1}, Lcom/amazon/identity/auth/device/api/AuthenticationMethod;->callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V

    .line 130
    sget-object v0, Lcom/amazon/identity/auth/device/api/InProcessOauthAuthenticationMethod;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Getting Access Token failed because of TimeoutException. This happens when the timeout passed into the future object occurs. Exception message: "

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7}, Ljava/util/concurrent/TimeoutException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_0
.end method

.class public Lcom/amazon/identity/kcpsdk/auth/PandaRequest;
.super Ljava/lang/Object;
.source "PandaRequest.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mCookieDomain:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    const-class v0, Lcom/amazon/identity/kcpsdk/auth/PandaRequest;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/PandaRequest;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method protected getPandaEndPoint(Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p1, "path"    # Ljava/lang/String;

    .prologue
    .line 25
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/auth/PandaRequest;->getPandaHost()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 26
    .local v0, "endpoint":Ljava/lang/String;
    sget-object v1, Lcom/amazon/identity/kcpsdk/auth/PandaRequest;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Using panda endpoint : "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 28
    return-object v0
.end method

.method protected getPandaHost()Ljava/lang/String;
    .locals 2

    .prologue
    .line 33
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getInstance()Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaRequest;->mCookieDomain:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getPandaHost(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 35
    return-object v0
.end method

.method public setCookieDomain(Ljava/lang/String;)V
    .locals 2
    .param p1, "cookieDomain"    # Ljava/lang/String;

    .prologue
    .line 40
    invoke-static {p1}, Lcom/amazon/identity/kcpsdk/common/RequestValidationHelper;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "."

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 42
    :cond_0
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/PandaRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v1, " setCookieDomain: domain was invalid (null, empty or starts with dot). Cannot be set.  Will default to \'amazon.com\'"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 45
    :cond_1
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/PandaRequest;->mCookieDomain:Ljava/lang/String;

    .line 46
    return-void
.end method

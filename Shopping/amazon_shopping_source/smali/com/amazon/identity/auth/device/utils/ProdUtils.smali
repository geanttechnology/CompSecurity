.class public final Lcom/amazon/identity/auth/device/utils/ProdUtils;
.super Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;
.source "ProdUtils.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 11
    const-class v0, Lcom/amazon/identity/auth/device/utils/ProdUtils;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/utils/ProdUtils;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;-><init>()V

    return-void
.end method


# virtual methods
.method public getAmazonCNDomain()Ljava/lang/String;
    .locals 1

    .prologue
    .line 105
    const-string/jumbo v0, ".amazon.cn"

    return-object v0
.end method

.method public getAmazonJPDomain()Ljava/lang/String;
    .locals 1

    .prologue
    .line 99
    const-string/jumbo v0, ".amazon.co.jp"

    return-object v0
.end method

.method public getAmazonUKDomain()Ljava/lang/String;
    .locals 1

    .prologue
    .line 93
    const-string/jumbo v0, ".amazon.co.uk"

    return-object v0
.end method

.method public getAmazonUSDomain()Ljava/lang/String;
    .locals 1

    .prologue
    .line 87
    const-string/jumbo v0, ".amazon.com"

    return-object v0
.end method

.method public getCompleteAuthPortalDomain(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "domainStr"    # Ljava/lang/String;

    .prologue
    .line 28
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 30
    sget-object v0, Lcom/amazon/identity/auth/device/utils/ProdUtils;->TAG:Ljava/lang/String;

    .line 32
    const-string/jumbo p1, "www.amazon.com"

    .line 47
    .end local p1    # "domainStr":Ljava/lang/String;
    :cond_0
    :goto_0
    return-object p1

    .line 35
    .restart local p1    # "domainStr":Ljava/lang/String;
    :cond_1
    const-string/jumbo v0, "."

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 38
    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "www"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    goto :goto_0

    .line 41
    :cond_2
    const-string/jumbo v0, "amazon."

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 43
    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "www."

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    goto :goto_0

    .line 45
    :cond_3
    const-string/jumbo v0, "www"

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 50
    new-instance v0, Ljava/lang/RuntimeException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "Input was non-empty and doesn\'t look like a partial domain: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method protected getCurrentEnvironment()Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;
    .locals 1

    .prologue
    .line 129
    sget-object v0, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;->prod:Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;

    return-object v0
.end method

.method public getDCAHost()Ljava/lang/String;
    .locals 1

    .prologue
    .line 123
    const-string/jumbo v0, "dcape-na.amazon.com"

    return-object v0
.end method

.method public getDefaultAmazonDomain()Ljava/lang/String;
    .locals 1

    .prologue
    .line 111
    const-string/jumbo v0, "www.amazon.com"

    return-object v0
.end method

.method public getFIRSHost()Ljava/lang/String;
    .locals 1

    .prologue
    .line 117
    const-string/jumbo v0, "firs-ta-g7g.amazon.com"

    return-object v0
.end method

.method public getPandaHost(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "partialDomainString"    # Ljava/lang/String;

    .prologue
    .line 56
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 58
    sget-object v0, Lcom/amazon/identity/auth/device/utils/ProdUtils;->TAG:Ljava/lang/String;

    .line 60
    const-string/jumbo p1, "api.amazon.com"

    .line 77
    .end local p1    # "partialDomainString":Ljava/lang/String;
    :cond_0
    :goto_0
    return-object p1

    .line 63
    .restart local p1    # "partialDomainString":Ljava/lang/String;
    :cond_1
    const-string/jumbo v0, "."

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 65
    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "api"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    goto :goto_0

    .line 67
    :cond_2
    const-string/jumbo v0, "amazon."

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 69
    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "api."

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    goto :goto_0

    .line 71
    :cond_3
    const-string/jumbo v0, "api.amazon"

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 75
    const-string/jumbo v0, "www"

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 77
    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "api"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const/4 v1, 0x3

    invoke-virtual {p1, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    goto :goto_0

    .line 80
    :cond_4
    new-instance v0, Ljava/lang/RuntimeException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "Input was non-empty and doesn\'t look like a partial domain: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

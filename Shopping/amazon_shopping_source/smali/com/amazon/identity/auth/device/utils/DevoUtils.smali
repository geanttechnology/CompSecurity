.class public final Lcom/amazon/identity/auth/device/utils/DevoUtils;
.super Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;
.source "DevoUtils.java"


# direct methods
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
    .line 64
    const-string/jumbo v0, "cn-development.amazon.com"

    return-object v0
.end method

.method public getAmazonJPDomain()Ljava/lang/String;
    .locals 1

    .prologue
    .line 58
    const-string/jumbo v0, "jp-development.amazon.com"

    return-object v0
.end method

.method public getAmazonUKDomain()Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    const-string/jumbo v0, "uk-development.amazon.com"

    return-object v0
.end method

.method public getAmazonUSDomain()Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    const-string/jumbo v0, "development.amazon.com"

    return-object v0
.end method

.method public getCompleteAuthPortalDomain(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "domainStr"    # Ljava/lang/String;

    .prologue
    .line 27
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 32
    .end local p1    # "domainStr":Ljava/lang/String;
    :goto_0
    return-object p1

    .restart local p1    # "domainStr":Ljava/lang/String;
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/utils/DevoUtils;->getAmazonUSDomain()Ljava/lang/String;

    move-result-object p1

    goto :goto_0
.end method

.method protected getCurrentEnvironment()Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;
    .locals 1

    .prologue
    .line 88
    sget-object v0, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;->devo:Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;

    return-object v0
.end method

.method public getDCAHost()Ljava/lang/String;
    .locals 1

    .prologue
    .line 82
    const-string/jumbo v0, "dcape-na.integ.amazon.com"

    return-object v0
.end method

.method public getDefaultAmazonDomain()Ljava/lang/String;
    .locals 1

    .prologue
    .line 70
    const-string/jumbo v0, "development.amazon.com"

    return-object v0
.end method

.method public getFIRSHost()Ljava/lang/String;
    .locals 1

    .prologue
    .line 76
    const-string/jumbo v0, "firs-ta-g7g.vipinteg.amazon.com"

    return-object v0
.end method

.method public getPandaHost(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "partialDomainString"    # Ljava/lang/String;

    .prologue
    .line 38
    if-nez p1, :cond_0

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/utils/DevoUtils;->getDefaultAmazonDomain()Ljava/lang/String;

    move-result-object p1

    .end local p1    # "partialDomainString":Ljava/lang/String;
    :cond_0
    const-string/jumbo v1, ".co.uk"

    invoke-virtual {p1, v1}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    const-string/jumbo v0, "uk-"

    .line 40
    .local v0, "prefix":Ljava/lang/String;
    :goto_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "api.integ.amazon.com"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1

    .line 38
    .end local v0    # "prefix":Ljava/lang/String;
    :cond_1
    const-string/jumbo v1, ".co.jp"

    invoke-virtual {p1, v1}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    const-string/jumbo v0, "jp-"

    goto :goto_0

    :cond_2
    const-string/jumbo v1, ".de"

    invoke-virtual {p1, v1}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    const-string/jumbo v0, "de-"

    goto :goto_0

    :cond_3
    const-string/jumbo v1, ".fr"

    invoke-virtual {p1, v1}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_4

    const-string/jumbo v0, "fr-"

    goto :goto_0

    :cond_4
    const-string/jumbo v1, ".cn"

    invoke-virtual {p1, v1}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_5

    const-string/jumbo v0, "cn-"

    goto :goto_0

    :cond_5
    const-string/jumbo v0, "us-"

    goto :goto_0
.end method

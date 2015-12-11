.class public final Lcom/amazon/identity/auth/device/utils/PreProdUtils;
.super Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;
.source "PreProdUtils.java"


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
    .line 85
    const-string/jumbo v0, "cn-pre-prod.amazon.com"

    return-object v0
.end method

.method public getAmazonJPDomain()Ljava/lang/String;
    .locals 1

    .prologue
    .line 79
    const-string/jumbo v0, "jp-pre-prod.amazon.com"

    return-object v0
.end method

.method public getAmazonUKDomain()Ljava/lang/String;
    .locals 1

    .prologue
    .line 73
    const-string/jumbo v0, "uk-pre-prod.amazon.com"

    return-object v0
.end method

.method public getAmazonUSDomain()Ljava/lang/String;
    .locals 1

    .prologue
    .line 67
    const-string/jumbo v0, "pre-prod.amazon.com"

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
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/utils/PreProdUtils;->getAmazonUSDomain()Ljava/lang/String;

    move-result-object p1

    goto :goto_0
.end method

.method protected getCurrentEnvironment()Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;
    .locals 1

    .prologue
    .line 109
    sget-object v0, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;->pre_prod:Lcom/amazon/identity/auth/device/utils/EnvironmentUtils$Environment;

    return-object v0
.end method

.method public getDCAHost()Ljava/lang/String;
    .locals 1

    .prologue
    .line 103
    const-string/jumbo v0, "dcape-na-preprod.amazon.com"

    return-object v0
.end method

.method public getDefaultAmazonDomain()Ljava/lang/String;
    .locals 1

    .prologue
    .line 91
    const-string/jumbo v0, "pre-prod.amazon.com"

    return-object v0
.end method

.method public getFIRSHost()Ljava/lang/String;
    .locals 1

    .prologue
    .line 97
    const-string/jumbo v0, "firs-ta-g7g-preprod.amazon.com"

    return-object v0
.end method

.method public getPandaHost(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "partialDomainString"    # Ljava/lang/String;

    .prologue
    .line 38
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 40
    const-string/jumbo p1, "api.amazon.com"

    .line 57
    .end local p1    # "partialDomainString":Ljava/lang/String;
    :cond_0
    :goto_0
    return-object p1

    .line 43
    .restart local p1    # "partialDomainString":Ljava/lang/String;
    :cond_1
    const-string/jumbo v0, "."

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 45
    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "api"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    goto :goto_0

    .line 47
    :cond_2
    const-string/jumbo v0, "amazon."

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 49
    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "api."

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    goto :goto_0

    .line 51
    :cond_3
    const-string/jumbo v0, "api.amazon"

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 55
    const-string/jumbo v0, "www"

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 57
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

    .line 60
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

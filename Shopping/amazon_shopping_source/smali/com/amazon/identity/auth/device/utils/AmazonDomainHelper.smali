.class public final Lcom/amazon/identity/auth/device/utils/AmazonDomainHelper;
.super Ljava/lang/Object;
.source "AmazonDomainHelper.java"


# static fields
.field public static final ACCOUNT_POOL_AMAZON:Ljava/lang/String; = "Amazon"

.field public static final ACCOUNT_POOL_AMAZON_CN:Ljava/lang/String; = "AmazonCN"

.field public static final ACCOUNT_POOL_AMAZON_JP:Ljava/lang/String; = "AmazonJP"

.field public static final AMAZON_DOMAIN_CN:Ljava/lang/String; = ".amazon.cn"

.field public static final AMAZON_DOMAIN_JP:Ljava/lang/String; = ".amazon.co.jp"

.field public static final AMAZON_DOMAIN_UK:Ljava/lang/String; = ".amazon.co.uk"

.field public static final AMAZON_DOMAIN_US:Ljava/lang/String; = ".amazon.com"

.field public static final DEFAULT_DOMAIN:Ljava/lang/String; = ".amazon.com"

.field public static final REGION_CN:Ljava/lang/String; = "CN"

.field public static final REGION_EU:Ljava/lang/String; = "EU"

.field public static final REGION_FE:Ljava/lang/String; = "FE"

.field public static final REGION_NA:Ljava/lang/String; = "NA"

.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 27
    const-class v0, Lcom/amazon/identity/auth/device/utils/AmazonDomainHelper;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/utils/AmazonDomainHelper;->TAG:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 40
    return-void
.end method

.method public static getAuthPortalDomainBasedOnAccountPool(Ljava/lang/String;)Ljava/lang/String;
    .locals 5
    .param p0, "accountPool"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 101
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 103
    sget-object v2, Lcom/amazon/identity/auth/device/utils/AmazonDomainHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Empty account pool, returning null domain "

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 123
    :goto_0
    return-object v1

    .line 107
    :cond_0
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getInstance()Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;

    move-result-object v0

    .line 109
    .local v0, "environmentUtils":Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;
    const-string/jumbo v2, "Amazon"

    invoke-virtual {p0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 111
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getAmazonUSDomain()Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 113
    :cond_1
    const-string/jumbo v2, "AmazonCN"

    invoke-virtual {p0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 115
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getAmazonCNDomain()Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 117
    :cond_2
    const-string/jumbo v2, "AmazonJP"

    invoke-virtual {p0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 119
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getAmazonJPDomain()Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 122
    :cond_3
    sget-object v2, Lcom/amazon/identity/auth/device/utils/AmazonDomainHelper;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "Ignoring unknown account pool:  "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static getAuthPortalDomainBasedOnCustomerRegion(Ljava/lang/String;)Ljava/lang/String;
    .locals 5
    .param p0, "customerRegion"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 64
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 66
    sget-object v2, Lcom/amazon/identity/auth/device/utils/AmazonDomainHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Empty customer region, returning null domain "

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 90
    :goto_0
    return-object v1

    .line 70
    :cond_0
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getInstance()Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;

    move-result-object v0

    .line 72
    .local v0, "envUtils":Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;
    const-string/jumbo v2, "NA"

    invoke-virtual {p0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 74
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getAmazonUSDomain()Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 76
    :cond_1
    const-string/jumbo v2, "EU"

    invoke-virtual {p0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 78
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getAmazonUKDomain()Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 80
    :cond_2
    const-string/jumbo v2, "FE"

    invoke-virtual {p0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 82
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getAmazonJPDomain()Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 84
    :cond_3
    const-string/jumbo v2, "CN"

    invoke-virtual {p0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 86
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getAmazonCNDomain()Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 89
    :cond_4
    sget-object v2, Lcom/amazon/identity/auth/device/utils/AmazonDomainHelper;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "Ignoring unknown customer region:  "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static getCompleteAuthPortalDomain(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "domainStr"    # Ljava/lang/String;

    .prologue
    .line 53
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getInstance()Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getCompleteAuthPortalDomain(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getCompleteCookieDomain(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "domainStr"    # Ljava/lang/String;

    .prologue
    .line 135
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getInstance()Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getCompleteAuthPortalDomain(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getDomainFromCompleteUrl(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "domainStr"    # Ljava/lang/String;

    .prologue
    .line 174
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 176
    sget-object v0, Lcom/amazon/identity/auth/device/utils/AmazonDomainHelper;->TAG:Ljava/lang/String;

    .line 177
    const-string/jumbo p0, ".amazon.com"

    .line 194
    .end local p0    # "domainStr":Ljava/lang/String;
    :cond_0
    :goto_0
    return-object p0

    .line 179
    .restart local p0    # "domainStr":Ljava/lang/String;
    :cond_1
    const-string/jumbo v0, "."

    invoke-virtual {p0, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 184
    const-string/jumbo v0, "amazon."

    invoke-virtual {p0, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 186
    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "."

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    goto :goto_0

    .line 188
    :cond_2
    const-string/jumbo v0, "www"

    invoke-virtual {p0, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 190
    const/4 v0, 0x3

    invoke-virtual {p0, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object p0

    goto :goto_0

    .line 192
    :cond_3
    const-string/jumbo v0, ".amazon"

    invoke-virtual {p0, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 194
    const-string/jumbo v0, ".amazon"

    invoke-virtual {p0, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    invoke-virtual {p0, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object p0

    goto :goto_0

    .line 197
    :cond_4
    new-instance v0, Ljava/lang/RuntimeException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "Input was non-empty and doesn\'t look like a valid url: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static getPartialAmazonDomainFromAPIBundle(Landroid/os/Bundle;)Ljava/lang/String;
    .locals 2
    .param p0, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 149
    if-nez p0, :cond_1

    .line 151
    const/4 v0, 0x0

    .line 162
    :cond_0
    :goto_0
    return-object v0

    .line 154
    :cond_1
    const-string/jumbo v1, "com.amazon.identity.ap.domain"

    invoke-virtual {p0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 157
    .local v0, "domain":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 159
    const-string/jumbo v1, "com.amazon.dcp.sso.AddAccount.options.AmazonDomain"

    invoke-virtual {p0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

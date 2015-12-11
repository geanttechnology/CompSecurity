.class public final Lcom/amazon/identity/auth/device/utils/InternationalizationUtil;
.super Ljava/lang/Object;
.source "InternationalizationUtil.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    return-void
.end method

.method public static fromAmazonDomainToLocale(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "amazonDomain"    # Ljava/lang/String;

    .prologue
    .line 19
    if-nez p0, :cond_0

    .line 21
    invoke-static {}, Lcom/amazon/identity/kcpsdk/common/LocaleUtil;->getLocaleAsLanguageTag()Ljava/lang/String;

    move-result-object v0

    .line 34
    :goto_0
    return-object v0

    .line 24
    :cond_0
    const-string/jumbo v0, "amazon.co.jp"

    invoke-virtual {p0, v0}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 26
    sget-object v0, Ljava/util/Locale;->JAPAN:Ljava/util/Locale;

    invoke-static {v0}, Lcom/amazon/identity/kcpsdk/common/LocaleUtil;->getLocaleAsLanguageTag(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 28
    :cond_1
    const-string/jumbo v0, "amazon.cn"

    invoke-virtual {p0, v0}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 30
    sget-object v0, Ljava/util/Locale;->CHINA:Ljava/util/Locale;

    invoke-static {v0}, Lcom/amazon/identity/kcpsdk/common/LocaleUtil;->getLocaleAsLanguageTag(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 34
    :cond_2
    invoke-static {}, Lcom/amazon/identity/kcpsdk/common/LocaleUtil;->getLocaleAsLanguageTag()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static getAuthPortalAssociationHandleForSpecificAmazonDomain(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "amazonDomain"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 40
    if-nez p0, :cond_1

    .line 55
    :cond_0
    :goto_0
    return-object v0

    .line 45
    :cond_1
    const-string/jumbo v1, "amazon.co.jp"

    invoke-virtual {p0, v1}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 47
    const-string/jumbo v0, "amzn_device_jp"

    goto :goto_0

    .line 49
    :cond_2
    const-string/jumbo v1, "amazon.cn"

    invoke-virtual {p0, v1}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 51
    const-string/jumbo v0, "amzn_device_cn"

    goto :goto_0
.end method

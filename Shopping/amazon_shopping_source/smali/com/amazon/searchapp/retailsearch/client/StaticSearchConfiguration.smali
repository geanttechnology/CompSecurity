.class public Lcom/amazon/searchapp/retailsearch/client/StaticSearchConfiguration;
.super Ljava/lang/Object;
.source "StaticSearchConfiguration.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static build()Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet;
    .locals 10

    .prologue
    const/4 v9, 0x4

    const/4 v8, 0x3

    const/4 v7, 0x1

    const/4 v6, 0x5

    const/4 v5, 0x7

    .line 17
    new-instance v2, Ljava/util/LinkedHashMap;

    invoke-direct {v2, v6}, Ljava/util/LinkedHashMap;-><init>(I)V

    invoke-static {v2}, Ljava/util/Collections;->synchronizedMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    .line 24
    .local v0, "configs":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;>;"
    new-instance v2, Ljava/util/LinkedHashMap;

    const/16 v3, 0xe

    invoke-direct {v2, v3}, Ljava/util/LinkedHashMap;-><init>(I)V

    invoke-static {v2}, Ljava/util/Collections;->synchronizedMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v1

    .line 28
    .local v1, "realms":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/searchapp/retailsearch/client/SearchRealm;>;"
    const-string/jumbo v2, "us"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "us"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "en_US"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3, v7}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "ATVPDKIKX0DER"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://www.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://www.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://www.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://www.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "UTF-8"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setInputEncoding(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 47
    const-string/jumbo v2, "br"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "br"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "pt_BR"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const v4, 0x80a7a

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A2Q3Y263D00KWC"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://www.amazon.com.br"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://www.amazon.com.br"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://www.amazon.com.br"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://www.amazon.com.br"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_pt_BR"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u00c5M\u00c5\u017d\u00d5\u00d1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 67
    const-string/jumbo v2, "ca"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "ca"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "en_CA"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3, v5}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A2EUQ1WTGCTBG2"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://www.amazon.ca"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://www.amazon.ca"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://www.amazon.ca"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://www.amazon.ca"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "UTF-8"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setInputEncoding(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 86
    const-string/jumbo v2, "ca_fr"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "ca_fr"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "fr_CA"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3, v5}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A2EUQ1WTGCTBG2"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://www.amazon.ca"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://www.amazon.ca"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://www.amazon.ca"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://www.amazon.ca"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_fr_CA"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u00c5M\u00c5\u017d\u00d5\u00d1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 106
    const-string/jumbo v2, "cn"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "cn"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "zh_CN"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const/16 v4, 0xca8

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "AAHKV2X7AFYLW"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://www.amazon.cn"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://www.amazon.cn"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://www.amazon.cn"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://www.amazon.cn"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.cn"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.cn"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_zh_CN"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u4e9a\u9a6c\u900a\u7f51\u7ad9"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 126
    const-string/jumbo v2, "de"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "de"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "de_DE"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3, v9}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A1PA6795UKMFR9"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://www.amazon.de"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://www.amazon.de"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://www.amazon.de"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://www.amazon.de"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_de_DE"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u00c5M\u00c5Z\u00d5\u00d1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 146
    const-string/jumbo v2, "es"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "es"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "es_ES"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const v4, 0xae07

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A1RKKUPIHCS9HS"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://www.amazon.es"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://www.amazon.es"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://www.amazon.es"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://www.amazon.es"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_es_ES"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u00c5M\u00c5Z\u00d5\u00d1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 166
    const-string/jumbo v2, "fr"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "fr"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "fr_FR"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3, v6}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A13V1IB3VIYZZH"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://www.amazon.fr"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://www.amazon.fr"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://www.amazon.fr"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://www.amazon.fr"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_fr_FR"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u00c5M\u00c5Z\u00d5\u00d1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 186
    const-string/jumbo v2, "in"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "in"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "en_IN"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const v4, 0xae1b

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A21TJRUUN4KGV"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://www.amazon.in"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://www.amazon.in"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://www.amazon.in"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://www.amazon.in"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "UTF-8"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setInputEncoding(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 205
    const-string/jumbo v2, "it"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "it"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "it_IT"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const v4, 0x8b6b

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "APJ6JRA9NG5V4"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://www.amazon.it"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://www.amazon.it"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://www.amazon.it"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://www.amazon.it"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_it_IT"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u00c5M\u00c5Z\u00d5\u00d1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 225
    const-string/jumbo v2, "jp"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "jp"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "ja_JP"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const/4 v4, 0x6

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A1VC38T7YXB528"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://www.amazon.jp"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://www.amazon.jp"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://www.amazon.co.jp"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://www.amazon.co.jp"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.jp"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.jp"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_ja_JP"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u30ab\u30bf\u30ab\u30ca"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 245
    const-string/jumbo v2, "uk"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "en_GB"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3, v8}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A1F83G8C2ARO7P"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://www.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://www.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://www.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://www.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_en_GB"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u00c5M\u00c5Z\u00d5\u00d1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 265
    const-string/jumbo v2, "au"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "au"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "en_AU"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const v4, 0x1b244

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A39IBJ37TRP1C6"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://www.amazon.com.au"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://www.amazon.com.au"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://www.amazon.com.au"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://www.amazon.com.au"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.jp"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.jp"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "UTF-8"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setInputEncoding(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 284
    const-string/jumbo v2, "mx"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "mx"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "es_MX"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const v4, 0xbc6ba

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A1AM78C64UM0Y8"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://www.amazon.com.mx"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://www.amazon.com.mx"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://www.amazon.com.mx"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://www.amazon.com.mx"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_es_MX"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u00c5M\u00c5Z\u00d5\u00d1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 302
    const-string/jumbo v2, "amazon"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;-><init>()V

    const-string/jumbo v4, "amazon"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;

    move-result-object v3

    invoke-virtual {v3, v1}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;->setRealms(Ljava/util/Map;)Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 312
    new-instance v2, Ljava/util/LinkedHashMap;

    const/16 v3, 0xe

    invoke-direct {v2, v3}, Ljava/util/LinkedHashMap;-><init>(I)V

    invoke-static {v2}, Ljava/util/Collections;->synchronizedMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v1

    .line 316
    const-string/jumbo v2, "us"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "us"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "en_US"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3, v7}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "ATVPDKIKX0DER"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma.amazon.com:9100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma.amazon.com:9100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma.amazon.com:9100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://sitenav-qa-gamma.amazon.com:9100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "UTF-8"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setInputEncoding(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 335
    const-string/jumbo v2, "br"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "br"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "pt_BR"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const v4, 0x80a7a

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A2Q3Y263D00KWC"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-br.amazon.com:17100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-br.amazon.com:17100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-br.amazon.com:17100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://sitenav-qa-gamma-br.amazon.com:17100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_pt_BR"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u00c5M\u00c5\u017d\u00d5\u00d1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 355
    const-string/jumbo v2, "ca"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "ca"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "en_CA"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3, v5}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A2EUQ1WTGCTBG2"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-ca.amazon.com:8100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-ca.amazon.com:8100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-ca.amazon.com:8100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://sitenav-qa-gamma-ca.amazon.com:8100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "UTF-8"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setInputEncoding(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 374
    const-string/jumbo v2, "ca_fr"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "ca_fr"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "fr_CA"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3, v5}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A2EUQ1WTGCTBG2"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-ca.amazon.com:8100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-ca.amazon.com:8100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-ca.amazon.com:8100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://sitenav-qa-gamma-ca.amazon.com:8100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_fr_CA"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u00c5M\u00c5\u017d\u00d5\u00d1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 394
    const-string/jumbo v2, "cn"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "cn"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "zh_CN"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const/16 v4, 0xca8

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "AAHKV2X7AFYLW"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-cn.amazon.com:6100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-cn.amazon.com:6100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-cn.amazon.com:6100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://sitenav-qa-gamma-cn.amazon.com:6100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.cn"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.cn"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_zh_CN"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u4e9a\u9a6c\u900a\u7f51\u7ad9"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 414
    const-string/jumbo v2, "de"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "de"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "de_DE"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3, v9}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A1PA6795UKMFR9"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-de.amazon.com:12100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-de.amazon.com:12100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-de.amazon.com:12100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://sitenav-qa-gamma-de.amazon.com:12100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_de_DE"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u00c5M\u00c5Z\u00d5\u00d1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 434
    const-string/jumbo v2, "es"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "es"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "es_ES"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const v4, 0xae07

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A1RKKUPIHCS9HS"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-es.amazon.com:17100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-es.amazon.com:17100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-es.amazon.com:17100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://sitenav-qa-gamma-es.amazon.com:17100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_es_ES"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u00c5M\u00c5Z\u00d5\u00d1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 454
    const-string/jumbo v2, "fr"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "fr"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "fr_FR"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3, v6}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A13V1IB3VIYZZH"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-fr.amazon.com:11100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-fr.amazon.com:11100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-fr.amazon.com:11100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://sitenav-qa-gamma-fr.amazon.com:11100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_fr_FR"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u00c5M\u00c5Z\u00d5\u00d1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 474
    const-string/jumbo v2, "in"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "in"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "en_IN"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const v4, 0xae1b

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A21TJRUUN4KGV"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-in.amazon.com:17100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-in.amazon.com:17100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-in.amazon.com:17100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://sitenav-qa-gamma-in.amazon.com:17100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "UTF-8"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setInputEncoding(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 493
    const-string/jumbo v2, "it"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "it"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "it_IT"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const v4, 0x8b6b

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "APJ6JRA9NG5V4"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-it.amazon.com:17100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-it.amazon.com:17100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-it.amazon.com:17100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://sitenav-qa-gamma-it.amazon.com:17100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_it_IT"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u00c5M\u00c5Z\u00d5\u00d1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 513
    const-string/jumbo v2, "jp"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "jp"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "ja_JP"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const/4 v4, 0x6

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A1VC38T7YXB528"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-jp.amazon.com:7100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-jp.amazon.com:7100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-jp.amazon.com:7100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://sitenav-qa-gamma-jp.amazon.com:7100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.jp"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.jp"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_ja_JP"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u30ab\u30bf\u30ab\u30ca"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 533
    const-string/jumbo v2, "uk"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "en_GB"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3, v8}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A1F83G8C2ARO7P"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-uk.amazon.com:10100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-uk.amazon.com:10100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-uk.amazon.com:10100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://sitenav-qa-gamma-uk.amazon.com:10100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_en_GB"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u00c5M\u00c5Z\u00d5\u00d1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 553
    const-string/jumbo v2, "au"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "au"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "en_AU"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const v4, 0x1b244

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A39IBJ37TRP1C6"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-au.amazon.com:18100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-au.amazon.com:18100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-au.amazon.com:18100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-au.amazon.com:18100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.jp"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.jp"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "UTF-8"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setInputEncoding(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 572
    const-string/jumbo v2, "mx"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "mx"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "es_MX"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const v4, 0xbc6ba

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A1AM78C64UM0Y8"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-mx.amazon.com:19100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-mx.amazon.com:19100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-mx.amazon.com:19100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://sitenav-qa-gamma-mx.amazon.com:19100"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_es_MX"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u00c5M\u00c5Z\u00d5\u00d1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 590
    const-string/jumbo v2, "test1"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;-><init>()V

    const-string/jumbo v4, "test1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;

    move-result-object v3

    invoke-virtual {v3, v1}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;->setRealms(Ljava/util/Map;)Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 600
    new-instance v2, Ljava/util/LinkedHashMap;

    const/16 v3, 0xe

    invoke-direct {v2, v3}, Ljava/util/LinkedHashMap;-><init>(I)V

    invoke-static {v2}, Ljava/util/Collections;->synchronizedMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v1

    .line 604
    const-string/jumbo v2, "us"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "us"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "en_US"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3, v7}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "ATVPDKIKX0DER"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma.amazon.com:9200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma.amazon.com:9200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma.amazon.com:9200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://sitenav-qa-gamma.amazon.com:9200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "UTF-8"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setInputEncoding(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 623
    const-string/jumbo v2, "br"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "br"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "pt_BR"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const v4, 0x80a7a

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A2Q3Y263D00KWC"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-br.amazon.com:17200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-br.amazon.com:17200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-br.amazon.com:17200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://sitenav-qa-gamma-br.amazon.com:17200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_pt_BR"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u00c5M\u00c5\u017d\u00d5\u00d1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 643
    const-string/jumbo v2, "ca"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "ca"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "en_CA"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3, v5}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A2EUQ1WTGCTBG2"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-ca.amazon.com:8200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-ca.amazon.com:8200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-ca.amazon.com:8200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://sitenav-qa-gamma-ca.amazon.com:8200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "UTF-8"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setInputEncoding(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 662
    const-string/jumbo v2, "ca_fr"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "ca_fr"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "fr_CA"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3, v5}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A2EUQ1WTGCTBG2"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-ca.amazon.com:8200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-ca.amazon.com:8200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-ca.amazon.com:8200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://sitenav-qa-gamma-ca.amazon.com:8200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_fr_CA"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u00c5M\u00c5\u017d\u00d5\u00d1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 682
    const-string/jumbo v2, "cn"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "cn"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "zh_CN"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const/16 v4, 0xca8

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "AAHKV2X7AFYLW"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-cn.amazon.com:6200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-cn.amazon.com:6200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-cn.amazon.com:6200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://sitenav-qa-gamma-cn.amazon.com:6200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.cn"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.cn"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_zh_CN"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u4e9a\u9a6c\u900a\u7f51\u7ad9"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 702
    const-string/jumbo v2, "de"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "de"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "de_DE"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3, v9}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A1PA6795UKMFR9"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-de.amazon.com:12200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-de.amazon.com:12200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-de.amazon.com:12200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://sitenav-qa-gamma-de.amazon.com:12200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_de_DE"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u00c5M\u00c5Z\u00d5\u00d1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 722
    const-string/jumbo v2, "es"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "es"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "es_ES"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const v4, 0xae07

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A1RKKUPIHCS9HS"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-es.amazon.com:17200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-es.amazon.com:17200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-es.amazon.com:17200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://sitenav-qa-gamma-es.amazon.com:17200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_es_ES"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u00c5M\u00c5Z\u00d5\u00d1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 742
    const-string/jumbo v2, "fr"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "fr"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "fr_FR"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3, v6}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A13V1IB3VIYZZH"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-fr.amazon.com:11200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-fr.amazon.com:11200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-fr.amazon.com:11200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://sitenav-qa-gamma-fr.amazon.com:11200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_fr_FR"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u00c5M\u00c5Z\u00d5\u00d1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 762
    const-string/jumbo v2, "in"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "in"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "en_IN"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const v4, 0xae1b

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A21TJRUUN4KGV"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-in.amazon.com:17200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-in.amazon.com:17200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-in.amazon.com:17200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://sitenav-qa-gamma-in.amazon.com:17200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "UTF-8"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setInputEncoding(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 781
    const-string/jumbo v2, "it"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "it"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "it_IT"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const v4, 0x8b6b

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "APJ6JRA9NG5V4"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-it.amazon.com:17200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-it.amazon.com:17200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-it.amazon.com:17200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://sitenav-qa-gamma-it.amazon.com:17200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_it_IT"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u00c5M\u00c5Z\u00d5\u00d1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 801
    const-string/jumbo v2, "jp"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "jp"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "ja_JP"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const/4 v4, 0x6

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A1VC38T7YXB528"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-jp.amazon.com:7200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-jp.amazon.com:7200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-jp.amazon.com:7200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://sitenav-qa-gamma-jp.amazon.com:7200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.jp"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.jp"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_ja_JP"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u30ab\u30bf\u30ab\u30ca"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 821
    const-string/jumbo v2, "uk"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "en_GB"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3, v8}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A1F83G8C2ARO7P"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-uk.amazon.com:10200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-uk.amazon.com:10200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-uk.amazon.com:10200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://sitenav-qa-gamma-uk.amazon.com:10200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_en_GB"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u00c5M\u00c5Z\u00d5\u00d1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 841
    const-string/jumbo v2, "au"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "au"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "en_AU"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const v4, 0x1b244

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A39IBJ37TRP1C6"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-au.amazon.com:18200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-au.amazon.com:18200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-au.amazon.com:18200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-au.amazon.com:18200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.jpg"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.jp"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "UTF-8"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setInputEncoding(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 860
    const-string/jumbo v2, "mx"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "mx"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "es_MX"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const v4, 0xbc6ba

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A1AM78C64UM0Y8"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-mx.amazon.com:19200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-mx.amazon.com:19200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sitenav-qa-gamma-mx.amazon.com:19200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://sitenav-qa-gamma-mx.amazon.com:19200"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_es_MX"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u00c5M\u00c5Z\u00d5\u00d1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 878
    const-string/jumbo v2, "test2"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;-><init>()V

    const-string/jumbo v4, "test2"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;

    move-result-object v3

    invoke-virtual {v3, v1}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;->setRealms(Ljava/util/Map;)Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 888
    new-instance v2, Ljava/util/LinkedHashMap;

    const/16 v3, 0xf

    invoke-direct {v2, v3}, Ljava/util/LinkedHashMap;-><init>(I)V

    invoke-static {v2}, Ljava/util/Collections;->synchronizedMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v1

    .line 892
    const-string/jumbo v2, "us"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "us"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "en_US"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3, v7}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "ATVPDKIKX0DER"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-us.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://sx-mobile-us.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-us.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://sx-mobile-us.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "UTF-8"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setInputEncoding(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 911
    const-string/jumbo v2, "br"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "br"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "pt_BR"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const v4, 0x80a7a

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A2Q3Y263D00KWC"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-br.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-br.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-br.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-br.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_pt_BR"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u00c5M\u00c5\u017d\u00d5\u00d1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 931
    const-string/jumbo v2, "ca"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "ca"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "en_CA"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3, v5}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A2EUQ1WTGCTBG2"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-ca.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-ca.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-ca.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-ca.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "UTF-8"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setInputEncoding(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 950
    const-string/jumbo v2, "ca_fr"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "ca_fr"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "fr_CA"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3, v5}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A2EUQ1WTGCTBG2"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-ca.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-ca.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-ca.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-ca.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_fr_CA"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u00c5M\u00c5\u017d\u00d5\u00d1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 970
    const-string/jumbo v2, "cn"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "cn"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "zh_CN"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const/16 v4, 0xca8

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "AAHKV2X7AFYLW"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-cn.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-cn.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-cn.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-cn.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.cn"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.cn"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_zh_CN"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u4e9a\u9a6c\u900a\u7f51\u7ad9"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 990
    const-string/jumbo v2, "de"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "de"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "de_DE"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3, v9}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A1PA6795UKMFR9"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-de.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-de.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-de.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-de.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_de_DE"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u00c5M\u00c5Z\u00d5\u00d1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1010
    const-string/jumbo v2, "es"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "es"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "es_ES"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const v4, 0xae07

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A1RKKUPIHCS9HS"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-es.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-es.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-es.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-es.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_es_ES"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u00c5M\u00c5Z\u00d5\u00d1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1030
    const-string/jumbo v2, "fr"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "fr"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "fr_FR"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3, v6}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A13V1IB3VIYZZH"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-fr.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-fr.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-fr.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-fr.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_fr_FR"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u00c5M\u00c5Z\u00d5\u00d1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1050
    const-string/jumbo v2, "in"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "in"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "en_IN"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const v4, 0xae1b

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A21TJRUUN4KGV"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-in.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-in.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-in.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-in.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "UTF-8"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setInputEncoding(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1069
    const-string/jumbo v2, "it"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "it"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "it_IT"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const v4, 0x8b6b

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "APJ6JRA9NG5V4"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-it.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-it.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-it.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-it.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_it_IT"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u00c5M\u00c5Z\u00d5\u00d1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1089
    const-string/jumbo v2, "jp"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "jp"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "ja_JP"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const/4 v4, 0x6

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A1VC38T7YXB528"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-jp.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-jp.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-jp.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-jp.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.jp"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.jp"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_ja_JP"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u30ab\u30bf\u30ab\u30ca"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1109
    const-string/jumbo v2, "uk"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "en_GB"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3, v8}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A1F83G8C2ARO7P"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-uk.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-uk.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-uk.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-uk.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_en_GB"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u00c5M\u00c5Z\u00d5\u00d1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1129
    const-string/jumbo v2, "au"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "au"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "en_AU"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const v4, 0x1b244

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A39IBJ37TRP1C6"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-au.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-au.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-au.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-au.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.jp"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.jp"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "UTF-8"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setInputEncoding(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1148
    const-string/jumbo v2, "mx"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "mx"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "es_MX"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const v4, 0xbc6ba

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A1AM78C64UM0Y8"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-mx.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-mx.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-mx.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-mx.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_es_MX"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u00c5M\u00c5Z\u00d5\u00d1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1168
    const-string/jumbo v2, "ru"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "ru"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "ru_RU"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const v4, 0x1b23a

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "AD2EMQ3L3PG8S"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-ru.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-ru.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-ru.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-ru.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "UTF-8"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setInputEncoding(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1185
    const-string/jumbo v2, "test3"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;-><init>()V

    const-string/jumbo v4, "test3"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;

    move-result-object v3

    invoke-virtual {v3, v1}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;->setRealms(Ljava/util/Map;)Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1195
    new-instance v2, Ljava/util/LinkedHashMap;

    const/16 v3, 0xf

    invoke-direct {v2, v3}, Ljava/util/LinkedHashMap;-><init>(I)V

    invoke-static {v2}, Ljava/util/Collections;->synchronizedMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v1

    .line 1199
    const-string/jumbo v2, "us"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "us"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "en_US"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3, v7}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "ATVPDKIKX0DER"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-us-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://sx-mobile-us-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-us-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://sx-mobile-us-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "UTF-8"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setInputEncoding(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1218
    const-string/jumbo v2, "br"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "br"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "pt_BR"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const v4, 0x80a7a

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A2Q3Y263D00KWC"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-br-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-br-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-br-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-br-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_pt_BR"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u00c5M\u00c5\u017d\u00d5\u00d1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1238
    const-string/jumbo v2, "ca"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "ca"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "en_CA"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3, v5}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A2EUQ1WTGCTBG2"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-ca-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-ca-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-ca-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-ca-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "UTF-8"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setInputEncoding(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1257
    const-string/jumbo v2, "ca_fr"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "ca_fr"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "fr_CA"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3, v5}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A2EUQ1WTGCTBG2"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-ca-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-ca-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-ca-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-ca-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_fr_CA"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u00c5M\u00c5\u017d\u00d5\u00d1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1277
    const-string/jumbo v2, "cn"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "cn"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "zh_CN"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const/16 v4, 0xca8

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "AAHKV2X7AFYLW"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-cn-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-cn-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-cn-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-cn-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.cn"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.cn"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_zh_CN"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u4e9a\u9a6c\u900a\u7f51\u7ad9"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1297
    const-string/jumbo v2, "de"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "de"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "de_DE"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3, v9}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A1PA6795UKMFR9"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-de-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-de-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-de-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-de-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_de_DE"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u00c5M\u00c5Z\u00d5\u00d1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1317
    const-string/jumbo v2, "es"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "es"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "es_ES"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const v4, 0xae07

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A1RKKUPIHCS9HS"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-es-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-es-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-es-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-es-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_es_ES"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u00c5M\u00c5Z\u00d5\u00d1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1337
    const-string/jumbo v2, "fr"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "fr"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "fr_FR"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3, v6}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A13V1IB3VIYZZH"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-fr-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-fr-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-fr-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-fr-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_fr_FR"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u00c5M\u00c5Z\u00d5\u00d1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1357
    const-string/jumbo v2, "in"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "in"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "en_IN"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const v4, 0xae1b

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A21TJRUUN4KGV"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-in-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-in-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-in-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-in-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "UTF-8"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setInputEncoding(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1376
    const-string/jumbo v2, "it"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "it"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "it_IT"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const v4, 0x8b6b

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "APJ6JRA9NG5V4"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-it-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-it-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-it-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-it-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_it_IT"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u00c5M\u00c5Z\u00d5\u00d1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1396
    const-string/jumbo v2, "jp"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "jp"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "ja_JP"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const/4 v4, 0x6

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A1VC38T7YXB528"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-jp-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-jp-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-jp-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-jp-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.jp"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.jp"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_ja_JP"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u30ab\u30bf\u30ab\u30ca"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1416
    const-string/jumbo v2, "uk"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "en_GB"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3, v8}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A1F83G8C2ARO7P"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-uk-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-uk-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-uk-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-uk-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_en_GB"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u00c5M\u00c5Z\u00d5\u00d1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1436
    const-string/jumbo v2, "au"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "au"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "en_AU"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const v4, 0x1b244

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A39IBJ37TRP1C6"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-au-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-au-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-au-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-au-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.jp"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.jp"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "UTF-8"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setInputEncoding(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1455
    const-string/jumbo v2, "mx"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "mx"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "es_MX"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const v4, 0xbc6ba

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "A1AM78C64UM0Y8"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-mx-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-mx-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-mx-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-mx-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "__mk_es_MX"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingParam(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "\u00c5M\u00c5Z\u00d5\u00d1"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setEncodingValue(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1475
    const-string/jumbo v2, "ru"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;-><init>()V

    const-string/jumbo v4, "ru"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "ru_RU"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setLocale(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const v4, 0x1b23a

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setMarketplaceId(I)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "AD2EMQ3L3PG8S"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setObfuscatedMarketplaceId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-ru-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-ru-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSiteUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-ru-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://sx-mobile-ru-gamma.integ.amazon.com"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureSearchServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "http://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "https://completion.amazon.co.uk"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setSecureCompletionServiceUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    const-string/jumbo v4, "UTF-8"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->setInputEncoding(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1492
    const-string/jumbo v2, "test4"

    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;-><init>()V

    const-string/jumbo v4, "test4"

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;->setId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;

    move-result-object v3

    invoke-virtual {v3, v1}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;->setRealms(Ljava/util/Map;)Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1500
    new-instance v2, Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet$Builder;

    invoke-direct {v2}, Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet$Builder;-><init>()V

    invoke-virtual {v2, v0}, Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet$Builder;->setConfigurations(Ljava/util/Map;)Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet$Builder;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet;

    move-result-object v2

    return-object v2
.end method

.class public abstract Lcom/amazon/mShop/publicurl/PublicURLProcessor;
.super Ljava/lang/Object;
.source "PublicURLProcessor.java"


# static fields
.field private static final sLocaleMapping:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field protected mAssociateTag:Ljava/lang/String;

.field protected mHost:Ljava/lang/String;

.field private mIsLocaleChecked:Z

.field protected mLocaleName:Ljava/lang/String;

.field protected mOrigin:Ljava/lang/String;

.field protected mParams:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field protected mPathSegments:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field protected mRefmarker:Ljava/lang/String;

.field protected final mUri:Landroid/net/Uri;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 42
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->sLocaleMapping:Ljava/util/Map;

    .line 43
    sget-object v0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->sLocaleMapping:Ljava/util/Map;

    const-string/jumbo v1, "com"

    const-string/jumbo v2, "en_US"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 44
    sget-object v0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->sLocaleMapping:Ljava/util/Map;

    const-string/jumbo v1, "co.uk"

    const-string/jumbo v2, "en_GB"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 45
    sget-object v0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->sLocaleMapping:Ljava/util/Map;

    const-string/jumbo v1, "co.jp"

    const-string/jumbo v2, "ja_JP"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 46
    sget-object v0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->sLocaleMapping:Ljava/util/Map;

    const-string/jumbo v1, "cn"

    const-string/jumbo v2, "zh_CN"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 47
    sget-object v0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->sLocaleMapping:Ljava/util/Map;

    const-string/jumbo v1, "ca"

    const-string/jumbo v2, "en_CA"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 48
    sget-object v0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->sLocaleMapping:Ljava/util/Map;

    const-string/jumbo v1, "it"

    const-string/jumbo v2, "it_IT"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 49
    sget-object v0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->sLocaleMapping:Ljava/util/Map;

    const-string/jumbo v1, "es"

    const-string/jumbo v2, "es_ES"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 50
    sget-object v0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->sLocaleMapping:Ljava/util/Map;

    const-string/jumbo v1, "de"

    const-string/jumbo v2, "de_DE"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 51
    sget-object v0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->sLocaleMapping:Ljava/util/Map;

    const-string/jumbo v1, "fr"

    const-string/jumbo v2, "fr_FR"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 52
    sget-object v0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->sLocaleMapping:Ljava/util/Map;

    const-string/jumbo v1, "in"

    const-string/jumbo v2, "en_IN"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 53
    return-void
.end method

.method public constructor <init>(Landroid/net/Uri;)V
    .locals 6
    .param p1, "uri"    # Landroid/net/Uri;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .annotation build Landroid/annotation/TargetApi;
        value = 0xb
    .end annotation

    .prologue
    .line 57
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 58
    iput-object p1, p0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->mUri:Landroid/net/Uri;

    .line 59
    iget-object v4, p0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->mUri:Landroid/net/Uri;

    invoke-virtual {v4}, Landroid/net/Uri;->getHost()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->mHost:Ljava/lang/String;

    .line 60
    iget-object v4, p0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->mHost:Ljava/lang/String;

    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 61
    iget-object v4, p0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->mHost:Ljava/lang/String;

    invoke-virtual {v4}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->mHost:Ljava/lang/String;

    .line 63
    :cond_0
    iget-object v4, p0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->mUri:Landroid/net/Uri;

    invoke-virtual {v4}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->mPathSegments:Ljava/util/List;

    .line 64
    iget-object v4, p0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->mUri:Landroid/net/Uri;

    const-string/jumbo v5, "ref"

    invoke-virtual {v4, v5}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->mRefmarker:Ljava/lang/String;

    .line 65
    iget-object v4, p0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->mUri:Landroid/net/Uri;

    const-string/jumbo v5, "tag"

    invoke-virtual {v4, v5}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->mAssociateTag:Ljava/lang/String;

    .line 66
    invoke-static {p1}, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->getLocaleNameFromUri(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->mLocaleName:Ljava/lang/String;

    .line 67
    new-instance v4, Ljava/util/HashMap;

    invoke-direct {v4}, Ljava/util/HashMap;-><init>()V

    iput-object v4, p0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->mParams:Ljava/util/Map;

    .line 69
    sget v4, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v5, 0xb

    if-lt v4, v5, :cond_1

    const/4 v0, 0x1

    .line 70
    .local v0, "isAboveHoneycomb":Z
    :goto_0
    if-eqz v0, :cond_2

    .line 71
    iget-object v4, p0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->mUri:Landroid/net/Uri;

    invoke-virtual {v4}, Landroid/net/Uri;->getQueryParameterNames()Ljava/util/Set;

    move-result-object v3

    .line 76
    .local v3, "paramNames":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    :goto_1
    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 77
    .local v1, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :goto_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_3

    .line 78
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 79
    .local v2, "key":Ljava/lang/String;
    iget-object v4, p0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->mParams:Ljava/util/Map;

    iget-object v5, p0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->mUri:Landroid/net/Uri;

    invoke-virtual {v5, v2}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v2, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_2

    .line 69
    .end local v0    # "isAboveHoneycomb":Z
    .end local v1    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    .end local v2    # "key":Ljava/lang/String;
    .end local v3    # "paramNames":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    .line 73
    .restart local v0    # "isAboveHoneycomb":Z
    :cond_2
    iget-object v4, p0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->mUri:Landroid/net/Uri;

    invoke-direct {p0, v4}, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->parseQueryParameterNames(Landroid/net/Uri;)Ljava/util/Set;

    move-result-object v3

    .restart local v3    # "paramNames":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    goto :goto_1

    .line 81
    .restart local v1    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_3
    return-void
.end method

.method private checkMarketplace()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/mShop/publicurl/PublicURLProcessException;
        }
    .end annotation

    .prologue
    .line 126
    iget-object v1, p0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->mHost:Ljava/lang/String;

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 127
    iget-object v1, p0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->mLocaleName:Ljava/lang/String;

    if-nez v1, :cond_0

    .line 128
    new-instance v1, Lcom/amazon/mShop/publicurl/PublicURLProcessException;

    sget-object v2, Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;->ERROR_CODE_ERROR_HOSTNAME:Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;

    invoke-direct {v1, v2}, Lcom/amazon/mShop/publicurl/PublicURLProcessException;-><init>(Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;)V

    throw v1

    .line 130
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocaleName()Ljava/lang/String;

    move-result-object v0

    .line 132
    .local v0, "currentLocaleName":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->mLocaleName:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    iget-object v1, p0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->mLocaleName:Ljava/lang/String;

    invoke-static {v1}, Lcom/amazon/mShop/platform/AppLocale;->isLocaleOfCA(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-static {v0}, Lcom/amazon/mShop/platform/AppLocale;->isLocaleOfCA(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 134
    :cond_1
    new-instance v1, Lcom/amazon/mShop/publicurl/PublicURLProcessException;

    sget-object v2, Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;->ERROR_CODE_NEED_SWITCH_LOCALE:Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;

    invoke-direct {v1, v2}, Lcom/amazon/mShop/publicurl/PublicURLProcessException;-><init>(Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;)V

    throw v1

    .line 137
    .end local v0    # "currentLocaleName":Ljava/lang/String;
    :cond_2
    return-void
.end method

.method public static getLocaleNameFromUri(Landroid/net/Uri;)Ljava/lang/String;
    .locals 4
    .param p0, "url"    # Landroid/net/Uri;

    .prologue
    const/4 v2, 0x0

    .line 198
    if-nez p0, :cond_1

    .line 209
    :cond_0
    :goto_0
    return-object v2

    .line 202
    :cond_1
    invoke-virtual {p0}, Landroid/net/Uri;->getHost()Ljava/lang/String;

    move-result-object v1

    .line 203
    .local v1, "host":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 207
    invoke-virtual {v1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    .line 208
    const-string/jumbo v2, "amazon."

    invoke-virtual {v1, v2}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v2

    const-string/jumbo v3, "amazon."

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v2, v3

    invoke-virtual {v1, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    .line 209
    .local v0, "domain":Ljava/lang/String;
    sget-object v2, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->sLocaleMapping:Ljava/util/Map;

    invoke-interface {v2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    goto :goto_0
.end method

.method private parseQueryParameterNames(Landroid/net/Uri;)Ljava/util/Set;
    .locals 9
    .param p1, "uri"    # Landroid/net/Uri;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/net/Uri;",
            ")",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v8, -0x1

    .line 87
    invoke-virtual {p1}, Landroid/net/Uri;->getEncodedQuery()Ljava/lang/String;

    move-result-object v4

    .line 88
    .local v4, "query":Ljava/lang/String;
    if-nez v4, :cond_0

    .line 89
    invoke-static {}, Ljava/util/Collections;->emptySet()Ljava/util/Set;

    move-result-object v2

    .line 109
    :goto_0
    return-object v2

    .line 92
    :cond_0
    new-instance v2, Ljava/util/LinkedHashSet;

    invoke-direct {v2}, Ljava/util/LinkedHashSet;-><init>()V

    .line 93
    .local v2, "names":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    const/4 v6, 0x0

    .line 95
    .local v6, "start":I
    :cond_1
    const/16 v7, 0x26

    invoke-virtual {v4, v7, v6}, Ljava/lang/String;->indexOf(II)I

    move-result v3

    .line 96
    .local v3, "next":I
    if-ne v3, v8, :cond_4

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v0

    .line 98
    .local v0, "end":I
    :goto_1
    const/16 v7, 0x3d

    invoke-virtual {v4, v7, v6}, Ljava/lang/String;->indexOf(II)I

    move-result v5

    .line 99
    .local v5, "separator":I
    if-gt v5, v0, :cond_2

    if-ne v5, v8, :cond_3

    .line 100
    :cond_2
    move v5, v0

    .line 103
    :cond_3
    invoke-virtual {v4, v6, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    .line 104
    .local v1, "name":Ljava/lang/String;
    invoke-static {v1}, Landroid/net/Uri;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-interface {v2, v7}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 107
    add-int/lit8 v6, v0, 0x1

    .line 108
    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v7

    if-lt v6, v7, :cond_1

    goto :goto_0

    .end local v0    # "end":I
    .end local v1    # "name":Ljava/lang/String;
    .end local v5    # "separator":I
    :cond_4
    move v0, v3

    .line 96
    goto :goto_1
.end method

.method private preprocess()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/mShop/publicurl/PublicURLProcessException;
        }
    .end annotation

    .prologue
    .line 119
    iget-boolean v0, p0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->mIsLocaleChecked:Z

    if-nez v0, :cond_0

    .line 120
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->mIsLocaleChecked:Z

    .line 121
    invoke-direct {p0}, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->checkMarketplace()V

    .line 123
    :cond_0
    return-void
.end method


# virtual methods
.method protected abstract doProcess(Landroid/content/Context;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/mShop/publicurl/PublicURLProcessException;
        }
    .end annotation
.end method

.method public getHost()Ljava/lang/String;
    .locals 1

    .prologue
    .line 182
    iget-object v0, p0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->mHost:Ljava/lang/String;

    return-object v0
.end method

.method public getLocaleName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 213
    iget-object v0, p0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->mLocaleName:Ljava/lang/String;

    return-object v0
.end method

.method public abstract getMetricIdentity()Ljava/lang/String;
.end method

.method public getOrigin()Ljava/lang/String;
    .locals 1

    .prologue
    .line 194
    iget-object v0, p0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->mOrigin:Ljava/lang/String;

    return-object v0
.end method

.method public getParams()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 217
    iget-object v0, p0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->mParams:Ljava/util/Map;

    return-object v0
.end method

.method public getRefmarker()Ljava/lang/String;
    .locals 1

    .prologue
    .line 186
    iget-object v0, p0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->mRefmarker:Ljava/lang/String;

    return-object v0
.end method

.method public process(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/mShop/publicurl/PublicURLProcessException;
        }
    .end annotation

    .prologue
    .line 145
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->process(Landroid/content/Context;Ljava/lang/String;)V

    .line 146
    return-void
.end method

.method public process(Landroid/content/Context;Ljava/lang/String;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "origin"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/mShop/publicurl/PublicURLProcessException;
        }
    .end annotation

    .prologue
    .line 157
    :try_start_0
    iput-object p2, p0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->mOrigin:Ljava/lang/String;

    .line 158
    iget-object v1, p0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->mRefmarker:Ljava/lang/String;

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->mOrigin:Ljava/lang/String;

    :goto_0
    iput-object v1, p0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->mRefmarker:Ljava/lang/String;

    .line 159
    invoke-direct {p0}, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->preprocess()V

    .line 160
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->doProcess(Landroid/content/Context;)V

    .line 167
    return-void

    .line 158
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->mRefmarker:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/UnsupportedOperationException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 161
    :catch_0
    move-exception v0

    .line 165
    .local v0, "e":Ljava/lang/UnsupportedOperationException;
    new-instance v1, Lcom/amazon/mShop/publicurl/PublicURLProcessException;

    sget-object v2, Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;->ERROR_CODE_ERROR_PATH:Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;

    invoke-direct {v1, v2}, Lcom/amazon/mShop/publicurl/PublicURLProcessException;-><init>(Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;)V

    throw v1
.end method

.class public Lcom/amazon/mobile/mash/interception/UrlInterceptionHandler;
.super Ljava/lang/Object;
.source "UrlInterceptionHandler.java"


# instance fields
.field private mContext:Landroid/content/Context;

.field private mParamList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/amazon/mobile/mash/interception/ParameterModel;",
            ">;"
        }
    .end annotation
.end field

.field private mUri:Landroid/net/Uri;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/net/Uri;Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "uri"    # Landroid/net/Uri;
    .param p3, "configEntry"    # Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    .prologue
    .line 42
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 43
    iput-object p1, p0, Lcom/amazon/mobile/mash/interception/UrlInterceptionHandler;->mContext:Landroid/content/Context;

    .line 44
    iput-object p2, p0, Lcom/amazon/mobile/mash/interception/UrlInterceptionHandler;->mUri:Landroid/net/Uri;

    .line 45
    invoke-virtual {p3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;->getParamList()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlInterceptionHandler;->mParamList:Ljava/util/ArrayList;

    .line 46
    return-void
.end method


# virtual methods
.method public getContext()Landroid/content/Context;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlInterceptionHandler;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method public getParam(Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p1, "paramName"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x0

    .line 72
    iget-object v5, p0, Lcom/amazon/mobile/mash/interception/UrlInterceptionHandler;->mUri:Landroid/net/Uri;

    invoke-virtual {v5}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v3

    .line 73
    .local v3, "urlComponents":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v5, p0, Lcom/amazon/mobile/mash/interception/UrlInterceptionHandler;->mParamList:Ljava/util/ArrayList;

    if-nez v5, :cond_1

    .line 82
    :cond_0
    :goto_0
    return-object v4

    .line 76
    :cond_1
    iget-object v5, p0, Lcom/amazon/mobile/mash/interception/UrlInterceptionHandler;->mParamList:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_2
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mobile/mash/interception/ParameterModel;

    .line 77
    .local v1, "param":Lcom/amazon/mobile/mash/interception/ParameterModel;
    invoke-virtual {v1}, Lcom/amazon/mobile/mash/interception/ParameterModel;->getPathSegmentIndex()I

    move-result v2

    .line 78
    .local v2, "paramLocation":I
    invoke-virtual {v1}, Lcom/amazon/mobile/mash/interception/ParameterModel;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v5

    if-ge v2, v5, :cond_2

    .line 79
    invoke-interface {v3, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    goto :goto_0
.end method

.method public getRefmarker()Ljava/lang/String;
    .locals 8

    .prologue
    .line 92
    const/4 v3, 0x0

    .line 94
    .local v3, "ref":Ljava/lang/String;
    :try_start_0
    iget-object v6, p0, Lcom/amazon/mobile/mash/interception/UrlInterceptionHandler;->mUri:Landroid/net/Uri;

    invoke-virtual {v6}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v2

    .line 95
    .local v2, "pathSegments":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 96
    .local v4, "segment":Ljava/lang/String;
    const-string/jumbo v6, "ref="

    invoke-virtual {v4, v6}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    .line 97
    .local v1, "index":I
    if-nez v1, :cond_0

    .line 98
    const-string/jumbo v6, "ref="

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v6

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v7

    invoke-virtual {v4, v6, v7}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    .line 103
    .end local v1    # "index":I
    .end local v4    # "segment":Ljava/lang/String;
    :cond_1
    invoke-static {v3}, Lcom/amazon/mobile/mash/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 104
    iget-object v6, p0, Lcom/amazon/mobile/mash/interception/UrlInterceptionHandler;->mUri:Landroid/net/Uri;

    const-string/jumbo v7, "ref_"

    invoke-virtual {v6, v7}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/UnsupportedOperationException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    :cond_2
    move-object v6, v3

    .line 110
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v2    # "pathSegments":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :goto_0
    return-object v6

    .line 106
    :catch_0
    move-exception v5

    .line 108
    .local v5, "uoe":Ljava/lang/UnsupportedOperationException;
    const/4 v6, 0x0

    goto :goto_0
.end method

.method public getUri()Landroid/net/Uri;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/amazon/mobile/mash/interception/UrlInterceptionHandler;->mUri:Landroid/net/Uri;

    return-object v0
.end method

.method public handle()Z
    .locals 1

    .prologue
    .line 120
    const/4 v0, 0x0

    return v0
.end method

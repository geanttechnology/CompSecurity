.class public Ltv/freewheel/ad/handler/EventCallbackHandler;
.super Ljava/lang/Object;
.source "EventCallbackHandler.java"


# instance fields
.field protected adInstance:Ltv/freewheel/ad/AdInstance;

.field private baseUrl:Ljava/lang/String;

.field private cachedUrl:Ljava/lang/String;

.field private callback:Ltv/freewheel/ad/EventCallback;

.field private crValue:Ljava/lang/String;

.field private externalTrackingURLs:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private internalUrl:Ljava/lang/String;

.field private keys:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field protected logger:Ltv/freewheel/utils/Logger;

.field private originalKeys:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private originalParameterPairs:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private parameterPairs:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ltv/freewheel/ad/EventCallback;)V
    .locals 2
    .param p1, "callback"    # Ltv/freewheel/ad/EventCallback;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/net/MalformedURLException;
        }
    .end annotation

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    const/4 v0, 0x0

    iput-object v0, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->adInstance:Ltv/freewheel/ad/AdInstance;

    .line 34
    if-nez p1, :cond_0

    .line 35
    new-instance v0, Ljava/net/MalformedURLException;

    const-string v1, "callback object is null"

    invoke-direct {v0, v1}, Ljava/net/MalformedURLException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 37
    :cond_0
    invoke-static {p0}, Ltv/freewheel/utils/Logger;->getLogger(Ljava/lang/Object;)Ltv/freewheel/utils/Logger;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->logger:Ltv/freewheel/utils/Logger;

    .line 38
    iput-object p1, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->callback:Ltv/freewheel/ad/EventCallback;

    .line 39
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->keys:Ljava/util/ArrayList;

    .line 40
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->originalKeys:Ljava/util/ArrayList;

    .line 41
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->parameterPairs:Ljava/util/HashMap;

    .line 42
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->originalParameterPairs:Ljava/util/HashMap;

    .line 43
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->externalTrackingURLs:Ljava/util/ArrayList;

    .line 45
    iget-object v0, p1, Ltv/freewheel/ad/EventCallback;->url:Ljava/lang/String;

    invoke-direct {p0, v0}, Ltv/freewheel/ad/handler/EventCallbackHandler;->parseCallbackUrl(Ljava/lang/String;)V

    .line 46
    iget-object v0, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->originalKeys:Ljava/util/ArrayList;

    iget-object v1, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->keys:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 47
    iget-object v0, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->originalParameterPairs:Ljava/util/HashMap;

    iget-object v1, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->parameterPairs:Ljava/util/HashMap;

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->putAll(Ljava/util/Map;)V

    .line 48
    return-void
.end method

.method private encodeURIComponent(Ljava/lang/String;)Ljava/lang/String;
    .locals 5
    .param p1, "s"    # Ljava/lang/String;

    .prologue
    .line 261
    :try_start_0
    const-string v2, "UTF-8"

    invoke-static {p1, v2}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "\\+"

    const-string v4, "%20"

    invoke-virtual {v2, v3, v4}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "\\%21"

    const-string v4, "!"

    invoke-virtual {v2, v3, v4}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "\\%27"

    const-string v4, "\'"

    invoke-virtual {v2, v3, v4}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "\\%28"

    const-string v4, "("

    invoke-virtual {v2, v3, v4}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "\\%29"

    const-string v4, ")"

    invoke-virtual {v2, v3, v4}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "\\%7E"

    const-string v4, "~"

    invoke-virtual {v2, v3, v4}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 272
    .local v1, "result":Ljava/lang/String;
    :goto_0
    return-object v1

    .line 268
    .end local v1    # "result":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 269
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    move-object v1, p1

    .restart local v1    # "result":Ljava/lang/String;
    goto :goto_0
.end method

.method private parseCallbackUrl(Ljava/lang/String;)V
    .locals 12
    .param p1, "urlStr"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/net/MalformedURLException;
        }
    .end annotation

    .prologue
    const/4 v11, 0x2

    const/4 v10, 0x0

    .line 51
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v8

    if-nez v8, :cond_1

    .line 52
    :cond_0
    new-instance v8, Ljava/net/MalformedURLException;

    const-string v9, "url is empty"

    invoke-direct {v8, v9}, Ljava/net/MalformedURLException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 55
    :cond_1
    invoke-virtual {p0, p1}, Ltv/freewheel/ad/handler/EventCallbackHandler;->getExpandedPingbackUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    .line 56
    iput-object p1, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->cachedUrl:Ljava/lang/String;

    .line 58
    new-instance v5, Ljava/net/URL;

    invoke-direct {v5, p1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 61
    .local v5, "url":Ljava/net/URL;
    :try_start_0
    invoke-virtual {v5}, Ljava/net/URL;->getQuery()Ljava/lang/String;

    move-result-object v8

    const-string v9, "&"

    invoke-virtual {v8, v9}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v4

    .line 63
    .local v4, "queryComponents":[Ljava/lang/String;
    const-string v8, "\\?"

    invoke-virtual {p1, v8}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v6

    .line 64
    .local v6, "urlComponents":[Ljava/lang/String;
    const/4 v8, 0x0

    aget-object v8, v6, v8

    iput-object v8, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->baseUrl:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_0

    .line 70
    .end local v6    # "urlComponents":[Ljava/lang/String;
    :goto_0
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    array-length v8, v4

    if-ge v1, v8, :cond_6

    .line 71
    aget-object v8, v4, v1

    const-string v9, "="

    invoke-virtual {v8, v9}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 72
    .local v3, "kvPair":[Ljava/lang/String;
    array-length v8, v3

    if-eqz v8, :cond_2

    array-length v8, v3

    if-gt v8, v11, :cond_2

    aget-object v8, v3, v10

    invoke-virtual {v8}, Ljava/lang/String;->length()I

    move-result v8

    if-nez v8, :cond_3

    .line 73
    :cond_2
    new-instance v8, Ljava/net/MalformedURLException;

    const-string v9, "invalid format in query string"

    invoke-direct {v8, v9}, Ljava/net/MalformedURLException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 65
    .end local v1    # "i":I
    .end local v3    # "kvPair":[Ljava/lang/String;
    .end local v4    # "queryComponents":[Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 66
    .local v0, "e":Ljava/lang/NullPointerException;
    new-array v4, v10, [Ljava/lang/String;

    .line 67
    .restart local v4    # "queryComponents":[Ljava/lang/String;
    iput-object p1, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->baseUrl:Ljava/lang/String;

    goto :goto_0

    .line 76
    .end local v0    # "e":Ljava/lang/NullPointerException;
    .restart local v1    # "i":I
    .restart local v3    # "kvPair":[Ljava/lang/String;
    :cond_3
    aget-object v8, v3, v10

    invoke-static {v8}, Landroid/net/Uri;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 77
    .local v2, "key":Ljava/lang/String;
    const-string v7, ""

    .line 78
    .local v7, "value":Ljava/lang/String;
    array-length v8, v3

    if-ne v8, v11, :cond_4

    .line 79
    const/4 v8, 0x1

    aget-object v8, v3, v8

    invoke-static {v8}, Landroid/net/Uri;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 82
    :cond_4
    const-string v8, "cr"

    invoke-virtual {v2, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_5

    .line 83
    invoke-virtual {v7}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v8

    iput-object v8, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->crValue:Ljava/lang/String;

    .line 70
    :goto_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 87
    :cond_5
    iget-object v8, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->keys:Ljava/util/ArrayList;

    invoke-virtual {v8, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 88
    iget-object v8, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->parameterPairs:Ljava/util/HashMap;

    invoke-virtual {v8, v2, v7}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_2

    .line 90
    .end local v2    # "key":Ljava/lang/String;
    .end local v3    # "kvPair":[Ljava/lang/String;
    .end local v7    # "value":Ljava/lang/String;
    :cond_6
    return-void
.end method


# virtual methods
.method public addExternalTrackingURLs(Ljava/util/ArrayList;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 233
    .local p1, "urls":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    iget-object v0, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " addExternalTrackingURLs "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->info(Ljava/lang/String;)V

    .line 234
    iget-object v0, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->externalTrackingURLs:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->removeAll(Ljava/util/Collection;)Z

    .line 235
    iget-object v0, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->externalTrackingURLs:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 236
    return-void
.end method

.method public getCallbackUrl()Ljava/lang/String;
    .locals 5

    .prologue
    .line 124
    iget-object v3, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->cachedUrl:Ljava/lang/String;

    if-nez v3, :cond_3

    .line 125
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->baseUrl:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "?"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->cachedUrl:Ljava/lang/String;

    .line 127
    iget-object v3, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->keys:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 128
    .local v0, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 129
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 130
    .local v1, "key":Ljava/lang/String;
    iget-object v3, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->parameterPairs:Ljava/util/HashMap;

    invoke-virtual {v3, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 131
    .local v2, "value":Ljava/lang/String;
    invoke-static {v1}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 132
    if-eqz v2, :cond_1

    .line 133
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->cachedUrl:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-static {v2}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->cachedUrl:Ljava/lang/String;

    .line 138
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 139
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->cachedUrl:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "&"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->cachedUrl:Ljava/lang/String;

    goto :goto_0

    .line 135
    :cond_1
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->cachedUrl:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->cachedUrl:Ljava/lang/String;

    goto :goto_1

    .line 144
    .end local v1    # "key":Ljava/lang/String;
    .end local v2    # "value":Ljava/lang/String;
    :cond_2
    iget-object v3, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->crValue:Ljava/lang/String;

    if-eqz v3, :cond_3

    .line 145
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->cachedUrl:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "&cr="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->crValue:Ljava/lang/String;

    invoke-static {v4}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->cachedUrl:Ljava/lang/String;

    .line 149
    .end local v0    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_3
    iget-object v3, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->cachedUrl:Ljava/lang/String;

    return-object v3
.end method

.method protected getExpandedPingbackUrl(Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p1, "originalUrl"    # Ljava/lang/String;

    .prologue
    .line 251
    const-string v1, "#c{comscore.platformname}"

    const-string v2, "android"

    invoke-virtual {p1, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 252
    .local v0, "result":Ljava/lang/String;
    const-string v1, "#ce{comscore.devicename}"

    sget-object v2, Landroid/os/Build;->DEVICE:Ljava/lang/String;

    invoke-direct {p0, v2}, Ltv/freewheel/ad/handler/EventCallbackHandler;->encodeURIComponent(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 253
    iget-object v1, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->logger:Ltv/freewheel/utils/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "getExpandedPingbackUrl():"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 254
    return-object v0
.end method

.method public getExternalTrackingURLs()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 239
    iget-object v0, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->externalTrackingURLs:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getInternalUrl()Ljava/lang/String;
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 153
    iget-object v3, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->internalUrl:Ljava/lang/String;

    if-nez v3, :cond_5

    .line 154
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->baseUrl:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "?"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->internalUrl:Ljava/lang/String;

    .line 156
    iget-object v3, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->originalKeys:Ljava/util/ArrayList;

    const-string v4, "et"

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 157
    iget-object v3, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->originalKeys:Ljava/util/ArrayList;

    const-string v4, "et"

    invoke-virtual {v3, v5, v4}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 159
    :cond_0
    iget-object v3, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->originalKeys:Ljava/util/ArrayList;

    const-string v4, "cn"

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 160
    iget-object v3, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->originalKeys:Ljava/util/ArrayList;

    const-string v4, "cn"

    invoke-virtual {v3, v5, v4}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 162
    :cond_1
    iget-object v3, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->originalParameterPairs:Ljava/util/HashMap;

    const-string v4, "cn"

    const-string v5, "cn"

    invoke-virtual {p0, v5}, Ltv/freewheel/ad/handler/EventCallbackHandler;->getUrlParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 163
    iget-object v3, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->originalParameterPairs:Ljava/util/HashMap;

    const-string v4, "et"

    const-string v5, "et"

    invoke-virtual {p0, v5}, Ltv/freewheel/ad/handler/EventCallbackHandler;->getUrlParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 165
    iget-object v3, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->originalKeys:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 166
    .local v0, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_2
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_4

    .line 167
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 168
    .local v1, "key":Ljava/lang/String;
    iget-object v3, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->originalParameterPairs:Ljava/util/HashMap;

    invoke-virtual {v3, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 170
    .local v2, "value":Ljava/lang/String;
    invoke-static {v1}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 171
    if-eqz v2, :cond_3

    .line 172
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->internalUrl:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-static {v2}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->internalUrl:Ljava/lang/String;

    .line 177
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 178
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->internalUrl:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "&"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->internalUrl:Ljava/lang/String;

    goto :goto_0

    .line 174
    :cond_3
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->internalUrl:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->internalUrl:Ljava/lang/String;

    goto :goto_1

    .line 183
    .end local v1    # "key":Ljava/lang/String;
    .end local v2    # "value":Ljava/lang/String;
    :cond_4
    iget-object v3, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->crValue:Ljava/lang/String;

    if-eqz v3, :cond_5

    .line 184
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->internalUrl:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "&cr="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->crValue:Ljava/lang/String;

    invoke-static {v4}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->internalUrl:Ljava/lang/String;

    .line 188
    .end local v0    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_5
    iget-object v3, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->internalUrl:Ljava/lang/String;

    return-object v3
.end method

.method public getTrackingURLs()Ljava/util/ArrayList;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 226
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 227
    .local v0, "ret":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    iget-object v1, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->callback:Ltv/freewheel/ad/EventCallback;

    iget-object v1, v1, Ltv/freewheel/ad/EventCallback;->trackingURLs:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 228
    iget-object v1, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->externalTrackingURLs:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 229
    return-object v0
.end method

.method public getUrlParameter(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 117
    const-string v0, "cr"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 118
    iget-object v0, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->crValue:Ljava/lang/String;

    .line 120
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->parameterPairs:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    goto :goto_0
.end method

.method public isShowBrowser()Z
    .locals 1

    .prologue
    .line 192
    iget-object v0, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->callback:Ltv/freewheel/ad/EventCallback;

    iget-boolean v0, v0, Ltv/freewheel/ad/EventCallback;->showBrowser:Z

    return v0
.end method

.method public send()V
    .locals 2

    .prologue
    .line 196
    iget-object v0, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->adInstance:Ltv/freewheel/ad/AdInstance;

    if-eqz v0, :cond_0

    iget-object v0, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->adInstance:Ltv/freewheel/ad/AdInstance;

    invoke-virtual {v0}, Ltv/freewheel/ad/AdInstance;->getActiveCreativeRendition()Ltv/freewheel/ad/CreativeRendition;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 197
    const-string v0, "reid"

    iget-object v1, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->adInstance:Ltv/freewheel/ad/AdInstance;

    invoke-virtual {v1}, Ltv/freewheel/ad/AdInstance;->getActiveCreativeRendition()Ltv/freewheel/ad/CreativeRendition;

    move-result-object v1

    iget v1, v1, Ltv/freewheel/ad/CreativeRendition;->creativeRenditionId:I

    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Ltv/freewheel/ad/handler/EventCallbackHandler;->setParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 199
    :cond_0
    invoke-virtual {p0}, Ltv/freewheel/ad/handler/EventCallbackHandler;->getCallbackUrl()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Ltv/freewheel/ad/handler/EventCallbackHandler;->sendRequest(Ljava/lang/String;)V

    .line 200
    return-void
.end method

.method protected sendRequest(Ljava/lang/String;)V
    .locals 3
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 215
    new-instance v1, Ltv/freewheel/utils/URLRequest;

    iget-object v2, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->callback:Ltv/freewheel/ad/EventCallback;

    invoke-virtual {v2}, Ltv/freewheel/ad/EventCallback;->getAdContext()Ltv/freewheel/ad/AdContext;

    move-result-object v2

    invoke-virtual {v2}, Ltv/freewheel/ad/AdContext;->getUserAgent()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, p1, v2}, Ltv/freewheel/utils/URLRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 218
    .local v1, "request":Ltv/freewheel/utils/URLRequest;
    const/4 v2, 0x1

    iput v2, v1, Ltv/freewheel/utils/URLRequest;->method:I

    .line 219
    const-string v2, "text/plain"

    iput-object v2, v1, Ltv/freewheel/utils/URLRequest;->contentType:Ljava/lang/String;

    .line 221
    new-instance v0, Ltv/freewheel/utils/URLLoader;

    invoke-direct {v0}, Ltv/freewheel/utils/URLLoader;-><init>()V

    .line 222
    .local v0, "loader":Ltv/freewheel/utils/URLLoader;
    invoke-virtual {v0, v1}, Ltv/freewheel/utils/URLLoader;->load(Ltv/freewheel/utils/URLRequest;)V

    .line 223
    return-void
.end method

.method public sendTrackingCallback()V
    .locals 5

    .prologue
    .line 203
    iget-object v3, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->logger:Ltv/freewheel/utils/Logger;

    const-string v4, "sendTrackingCallback()"

    invoke-virtual {v3, v4}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 204
    invoke-virtual {p0}, Ltv/freewheel/ad/handler/EventCallbackHandler;->getTrackingURLs()Ljava/util/ArrayList;

    move-result-object v1

    .line 205
    .local v1, "trackingURLs":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-lez v3, :cond_0

    .line 206
    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 207
    .local v0, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 208
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 209
    .local v2, "url":Ljava/lang/String;
    invoke-virtual {p0, v2}, Ltv/freewheel/ad/handler/EventCallbackHandler;->getExpandedPingbackUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v3}, Ltv/freewheel/ad/handler/EventCallbackHandler;->sendRequest(Ljava/lang/String;)V

    goto :goto_0

    .line 212
    .end local v0    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    .end local v2    # "url":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method public setAdInstance(Ltv/freewheel/ad/AdInstance;)V
    .locals 0
    .param p1, "ad"    # Ltv/freewheel/ad/AdInstance;

    .prologue
    .line 247
    iput-object p1, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->adInstance:Ltv/freewheel/ad/AdInstance;

    .line 248
    return-void
.end method

.method public setParameter(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 93
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_1

    .line 114
    :cond_0
    :goto_0
    return-void

    .line 97
    :cond_1
    const-string v0, "cr"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 98
    if-eqz p2, :cond_0

    .line 101
    iput-object p2, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->crValue:Ljava/lang/String;

    .line 102
    iput-object v2, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->cachedUrl:Ljava/lang/String;

    .line 103
    iput-object v2, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->internalUrl:Ljava/lang/String;

    goto :goto_0

    .line 107
    :cond_2
    iget-object v0, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->keys:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 108
    iget-object v0, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->keys:Ljava/util/ArrayList;

    const/4 v1, 0x0

    invoke-virtual {v0, v1, p1}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 110
    :cond_3
    iget-object v0, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->parameterPairs:Ljava/util/HashMap;

    invoke-virtual {v0, p1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 112
    iput-object v2, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->cachedUrl:Ljava/lang/String;

    .line 113
    iput-object v2, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->internalUrl:Ljava/lang/String;

    goto :goto_0
.end method

.method public setShowBrowserValue(Z)V
    .locals 1
    .param p1, "isShowBrowser"    # Z

    .prologue
    .line 243
    iget-object v0, p0, Ltv/freewheel/ad/handler/EventCallbackHandler;->callback:Ltv/freewheel/ad/EventCallback;

    iput-boolean p1, v0, Ltv/freewheel/ad/EventCallback;->showBrowser:Z

    .line 244
    return-void
.end method

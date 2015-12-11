.class public Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
.super Ljava/lang/Object;
.source "EventCallbackHandler.java"


# instance fields
.field protected adInstance:Ltv/freewheel/hybrid/ad/AdInstance;

.field private baseUrl:Ljava/lang/String;

.field private cachedUrl:Ljava/lang/String;

.field private callback:Ltv/freewheel/hybrid/ad/EventCallback;

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

.field protected logger:Ltv/freewheel/hybrid/utils/Logger;

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

.field protected trackingUrlSend:Z


# direct methods
.method public constructor <init>(Ltv/freewheel/hybrid/ad/EventCallback;)V
    .locals 2
    .param p1, "callback"    # Ltv/freewheel/hybrid/ad/EventCallback;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/net/MalformedURLException;
        }
    .end annotation

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    const/4 v0, 0x0

    iput-boolean v0, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->trackingUrlSend:Z

    .line 30
    const/4 v0, 0x0

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->adInstance:Ltv/freewheel/hybrid/ad/AdInstance;

    .line 33
    if-nez p1, :cond_0

    .line 34
    new-instance v0, Ljava/net/MalformedURLException;

    const-string v1, "callback object is null"

    invoke-direct {v0, v1}, Ljava/net/MalformedURLException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 36
    :cond_0
    invoke-static {p0}, Ltv/freewheel/hybrid/utils/Logger;->getLogger(Ljava/lang/Object;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->logger:Ltv/freewheel/hybrid/utils/Logger;

    .line 37
    iput-object p1, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->callback:Ltv/freewheel/hybrid/ad/EventCallback;

    .line 38
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->keys:Ljava/util/ArrayList;

    .line 39
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->originalKeys:Ljava/util/ArrayList;

    .line 40
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->parameterPairs:Ljava/util/HashMap;

    .line 41
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->originalParameterPairs:Ljava/util/HashMap;

    .line 42
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->externalTrackingURLs:Ljava/util/ArrayList;

    .line 44
    iget-object v0, p1, Ltv/freewheel/hybrid/ad/EventCallback;->url:Ljava/lang/String;

    invoke-direct {p0, v0}, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->parseCallbackUrl(Ljava/lang/String;)V

    .line 45
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->originalKeys:Ljava/util/ArrayList;

    iget-object v1, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->keys:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 46
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->originalParameterPairs:Ljava/util/HashMap;

    iget-object v1, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->parameterPairs:Ljava/util/HashMap;

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->putAll(Ljava/util/Map;)V

    .line 47
    return-void
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

    .line 50
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v8

    if-nez v8, :cond_1

    .line 51
    :cond_0
    new-instance v8, Ljava/net/MalformedURLException;

    const-string v9, "url is empty"

    invoke-direct {v8, v9}, Ljava/net/MalformedURLException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 54
    :cond_1
    iput-object p1, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->cachedUrl:Ljava/lang/String;

    .line 56
    new-instance v5, Ljava/net/URL;

    invoke-direct {v5, p1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 59
    .local v5, "url":Ljava/net/URL;
    :try_start_0
    invoke-virtual {v5}, Ljava/net/URL;->getQuery()Ljava/lang/String;

    move-result-object v8

    const-string v9, "&"

    invoke-virtual {v8, v9}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v4

    .line 61
    .local v4, "queryComponents":[Ljava/lang/String;
    const-string v8, "\\?"

    invoke-virtual {p1, v8}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v6

    .line 62
    .local v6, "urlComponents":[Ljava/lang/String;
    const/4 v8, 0x0

    aget-object v8, v6, v8

    iput-object v8, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->baseUrl:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_0

    .line 68
    .end local v6    # "urlComponents":[Ljava/lang/String;
    :goto_0
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    array-length v8, v4

    if-ge v1, v8, :cond_6

    .line 69
    aget-object v8, v4, v1

    const-string v9, "="

    invoke-virtual {v8, v9}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 70
    .local v3, "kvPair":[Ljava/lang/String;
    array-length v8, v3

    if-eqz v8, :cond_2

    array-length v8, v3

    if-gt v8, v11, :cond_2

    aget-object v8, v3, v10

    invoke-virtual {v8}, Ljava/lang/String;->length()I

    move-result v8

    if-nez v8, :cond_3

    .line 71
    :cond_2
    new-instance v8, Ljava/net/MalformedURLException;

    const-string v9, "invalid format in query string"

    invoke-direct {v8, v9}, Ljava/net/MalformedURLException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 63
    .end local v1    # "i":I
    .end local v3    # "kvPair":[Ljava/lang/String;
    .end local v4    # "queryComponents":[Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 64
    .local v0, "e":Ljava/lang/NullPointerException;
    new-array v4, v10, [Ljava/lang/String;

    .line 65
    .restart local v4    # "queryComponents":[Ljava/lang/String;
    iput-object p1, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->baseUrl:Ljava/lang/String;

    goto :goto_0

    .line 74
    .end local v0    # "e":Ljava/lang/NullPointerException;
    .restart local v1    # "i":I
    .restart local v3    # "kvPair":[Ljava/lang/String;
    :cond_3
    aget-object v8, v3, v10

    invoke-static {v8}, Landroid/net/Uri;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 75
    .local v2, "key":Ljava/lang/String;
    const-string v7, ""

    .line 76
    .local v7, "value":Ljava/lang/String;
    array-length v8, v3

    if-ne v8, v11, :cond_4

    .line 77
    const/4 v8, 0x1

    aget-object v8, v3, v8

    invoke-static {v8}, Landroid/net/Uri;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 80
    :cond_4
    const-string v8, "cr"

    invoke-virtual {v2, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_5

    .line 81
    invoke-virtual {v7}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v8

    iput-object v8, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->crValue:Ljava/lang/String;

    .line 68
    :goto_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 85
    :cond_5
    iget-object v8, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->keys:Ljava/util/ArrayList;

    invoke-virtual {v8, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 86
    iget-object v8, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->parameterPairs:Ljava/util/HashMap;

    invoke-virtual {v8, v2, v7}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_2

    .line 88
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
    .line 231
    .local p1, "urls":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->logger:Ltv/freewheel/hybrid/utils/Logger;

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

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->info(Ljava/lang/String;)V

    .line 232
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->externalTrackingURLs:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->removeAll(Ljava/util/Collection;)Z

    .line 233
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->externalTrackingURLs:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 234
    return-void
.end method

.method public getCallbackUrl()Ljava/lang/String;
    .locals 5

    .prologue
    .line 122
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->cachedUrl:Ljava/lang/String;

    if-nez v3, :cond_3

    .line 123
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->baseUrl:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "?"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->cachedUrl:Ljava/lang/String;

    .line 125
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->keys:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 126
    .local v0, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 127
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 128
    .local v1, "key":Ljava/lang/String;
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->parameterPairs:Ljava/util/HashMap;

    invoke-virtual {v3, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 129
    .local v2, "value":Ljava/lang/String;
    invoke-static {v1}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 130
    if-eqz v2, :cond_1

    .line 131
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->cachedUrl:Ljava/lang/String;

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

    iput-object v3, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->cachedUrl:Ljava/lang/String;

    .line 136
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 137
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->cachedUrl:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "&"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->cachedUrl:Ljava/lang/String;

    goto :goto_0

    .line 133
    :cond_1
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->cachedUrl:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->cachedUrl:Ljava/lang/String;

    goto :goto_1

    .line 142
    .end local v1    # "key":Ljava/lang/String;
    .end local v2    # "value":Ljava/lang/String;
    :cond_2
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->crValue:Ljava/lang/String;

    if-eqz v3, :cond_3

    .line 143
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->cachedUrl:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "&cr="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->crValue:Ljava/lang/String;

    invoke-static {v4}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->cachedUrl:Ljava/lang/String;

    .line 147
    .end local v0    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_3
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->cachedUrl:Ljava/lang/String;

    return-object v3
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
    .line 237
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->externalTrackingURLs:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getInternalUrl()Ljava/lang/String;
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 151
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->internalUrl:Ljava/lang/String;

    if-nez v3, :cond_5

    .line 152
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->baseUrl:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "?"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->internalUrl:Ljava/lang/String;

    .line 154
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->originalKeys:Ljava/util/ArrayList;

    const-string v4, "et"

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 155
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->originalKeys:Ljava/util/ArrayList;

    const-string v4, "et"

    invoke-virtual {v3, v5, v4}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 157
    :cond_0
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->originalKeys:Ljava/util/ArrayList;

    const-string v4, "cn"

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 158
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->originalKeys:Ljava/util/ArrayList;

    const-string v4, "cn"

    invoke-virtual {v3, v5, v4}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 160
    :cond_1
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->originalParameterPairs:Ljava/util/HashMap;

    const-string v4, "cn"

    const-string v5, "cn"

    invoke-virtual {p0, v5}, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->getUrlParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 161
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->originalParameterPairs:Ljava/util/HashMap;

    const-string v4, "et"

    const-string v5, "et"

    invoke-virtual {p0, v5}, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->getUrlParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 163
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->originalKeys:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 164
    .local v0, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_2
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_4

    .line 165
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 166
    .local v1, "key":Ljava/lang/String;
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->originalParameterPairs:Ljava/util/HashMap;

    invoke-virtual {v3, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 168
    .local v2, "value":Ljava/lang/String;
    invoke-static {v1}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 169
    if-eqz v2, :cond_3

    .line 170
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->internalUrl:Ljava/lang/String;

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

    iput-object v3, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->internalUrl:Ljava/lang/String;

    .line 175
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 176
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->internalUrl:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "&"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->internalUrl:Ljava/lang/String;

    goto :goto_0

    .line 172
    :cond_3
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->internalUrl:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->internalUrl:Ljava/lang/String;

    goto :goto_1

    .line 181
    .end local v1    # "key":Ljava/lang/String;
    .end local v2    # "value":Ljava/lang/String;
    :cond_4
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->crValue:Ljava/lang/String;

    if-eqz v3, :cond_5

    .line 182
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->internalUrl:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "&cr="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->crValue:Ljava/lang/String;

    invoke-static {v4}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->internalUrl:Ljava/lang/String;

    .line 186
    .end local v0    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_5
    iget-object v3, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->internalUrl:Ljava/lang/String;

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
    .line 224
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 225
    .local v0, "ret":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    iget-object v1, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->callback:Ltv/freewheel/hybrid/ad/EventCallback;

    iget-object v1, v1, Ltv/freewheel/hybrid/ad/EventCallback;->trackingURLs:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 226
    iget-object v1, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->externalTrackingURLs:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 227
    return-object v0
.end method

.method public getUrlParameter(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 115
    const-string v0, "cr"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 116
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->crValue:Ljava/lang/String;

    .line 118
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->parameterPairs:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    goto :goto_0
.end method

.method public isShowBrowser()Z
    .locals 1

    .prologue
    .line 190
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->callback:Ltv/freewheel/hybrid/ad/EventCallback;

    iget-boolean v0, v0, Ltv/freewheel/hybrid/ad/EventCallback;->showBrowser:Z

    return v0
.end method

.method public send()V
    .locals 2

    .prologue
    .line 194
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->adInstance:Ltv/freewheel/hybrid/ad/AdInstance;

    if-eqz v0, :cond_0

    iget-object v0, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->adInstance:Ltv/freewheel/hybrid/ad/AdInstance;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/ad/AdInstance;->getActiveCreativeRendition()Ltv/freewheel/hybrid/ad/CreativeRendition;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 195
    const-string v0, "reid"

    iget-object v1, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->adInstance:Ltv/freewheel/hybrid/ad/AdInstance;

    invoke-virtual {v1}, Ltv/freewheel/hybrid/ad/AdInstance;->getActiveCreativeRendition()Ltv/freewheel/hybrid/ad/CreativeRendition;

    move-result-object v1

    iget v1, v1, Ltv/freewheel/hybrid/ad/CreativeRendition;->creativeRenditionId:I

    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->setParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 197
    :cond_0
    invoke-virtual {p0}, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->getCallbackUrl()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->sendRequest(Ljava/lang/String;)V

    .line 198
    return-void
.end method

.method protected sendRequest(Ljava/lang/String;)V
    .locals 5
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 212
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "will send callback: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->info(Ljava/lang/String;)V

    .line 213
    new-instance v1, Ltv/freewheel/hybrid/utils/URLRequest;

    iget-object v2, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->callback:Ltv/freewheel/hybrid/ad/EventCallback;

    invoke-virtual {v2}, Ltv/freewheel/hybrid/ad/EventCallback;->getAdContext()Ltv/freewheel/hybrid/ad/AdContext;

    move-result-object v2

    invoke-virtual {v2}, Ltv/freewheel/hybrid/ad/AdContext;->getUserAgent()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, p1, v2}, Ltv/freewheel/hybrid/utils/URLRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 216
    .local v1, "request":Ltv/freewheel/hybrid/utils/URLRequest;
    const/4 v2, 0x1

    iput v2, v1, Ltv/freewheel/hybrid/utils/URLRequest;->method:I

    .line 217
    const-string v2, "text/plain"

    iput-object v2, v1, Ltv/freewheel/hybrid/utils/URLRequest;->contentType:Ljava/lang/String;

    .line 219
    new-instance v0, Ltv/freewheel/hybrid/utils/URLLoader;

    invoke-direct {v0}, Ltv/freewheel/hybrid/utils/URLLoader;-><init>()V

    .line 220
    .local v0, "loader":Ltv/freewheel/hybrid/utils/URLLoader;
    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/URLLoader;->load(Ltv/freewheel/hybrid/utils/URLRequest;)V

    .line 221
    return-void
.end method

.method public sendTrackingCallback()V
    .locals 4

    .prologue
    .line 201
    invoke-virtual {p0}, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->getTrackingURLs()Ljava/util/ArrayList;

    move-result-object v1

    .line 202
    .local v1, "trackingURLs":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-lez v3, :cond_0

    .line 203
    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 204
    .local v0, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 205
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 206
    .local v2, "url":Ljava/lang/String;
    invoke-virtual {p0, v2}, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->sendRequest(Ljava/lang/String;)V

    goto :goto_0

    .line 209
    .end local v0    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    .end local v2    # "url":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method public setAdInstance(Ltv/freewheel/hybrid/ad/AdInstance;)V
    .locals 0
    .param p1, "ad"    # Ltv/freewheel/hybrid/ad/AdInstance;

    .prologue
    .line 245
    iput-object p1, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->adInstance:Ltv/freewheel/hybrid/ad/AdInstance;

    .line 246
    return-void
.end method

.method public setParameter(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 91
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_1

    .line 112
    :cond_0
    :goto_0
    return-void

    .line 95
    :cond_1
    const-string v0, "cr"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 96
    if-eqz p2, :cond_0

    .line 99
    iput-object p2, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->crValue:Ljava/lang/String;

    .line 100
    iput-object v2, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->cachedUrl:Ljava/lang/String;

    .line 101
    iput-object v2, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->internalUrl:Ljava/lang/String;

    goto :goto_0

    .line 105
    :cond_2
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->keys:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 106
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->keys:Ljava/util/ArrayList;

    const/4 v1, 0x0

    invoke-virtual {v0, v1, p1}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 108
    :cond_3
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->parameterPairs:Ljava/util/HashMap;

    invoke-virtual {v0, p1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 110
    iput-object v2, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->cachedUrl:Ljava/lang/String;

    .line 111
    iput-object v2, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->internalUrl:Ljava/lang/String;

    goto :goto_0
.end method

.method public setShowBrowserValue(Z)V
    .locals 1
    .param p1, "isShowBrowser"    # Z

    .prologue
    .line 241
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->callback:Ltv/freewheel/hybrid/ad/EventCallback;

    iput-boolean p1, v0, Ltv/freewheel/hybrid/ad/EventCallback;->showBrowser:Z

    .line 242
    return-void
.end method

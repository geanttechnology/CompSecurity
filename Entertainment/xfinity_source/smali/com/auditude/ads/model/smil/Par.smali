.class public Lcom/auditude/ads/model/smil/Par;
.super Lcom/auditude/ads/util/event/EventDispatcher;
.source "Par.java"

# interfaces
.implements Lcom/auditude/ads/util/event/IEventListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/auditude/ads/model/smil/Par$ParResoultionCompleteListener;
    }
.end annotation


# instance fields
.field private enumeratorIndex:I

.field private isResolved:Z

.field private networkAdLoader:Lcom/auditude/ads/network/INetworkAdLoader;

.field private parListener:Lcom/auditude/ads/model/smil/Par$ParResoultionCompleteListener;

.field private priority:I

.field private refList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/model/smil/Ref;",
            ">;"
        }
    .end annotation
.end field

.field private sequence:Lcom/auditude/ads/model/smil/Sequence;

.field private state:Ljava/util/HashMap;
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
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 31
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/auditude/ads/model/smil/Par;-><init>(Lcom/auditude/ads/model/smil/Sequence;)V

    .line 32
    return-void
.end method

.method public constructor <init>(Lcom/auditude/ads/model/smil/Sequence;)V
    .locals 2
    .param p1, "sequence"    # Lcom/auditude/ads/model/smil/Sequence;

    .prologue
    const/4 v1, 0x0

    .line 34
    invoke-direct {p0}, Lcom/auditude/ads/util/event/EventDispatcher;-><init>()V

    .line 21
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/model/smil/Par;->refList:Ljava/util/ArrayList;

    .line 23
    iput v1, p0, Lcom/auditude/ads/model/smil/Par;->priority:I

    .line 24
    iput-boolean v1, p0, Lcom/auditude/ads/model/smil/Par;->isResolved:Z

    .line 27
    const/4 v0, -0x1

    iput v0, p0, Lcom/auditude/ads/model/smil/Par;->enumeratorIndex:I

    .line 36
    iput-object p1, p0, Lcom/auditude/ads/model/smil/Par;->sequence:Lcom/auditude/ads/model/smil/Sequence;

    .line 37
    return-void
.end method

.method private notifyResolutionComplete()V
    .locals 1

    .prologue
    .line 278
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/auditude/ads/model/smil/Par;->isResolved:Z

    .line 280
    iget-object v0, p0, Lcom/auditude/ads/model/smil/Par;->parListener:Lcom/auditude/ads/model/smil/Par$ParResoultionCompleteListener;

    if-eqz v0, :cond_0

    .line 282
    iget-object v0, p0, Lcom/auditude/ads/model/smil/Par;->parListener:Lcom/auditude/ads/model/smil/Par$ParResoultionCompleteListener;

    invoke-interface {v0}, Lcom/auditude/ads/model/smil/Par$ParResoultionCompleteListener;->onParResolutionComplete()V

    .line 284
    :cond_0
    return-void
.end method


# virtual methods
.method public final addRef(Lcom/auditude/ads/model/smil/Ref;)V
    .locals 1
    .param p1, "reff"    # Lcom/auditude/ads/model/smil/Ref;

    .prologue
    .line 89
    if-eqz p1, :cond_0

    .line 91
    invoke-virtual {p1, p0}, Lcom/auditude/ads/model/smil/Ref;->setPar(Lcom/auditude/ads/model/smil/Par;)V

    .line 92
    iget-object v0, p0, Lcom/auditude/ads/model/smil/Par;->refList:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 94
    :cond_0
    return-void
.end method

.method public final addState(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 61
    invoke-static {p1}, Lcom/auditude/ads/util/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-static {p2}, Lcom/auditude/ads/util/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 63
    iget-object v0, p0, Lcom/auditude/ads/model/smil/Par;->state:Ljava/util/HashMap;

    if-nez v0, :cond_0

    .line 65
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/model/smil/Par;->state:Ljava/util/HashMap;

    .line 68
    :cond_0
    iget-object v0, p0, Lcom/auditude/ads/model/smil/Par;->state:Ljava/util/HashMap;

    invoke-virtual {v0, p1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 70
    :cond_1
    return-void
.end method

.method public final getRefList()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/model/smil/Ref;",
            ">;"
        }
    .end annotation

    .prologue
    .line 74
    iget-object v0, p0, Lcom/auditude/ads/model/smil/Par;->refList:Ljava/util/ArrayList;

    return-object v0
.end method

.method public final getSequence()Lcom/auditude/ads/model/smil/Sequence;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/auditude/ads/model/smil/Par;->sequence:Lcom/auditude/ads/model/smil/Sequence;

    return-object v0
.end method

.method public final getState()Ljava/util/HashMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 57
    iget-object v0, p0, Lcom/auditude/ads/model/smil/Par;->state:Ljava/util/HashMap;

    return-object v0
.end method

.method public onEvent(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 12
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "event"    # Ljava/lang/Object;

    .prologue
    .line 205
    const-string v9, "error"

    invoke-virtual {p1, v9}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_1

    .line 207
    instance-of v9, p2, Lcom/auditude/ads/event/AdPluginEvent;

    if-eqz v9, :cond_0

    .line 209
    invoke-virtual {p0, p1, p2}, Lcom/auditude/ads/model/smil/Par;->dispatchEvent(Ljava/lang/String;Ljava/lang/Object;)V

    .line 274
    .end local p2    # "event":Ljava/lang/Object;
    :cond_0
    :goto_0
    return-void

    .line 214
    .restart local p2    # "event":Ljava/lang/Object;
    :cond_1
    const-string v9, "complete"

    invoke-virtual {p1, v9}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_0

    .line 216
    const/4 v0, 0x0

    .line 217
    .local v0, "ad":Lcom/auditude/ads/model/Ad;
    const/4 v2, 0x0

    .line 218
    .local v2, "loader":Lcom/auditude/ads/network/INetworkAdLoader;
    instance-of v9, p2, Lcom/auditude/ads/util/event/Event;

    if-eqz v9, :cond_2

    move-object v9, p2

    check-cast v9, Lcom/auditude/ads/util/event/Event;

    invoke-virtual {v9}, Lcom/auditude/ads/util/event/Event;->getOwner()Lcom/auditude/ads/util/event/IEventDispatcher;

    move-result-object v9

    instance-of v9, v9, Lcom/auditude/ads/network/INetworkAdLoader;

    if-eqz v9, :cond_2

    .line 220
    check-cast p2, Lcom/auditude/ads/util/event/Event;

    .end local p2    # "event":Ljava/lang/Object;
    invoke-virtual {p2}, Lcom/auditude/ads/util/event/Event;->getOwner()Lcom/auditude/ads/util/event/IEventDispatcher;

    move-result-object v2

    .end local v2    # "loader":Lcom/auditude/ads/network/INetworkAdLoader;
    check-cast v2, Lcom/auditude/ads/network/INetworkAdLoader;

    .line 221
    .restart local v2    # "loader":Lcom/auditude/ads/network/INetworkAdLoader;
    invoke-interface {v2}, Lcom/auditude/ads/network/INetworkAdLoader;->getAd()Lcom/auditude/ads/model/Ad;

    move-result-object v0

    .line 224
    :cond_2
    if-eqz v0, :cond_3

    .line 226
    new-instance v9, Ljava/util/ArrayList;

    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    iput-object v9, p0, Lcom/auditude/ads/model/smil/Par;->refList:Ljava/util/ArrayList;

    .line 227
    invoke-interface {v2}, Lcom/auditude/ads/network/INetworkAdLoader;->getResult()Ljava/lang/Object;

    move-result-object v4

    .line 228
    .local v4, "result":Ljava/lang/Object;
    if-eqz v4, :cond_9

    instance-of v9, v4, Ljava/util/ArrayList;

    if-eqz v9, :cond_9

    move-object v6, v4

    .line 231
    check-cast v6, Ljava/util/ArrayList;

    .line 232
    .local v6, "segments":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/ArrayList<Lcom/auditude/ads/model/Asset;>;>;"
    invoke-virtual {v6}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v10

    :goto_1
    invoke-interface {v10}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-nez v9, :cond_4

    .line 273
    .end local v4    # "result":Ljava/lang/Object;
    .end local v6    # "segments":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/ArrayList<Lcom/auditude/ads/model/Asset;>;>;"
    :cond_3
    :goto_2
    invoke-direct {p0}, Lcom/auditude/ads/model/smil/Par;->notifyResolutionComplete()V

    goto :goto_0

    .line 232
    .restart local v4    # "result":Ljava/lang/Object;
    .restart local v6    # "segments":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/ArrayList<Lcom/auditude/ads/model/Asset;>;>;"
    :cond_4
    invoke-interface {v10}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/ArrayList;

    .line 234
    .local v5, "segment":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/model/Asset;>;"
    new-instance v3, Lcom/auditude/ads/model/smil/Ref;

    invoke-direct {v3, p0}, Lcom/auditude/ads/model/smil/Ref;-><init>(Lcom/auditude/ads/model/smil/Par;)V

    .line 235
    .local v3, "reff":Lcom/auditude/ads/model/smil/Ref;
    invoke-virtual {v3, v0}, Lcom/auditude/ads/model/smil/Ref;->setAd(Lcom/auditude/ads/model/Ad;)V

    .line 237
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    .line 238
    .local v7, "temp":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/model/Asset;>;"
    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v9

    if-lez v9, :cond_6

    .line 240
    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :cond_5
    :goto_3
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-nez v11, :cond_7

    .line 259
    :cond_6
    const/4 v9, 0x0

    new-array v9, v9, [Lcom/auditude/ads/model/Asset;

    invoke-virtual {v7, v9}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v9

    check-cast v9, [Lcom/auditude/ads/model/Asset;

    invoke-virtual {v3, v9}, Lcom/auditude/ads/model/smil/Ref;->setAssets([Lcom/auditude/ads/model/Asset;)V

    .line 260
    invoke-virtual {p0, v3}, Lcom/auditude/ads/model/smil/Par;->addRef(Lcom/auditude/ads/model/smil/Ref;)V

    goto :goto_1

    .line 240
    :cond_7
    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/auditude/ads/model/Asset;

    .line 242
    .local v1, "asset":Lcom/auditude/ads/model/Asset;
    invoke-virtual {v1}, Lcom/auditude/ads/model/Asset;->getType()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v0, v11}, Lcom/auditude/ads/model/Ad;->getTrackingAssetByType(Ljava/lang/String;)Lcom/auditude/ads/model/Asset;

    move-result-object v8

    .line 243
    .local v8, "trackingAsset":Lcom/auditude/ads/model/Asset;
    if-eqz v8, :cond_8

    .line 245
    invoke-virtual {v8}, Lcom/auditude/ads/model/Asset;->Reset()V

    .line 246
    invoke-virtual {v8, v1}, Lcom/auditude/ads/model/Asset;->CopyTo(Lcom/auditude/ads/model/Asset;)V

    .line 249
    :cond_8
    invoke-virtual {v7, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 252
    instance-of v11, v1, Lcom/auditude/ads/model/OnPageAsset;

    if-eqz v11, :cond_5

    .line 254
    invoke-static {v7, v1}, Lcom/auditude/ads/model/Ad;->consolidateOnPageAsset(Ljava/util/ArrayList;Lcom/auditude/ads/model/Asset;)V

    goto :goto_3

    .line 266
    .end local v1    # "asset":Lcom/auditude/ads/model/Asset;
    .end local v3    # "reff":Lcom/auditude/ads/model/smil/Ref;
    .end local v5    # "segment":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/model/Asset;>;"
    .end local v6    # "segments":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/ArrayList<Lcom/auditude/ads/model/Asset;>;>;"
    .end local v7    # "temp":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/model/Asset;>;"
    .end local v8    # "trackingAsset":Lcom/auditude/ads/model/Asset;
    :cond_9
    new-instance v3, Lcom/auditude/ads/model/smil/Ref;

    invoke-direct {v3, p0}, Lcom/auditude/ads/model/smil/Ref;-><init>(Lcom/auditude/ads/model/smil/Par;)V

    .line 267
    .restart local v3    # "reff":Lcom/auditude/ads/model/smil/Ref;
    invoke-virtual {v3, v0}, Lcom/auditude/ads/model/smil/Ref;->setAd(Lcom/auditude/ads/model/Ad;)V

    .line 268
    const/4 v9, 0x0

    invoke-virtual {v3, v9}, Lcom/auditude/ads/model/smil/Ref;->setAssets([Lcom/auditude/ads/model/Asset;)V

    .line 269
    invoke-virtual {p0, v3}, Lcom/auditude/ads/model/smil/Par;->addRef(Lcom/auditude/ads/model/smil/Ref;)V

    goto :goto_2
.end method

.method public final resolve(Ljava/util/HashMap;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 161
    .local p1, "customParams":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    iget-boolean v2, p0, Lcom/auditude/ads/model/smil/Par;->isResolved:Z

    if-eqz v2, :cond_0

    .line 163
    invoke-direct {p0}, Lcom/auditude/ads/model/smil/Par;->notifyResolutionComplete()V

    .line 201
    :goto_0
    return-void

    .line 167
    :cond_0
    iget-object v2, p0, Lcom/auditude/ads/model/smil/Par;->refList:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-lez v2, :cond_3

    .line 169
    iget-object v2, p0, Lcom/auditude/ads/model/smil/Par;->refList:Ljava/util/ArrayList;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/auditude/ads/model/smil/Ref;

    .line 170
    .local v1, "adRef":Lcom/auditude/ads/model/smil/Ref;
    invoke-virtual {v1}, Lcom/auditude/ads/model/smil/Ref;->getAd()Lcom/auditude/ads/model/Ad;

    move-result-object v0

    .line 172
    .local v0, "ad":Lcom/auditude/ads/model/Ad;
    if-eqz v0, :cond_2

    invoke-virtual {v0}, Lcom/auditude/ads/model/Ad;->getIsNetworkAd()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 175
    invoke-virtual {v0}, Lcom/auditude/ads/model/Ad;->getNetworkAdType()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/auditude/ads/network/NetworkAdLoaderFactory;->getLoaderForType(Ljava/lang/String;)Lcom/auditude/ads/network/INetworkAdLoader;

    move-result-object v2

    iput-object v2, p0, Lcom/auditude/ads/model/smil/Par;->networkAdLoader:Lcom/auditude/ads/network/INetworkAdLoader;

    .line 177
    iget-object v2, p0, Lcom/auditude/ads/model/smil/Par;->networkAdLoader:Lcom/auditude/ads/network/INetworkAdLoader;

    if-eqz v2, :cond_1

    .line 179
    iget-object v2, p0, Lcom/auditude/ads/model/smil/Par;->networkAdLoader:Lcom/auditude/ads/network/INetworkAdLoader;

    const-string v3, "error"

    invoke-interface {v2, v3, p0}, Lcom/auditude/ads/network/INetworkAdLoader;->addEventListener(Ljava/lang/String;Lcom/auditude/ads/util/event/IEventListener;)V

    .line 180
    iget-object v2, p0, Lcom/auditude/ads/model/smil/Par;->networkAdLoader:Lcom/auditude/ads/network/INetworkAdLoader;

    const-string v3, "complete"

    invoke-interface {v2, v3, p0}, Lcom/auditude/ads/network/INetworkAdLoader;->addEventListener(Ljava/lang/String;Lcom/auditude/ads/util/event/IEventListener;)V

    .line 181
    iget-object v2, p0, Lcom/auditude/ads/model/smil/Par;->networkAdLoader:Lcom/auditude/ads/network/INetworkAdLoader;

    invoke-interface {v2, p1}, Lcom/auditude/ads/network/INetworkAdLoader;->setCustomParams(Ljava/util/HashMap;)V

    .line 182
    iget-object v2, p0, Lcom/auditude/ads/model/smil/Par;->networkAdLoader:Lcom/auditude/ads/network/INetworkAdLoader;

    invoke-virtual {v0}, Lcom/auditude/ads/model/Ad;->getNetworkAdSource()Ljava/lang/Object;

    move-result-object v3

    invoke-interface {v2, v3}, Lcom/auditude/ads/network/INetworkAdLoader;->setSource(Ljava/lang/Object;)V

    .line 183
    iget-object v2, p0, Lcom/auditude/ads/model/smil/Par;->networkAdLoader:Lcom/auditude/ads/network/INetworkAdLoader;

    invoke-interface {v2, v0}, Lcom/auditude/ads/network/INetworkAdLoader;->setAd(Lcom/auditude/ads/model/Ad;)V

    .line 184
    iget-object v2, p0, Lcom/auditude/ads/model/smil/Par;->networkAdLoader:Lcom/auditude/ads/network/INetworkAdLoader;

    invoke-interface {v2}, Lcom/auditude/ads/network/INetworkAdLoader;->load()V

    goto :goto_0

    .line 188
    :cond_1
    invoke-direct {p0}, Lcom/auditude/ads/model/smil/Par;->notifyResolutionComplete()V

    goto :goto_0

    .line 193
    :cond_2
    invoke-direct {p0}, Lcom/auditude/ads/model/smil/Par;->notifyResolutionComplete()V

    goto :goto_0

    .line 199
    .end local v0    # "ad":Lcom/auditude/ads/model/Ad;
    .end local v1    # "adRef":Lcom/auditude/ads/model/smil/Ref;
    :cond_3
    invoke-direct {p0}, Lcom/auditude/ads/model/smil/Par;->notifyResolutionComplete()V

    goto :goto_0
.end method

.method public setParResolutionCompleteListener(Lcom/auditude/ads/model/smil/Par$ParResoultionCompleteListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/auditude/ads/model/smil/Par$ParResoultionCompleteListener;

    .prologue
    .line 46
    iput-object p1, p0, Lcom/auditude/ads/model/smil/Par;->parListener:Lcom/auditude/ads/model/smil/Par$ParResoultionCompleteListener;

    .line 47
    return-void
.end method

.method public final setPriority(I)V
    .locals 0
    .param p1, "value"    # I

    .prologue
    .line 55
    iput p1, p0, Lcom/auditude/ads/model/smil/Par;->priority:I

    return-void
.end method

.method public setSequence(Lcom/auditude/ads/model/smil/Sequence;)V
    .locals 0
    .param p1, "sequence"    # Lcom/auditude/ads/model/smil/Sequence;

    .prologue
    .line 51
    iput-object p1, p0, Lcom/auditude/ads/model/smil/Par;->sequence:Lcom/auditude/ads/model/smil/Sequence;

    return-void
.end method

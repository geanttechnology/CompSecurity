.class public Lcom/auditude/ads/network/vast/model/VASTAd;
.super Ljava/lang/Object;
.source "VASTAd.java"

# interfaces
.implements Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager$VastAssetRepackagingCompletionListener;


# instance fields
.field private fallbackOnInvalidCreative:Ljava/lang/Boolean;

.field private fallbackOnNoAd:Ljava/lang/Boolean;

.field private id:Ljava/lang/String;

.field private inlineAds:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/network/vast/model/VASTInlineAd;",
            ">;"
        }
    .end annotation
.end field

.field private isFromVmapDoc:Ljava/lang/Boolean;

.field private repackageCount:I

.field private repackageTotal:I

.field private repackagingListener:Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager$VastAssetRepackagingCompletionListener;

.field private sequence:I

.field private vastDocument:Lcom/auditude/ads/network/vast/model/VASTDocument;

.field private wrapperAd:Lcom/auditude/ads/network/vast/model/VASTWrapperAd;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/Boolean;)V
    .locals 2
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "fallbackOnInvalidCreative"    # Ljava/lang/Boolean;

    .prologue
    const/4 v1, 0x0

    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    const/4 v0, -0x1

    iput v0, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->sequence:I

    .line 16
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->fallbackOnNoAd:Ljava/lang/Boolean;

    .line 17
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->fallbackOnInvalidCreative:Ljava/lang/Boolean;

    .line 19
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->isFromVmapDoc:Ljava/lang/Boolean;

    .line 20
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->repackagingListener:Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager$VastAssetRepackagingCompletionListener;

    .line 21
    iput v1, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->repackageCount:I

    .line 22
    iput v1, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->repackageTotal:I

    .line 26
    iput-object p1, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->id:Ljava/lang/String;

    .line 27
    iput-object p2, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->fallbackOnInvalidCreative:Ljava/lang/Boolean;

    .line 28
    return-void
.end method


# virtual methods
.method public final addInlineAds(Lcom/auditude/ads/network/vast/model/VASTInlineAd;)V
    .locals 1
    .param p1, "value"    # Lcom/auditude/ads/network/vast/model/VASTInlineAd;

    .prologue
    .line 41
    if-eqz p1, :cond_1

    .line 43
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->inlineAds:Ljava/util/ArrayList;

    if-nez v0, :cond_0

    .line 45
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->inlineAds:Ljava/util/ArrayList;

    .line 47
    :cond_0
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->inlineAds:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 49
    :cond_1
    return-void
.end method

.method public final getDocument()Lcom/auditude/ads/network/vast/model/VASTDocument;
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->vastDocument:Lcom/auditude/ads/network/vast/model/VASTDocument;

    return-object v0
.end method

.method public final getFallbackOnInvalidCreative()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->fallbackOnInvalidCreative:Ljava/lang/Boolean;

    return-object v0
.end method

.method public final getFallbackOnNoAd()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->fallbackOnNoAd:Ljava/lang/Boolean;

    return-object v0
.end method

.method public final getID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->id:Ljava/lang/String;

    return-object v0
.end method

.method public final getInlineAds()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/network/vast/model/VASTInlineAd;",
            ">;"
        }
    .end annotation

    .prologue
    .line 37
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->inlineAds:Ljava/util/ArrayList;

    return-object v0
.end method

.method public final getIsFromVmapDoc()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 109
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->isFromVmapDoc:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getRootAdId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 167
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->vastDocument:Lcom/auditude/ads/network/vast/model/VASTDocument;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->vastDocument:Lcom/auditude/ads/network/vast/model/VASTDocument;

    iget-object v0, v0, Lcom/auditude/ads/network/vast/model/VASTDocument;->parentAd:Lcom/auditude/ads/network/vast/model/VASTAd;

    if-eqz v0, :cond_0

    .line 169
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->vastDocument:Lcom/auditude/ads/network/vast/model/VASTDocument;

    iget-object v0, v0, Lcom/auditude/ads/network/vast/model/VASTDocument;->parentAd:Lcom/auditude/ads/network/vast/model/VASTAd;

    invoke-virtual {v0}, Lcom/auditude/ads/network/vast/model/VASTAd;->getRootAdId()Ljava/lang/String;

    move-result-object v0

    .line 171
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->id:Ljava/lang/String;

    goto :goto_0
.end method

.method public final getSequence()I
    .locals 1

    .prologue
    .line 77
    iget v0, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->sequence:I

    return v0
.end method

.method public final getWrapperAd()Lcom/auditude/ads/network/vast/model/VASTWrapperAd;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->wrapperAd:Lcom/auditude/ads/network/vast/model/VASTWrapperAd;

    return-object v0
.end method

.method public final hasAssetsWithMimeType(Ljava/util/ArrayList;)Ljava/lang/Boolean;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/lang/Boolean;"
        }
    .end annotation

    .prologue
    .line 114
    .local p1, "mimeTypes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    iget-object v1, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->inlineAds:Ljava/util/ArrayList;

    if-eqz v1, :cond_1

    .line 116
    iget-object v1, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->inlineAds:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_2

    .line 124
    :cond_1
    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    :goto_0
    return-object v1

    .line 116
    :cond_2
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/auditude/ads/network/vast/model/VASTInlineAd;

    .line 118
    .local v0, "inlineAd":Lcom/auditude/ads/network/vast/model/VASTInlineAd;
    iget-object v2, v0, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    if-eqz v2, :cond_0

    iget-object v2, v0, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    invoke-virtual {v2, p1}, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->hasAssetsWithMimeType(Ljava/util/ArrayList;)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 120
    const/4 v1, 0x1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    goto :goto_0
.end method

.method public onRepackagingComplete(Lcom/auditude/ads/network/vast/model/VASTLinearCreative;Z)V
    .locals 2
    .param p1, "asset"    # Lcom/auditude/ads/network/vast/model/VASTLinearCreative;
    .param p2, "success"    # Z

    .prologue
    .line 158
    iget v0, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->repackageCount:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->repackageCount:I

    .line 159
    iget v0, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->repackageCount:I

    iget v1, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->repackageTotal:I

    if-lt v0, v1, :cond_0

    .line 161
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->repackagingListener:Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager$VastAssetRepackagingCompletionListener;

    const/4 v1, 0x0

    invoke-interface {v0, p1, v1}, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager$VastAssetRepackagingCompletionListener;->onRepackagingComplete(Lcom/auditude/ads/network/vast/model/VASTLinearCreative;Z)V

    .line 163
    :cond_0
    return-void
.end method

.method public final repackageIncompatibleCreatives(Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager$VastAssetRepackagingCompletionListener;Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;)V
    .locals 7
    .param p1, "repackagingListener"    # Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager$VastAssetRepackagingCompletionListener;
    .param p2, "vastAssetRepackagerInfo"    # Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;

    .prologue
    const/4 v6, 0x0

    .line 129
    iput-object p1, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->repackagingListener:Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager$VastAssetRepackagingCompletionListener;

    .line 130
    iput v6, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->repackageCount:I

    .line 131
    iput v6, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->repackageTotal:I

    .line 133
    iget-object v3, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->inlineAds:Ljava/util/ArrayList;

    if-eqz v3, :cond_1

    .line 135
    iget-object v3, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->inlineAds:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-nez v4, :cond_3

    .line 150
    :cond_1
    iget v3, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->repackageTotal:I

    if-nez v3, :cond_2

    .line 152
    const/4 v3, 0x0

    invoke-interface {p1, v3, v6}, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager$VastAssetRepackagingCompletionListener;->onRepackagingComplete(Lcom/auditude/ads/network/vast/model/VASTLinearCreative;Z)V

    .line 154
    :cond_2
    return-void

    .line 135
    :cond_3
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/auditude/ads/network/vast/model/VASTInlineAd;

    .line 137
    .local v0, "inlineAd":Lcom/auditude/ads/network/vast/model/VASTInlineAd;
    if-eqz v0, :cond_0

    .line 139
    iget-object v4, v0, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    invoke-virtual {v4}, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->getBestMediaFile()Lcom/auditude/ads/network/vast/model/VASTMediaFile;

    move-result-object v1

    .line 140
    .local v1, "mediaFile":Lcom/auditude/ads/network/vast/model/VASTMediaFile;
    if-eqz v1, :cond_0

    iget-object v4, v1, Lcom/auditude/ads/network/vast/model/VASTMediaFile;->type:Ljava/lang/String;

    invoke-virtual {v4}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p2, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;->requiredFormat:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 142
    iget v4, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->repackageTotal:I

    add-int/lit8 v4, v4, 0x1

    iput v4, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->repackageTotal:I

    .line 143
    new-instance v2, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager;

    iget-object v4, v0, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    invoke-virtual {p0}, Lcom/auditude/ads/network/vast/model/VASTAd;->getRootAdId()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v2, p0, v4, v5, p2}, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager;-><init>(Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager$VastAssetRepackagingCompletionListener;Lcom/auditude/ads/network/vast/model/VASTLinearCreative;Ljava/lang/String;Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;)V

    .line 144
    .local v2, "repackager":Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager;
    invoke-virtual {v2}, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager;->repackage()V

    goto :goto_0
.end method

.method public final setDocument(Lcom/auditude/ads/network/vast/model/VASTDocument;)V
    .locals 0
    .param p1, "value"    # Lcom/auditude/ads/network/vast/model/VASTDocument;

    .prologue
    .line 96
    iput-object p1, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->vastDocument:Lcom/auditude/ads/network/vast/model/VASTDocument;

    .line 97
    return-void
.end method

.method public final setFallbackOnNoAd(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/Boolean;

    .prologue
    .line 82
    iput-object p1, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->fallbackOnNoAd:Ljava/lang/Boolean;

    .line 83
    return-void
.end method

.method public final setIsFromVmapDoc(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/Boolean;

    .prologue
    .line 105
    iput-object p1, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->isFromVmapDoc:Ljava/lang/Boolean;

    .line 106
    return-void
.end method

.method public final setSequence(I)V
    .locals 0
    .param p1, "value"    # I

    .prologue
    .line 73
    iput p1, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->sequence:I

    .line 74
    return-void
.end method

.method public final setWrapperAd(Lcom/auditude/ads/network/vast/model/VASTWrapperAd;)V
    .locals 2
    .param p1, "value"    # Lcom/auditude/ads/network/vast/model/VASTWrapperAd;

    .prologue
    .line 57
    iput-object p1, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->wrapperAd:Lcom/auditude/ads/network/vast/model/VASTWrapperAd;

    .line 58
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->wrapperAd:Lcom/auditude/ads/network/vast/model/VASTWrapperAd;

    if-eqz v0, :cond_0

    .line 60
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->wrapperAd:Lcom/auditude/ads/network/vast/model/VASTWrapperAd;

    iget-object v0, v0, Lcom/auditude/ads/network/vast/model/VASTWrapperAd;->fallbackOnNoAd:Ljava/lang/String;

    if-nez v0, :cond_1

    .line 62
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->fallbackOnInvalidCreative:Ljava/lang/Boolean;

    iput-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->fallbackOnNoAd:Ljava/lang/Boolean;

    .line 69
    :cond_0
    :goto_0
    return-void

    .line 66
    :cond_1
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->wrapperAd:Lcom/auditude/ads/network/vast/model/VASTWrapperAd;

    iget-object v0, v0, Lcom/auditude/ads/network/vast/model/VASTWrapperAd;->fallbackOnNoAd:Ljava/lang/String;

    const-string v1, "true"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTAd;->fallbackOnNoAd:Ljava/lang/Boolean;

    goto :goto_0
.end method

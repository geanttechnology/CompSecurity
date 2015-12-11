.class public Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;
.super Lcom/auditude/ads/util/event/EventDispatcher;
.source "VASTDocumentProcessor.java"

# interfaces
.implements Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager$VastAssetRepackagingCompletionListener;
.implements Lcom/auditude/ads/util/event/IEventListener;


# instance fields
.field private document:Lcom/auditude/ads/network/vast/model/VASTDocument;

.field private error:Ljava/lang/Throwable;

.field private fallbackOnInvalidCreative:Ljava/lang/Boolean;

.field private maxNumWrapperRedirects:I

.field private mimeTypes:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private numLoadsToComplete:I

.field private repackagingCount:I

.field vastAssetRepackagerInfo:Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;

.field private wrapperDocument:Lcom/auditude/ads/network/vast/model/VASTDocument;


# direct methods
.method public constructor <init>(ILjava/util/ArrayList;Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;Ljava/lang/Boolean;)V
    .locals 3
    .param p1, "maxNumWrapperRedirects"    # I
    .param p3, "vastAssetRepackagerInfo"    # Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;
    .param p4, "fallbackOnInvalidCreative"    # Ljava/lang/Boolean;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;",
            "Ljava/lang/Boolean;",
            ")V"
        }
    .end annotation

    .prologue
    .local p2, "mimeTypes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 43
    invoke-direct {p0}, Lcom/auditude/ads/util/event/EventDispatcher;-><init>()V

    .line 29
    iput v1, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->numLoadsToComplete:I

    .line 30
    const/4 v0, 0x6

    iput v0, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->maxNumWrapperRedirects:I

    .line 32
    iput-object v2, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->mimeTypes:Ljava/util/ArrayList;

    .line 33
    iput-object v2, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->vastAssetRepackagerInfo:Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;

    .line 35
    iput v1, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->repackagingCount:I

    .line 36
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->fallbackOnInvalidCreative:Ljava/lang/Boolean;

    .line 45
    iput p1, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->maxNumWrapperRedirects:I

    .line 46
    iput-object p2, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->mimeTypes:Ljava/util/ArrayList;

    .line 47
    iput-object p3, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->vastAssetRepackagerInfo:Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;

    .line 48
    iput-object p4, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->fallbackOnInvalidCreative:Ljava/lang/Boolean;

    .line 49
    return-void
.end method

.method private checkCompletion(Lcom/auditude/ads/network/vast/model/VASTDocument;)V
    .locals 1
    .param p1, "vastDocument"    # Lcom/auditude/ads/network/vast/model/VASTDocument;

    .prologue
    .line 265
    iget v0, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->numLoadsToComplete:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->numLoadsToComplete:I

    .line 267
    iget v0, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->numLoadsToComplete:I

    if-gtz v0, :cond_0

    .line 269
    invoke-direct {p0}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->repackageIncompatibleCreatives()V

    .line 271
    :cond_0
    return-void
.end method

.method private checkForFallbackAds()Ljava/lang/Boolean;
    .locals 10

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 311
    iget-object v5, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->vastAssetRepackagerInfo:Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;

    iget-object v5, v5, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;->repackaginEnabled:Ljava/lang/Boolean;

    invoke-virtual {v5}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 313
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    iput-object v5, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->mimeTypes:Ljava/util/ArrayList;

    .line 314
    iget-object v5, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->mimeTypes:Ljava/util/ArrayList;

    iget-object v8, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->vastAssetRepackagerInfo:Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;

    iget-object v8, v8, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;->requiredFormat:Ljava/lang/String;

    invoke-virtual {v5, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 317
    :cond_0
    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    .line 318
    .local v0, "done":Ljava/lang/Boolean;
    iget-object v5, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->wrapperDocument:Lcom/auditude/ads/network/vast/model/VASTDocument;

    if-eqz v5, :cond_2

    iget-object v5, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->wrapperDocument:Lcom/auditude/ads/network/vast/model/VASTDocument;

    invoke-virtual {v5}, Lcom/auditude/ads/network/vast/model/VASTDocument;->getAds()Ljava/util/ArrayList;

    move-result-object v5

    if-eqz v5, :cond_2

    iget-object v5, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->wrapperDocument:Lcom/auditude/ads/network/vast/model/VASTDocument;

    invoke-virtual {v5}, Lcom/auditude/ads/network/vast/model/VASTDocument;->getAds()Ljava/util/ArrayList;

    move-result-object v5

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v5

    if-lez v5, :cond_2

    .line 320
    iget-object v5, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->wrapperDocument:Lcom/auditude/ads/network/vast/model/VASTDocument;

    invoke-virtual {v5}, Lcom/auditude/ads/network/vast/model/VASTDocument;->getAds()Ljava/util/ArrayList;

    move-result-object v5

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :cond_1
    :goto_0
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-nez v5, :cond_3

    :cond_2
    move-object v5, v0

    .line 354
    :goto_1
    return-object v5

    .line 320
    :cond_3
    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/auditude/ads/network/vast/model/VASTAd;

    .line 322
    .local v4, "vastAd":Lcom/auditude/ads/network/vast/model/VASTAd;
    iget-object v5, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->mimeTypes:Ljava/util/ArrayList;

    if-eqz v5, :cond_7

    iget-object v5, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->mimeTypes:Ljava/util/ArrayList;

    invoke-virtual {v4, v5}, Lcom/auditude/ads/network/vast/model/VASTAd;->hasAssetsWithMimeType(Ljava/util/ArrayList;)Ljava/lang/Boolean;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v5

    if-nez v5, :cond_7

    move v5, v6

    :goto_2
    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    .line 323
    .local v2, "isValidMimeType":Ljava/lang/Boolean;
    invoke-virtual {v4}, Lcom/auditude/ads/network/vast/model/VASTAd;->getFallbackOnNoAd()Ljava/lang/Boolean;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v5

    if-eqz v5, :cond_4

    invoke-virtual {v4}, Lcom/auditude/ads/network/vast/model/VASTAd;->getInlineAds()Ljava/util/ArrayList;

    move-result-object v5

    if-eqz v5, :cond_4

    invoke-virtual {v4}, Lcom/auditude/ads/network/vast/model/VASTAd;->getInlineAds()Ljava/util/ArrayList;

    move-result-object v5

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v5

    if-gtz v5, :cond_1

    .line 325
    :cond_4
    invoke-virtual {v4}, Lcom/auditude/ads/network/vast/model/VASTAd;->getDocument()Lcom/auditude/ads/network/vast/model/VASTDocument;

    move-result-object v5

    invoke-virtual {v5}, Lcom/auditude/ads/network/vast/model/VASTDocument;->getNextUnusedAd()Lcom/auditude/ads/network/vast/model/VASTAd;

    move-result-object v3

    .line 326
    .local v3, "unusedAd":Lcom/auditude/ads/network/vast/model/VASTAd;
    if-eqz v3, :cond_9

    iget-object v5, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->mimeTypes:Ljava/util/ArrayList;

    invoke-virtual {v3, v5}, Lcom/auditude/ads/network/vast/model/VASTAd;->hasAssetsWithMimeType(Ljava/util/ArrayList;)Ljava/lang/Boolean;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v5

    if-nez v5, :cond_5

    invoke-virtual {v3}, Lcom/auditude/ads/network/vast/model/VASTAd;->getWrapperAd()Lcom/auditude/ads/network/vast/model/VASTWrapperAd;

    move-result-object v5

    if-nez v5, :cond_5

    invoke-virtual {v4}, Lcom/auditude/ads/network/vast/model/VASTAd;->getFallbackOnInvalidCreative()Ljava/lang/Boolean;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v5

    if-eqz v5, :cond_9

    .line 329
    :cond_5
    invoke-virtual {v4}, Lcom/auditude/ads/network/vast/model/VASTAd;->getInlineAds()Ljava/util/ArrayList;

    move-result-object v5

    if-eqz v5, :cond_6

    invoke-virtual {v4}, Lcom/auditude/ads/network/vast/model/VASTAd;->getInlineAds()Ljava/util/ArrayList;

    move-result-object v5

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v5

    if-lez v5, :cond_6

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v5

    if-nez v5, :cond_6

    .line 331
    invoke-virtual {v4}, Lcom/auditude/ads/network/vast/model/VASTAd;->getInlineAds()Ljava/util/ArrayList;

    move-result-object v5

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_3
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-nez v9, :cond_8

    .line 338
    :cond_6
    iget-object v5, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->wrapperDocument:Lcom/auditude/ads/network/vast/model/VASTDocument;

    invoke-virtual {v5, v4, v3}, Lcom/auditude/ads/network/vast/model/VASTDocument;->replaceAd(Lcom/auditude/ads/network/vast/model/VASTAd;Lcom/auditude/ads/network/vast/model/VASTAd;)V

    .line 339
    invoke-direct {p0, v3}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->shouldLoadVASTWrapper(Lcom/auditude/ads/network/vast/model/VASTAd;)Ljava/lang/Boolean;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 341
    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    .line 342
    invoke-direct {p0, v3}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->loadVASTWrapper(Lcom/auditude/ads/network/vast/model/VASTAd;)V

    .line 343
    invoke-virtual {v3}, Lcom/auditude/ads/network/vast/model/VASTAd;->getDocument()Lcom/auditude/ads/network/vast/model/VASTDocument;

    move-result-object v5

    invoke-direct {p0, v5}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->getNumVASTWrappers(Lcom/auditude/ads/network/vast/model/VASTDocument;)I

    move-result v5

    iput v5, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->numLoadsToComplete:I

    goto/16 :goto_0

    .end local v2    # "isValidMimeType":Ljava/lang/Boolean;
    .end local v3    # "unusedAd":Lcom/auditude/ads/network/vast/model/VASTAd;
    :cond_7
    move v5, v7

    .line 322
    goto/16 :goto_2

    .line 331
    .restart local v2    # "isValidMimeType":Ljava/lang/Boolean;
    .restart local v3    # "unusedAd":Lcom/auditude/ads/network/vast/model/VASTAd;
    :cond_8
    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/auditude/ads/network/vast/model/VASTInlineAd;

    .line 333
    .local v1, "inlineAd":Lcom/auditude/ads/network/vast/model/VASTInlineAd;
    const/16 v9, 0x193

    invoke-direct {p0, v1, v9}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->logVastError(Lcom/auditude/ads/network/vast/model/VASTInlineAd;I)V

    goto :goto_3

    .line 347
    .end local v1    # "inlineAd":Lcom/auditude/ads/network/vast/model/VASTInlineAd;
    :cond_9
    if-eqz v3, :cond_1

    .line 349
    invoke-direct {p0}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->checkForFallbackAds()Ljava/lang/Boolean;

    move-result-object v5

    goto/16 :goto_1
.end method

.method private getNumVASTWrappers(Lcom/auditude/ads/network/vast/model/VASTDocument;)I
    .locals 5
    .param p1, "vastDocument"    # Lcom/auditude/ads/network/vast/model/VASTDocument;

    .prologue
    .line 165
    const/4 v2, 0x0

    .line 167
    .local v2, "count":I
    invoke-virtual {p1}, Lcom/auditude/ads/network/vast/model/VASTDocument;->getAds()Ljava/util/ArrayList;

    move-result-object v1

    .line 168
    .local v1, "ads":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/network/vast/model/VASTAd;>;"
    if-eqz v1, :cond_1

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-lez v3, :cond_1

    .line 170
    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-nez v4, :cond_2

    .line 179
    :cond_1
    return v2

    .line 170
    :cond_2
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/auditude/ads/network/vast/model/VASTAd;

    .line 172
    .local v0, "ad":Lcom/auditude/ads/network/vast/model/VASTAd;
    invoke-direct {p0, v0}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->shouldLoadVASTWrapper(Lcom/auditude/ads/network/vast/model/VASTAd;)Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 174
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method private loadVASTWrapper(Lcom/auditude/ads/network/vast/model/VASTAd;)V
    .locals 5
    .param p1, "ad"    # Lcom/auditude/ads/network/vast/model/VASTAd;

    .prologue
    .line 202
    new-instance v0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;

    const/4 v1, -0x1

    iget v2, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->maxNumWrapperRedirects:I

    add-int/lit8 v2, v2, -0x1

    invoke-static {v1, v2}, Ljava/lang/Math;->max(II)I

    move-result v1

    iget-object v2, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->mimeTypes:Ljava/util/ArrayList;

    iget-object v3, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->vastAssetRepackagerInfo:Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;

    iget-object v4, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->fallbackOnInvalidCreative:Ljava/lang/Boolean;

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;-><init>(ILjava/util/ArrayList;Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;Ljava/lang/Boolean;)V

    .line 203
    .local v0, "wrapperLoader":Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;
    iput-object p1, v0, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->State:Ljava/lang/Object;

    .line 206
    const-string v1, "complete"

    invoke-virtual {v0, v1, p0}, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->addEventListener(Ljava/lang/String;Lcom/auditude/ads/util/event/IEventListener;)V

    .line 207
    const-string v1, "failed"

    invoke-virtual {v0, v1, p0}, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->addEventListener(Ljava/lang/String;Lcom/auditude/ads/util/event/IEventListener;)V

    .line 208
    invoke-virtual {p1}, Lcom/auditude/ads/network/vast/model/VASTAd;->getWrapperAd()Lcom/auditude/ads/network/vast/model/VASTWrapperAd;

    move-result-object v1

    iget-object v1, v1, Lcom/auditude/ads/network/vast/model/VASTWrapperAd;->source:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->init(Ljava/lang/Object;)V

    .line 209
    return-void
.end method

.method private loadVASTWrappers(Lcom/auditude/ads/network/vast/model/VASTDocument;)V
    .locals 4
    .param p1, "vastDocument"    # Lcom/auditude/ads/network/vast/model/VASTDocument;

    .prologue
    .line 185
    invoke-direct {p0, p1}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->getNumVASTWrappers(Lcom/auditude/ads/network/vast/model/VASTDocument;)I

    move-result v2

    iput v2, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->numLoadsToComplete:I

    .line 187
    invoke-virtual {p1}, Lcom/auditude/ads/network/vast/model/VASTDocument;->getAds()Ljava/util/ArrayList;

    move-result-object v1

    .line 188
    .local v1, "ads":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/network/vast/model/VASTAd;>;"
    if-eqz v1, :cond_1

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-lez v2, :cond_1

    .line 190
    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-nez v3, :cond_2

    .line 198
    :cond_1
    return-void

    .line 190
    :cond_2
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/auditude/ads/network/vast/model/VASTAd;

    .line 192
    .local v0, "ad":Lcom/auditude/ads/network/vast/model/VASTAd;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/auditude/ads/network/vast/model/VASTAd;->getWrapperAd()Lcom/auditude/ads/network/vast/model/VASTWrapperAd;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 194
    invoke-direct {p0, v0}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->loadVASTWrapper(Lcom/auditude/ads/network/vast/model/VASTAd;)V

    goto :goto_0
.end method

.method private logVastError(Lcom/auditude/ads/network/vast/model/VASTInlineAd;I)V
    .locals 4
    .param p1, "inlineAd"    # Lcom/auditude/ads/network/vast/model/VASTInlineAd;
    .param p2, "errorCode"    # I

    .prologue
    .line 437
    if-eqz p1, :cond_0

    iget-object v1, p1, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->errorUrl:Ljava/lang/String;

    if-eqz v1, :cond_0

    iget-object v1, p1, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->errorUrl:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_0

    .line 439
    iget-object v1, p1, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->errorUrl:Ljava/lang/String;

    const-string v2, "\\[ERRORCODE\\]"

    invoke-static {p2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 440
    .local v0, "url":Ljava/lang/String;
    const-string v1, "%5BERRORCODE%5D"

    invoke-static {p2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 441
    invoke-static {v0}, Lcom/auditude/ads/util/AuditudeUtil;->substituteTags(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 442
    invoke-static {v0}, Lcom/auditude/ads/util/PingUtil;->pingUrl(Ljava/lang/String;)V

    .line 444
    .end local v0    # "url":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method private mergeAd(Lcom/auditude/ads/network/vast/model/VASTInlineAd;Lcom/auditude/ads/network/vast/model/VASTWrapperAd;)V
    .locals 8
    .param p1, "inlineAd"    # Lcom/auditude/ads/network/vast/model/VASTInlineAd;
    .param p2, "wrapperAd"    # Lcom/auditude/ads/network/vast/model/VASTWrapperAd;

    .prologue
    .line 399
    if-nez p2, :cond_1

    .line 433
    :cond_0
    return-void

    .line 402
    :cond_1
    invoke-virtual {p2}, Lcom/auditude/ads/network/vast/model/VASTWrapperAd;->getImpressionUrls()Ljava/util/ArrayList;

    move-result-object v6

    if-eqz v6, :cond_2

    .line 404
    invoke-virtual {p2}, Lcom/auditude/ads/network/vast/model/VASTWrapperAd;->getImpressionUrls()Ljava/util/ArrayList;

    move-result-object v6

    invoke-virtual {v6}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :goto_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-nez v7, :cond_4

    .line 411
    :cond_2
    iget-object v6, p2, Lcom/auditude/ads/network/vast/model/VASTWrapperAd;->linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    if-eqz v6, :cond_3

    iget-object v6, p2, Lcom/auditude/ads/network/vast/model/VASTWrapperAd;->linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    invoke-virtual {v6}, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->getTrackingEvents()Ljava/util/ArrayList;

    move-result-object v6

    if-eqz v6, :cond_3

    iget-object v6, p1, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    if-eqz v6, :cond_3

    .line 413
    iget-object v6, p2, Lcom/auditude/ads/network/vast/model/VASTWrapperAd;->linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    invoke-virtual {v6}, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->getTrackingEvents()Ljava/util/ArrayList;

    move-result-object v6

    invoke-virtual {v6}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :goto_1
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-nez v7, :cond_5

    .line 420
    :cond_3
    iget-object v6, p2, Lcom/auditude/ads/network/vast/model/VASTWrapperAd;->linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    if-eqz v6, :cond_0

    iget-object v6, p2, Lcom/auditude/ads/network/vast/model/VASTWrapperAd;->linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    iget-object v6, v6, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->click:Lcom/auditude/ads/network/vast/model/VASTClick;

    if-eqz v6, :cond_0

    iget-object v6, p1, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    if-eqz v6, :cond_0

    .line 422
    iget-object v6, p2, Lcom/auditude/ads/network/vast/model/VASTWrapperAd;->linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    iget-object v5, v6, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->click:Lcom/auditude/ads/network/vast/model/VASTClick;

    .line 423
    .local v5, "wrapperClick":Lcom/auditude/ads/network/vast/model/VASTClick;
    iget-object v6, p1, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    iget-object v2, v6, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->click:Lcom/auditude/ads/network/vast/model/VASTClick;

    .line 424
    .local v2, "inlineClick":Lcom/auditude/ads/network/vast/model/VASTClick;
    invoke-virtual {v5}, Lcom/auditude/ads/network/vast/model/VASTClick;->getTrackingUrls()Ljava/util/ArrayList;

    move-result-object v0

    .line 425
    .local v0, "clickTrackingUrls":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    if-eqz v0, :cond_0

    if-eqz v2, :cond_0

    .line 427
    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :goto_2
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_0

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 429
    .local v4, "trackingUrl":Ljava/lang/String;
    invoke-virtual {v2, v4}, Lcom/auditude/ads/network/vast/model/VASTClick;->addClickTrackingUrl(Ljava/lang/String;)V

    goto :goto_2

    .line 404
    .end local v0    # "clickTrackingUrls":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    .end local v2    # "inlineClick":Lcom/auditude/ads/network/vast/model/VASTClick;
    .end local v4    # "trackingUrl":Ljava/lang/String;
    .end local v5    # "wrapperClick":Lcom/auditude/ads/network/vast/model/VASTClick;
    :cond_4
    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;

    .line 406
    .local v1, "impression":Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;
    invoke-virtual {p1, v1}, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->addImpressionUrl(Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;)V

    goto :goto_0

    .line 413
    .end local v1    # "impression":Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;
    :cond_5
    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;

    .line 415
    .local v3, "trackingEvent":Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;
    iget-object v7, p1, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    invoke-virtual {v7, v3}, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->addTrackingEvent(Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;)V

    goto :goto_1
.end method

.method private mergeAds(Lcom/auditude/ads/network/vast/model/VASTAd;Lcom/auditude/ads/network/vast/model/VASTDocument;)V
    .locals 5
    .param p1, "rootAd"    # Lcom/auditude/ads/network/vast/model/VASTAd;
    .param p2, "nestedDocument"    # Lcom/auditude/ads/network/vast/model/VASTDocument;

    .prologue
    .line 364
    if-nez p2, :cond_0

    .line 395
    :goto_0
    return-void

    .line 372
    :cond_0
    if-eqz p1, :cond_1

    invoke-virtual {p1}, Lcom/auditude/ads/network/vast/model/VASTAd;->getDocument()Lcom/auditude/ads/network/vast/model/VASTDocument;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 374
    invoke-virtual {p1}, Lcom/auditude/ads/network/vast/model/VASTAd;->getDocument()Lcom/auditude/ads/network/vast/model/VASTDocument;

    move-result-object v2

    iget-boolean v3, p2, Lcom/auditude/ads/network/vast/model/VASTDocument;->reachedMaxWrapper:Z

    iput-boolean v3, v2, Lcom/auditude/ads/network/vast/model/VASTDocument;->reachedMaxWrapper:Z

    .line 376
    :cond_1
    invoke-virtual {p2}, Lcom/auditude/ads/network/vast/model/VASTDocument;->getAds()Ljava/util/ArrayList;

    move-result-object v2

    if-eqz v2, :cond_3

    invoke-virtual {p2}, Lcom/auditude/ads/network/vast/model/VASTDocument;->getAds()Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-lez v2, :cond_3

    .line 378
    invoke-virtual {p2}, Lcom/auditude/ads/network/vast/model/VASTDocument;->getAds()Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_2
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-nez v3, :cond_4

    .line 394
    :cond_3
    const/4 v2, 0x0

    invoke-virtual {p1, v2}, Lcom/auditude/ads/network/vast/model/VASTAd;->setWrapperAd(Lcom/auditude/ads/network/vast/model/VASTWrapperAd;)V

    goto :goto_0

    .line 378
    :cond_4
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/auditude/ads/network/vast/model/VASTAd;

    .line 380
    .local v1, "nestedAd":Lcom/auditude/ads/network/vast/model/VASTAd;
    if-eqz v1, :cond_2

    invoke-virtual {v1}, Lcom/auditude/ads/network/vast/model/VASTAd;->getInlineAds()Ljava/util/ArrayList;

    move-result-object v3

    if-eqz v3, :cond_2

    .line 382
    invoke-virtual {v1}, Lcom/auditude/ads/network/vast/model/VASTAd;->getInlineAds()Ljava/util/ArrayList;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/auditude/ads/network/vast/model/VASTInlineAd;

    .line 384
    .local v0, "inlineAd":Lcom/auditude/ads/network/vast/model/VASTInlineAd;
    invoke-virtual {p1}, Lcom/auditude/ads/network/vast/model/VASTAd;->getWrapperAd()Lcom/auditude/ads/network/vast/model/VASTWrapperAd;

    move-result-object v4

    invoke-direct {p0, v0, v4}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->mergeAd(Lcom/auditude/ads/network/vast/model/VASTInlineAd;Lcom/auditude/ads/network/vast/model/VASTWrapperAd;)V

    .line 385
    invoke-virtual {p1, v0}, Lcom/auditude/ads/network/vast/model/VASTAd;->addInlineAds(Lcom/auditude/ads/network/vast/model/VASTInlineAd;)V

    goto :goto_1
.end method

.method private onWrapperLoadComplete(Ljava/lang/Object;)V
    .locals 5
    .param p1, "sender"    # Ljava/lang/Object;

    .prologue
    const/4 v3, 0x0

    .line 225
    instance-of v4, p1, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;

    if-eqz v4, :cond_4

    move-object v2, p1

    :goto_0
    check-cast v2, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;

    .line 226
    .local v2, "wrapperLoader":Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;
    const-string v4, "complete"

    invoke-virtual {v2, v4, p0}, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->removeEventListener(Ljava/lang/String;Lcom/auditude/ads/util/event/IEventListener;)V

    .line 227
    const-string v4, "failed"

    invoke-virtual {v2, v4, p0}, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->removeEventListener(Ljava/lang/String;Lcom/auditude/ads/util/event/IEventListener;)V

    .line 229
    iget-object v0, v2, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->State:Ljava/lang/Object;

    check-cast v0, Lcom/auditude/ads/network/vast/model/VASTAd;

    .line 230
    .local v0, "ad":Lcom/auditude/ads/network/vast/model/VASTAd;
    const/4 v1, 0x0

    .line 231
    .local v1, "wrapperAd":Lcom/auditude/ads/network/vast/model/VASTWrapperAd;
    if-eqz v0, :cond_0

    .line 234
    invoke-virtual {v0}, Lcom/auditude/ads/network/vast/model/VASTAd;->getWrapperAd()Lcom/auditude/ads/network/vast/model/VASTWrapperAd;

    move-result-object v1

    .line 237
    :cond_0
    iget-object v4, v2, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->State:Ljava/lang/Object;

    instance-of v4, v4, Lcom/auditude/ads/network/vast/model/VASTAd;

    if-eqz v4, :cond_1

    iget-object v3, v2, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->State:Ljava/lang/Object;

    :cond_1
    check-cast v3, Lcom/auditude/ads/network/vast/model/VASTAd;

    invoke-virtual {v2}, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->getDocument()Lcom/auditude/ads/network/vast/model/VASTDocument;

    move-result-object v4

    invoke-direct {p0, v3, v4}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->mergeAds(Lcom/auditude/ads/network/vast/model/VASTAd;Lcom/auditude/ads/network/vast/model/VASTDocument;)V

    .line 238
    iget-object v3, v2, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->State:Ljava/lang/Object;

    if-eqz v3, :cond_3

    iget-object v3, v2, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->State:Ljava/lang/Object;

    instance-of v3, v3, Lcom/auditude/ads/network/vast/model/VASTAd;

    if-eqz v3, :cond_3

    .line 240
    invoke-virtual {v0}, Lcom/auditude/ads/network/vast/model/VASTAd;->getInlineAds()Ljava/util/ArrayList;

    move-result-object v3

    if-eqz v3, :cond_2

    invoke-virtual {v0}, Lcom/auditude/ads/network/vast/model/VASTAd;->getInlineAds()Ljava/util/ArrayList;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-nez v3, :cond_3

    .line 242
    :cond_2
    const/16 v3, 0x12f

    invoke-direct {p0, v1, v3}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->logVastError(Lcom/auditude/ads/network/vast/model/VASTInlineAd;I)V

    .line 245
    :cond_3
    invoke-virtual {v0}, Lcom/auditude/ads/network/vast/model/VASTAd;->getDocument()Lcom/auditude/ads/network/vast/model/VASTDocument;

    move-result-object v3

    invoke-direct {p0, v3}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->checkCompletion(Lcom/auditude/ads/network/vast/model/VASTDocument;)V

    .line 246
    return-void

    .end local v0    # "ad":Lcom/auditude/ads/network/vast/model/VASTAd;
    .end local v1    # "wrapperAd":Lcom/auditude/ads/network/vast/model/VASTWrapperAd;
    .end local v2    # "wrapperLoader":Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;
    :cond_4
    move-object v2, v3

    .line 225
    goto :goto_0
.end method

.method private onWrapperLoadFailed(Ljava/lang/Object;)V
    .locals 5
    .param p1, "sender"    # Ljava/lang/Object;

    .prologue
    const/4 v2, 0x0

    .line 250
    instance-of v3, p1, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;

    if-eqz v3, :cond_1

    move-object v1, p1

    :goto_0
    check-cast v1, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;

    .line 251
    .local v1, "wrapperLoader":Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;
    const-string v3, "complete"

    invoke-virtual {v1, v3, p0}, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->removeEventListener(Ljava/lang/String;Lcom/auditude/ads/util/event/IEventListener;)V

    .line 252
    const-string v3, "failed"

    invoke-virtual {v1, v3, p0}, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->removeEventListener(Ljava/lang/String;Lcom/auditude/ads/util/event/IEventListener;)V

    .line 254
    iget-object v3, v1, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->State:Ljava/lang/Object;

    if-eqz v3, :cond_0

    iget-object v3, v1, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->State:Ljava/lang/Object;

    instance-of v3, v3, Lcom/auditude/ads/network/vast/model/VASTAd;

    if-eqz v3, :cond_0

    .line 256
    iget-object v0, v1, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->State:Ljava/lang/Object;

    check-cast v0, Lcom/auditude/ads/network/vast/model/VASTAd;

    .line 257
    .local v0, "ad":Lcom/auditude/ads/network/vast/model/VASTAd;
    invoke-virtual {v0}, Lcom/auditude/ads/network/vast/model/VASTAd;->getWrapperAd()Lcom/auditude/ads/network/vast/model/VASTWrapperAd;

    move-result-object v3

    const/16 v4, 0x12d

    invoke-direct {p0, v3, v4}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->logVastError(Lcom/auditude/ads/network/vast/model/VASTInlineAd;I)V

    .line 260
    .end local v0    # "ad":Lcom/auditude/ads/network/vast/model/VASTAd;
    :cond_0
    invoke-direct {p0, v2}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->checkCompletion(Lcom/auditude/ads/network/vast/model/VASTDocument;)V

    .line 261
    return-void

    .end local v1    # "wrapperLoader":Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;
    :cond_1
    move-object v1, v2

    .line 250
    goto :goto_0
.end method

.method private repackageIncompatibleCreatives()V
    .locals 3

    .prologue
    .line 278
    const/4 v1, 0x0

    iput v1, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->repackagingCount:I

    .line 279
    iget-object v1, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->vastAssetRepackagerInfo:Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;

    iget-object v1, v1, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;->repackaginEnabled:Ljava/lang/Boolean;

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->wrapperDocument:Lcom/auditude/ads/network/vast/model/VASTDocument;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->wrapperDocument:Lcom/auditude/ads/network/vast/model/VASTDocument;

    invoke-virtual {v1}, Lcom/auditude/ads/network/vast/model/VASTDocument;->getAds()Ljava/util/ArrayList;

    move-result-object v1

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->wrapperDocument:Lcom/auditude/ads/network/vast/model/VASTDocument;

    invoke-virtual {v1}, Lcom/auditude/ads/network/vast/model/VASTDocument;->getAds()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-lez v1, :cond_2

    .line 281
    iget-object v1, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->wrapperDocument:Lcom/auditude/ads/network/vast/model/VASTDocument;

    invoke-virtual {v1}, Lcom/auditude/ads/network/vast/model/VASTDocument;->getAds()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_1

    .line 291
    :cond_0
    :goto_1
    return-void

    .line 281
    :cond_1
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/auditude/ads/network/vast/model/VASTAd;

    .line 283
    .local v0, "vastAd":Lcom/auditude/ads/network/vast/model/VASTAd;
    iget-object v2, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->vastAssetRepackagerInfo:Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;

    invoke-virtual {v0, p0, v2}, Lcom/auditude/ads/network/vast/model/VASTAd;->repackageIncompatibleCreatives(Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager$VastAssetRepackagingCompletionListener;Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;)V

    goto :goto_0

    .line 286
    .end local v0    # "vastAd":Lcom/auditude/ads/network/vast/model/VASTAd;
    :cond_2
    invoke-direct {p0}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->checkForFallbackAds()Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 288
    iget-object v1, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->wrapperDocument:Lcom/auditude/ads/network/vast/model/VASTDocument;

    iput-object v1, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->document:Lcom/auditude/ads/network/vast/model/VASTDocument;

    .line 289
    const-string v1, "processComplete"

    new-instance v2, Lcom/auditude/ads/util/event/Event;

    invoke-direct {v2, p0}, Lcom/auditude/ads/util/event/Event;-><init>(Lcom/auditude/ads/util/event/IEventDispatcher;)V

    invoke-virtual {p0, v1, v2}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->dispatchEvent(Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_1
.end method

.method private shouldLoadVASTWrapper(Lcom/auditude/ads/network/vast/model/VASTAd;)Ljava/lang/Boolean;
    .locals 2
    .param p1, "ad"    # Lcom/auditude/ads/network/vast/model/VASTAd;

    .prologue
    .line 359
    if-eqz p1, :cond_1

    invoke-virtual {p1}, Lcom/auditude/ads/network/vast/model/VASTAd;->getWrapperAd()Lcom/auditude/ads/network/vast/model/VASTWrapperAd;

    move-result-object v0

    if-eqz v0, :cond_1

    iget v0, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->maxNumWrapperRedirects:I

    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    iget v0, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->maxNumWrapperRedirects:I

    if-lez v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_1
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    goto :goto_0
.end method


# virtual methods
.method public final getDocument()Lcom/auditude/ads/network/vast/model/VASTDocument;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->document:Lcom/auditude/ads/network/vast/model/VASTDocument;

    return-object v0
.end method

.method public onEvent(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 1
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "event"    # Ljava/lang/Object;

    .prologue
    .line 213
    const-string v0, "complete"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 215
    check-cast p2, Lcom/auditude/ads/util/event/Event;

    .end local p2    # "event":Ljava/lang/Object;
    invoke-virtual {p2}, Lcom/auditude/ads/util/event/Event;->getOwner()Lcom/auditude/ads/util/event/IEventDispatcher;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->onWrapperLoadComplete(Ljava/lang/Object;)V

    .line 221
    :cond_0
    :goto_0
    return-void

    .line 217
    .restart local p2    # "event":Ljava/lang/Object;
    :cond_1
    const-string v0, "failed"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 219
    check-cast p2, Lcom/auditude/ads/util/event/Event;

    .end local p2    # "event":Ljava/lang/Object;
    invoke-virtual {p2}, Lcom/auditude/ads/util/event/Event;->getOwner()Lcom/auditude/ads/util/event/IEventDispatcher;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->onWrapperLoadFailed(Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public onRepackagingComplete(Lcom/auditude/ads/network/vast/model/VASTLinearCreative;Z)V
    .locals 2
    .param p1, "asset"    # Lcom/auditude/ads/network/vast/model/VASTLinearCreative;
    .param p2, "success"    # Z

    .prologue
    .line 295
    iget v0, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->repackagingCount:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->repackagingCount:I

    .line 296
    iget v0, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->repackagingCount:I

    iget-object v1, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->wrapperDocument:Lcom/auditude/ads/network/vast/model/VASTDocument;

    invoke-virtual {v1}, Lcom/auditude/ads/network/vast/model/VASTDocument;->getAds()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-lt v0, v1, :cond_0

    .line 298
    invoke-direct {p0}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->checkForFallbackAds()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 300
    iget-object v0, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->wrapperDocument:Lcom/auditude/ads/network/vast/model/VASTDocument;

    iput-object v0, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->document:Lcom/auditude/ads/network/vast/model/VASTDocument;

    .line 301
    const-string v0, "processComplete"

    new-instance v1, Lcom/auditude/ads/util/event/Event;

    invoke-direct {v1, p0}, Lcom/auditude/ads/util/event/Event;-><init>(Lcom/auditude/ads/util/event/IEventDispatcher;)V

    invoke-virtual {p0, v0, v1}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->dispatchEvent(Ljava/lang/String;Ljava/lang/Object;)V

    .line 304
    :cond_0
    return-void
.end method

.method public final process(Lcom/auditude/ads/network/vast/model/VASTDocument;)V
    .locals 4
    .param p1, "vastDocument"    # Lcom/auditude/ads/network/vast/model/VASTDocument;

    .prologue
    .line 129
    if-eqz p1, :cond_3

    .line 131
    invoke-direct {p0, p1}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->getNumVASTWrappers(Lcom/auditude/ads/network/vast/model/VASTDocument;)I

    move-result v0

    .line 133
    .local v0, "numWrappers":I
    if-lez v0, :cond_0

    .line 135
    iput-object p1, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->wrapperDocument:Lcom/auditude/ads/network/vast/model/VASTDocument;

    .line 136
    iget-object v2, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->wrapperDocument:Lcom/auditude/ads/network/vast/model/VASTDocument;

    invoke-direct {p0, v2}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->loadVASTWrappers(Lcom/auditude/ads/network/vast/model/VASTDocument;)V

    .line 161
    .end local v0    # "numWrappers":I
    :goto_0
    return-void

    .line 141
    .restart local v0    # "numWrappers":I
    :cond_0
    iget-object v2, p1, Lcom/auditude/ads/network/vast/model/VASTDocument;->parentAd:Lcom/auditude/ads/network/vast/model/VASTAd;

    if-eqz v2, :cond_2

    iget-object v2, p1, Lcom/auditude/ads/network/vast/model/VASTDocument;->parentAd:Lcom/auditude/ads/network/vast/model/VASTAd;

    invoke-virtual {v2}, Lcom/auditude/ads/network/vast/model/VASTAd;->getIsFromVmapDoc()Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->fallbackOnInvalidCreative:Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 143
    invoke-virtual {p1}, Lcom/auditude/ads/network/vast/model/VASTDocument;->getAds()Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-nez v3, :cond_1

    .line 147
    iput-object p1, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->wrapperDocument:Lcom/auditude/ads/network/vast/model/VASTDocument;

    .line 148
    invoke-direct {p0}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->repackageIncompatibleCreatives()V

    goto :goto_0

    .line 143
    :cond_1
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/auditude/ads/network/vast/model/VASTAd;

    .line 145
    .local v1, "vAd":Lcom/auditude/ads/network/vast/model/VASTAd;
    const/4 v3, 0x1

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/auditude/ads/network/vast/model/VASTAd;->setFallbackOnNoAd(Ljava/lang/Boolean;)V

    goto :goto_1

    .line 152
    .end local v1    # "vAd":Lcom/auditude/ads/network/vast/model/VASTAd;
    :cond_2
    iput-object p1, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->document:Lcom/auditude/ads/network/vast/model/VASTDocument;

    .line 153
    const-string v2, "processComplete"

    new-instance v3, Lcom/auditude/ads/util/event/Event;

    invoke-direct {v3, p0}, Lcom/auditude/ads/util/event/Event;-><init>(Lcom/auditude/ads/util/event/IEventDispatcher;)V

    invoke-virtual {p0, v2, v3}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->dispatchEvent(Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_0

    .line 159
    .end local v0    # "numWrappers":I
    :cond_3
    const-string v2, "processFailed"

    new-instance v3, Lcom/auditude/ads/util/event/Event;

    invoke-direct {v3, p0}, Lcom/auditude/ads/util/event/Event;-><init>(Lcom/auditude/ads/util/event/IEventDispatcher;)V

    invoke-virtual {p0, v2, v3}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->dispatchEvent(Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public final process(Ljava/lang/String;Lcom/auditude/ads/network/vast/model/VASTAd;)V
    .locals 11
    .param p1, "response"    # Ljava/lang/String;
    .param p2, "parentAd"    # Lcom/auditude/ads/network/vast/model/VASTAd;

    .prologue
    const/4 v10, 0x1

    .line 57
    const/4 v4, 0x0

    .line 58
    .local v4, "processingFailed":Z
    const/4 v6, 0x0

    .line 60
    .local v6, "vastDocument":Lcom/auditude/ads/network/vast/model/VASTDocument;
    new-instance v3, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;

    invoke-direct {v3}, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;-><init>()V

    .line 61
    .local v3, "parser":Lcom/auditude/ads/network/vast/loader/VASTXMLParser;
    iput-object p2, v3, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parentAd:Lcom/auditude/ads/network/vast/model/VASTAd;

    .line 65
    :try_start_0
    invoke-virtual {v3, p1}, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parse(Ljava/lang/String;)Lcom/auditude/ads/network/vast/model/VASTDocument;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v6

    .line 76
    :goto_0
    if-eqz v6, :cond_6

    .line 78
    invoke-direct {p0, v6}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->getNumVASTWrappers(Lcom/auditude/ads/network/vast/model/VASTDocument;)I

    move-result v2

    .line 80
    .local v2, "numWrappers":I
    if-lez v2, :cond_2

    .line 82
    iput-object v6, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->wrapperDocument:Lcom/auditude/ads/network/vast/model/VASTDocument;

    .line 83
    iget-object v7, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->wrapperDocument:Lcom/auditude/ads/network/vast/model/VASTDocument;

    invoke-direct {p0, v7}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->loadVASTWrappers(Lcom/auditude/ads/network/vast/model/VASTDocument;)V

    .line 121
    .end local v2    # "numWrappers":I
    :cond_0
    :goto_1
    if-eqz v4, :cond_1

    .line 123
    const-string v7, "processFailed"

    new-instance v8, Lcom/auditude/ads/util/event/Event;

    invoke-direct {v8, p0}, Lcom/auditude/ads/util/event/Event;-><init>(Lcom/auditude/ads/util/event/IEventDispatcher;)V

    invoke-virtual {p0, v7, v8}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->dispatchEvent(Ljava/lang/String;Ljava/lang/Object;)V

    .line 125
    :cond_1
    return-void

    .line 67
    :catch_0
    move-exception v1

    .line 69
    .local v1, "e":Ljava/io/IOException;
    iput-object v1, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->error:Ljava/lang/Throwable;

    goto :goto_0

    .line 71
    .end local v1    # "e":Ljava/io/IOException;
    :catch_1
    move-exception v1

    .line 73
    .local v1, "e":Lorg/xmlpull/v1/XmlPullParserException;
    iput-object v1, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->error:Ljava/lang/Throwable;

    goto :goto_0

    .line 88
    .end local v1    # "e":Lorg/xmlpull/v1/XmlPullParserException;
    .restart local v2    # "numWrappers":I
    :cond_2
    if-eqz p2, :cond_5

    invoke-virtual {p2}, Lcom/auditude/ads/network/vast/model/VASTAd;->getIsFromVmapDoc()Ljava/lang/Boolean;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v7

    if-eqz v7, :cond_5

    iget-object v7, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->fallbackOnInvalidCreative:Ljava/lang/Boolean;

    invoke-virtual {v7}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v7

    if-eqz v7, :cond_5

    .line 90
    invoke-virtual {v6}, Lcom/auditude/ads/network/vast/model/VASTDocument;->getAds()Ljava/util/ArrayList;

    move-result-object v7

    invoke-virtual {v7}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :goto_2
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-nez v8, :cond_4

    .line 94
    iput-object v6, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->wrapperDocument:Lcom/auditude/ads/network/vast/model/VASTDocument;

    .line 95
    invoke-direct {p0}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->repackageIncompatibleCreatives()V

    .line 103
    :goto_3
    iget-object v7, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->document:Lcom/auditude/ads/network/vast/model/VASTDocument;

    if-eqz v7, :cond_0

    iget-object v7, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->document:Lcom/auditude/ads/network/vast/model/VASTDocument;

    invoke-virtual {v7}, Lcom/auditude/ads/network/vast/model/VASTDocument;->getAds()Ljava/util/ArrayList;

    move-result-object v7

    if-eqz v7, :cond_0

    iget-object v7, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->document:Lcom/auditude/ads/network/vast/model/VASTDocument;

    invoke-virtual {v7}, Lcom/auditude/ads/network/vast/model/VASTDocument;->getAds()Ljava/util/ArrayList;

    move-result-object v7

    invoke-virtual {v7}, Ljava/util/ArrayList;->size()I

    move-result v7

    if-lez v7, :cond_0

    .line 105
    iget-object v7, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->document:Lcom/auditude/ads/network/vast/model/VASTDocument;

    invoke-virtual {v7}, Lcom/auditude/ads/network/vast/model/VASTDocument;->getAds()Ljava/util/ArrayList;

    move-result-object v7

    invoke-virtual {v7}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :cond_3
    :goto_4
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_0

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/auditude/ads/network/vast/model/VASTAd;

    .line 107
    .local v0, "ad":Lcom/auditude/ads/network/vast/model/VASTAd;
    invoke-virtual {v0}, Lcom/auditude/ads/network/vast/model/VASTAd;->getWrapperAd()Lcom/auditude/ads/network/vast/model/VASTWrapperAd;

    move-result-object v8

    if-eqz v8, :cond_3

    .line 109
    iget-object v8, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->document:Lcom/auditude/ads/network/vast/model/VASTDocument;

    iput-boolean v10, v8, Lcom/auditude/ads/network/vast/model/VASTDocument;->reachedMaxWrapper:Z

    .line 110
    invoke-virtual {v0}, Lcom/auditude/ads/network/vast/model/VASTAd;->getWrapperAd()Lcom/auditude/ads/network/vast/model/VASTWrapperAd;

    move-result-object v8

    const/16 v9, 0x12e

    invoke-direct {p0, v8, v9}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->logVastError(Lcom/auditude/ads/network/vast/model/VASTInlineAd;I)V

    goto :goto_4

    .line 90
    .end local v0    # "ad":Lcom/auditude/ads/network/vast/model/VASTAd;
    :cond_4
    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/auditude/ads/network/vast/model/VASTAd;

    .line 92
    .local v5, "vAd":Lcom/auditude/ads/network/vast/model/VASTAd;
    invoke-static {v10}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v8

    invoke-virtual {v5, v8}, Lcom/auditude/ads/network/vast/model/VASTAd;->setFallbackOnNoAd(Ljava/lang/Boolean;)V

    goto :goto_2

    .line 99
    .end local v5    # "vAd":Lcom/auditude/ads/network/vast/model/VASTAd;
    :cond_5
    iput-object v6, p0, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->document:Lcom/auditude/ads/network/vast/model/VASTDocument;

    .line 100
    const-string v7, "processComplete"

    new-instance v8, Lcom/auditude/ads/util/event/Event;

    invoke-direct {v8, p0}, Lcom/auditude/ads/util/event/Event;-><init>(Lcom/auditude/ads/util/event/IEventDispatcher;)V

    invoke-virtual {p0, v7, v8}, Lcom/auditude/ads/network/vast/loader/VASTDocumentProcessor;->dispatchEvent(Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_3

    .line 118
    .end local v2    # "numWrappers":I
    :cond_6
    const/4 v4, 0x1

    goto/16 :goto_1
.end method

.class public Lcom/auditude/ads/network/vast/VASTAdLoader;
.super Lcom/auditude/ads/network/NetworkAdLoader;
.source "VASTAdLoader.java"

# interfaces
.implements Lcom/auditude/ads/util/event/IEventListener;


# instance fields
.field private loader:Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 43
    invoke-direct {p0}, Lcom/auditude/ads/network/NetworkAdLoader;-><init>()V

    return-void
.end method

.method private addVASTProgressTracking(Lcom/auditude/ads/model/Asset;ILcom/auditude/ads/network/vast/model/VASTTrackingEvent;)V
    .locals 7
    .param p1, "asset"    # Lcom/auditude/ads/model/Asset;
    .param p2, "progress"    # I
    .param p3, "vastTrackingEvent"    # Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;

    .prologue
    const/4 v5, 0x1

    .line 475
    if-eqz p3, :cond_0

    invoke-virtual {p3}, Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;->getTrackingUrls()Ljava/util/ArrayList;

    move-result-object v4

    if-eqz v4, :cond_0

    invoke-virtual {p3}, Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;->getTrackingUrls()Ljava/util/ArrayList;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 515
    :cond_0
    return-void

    .line 480
    :cond_1
    invoke-virtual {p3}, Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;->getTrackingUrls()Ljava/util/ArrayList;

    move-result-object v2

    .line 481
    .local v2, "trackingUrls":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;>;"
    const/4 v0, 0x0

    .line 483
    .local v0, "trackingEvent":Lcom/auditude/ads/model/tracking/TrackingEvent;
    sparse-switch p2, :sswitch_data_0

    .line 504
    :goto_0
    if-eqz v0, :cond_0

    .line 506
    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_2
    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;

    .line 508
    .local v3, "vastTrackingUrl":Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;
    invoke-virtual {v3}, Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;->getUrl()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_2

    .line 509
    new-instance v1, Lcom/auditude/ads/model/tracking/TrackingUrl;

    invoke-virtual {v3}, Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;->getUrl()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0}, Lcom/auditude/ads/model/tracking/TrackingEvent;->getType()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v1, v5, v6}, Lcom/auditude/ads/model/tracking/TrackingUrl;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 510
    .local v1, "trackingUrl":Lcom/auditude/ads/model/tracking/TrackingUrl;
    invoke-virtual {v3}, Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;->getOffset()I

    move-result v5

    invoke-virtual {v1, v5}, Lcom/auditude/ads/model/tracking/TrackingUrl;->setOffset(I)V

    .line 511
    invoke-virtual {v3}, Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;->getOffsetIsPercent()Ljava/lang/Boolean;

    move-result-object v5

    invoke-virtual {v1, v5}, Lcom/auditude/ads/model/tracking/TrackingUrl;->setOffsetIsPercent(Ljava/lang/Boolean;)V

    .line 512
    invoke-virtual {v0, v1}, Lcom/auditude/ads/model/tracking/TrackingEvent;->addTrackingUrl(Lcom/auditude/ads/model/tracking/TrackingUrl;)V

    goto :goto_1

    .line 486
    .end local v1    # "trackingUrl":Lcom/auditude/ads/model/tracking/TrackingUrl;
    .end local v3    # "vastTrackingUrl":Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;
    :sswitch_0
    const-string v4, "start"

    invoke-virtual {p1, v4, v5}, Lcom/auditude/ads/model/Asset;->getTrackingEventByType(Ljava/lang/String;Z)Lcom/auditude/ads/model/tracking/TrackingEvent;

    move-result-object v0

    .line 487
    goto :goto_0

    .line 489
    :sswitch_1
    const-string v4, "firstquartile"

    invoke-virtual {p1, v4, v5}, Lcom/auditude/ads/model/Asset;->getTrackingEventByType(Ljava/lang/String;Z)Lcom/auditude/ads/model/tracking/TrackingEvent;

    move-result-object v0

    .line 490
    goto :goto_0

    .line 492
    :sswitch_2
    const-string v4, "midpoint"

    invoke-virtual {p1, v4, v5}, Lcom/auditude/ads/model/Asset;->getTrackingEventByType(Ljava/lang/String;Z)Lcom/auditude/ads/model/tracking/TrackingEvent;

    move-result-object v0

    .line 493
    goto :goto_0

    .line 495
    :sswitch_3
    const-string v4, "thirdquartile"

    invoke-virtual {p1, v4, v5}, Lcom/auditude/ads/model/Asset;->getTrackingEventByType(Ljava/lang/String;Z)Lcom/auditude/ads/model/tracking/TrackingEvent;

    move-result-object v0

    .line 496
    goto :goto_0

    .line 498
    :sswitch_4
    const-string v4, "complete"

    invoke-virtual {p1, v4, v5}, Lcom/auditude/ads/model/Asset;->getTrackingEventByType(Ljava/lang/String;Z)Lcom/auditude/ads/model/tracking/TrackingEvent;

    move-result-object v0

    .line 499
    goto :goto_0

    .line 483
    :sswitch_data_0
    .sparse-switch
        0x0 -> :sswitch_0
        0x19 -> :sswitch_1
        0x32 -> :sswitch_2
        0x4b -> :sswitch_3
        0x64 -> :sswitch_4
    .end sparse-switch
.end method

.method private addVASTTracking(Lcom/auditude/ads/model/Asset;Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;)V
    .locals 2
    .param p1, "asset"    # Lcom/auditude/ads/model/Asset;
    .param p2, "vastTrackingEvent"    # Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;

    .prologue
    .line 445
    if-nez p2, :cond_0

    .line 448
    :goto_0
    return-void

    .line 447
    :cond_0
    invoke-virtual {p2}, Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;->getTrackingUrls()Ljava/util/ArrayList;

    move-result-object v0

    iget-object v1, p2, Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;->type:Ljava/lang/String;

    invoke-direct {p0, p1, v0, v1}, Lcom/auditude/ads/network/vast/VASTAdLoader;->addVASTTrackingUrls(Lcom/auditude/ads/model/Asset;Ljava/util/ArrayList;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private addVASTTrackingUrls(Lcom/auditude/ads/model/Asset;Ljava/util/ArrayList;Ljava/lang/String;)V
    .locals 6
    .param p1, "asset"    # Lcom/auditude/ads/model/Asset;
    .param p3, "trackingType"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/auditude/ads/model/Asset;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;",
            ">;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 452
    .local p2, "trackingUrls":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;>;"
    if-eqz p2, :cond_0

    invoke-virtual {p2}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 472
    :cond_0
    return-void

    .line 457
    :cond_1
    const/4 v3, 0x1

    invoke-virtual {p1, p3, v3}, Lcom/auditude/ads/model/Asset;->getTrackingEventByType(Ljava/lang/String;Z)Lcom/auditude/ads/model/tracking/TrackingEvent;

    move-result-object v0

    .line 458
    .local v0, "trackingEvent":Lcom/auditude/ads/model/tracking/TrackingEvent;
    if-eqz v0, :cond_0

    .line 460
    invoke-virtual {p2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_2
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;

    .line 462
    .local v2, "vastTrackingUrl":Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;
    invoke-virtual {v2}, Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;->getUrl()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_2

    .line 466
    new-instance v1, Lcom/auditude/ads/model/tracking/TrackingUrl;

    invoke-virtual {v2}, Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;->getUrl()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0}, Lcom/auditude/ads/model/tracking/TrackingEvent;->getType()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v1, v4, v5}, Lcom/auditude/ads/model/tracking/TrackingUrl;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 467
    .local v1, "trackingUrl":Lcom/auditude/ads/model/tracking/TrackingUrl;
    invoke-virtual {v2}, Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;->getOffset()I

    move-result v4

    invoke-virtual {v1, v4}, Lcom/auditude/ads/model/tracking/TrackingUrl;->setOffset(I)V

    .line 468
    invoke-virtual {v2}, Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;->getOffsetIsPercent()Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {v1, v4}, Lcom/auditude/ads/model/tracking/TrackingUrl;->setOffsetIsPercent(Ljava/lang/Boolean;)V

    .line 469
    invoke-virtual {v0, v1}, Lcom/auditude/ads/model/tracking/TrackingEvent;->addTrackingUrl(Lcom/auditude/ads/model/tracking/TrackingUrl;)V

    goto :goto_0
.end method

.method private getCompanionAssets(Lcom/auditude/ads/network/vast/model/VASTInlineAd;)Ljava/util/ArrayList;
    .locals 11
    .param p1, "inlineAd"    # Lcom/auditude/ads/network/vast/model/VASTInlineAd;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/auditude/ads/network/vast/model/VASTInlineAd;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/model/Asset;",
            ">;"
        }
    .end annotation

    .prologue
    .line 388
    invoke-virtual {p1}, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->getCompanionAds()Ljava/util/ArrayList;

    move-result-object v3

    .line 389
    .local v3, "companionAds":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/network/vast/model/VASTCompanionCreative;>;"
    if-eqz v3, :cond_4

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v7

    if-lez v7, :cond_4

    .line 391
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 393
    .local v1, "assets":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/model/Asset;>;"
    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :goto_0
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-nez v8, :cond_0

    .line 428
    .end local v1    # "assets":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/model/Asset;>;"
    :goto_1
    return-object v1

    .line 393
    .restart local v1    # "assets":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/model/Asset;>;"
    :cond_0
    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/auditude/ads/network/vast/model/VASTCompanionCreative;

    .line 395
    .local v4, "companionCreative":Lcom/auditude/ads/network/vast/model/VASTCompanionCreative;
    new-instance v0, Lcom/auditude/ads/model/OnPageAsset;

    invoke-virtual {p0}, Lcom/auditude/ads/network/vast/VASTAdLoader;->getAd()Lcom/auditude/ads/model/Ad;

    move-result-object v8

    invoke-direct {v0, v8}, Lcom/auditude/ads/model/OnPageAsset;-><init>(Lcom/auditude/ads/model/BaseElement;)V

    .line 396
    .local v0, "asset":Lcom/auditude/ads/model/OnPageAsset;
    const-string v8, "onpage"

    invoke-virtual {v0, v8}, Lcom/auditude/ads/model/OnPageAsset;->setFormat(Ljava/lang/String;)V

    .line 398
    invoke-direct {p0, v0, v4}, Lcom/auditude/ads/network/vast/VASTAdLoader;->setAssetProperties(Lcom/auditude/ads/model/Asset;Lcom/auditude/ads/network/vast/model/VASTAdCreativeBase;)V

    .line 400
    iget-object v8, v4, Lcom/auditude/ads/network/vast/model/VASTCompanionCreative;->altText:Ljava/lang/String;

    invoke-virtual {v0, v8}, Lcom/auditude/ads/model/OnPageAsset;->setAltText(Ljava/lang/String;)V

    .line 402
    new-instance v2, Lcom/auditude/ads/model/Click;

    invoke-direct {v2, v0}, Lcom/auditude/ads/model/Click;-><init>(Lcom/auditude/ads/model/BaseElement;)V

    .line 403
    .local v2, "click":Lcom/auditude/ads/model/Click;
    iget-object v8, v4, Lcom/auditude/ads/network/vast/model/VASTCompanionCreative;->clickThroughUrl:Ljava/lang/String;

    invoke-static {v8}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_1

    .line 405
    iget-object v8, v4, Lcom/auditude/ads/network/vast/model/VASTCompanionCreative;->clickThroughUrl:Ljava/lang/String;

    invoke-virtual {v2, v8}, Lcom/auditude/ads/model/Click;->setUrl(Ljava/lang/String;)V

    .line 407
    :cond_1
    invoke-virtual {v4}, Lcom/auditude/ads/network/vast/model/VASTCompanionCreative;->getClickTrackingUrls()Ljava/util/ArrayList;

    move-result-object v8

    if-eqz v8, :cond_2

    .line 409
    invoke-virtual {v4}, Lcom/auditude/ads/network/vast/model/VASTCompanionCreative;->getClickTrackingUrls()Ljava/util/ArrayList;

    move-result-object v8

    invoke-virtual {v8}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :goto_2
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-nez v9, :cond_3

    .line 414
    :cond_2
    invoke-virtual {v0, v2}, Lcom/auditude/ads/model/OnPageAsset;->setClick(Lcom/auditude/ads/model/IClick;)V

    .line 416
    new-instance v5, Lcom/auditude/ads/model/media/MediaFile;

    invoke-direct {v5}, Lcom/auditude/ads/model/media/MediaFile;-><init>()V

    .line 417
    .local v5, "mediaFile":Lcom/auditude/ads/model/media/MediaFile;
    iget-object v8, v4, Lcom/auditude/ads/network/vast/model/VASTCompanionCreative;->url:Ljava/lang/String;

    iput-object v8, v5, Lcom/auditude/ads/model/media/MediaFile;->source:Ljava/lang/String;

    .line 418
    invoke-virtual {v0}, Lcom/auditude/ads/model/OnPageAsset;->getWidth()I

    move-result v8

    iput v8, v5, Lcom/auditude/ads/model/media/MediaFile;->width:I

    .line 419
    invoke-virtual {v0}, Lcom/auditude/ads/model/OnPageAsset;->getHeight()I

    move-result v8

    iput v8, v5, Lcom/auditude/ads/model/media/MediaFile;->height:I

    .line 420
    invoke-virtual {v0, v5}, Lcom/auditude/ads/model/OnPageAsset;->AddMediaFile(Lcom/auditude/ads/model/media/MediaFile;)V

    .line 422
    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 409
    .end local v5    # "mediaFile":Lcom/auditude/ads/model/media/MediaFile;
    :cond_3
    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    .line 411
    .local v6, "url":Ljava/lang/String;
    new-instance v9, Lcom/auditude/ads/model/tracking/TrackingUrl;

    const-string v10, "click"

    invoke-direct {v9, v6, v10}, Lcom/auditude/ads/model/tracking/TrackingUrl;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    const-string v10, "click"

    invoke-virtual {v2, v9, v10}, Lcom/auditude/ads/model/Click;->addTrackingUrlForType(Lcom/auditude/ads/model/tracking/TrackingUrl;Ljava/lang/String;)V

    goto :goto_2

    .line 428
    .end local v0    # "asset":Lcom/auditude/ads/model/OnPageAsset;
    .end local v1    # "assets":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/model/Asset;>;"
    .end local v2    # "click":Lcom/auditude/ads/model/Click;
    .end local v4    # "companionCreative":Lcom/auditude/ads/network/vast/model/VASTCompanionCreative;
    .end local v6    # "url":Ljava/lang/String;
    :cond_4
    const/4 v1, 0x0

    goto :goto_1
.end method

.method private getLinearAsset(Lcom/auditude/ads/network/vast/model/VASTInlineAd;)Lcom/auditude/ads/model/Asset;
    .locals 14
    .param p1, "inlineAd"    # Lcom/auditude/ads/network/vast/model/VASTInlineAd;

    .prologue
    .line 227
    iget-object v11, p1, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    if-nez v11, :cond_0

    const/4 v1, 0x0

    .line 335
    :goto_0
    return-object v1

    .line 229
    :cond_0
    new-instance v1, Lcom/auditude/ads/model/LinearAsset;

    invoke-virtual {p0}, Lcom/auditude/ads/network/vast/VASTAdLoader;->getAd()Lcom/auditude/ads/model/Ad;

    move-result-object v11

    invoke-direct {v1, v11}, Lcom/auditude/ads/model/LinearAsset;-><init>(Lcom/auditude/ads/model/BaseElement;)V

    .line 230
    .local v1, "linearAsset":Lcom/auditude/ads/model/LinearAsset;
    iget-object v11, p1, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->errorUrl:Ljava/lang/String;

    iput-object v11, v1, Lcom/auditude/ads/model/LinearAsset;->errorUrl:Ljava/lang/String;

    .line 231
    const/4 v4, -0x1

    .line 232
    .local v4, "skipOffset":I
    invoke-virtual {p1}, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->getSkipOffset()Ljava/lang/String;

    move-result-object v11

    if-eqz v11, :cond_1

    invoke-virtual {p1}, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->getSkipOffset()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/String;->length()I

    move-result v11

    if-lez v11, :cond_1

    .line 234
    invoke-virtual {p1}, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->getSkipOffset()Ljava/lang/String;

    move-result-object v11

    const-string v12, "(^[-.0-9]+:[-.0-9]+:[-.0-9]+$)"

    invoke-virtual {v11, v12}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v11

    if-eqz v11, :cond_7

    .line 236
    invoke-virtual {p1}, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->getSkipOffset()Ljava/lang/String;

    move-result-object v11

    invoke-static {v11}, Lcom/auditude/ads/util/StringUtil;->parseDuration(Ljava/lang/String;)I

    move-result v11

    mul-int/lit16 v4, v11, 0x3e8

    .line 248
    :cond_1
    :goto_1
    invoke-virtual {v1, v4}, Lcom/auditude/ads/model/LinearAsset;->setSkipOffset(I)V

    .line 250
    iget-object v8, p1, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    .line 251
    .local v8, "vastLinearCreative":Lcom/auditude/ads/network/vast/model/VASTLinearCreative;
    iget v11, v8, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->duration:I

    mul-int/lit16 v11, v11, 0x3e8

    invoke-virtual {v1, v11}, Lcom/auditude/ads/model/LinearAsset;->setDurationInMillis(I)V

    .line 252
    iget-object v11, v8, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->id:Ljava/lang/String;

    invoke-virtual {v1, v11}, Lcom/auditude/ads/model/LinearAsset;->setID(Ljava/lang/String;)V

    .line 253
    iget-object v11, v8, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->apiFramework:Ljava/lang/String;

    invoke-virtual {v1, v11}, Lcom/auditude/ads/model/LinearAsset;->setApiFramework(Ljava/lang/String;)V

    .line 254
    iget-object v11, v8, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->adParameters:Ljava/lang/String;

    invoke-virtual {v1, v11}, Lcom/auditude/ads/model/LinearAsset;->setAdParameters(Ljava/lang/String;)V

    .line 257
    invoke-virtual {v8}, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->getMediaFiles()Ljava/util/ArrayList;

    move-result-object v11

    if-eqz v11, :cond_2

    invoke-virtual {v8}, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->getMediaFiles()Ljava/util/ArrayList;

    move-result-object v11

    invoke-virtual {v11}, Ljava/util/ArrayList;->size()I

    move-result v11

    if-lez v11, :cond_2

    .line 259
    invoke-virtual {v8}, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->getMediaFiles()Ljava/util/ArrayList;

    move-result-object v11

    const/4 v12, 0x0

    invoke-virtual {v11, v12}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/auditude/ads/network/vast/model/VASTMediaFile;

    .line 260
    .local v5, "tempVar":Lcom/auditude/ads/network/vast/model/VASTMediaFile;
    instance-of v11, v5, Lcom/auditude/ads/network/vast/model/VASTMediaFile;

    if-eqz v11, :cond_9

    move-object v2, v5

    .line 261
    .local v2, "mediaFile":Lcom/auditude/ads/network/vast/model/VASTMediaFile;
    :goto_2
    if-eqz v2, :cond_2

    .line 263
    iget v11, v2, Lcom/auditude/ads/network/vast/model/VASTMediaFile;->width:I

    invoke-virtual {v1, v11}, Lcom/auditude/ads/model/LinearAsset;->setWidth(I)V

    .line 264
    iget v11, v2, Lcom/auditude/ads/network/vast/model/VASTMediaFile;->height:I

    invoke-virtual {v1, v11}, Lcom/auditude/ads/model/LinearAsset;->setHeight(I)V

    .line 268
    .end local v2    # "mediaFile":Lcom/auditude/ads/network/vast/model/VASTMediaFile;
    .end local v5    # "tempVar":Lcom/auditude/ads/network/vast/model/VASTMediaFile;
    :cond_2
    invoke-virtual {v8}, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->getMediaFiles()Ljava/util/ArrayList;

    move-result-object v10

    .line 269
    .local v10, "vastMediaFiles":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/network/vast/model/VASTMediaFile;>;"
    if-eqz v10, :cond_3

    invoke-virtual {v10}, Ljava/util/ArrayList;->size()I

    move-result v11

    if-lez v11, :cond_3

    .line 271
    invoke-virtual {v10}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v11

    :goto_3
    invoke-interface {v11}, Ljava/util/Iterator;->hasNext()Z

    move-result v12

    if-nez v12, :cond_a

    .line 291
    :cond_3
    const-string v11, "video"

    invoke-virtual {v1, v11}, Lcom/auditude/ads/model/LinearAsset;->setFormat(Ljava/lang/String;)V

    .line 294
    iget-object v11, v8, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->click:Lcom/auditude/ads/network/vast/model/VASTClick;

    if-eqz v11, :cond_6

    .line 296
    new-instance v0, Lcom/auditude/ads/model/Click;

    invoke-direct {v0, v1}, Lcom/auditude/ads/model/Click;-><init>(Lcom/auditude/ads/model/BaseElement;)V

    .line 297
    .local v0, "click":Lcom/auditude/ads/model/Click;
    iget-object v11, v8, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->click:Lcom/auditude/ads/network/vast/model/VASTClick;

    invoke-virtual {v11}, Lcom/auditude/ads/network/vast/model/VASTClick;->getUrl()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v0, v11}, Lcom/auditude/ads/model/Click;->setUrl(Ljava/lang/String;)V

    .line 300
    iget-object v11, v8, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->click:Lcom/auditude/ads/network/vast/model/VASTClick;

    invoke-virtual {v11}, Lcom/auditude/ads/network/vast/model/VASTClick;->getTrackingUrls()Ljava/util/ArrayList;

    move-result-object v6

    .line 301
    .local v6, "trackingUrls":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    if-eqz v6, :cond_5

    .line 303
    invoke-virtual {v6}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v11

    :cond_4
    :goto_4
    invoke-interface {v11}, Ljava/util/Iterator;->hasNext()Z

    move-result v12

    if-nez v12, :cond_b

    .line 313
    :cond_5
    invoke-virtual {v1, v0}, Lcom/auditude/ads/model/LinearAsset;->setClick(Lcom/auditude/ads/model/IClick;)V

    .line 317
    .end local v0    # "click":Lcom/auditude/ads/model/Click;
    .end local v6    # "trackingUrls":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    :cond_6
    invoke-virtual {p1}, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->getImpressionUrls()Ljava/util/ArrayList;

    move-result-object v11

    const-string v12, "creativeview"

    invoke-direct {p0, v1, v11, v12}, Lcom/auditude/ads/network/vast/VASTAdLoader;->addVASTTrackingUrls(Lcom/auditude/ads/model/Asset;Ljava/util/ArrayList;Ljava/lang/String;)V

    .line 319
    const-string v11, "creativeview"

    invoke-virtual {v8, v11}, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->getTrackingEventByType(Ljava/lang/String;)Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;

    move-result-object v11

    invoke-direct {p0, v1, v11}, Lcom/auditude/ads/network/vast/VASTAdLoader;->addVASTTracking(Lcom/auditude/ads/model/Asset;Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;)V

    .line 320
    const/4 v11, 0x0

    const-string v12, "start"

    invoke-virtual {v8, v12}, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->getTrackingEventByType(Ljava/lang/String;)Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;

    move-result-object v12

    invoke-direct {p0, v1, v11, v12}, Lcom/auditude/ads/network/vast/VASTAdLoader;->addVASTProgressTracking(Lcom/auditude/ads/model/Asset;ILcom/auditude/ads/network/vast/model/VASTTrackingEvent;)V

    .line 321
    const/16 v11, 0x19

    const-string v12, "firstquartile"

    invoke-virtual {v8, v12}, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->getTrackingEventByType(Ljava/lang/String;)Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;

    move-result-object v12

    invoke-direct {p0, v1, v11, v12}, Lcom/auditude/ads/network/vast/VASTAdLoader;->addVASTProgressTracking(Lcom/auditude/ads/model/Asset;ILcom/auditude/ads/network/vast/model/VASTTrackingEvent;)V

    .line 322
    const/16 v11, 0x32

    const-string v12, "midpoint"

    invoke-virtual {v8, v12}, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->getTrackingEventByType(Ljava/lang/String;)Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;

    move-result-object v12

    invoke-direct {p0, v1, v11, v12}, Lcom/auditude/ads/network/vast/VASTAdLoader;->addVASTProgressTracking(Lcom/auditude/ads/model/Asset;ILcom/auditude/ads/network/vast/model/VASTTrackingEvent;)V

    .line 323
    const/16 v11, 0x4b

    const-string v12, "thirdquartile"

    invoke-virtual {v8, v12}, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->getTrackingEventByType(Ljava/lang/String;)Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;

    move-result-object v12

    invoke-direct {p0, v1, v11, v12}, Lcom/auditude/ads/network/vast/VASTAdLoader;->addVASTProgressTracking(Lcom/auditude/ads/model/Asset;ILcom/auditude/ads/network/vast/model/VASTTrackingEvent;)V

    .line 324
    const/16 v11, 0x64

    const-string v12, "complete"

    invoke-virtual {v8, v12}, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->getTrackingEventByType(Ljava/lang/String;)Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;

    move-result-object v12

    invoke-direct {p0, v1, v11, v12}, Lcom/auditude/ads/network/vast/VASTAdLoader;->addVASTProgressTracking(Lcom/auditude/ads/model/Asset;ILcom/auditude/ads/network/vast/model/VASTTrackingEvent;)V

    .line 327
    const-string v11, "progress"

    invoke-virtual {v8, v11}, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->getTrackingEventByType(Ljava/lang/String;)Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;

    move-result-object v11

    invoke-direct {p0, v1, v11}, Lcom/auditude/ads/network/vast/VASTAdLoader;->addVASTTracking(Lcom/auditude/ads/model/Asset;Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;)V

    .line 330
    const-string v11, "vasterror"

    invoke-virtual {v8, v11}, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->getTrackingEventByType(Ljava/lang/String;)Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;

    move-result-object v11

    invoke-direct {p0, v1, v11}, Lcom/auditude/ads/network/vast/VASTAdLoader;->addVASTTracking(Lcom/auditude/ads/model/Asset;Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;)V

    .line 333
    const-string v11, "skip"

    invoke-virtual {v8, v11}, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->getTrackingEventByType(Ljava/lang/String;)Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;

    move-result-object v11

    invoke-direct {p0, v1, v11}, Lcom/auditude/ads/network/vast/VASTAdLoader;->addVASTTracking(Lcom/auditude/ads/model/Asset;Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;)V

    goto/16 :goto_0

    .line 238
    .end local v8    # "vastLinearCreative":Lcom/auditude/ads/network/vast/model/VASTLinearCreative;
    .end local v10    # "vastMediaFiles":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/network/vast/model/VASTMediaFile;>;"
    :cond_7
    invoke-virtual {p1}, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->getSkipOffset()Ljava/lang/String;

    move-result-object v11

    const-string v12, "%"

    invoke-virtual {v11, v12}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v11

    if-eqz v11, :cond_8

    iget-object v11, p1, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    if-eqz v11, :cond_8

    iget-object v11, p1, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    iget v11, v11, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->duration:I

    if-lez v11, :cond_8

    .line 240
    invoke-virtual {p1}, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->getSkipOffset()Ljava/lang/String;

    move-result-object v11

    const-string v12, "%"

    const-string v13, ""

    invoke-virtual {v11, v12, v13}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    invoke-static {v11}, Lcom/auditude/ads/util/StringUtil;->convertToInt(Ljava/lang/String;)I

    move-result v3

    .line 241
    .local v3, "per":I
    iget-object v11, p1, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    iget v11, v11, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->duration:I

    int-to-float v11, v11

    int-to-float v12, v3

    mul-float/2addr v11, v12

    const/high16 v12, 0x42c80000    # 100.0f

    div-float/2addr v11, v12

    const/high16 v12, 0x447a0000    # 1000.0f

    mul-float/2addr v11, v12

    invoke-static {v11}, Ljava/lang/Math;->round(F)I

    move-result v4

    .line 242
    goto/16 :goto_1

    .line 245
    .end local v3    # "per":I
    :cond_8
    const/4 v4, -0x1

    goto/16 :goto_1

    .line 260
    .restart local v5    # "tempVar":Lcom/auditude/ads/network/vast/model/VASTMediaFile;
    .restart local v8    # "vastLinearCreative":Lcom/auditude/ads/network/vast/model/VASTLinearCreative;
    :cond_9
    const/4 v2, 0x0

    goto/16 :goto_2

    .line 271
    .end local v5    # "tempVar":Lcom/auditude/ads/network/vast/model/VASTMediaFile;
    .restart local v10    # "vastMediaFiles":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/network/vast/model/VASTMediaFile;>;"
    :cond_a
    invoke-interface {v11}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/auditude/ads/network/vast/model/VASTMediaFile;

    .line 273
    .local v9, "vastMediaFile":Lcom/auditude/ads/network/vast/model/VASTMediaFile;
    new-instance v2, Lcom/auditude/ads/model/media/MediaFile;

    invoke-direct {v2}, Lcom/auditude/ads/model/media/MediaFile;-><init>()V

    .line 274
    .local v2, "mediaFile":Lcom/auditude/ads/model/media/MediaFile;
    iget-object v12, v9, Lcom/auditude/ads/network/vast/model/VASTMediaFile;->id:Ljava/lang/String;

    iput-object v12, v2, Lcom/auditude/ads/model/media/MediaFile;->id:Ljava/lang/String;

    .line 275
    iget v12, v9, Lcom/auditude/ads/network/vast/model/VASTMediaFile;->bitrate:I

    iput v12, v2, Lcom/auditude/ads/model/media/MediaFile;->bitrate:I

    .line 276
    iget v12, v9, Lcom/auditude/ads/network/vast/model/VASTMediaFile;->width:I

    iput v12, v2, Lcom/auditude/ads/model/media/MediaFile;->width:I

    .line 277
    iget v12, v9, Lcom/auditude/ads/network/vast/model/VASTMediaFile;->height:I

    iput v12, v2, Lcom/auditude/ads/model/media/MediaFile;->height:I

    .line 278
    iget-object v12, v9, Lcom/auditude/ads/network/vast/model/VASTMediaFile;->url:Ljava/lang/String;

    iput-object v12, v2, Lcom/auditude/ads/model/media/MediaFile;->source:Ljava/lang/String;

    .line 279
    iget-object v12, v9, Lcom/auditude/ads/network/vast/model/VASTMediaFile;->type:Ljava/lang/String;

    iput-object v12, v2, Lcom/auditude/ads/model/media/MediaFile;->mimeType:Ljava/lang/String;

    .line 280
    iget-boolean v12, v9, Lcom/auditude/ads/network/vast/model/VASTMediaFile;->scalable:Z

    iput-boolean v12, v2, Lcom/auditude/ads/model/media/MediaFile;->scalable:Z

    .line 281
    iget-boolean v12, v9, Lcom/auditude/ads/network/vast/model/VASTMediaFile;->maintainAspectRatio:Z

    iput-boolean v12, v2, Lcom/auditude/ads/model/media/MediaFile;->maintainAspectRatio:Z

    .line 282
    iget-object v12, v9, Lcom/auditude/ads/network/vast/model/VASTMediaFile;->delivery:Ljava/lang/String;

    iput-object v12, v2, Lcom/auditude/ads/model/media/MediaFile;->delivery:Ljava/lang/String;

    .line 283
    iget-object v12, v9, Lcom/auditude/ads/network/vast/model/VASTMediaFile;->apiFramework:Ljava/lang/String;

    iput-object v12, v2, Lcom/auditude/ads/model/media/MediaFile;->apiFramework:Ljava/lang/String;

    .line 285
    invoke-virtual {v1, v2}, Lcom/auditude/ads/model/LinearAsset;->AddMediaFile(Lcom/auditude/ads/model/media/MediaFile;)V

    goto/16 :goto_3

    .line 303
    .end local v2    # "mediaFile":Lcom/auditude/ads/model/media/MediaFile;
    .end local v9    # "vastMediaFile":Lcom/auditude/ads/network/vast/model/VASTMediaFile;
    .restart local v0    # "click":Lcom/auditude/ads/model/Click;
    .restart local v6    # "trackingUrls":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    :cond_b
    invoke-interface {v11}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    .line 305
    .local v7, "url":Ljava/lang/String;
    invoke-static {v7}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v12

    if-nez v12, :cond_4

    .line 309
    new-instance v12, Lcom/auditude/ads/model/tracking/TrackingUrl;

    const-string v13, "click"

    invoke-direct {v12, v7, v13}, Lcom/auditude/ads/model/tracking/TrackingUrl;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    const-string v13, "click"

    invoke-virtual {v0, v12, v13}, Lcom/auditude/ads/model/Click;->addTrackingUrlForType(Lcom/auditude/ads/model/tracking/TrackingUrl;Ljava/lang/String;)V

    goto/16 :goto_4
.end method

.method private getNonLinearAssets(Lcom/auditude/ads/network/vast/model/VASTInlineAd;)Ljava/util/ArrayList;
    .locals 10
    .param p1, "inlineAd"    # Lcom/auditude/ads/network/vast/model/VASTInlineAd;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/auditude/ads/network/vast/model/VASTInlineAd;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/model/Asset;",
            ">;"
        }
    .end annotation

    .prologue
    .line 340
    invoke-virtual {p1}, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->getNonLinearAds()Ljava/util/ArrayList;

    move-result-object v5

    .line 341
    .local v5, "nonLinearAds":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/network/vast/model/VASTNonLinearCreative;>;"
    if-eqz v5, :cond_3

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v7

    if-lez v7, :cond_3

    .line 343
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 345
    .local v1, "assets":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/model/Asset;>;"
    const/4 v3, 0x0

    .line 346
    .local v3, "impressionsAdded":Z
    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :goto_0
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-nez v8, :cond_0

    .line 383
    .end local v1    # "assets":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/model/Asset;>;"
    .end local v3    # "impressionsAdded":Z
    :goto_1
    return-object v1

    .line 346
    .restart local v1    # "assets":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/model/Asset;>;"
    .restart local v3    # "impressionsAdded":Z
    :cond_0
    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/auditude/ads/network/vast/model/VASTNonLinearCreative;

    .line 348
    .local v6, "nonLinearCreative":Lcom/auditude/ads/network/vast/model/VASTNonLinearCreative;
    new-instance v0, Lcom/auditude/ads/model/NonLinearAsset;

    invoke-virtual {p0}, Lcom/auditude/ads/network/vast/VASTAdLoader;->getAd()Lcom/auditude/ads/model/Ad;

    move-result-object v8

    invoke-direct {v0, v8}, Lcom/auditude/ads/model/NonLinearAsset;-><init>(Lcom/auditude/ads/model/BaseElement;)V

    .line 349
    .local v0, "asset":Lcom/auditude/ads/model/NonLinearAsset;
    const-string v8, "overlay"

    invoke-virtual {v0, v8}, Lcom/auditude/ads/model/NonLinearAsset;->setFormat(Ljava/lang/String;)V

    .line 351
    invoke-direct {p0, v0, v6}, Lcom/auditude/ads/network/vast/VASTAdLoader;->setAssetProperties(Lcom/auditude/ads/model/Asset;Lcom/auditude/ads/network/vast/model/VASTAdCreativeBase;)V

    .line 353
    new-instance v4, Lcom/auditude/ads/model/media/MediaFile;

    invoke-direct {v4}, Lcom/auditude/ads/model/media/MediaFile;-><init>()V

    .line 354
    .local v4, "mediaFile":Lcom/auditude/ads/model/media/MediaFile;
    iget-object v8, v6, Lcom/auditude/ads/network/vast/model/VASTNonLinearCreative;->url:Ljava/lang/String;

    iput-object v8, v4, Lcom/auditude/ads/model/media/MediaFile;->source:Ljava/lang/String;

    .line 355
    iget-object v8, v6, Lcom/auditude/ads/network/vast/model/VASTNonLinearCreative;->apiFramework:Ljava/lang/String;

    iput-object v8, v4, Lcom/auditude/ads/model/media/MediaFile;->apiFramework:Ljava/lang/String;

    .line 356
    iget v8, v6, Lcom/auditude/ads/network/vast/model/VASTNonLinearCreative;->width:I

    iput v8, v4, Lcom/auditude/ads/model/media/MediaFile;->width:I

    .line 357
    iget v8, v6, Lcom/auditude/ads/network/vast/model/VASTNonLinearCreative;->height:I

    iput v8, v4, Lcom/auditude/ads/model/media/MediaFile;->height:I

    .line 358
    invoke-virtual {v0, v4}, Lcom/auditude/ads/model/NonLinearAsset;->AddMediaFile(Lcom/auditude/ads/model/media/MediaFile;)V

    .line 360
    iget-object v8, v6, Lcom/auditude/ads/network/vast/model/VASTNonLinearCreative;->apiFramework:Ljava/lang/String;

    invoke-virtual {v0, v8}, Lcom/auditude/ads/model/NonLinearAsset;->setApiFramework(Ljava/lang/String;)V

    .line 362
    iget-object v8, v6, Lcom/auditude/ads/network/vast/model/VASTNonLinearCreative;->clickThroughUrl:Ljava/lang/String;

    invoke-static {v8}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_1

    .line 364
    new-instance v2, Lcom/auditude/ads/model/Click;

    invoke-direct {v2, v0}, Lcom/auditude/ads/model/Click;-><init>(Lcom/auditude/ads/model/BaseElement;)V

    .line 365
    .local v2, "click":Lcom/auditude/ads/model/Click;
    iget-object v8, v6, Lcom/auditude/ads/network/vast/model/VASTNonLinearCreative;->clickThroughUrl:Ljava/lang/String;

    invoke-virtual {v2, v8}, Lcom/auditude/ads/model/Click;->setUrl(Ljava/lang/String;)V

    .line 366
    invoke-virtual {v0, v2}, Lcom/auditude/ads/model/NonLinearAsset;->setClick(Lcom/auditude/ads/model/IClick;)V

    .line 371
    .end local v2    # "click":Lcom/auditude/ads/model/Click;
    :cond_1
    iget-object v8, p1, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    if-eqz v8, :cond_2

    if-nez v3, :cond_2

    .line 373
    invoke-virtual {p1}, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->getImpressionUrls()Ljava/util/ArrayList;

    move-result-object v8

    const-string v9, "creativeview"

    invoke-direct {p0, v0, v8, v9}, Lcom/auditude/ads/network/vast/VASTAdLoader;->addVASTTrackingUrls(Lcom/auditude/ads/model/Asset;Ljava/util/ArrayList;Ljava/lang/String;)V

    .line 374
    const/4 v3, 0x1

    .line 377
    :cond_2
    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 383
    .end local v0    # "asset":Lcom/auditude/ads/model/NonLinearAsset;
    .end local v1    # "assets":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/model/Asset;>;"
    .end local v3    # "impressionsAdded":Z
    .end local v4    # "mediaFile":Lcom/auditude/ads/model/media/MediaFile;
    .end local v6    # "nonLinearCreative":Lcom/auditude/ads/network/vast/model/VASTNonLinearCreative;
    :cond_3
    const/4 v1, 0x0

    goto :goto_1
.end method

.method private onLoadComplete(Lcom/auditude/ads/util/event/IEventDispatcher;)V
    .locals 2
    .param p1, "sender"    # Lcom/auditude/ads/util/event/IEventDispatcher;

    .prologue
    .line 127
    const-string v1, "complete"

    invoke-interface {p1, v1, p0}, Lcom/auditude/ads/util/event/IEventDispatcher;->removeEventListener(Ljava/lang/String;Lcom/auditude/ads/util/event/IEventListener;)V

    .line 128
    const-string v1, "failed"

    invoke-interface {p1, v1, p0}, Lcom/auditude/ads/util/event/IEventDispatcher;->removeEventListener(Ljava/lang/String;Lcom/auditude/ads/util/event/IEventListener;)V

    .line 129
    iget-object v1, p0, Lcom/auditude/ads/network/vast/VASTAdLoader;->loader:Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;

    invoke-virtual {v1}, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->getDocument()Lcom/auditude/ads/network/vast/model/VASTDocument;

    move-result-object v0

    .line 131
    .local v0, "document":Lcom/auditude/ads/network/vast/model/VASTDocument;
    invoke-direct {p0, v0}, Lcom/auditude/ads/network/vast/VASTAdLoader;->parseVastDocument(Lcom/auditude/ads/network/vast/model/VASTDocument;)V

    .line 132
    invoke-virtual {p0}, Lcom/auditude/ads/network/vast/VASTAdLoader;->notifyComplete()V

    .line 133
    return-void
.end method

.method private onLoadFailed(Lcom/auditude/ads/util/event/IEventDispatcher;)V
    .locals 6
    .param p1, "sender"    # Lcom/auditude/ads/util/event/IEventDispatcher;

    .prologue
    const/16 v5, 0x455

    .line 209
    const-string v2, "complete"

    invoke-interface {p1, v2, p0}, Lcom/auditude/ads/util/event/IEventDispatcher;->removeEventListener(Ljava/lang/String;Lcom/auditude/ads/util/event/IEventListener;)V

    .line 210
    const-string v2, "failed"

    invoke-interface {p1, v2, p0}, Lcom/auditude/ads/util/event/IEventDispatcher;->removeEventListener(Ljava/lang/String;Lcom/auditude/ads/util/event/IEventListener;)V

    .line 213
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 214
    .local v1, "data":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    invoke-virtual {p0}, Lcom/auditude/ads/network/vast/VASTAdLoader;->getAd()Lcom/auditude/ads/model/Ad;

    move-result-object v0

    .line 215
    .local v0, "ad":Lcom/auditude/ads/model/Ad;
    if-eqz v0, :cond_0

    const-string v2, "AdId"

    invoke-virtual {v0}, Lcom/auditude/ads/model/Ad;->getID()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 216
    :cond_0
    const-string v2, "InternalErrorId"

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 217
    const-string v2, "Description"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "Connection failed on:"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/auditude/ads/network/vast/VASTAdLoader;->getSource()Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 218
    new-instance v2, Lcom/auditude/ads/event/AdPluginEvent;

    const-string v3, "NetworkAdResponseEmpty"

    invoke-direct {v2, v3, v1}, Lcom/auditude/ads/event/AdPluginEvent;-><init>(Ljava/lang/String;Ljava/util/HashMap;)V

    invoke-virtual {p0, v2}, Lcom/auditude/ads/network/vast/VASTAdLoader;->notifyError(Lcom/auditude/ads/event/AdPluginEvent;)V

    .line 221
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Connection failed on:"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/auditude/ads/network/vast/VASTAdLoader;->getSource()Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v5, v2}, Lcom/auditude/ads/network/vast/VASTAdLoader;->logError(ILjava/lang/String;)V

    .line 222
    invoke-virtual {p0}, Lcom/auditude/ads/network/vast/VASTAdLoader;->notifyComplete()V

    .line 223
    return-void
.end method

.method private parseVastDocument(Lcom/auditude/ads/network/vast/model/VASTDocument;)V
    .locals 13
    .param p1, "document"    # Lcom/auditude/ads/network/vast/model/VASTDocument;

    .prologue
    const/16 v12, 0x454

    .line 137
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    .line 138
    .local v7, "segments":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/ArrayList<Lcom/auditude/ads/model/Asset;>;>;"
    if-eqz p1, :cond_1

    .line 140
    invoke-virtual {p1}, Lcom/auditude/ads/network/vast/model/VASTDocument;->getAds()Ljava/util/ArrayList;

    move-result-object v1

    .line 141
    .local v1, "ads":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/network/vast/model/VASTAd;>;"
    if-eqz v1, :cond_1

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v9

    if-lez v9, :cond_1

    .line 143
    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :cond_0
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-nez v10, :cond_5

    .line 188
    .end local v1    # "ads":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/network/vast/model/VASTAd;>;"
    :cond_1
    invoke-virtual {v7}, Ljava/util/ArrayList;->size()I

    move-result v9

    if-lez v9, :cond_a

    move-object v9, v7

    :goto_0
    invoke-virtual {p0, v9}, Lcom/auditude/ads/network/vast/VASTAdLoader;->setResult(Ljava/lang/Object;)V

    .line 189
    if-eqz v7, :cond_2

    if-eqz p1, :cond_2

    invoke-virtual {v7}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v9

    if-eqz v9, :cond_b

    invoke-virtual {p0}, Lcom/auditude/ads/network/vast/VASTAdLoader;->getAd()Lcom/auditude/ads/model/Ad;

    move-result-object v9

    invoke-virtual {v9}, Lcom/auditude/ads/model/Ad;->getDispatchError()Ljava/lang/Boolean;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v9

    if-eqz v9, :cond_b

    iget-boolean v9, p1, Lcom/auditude/ads/network/vast/model/VASTDocument;->reachedMaxWrapper:Z

    if-nez v9, :cond_b

    .line 192
    :cond_2
    new-instance v4, Ljava/util/HashMap;

    invoke-direct {v4}, Ljava/util/HashMap;-><init>()V

    .line 193
    .local v4, "data":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    invoke-virtual {p0}, Lcom/auditude/ads/network/vast/VASTAdLoader;->getAd()Lcom/auditude/ads/model/Ad;

    move-result-object v0

    .line 194
    .local v0, "ad":Lcom/auditude/ads/model/Ad;
    if-eqz v0, :cond_3

    const-string v9, "AdId"

    invoke-virtual {v0}, Lcom/auditude/ads/model/Ad;->getID()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v4, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 195
    :cond_3
    const-string v9, "InternalErrorId"

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    invoke-virtual {v4, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 196
    const-string v9, "Description"

    new-instance v10, Ljava/lang/StringBuilder;

    const-string v11, "No ads returned from:"

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/auditude/ads/network/vast/VASTAdLoader;->getSource()Ljava/lang/Object;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v4, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 197
    new-instance v9, Lcom/auditude/ads/event/AdPluginEvent;

    const-string v10, "NetworkAdResponseEmpty"

    invoke-direct {v9, v10, v4}, Lcom/auditude/ads/event/AdPluginEvent;-><init>(Ljava/lang/String;Ljava/util/HashMap;)V

    invoke-virtual {p0, v9}, Lcom/auditude/ads/network/vast/VASTAdLoader;->notifyError(Lcom/auditude/ads/event/AdPluginEvent;)V

    .line 199
    new-instance v9, Ljava/lang/StringBuilder;

    const-string v10, "No ads returned from:"

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/auditude/ads/network/vast/VASTAdLoader;->getSource()Ljava/lang/Object;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {p0, v12, v9}, Lcom/auditude/ads/network/vast/VASTAdLoader;->logError(ILjava/lang/String;)V

    .line 205
    .end local v0    # "ad":Lcom/auditude/ads/model/Ad;
    .end local v4    # "data":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_4
    :goto_1
    return-void

    .line 143
    .restart local v1    # "ads":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/network/vast/model/VASTAd;>;"
    :cond_5
    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/auditude/ads/network/vast/model/VASTAd;

    .line 145
    .local v8, "vastAd":Lcom/auditude/ads/network/vast/model/VASTAd;
    if-eqz v8, :cond_0

    invoke-virtual {v8}, Lcom/auditude/ads/network/vast/model/VASTAd;->getInlineAds()Ljava/util/ArrayList;

    move-result-object v10

    if-eqz v10, :cond_0

    .line 147
    invoke-virtual {v8}, Lcom/auditude/ads/network/vast/model/VASTAd;->getInlineAds()Ljava/util/ArrayList;

    move-result-object v10

    invoke-virtual {v10}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v10

    :cond_6
    :goto_2
    invoke-interface {v10}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-eqz v11, :cond_0

    invoke-interface {v10}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/auditude/ads/network/vast/model/VASTInlineAd;

    .line 149
    .local v5, "inlineAd":Lcom/auditude/ads/network/vast/model/VASTInlineAd;
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    .line 152
    .local v6, "par":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/model/Asset;>;"
    invoke-direct {p0, v5}, Lcom/auditude/ads/network/vast/VASTAdLoader;->getLinearAsset(Lcom/auditude/ads/network/vast/model/VASTInlineAd;)Lcom/auditude/ads/model/Asset;

    move-result-object v2

    .line 153
    .local v2, "asset":Lcom/auditude/ads/model/Asset;
    if-eqz v2, :cond_6

    .line 155
    invoke-virtual {v5}, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->getNetworkAdId()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v2, v11}, Lcom/auditude/ads/model/Asset;->setNetworkAdId(Ljava/lang/String;)V

    .line 156
    iget-object v11, v5, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->companionRequired:Ljava/lang/String;

    invoke-virtual {v2, v11}, Lcom/auditude/ads/model/Asset;->setCompanionRequired(Ljava/lang/String;)V

    .line 157
    if-eqz v2, :cond_7

    .line 159
    invoke-virtual {v6, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 163
    :cond_7
    invoke-direct {p0, v5}, Lcom/auditude/ads/network/vast/VASTAdLoader;->getNonLinearAssets(Lcom/auditude/ads/network/vast/model/VASTInlineAd;)Ljava/util/ArrayList;

    move-result-object v3

    .line 164
    .local v3, "assets":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/model/Asset;>;"
    if-eqz v3, :cond_8

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v11

    if-lez v11, :cond_8

    .line 166
    invoke-virtual {v6, v3}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 170
    :cond_8
    invoke-direct {p0, v5}, Lcom/auditude/ads/network/vast/VASTAdLoader;->getCompanionAssets(Lcom/auditude/ads/network/vast/model/VASTInlineAd;)Ljava/util/ArrayList;

    move-result-object v3

    .line 171
    if-eqz v3, :cond_9

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v11

    if-lez v11, :cond_9

    .line 173
    invoke-virtual {v6, v3}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 176
    :cond_9
    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v11

    if-lez v11, :cond_6

    .line 178
    invoke-virtual {v7, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 188
    .end local v1    # "ads":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/network/vast/model/VASTAd;>;"
    .end local v2    # "asset":Lcom/auditude/ads/model/Asset;
    .end local v3    # "assets":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/model/Asset;>;"
    .end local v5    # "inlineAd":Lcom/auditude/ads/network/vast/model/VASTInlineAd;
    .end local v6    # "par":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/model/Asset;>;"
    .end local v8    # "vastAd":Lcom/auditude/ads/network/vast/model/VASTAd;
    :cond_a
    const/4 v9, 0x0

    goto/16 :goto_0

    .line 201
    :cond_b
    if-eqz p1, :cond_4

    iget-boolean v9, p1, Lcom/auditude/ads/network/vast/model/VASTDocument;->reachedMaxWrapper:Z

    if-eqz v9, :cond_4

    invoke-virtual {p0}, Lcom/auditude/ads/network/vast/VASTAdLoader;->getAd()Lcom/auditude/ads/model/Ad;

    move-result-object v9

    invoke-virtual {v9}, Lcom/auditude/ads/model/Ad;->getDispatchError()Ljava/lang/Boolean;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v9

    if-eqz v9, :cond_4

    .line 203
    const/16 v9, 0x456

    const-string v10, ""

    invoke-virtual {p0, v9, v10}, Lcom/auditude/ads/network/vast/VASTAdLoader;->logError(ILjava/lang/String;)V

    goto/16 :goto_1
.end method

.method private setAssetProperties(Lcom/auditude/ads/model/Asset;Lcom/auditude/ads/network/vast/model/VASTAdCreativeBase;)V
    .locals 1
    .param p1, "asset"    # Lcom/auditude/ads/model/Asset;
    .param p2, "vastCreative"    # Lcom/auditude/ads/network/vast/model/VASTAdCreativeBase;

    .prologue
    .line 433
    iget-object v0, p2, Lcom/auditude/ads/network/vast/model/VASTAdCreativeBase;->id:Ljava/lang/String;

    invoke-virtual {p1, v0}, Lcom/auditude/ads/model/Asset;->setID(Ljava/lang/String;)V

    .line 434
    iget v0, p2, Lcom/auditude/ads/network/vast/model/VASTAdCreativeBase;->width:I

    invoke-virtual {p1, v0}, Lcom/auditude/ads/model/Asset;->setWidth(I)V

    .line 435
    iget v0, p2, Lcom/auditude/ads/network/vast/model/VASTAdCreativeBase;->height:I

    invoke-virtual {p1, v0}, Lcom/auditude/ads/model/Asset;->setHeight(I)V

    .line 436
    iget-object v0, p2, Lcom/auditude/ads/network/vast/model/VASTAdCreativeBase;->adParameters:Ljava/lang/String;

    invoke-virtual {p1, v0}, Lcom/auditude/ads/model/Asset;->setAdParameters(Ljava/lang/String;)V

    .line 437
    iget-object v0, p2, Lcom/auditude/ads/network/vast/model/VASTAdCreativeBase;->creativeType:Ljava/lang/String;

    invoke-virtual {p1, v0}, Lcom/auditude/ads/model/Asset;->setCreativeType(Ljava/lang/String;)V

    .line 438
    iget-object v0, p2, Lcom/auditude/ads/network/vast/model/VASTAdCreativeBase;->resourceType:Ljava/lang/String;

    invoke-static {v0}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "static"

    :goto_0
    invoke-virtual {p1, v0}, Lcom/auditude/ads/model/Asset;->setResourceType(Ljava/lang/String;)V

    .line 440
    const-string v0, "creativeview"

    invoke-virtual {p2, v0}, Lcom/auditude/ads/network/vast/model/VASTAdCreativeBase;->getTrackingEventByType(Ljava/lang/String;)Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/auditude/ads/network/vast/VASTAdLoader;->addVASTTracking(Lcom/auditude/ads/model/Asset;Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;)V

    .line 441
    return-void

    .line 438
    :cond_0
    iget-object v0, p2, Lcom/auditude/ads/network/vast/model/VASTAdCreativeBase;->resourceType:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method


# virtual methods
.method public load()V
    .locals 14

    .prologue
    const/4 v10, 0x0

    .line 51
    invoke-super {p0}, Lcom/auditude/ads/network/NetworkAdLoader;->load()V

    .line 53
    invoke-static {}, Lcom/auditude/ads/core/AuditudeEnv;->getInstance()Lcom/auditude/ads/core/AuditudeEnv;

    move-result-object v11

    invoke-virtual {v11}, Lcom/auditude/ads/core/AuditudeEnv;->getAdSettings()Lcom/auditude/ads/core/AdSettings;

    move-result-object v1

    .line 54
    .local v1, "adSettings":Lcom/auditude/ads/core/AdSettings;
    const/4 v6, 0x0

    .line 55
    .local v6, "repackageCreativeEnabled":Z
    const-string v11, "repackageCreativeEnabled"

    invoke-virtual {v1, v11}, Lcom/auditude/ads/core/AdSettings;->getProperty(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v11

    if-eqz v11, :cond_0

    .line 57
    const-string v11, "repackageCreativeEnabled"

    invoke-virtual {v1, v11}, Lcom/auditude/ads/core/AdSettings;->getProperty(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-static {v11}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v6

    .line 59
    :cond_0
    const/4 v3, 0x0

    .line 60
    .local v3, "fallbackOnInvalidCreative":Z
    const-string v11, "fallbackOnInvalidCreative"

    invoke-virtual {v1, v11}, Lcom/auditude/ads/core/AdSettings;->getProperty(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v11

    if-eqz v11, :cond_1

    .line 62
    const-string v11, "fallbackOnInvalidCreative"

    invoke-virtual {v1, v11}, Lcom/auditude/ads/core/AdSettings;->getProperty(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-static {v11}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    .line 67
    :cond_1
    const/4 v4, 0x0

    .line 68
    .local v4, "mimeTypes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    if-nez v6, :cond_2

    const-string v11, "validMimeTypes"

    invoke-virtual {v1, v11}, Lcom/auditude/ads/core/AdSettings;->getProperty(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v11

    if-eqz v11, :cond_2

    .line 70
    const-string v11, "validMimeTypes"

    invoke-virtual {v1, v11}, Lcom/auditude/ads/core/AdSettings;->getProperty(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    .end local v4    # "mimeTypes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    check-cast v4, Ljava/util/ArrayList;

    .line 73
    .restart local v4    # "mimeTypes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    :cond_2
    invoke-virtual {p0}, Lcom/auditude/ads/network/vast/VASTAdLoader;->getAd()Lcom/auditude/ads/model/Ad;

    move-result-object v0

    .line 74
    .local v0, "ad":Lcom/auditude/ads/model/Ad;
    invoke-static {v10}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    .line 75
    .local v2, "crenabled":Ljava/lang/Boolean;
    if-eqz v0, :cond_3

    invoke-virtual {v0}, Lcom/auditude/ads/model/Ad;->isRepackagingEnabled()Z

    move-result v11

    invoke-static {v11}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    .line 76
    :cond_3
    new-instance v8, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;

    if-eqz v6, :cond_4

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v11

    if-eqz v11, :cond_4

    const/4 v10, 0x1

    :cond_4
    invoke-static {v10}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v11

    const-string v10, "repackageCreativeFormat"

    invoke-virtual {v1, v10}, Lcom/auditude/ads/core/AdSettings;->getProperty(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Ljava/lang/String;

    invoke-virtual {v1}, Lcom/auditude/ads/core/AdSettings;->getDomain()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v1}, Lcom/auditude/ads/core/AdSettings;->getZoneId()I

    move-result v13

    invoke-direct {v8, v11, v10, v12, v13}, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;-><init>(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;I)V

    .line 78
    .local v8, "vastAssetRepackagerInfo":Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;
    new-instance v10, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;

    const/4 v11, 0x6

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v12

    invoke-direct {v10, v11, v4, v8, v12}, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;-><init>(ILjava/util/ArrayList;Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;Ljava/lang/Boolean;)V

    iput-object v10, p0, Lcom/auditude/ads/network/vast/VASTAdLoader;->loader:Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;

    .line 79
    iget-object v10, p0, Lcom/auditude/ads/network/vast/VASTAdLoader;->loader:Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;

    const-string v11, "complete"

    invoke-virtual {v10, v11, p0}, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->addEventListener(Ljava/lang/String;Lcom/auditude/ads/util/event/IEventListener;)V

    .line 80
    iget-object v10, p0, Lcom/auditude/ads/network/vast/VASTAdLoader;->loader:Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;

    const-string v11, "failed"

    invoke-virtual {v10, v11, p0}, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->addEventListener(Ljava/lang/String;Lcom/auditude/ads/util/event/IEventListener;)V

    .line 82
    if-eqz v0, :cond_5

    .line 84
    new-instance v9, Lcom/auditude/ads/network/vast/model/VASTWrapperAd;

    invoke-direct {v9}, Lcom/auditude/ads/network/vast/model/VASTWrapperAd;-><init>()V

    .line 85
    .local v9, "wrapperAd":Lcom/auditude/ads/network/vast/model/VASTWrapperAd;
    invoke-virtual {v0}, Lcom/auditude/ads/model/Ad;->getAllowMultipleAds()Ljava/lang/String;

    move-result-object v10

    iput-object v10, v9, Lcom/auditude/ads/network/vast/model/VASTWrapperAd;->allowMultipleAds:Ljava/lang/String;

    .line 86
    invoke-virtual {v0}, Lcom/auditude/ads/model/Ad;->getFollowRedirects()Ljava/lang/Boolean;

    move-result-object v10

    iput-object v10, v9, Lcom/auditude/ads/network/vast/model/VASTWrapperAd;->followAdditionalWrappers:Ljava/lang/Boolean;

    .line 88
    new-instance v7, Lcom/auditude/ads/network/vast/model/VASTAd;

    invoke-virtual {v0}, Lcom/auditude/ads/model/Ad;->getID()Ljava/lang/String;

    move-result-object v10

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v11

    invoke-direct {v7, v10, v11}, Lcom/auditude/ads/network/vast/model/VASTAd;-><init>(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 89
    .local v7, "vastAd":Lcom/auditude/ads/network/vast/model/VASTAd;
    invoke-virtual {v0}, Lcom/auditude/ads/model/Ad;->getIsFromVmapDoc()Ljava/lang/Boolean;

    move-result-object v10

    invoke-virtual {v7, v10}, Lcom/auditude/ads/network/vast/model/VASTAd;->setIsFromVmapDoc(Ljava/lang/Boolean;)V

    .line 90
    invoke-virtual {v7, v9}, Lcom/auditude/ads/network/vast/model/VASTAd;->setWrapperAd(Lcom/auditude/ads/network/vast/model/VASTWrapperAd;)V

    .line 91
    iget-object v10, p0, Lcom/auditude/ads/network/vast/VASTAdLoader;->loader:Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;

    iput-object v7, v10, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->State:Ljava/lang/Object;

    .line 94
    .end local v7    # "vastAd":Lcom/auditude/ads/network/vast/model/VASTAd;
    .end local v9    # "wrapperAd":Lcom/auditude/ads/network/vast/model/VASTWrapperAd;
    :cond_5
    invoke-virtual {p0}, Lcom/auditude/ads/network/vast/VASTAdLoader;->getSource()Ljava/lang/Object;

    move-result-object v5

    .line 96
    .local v5, "networkSource":Ljava/lang/Object;
    instance-of v10, v5, Ljava/lang/String;

    if-eqz v10, :cond_6

    move-object v10, v5

    check-cast v10, Ljava/lang/String;

    invoke-static {v10}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v10

    if-nez v10, :cond_6

    .line 98
    invoke-static {}, Lcom/auditude/ads/util/log/Log;->getLogger()Lcom/auditude/ads/util/log/ILogger;

    move-result-object v10

    new-instance v11, Ljava/lang/StringBuilder;

    const-string v12, "Sending network ad request to: "

    invoke-direct {v11, v12}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v11, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-interface {v10, v11}, Lcom/auditude/ads/util/log/ILogger;->info(Ljava/lang/Object;)V

    .line 100
    :cond_6
    iget-object v10, p0, Lcom/auditude/ads/network/vast/VASTAdLoader;->loader:Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;

    invoke-virtual {v10, v5}, Lcom/auditude/ads/network/vast/loader/VASTXMLLoader;->init(Ljava/lang/Object;)V

    .line 101
    return-void
.end method

.method public onEvent(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 1
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "event"    # Ljava/lang/Object;

    .prologue
    .line 111
    const-string v0, "complete"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 113
    check-cast p2, Lcom/auditude/ads/util/event/Event;

    .end local p2    # "event":Ljava/lang/Object;
    invoke-virtual {p2}, Lcom/auditude/ads/util/event/Event;->getOwner()Lcom/auditude/ads/util/event/IEventDispatcher;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/auditude/ads/network/vast/VASTAdLoader;->onLoadComplete(Lcom/auditude/ads/util/event/IEventDispatcher;)V

    .line 123
    :goto_0
    return-void

    .line 115
    .restart local p2    # "event":Ljava/lang/Object;
    :cond_0
    const-string v0, "failed"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 117
    check-cast p2, Lcom/auditude/ads/util/event/Event;

    .end local p2    # "event":Ljava/lang/Object;
    invoke-virtual {p2}, Lcom/auditude/ads/util/event/Event;->getOwner()Lcom/auditude/ads/util/event/IEventDispatcher;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/auditude/ads/network/vast/VASTAdLoader;->onLoadFailed(Lcom/auditude/ads/util/event/IEventDispatcher;)V

    goto :goto_0

    .line 121
    .restart local p2    # "event":Ljava/lang/Object;
    :cond_1
    invoke-virtual {p0}, Lcom/auditude/ads/network/vast/VASTAdLoader;->notifyComplete()V

    goto :goto_0
.end method

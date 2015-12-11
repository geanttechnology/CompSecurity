.class public Lcom/auditude/ads/network/vast/loader/VASTXMLParser;
.super Ljava/lang/Object;
.source "VASTXMLParser.java"


# instance fields
.field public parentAd:Lcom/auditude/ads/network/vast/model/VASTAd;

.field private parser:Lorg/xmlpull/v1/XmlPullParser;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private logVastError(Lcom/auditude/ads/network/vast/model/VASTInlineAd;I)V
    .locals 4
    .param p1, "inlineAd"    # Lcom/auditude/ads/network/vast/model/VASTInlineAd;
    .param p2, "errorCode"    # I

    .prologue
    .line 680
    if-eqz p1, :cond_0

    iget-object v1, p1, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->errorUrl:Ljava/lang/String;

    if-eqz v1, :cond_0

    iget-object v1, p1, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->errorUrl:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_0

    .line 682
    iget-object v1, p1, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->errorUrl:Ljava/lang/String;

    const-string v2, "\\[ERRORCODE\\]"

    invoke-static {p2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 683
    .local v0, "url":Ljava/lang/String;
    const-string v1, "%5BERRORCODE%5D"

    invoke-static {p2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 684
    invoke-static {v0}, Lcom/auditude/ads/util/AuditudeUtil;->substituteTags(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 685
    invoke-static {v0}, Lcom/auditude/ads/util/PingUtil;->pingUrl(Ljava/lang/String;)V

    .line 687
    .end local v0    # "url":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method private parseAd()Lcom/auditude/ads/network/vast/model/VASTAd;
    .locals 8
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v7, 0x0

    .line 111
    new-instance v0, Lcom/auditude/ads/network/vast/model/VASTAd;

    iget-object v4, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v5, "id"

    invoke-static {v4, v5, v7}, Lcom/auditude/ads/util/XMLUtil;->attributeAsStringOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parentAd:Lcom/auditude/ads/network/vast/model/VASTAd;

    invoke-virtual {v5}, Lcom/auditude/ads/network/vast/model/VASTAd;->getFallbackOnInvalidCreative()Ljava/lang/Boolean;

    move-result-object v5

    invoke-direct {v0, v4, v5}, Lcom/auditude/ads/network/vast/model/VASTAd;-><init>(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 112
    .local v0, "ad":Lcom/auditude/ads/network/vast/model/VASTAd;
    iget-object v4, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v5, "sequence"

    const/4 v6, -0x1

    invoke-static {v4, v5, v6}, Lcom/auditude/ads/util/XMLUtil;->attributeAsIntOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;I)I

    move-result v4

    invoke-virtual {v0, v4}, Lcom/auditude/ads/network/vast/model/VASTAd;->setSequence(I)V

    .line 114
    const/4 v1, 0x2

    .line 117
    .local v1, "eventType":I
    :goto_0
    iget-object v4, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v2

    .line 118
    .local v2, "tag":Ljava/lang/String;
    const/4 v4, 0x2

    if-ne v1, v4, :cond_2

    .line 120
    const-string v4, "InLine"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 122
    new-instance v4, Lcom/auditude/ads/network/vast/model/VASTInlineAd;

    invoke-direct {v4}, Lcom/auditude/ads/network/vast/model/VASTInlineAd;-><init>()V

    invoke-direct {p0, v0, v4}, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parseVASTAdBase(Lcom/auditude/ads/network/vast/model/VASTAd;Lcom/auditude/ads/network/vast/model/VASTInlineAd;)V

    .line 138
    :cond_0
    :goto_1
    iget-object v4, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v1

    .line 115
    goto :goto_0

    .line 124
    :cond_1
    const-string v4, "Wrapper"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 126
    new-instance v3, Lcom/auditude/ads/network/vast/model/VASTWrapperAd;

    invoke-direct {v3}, Lcom/auditude/ads/network/vast/model/VASTWrapperAd;-><init>()V

    .line 127
    .local v3, "wrapperAd":Lcom/auditude/ads/network/vast/model/VASTWrapperAd;
    iget-object v4, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v5, "followAdditionalWrappers"

    const/4 v6, 0x1

    invoke-static {v4, v5, v6}, Lcom/auditude/ads/util/XMLUtil;->attributeAsBoolOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Z)Z

    move-result v4

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    iput-object v4, v3, Lcom/auditude/ads/network/vast/model/VASTWrapperAd;->followAdditionalWrappers:Ljava/lang/Boolean;

    .line 128
    iget-object v4, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v5, "fallbackOnNoAd"

    invoke-static {v4, v5, v7}, Lcom/auditude/ads/util/XMLUtil;->attributeAsStringOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v3, Lcom/auditude/ads/network/vast/model/VASTWrapperAd;->fallbackOnNoAd:Ljava/lang/String;

    .line 129
    iget-object v4, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v5, "allowMultipleAds"

    invoke-static {v4, v5, v7}, Lcom/auditude/ads/util/XMLUtil;->attributeAsStringOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v3, Lcom/auditude/ads/network/vast/model/VASTWrapperAd;->allowMultipleAds:Ljava/lang/String;

    .line 130
    invoke-direct {p0, v0, v3}, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parseVASTAdBase(Lcom/auditude/ads/network/vast/model/VASTAd;Lcom/auditude/ads/network/vast/model/VASTInlineAd;)V

    goto :goto_1

    .line 133
    .end local v3    # "wrapperAd":Lcom/auditude/ads/network/vast/model/VASTWrapperAd;
    :cond_2
    const/4 v4, 0x3

    if-ne v1, v4, :cond_0

    const-string v4, "Ad"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 141
    return-object v0
.end method

.method private parseAdCreativeBaseAttributes(Lcom/auditude/ads/network/vast/model/VASTAdCreativeBase;)V
    .locals 4
    .param p1, "adCreativeBase"    # Lcom/auditude/ads/network/vast/model/VASTAdCreativeBase;

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x0

    .line 497
    iget-object v0, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v1, "id"

    invoke-static {v0, v1, v3}, Lcom/auditude/ads/util/XMLUtil;->attributeAsStringOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p1, Lcom/auditude/ads/network/vast/model/VASTAdCreativeBase;->id:Ljava/lang/String;

    .line 498
    iget-object v0, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v1, "width"

    invoke-static {v0, v1, v2}, Lcom/auditude/ads/util/XMLUtil;->attributeAsIntOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;I)I

    move-result v0

    iput v0, p1, Lcom/auditude/ads/network/vast/model/VASTAdCreativeBase;->width:I

    .line 499
    iget-object v0, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v1, "height"

    invoke-static {v0, v1, v2}, Lcom/auditude/ads/util/XMLUtil;->attributeAsIntOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;I)I

    move-result v0

    iput v0, p1, Lcom/auditude/ads/network/vast/model/VASTAdCreativeBase;->height:I

    .line 500
    iget-object v0, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v1, "expandedWidth"

    invoke-static {v0, v1, v2}, Lcom/auditude/ads/util/XMLUtil;->attributeAsIntOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;I)I

    move-result v0

    iput v0, p1, Lcom/auditude/ads/network/vast/model/VASTAdCreativeBase;->expandedWidth:I

    .line 501
    iget-object v0, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v1, "expandedHeight"

    invoke-static {v0, v1, v2}, Lcom/auditude/ads/util/XMLUtil;->attributeAsIntOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;I)I

    move-result v0

    iput v0, p1, Lcom/auditude/ads/network/vast/model/VASTAdCreativeBase;->expandedHeight:I

    .line 502
    iget-object v0, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v1, "apiFramework"

    invoke-static {v0, v1, v3}, Lcom/auditude/ads/util/XMLUtil;->attributeAsStringOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p1, Lcom/auditude/ads/network/vast/model/VASTAdCreativeBase;->apiFramework:Ljava/lang/String;

    .line 513
    return-void
.end method

.method private parseCompanionAds(Lcom/auditude/ads/network/vast/model/VASTInlineAd;Ljava/lang/String;)V
    .locals 6
    .param p1, "inlineAd"    # Lcom/auditude/ads/network/vast/model/VASTInlineAd;
    .param p2, "adId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 420
    const/4 v0, 0x0

    .line 422
    .local v0, "companionCreative":Lcom/auditude/ads/network/vast/model/VASTCompanionCreative;
    iget-object v3, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v1

    .line 425
    .local v1, "eventType":I
    :goto_0
    iget-object v3, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v2

    .line 427
    .local v2, "tag":Ljava/lang/String;
    const/4 v3, 0x2

    if-ne v1, v3, :cond_9

    .line 429
    const-string v3, "Companion"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 431
    new-instance v0, Lcom/auditude/ads/network/vast/model/VASTCompanionCreative;

    .end local v0    # "companionCreative":Lcom/auditude/ads/network/vast/model/VASTCompanionCreative;
    invoke-direct {v0}, Lcom/auditude/ads/network/vast/model/VASTCompanionCreative;-><init>()V

    .line 432
    .restart local v0    # "companionCreative":Lcom/auditude/ads/network/vast/model/VASTCompanionCreative;
    invoke-direct {p0, v0}, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parseAdCreativeBaseAttributes(Lcom/auditude/ads/network/vast/model/VASTAdCreativeBase;)V

    .line 434
    invoke-virtual {p1, v0}, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->addCompanionAd(Lcom/auditude/ads/network/vast/model/VASTCompanionCreative;)V

    .line 491
    :cond_0
    :goto_1
    iget-object v3, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v1

    .line 423
    goto :goto_0

    .line 436
    :cond_1
    const-string v3, "CompanionClickThrough"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 438
    if-eqz v0, :cond_0

    .line 440
    iget-object v3, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v3

    const-string v4, "\t"

    const-string v5, ""

    invoke-virtual {v3, v4, v5}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, v0, Lcom/auditude/ads/network/vast/model/VASTCompanionCreative;->clickThroughUrl:Ljava/lang/String;

    goto :goto_1

    .line 443
    :cond_2
    const-string v3, "CompanionClickTracking"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 445
    iget-object v3, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v3

    const-string v4, "\t"

    const-string v5, ""

    invoke-virtual {v3, v4, v5}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/auditude/ads/network/vast/model/VASTCompanionCreative;->addClickTrakingUrl(Ljava/lang/String;)V

    goto :goto_1

    .line 447
    :cond_3
    const-string v3, "AdParameters"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 449
    iget-object v3, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v3

    const-string v4, "\t"

    const-string v5, ""

    invoke-virtual {v3, v4, v5}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, v0, Lcom/auditude/ads/network/vast/model/VASTCompanionCreative;->adParameters:Ljava/lang/String;

    goto :goto_1

    .line 451
    :cond_4
    const-string v3, "AltText"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_5

    .line 453
    iget-object v3, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v3

    const-string v4, "\t"

    const-string v5, ""

    invoke-virtual {v3, v4, v5}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, v0, Lcom/auditude/ads/network/vast/model/VASTCompanionCreative;->altText:Ljava/lang/String;

    goto :goto_1

    .line 455
    :cond_5
    const-string v3, "TrackingEvents"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_6

    .line 457
    if-eqz v0, :cond_0

    .line 459
    invoke-direct {p0, v0}, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parseTrackingEvents(Lcom/auditude/ads/network/vast/model/VASTAdCreativeBase;)V

    goto :goto_1

    .line 462
    :cond_6
    const-string v3, "StaticResource"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_7

    .line 464
    iget-object v3, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v4, "creativeType"

    const/4 v5, 0x0

    invoke-static {v3, v4, v5}, Lcom/auditude/ads/util/XMLUtil;->attributeAsStringOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, v0, Lcom/auditude/ads/network/vast/model/VASTCompanionCreative;->creativeType:Ljava/lang/String;

    .line 465
    const-string v3, "static"

    iput-object v3, v0, Lcom/auditude/ads/network/vast/model/VASTCompanionCreative;->resourceType:Ljava/lang/String;

    .line 466
    iget-object v3, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v3

    const-string v4, "\t"

    const-string v5, ""

    invoke-virtual {v3, v4, v5}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, v0, Lcom/auditude/ads/network/vast/model/VASTCompanionCreative;->url:Ljava/lang/String;

    goto/16 :goto_1

    .line 468
    :cond_7
    const-string v3, "IFrameResource"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_8

    iget-object v3, v0, Lcom/auditude/ads/network/vast/model/VASTCompanionCreative;->resourceType:Ljava/lang/String;

    const-string v4, "static"

    if-eq v3, v4, :cond_8

    .line 470
    const-string v3, "iframe"

    iput-object v3, v0, Lcom/auditude/ads/network/vast/model/VASTCompanionCreative;->resourceType:Ljava/lang/String;

    .line 471
    iget-object v3, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v3

    const-string v4, "\t"

    const-string v5, ""

    invoke-virtual {v3, v4, v5}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, v0, Lcom/auditude/ads/network/vast/model/VASTCompanionCreative;->url:Ljava/lang/String;

    goto/16 :goto_1

    .line 473
    :cond_8
    const-string v3, "HTMLResource"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    iget-object v3, v0, Lcom/auditude/ads/network/vast/model/VASTCompanionCreative;->resourceType:Ljava/lang/String;

    if-nez v3, :cond_0

    .line 475
    const-string v3, "html"

    iput-object v3, v0, Lcom/auditude/ads/network/vast/model/VASTCompanionCreative;->resourceType:Ljava/lang/String;

    .line 476
    iget-object v3, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v3

    const-string v4, "\t"

    const-string v5, ""

    invoke-virtual {v3, v4, v5}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, v0, Lcom/auditude/ads/network/vast/model/VASTCompanionCreative;->url:Ljava/lang/String;

    goto/16 :goto_1

    .line 479
    :cond_9
    const/4 v3, 0x3

    if-ne v1, v3, :cond_0

    .line 481
    const-string v3, "Companion"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_a

    .line 483
    const/4 v0, 0x0

    .line 484
    goto/16 :goto_1

    .line 485
    :cond_a
    const-string v3, "CompanionAds"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 493
    return-void
.end method

.method private parseCreatives(Lcom/auditude/ads/network/vast/model/VASTInlineAd;Ljava/lang/String;)V
    .locals 6
    .param p1, "inlineAd"    # Lcom/auditude/ads/network/vast/model/VASTInlineAd;
    .param p2, "adId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 235
    iget-object v3, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    .line 238
    .local v0, "eventType":I
    :goto_0
    iget-object v3, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v2

    .line 240
    .local v2, "tag":Ljava/lang/String;
    const/4 v3, 0x2

    if-ne v0, v3, :cond_4

    .line 242
    const-string v3, "Linear"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 244
    invoke-direct {p0, p1, p2}, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parseLinearAd(Lcom/auditude/ads/network/vast/model/VASTInlineAd;Ljava/lang/String;)V

    .line 266
    :cond_0
    :goto_1
    iget-object v3, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    .line 236
    goto :goto_0

    .line 246
    :cond_1
    const-string v3, "NonLinearAds"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 248
    invoke-direct {p0, p1, p2}, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parseNonLinearAds(Lcom/auditude/ads/network/vast/model/VASTInlineAd;Ljava/lang/String;)V

    goto :goto_1

    .line 250
    :cond_2
    const-string v3, "CompanionAds"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 252
    iget-object v3, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v4, "required"

    const-string v5, "none"

    invoke-static {v3, v4, v5}, Lcom/auditude/ads/util/XMLUtil;->attributeAsStringOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 253
    .local v1, "required":Ljava/lang/String;
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v3

    if-gtz v3, :cond_3

    const-string v1, "none"

    .line 254
    :cond_3
    iput-object v1, p1, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->companionRequired:Ljava/lang/String;

    .line 255
    invoke-direct {p0, p1, p2}, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parseCompanionAds(Lcom/auditude/ads/network/vast/model/VASTInlineAd;Ljava/lang/String;)V

    goto :goto_1

    .line 258
    .end local v1    # "required":Ljava/lang/String;
    :cond_4
    const/4 v3, 0x3

    if-ne v0, v3, :cond_0

    .line 260
    const-string v3, "Creatives"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 268
    return-void
.end method

.method private parseExtensions(Lcom/auditude/ads/network/vast/model/VASTAdBase;)V
    .locals 3
    .param p1, "adBase"    # Lcom/auditude/ads/network/vast/model/VASTAdBase;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 591
    iget-object v2, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    .line 594
    .local v0, "eventType":I
    :goto_0
    iget-object v2, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v1

    .line 596
    .local v1, "tag":Ljava/lang/String;
    const/4 v2, 0x2

    if-ne v0, v2, :cond_1

    .line 598
    const-string v2, "Extension"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 600
    iget-object v2, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v2}, Lcom/auditude/ads/network/vast/model/VASTAdBase;->addExtension(Ljava/lang/Object;)V

    .line 611
    :cond_0
    iget-object v2, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    .line 592
    goto :goto_0

    .line 603
    :cond_1
    const/4 v2, 0x3

    if-ne v0, v2, :cond_0

    .line 605
    const-string v2, "Extensions"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 613
    return-void
.end method

.method private parseLinearAd(Lcom/auditude/ads/network/vast/model/VASTInlineAd;Ljava/lang/String;)V
    .locals 7
    .param p1, "inlineAd"    # Lcom/auditude/ads/network/vast/model/VASTInlineAd;
    .param p2, "adId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 272
    new-instance v1, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    invoke-direct {v1}, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;-><init>()V

    .line 273
    .local v1, "linearCreative":Lcom/auditude/ads/network/vast/model/VASTLinearCreative;
    iput-object p2, v1, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->adId:Ljava/lang/String;

    .line 275
    iget-object v4, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v5, "skipoffset"

    const/4 v6, 0x0

    invoke-static {v4, v5, v6}, Lcom/auditude/ads/util/XMLUtil;->attributeAsStringOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 276
    .local v2, "skipOffset":Ljava/lang/String;
    if-eqz v2, :cond_1

    const-string v4, "(^[-.0-9]+:[-.0-9]+:[-.0-9]+$)"

    invoke-virtual {v2, v4}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_0

    const-string v4, "(^[-.0-9]+%)"

    invoke-virtual {v2, v4}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 278
    :cond_0
    invoke-virtual {p1, v2}, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->setSkipOffset(Ljava/lang/String;)V

    .line 281
    :cond_1
    iget-object v4, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    .line 284
    .local v0, "eventType":I
    :goto_0
    iget-object v4, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v3

    .line 286
    .local v3, "tag":Ljava/lang/String;
    const/4 v4, 0x2

    if-ne v0, v4, :cond_7

    .line 288
    const-string v4, "TrackingEvents"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 290
    invoke-direct {p0, v1}, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parseTrackingEvents(Lcom/auditude/ads/network/vast/model/VASTAdCreativeBase;)V

    .line 317
    :cond_2
    :goto_1
    iget-object v4, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    .line 282
    goto :goto_0

    .line 292
    :cond_3
    const-string v4, "Duration"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 294
    iget-object v4, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v4

    const-string v5, "\t"

    const-string v6, ""

    invoke-virtual {v4, v5, v6}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/auditude/ads/util/StringUtil;->parseDuration(Ljava/lang/String;)I

    move-result v4

    iput v4, v1, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->duration:I

    goto :goto_1

    .line 296
    :cond_4
    const-string v4, "AdParameters"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_5

    .line 298
    iget-object v4, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v4

    const-string v5, "\t"

    const-string v6, ""

    invoke-virtual {v4, v5, v6}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v1, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->adParameters:Ljava/lang/String;

    goto :goto_1

    .line 300
    :cond_5
    const-string v4, "VideoClicks"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_6

    .line 302
    invoke-direct {p0, v1}, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parseLinearClick(Lcom/auditude/ads/network/vast/model/VASTLinearCreative;)V

    goto :goto_1

    .line 304
    :cond_6
    const-string v4, "MediaFiles"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 306
    invoke-direct {p0, v1}, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parseMediaFiles(Lcom/auditude/ads/network/vast/model/VASTLinearCreative;)V

    goto :goto_1

    .line 309
    :cond_7
    const/4 v4, 0x3

    if-ne v0, v4, :cond_2

    .line 311
    const-string v4, "Linear"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 321
    invoke-virtual {v1}, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->getMediaFiles()Ljava/util/ArrayList;

    move-result-object v4

    if-eqz v4, :cond_8

    invoke-virtual {v1}, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->getMediaFiles()Ljava/util/ArrayList;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-lez v4, :cond_8

    .line 323
    invoke-virtual {v1}, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->getMediaFiles()Ljava/util/ArrayList;

    move-result-object v4

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/auditude/ads/network/vast/model/VASTMediaFile;

    iget-object v4, v4, Lcom/auditude/ads/network/vast/model/VASTMediaFile;->apiFramework:Ljava/lang/String;

    iput-object v4, v1, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->apiFramework:Ljava/lang/String;

    .line 325
    :cond_8
    iput-object v1, p1, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    .line 328
    instance-of v4, p1, Lcom/auditude/ads/network/vast/model/VASTWrapperAd;

    if-nez v4, :cond_a

    iget-object v4, p1, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    if-eqz v4, :cond_9

    iget-object v4, p1, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    invoke-virtual {v4}, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->getMediaFiles()Ljava/util/ArrayList;

    move-result-object v4

    if-eqz v4, :cond_9

    iget-object v4, p1, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    invoke-virtual {v4}, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->getMediaFiles()Ljava/util/ArrayList;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-lez v4, :cond_9

    iget-object v4, p1, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    iget v4, v4, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->duration:I

    if-gtz v4, :cond_a

    .line 330
    :cond_9
    const/4 v4, 0x1

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    iput-object v4, p1, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->asInvalideXML:Ljava/lang/Boolean;

    .line 332
    :cond_a
    return-void
.end method

.method private parseLinearClick(Lcom/auditude/ads/network/vast/model/VASTLinearCreative;)V
    .locals 6
    .param p1, "linearCreative"    # Lcom/auditude/ads/network/vast/model/VASTLinearCreative;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 554
    new-instance v0, Lcom/auditude/ads/network/vast/model/VASTClick;

    invoke-direct {v0}, Lcom/auditude/ads/network/vast/model/VASTClick;-><init>()V

    .line 556
    .local v0, "click":Lcom/auditude/ads/network/vast/model/VASTClick;
    iget-object v3, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v1

    .line 559
    .local v1, "eventType":I
    :goto_0
    iget-object v3, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v2

    .line 561
    .local v2, "tag":Ljava/lang/String;
    const/4 v3, 0x2

    if-ne v1, v3, :cond_3

    .line 563
    const-string v3, "ClickThrough"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 565
    iget-object v3, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v3

    const-string v4, "\t"

    const-string v5, ""

    invoke-virtual {v3, v4, v5}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/auditude/ads/network/vast/model/VASTClick;->setUrl(Ljava/lang/String;)V

    .line 585
    :cond_0
    :goto_1
    iget-object v3, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v1

    .line 557
    goto :goto_0

    .line 567
    :cond_1
    const-string v3, "ClickTracking"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 569
    iget-object v3, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v3

    const-string v4, "\t"

    const-string v5, ""

    invoke-virtual {v3, v4, v5}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/auditude/ads/network/vast/model/VASTClick;->addClickTrackingUrl(Ljava/lang/String;)V

    goto :goto_1

    .line 571
    :cond_2
    const-string v3, "CustomClick"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 573
    iget-object v3, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v3

    const-string v4, "\t"

    const-string v5, ""

    invoke-virtual {v3, v4, v5}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/auditude/ads/network/vast/model/VASTClick;->addCustomClickUrl(Ljava/lang/String;)V

    goto :goto_1

    .line 576
    :cond_3
    const/4 v3, 0x3

    if-ne v1, v3, :cond_0

    .line 578
    const-string v3, "VideoClicks"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 580
    iput-object v0, p1, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->click:Lcom/auditude/ads/network/vast/model/VASTClick;

    .line 587
    return-void
.end method

.method private parseMediaFiles(Lcom/auditude/ads/network/vast/model/VASTLinearCreative;)V
    .locals 9
    .param p1, "linearCreative"    # Lcom/auditude/ads/network/vast/model/VASTLinearCreative;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    const/4 v6, 0x0

    .line 517
    iget-object v3, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    .line 520
    .local v0, "eventType":I
    :goto_0
    iget-object v3, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v2

    .line 522
    .local v2, "tag":Ljava/lang/String;
    const/4 v3, 0x2

    if-ne v0, v3, :cond_1

    .line 524
    const-string v3, "MediaFile"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 526
    new-instance v1, Lcom/auditude/ads/network/vast/model/VASTMediaFile;

    invoke-direct {v1}, Lcom/auditude/ads/network/vast/model/VASTMediaFile;-><init>()V

    .line 527
    .local v1, "mediaFile":Lcom/auditude/ads/network/vast/model/VASTMediaFile;
    iget-object v3, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v4, "id"

    invoke-static {v3, v4, v6}, Lcom/auditude/ads/util/XMLUtil;->attributeAsStringOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, v1, Lcom/auditude/ads/network/vast/model/VASTMediaFile;->id:Ljava/lang/String;

    .line 528
    iget-object v3, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v4, "bitrate"

    invoke-static {v3, v4, v7}, Lcom/auditude/ads/util/XMLUtil;->attributeAsIntOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;I)I

    move-result v3

    iput v3, v1, Lcom/auditude/ads/network/vast/model/VASTMediaFile;->bitrate:I

    .line 529
    iget-object v3, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v4, "width"

    invoke-static {v3, v4, v7}, Lcom/auditude/ads/util/XMLUtil;->attributeAsIntOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;I)I

    move-result v3

    iput v3, v1, Lcom/auditude/ads/network/vast/model/VASTMediaFile;->width:I

    .line 530
    iget-object v3, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v4, "height"

    invoke-static {v3, v4, v7}, Lcom/auditude/ads/util/XMLUtil;->attributeAsIntOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;I)I

    move-result v3

    iput v3, v1, Lcom/auditude/ads/network/vast/model/VASTMediaFile;->height:I

    .line 531
    iget-object v3, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v4, "delivery"

    invoke-static {v3, v4, v6}, Lcom/auditude/ads/util/XMLUtil;->attributeAsStringOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, v1, Lcom/auditude/ads/network/vast/model/VASTMediaFile;->delivery:Ljava/lang/String;

    .line 532
    iget-object v3, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v4, "type"

    invoke-static {v3, v4, v6}, Lcom/auditude/ads/util/XMLUtil;->attributeAsStringOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, v1, Lcom/auditude/ads/network/vast/model/VASTMediaFile;->type:Ljava/lang/String;

    .line 533
    iget-object v3, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v4, "scalable"

    invoke-static {v3, v4, v8}, Lcom/auditude/ads/util/XMLUtil;->attributeAsBoolOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Z)Z

    move-result v3

    iput-boolean v3, v1, Lcom/auditude/ads/network/vast/model/VASTMediaFile;->scalable:Z

    .line 534
    iget-object v3, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v4, "maintainAspectRatio"

    invoke-static {v3, v4, v8}, Lcom/auditude/ads/util/XMLUtil;->attributeAsBoolOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Z)Z

    move-result v3

    iput-boolean v3, v1, Lcom/auditude/ads/network/vast/model/VASTMediaFile;->maintainAspectRatio:Z

    .line 535
    iget-object v3, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v4, "apiFramework"

    invoke-static {v3, v4, v6}, Lcom/auditude/ads/util/XMLUtil;->attributeAsStringOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, v1, Lcom/auditude/ads/network/vast/model/VASTMediaFile;->apiFramework:Ljava/lang/String;

    .line 536
    iget-object v3, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v3

    const-string v4, "\t"

    const-string v5, ""

    invoke-virtual {v3, v4, v5}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, v1, Lcom/auditude/ads/network/vast/model/VASTMediaFile;->url:Ljava/lang/String;

    .line 537
    invoke-virtual {p1, v1}, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->addMediaFile(Lcom/auditude/ads/network/vast/model/VASTMediaFile;)V

    .line 548
    .end local v1    # "mediaFile":Lcom/auditude/ads/network/vast/model/VASTMediaFile;
    :cond_0
    iget-object v3, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    .line 518
    goto/16 :goto_0

    .line 540
    :cond_1
    const/4 v3, 0x3

    if-ne v0, v3, :cond_0

    .line 542
    const-string v3, "MediaFiles"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 550
    return-void
.end method

.method private parseNonLinearAds(Lcom/auditude/ads/network/vast/model/VASTInlineAd;Ljava/lang/String;)V
    .locals 8
    .param p1, "inlineAd"    # Lcom/auditude/ads/network/vast/model/VASTInlineAd;
    .param p2, "adId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v7, 0x1

    .line 337
    new-instance v3, Lcom/auditude/ads/network/vast/model/VASTAdCreativeBase;

    invoke-direct {v3}, Lcom/auditude/ads/network/vast/model/VASTAdCreativeBase;-><init>()V

    .line 339
    .local v3, "tempAdCreative":Lcom/auditude/ads/network/vast/model/VASTAdCreativeBase;
    const/4 v1, 0x0

    .line 341
    .local v1, "nonLinearCreative":Lcom/auditude/ads/network/vast/model/VASTNonLinearCreative;
    iget-object v4, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    .line 344
    .local v0, "eventType":I
    :goto_0
    iget-object v4, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v2

    .line 346
    .local v2, "tag":Ljava/lang/String;
    const/4 v4, 0x2

    if-ne v0, v4, :cond_8

    .line 348
    const-string v4, "NonLinear"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 350
    new-instance v1, Lcom/auditude/ads/network/vast/model/VASTNonLinearCreative;

    .end local v1    # "nonLinearCreative":Lcom/auditude/ads/network/vast/model/VASTNonLinearCreative;
    invoke-direct {v1}, Lcom/auditude/ads/network/vast/model/VASTNonLinearCreative;-><init>()V

    .line 351
    .restart local v1    # "nonLinearCreative":Lcom/auditude/ads/network/vast/model/VASTNonLinearCreative;
    invoke-direct {p0, v1}, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parseAdCreativeBaseAttributes(Lcom/auditude/ads/network/vast/model/VASTAdCreativeBase;)V

    .line 353
    iget-object v4, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v5, "scalable"

    invoke-static {v4, v5, v7}, Lcom/auditude/ads/util/XMLUtil;->attributeAsBoolOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Z)Z

    move-result v4

    iput-boolean v4, v1, Lcom/auditude/ads/network/vast/model/VASTNonLinearCreative;->scalable:Z

    .line 354
    iget-object v4, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v5, "maintainAspectRatio"

    invoke-static {v4, v5, v7}, Lcom/auditude/ads/util/XMLUtil;->attributeAsBoolOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Z)Z

    move-result v4

    iput-boolean v4, v1, Lcom/auditude/ads/network/vast/model/VASTNonLinearCreative;->maintainAspectRatio:Z

    .line 356
    invoke-virtual {p1, v1}, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->addNonLinearAd(Lcom/auditude/ads/network/vast/model/VASTNonLinearCreative;)V

    .line 414
    :cond_0
    :goto_1
    iget-object v4, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    .line 342
    goto :goto_0

    .line 358
    :cond_1
    const-string v4, "NonLinearClickThrough"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 360
    if-eqz v1, :cond_0

    .line 362
    iget-object v4, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v4

    const-string v5, "\t"

    const-string v6, ""

    invoke-virtual {v4, v5, v6}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v1, Lcom/auditude/ads/network/vast/model/VASTNonLinearCreative;->clickThroughUrl:Ljava/lang/String;

    goto :goto_1

    .line 365
    :cond_2
    const-string v4, "AdParameters"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 367
    iget-object v4, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v4

    const-string v5, "\t"

    const-string v6, ""

    invoke-virtual {v4, v5, v6}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v1, Lcom/auditude/ads/network/vast/model/VASTNonLinearCreative;->adParameters:Ljava/lang/String;

    goto :goto_1

    .line 369
    :cond_3
    const-string v4, "TrackingEvents"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_5

    .line 371
    if-eqz v1, :cond_4

    .line 373
    invoke-direct {p0, v1}, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parseTrackingEvents(Lcom/auditude/ads/network/vast/model/VASTAdCreativeBase;)V

    goto :goto_1

    .line 377
    :cond_4
    invoke-direct {p0, v3}, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parseTrackingEvents(Lcom/auditude/ads/network/vast/model/VASTAdCreativeBase;)V

    goto :goto_1

    .line 380
    :cond_5
    const-string v4, "StaticResource"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_6

    .line 382
    iget-object v4, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v5, "creativeType"

    const/4 v6, 0x0

    invoke-static {v4, v5, v6}, Lcom/auditude/ads/util/XMLUtil;->attributeAsStringOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v1, Lcom/auditude/ads/network/vast/model/VASTNonLinearCreative;->creativeType:Ljava/lang/String;

    .line 383
    const-string v4, "static"

    iput-object v4, v1, Lcom/auditude/ads/network/vast/model/VASTNonLinearCreative;->resourceType:Ljava/lang/String;

    .line 384
    iget-object v4, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v4

    const-string v5, "\t"

    const-string v6, ""

    invoke-virtual {v4, v5, v6}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v1, Lcom/auditude/ads/network/vast/model/VASTNonLinearCreative;->url:Ljava/lang/String;

    goto :goto_1

    .line 386
    :cond_6
    const-string v4, "IFrameResource"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_7

    .line 388
    const-string v4, "iframe"

    iput-object v4, v1, Lcom/auditude/ads/network/vast/model/VASTNonLinearCreative;->resourceType:Ljava/lang/String;

    .line 389
    iget-object v4, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v4

    const-string v5, "\t"

    const-string v6, ""

    invoke-virtual {v4, v5, v6}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v1, Lcom/auditude/ads/network/vast/model/VASTNonLinearCreative;->url:Ljava/lang/String;

    goto/16 :goto_1

    .line 391
    :cond_7
    const-string v4, "HTMLResource"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 393
    const-string v4, "html"

    iput-object v4, v1, Lcom/auditude/ads/network/vast/model/VASTNonLinearCreative;->resourceType:Ljava/lang/String;

    .line 394
    iget-object v4, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v4

    const-string v5, "\t"

    const-string v6, ""

    invoke-virtual {v4, v5, v6}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v1, Lcom/auditude/ads/network/vast/model/VASTNonLinearCreative;->url:Ljava/lang/String;

    goto/16 :goto_1

    .line 397
    :cond_8
    const/4 v4, 0x3

    if-ne v0, v4, :cond_0

    .line 399
    const-string v4, "NonLinear"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_9

    .line 401
    const/4 v1, 0x0

    .line 402
    goto/16 :goto_1

    .line 403
    :cond_9
    const-string v4, "NonLinearAds"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 406
    invoke-virtual {v3}, Lcom/auditude/ads/network/vast/model/VASTAdCreativeBase;->getTrackingEvents()Ljava/util/ArrayList;

    move-result-object v4

    if-eqz v4, :cond_a

    invoke-virtual {v3}, Lcom/auditude/ads/network/vast/model/VASTAdCreativeBase;->getTrackingEvents()Ljava/util/ArrayList;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-lez v4, :cond_a

    .line 408
    invoke-virtual {v3}, Lcom/auditude/ads/network/vast/model/VASTAdCreativeBase;->getTrackingEvents()Ljava/util/ArrayList;

    move-result-object v4

    invoke-virtual {p1, v4}, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->setNonLinearAdTrackingEvents(Ljava/util/ArrayList;)V

    .line 416
    :cond_a
    return-void
.end method

.method private parseTrackingEvents(Lcom/auditude/ads/network/vast/model/VASTAdCreativeBase;)V
    .locals 11
    .param p1, "adBase"    # Lcom/auditude/ads/network/vast/model/VASTAdCreativeBase;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v10, 0x0

    const/4 v9, 0x0

    .line 617
    iget-object v6, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    .line 620
    .local v0, "eventType":I
    :goto_0
    iget-object v6, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v2

    .line 622
    .local v2, "tag":Ljava/lang/String;
    const/4 v6, 0x2

    if-ne v0, v6, :cond_5

    .line 624
    const-string v6, "Tracking"

    invoke-virtual {v6, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 626
    iget-object v6, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v7, "event"

    invoke-static {v6, v7, v10}, Lcom/auditude/ads/util/XMLUtil;->attributeAsStringOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 627
    .local v4, "trackingEventType":Ljava/lang/String;
    invoke-static {v4}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_1

    .line 629
    invoke-virtual {p1, v4}, Lcom/auditude/ads/network/vast/model/VASTAdCreativeBase;->getTrackingEventByType(Ljava/lang/String;)Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;

    move-result-object v3

    .line 630
    .local v3, "trackingEvent":Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;
    if-nez v3, :cond_0

    .line 632
    new-instance v3, Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;

    .end local v3    # "trackingEvent":Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;
    invoke-direct {v3, v4}, Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;-><init>(Ljava/lang/String;)V

    .line 633
    .restart local v3    # "trackingEvent":Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;
    invoke-virtual {p1, v3}, Lcom/auditude/ads/network/vast/model/VASTAdCreativeBase;->addTrackingEvent(Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;)V

    .line 636
    :cond_0
    iget-object v6, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v7, "offset"

    invoke-static {v6, v7, v10}, Lcom/auditude/ads/util/XMLUtil;->attributeAsStringOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 637
    .local v1, "strOffset":Ljava/lang/String;
    new-instance v5, Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;

    iget-object v6, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v6

    const-string v7, "\t"

    const-string v8, ""

    invoke-virtual {v6, v7, v8}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6, v4}, Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 638
    .local v5, "trackingUrl":Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;
    if-eqz v1, :cond_4

    const-string v6, "progress"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_4

    .line 640
    const-string v6, "(^[-.0-9]+%)"

    invoke-virtual {v1, v6}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 642
    const-string v6, "%"

    invoke-virtual {v1, v6}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v6

    invoke-virtual {v1, v9, v6}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lcom/auditude/ads/util/StringUtil;->convertToInt(Ljava/lang/String;)I

    move-result v6

    invoke-virtual {v5, v6}, Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;->setOffset(I)V

    .line 643
    const/4 v6, 0x1

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;->setOffsetIsPercent(Ljava/lang/Boolean;)V

    .line 644
    invoke-virtual {v3, v5}, Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;->addTrackingUrl(Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;)V

    .line 674
    .end local v1    # "strOffset":Ljava/lang/String;
    .end local v3    # "trackingEvent":Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;
    .end local v4    # "trackingEventType":Ljava/lang/String;
    .end local v5    # "trackingUrl":Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;
    :cond_1
    :goto_1
    iget-object v6, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    .line 618
    goto :goto_0

    .line 646
    .restart local v1    # "strOffset":Ljava/lang/String;
    .restart local v3    # "trackingEvent":Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;
    .restart local v4    # "trackingEventType":Ljava/lang/String;
    .restart local v5    # "trackingUrl":Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;
    :cond_2
    const-string v6, "(^[-.0-9]+:[-.0-9]+:[-.0-9]+$)"

    invoke-virtual {v1, v6}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 648
    invoke-static {v1}, Lcom/auditude/ads/util/StringUtil;->parseDuration(Ljava/lang/String;)I

    move-result v6

    mul-int/lit16 v6, v6, 0x3e8

    invoke-virtual {v5, v6}, Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;->setOffset(I)V

    .line 649
    invoke-static {v9}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;->setOffsetIsPercent(Ljava/lang/Boolean;)V

    .line 650
    invoke-virtual {v3, v5}, Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;->addTrackingUrl(Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;)V

    goto :goto_1

    .line 652
    :cond_3
    const-string v6, "(^[0-9]+$)"

    invoke-virtual {v1, v6}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 654
    invoke-static {v1}, Lcom/auditude/ads/util/StringUtil;->convertToInt(Ljava/lang/String;)I

    move-result v6

    mul-int/lit16 v6, v6, 0x3e8

    invoke-virtual {v5, v6}, Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;->setOffset(I)V

    .line 655
    invoke-static {v9}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;->setOffsetIsPercent(Ljava/lang/Boolean;)V

    .line 656
    invoke-virtual {v3, v5}, Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;->addTrackingUrl(Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;)V

    goto :goto_1

    .line 661
    :cond_4
    invoke-virtual {v3, v5}, Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;->addTrackingUrl(Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;)V

    goto :goto_1

    .line 666
    .end local v1    # "strOffset":Ljava/lang/String;
    .end local v3    # "trackingEvent":Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;
    .end local v4    # "trackingEventType":Ljava/lang/String;
    .end local v5    # "trackingUrl":Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;
    :cond_5
    const/4 v6, 0x3

    if-ne v0, v6, :cond_1

    .line 668
    const-string v6, "TrackingEvents"

    invoke-virtual {v6, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 676
    return-void
.end method

.method private parseVASTAdBase(Lcom/auditude/ads/network/vast/model/VASTAd;Lcom/auditude/ads/network/vast/model/VASTInlineAd;)V
    .locals 9
    .param p1, "ad"    # Lcom/auditude/ads/network/vast/model/VASTAd;
    .param p2, "vastInlineAd"    # Lcom/auditude/ads/network/vast/model/VASTInlineAd;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 146
    iget-object v5, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    .line 147
    .local v0, "eventType":I
    invoke-virtual {p1}, Lcom/auditude/ads/network/vast/model/VASTAd;->getID()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p2, v5}, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->setNetworkAdId(Ljava/lang/String;)V

    .line 150
    :goto_0
    iget-object v5, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v2

    .line 152
    .local v2, "tag":Ljava/lang/String;
    const/4 v5, 0x2

    if-ne v0, v5, :cond_9

    .line 154
    const-string v5, "VASTAdTagURI"

    invoke-virtual {v5, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 156
    instance-of v5, p2, Lcom/auditude/ads/network/vast/model/VASTWrapperAd;

    if-eqz v5, :cond_0

    move-object v5, p2

    .line 158
    check-cast v5, Lcom/auditude/ads/network/vast/model/VASTWrapperAd;

    iget-object v6, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v6

    const-string v7, "\t"

    const-string v8, ""

    invoke-virtual {v6, v7, v8}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, v5, Lcom/auditude/ads/network/vast/model/VASTWrapperAd;->source:Ljava/lang/String;

    .line 229
    :cond_0
    :goto_1
    iget-object v5, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    .line 148
    goto :goto_0

    .line 161
    :cond_1
    const-string v5, "AdSystem"

    invoke-virtual {v5, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 163
    iget-object v5, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v5

    const-string v6, "\t"

    const-string v7, ""

    invoke-virtual {v5, v6, v7}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, p2, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->adSystem:Ljava/lang/String;

    goto :goto_1

    .line 165
    :cond_2
    const-string v5, "AdTitle"

    invoke-virtual {v5, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 167
    iget-object v5, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v5

    const-string v6, "\t"

    const-string v7, ""

    invoke-virtual {v5, v6, v7}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, p2, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->adTitle:Ljava/lang/String;

    goto :goto_1

    .line 169
    :cond_3
    const-string v5, "Description"

    invoke-virtual {v5, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 171
    iget-object v5, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v5

    const-string v6, "\t"

    const-string v7, ""

    invoke-virtual {v5, v6, v7}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, p2, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->description:Ljava/lang/String;

    goto :goto_1

    .line 173
    :cond_4
    const-string v5, "Survey"

    invoke-virtual {v5, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_5

    .line 175
    iget-object v5, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v5

    const-string v6, "\t"

    const-string v7, ""

    invoke-virtual {v5, v6, v7}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, p2, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->surveyUrl:Ljava/lang/String;

    goto :goto_1

    .line 177
    :cond_5
    const-string v5, "Error"

    invoke-virtual {v5, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_6

    .line 179
    iget-object v5, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v5

    const-string v6, "\t"

    const-string v7, ""

    invoke-virtual {v5, v6, v7}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, p2, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->errorUrl:Ljava/lang/String;

    goto/16 :goto_1

    .line 181
    :cond_6
    const-string v5, "Impression"

    invoke-virtual {v5, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_7

    .line 183
    new-instance v1, Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;

    iget-object v5, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v5

    const-string v6, "\t"

    const-string v7, ""

    invoke-virtual {v5, v6, v7}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string v6, "creativeview"

    invoke-direct {v1, v5, v6}, Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 184
    .local v1, "impression":Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;
    invoke-virtual {p2, v1}, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->addImpressionUrl(Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;)V

    goto/16 :goto_1

    .line 186
    .end local v1    # "impression":Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;
    :cond_7
    const-string v5, "Creatives"

    invoke-virtual {v5, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_8

    .line 188
    invoke-virtual {p1}, Lcom/auditude/ads/network/vast/model/VASTAd;->getID()Ljava/lang/String;

    move-result-object v5

    invoke-direct {p0, p2, v5}, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parseCreatives(Lcom/auditude/ads/network/vast/model/VASTInlineAd;Ljava/lang/String;)V

    goto/16 :goto_1

    .line 190
    :cond_8
    const-string v5, "Extensions"

    invoke-virtual {v5, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 192
    invoke-direct {p0, p2}, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parseExtensions(Lcom/auditude/ads/network/vast/model/VASTAdBase;)V

    goto/16 :goto_1

    .line 195
    :cond_9
    const/4 v5, 0x3

    if-ne v0, v5, :cond_0

    .line 197
    iget-object v5, p2, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    if-eqz v5, :cond_b

    iget-object v5, p2, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->errorUrl:Ljava/lang/String;

    if-eqz v5, :cond_b

    iget-object v5, p2, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->errorUrl:Ljava/lang/String;

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v5

    if-lez v5, :cond_b

    .line 199
    iget-object v5, p2, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    const-string v6, "vasterror"

    invoke-virtual {v5, v6}, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->getTrackingEventByType(Ljava/lang/String;)Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;

    move-result-object v3

    .line 200
    .local v3, "trackingEvent":Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;
    if-nez v3, :cond_a

    .line 202
    new-instance v3, Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;

    .end local v3    # "trackingEvent":Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;
    const-string v5, "vasterror"

    invoke-direct {v3, v5}, Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;-><init>(Ljava/lang/String;)V

    .line 203
    .restart local v3    # "trackingEvent":Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;
    iget-object v5, p2, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    invoke-virtual {v5, v3}, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->addTrackingEvent(Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;)V

    .line 205
    :cond_a
    new-instance v4, Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;

    iget-object v5, p2, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->errorUrl:Ljava/lang/String;

    const-string v6, "vasterror"

    invoke-direct {v4, v5, v6}, Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 206
    .local v4, "vastTrackingUlr":Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;
    invoke-virtual {v3, v4}, Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;->addTrackingUrl(Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;)V

    .line 209
    .end local v3    # "trackingEvent":Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;
    .end local v4    # "vastTrackingUlr":Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;
    :cond_b
    const-string v5, "Wrapper"

    invoke-virtual {v5, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_c

    instance-of v5, p2, Lcom/auditude/ads/network/vast/model/VASTWrapperAd;

    if-eqz v5, :cond_c

    .line 211
    check-cast p2, Lcom/auditude/ads/network/vast/model/VASTWrapperAd;

    .end local p2    # "vastInlineAd":Lcom/auditude/ads/network/vast/model/VASTInlineAd;
    invoke-virtual {p1, p2}, Lcom/auditude/ads/network/vast/model/VASTAd;->setWrapperAd(Lcom/auditude/ads/network/vast/model/VASTWrapperAd;)V

    .line 231
    :goto_2
    return-void

    .line 214
    .restart local p2    # "vastInlineAd":Lcom/auditude/ads/network/vast/model/VASTInlineAd;
    :cond_c
    const-string v5, "InLine"

    invoke-virtual {v5, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 216
    iget-object v5, p2, Lcom/auditude/ads/network/vast/model/VASTInlineAd;->asInvalideXML:Ljava/lang/Boolean;

    invoke-virtual {v5}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v5

    if-eqz v5, :cond_d

    .line 219
    const/16 v5, 0x65

    invoke-direct {p0, p2, v5}, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->logVastError(Lcom/auditude/ads/network/vast/model/VASTInlineAd;I)V

    goto :goto_2

    .line 223
    :cond_d
    invoke-virtual {p1, p2}, Lcom/auditude/ads/network/vast/model/VASTAd;->addInlineAds(Lcom/auditude/ads/network/vast/model/VASTInlineAd;)V

    goto :goto_2
.end method

.method private parseXML(Lorg/xmlpull/v1/XmlPullParser;)Lcom/auditude/ads/network/vast/model/VASTDocument;
    .locals 8
    .param p1, "parser"    # Lorg/xmlpull/v1/XmlPullParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lorg/xmlpull/v1/XmlPullParserException;
        }
    .end annotation

    .prologue
    const/4 v5, 0x0

    .line 61
    const/4 v3, 0x0

    .line 63
    .local v3, "vastDocument":Lcom/auditude/ads/network/vast/model/VASTDocument;
    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v1

    .line 64
    .local v1, "eventType":I
    :goto_0
    const/4 v6, 0x1

    if-ne v1, v6, :cond_0

    .line 106
    .end local v3    # "vastDocument":Lcom/auditude/ads/network/vast/model/VASTDocument;
    :goto_1
    return-object v3

    .line 66
    .restart local v3    # "vastDocument":Lcom/auditude/ads/network/vast/model/VASTDocument;
    :cond_0
    packed-switch v1, :pswitch_data_0

    .line 103
    :cond_1
    :goto_2
    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v1

    goto :goto_0

    .line 69
    :pswitch_0
    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v2

    .line 70
    .local v2, "tagName":Ljava/lang/String;
    const-string v6, "VAST"

    invoke-virtual {v2, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_4

    .line 73
    const-string v6, "version"

    invoke-static {p1, v6, v5}, Lcom/auditude/ads/util/XMLUtil;->attributeAsStringOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 74
    .local v4, "version":Ljava/lang/String;
    invoke-static {v4}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_2

    move-object v3, v5

    goto :goto_1

    .line 75
    :cond_2
    const-string v6, "2.0"

    invoke-virtual {v6, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_3

    const-string v6, "2.0.0"

    invoke-virtual {v6, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_3

    const-string v6, "2.0.1"

    invoke-virtual {v6, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_3

    const-string v6, "3.0"

    invoke-virtual {v6, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_3

    move-object v3, v5

    .line 77
    goto :goto_1

    .line 80
    :cond_3
    new-instance v3, Lcom/auditude/ads/network/vast/model/VASTDocument;

    .end local v3    # "vastDocument":Lcom/auditude/ads/network/vast/model/VASTDocument;
    iget-object v6, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parentAd:Lcom/auditude/ads/network/vast/model/VASTAd;

    invoke-direct {v3, v6}, Lcom/auditude/ads/network/vast/model/VASTDocument;-><init>(Lcom/auditude/ads/network/vast/model/VASTAd;)V

    .line 81
    .restart local v3    # "vastDocument":Lcom/auditude/ads/network/vast/model/VASTDocument;
    iput-object v4, v3, Lcom/auditude/ads/network/vast/model/VASTDocument;->version:Ljava/lang/String;

    goto :goto_2

    .line 83
    .end local v4    # "version":Ljava/lang/String;
    :cond_4
    const-string v6, "Ad"

    invoke-virtual {v2, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 85
    invoke-direct {p0}, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parseAd()Lcom/auditude/ads/network/vast/model/VASTAd;

    move-result-object v0

    .line 86
    .local v0, "ad":Lcom/auditude/ads/network/vast/model/VASTAd;
    if-eqz v0, :cond_1

    .line 88
    invoke-virtual {v3, v0}, Lcom/auditude/ads/network/vast/model/VASTDocument;->addVASTAd(Lcom/auditude/ads/network/vast/model/VASTAd;)V

    goto :goto_2

    .line 93
    .end local v0    # "ad":Lcom/auditude/ads/network/vast/model/VASTAd;
    .end local v2    # "tagName":Ljava/lang/String;
    :pswitch_1
    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v6

    const-string v7, "VAST"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_1

    goto :goto_1

    .line 66
    nop

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method


# virtual methods
.method public final parse(Ljava/lang/String;)Lcom/auditude/ads/network/vast/model/VASTDocument;
    .locals 4
    .param p1, "value"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lorg/xmlpull/v1/XmlPullParserException;
        }
    .end annotation

    .prologue
    .line 37
    invoke-static {p1}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 40
    const/4 v1, 0x0

    .line 48
    :goto_0
    return-object v1

    .line 43
    :cond_0
    invoke-static {}, Lorg/xmlpull/v1/XmlPullParserFactory;->newInstance()Lorg/xmlpull/v1/XmlPullParserFactory;

    move-result-object v0

    .line 44
    .local v0, "factory":Lorg/xmlpull/v1/XmlPullParserFactory;
    invoke-virtual {v0}, Lorg/xmlpull/v1/XmlPullParserFactory;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v2

    iput-object v2, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    .line 45
    iget-object v2, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    new-instance v3, Ljava/io/StringReader;

    invoke-direct {v3, p1}, Ljava/io/StringReader;-><init>(Ljava/lang/String;)V

    invoke-interface {v2, v3}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/Reader;)V

    .line 47
    iget-object v2, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-direct {p0, v2}, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parseXML(Lorg/xmlpull/v1/XmlPullParser;)Lcom/auditude/ads/network/vast/model/VASTDocument;

    move-result-object v1

    .line 48
    .local v1, "vastDoc":Lcom/auditude/ads/network/vast/model/VASTDocument;
    goto :goto_0
.end method

.method public final parse(Lorg/xmlpull/v1/XmlPullParser;)Lcom/auditude/ads/network/vast/model/VASTDocument;
    .locals 2
    .param p1, "parser"    # Lorg/xmlpull/v1/XmlPullParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lorg/xmlpull/v1/XmlPullParserException;
        }
    .end annotation

    .prologue
    .line 53
    iput-object p1, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    .line 55
    iget-object v1, p0, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-direct {p0, v1}, Lcom/auditude/ads/network/vast/loader/VASTXMLParser;->parseXML(Lorg/xmlpull/v1/XmlPullParser;)Lcom/auditude/ads/network/vast/model/VASTDocument;

    move-result-object v0

    .line 56
    .local v0, "vastDoc":Lcom/auditude/ads/network/vast/model/VASTDocument;
    return-object v0
.end method

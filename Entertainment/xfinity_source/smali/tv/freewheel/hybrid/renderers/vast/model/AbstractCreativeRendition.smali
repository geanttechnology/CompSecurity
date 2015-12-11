.class public abstract Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;
.super Ljava/lang/Object;
.source "AbstractCreativeRendition.java"

# interfaces
.implements Ltv/freewheel/hybrid/renderers/vast/model/IVastValidation;


# instance fields
.field adParameters:Ljava/lang/String;

.field apiFramework:Ljava/lang/String;

.field assetContent:Ljava/lang/String;

.field assetURL:Ljava/lang/String;

.field public height:Ljava/lang/Integer;

.field public id:Ljava/lang/String;

.field protected logger:Ltv/freewheel/hybrid/utils/Logger;

.field private shouldInjectCallback:Z

.field type:Ljava/lang/String;

.field public width:Ljava/lang/Integer;


# direct methods
.method protected constructor <init>()V
    .locals 1

    .prologue
    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    const/4 v0, 0x0

    iput-boolean v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->shouldInjectCallback:Z

    .line 39
    invoke-static {p0}, Ltv/freewheel/hybrid/utils/Logger;->getLogger(Ljava/lang/Object;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->logger:Ltv/freewheel/hybrid/utils/Logger;

    .line 40
    return-void
.end method


# virtual methods
.method getAltText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    const/4 v0, 0x0

    return-object v0
.end method

.method abstract getClickThroughURL()Ljava/lang/String;
.end method

.method public getContentType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->type:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 66
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->type:Ljava/lang/String;

    invoke-static {v0}, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTypeTransform;->transform(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 68
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isSetAssetContentSuccessfully(Ljava/lang/String;)Z
    .locals 4
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 72
    const/4 v0, 0x1

    .line 73
    .local v0, "ret":Z
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->type:Ljava/lang/String;

    const-string v2, "image"

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 74
    const/4 v1, 0x1

    iput-boolean v1, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->shouldInjectCallback:Z

    .line 75
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->width:Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->height:Ljava/lang/Integer;

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    invoke-virtual {p0}, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->getAltText()Ljava/lang/String;

    move-result-object v3

    invoke-static {p1, v1, v2, v3}, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->image_TO_text_html_doc_lit_mobile(Ljava/lang/String;IILjava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->assetContent:Ljava/lang/String;

    .line 80
    :goto_0
    return v0

    .line 76
    :cond_0
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->type:Ljava/lang/String;

    const-string v2, "javascript"

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 77
    invoke-static {p1}, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->text_js_ref_TO_text_html_doc_lit_mobile(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->assetContent:Ljava/lang/String;

    goto :goto_0

    .line 79
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isValid(Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)Z
    .locals 4
    .param p1, "slot"    # Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    .param p2, "constants"    # Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    .prologue
    const-wide/16 v2, 0x0

    .line 61
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->width:Ljava/lang/Integer;

    if-eqz v0, :cond_1

    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->width:Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    int-to-double v0, v0

    cmpl-double v0, v0, v2

    if-lez v0, :cond_1

    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->height:Ljava/lang/Integer;

    if-eqz v0, :cond_1

    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->height:Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    int-to-double v0, v0

    cmpl-double v0, v0, v2

    if-lez v0, :cond_1

    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->type:Ljava/lang/String;

    if-eqz v0, :cond_1

    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->assetURL:Ljava/lang/String;

    if-nez v0, :cond_0

    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->assetContent:Ljava/lang/String;

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public parse(Lorg/w3c/dom/Element;)V
    .locals 1
    .param p1, "node"    # Lorg/w3c/dom/Element;

    .prologue
    .line 53
    const-string v0, "id"

    invoke-interface {p1, v0}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->id:Ljava/lang/String;

    .line 54
    const-string v0, "width"

    invoke-interface {p1, v0}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ltv/freewheel/hybrid/renderers/vast/util/StringUtils;->parseInt(Ljava/lang/String;)I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->width:Ljava/lang/Integer;

    .line 55
    const-string v0, "height"

    invoke-interface {p1, v0}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ltv/freewheel/hybrid/renderers/vast/util/StringUtils;->parseInt(Ljava/lang/String;)I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->height:Ljava/lang/Integer;

    .line 56
    const-string v0, "apiFramework"

    invoke-interface {p1, v0}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->apiFramework:Ljava/lang/String;

    .line 57
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 44
    const-string v0, "[[%s] id=%s assetURL=%s assetContent=%s  width=%d height=%d type=%s apiFramework=%s]"

    const/16 v1, 0x8

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-super {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->id:Ljava/lang/String;

    aput-object v3, v1, v2

    const/4 v2, 0x2

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->assetURL:Ljava/lang/String;

    aput-object v3, v1, v2

    const/4 v2, 0x3

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->assetContent:Ljava/lang/String;

    aput-object v3, v1, v2

    const/4 v2, 0x4

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->width:Ljava/lang/Integer;

    aput-object v3, v1, v2

    const/4 v2, 0x5

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->height:Ljava/lang/Integer;

    aput-object v3, v1, v2

    const/4 v2, 0x6

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->type:Ljava/lang/String;

    aput-object v3, v1, v2

    const/4 v2, 0x7

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->apiFramework:Ljava/lang/String;

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public translateToFWCreativeRendition(Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;Ltv/freewheel/hybrid/ad/interfaces/IConstants;)V
    .locals 15
    .param p1, "cr"    # Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;
    .param p2, "adi"    # Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;
    .param p3, "hostAdi"    # Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;
    .param p4, "constants"    # Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    .prologue
    .line 88
    invoke-virtual {p0}, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->getContentType()Ljava/lang/String;

    move-result-object v12

    move-object/from16 v0, p1

    invoke-interface {v0, v12}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->setContentType(Ljava/lang/String;)V

    .line 91
    iget-object v12, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->apiFramework:Ljava/lang/String;

    if-eqz v12, :cond_3

    iget-object v12, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->apiFramework:Ljava/lang/String;

    const-string v13, "MRAID"

    invoke-virtual {v12, v13}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v12

    if-eqz v12, :cond_3

    .line 92
    const-string v12, "MRAID-1.0"

    move-object/from16 v0, p1

    invoke-interface {v0, v12}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->setCreativeAPI(Ljava/lang/String;)V

    .line 98
    :cond_0
    :goto_0
    iget-object v12, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->adParameters:Ljava/lang/String;

    if-eqz v12, :cond_1

    .line 99
    const/4 v9, 0x0

    .line 101
    .local v9, "uri":Ljava/net/URI;
    :try_start_0
    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    const-string v13, "http://fakehost?"

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    iget-object v13, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->adParameters:Ljava/lang/String;

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-static {v12}, Ljava/net/URI;->create(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v9

    .line 102
    const-string v12, "UTF-8"

    invoke-static {v9, v12}, Lorg/apache/http/client/utils/URLEncodedUtils;->parse(Ljava/net/URI;Ljava/lang/String;)Ljava/util/List;

    move-result-object v5

    .line 103
    .local v5, "list":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/NameValuePair;>;"
    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v12

    if-eqz v12, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lorg/apache/http/NameValuePair;

    .line 104
    .local v6, "nvp":Lorg/apache/http/NameValuePair;
    invoke-interface {v6}, Lorg/apache/http/NameValuePair;->getName()Ljava/lang/String;

    move-result-object v12

    invoke-interface {v6}, Lorg/apache/http/NameValuePair;->getValue()Ljava/lang/String;

    move-result-object v13

    move-object/from16 v0, p1

    invoke-interface {v0, v12, v13}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->setParameter(Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 106
    .end local v4    # "i$":Ljava/util/Iterator;
    .end local v5    # "list":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/NameValuePair;>;"
    .end local v6    # "nvp":Lorg/apache/http/NameValuePair;
    :catch_0
    move-exception v3

    .line 107
    .local v3, "e":Ljava/lang/Throwable;
    iget-object v12, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    const-string v14, "Invalid adParameters:"

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    iget-object v14, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->adParameters:Ljava/lang/String;

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 111
    .end local v3    # "e":Ljava/lang/Throwable;
    .end local v9    # "uri":Ljava/net/URI;
    :cond_1
    iget-object v12, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->width:Ljava/lang/Integer;

    invoke-virtual {v12}, Ljava/lang/Integer;->intValue()I

    move-result v12

    move-object/from16 v0, p1

    invoke-interface {v0, v12}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->setWidth(I)V

    .line 112
    iget-object v12, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->height:Ljava/lang/Integer;

    invoke-virtual {v12}, Ljava/lang/Integer;->intValue()I

    move-result v12

    move-object/from16 v0, p1

    invoke-interface {v0, v12}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->setHeight(I)V

    .line 113
    invoke-interface/range {p1 .. p1}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->getWrapperURL()Ljava/lang/String;

    move-result-object v12

    if-nez v12, :cond_2

    .line 114
    iget-object v12, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->id:Ljava/lang/String;

    const/4 v13, 0x1

    move-object/from16 v0, p1

    invoke-interface {v0, v12, v13}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->createCreativeRenditionAssetForTranslation(Ljava/lang/String;Z)Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;

    move-result-object v1

    .line 115
    .local v1, "asset":Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;
    invoke-virtual {p0}, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->getContentType()Ljava/lang/String;

    move-result-object v12

    invoke-interface {v1, v12}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;->setContentType(Ljava/lang/String;)V

    .line 116
    iget-object v12, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->type:Ljava/lang/String;

    invoke-interface {v1, v12}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;->setMimeType(Ljava/lang/String;)V

    .line 117
    iget-object v12, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->assetURL:Ljava/lang/String;

    if-eqz v12, :cond_4

    .line 118
    iget-object v12, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->assetURL:Ljava/lang/String;

    invoke-interface {v1, v12}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;->setURL(Ljava/lang/String;)V

    .line 140
    :goto_2
    invoke-virtual {p0, v1}, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->translateToFWCreativeRenditionAsset(Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;)V

    .line 141
    iget-object v12, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    const-string v14, "translate to asset (content type:"

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;->getContentType()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    const-string v14, ",mime type:"

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;->getMimeType()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    const-string v14, ", url:"

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;->getURL()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    const-string v14, ",content:"

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;->getContent()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 145
    .end local v1    # "asset":Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;
    :cond_2
    iget-object v12, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    const-string v14, "translate to content type:"

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-interface/range {p1 .. p1}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->getContentType()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 146
    iget-object v12, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    const-string v14, "translate to width:"

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-interface/range {p1 .. p1}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->getWidth()I

    move-result v14

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v13

    const-string v14, ",height="

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-interface/range {p1 .. p1}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->getHeight()I

    move-result v14

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 147
    return-void

    .line 93
    :cond_3
    iget-object v12, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->apiFramework:Ljava/lang/String;

    if-eqz v12, :cond_0

    iget-object v12, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->apiFramework:Ljava/lang/String;

    const-string v13, "VPAID"

    invoke-virtual {v12, v13}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v12

    if-eqz v12, :cond_0

    .line 94
    const-string v12, "VPAID"

    move-object/from16 v0, p1

    invoke-interface {v0, v12}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRendition;->setCreativeAPI(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 120
    .restart local v1    # "asset":Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;
    :cond_4
    iget-boolean v12, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->shouldInjectCallback:Z

    if-eqz v12, :cond_7

    .line 121
    const/4 v2, 0x0

    .line 122
    .local v2, "clickURL":Ljava/lang/String;
    invoke-virtual {p0}, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->getClickThroughURL()Ljava/lang/String;

    move-result-object v10

    .line 123
    .local v10, "url":Ljava/lang/String;
    if-eqz v10, :cond_5

    .line 124
    invoke-interface/range {p4 .. p4}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_CLICK()Ljava/lang/String;

    move-result-object v12

    move-object/from16 v0, p2

    invoke-interface {v0, v10, v12}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->setClickThroughURL(Ljava/lang/String;Ljava/lang/String;)V

    .line 125
    invoke-interface/range {p4 .. p4}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_CLICK()Ljava/lang/String;

    move-result-object v12

    invoke-interface/range {p4 .. p4}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_TYPE_CLICK()Ljava/lang/String;

    move-result-object v13

    move-object/from16 v0, p2

    invoke-interface {v0, v12, v13}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->getEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v11

    .line 126
    .local v11, "urls":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    if-eqz v11, :cond_5

    invoke-virtual {v11}, Ljava/util/ArrayList;->size()I

    move-result v12

    if-lez v12, :cond_5

    .line 127
    const/4 v12, 0x0

    invoke-virtual {v11, v12}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    .end local v2    # "clickURL":Ljava/lang/String;
    check-cast v2, Ljava/lang/String;

    .line 130
    .end local v11    # "urls":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    .restart local v2    # "clickURL":Ljava/lang/String;
    :cond_5
    invoke-interface/range {p4 .. p4}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_CLICK()Ljava/lang/String;

    move-result-object v12

    invoke-interface/range {p4 .. p4}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_TYPE_CLICK_TRACKING()Ljava/lang/String;

    move-result-object v13

    move-object/from16 v0, p2

    invoke-interface {v0, v12, v13}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->getEventCallbackURLs(Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v8

    .line 131
    .local v8, "trackingURLs":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    iget-object v12, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    const-string v14, "injected tracking urls:"

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v8}, Ljava/util/ArrayList;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 132
    const/4 v7, 0x0

    .line 133
    .local v7, "safeId":Ljava/lang/String;
    if-eqz p2, :cond_6

    invoke-interface/range {p2 .. p2}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->getSlot()Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    move-result-object v12

    if-eqz v12, :cond_6

    .line 134
    invoke-interface/range {p2 .. p2}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->getSlot()Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    move-result-object v12

    invoke-interface {v12}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getCustomId()Ljava/lang/String;

    move-result-object v7

    .line 136
    :cond_6
    iget-object v12, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->assetContent:Ljava/lang/String;

    invoke-static {v12, v2, v8, v7}, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->injectCallback(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    iput-object v12, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->assetContent:Ljava/lang/String;

    .line 138
    .end local v2    # "clickURL":Ljava/lang/String;
    .end local v7    # "safeId":Ljava/lang/String;
    .end local v8    # "trackingURLs":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    .end local v10    # "url":Ljava/lang/String;
    :cond_7
    iget-object v12, p0, Ltv/freewheel/hybrid/renderers/vast/model/AbstractCreativeRendition;->assetContent:Ljava/lang/String;

    invoke-interface {v1, v12}, Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;->setContent(Ljava/lang/String;)V

    goto/16 :goto_2
.end method

.method public translateToFWCreativeRenditionAsset(Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;)V
    .locals 0
    .param p1, "asset"    # Ltv/freewheel/hybrid/ad/interfaces/ICreativeRenditionAsset;

    .prologue
    .line 86
    return-void
.end method

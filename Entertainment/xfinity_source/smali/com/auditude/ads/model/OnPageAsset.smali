.class public Lcom/auditude/ads/model/OnPageAsset;
.super Lcom/auditude/ads/model/Asset;
.source "OnPageAsset.java"

# interfaces
.implements Lcom/auditude/ads/model/IOnPageAsset;


# instance fields
.field private altText:Ljava/lang/String;

.field private source:Ljava/lang/String;

.field private staticAsset:Lcom/auditude/ads/model/IOnPageAsset;


# direct methods
.method public constructor <init>(Lcom/auditude/ads/model/BaseElement;)V
    .locals 1
    .param p1, "parent"    # Lcom/auditude/ads/model/BaseElement;

    .prologue
    .line 19
    invoke-direct {p0, p1}, Lcom/auditude/ads/model/Asset;-><init>(Lcom/auditude/ads/model/BaseElement;)V

    .line 20
    const-string v0, "onpage"

    invoke-virtual {p0, v0}, Lcom/auditude/ads/model/OnPageAsset;->setFormat(Ljava/lang/String;)V

    .line 21
    return-void
.end method


# virtual methods
.method public CopyTo(Lcom/auditude/ads/model/Asset;)V
    .locals 3
    .param p1, "asset"    # Lcom/auditude/ads/model/Asset;

    .prologue
    .line 150
    invoke-super {p0, p1}, Lcom/auditude/ads/model/Asset;->CopyTo(Lcom/auditude/ads/model/Asset;)V

    .line 154
    invoke-virtual {p1}, Lcom/auditude/ads/model/Asset;->getClick()Lcom/auditude/ads/model/IClick;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-virtual {p0}, Lcom/auditude/ads/model/OnPageAsset;->getClick()Lcom/auditude/ads/model/IClick;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 156
    invoke-virtual {p0}, Lcom/auditude/ads/model/OnPageAsset;->getClick()Lcom/auditude/ads/model/IClick;

    move-result-object v0

    .line 157
    .local v0, "tempVar":Lcom/auditude/ads/model/IClick;
    invoke-virtual {p1}, Lcom/auditude/ads/model/Asset;->getClick()Lcom/auditude/ads/model/IClick;

    move-result-object v1

    check-cast v1, Lcom/auditude/ads/model/Click;

    instance-of v2, v0, Lcom/auditude/ads/model/Click;

    if-eqz v2, :cond_1

    move-object v2, v0

    :goto_0
    check-cast v2, Lcom/auditude/ads/model/Click;

    invoke-virtual {v1, v2}, Lcom/auditude/ads/model/Click;->setBaseTrackingClick(Lcom/auditude/ads/model/Click;)V

    .line 159
    .end local v0    # "tempVar":Lcom/auditude/ads/model/IClick;
    :cond_0
    return-void

    .line 157
    .restart local v0    # "tempVar":Lcom/auditude/ads/model/IClick;
    :cond_1
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public clone()Lcom/auditude/ads/model/OnPageAsset;
    .locals 2

    .prologue
    .line 163
    new-instance v0, Lcom/auditude/ads/model/OnPageAsset;

    invoke-virtual {p0}, Lcom/auditude/ads/model/OnPageAsset;->getParent()Lcom/auditude/ads/model/BaseElement;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/auditude/ads/model/OnPageAsset;-><init>(Lcom/auditude/ads/model/BaseElement;)V

    .line 165
    .local v0, "asset":Lcom/auditude/ads/model/OnPageAsset;
    invoke-virtual {p0}, Lcom/auditude/ads/model/OnPageAsset;->getState()Ljava/util/HashMap;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/auditude/ads/model/OnPageAsset;->setState(Ljava/util/HashMap;)V

    .line 166
    invoke-virtual {p0}, Lcom/auditude/ads/model/OnPageAsset;->getID()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/auditude/ads/model/OnPageAsset;->setID(Ljava/lang/String;)V

    .line 167
    invoke-virtual {p0}, Lcom/auditude/ads/model/OnPageAsset;->getTrackingEvents()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/auditude/ads/model/OnPageAsset;->setTrackingEvents(Ljava/util/ArrayList;)V

    .line 169
    invoke-virtual {p0}, Lcom/auditude/ads/model/OnPageAsset;->getTitle()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/auditude/ads/model/OnPageAsset;->setTitle(Ljava/lang/String;)V

    .line 170
    invoke-virtual {p0}, Lcom/auditude/ads/model/OnPageAsset;->getDescription()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/auditude/ads/model/OnPageAsset;->setDescription(Ljava/lang/String;)V

    .line 171
    invoke-virtual {p0}, Lcom/auditude/ads/model/OnPageAsset;->getFormat()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/auditude/ads/model/OnPageAsset;->setFormat(Ljava/lang/String;)V

    .line 172
    invoke-virtual {p0}, Lcom/auditude/ads/model/OnPageAsset;->getResourceType()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/auditude/ads/model/OnPageAsset;->setResourceType(Ljava/lang/String;)V

    .line 173
    invoke-virtual {p0}, Lcom/auditude/ads/model/OnPageAsset;->getCreativeType()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/auditude/ads/model/OnPageAsset;->setCreativeType(Ljava/lang/String;)V

    .line 174
    invoke-virtual {p0}, Lcom/auditude/ads/model/OnPageAsset;->getApiFramework()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/auditude/ads/model/OnPageAsset;->setApiFramework(Ljava/lang/String;)V

    .line 175
    invoke-virtual {p0}, Lcom/auditude/ads/model/OnPageAsset;->getAdParameters()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/auditude/ads/model/OnPageAsset;->setAdParameters(Ljava/lang/String;)V

    .line 176
    invoke-virtual {p0}, Lcom/auditude/ads/model/OnPageAsset;->getCustomData()Ljava/util/HashMap;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/auditude/ads/model/OnPageAsset;->setCustomData(Ljava/util/HashMap;)V

    .line 177
    invoke-virtual {p0}, Lcom/auditude/ads/model/OnPageAsset;->getAuditudeParams()Ljava/util/HashMap;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/auditude/ads/model/OnPageAsset;->setAuditudeParams(Ljava/util/HashMap;)V

    .line 178
    invoke-virtual {p0}, Lcom/auditude/ads/model/OnPageAsset;->getDurationInMillis()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/auditude/ads/model/OnPageAsset;->setDurationInMillis(I)V

    .line 179
    invoke-virtual {p0}, Lcom/auditude/ads/model/OnPageAsset;->getLeadTimeInMillis()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/auditude/ads/model/OnPageAsset;->setLeadTimeInMillis(I)V

    .line 180
    invoke-virtual {p0}, Lcom/auditude/ads/model/OnPageAsset;->getClick()Lcom/auditude/ads/model/IClick;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/auditude/ads/model/OnPageAsset;->setClick(Lcom/auditude/ads/model/IClick;)V

    .line 181
    invoke-virtual {p0}, Lcom/auditude/ads/model/OnPageAsset;->getMediaFiles()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/auditude/ads/model/OnPageAsset;->setMediaFiles(Ljava/util/ArrayList;)V

    .line 183
    invoke-virtual {p0}, Lcom/auditude/ads/model/OnPageAsset;->getAltText()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/auditude/ads/model/OnPageAsset;->setAltText(Ljava/lang/String;)V

    .line 184
    iget-object v1, p0, Lcom/auditude/ads/model/OnPageAsset;->source:Ljava/lang/String;

    iput-object v1, v0, Lcom/auditude/ads/model/OnPageAsset;->source:Ljava/lang/String;

    .line 186
    return-object v0
.end method

.method public bridge synthetic clone()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    .line 1
    invoke-virtual {p0}, Lcom/auditude/ads/model/OnPageAsset;->clone()Lcom/auditude/ads/model/OnPageAsset;

    move-result-object v0

    return-object v0
.end method

.method public final getAltText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/auditude/ads/model/OnPageAsset;->altText:Ljava/lang/String;

    return-object v0
.end method

.method public getResourceType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 58
    invoke-super {p0}, Lcom/auditude/ads/model/Asset;->getResourceType()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 26
    const-string v0, "companion"

    return-object v0
.end method

.method public final setAltText(Ljava/lang/String;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 41
    iput-object p1, p0, Lcom/auditude/ads/model/OnPageAsset;->altText:Ljava/lang/String;

    .line 42
    return-void
.end method

.method public setResourceType(Ljava/lang/String;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 63
    invoke-super {p0, p1}, Lcom/auditude/ads/model/Asset;->setResourceType(Ljava/lang/String;)V

    .line 64
    return-void
.end method

.method public final setStaticAsset(Lcom/auditude/ads/model/IOnPageAsset;)V
    .locals 0
    .param p1, "value"    # Lcom/auditude/ads/model/IOnPageAsset;

    .prologue
    .line 100
    iput-object p1, p0, Lcom/auditude/ads/model/OnPageAsset;->staticAsset:Lcom/auditude/ads/model/IOnPageAsset;

    .line 101
    return-void
.end method

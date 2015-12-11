.class public Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;
.super Ljava/lang/Object;
.source "AnalyticsAssetInfo.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/annotation/JsonInclude;
    value = .enum Lcom/fasterxml/jackson/annotation/JsonInclude$Include;->NON_NULL:Lcom/fasterxml/jackson/annotation/JsonInclude$Include;
.end annotation


# instance fields
.field private AssetID:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "AID"
    .end annotation
.end field

.field private ProviderID:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "PID"
    .end annotation
.end field

.field private actors:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "ACTORS"
    .end annotation
.end field

.field private availableData:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "AVAIL"
    .end annotation
.end field

.field private category:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "CAT"
    .end annotation
.end field

.field private channelName:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "CH_NAME"
    .end annotation
.end field

.field private channelNumber:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "CH_NUM"
    .end annotation
.end field

.field private drmProtected:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "PROTECT"
    .end annotation
.end field

.field private duration:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "DUR"
    .end annotation
.end field

.field private endTime:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "END"
    .end annotation
.end field

.field private expirationDate:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "EXPIR"
    .end annotation
.end field

.field private genre:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "GENRE"
    .end annotation
.end field

.field private hasClosedCaptions:Ljava/lang/Boolean;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "CC"
    .end annotation
.end field

.field private is3D:Ljava/lang/Boolean;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "3D"
    .end annotation
.end field

.field private isHD:Ljava/lang/Boolean;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "HD"
    .end annotation
.end field

.field private languages:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "LANG"
    .end annotation
.end field

.field private manifestUrl:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "URL"
    .end annotation
.end field

.field private providerIdentifier:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "PROVIDER"
    .end annotation
.end field

.field private rating:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "RATING"
    .end annotation
.end field

.field private releaseYear:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "YEAR"
    .end annotation
.end field

.field private startTime:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "START"
    .end annotation
.end field

.field private title:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "TITLE"
    .end annotation
.end field

.field private type:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "TYPE"
    .end annotation
.end field

.field private viewingPrice:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "PRICE"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getActors()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 272
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->actors:Ljava/lang/String;

    return-object v0
.end method

.method public getAssetID()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 371
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->AssetID:Ljava/lang/String;

    return-object v0
.end method

.method public getAvailableData()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 299
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->availableData:Ljava/lang/String;

    return-object v0
.end method

.method public getCategory()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 245
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->category:Ljava/lang/String;

    return-object v0
.end method

.method public getChannelName()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 335
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->channelName:Ljava/lang/String;

    return-object v0
.end method

.method public getChannelNumber()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 326
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->channelNumber:Ljava/lang/String;

    return-object v0
.end method

.method public getDrmProtected()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 290
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->drmProtected:Ljava/lang/String;

    return-object v0
.end method

.method public getDuration()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 191
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->duration:Ljava/lang/String;

    return-object v0
.end method

.method public getEndTime()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 353
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->endTime:Ljava/lang/String;

    return-object v0
.end method

.method public getExpirationDate()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 308
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->expirationDate:Ljava/lang/String;

    return-object v0
.end method

.method public getGenre()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 254
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->genre:Ljava/lang/String;

    return-object v0
.end method

.method public getLanguages()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 227
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->languages:Ljava/lang/String;

    return-object v0
.end method

.method public getManifestUrl()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 362
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->manifestUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getProviderID()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 164
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->ProviderID:Ljava/lang/String;

    return-object v0
.end method

.method public getProviderIdentifier()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 173
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->providerIdentifier:Ljava/lang/String;

    return-object v0
.end method

.method public getRating()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 281
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->rating:Ljava/lang/String;

    return-object v0
.end method

.method public getReleaseYear()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 263
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->releaseYear:Ljava/lang/String;

    return-object v0
.end method

.method public getStartTime()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 344
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->startTime:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 182
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->title:Ljava/lang/String;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 236
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->type:Ljava/lang/String;

    return-object v0
.end method

.method public getViewingPrice()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 317
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->viewingPrice:Ljava/lang/String;

    return-object v0
.end method

.method public setActors(Ljava/lang/String;)V
    .locals 0
    .param p1, "actors"    # Ljava/lang/String;

    .prologue
    .line 276
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->actors:Ljava/lang/String;

    .line 277
    return-void
.end method

.method public setAssetID(Ljava/lang/String;)V
    .locals 0
    .param p1, "assetID"    # Ljava/lang/String;

    .prologue
    .line 375
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->AssetID:Ljava/lang/String;

    .line 376
    return-void
.end method

.method public setAvailableData(Ljava/lang/String;)V
    .locals 0
    .param p1, "availableData"    # Ljava/lang/String;

    .prologue
    .line 303
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->availableData:Ljava/lang/String;

    .line 304
    return-void
.end method

.method public setCategory(Ljava/lang/String;)V
    .locals 0
    .param p1, "category"    # Ljava/lang/String;

    .prologue
    .line 249
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->category:Ljava/lang/String;

    .line 250
    return-void
.end method

.method public setChannelName(Ljava/lang/String;)V
    .locals 0
    .param p1, "channelName"    # Ljava/lang/String;

    .prologue
    .line 339
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->channelName:Ljava/lang/String;

    .line 340
    return-void
.end method

.method public setChannelNumber(Ljava/lang/String;)V
    .locals 0
    .param p1, "channelNumber"    # Ljava/lang/String;

    .prologue
    .line 330
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->channelNumber:Ljava/lang/String;

    .line 331
    return-void
.end method

.method public setDrmProtected(Ljava/lang/String;)V
    .locals 0
    .param p1, "drmProtected"    # Ljava/lang/String;

    .prologue
    .line 294
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->drmProtected:Ljava/lang/String;

    .line 295
    return-void
.end method

.method public setDuration(Ljava/lang/String;)V
    .locals 0
    .param p1, "duration"    # Ljava/lang/String;

    .prologue
    .line 195
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->duration:Ljava/lang/String;

    .line 196
    return-void
.end method

.method public setEndTime(Ljava/lang/String;)V
    .locals 0
    .param p1, "endTime"    # Ljava/lang/String;

    .prologue
    .line 357
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->endTime:Ljava/lang/String;

    .line 358
    return-void
.end method

.method public setExpirationDate(Ljava/lang/String;)V
    .locals 0
    .param p1, "expirationDate"    # Ljava/lang/String;

    .prologue
    .line 312
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->expirationDate:Ljava/lang/String;

    .line 313
    return-void
.end method

.method public setGenre(Ljava/lang/String;)V
    .locals 0
    .param p1, "genre"    # Ljava/lang/String;

    .prologue
    .line 258
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->genre:Ljava/lang/String;

    .line 259
    return-void
.end method

.method public setHD(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "HD"    # Ljava/lang/Boolean;

    .prologue
    .line 204
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->isHD:Ljava/lang/Boolean;

    .line 205
    return-void
.end method

.method public setHasClosedCaptions(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "hasClosedCaptions"    # Ljava/lang/Boolean;

    .prologue
    .line 222
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->hasClosedCaptions:Ljava/lang/Boolean;

    .line 223
    return-void
.end method

.method public setIs3D(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "is3D"    # Ljava/lang/Boolean;

    .prologue
    .line 213
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->is3D:Ljava/lang/Boolean;

    .line 214
    return-void
.end method

.method public setLanguages(Ljava/lang/String;)V
    .locals 0
    .param p1, "languages"    # Ljava/lang/String;

    .prologue
    .line 231
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->languages:Ljava/lang/String;

    .line 232
    return-void
.end method

.method public setManifestUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "manifestUrl"    # Ljava/lang/String;

    .prologue
    .line 366
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->manifestUrl:Ljava/lang/String;

    .line 367
    return-void
.end method

.method public setProviderID(Ljava/lang/String;)V
    .locals 0
    .param p1, "providerID"    # Ljava/lang/String;

    .prologue
    .line 168
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->ProviderID:Ljava/lang/String;

    .line 169
    return-void
.end method

.method public setProviderIdentifier(Ljava/lang/String;)V
    .locals 0
    .param p1, "providerIdentifier"    # Ljava/lang/String;

    .prologue
    .line 177
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->providerIdentifier:Ljava/lang/String;

    .line 178
    return-void
.end method

.method public setRating(Ljava/lang/String;)V
    .locals 0
    .param p1, "rating"    # Ljava/lang/String;

    .prologue
    .line 285
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->rating:Ljava/lang/String;

    .line 286
    return-void
.end method

.method public setReleaseYear(Ljava/lang/String;)V
    .locals 0
    .param p1, "releaseYear"    # Ljava/lang/String;

    .prologue
    .line 267
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->releaseYear:Ljava/lang/String;

    .line 268
    return-void
.end method

.method public setStartTime(Ljava/lang/String;)V
    .locals 0
    .param p1, "startTime"    # Ljava/lang/String;

    .prologue
    .line 348
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->startTime:Ljava/lang/String;

    .line 349
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "title"    # Ljava/lang/String;

    .prologue
    .line 186
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->title:Ljava/lang/String;

    .line 187
    return-void
.end method

.method public setType(Ljava/lang/String;)V
    .locals 0
    .param p1, "type"    # Ljava/lang/String;

    .prologue
    .line 240
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->type:Ljava/lang/String;

    .line 241
    return-void
.end method

.method public setViewingPrice(Ljava/lang/String;)V
    .locals 0
    .param p1, "viewingPrice"    # Ljava/lang/String;

    .prologue
    .line 321
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;->viewingPrice:Ljava/lang/String;

    .line 322
    return-void
.end method

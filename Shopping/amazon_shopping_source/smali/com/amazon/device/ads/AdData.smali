.class Lcom/amazon/device/ads/AdData;
.super Ljava/lang/Object;
.source "AdData.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/device/ads/AdData$AAXCreative;
    }
.end annotation


# static fields
.field public static final CAN_EXPAND1_CT:I = 0x3eb

.field public static final CAN_EXPAND2_CT:I = 0x3ec

.field public static final CAN_PLAY_AUDIO1_CT:I = 0x3e9

.field public static final CAN_PLAY_AUDIO2_CT:I = 0x3ea

.field public static final CAN_PLAY_VIDEO_CT:I = 0x3f6

.field public static final HTML_CT:I = 0x3ef

.field public static final INTERSTITIAL_CT:I = 0x3f0

.field public static final MRAID1_CT:I = 0x3f8

.field public static final MRAID2_CT:I = 0x3f9


# instance fields
.field private connectionType:Ljava/lang/String;

.field private creative:Ljava/lang/String;

.field private creativeTypes:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/amazon/device/ads/AdData$AAXCreative;",
            ">;"
        }
    .end annotation
.end field

.field private expirationTimeMs:J

.field private fetched:Z

.field private height:I

.field private impPixelUrl:Ljava/lang/String;

.field private instrPixelUrl:Ljava/lang/String;

.field private isRendering:Z

.field private maxSize:Ljava/lang/String;

.field private metricsCollector:Lcom/amazon/device/ads/MetricsCollector;

.field private properties:Lcom/amazon/device/ads/AdProperties;

.field private final requestedAdSize:Lcom/amazon/device/ads/AdSize;

.field private screenHeight:I

.field private screenWidth:I

.field private slotId:I

.field private width:I


# direct methods
.method public constructor <init>(Lcom/amazon/device/ads/AdSize;)V
    .locals 2
    .param p1, "requestedAdSize"    # Lcom/amazon/device/ads/AdSize;

    .prologue
    const/4 v0, 0x0

    .line 105
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    iput v0, p0, Lcom/amazon/device/ads/AdData;->height:I

    .line 35
    iput v0, p0, Lcom/amazon/device/ads/AdData;->width:I

    .line 36
    iput v0, p0, Lcom/amazon/device/ads/AdData;->screenHeight:I

    .line 37
    iput v0, p0, Lcom/amazon/device/ads/AdData;->screenWidth:I

    .line 43
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/amazon/device/ads/AdData;->expirationTimeMs:J

    .line 106
    iput-object p1, p0, Lcom/amazon/device/ads/AdData;->requestedAdSize:Lcom/amazon/device/ads/AdSize;

    .line 107
    new-instance v0, Lcom/amazon/device/ads/MetricsCollector;

    invoke-direct {v0}, Lcom/amazon/device/ads/MetricsCollector;-><init>()V

    iput-object v0, p0, Lcom/amazon/device/ads/AdData;->metricsCollector:Lcom/amazon/device/ads/MetricsCollector;

    .line 108
    return-void
.end method


# virtual methods
.method public getConnectionType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 313
    iget-object v0, p0, Lcom/amazon/device/ads/AdData;->connectionType:Ljava/lang/String;

    return-object v0
.end method

.method protected getCreative()Ljava/lang/String;
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lcom/amazon/device/ads/AdData;->creative:Ljava/lang/String;

    return-object v0
.end method

.method protected getCreativeTypes()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Lcom/amazon/device/ads/AdData$AAXCreative;",
            ">;"
        }
    .end annotation

    .prologue
    .line 155
    iget-object v0, p0, Lcom/amazon/device/ads/AdData;->creativeTypes:Ljava/util/Set;

    return-object v0
.end method

.method protected getHeight()I
    .locals 1

    .prologue
    .line 172
    iget v0, p0, Lcom/amazon/device/ads/AdData;->height:I

    return v0
.end method

.method protected getImpressionPixelUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 260
    iget-object v0, p0, Lcom/amazon/device/ads/AdData;->impPixelUrl:Ljava/lang/String;

    return-object v0
.end method

.method protected getInstrumentationPixelUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 242
    iget-object v0, p0, Lcom/amazon/device/ads/AdData;->instrPixelUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getIsFetched()Z
    .locals 1

    .prologue
    .line 295
    iget-boolean v0, p0, Lcom/amazon/device/ads/AdData;->fetched:Z

    return v0
.end method

.method protected getIsRendering()Z
    .locals 1

    .prologue
    .line 278
    iget-boolean v0, p0, Lcom/amazon/device/ads/AdData;->isRendering:Z

    return v0
.end method

.method public getMaxSize()Ljava/lang/String;
    .locals 1

    .prologue
    .line 372
    iget-object v0, p0, Lcom/amazon/device/ads/AdData;->maxSize:Ljava/lang/String;

    return-object v0
.end method

.method public getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;
    .locals 1

    .prologue
    .line 355
    iget-object v0, p0, Lcom/amazon/device/ads/AdData;->metricsCollector:Lcom/amazon/device/ads/MetricsCollector;

    return-object v0
.end method

.method protected getProperties()Lcom/amazon/device/ads/AdProperties;
    .locals 1

    .prologue
    .line 138
    iget-object v0, p0, Lcom/amazon/device/ads/AdData;->properties:Lcom/amazon/device/ads/AdProperties;

    return-object v0
.end method

.method protected getRequestedAdSize()Lcom/amazon/device/ads/AdSize;
    .locals 1

    .prologue
    .line 112
    iget-object v0, p0, Lcom/amazon/device/ads/AdData;->requestedAdSize:Lcom/amazon/device/ads/AdSize;

    return-object v0
.end method

.method protected getScreenHeight()I
    .locals 1

    .prologue
    .line 206
    iget v0, p0, Lcom/amazon/device/ads/AdData;->screenHeight:I

    return v0
.end method

.method protected getScreenWidth()I
    .locals 1

    .prologue
    .line 224
    iget v0, p0, Lcom/amazon/device/ads/AdData;->screenWidth:I

    return v0
.end method

.method public getSlotId()I
    .locals 1

    .prologue
    .line 329
    iget v0, p0, Lcom/amazon/device/ads/AdData;->slotId:I

    return v0
.end method

.method protected getWidth()I
    .locals 1

    .prologue
    .line 189
    iget v0, p0, Lcom/amazon/device/ads/AdData;->width:I

    return v0
.end method

.method public isExpired()Z
    .locals 7

    .prologue
    const/4 v2, 0x0

    .line 345
    iget-wide v3, p0, Lcom/amazon/device/ads/AdData;->expirationTimeMs:J

    const-wide/16 v5, 0x0

    cmp-long v3, v3, v5

    if-gez v3, :cond_1

    .line 350
    :cond_0
    :goto_0
    return v2

    .line 349
    :cond_1
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 350
    .local v0, "time":J
    iget-wide v3, p0, Lcom/amazon/device/ads/AdData;->expirationTimeMs:J

    cmp-long v3, v0, v3

    if-lez v3, :cond_0

    const/4 v2, 0x1

    goto :goto_0
.end method

.method public resetMetricsCollector()V
    .locals 1

    .prologue
    .line 363
    new-instance v0, Lcom/amazon/device/ads/MetricsCollector;

    invoke-direct {v0}, Lcom/amazon/device/ads/MetricsCollector;-><init>()V

    iput-object v0, p0, Lcom/amazon/device/ads/AdData;->metricsCollector:Lcom/amazon/device/ads/MetricsCollector;

    .line 364
    return-void
.end method

.method public setConnectionType(Ljava/lang/String;)V
    .locals 0
    .param p1, "connectionType"    # Ljava/lang/String;

    .prologue
    .line 308
    iput-object p1, p0, Lcom/amazon/device/ads/AdData;->connectionType:Ljava/lang/String;

    .line 309
    return-void
.end method

.method protected setCreative(Ljava/lang/String;)V
    .locals 0
    .param p1, "creative"    # Ljava/lang/String;

    .prologue
    .line 129
    iput-object p1, p0, Lcom/amazon/device/ads/AdData;->creative:Ljava/lang/String;

    .line 130
    return-void
.end method

.method protected setCreativeTypes(Ljava/util/Set;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Lcom/amazon/device/ads/AdData$AAXCreative;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 163
    .local p1, "creativeTypes":Ljava/util/Set;, "Ljava/util/Set<Lcom/amazon/device/ads/AdData$AAXCreative;>;"
    iput-object p1, p0, Lcom/amazon/device/ads/AdData;->creativeTypes:Ljava/util/Set;

    .line 164
    return-void
.end method

.method protected setExpirationTimeMillis(J)V
    .locals 0
    .param p1, "expirationTimeMs"    # J

    .prologue
    .line 337
    iput-wide p1, p0, Lcom/amazon/device/ads/AdData;->expirationTimeMs:J

    .line 338
    return-void
.end method

.method public setFetched(Z)V
    .locals 0
    .param p1, "fetched"    # Z

    .prologue
    .line 303
    iput-boolean p1, p0, Lcom/amazon/device/ads/AdData;->fetched:Z

    .line 304
    return-void
.end method

.method protected setHeight(I)V
    .locals 0
    .param p1, "height"    # I

    .prologue
    .line 180
    iput p1, p0, Lcom/amazon/device/ads/AdData;->height:I

    .line 181
    return-void
.end method

.method protected setImpressionPixelUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "impPixelUrl"    # Ljava/lang/String;

    .prologue
    .line 269
    iput-object p1, p0, Lcom/amazon/device/ads/AdData;->impPixelUrl:Ljava/lang/String;

    .line 270
    return-void
.end method

.method protected setInstrumentationPixelUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "instrPixelUrl"    # Ljava/lang/String;

    .prologue
    .line 251
    iput-object p1, p0, Lcom/amazon/device/ads/AdData;->instrPixelUrl:Ljava/lang/String;

    .line 252
    return-void
.end method

.method protected setIsRendering(Z)V
    .locals 0
    .param p1, "isRendering"    # Z

    .prologue
    .line 286
    iput-boolean p1, p0, Lcom/amazon/device/ads/AdData;->isRendering:Z

    .line 287
    return-void
.end method

.method public setMaxSize(Ljava/lang/String;)V
    .locals 0
    .param p1, "maxSize"    # Ljava/lang/String;

    .prologue
    .line 368
    iput-object p1, p0, Lcom/amazon/device/ads/AdData;->maxSize:Ljava/lang/String;

    .line 369
    return-void
.end method

.method protected setProperties(Lcom/amazon/device/ads/AdProperties;)V
    .locals 0
    .param p1, "properties"    # Lcom/amazon/device/ads/AdProperties;

    .prologue
    .line 146
    iput-object p1, p0, Lcom/amazon/device/ads/AdData;->properties:Lcom/amazon/device/ads/AdProperties;

    .line 147
    return-void
.end method

.method protected setScreenHeight(I)V
    .locals 0
    .param p1, "screenHeight"    # I

    .prologue
    .line 215
    iput p1, p0, Lcom/amazon/device/ads/AdData;->screenHeight:I

    .line 216
    return-void
.end method

.method protected setScreenWidth(I)V
    .locals 0
    .param p1, "screenWidth"    # I

    .prologue
    .line 233
    iput p1, p0, Lcom/amazon/device/ads/AdData;->screenWidth:I

    .line 234
    return-void
.end method

.method public setSlotId(I)V
    .locals 0
    .param p1, "slotId"    # I

    .prologue
    .line 321
    iput p1, p0, Lcom/amazon/device/ads/AdData;->slotId:I

    .line 322
    return-void
.end method

.method protected setWidth(I)V
    .locals 0
    .param p1, "width"    # I

    .prologue
    .line 197
    iput p1, p0, Lcom/amazon/device/ads/AdData;->width:I

    .line 198
    return-void
.end method

.class abstract Lcom/amazon/device/ads/AdRenderer;
.super Ljava/lang/Object;
.source "AdRenderer.java"

# interfaces
.implements Lcom/amazon/device/ads/AdView;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/device/ads/AdRenderer$AdState;
    }
.end annotation


# static fields
.field protected static final AAX_REDIRECT_BETA:Ljava/lang/String; = "aax-beta.integ.amazon.com"

.field protected static final AAX_REDIRECT_GAMMA:Ljava/lang/String; = "aax-us-east.amazon-adsystem.com"

.field protected static final AAX_REDIRECT_PROD:Ljava/lang/String; = "aax-us-east.amazon-adsystem.com"

.field protected static final CORNERSTONE_BEST_ENDPOINT_BETA:Ljava/lang/String; = "d16g-cornerstone-bes.integ.amazon.com"

.field protected static final CORNERSTONE_BEST_ENDPOINT_PROD:Ljava/lang/String; = "pda-bes.amazon.com"

.field private static final LOG_TAG:Ljava/lang/String; = "AdRenderer"


# instance fields
.field protected adData:Lcom/amazon/device/ads/AdData;

.field protected final context:Landroid/content/Context;

.field protected final controller:Lcom/amazon/device/ads/IAdController;

.field protected isDestroyed:Z

.field protected isInitialized:Z

.field private scalingMultiplier:D

.field protected viewRemoved:Z


# direct methods
.method protected constructor <init>(Lcom/amazon/device/ads/AdData;Lcom/amazon/device/ads/IAdController;Landroid/content/Context;)V
    .locals 2
    .param p1, "ad"    # Lcom/amazon/device/ads/AdData;
    .param p2, "controller"    # Lcom/amazon/device/ads/IAdController;
    .param p3, "context"    # Landroid/content/Context;

    .prologue
    const/4 v0, 0x0

    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    iput-boolean v0, p0, Lcom/amazon/device/ads/AdRenderer;->viewRemoved:Z

    .line 31
    iput-boolean v0, p0, Lcom/amazon/device/ads/AdRenderer;->isDestroyed:Z

    .line 32
    iput-boolean v0, p0, Lcom/amazon/device/ads/AdRenderer;->isInitialized:Z

    .line 34
    const-wide/high16 v0, 0x3ff0000000000000L    # 1.0

    iput-wide v0, p0, Lcom/amazon/device/ads/AdRenderer;->scalingMultiplier:D

    .line 38
    iput-object p1, p0, Lcom/amazon/device/ads/AdRenderer;->adData:Lcom/amazon/device/ads/AdData;

    .line 39
    iput-object p2, p0, Lcom/amazon/device/ads/AdRenderer;->controller:Lcom/amazon/device/ads/IAdController;

    .line 40
    iput-object p3, p0, Lcom/amazon/device/ads/AdRenderer;->context:Landroid/content/Context;

    .line 41
    return-void
.end method

.method protected static calculateScalingMultiplier(IIII)D
    .locals 12
    .param p0, "absoluteAdWidth"    # I
    .param p1, "absoluteAdHeight"    # I
    .param p2, "absoluteWindowWidth"    # I
    .param p3, "absoluteWindowHeight"    # I

    .prologue
    const-wide/16 v10, 0x0

    .line 101
    int-to-double v6, p2

    int-to-double v8, p0

    div-double v4, v6, v8

    .line 102
    .local v4, "widthRatio":D
    int-to-double v6, p3

    int-to-double v8, p1

    div-double v0, v6, v8

    .line 109
    .local v0, "heightRatio":D
    cmpg-double v6, v0, v4

    if-ltz v6, :cond_0

    cmpl-double v6, v4, v10

    if-nez v6, :cond_2

    :cond_0
    cmpl-double v6, v0, v10

    if-eqz v6, :cond_2

    .line 110
    move-wide v2, v0

    .line 114
    .local v2, "multiplier":D
    :goto_0
    cmpl-double v6, v2, v10

    if-nez v6, :cond_1

    const-wide/high16 v2, 0x3ff0000000000000L    # 1.0

    .end local v2    # "multiplier":D
    :cond_1
    return-wide v2

    .line 112
    :cond_2
    move-wide v2, v4

    .restart local v2    # "multiplier":D
    goto :goto_0
.end method

.method protected static determineScalingMultiplier(Lcom/amazon/device/ads/AdData;Lcom/amazon/device/ads/IAdController;)D
    .locals 10
    .param p0, "adData"    # Lcom/amazon/device/ads/AdData;
    .param p1, "controller"    # Lcom/amazon/device/ads/IAdController;

    .prologue
    .line 74
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v5

    invoke-interface {v5}, Lcom/amazon/device/ads/IInternalAdRegistration;->getDeviceInfo()Lcom/amazon/device/ads/DeviceInfo;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/device/ads/DeviceInfo;->getScalingFactorAsFloat()F

    move-result v2

    .line 75
    .local v2, "scalingDensity":F
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdData;->getWidth()I

    move-result v5

    int-to-float v5, v5

    mul-float/2addr v5, v2

    float-to-int v1, v5

    .line 76
    .local v1, "adWidth":I
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdData;->getHeight()I

    move-result v5

    int-to-float v5, v5

    mul-float/2addr v5, v2

    float-to-int v0, v5

    .line 78
    .local v0, "adHeight":I
    invoke-interface {p1}, Lcom/amazon/device/ads/IAdController;->getWindowWidth()I

    move-result v5

    invoke-interface {p1}, Lcom/amazon/device/ads/IAdController;->getWindowHeight()I

    move-result v6

    invoke-static {v1, v0, v5, v6}, Lcom/amazon/device/ads/AdRenderer;->calculateScalingMultiplier(IIII)D

    move-result-wide v3

    .line 81
    .local v3, "scalingMultiplier":D
    const-string/jumbo v5, "AdRenderer"

    const-string/jumbo v6, "Scaling Params: scalingDensity: %f, windowWidth: %d, windowHeight: %d, adWidth: %d, adHeight: %d, scale: %f"

    const/4 v7, 0x6

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v9

    aput-object v9, v7, v8

    const/4 v8, 0x1

    invoke-interface {p1}, Lcom/amazon/device/ads/IAdController;->getWindowWidth()I

    move-result v9

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v7, v8

    const/4 v8, 0x2

    invoke-interface {p1}, Lcom/amazon/device/ads/IAdController;->getWindowHeight()I

    move-result v9

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v7, v8

    const/4 v8, 0x3

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v7, v8

    const/4 v8, 0x4

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v7, v8

    const/4 v8, 0x5

    invoke-static {v3, v4}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v9

    aput-object v9, v7, v8

    invoke-static {v5, v6, v7}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 88
    return-wide v3
.end method


# virtual methods
.method protected adLoaded(Lcom/amazon/device/ads/AdProperties;)V
    .locals 1
    .param p1, "props"    # Lcom/amazon/device/ads/AdProperties;

    .prologue
    .line 166
    iget-object v0, p0, Lcom/amazon/device/ads/AdRenderer;->controller:Lcom/amazon/device/ads/IAdController;

    invoke-interface {v0, p1}, Lcom/amazon/device/ads/IAdController;->adLoaded(Lcom/amazon/device/ads/AdProperties;)V

    .line 167
    return-void
.end method

.method protected abstract destroy()V
.end method

.method protected abstract getAdState(Lcom/amazon/device/ads/AdRenderer$AdState;)Z
.end method

.method public getHeight()I
    .locals 1

    .prologue
    .line 205
    iget-object v0, p0, Lcom/amazon/device/ads/AdRenderer;->adData:Lcom/amazon/device/ads/AdData;

    invoke-virtual {v0}, Lcom/amazon/device/ads/AdData;->getHeight()I

    move-result v0

    return v0
.end method

.method protected getScalingMultiplier()D
    .locals 2

    .prologue
    .line 123
    iget-wide v0, p0, Lcom/amazon/device/ads/AdRenderer;->scalingMultiplier:D

    return-wide v0
.end method

.method public getScalingMultiplierDescription()Ljava/lang/String;
    .locals 4

    .prologue
    const-wide/high16 v2, 0x3ff0000000000000L    # 1.0

    .line 132
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdRenderer;->getScalingMultiplier()D

    move-result-wide v0

    cmpl-double v0, v0, v2

    if-lez v0, :cond_0

    .line 134
    const-string/jumbo v0, "u"

    .line 140
    :goto_0
    return-object v0

    .line 136
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdRenderer;->getScalingMultiplier()D

    move-result-wide v0

    cmpg-double v0, v0, v2

    if-gez v0, :cond_1

    invoke-virtual {p0}, Lcom/amazon/device/ads/AdRenderer;->getScalingMultiplier()D

    move-result-wide v0

    const-wide/16 v2, 0x0

    cmpl-double v0, v0, v2

    if-lez v0, :cond_1

    .line 138
    const-string/jumbo v0, "d"

    goto :goto_0

    .line 140
    :cond_1
    const-string/jumbo v0, "n"

    goto :goto_0
.end method

.method public getSpecialUrlExecutor()Lcom/amazon/device/ads/AdWebViewClient$UrlExecutor;
    .locals 1

    .prologue
    .line 211
    iget-object v0, p0, Lcom/amazon/device/ads/AdRenderer;->controller:Lcom/amazon/device/ads/IAdController;

    invoke-interface {v0}, Lcom/amazon/device/ads/IAdController;->getSpecialUrlExecutor()Lcom/amazon/device/ads/AdWebViewClient$UrlExecutor;

    move-result-object v0

    return-object v0
.end method

.method public initialize()V
    .locals 2

    .prologue
    .line 54
    iget-object v0, p0, Lcom/amazon/device/ads/AdRenderer;->adData:Lcom/amazon/device/ads/AdData;

    iget-object v1, p0, Lcom/amazon/device/ads/AdRenderer;->controller:Lcom/amazon/device/ads/IAdController;

    invoke-static {v0, v1}, Lcom/amazon/device/ads/AdRenderer;->determineScalingMultiplier(Lcom/amazon/device/ads/AdData;Lcom/amazon/device/ads/IAdController;)D

    move-result-wide v0

    iput-wide v0, p0, Lcom/amazon/device/ads/AdRenderer;->scalingMultiplier:D

    .line 55
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/device/ads/AdRenderer;->isInitialized:Z

    .line 56
    return-void
.end method

.method protected isAdViewDestroyed()Z
    .locals 1

    .prologue
    .line 150
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdRenderer;->isInitialized()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/amazon/device/ads/AdRenderer;->isDestroyed:Z

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected isAdViewRemoved()Z
    .locals 1

    .prologue
    .line 155
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdRenderer;->isInitialized()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/amazon/device/ads/AdRenderer;->viewRemoved:Z

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isAdViewRenderable()Z
    .locals 1

    .prologue
    .line 161
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdRenderer;->isInitialized()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/device/ads/AdRenderer;->isAdViewRemoved()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/device/ads/AdRenderer;->isAdViewDestroyed()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isInitialized()Z
    .locals 1

    .prologue
    .line 63
    iget-boolean v0, p0, Lcom/amazon/device/ads/AdRenderer;->isInitialized:Z

    return v0
.end method

.method protected abstract prepareToGoAway()V
.end method

.method protected abstract removeView()V
.end method

.method protected abstract render()Z
.end method

.method protected abstract sendCommand(Ljava/lang/String;Ljava/util/Map;)Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)Z"
        }
    .end annotation
.end method

.method protected setAd(Lcom/amazon/device/ads/AdData;)V
    .locals 0
    .param p1, "ad"    # Lcom/amazon/device/ads/AdData;

    .prologue
    .line 145
    iput-object p1, p0, Lcom/amazon/device/ads/AdRenderer;->adData:Lcom/amazon/device/ads/AdData;

    .line 146
    return-void
.end method

.method public shouldDisableWebViewHardwareAcceleration()Z
    .locals 1

    .prologue
    .line 171
    iget-object v0, p0, Lcom/amazon/device/ads/AdRenderer;->controller:Lcom/amazon/device/ads/IAdController;

    invoke-interface {v0}, Lcom/amazon/device/ads/IAdController;->shouldDisableWebViewHardwareAcceleration()Z

    move-result v0

    return v0
.end method

.method protected abstract shouldReuse()Z
.end method

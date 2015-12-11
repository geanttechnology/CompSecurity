.class interface abstract Lcom/amazon/device/ads/IAdController;
.super Ljava/lang/Object;
.source "AdController.java"


# virtual methods
.method public abstract adClosedExpansion()V
.end method

.method public abstract adExpanded()V
.end method

.method public abstract adLoaded(Lcom/amazon/device/ads/AdProperties;)V
.end method

.method public abstract destroy()V
.end method

.method public abstract getAdLayout()Lcom/amazon/device/ads/AdLayout;
.end method

.method public abstract getAdSize()Lcom/amazon/device/ads/AdSize;
.end method

.method public abstract getMaxSize()Ljava/lang/String;
.end method

.method public abstract getSpecialUrlExecutor()Lcom/amazon/device/ads/AdWebViewClient$UrlExecutor;
.end method

.method public abstract getTimeout()I
.end method

.method public abstract getWindowHeight()I
.end method

.method public abstract getWindowWidth()I
.end method

.method public abstract isAdExpanded()Z
.end method

.method public abstract isAdLoading()Z
.end method

.method public abstract prepareAd(J)V
.end method

.method public abstract prepareToGoAway()V
.end method

.method public abstract sendCommand(Ljava/lang/String;Ljava/util/HashMap;)Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)Z"
        }
    .end annotation
.end method

.method public abstract setListener(Lcom/amazon/device/ads/AdListener;)V
.end method

.method public abstract setTimeout(I)V
.end method

.method public abstract setWindowDimensions(II)V
.end method

.method public abstract shouldDisableWebViewHardwareAcceleration()Z
.end method

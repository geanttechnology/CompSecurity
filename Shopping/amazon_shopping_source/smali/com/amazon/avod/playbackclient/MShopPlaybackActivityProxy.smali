.class public Lcom/amazon/avod/playbackclient/MShopPlaybackActivityProxy;
.super Lcom/amazon/mShop/android/platform/app/ProxyActivity;
.source "MShopPlaybackActivityProxy.java"

# interfaces
.implements Lcom/amazon/avod/clickstream/page/ComponentPageInfoHolder;
.implements Lcom/amazon/avod/playbackclient/activity/ForegroundAwareActivity;
.implements Lcom/amazon/avod/playbackclient/presenters/SurfaceSwitcherProvider;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Lcom/amazon/mShop/android/platform/app/ProxyActivity;-><init>()V

    return-void
.end method


# virtual methods
.method public getPageInfo()Lcom/amazon/avod/clickstream/PageInfo;
    .locals 1

    .prologue
    .line 36
    invoke-virtual {p0}, Lcom/amazon/avod/playbackclient/MShopPlaybackActivityProxy;->getActivityDelegate()Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;

    move-result-object v0

    check-cast v0, Lcom/amazon/avod/clickstream/PageInfoSource;

    invoke-interface {v0}, Lcom/amazon/avod/clickstream/PageInfoSource;->getPageInfo()Lcom/amazon/avod/clickstream/PageInfo;

    move-result-object v0

    return-object v0
.end method

.method public getSurfaceSwitcher()Lcom/amazon/avod/playbackclient/presenters/SurfaceSwitcher;
    .locals 1

    .prologue
    .line 42
    invoke-virtual {p0}, Lcom/amazon/avod/playbackclient/MShopPlaybackActivityProxy;->getActivityDelegate()Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;

    move-result-object v0

    check-cast v0, Lcom/amazon/avod/playbackclient/presenters/SurfaceSwitcherProvider;

    invoke-interface {v0}, Lcom/amazon/avod/playbackclient/presenters/SurfaceSwitcherProvider;->getSurfaceSwitcher()Lcom/amazon/avod/playbackclient/presenters/SurfaceSwitcher;

    move-result-object v0

    return-object v0
.end method

.method public isActivityInForeground()Z
    .locals 1

    .prologue
    .line 31
    invoke-virtual {p0}, Lcom/amazon/avod/playbackclient/MShopPlaybackActivityProxy;->getActivityDelegate()Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;

    move-result-object v0

    check-cast v0, Lcom/amazon/avod/playbackclient/activity/ForegroundAwareActivity;

    invoke-interface {v0}, Lcom/amazon/avod/playbackclient/activity/ForegroundAwareActivity;->isActivityInForeground()Z

    move-result v0

    return v0
.end method

.method public resetToMainPage(Ljava/lang/String;)V
    .locals 1
    .param p1, "refMarker"    # Ljava/lang/String;

    .prologue
    .line 21
    invoke-virtual {p0}, Lcom/amazon/avod/playbackclient/MShopPlaybackActivityProxy;->getActivityDelegate()Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;

    move-result-object v0

    check-cast v0, Lcom/amazon/avod/clickstream/page/ComponentPageInfoHolder;

    invoke-interface {v0, p1}, Lcom/amazon/avod/clickstream/page/ComponentPageInfoHolder;->resetToMainPage(Ljava/lang/String;)V

    .line 22
    return-void
.end method

.method public transitionToPage(Ljava/lang/String;Lcom/amazon/avod/clickstream/PageInfo;)V
    .locals 1
    .param p1, "refMarker"    # Ljava/lang/String;
    .param p2, "pageInfo"    # Lcom/amazon/avod/clickstream/PageInfo;

    .prologue
    .line 26
    invoke-virtual {p0}, Lcom/amazon/avod/playbackclient/MShopPlaybackActivityProxy;->getActivityDelegate()Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;

    move-result-object v0

    check-cast v0, Lcom/amazon/avod/clickstream/page/ComponentPageInfoHolder;

    invoke-interface {v0, p1, p2}, Lcom/amazon/avod/clickstream/page/ComponentPageInfoHolder;->transitionToPage(Ljava/lang/String;Lcom/amazon/avod/clickstream/PageInfo;)V

    .line 27
    return-void
.end method

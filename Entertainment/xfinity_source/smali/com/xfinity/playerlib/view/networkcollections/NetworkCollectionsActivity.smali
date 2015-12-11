.class public Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsActivity;
.super Lcom/xfinity/playerlib/view/networkcollections/NetworkActivity;
.source "NetworkCollectionsActivity.java"


# instance fields
.field private final accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

.field private final androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 9
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/networkcollections/NetworkActivity;-><init>()V

    .line 11
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getAndroidDevice()Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsActivity;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    .line 12
    invoke-static {}, Lcom/comcast/cim/container/CALContainer;->getInstance()Lcom/comcast/cim/container/CALContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/CALContainer;->getAccessibilityUtil()Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsActivity;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    return-void
.end method


# virtual methods
.method protected getLayoutId()I
    .locals 1

    .prologue
    .line 17
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsActivity;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->isTabletDevice()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 18
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsActivity;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    invoke-virtual {v0}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    sget v0, Lcom/xfinity/playerlib/R$layout;->flyin_network_collections_phone:I

    .line 23
    :goto_0
    return v0

    .line 18
    :cond_0
    sget v0, Lcom/xfinity/playerlib/R$layout;->layout_flyin_network_collections:I

    goto :goto_0

    .line 23
    :cond_1
    sget v0, Lcom/xfinity/playerlib/R$layout;->layout_flyin_network_collections:I

    goto :goto_0
.end method

.method public onResumeInternal()V
    .locals 0

    .prologue
    .line 28
    invoke-super {p0}, Lcom/xfinity/playerlib/view/networkcollections/NetworkActivity;->onResumeInternal()V

    .line 29
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsActivity;->checkTalkBackModeOnResume()V

    .line 30
    return-void
.end method

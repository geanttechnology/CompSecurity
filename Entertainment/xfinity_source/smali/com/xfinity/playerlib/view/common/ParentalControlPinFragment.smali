.class public Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;
.super Lcom/comcast/cim/android/view/common/PinKeypadFragment;
.source "ParentalControlPinFragment.java"


# instance fields
.field private trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 11
    invoke-direct {p0}, Lcom/comcast/cim/android/view/common/PinKeypadFragment;-><init>()V

    .line 13
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getTrackingService()Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    return-void
.end method


# virtual methods
.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 1
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 17
    iget-object v0, p0, Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->trackParentalControlsPinPadRendered()V

    .line 18
    invoke-super {p0, p1, p2, p3}, Lcom/comcast/cim/android/view/common/PinKeypadFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

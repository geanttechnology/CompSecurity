.class public Lcom/xfinity/playerlib/view/authentication/PlayNowAuthenticationActivity;
.super Lcom/comcast/cim/android/authentication/AuthenticationActivity;
.source "PlayNowAuthenticationActivity.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/android/authentication/AuthenticationActivity",
        "<",
        "Lcom/xfinity/playerlib/model/user/PlayNowUser;",
        "Lcom/xfinity/playerlib/model/user/PlayerUserSettings;",
        ">;"
    }
.end annotation


# instance fields
.field private final sensorIfHasKeyboardOrientationStrategy:Lcom/comcast/cim/android/view/common/OrientationStrategy;

.field private final trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

.field private final userManager:Lcom/comcast/cim/model/user/XipUserManager;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/model/user/XipUserManager",
            "<",
            "Lcom/xfinity/playerlib/model/user/PlayNowUser;",
            "Lcom/xfinity/playerlib/model/user/PlayerUserSettings;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 12
    invoke-direct {p0}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;-><init>()V

    .line 14
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getTrackingService()Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/authentication/PlayNowAuthenticationActivity;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    .line 15
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/authentication/PlayNowAuthenticationActivity;->userManager:Lcom/comcast/cim/model/user/XipUserManager;

    .line 16
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getSensorIfHasKeyboardOrientationStrategy()Lcom/comcast/cim/android/view/common/OrientationStrategy;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/authentication/PlayNowAuthenticationActivity;->sensorIfHasKeyboardOrientationStrategy:Lcom/comcast/cim/android/view/common/OrientationStrategy;

    return-void
.end method


# virtual methods
.method public getOrientationStrategy()Lcom/comcast/cim/android/view/common/OrientationStrategy;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/xfinity/playerlib/view/authentication/PlayNowAuthenticationActivity;->sensorIfHasKeyboardOrientationStrategy:Lcom/comcast/cim/android/view/common/OrientationStrategy;

    return-object v0
.end method

.method protected getUserManager()Lcom/comcast/cim/model/user/XipUserManager;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/model/user/XipUserManager",
            "<",
            "Lcom/xfinity/playerlib/model/user/PlayNowUser;",
            "Lcom/xfinity/playerlib/model/user/PlayerUserSettings;",
            ">;"
        }
    .end annotation

    .prologue
    .line 20
    iget-object v0, p0, Lcom/xfinity/playerlib/view/authentication/PlayNowAuthenticationActivity;->userManager:Lcom/comcast/cim/model/user/XipUserManager;

    return-object v0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 25
    invoke-super {p0, p1}, Lcom/comcast/cim/android/authentication/AuthenticationActivity;->onCreate(Landroid/os/Bundle;)V

    .line 27
    iget-object v0, p0, Lcom/xfinity/playerlib/view/authentication/PlayNowAuthenticationActivity;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->trackSignInScreenRendered()V

    .line 28
    return-void
.end method

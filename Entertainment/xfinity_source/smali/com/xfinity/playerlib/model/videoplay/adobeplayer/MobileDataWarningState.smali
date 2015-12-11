.class public Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;
.super Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;
.source "MobileDataWarningState.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private paused:Z

.field private transitionState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 15
    const-class v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V
    .locals 1
    .param p1, "stateController"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    .param p2, "transitionState"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    .prologue
    .line 21
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    .line 18
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;->paused:Z

    .line 22
    iput-object p2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;->transitionState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    .line 23
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;

    .prologue
    .line 14
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;->transitionState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    return-object v0
.end method

.method private mobileDataRequirementCheck()V
    .locals 2

    .prologue
    .line 49
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->shouldUseDownloadFile()Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .line 50
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getInternetConnection()Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;->isConnectedNotOnWiFi()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .line 51
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getUseCellularWhenAvailable()Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .line 52
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->isIgnoreMobileDataWarningSettingThisSession()Z

    move-result v0

    if-nez v0, :cond_1

    .line 54
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getPlayerStatus()Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    move-result-object v0

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PLAYING:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    if-ne v0, v1, :cond_0

    .line 55
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->pause()V

    .line 56
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;->paused:Z

    .line 58
    :cond_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;->postMobileDataWarningDialog()V

    .line 63
    :goto_0
    return-void

    .line 61
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;->transitionState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    goto :goto_0
.end method


# virtual methods
.method public getStateName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 40
    const-string v0, "MobileDataWarningState"

    return-object v0
.end method

.method public postMobileDataWarningDialog()V
    .locals 5

    .prologue
    .line 66
    new-instance v1, Landroid/app/AlertDialog$Builder;

    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getActivityContext()Landroid/app/Activity;

    move-result-object v3

    invoke-direct {v1, v3}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 67
    .local v1, "builder":Landroid/app/AlertDialog$Builder;
    const/4 v3, 0x1

    invoke-virtual {v1, v3}, Landroid/app/AlertDialog$Builder;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    .line 69
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getActivityContext()Landroid/app/Activity;

    move-result-object v3

    const-string v4, "wifi"

    invoke-virtual {v3, v4}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/net/wifi/WifiManager;

    .line 70
    .local v2, "wifi":Landroid/net/wifi/WifiManager;
    invoke-virtual {v2}, Landroid/net/wifi/WifiManager;->isWifiEnabled()Z

    move-result v3

    if-nez v3, :cond_0

    .line 71
    sget v3, Lcom/xfinity/playerlib/R$string;->alert_video_over_mobile_warning__wifi_disabled_title:I

    invoke-virtual {v1, v3}, Landroid/app/AlertDialog$Builder;->setTitle(I)Landroid/app/AlertDialog$Builder;

    .line 76
    :goto_0
    sget v3, Lcom/xfinity/playerlib/R$string;->alert_video_over_mobile_warning_msg:I

    invoke-virtual {v1, v3}, Landroid/app/AlertDialog$Builder;->setMessage(I)Landroid/app/AlertDialog$Builder;

    .line 78
    sget v3, Lcom/xfinity/playerlib/R$string;->alert_video_over_mobile_warning_btn_positive:I

    new-instance v4, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState$1;

    invoke-direct {v4, p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState$1;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;)V

    invoke-virtual {v1, v3, v4}, Landroid/app/AlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 87
    sget v3, Lcom/xfinity/playerlib/R$string;->alert_video_over_mobile_warning_btn_negative:I

    new-instance v4, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState$2;

    invoke-direct {v4, p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState$2;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;)V

    invoke-virtual {v1, v3, v4}, Landroid/app/AlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 94
    sget v3, Lcom/xfinity/playerlib/R$string;->alert_video_over_mobile_warning_btn_positive_change_setting:I

    new-instance v4, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState$3;

    invoke-direct {v4, p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState$3;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;)V

    invoke-virtual {v1, v3, v4}, Landroid/app/AlertDialog$Builder;->setNeutralButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 110
    new-instance v3, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState$4;

    invoke-direct {v3, p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState$4;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;)V

    invoke-virtual {v1, v3}, Landroid/app/AlertDialog$Builder;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)Landroid/app/AlertDialog$Builder;

    .line 117
    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 118
    .local v0, "alertDialog":Landroid/app/AlertDialog;
    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 119
    return-void

    .line 73
    .end local v0    # "alertDialog":Landroid/app/AlertDialog;
    :cond_0
    sget v3, Lcom/xfinity/playerlib/R$string;->alert_video_over_mobile_warning_title:I

    invoke-virtual {v1, v3}, Landroid/app/AlertDialog$Builder;->setTitle(I)Landroid/app/AlertDialog$Builder;

    goto :goto_0
.end method

.method public run()V
    .locals 0

    .prologue
    .line 45
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;->mobileDataRequirementCheck()V

    .line 46
    return-void
.end method

.method public transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V
    .locals 2
    .param p1, "newState"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    .prologue
    .line 28
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;->transitionState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    if-ne v0, v1, :cond_1

    .line 29
    iget-boolean v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;->paused:Z

    if-eqz v0, :cond_0

    .line 30
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->play()V

    .line 32
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->setState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 36
    :goto_0
    return-void

    .line 34
    :cond_1
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    goto :goto_0
.end method

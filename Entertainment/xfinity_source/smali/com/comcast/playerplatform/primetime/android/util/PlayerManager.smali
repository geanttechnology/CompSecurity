.class public Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;
.super Ljava/lang/Object;
.source "PlayerManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/playerplatform/primetime/android/util/PlayerManager$1;
    }
.end annotation


# instance fields
.field private activity:Landroid/app/Activity;

.field private applicationContext:Landroid/content/Context;

.field private currentPlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

.field private disneyPlayer:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

.field private espnPlayer:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

.field private httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

.field private licenseService:Lcom/comcast/playerplatform/drm/java/service/LicenseService;

.field private parentView:Landroid/widget/FrameLayout;

.field private playerChanged:Z

.field private final playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

.field private primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;


# direct methods
.method public constructor <init>(Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;Landroid/content/Context;Landroid/app/Activity;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/playerplatform/drm/java/service/LicenseService;Landroid/widget/FrameLayout;)V
    .locals 0
    .param p1, "playerSettings"    # Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;
    .param p2, "applicationContext"    # Landroid/content/Context;
    .param p3, "activity"    # Landroid/app/Activity;
    .param p4, "httpClient"    # Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;
    .param p5, "licenseService"    # Lcom/comcast/playerplatform/drm/java/service/LicenseService;
    .param p6, "parentView"    # Landroid/widget/FrameLayout;

    .prologue
    .line 42
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 43
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    .line 44
    iput-object p2, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->applicationContext:Landroid/content/Context;

    .line 45
    iput-object p3, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->activity:Landroid/app/Activity;

    .line 46
    iput-object p4, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    .line 47
    iput-object p5, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->licenseService:Lcom/comcast/playerplatform/drm/java/service/LicenseService;

    .line 48
    iput-object p6, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->parentView:Landroid/widget/FrameLayout;

    .line 49
    return-void
.end method

.method private resetPreviousPlayer()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 119
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->currentPlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    instance-of v0, v0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    if-eqz v0, :cond_1

    .line 120
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->destroy()V

    .line 121
    iput-object v1, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    .line 130
    :cond_0
    :goto_0
    return-void

    .line 122
    :cond_1
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->currentPlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    instance-of v0, v0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    if-eqz v0, :cond_2

    .line 123
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->espnPlayer:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->destroy()V

    .line 124
    iput-object v1, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->espnPlayer:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    goto :goto_0

    .line 125
    :cond_2
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->currentPlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    instance-of v0, v0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    if-eqz v0, :cond_0

    .line 126
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->disneyPlayer:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->destroy()V

    .line 127
    iput-object v1, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->disneyPlayer:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    goto :goto_0
.end method

.method private setCurrentPlayer(Lcom/comcast/playerplatform/primetime/android/player/Player;)V
    .locals 1
    .param p1, "player"    # Lcom/comcast/playerplatform/primetime/android/player/Player;

    .prologue
    .line 112
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->currentPlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eq p1, v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->playerChanged:Z

    .line 113
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->currentPlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    .line 114
    return-void

    .line 112
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public didPlayerChange()Z
    .locals 1

    .prologue
    .line 108
    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->playerChanged:Z

    return v0
.end method

.method public getDisneyPlayer()Lcom/comcast/playerplatform/primetime/android/player/Player;
    .locals 4

    .prologue
    .line 52
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->currentPlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->currentPlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    instance-of v0, v0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    if-nez v0, :cond_0

    .line 53
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->resetPreviousPlayer()V

    .line 56
    :cond_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->disneyPlayer:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    if-nez v0, :cond_1

    .line 57
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->applicationContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->activity:Landroid/app/Activity;

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-direct {v0, v1, v2, v3}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;-><init>(Landroid/content/Context;Landroid/app/Activity;Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->disneyPlayer:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    .line 58
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->parentView:Landroid/widget/FrameLayout;

    invoke-virtual {v0}, Landroid/widget/FrameLayout;->removeAllViews()V

    .line 59
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->parentView:Landroid/widget/FrameLayout;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->disneyPlayer:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->getView()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V

    .line 61
    :cond_1
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->disneyPlayer:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->setCurrentPlayer(Lcom/comcast/playerplatform/primetime/android/player/Player;)V

    .line 62
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->disneyPlayer:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    return-object v0
.end method

.method public getEspnPlayer()Lcom/comcast/playerplatform/primetime/android/player/Player;
    .locals 4

    .prologue
    .line 66
    invoke-static {}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->getInstance()Lcom/comcast/playerplatform/util/android/ConfigurationManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->isEspnReady()Z

    move-result v0

    if-nez v0, :cond_0

    .line 67
    invoke-static {}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->getInstance()Lcom/comcast/playerplatform/util/android/ConfigurationManager;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->applicationContext:Landroid/content/Context;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->initializeESPN(Landroid/content/Context;Z)V

    .line 70
    :cond_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->currentPlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->currentPlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    instance-of v0, v0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    if-nez v0, :cond_1

    .line 71
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->resetPreviousPlayer()V

    .line 74
    :cond_1
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->espnPlayer:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    if-nez v0, :cond_2

    .line 75
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->applicationContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-direct {v0, v1, v2, v3}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;-><init>(Landroid/content/Context;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->espnPlayer:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    .line 76
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->parentView:Landroid/widget/FrameLayout;

    invoke-virtual {v0}, Landroid/widget/FrameLayout;->removeAllViews()V

    .line 77
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->parentView:Landroid/widget/FrameLayout;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->espnPlayer:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->getView()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V

    .line 79
    :cond_2
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->espnPlayer:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->setCurrentPlayer(Lcom/comcast/playerplatform/primetime/android/player/Player;)V

    .line 80
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->espnPlayer:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    return-object v0
.end method

.method public declared-synchronized getPlayer(Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;)Lcom/comcast/playerplatform/primetime/android/player/Player;
    .locals 2
    .param p1, "type"    # Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;

    .prologue
    .line 97
    monitor-enter p0

    :try_start_0
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager$1;->$SwitchMap$com$comcast$playerplatform$primetime$android$asset$Asset$AssetType:[I

    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 103
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->getPrimetimePlayer()Lcom/comcast/playerplatform/primetime/android/player/Player;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    :goto_0
    monitor-exit p0

    return-object v0

    .line 99
    :pswitch_0
    :try_start_1
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->getEspnPlayer()Lcom/comcast/playerplatform/primetime/android/player/Player;

    move-result-object v0

    goto :goto_0

    .line 101
    :pswitch_1
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->getDisneyPlayer()Lcom/comcast/playerplatform/primetime/android/player/Player;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v0

    goto :goto_0

    .line 97
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public getPrimetimePlayer()Lcom/comcast/playerplatform/primetime/android/player/Player;
    .locals 5

    .prologue
    .line 84
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->currentPlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->currentPlayer:Lcom/comcast/playerplatform/primetime/android/player/Player;

    instance-of v0, v0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    if-nez v0, :cond_0

    .line 85
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->resetPreviousPlayer()V

    .line 87
    :cond_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    if-nez v0, :cond_1

    .line 88
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->applicationContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    iget-object v4, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->licenseService:Lcom/comcast/playerplatform/drm/java/service/LicenseService;

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;-><init>(Landroid/content/Context;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;Lcom/comcast/playerplatform/drm/java/service/LicenseService;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    .line 89
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->parentView:Landroid/widget/FrameLayout;

    invoke-virtual {v0}, Landroid/widget/FrameLayout;->removeAllViews()V

    .line 90
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->parentView:Landroid/widget/FrameLayout;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->getView()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V

    .line 92
    :cond_1
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->setCurrentPlayer(Lcom/comcast/playerplatform/primetime/android/player/Player;)V

    .line 93
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/PlayerManager;->primeTimePlayer:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    return-object v0
.end method

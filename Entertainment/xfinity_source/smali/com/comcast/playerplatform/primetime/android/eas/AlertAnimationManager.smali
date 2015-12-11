.class public Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;
.super Ljava/lang/Object;
.source "AlertAnimationManager.java"


# instance fields
.field private alertPlayer:Lcom/adobe/mediacore/MediaPlayer;

.field private alertScrollView:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertScroller;

.field private alertTextAnimation:Landroid/view/animation/TranslateAnimation;

.field private alertTextView:Landroid/widget/TextView;

.field private animationListener:Landroid/view/animation/Animation$AnimationListener;

.field private applicationContext:Landroid/content/Context;

.field private currentAlert:Lcom/comcast/playerplatform/primetime/android/eas/Alert;

.field private listener:Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;

.field private playerPlatform:Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;

.field private savedPlayerStatus:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

.field private savedView:Landroid/view/View;

.field private settings:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 73
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$1;

    invoke-direct {v0, p0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$1;-><init>(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->animationListener:Landroid/view/animation/Animation$AnimationListener;

    .line 74
    return-void
.end method

.method static synthetic access$000(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    .prologue
    .line 34
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->destroyText()V

    return-void
.end method

.method static synthetic access$100(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->listener:Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;

    return-object v0
.end method

.method static synthetic access$1000(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertScroller;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertScrollView:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertScroller;

    return-object v0
.end method

.method static synthetic access$1100(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertTextView:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$1200(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)Landroid/view/animation/TranslateAnimation;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertTextAnimation:Landroid/view/animation/TranslateAnimation;

    return-object v0
.end method

.method static synthetic access$200(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)Lcom/comcast/playerplatform/primetime/android/eas/Alert;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->currentAlert:Lcom/comcast/playerplatform/primetime/android/eas/Alert;

    return-object v0
.end method

.method static synthetic access$300(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    .prologue
    .line 34
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->checkForNextAlert()V

    return-void
.end method

.method static synthetic access$400(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)Lcom/adobe/mediacore/MediaPlayer;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertPlayer:Lcom/adobe/mediacore/MediaPlayer;

    return-object v0
.end method

.method static synthetic access$402(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;Lcom/adobe/mediacore/MediaPlayer;)Lcom/adobe/mediacore/MediaPlayer;
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;
    .param p1, "x1"    # Lcom/adobe/mediacore/MediaPlayer;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertPlayer:Lcom/adobe/mediacore/MediaPlayer;

    return-object p1
.end method

.method static synthetic access$500(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->playerPlatform:Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;

    return-object v0
.end method

.method static synthetic access$600(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->savedView:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$602(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;Landroid/view/View;)Landroid/view/View;
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;
    .param p1, "x1"    # Landroid/view/View;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->savedView:Landroid/view/View;

    return-object p1
.end method

.method static synthetic access$700(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->savedPlayerStatus:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    return-object v0
.end method

.method static synthetic access$702(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;
    .param p1, "x1"    # Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->savedPlayerStatus:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    return-object p1
.end method

.method static synthetic access$800(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    .prologue
    .line 34
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->saveCurrentPlayerState()V

    return-void
.end method

.method static synthetic access$900(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;

    .prologue
    .line 34
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->startAlertContent()V

    return-void
.end method

.method private addToPlayerView()V
    .locals 7

    .prologue
    const/4 v6, -0x1

    const/4 v5, -0x2

    const/4 v3, 0x0

    .line 251
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->playerPlatform:Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;

    invoke-interface {v2}, Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;->getView()Landroid/view/View;

    move-result-object v1

    .line 253
    .local v1, "playerView":Landroid/view/View;
    invoke-virtual {v1, v3, v3}, Landroid/view/View;->measure(II)V

    .line 255
    new-instance v0, Landroid/widget/FrameLayout$LayoutParams;

    invoke-direct {v0, v6, v5}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    .line 256
    .local v0, "lp":Landroid/widget/FrameLayout$LayoutParams;
    invoke-virtual {v0, v3, v3, v3, v3}, Landroid/widget/FrameLayout$LayoutParams;->setMargins(IIII)V

    .line 258
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertScrollView:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertScroller;

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertTextView:Landroid/widget/TextView;

    new-instance v4, Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {v4, v5, v6}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v2, v3, v4}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertScroller;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 259
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertScrollView:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertScroller;

    invoke-virtual {v2, v0}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertScroller;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 260
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v2

    new-instance v3, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$5;

    invoke-direct {v3, p0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$5;-><init>(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)V

    invoke-virtual {v2, v3}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 271
    return-void
.end method

.method private checkForNextAlert()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 184
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->savedPlayerStatus:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    if-eqz v0, :cond_0

    .line 185
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->restartMainContent()V

    .line 186
    iput-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->currentAlert:Lcom/comcast/playerplatform/primetime/android/eas/Alert;

    .line 190
    :goto_0
    return-void

    .line 188
    :cond_0
    iput-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->currentAlert:Lcom/comcast/playerplatform/primetime/android/eas/Alert;

    goto :goto_0
.end method

.method private destroyText()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 295
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertTextAnimation:Landroid/view/animation/TranslateAnimation;

    invoke-virtual {v0}, Landroid/view/animation/TranslateAnimation;->hasStarted()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertTextAnimation:Landroid/view/animation/TranslateAnimation;

    invoke-virtual {v0}, Landroid/view/animation/TranslateAnimation;->hasEnded()Z

    move-result v0

    if-nez v0, :cond_0

    .line 296
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertTextAnimation:Landroid/view/animation/TranslateAnimation;

    invoke-virtual {v0}, Landroid/view/animation/TranslateAnimation;->cancel()V

    .line 299
    :cond_0
    iput-object v2, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertTextAnimation:Landroid/view/animation/TranslateAnimation;

    .line 301
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertTextView:Landroid/widget/TextView;

    if-eqz v0, :cond_2

    .line 302
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertTextView:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->clearComposingText()V

    .line 304
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertScrollView:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertScroller;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertScroller;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 305
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertScrollView:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertScroller;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertScroller;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertScrollView:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertScroller;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 306
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertScrollView:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertScroller;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertTextView:Landroid/widget/TextView;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertScroller;->removeView(Landroid/view/View;)V

    .line 310
    :cond_1
    iput-object v2, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertTextView:Landroid/widget/TextView;

    .line 311
    iput-object v2, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertScrollView:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertScroller;

    .line 313
    :cond_2
    return-void
.end method

.method private restartMainContent()V
    .locals 2

    .prologue
    .line 193
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$3;

    invoke-direct {v1, p0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$3;-><init>(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 213
    return-void
.end method

.method private saveCurrentPlayerState()V
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->playerPlatform:Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;->getPlayerStatus()Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->savedPlayerStatus:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .line 88
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->playerPlatform:Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;->pause()V

    .line 95
    return-void
.end method

.method private setupTextView()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 238
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertScroller;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->applicationContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertScroller;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertScrollView:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertScroller;

    .line 239
    new-instance v0, Landroid/widget/TextView;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->applicationContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertTextView:Landroid/widget/TextView;

    .line 241
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertTextView:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->settings:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;->getTextSize()F

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextSize(F)V

    .line 242
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertTextView:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->settings:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;->getTextColor()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 243
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertTextView:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->settings:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;->getBackgroundColor()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setBackgroundColor(I)V

    .line 244
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertTextView:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setMaxLines(I)V

    .line 245
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertTextView:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setHorizontallyScrolling(Z)V

    .line 247
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertTextView:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->currentAlert:Lcom/comcast/playerplatform/primetime/android/eas/Alert;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->getAlertMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 248
    return-void
.end method

.method private startAlert()V
    .locals 3

    .prologue
    .line 216
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->listener:Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;

    if-eqz v0, :cond_0

    .line 217
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->listener:Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->currentAlert:Lcom/comcast/playerplatform/primetime/android/eas/Alert;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->getIdentifier()Ljava/lang/String;

    move-result-object v2

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->currentAlert:Lcom/comcast/playerplatform/primetime/android/eas/Alert;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->hasMediaUrl()Z

    move-result v0

    if-nez v0, :cond_1

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {v1, v2, v0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;->emergencyAlertStarted(Ljava/lang/String;Z)V

    .line 220
    :cond_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->currentAlert:Lcom/comcast/playerplatform/primetime/android/eas/Alert;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->hasMediaUrl()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 221
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$4;

    invoke-direct {v1, p0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$4;-><init>(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 235
    :goto_1
    return-void

    .line 217
    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    .line 231
    :cond_2
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->setupTextView()V

    .line 232
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->addToPlayerView()V

    .line 233
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->startAlertAnimation()V

    goto :goto_1
.end method

.method private startAlertAnimation()V
    .locals 10

    .prologue
    const/4 v6, 0x0

    const/4 v1, 0x2

    const/4 v9, 0x0

    .line 274
    new-instance v0, Landroid/view/animation/TranslateAnimation;

    const/high16 v2, 0x3f800000    # 1.0f

    const/4 v3, 0x1

    const/high16 v4, -0x40800000    # -1.0f

    move v5, v1

    move v7, v1

    move v8, v6

    invoke-direct/range {v0 .. v8}, Landroid/view/animation/TranslateAnimation;-><init>(IFIFIFIF)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertTextAnimation:Landroid/view/animation/TranslateAnimation;

    .line 275
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertTextAnimation:Landroid/view/animation/TranslateAnimation;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->animationListener:Landroid/view/animation/Animation$AnimationListener;

    invoke-virtual {v0, v1}, Landroid/view/animation/TranslateAnimation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 277
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertTextAnimation:Landroid/view/animation/TranslateAnimation;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->settings:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;->getAlertRepeatCount()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/view/animation/TranslateAnimation;->setRepeatCount(I)V

    .line 279
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertTextAnimation:Landroid/view/animation/TranslateAnimation;

    new-instance v1, Landroid/view/animation/LinearInterpolator;

    invoke-direct {v1}, Landroid/view/animation/LinearInterpolator;-><init>()V

    invoke-virtual {v0, v1}, Landroid/view/animation/TranslateAnimation;->setInterpolator(Landroid/view/animation/Interpolator;)V

    .line 280
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertTextView:Landroid/widget/TextView;

    invoke-virtual {v0, v9, v9}, Landroid/widget/TextView;->measure(II)V

    .line 281
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertScrollView:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertScroller;

    invoke-virtual {v0, v9, v9}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertScroller;->measure(II)V

    .line 283
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertTextAnimation:Landroid/view/animation/TranslateAnimation;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertTextView:Landroid/widget/TextView;

    invoke-virtual {v1}, Landroid/widget/TextView;->getMeasuredWidth()I

    move-result v1

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertTextView:Landroid/widget/TextView;

    invoke-virtual {v2}, Landroid/widget/TextView;->getMeasuredHeight()I

    move-result v2

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertScrollView:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertScroller;

    invoke-virtual {v3}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertScroller;->getMeasuredWidth()I

    move-result v3

    iget-object v4, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertScrollView:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertScroller;

    invoke-virtual {v4}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertScroller;->getMeasuredHeight()I

    move-result v4

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/view/animation/TranslateAnimation;->initialize(IIII)V

    .line 284
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertTextAnimation:Landroid/view/animation/TranslateAnimation;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertTextView:Landroid/widget/TextView;

    invoke-virtual {v1}, Landroid/widget/TextView;->getMeasuredWidth()I

    move-result v1

    div-int/lit8 v1, v1, 0x32

    mul-int/lit16 v1, v1, 0x1f4

    int-to-long v2, v1

    invoke-virtual {v0, v2, v3}, Landroid/view/animation/TranslateAnimation;->setDuration(J)V

    .line 286
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$6;

    invoke-direct {v1, p0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$6;-><init>(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 292
    return-void
.end method

.method private startAlertContent()V
    .locals 4

    .prologue
    .line 98
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->applicationContext:Landroid/content/Context;

    invoke-static {v1}, Lcom/adobe/mediacore/DefaultMediaPlayer;->create(Landroid/content/Context;)Lcom/adobe/mediacore/MediaPlayer;

    move-result-object v1

    iput-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertPlayer:Lcom/adobe/mediacore/MediaPlayer;

    .line 99
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertPlayer:Lcom/adobe/mediacore/MediaPlayer;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayer$Event;->PLAYBACK:Lcom/adobe/mediacore/MediaPlayer$Event;

    new-instance v3, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$2;

    invoke-direct {v3, p0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager$2;-><init>(Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;)V

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/MediaPlayer;->addEventListener(Lcom/adobe/mediacore/MediaPlayer$Event;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    .line 173
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->playerPlatform:Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;

    invoke-interface {v1}, Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;->getView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    .line 174
    .local v0, "parentView":Landroid/widget/FrameLayout;
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->savedView:Landroid/view/View;

    .line 175
    invoke-virtual {v0}, Landroid/widget/FrameLayout;->removeAllViews()V

    .line 176
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertPlayer:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v1}, Lcom/adobe/mediacore/MediaPlayer;->getView()Lcom/adobe/mediacore/MediaPlayerView;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V

    .line 177
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertPlayer:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v1}, Lcom/adobe/mediacore/MediaPlayer;->getView()Lcom/adobe/mediacore/MediaPlayerView;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->bringChildToFront(Landroid/view/View;)V

    .line 178
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertPlayer:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v1}, Lcom/adobe/mediacore/MediaPlayer;->getView()Lcom/adobe/mediacore/MediaPlayerView;

    move-result-object v1

    invoke-virtual {v1}, Lcom/adobe/mediacore/MediaPlayerView;->bringToFront()V

    .line 179
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->alertPlayer:Lcom/adobe/mediacore/MediaPlayer;

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->currentAlert:Lcom/comcast/playerplatform/primetime/android/eas/Alert;

    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->getReplaceContentUri()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-static {v2, v3}, Lcom/adobe/mediacore/MediaResource;->createFromUrl(Ljava/lang/String;Lcom/adobe/mediacore/metadata/Metadata;)Lcom/adobe/mediacore/MediaResource;

    move-result-object v2

    invoke-interface {v1, v2}, Lcom/adobe/mediacore/MediaPlayer;->replaceCurrentItem(Lcom/adobe/mediacore/MediaResource;)V

    .line 181
    return-void
.end method


# virtual methods
.method public displayAlert(Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;Landroid/content/Context;Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;Lcom/comcast/playerplatform/primetime/android/eas/Alert;)V
    .locals 0
    .param p1, "playerplatform"    # Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;
    .param p2, "applicationContext"    # Landroid/content/Context;
    .param p3, "settings"    # Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;
    .param p4, "listener"    # Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;
    .param p5, "activeAlert"    # Lcom/comcast/playerplatform/primetime/android/eas/Alert;

    .prologue
    .line 77
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->playerPlatform:Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;

    .line 78
    iput-object p2, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->applicationContext:Landroid/content/Context;

    .line 79
    iput-object p3, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->settings:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertSettings;

    .line 80
    iput-object p4, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->listener:Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;

    .line 81
    iput-object p5, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->currentAlert:Lcom/comcast/playerplatform/primetime/android/eas/Alert;

    .line 83
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->startAlert()V

    .line 84
    return-void
.end method

.method public getCurrentAlert()Lcom/comcast/playerplatform/primetime/android/eas/Alert;
    .locals 1

    .prologue
    .line 326
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->currentAlert:Lcom/comcast/playerplatform/primetime/android/eas/Alert;

    return-object v0
.end method

.method public declared-synchronized stopEmergencyActionNotification()V
    .locals 3

    .prologue
    .line 330
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->listener:Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->currentAlert:Lcom/comcast/playerplatform/primetime/android/eas/Alert;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/eas/Alert;->getIdentifier()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;->emergencyAlertCompleted(Ljava/lang/String;Z)V

    .line 331
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->currentAlert:Lcom/comcast/playerplatform/primetime/android/eas/Alert;

    .line 332
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertAnimationManager;->checkForNextAlert()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 333
    monitor-exit p0

    return-void

    .line 330
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.class public Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;
.super Landroid/widget/Button;
.source "SourceFile"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private applicationId:Ljava/lang/String;

.field private confirmLogout:Z

.field private fetchUserInfo:Z

.field private loginText:Ljava/lang/String;

.field private logoutText:Ljava/lang/String;

.field private parentFragment:Landroid/support/v4/app/Fragment;

.field private properties:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;

.field private sessionTracker:Lcom/facebook/internal/SessionTracker;

.field private user:Lcom/facebook/model/GraphUser;

.field private userInfoChangedCallback:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$UserInfoChangedCallback;

.field private userInfoSession:Lcom/facebook/Session;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 35
    const-class v0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 166
    invoke-direct {p0, p1}, Landroid/widget/Button;-><init>(Landroid/content/Context;)V

    .line 36
    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->applicationId:Ljava/lang/String;

    .line 38
    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->user:Lcom/facebook/model/GraphUser;

    .line 39
    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->userInfoSession:Lcom/facebook/Session;

    .line 46
    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;

    invoke-direct {v0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;-><init>()V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->properties:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;

    .line 167
    invoke-direct {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->initializeActiveSessionWithCachedToken(Landroid/content/Context;)Z

    .line 169
    invoke-direct {p0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->finishInit()V

    .line 170
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 5

    .prologue
    const/4 v0, 0x0

    .line 178
    invoke-direct {p0, p1, p2}, Landroid/widget/Button;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 36
    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->applicationId:Ljava/lang/String;

    .line 38
    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->user:Lcom/facebook/model/GraphUser;

    .line 39
    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->userInfoSession:Lcom/facebook/Session;

    .line 46
    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;

    invoke-direct {v0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;-><init>()V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->properties:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;

    .line 180
    invoke-interface {p2}, Landroid/util/AttributeSet;->getStyleAttribute()I

    move-result v0

    if-nez v0, :cond_0

    .line 184
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f060014

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->setTextColor(I)V

    .line 185
    const/4 v0, 0x0

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0b001c

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v1

    invoke-virtual {p0, v0, v1}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->setTextSize(IF)V

    .line 187
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0b0016

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0b0018

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0b0017

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0b0019

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v3

    invoke-virtual {p0, v0, v1, v2, v3}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->setPadding(IIII)V

    .line 191
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0b001a

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->setWidth(I)V

    .line 192
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0b001b

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->setHeight(I)V

    .line 193
    const/16 v0, 0x11

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->setGravity(I)V

    .line 195
    invoke-direct {p0, p2}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->parseAttributes(Landroid/util/AttributeSet;)V

    .line 196
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->isInEditMode()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 199
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f060010

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->setBackgroundColor(I)V

    .line 201
    const-string v0, "Log in"

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->loginText:Ljava/lang/String;

    .line 207
    :cond_0
    :goto_0
    return-void

    .line 203
    :cond_1
    const v0, 0x7f02008e

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->setBackgroundResource(I)V

    .line 204
    invoke-direct {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->initializeActiveSessionWithCachedToken(Landroid/content/Context;)Z

    goto :goto_0
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 215
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/Button;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 36
    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->applicationId:Ljava/lang/String;

    .line 38
    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->user:Lcom/facebook/model/GraphUser;

    .line 39
    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->userInfoSession:Lcom/facebook/Session;

    .line 46
    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;

    invoke-direct {v0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;-><init>()V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->properties:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;

    .line 216
    invoke-direct {p0, p2}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->parseAttributes(Landroid/util/AttributeSet;)V

    .line 217
    invoke-direct {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->initializeActiveSessionWithCachedToken(Landroid/content/Context;)Z

    .line 218
    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 33
    sget-object v0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1300(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;)V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->fetchUserInfo()V

    return-void
.end method

.method static synthetic access$1400(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;)V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->setButtonText()V

    return-void
.end method

.method static synthetic access$200(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;)Lcom/facebook/internal/SessionTracker;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->sessionTracker:Lcom/facebook/internal/SessionTracker;

    return-object v0
.end method

.method static synthetic access$300(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;)Lcom/facebook/model/GraphUser;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->user:Lcom/facebook/model/GraphUser;

    return-object v0
.end method

.method static synthetic access$302(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;Lcom/facebook/model/GraphUser;)Lcom/facebook/model/GraphUser;
    .locals 0

    .prologue
    .line 33
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->user:Lcom/facebook/model/GraphUser;

    return-object p1
.end method

.method static synthetic access$400(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;)Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$UserInfoChangedCallback;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->userInfoChangedCallback:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$UserInfoChangedCallback;

    return-object v0
.end method

.method static synthetic access$500(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;)Z
    .locals 1

    .prologue
    .line 33
    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->confirmLogout:Z

    return v0
.end method

.method static synthetic access$600(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->applicationId:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$700(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;)Landroid/support/v4/app/Fragment;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->parentFragment:Landroid/support/v4/app/Fragment;

    return-object v0
.end method

.method static synthetic access$800(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;)Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->properties:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;

    return-object v0
.end method

.method private fetchUserInfo()V
    .locals 4

    .prologue
    .line 535
    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->fetchUserInfo:Z

    if-eqz v0, :cond_0

    .line 536
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->sessionTracker:Lcom/facebook/internal/SessionTracker;

    invoke-virtual {v0}, Lcom/facebook/internal/SessionTracker;->getOpenSession()Lcom/facebook/Session;

    move-result-object v0

    .line 537
    if-eqz v0, :cond_1

    .line 538
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->userInfoSession:Lcom/facebook/Session;

    if-eq v0, v1, :cond_0

    .line 539
    new-instance v1, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$1;

    invoke-direct {v1, p0, v0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$1;-><init>(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;Lcom/facebook/Session;)V

    invoke-static {v0, v1}, Lcom/facebook/Request;->newMeRequest(Lcom/facebook/Session;Lcom/facebook/Request$GraphUserCallback;)Lcom/facebook/Request;

    move-result-object v1

    .line 553
    const/4 v2, 0x1

    new-array v2, v2, [Lcom/facebook/Request;

    const/4 v3, 0x0

    aput-object v1, v2, v3

    invoke-static {v2}, Lcom/facebook/Request;->executeBatchAsync([Lcom/facebook/Request;)Lcom/facebook/RequestAsyncTask;

    .line 554
    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->userInfoSession:Lcom/facebook/Session;

    .line 563
    :cond_0
    :goto_0
    return-void

    .line 557
    :cond_1
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->user:Lcom/facebook/model/GraphUser;

    .line 558
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->userInfoChangedCallback:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$UserInfoChangedCallback;

    if-eqz v0, :cond_0

    .line 559
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->userInfoChangedCallback:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$UserInfoChangedCallback;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->user:Lcom/facebook/model/GraphUser;

    invoke-interface {v0, v1}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$UserInfoChangedCallback;->onUserInfoFetched(Lcom/facebook/model/GraphUser;)V

    goto :goto_0
.end method

.method private finishInit()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 450
    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginClickListener;

    invoke-direct {v0, p0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginClickListener;-><init>(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;)V

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 451
    invoke-direct {p0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->setButtonText()V

    .line 452
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->isInEditMode()Z

    move-result v0

    if-nez v0, :cond_0

    .line 453
    new-instance v0, Lcom/facebook/internal/SessionTracker;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->getContext()Landroid/content/Context;

    move-result-object v1

    new-instance v2, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonCallback;

    invoke-direct {v2, p0, v4}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonCallback;-><init>(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$1;)V

    const/4 v3, 0x0

    invoke-direct {v0, v1, v2, v4, v3}, Lcom/facebook/internal/SessionTracker;-><init>(Landroid/content/Context;Lcom/facebook/Session$StatusCallback;Lcom/facebook/Session;Z)V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->sessionTracker:Lcom/facebook/internal/SessionTracker;

    .line 454
    invoke-direct {p0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->fetchUserInfo()V

    .line 456
    :cond_0
    return-void
.end method

.method private initializeActiveSessionWithCachedToken(Landroid/content/Context;)Z
    .locals 2

    .prologue
    const/4 v0, 0x0

    .line 517
    if-nez p1, :cond_1

    .line 531
    :cond_0
    :goto_0
    return v0

    .line 521
    :cond_1
    invoke-static {}, Lcom/facebook/Session;->getActiveSession()Lcom/facebook/Session;

    move-result-object v1

    .line 522
    if-eqz v1, :cond_2

    .line 523
    invoke-virtual {v1}, Lcom/facebook/Session;->isOpened()Z

    move-result v0

    goto :goto_0

    .line 526
    :cond_2
    invoke-static {p1}, Lcom/facebook/internal/Utility;->getMetadataApplicationId(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    .line 527
    if-eqz v1, :cond_0

    .line 531
    invoke-static {p1}, Lcom/facebook/Session;->openActiveSessionFromCache(Landroid/content/Context;)Lcom/facebook/Session;

    move-result-object v1

    if-eqz v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0
.end method

.method private parseAttributes(Landroid/util/AttributeSet;)V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 498
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->getContext()Landroid/content/Context;

    move-result-object v0

    sget-object v1, Lcom/mixerbox/mixerbox3b/R$styleable;->com_facebook_login_view:[I

    invoke-virtual {v0, p1, v1}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 499
    const/4 v1, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v1

    iput-boolean v1, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->confirmLogout:Z

    .line 500
    invoke-virtual {v0, v2, v2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v1

    iput-boolean v1, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->fetchUserInfo:Z

    .line 501
    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->loginText:Ljava/lang/String;

    .line 502
    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->logoutText:Ljava/lang/String;

    .line 503
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 504
    return-void
.end method

.method private setButtonText()V
    .locals 2

    .prologue
    .line 507
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->sessionTracker:Lcom/facebook/internal/SessionTracker;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->sessionTracker:Lcom/facebook/internal/SessionTracker;

    invoke-virtual {v0}, Lcom/facebook/internal/SessionTracker;->getOpenSession()Lcom/facebook/Session;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 508
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->logoutText:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->logoutText:Ljava/lang/String;

    :goto_0
    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->setText(Ljava/lang/CharSequence;)V

    .line 514
    :goto_1
    return-void

    .line 508
    :cond_0
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f08002e

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 511
    :cond_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->loginText:Ljava/lang/String;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->loginText:Ljava/lang/String;

    :goto_2
    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->setText(Ljava/lang/CharSequence;)V

    goto :goto_1

    :cond_2
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f08002f

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_2
.end method


# virtual methods
.method public clearPermissions()V
    .locals 1

    .prologue
    .line 317
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->properties:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->clearPermissions()V

    .line 318
    return-void
.end method

.method public getDefaultAudience()Lcom/facebook/SessionDefaultAudience;
    .locals 1

    .prologue
    .line 258
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->properties:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->getDefaultAudience()Lcom/facebook/SessionDefaultAudience;

    move-result-object v0

    return-object v0
.end method

.method public getLoginBehavior()Lcom/facebook/SessionLoginBehavior;
    .locals 1

    .prologue
    .line 343
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->properties:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->getLoginBehavior()Lcom/facebook/SessionLoginBehavior;

    move-result-object v0

    return-object v0
.end method

.method public getOnErrorListener()Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$OnErrorListener;
    .locals 1

    .prologue
    .line 236
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->properties:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->getOnErrorListener()Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$OnErrorListener;

    move-result-object v0

    return-object v0
.end method

.method getPermissions()Ljava/util/List;
    .locals 1

    .prologue
    .line 490
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->properties:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->getPermissions()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getSessionStatusCallback()Lcom/facebook/Session$StatusCallback;
    .locals 1

    .prologue
    .line 390
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->properties:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->getSessionStatusCallback()Lcom/facebook/Session$StatusCallback;

    move-result-object v0

    return-object v0
.end method

.method public getUserInfoChangedCallback()Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$UserInfoChangedCallback;
    .locals 1

    .prologue
    .line 360
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->userInfoChangedCallback:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$UserInfoChangedCallback;

    return-object v0
.end method

.method handleError(Ljava/lang/Exception;)V
    .locals 2

    .prologue
    .line 645
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->properties:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->onErrorListener:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$OnErrorListener;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->access$1600(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;)Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$OnErrorListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 646
    instance-of v0, p1, Lcom/facebook/FacebookException;

    if-eqz v0, :cond_1

    .line 647
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->properties:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->onErrorListener:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$OnErrorListener;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->access$1600(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;)Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$OnErrorListener;

    move-result-object v0

    check-cast p1, Lcom/facebook/FacebookException;

    invoke-interface {v0, p1}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$OnErrorListener;->onError(Lcom/facebook/FacebookException;)V

    .line 652
    :cond_0
    :goto_0
    return-void

    .line 649
    :cond_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->properties:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->onErrorListener:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$OnErrorListener;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->access$1600(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;)Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$OnErrorListener;

    move-result-object v0

    new-instance v1, Lcom/facebook/FacebookException;

    invoke-direct {v1, p1}, Lcom/facebook/FacebookException;-><init>(Ljava/lang/Throwable;)V

    invoke-interface {v0, v1}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$OnErrorListener;->onError(Lcom/facebook/FacebookException;)V

    goto :goto_0
.end method

.method public onActivityResult(IILandroid/content/Intent;)Z
    .locals 2

    .prologue
    .line 417
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->sessionTracker:Lcom/facebook/internal/SessionTracker;

    invoke-virtual {v0}, Lcom/facebook/internal/SessionTracker;->getSession()Lcom/facebook/Session;

    move-result-object v1

    .line 418
    if-eqz v1, :cond_0

    .line 419
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Landroid/app/Activity;

    invoke-virtual {v1, v0, p1, p2, p3}, Lcom/facebook/Session;->onActivityResult(Landroid/app/Activity;IILandroid/content/Intent;)Z

    move-result v0

    .line 422
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected onAttachedToWindow()V
    .locals 1

    .prologue
    .line 472
    invoke-super {p0}, Landroid/widget/Button;->onAttachedToWindow()V

    .line 473
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->sessionTracker:Lcom/facebook/internal/SessionTracker;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->sessionTracker:Lcom/facebook/internal/SessionTracker;

    invoke-virtual {v0}, Lcom/facebook/internal/SessionTracker;->isTracking()Z

    move-result v0

    if-nez v0, :cond_0

    .line 474
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->sessionTracker:Lcom/facebook/internal/SessionTracker;

    invoke-virtual {v0}, Lcom/facebook/internal/SessionTracker;->startTracking()V

    .line 475
    invoke-direct {p0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->fetchUserInfo()V

    .line 476
    invoke-direct {p0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->setButtonText()V

    .line 478
    :cond_0
    return-void
.end method

.method protected onDetachedFromWindow()V
    .locals 1

    .prologue
    .line 482
    invoke-super {p0}, Landroid/widget/Button;->onDetachedFromWindow()V

    .line 483
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->sessionTracker:Lcom/facebook/internal/SessionTracker;

    if-eqz v0, :cond_0

    .line 484
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->sessionTracker:Lcom/facebook/internal/SessionTracker;

    invoke-virtual {v0}, Lcom/facebook/internal/SessionTracker;->stopTracking()V

    .line 486
    :cond_0
    return-void
.end method

.method public onFinishInflate()V
    .locals 0

    .prologue
    .line 445
    invoke-super {p0}, Landroid/widget/Button;->onFinishInflate()V

    .line 446
    invoke-direct {p0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->finishInit()V

    .line 447
    return-void
.end method

.method public setApplicationId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 352
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->applicationId:Ljava/lang/String;

    .line 353
    return-void
.end method

.method public setDefaultAudience(Lcom/facebook/SessionDefaultAudience;)V
    .locals 1

    .prologue
    .line 247
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->properties:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;

    invoke-virtual {v0, p1}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->setDefaultAudience(Lcom/facebook/SessionDefaultAudience;)V

    .line 248
    return-void
.end method

.method public setFragment(Landroid/support/v4/app/Fragment;)V
    .locals 0

    .prologue
    .line 467
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->parentFragment:Landroid/support/v4/app/Fragment;

    .line 468
    return-void
.end method

.method public setLoginBehavior(Lcom/facebook/SessionLoginBehavior;)V
    .locals 1

    .prologue
    .line 330
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->properties:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;

    invoke-virtual {v0, p1}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->setLoginBehavior(Lcom/facebook/SessionLoginBehavior;)V

    .line 331
    return-void
.end method

.method public setOnErrorListener(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$OnErrorListener;)V
    .locals 1

    .prologue
    .line 227
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->properties:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;

    invoke-virtual {v0, p1}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->setOnErrorListener(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$OnErrorListener;)V

    .line 228
    return-void
.end method

.method setProperties(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;)V
    .locals 0

    .prologue
    .line 494
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->properties:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;

    .line 495
    return-void
.end method

.method public setPublishPermissions(Ljava/util/List;)V
    .locals 2

    .prologue
    .line 309
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->properties:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->sessionTracker:Lcom/facebook/internal/SessionTracker;

    invoke-virtual {v1}, Lcom/facebook/internal/SessionTracker;->getSession()Lcom/facebook/Session;

    move-result-object v1

    invoke-virtual {v0, p1, v1}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->setPublishPermissions(Ljava/util/List;Lcom/facebook/Session;)V

    .line 310
    return-void
.end method

.method public setReadPermissions(Ljava/util/List;)V
    .locals 2

    .prologue
    .line 283
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->properties:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->sessionTracker:Lcom/facebook/internal/SessionTracker;

    invoke-virtual {v1}, Lcom/facebook/internal/SessionTracker;->getSession()Lcom/facebook/Session;

    move-result-object v1

    invoke-virtual {v0, p1, v1}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->setReadPermissions(Ljava/util/List;Lcom/facebook/Session;)V

    .line 284
    return-void
.end method

.method public setSession(Lcom/facebook/Session;)V
    .locals 1

    .prologue
    .line 438
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->sessionTracker:Lcom/facebook/internal/SessionTracker;

    invoke-virtual {v0, p1}, Lcom/facebook/internal/SessionTracker;->setSession(Lcom/facebook/Session;)V

    .line 439
    invoke-direct {p0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->fetchUserInfo()V

    .line 440
    invoke-direct {p0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->setButtonText()V

    .line 441
    return-void
.end method

.method public setSessionStatusCallback(Lcom/facebook/Session$StatusCallback;)V
    .locals 1

    .prologue
    .line 380
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->properties:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;

    invoke-virtual {v0, p1}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginButtonProperties;->setSessionStatusCallback(Lcom/facebook/Session$StatusCallback;)V

    .line 381
    return-void
.end method

.method public setUserInfoChangedCallback(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$UserInfoChangedCallback;)V
    .locals 0

    .prologue
    .line 369
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->userInfoChangedCallback:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$UserInfoChangedCallback;

    .line 370
    return-void
.end method

.class public Lcom/poshmark/ui/customviews/UserFollowButtonLayout;
.super Landroid/widget/FrameLayout;
.source "UserFollowButtonLayout.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/ui/customviews/UserFollowButtonLayout$UserFollowButtonListener;,
        Lcom/poshmark/ui/customviews/UserFollowButtonLayout$DisplayMode;
    }
.end annotation


# instance fields
.field displayMode:Lcom/poshmark/ui/customviews/UserFollowButtonLayout$DisplayMode;

.field fireAndForgetMode:Z

.field followButton:Landroid/widget/Button;

.field private followCallHandler:Lcom/poshmark/http/api/PMApiResponseHandler;

.field private followingCallHandler:Lcom/poshmark/http/api/PMApiResponseHandler;

.field isFollowing:Z

.field isSetupComplete:Z

.field listener:Lcom/poshmark/ui/customviews/UserFollowButtonLayout$UserFollowButtonListener;

.field progressSpinner:Landroid/widget/ProgressBar;

.field userId:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x0

    .line 47
    invoke-direct {p0, p1, p2}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 36
    iput-object v1, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->userId:Ljava/lang/String;

    .line 39
    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->isFollowing:Z

    .line 40
    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->isSetupComplete:Z

    .line 41
    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->fireAndForgetMode:Z

    .line 42
    iput-object v1, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->listener:Lcom/poshmark/ui/customviews/UserFollowButtonLayout$UserFollowButtonListener;

    .line 44
    sget-object v0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout$DisplayMode;->SINGLE_MODE:Lcom/poshmark/ui/customviews/UserFollowButtonLayout$DisplayMode;

    iput-object v0, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->displayMode:Lcom/poshmark/ui/customviews/UserFollowButtonLayout$DisplayMode;

    .line 150
    new-instance v0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout$2;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/customviews/UserFollowButtonLayout$2;-><init>(Lcom/poshmark/ui/customviews/UserFollowButtonLayout;)V

    iput-object v0, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->followCallHandler:Lcom/poshmark/http/api/PMApiResponseHandler;

    .line 169
    new-instance v0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout$3;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/customviews/UserFollowButtonLayout$3;-><init>(Lcom/poshmark/ui/customviews/UserFollowButtonLayout;)V

    iput-object v0, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->followingCallHandler:Lcom/poshmark/http/api/PMApiResponseHandler;

    .line 48
    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/customviews/UserFollowButtonLayout;)Lcom/poshmark/http/api/PMApiResponseHandler;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/customviews/UserFollowButtonLayout;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->followCallHandler:Lcom/poshmark/http/api/PMApiResponseHandler;

    return-object v0
.end method

.method static synthetic access$100(Lcom/poshmark/ui/customviews/UserFollowButtonLayout;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/customviews/UserFollowButtonLayout;
    .param p1, "x1"    # Z

    .prologue
    .line 30
    invoke-direct {p0, p1}, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->setButtonVisibility(Z)V

    return-void
.end method

.method static synthetic access$200(Lcom/poshmark/ui/customviews/UserFollowButtonLayout;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/customviews/UserFollowButtonLayout;

    .prologue
    .line 30
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->setFollowingButton()V

    return-void
.end method

.method static synthetic access$300(Lcom/poshmark/ui/customviews/UserFollowButtonLayout;)Lcom/poshmark/http/api/PMApiResponseHandler;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/customviews/UserFollowButtonLayout;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->followingCallHandler:Lcom/poshmark/http/api/PMApiResponseHandler;

    return-object v0
.end method

.method static synthetic access$400(Lcom/poshmark/ui/customviews/UserFollowButtonLayout;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/customviews/UserFollowButtonLayout;

    .prologue
    .line 30
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->setFollowButton()V

    return-void
.end method

.method static synthetic access$500(Lcom/poshmark/ui/customviews/UserFollowButtonLayout;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/customviews/UserFollowButtonLayout;

    .prologue
    .line 30
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->fireUserFollowingStatusChangedNotification()V

    return-void
.end method

.method private fireUserFollowingStatusChangedNotification()V
    .locals 3

    .prologue
    .line 122
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 123
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "USER"

    iget-object v2, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->userId:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 124
    const-string v1, "IS_FOLLOWING"

    iget-boolean v2, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->isFollowing:Z

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 125
    const-string v1, "com.poshmark.intents.USER_FOLLOW_STATUS_CHANGED"

    invoke-static {v1, v0}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 126
    return-void
.end method

.method private setButtonVisibility(Z)V
    .locals 3
    .param p1, "show"    # Z

    .prologue
    const/4 v2, 0x4

    const/4 v1, 0x0

    .line 141
    if-eqz p1, :cond_0

    .line 142
    iget-object v0, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->followButton:Landroid/widget/Button;

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setVisibility(I)V

    .line 143
    iget-object v0, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->progressSpinner:Landroid/widget/ProgressBar;

    invoke-virtual {v0, v2}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 148
    :goto_0
    return-void

    .line 145
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->followButton:Landroid/widget/Button;

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setVisibility(I)V

    .line 146
    iget-object v0, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->progressSpinner:Landroid/widget/ProgressBar;

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    goto :goto_0
.end method

.method private setFollowButton()V
    .locals 3

    .prologue
    .line 129
    iget-object v0, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->followButton:Landroid/widget/Button;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f020005

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 130
    iget-object v0, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->followButton:Landroid/widget/Button;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f090040

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setTextColor(I)V

    .line 131
    iget-object v0, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->followButton:Landroid/widget/Button;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f06012f

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 132
    return-void
.end method

.method private setFollowingButton()V
    .locals 3

    .prologue
    .line 135
    iget-object v0, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->followButton:Landroid/widget/Button;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f02000c

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 136
    iget-object v0, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->followButton:Landroid/widget/Button;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f090040

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setTextColor(I)V

    .line 137
    iget-object v0, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->followButton:Landroid/widget/Button;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f060134

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 138
    return-void
.end method

.method private setup()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 81
    iget-boolean v0, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->isSetupComplete:Z

    if-nez v0, :cond_0

    .line 82
    iput-boolean v2, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->isSetupComplete:Z

    .line 83
    const v0, 0x7f0c0060

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->followButton:Landroid/widget/Button;

    .line 84
    const v0, 0x7f0c0061

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    iput-object v0, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->progressSpinner:Landroid/widget/ProgressBar;

    .line 86
    iget-object v0, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->followButton:Landroid/widget/Button;

    new-instance v1, Lcom/poshmark/ui/customviews/UserFollowButtonLayout$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/customviews/UserFollowButtonLayout$1;-><init>(Lcom/poshmark/ui/customviews/UserFollowButtonLayout;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 117
    invoke-direct {p0, v2}, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->setButtonVisibility(Z)V

    .line 119
    :cond_0
    return-void
.end method


# virtual methods
.method protected onAttachedToWindow()V
    .locals 0

    .prologue
    .line 53
    return-void
.end method

.method protected onDetachedFromWindow()V
    .locals 0

    .prologue
    .line 58
    return-void
.end method

.method public setDisplayMode(Lcom/poshmark/ui/customviews/UserFollowButtonLayout$DisplayMode;)V
    .locals 0
    .param p1, "mode"    # Lcom/poshmark/ui/customviews/UserFollowButtonLayout$DisplayMode;

    .prologue
    .line 61
    iput-object p1, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->displayMode:Lcom/poshmark/ui/customviews/UserFollowButtonLayout$DisplayMode;

    .line 62
    return-void
.end method

.method public setListener(Lcom/poshmark/ui/customviews/UserFollowButtonLayout$UserFollowButtonListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/poshmark/ui/customviews/UserFollowButtonLayout$UserFollowButtonListener;

    .prologue
    .line 65
    iput-object p1, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->listener:Lcom/poshmark/ui/customviews/UserFollowButtonLayout$UserFollowButtonListener;

    .line 66
    return-void
.end method

.method public setUser(Ljava/lang/String;Z)V
    .locals 1
    .param p1, "user"    # Ljava/lang/String;
    .param p2, "isFollowing"    # Z

    .prologue
    .line 69
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->setup()V

    .line 70
    iput-object p1, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->userId:Ljava/lang/String;

    .line 71
    if-eqz p2, :cond_0

    .line 72
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->isFollowing:Z

    .line 73
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->setFollowingButton()V

    .line 78
    :goto_0
    return-void

    .line 75
    :cond_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->isFollowing:Z

    .line 76
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/UserFollowButtonLayout;->setFollowButton()V

    goto :goto_0
.end method

.class public Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;
.super Landroid/widget/FrameLayout;
.source "BrandFollowButtonLayout.java"


# instance fields
.field brandName:Ljava/lang/String;

.field followButton:Landroid/widget/Button;

.field followingButtonColor:I

.field followingButtonDrawable:I

.field isFollowing:Z

.field isSetupComplete:Z

.field progressSpinner:Landroid/widget/ProgressBar;

.field screenNameForAnalytics:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x0

    .line 36
    invoke-direct {p0, p1, p2}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 27
    iput-object v1, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->brandName:Ljava/lang/String;

    .line 30
    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->isFollowing:Z

    .line 31
    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->isSetupComplete:Z

    .line 32
    const v0, 0x7f090040

    iput v0, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->followingButtonColor:I

    .line 33
    const v0, 0x7f02000c

    iput v0, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->followingButtonDrawable:I

    .line 34
    iput-object v1, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->screenNameForAnalytics:Ljava/lang/String;

    .line 37
    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;
    .param p1, "x1"    # Z

    .prologue
    .line 25
    invoke-direct {p0, p1}, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->setButtonVisibility(Z)V

    return-void
.end method

.method static synthetic access$100(Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;

    .prologue
    .line 25
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->setFollowingButton()V

    return-void
.end method

.method static synthetic access$200(Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;

    .prologue
    .line 25
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->fireBrandStatusChangedNotification()V

    return-void
.end method

.method static synthetic access$300(Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;

    .prologue
    .line 25
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->setFollowButton()V

    return-void
.end method

.method private fireBrandStatusChangedNotification()V
    .locals 3

    .prologue
    .line 124
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 125
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "BRAND"

    iget-object v2, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->brandName:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 126
    const-string v1, "com.poshmark.intents.BRAND_FOLLOW_STATUS_CHANGED"

    invoke-static {v1, v0}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 127
    return-void
.end method

.method private setButtonVisibility(Z)V
    .locals 3
    .param p1, "show"    # Z

    .prologue
    const/4 v2, 0x4

    const/4 v1, 0x0

    .line 142
    if-eqz p1, :cond_0

    .line 143
    iget-object v0, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->followButton:Landroid/widget/Button;

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setVisibility(I)V

    .line 144
    iget-object v0, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->progressSpinner:Landroid/widget/ProgressBar;

    invoke-virtual {v0, v2}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 149
    :goto_0
    return-void

    .line 146
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->followButton:Landroid/widget/Button;

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setVisibility(I)V

    .line 147
    iget-object v0, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->progressSpinner:Landroid/widget/ProgressBar;

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    goto :goto_0
.end method

.method private setFollowButton()V
    .locals 3

    .prologue
    .line 130
    iget-object v0, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->followButton:Landroid/widget/Button;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f020007

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 131
    iget-object v0, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->followButton:Landroid/widget/Button;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f090040

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setTextColor(I)V

    .line 132
    iget-object v0, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->followButton:Landroid/widget/Button;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f06012f

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 133
    return-void
.end method

.method private setFollowingButton()V
    .locals 3

    .prologue
    .line 136
    iget-object v0, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->followButton:Landroid/widget/Button;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    iget v2, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->followingButtonDrawable:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 137
    iget-object v0, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->followButton:Landroid/widget/Button;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    iget v2, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->followingButtonColor:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setTextColor(I)V

    .line 138
    iget-object v0, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->followButton:Landroid/widget/Button;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f060134

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 139
    return-void
.end method

.method private setup()V
    .locals 2

    .prologue
    .line 66
    iget-boolean v0, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->isSetupComplete:Z

    if-nez v0, :cond_0

    .line 67
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->isSetupComplete:Z

    .line 68
    const v0, 0x7f0c0060

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->followButton:Landroid/widget/Button;

    .line 69
    const v0, 0x7f0c0061

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    iput-object v0, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->progressSpinner:Landroid/widget/ProgressBar;

    .line 71
    iget-object v0, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->followButton:Landroid/widget/Button;

    new-instance v1, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1;-><init>(Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 121
    :cond_0
    return-void
.end method


# virtual methods
.method protected onAttachedToWindow()V
    .locals 0

    .prologue
    .line 42
    return-void
.end method

.method protected onDetachedFromWindow()V
    .locals 0

    .prologue
    .line 46
    return-void
.end method

.method public setBrand(Ljava/lang/String;)V
    .locals 2
    .param p1, "brand"    # Ljava/lang/String;

    .prologue
    .line 49
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->setup()V

    .line 50
    iput-object p1, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->brandName:Ljava/lang/String;

    .line 51
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->brandName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/poshmark/controllers/GlobalDbController;->isFollowingBrand(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 52
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->isFollowing:Z

    .line 53
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->setFollowingButton()V

    .line 58
    :goto_0
    return-void

    .line 55
    :cond_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->isFollowing:Z

    .line 56
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->setFollowButton()V

    goto :goto_0
.end method

.method public setFollowingButtonColor(II)V
    .locals 0
    .param p1, "drawableId"    # I
    .param p2, "color"    # I

    .prologue
    .line 61
    iput p1, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->followingButtonDrawable:I

    .line 62
    iput p2, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->followingButtonColor:I

    .line 63
    return-void
.end method

.method public setParentScreenNameForAnalytics(Ljava/lang/String;)V
    .locals 0
    .param p1, "viewNameForAnalytics"    # Ljava/lang/String;

    .prologue
    .line 152
    iput-object p1, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->screenNameForAnalytics:Ljava/lang/String;

    .line 153
    return-void
.end method

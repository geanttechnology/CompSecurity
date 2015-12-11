.class public Lcom/bestbuy/android/base/BaseFragmentContainer;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"


# instance fields
.field private a:Z

.field private b:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 12
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 14
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bestbuy/android/base/BaseFragmentContainer;->a:Z

    .line 15
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/base/BaseFragmentContainer;->b:Z

    return-void
.end method


# virtual methods
.method public a(Landroid/support/v4/app/Fragment;Z)V
    .locals 1

    .prologue
    .line 21
    const-string v0, ""

    invoke-virtual {p0, p1, p2, v0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    .line 22
    return-void
.end method

.method public a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V
    .locals 2

    .prologue
    .line 24
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    new-instance v1, Lcom/bestbuy/android/base/BaseFragmentContainer$1;

    invoke-direct {v1, p0, p2, p1, p3}, Lcom/bestbuy/android/base/BaseFragmentContainer$1;-><init>(Lcom/bestbuy/android/base/BaseFragmentContainer;ZLandroid/support/v4/app/Fragment;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 39
    return-void
.end method

.method public b()Landroid/support/v4/app/Fragment;
    .locals 2

    .prologue
    .line 132
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 133
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const v1, 0x7f0c009e

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 134
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public d()V
    .locals 1

    .prologue
    .line 59
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->popBackStack()V

    .line 60
    return-void
.end method

.method public e()Z
    .locals 4

    .prologue
    const v3, 0x7f0c009e

    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 63
    .line 65
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->getBackStackEntryCount()I

    move-result v0

    if-le v0, v1, :cond_0

    move v0, v1

    .line 66
    :goto_0
    if-eqz v0, :cond_3

    .line 68
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 73
    instance-of v2, v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    if-eqz v2, :cond_2

    .line 74
    check-cast v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    .line 75
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->d()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 76
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->e()V

    .line 98
    :goto_1
    return v1

    :cond_0
    move v0, v2

    .line 65
    goto :goto_0

    .line 78
    :cond_1
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->popBackStack()V

    goto :goto_1

    .line 81
    :cond_2
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->popBackStack()V

    goto :goto_1

    .line 84
    :cond_3
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 85
    instance-of v3, v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    if-eqz v3, :cond_5

    .line 86
    check-cast v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    .line 87
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->d()Z

    move-result v3

    if-eqz v3, :cond_4

    .line 88
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->e()V

    move v0, v1

    :goto_2
    move v1, v0

    .line 94
    goto :goto_1

    .line 91
    :cond_4
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->popBackStack()V

    move v0, v2

    .line 92
    goto :goto_2

    .line 95
    :cond_5
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->popBackStack()V

    move v1, v2

    goto :goto_1
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 17
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 18
    return-void
.end method

.class public Lcom/bestbuy/android/base/BBYBaseFragment;
.super Landroid/support/v4/app/Fragment;
.source "SourceFile"


# instance fields
.field private a:Z

.field public d:Landroid/app/Activity;

.field public e:Landroid/widget/FrameLayout;

.field public f:Lnb;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0}, Landroid/support/v4/app/Fragment;-><init>()V

    .line 41
    return-void
.end method


# virtual methods
.method public a(Landroid/view/View;)Landroid/widget/FrameLayout;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/bestbuy/android/base/BBYBaseFragment;->e:Landroid/widget/FrameLayout;

    if-nez v0, :cond_0

    .line 55
    const v0, 0x7f0c0064

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    iput-object v0, p0, Lcom/bestbuy/android/base/BBYBaseFragment;->e:Landroid/widget/FrameLayout;

    .line 57
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/base/BBYBaseFragment;->e:Landroid/widget/FrameLayout;

    return-object v0
.end method

.method public a(Lcom/bestbuy/android/api/lib/models/search/SearchApi;Ljava/lang/String;)V
    .locals 7

    .prologue
    .line 86
    iget-object v0, p0, Lcom/bestbuy/android/base/BBYBaseFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const v1, 0x7f0c0033

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v4

    .line 87
    const/4 v5, 0x0

    .line 88
    instance-of v0, v4, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v0, :cond_0

    move-object v0, v4

    .line 89
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    move-object v5, v0

    .line 91
    :cond_0
    instance-of v0, v4, Lcom/bestbuy/android/base/BaseFragmentContainer;

    if-nez v0, :cond_1

    .line 92
    invoke-virtual {v5}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b()Landroid/support/v4/app/FragmentTabHost;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTabHost;->getCurrentTab()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 100
    :cond_1
    :goto_0
    :pswitch_0
    new-instance v6, Landroid/os/Handler;

    invoke-direct {v6}, Landroid/os/Handler;-><init>()V

    new-instance v0, Lcom/bestbuy/android/base/BBYBaseFragment$1;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    invoke-direct/range {v0 .. v5}, Lcom/bestbuy/android/base/BBYBaseFragment$1;-><init>(Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/search/SearchApi;Ljava/lang/String;Landroid/support/v4/app/Fragment;Lcom/bestbuy/android/activities/home/HomeTabFragment;)V

    const-wide/16 v2, 0x1f4

    invoke-virtual {v6, v0, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 174
    return-void

    .line 95
    :pswitch_1
    const/4 v0, 0x1

    invoke-virtual {v5, v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->a(I)V

    goto :goto_0

    .line 92
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public a(Ljava/lang/String;Landroid/widget/FrameLayout;)V
    .locals 12

    .prologue
    const/4 v5, 0x0

    const/4 v8, 0x1

    const/4 v10, 0x0

    .line 80
    new-instance v0, Lhz;

    iget-object v1, p0, Lcom/bestbuy/android/base/BBYBaseFragment;->d:Landroid/app/Activity;

    const-string v7, ""

    const/16 v9, 0x14

    move-object v2, p0

    move-object v3, p2

    move-object v4, p1

    move-object v6, v5

    move v11, v8

    invoke-direct/range {v0 .. v11}, Lhz;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;IIZZ)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v10, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhz;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 82
    return-void
.end method

.method public b_()V
    .locals 0

    .prologue
    .line 69
    return-void
.end method

.method public d(Z)V
    .locals 0

    .prologue
    .line 76
    iput-boolean p1, p0, Lcom/bestbuy/android/base/BBYBaseFragment;->a:Z

    .line 77
    return-void
.end method

.method public l()Z
    .locals 1

    .prologue
    .line 72
    iget-boolean v0, p0, Lcom/bestbuy/android/base/BBYBaseFragment;->a:Z

    return v0
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 49
    invoke-super {p0, p1}, Landroid/support/v4/app/Fragment;->onAttach(Landroid/app/Activity;)V

    .line 50
    iput-object p1, p0, Lcom/bestbuy/android/base/BBYBaseFragment;->d:Landroid/app/Activity;

    .line 51
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 44
    invoke-super {p0, p1}, Landroid/support/v4/app/Fragment;->onCreate(Landroid/os/Bundle;)V

    .line 45
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/base/BBYBaseFragment;->f:Lnb;

    .line 46
    return-void
.end method

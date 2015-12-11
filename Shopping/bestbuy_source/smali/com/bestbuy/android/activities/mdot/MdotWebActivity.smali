.class public Lcom/bestbuy/android/activities/mdot/MdotWebActivity;
.super Lcom/bestbuy/android/base/BBYBaseFragmentActivity;
.source "SourceFile"


# instance fields
.field private a:Lcom/bestbuy/android/base/BBYBaseFragment;

.field private b:Ljava/lang/String;

.field private c:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 15
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;-><init>()V

    .line 18
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebActivity;->b:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 5

    .prologue
    const v4, 0x7f0c0056

    const v3, 0x7f080055

    .line 25
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onCreate(Landroid/os/Bundle;)V

    .line 26
    const v0, 0x7f03000c

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/mdot/MdotWebActivity;->setContentView(I)V

    .line 27
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mdot/MdotWebActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 28
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mdot/MdotWebActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mdot/MdotWebActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/content/Intent;->hasExtra(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 29
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mdot/MdotWebActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebActivity;->c:Ljava/lang/String;

    .line 31
    :cond_0
    invoke-virtual {p0, v4}, Lcom/bestbuy/android/activities/mdot/MdotWebActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 32
    if-eqz p1, :cond_2

    .line 39
    :cond_1
    :goto_0
    return-void

    .line 35
    :cond_2
    new-instance v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-direct {v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebActivity;->a:Lcom/bestbuy/android/base/BBYBaseFragment;

    .line 36
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebActivity;->a:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mdot/MdotWebActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragment;->setArguments(Landroid/os/Bundle;)V

    .line 37
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mdot/MdotWebActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebActivity;->a:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0, v4, v1}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    goto :goto_0
.end method

.method public onPause()V
    .locals 0

    .prologue
    .line 48
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onPause()V

    .line 49
    invoke-static {}, Llu;->a()V

    .line 51
    return-void
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 42
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onResume()V

    .line 43
    invoke-static {p0}, Llu;->a(Landroid/app/Activity;)V

    .line 45
    return-void
.end method

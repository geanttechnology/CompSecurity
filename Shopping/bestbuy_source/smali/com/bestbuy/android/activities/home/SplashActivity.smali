.class public Lcom/bestbuy/android/activities/home/SplashActivity;
.super Lcom/bestbuy/android/base/BBYBaseFragmentActivity;
.source "SourceFile"


# static fields
.field private static final a:Ljava/lang/String;


# instance fields
.field private b:Lnb;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 18
    const-class v0, Lcom/bestbuy/android/activities/home/SplashActivity;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/activities/home/SplashActivity;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;-><init>()V

    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 22
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onCreate(Landroid/os/Bundle;)V

    .line 27
    const-string v0, "AD-AAB-AAB-GRA"

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/SplashActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v0, v1}, Ll;->a(Ljava/lang/String;Landroid/content/Context;)V

    .line 30
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/SplashActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Llu;->a(Landroid/content/Context;)V

    .line 32
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/SplashActivity;->b:Lnb;

    .line 33
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/SplashActivity;->b:Lnb;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/home/SplashActivity;->b:Lnb;

    invoke-virtual {v0}, Lnb;->x()Z

    move-result v0

    if-nez v0, :cond_0

    .line 34
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 35
    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/home/SplashActivity;->startActivity(Landroid/content/Intent;)V

    .line 36
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/SplashActivity;->finish()V

    .line 44
    :goto_0
    return-void

    .line 40
    :cond_0
    const v0, 0x7f0300f4

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/home/SplashActivity;->setContentView(I)V

    .line 42
    new-instance v0, Lcom/bestbuy/android/activities/home/SplashFragment;

    invoke-direct {v0}, Lcom/bestbuy/android/activities/home/SplashFragment;-><init>()V

    .line 43
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/SplashActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v1

    const v2, 0x7f0c0056

    invoke-virtual {v1, v2, v0}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    goto :goto_0
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 54
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onPause()V

    .line 55
    invoke-static {}, Llu;->a()V

    .line 56
    return-void
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 48
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onResume()V

    .line 49
    invoke-static {p0}, Llu;->a(Landroid/app/Activity;)V

    .line 50
    return-void
.end method

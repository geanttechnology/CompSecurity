.class Lcom/bestbuy/android/activities/home/SplashFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/home/SplashFragment;->b()V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/home/SplashFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/home/SplashFragment;)V
    .locals 0

    .prologue
    .line 52
    iput-object p1, p0, Lcom/bestbuy/android/activities/home/SplashFragment$1;->a:Lcom/bestbuy/android/activities/home/SplashFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 55
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/SplashFragment$1;->a:Lcom/bestbuy/android/activities/home/SplashFragment;

    iget-object v1, v1, Lcom/bestbuy/android/activities/home/SplashFragment;->a:Landroid/app/Activity;

    const-class v2, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 56
    iget-object v1, p0, Lcom/bestbuy/android/activities/home/SplashFragment$1;->a:Lcom/bestbuy/android/activities/home/SplashFragment;

    iget-object v1, v1, Lcom/bestbuy/android/activities/home/SplashFragment;->f:Lnb;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lnb;->a(Z)V

    .line 57
    const/high16 v1, 0x4000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 58
    iget-object v1, p0, Lcom/bestbuy/android/activities/home/SplashFragment$1;->a:Lcom/bestbuy/android/activities/home/SplashFragment;

    iget-object v1, v1, Lcom/bestbuy/android/activities/home/SplashFragment;->a:Landroid/app/Activity;

    invoke-virtual {v1, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 59
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/SplashFragment$1;->a:Lcom/bestbuy/android/activities/home/SplashFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/home/SplashFragment;->a:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    .line 60
    return-void
.end method

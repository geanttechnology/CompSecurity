.class public Lcom/bestbuy/android/activities/appsettings/MediumActivity;
.super Landroid/app/Activity;
.source "SourceFile"


# instance fields
.field private a:I

.field private b:Ljava/lang/String;

.field private c:Ljava/lang/String;

.field private d:Lnb;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 12
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 14
    const/4 v0, 0x0

    iput v0, p0, Lcom/bestbuy/android/activities/appsettings/MediumActivity;->a:I

    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    invoke-static {p0}, Lp;->a(Landroid/app/Activity;)V

    .line 21
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 22
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/appsettings/MediumActivity;->d:Lnb;

    .line 24
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/appsettings/MediumActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 25
    if-eqz v0, :cond_0

    .line 26
    const-string v1, "mDotURL"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/bestbuy/android/activities/appsettings/MediumActivity;->b:Ljava/lang/String;

    .line 27
    const-string v1, "KEY_NAME"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/appsettings/MediumActivity;->c:Ljava/lang/String;

    .line 30
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/MediumActivity;->b:Ljava/lang/String;

    if-eqz v0, :cond_3

    .line 32
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/MediumActivity;->d:Lnb;

    invoke-virtual {v0}, Lnb;->R()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 33
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 36
    :goto_0
    const-string v1, "com.bestbuy.android.NOTIFICATION"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 37
    const-string v1, "IS_CALLED_FROM_NOTIFICATION"

    invoke-virtual {v0, v1, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 38
    const-string v1, "TAB_NAME"

    const-string v2, "ProductTab"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 39
    const/high16 v1, 0x4000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 40
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/appsettings/MediumActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080055

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/appsettings/MediumActivity;->b:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 41
    iget-object v1, p0, Lcom/bestbuy/android/activities/appsettings/MediumActivity;->c:Ljava/lang/String;

    const v2, 0x7f080388

    invoke-virtual {p0, v2}, Lcom/bestbuy/android/activities/appsettings/MediumActivity;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    iget-object v1, p0, Lcom/bestbuy/android/activities/appsettings/MediumActivity;->c:Ljava/lang/String;

    const v2, 0x7f0802c1

    invoke-virtual {p0, v2}, Lcom/bestbuy/android/activities/appsettings/MediumActivity;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 42
    :cond_1
    const-string v1, "isDod"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 46
    :cond_2
    :goto_1
    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/appsettings/MediumActivity;->startActivity(Landroid/content/Intent;)V

    .line 49
    :cond_3
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/appsettings/MediumActivity;->finish()V

    .line 50
    return-void

    .line 35
    :cond_4
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    goto :goto_0

    .line 43
    :cond_5
    iget-object v1, p0, Lcom/bestbuy/android/activities/appsettings/MediumActivity;->c:Ljava/lang/String;

    const v2, 0x7f08016f

    invoke-virtual {p0, v2}, Lcom/bestbuy/android/activities/appsettings/MediumActivity;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 44
    const-string v1, "isDod"

    invoke-virtual {v0, v1, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    goto :goto_1
.end method

.method protected onDestroy()V
    .locals 0

    invoke-super {p0}, Landroid/app/Activity;->onDestroy()V

    invoke-static {p0}, Lp;->d(Landroid/app/Activity;)V

    return-void
.end method

.method protected onPause()V
    .locals 0

    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    invoke-static {p0}, Lp;->g(Landroid/app/Activity;)V

    return-void
.end method

.method protected onRestart()V
    .locals 0

    invoke-super {p0}, Landroid/app/Activity;->onRestart()V

    invoke-static {p0}, Lp;->e(Landroid/app/Activity;)V

    return-void
.end method

.method protected onResume()V
    .locals 0

    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    invoke-static {p0}, Lp;->f(Landroid/app/Activity;)V

    return-void
.end method

.method protected onStart()V
    .locals 0

    invoke-super {p0}, Landroid/app/Activity;->onStart()V

    invoke-static {p0}, Lp;->b(Landroid/app/Activity;)V

    return-void
.end method

.method protected onStop()V
    .locals 0

    invoke-super {p0}, Landroid/app/Activity;->onStop()V

    invoke-static {p0}, Lp;->c(Landroid/app/Activity;)V

    return-void
.end method

.class public final Lcom/google/android/gms/ads/purchase/InAppPurchaseActivity;
.super Landroid/app/Activity;


# instance fields
.field private a:Lym;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method


# virtual methods
.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 2

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/ads/purchase/InAppPurchaseActivity;->a:Lym;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/ads/purchase/InAppPurchaseActivity;->a:Lym;

    invoke-interface {v0, p1, p2, p3}, Lym;->a(IILandroid/content/Intent;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    invoke-super {p0, p1, p2, p3}, Landroid/app/Activity;->onActivityResult(IILandroid/content/Intent;)V

    return-void

    :catch_0
    move-exception v0

    const-string v1, "Could not forward onActivityResult to in-app purchase manager:"

    invoke-static {v1, v0}, Lacb;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 2

    invoke-static {p0}, Lp;->a(Landroid/app/Activity;)V

    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    invoke-static {p0}, Lyz;->a(Landroid/app/Activity;)Lym;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/ads/purchase/InAppPurchaseActivity;->a:Lym;

    iget-object v0, p0, Lcom/google/android/gms/ads/purchase/InAppPurchaseActivity;->a:Lym;

    if-nez v0, :cond_0

    const-string v0, "Could not create in-app purchase manager."

    invoke-static {v0}, Lacb;->e(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/google/android/gms/ads/purchase/InAppPurchaseActivity;->finish()V

    :goto_0
    return-void

    :cond_0
    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/ads/purchase/InAppPurchaseActivity;->a:Lym;

    invoke-interface {v0}, Lym;->a()V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    const-string v1, "Could not forward onCreate to in-app purchase manager:"

    invoke-static {v1, v0}, Lacb;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    invoke-virtual {p0}, Lcom/google/android/gms/ads/purchase/InAppPurchaseActivity;->finish()V

    goto :goto_0
.end method

.method protected onDestroy()V
    .locals 2

    invoke-static {p0}, Lp;->d(Landroid/app/Activity;)V

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/ads/purchase/InAppPurchaseActivity;->a:Lym;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/ads/purchase/InAppPurchaseActivity;->a:Lym;

    invoke-interface {v0}, Lym;->b()V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    invoke-super {p0}, Landroid/app/Activity;->onDestroy()V

    return-void

    :catch_0
    move-exception v0

    const-string v1, "Could not forward onDestroy to in-app purchase manager:"

    invoke-static {v1, v0}, Lacb;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
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

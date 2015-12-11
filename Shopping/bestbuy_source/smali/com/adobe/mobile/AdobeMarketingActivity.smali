.class public abstract Lcom/adobe/mobile/AdobeMarketingActivity;
.super Landroid/app/Activity;
.source "SourceFile"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    invoke-static {p0}, Lp;->a(Landroid/app/Activity;)V

    .line 27
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 28
    invoke-virtual {p0}, Lcom/adobe/mobile/AdobeMarketingActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/adobe/mobile/Config;->setContext(Landroid/content/Context;)V

    .line 29
    return-void
.end method

.method protected onDestroy()V
    .locals 0

    invoke-super {p0}, Landroid/app/Activity;->onDestroy()V

    invoke-static {p0}, Lp;->d(Landroid/app/Activity;)V

    return-void
.end method

.method public onPause()V
    .locals 0

    .prologue
    invoke-static {p0}, Lp;->g(Landroid/app/Activity;)V

    .line 33
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 34
    invoke-static {}, Lcom/adobe/mobile/Config;->pauseCollectingLifecycleData()V

    .line 35
    return-void
.end method

.method protected onRestart()V
    .locals 0

    invoke-super {p0}, Landroid/app/Activity;->onRestart()V

    invoke-static {p0}, Lp;->e(Landroid/app/Activity;)V

    return-void
.end method

.method public onResume()V
    .locals 0

    .prologue
    invoke-static {p0}, Lp;->f(Landroid/app/Activity;)V

    .line 39
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 40
    invoke-static {p0}, Lcom/adobe/mobile/Config;->collectLifecycleData(Landroid/app/Activity;)V

    .line 41
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

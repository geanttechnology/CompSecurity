.class public Lco/vine/android/SonyLaunchActivity;
.super Landroid/app/Activity;
.source "SonyLaunchActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 17
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 19
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lco/vine/android/SonyRecordingActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 20
    .local v0, "intent":Landroid/content/Intent;
    const v1, 0x10008000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 21
    invoke-virtual {p0, v0}, Lco/vine/android/SonyLaunchActivity;->startActivity(Landroid/content/Intent;)V

    .line 22
    invoke-virtual {p0}, Lco/vine/android/SonyLaunchActivity;->finish()V

    .line 23
    return-void
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .locals 0
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 27
    invoke-super {p0, p1}, Landroid/app/Activity;->onNewIntent(Landroid/content/Intent;)V

    .line 28
    return-void
.end method

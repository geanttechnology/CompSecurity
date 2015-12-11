.class public Lcom/wishabi/flipp/app/InstallBroadcastReceiver;
.super Landroid/content/BroadcastReceiver;
.source "SourceFile"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 4

    .prologue
    .line 16
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    iget-object v0, v0, Lcom/wishabi/flipp/b/a;->b:Landroid/content/Context;

    const-string v1, "com.wishabi.flipp.preferences"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-virtual {p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_0

    const-string v2, "referrer"

    const-string v3, "none"

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    :goto_0
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    const-string v2, "referrer"

    invoke-interface {v1, v2, v0}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 17
    new-instance v0, Lcom/localytics/android/ReferralReceiver;

    invoke-direct {v0}, Lcom/localytics/android/ReferralReceiver;-><init>()V

    invoke-virtual {v0, p1, p2}, Lcom/localytics/android/ReferralReceiver;->onReceive(Landroid/content/Context;Landroid/content/Intent;)V

    .line 18
    new-instance v0, Lcom/google/analytics/tracking/android/j;

    invoke-direct {v0}, Lcom/google/analytics/tracking/android/j;-><init>()V

    invoke-virtual {v0, p1, p2}, Lcom/google/analytics/tracking/android/j;->onReceive(Landroid/content/Context;Landroid/content/Intent;)V

    .line 19
    return-void

    .line 16
    :cond_0
    const-string v0, "none"

    goto :goto_0
.end method

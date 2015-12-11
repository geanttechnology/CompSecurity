.class final Lcom/wishabi/flipp/app/dh;
.super Landroid/content/BroadcastReceiver;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/MainActivity;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/MainActivity;)V
    .locals 0

    .prologue
    .line 102
    iput-object p1, p0, Lcom/wishabi/flipp/app/dh;->a:Lcom/wishabi/flipp/app/MainActivity;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public final onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 4

    .prologue
    .line 105
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v0

    .line 106
    invoke-static {}, Lcom/wishabi/flipp/util/p;->a()Landroid/content/SharedPreferences;

    move-result-object v2

    .line 107
    if-eqz v2, :cond_0

    .line 108
    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    const-string v3, "app_open_last_recreate_nano"

    invoke-interface {v2, v3, v0, v1}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 110
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/dh;->a:Lcom/wishabi/flipp/app/MainActivity;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/MainActivity;->recreate()V

    .line 111
    return-void
.end method

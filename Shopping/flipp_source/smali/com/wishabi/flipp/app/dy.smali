.class final Lcom/wishabi/flipp/app/dy;
.super Landroid/content/BroadcastReceiver;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/SearchActivity;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/SearchActivity;)V
    .locals 0

    .prologue
    .line 25
    iput-object p1, p0, Lcom/wishabi/flipp/app/dy;->a:Lcom/wishabi/flipp/app/SearchActivity;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public final onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 4

    .prologue
    .line 28
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v0

    .line 29
    invoke-static {}, Lcom/wishabi/flipp/util/p;->a()Landroid/content/SharedPreferences;

    move-result-object v2

    .line 30
    if-eqz v2, :cond_0

    .line 31
    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    const-string v3, "app_open_last_recreate_nano"

    invoke-interface {v2, v3, v0, v1}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 33
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/dy;->a:Lcom/wishabi/flipp/app/SearchActivity;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/SearchActivity;->recreate()V

    .line 34
    return-void
.end method

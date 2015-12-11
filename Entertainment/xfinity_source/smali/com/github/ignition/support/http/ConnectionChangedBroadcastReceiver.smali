.class public Lcom/github/ignition/support/http/ConnectionChangedBroadcastReceiver;
.super Landroid/content/BroadcastReceiver;
.source "ConnectionChangedBroadcastReceiver.java"


# instance fields
.field private http:Lcom/github/ignition/support/http/IgnitedHttp;


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 32
    iget-object v0, p0, Lcom/github/ignition/support/http/ConnectionChangedBroadcastReceiver;->http:Lcom/github/ignition/support/http/IgnitedHttp;

    invoke-virtual {v0, p1}, Lcom/github/ignition/support/http/IgnitedHttp;->updateProxySettings(Landroid/content/Context;)V

    .line 33
    return-void
.end method

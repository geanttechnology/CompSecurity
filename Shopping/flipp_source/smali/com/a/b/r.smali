.class final Lcom/a/b/r;
.super Landroid/content/BroadcastReceiver;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/a/b/n;

.field private final b:Landroid/net/ConnectivityManager;


# direct methods
.method constructor <init>(Lcom/a/b/n;Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 280
    iput-object p1, p0, Lcom/a/b/r;->a:Lcom/a/b/n;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    .line 281
    const-string v0, "connectivity"

    invoke-virtual {p2, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    iput-object v0, p0, Lcom/a/b/r;->b:Landroid/net/ConnectivityManager;

    .line 282
    return-void
.end method


# virtual methods
.method public final onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 6

    .prologue
    const/4 v1, 0x0

    .line 301
    if-nez p2, :cond_1

    .line 313
    :cond_0
    :goto_0
    return-void

    .line 305
    :cond_1
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 306
    invoke-virtual {p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v2

    .line 308
    const-string v3, "android.intent.action.AIRPLANE_MODE"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 309
    iget-object v0, p0, Lcom/a/b/r;->a:Lcom/a/b/n;

    const-string v3, "state"

    invoke-virtual {v2, v3, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v2

    iget-object v3, v0, Lcom/a/b/n;->f:Landroid/os/Handler;

    iget-object v4, v0, Lcom/a/b/n;->f:Landroid/os/Handler;

    const/16 v5, 0xa

    if-eqz v2, :cond_2

    const/4 v0, 0x1

    :goto_1
    invoke-virtual {v4, v5, v0, v1}, Landroid/os/Handler;->obtainMessage(III)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {v3, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto :goto_0

    :cond_2
    move v0, v1

    goto :goto_1

    .line 310
    :cond_3
    const-string v1, "android.net.conn.CONNECTIVITY_CHANGE"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 311
    iget-object v0, p0, Lcom/a/b/r;->a:Lcom/a/b/n;

    iget-object v1, p0, Lcom/a/b/r;->b:Landroid/net/ConnectivityManager;

    invoke-virtual {v1}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v1

    iget-object v2, v0, Lcom/a/b/n;->f:Landroid/os/Handler;

    iget-object v0, v0, Lcom/a/b/n;->f:Landroid/os/Handler;

    const/16 v3, 0x9

    invoke-virtual {v0, v3, v1}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {v2, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto :goto_0
.end method

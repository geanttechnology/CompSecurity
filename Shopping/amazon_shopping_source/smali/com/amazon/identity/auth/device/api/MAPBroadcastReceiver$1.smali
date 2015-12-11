.class Lcom/amazon/identity/auth/device/api/MAPBroadcastReceiver$1;
.super Ljava/lang/Object;
.source "MAPBroadcastReceiver.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/device/api/MAPBroadcastReceiver;->onReceive(Landroid/content/Context;Landroid/content/Intent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/api/MAPBroadcastReceiver;

.field final synthetic val$context:Landroid/content/Context;

.field final synthetic val$intent:Landroid/content/Intent;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/api/MAPBroadcastReceiver;Landroid/content/Context;Landroid/content/Intent;)V
    .locals 0

    .prologue
    .line 50
    iput-object p1, p0, Lcom/amazon/identity/auth/device/api/MAPBroadcastReceiver$1;->this$0:Lcom/amazon/identity/auth/device/api/MAPBroadcastReceiver;

    iput-object p2, p0, Lcom/amazon/identity/auth/device/api/MAPBroadcastReceiver$1;->val$context:Landroid/content/Context;

    iput-object p3, p0, Lcom/amazon/identity/auth/device/api/MAPBroadcastReceiver$1;->val$intent:Landroid/content/Intent;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 55
    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPBroadcastReceiver$1;->val$context:Landroid/content/Context;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/MAPBroadcastReceiver$1;->val$intent:Landroid/content/Intent;

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/api/MAPBroadcastReceiver;->constructBackwardsCompatibleIntent(Landroid/content/Context;Landroid/content/Intent;)Landroid/content/Intent;

    move-result-object v0

    .line 56
    .local v0, "backCompatIntent":Landroid/content/Intent;
    if-nez v0, :cond_0

    .line 58
    # getter for: Lcom/amazon/identity/auth/device/api/MAPBroadcastReceiver;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/api/MAPBroadcastReceiver;->access$000()Ljava/lang/String;

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/amazon/identity/auth/device/api/MAPBroadcastReceiver$1;->val$intent:Landroid/content/Intent;

    invoke-virtual {v3}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    .line 63
    :goto_0
    return-void

    .line 62
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPBroadcastReceiver$1;->this$0:Lcom/amazon/identity/auth/device/api/MAPBroadcastReceiver;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/MAPBroadcastReceiver$1;->val$context:Landroid/content/Context;

    invoke-virtual {v1, v2, v0}, Lcom/amazon/identity/auth/device/api/MAPBroadcastReceiver;->backwardsCompatibleOnReceive(Landroid/content/Context;Landroid/content/Intent;)V

    goto :goto_0
.end method

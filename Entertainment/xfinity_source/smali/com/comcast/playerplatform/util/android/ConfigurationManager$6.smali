.class Lcom/comcast/playerplatform/util/android/ConfigurationManager$6;
.super Landroid/content/BroadcastReceiver;
.source "ConfigurationManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/util/android/ConfigurationManager;->initializeESPN(Landroid/content/Context;Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/util/android/ConfigurationManager;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/util/android/ConfigurationManager;)V
    .locals 0

    .prologue
    .line 221
    iput-object p1, p0, Lcom/comcast/playerplatform/util/android/ConfigurationManager$6;->this$0:Lcom/comcast/playerplatform/util/android/ConfigurationManager;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 224
    iget-object v0, p0, Lcom/comcast/playerplatform/util/android/ConfigurationManager$6;->this$0:Lcom/comcast/playerplatform/util/android/ConfigurationManager;

    const/4 v1, 0x1

    # setter for: Lcom/comcast/playerplatform/util/android/ConfigurationManager;->isEspnReady:Z
    invoke-static {v0, v1}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->access$202(Lcom/comcast/playerplatform/util/android/ConfigurationManager;Z)Z

    .line 225
    invoke-virtual {p1, p0}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 226
    return-void
.end method

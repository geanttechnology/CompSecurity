.class public Lcom/aio/downloader/jpush/JpushMainActivity$MessageReceiver;
.super Landroid/content/BroadcastReceiver;
.source "JpushMainActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/jpush/JpushMainActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "MessageReceiver"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/jpush/JpushMainActivity;


# direct methods
.method public constructor <init>(Lcom/aio/downloader/jpush/JpushMainActivity;)V
    .locals 0

    .prologue
    .line 64
    iput-object p1, p0, Lcom/aio/downloader/jpush/JpushMainActivity$MessageReceiver;->this$0:Lcom/aio/downloader/jpush/JpushMainActivity;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 68
    const-string v3, "com.example.jpushdemo.MESSAGE_RECEIVED_ACTION"

    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 69
    const-string v3, "message"

    invoke-virtual {p2, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 70
    .local v1, "messge":Ljava/lang/String;
    const-string v3, "extras"

    invoke-virtual {p2, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 71
    .local v0, "extras":Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 72
    .local v2, "showMsg":Ljava/lang/StringBuilder;
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "message : "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\n"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 75
    .end local v0    # "extras":Ljava/lang/String;
    .end local v1    # "messge":Ljava/lang/String;
    .end local v2    # "showMsg":Ljava/lang/StringBuilder;
    :cond_0
    return-void
.end method

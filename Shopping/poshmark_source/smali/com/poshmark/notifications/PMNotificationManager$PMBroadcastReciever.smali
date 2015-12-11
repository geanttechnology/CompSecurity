.class public Lcom/poshmark/notifications/PMNotificationManager$PMBroadcastReciever;
.super Landroid/content/BroadcastReceiver;
.source "PMNotificationManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/notifications/PMNotificationManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "PMBroadcastReciever"
.end annotation


# instance fields
.field listener:Lcom/poshmark/notifications/PMNotificationListener;

.field final synthetic this$0:Lcom/poshmark/notifications/PMNotificationManager;


# direct methods
.method public constructor <init>(Lcom/poshmark/notifications/PMNotificationManager;)V
    .locals 1

    .prologue
    .line 148
    iput-object p1, p0, Lcom/poshmark/notifications/PMNotificationManager$PMBroadcastReciever;->this$0:Lcom/poshmark/notifications/PMNotificationManager;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    .line 142
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/notifications/PMNotificationManager$PMBroadcastReciever;->listener:Lcom/poshmark/notifications/PMNotificationListener;

    .line 150
    return-void
.end method

.method public constructor <init>(Lcom/poshmark/notifications/PMNotificationManager;Lcom/poshmark/notifications/PMNotificationListener;)V
    .locals 1
    .param p2, "listener"    # Lcom/poshmark/notifications/PMNotificationListener;

    .prologue
    .line 144
    iput-object p1, p0, Lcom/poshmark/notifications/PMNotificationManager$PMBroadcastReciever;->this$0:Lcom/poshmark/notifications/PMNotificationManager;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    .line 142
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/notifications/PMNotificationManager$PMBroadcastReciever;->listener:Lcom/poshmark/notifications/PMNotificationListener;

    .line 145
    iput-object p2, p0, Lcom/poshmark/notifications/PMNotificationManager$PMBroadcastReciever;->listener:Lcom/poshmark/notifications/PMNotificationListener;

    .line 146
    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 154
    iget-object v0, p0, Lcom/poshmark/notifications/PMNotificationManager$PMBroadcastReciever;->listener:Lcom/poshmark/notifications/PMNotificationListener;

    if-eqz v0, :cond_0

    .line 155
    iget-object v0, p0, Lcom/poshmark/notifications/PMNotificationManager$PMBroadcastReciever;->listener:Lcom/poshmark/notifications/PMNotificationListener;

    invoke-interface {v0, p2}, Lcom/poshmark/notifications/PMNotificationListener;->handleNotification(Landroid/content/Intent;)V

    .line 157
    :cond_0
    return-void
.end method

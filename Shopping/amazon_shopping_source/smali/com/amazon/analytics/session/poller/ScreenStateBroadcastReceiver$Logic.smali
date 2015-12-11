.class Lcom/amazon/analytics/session/poller/ScreenStateBroadcastReceiver$Logic;
.super Ljava/lang/Object;
.source "ScreenStateBroadcastReceiver.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/analytics/session/poller/ScreenStateBroadcastReceiver;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Logic"
.end annotation


# instance fields
.field private screenChangeListener:Lcom/amazon/analytics/session/poller/ScreenStateBroadcastReceiver$ScreenStateChangeListener;


# direct methods
.method public constructor <init>(Lcom/amazon/analytics/session/poller/ScreenStateBroadcastReceiver$ScreenStateChangeListener;)V
    .locals 1
    .param p1, "screenChangeListener"    # Lcom/amazon/analytics/session/poller/ScreenStateBroadcastReceiver$ScreenStateChangeListener;

    .prologue
    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    invoke-static {p1}, Lcom/amazon/analytics/util/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/analytics/session/poller/ScreenStateBroadcastReceiver$ScreenStateChangeListener;

    iput-object v0, p0, Lcom/amazon/analytics/session/poller/ScreenStateBroadcastReceiver$Logic;->screenChangeListener:Lcom/amazon/analytics/session/poller/ScreenStateBroadcastReceiver$ScreenStateChangeListener;

    .line 43
    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 46
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 47
    .local v0, "intentAction":Ljava/lang/String;
    const-string/jumbo v1, "android.intent.action.SCREEN_ON"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 48
    iget-object v1, p0, Lcom/amazon/analytics/session/poller/ScreenStateBroadcastReceiver$Logic;->screenChangeListener:Lcom/amazon/analytics/session/poller/ScreenStateBroadcastReceiver$ScreenStateChangeListener;

    invoke-interface {v1}, Lcom/amazon/analytics/session/poller/ScreenStateBroadcastReceiver$ScreenStateChangeListener;->onScreenOn()V

    .line 52
    :cond_0
    :goto_0
    return-void

    .line 49
    :cond_1
    const-string/jumbo v1, "android.intent.action.SCREEN_OFF"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 50
    iget-object v1, p0, Lcom/amazon/analytics/session/poller/ScreenStateBroadcastReceiver$Logic;->screenChangeListener:Lcom/amazon/analytics/session/poller/ScreenStateBroadcastReceiver$ScreenStateChangeListener;

    invoke-interface {v1}, Lcom/amazon/analytics/session/poller/ScreenStateBroadcastReceiver$ScreenStateChangeListener;->onScreenOff()V

    goto :goto_0
.end method

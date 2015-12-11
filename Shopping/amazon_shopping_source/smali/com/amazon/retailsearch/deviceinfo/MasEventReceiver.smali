.class public Lcom/amazon/retailsearch/deviceinfo/MasEventReceiver;
.super Landroid/content/BroadcastReceiver;
.source "MasEventReceiver.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/deviceinfo/MasEventReceiver$MasAction;
    }
.end annotation


# static fields
.field private static final log:Lcom/amazon/retailsearch/log/MessageLogger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    const-class v0, Lcom/amazon/retailsearch/deviceinfo/MasEventReceiver;

    invoke-static {v0}, Lcom/amazon/retailsearch/log/AppLog;->getLog(Ljava/lang/Class;)Lcom/amazon/retailsearch/log/MessageLogger;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/deviceinfo/MasEventReceiver;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    .line 45
    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 21
    if-nez p2, :cond_0

    .line 30
    :goto_0
    return-void

    .line 26
    :cond_0
    sget-object v1, Lcom/amazon/retailsearch/deviceinfo/MasEventReceiver;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Received broadcast: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Lcom/amazon/retailsearch/log/MessageLogger;->debug(Ljava/lang/String;)V

    .line 28
    invoke-static {}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->getInstance()Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;

    move-result-object v0

    .line 29
    .local v0, "loader":Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;
    invoke-virtual {v0, p1}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->refresh(Landroid/content/Context;)V

    goto :goto_0
.end method

.method public register(Landroid/content/Context;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 35
    :try_start_0
    new-instance v1, Landroid/content/IntentFilter;

    invoke-direct {v1}, Landroid/content/IntentFilter;-><init>()V

    .line 36
    .local v1, "filter":Landroid/content/IntentFilter;
    const-string/jumbo v2, "com.amazon.mas.client.tokenrefresh.TokenRefreshService.ddi.refresh.successful"

    invoke-virtual {v1, v2}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 37
    const-string/jumbo v2, "com.amazon.mas.client.authentication.action.AUTHENTICATION_SUCCESS_ACTION"

    invoke-virtual {v1, v2}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 38
    const-string/jumbo v2, "com.amazon.mas.client.authentication.action.USER_DEREGISTERED_ACTION"

    invoke-virtual {v1, v2}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 39
    invoke-virtual {p1, p0, v1}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 43
    .end local v1    # "filter":Landroid/content/IntentFilter;
    :goto_0
    return-void

    .line 40
    :catch_0
    move-exception v0

    .line 41
    .local v0, "e":Ljava/lang/Throwable;
    sget-object v2, Lcom/amazon/retailsearch/deviceinfo/MasEventReceiver;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    const-string/jumbo v3, "Error"

    invoke-interface {v2, v3, v0}, Lcom/amazon/retailsearch/log/MessageLogger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

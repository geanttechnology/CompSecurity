.class public Lcom/exacttarget/etpushsdk/ETCloudPageManager;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/exacttarget/etpushsdk/event/BackgroundEventListener;
.implements Lcom/exacttarget/etpushsdk/event/CloudPagesResponseListener;


# static fields
.field private static a:Lcom/exacttarget/etpushsdk/ETCloudPageManager;


# instance fields
.field private b:Landroid/content/Context;


# direct methods
.method private constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 40
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/ETCloudPageManager;->b:Landroid/content/Context;

    .line 42
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/EventBus;->getInstance()Lcom/exacttarget/etpushsdk/util/EventBus;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/exacttarget/etpushsdk/util/EventBus;->register(Ljava/lang/Object;)V

    .line 43
    return-void
.end method

.method protected static a(Landroid/content/Context;)V
    .locals 2

    .prologue
    .line 68
    sget-object v0, Lcom/exacttarget/etpushsdk/ETCloudPageManager;->a:Lcom/exacttarget/etpushsdk/ETCloudPageManager;

    if-nez v0, :cond_0

    .line 69
    const-string v0, "~!ETCloudPageManager"

    const-string v1, "readyAimFire()"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 70
    new-instance v0, Lcom/exacttarget/etpushsdk/ETCloudPageManager;

    invoke-direct {v0, p0}, Lcom/exacttarget/etpushsdk/ETCloudPageManager;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/exacttarget/etpushsdk/ETCloudPageManager;->a:Lcom/exacttarget/etpushsdk/ETCloudPageManager;

    .line 74
    return-void

    .line 72
    :cond_0
    new-instance v0, Lcom/exacttarget/etpushsdk/ETException;

    const-string v1, "You must have called readyAimFire more than once."

    invoke-direct {v0, v1}, Lcom/exacttarget/etpushsdk/ETException;-><init>(Ljava/lang/String;)V

    throw v0
.end method


# virtual methods
.method public a()V
    .locals 3

    .prologue
    .line 128
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/ETCloudPageManager;->b:Landroid/content/Context;

    const-class v2, Lcom/exacttarget/etpushsdk/ETPushReceiver;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 129
    const-string v1, "et_send_type_extra"

    const-string v2, "et_send_type_cloudpage"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 130
    iget-object v1, p0, Lcom/exacttarget/etpushsdk/ETCloudPageManager;->b:Landroid/content/Context;

    invoke-virtual {v1, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 131
    return-void
.end method

.method public onEvent(Lcom/exacttarget/etpushsdk/event/BackgroundEvent;)V
    .locals 2

    .prologue
    .line 84
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->j()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 85
    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/BackgroundEvent;->isInBackground()Z

    move-result v0

    if-nez v0, :cond_0

    .line 87
    const-string v0, "~!ETCloudPageManager"

    const-string v1, "In FOREGROUND"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 88
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/ETCloudPageManager;->a()V

    .line 91
    :cond_0
    return-void
.end method

.method public onEvent(Lcom/exacttarget/etpushsdk/event/CloudPagesResponse;)V
    .locals 4

    .prologue
    .line 102
    if-eqz p1, :cond_0

    :try_start_0
    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/CloudPagesResponse;->getMessages()Ljava/util/ArrayList;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/CloudPagesResponse;->getMessages()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 103
    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/CloudPagesResponse;->getMessages()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/exacttarget/etpushsdk/data/Message;

    .line 104
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Message;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/exacttarget/etpushsdk/database/e;->a(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/data/Message;

    move-result-object v2

    .line 105
    if-eqz v2, :cond_1

    .line 107
    invoke-virtual {v2}, Lcom/exacttarget/etpushsdk/data/Message;->getRead()Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Message;->setRead(Ljava/lang/Boolean;)V

    .line 109
    invoke-virtual {v2}, Lcom/exacttarget/etpushsdk/data/Message;->getMessageDeleted()Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/exacttarget/etpushsdk/data/Message;->setMessageDeleted(Ljava/lang/Boolean;)V

    .line 111
    invoke-static {v0}, Lcom/exacttarget/etpushsdk/database/e;->c(Lcom/exacttarget/etpushsdk/data/Message;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 119
    :catch_0
    move-exception v0

    .line 120
    const-string v1, "~!ETCloudPageManager"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 122
    :cond_0
    :goto_1
    return-void

    .line 113
    :cond_1
    :try_start_1
    invoke-static {v0}, Lcom/exacttarget/etpushsdk/database/e;->a(Lcom/exacttarget/etpushsdk/data/Message;)V

    goto :goto_0

    .line 117
    :cond_2
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/EventBus;->getInstance()Lcom/exacttarget/etpushsdk/util/EventBus;

    move-result-object v0

    new-instance v1, Lcom/exacttarget/etpushsdk/event/CloudPagesChangedEvent;

    invoke-direct {v1}, Lcom/exacttarget/etpushsdk/event/CloudPagesChangedEvent;-><init>()V

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/util/EventBus;->a(Ljava/lang/Object;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1
.end method

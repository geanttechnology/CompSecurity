.class public Lcom/igexin/sdk/bean/PushMessageBean;
.super Ljava/lang/Object;
.source "PushMessageBean.java"


# instance fields
.field private actionChains:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/igexin/sdk/bean/BaseBean;",
            ">;"
        }
    .end annotation
.end field

.field private actionId:Ljava/lang/String;

.field private masterMessageId:Ljava/lang/String;

.field private masterTaskId:Ljava/lang/String;

.field private messageId:Ljava/lang/String;

.field private payload:[B

.field private taskId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getActionChains()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/igexin/sdk/bean/BaseBean;",
            ">;"
        }
    .end annotation

    .prologue
    .line 69
    iget-object v0, p0, Lcom/igexin/sdk/bean/PushMessageBean;->actionChains:Ljava/util/List;

    return-object v0
.end method

.method public getActionId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/igexin/sdk/bean/PushMessageBean;->actionId:Ljava/lang/String;

    return-object v0
.end method

.method public getBean(Ljava/lang/String;)Lcom/igexin/sdk/bean/BaseBean;
    .locals 4
    .param p1, "actionId"    # Ljava/lang/String;

    .prologue
    .line 94
    invoke-virtual {p0}, Lcom/igexin/sdk/bean/PushMessageBean;->getActionChains()Ljava/util/List;

    move-result-object v0

    .line 95
    .local v0, "actionChains":Ljava/util/List;, "Ljava/util/List<Lcom/igexin/sdk/bean/BaseBean;>;"
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/igexin/sdk/bean/BaseBean;

    .line 96
    .local v1, "bean":Lcom/igexin/sdk/bean/BaseBean;
    invoke-virtual {v1}, Lcom/igexin/sdk/bean/BaseBean;->getActionId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 100
    .end local v1    # "bean":Lcom/igexin/sdk/bean/BaseBean;
    :goto_0
    return-object v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getMasterMessageId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/igexin/sdk/bean/PushMessageBean;->masterMessageId:Ljava/lang/String;

    return-object v0
.end method

.method public getMasterTaskId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/igexin/sdk/bean/PushMessageBean;->masterTaskId:Ljava/lang/String;

    return-object v0
.end method

.method public getMessageId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/igexin/sdk/bean/PushMessageBean;->messageId:Ljava/lang/String;

    return-object v0
.end method

.method public getPayload()[B
    .locals 1

    .prologue
    .line 77
    iget-object v0, p0, Lcom/igexin/sdk/bean/PushMessageBean;->payload:[B

    return-object v0
.end method

.method public getTaskId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/igexin/sdk/bean/PushMessageBean;->taskId:Ljava/lang/String;

    return-object v0
.end method

.method public setActionChains(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/igexin/sdk/bean/BaseBean;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 73
    .local p1, "actionChains":Ljava/util/List;, "Ljava/util/List<Lcom/igexin/sdk/bean/BaseBean;>;"
    iput-object p1, p0, Lcom/igexin/sdk/bean/PushMessageBean;->actionChains:Ljava/util/List;

    .line 74
    return-void
.end method

.method public setActionId(Ljava/lang/String;)V
    .locals 0
    .param p1, "actionId"    # Ljava/lang/String;

    .prologue
    .line 65
    iput-object p1, p0, Lcom/igexin/sdk/bean/PushMessageBean;->actionId:Ljava/lang/String;

    .line 66
    return-void
.end method

.method public setMasterMessageId(Ljava/lang/String;)V
    .locals 0
    .param p1, "masterMessageId"    # Ljava/lang/String;

    .prologue
    .line 41
    iput-object p1, p0, Lcom/igexin/sdk/bean/PushMessageBean;->masterMessageId:Ljava/lang/String;

    .line 42
    return-void
.end method

.method public setMasterTaskId(Ljava/lang/String;)V
    .locals 0
    .param p1, "masterTaskId"    # Ljava/lang/String;

    .prologue
    .line 33
    iput-object p1, p0, Lcom/igexin/sdk/bean/PushMessageBean;->masterTaskId:Ljava/lang/String;

    .line 34
    return-void
.end method

.method public setMessageId(Ljava/lang/String;)V
    .locals 0
    .param p1, "messageId"    # Ljava/lang/String;

    .prologue
    .line 49
    iput-object p1, p0, Lcom/igexin/sdk/bean/PushMessageBean;->messageId:Ljava/lang/String;

    .line 50
    return-void
.end method

.method public setPayload([B)V
    .locals 0
    .param p1, "payload"    # [B

    .prologue
    .line 81
    iput-object p1, p0, Lcom/igexin/sdk/bean/PushMessageBean;->payload:[B

    .line 82
    return-void
.end method

.method public setTaskId(Ljava/lang/String;)V
    .locals 0
    .param p1, "taskId"    # Ljava/lang/String;

    .prologue
    .line 57
    iput-object p1, p0, Lcom/igexin/sdk/bean/PushMessageBean;->taskId:Ljava/lang/String;

    .line 58
    return-void
.end method

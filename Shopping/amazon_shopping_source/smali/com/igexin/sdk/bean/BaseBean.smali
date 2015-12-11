.class public Lcom/igexin/sdk/bean/BaseBean;
.super Ljava/lang/Object;
.source "BaseBean.java"


# instance fields
.field private actionId:Ljava/lang/String;

.field private doActionId:Ljava/lang/String;

.field private type:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getActionId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/igexin/sdk/bean/BaseBean;->actionId:Ljava/lang/String;

    return-object v0
.end method

.method public getDoActionId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/igexin/sdk/bean/BaseBean;->doActionId:Ljava/lang/String;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/igexin/sdk/bean/BaseBean;->type:Ljava/lang/String;

    return-object v0
.end method

.method public setActionId(Ljava/lang/String;)V
    .locals 0
    .param p1, "actionId"    # Ljava/lang/String;

    .prologue
    .line 27
    iput-object p1, p0, Lcom/igexin/sdk/bean/BaseBean;->actionId:Ljava/lang/String;

    .line 28
    return-void
.end method

.method public setDoActionId(Ljava/lang/String;)V
    .locals 0
    .param p1, "doActionId"    # Ljava/lang/String;

    .prologue
    .line 43
    iput-object p1, p0, Lcom/igexin/sdk/bean/BaseBean;->doActionId:Ljava/lang/String;

    .line 44
    return-void
.end method

.method public setType(Ljava/lang/String;)V
    .locals 0
    .param p1, "type"    # Ljava/lang/String;

    .prologue
    .line 35
    iput-object p1, p0, Lcom/igexin/sdk/bean/BaseBean;->type:Ljava/lang/String;

    .line 36
    return-void
.end method

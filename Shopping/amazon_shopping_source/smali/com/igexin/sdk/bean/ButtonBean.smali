.class public Lcom/igexin/sdk/bean/ButtonBean;
.super Ljava/lang/Object;
.source "ButtonBean.java"


# instance fields
.field private doActionId:Ljava/lang/String;

.field private text:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getDoActionId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/igexin/sdk/bean/ButtonBean;->doActionId:Ljava/lang/String;

    return-object v0
.end method

.method public getText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 15
    iget-object v0, p0, Lcom/igexin/sdk/bean/ButtonBean;->text:Ljava/lang/String;

    return-object v0
.end method

.method public setDoActionId(Ljava/lang/String;)V
    .locals 0
    .param p1, "doActionId"    # Ljava/lang/String;

    .prologue
    .line 27
    iput-object p1, p0, Lcom/igexin/sdk/bean/ButtonBean;->doActionId:Ljava/lang/String;

    .line 28
    return-void
.end method

.method public setText(Ljava/lang/String;)V
    .locals 0
    .param p1, "text"    # Ljava/lang/String;

    .prologue
    .line 19
    iput-object p1, p0, Lcom/igexin/sdk/bean/ButtonBean;->text:Ljava/lang/String;

    .line 20
    return-void
.end method

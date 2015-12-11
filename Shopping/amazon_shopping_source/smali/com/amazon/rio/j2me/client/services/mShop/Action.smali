.class public Lcom/amazon/rio/j2me/client/services/mShop/Action;
.super Ljava/lang/Object;
.source "Action.java"


# instance fields
.field private params:Ljava/lang/String;

.field private type:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getParams()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/Action;->params:Ljava/lang/String;

    return-object v0
.end method

.method public getType()I
    .locals 1

    .prologue
    .line 18
    iget v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/Action;->type:I

    return v0
.end method

.method public setParams(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 36
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Action;->params:Ljava/lang/String;

    .line 37
    return-void
.end method

.method public setType(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 23
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Action;->type:I

    .line 24
    return-void
.end method

.class public Lcom/amazon/rio/j2me/client/services/mShop/HyperText;
.super Ljava/lang/Object;
.source "HyperText.java"


# instance fields
.field private attributes:Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;

.field private lineBreak:Z

.field private text:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAttributes()Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/HyperText;->attributes:Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;

    return-object v0
.end method

.method public getLineBreak()Z
    .locals 1

    .prologue
    .line 45
    iget-boolean v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/HyperText;->lineBreak:Z

    return v0
.end method

.method public getText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/HyperText;->text:Ljava/lang/String;

    return-object v0
.end method

.method public setAttributes(Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;

    .prologue
    .line 40
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/HyperText;->attributes:Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;

    .line 41
    return-void
.end method

.method public setLineBreak(Z)V
    .locals 0
    .param p1, "value_"    # Z

    .prologue
    .line 50
    iput-boolean p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/HyperText;->lineBreak:Z

    .line 51
    return-void
.end method

.method public setText(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 27
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/HyperText;->text:Ljava/lang/String;

    .line 28
    return-void
.end method

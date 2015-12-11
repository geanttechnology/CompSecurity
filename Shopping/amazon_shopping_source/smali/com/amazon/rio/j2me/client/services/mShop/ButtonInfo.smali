.class public Lcom/amazon/rio/j2me/client/services/mShop/ButtonInfo;
.super Ljava/lang/Object;
.source "ButtonInfo.java"


# instance fields
.field private buttonAction:Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;

.field private buttonText:Lcom/amazon/rio/j2me/client/services/mShop/HyperText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public setButtonAction(Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;

    .prologue
    .line 39
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ButtonInfo;->buttonAction:Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;

    .line 40
    return-void
.end method

.method public setButtonText(Lcom/amazon/rio/j2me/client/services/mShop/HyperText;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

    .prologue
    .line 26
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ButtonInfo;->buttonText:Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

    .line 27
    return-void
.end method

.class public Lcom/amazon/rio/j2me/client/services/mShop/Subtotal;
.super Ljava/lang/Object;
.source "Subtotal.java"


# instance fields
.field private amount:Ljava/lang/String;

.field private name:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public setAmount(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 39
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Subtotal;->amount:Ljava/lang/String;

    .line 40
    return-void
.end method

.method public setName(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 26
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Subtotal;->name:Ljava/lang/String;

    .line 27
    return-void
.end method

.class public Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;
.super Ljava/lang/Object;
.source "KeyValuePair.java"


# instance fields
.field private key:Ljava/lang/String;

.field private value:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;->key:Ljava/lang/String;

    return-object v0
.end method

.method public getValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;->value:Ljava/lang/String;

    return-object v0
.end method

.method public setKey(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 23
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;->key:Ljava/lang/String;

    .line 24
    return-void
.end method

.method public setValue(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 33
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;->value:Ljava/lang/String;

    .line 34
    return-void
.end method

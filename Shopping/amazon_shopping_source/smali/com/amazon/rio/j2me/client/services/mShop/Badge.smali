.class public Lcom/amazon/rio/j2me/client/services/mShop/Badge;
.super Ljava/lang/Object;
.source "Badge.java"


# instance fields
.field private meta:Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

.field private type:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getMeta()Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/Badge;->meta:Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/Badge;->type:Ljava/lang/String;

    return-object v0
.end method

.method public setMeta(Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

    .prologue
    .line 33
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Badge;->meta:Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

    .line 34
    return-void
.end method

.method public setType(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 23
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Badge;->type:Ljava/lang/String;

    .line 24
    return-void
.end method

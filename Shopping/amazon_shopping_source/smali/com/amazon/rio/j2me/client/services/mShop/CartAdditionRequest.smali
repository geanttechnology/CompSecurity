.class public Lcom/amazon/rio/j2me/client/services/mShop/CartAdditionRequest;
.super Ljava/lang/Object;
.source "CartAdditionRequest.java"


# instance fields
.field private additions:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/CartAddition;",
            ">;"
        }
    .end annotation
.end field

.field private clickStreamOrigin:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAdditions()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/CartAddition;",
            ">;"
        }
    .end annotation

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartAdditionRequest;->additions:Ljava/util/List;

    return-object v0
.end method

.method public getClickStreamOrigin()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartAdditionRequest;->clickStreamOrigin:Ljava/lang/String;

    return-object v0
.end method

.method public setAdditions(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/CartAddition;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 23
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/CartAddition;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartAdditionRequest;->additions:Ljava/util/List;

    .line 24
    return-void
.end method

.method public setClickStreamOrigin(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 33
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartAdditionRequest;->clickStreamOrigin:Ljava/lang/String;

    .line 34
    return-void
.end method

.class public Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsResponse;
.super Ljava/lang/Object;
.source "AddListItemsResponse.java"


# instance fields
.field private addedItems:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/ListItem;",
            ">;"
        }
    .end annotation
.end field

.field private affectedRegistry:Lcom/amazon/rio/j2me/client/services/mShop/ListList;

.field private errorCode:Ljava/lang/Integer;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public setAddedItems(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/ListItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 40
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/ListItem;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsResponse;->addedItems:Ljava/util/List;

    .line 41
    return-void
.end method

.method public setAffectedRegistry(Lcom/amazon/rio/j2me/client/services/mShop/ListList;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/ListList;

    .prologue
    .line 27
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsResponse;->affectedRegistry:Lcom/amazon/rio/j2me/client/services/mShop/ListList;

    .line 28
    return-void
.end method

.method public setErrorCode(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 53
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsResponse;->errorCode:Ljava/lang/Integer;

    .line 54
    return-void
.end method

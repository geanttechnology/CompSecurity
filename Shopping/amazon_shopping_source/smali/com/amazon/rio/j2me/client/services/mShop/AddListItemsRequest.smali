.class public Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsRequest;
.super Ljava/lang/Object;
.source "AddListItemsRequest.java"


# instance fields
.field private items:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/RequestListItem;",
            ">;"
        }
    .end annotation
.end field

.field private returnAddedItems:Ljava/lang/Boolean;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getItems()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/RequestListItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsRequest;->items:Ljava/util/List;

    return-object v0
.end method

.method public getReturnAddedItems()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsRequest;->returnAddedItems:Ljava/lang/Boolean;

    return-object v0
.end method

.method public setItems(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/RequestListItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 23
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/RequestListItem;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsRequest;->items:Ljava/util/List;

    .line 24
    return-void
.end method

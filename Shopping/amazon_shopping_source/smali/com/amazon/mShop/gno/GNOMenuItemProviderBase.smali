.class public Lcom/amazon/mShop/gno/GNOMenuItemProviderBase;
.super Lcom/amazon/mShop/gno/GNOMenuItemProvider;
.source "GNOMenuItemProviderBase.java"


# instance fields
.field private mItemMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/mShop/gno/GNODrawerItem;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 11
    invoke-direct {p0}, Lcom/amazon/mShop/gno/GNOMenuItemProvider;-><init>()V

    .line 12
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0}, Ljava/util/LinkedHashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderBase;->mItemMap:Ljava/util/Map;

    .line 13
    return-void
.end method


# virtual methods
.method public addItem(Lcom/amazon/mShop/gno/GNODrawerItem;)V
    .locals 2
    .param p1, "item"    # Lcom/amazon/mShop/gno/GNODrawerItem;

    .prologue
    .line 16
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderBase;->mItemMap:Ljava/util/Map;

    invoke-interface {p1}, Lcom/amazon/mShop/gno/GNODrawerItem;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 17
    return-void
.end method

.method public getItem(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItem;
    .locals 1
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 25
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderBase;->mItemMap:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItem;

    return-object v0
.end method

.method public getItems()Ljava/util/Collection;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Collection",
            "<",
            "Lcom/amazon/mShop/gno/GNODrawerItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderBase;->mItemMap:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v0

    return-object v0
.end method

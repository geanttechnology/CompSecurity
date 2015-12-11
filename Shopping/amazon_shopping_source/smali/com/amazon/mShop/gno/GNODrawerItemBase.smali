.class public abstract Lcom/amazon/mShop/gno/GNODrawerItemBase;
.super Ljava/lang/Object;
.source "GNODrawerItemBase.java"

# interfaces
.implements Lcom/amazon/mShop/gno/GNODrawerItem;


# instance fields
.field private mChildren:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/gno/GNODrawerItem;",
            ">;"
        }
    .end annotation
.end field

.field private mParent:Lcom/amazon/mShop/gno/GNODrawerItem;

.field private mRefMarker:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public allowDividers()Z
    .locals 1

    .prologue
    .line 106
    const/4 v0, 0x1

    return v0
.end method

.method public bridge synthetic getChildren()Ljava/util/Collection;
    .locals 1

    .prologue
    .line 19
    invoke-virtual {p0}, Lcom/amazon/mShop/gno/GNODrawerItemBase;->getChildren()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getChildren()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/gno/GNODrawerItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 74
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemBase;->mChildren:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemBase;->mChildren:Ljava/util/List;

    :goto_0
    return-object v0

    :cond_0
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    goto :goto_0
.end method

.method public getParent()Lcom/amazon/mShop/gno/GNODrawerItem;
    .locals 1

    .prologue
    .line 79
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemBase;->mParent:Lcom/amazon/mShop/gno/GNODrawerItem;

    return-object v0
.end method

.method public onClick(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/gno/GNODrawer;)V
    .locals 1
    .param p1, "callingActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p2, "drawer"    # Lcom/amazon/mShop/gno/GNODrawer;

    .prologue
    .line 46
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemBase;->mRefMarker:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 47
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemBase;->mRefMarker:Ljava/lang/String;

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 49
    :cond_0
    return-void
.end method

.method public setChildren(Ljava/util/Collection;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/amazon/mShop/gno/GNODrawerItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 59
    .local p1, "children":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/amazon/mShop/gno/GNODrawerItem;>;"
    instance-of v2, p1, Ljava/util/List;

    if-eqz v2, :cond_1

    .line 60
    check-cast p1, Ljava/util/List;

    .end local p1    # "children":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/amazon/mShop/gno/GNODrawerItem;>;"
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNODrawerItemBase;->mChildren:Ljava/util/List;

    .line 65
    :goto_0
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNODrawerItemBase;->mChildren:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItem;

    .line 66
    .local v0, "child":Lcom/amazon/mShop/gno/GNODrawerItem;
    instance-of v2, v0, Lcom/amazon/mShop/gno/GNODrawerItemBase;

    if-eqz v2, :cond_0

    .line 67
    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemBase;

    .end local v0    # "child":Lcom/amazon/mShop/gno/GNODrawerItem;
    iput-object p0, v0, Lcom/amazon/mShop/gno/GNODrawerItemBase;->mParent:Lcom/amazon/mShop/gno/GNODrawerItem;

    goto :goto_1

    .line 62
    .end local v1    # "i$":Ljava/util/Iterator;
    .restart local p1    # "children":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/amazon/mShop/gno/GNODrawerItem;>;"
    :cond_1
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2, p1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v2, p0, Lcom/amazon/mShop/gno/GNODrawerItemBase;->mChildren:Ljava/util/List;

    goto :goto_0

    .line 70
    .end local p1    # "children":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/amazon/mShop/gno/GNODrawerItem;>;"
    .restart local v1    # "i$":Ljava/util/Iterator;
    :cond_2
    return-void
.end method

.method public setRefMarker(Ljava/lang/String;)V
    .locals 0
    .param p1, "refMarker"    # Ljava/lang/String;

    .prologue
    .line 31
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNODrawerItemBase;->mRefMarker:Ljava/lang/String;

    .line 32
    return-void
.end method

.class public interface abstract Lcom/amazon/mShop/gno/GNODrawerItem;
.super Ljava/lang/Object;
.source "GNODrawerItem.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/gno/GNODrawerItem$Type;
    }
.end annotation


# virtual methods
.method public abstract allowDividers()Z
.end method

.method public abstract getChildren()Ljava/util/Collection;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Collection",
            "<",
            "Lcom/amazon/mShop/gno/GNODrawerItem;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getId()Ljava/lang/String;
.end method

.method public abstract getParent()Lcom/amazon/mShop/gno/GNODrawerItem;
.end method

.method public abstract getType()Lcom/amazon/mShop/gno/GNODrawerItem$Type;
.end method

.method public abstract getView(Landroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end method

.method public abstract onClick(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/gno/GNODrawer;)V
.end method

.method public abstract setChildren(Ljava/util/Collection;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/amazon/mShop/gno/GNODrawerItem;",
            ">;)V"
        }
    .end annotation
.end method

.class public Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;
.super Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;
.source "GNODrawerItemAppstoreHeader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder",
        "<TT;>;>",
        "Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder",
        "<TT;>;"
    }
.end annotation


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "id"    # Ljava/lang/String;

    .prologue
    .line 56
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder<TT;>;"
    new-instance v0, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader;

    invoke-direct {v0, p1, p2}, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    invoke-direct {p0, v0}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;-><init>(Lcom/amazon/mShop/gno/GNODrawerItemGroup;)V

    .line 57
    sget-object v0, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->APPSTORE_HEADER:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-super {p0, v0}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    .line 58
    return-void
.end method


# virtual methods
.method public build()Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader;
    .locals 1

    .prologue
    .line 62
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder<TT;>;"
    invoke-super {p0}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemGroup;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader;

    .line 63
    .local v0, "item":Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader;
    return-object v0
.end method

.method public bridge synthetic build()Lcom/amazon/mShop/gno/GNODrawerItemGroup;
    .locals 1

    .prologue
    .line 53
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder<TT;>;"
    invoke-virtual {p0}, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic build()Lcom/amazon/mShop/gno/GNODrawerItemHideable;
    .locals 1

    .prologue
    .line 53
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder<TT;>;"
    invoke-virtual {p0}, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;
    .locals 1

    .prologue
    .line 53
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder<TT;>;"
    invoke-virtual {p0}, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader;

    move-result-object v0

    return-object v0
.end method

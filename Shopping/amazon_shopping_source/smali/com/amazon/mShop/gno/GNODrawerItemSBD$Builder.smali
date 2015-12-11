.class public Lcom/amazon/mShop/gno/GNODrawerItemSBD$Builder;
.super Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;
.source "GNODrawerItemSBD.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/gno/GNODrawerItemSBD;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Lcom/amazon/mShop/gno/GNODrawerItemSBD$Builder",
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
    .line 52
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemSBD$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemSBD$Builder<TT;>;"
    new-instance v0, Lcom/amazon/mShop/gno/GNODrawerItemSBD;

    invoke-direct {v0, p1, p2}, Lcom/amazon/mShop/gno/GNODrawerItemSBD;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    invoke-direct {p0, v0}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;-><init>(Lcom/amazon/mShop/gno/GNODrawerItemGroup;)V

    .line 53
    return-void
.end method


# virtual methods
.method public bridge synthetic build()Lcom/amazon/mShop/gno/GNODrawerItemGroup;
    .locals 1

    .prologue
    .line 49
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemSBD$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemSBD$Builder<TT;>;"
    invoke-virtual {p0}, Lcom/amazon/mShop/gno/GNODrawerItemSBD$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSBD;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic build()Lcom/amazon/mShop/gno/GNODrawerItemHideable;
    .locals 1

    .prologue
    .line 49
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemSBD$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemSBD$Builder<TT;>;"
    invoke-virtual {p0}, Lcom/amazon/mShop/gno/GNODrawerItemSBD$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSBD;

    move-result-object v0

    return-object v0
.end method

.method public build()Lcom/amazon/mShop/gno/GNODrawerItemSBD;
    .locals 1

    .prologue
    .line 57
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemSBD$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemSBD$Builder<TT;>;"
    invoke-super {p0}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemGroup;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemSBD;

    .line 58
    .local v0, "item":Lcom/amazon/mShop/gno/GNODrawerItemSBD;
    return-object v0
.end method

.method public bridge synthetic build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;
    .locals 1

    .prologue
    .line 49
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemSBD$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemSBD$Builder<TT;>;"
    invoke-virtual {p0}, Lcom/amazon/mShop/gno/GNODrawerItemSBD$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSBD;

    move-result-object v0

    return-object v0
.end method

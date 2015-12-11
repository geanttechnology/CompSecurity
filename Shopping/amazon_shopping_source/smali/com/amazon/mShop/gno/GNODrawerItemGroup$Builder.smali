.class public Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;
.super Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;
.source "GNODrawerItemGroup.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/gno/GNODrawerItemGroup;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder",
        "<TT;>;>",
        "Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder",
        "<TT;>;"
    }
.end annotation


# instance fields
.field protected children:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/gno/GNODrawerItem;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "id"    # Ljava/lang/String;

    .prologue
    .line 114
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder<TT;>;"
    new-instance v0, Lcom/amazon/mShop/gno/GNODrawerItemGroup;

    invoke-direct {v0, p1, p2}, Lcom/amazon/mShop/gno/GNODrawerItemGroup;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    invoke-direct {p0, v0}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;-><init>(Lcom/amazon/mShop/gno/GNODrawerItemHideable;)V

    .line 116
    sget v0, Lcom/amazon/mShop/android/lib/R$layout;->gno_drawer_item_group_icon:I

    invoke-super {p0, v0}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->withSubView(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    .line 118
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->children:Ljava/util/List;

    .line 119
    return-void
.end method

.method public constructor <init>(Lcom/amazon/mShop/gno/GNODrawerItemGroup;)V
    .locals 1
    .param p1, "item"    # Lcom/amazon/mShop/gno/GNODrawerItemGroup;

    .prologue
    .line 122
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder<TT;>;"
    invoke-direct {p0, p1}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;-><init>(Lcom/amazon/mShop/gno/GNODrawerItemHideable;)V

    .line 123
    sget v0, Lcom/amazon/mShop/android/lib/R$layout;->gno_drawer_item_group_icon:I

    invoke-super {p0, v0}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->withSubView(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    .line 124
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->children:Ljava/util/List;

    .line 125
    return-void
.end method


# virtual methods
.method public build()Lcom/amazon/mShop/gno/GNODrawerItemGroup;
    .locals 2

    .prologue
    .line 129
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder<TT;>;"
    invoke-super {p0}, Lcom/amazon/mShop/gno/GNODrawerItemHideable$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemHideable;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemGroup;

    .line 131
    .local v0, "item":Lcom/amazon/mShop/gno/GNODrawerItemGroup;
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->children:Ljava/util/List;

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 132
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->children:Ljava/util/List;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemGroup;->setChildren(Ljava/util/Collection;)V

    .line 135
    :cond_0
    return-object v0
.end method

.method public bridge synthetic build()Lcom/amazon/mShop/gno/GNODrawerItemHideable;
    .locals 1

    .prologue
    .line 110
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder<TT;>;"
    invoke-virtual {p0}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemGroup;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;
    .locals 1

    .prologue
    .line 110
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder<TT;>;"
    invoke-virtual {p0}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemGroup;

    move-result-object v0

    return-object v0
.end method

.method public withChild(Lcom/amazon/mShop/gno/GNODrawerItem;)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;
    .locals 1
    .param p1, "child"    # Lcom/amazon/mShop/gno/GNODrawerItem;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/mShop/gno/GNODrawerItem;",
            ")TT;"
        }
    .end annotation

    .prologue
    .line 139
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->children:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 140
    invoke-virtual {p0}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->self()Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    return-object v0
.end method

.method public withSubView(I)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;
    .locals 1
    .param p1, "id"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)TT;"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 150
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder<TT;>;"
    invoke-virtual {p0}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->self()Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    return-object v0
.end method

.method public bridge synthetic withSubView(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 110
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder<TT;>;"
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;->withSubView(I)Lcom/amazon/mShop/gno/GNODrawerItemGroup$Builder;

    move-result-object v0

    return-object v0
.end method

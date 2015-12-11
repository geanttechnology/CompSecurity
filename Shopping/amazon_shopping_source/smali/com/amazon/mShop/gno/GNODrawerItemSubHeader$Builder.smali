.class public Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;
.super Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;
.source "GNODrawerItemSubHeader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/gno/GNODrawerItemSubHeader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder",
        "<TT;>;>",
        "Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder",
        "<TT;>;"
    }
.end annotation


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "id"    # Ljava/lang/String;

    .prologue
    .line 46
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder<TT;>;"
    new-instance v0, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader;

    invoke-direct {v0, p1, p2}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    invoke-direct {p0, v0}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;-><init>(Lcom/amazon/mShop/gno/GNODrawerItemSimple;)V

    .line 48
    sget-object v0, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_HEADER:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-super {p0, v0}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    .line 49
    return-void
.end method

.method public constructor <init>(Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable;)V
    .locals 1
    .param p1, "item"    # Lcom/amazon/mShop/gno/GNODrawerItemSubHeaderHideable;

    .prologue
    .line 53
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder<TT;>;"
    invoke-direct {p0, p1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;-><init>(Lcom/amazon/mShop/gno/GNODrawerItemSimple;)V

    .line 55
    sget-object v0, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_HEADER:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-super {p0, v0}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    .line 56
    return-void
.end method


# virtual methods
.method public build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;
    .locals 1

    .prologue
    .line 60
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder<TT;>;"
    invoke-super {p0}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic withSubView(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 44
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder<TT;>;"
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;->withSubView(I)Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;

    move-result-object v0

    return-object v0
.end method

.method public withSubView(I)Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;
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
    .line 67
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder<TT;>;"
    invoke-virtual {p0}, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;->self()Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemSubHeader$Builder;

    return-object v0
.end method

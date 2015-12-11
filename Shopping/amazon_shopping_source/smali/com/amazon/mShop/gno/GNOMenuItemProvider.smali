.class public abstract Lcom/amazon/mShop/gno/GNOMenuItemProvider;
.super Ljava/lang/Object;
.source "GNOMenuItemProvider.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public abstract getItem(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItem;
.end method

.method public abstract getItems()Ljava/util/Collection;
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

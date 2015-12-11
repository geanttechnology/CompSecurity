.class final Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin$1;
.super Ljava/util/ArrayList;
.source "MASHMShopCardScannerPlugin.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/util/ArrayList",
        "<",
        "Ljava/lang/Integer;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    .line 43
    invoke-direct {p0}, Ljava/util/ArrayList;-><init>()V

    .line 44
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin$1;->add(Ljava/lang/Object;)Z

    .line 45
    const/4 v0, 0x2

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin$1;->add(Ljava/lang/Object;)Z

    .line 46
    const/4 v0, 0x3

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin$1;->add(Ljava/lang/Object;)Z

    .line 47
    const/4 v0, 0x4

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin$1;->add(Ljava/lang/Object;)Z

    .line 48
    return-void
.end method

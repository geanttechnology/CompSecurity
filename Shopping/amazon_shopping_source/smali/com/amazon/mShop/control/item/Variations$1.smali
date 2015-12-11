.class Lcom/amazon/mShop/control/item/Variations$1;
.super Ljava/lang/Object;
.source "Variations.java"

# interfaces
.implements Lcom/amazon/mShop/control/item/Variations$AttributeFetcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/control/item/Variations;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/mShop/control/item/Variations$AttributeFetcher",
        "<[B>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/item/Variations;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/item/Variations;)V
    .locals 0

    .prologue
    .line 474
    iput-object p1, p0, Lcom/amazon/mShop/control/item/Variations$1;->this$0:Lcom/amazon/mShop/control/item/Variations;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAttributes(I)Ljava/util/List;
    .locals 1
    .param p1, "dimensionIndex"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Ljava/util/List",
            "<[B>;"
        }
    .end annotation

    .prologue
    .line 477
    iget-object v0, p0, Lcom/amazon/mShop/control/item/Variations$1;->this$0:Lcom/amazon/mShop/control/item/Variations;

    # getter for: Lcom/amazon/mShop/control/item/Variations;->dimensions:[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;
    invoke-static {v0}, Lcom/amazon/mShop/control/item/Variations;->access$100(Lcom/amazon/mShop/control/item/Variations;)[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;

    move-result-object v0

    aget-object v0, v0, p1

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/Dimension;->getSwatches()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

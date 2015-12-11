.class Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;
.super Ljava/lang/Object;
.source "HomeShovelerItemsAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "HomeShovelerItem"
.end annotation


# instance fields
.field private mHomeItem:Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;

.field private mRetryCounts:I

.field final synthetic this$0:Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;I)V
    .locals 1
    .param p2, "item"    # Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;
    .param p3, "value"    # I

    .prologue
    .line 506
    iput-object p1, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;->this$0:Lcom/amazon/mShop/home/HomeShovelerItemsAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 504
    const/4 v0, 0x0

    iput v0, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;->mRetryCounts:I

    .line 507
    iput-object p2, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;->mHomeItem:Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;

    .line 508
    iput p3, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;->mRetryCounts:I

    .line 509
    return-void
.end method


# virtual methods
.method public getHomeShoveler()Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;
    .locals 1

    .prologue
    .line 512
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;->mHomeItem:Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;

    return-object v0
.end method

.method public getRetryCounts()I
    .locals 1

    .prologue
    .line 516
    iget v0, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;->mRetryCounts:I

    return v0
.end method

.method public setRetryCounts(I)V
    .locals 0
    .param p1, "value"    # I

    .prologue
    .line 520
    iput p1, p0, Lcom/amazon/mShop/home/HomeShovelerItemsAdapter$HomeShovelerItem;->mRetryCounts:I

    .line 521
    return-void
.end method

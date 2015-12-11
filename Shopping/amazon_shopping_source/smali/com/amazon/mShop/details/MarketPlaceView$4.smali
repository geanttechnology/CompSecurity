.class Lcom/amazon/mShop/details/MarketPlaceView$4;
.super Lcom/amazon/mShop/details/ProductSubscriberBase;
.source "MarketPlaceView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/details/MarketPlaceView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/details/MarketPlaceView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/details/MarketPlaceView;)V
    .locals 0

    .prologue
    .line 283
    iput-object p1, p0, Lcom/amazon/mShop/details/MarketPlaceView$4;->this$0:Lcom/amazon/mShop/details/MarketPlaceView;

    invoke-direct {p0}, Lcom/amazon/mShop/details/ProductSubscriberBase;-><init>()V

    return-void
.end method


# virtual methods
.method public onProductUpdated()V
    .locals 1

    .prologue
    .line 287
    iget-object v0, p0, Lcom/amazon/mShop/details/MarketPlaceView$4;->this$0:Lcom/amazon/mShop/details/MarketPlaceView;

    invoke-virtual {v0}, Lcom/amazon/mShop/details/MarketPlaceView;->update()V

    .line 288
    return-void
.end method

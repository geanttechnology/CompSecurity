.class Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$4;
.super Ljava/lang/Object;
.source "BarcodeSearchController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->receivedMatchedItemThumbnail([BLcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

.field final synthetic val$value:[B


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;[B)V
    .locals 0

    .prologue
    .line 159
    iput-object p1, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$4;->this$0:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    iput-object p2, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$4;->val$value:[B

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 162
    iget-object v0, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$4;->this$0:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    iget-object v1, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$4;->val$value:[B

    # setter for: Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->mMatchedItemThumbnail:[B
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->access$502(Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;[B)[B

    .line 163
    iget-object v0, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$4;->this$0:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    # getter for: Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->mSubscriber:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchSubscriber;
    invoke-static {v0}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->access$300(Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;)Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchSubscriber;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$4;->val$value:[B

    invoke-interface {v0, v1}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchSubscriber;->onMatchedItemThumbnailReceived([B)V

    .line 164
    return-void
.end method

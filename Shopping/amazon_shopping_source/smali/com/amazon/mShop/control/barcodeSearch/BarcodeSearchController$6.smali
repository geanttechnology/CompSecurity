.class Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$6;
.super Ljava/lang/Object;
.source "BarcodeSearchController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->receivedQueryDescriptor(Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

.field final synthetic val$value:Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;)V
    .locals 0

    .prologue
    .line 189
    iput-object p1, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$6;->this$0:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    iput-object p2, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$6;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 192
    iget-object v0, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$6;->this$0:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    iget-object v1, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$6;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;

    # setter for: Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->mQueryDescriptor:Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->access$702(Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;)Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;

    .line 193
    iget-object v0, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$6;->this$0:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    # getter for: Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->mSubscriber:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchSubscriber;
    invoke-static {v0}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->access$300(Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;)Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchSubscriber;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$6;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;

    invoke-interface {v0, v1}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchSubscriber;->onQueryDescriptorReceived(Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;)V

    .line 194
    return-void
.end method

.class Lcom/amazon/mShop/barcodeSearch/BarcodeFirstTryTipActivity$1;
.super Ljava/lang/Object;
.source "BarcodeFirstTryTipActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/barcodeSearch/BarcodeFirstTryTipActivity;->onStart()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/barcodeSearch/BarcodeFirstTryTipActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/barcodeSearch/BarcodeFirstTryTipActivity;)V
    .locals 0

    .prologue
    .line 45
    iput-object p1, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeFirstTryTipActivity$1;->this$0:Lcom/amazon/mShop/barcodeSearch/BarcodeFirstTryTipActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 50
    const-string/jumbo v0, "scan_try_it_btn"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 52
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    const-string/jumbo v1, "keyBarcodeSearchTryAccepted"

    const/4 v2, 0x1

    invoke-interface {v0, v1, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putBoolean(Ljava/lang/String;Z)V

    .line 53
    iget-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeFirstTryTipActivity$1;->this$0:Lcom/amazon/mShop/barcodeSearch/BarcodeFirstTryTipActivity;

    const/16 v1, 0x5a

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/barcodeSearch/BarcodeFirstTryTipActivity;->setResult(I)V

    .line 54
    iget-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeFirstTryTipActivity$1;->this$0:Lcom/amazon/mShop/barcodeSearch/BarcodeFirstTryTipActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/barcodeSearch/BarcodeFirstTryTipActivity;->finish()V

    .line 55
    return-void
.end method

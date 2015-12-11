.class Lcom/amazon/mShop/search/viewit/ViewItActivity$4;
.super Ljava/lang/Object;
.source "ViewItActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItActivity;->didReceiveBarcodeDecodeSuccess(Lcom/flow/android/engine/library/objectinfo/FlowBarcodeObjectInfo;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

.field final synthetic val$barcode:Ljava/lang/String;

.field final synthetic val$barcodeFormat:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItActivity;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 653
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$4;->this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    iput-object p2, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$4;->val$barcode:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$4;->val$barcodeFormat:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    const/4 v3, -0x1

    .line 656
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 657
    .local v0, "intent":Landroid/content/Intent;
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$4;->val$barcode:Ljava/lang/String;

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 658
    const-string/jumbo v1, "BARCODE_STRING"

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$4;->val$barcode:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 659
    const-string/jumbo v1, "BARCODE_FORMAT"

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$4;->val$barcodeFormat:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 660
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$4;->this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-virtual {v1, v3, v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->setResult(ILandroid/content/Intent;)V

    .line 664
    :goto_0
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$4;->this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->finish()V

    .line 665
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$4;->this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    const-wide/16 v2, 0x64

    invoke-static {v1, v2, v3}, Lcom/amazon/mShop/util/UIUtils;->vibrate(Landroid/content/Context;J)V

    .line 666
    return-void

    .line 662
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$4;->this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-virtual {v1, v3, v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->setResult(ILandroid/content/Intent;)V

    goto :goto_0
.end method

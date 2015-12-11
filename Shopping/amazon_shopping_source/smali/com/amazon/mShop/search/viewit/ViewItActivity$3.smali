.class Lcom/amazon/mShop/search/viewit/ViewItActivity$3;
.super Ljava/lang/Object;
.source "ViewItActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItActivity;->showPublicDataMatrixCodeInfoDialog()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItActivity;)V
    .locals 0

    .prologue
    .line 588
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 591
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItActivity;->mPhotoCaptureView:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->access$000(Lcom/amazon/mShop/search/viewit/ViewItActivity;)Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->getViewItDialogHelper()Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;

    move-result-object v0

    sget-object v1, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;->PUBLIC_DATA_MATRIX_INFO:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    invoke-virtual {v0, v2, v2, v1}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->showDialog(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;)V

    .line 592
    return-void
.end method

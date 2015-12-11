.class Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter$1;
.super Ljava/lang/Object;
.source "BarcodeSearchResultsAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;)V
    .locals 0

    .prologue
    .line 110
    iput-object p1, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter$1;->this$0:Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 113
    iget-object v2, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter$1;->this$0:Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;

    # getter for: Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->mBarcodeSearchController:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;
    invoke-static {v2}, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->access$000(Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;)Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->reportMismatch()V

    .line 114
    new-instance v2, Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    iget-object v3, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter$1;->this$0:Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;

    # getter for: Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->mActivity:Landroid/app/Activity;
    invoke-static {v3}, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->access$100(Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;)Landroid/app/Activity;

    move-result-object v3

    invoke-direct {v2, v3}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;-><init>(Landroid/content/Context;)V

    iget-object v3, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter$1;->this$0:Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;

    # getter for: Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->mActivity:Landroid/app/Activity;
    invoke-static {v3}, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->access$100(Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;)Landroid/app/Activity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->bc_search_bad_match_acknowledgement:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    move-result-object v0

    .line 116
    .local v0, "builder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    new-instance v1, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter$1$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter$1$1;-><init>(Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter$1;)V

    .line 122
    .local v1, "onClickListener":Landroid/content/DialogInterface$OnClickListener;
    sget v2, Lcom/amazon/mShop/android/lib/R$string;->alert_ok_button:I

    invoke-virtual {v0, v2, v1}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 123
    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->create()Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/AmazonAlertDialog;->show()V

    .line 124
    return-void
.end method

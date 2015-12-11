.class Lcom/amazon/mShop/details/ProductImagesView$1;
.super Ljava/lang/Object;
.source "ProductImagesView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/details/ProductImagesView;->onItemSelected(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/details/ProductImagesView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/details/ProductImagesView;)V
    .locals 0

    .prologue
    .line 183
    iput-object p1, p0, Lcom/amazon/mShop/details/ProductImagesView$1;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 186
    iget-object v1, p0, Lcom/amazon/mShop/details/ProductImagesView$1;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView$1;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mMainGallery:Landroid/widget/Gallery;
    invoke-static {v0}, Lcom/amazon/mShop/details/ProductImagesView;->access$100(Lcom/amazon/mShop/details/ProductImagesView;)Landroid/widget/Gallery;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Gallery;->getSelectedItemPosition()I

    move-result v2

    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView$1;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mMainGallery:Landroid/widget/Gallery;
    invoke-static {v0}, Lcom/amazon/mShop/details/ProductImagesView;->access$100(Lcom/amazon/mShop/details/ProductImagesView;)Landroid/widget/Gallery;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/details/CustomizedGallery;

    invoke-virtual {v0}, Lcom/amazon/mShop/details/CustomizedGallery;->getAction()Lcom/amazon/mShop/details/ProductImagesView$MoveAction;

    move-result-object v0

    invoke-virtual {v1, v2, v0}, Lcom/amazon/mShop/details/ProductImagesView;->setSelectedState(ILcom/amazon/mShop/details/ProductImagesView$MoveAction;)V

    .line 187
    return-void
.end method

.class Lcom/amazon/mShop/cvsd/CVSDMapActivity$8;
.super Ljava/lang/Object;
.source "CVSDMapActivity.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/cvsd/CVSDMapActivity;->createSearchOptionDialog()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

.field final synthetic val$dialog:Lcom/amazon/mShop/AmazonAlertDialog;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/cvsd/CVSDMapActivity;Lcom/amazon/mShop/AmazonAlertDialog;)V
    .locals 0

    .prologue
    .line 547
    iput-object p1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$8;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    iput-object p2, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$8;->val$dialog:Lcom/amazon/mShop/AmazonAlertDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 1
    .param p2, "itemView"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "viewId"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 551
    .local p1, "parentView":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    if-nez p3, :cond_1

    .line 553
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$8;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    # invokes: Lcom/amazon/mShop/cvsd/CVSDMapActivity;->searchByAddress()V
    invoke-static {v0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->access$800(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)V

    .line 564
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$8;->val$dialog:Lcom/amazon/mShop/AmazonAlertDialog;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog;->dismiss()V

    .line 565
    return-void

    .line 554
    :cond_1
    const/4 v0, 0x1

    if-ne p3, v0, :cond_2

    .line 556
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$8;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    # invokes: Lcom/amazon/mShop/cvsd/CVSDMapActivity;->searchByZipCode()V
    invoke-static {v0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->access$900(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)V

    goto :goto_0

    .line 557
    :cond_2
    const/4 v0, 0x2

    if-ne p3, v0, :cond_3

    .line 559
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$8;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    # invokes: Lcom/amazon/mShop/cvsd/CVSDMapActivity;->searchByLandmark()V
    invoke-static {v0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->access$1000(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)V

    goto :goto_0

    .line 560
    :cond_3
    const/4 v0, 0x3

    if-ne p3, v0, :cond_0

    .line 562
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$8;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    # invokes: Lcom/amazon/mShop/cvsd/CVSDMapActivity;->searchByCurrentLocation()V
    invoke-static {v0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->access$1100(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)V

    goto :goto_0
.end method

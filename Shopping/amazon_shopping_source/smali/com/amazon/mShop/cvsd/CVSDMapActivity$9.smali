.class Lcom/amazon/mShop/cvsd/CVSDMapActivity$9;
.super Ljava/lang/Object;
.source "CVSDMapActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/cvsd/CVSDMapActivity;->searchByAddress()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

.field final synthetic val$market:Ljava/lang/String;

.field final synthetic val$statesSpinner:Landroid/widget/Spinner;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/cvsd/CVSDMapActivity;Ljava/lang/String;Landroid/widget/Spinner;)V
    .locals 0

    .prologue
    .line 608
    iput-object p1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$9;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    iput-object p2, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$9;->val$market:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$9;->val$statesSpinner:Landroid/widget/Spinner;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 4
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 613
    iget-object v1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$9;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    # invokes: Lcom/amazon/mShop/cvsd/CVSDMapActivity;->clearMap()V
    invoke-static {v1}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->access$1200(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)V

    .line 617
    const/4 v0, 0x0

    .line 618
    .local v0, "state":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$9;->val$market:Ljava/lang/String;

    const-string/jumbo v2, "JP"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 619
    iget-object v1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$9;->val$statesSpinner:Landroid/widget/Spinner;

    invoke-virtual {v1}, Landroid/widget/Spinner;->getSelectedItem()Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 623
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$9;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    # getter for: Lcom/amazon/mShop/cvsd/CVSDMapActivity;->address:Landroid/widget/EditText;
    invoke-static {v1}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->access$1300(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)Landroid/widget/EditText;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/util/UIUtils;->closeSoftKeyboard(Landroid/view/View;)V

    .line 625
    iget-object v1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$9;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    # getter for: Lcom/amazon/mShop/cvsd/CVSDMapActivity;->cvsdController:Lcom/amazon/mShop/control/cvsd/CVSDController;
    invoke-static {v1}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->access$1400(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)Lcom/amazon/mShop/control/cvsd/CVSDController;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$9;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    # getter for: Lcom/amazon/mShop/cvsd/CVSDMapActivity;->address:Landroid/widget/EditText;
    invoke-static {v2}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->access$1300(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)Landroid/widget/EditText;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v1, v0, v2, v3}, Lcom/amazon/mShop/control/cvsd/CVSDController;->searchDeliveryLocationByAddress(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mShop/control/TaskCallback;)V

    .line 626
    return-void
.end method

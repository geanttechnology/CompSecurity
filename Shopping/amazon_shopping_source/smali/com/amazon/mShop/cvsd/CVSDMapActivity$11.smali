.class Lcom/amazon/mShop/cvsd/CVSDMapActivity$11;
.super Ljava/lang/Object;
.source "CVSDMapActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/cvsd/CVSDMapActivity;->searchByZipCode()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

.field final synthetic val$market:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/cvsd/CVSDMapActivity;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 683
    iput-object p1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$11;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    iput-object p2, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$11;->val$market:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 5
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 688
    iget-object v3, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$11;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    # invokes: Lcom/amazon/mShop/cvsd/CVSDMapActivity;->clearMap()V
    invoke-static {v3}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->access$1200(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)V

    .line 693
    const/4 v2, 0x0

    .line 694
    .local v2, "zipCode":Ljava/lang/String;
    iget-object v3, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$11;->val$market:Ljava/lang/String;

    const-string/jumbo v4, "JP"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 695
    iget-object v3, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$11;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    # getter for: Lcom/amazon/mShop/cvsd/CVSDMapActivity;->zip1:Landroid/widget/EditText;
    invoke-static {v3}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->access$1500(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)Landroid/widget/EditText;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 696
    .local v0, "zip1String":Ljava/lang/String;
    iget-object v3, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$11;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    # getter for: Lcom/amazon/mShop/cvsd/CVSDMapActivity;->zip2:Landroid/widget/EditText;
    invoke-static {v3}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->access$1600(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)Landroid/widget/EditText;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    .line 697
    .local v1, "zip2String":Ljava/lang/String;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "-"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 703
    .end local v0    # "zip1String":Ljava/lang/String;
    .end local v1    # "zip2String":Ljava/lang/String;
    :cond_0
    :goto_0
    iget-object v3, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$11;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    # getter for: Lcom/amazon/mShop/cvsd/CVSDMapActivity;->zip1:Landroid/widget/EditText;
    invoke-static {v3}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->access$1500(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)Landroid/widget/EditText;

    move-result-object v3

    if-nez v3, :cond_1

    iget-object v3, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$11;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    # getter for: Lcom/amazon/mShop/cvsd/CVSDMapActivity;->zip:Landroid/widget/EditText;
    invoke-static {v3}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->access$1700(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)Landroid/widget/EditText;

    move-result-object v3

    if-eqz v3, :cond_2

    .line 704
    :cond_1
    iget-object v3, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$11;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    # getter for: Lcom/amazon/mShop/cvsd/CVSDMapActivity;->zip1:Landroid/widget/EditText;
    invoke-static {v3}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->access$1500(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)Landroid/widget/EditText;

    move-result-object v3

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$11;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    # getter for: Lcom/amazon/mShop/cvsd/CVSDMapActivity;->zip1:Landroid/widget/EditText;
    invoke-static {v3}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->access$1500(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)Landroid/widget/EditText;

    move-result-object v3

    :goto_1
    invoke-static {v3}, Lcom/amazon/mShop/util/UIUtils;->closeSoftKeyboard(Landroid/view/View;)V

    .line 707
    :cond_2
    iget-object v3, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$11;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    # getter for: Lcom/amazon/mShop/cvsd/CVSDMapActivity;->cvsdController:Lcom/amazon/mShop/control/cvsd/CVSDController;
    invoke-static {v3}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->access$1400(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)Lcom/amazon/mShop/control/cvsd/CVSDController;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v3, v2, v4}, Lcom/amazon/mShop/control/cvsd/CVSDController;->searchDeliveryLocationByZipcode(Ljava/lang/String;Lcom/amazon/mShop/control/TaskCallback;)V

    .line 708
    return-void

    .line 698
    :cond_3
    iget-object v3, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$11;->val$market:Ljava/lang/String;

    const-string/jumbo v4, "FR"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 699
    iget-object v3, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$11;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    # getter for: Lcom/amazon/mShop/cvsd/CVSDMapActivity;->zip:Landroid/widget/EditText;
    invoke-static {v3}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->access$1700(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)Landroid/widget/EditText;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 704
    :cond_4
    iget-object v3, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$11;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    # getter for: Lcom/amazon/mShop/cvsd/CVSDMapActivity;->zip:Landroid/widget/EditText;
    invoke-static {v3}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->access$1700(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)Landroid/widget/EditText;

    move-result-object v3

    goto :goto_1
.end method

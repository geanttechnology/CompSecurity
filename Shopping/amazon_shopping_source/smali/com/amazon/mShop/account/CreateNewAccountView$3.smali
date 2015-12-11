.class Lcom/amazon/mShop/account/CreateNewAccountView$3;
.super Ljava/lang/Object;
.source "CreateNewAccountView.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/account/CreateNewAccountView;->onNewAccountCreation(ZLcom/amazon/rio/j2me/client/services/mShop/Notification;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/account/CreateNewAccountView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/account/CreateNewAccountView;)V
    .locals 0

    .prologue
    .line 229
    iput-object p1, p0, Lcom/amazon/mShop/account/CreateNewAccountView$3;->this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 7
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    const/4 v5, 0x1

    .line 232
    const/4 v0, -0x2

    if-ne p2, v0, :cond_1

    .line 233
    iget-object v0, p0, Lcom/amazon/mShop/account/CreateNewAccountView$3;->this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

    # getter for: Lcom/amazon/mShop/account/CreateNewAccountView;->email:Landroid/widget/EditText;
    invoke-static {v0}, Lcom/amazon/mShop/account/CreateNewAccountView;->access$500(Lcom/amazon/mShop/account/CreateNewAccountView;)Landroid/widget/EditText;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/EditText;->requestFocus()Z

    .line 245
    :cond_0
    :goto_0
    return-void

    .line 236
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/account/CreateNewAccountView$3;->this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

    # getter for: Lcom/amazon/mShop/account/CreateNewAccountView;->newAccountController:Lcom/amazon/mShop/control/account/NewAccountController;
    invoke-static {v0}, Lcom/amazon/mShop/account/CreateNewAccountView;->access$200(Lcom/amazon/mShop/account/CreateNewAccountView;)Lcom/amazon/mShop/control/account/NewAccountController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/control/account/NewAccountController;->hasServiceCallRunning()Z

    move-result v0

    if-nez v0, :cond_0

    .line 237
    iget-object v0, p0, Lcom/amazon/mShop/account/CreateNewAccountView$3;->this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

    # getter for: Lcom/amazon/mShop/account/CreateNewAccountView;->loginActivity:Lcom/amazon/mShop/account/LoginActivity;
    invoke-static {v0}, Lcom/amazon/mShop/account/CreateNewAccountView;->access$900(Lcom/amazon/mShop/account/CreateNewAccountView;)Lcom/amazon/mShop/account/LoginActivity;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->config_cna_requires_furigana:I

    invoke-static {v0, v1}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(Landroid/content/Context;I)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 238
    iget-object v0, p0, Lcom/amazon/mShop/account/CreateNewAccountView$3;->this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

    # getter for: Lcom/amazon/mShop/account/CreateNewAccountView;->newAccountController:Lcom/amazon/mShop/control/account/NewAccountController;
    invoke-static {v0}, Lcom/amazon/mShop/account/CreateNewAccountView;->access$200(Lcom/amazon/mShop/account/CreateNewAccountView;)Lcom/amazon/mShop/control/account/NewAccountController;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/account/CreateNewAccountView$3;->this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

    # getter for: Lcom/amazon/mShop/account/CreateNewAccountView;->fullName:Landroid/widget/EditText;
    invoke-static {v1}, Lcom/amazon/mShop/account/CreateNewAccountView;->access$300(Lcom/amazon/mShop/account/CreateNewAccountView;)Landroid/widget/EditText;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/account/CreateNewAccountView$3;->this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

    # getter for: Lcom/amazon/mShop/account/CreateNewAccountView;->furigana:Landroid/widget/EditText;
    invoke-static {v2}, Lcom/amazon/mShop/account/CreateNewAccountView;->access$400(Lcom/amazon/mShop/account/CreateNewAccountView;)Landroid/widget/EditText;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/mShop/account/CreateNewAccountView$3;->this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

    # getter for: Lcom/amazon/mShop/account/CreateNewAccountView;->email:Landroid/widget/EditText;
    invoke-static {v3}, Lcom/amazon/mShop/account/CreateNewAccountView;->access$500(Lcom/amazon/mShop/account/CreateNewAccountView;)Landroid/widget/EditText;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/mShop/account/CreateNewAccountView$3;->this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

    # getter for: Lcom/amazon/mShop/account/CreateNewAccountView;->password:Landroid/widget/EditText;
    invoke-static {v4}, Lcom/amazon/mShop/account/CreateNewAccountView;->access$600(Lcom/amazon/mShop/account/CreateNewAccountView;)Landroid/widget/EditText;

    move-result-object v4

    invoke-virtual {v4}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    iget-object v6, p0, Lcom/amazon/mShop/account/CreateNewAccountView$3;->this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

    # getter for: Lcom/amazon/mShop/account/CreateNewAccountView;->taskCallback:Lcom/amazon/mShop/control/TaskCallback;
    invoke-static {v6}, Lcom/amazon/mShop/account/CreateNewAccountView;->access$700(Lcom/amazon/mShop/account/CreateNewAccountView;)Lcom/amazon/mShop/control/TaskCallback;

    move-result-object v6

    invoke-virtual/range {v0 .. v6}, Lcom/amazon/mShop/control/account/NewAccountController;->createNewAccount(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/amazon/mShop/control/TaskCallback;)V

    goto :goto_0

    .line 240
    :cond_2
    iget-object v0, p0, Lcom/amazon/mShop/account/CreateNewAccountView$3;->this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

    # getter for: Lcom/amazon/mShop/account/CreateNewAccountView;->newAccountController:Lcom/amazon/mShop/control/account/NewAccountController;
    invoke-static {v0}, Lcom/amazon/mShop/account/CreateNewAccountView;->access$200(Lcom/amazon/mShop/account/CreateNewAccountView;)Lcom/amazon/mShop/control/account/NewAccountController;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/account/CreateNewAccountView$3;->this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

    # getter for: Lcom/amazon/mShop/account/CreateNewAccountView;->fullName:Landroid/widget/EditText;
    invoke-static {v1}, Lcom/amazon/mShop/account/CreateNewAccountView;->access$300(Lcom/amazon/mShop/account/CreateNewAccountView;)Landroid/widget/EditText;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/amazon/mShop/account/CreateNewAccountView$3;->this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

    # getter for: Lcom/amazon/mShop/account/CreateNewAccountView;->email:Landroid/widget/EditText;
    invoke-static {v3}, Lcom/amazon/mShop/account/CreateNewAccountView;->access$500(Lcom/amazon/mShop/account/CreateNewAccountView;)Landroid/widget/EditText;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/mShop/account/CreateNewAccountView$3;->this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

    # getter for: Lcom/amazon/mShop/account/CreateNewAccountView;->password:Landroid/widget/EditText;
    invoke-static {v4}, Lcom/amazon/mShop/account/CreateNewAccountView;->access$600(Lcom/amazon/mShop/account/CreateNewAccountView;)Landroid/widget/EditText;

    move-result-object v4

    invoke-virtual {v4}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    iget-object v6, p0, Lcom/amazon/mShop/account/CreateNewAccountView$3;->this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

    # getter for: Lcom/amazon/mShop/account/CreateNewAccountView;->taskCallback:Lcom/amazon/mShop/control/TaskCallback;
    invoke-static {v6}, Lcom/amazon/mShop/account/CreateNewAccountView;->access$700(Lcom/amazon/mShop/account/CreateNewAccountView;)Lcom/amazon/mShop/control/TaskCallback;

    move-result-object v6

    invoke-virtual/range {v0 .. v6}, Lcom/amazon/mShop/control/account/NewAccountController;->createNewAccount(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/amazon/mShop/control/TaskCallback;)V

    goto/16 :goto_0
.end method

.class Lcom/amazon/mShop/account/CreateNewAccountView$1;
.super Ljava/lang/Object;
.source "CreateNewAccountView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/account/CreateNewAccountView;-><init>(Lcom/amazon/mShop/account/LoginActivity;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

.field final synthetic val$loginActivity:Lcom/amazon/mShop/account/LoginActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/account/CreateNewAccountView;Lcom/amazon/mShop/account/LoginActivity;)V
    .locals 0

    .prologue
    .line 73
    iput-object p1, p0, Lcom/amazon/mShop/account/CreateNewAccountView$1;->this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

    iput-object p2, p0, Lcom/amazon/mShop/account/CreateNewAccountView$1;->val$loginActivity:Lcom/amazon/mShop/account/LoginActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 7
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/4 v5, 0x0

    .line 77
    iget-object v0, p0, Lcom/amazon/mShop/account/CreateNewAccountView$1;->this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

    # invokes: Lcom/amazon/mShop/account/CreateNewAccountView;->isValidEmail()Z
    invoke-static {v0}, Lcom/amazon/mShop/account/CreateNewAccountView;->access$000(Lcom/amazon/mShop/account/CreateNewAccountView;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/account/CreateNewAccountView$1;->this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

    # invokes: Lcom/amazon/mShop/account/CreateNewAccountView;->isValidPassword()Z
    invoke-static {v0}, Lcom/amazon/mShop/account/CreateNewAccountView;->access$100(Lcom/amazon/mShop/account/CreateNewAccountView;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 78
    iget-object v0, p0, Lcom/amazon/mShop/account/CreateNewAccountView$1;->this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

    # getter for: Lcom/amazon/mShop/account/CreateNewAccountView;->newAccountController:Lcom/amazon/mShop/control/account/NewAccountController;
    invoke-static {v0}, Lcom/amazon/mShop/account/CreateNewAccountView;->access$200(Lcom/amazon/mShop/account/CreateNewAccountView;)Lcom/amazon/mShop/control/account/NewAccountController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/control/account/NewAccountController;->hasServiceCallRunning()Z

    move-result v0

    if-nez v0, :cond_0

    .line 79
    iget-object v0, p0, Lcom/amazon/mShop/account/CreateNewAccountView$1;->val$loginActivity:Lcom/amazon/mShop/account/LoginActivity;

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->config_cna_requires_furigana:I

    invoke-static {v0, v1}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(Landroid/content/Context;I)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 80
    iget-object v0, p0, Lcom/amazon/mShop/account/CreateNewAccountView$1;->this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

    # getter for: Lcom/amazon/mShop/account/CreateNewAccountView;->newAccountController:Lcom/amazon/mShop/control/account/NewAccountController;
    invoke-static {v0}, Lcom/amazon/mShop/account/CreateNewAccountView;->access$200(Lcom/amazon/mShop/account/CreateNewAccountView;)Lcom/amazon/mShop/control/account/NewAccountController;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/account/CreateNewAccountView$1;->this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

    # getter for: Lcom/amazon/mShop/account/CreateNewAccountView;->fullName:Landroid/widget/EditText;
    invoke-static {v1}, Lcom/amazon/mShop/account/CreateNewAccountView;->access$300(Lcom/amazon/mShop/account/CreateNewAccountView;)Landroid/widget/EditText;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/account/CreateNewAccountView$1;->this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

    # getter for: Lcom/amazon/mShop/account/CreateNewAccountView;->furigana:Landroid/widget/EditText;
    invoke-static {v2}, Lcom/amazon/mShop/account/CreateNewAccountView;->access$400(Lcom/amazon/mShop/account/CreateNewAccountView;)Landroid/widget/EditText;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/mShop/account/CreateNewAccountView$1;->this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

    # getter for: Lcom/amazon/mShop/account/CreateNewAccountView;->email:Landroid/widget/EditText;
    invoke-static {v3}, Lcom/amazon/mShop/account/CreateNewAccountView;->access$500(Lcom/amazon/mShop/account/CreateNewAccountView;)Landroid/widget/EditText;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/mShop/account/CreateNewAccountView$1;->this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

    # getter for: Lcom/amazon/mShop/account/CreateNewAccountView;->password:Landroid/widget/EditText;
    invoke-static {v4}, Lcom/amazon/mShop/account/CreateNewAccountView;->access$600(Lcom/amazon/mShop/account/CreateNewAccountView;)Landroid/widget/EditText;

    move-result-object v4

    invoke-virtual {v4}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    iget-object v6, p0, Lcom/amazon/mShop/account/CreateNewAccountView$1;->this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

    # getter for: Lcom/amazon/mShop/account/CreateNewAccountView;->taskCallback:Lcom/amazon/mShop/control/TaskCallback;
    invoke-static {v6}, Lcom/amazon/mShop/account/CreateNewAccountView;->access$700(Lcom/amazon/mShop/account/CreateNewAccountView;)Lcom/amazon/mShop/control/TaskCallback;

    move-result-object v6

    invoke-virtual/range {v0 .. v6}, Lcom/amazon/mShop/control/account/NewAccountController;->createNewAccount(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/amazon/mShop/control/TaskCallback;)V

    .line 86
    :goto_0
    iget-object v0, p0, Lcom/amazon/mShop/account/CreateNewAccountView$1;->this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

    # getter for: Lcom/amazon/mShop/account/CreateNewAccountView;->mRefMarker:Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/account/CreateNewAccountView;->access$800(Lcom/amazon/mShop/account/CreateNewAccountView;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 87
    iget-object v0, p0, Lcom/amazon/mShop/account/CreateNewAccountView$1;->this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

    # getter for: Lcom/amazon/mShop/account/CreateNewAccountView;->mRefMarker:Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/account/CreateNewAccountView;->access$800(Lcom/amazon/mShop/account/CreateNewAccountView;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 92
    :cond_0
    return-void

    .line 82
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/account/CreateNewAccountView$1;->this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

    # getter for: Lcom/amazon/mShop/account/CreateNewAccountView;->newAccountController:Lcom/amazon/mShop/control/account/NewAccountController;
    invoke-static {v0}, Lcom/amazon/mShop/account/CreateNewAccountView;->access$200(Lcom/amazon/mShop/account/CreateNewAccountView;)Lcom/amazon/mShop/control/account/NewAccountController;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/account/CreateNewAccountView$1;->this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

    # getter for: Lcom/amazon/mShop/account/CreateNewAccountView;->fullName:Landroid/widget/EditText;
    invoke-static {v1}, Lcom/amazon/mShop/account/CreateNewAccountView;->access$300(Lcom/amazon/mShop/account/CreateNewAccountView;)Landroid/widget/EditText;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/amazon/mShop/account/CreateNewAccountView$1;->this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

    # getter for: Lcom/amazon/mShop/account/CreateNewAccountView;->email:Landroid/widget/EditText;
    invoke-static {v3}, Lcom/amazon/mShop/account/CreateNewAccountView;->access$500(Lcom/amazon/mShop/account/CreateNewAccountView;)Landroid/widget/EditText;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/mShop/account/CreateNewAccountView$1;->this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

    # getter for: Lcom/amazon/mShop/account/CreateNewAccountView;->password:Landroid/widget/EditText;
    invoke-static {v4}, Lcom/amazon/mShop/account/CreateNewAccountView;->access$600(Lcom/amazon/mShop/account/CreateNewAccountView;)Landroid/widget/EditText;

    move-result-object v4

    invoke-virtual {v4}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    iget-object v6, p0, Lcom/amazon/mShop/account/CreateNewAccountView$1;->this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

    # getter for: Lcom/amazon/mShop/account/CreateNewAccountView;->taskCallback:Lcom/amazon/mShop/control/TaskCallback;
    invoke-static {v6}, Lcom/amazon/mShop/account/CreateNewAccountView;->access$700(Lcom/amazon/mShop/account/CreateNewAccountView;)Lcom/amazon/mShop/control/TaskCallback;

    move-result-object v6

    invoke-virtual/range {v0 .. v6}, Lcom/amazon/mShop/control/account/NewAccountController;->createNewAccount(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/amazon/mShop/control/TaskCallback;)V

    goto :goto_0
.end method

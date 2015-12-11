.class Lcom/amazon/mShop/youraccount/OneClickSettingsView$3;
.super Ljava/lang/Object;
.source "OneClickSettingsView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/youraccount/OneClickSettingsView;-><init>(Lcom/amazon/mShop/AmazonActivity;Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/youraccount/OneClickSettingsView;

.field final synthetic val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/youraccount/OneClickSettingsView;Lcom/amazon/mShop/AmazonActivity;)V
    .locals 0

    .prologue
    .line 140
    iput-object p1, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$3;->this$0:Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    iput-object p2, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$3;->val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 145
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$3;->this$0:Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    # getter for: Lcom/amazon/mShop/youraccount/OneClickSettingsView;->controller:Lcom/amazon/mShop/control/account/OneClickController;
    invoke-static {v0}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->access$000(Lcom/amazon/mShop/youraccount/OneClickSettingsView;)Lcom/amazon/mShop/control/account/OneClickController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/control/account/OneClickController;->isDeviceNameSet()Z

    move-result v0

    if-nez v0, :cond_0

    .line 146
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$3;->this$0:Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    # getter for: Lcom/amazon/mShop/youraccount/OneClickSettingsView;->controller:Lcom/amazon/mShop/control/account/OneClickController;
    invoke-static {v0}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->access$000(Lcom/amazon/mShop/youraccount/OneClickSettingsView;)Lcom/amazon/mShop/control/account/OneClickController;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$3;->this$0:Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    # getter for: Lcom/amazon/mShop/youraccount/OneClickSettingsView;->deviceNameEdit:Landroid/widget/EditText;
    invoke-static {v1}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->access$200(Lcom/amazon/mShop/youraccount/OneClickSettingsView;)Landroid/widget/EditText;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/control/account/OneClickController;->setDeviceName(Ljava/lang/String;)V

    .line 148
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$3;->this$0:Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    # getter for: Lcom/amazon/mShop/youraccount/OneClickSettingsView;->controller:Lcom/amazon/mShop/control/account/OneClickController;
    invoke-static {v0}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->access$000(Lcom/amazon/mShop/youraccount/OneClickSettingsView;)Lcom/amazon/mShop/control/account/OneClickController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/control/account/OneClickController;->hasServiceCallRunning()Z

    move-result v0

    if-nez v0, :cond_1

    .line 149
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$3;->this$0:Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    # getter for: Lcom/amazon/mShop/youraccount/OneClickSettingsView;->controller:Lcom/amazon/mShop/control/account/OneClickController;
    invoke-static {v0}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->access$000(Lcom/amazon/mShop/youraccount/OneClickSettingsView;)Lcom/amazon/mShop/control/account/OneClickController;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$3;->this$0:Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    # getter for: Lcom/amazon/mShop/youraccount/OneClickSettingsView;->taskCallback:Lcom/amazon/mShop/TaskCallbackFactory;
    invoke-static {v1}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->access$300(Lcom/amazon/mShop/youraccount/OneClickSettingsView;)Lcom/amazon/mShop/TaskCallbackFactory;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$3;->this$0:Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    # getter for: Lcom/amazon/mShop/youraccount/OneClickSettingsView;->controller:Lcom/amazon/mShop/control/account/OneClickController;
    invoke-static {v2}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->access$000(Lcom/amazon/mShop/youraccount/OneClickSettingsView;)Lcom/amazon/mShop/control/account/OneClickController;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$3;->val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->one_click_settings_loading_shipping_addresses:I

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/mShop/TaskCallbackFactory;->getPopViewTaskCallback(Lcom/amazon/mShop/control/Cancellable;Lcom/amazon/mShop/AmazonActivity;I)Lcom/amazon/mShop/control/TaskCallback;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/control/account/OneClickController;->doGetOneClickAddresses(Lcom/amazon/mShop/control/TaskCallback;)V

    .line 152
    :cond_1
    return-void
.end method

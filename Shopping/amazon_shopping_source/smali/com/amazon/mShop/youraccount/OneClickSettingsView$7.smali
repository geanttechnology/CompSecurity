.class Lcom/amazon/mShop/youraccount/OneClickSettingsView$7;
.super Ljava/lang/Object;
.source "OneClickSettingsView.java"

# interfaces
.implements Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/youraccount/OneClickSettingsView;->onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/youraccount/OneClickSettingsView;

.field final synthetic val$errorMethod:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/youraccount/OneClickSettingsView;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 337
    iput-object p1, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$7;->this$0:Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    iput-object p2, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$7;->val$errorMethod:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onActionButtonClick(I)V
    .locals 5
    .param p1, "errorId"    # I

    .prologue
    .line 343
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$7;->this$0:Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    # getter for: Lcom/amazon/mShop/youraccount/OneClickSettingsView;->controller:Lcom/amazon/mShop/control/account/OneClickController;
    invoke-static {v0}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->access$000(Lcom/amazon/mShop/youraccount/OneClickSettingsView;)Lcom/amazon/mShop/control/account/OneClickController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/control/account/OneClickController;->hasServiceCallRunning()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 344
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$7;->this$0:Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    # getter for: Lcom/amazon/mShop/youraccount/OneClickSettingsView;->controller:Lcom/amazon/mShop/control/account/OneClickController;
    invoke-static {v0}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->access$000(Lcom/amazon/mShop/youraccount/OneClickSettingsView;)Lcom/amazon/mShop/control/account/OneClickController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/control/account/OneClickController;->cancel()V

    .line 347
    :cond_0
    const-string/jumbo v0, "enable_one_click_v1"

    iget-object v1, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$7;->val$errorMethod:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 348
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$7;->this$0:Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    const/4 v1, 0x1

    # invokes: Lcom/amazon/mShop/youraccount/OneClickSettingsView;->setOneClickSetting(Z)V
    invoke-static {v0, v1}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->access$100(Lcom/amazon/mShop/youraccount/OneClickSettingsView;Z)V

    .line 359
    :cond_1
    :goto_0
    return-void

    .line 349
    :cond_2
    const-string/jumbo v0, "disable_one_click_v1"

    iget-object v1, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$7;->val$errorMethod:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 350
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$7;->this$0:Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    const/4 v1, 0x0

    # invokes: Lcom/amazon/mShop/youraccount/OneClickSettingsView;->setOneClickSetting(Z)V
    invoke-static {v0, v1}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->access$100(Lcom/amazon/mShop/youraccount/OneClickSettingsView;Z)V

    goto :goto_0

    .line 351
    :cond_3
    const-string/jumbo v0, "get_one_click_addresses_v21"

    iget-object v1, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$7;->val$errorMethod:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 352
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$7;->this$0:Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    # getter for: Lcom/amazon/mShop/youraccount/OneClickSettingsView;->controller:Lcom/amazon/mShop/control/account/OneClickController;
    invoke-static {v0}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->access$000(Lcom/amazon/mShop/youraccount/OneClickSettingsView;)Lcom/amazon/mShop/control/account/OneClickController;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$7;->this$0:Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    # getter for: Lcom/amazon/mShop/youraccount/OneClickSettingsView;->taskCallback:Lcom/amazon/mShop/TaskCallbackFactory;
    invoke-static {v1}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->access$300(Lcom/amazon/mShop/youraccount/OneClickSettingsView;)Lcom/amazon/mShop/TaskCallbackFactory;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$7;->this$0:Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    # getter for: Lcom/amazon/mShop/youraccount/OneClickSettingsView;->controller:Lcom/amazon/mShop/control/account/OneClickController;
    invoke-static {v2}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->access$000(Lcom/amazon/mShop/youraccount/OneClickSettingsView;)Lcom/amazon/mShop/control/account/OneClickController;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$7;->this$0:Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    # getter for: Lcom/amazon/mShop/youraccount/OneClickSettingsView;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v3}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->access$500(Lcom/amazon/mShop/youraccount/OneClickSettingsView;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->one_click_settings_loading_shipping_addresses:I

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/mShop/TaskCallbackFactory;->getPopViewTaskCallback(Lcom/amazon/mShop/control/Cancellable;Lcom/amazon/mShop/AmazonActivity;I)Lcom/amazon/mShop/control/TaskCallback;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/control/account/OneClickController;->doGetOneClickAddresses(Lcom/amazon/mShop/control/TaskCallback;)V

    goto :goto_0

    .line 353
    :cond_4
    const-string/jumbo v0, "get_one_click_config_v21"

    iget-object v1, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$7;->val$errorMethod:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 354
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$7;->this$0:Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    # getter for: Lcom/amazon/mShop/youraccount/OneClickSettingsView;->controller:Lcom/amazon/mShop/control/account/OneClickController;
    invoke-static {v0}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->access$000(Lcom/amazon/mShop/youraccount/OneClickSettingsView;)Lcom/amazon/mShop/control/account/OneClickController;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$7;->this$0:Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    # getter for: Lcom/amazon/mShop/youraccount/OneClickSettingsView;->taskCallback:Lcom/amazon/mShop/TaskCallbackFactory;
    invoke-static {v1}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->access$300(Lcom/amazon/mShop/youraccount/OneClickSettingsView;)Lcom/amazon/mShop/TaskCallbackFactory;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$7;->this$0:Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    # getter for: Lcom/amazon/mShop/youraccount/OneClickSettingsView;->controller:Lcom/amazon/mShop/control/account/OneClickController;
    invoke-static {v2}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->access$000(Lcom/amazon/mShop/youraccount/OneClickSettingsView;)Lcom/amazon/mShop/control/account/OneClickController;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->one_click_settings_loading:I

    invoke-virtual {v1, v2, v3}, Lcom/amazon/mShop/TaskCallbackFactory;->getTaskCallback(Lcom/amazon/mShop/control/Cancellable;I)Lcom/amazon/mShop/control/TaskCallback;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/control/account/OneClickController;->doGetOneClickConfig(Lcom/amazon/mShop/control/TaskCallback;)V

    goto :goto_0

    .line 355
    :cond_5
    const-string/jumbo v0, "set_one_click_config_v21"

    iget-object v1, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$7;->val$errorMethod:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 356
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$7;->this$0:Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    # getter for: Lcom/amazon/mShop/youraccount/OneClickSettingsView;->controller:Lcom/amazon/mShop/control/account/OneClickController;
    invoke-static {v0}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->access$000(Lcom/amazon/mShop/youraccount/OneClickSettingsView;)Lcom/amazon/mShop/control/account/OneClickController;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$7;->this$0:Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    # getter for: Lcom/amazon/mShop/youraccount/OneClickSettingsView;->taskCallback:Lcom/amazon/mShop/TaskCallbackFactory;
    invoke-static {v1}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->access$300(Lcom/amazon/mShop/youraccount/OneClickSettingsView;)Lcom/amazon/mShop/TaskCallbackFactory;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$7;->this$0:Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    # getter for: Lcom/amazon/mShop/youraccount/OneClickSettingsView;->controller:Lcom/amazon/mShop/control/account/OneClickController;
    invoke-static {v2}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->access$000(Lcom/amazon/mShop/youraccount/OneClickSettingsView;)Lcom/amazon/mShop/control/account/OneClickController;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$7;->this$0:Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    # getter for: Lcom/amazon/mShop/youraccount/OneClickSettingsView;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v3}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->access$500(Lcom/amazon/mShop/youraccount/OneClickSettingsView;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->one_click_settings_saving_shipping_payment_method:I

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/mShop/TaskCallbackFactory;->getPopViewTaskCallback(Lcom/amazon/mShop/control/Cancellable;Lcom/amazon/mShop/AmazonActivity;I)Lcom/amazon/mShop/control/TaskCallback;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/control/account/OneClickController;->doSetOneClickConfig(Lcom/amazon/mShop/control/TaskCallback;)V

    goto/16 :goto_0
.end method

.class Lcom/amazon/mShop/youraccount/OneClickSettingsView$2;
.super Ljava/lang/Object;
.source "OneClickSettingsView.java"

# interfaces
.implements Landroid/widget/CompoundButton$OnCheckedChangeListener;


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


# direct methods
.method constructor <init>(Lcom/amazon/mShop/youraccount/OneClickSettingsView;)V
    .locals 0

    .prologue
    .line 109
    iput-object p1, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$2;->this$0:Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCheckedChanged(Landroid/widget/CompoundButton;Z)V
    .locals 3
    .param p1, "buttonView"    # Landroid/widget/CompoundButton;
    .param p2, "isChecked"    # Z

    .prologue
    .line 114
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$2;->this$0:Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    # getter for: Lcom/amazon/mShop/youraccount/OneClickSettingsView;->controller:Lcom/amazon/mShop/control/account/OneClickController;
    invoke-static {v0}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->access$000(Lcom/amazon/mShop/youraccount/OneClickSettingsView;)Lcom/amazon/mShop/control/account/OneClickController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/control/account/OneClickController;->isOneClickStatusEnabled()Z

    move-result v0

    if-eq p2, v0, :cond_0

    .line 115
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$2;->this$0:Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    # invokes: Lcom/amazon/mShop/youraccount/OneClickSettingsView;->setOneClickSetting(Z)V
    invoke-static {v0, p2}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->access$100(Lcom/amazon/mShop/youraccount/OneClickSettingsView;Z)V

    .line 118
    if-nez p2, :cond_0

    invoke-static {}, Lcom/amazon/mShop/util/ConfigUtils;->isDigitalContentEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 119
    new-instance v0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    iget-object v1, p0, Lcom/amazon/mShop/youraccount/OneClickSettingsView$2;->this$0:Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    invoke-virtual {v1}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;-><init>(Landroid/content/Context;)V

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->one_click_settings_pop_up_title:I

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setTitle(I)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->one_click_settings_pop_up_message:I

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setMessage(I)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->alert_ok_button:I

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setNeutralButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->create()Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog;->show()V

    .line 127
    :cond_0
    return-void
.end method

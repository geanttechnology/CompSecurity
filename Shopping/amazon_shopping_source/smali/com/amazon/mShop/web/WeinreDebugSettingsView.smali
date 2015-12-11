.class public Lcom/amazon/mShop/web/WeinreDebugSettingsView;
.super Landroid/widget/LinearLayout;
.source "WeinreDebugSettingsView.java"


# instance fields
.field private mActivity:Lcom/amazon/mShop/AmazonActivity;

.field private mWeinreServerHostEditText:Landroid/widget/EditText;

.field private mWeinreServerPortEditText:Landroid/widget/EditText;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/AmazonActivity;Landroid/util/AttributeSet;)V
    .locals 8
    .param p1, "activity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 40
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 41
    iput-object p1, p0, Lcom/amazon/mShop/web/WeinreDebugSettingsView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 42
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v5

    invoke-interface {v5}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v1

    .line 43
    .local v1, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    iget-object v5, p0, Lcom/amazon/mShop/web/WeinreDebugSettingsView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    sget v6, Lcom/amazon/mShop/android/lib/R$layout;->weinre_debug_settings:I

    invoke-static {v5, v6, p0}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 44
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->weinre_server_host_edit_text:I

    invoke-virtual {p0, v5}, Lcom/amazon/mShop/web/WeinreDebugSettingsView;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/EditText;

    iput-object v5, p0, Lcom/amazon/mShop/web/WeinreDebugSettingsView;->mWeinreServerHostEditText:Landroid/widget/EditText;

    .line 45
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->weinre_server_port_edit_text:I

    invoke-virtual {p0, v5}, Lcom/amazon/mShop/web/WeinreDebugSettingsView;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/EditText;

    iput-object v5, p0, Lcom/amazon/mShop/web/WeinreDebugSettingsView;->mWeinreServerPortEditText:Landroid/widget/EditText;

    .line 47
    iget-object v5, p0, Lcom/amazon/mShop/web/WeinreDebugSettingsView;->mWeinreServerHostEditText:Landroid/widget/EditText;

    const-string/jumbo v6, "weinreServerHost"

    invoke-interface {v1, v6}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 48
    const-string/jumbo v5, "weinreServerPort"

    invoke-interface {v1, v5}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getInt(Ljava/lang/String;)I

    move-result v3

    .line 49
    .local v3, "port":I
    if-nez v3, :cond_0

    .line 50
    invoke-virtual {p0}, Lcom/amazon/mShop/web/WeinreDebugSettingsView;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/amazon/mShop/android/lib/R$integer;->weinre_server_default_port:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v3

    .line 52
    :cond_0
    iget-object v5, p0, Lcom/amazon/mShop/web/WeinreDebugSettingsView;->mWeinreServerPortEditText:Landroid/widget/EditText;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, ""

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 54
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->weinre_debug_checkbox:I

    invoke-virtual {p0, v5}, Lcom/amazon/mShop/web/WeinreDebugSettingsView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;

    .line 55
    .local v0, "checkBox":Lcom/amazon/mShop/ui/AmazonSwitchWidget;
    const-string/jumbo v5, "weinreServerStatus"

    const/4 v6, 0x0

    invoke-interface {v1, v5, v6}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getBoolean(Ljava/lang/String;Z)Z

    move-result v2

    .line 56
    .local v2, "isWeinreDebugOn":Z
    invoke-virtual {v0, v2}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->setChecked(Z)V

    .line 57
    iget-object v5, p0, Lcom/amazon/mShop/web/WeinreDebugSettingsView;->mWeinreServerHostEditText:Landroid/widget/EditText;

    invoke-virtual {v5, v2}, Landroid/widget/EditText;->setEnabled(Z)V

    .line 58
    iget-object v5, p0, Lcom/amazon/mShop/web/WeinreDebugSettingsView;->mWeinreServerPortEditText:Landroid/widget/EditText;

    invoke-virtual {v5, v2}, Landroid/widget/EditText;->setEnabled(Z)V

    .line 59
    new-instance v5, Lcom/amazon/mShop/web/WeinreDebugSettingsView$1;

    invoke-direct {v5, p0, v1}, Lcom/amazon/mShop/web/WeinreDebugSettingsView$1;-><init>(Lcom/amazon/mShop/web/WeinreDebugSettingsView;Lcom/amazon/rio/j2me/client/persistence/DataStore;)V

    invoke-virtual {v0, v5}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 68
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->save_settings_and_restart_button:I

    invoke-virtual {p0, v5}, Lcom/amazon/mShop/web/WeinreDebugSettingsView;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/Button;

    .line 69
    .local v4, "saveSettingsButton":Landroid/widget/Button;
    new-instance v5, Lcom/amazon/mShop/web/WeinreDebugSettingsView$2;

    invoke-direct {v5, p0, v1}, Lcom/amazon/mShop/web/WeinreDebugSettingsView$2;-><init>(Lcom/amazon/mShop/web/WeinreDebugSettingsView;Lcom/amazon/rio/j2me/client/persistence/DataStore;)V

    invoke-virtual {v4, v5}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 78
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/web/WeinreDebugSettingsView;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/web/WeinreDebugSettingsView;

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/mShop/web/WeinreDebugSettingsView;->mWeinreServerHostEditText:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/web/WeinreDebugSettingsView;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/web/WeinreDebugSettingsView;

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/mShop/web/WeinreDebugSettingsView;->mWeinreServerPortEditText:Landroid/widget/EditText;

    return-object v0
.end method

.class Lcom/amazon/mShop/web/WeinreDebugSettingsView$2;
.super Ljava/lang/Object;
.source "WeinreDebugSettingsView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/web/WeinreDebugSettingsView;-><init>(Lcom/amazon/mShop/AmazonActivity;Landroid/util/AttributeSet;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/web/WeinreDebugSettingsView;

.field final synthetic val$dataStore:Lcom/amazon/rio/j2me/client/persistence/DataStore;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/web/WeinreDebugSettingsView;Lcom/amazon/rio/j2me/client/persistence/DataStore;)V
    .locals 0

    .prologue
    .line 69
    iput-object p1, p0, Lcom/amazon/mShop/web/WeinreDebugSettingsView$2;->this$0:Lcom/amazon/mShop/web/WeinreDebugSettingsView;

    iput-object p2, p0, Lcom/amazon/mShop/web/WeinreDebugSettingsView$2;->val$dataStore:Lcom/amazon/rio/j2me/client/persistence/DataStore;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 72
    iget-object v0, p0, Lcom/amazon/mShop/web/WeinreDebugSettingsView$2;->val$dataStore:Lcom/amazon/rio/j2me/client/persistence/DataStore;

    const-string/jumbo v1, "weinreServerHost"

    iget-object v2, p0, Lcom/amazon/mShop/web/WeinreDebugSettingsView$2;->this$0:Lcom/amazon/mShop/web/WeinreDebugSettingsView;

    # getter for: Lcom/amazon/mShop/web/WeinreDebugSettingsView;->mWeinreServerHostEditText:Landroid/widget/EditText;
    invoke-static {v2}, Lcom/amazon/mShop/web/WeinreDebugSettingsView;->access$000(Lcom/amazon/mShop/web/WeinreDebugSettingsView;)Landroid/widget/EditText;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 73
    iget-object v1, p0, Lcom/amazon/mShop/web/WeinreDebugSettingsView$2;->val$dataStore:Lcom/amazon/rio/j2me/client/persistence/DataStore;

    const-string/jumbo v2, "weinreServerPort"

    iget-object v0, p0, Lcom/amazon/mShop/web/WeinreDebugSettingsView$2;->this$0:Lcom/amazon/mShop/web/WeinreDebugSettingsView;

    # getter for: Lcom/amazon/mShop/web/WeinreDebugSettingsView;->mWeinreServerPortEditText:Landroid/widget/EditText;
    invoke-static {v0}, Lcom/amazon/mShop/web/WeinreDebugSettingsView;->access$100(Lcom/amazon/mShop/web/WeinreDebugSettingsView;)Landroid/widget/EditText;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/web/WeinreDebugSettingsView$2;->this$0:Lcom/amazon/mShop/web/WeinreDebugSettingsView;

    invoke-virtual {v0}, Lcom/amazon/mShop/web/WeinreDebugSettingsView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v3, Lcom/amazon/mShop/android/lib/R$integer;->weinre_server_default_port:I

    invoke-virtual {v0, v3}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v0

    :goto_0
    invoke-interface {v1, v2, v0}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putInt(Ljava/lang/String;I)V

    .line 75
    invoke-static {}, Lcom/amazon/mShop/util/AppUtils;->restartApp()V

    .line 76
    return-void

    .line 73
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/web/WeinreDebugSettingsView$2;->this$0:Lcom/amazon/mShop/web/WeinreDebugSettingsView;

    # getter for: Lcom/amazon/mShop/web/WeinreDebugSettingsView;->mWeinreServerPortEditText:Landroid/widget/EditText;
    invoke-static {v0}, Lcom/amazon/mShop/web/WeinreDebugSettingsView;->access$100(Lcom/amazon/mShop/web/WeinreDebugSettingsView;)Landroid/widget/EditText;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    goto :goto_0
.end method

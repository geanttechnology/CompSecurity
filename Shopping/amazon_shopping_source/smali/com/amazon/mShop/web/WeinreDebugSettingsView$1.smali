.class Lcom/amazon/mShop/web/WeinreDebugSettingsView$1;
.super Ljava/lang/Object;
.source "WeinreDebugSettingsView.java"

# interfaces
.implements Landroid/widget/CompoundButton$OnCheckedChangeListener;


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
    .line 59
    iput-object p1, p0, Lcom/amazon/mShop/web/WeinreDebugSettingsView$1;->this$0:Lcom/amazon/mShop/web/WeinreDebugSettingsView;

    iput-object p2, p0, Lcom/amazon/mShop/web/WeinreDebugSettingsView$1;->val$dataStore:Lcom/amazon/rio/j2me/client/persistence/DataStore;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCheckedChanged(Landroid/widget/CompoundButton;Z)V
    .locals 2
    .param p1, "buttonView"    # Landroid/widget/CompoundButton;
    .param p2, "isChecked"    # Z

    .prologue
    .line 62
    iget-object v0, p0, Lcom/amazon/mShop/web/WeinreDebugSettingsView$1;->val$dataStore:Lcom/amazon/rio/j2me/client/persistence/DataStore;

    const-string/jumbo v1, "weinreServerStatus"

    invoke-interface {v0, v1, p2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putBoolean(Ljava/lang/String;Z)V

    .line 63
    iget-object v0, p0, Lcom/amazon/mShop/web/WeinreDebugSettingsView$1;->this$0:Lcom/amazon/mShop/web/WeinreDebugSettingsView;

    # getter for: Lcom/amazon/mShop/web/WeinreDebugSettingsView;->mWeinreServerHostEditText:Landroid/widget/EditText;
    invoke-static {v0}, Lcom/amazon/mShop/web/WeinreDebugSettingsView;->access$000(Lcom/amazon/mShop/web/WeinreDebugSettingsView;)Landroid/widget/EditText;

    move-result-object v0

    invoke-virtual {v0, p2}, Landroid/widget/EditText;->setEnabled(Z)V

    .line 64
    iget-object v0, p0, Lcom/amazon/mShop/web/WeinreDebugSettingsView$1;->this$0:Lcom/amazon/mShop/web/WeinreDebugSettingsView;

    # getter for: Lcom/amazon/mShop/web/WeinreDebugSettingsView;->mWeinreServerPortEditText:Landroid/widget/EditText;
    invoke-static {v0}, Lcom/amazon/mShop/web/WeinreDebugSettingsView;->access$100(Lcom/amazon/mShop/web/WeinreDebugSettingsView;)Landroid/widget/EditText;

    move-result-object v0

    invoke-virtual {v0, p2}, Landroid/widget/EditText;->setEnabled(Z)V

    .line 65
    return-void
.end method

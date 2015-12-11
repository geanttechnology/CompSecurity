.class Lcom/amazon/mShop/startup/UserAgreementActivity$1;
.super Ljava/lang/Object;
.source "UserAgreementActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/startup/UserAgreementActivity;->showUserAgreement(Landroid/app/Activity;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/startup/UserAgreementActivity;

.field final synthetic val$checkBox:Landroid/widget/CheckBox;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/startup/UserAgreementActivity;Landroid/widget/CheckBox;)V
    .locals 0

    .prologue
    .line 62
    iput-object p1, p0, Lcom/amazon/mShop/startup/UserAgreementActivity$1;->this$0:Lcom/amazon/mShop/startup/UserAgreementActivity;

    iput-object p2, p0, Lcom/amazon/mShop/startup/UserAgreementActivity$1;->val$checkBox:Landroid/widget/CheckBox;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 3
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 65
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 66
    iget-object v1, p0, Lcom/amazon/mShop/startup/UserAgreementActivity$1;->val$checkBox:Landroid/widget/CheckBox;

    invoke-virtual {v1}, Landroid/widget/CheckBox;->isChecked()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 67
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 68
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v1, "appStartIndicationDialogNotRemindAgain"

    const/4 v2, 0x1

    invoke-interface {v0, v1, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putBoolean(Ljava/lang/String;Z)V

    .line 70
    .end local v0    # "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/startup/UserAgreementActivity$1;->this$0:Lcom/amazon/mShop/startup/UserAgreementActivity;

    const-string/jumbo v2, "taskResultSucceed"

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/startup/UserAgreementActivity;->endStartupTask(Ljava/lang/String;)V

    .line 71
    return-void
.end method

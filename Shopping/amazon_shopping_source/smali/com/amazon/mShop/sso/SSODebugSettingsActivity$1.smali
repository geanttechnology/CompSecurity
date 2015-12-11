.class Lcom/amazon/mShop/sso/SSODebugSettingsActivity$1;
.super Ljava/lang/Object;
.source "SSODebugSettingsActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/sso/SSODebugSettingsActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/sso/SSODebugSettingsActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/sso/SSODebugSettingsActivity;)V
    .locals 0

    .prologue
    .line 33
    iput-object p1, p0, Lcom/amazon/mShop/sso/SSODebugSettingsActivity$1;->this$0:Lcom/amazon/mShop/sso/SSODebugSettingsActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 36
    iget-object v3, p0, Lcom/amazon/mShop/sso/SSODebugSettingsActivity$1;->this$0:Lcom/amazon/mShop/sso/SSODebugSettingsActivity;

    # getter for: Lcom/amazon/mShop/sso/SSODebugSettingsActivity;->mForceSignInGroup:Landroid/widget/RadioGroup;
    invoke-static {v3}, Lcom/amazon/mShop/sso/SSODebugSettingsActivity;->access$000(Lcom/amazon/mShop/sso/SSODebugSettingsActivity;)Landroid/widget/RadioGroup;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/mShop/sso/SSODebugSettingsActivity$1;->this$0:Lcom/amazon/mShop/sso/SSODebugSettingsActivity;

    # getter for: Lcom/amazon/mShop/sso/SSODebugSettingsActivity;->mForceSignInGroup:Landroid/widget/RadioGroup;
    invoke-static {v4}, Lcom/amazon/mShop/sso/SSODebugSettingsActivity;->access$000(Lcom/amazon/mShop/sso/SSODebugSettingsActivity;)Landroid/widget/RadioGroup;

    move-result-object v4

    invoke-virtual {v4}, Landroid/widget/RadioGroup;->getCheckedRadioButtonId()I

    move-result v4

    invoke-virtual {v3, v4}, Landroid/widget/RadioGroup;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/RadioButton;

    invoke-virtual {v3}, Landroid/widget/RadioButton;->getText()Ljava/lang/CharSequence;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    .line 38
    .local v2, "forceSignInOption":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v1

    .line 39
    .local v1, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v3, "switchSSONonAuthForceSignIn"

    invoke-interface {v1, v3, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 41
    iget-object v3, p0, Lcom/amazon/mShop/sso/SSODebugSettingsActivity$1;->this$0:Lcom/amazon/mShop/sso/SSODebugSettingsActivity;

    # getter for: Lcom/amazon/mShop/sso/SSODebugSettingsActivity;->mAccountPhoneNumberGroup:Landroid/widget/RadioGroup;
    invoke-static {v3}, Lcom/amazon/mShop/sso/SSODebugSettingsActivity;->access$100(Lcom/amazon/mShop/sso/SSODebugSettingsActivity;)Landroid/widget/RadioGroup;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/mShop/sso/SSODebugSettingsActivity$1;->this$0:Lcom/amazon/mShop/sso/SSODebugSettingsActivity;

    # getter for: Lcom/amazon/mShop/sso/SSODebugSettingsActivity;->mAccountPhoneNumberGroup:Landroid/widget/RadioGroup;
    invoke-static {v4}, Lcom/amazon/mShop/sso/SSODebugSettingsActivity;->access$100(Lcom/amazon/mShop/sso/SSODebugSettingsActivity;)Landroid/widget/RadioGroup;

    move-result-object v4

    invoke-virtual {v4}, Landroid/widget/RadioGroup;->getCheckedRadioButtonId()I

    move-result v4

    invoke-virtual {v3, v4}, Landroid/widget/RadioGroup;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/RadioButton;

    invoke-virtual {v3}, Landroid/widget/RadioButton;->getText()Ljava/lang/CharSequence;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 43
    .local v0, "accountPhoneNumber":Ljava/lang/String;
    const-string/jumbo v3, "accountPhoneNumber"

    invoke-interface {v1, v3, v0}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 45
    invoke-static {}, Lcom/amazon/mShop/util/AppUtils;->restartApp()V

    .line 46
    return-void
.end method

.class Lcom/poshmark/ui/fragments/SharingSettingsFragment$1;
.super Ljava/lang/Object;
.source "SharingSettingsFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/SharingSettingsFragment;->onActivityCreated(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/poshmark/http/api/PMApiResponseHandler",
        "<",
        "Lcom/poshmark/user/UserInfoDetails$Settings;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/SharingSettingsFragment;)V
    .locals 0

    .prologue
    .line 84
    iput-object p1, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$1;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Lcom/poshmark/user/UserInfoDetails$Settings;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 87
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/user/UserInfoDetails$Settings;>;"
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$1;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 88
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$1;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->hideProgressDialog()V

    .line 89
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_1

    .line 90
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$1;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/user/UserInfoDetails$Settings;

    iput-object v0, v1, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->settingsData:Lcom/poshmark/user/UserInfoDetails$Settings;

    .line 91
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$1;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$1;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getView()Landroid/view/View;

    move-result-object v1

    # invokes: Lcom/poshmark/ui/fragments/SharingSettingsFragment;->setupView(Landroid/view/View;)V
    invoke-static {v0, v1}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->access$000(Lcom/poshmark/ui/fragments/SharingSettingsFragment;Landroid/view/View;)V

    .line 92
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$1;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    # getter for: Lcom/poshmark/ui/fragments/SharingSettingsFragment;->autoLaunchServiceConnect:Z
    invoke-static {v0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->access$100(Lcom/poshmark/ui/fragments/SharingSettingsFragment;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 93
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$1;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    # invokes: Lcom/poshmark/ui/fragments/SharingSettingsFragment;->autoLaunchServiceConnect()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->access$200(Lcom/poshmark/ui/fragments/SharingSettingsFragment;)V

    .line 100
    :cond_0
    :goto_0
    return-void

    .line 96
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$1;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    new-instance v1, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v2, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v3, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->LOAD_USER_SETTINGS:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$1;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    const v5, 0x7f0600ed

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v1, v2, v3, v4}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method

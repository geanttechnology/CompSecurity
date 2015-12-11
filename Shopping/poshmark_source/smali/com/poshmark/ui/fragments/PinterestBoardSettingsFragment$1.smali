.class Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$1;
.super Ljava/lang/Object;
.source "PinterestBoardSettingsFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->onActivityCreated(Landroid/os/Bundle;)V
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
        "Lcom/poshmark/utils/meta_data/PinterestSettings;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;)V
    .locals 0

    .prologue
    .line 73
    iput-object p1, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$1;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;

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
            "Lcom/poshmark/utils/meta_data/PinterestSettings;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 76
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/utils/meta_data/PinterestSettings;>;"
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$1;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 77
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$1;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->hideProgressDialog()V

    .line 78
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_1

    .line 79
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$1;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;

    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/utils/meta_data/PinterestSettings;

    iput-object v0, v1, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->pins:Lcom/poshmark/utils/meta_data/PinterestSettings;

    .line 80
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$1;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;

    # invokes: Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->setupView()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->access$000(Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;)V

    .line 86
    :cond_0
    :goto_0
    return-void

    .line 82
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$1;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;

    new-instance v1, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v2, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v3, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->LOAD_USER_SETTINGS:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$1;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;

    const v5, 0x7f0600ed

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v1, v2, v3, v4}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method

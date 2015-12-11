.class Lcom/poshmark/ui/fragments/ClosetFragment$9;
.super Ljava/lang/Object;
.source "ClosetFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ClosetFragment;->unblockUser()V
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
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ClosetFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ClosetFragment;)V
    .locals 0

    .prologue
    .line 389
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ClosetFragment$9;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Ljava/lang/Void;>;"
    const/4 v4, 0x0

    .line 392
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment$9;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/ClosetFragment;->isAdded()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 393
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v1

    if-nez v1, :cond_1

    .line 394
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment$9;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetFragment$9;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    const v3, 0x7f0602b8

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/ClosetFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/ClosetFragment;->showAutoHideSuccessMessage(Ljava/lang/String;)V

    .line 395
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment$9;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    # getter for: Lcom/poshmark/ui/fragments/ClosetFragment;->profileData:Lcom/poshmark/user/UserInfoDetails;
    invoke-static {v1}, Lcom/poshmark/ui/fragments/ClosetFragment;->access$100(Lcom/poshmark/ui/fragments/ClosetFragment;)Lcom/poshmark/user/UserInfoDetails;

    move-result-object v1

    invoke-virtual {v1, v4}, Lcom/poshmark/user/UserInfoDetails;->setBlockedFlag(Z)V

    .line 396
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 397
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "PARENT_ID"

    new-instance v2, Landroid/os/ParcelUuid;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ClosetFragment$9;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/ClosetFragment;->fragmentId:Ljava/util/UUID;

    invoke-direct {v2, v3}, Landroid/os/ParcelUuid;-><init>(Ljava/util/UUID;)V

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 398
    const-string v1, "BLOCK_USER_STATUS"

    invoke-virtual {v0, v1, v4}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 399
    const-string v1, "com.poshmark.intents.SET_BLOCK_USER_STATUS_ACTION"

    invoke-static {v1, v0}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 406
    .end local v0    # "b":Landroid/os/Bundle;
    :cond_0
    :goto_0
    return-void

    .line 402
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetFragment$9;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    new-instance v2, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v3, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v4, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->UNBLOCK_USER:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    iget-object v5, p0, Lcom/poshmark/ui/fragments/ClosetFragment$9;->this$0:Lcom/poshmark/ui/fragments/ClosetFragment;

    const v6, 0x7f0600fd

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/fragments/ClosetFragment;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v2, v3, v4, v5}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/ClosetFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method

.class Lcom/poshmark/utils/ShareManager_Old$7;
.super Ljava/lang/Object;
.source "ShareManager_Old.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/ShareManager_Old;->initiateShare(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)V
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
        "Lcom/poshmark/data_model/models/inner_models/ShortUrl;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/utils/ShareManager_Old;

.field final synthetic val$shareType:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/ShareManager_Old;Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)V
    .locals 0

    .prologue
    .line 563
    iput-object p1, p0, Lcom/poshmark/utils/ShareManager_Old$7;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    iput-object p2, p0, Lcom/poshmark/utils/ShareManager_Old$7;->val$shareType:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Lcom/poshmark/data_model/models/inner_models/ShortUrl;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 566
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/inner_models/ShortUrl;>;"
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old$7;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    # getter for: Lcom/poshmark/utils/ShareManager_Old;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;
    invoke-static {v0}, Lcom/poshmark/utils/ShareManager_Old;->access$200(Lcom/poshmark/utils/ShareManager_Old;)Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PMFragment;->hideProgressDialog()V

    .line 567
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_4

    .line 568
    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old$7;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/inner_models/ShortUrl;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/ShortUrl;->short_url:Ljava/lang/String;

    # setter for: Lcom/poshmark/utils/ShareManager_Old;->closetShortURL:Ljava/lang/String;
    invoke-static {v1, v0}, Lcom/poshmark/utils/ShareManager_Old;->access$502(Lcom/poshmark/utils/ShareManager_Old;Ljava/lang/String;)Ljava/lang/String;

    .line 569
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old$7;->val$shareType:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v1, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->EMAIL_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v0, v1, :cond_0

    .line 570
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old$7;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager_Old;->doEmailShare()V

    .line 583
    :goto_0
    return-void

    .line 571
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old$7;->val$shareType:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v1, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->SMS_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v0, v1, :cond_1

    .line 572
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old$7;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager_Old;->doSMSShare()V

    goto :goto_0

    .line 573
    :cond_1
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old$7;->val$shareType:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v1, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->FB_MESSENGER_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v0, v1, :cond_2

    .line 574
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old$7;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager_Old;->doFBMessengerShare()V

    goto :goto_0

    .line 575
    :cond_2
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old$7;->val$shareType:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v1, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->FB_DIALOG_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v0, v1, :cond_3

    .line 576
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old$7;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager_Old;->doFbDialogShare()V

    goto :goto_0

    .line 578
    :cond_3
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old$7;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager_Old;->showShareMessageEditor()V

    goto :goto_0

    .line 580
    :cond_4
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old$7;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    # getter for: Lcom/poshmark/utils/ShareManager_Old;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;
    invoke-static {v0}, Lcom/poshmark/utils/ShareManager_Old;->access$200(Lcom/poshmark/utils/ShareManager_Old;)Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v0

    new-instance v1, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v2, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v3, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->SHARE_LISTING_TWITTER:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    invoke-direct {v1, v2, v3}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/PMFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method

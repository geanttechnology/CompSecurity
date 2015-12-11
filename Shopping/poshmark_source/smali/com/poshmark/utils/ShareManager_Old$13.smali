.class Lcom/poshmark/utils/ShareManager_Old$13;
.super Ljava/lang/Object;
.source "ShareManager_Old.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/ShareManager_Old;->shareCloset(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;Ljava/lang/String;)V
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
.field final synthetic this$0:Lcom/poshmark/utils/ShareManager_Old;

.field final synthetic val$defaultMessage:Ljava/lang/String;

.field final synthetic val$message:Ljava/lang/String;

.field final synthetic val$type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/ShareManager_Old;Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 927
    iput-object p1, p0, Lcom/poshmark/utils/ShareManager_Old$13;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    iput-object p2, p0, Lcom/poshmark/utils/ShareManager_Old$13;->val$type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    iput-object p3, p0, Lcom/poshmark/utils/ShareManager_Old$13;->val$message:Ljava/lang/String;

    iput-object p4, p0, Lcom/poshmark/utils/ShareManager_Old$13;->val$defaultMessage:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 5
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
    .line 930
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Ljava/lang/Void;>;"
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old$13;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    # getter for: Lcom/poshmark/utils/ShareManager_Old;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;
    invoke-static {v2}, Lcom/poshmark/utils/ShareManager_Old;->access$200(Lcom/poshmark/utils/ShareManager_Old;)Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/PMFragment;->hideProgressDialog()V

    .line 931
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v2

    if-nez v2, :cond_0

    .line 932
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old$13;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    # invokes: Lcom/poshmark/utils/ShareManager_Old;->trackShareEvent()V
    invoke-static {v2}, Lcom/poshmark/utils/ShareManager_Old;->access$600(Lcom/poshmark/utils/ShareManager_Old;)V

    .line 934
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old$13;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    # getter for: Lcom/poshmark/utils/ShareManager_Old;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;
    invoke-static {v2}, Lcom/poshmark/utils/ShareManager_Old;->access$200(Lcom/poshmark/utils/ShareManager_Old;)Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old$13;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    # getter for: Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;
    invoke-static {v3}, Lcom/poshmark/utils/ShareManager_Old;->access$300(Lcom/poshmark/utils/ShareManager_Old;)Landroid/content/Context;

    move-result-object v3

    const v4, 0x7f060259

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old$13;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    iget-object v4, v4, Lcom/poshmark/utils/ShareManager_Old;->dismissListener:Lcom/poshmark/ui/customviews/PMProgressDialog$ProgressDialogAutoDismissListener;

    invoke-virtual {v2, v3, v4}, Lcom/poshmark/ui/fragments/PMFragment;->showAutoHideProgressDialogWithMessage(Ljava/lang/String;Lcom/poshmark/ui/customviews/PMProgressDialog$ProgressDialogAutoDismissListener;)V

    .line 936
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old$13;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    # getter for: Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;
    invoke-static {v2}, Lcom/poshmark/utils/ShareManager_Old;->access$300(Lcom/poshmark/utils/ShareManager_Old;)Landroid/content/Context;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/PMContainerActivity;

    .line 937
    .local v1, "activity":Lcom/poshmark/ui/PMContainerActivity;
    invoke-virtual {v1}, Lcom/poshmark/ui/PMContainerActivity;->popTopFragment()V

    .line 963
    .end local v1    # "activity":Lcom/poshmark/ui/PMContainerActivity;
    :goto_0
    return-void

    .line 939
    :cond_0
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old$13;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    # invokes: Lcom/poshmark/utils/ShareManager_Old;->trackShareFailedEvent()V
    invoke-static {v2}, Lcom/poshmark/utils/ShareManager_Old;->access$700(Lcom/poshmark/utils/ShareManager_Old;)V

    .line 940
    sget-object v0, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->SHARE_CLOSET:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    .line 941
    .local v0, "actionContext":Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;
    sget-object v2, Lcom/poshmark/utils/ShareManager_Old$15;->$SwitchMap$com$poshmark$utils$ShareManager_Old$SHARE_TYPE:[I

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old$13;->val$type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    invoke-virtual {v3}, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    goto :goto_0

    .line 943
    :pswitch_0
    sget-object v0, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->SHARE_CLOSET_FACEBOOK:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    .line 944
    iget-object v2, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    iget-object v2, v2, Lcom/poshmark/http/api/PMApiError;->pmErrorType:Lcom/poshmark/data_model/models/PMErrorType;

    sget-object v3, Lcom/poshmark/data_model/models/PMErrorType;->EXTERNAL_AUTH_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    if-ne v2, v3, :cond_2

    .line 945
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old$13;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old$13;->val$message:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    if-nez v2, :cond_1

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old$13;->val$defaultMessage:Ljava/lang/String;

    :goto_1
    # invokes: Lcom/poshmark/utils/ShareManager_Old;->handleFbShareAuthError(Lcom/poshmark/http/api/PMApiResponse;Ljava/lang/String;)V
    invoke-static {v3, p1, v2}, Lcom/poshmark/utils/ShareManager_Old;->access$800(Lcom/poshmark/utils/ShareManager_Old;Lcom/poshmark/http/api/PMApiResponse;Ljava/lang/String;)V

    goto :goto_0

    :cond_1
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old$13;->val$message:Ljava/lang/String;

    goto :goto_1

    .line 947
    :cond_2
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old$13;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    # getter for: Lcom/poshmark/utils/ShareManager_Old;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;
    invoke-static {v2}, Lcom/poshmark/utils/ShareManager_Old;->access$200(Lcom/poshmark/utils/ShareManager_Old;)Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v2

    new-instance v3, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v4, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    invoke-direct {v3, v4, v0}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;)V

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/PMFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0

    .line 951
    :pswitch_1
    sget-object v0, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->SHARE_LISTING_TWITTER:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    .line 952
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old$13;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    # getter for: Lcom/poshmark/utils/ShareManager_Old;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;
    invoke-static {v2}, Lcom/poshmark/utils/ShareManager_Old;->access$200(Lcom/poshmark/utils/ShareManager_Old;)Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v2

    new-instance v3, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v4, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    invoke-direct {v3, v4, v0}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;)V

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/PMFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0

    .line 955
    :pswitch_2
    sget-object v0, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->SHARE_LISTING_TUMBLR:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    .line 956
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old$13;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    # getter for: Lcom/poshmark/utils/ShareManager_Old;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;
    invoke-static {v2}, Lcom/poshmark/utils/ShareManager_Old;->access$200(Lcom/poshmark/utils/ShareManager_Old;)Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v2

    new-instance v3, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v4, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    invoke-direct {v3, v4, v0}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;)V

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/PMFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0

    .line 941
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method

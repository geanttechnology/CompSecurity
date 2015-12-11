.class Lcom/poshmark/utils/ShareManager_Old$10;
.super Ljava/lang/Object;
.source "ShareManager_Old.java"

# interfaces
.implements Lcom/poshmark/fb_tmblr_twitter/FBConnectCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/ShareManager_Old;->handleFbShareAuthError(Lcom/poshmark/http/api/PMApiResponse;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/utils/ShareManager_Old;

.field final synthetic val$apiResponse:Lcom/poshmark/http/api/PMApiResponse;

.field final synthetic val$message:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/ShareManager_Old;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 0

    .prologue
    .line 783
    iput-object p1, p0, Lcom/poshmark/utils/ShareManager_Old$10;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    iput-object p2, p0, Lcom/poshmark/utils/ShareManager_Old$10;->val$message:Ljava/lang/String;

    iput-object p3, p0, Lcom/poshmark/utils/ShareManager_Old$10;->val$apiResponse:Lcom/poshmark/http/api/PMApiResponse;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public error(Lcom/poshmark/http/api/PMApiError;)V
    .locals 4
    .param p1, "error"    # Lcom/poshmark/http/api/PMApiError;

    .prologue
    .line 811
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old$10;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    # getter for: Lcom/poshmark/utils/ShareManager_Old;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;
    invoke-static {v0}, Lcom/poshmark/utils/ShareManager_Old;->access$200(Lcom/poshmark/utils/ShareManager_Old;)Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v0

    new-instance v1, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old$10;->val$apiResponse:Lcom/poshmark/http/api/PMApiResponse;

    iget-object v2, v2, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v3, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->SHARE_LISTING_FACEBOOK:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    invoke-direct {v1, v2, v3}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/PMFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    .line 812
    return-void
.end method

.method public success(ILjava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "accessLevel"    # I
    .param p2, "accessToken"    # Ljava/lang/String;
    .param p3, "formattedDate"    # Ljava/lang/String;

    .prologue
    .line 786
    and-int/lit8 v0, p1, 0x8

    if-eqz v0, :cond_0

    .line 787
    sget-object v0, Lcom/poshmark/utils/ShareManager_Old$15;->$SwitchMap$com$poshmark$utils$ShareManager_Old$SHARE_MODE:[I

    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old$10;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    # getter for: Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;
    invoke-static {v1}, Lcom/poshmark/utils/ShareManager_Old;->access$900(Lcom/poshmark/utils/ShareManager_Old;)Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 807
    :cond_0
    :goto_0
    return-void

    .line 789
    :pswitch_0
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old$10;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old$10;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    # getter for: Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;
    invoke-static {v1}, Lcom/poshmark/utils/ShareManager_Old;->access$1000(Lcom/poshmark/utils/ShareManager_Old;)Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old$10;->val$message:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/poshmark/utils/ShareManager_Old;->shareListing(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;Ljava/lang/String;)V

    goto :goto_0

    .line 792
    :pswitch_1
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old$10;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old$10;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    # getter for: Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;
    invoke-static {v1}, Lcom/poshmark/utils/ShareManager_Old;->access$1000(Lcom/poshmark/utils/ShareManager_Old;)Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old$10;->val$message:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/poshmark/utils/ShareManager_Old;->shareShowroom(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;Ljava/lang/String;)V

    goto :goto_0

    .line 796
    :pswitch_2
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old$10;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old$10;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    # getter for: Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;
    invoke-static {v1}, Lcom/poshmark/utils/ShareManager_Old;->access$1000(Lcom/poshmark/utils/ShareManager_Old;)Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old$10;->val$message:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/poshmark/utils/ShareManager_Old;->shareBrand(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;Ljava/lang/String;)V

    goto :goto_0

    .line 799
    :pswitch_3
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old$10;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old$10;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    # getter for: Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;
    invoke-static {v1}, Lcom/poshmark/utils/ShareManager_Old;->access$1000(Lcom/poshmark/utils/ShareManager_Old;)Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old$10;->val$message:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/poshmark/utils/ShareManager_Old;->shareCloset(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;Ljava/lang/String;)V

    goto :goto_0

    .line 802
    :pswitch_4
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old$10;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old$10;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    # getter for: Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;
    invoke-static {v1}, Lcom/poshmark/utils/ShareManager_Old;->access$1000(Lcom/poshmark/utils/ShareManager_Old;)Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old$10;->val$message:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/poshmark/utils/ShareManager_Old;->shareParty(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;Ljava/lang/String;)V

    goto :goto_0

    .line 787
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method

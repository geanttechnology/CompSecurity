.class public Lcom/poshmark/utils/sharing/share_states/GetLocalContent;
.super Lcom/poshmark/utils/sharing/share_states/ShareState;
.source "GetLocalContent.java"


# static fields
.field public static id:Ljava/util/UUID;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 22
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    sput-object v0, Lcom/poshmark/utils/sharing/share_states/GetLocalContent;->id:Ljava/util/UUID;

    return-void
.end method

.method public constructor <init>(Lcom/poshmark/utils/sharing/StateCompletionListener;Lcom/poshmark/utils/ShareManager;)V
    .locals 0
    .param p1, "listener"    # Lcom/poshmark/utils/sharing/StateCompletionListener;
    .param p2, "shareManager"    # Lcom/poshmark/utils/ShareManager;

    .prologue
    .line 25
    invoke-direct {p0, p1, p2}, Lcom/poshmark/utils/sharing/share_states/ShareState;-><init>(Lcom/poshmark/utils/sharing/StateCompletionListener;Lcom/poshmark/utils/ShareManager;)V

    .line 26
    return-void
.end method


# virtual methods
.method public executeState()V
    .locals 8

    .prologue
    const v7, 0x7f06025d

    .line 31
    iget-object v5, p0, Lcom/poshmark/utils/sharing/share_states/GetLocalContent;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v5}, Lcom/poshmark/utils/ShareManager;->getShareType()Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    move-result-object v4

    .line 32
    .local v4, "type":Lcom/poshmark/utils/ShareManager$SHARE_TYPE;
    iget-object v5, p0, Lcom/poshmark/utils/sharing/share_states/GetLocalContent;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v5}, Lcom/poshmark/utils/ShareManager;->getShareMode()Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    move-result-object v3

    .line 33
    .local v3, "mode":Lcom/poshmark/utils/ShareManager$SHARE_MODE;
    iget-object v5, p0, Lcom/poshmark/utils/sharing/share_states/GetLocalContent;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v5}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v5

    if-eqz v5, :cond_3

    iget-object v5, p0, Lcom/poshmark/utils/sharing/share_states/GetLocalContent;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v5}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/ui/fragments/PMFragment;->isAdded()Z

    move-result v5

    if-eqz v5, :cond_3

    const/4 v1, 0x1

    .line 34
    .local v1, "isFragmentAdded":Z
    :goto_0
    sget-object v5, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_LISTING:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v3, v5, :cond_6

    .line 35
    sget-object v5, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->TM_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-eq v4, v5, :cond_0

    sget-object v5, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->TW_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v4, v5, :cond_5

    .line 37
    :cond_0
    iget-object v5, p0, Lcom/poshmark/utils/sharing/share_states/GetLocalContent;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v5}, Lcom/poshmark/utils/ShareManager;->getShareContent()Lcom/poshmark/utils/sharing/PMShareContent;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/utils/sharing/PMShareContent;->getListing()Lcom/poshmark/data_model/models/ListingSummary;

    move-result-object v2

    .line 38
    .local v2, "listingItem":Lcom/poshmark/data_model/models/ListingSummary;
    invoke-virtual {v2}, Lcom/poshmark/data_model/models/ListingSummary;->getShortURL()Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_1

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/ListingSummary;->getShortURL()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v5

    if-nez v5, :cond_4

    .line 39
    :cond_1
    if-eqz v1, :cond_2

    .line 40
    iget-object v5, p0, Lcom/poshmark/utils/sharing/share_states/GetLocalContent;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v5}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v5

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v6

    invoke-virtual {v6, v7}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/fragments/PMFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 42
    :cond_2
    invoke-virtual {v2}, Lcom/poshmark/data_model/models/ListingSummary;->getIdAsString()Ljava/lang/String;

    move-result-object v5

    new-instance v6, Lcom/poshmark/utils/sharing/share_states/GetLocalContent$1;

    invoke-direct {v6, p0, v2}, Lcom/poshmark/utils/sharing/share_states/GetLocalContent$1;-><init>(Lcom/poshmark/utils/sharing/share_states/GetLocalContent;Lcom/poshmark/data_model/models/ListingSummary;)V

    invoke-static {v5, v6}, Lcom/poshmark/http/api/PMApi;->getTinyUrlForListing(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 120
    .end local v2    # "listingItem":Lcom/poshmark/data_model/models/ListingSummary;
    :goto_1
    return-void

    .line 33
    .end local v1    # "isFragmentAdded":Z
    :cond_3
    const/4 v1, 0x0

    goto :goto_0

    .line 62
    .restart local v1    # "isFragmentAdded":Z
    .restart local v2    # "listingItem":Lcom/poshmark/data_model/models/ListingSummary;
    :cond_4
    iget-object v5, p0, Lcom/poshmark/utils/sharing/share_states/GetLocalContent;->listener:Lcom/poshmark/utils/sharing/StateCompletionListener;

    invoke-interface {v5}, Lcom/poshmark/utils/sharing/StateCompletionListener;->stateCompleted()V

    goto :goto_1

    .line 65
    .end local v2    # "listingItem":Lcom/poshmark/data_model/models/ListingSummary;
    :cond_5
    iget-object v5, p0, Lcom/poshmark/utils/sharing/share_states/GetLocalContent;->listener:Lcom/poshmark/utils/sharing/StateCompletionListener;

    invoke-interface {v5}, Lcom/poshmark/utils/sharing/StateCompletionListener;->stateCompleted()V

    goto :goto_1

    .line 67
    :cond_6
    sget-object v5, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_CLOSET:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v3, v5, :cond_a

    .line 68
    iget-object v5, p0, Lcom/poshmark/utils/sharing/share_states/GetLocalContent;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v5}, Lcom/poshmark/utils/ShareManager;->getShareContent()Lcom/poshmark/utils/sharing/PMShareContent;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/utils/sharing/PMShareContent;->getClosetShortUrl()Ljava/lang/String;

    move-result-object v0

    .line 69
    .local v0, "closetShortURL":Ljava/lang/String;
    if-eqz v0, :cond_7

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v5

    if-nez v5, :cond_9

    .line 70
    :cond_7
    if-eqz v1, :cond_8

    .line 71
    iget-object v5, p0, Lcom/poshmark/utils/sharing/share_states/GetLocalContent;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v5}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v5

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v6

    invoke-virtual {v6, v7}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/fragments/PMFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 74
    :cond_8
    iget-object v5, p0, Lcom/poshmark/utils/sharing/share_states/GetLocalContent;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v5}, Lcom/poshmark/utils/ShareManager;->getShareContent()Lcom/poshmark/utils/sharing/PMShareContent;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/utils/sharing/PMShareContent;->getUser()Lcom/poshmark/user/UserInfoDetails;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/user/UserInfoDetails;->getPMUserId()Ljava/lang/String;

    move-result-object v5

    new-instance v6, Lcom/poshmark/utils/sharing/share_states/GetLocalContent$2;

    invoke-direct {v6, p0}, Lcom/poshmark/utils/sharing/share_states/GetLocalContent$2;-><init>(Lcom/poshmark/utils/sharing/share_states/GetLocalContent;)V

    invoke-static {v5, v6}, Lcom/poshmark/http/api/PMApi;->getTinyURLForUser(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_1

    .line 94
    :cond_9
    iget-object v5, p0, Lcom/poshmark/utils/sharing/share_states/GetLocalContent;->listener:Lcom/poshmark/utils/sharing/StateCompletionListener;

    invoke-interface {v5}, Lcom/poshmark/utils/sharing/StateCompletionListener;->stateCompleted()V

    goto :goto_1

    .line 96
    .end local v0    # "closetShortURL":Ljava/lang/String;
    :cond_a
    sget-object v5, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_BRAND:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-eq v3, v5, :cond_b

    sget-object v5, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_BRAND_JUSTIN:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v3, v5, :cond_c

    .line 98
    :cond_b
    iget-object v5, p0, Lcom/poshmark/utils/sharing/share_states/GetLocalContent;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v5}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v5

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v6

    const v7, 0x7f060190

    invoke-virtual {v6, v7}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/fragments/PMFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 99
    iget-object v5, p0, Lcom/poshmark/utils/sharing/share_states/GetLocalContent;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v5}, Lcom/poshmark/utils/ShareManager;->getShareContent()Lcom/poshmark/utils/sharing/PMShareContent;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/utils/sharing/PMShareContent;->getBrand()Lcom/poshmark/data_model/models/Brand;

    move-result-object v5

    iget-object v5, v5, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    new-instance v6, Lcom/poshmark/utils/sharing/share_states/GetLocalContent$3;

    invoke-direct {v6, p0}, Lcom/poshmark/utils/sharing/share_states/GetLocalContent$3;-><init>(Lcom/poshmark/utils/sharing/share_states/GetLocalContent;)V

    invoke-static {v5, v6}, Lcom/poshmark/http/api/PMApi;->getBrandShareMessages(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto/16 :goto_1

    .line 118
    :cond_c
    iget-object v5, p0, Lcom/poshmark/utils/sharing/share_states/GetLocalContent;->listener:Lcom/poshmark/utils/sharing/StateCompletionListener;

    invoke-interface {v5}, Lcom/poshmark/utils/sharing/StateCompletionListener;->stateCompleted()V

    goto/16 :goto_1
.end method

.method public getId()Ljava/util/UUID;
    .locals 1

    .prologue
    .line 123
    sget-object v0, Lcom/poshmark/utils/sharing/share_states/GetLocalContent;->id:Ljava/util/UUID;

    return-object v0
.end method

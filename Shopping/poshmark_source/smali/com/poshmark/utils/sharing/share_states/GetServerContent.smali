.class public Lcom/poshmark/utils/sharing/share_states/GetServerContent;
.super Lcom/poshmark/utils/sharing/share_states/ShareState;
.source "GetServerContent.java"


# static fields
.field public static id:Ljava/util/UUID;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    sput-object v0, Lcom/poshmark/utils/sharing/share_states/GetServerContent;->id:Ljava/util/UUID;

    return-void
.end method

.method public constructor <init>(Lcom/poshmark/utils/sharing/StateCompletionListener;Lcom/poshmark/utils/ShareManager;)V
    .locals 0
    .param p1, "listener"    # Lcom/poshmark/utils/sharing/StateCompletionListener;
    .param p2, "shareManager"    # Lcom/poshmark/utils/ShareManager;

    .prologue
    .line 22
    invoke-direct {p0, p1, p2}, Lcom/poshmark/utils/sharing/share_states/ShareState;-><init>(Lcom/poshmark/utils/sharing/StateCompletionListener;Lcom/poshmark/utils/ShareManager;)V

    .line 23
    return-void
.end method


# virtual methods
.method public executeState()V
    .locals 6

    .prologue
    .line 35
    iget-object v3, p0, Lcom/poshmark/utils/sharing/share_states/GetServerContent;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v3}, Lcom/poshmark/utils/ShareManager;->getShareMode()Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    move-result-object v0

    .line 36
    .local v0, "mode":Lcom/poshmark/utils/ShareManager$SHARE_MODE;
    iget-object v3, p0, Lcom/poshmark/utils/sharing/share_states/GetServerContent;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v3}, Lcom/poshmark/utils/ShareManager;->getExternalShareCode()Ljava/lang/String;

    move-result-object v1

    .line 37
    .local v1, "shareCode":Ljava/lang/String;
    iget-object v3, p0, Lcom/poshmark/utils/sharing/share_states/GetServerContent;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v3}, Lcom/poshmark/utils/ShareManager;->getShareContent()Lcom/poshmark/utils/sharing/PMShareContent;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/utils/sharing/PMShareContent;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3, v1, v0}, Lcom/poshmark/utils/sharing/ShareContentHelper;->prepareGetShareMessagesEndPoint(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/utils/ShareManager$SHARE_MODE;)Ljava/lang/String;

    move-result-object v2

    .line 38
    .local v2, "url":Ljava/lang/String;
    iget-object v3, p0, Lcom/poshmark/utils/sharing/share_states/GetServerContent;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v3}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v3

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/poshmark/utils/sharing/share_states/GetServerContent;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v3}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/PMFragment;->isAdded()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 39
    iget-object v3, p0, Lcom/poshmark/utils/sharing/share_states/GetServerContent;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v3}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v3

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v4

    const v5, 0x7f060190

    invoke-virtual {v4, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/fragments/PMFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 41
    :cond_0
    new-instance v3, Lcom/poshmark/utils/sharing/share_states/GetServerContent$1;

    invoke-direct {v3, p0}, Lcom/poshmark/utils/sharing/share_states/GetServerContent$1;-><init>(Lcom/poshmark/utils/sharing/share_states/GetServerContent;)V

    invoke-static {v2, v3}, Lcom/poshmark/http/api/PMApi;->getShareMessagesFromServer(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 53
    return-void
.end method

.method public getId()Ljava/util/UUID;
    .locals 1

    .prologue
    .line 56
    sget-object v0, Lcom/poshmark/utils/sharing/share_states/GetServerContent;->id:Ljava/util/UUID;

    return-object v0
.end method

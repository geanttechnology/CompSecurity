.class public Lcom/poshmark/utils/sharing/share_states/FbDialogShare;
.super Lcom/poshmark/utils/sharing/share_states/ShareState;
.source "FbDialogShare.java"

# interfaces
.implements Lcom/poshmark/notifications/PMNotificationListener;


# static fields
.field public static id:Ljava/util/UUID;


# instance fields
.field callbackManager:Lcom/facebook/CallbackManager;

.field fbDialogCallback:Lcom/facebook/FacebookCallback;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 26
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    sput-object v0, Lcom/poshmark/utils/sharing/share_states/FbDialogShare;->id:Ljava/util/UUID;

    return-void
.end method

.method public constructor <init>(Lcom/poshmark/utils/sharing/StateCompletionListener;Lcom/poshmark/utils/ShareManager;)V
    .locals 1
    .param p1, "listener"    # Lcom/poshmark/utils/sharing/StateCompletionListener;
    .param p2, "shareManager"    # Lcom/poshmark/utils/ShareManager;

    .prologue
    .line 30
    invoke-direct {p0, p1, p2}, Lcom/poshmark/utils/sharing/share_states/ShareState;-><init>(Lcom/poshmark/utils/sharing/StateCompletionListener;Lcom/poshmark/utils/ShareManager;)V

    .line 85
    new-instance v0, Lcom/poshmark/utils/sharing/share_states/FbDialogShare$1;

    invoke-direct {v0, p0}, Lcom/poshmark/utils/sharing/share_states/FbDialogShare$1;-><init>(Lcom/poshmark/utils/sharing/share_states/FbDialogShare;)V

    iput-object v0, p0, Lcom/poshmark/utils/sharing/share_states/FbDialogShare;->fbDialogCallback:Lcom/facebook/FacebookCallback;

    .line 31
    invoke-static {}, Lcom/facebook/CallbackManager$Factory;->create()Lcom/facebook/CallbackManager;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/utils/sharing/share_states/FbDialogShare;->callbackManager:Lcom/facebook/CallbackManager;

    .line 32
    return-void
.end method


# virtual methods
.method public executeState()V
    .locals 12

    .prologue
    .line 40
    iget-object v10, p0, Lcom/poshmark/utils/sharing/share_states/FbDialogShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v10}, Lcom/poshmark/utils/ShareManager;->getShareContent()Lcom/poshmark/utils/sharing/PMShareContent;

    move-result-object v6

    .line 41
    .local v6, "pmContent":Lcom/poshmark/utils/sharing/PMShareContent;
    invoke-virtual {v6}, Lcom/poshmark/utils/sharing/PMShareContent;->getShareTitle()Ljava/lang/String;

    move-result-object v9

    .line 42
    .local v9, "title":Ljava/lang/String;
    invoke-virtual {v6}, Lcom/poshmark/utils/sharing/PMShareContent;->getShareDescription()Ljava/lang/String;

    move-result-object v1

    .line 43
    .local v1, "description":Ljava/lang/String;
    invoke-virtual {v6}, Lcom/poshmark/utils/sharing/PMShareContent;->getShareUrl()Ljava/lang/String;

    move-result-object v2

    .line 44
    .local v2, "link":Ljava/lang/String;
    invoke-virtual {v6}, Lcom/poshmark/utils/sharing/PMShareContent;->getShareMessage()Ljava/lang/String;

    move-result-object v4

    .line 45
    .local v4, "message":Ljava/lang/String;
    invoke-virtual {v6}, Lcom/poshmark/utils/sharing/PMShareContent;->getPlaceHolderString()Ljava/lang/String;

    move-result-object v5

    .line 46
    .local v5, "placeholderTxt":Ljava/lang/String;
    invoke-virtual {v6}, Lcom/poshmark/utils/sharing/PMShareContent;->getSubject()Ljava/lang/String;

    move-result-object v8

    .line 47
    .local v8, "subject":Ljava/lang/String;
    invoke-virtual {v6}, Lcom/poshmark/utils/sharing/PMShareContent;->getBody()Ljava/lang/String;

    move-result-object v0

    .line 51
    .local v0, "body":Ljava/lang/String;
    new-instance v7, Lcom/facebook/share/widget/ShareDialog;

    iget-object v10, p0, Lcom/poshmark/utils/sharing/share_states/FbDialogShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v10}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v10

    invoke-direct {v7, v10}, Lcom/facebook/share/widget/ShareDialog;-><init>(Landroid/support/v4/app/Fragment;)V

    .line 52
    .local v7, "shareDialog":Lcom/facebook/share/widget/ShareDialog;
    iget-object v10, p0, Lcom/poshmark/utils/sharing/share_states/FbDialogShare;->callbackManager:Lcom/facebook/CallbackManager;

    iget-object v11, p0, Lcom/poshmark/utils/sharing/share_states/FbDialogShare;->fbDialogCallback:Lcom/facebook/FacebookCallback;

    invoke-virtual {v7, v10, v11}, Lcom/facebook/share/widget/ShareDialog;->registerCallback(Lcom/facebook/CallbackManager;Lcom/facebook/FacebookCallback;)V

    .line 54
    const-class v10, Lcom/facebook/share/model/ShareLinkContent;

    invoke-static {v10}, Lcom/facebook/share/widget/ShareDialog;->canShow(Ljava/lang/Class;)Z

    move-result v10

    if-eqz v10, :cond_0

    .line 55
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v10

    const-string v11, "com.poshmark.intents.FBDIALOG_SHARE_RESULTS"

    invoke-virtual {v10, v11, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 56
    new-instance v10, Lcom/facebook/share/model/ShareLinkContent$Builder;

    invoke-direct {v10}, Lcom/facebook/share/model/ShareLinkContent$Builder;-><init>()V

    invoke-virtual {v10, v9}, Lcom/facebook/share/model/ShareLinkContent$Builder;->setContentTitle(Ljava/lang/String;)Lcom/facebook/share/model/ShareLinkContent$Builder;

    move-result-object v10

    invoke-virtual {v10, v1}, Lcom/facebook/share/model/ShareLinkContent$Builder;->setContentDescription(Ljava/lang/String;)Lcom/facebook/share/model/ShareLinkContent$Builder;

    move-result-object v10

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v11

    invoke-virtual {v10, v11}, Lcom/facebook/share/model/ShareLinkContent$Builder;->setContentUrl(Landroid/net/Uri;)Lcom/facebook/share/model/ShareContent$Builder;

    move-result-object v10

    check-cast v10, Lcom/facebook/share/model/ShareLinkContent$Builder;

    invoke-virtual {v10}, Lcom/facebook/share/model/ShareLinkContent$Builder;->build()Lcom/facebook/share/model/ShareLinkContent;

    move-result-object v3

    .line 62
    .local v3, "linkContent":Lcom/facebook/share/model/ShareLinkContent;
    invoke-virtual {v7, v3}, Lcom/facebook/share/widget/ShareDialog;->show(Ljava/lang/Object;)V

    .line 63
    iget-object v10, p0, Lcom/poshmark/utils/sharing/share_states/FbDialogShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    sget-object v11, Lcom/poshmark/utils/ShareManager;->EXTERNAL_SHARE_STATE_INITIALED:Ljava/lang/String;

    invoke-virtual {v10, v11}, Lcom/poshmark/utils/ShareManager;->trackExternalShareOnPM(Ljava/lang/String;)V

    .line 65
    .end local v3    # "linkContent":Lcom/facebook/share/model/ShareLinkContent;
    :cond_0
    return-void
.end method

.method public getId()Ljava/util/UUID;
    .locals 1

    .prologue
    .line 36
    sget-object v0, Lcom/poshmark/utils/sharing/share_states/FbDialogShare;->id:Ljava/util/UUID;

    return-object v0
.end method

.method public handleNotification(Landroid/content/Intent;)V
    .locals 7
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 69
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v5

    const-string v6, "com.poshmark.intents.FBDIALOG_SHARE_RESULTS"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 70
    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 71
    .local v0, "b":Landroid/os/Bundle;
    if-eqz v0, :cond_0

    .line 72
    const-string v5, "RESULT"

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v3

    .line 73
    .local v3, "result":Landroid/os/Bundle;
    if-eqz v3, :cond_0

    .line 74
    const-string v5, "REQUEST_CODE"

    invoke-virtual {v3, v5}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v2

    .line 75
    .local v2, "requestCode":I
    const-string v5, "RESULT_CODE"

    invoke-virtual {v3, v5}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v4

    .line 76
    .local v4, "resultCode":I
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 77
    .local v1, "fbIntent":Landroid/content/Intent;
    invoke-virtual {v1, v3}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 78
    iget-object v5, p0, Lcom/poshmark/utils/sharing/share_states/FbDialogShare;->callbackManager:Lcom/facebook/CallbackManager;

    invoke-interface {v5, v2, v4, v1}, Lcom/facebook/CallbackManager;->onActivityResult(IILandroid/content/Intent;)Z

    .line 83
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v1    # "fbIntent":Landroid/content/Intent;
    .end local v2    # "requestCode":I
    .end local v3    # "result":Landroid/os/Bundle;
    .end local v4    # "resultCode":I
    :cond_0
    return-void
.end method

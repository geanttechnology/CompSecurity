.class public Lcom/poshmark/utils/sharing/share_states/ServerShare;
.super Lcom/poshmark/utils/sharing/share_states/ShareState;
.source "ServerShare.java"

# interfaces
.implements Lcom/poshmark/notifications/PMNotificationListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/sharing/share_states/ServerShare$2;
    }
.end annotation


# static fields
.field public static id:Ljava/util/UUID;


# instance fields
.field apiResponseHandler:Lcom/poshmark/http/api/PMApiResponseHandler;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/poshmark/http/api/PMApiResponseHandler",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 27
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    sput-object v0, Lcom/poshmark/utils/sharing/share_states/ServerShare;->id:Ljava/util/UUID;

    return-void
.end method

.method public constructor <init>(Lcom/poshmark/utils/sharing/StateCompletionListener;Lcom/poshmark/utils/ShareManager;)V
    .locals 2
    .param p1, "listener"    # Lcom/poshmark/utils/sharing/StateCompletionListener;
    .param p2, "shareManager"    # Lcom/poshmark/utils/ShareManager;

    .prologue
    .line 30
    invoke-direct {p0, p1, p2}, Lcom/poshmark/utils/sharing/share_states/ShareState;-><init>(Lcom/poshmark/utils/sharing/StateCompletionListener;Lcom/poshmark/utils/ShareManager;)V

    .line 78
    new-instance v0, Lcom/poshmark/utils/sharing/share_states/ServerShare$1;

    invoke-direct {v0, p0}, Lcom/poshmark/utils/sharing/share_states/ServerShare$1;-><init>(Lcom/poshmark/utils/sharing/share_states/ServerShare;)V

    iput-object v0, p0, Lcom/poshmark/utils/sharing/share_states/ServerShare;->apiResponseHandler:Lcom/poshmark/http/api/PMApiResponseHandler;

    .line 31
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.MESSAGE_EDITOR_ACTION_COMPLETE"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 32
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.MESSAGE_EDITOR_ACTION_CANCELLED"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 33
    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/utils/sharing/share_states/ServerShare;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/utils/sharing/share_states/ServerShare;

    .prologue
    .line 26
    invoke-direct {p0}, Lcom/poshmark/utils/sharing/share_states/ServerShare;->deRegisterListeners()V

    return-void
.end method

.method private deRegisterListeners()V
    .locals 1

    .prologue
    .line 75
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/poshmark/notifications/PMNotificationManager;->unregisterAllEvents(Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 76
    return-void
.end method

.method private fireShare()V
    .locals 6

    .prologue
    .line 45
    iget-object v2, p0, Lcom/poshmark/utils/sharing/share_states/ServerShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v2}, Lcom/poshmark/utils/ShareManager;->getShareContent()Lcom/poshmark/utils/sharing/PMShareContent;

    move-result-object v0

    .line 46
    .local v0, "content":Lcom/poshmark/utils/sharing/PMShareContent;
    iget-object v2, p0, Lcom/poshmark/utils/sharing/share_states/ServerShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v2}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/PMFragment;->getParentActivity()Lcom/poshmark/ui/PMActivity;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/ui/PMActivity;->isActivityInForeground()Z

    move-result v1

    .line 47
    .local v1, "isActivityForeground":Z
    if-eqz v1, :cond_0

    .line 48
    iget-object v2, p0, Lcom/poshmark/utils/sharing/share_states/ServerShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v2}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v2

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v3

    const v4, 0x7f06025d

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/PMFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 50
    :cond_0
    sget-object v2, Lcom/poshmark/utils/sharing/share_states/ServerShare$2;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE:[I

    iget-object v3, p0, Lcom/poshmark/utils/sharing/share_states/ServerShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v3}, Lcom/poshmark/utils/ShareManager;->getShareMode()Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    .line 72
    :goto_0
    return-void

    .line 52
    :pswitch_0
    invoke-virtual {v0}, Lcom/poshmark/utils/sharing/PMShareContent;->getId()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/utils/sharing/share_states/ServerShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v3}, Lcom/poshmark/utils/ShareManager;->getExternalShareCode()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/poshmark/utils/sharing/share_states/ServerShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v4}, Lcom/poshmark/utils/ShareManager;->getShareContent()Lcom/poshmark/utils/sharing/PMShareContent;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/utils/sharing/PMShareContent;->getFinalSharingMessage()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/poshmark/utils/sharing/share_states/ServerShare;->apiResponseHandler:Lcom/poshmark/http/api/PMApiResponseHandler;

    invoke-static {v2, v3, v4, v5}, Lcom/poshmark/http/api/PMApi;->shareListingToExternalService(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0

    .line 55
    :pswitch_1
    invoke-virtual {v0}, Lcom/poshmark/utils/sharing/PMShareContent;->getBrand()Lcom/poshmark/data_model/models/Brand;

    move-result-object v2

    iget-object v2, v2, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    iget-object v3, p0, Lcom/poshmark/utils/sharing/share_states/ServerShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v3}, Lcom/poshmark/utils/ShareManager;->getExternalShareCode()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/poshmark/utils/sharing/share_states/ServerShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v4}, Lcom/poshmark/utils/ShareManager;->getShareContent()Lcom/poshmark/utils/sharing/PMShareContent;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/utils/sharing/PMShareContent;->getFinalSharingMessage()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/poshmark/utils/sharing/share_states/ServerShare;->apiResponseHandler:Lcom/poshmark/http/api/PMApiResponseHandler;

    invoke-static {v2, v3, v4, v5}, Lcom/poshmark/http/api/PMApi;->shareBrandToExternalService(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0

    .line 58
    :pswitch_2
    invoke-virtual {v0}, Lcom/poshmark/utils/sharing/PMShareContent;->getId()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/utils/sharing/share_states/ServerShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v3}, Lcom/poshmark/utils/ShareManager;->getExternalShareCode()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/poshmark/utils/sharing/share_states/ServerShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v4}, Lcom/poshmark/utils/ShareManager;->getShareContent()Lcom/poshmark/utils/sharing/PMShareContent;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/utils/sharing/PMShareContent;->getFinalSharingMessage()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/poshmark/utils/sharing/share_states/ServerShare;->apiResponseHandler:Lcom/poshmark/http/api/PMApiResponseHandler;

    invoke-static {v2, v3, v4, v5}, Lcom/poshmark/http/api/PMApi;->shareShowroom(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0

    .line 62
    :pswitch_3
    const/4 v2, 0x0

    iget-object v3, p0, Lcom/poshmark/utils/sharing/share_states/ServerShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v3}, Lcom/poshmark/utils/ShareManager;->getShareContent()Lcom/poshmark/utils/sharing/PMShareContent;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/utils/sharing/PMShareContent;->getFinalSharingMessage()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/poshmark/utils/sharing/share_states/ServerShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v4}, Lcom/poshmark/utils/ShareManager;->getExternalShareCode()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/poshmark/utils/sharing/share_states/ServerShare;->apiResponseHandler:Lcom/poshmark/http/api/PMApiResponseHandler;

    invoke-static {v2, v3, v4, v5}, Lcom/poshmark/http/api/PMApi;->inviteFriends(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0

    .line 65
    :pswitch_4
    invoke-virtual {v0}, Lcom/poshmark/utils/sharing/PMShareContent;->getId()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/utils/sharing/share_states/ServerShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v3}, Lcom/poshmark/utils/ShareManager;->getExternalShareCode()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/poshmark/utils/sharing/share_states/ServerShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v4}, Lcom/poshmark/utils/ShareManager;->getShareContent()Lcom/poshmark/utils/sharing/PMShareContent;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/utils/sharing/PMShareContent;->getFinalSharingMessage()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/poshmark/utils/sharing/share_states/ServerShare;->apiResponseHandler:Lcom/poshmark/http/api/PMApiResponseHandler;

    invoke-static {v2, v3, v4, v5}, Lcom/poshmark/http/api/PMApi;->shareCloset(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto/16 :goto_0

    .line 68
    :pswitch_5
    invoke-virtual {v0}, Lcom/poshmark/utils/sharing/PMShareContent;->getId()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/utils/sharing/share_states/ServerShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v3}, Lcom/poshmark/utils/ShareManager;->getExternalShareCode()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/poshmark/utils/sharing/share_states/ServerShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v4}, Lcom/poshmark/utils/ShareManager;->getShareContent()Lcom/poshmark/utils/sharing/PMShareContent;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/utils/sharing/PMShareContent;->getFinalSharingMessage()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/poshmark/utils/sharing/share_states/ServerShare;->apiResponseHandler:Lcom/poshmark/http/api/PMApiResponseHandler;

    invoke-static {v2, v3, v4, v5}, Lcom/poshmark/http/api/PMApi;->shareEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto/16 :goto_0

    .line 50
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
    .end packed-switch
.end method


# virtual methods
.method public executeState()V
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/ServerShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager;->getUserMessage()V

    .line 42
    return-void
.end method

.method public getId()Ljava/util/UUID;
    .locals 1

    .prologue
    .line 37
    sget-object v0, Lcom/poshmark/utils/sharing/share_states/ServerShare;->id:Ljava/util/UUID;

    return-object v0
.end method

.method public handleNotification(Landroid/content/Intent;)V
    .locals 5
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 103
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v2

    const-string v3, "com.poshmark.intents.MESSAGE_EDITOR_ACTION_COMPLETE"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 104
    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 105
    .local v0, "b":Landroid/os/Bundle;
    if-eqz v0, :cond_0

    .line 106
    const-string v2, "RESULT"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    .line 107
    .local v1, "result":Landroid/os/Bundle;
    if-eqz v1, :cond_0

    .line 108
    iget-object v2, p0, Lcom/poshmark/utils/sharing/share_states/ServerShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v2}, Lcom/poshmark/utils/ShareManager;->getShareContent()Lcom/poshmark/utils/sharing/PMShareContent;

    move-result-object v2

    const-string v3, "MESSAGE"

    const-string v4, ""

    invoke-virtual {v1, v3, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/poshmark/utils/sharing/PMShareContent;->addFinalSharingMessage(Ljava/lang/String;)V

    .line 109
    invoke-direct {p0}, Lcom/poshmark/utils/sharing/share_states/ServerShare;->fireShare()V

    .line 116
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v1    # "result":Landroid/os/Bundle;
    :cond_0
    :goto_0
    return-void

    .line 112
    :cond_1
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v2

    const-string v3, "com.poshmark.intents.MESSAGE_EDITOR_ACTION_CANCELLED"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 113
    invoke-direct {p0}, Lcom/poshmark/utils/sharing/share_states/ServerShare;->deRegisterListeners()V

    .line 114
    iget-object v2, p0, Lcom/poshmark/utils/sharing/share_states/ServerShare;->listener:Lcom/poshmark/utils/sharing/StateCompletionListener;

    invoke-interface {v2}, Lcom/poshmark/utils/sharing/StateCompletionListener;->stateFailed()V

    goto :goto_0
.end method

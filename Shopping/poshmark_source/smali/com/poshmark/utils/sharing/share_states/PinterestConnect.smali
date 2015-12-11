.class public Lcom/poshmark/utils/sharing/share_states/PinterestConnect;
.super Lcom/poshmark/utils/sharing/share_states/ShareState;
.source "PinterestConnect.java"

# interfaces
.implements Lcom/poshmark/notifications/PMNotificationListener;


# static fields
.field public static id:Ljava/util/UUID;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 29
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    sput-object v0, Lcom/poshmark/utils/sharing/share_states/PinterestConnect;->id:Ljava/util/UUID;

    return-void
.end method

.method public constructor <init>(Lcom/poshmark/utils/sharing/StateCompletionListener;Lcom/poshmark/utils/ShareManager;)V
    .locals 2
    .param p1, "listener"    # Lcom/poshmark/utils/sharing/StateCompletionListener;
    .param p2, "shareManager"    # Lcom/poshmark/utils/ShareManager;

    .prologue
    .line 32
    invoke-direct {p0, p1, p2}, Lcom/poshmark/utils/sharing/share_states/ShareState;-><init>(Lcom/poshmark/utils/sharing/StateCompletionListener;Lcom/poshmark/utils/ShareManager;)V

    .line 33
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.PINTEREST_FIRST_TIME_DIALOG_BACK"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 34
    return-void
.end method

.method private deRegisterListeners()V
    .locals 1

    .prologue
    .line 94
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/poshmark/notifications/PMNotificationManager;->unregisterAllEvents(Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 95
    return-void
.end method


# virtual methods
.method public executeState()V
    .locals 10

    .prologue
    .line 36
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v5

    iget-object v6, p0, Lcom/poshmark/utils/sharing/share_states/PinterestConnect;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v6}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v6

    invoke-virtual {v6}, Lcom/poshmark/ui/fragments/PMFragment;->getViewNameForAnalytics()Ljava/lang/String;

    move-result-object v6

    const-string v7, "user"

    const-string v8, "connect_pinterest_initiated"

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v9

    invoke-virtual {v9}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v5, v6, v7, v8, v9}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 37
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->isPinterestPreDialogShown()Z

    move-result v3

    .line 38
    .local v3, "isPreDiallogShown":Z
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getPinterestToken()Ljava/lang/String;

    move-result-object v4

    .line 39
    .local v4, "pinterestToken":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/utils/FeatureManager;->getGlobalFeatureManager()Lcom/poshmark/utils/FeatureManager;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/utils/FeatureManager;->isPinterestButtonEnabled()Z

    move-result v2

    .line 40
    .local v2, "isPinterestEnabled":Z
    if-eqz v2, :cond_0

    if-nez v3, :cond_0

    if-nez v4, :cond_0

    .line 41
    iget-object v5, p0, Lcom/poshmark/utils/sharing/share_states/PinterestConnect;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v5}, Lcom/poshmark/utils/ShareManager;->getFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v1

    .line 42
    .local v1, "fragment":Lcom/poshmark/ui/fragments/PMFragment;
    new-instance v0, Lcom/poshmark/utils/view_holders/PinterestDialog;

    invoke-direct {v0}, Lcom/poshmark/utils/view_holders/PinterestDialog;-><init>()V

    .line 43
    .local v0, "dialog":Lcom/poshmark/utils/view_holders/PinterestDialog;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v5

    const-string v6, "pre_connect_pinterest_dlg_screen"

    invoke-virtual {v5, v6}, Lcom/poshmark/analytics/Analytics;->trackView(Ljava/lang/String;)V

    .line 44
    sget-object v5, Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;->PRE_CONN:Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;

    invoke-virtual {v0, v5}, Lcom/poshmark/utils/view_holders/PinterestDialog;->setCurrent_mode(Lcom/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE;)V

    .line 45
    new-instance v5, Lcom/poshmark/utils/sharing/share_states/PinterestConnect$1;

    invoke-direct {v5, p0, v1, v0}, Lcom/poshmark/utils/sharing/share_states/PinterestConnect$1;-><init>(Lcom/poshmark/utils/sharing/share_states/PinterestConnect;Lcom/poshmark/ui/fragments/PMFragment;Lcom/poshmark/utils/view_holders/PinterestDialog;)V

    invoke-virtual {v0, v5}, Lcom/poshmark/utils/view_holders/PinterestDialog;->setClickListener(Landroid/view/View$OnClickListener;)V

    .line 72
    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/PMFragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v5

    const-string v6, "pn"

    invoke-virtual {v0, v5, v6}, Lcom/poshmark/utils/view_holders/PinterestDialog;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 73
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    const/4 v6, 0x1

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/poshmark/application/PMApplicationSession;->setPinterestPreDialogShownFlag(Ljava/lang/Boolean;)V

    .line 77
    .end local v0    # "dialog":Lcom/poshmark/utils/view_holders/PinterestDialog;
    .end local v1    # "fragment":Lcom/poshmark/ui/fragments/PMFragment;
    :goto_0
    return-void

    .line 75
    :cond_0
    iget-object v5, p0, Lcom/poshmark/utils/sharing/share_states/PinterestConnect;->listener:Lcom/poshmark/utils/sharing/StateCompletionListener;

    invoke-interface {v5}, Lcom/poshmark/utils/sharing/StateCompletionListener;->stateCompleted()V

    goto :goto_0
.end method

.method public getId()Ljava/util/UUID;
    .locals 1

    .prologue
    .line 82
    sget-object v0, Lcom/poshmark/utils/sharing/share_states/PinterestConnect;->id:Ljava/util/UUID;

    return-object v0
.end method

.method public handleNotification(Landroid/content/Intent;)V
    .locals 2
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 87
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.poshmark.intents.PINTEREST_FIRST_TIME_DIALOG_BACK"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 88
    invoke-direct {p0}, Lcom/poshmark/utils/sharing/share_states/PinterestConnect;->deRegisterListeners()V

    .line 89
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/PinterestConnect;->listener:Lcom/poshmark/utils/sharing/StateCompletionListener;

    invoke-interface {v0}, Lcom/poshmark/utils/sharing/StateCompletionListener;->stateFailed()V

    .line 91
    :cond_0
    return-void
.end method

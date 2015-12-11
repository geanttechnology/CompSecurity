.class public Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;
.super Landroid/support/v4/app/Fragment;
.source "SourceFile"


# static fields
.field private static pendingAnnounce:Z


# instance fields
.field private callback:Lcom/facebook/Session$StatusCallback;

.field public checkLoginType:I

.field public loginButton:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

.field private uiHelper:Lcom/facebook/UiLifecycleHelper;

.field v:Landroid/view/View;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 30
    const/4 v0, 0x0

    sput-boolean v0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->pendingAnnounce:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 23
    invoke-direct {p0}, Landroid/support/v4/app/Fragment;-><init>()V

    .line 26
    const/4 v0, 0x1

    iput v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->checkLoginType:I

    .line 31
    new-instance v0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment$1;

    invoke-direct {v0, p0}, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment$1;-><init>(Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;)V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->callback:Lcom/facebook/Session$StatusCallback;

    return-void
.end method

.method static synthetic access$000(Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;Lcom/facebook/Session;Lcom/facebook/SessionState;Ljava/lang/Exception;)V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0, p1, p2, p3}, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->onSessionStateChange(Lcom/facebook/Session;Lcom/facebook/SessionState;Ljava/lang/Exception;)V

    return-void
.end method

.method private onSessionStateChange(Lcom/facebook/Session;Lcom/facebook/SessionState;Ljava/lang/Exception;)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 111
    invoke-virtual {p2}, Lcom/facebook/SessionState;->isOpened()Z

    move-result v0

    if-eqz v0, :cond_1

    sget-boolean v0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->pendingAnnounce:Z

    if-nez v0, :cond_1

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-boolean v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->isLogIn:Z

    if-nez v0, :cond_1

    .line 112
    sput-boolean v3, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->pendingAnnounce:Z

    .line 113
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {p1}, Lcom/facebook/Session;->getAccessToken()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putFacebookToken(Landroid/content/Context;Ljava/lang/String;)V

    .line 114
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080074

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, v3}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    .line 115
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const/4 v1, 0x0

    invoke-static {v0, p1, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->laterLoginInit(Landroid/content/Context;Lcom/facebook/Session;Landroid/os/Bundle;)V

    .line 116
    const-string v0, "SESSION IS OPEN"

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->logMsg(Ljava/lang/String;)V

    .line 120
    :cond_0
    :goto_0
    return-void

    .line 117
    :cond_1
    invoke-virtual {p2}, Lcom/facebook/SessionState;->isClosed()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 118
    const-string v0, "SESSION IS NOT OPEN"

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->logMsg(Ljava/lang/String;)V

    goto :goto_0
.end method


# virtual methods
.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 2

    .prologue
    .line 124
    invoke-super {p0, p1, p2, p3}, Landroid/support/v4/app/Fragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 125
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->uiHelper:Lcom/facebook/UiLifecycleHelper;

    invoke-virtual {v0, p1, p2, p3}, Lcom/facebook/UiLifecycleHelper;->onActivityResult(IILandroid/content/Intent;)V

    .line 126
    invoke-static {}, Lcom/facebook/Session;->getActiveSession()Lcom/facebook/Session;

    move-result-object v0

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v0, v1, p1, p2, p3}, Lcom/facebook/Session;->onActivityResult(Landroid/app/Activity;IILandroid/content/Intent;)Z

    .line 127
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 40
    invoke-super {p0, p1}, Landroid/support/v4/app/Fragment;->onCreate(Landroid/os/Bundle;)V

    .line 41
    const/4 v0, 0x1

    iput v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->checkLoginType:I

    .line 42
    new-instance v0, Lcom/facebook/UiLifecycleHelper;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->callback:Lcom/facebook/Session$StatusCallback;

    invoke-direct {v0, v1, v2}, Lcom/facebook/UiLifecycleHelper;-><init>(Landroid/app/Activity;Lcom/facebook/Session$StatusCallback;)V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->uiHelper:Lcom/facebook/UiLifecycleHelper;

    .line 43
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->uiHelper:Lcom/facebook/UiLifecycleHelper;

    invoke-virtual {v0, p1}, Lcom/facebook/UiLifecycleHelper;->onCreate(Landroid/os/Bundle;)V

    .line 44
    const/4 v0, 0x0

    sput-boolean v0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->pendingAnnounce:Z

    .line 45
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 6

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 49
    const v0, 0x7f030035

    invoke-virtual {p1, v0, p2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->v:Landroid/view/View;

    .line 50
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->v:Landroid/view/View;

    const v1, 0x7f070090

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->loginButton:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    .line 51
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->loginButton:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    invoke-virtual {v0, p0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->setFragment(Landroid/support/v4/app/Fragment;)V

    .line 52
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->loginButton:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    const/4 v1, 0x3

    new-array v1, v1, [Ljava/lang/String;

    const-string v2, "user_likes"

    aput-object v2, v1, v4

    const-string v2, "email"

    aput-object v2, v1, v5

    const/4 v2, 0x2

    const-string v3, "read_stream"

    aput-object v3, v1, v2

    invoke-static {v1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->setReadPermissions(Ljava/util/List;)V

    .line 54
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->loginButton:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    new-instance v1, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment$2;

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->loginButton:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    invoke-virtual {v2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    invoke-direct {v1, p0, v2}, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment$2;-><init>(Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;)V

    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 71
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-boolean v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldLogin:Z

    if-eqz v0, :cond_0

    .line 72
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iput-boolean v4, v0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldLogin:Z

    .line 73
    iput v4, p0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->checkLoginType:I

    .line 74
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iput-boolean v5, v0, Lcom/mixerbox/mixerbox3b/MainPage;->canPlay:Z

    .line 75
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->loginButton:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->performClick()Z

    .line 78
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->v:Landroid/view/View;

    return-object v0
.end method

.method public onDestroy()V
    .locals 1

    .prologue
    .line 106
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onDestroy()V

    .line 107
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->uiHelper:Lcom/facebook/UiLifecycleHelper;

    invoke-virtual {v0}, Lcom/facebook/UiLifecycleHelper;->onDestroy()V

    .line 108
    return-void
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 100
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onPause()V

    .line 101
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->uiHelper:Lcom/facebook/UiLifecycleHelper;

    invoke-virtual {v0}, Lcom/facebook/UiLifecycleHelper;->onPause()V

    .line 102
    return-void
.end method

.method public onResume()V
    .locals 3

    .prologue
    .line 83
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onResume()V

    .line 84
    invoke-static {}, Lcom/facebook/Session;->getActiveSession()Lcom/facebook/Session;

    move-result-object v0

    .line 85
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/facebook/Session;->isOpened()Z

    move-result v1

    if-nez v1, :cond_0

    invoke-virtual {v0}, Lcom/facebook/Session;->isClosed()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 87
    :cond_0
    invoke-virtual {v0}, Lcom/facebook/Session;->getState()Lcom/facebook/SessionState;

    move-result-object v1

    const/4 v2, 0x0

    invoke-direct {p0, v0, v1, v2}, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->onSessionStateChange(Lcom/facebook/Session;Lcom/facebook/SessionState;Ljava/lang/Exception;)V

    .line 89
    :cond_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->uiHelper:Lcom/facebook/UiLifecycleHelper;

    invoke-virtual {v0}, Lcom/facebook/UiLifecycleHelper;->onResume()V

    .line 90
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 94
    invoke-super {p0, p1}, Landroid/support/v4/app/Fragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 95
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->uiHelper:Lcom/facebook/UiLifecycleHelper;

    invoke-virtual {v0, p1}, Lcom/facebook/UiLifecycleHelper;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 96
    return-void
.end method

.class Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;)V
    .locals 0

    .prologue
    .line 86
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 88
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;->type:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_1

    .line 89
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 90
    const-string v1, "action"

    const-string v2, "tabPlaylists"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 91
    const-string v1, "action:login_aft_ask"

    invoke-static {v1, v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    .line 124
    :goto_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->rlVideoPlayer:Landroid/widget/RelativeLayout;

    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    .line 125
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iput-boolean v3, v0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldSendNoti:Z

    .line 126
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->closePlayer()V

    .line 129
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentSignUp:Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;

    iput v3, v0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->checkLoginType:I

    .line 130
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentSignUp:Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->loginButton:Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;->performClick()Z

    .line 131
    return-void

    .line 93
    :cond_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;->type:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_2

    .line 94
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 95
    const-string v1, "action"

    const-string v2, "addMusic"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 96
    const-string v1, "action:login_aft_ask"

    invoke-static {v1, v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    goto :goto_0

    .line 98
    :cond_2
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;->type:I

    const/4 v1, 0x3

    if-ne v0, v1, :cond_3

    .line 99
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 100
    const-string v1, "action"

    const-string v2, "createAutoPlaylist"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 101
    const-string v1, "action:login_aft_ask"

    invoke-static {v1, v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    goto :goto_0

    .line 103
    :cond_3
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;->type:I

    const/4 v1, 0x4

    if-ne v0, v1, :cond_4

    .line 104
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 105
    const-string v1, "action"

    const-string v2, "subsOverDefault"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 106
    const-string v1, "action:login_aft_ask"

    invoke-static {v1, v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    goto/16 :goto_0

    .line 108
    :cond_4
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;->type:I

    const/16 v1, 0x8

    if-ne v0, v1, :cond_5

    .line 109
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 110
    const-string v1, "action"

    const-string v2, "shareLocalPlaylist"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 111
    const-string v1, "action:login_aft_ask"

    invoke-static {v1, v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    goto/16 :goto_0

    .line 113
    :cond_5
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/dialogs/LoginDialog;->type:I

    const/16 v1, 0x9

    if-ne v0, v1, :cond_6

    .line 114
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 115
    const-string v1, "action"

    const-string v2, "followDJ"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 116
    const-string v1, "action:login_aft_ask"

    invoke-static {v1, v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    goto/16 :goto_0

    .line 119
    :cond_6
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 120
    const-string v1, "action"

    const-string v2, "createPlaylist"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 121
    const-string v1, "action:login_aft_ask"

    invoke-static {v1, v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    goto/16 :goto_0
.end method

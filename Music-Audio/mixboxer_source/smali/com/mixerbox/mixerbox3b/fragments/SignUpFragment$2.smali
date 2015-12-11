.class Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment$2;
.super Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginClickListener;
.source "SourceFile"


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;)V
    .locals 0

    .prologue
    .line 54
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;

    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    invoke-direct {p0, p2}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginClickListener;-><init>(Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton;)V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 57
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iput-boolean v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->canSetLocalNotification:Z

    .line 59
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iput-boolean v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldSendNoti:Z

    .line 60
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iput-boolean v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldPlayAfterReady:Z

    .line 61
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->closePlayer()V

    .line 63
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->checkLoginType:I

    if-ne v0, v2, :cond_0

    .line 64
    const-string v0, "action:djs_page_login"

    invoke-static {v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;)V

    .line 66
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment$2;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;

    iput v2, v0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;->checkLoginType:I

    .line 67
    invoke-super {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MyFbLoginButton$LoginClickListener;->onClick(Landroid/view/View;)V

    .line 68
    return-void
.end method

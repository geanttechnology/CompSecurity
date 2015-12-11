.class Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;)V
    .locals 0

    .prologue
    .line 48
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog$2;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 2

    .prologue
    .line 50
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog$2;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;)Landroid/content/Context;

    move-result-object v0

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putOnboardingFinish(Landroid/content/Context;Z)V

    .line 51
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog$2;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/OnboardingLoginDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->onboardingPlayMusic()V

    .line 52
    return-void
.end method

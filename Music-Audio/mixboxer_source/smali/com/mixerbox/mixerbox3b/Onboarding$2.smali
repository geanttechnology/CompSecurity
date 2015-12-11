.class Lcom/mixerbox/mixerbox3b/Onboarding$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/Onboarding;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/Onboarding;)V
    .locals 0

    .prologue
    .line 216
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/Onboarding$2;->this$0:Lcom/mixerbox/mixerbox3b/Onboarding;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 219
    const-string v0, "action_onboarding_skip"

    invoke-static {v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;)V

    .line 220
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/Onboarding$2;->this$0:Lcom/mixerbox/mixerbox3b/Onboarding;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/Onboarding;->goToMainPage()V

    .line 221
    return-void
.end method

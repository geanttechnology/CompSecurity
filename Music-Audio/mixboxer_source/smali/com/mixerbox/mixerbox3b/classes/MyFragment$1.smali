.class Lcom/mixerbox/mixerbox3b/classes/MyFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/classes/MyFragment;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/classes/MyFragment;)V
    .locals 0

    .prologue
    .line 75
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/classes/MyFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/classes/MyFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MyFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/classes/MyFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/MyFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/Onboarding;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/Onboarding;->goToMainPage()V

    .line 79
    return-void
.end method

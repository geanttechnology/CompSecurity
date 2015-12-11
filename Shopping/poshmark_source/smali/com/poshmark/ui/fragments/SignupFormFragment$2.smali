.class Lcom/poshmark/ui/fragments/SignupFormFragment$2;
.super Landroid/text/style/ClickableSpan;
.source "SignupFormFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/SignupFormFragment;->displayForm()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/SignupFormFragment;)V
    .locals 0

    .prologue
    .line 266
    iput-object p1, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$2;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    invoke-direct {p0}, Landroid/text/style/ClickableSpan;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 270
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SignupFormFragment$2;->this$0:Lcom/poshmark/ui/fragments/SignupFormFragment;

    const-string v1, "/mapp/privacy_policy"

    const-string v2, "privacy_policy_screen"

    # invokes: Lcom/poshmark/ui/fragments/SignupFormFragment;->launchUrl(Ljava/lang/String;Ljava/lang/String;)V
    invoke-static {v0, v1, v2}, Lcom/poshmark/ui/fragments/SignupFormFragment;->access$000(Lcom/poshmark/ui/fragments/SignupFormFragment;Ljava/lang/String;Ljava/lang/String;)V

    .line 271
    return-void
.end method

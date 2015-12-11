.class Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity$1;
.super Ljava/lang/Object;
.source "ExternalLinkPromptActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity;

.field final synthetic val$url:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity;Ljava/lang/String;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity$1;->this$0:Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity;

    iput-object p2, p0, Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity$1;->val$url:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 3
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 37
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 38
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    iget-object v2, p0, Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity$1;->val$url:Ljava/lang/String;

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 39
    .local v0, "intent":Landroid/content/Intent;
    iget-object v1, p0, Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity$1;->this$0:Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity;

    invoke-virtual {v1, v0}, Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity;->startActivity(Landroid/content/Intent;)V

    .line 40
    iget-object v1, p0, Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity$1;->this$0:Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity;

    invoke-virtual {v1}, Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity;->finish()V

    .line 41
    return-void
.end method

.class Lcom/poshmark/ui/fragments/MessageEditorFragment$1;
.super Ljava/lang/Object;
.source "MessageEditorFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/MessageEditorFragment;->setupActionBar()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/MessageEditorFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/MessageEditorFragment;)V
    .locals 0

    .prologue
    .line 59
    iput-object p1, p0, Lcom/poshmark/ui/fragments/MessageEditorFragment$1;->this$0:Lcom/poshmark/ui/fragments/MessageEditorFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 62
    iget-object v4, p0, Lcom/poshmark/ui/fragments/MessageEditorFragment$1;->this$0:Lcom/poshmark/ui/fragments/MessageEditorFragment;

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/MessageEditorFragment;->hideKeyboard()V

    .line 63
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 64
    .local v0, "b":Landroid/os/Bundle;
    iget-object v4, p0, Lcom/poshmark/ui/fragments/MessageEditorFragment$1;->this$0:Lcom/poshmark/ui/fragments/MessageEditorFragment;

    # getter for: Lcom/poshmark/ui/fragments/MessageEditorFragment;->messageEditor:Lcom/poshmark/ui/customviews/PMEditText;
    invoke-static {v4}, Lcom/poshmark/ui/fragments/MessageEditorFragment;->access$000(Lcom/poshmark/ui/fragments/MessageEditorFragment;)Lcom/poshmark/ui/customviews/PMEditText;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/ui/customviews/PMEditText;->getText()Landroid/text/Editable;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    if-lez v4, :cond_0

    .line 65
    const-string v4, "MESSAGE"

    iget-object v5, p0, Lcom/poshmark/ui/fragments/MessageEditorFragment$1;->this$0:Lcom/poshmark/ui/fragments/MessageEditorFragment;

    # getter for: Lcom/poshmark/ui/fragments/MessageEditorFragment;->messageEditor:Lcom/poshmark/ui/customviews/PMEditText;
    invoke-static {v5}, Lcom/poshmark/ui/fragments/MessageEditorFragment;->access$000(Lcom/poshmark/ui/fragments/MessageEditorFragment;)Lcom/poshmark/ui/customviews/PMEditText;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/ui/customviews/PMEditText;->getText()Landroid/text/Editable;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v4, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 69
    :goto_0
    iget-object v4, p0, Lcom/poshmark/ui/fragments/MessageEditorFragment$1;->this$0:Lcom/poshmark/ui/fragments/MessageEditorFragment;

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/MessageEditorFragment;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/fragments/PMFragment;

    .line 70
    .local v1, "callingFragment":Lcom/poshmark/ui/fragments/PMFragment;
    if-eqz v1, :cond_1

    .line 71
    iget-object v4, p0, Lcom/poshmark/ui/fragments/MessageEditorFragment$1;->this$0:Lcom/poshmark/ui/fragments/MessageEditorFragment;

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/MessageEditorFragment;->getTargetRequestCode()I

    move-result v3

    .line 72
    .local v3, "requestCode":I
    invoke-virtual {v1, v0, v3}, Lcom/poshmark/ui/fragments/PMFragment;->onFragmentResult(Landroid/os/Bundle;I)V

    .line 79
    .end local v3    # "requestCode":I
    :goto_1
    const-string v4, "com.poshmark.intents.MESSAGE_EDITOR_ACTION_COMPLETE"

    invoke-static {v4, v0}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 80
    return-void

    .line 67
    .end local v1    # "callingFragment":Lcom/poshmark/ui/fragments/PMFragment;
    :cond_0
    const-string v4, "MESSAGE"

    const-string v5, ""

    invoke-virtual {v0, v4, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 74
    .restart local v1    # "callingFragment":Lcom/poshmark/ui/fragments/PMFragment;
    :cond_1
    new-instance v2, Landroid/content/Intent;

    invoke-direct {v2}, Landroid/content/Intent;-><init>()V

    .line 75
    .local v2, "intent":Landroid/content/Intent;
    invoke-virtual {v2, v0}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 76
    iget-object v4, p0, Lcom/poshmark/ui/fragments/MessageEditorFragment$1;->this$0:Lcom/poshmark/ui/fragments/MessageEditorFragment;

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/MessageEditorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    const/4 v5, -0x1

    invoke-virtual {v4, v5, v2}, Landroid/support/v4/app/FragmentActivity;->setResult(ILandroid/content/Intent;)V

    goto :goto_1
.end method

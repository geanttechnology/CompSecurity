.class Lcom/poshmark/ui/fragments/EmailLoginFragment$2;
.super Ljava/lang/Object;
.source "EmailLoginFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/EmailLoginFragment;->onActivityCreated(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/EmailLoginFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/EmailLoginFragment;)V
    .locals 0

    .prologue
    .line 77
    iput-object p1, p0, Lcom/poshmark/ui/fragments/EmailLoginFragment$2;->this$0:Lcom/poshmark/ui/fragments/EmailLoginFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 80
    const-string v1, "https://www.poshmark.com/user/password/reset"

    .line 81
    .local v1, "url":Ljava/lang/String;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/EmailLoginFragment$2;->this$0:Lcom/poshmark/ui/fragments/EmailLoginFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/EmailLoginFragment;->userHandleEditText:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMEditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_0

    .line 82
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "?username="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/ui/fragments/EmailLoginFragment$2;->this$0:Lcom/poshmark/ui/fragments/EmailLoginFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/EmailLoginFragment;->userHandleEditText:Lcom/poshmark/ui/customviews/PMEditText;

    invoke-virtual {v3}, Lcom/poshmark/ui/customviews/PMEditText;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 84
    :cond_0
    new-instance v0, Landroid/content/Intent;

    const-string v2, "android.intent.action.VIEW"

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    invoke-direct {v0, v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 85
    .local v0, "browserIntent":Landroid/content/Intent;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/EmailLoginFragment$2;->this$0:Lcom/poshmark/ui/fragments/EmailLoginFragment;

    invoke-virtual {v2, v0}, Lcom/poshmark/ui/fragments/EmailLoginFragment;->startActivity(Landroid/content/Intent;)V

    .line 86
    return-void
.end method

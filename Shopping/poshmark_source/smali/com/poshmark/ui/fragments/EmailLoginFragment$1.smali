.class Lcom/poshmark/ui/fragments/EmailLoginFragment$1;
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
    .line 68
    iput-object p1, p0, Lcom/poshmark/ui/fragments/EmailLoginFragment$1;->this$0:Lcom/poshmark/ui/fragments/EmailLoginFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 72
    iget-object v0, p0, Lcom/poshmark/ui/fragments/EmailLoginFragment$1;->this$0:Lcom/poshmark/ui/fragments/EmailLoginFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/EmailLoginFragment;->onLoginClicked()V

    .line 73
    return-void
.end method

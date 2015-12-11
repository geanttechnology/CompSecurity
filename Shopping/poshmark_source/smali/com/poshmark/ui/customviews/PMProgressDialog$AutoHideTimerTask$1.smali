.class Lcom/poshmark/ui/customviews/PMProgressDialog$AutoHideTimerTask$1;
.super Ljava/lang/Object;
.source "PMProgressDialog.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/customviews/PMProgressDialog$AutoHideTimerTask;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/poshmark/ui/customviews/PMProgressDialog$AutoHideTimerTask;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/customviews/PMProgressDialog$AutoHideTimerTask;)V
    .locals 0

    .prologue
    .line 106
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMProgressDialog$AutoHideTimerTask$1;->this$1:Lcom/poshmark/ui/customviews/PMProgressDialog$AutoHideTimerTask;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 109
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMProgressDialog$AutoHideTimerTask$1;->this$1:Lcom/poshmark/ui/customviews/PMProgressDialog$AutoHideTimerTask;

    iget-object v0, v0, Lcom/poshmark/ui/customviews/PMProgressDialog$AutoHideTimerTask;->this$0:Lcom/poshmark/ui/customviews/PMProgressDialog;

    const/4 v1, 0x0

    iput-boolean v1, v0, Lcom/poshmark/ui/customviews/PMProgressDialog;->bAutoHide:Z

    .line 110
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMProgressDialog$AutoHideTimerTask$1;->this$1:Lcom/poshmark/ui/customviews/PMProgressDialog$AutoHideTimerTask;

    iget-object v0, v0, Lcom/poshmark/ui/customviews/PMProgressDialog$AutoHideTimerTask;->this$0:Lcom/poshmark/ui/customviews/PMProgressDialog;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMProgressDialog;->dismiss()V

    .line 111
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMProgressDialog$AutoHideTimerTask$1;->this$1:Lcom/poshmark/ui/customviews/PMProgressDialog$AutoHideTimerTask;

    iget-object v0, v0, Lcom/poshmark/ui/customviews/PMProgressDialog$AutoHideTimerTask;->this$0:Lcom/poshmark/ui/customviews/PMProgressDialog;

    iget-object v0, v0, Lcom/poshmark/ui/customviews/PMProgressDialog;->dismissListener:Lcom/poshmark/ui/customviews/PMProgressDialog$ProgressDialogAutoDismissListener;

    if-eqz v0, :cond_0

    .line 112
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMProgressDialog$AutoHideTimerTask$1;->this$1:Lcom/poshmark/ui/customviews/PMProgressDialog$AutoHideTimerTask;

    iget-object v0, v0, Lcom/poshmark/ui/customviews/PMProgressDialog$AutoHideTimerTask;->this$0:Lcom/poshmark/ui/customviews/PMProgressDialog;

    iget-object v0, v0, Lcom/poshmark/ui/customviews/PMProgressDialog;->dismissListener:Lcom/poshmark/ui/customviews/PMProgressDialog$ProgressDialogAutoDismissListener;

    invoke-interface {v0}, Lcom/poshmark/ui/customviews/PMProgressDialog$ProgressDialogAutoDismissListener;->dialogDismissed()V

    .line 113
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMProgressDialog$AutoHideTimerTask$1;->this$1:Lcom/poshmark/ui/customviews/PMProgressDialog$AutoHideTimerTask;

    iget-object v0, v0, Lcom/poshmark/ui/customviews/PMProgressDialog$AutoHideTimerTask;->this$0:Lcom/poshmark/ui/customviews/PMProgressDialog;

    const/4 v1, 0x0

    iput-object v1, v0, Lcom/poshmark/ui/customviews/PMProgressDialog;->dismissListener:Lcom/poshmark/ui/customviews/PMProgressDialog$ProgressDialogAutoDismissListener;

    .line 115
    :cond_0
    return-void
.end method

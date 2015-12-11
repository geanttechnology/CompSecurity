.class public Lcom/poshmark/ui/customviews/PMProgressDialog;
.super Landroid/app/Dialog;
.source "PMProgressDialog.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/ui/customviews/PMProgressDialog$ProgressDialogAutoDismissListener;,
        Lcom/poshmark/ui/customviews/PMProgressDialog$AutoHideTimerTask;
    }
.end annotation


# instance fields
.field bAutoHide:Z

.field dismissListener:Lcom/poshmark/ui/customviews/PMProgressDialog$ProgressDialogAutoDismissListener;

.field private imageView:Landroid/widget/ImageView;

.field private progressBar:Landroid/widget/ProgressBar;

.field private textView:Lcom/poshmark/ui/customviews/PMTextView;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 33
    const v1, 0x7f080015

    invoke-direct {p0, p1, v1}, Landroid/app/Dialog;-><init>(Landroid/content/Context;I)V

    .line 24
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/poshmark/ui/customviews/PMProgressDialog;->bAutoHide:Z

    .line 35
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMProgressDialog;->getContext()Landroid/content/Context;

    .line 37
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMProgressDialog;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v1

    const v2, 0x7f0300a6

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 38
    .local v0, "layout":Landroid/widget/LinearLayout;
    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/PMProgressDialog;->setContentView(Landroid/view/View;)V

    .line 40
    const v1, 0x7f0c0273

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v1, p0, Lcom/poshmark/ui/customviews/PMProgressDialog;->textView:Lcom/poshmark/ui/customviews/PMTextView;

    .line 41
    const v1, 0x7f0c0272

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/poshmark/ui/customviews/PMProgressDialog;->imageView:Landroid/widget/ImageView;

    .line 42
    const v1, 0x7f0c0061

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ProgressBar;

    iput-object v1, p0, Lcom/poshmark/ui/customviews/PMProgressDialog;->progressBar:Landroid/widget/ProgressBar;

    .line 43
    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 47
    invoke-super {p0, p1}, Landroid/app/Dialog;->onCreate(Landroid/os/Bundle;)V

    .line 48
    return-void
.end method

.method public onStart()V
    .locals 0

    .prologue
    .line 62
    invoke-super {p0}, Landroid/app/Dialog;->onStart()V

    .line 63
    return-void
.end method

.method public onStop()V
    .locals 0

    .prologue
    .line 67
    invoke-super {p0}, Landroid/app/Dialog;->onStop()V

    .line 68
    return-void
.end method

.method public setAutoHideFlag(Z)V
    .locals 2
    .param p1, "autoHide"    # Z

    .prologue
    .line 82
    iput-boolean p1, p0, Lcom/poshmark/ui/customviews/PMProgressDialog;->bAutoHide:Z

    .line 83
    if-eqz p1, :cond_0

    .line 84
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMProgressDialog;->progressBar:Landroid/widget/ProgressBar;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 89
    :goto_0
    return-void

    .line 87
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMProgressDialog;->progressBar:Landroid/widget/ProgressBar;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    goto :goto_0
.end method

.method public setDismissListener(Lcom/poshmark/ui/customviews/PMProgressDialog$ProgressDialogAutoDismissListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/poshmark/ui/customviews/PMProgressDialog$ProgressDialogAutoDismissListener;

    .prologue
    .line 92
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMProgressDialog;->dismissListener:Lcom/poshmark/ui/customviews/PMProgressDialog$ProgressDialogAutoDismissListener;

    .line 93
    return-void
.end method

.method public setMessage(Ljava/lang/String;)V
    .locals 2
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 71
    if-eqz p1, :cond_0

    .line 72
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMProgressDialog;->textView:Lcom/poshmark/ui/customviews/PMTextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    .line 73
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMProgressDialog;->textView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v0, p1}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 79
    :goto_0
    return-void

    .line 76
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMProgressDialog;->textView:Lcom/poshmark/ui/customviews/PMTextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    .line 77
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMProgressDialog;->textView:Lcom/poshmark/ui/customviews/PMTextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method

.method public show()V
    .locals 4

    .prologue
    .line 52
    invoke-super {p0}, Landroid/app/Dialog;->show()V

    .line 53
    iget-boolean v2, p0, Lcom/poshmark/ui/customviews/PMProgressDialog;->bAutoHide:Z

    if-eqz v2, :cond_0

    .line 54
    new-instance v0, Lcom/poshmark/ui/customviews/PMProgressDialog$AutoHideTimerTask;

    invoke-direct {v0, p0, p0}, Lcom/poshmark/ui/customviews/PMProgressDialog$AutoHideTimerTask;-><init>(Lcom/poshmark/ui/customviews/PMProgressDialog;Lcom/poshmark/ui/customviews/PMProgressDialog;)V

    .line 55
    .local v0, "task":Lcom/poshmark/ui/customviews/PMProgressDialog$AutoHideTimerTask;
    new-instance v1, Ljava/util/Timer;

    invoke-direct {v1}, Ljava/util/Timer;-><init>()V

    .line 56
    .local v1, "timer":Ljava/util/Timer;
    const-wide/16 v2, 0x5dc

    invoke-virtual {v1, v0, v2, v3}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;J)V

    .line 58
    .end local v0    # "task":Lcom/poshmark/ui/customviews/PMProgressDialog$AutoHideTimerTask;
    .end local v1    # "timer":Ljava/util/Timer;
    :cond_0
    return-void
.end method

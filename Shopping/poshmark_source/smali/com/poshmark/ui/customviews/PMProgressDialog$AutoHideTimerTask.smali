.class public Lcom/poshmark/ui/customviews/PMProgressDialog$AutoHideTimerTask;
.super Ljava/util/TimerTask;
.source "PMProgressDialog.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/customviews/PMProgressDialog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "AutoHideTimerTask"
.end annotation


# instance fields
.field parent:Lcom/poshmark/ui/customviews/PMProgressDialog;

.field final synthetic this$0:Lcom/poshmark/ui/customviews/PMProgressDialog;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/customviews/PMProgressDialog;Lcom/poshmark/ui/customviews/PMProgressDialog;)V
    .locals 0
    .param p2, "parent"    # Lcom/poshmark/ui/customviews/PMProgressDialog;

    .prologue
    .line 98
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMProgressDialog$AutoHideTimerTask;->this$0:Lcom/poshmark/ui/customviews/PMProgressDialog;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    .line 99
    iput-object p2, p0, Lcom/poshmark/ui/customviews/PMProgressDialog$AutoHideTimerTask;->parent:Lcom/poshmark/ui/customviews/PMProgressDialog;

    .line 100
    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 104
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getApplicationObject()Lcom/poshmark/application/PMApplication;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/application/PMApplication;->getTopActivity()Lcom/poshmark/ui/PMActivity;

    move-result-object v0

    .line 105
    .local v0, "activity":Landroid/app/Activity;
    if-eqz v0, :cond_0

    .line 106
    new-instance v1, Lcom/poshmark/ui/customviews/PMProgressDialog$AutoHideTimerTask$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/customviews/PMProgressDialog$AutoHideTimerTask$1;-><init>(Lcom/poshmark/ui/customviews/PMProgressDialog$AutoHideTimerTask;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 118
    :cond_0
    return-void
.end method

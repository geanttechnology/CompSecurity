.class abstract Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;
.super Ljava/lang/Object;
.source "PreDownloadFlowFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x402
    name = "DialogLifecycleManager"
.end annotation


# instance fields
.field private isDismissingFromOnPause:Z

.field final synthetic this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;


# direct methods
.method private constructor <init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V
    .locals 0

    .prologue
    .line 1004
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;
    .param p2, "x1"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$1;

    .prologue
    .line 1004
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V

    return-void
.end method

.method static synthetic access$4800(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;)Z
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;

    .prologue
    .line 1004
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;->isDismissingFromOnPause:Z

    return v0
.end method

.method static synthetic access$4802(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;
    .param p1, "x1"    # Z

    .prologue
    .line 1004
    iput-boolean p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;->isDismissingFromOnPause:Z

    return p1
.end method


# virtual methods
.method protected abstract dismissDialog()V
.end method

.method protected abstract getDialogId()Ljava/lang/String;
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 1034
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;->isDismissingFromOnPause:Z

    .line 1035
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;->dismissDialog()V

    .line 1036
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 1009
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager$1;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager$1;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;)V

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;->showDialogWithDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V

    .line 1031
    return-void
.end method

.method protected abstract showDialogWithDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V
.end method

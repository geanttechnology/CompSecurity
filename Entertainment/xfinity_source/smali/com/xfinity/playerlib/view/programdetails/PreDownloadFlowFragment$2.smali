.class Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$2;
.super Ljava/lang/Object;
.source "PreDownloadFlowFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnDismissListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 148
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDismiss(Landroid/content/DialogInterface;)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 151
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->abortFlow()V

    .line 152
    return-void
.end method

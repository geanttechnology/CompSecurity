.class Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$18$1;
.super Ljava/lang/Object;
.source "PreDownloadFlowFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$18;->get()Lcom/comcast/cim/android/view/common/CALDialogFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$18;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$18;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$18;

    .prologue
    .line 694
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$18$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$18;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 697
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$18$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$18;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$18;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # invokes: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->registerDevice()V
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$2800(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V

    .line 698
    return-void
.end method

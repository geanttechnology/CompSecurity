.class Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$9$2;
.super Ljava/lang/Object;
.source "PreDownloadFlowFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$9;->get()Lcom/comcast/cim/android/view/common/CALDialogFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$9;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$9;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$9;

    .prologue
    .line 453
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$9$2;->this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$9;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 3
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 456
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$9$2;->this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$9;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$9;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$9$2;->this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$9;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$9;->val$highQualityProfile:Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;

    sget-object v2, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;->HIGH:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;

    # invokes: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->setSelectedHalVideoProfileAndProceedToNextStep(Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;)V
    invoke-static {v0, v1, v2}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$1100(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;)V

    .line 457
    return-void
.end method

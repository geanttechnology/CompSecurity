.class Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$9;
.super Ljava/lang/Object;
.source "PreDownloadFlowFragment.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/provider/Provider;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->chooseVideoFormat()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/utils/provider/Provider",
        "<",
        "Lcom/comcast/cim/android/view/common/CALDialogFragment;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

.field final synthetic val$highQualityProfile:Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;

.field final synthetic val$lowQualityProfile:Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 437
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$9;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$9;->val$lowQualityProfile:Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;

    iput-object p3, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$9;->val$highQualityProfile:Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public get()Lcom/comcast/cim/android/view/common/CALDialogFragment;
    .locals 12

    .prologue
    const/4 v11, 0x1

    const/4 v10, 0x0

    .line 439
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 440
    .local v0, "args":Landroid/os/Bundle;
    const-string v3, "title"

    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$9;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->resources:Landroid/content/res/Resources;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$500(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/xfinity/playerlib/R$string;->select_download_quality:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 442
    const-string v3, "inputPromptDlg"

    invoke-static {v3}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->newInstance(Ljava/lang/String;)Lcom/comcast/cim/android/view/common/CALDialogFragment;

    move-result-object v2

    .line 443
    .local v2, "dialog":Lcom/comcast/cim/android/view/common/CALDialogFragment;
    invoke-virtual {v2, v0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->addArguments(Landroid/os/Bundle;)V

    .line 445
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 446
    .local v1, "buttonList":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;>;"
    new-instance v3, Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;

    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$9;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/xfinity/playerlib/R$string;->download_quality_button_medium:I

    new-array v6, v11, [Ljava/lang/Object;

    iget-object v7, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$9;->val$lowQualityProfile:Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;

    invoke-virtual {v7}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->getContentSizeInBytes()J

    move-result-wide v8

    invoke-static {v8, v9}, Lcom/comcast/cim/utils/UIPresentationUtil;->bytesToMB(J)J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    aput-object v7, v6, v10

    invoke-virtual {v4, v5, v6}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    new-instance v5, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$9$1;

    invoke-direct {v5, p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$9$1;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$9;)V

    invoke-direct {v3, v4, v5}, Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;-><init>(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V

    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 453
    new-instance v3, Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;

    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$9;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/xfinity/playerlib/R$string;->download_quality_button_high:I

    new-array v6, v11, [Ljava/lang/Object;

    iget-object v7, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$9;->val$highQualityProfile:Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;

    invoke-virtual {v7}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->getContentSizeInBytes()J

    move-result-wide v8

    invoke-static {v8, v9}, Lcom/comcast/cim/utils/UIPresentationUtil;->bytesToMB(J)J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    aput-object v7, v6, v10

    invoke-virtual {v4, v5, v6}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    new-instance v5, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$9$2;

    invoke-direct {v5, p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$9$2;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$9;)V

    invoke-direct {v3, v4, v5}, Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;-><init>(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V

    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 460
    invoke-virtual {v2, v1}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->setButtonList(Ljava/util/List;)V

    .line 461
    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$9;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->abortFlowCancelListener:Landroid/content/DialogInterface$OnCancelListener;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$700(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Landroid/content/DialogInterface$OnCancelListener;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    .line 463
    return-object v2
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 437
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$9;->get()Lcom/comcast/cim/android/view/common/CALDialogFragment;

    move-result-object v0

    return-object v0
.end method

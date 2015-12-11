.class Lcom/amazon/mShop/search/viewit/ViewItActivity$6$1;
.super Ljava/lang/Object;
.source "ViewItActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItActivity$6;->error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/search/viewit/ViewItActivity$6;

.field final synthetic val$errorDialogType:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

.field final synthetic val$errorMsg:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItActivity$6;Ljava/lang/String;Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;)V
    .locals 0

    .prologue
    .line 945
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$6$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItActivity$6;

    iput-object p2, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$6$1;->val$errorMsg:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$6$1;->val$errorDialogType:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 948
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$6$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItActivity$6;

    iget-object v0, v0, Lcom/amazon/mShop/search/viewit/ViewItActivity$6;->this$0:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItActivity;->mPhotoCaptureView:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->access$000(Lcom/amazon/mShop/search/viewit/ViewItActivity;)Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->getViewItDialogHelper()Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;

    move-result-object v0

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$6$1;->val$errorMsg:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItActivity$6$1;->val$errorDialogType:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->showDialog(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;)V

    .line 949
    return-void
.end method

.class Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyLandmarkTextWatcher;
.super Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;
.source "CVSDMapActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/cvsd/CVSDMapActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "MyLandmarkTextWatcher"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/cvsd/CVSDMapActivity;Landroid/widget/EditText;)V
    .locals 0
    .param p2, "watched"    # Landroid/widget/EditText;

    .prologue
    .line 993
    iput-object p1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyLandmarkTextWatcher;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    .line 994
    invoke-direct {p0, p2}, Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;-><init>(Landroid/widget/EditText;)V

    .line 995
    return-void
.end method


# virtual methods
.method public update()V
    .locals 2

    .prologue
    .line 999
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyLandmarkTextWatcher;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    # getter for: Lcom/amazon/mShop/cvsd/CVSDMapActivity;->landmarkDialogPositiveButton:Landroid/widget/Button;
    invoke-static {v0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->access$2500(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)Landroid/widget/Button;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyLandmarkTextWatcher;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    # getter for: Lcom/amazon/mShop/cvsd/CVSDMapActivity;->landmarkTextWatcher:Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyLandmarkTextWatcher;
    invoke-static {v1}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->access$2400(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyLandmarkTextWatcher;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyLandmarkTextWatcher;->isWatchedNonZeroLength()Z

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setEnabled(Z)V

    .line 1000
    return-void
.end method

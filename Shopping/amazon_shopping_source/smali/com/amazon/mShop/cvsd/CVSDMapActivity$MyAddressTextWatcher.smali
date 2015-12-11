.class Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyAddressTextWatcher;
.super Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;
.source "CVSDMapActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/cvsd/CVSDMapActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "MyAddressTextWatcher"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/cvsd/CVSDMapActivity;Landroid/widget/EditText;)V
    .locals 0
    .param p2, "watched"    # Landroid/widget/EditText;

    .prologue
    .line 941
    iput-object p1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyAddressTextWatcher;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    .line 942
    invoke-direct {p0, p2}, Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;-><init>(Landroid/widget/EditText;)V

    .line 943
    return-void
.end method


# virtual methods
.method public update()V
    .locals 2

    .prologue
    .line 947
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyAddressTextWatcher;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    # getter for: Lcom/amazon/mShop/cvsd/CVSDMapActivity;->addressDialogPositiveButton:Landroid/widget/Button;
    invoke-static {v0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->access$2000(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)Landroid/widget/Button;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyAddressTextWatcher;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    # getter for: Lcom/amazon/mShop/cvsd/CVSDMapActivity;->addressTextWatcher:Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyAddressTextWatcher;
    invoke-static {v1}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->access$1900(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyAddressTextWatcher;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyAddressTextWatcher;->isWatchedNonZeroLength()Z

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setEnabled(Z)V

    .line 948
    return-void
.end method

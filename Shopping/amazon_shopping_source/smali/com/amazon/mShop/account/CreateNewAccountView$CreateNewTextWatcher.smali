.class final Lcom/amazon/mShop/account/CreateNewAccountView$CreateNewTextWatcher;
.super Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;
.source "CreateNewAccountView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/account/CreateNewAccountView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "CreateNewTextWatcher"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/account/CreateNewAccountView;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/account/CreateNewAccountView;Landroid/widget/EditText;)V
    .locals 0
    .param p2, "watched"    # Landroid/widget/EditText;

    .prologue
    .line 280
    iput-object p1, p0, Lcom/amazon/mShop/account/CreateNewAccountView$CreateNewTextWatcher;->this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

    .line 281
    invoke-direct {p0, p2}, Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;-><init>(Landroid/widget/EditText;)V

    .line 282
    return-void
.end method


# virtual methods
.method public update()V
    .locals 1

    .prologue
    .line 286
    iget-object v0, p0, Lcom/amazon/mShop/account/CreateNewAccountView$CreateNewTextWatcher;->this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

    # invokes: Lcom/amazon/mShop/account/CreateNewAccountView;->updateContinueButtonEnabled()V
    invoke-static {v0}, Lcom/amazon/mShop/account/CreateNewAccountView;->access$1000(Lcom/amazon/mShop/account/CreateNewAccountView;)V

    .line 287
    return-void
.end method

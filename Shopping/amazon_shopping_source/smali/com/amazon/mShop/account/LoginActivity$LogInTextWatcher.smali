.class final Lcom/amazon/mShop/account/LoginActivity$LogInTextWatcher;
.super Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;
.source "LoginActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/account/LoginActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "LogInTextWatcher"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/account/LoginActivity;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/account/LoginActivity;Landroid/widget/EditText;)V
    .locals 0
    .param p2, "watched"    # Landroid/widget/EditText;

    .prologue
    .line 498
    iput-object p1, p0, Lcom/amazon/mShop/account/LoginActivity$LogInTextWatcher;->this$0:Lcom/amazon/mShop/account/LoginActivity;

    .line 499
    invoke-direct {p0, p2}, Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;-><init>(Landroid/widget/EditText;)V

    .line 500
    return-void
.end method


# virtual methods
.method public update()V
    .locals 1

    .prologue
    .line 504
    iget-object v0, p0, Lcom/amazon/mShop/account/LoginActivity$LogInTextWatcher;->this$0:Lcom/amazon/mShop/account/LoginActivity;

    # invokes: Lcom/amazon/mShop/account/LoginActivity;->updateLoginButtonEnabled()V
    invoke-static {v0}, Lcom/amazon/mShop/account/LoginActivity;->access$000(Lcom/amazon/mShop/account/LoginActivity;)V

    .line 506
    return-void
.end method

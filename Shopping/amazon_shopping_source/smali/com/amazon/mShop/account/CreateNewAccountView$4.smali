.class Lcom/amazon/mShop/account/CreateNewAccountView$4;
.super Ljava/lang/Object;
.source "CreateNewAccountView.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/account/CreateNewAccountView;->onNewAccountCreation(ZLcom/amazon/rio/j2me/client/services/mShop/Notification;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/account/CreateNewAccountView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/account/CreateNewAccountView;)V
    .locals 0

    .prologue
    .line 255
    iput-object p1, p0, Lcom/amazon/mShop/account/CreateNewAccountView$4;->this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 258
    iget-object v0, p0, Lcom/amazon/mShop/account/CreateNewAccountView$4;->this$0:Lcom/amazon/mShop/account/CreateNewAccountView;

    # getter for: Lcom/amazon/mShop/account/CreateNewAccountView;->loginActivity:Lcom/amazon/mShop/account/LoginActivity;
    invoke-static {v0}, Lcom/amazon/mShop/account/CreateNewAccountView;->access$900(Lcom/amazon/mShop/account/CreateNewAccountView;)Lcom/amazon/mShop/account/LoginActivity;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/account/LoginActivity;->finish()V

    .line 259
    return-void
.end method

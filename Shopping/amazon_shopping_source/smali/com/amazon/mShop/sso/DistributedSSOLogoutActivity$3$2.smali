.class Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3$2;
.super Ljava/lang/Object;
.source "DistributedSSOLogoutActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3;->onError(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3;)V
    .locals 0

    .prologue
    .line 205
    iput-object p1, p0, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3$2;->this$1:Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 207
    iget-object v0, p0, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3$2;->this$1:Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3;

    iget-object v0, v0, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3;->this$0:Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->setResult(I)V

    .line 208
    iget-object v0, p0, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3$2;->this$1:Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3;

    iget-object v0, v0, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3;->this$0:Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;

    # getter for: Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->mProgressDialog:Landroid/app/ProgressDialog;
    invoke-static {v0}, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->access$100(Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;)Landroid/app/ProgressDialog;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 209
    iget-object v0, p0, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3$2;->this$1:Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3;

    iget-object v0, v0, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3;->this$0:Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;

    # getter for: Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->mProgressDialog:Landroid/app/ProgressDialog;
    invoke-static {v0}, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->access$100(Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;)Landroid/app/ProgressDialog;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    .line 211
    :cond_0
    return-void
.end method

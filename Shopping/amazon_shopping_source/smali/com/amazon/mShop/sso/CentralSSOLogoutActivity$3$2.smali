.class Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3$2;
.super Ljava/lang/Object;
.source "CentralSSOLogoutActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3;->onError(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3;)V
    .locals 0

    .prologue
    .line 146
    iput-object p1, p0, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3$2;->this$1:Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 148
    iget-object v0, p0, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3$2;->this$1:Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3;

    iget-object v0, v0, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3;->this$0:Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;->setResult(I)V

    .line 149
    iget-object v0, p0, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3$2;->this$1:Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3;

    iget-object v0, v0, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3;->this$0:Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;

    # getter for: Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;->mProgressDialog:Landroid/app/ProgressDialog;
    invoke-static {v0}, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;->access$100(Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;)Landroid/app/ProgressDialog;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 150
    iget-object v0, p0, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3$2;->this$1:Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3;

    iget-object v0, v0, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3;->this$0:Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;

    # getter for: Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;->mProgressDialog:Landroid/app/ProgressDialog;
    invoke-static {v0}, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;->access$100(Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;)Landroid/app/ProgressDialog;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    .line 152
    :cond_0
    return-void
.end method

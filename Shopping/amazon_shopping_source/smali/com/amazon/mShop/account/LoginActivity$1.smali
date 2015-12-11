.class Lcom/amazon/mShop/account/LoginActivity$1;
.super Ljava/lang/Object;
.source "LoginActivity.java"

# interfaces
.implements Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper$PrimeUpsellSubscriber;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/account/LoginActivity;->onSignInCompleted(ZLcom/amazon/rio/j2me/client/services/mShop/Notification;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/account/LoginActivity;

.field final synthetic val$notification:Lcom/amazon/rio/j2me/client/services/mShop/Notification;

.field final synthetic val$successful:Z


# direct methods
.method constructor <init>(Lcom/amazon/mShop/account/LoginActivity;ZLcom/amazon/rio/j2me/client/services/mShop/Notification;)V
    .locals 0

    .prologue
    .line 530
    iput-object p1, p0, Lcom/amazon/mShop/account/LoginActivity$1;->this$0:Lcom/amazon/mShop/account/LoginActivity;

    iput-boolean p2, p0, Lcom/amazon/mShop/account/LoginActivity$1;->val$successful:Z

    iput-object p3, p0, Lcom/amazon/mShop/account/LoginActivity$1;->val$notification:Lcom/amazon/rio/j2me/client/services/mShop/Notification;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onComplete(Z)V
    .locals 3
    .param p1, "signUpResult"    # Z

    .prologue
    .line 541
    iget-object v0, p0, Lcom/amazon/mShop/account/LoginActivity$1;->this$0:Lcom/amazon/mShop/account/LoginActivity;

    iget-boolean v1, p0, Lcom/amazon/mShop/account/LoginActivity$1;->val$successful:Z

    const/4 v2, 0x0

    # invokes: Lcom/amazon/mShop/account/LoginActivity;->postLogin(ZLcom/amazon/rio/j2me/client/services/mShop/Notification;)V
    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/account/LoginActivity;->access$100(Lcom/amazon/mShop/account/LoginActivity;ZLcom/amazon/rio/j2me/client/services/mShop/Notification;)V

    .line 542
    return-void
.end method

.method public onPageLoadFinished()V
    .locals 2

    .prologue
    .line 548
    iget-object v0, p0, Lcom/amazon/mShop/account/LoginActivity$1;->this$0:Lcom/amazon/mShop/account/LoginActivity;

    iget-boolean v1, p0, Lcom/amazon/mShop/account/LoginActivity$1;->val$successful:Z

    # invokes: Lcom/amazon/mShop/account/LoginActivity;->callUserSignedIn(Z)V
    invoke-static {v0, v1}, Lcom/amazon/mShop/account/LoginActivity;->access$200(Lcom/amazon/mShop/account/LoginActivity;Z)V

    .line 549
    return-void
.end method

.method public onUserCancel()V
    .locals 3

    .prologue
    .line 534
    iget-object v0, p0, Lcom/amazon/mShop/account/LoginActivity$1;->this$0:Lcom/amazon/mShop/account/LoginActivity;

    iget-boolean v1, p0, Lcom/amazon/mShop/account/LoginActivity$1;->val$successful:Z

    iget-object v2, p0, Lcom/amazon/mShop/account/LoginActivity$1;->val$notification:Lcom/amazon/rio/j2me/client/services/mShop/Notification;

    # invokes: Lcom/amazon/mShop/account/LoginActivity;->postLogin(ZLcom/amazon/rio/j2me/client/services/mShop/Notification;)V
    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/account/LoginActivity;->access$100(Lcom/amazon/mShop/account/LoginActivity;ZLcom/amazon/rio/j2me/client/services/mShop/Notification;)V

    .line 535
    return-void
.end method

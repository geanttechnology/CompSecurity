.class Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3$1;
.super Ljava/lang/Object;
.source "DistributedSSOLoginActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3;->onSuccess(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3;

.field final synthetic val$newAccount:Ljava/lang/String;

.field final synthetic val$startTime:J


# direct methods
.method constructor <init>(Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3;JLjava/lang/String;)V
    .locals 0

    .prologue
    .line 320
    iput-object p1, p0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3$1;->this$1:Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3;

    iput-wide p2, p0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3$1;->val$startTime:J

    iput-object p4, p0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3$1;->val$newAccount:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 324
    # getter for: Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->DEBUG:Z
    invoke-static {}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->access$500()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 325
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v0

    .line 326
    .local v0, "endTime":J
    # getter for: Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->access$400()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "before addAccountCustomeKey:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-wide v4, p0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3$1;->val$startTime:J

    sub-long v4, v0, v4

    invoke-virtual {v3, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 328
    .end local v0    # "endTime":J
    :cond_0
    iget-object v2, p0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3$1;->val$newAccount:Ljava/lang/String;

    invoke-static {v2}, Lcom/amazon/mShop/sso/SSOUtil;->addAccountCustomKeyMapping(Ljava/lang/String;)V

    .line 329
    # getter for: Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->DEBUG:Z
    invoke-static {}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->access$600()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 330
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v0

    .line 331
    .restart local v0    # "endTime":J
    # getter for: Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->access$400()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "after addAccountCustomKey:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-wide v4, p0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3$1;->val$startTime:J

    sub-long v4, v0, v4

    invoke-virtual {v3, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 333
    .end local v0    # "endTime":J
    :cond_1
    return-void
.end method

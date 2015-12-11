.class Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$3;
.super Ljava/lang/Object;
.source "PrimeFlagChecker.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;->completed(Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;

.field final synthetic val$loginResponse:Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;)V
    .locals 0

    .prologue
    .line 83
    iput-object p1, p0, Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$3;->this$0:Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;

    iput-object p2, p0, Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$3;->val$loginResponse:Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 87
    iget-object v0, p0, Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$3;->this$0:Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;

    iget-object v1, p0, Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$3;->val$loginResponse:Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;

    # invokes: Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;->handleLoginResponse(Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;)V
    invoke-static {v0, v1}, Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;->access$100(Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;)V

    .line 88
    iget-object v0, p0, Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$3;->this$0:Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;

    # getter for: Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;->mSubscriber:Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$Subscriber;
    invoke-static {v0}, Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;->access$000(Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;)Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$Subscriber;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 89
    iget-object v0, p0, Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$3;->val$loginResponse:Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;

    if-eqz v0, :cond_1

    .line 90
    iget-object v0, p0, Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$3;->this$0:Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;

    # getter for: Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;->mSubscriber:Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$Subscriber;
    invoke-static {v0}, Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;->access$000(Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;)Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$Subscriber;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$Subscriber;->onComplete()V

    .line 96
    :cond_0
    :goto_0
    return-void

    .line 92
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$3;->this$0:Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;

    # getter for: Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;->mSubscriber:Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$Subscriber;
    invoke-static {v0}, Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;->access$000(Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;)Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$Subscriber;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$Subscriber;->onError()V

    goto :goto_0
.end method

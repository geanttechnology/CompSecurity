.class Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$1;
.super Ljava/lang/Object;
.source "PrimeFlagChecker.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;->error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;)V
    .locals 0

    .prologue
    .line 57
    iput-object p1, p0, Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$1;->this$0:Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$1;->this$0:Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;

    # getter for: Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;->mSubscriber:Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$Subscriber;
    invoke-static {v0}, Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;->access$000(Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;)Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$Subscriber;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 62
    iget-object v0, p0, Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$1;->this$0:Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;

    # getter for: Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;->mSubscriber:Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$Subscriber;
    invoke-static {v0}, Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;->access$000(Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;)Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$Subscriber;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$Subscriber;->onError()V

    .line 64
    :cond_0
    return-void
.end method

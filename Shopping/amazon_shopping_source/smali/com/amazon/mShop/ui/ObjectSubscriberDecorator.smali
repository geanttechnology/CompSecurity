.class public Lcom/amazon/mShop/ui/ObjectSubscriberDecorator;
.super Ljava/lang/Object;
.source "ObjectSubscriberDecorator.java"

# interfaces
.implements Lcom/amazon/mShop/control/ObjectSubscriber;


# instance fields
.field private final weakSubscriber:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Lcom/amazon/mShop/control/ObjectSubscriber;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/control/ObjectSubscriber;)V
    .locals 1
    .param p1, "subscriber"    # Lcom/amazon/mShop/control/ObjectSubscriber;

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    new-instance v0, Ljava/lang/ref/WeakReference;

    invoke-direct {v0, p1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lcom/amazon/mShop/ui/ObjectSubscriberDecorator;->weakSubscriber:Ljava/lang/ref/WeakReference;

    .line 29
    return-void
.end method

.method private getSubscriber()Lcom/amazon/mShop/control/ObjectSubscriber;
    .locals 2

    .prologue
    .line 32
    iget-object v1, p0, Lcom/amazon/mShop/ui/ObjectSubscriberDecorator;->weakSubscriber:Ljava/lang/ref/WeakReference;

    invoke-virtual {v1}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/control/ObjectSubscriber;

    .line 33
    .local v0, "subscriber":Lcom/amazon/mShop/control/ObjectSubscriber;
    return-object v0
.end method


# virtual methods
.method public onAvailableCountReceived(I)V
    .locals 1
    .param p1, "availableCount"    # I

    .prologue
    .line 45
    invoke-direct {p0}, Lcom/amazon/mShop/ui/ObjectSubscriberDecorator;->getSubscriber()Lcom/amazon/mShop/control/ObjectSubscriber;

    move-result-object v0

    .line 46
    .local v0, "subscriber":Lcom/amazon/mShop/control/ObjectSubscriber;
    if-eqz v0, :cond_0

    .line 47
    invoke-interface {v0, p1}, Lcom/amazon/mShop/control/ObjectSubscriber;->onAvailableCountReceived(I)V

    .line 48
    :cond_0
    return-void
.end method

.method public onCancelled()V
    .locals 1

    .prologue
    .line 66
    invoke-direct {p0}, Lcom/amazon/mShop/ui/ObjectSubscriberDecorator;->getSubscriber()Lcom/amazon/mShop/control/ObjectSubscriber;

    move-result-object v0

    .line 67
    .local v0, "subscriber":Lcom/amazon/mShop/control/ObjectSubscriber;
    if-eqz v0, :cond_0

    .line 68
    invoke-interface {v0}, Lcom/amazon/mShop/control/ObjectSubscriber;->onCancelled()V

    .line 69
    :cond_0
    return-void
.end method

.method public onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 1
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 38
    invoke-direct {p0}, Lcom/amazon/mShop/ui/ObjectSubscriberDecorator;->getSubscriber()Lcom/amazon/mShop/control/ObjectSubscriber;

    move-result-object v0

    .line 39
    .local v0, "subscriber":Lcom/amazon/mShop/control/ObjectSubscriber;
    if-eqz v0, :cond_0

    .line 40
    invoke-interface {v0, p1, p2}, Lcom/amazon/mShop/control/ObjectSubscriber;->onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 41
    :cond_0
    return-void
.end method

.method public onObjectReceived(Ljava/lang/Object;I)V
    .locals 1
    .param p1, "o"    # Ljava/lang/Object;
    .param p2, "index"    # I

    .prologue
    .line 52
    invoke-direct {p0}, Lcom/amazon/mShop/ui/ObjectSubscriberDecorator;->getSubscriber()Lcom/amazon/mShop/control/ObjectSubscriber;

    move-result-object v0

    .line 53
    .local v0, "subscriber":Lcom/amazon/mShop/control/ObjectSubscriber;
    if-eqz v0, :cond_0

    .line 54
    invoke-interface {v0, p1, p2}, Lcom/amazon/mShop/control/ObjectSubscriber;->onObjectReceived(Ljava/lang/Object;I)V

    .line 55
    :cond_0
    return-void
.end method

.method public onObjectsReceived()V
    .locals 1

    .prologue
    .line 59
    invoke-direct {p0}, Lcom/amazon/mShop/ui/ObjectSubscriberDecorator;->getSubscriber()Lcom/amazon/mShop/control/ObjectSubscriber;

    move-result-object v0

    .line 60
    .local v0, "subscriber":Lcom/amazon/mShop/control/ObjectSubscriber;
    if-eqz v0, :cond_0

    .line 61
    invoke-interface {v0}, Lcom/amazon/mShop/control/ObjectSubscriber;->onObjectsReceived()V

    .line 62
    :cond_0
    return-void
.end method

.method public onPageComplete()V
    .locals 1

    .prologue
    .line 73
    invoke-direct {p0}, Lcom/amazon/mShop/ui/ObjectSubscriberDecorator;->getSubscriber()Lcom/amazon/mShop/control/ObjectSubscriber;

    move-result-object v0

    .line 74
    .local v0, "subscriber":Lcom/amazon/mShop/control/ObjectSubscriber;
    if-eqz v0, :cond_0

    .line 75
    invoke-interface {v0}, Lcom/amazon/mShop/control/ObjectSubscriber;->onPageComplete()V

    .line 76
    :cond_0
    return-void
.end method

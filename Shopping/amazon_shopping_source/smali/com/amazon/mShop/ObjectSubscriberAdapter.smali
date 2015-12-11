.class public abstract Lcom/amazon/mShop/ObjectSubscriberAdapter;
.super Landroid/widget/BaseAdapter;
.source "ObjectSubscriberAdapter.java"

# interfaces
.implements Lcom/amazon/mShop/control/ObjectSubscriber;


# instance fields
.field private final amazonActivity:Lcom/amazon/mShop/AmazonActivity;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/AmazonActivity;)V
    .locals 0
    .param p1, "activity"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    .line 31
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 32
    iput-object p1, p0, Lcom/amazon/mShop/ObjectSubscriberAdapter;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 33
    return-void
.end method


# virtual methods
.method public getAmazonActivity()Lcom/amazon/mShop/AmazonActivity;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/amazon/mShop/ObjectSubscriberAdapter;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    return-object v0
.end method

.method public getContext()Landroid/content/Context;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/mShop/ObjectSubscriberAdapter;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    return-object v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 104
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 98
    int-to-long v0, p1

    return-wide v0
.end method

.method public onAvailableCountReceived(I)V
    .locals 0
    .param p1, "availableCount"    # I

    .prologue
    .line 53
    return-void
.end method

.method public onCancelled()V
    .locals 0

    .prologue
    .line 71
    return-void
.end method

.method public onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 84
    const-string/jumbo v0, "Amazon.ObjectSubscriberAdapter"

    const-string/jumbo v1, "onError"

    invoke-static {v0, v1, p1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 85
    return-void
.end method

.method public onObjectReceived(Ljava/lang/Object;I)V
    .locals 0
    .param p1, "o"    # Ljava/lang/Object;
    .param p2, "index"    # I

    .prologue
    .line 57
    invoke-virtual {p0}, Lcom/amazon/mShop/ObjectSubscriberAdapter;->notifyDataSetChanged()V

    .line 58
    return-void
.end method

.method public onObjectsReceived()V
    .locals 0

    .prologue
    .line 62
    invoke-virtual {p0}, Lcom/amazon/mShop/ObjectSubscriberAdapter;->notifyDataSetChanged()V

    .line 63
    return-void
.end method

.method public onPageComplete()V
    .locals 0

    .prologue
    .line 90
    return-void
.end method

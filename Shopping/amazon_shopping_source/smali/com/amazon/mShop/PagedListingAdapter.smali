.class public abstract Lcom/amazon/mShop/PagedListingAdapter;
.super Lcom/amazon/mShop/ObjectSubscriberAdapter;
.source "PagedListingAdapter.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/amazon/mShop/ObjectSubscriberAdapter;"
    }
.end annotation


# instance fields
.field protected browser:Lcom/amazon/mShop/control/PagedListingBrowser;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/mShop/control/PagedListingBrowser",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/AmazonActivity;)V
    .locals 0
    .param p1, "activity"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    .line 19
    .local p0, "this":Lcom/amazon/mShop/PagedListingAdapter;, "Lcom/amazon/mShop/PagedListingAdapter<TT;>;"
    invoke-direct {p0, p1}, Lcom/amazon/mShop/ObjectSubscriberAdapter;-><init>(Lcom/amazon/mShop/AmazonActivity;)V

    .line 20
    return-void
.end method


# virtual methods
.method public getBrowser()Lcom/amazon/mShop/control/PagedListingBrowser;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/amazon/mShop/control/PagedListingBrowser",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 26
    .local p0, "this":Lcom/amazon/mShop/PagedListingAdapter;, "Lcom/amazon/mShop/PagedListingAdapter<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/PagedListingAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    return-object v0
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 44
    .local p0, "this":Lcom/amazon/mShop/PagedListingAdapter;, "Lcom/amazon/mShop/PagedListingAdapter<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/PagedListingAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    if-nez v0, :cond_0

    .line 45
    const/4 v0, 0x0

    .line 47
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/PagedListingAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/PagedListingBrowser;->getReceivedCount()I

    move-result v0

    goto :goto_0
.end method

.method public setBrowser(Lcom/amazon/mShop/control/PagedListingBrowser;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/mShop/control/PagedListingBrowser",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 33
    .local p0, "this":Lcom/amazon/mShop/PagedListingAdapter;, "Lcom/amazon/mShop/PagedListingAdapter<TT;>;"
    .local p1, "browser":Lcom/amazon/mShop/control/PagedListingBrowser;, "Lcom/amazon/mShop/control/PagedListingBrowser<TT;>;"
    iput-object p1, p0, Lcom/amazon/mShop/PagedListingAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    .line 34
    new-instance v0, Lcom/amazon/mShop/ui/ObjectSubscriberDecorator;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/ui/ObjectSubscriberDecorator;-><init>(Lcom/amazon/mShop/control/ObjectSubscriber;)V

    invoke-virtual {p1, v0}, Lcom/amazon/mShop/control/PagedListingBrowser;->setPrimarySubscriber(Lcom/amazon/mShop/control/ObjectSubscriber;)V

    .line 35
    invoke-virtual {p0}, Lcom/amazon/mShop/PagedListingAdapter;->notifyDataSetChanged()V

    .line 36
    return-void
.end method

.class Lcom/amazon/mShop/control/PagedListingBrowser$2;
.super Ljava/lang/Object;
.source "PagedListingBrowser.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/PagedListingBrowser;->availableCountReceived(ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

.field final synthetic val$availableCount:I

.field final synthetic val$serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/PagedListingBrowser;Lcom/amazon/rio/j2me/client/services/ServiceCall;I)V
    .locals 0

    .prologue
    .line 725
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser$2;, "Lcom/amazon/mShop/control/PagedListingBrowser.2;"
    iput-object p1, p0, Lcom/amazon/mShop/control/PagedListingBrowser$2;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    iput-object p2, p0, Lcom/amazon/mShop/control/PagedListingBrowser$2;->val$serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    iput p3, p0, Lcom/amazon/mShop/control/PagedListingBrowser$2;->val$availableCount:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 730
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser$2;, "Lcom/amazon/mShop/control/PagedListingBrowser.2;"
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser$2;->val$serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    iget-object v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser$2;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    iget-object v1, v1, Lcom/amazon/mShop/control/PagedListingBrowser;->currentRequest:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    if-ne v0, v1, :cond_0

    .line 731
    iget v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser$2;->val$availableCount:I

    iget-object v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser$2;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    # getter for: Lcom/amazon/mShop/control/PagedListingBrowser;->availableCount:I
    invoke-static {v1}, Lcom/amazon/mShop/control/PagedListingBrowser;->access$100(Lcom/amazon/mShop/control/PagedListingBrowser;)I

    move-result v1

    if-eq v0, v1, :cond_0

    .line 732
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser$2;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    iget v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser$2;->val$availableCount:I

    # setter for: Lcom/amazon/mShop/control/PagedListingBrowser;->availableCount:I
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/PagedListingBrowser;->access$102(Lcom/amazon/mShop/control/PagedListingBrowser;I)I

    .line 733
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser$2;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    # invokes: Lcom/amazon/mShop/control/PagedListingBrowser;->notifyCountReceived()V
    invoke-static {v0}, Lcom/amazon/mShop/control/PagedListingBrowser;->access$200(Lcom/amazon/mShop/control/PagedListingBrowser;)V

    .line 736
    :cond_0
    return-void
.end method

.class Lcom/amazon/mShop/control/PagedListingBrowser$3;
.super Ljava/lang/Object;
.source "PagedListingBrowser.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/PagedListingBrowser;->objectReceived(Ljava/lang/Object;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

.field final synthetic val$intraPageIndex:I

.field final synthetic val$o:Ljava/lang/Object;

.field final synthetic val$serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/PagedListingBrowser;Ljava/lang/Object;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0

    .prologue
    .line 754
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser$3;, "Lcom/amazon/mShop/control/PagedListingBrowser.3;"
    iput-object p1, p0, Lcom/amazon/mShop/control/PagedListingBrowser$3;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    iput-object p2, p0, Lcom/amazon/mShop/control/PagedListingBrowser$3;->val$o:Ljava/lang/Object;

    iput p3, p0, Lcom/amazon/mShop/control/PagedListingBrowser$3;->val$intraPageIndex:I

    iput-object p4, p0, Lcom/amazon/mShop/control/PagedListingBrowser$3;->val$serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 758
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser$3;, "Lcom/amazon/mShop/control/PagedListingBrowser.3;"
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser$3;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    iget-object v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser$3;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    iget-object v1, v1, Lcom/amazon/mShop/control/PagedListingBrowser;->listingObjects:Ljava/util/List;

    iget-object v2, p0, Lcom/amazon/mShop/control/PagedListingBrowser$3;->val$o:Ljava/lang/Object;

    iget v3, p0, Lcom/amazon/mShop/control/PagedListingBrowser$3;->val$intraPageIndex:I

    iget-object v4, p0, Lcom/amazon/mShop/control/PagedListingBrowser$3;->val$serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/amazon/mShop/control/PagedListingBrowser;->addToListAndNotify(Ljava/util/List;Ljava/lang/Object;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 759
    return-void
.end method

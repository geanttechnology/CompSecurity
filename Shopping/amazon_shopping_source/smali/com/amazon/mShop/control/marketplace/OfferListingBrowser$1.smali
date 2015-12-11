.class Lcom/amazon/mShop/control/marketplace/OfferListingBrowser$1;
.super Ljava/lang/Object;
.source "OfferListingBrowser.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/marketplace/OfferListingBrowser;->receivedPrimeOneClickStatus(Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/marketplace/OfferListingBrowser;

.field final synthetic val$value:Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/marketplace/OfferListingBrowser;Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;)V
    .locals 0

    .prologue
    .line 72
    iput-object p1, p0, Lcom/amazon/mShop/control/marketplace/OfferListingBrowser$1;->this$0:Lcom/amazon/mShop/control/marketplace/OfferListingBrowser;

    iput-object p2, p0, Lcom/amazon/mShop/control/marketplace/OfferListingBrowser$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/amazon/mShop/control/marketplace/OfferListingBrowser$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;

    invoke-static {v0}, Lcom/amazon/mShop/model/auth/User;->setPrimeOneClickStatus(Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;)V

    .line 77
    return-void
.end method

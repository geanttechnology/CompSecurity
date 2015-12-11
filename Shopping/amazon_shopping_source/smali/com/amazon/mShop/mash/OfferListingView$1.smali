.class Lcom/amazon/mShop/mash/OfferListingView$1;
.super Ljava/lang/Object;
.source "OfferListingView.java"

# interfaces
.implements Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/mash/OfferListingView;->error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/mash/OfferListingView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/mash/OfferListingView;)V
    .locals 0

    .prologue
    .line 103
    iput-object p1, p0, Lcom/amazon/mShop/mash/OfferListingView$1;->this$0:Lcom/amazon/mShop/mash/OfferListingView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onActionButtonClick(I)V
    .locals 2
    .param p1, "errorId"    # I

    .prologue
    .line 106
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/mash/OfferListingView$1$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/mash/OfferListingView$1$1;-><init>(Lcom/amazon/mShop/mash/OfferListingView$1;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 112
    return-void
.end method

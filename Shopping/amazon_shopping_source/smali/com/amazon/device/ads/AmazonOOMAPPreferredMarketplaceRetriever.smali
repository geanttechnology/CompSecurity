.class Lcom/amazon/device/ads/AmazonOOMAPPreferredMarketplaceRetriever;
.super Ljava/lang/Object;
.source "AmazonOOMAPPreferredMarketplaceRetriever.java"

# interfaces
.implements Lcom/amazon/device/ads/PreferredMarketplaceRetriever;


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public retrievePreferredMarketplace()Ljava/lang/String;
    .locals 2

    .prologue
    .line 13
    new-instance v0, Lcom/amazon/device/ads/AmazonOOMAPAdapter;

    invoke-direct {v0}, Lcom/amazon/device/ads/AmazonOOMAPAdapter;-><init>()V

    .line 14
    .local v0, "map":Lcom/amazon/device/ads/AmazonOOMAPAdapter;
    invoke-virtual {v0}, Lcom/amazon/device/ads/AmazonOOMAPAdapter;->getPreferredMarketplace()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

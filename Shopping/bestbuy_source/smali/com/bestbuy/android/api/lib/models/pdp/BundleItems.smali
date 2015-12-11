.class public Lcom/bestbuy/android/api/lib/models/pdp/BundleItems;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private bundleCustomerRatings:Lcom/bestbuy/android/api/lib/models/pdp/BundleCustomerRatings;

.field private bundleDescriptions:Lcom/bestbuy/android/api/lib/models/pdp/BundleDescriptions;

.field private bundleManufacturerId:Lcom/bestbuy/android/api/lib/models/pdp/BundleManufacturer;

.field private media:Lcom/bestbuy/android/api/lib/models/pdp/BundleMedia;

.field private names:Lcom/bestbuy/android/api/lib/models/pdp/BundleName;

.field private skuId:Ljava/lang/String;

.field private url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getBundleCustomerRatings()Lcom/bestbuy/android/api/lib/models/pdp/BundleCustomerRatings;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleItems;->bundleCustomerRatings:Lcom/bestbuy/android/api/lib/models/pdp/BundleCustomerRatings;

    return-object v0
.end method

.method public getBundleDescriptions()Lcom/bestbuy/android/api/lib/models/pdp/BundleDescriptions;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleItems;->bundleDescriptions:Lcom/bestbuy/android/api/lib/models/pdp/BundleDescriptions;

    return-object v0
.end method

.method public getBundleManufacturerId()Lcom/bestbuy/android/api/lib/models/pdp/BundleManufacturer;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleItems;->bundleManufacturerId:Lcom/bestbuy/android/api/lib/models/pdp/BundleManufacturer;

    return-object v0
.end method

.method public getMedia()Lcom/bestbuy/android/api/lib/models/pdp/BundleMedia;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleItems;->media:Lcom/bestbuy/android/api/lib/models/pdp/BundleMedia;

    return-object v0
.end method

.method public getNames()Lcom/bestbuy/android/api/lib/models/pdp/BundleName;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleItems;->names:Lcom/bestbuy/android/api/lib/models/pdp/BundleName;

    return-object v0
.end method

.method public getSkuId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleItems;->skuId:Ljava/lang/String;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleItems;->url:Ljava/lang/String;

    return-object v0
.end method

.method public setBundleCustomerRatings(Lcom/bestbuy/android/api/lib/models/pdp/BundleCustomerRatings;)V
    .locals 0

    .prologue
    .line 27
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleItems;->bundleCustomerRatings:Lcom/bestbuy/android/api/lib/models/pdp/BundleCustomerRatings;

    .line 28
    return-void
.end method

.method public setBundleDescriptions(Lcom/bestbuy/android/api/lib/models/pdp/BundleDescriptions;)V
    .locals 0

    .prologue
    .line 35
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleItems;->bundleDescriptions:Lcom/bestbuy/android/api/lib/models/pdp/BundleDescriptions;

    .line 36
    return-void
.end method

.method public setBundleManufacturerId(Lcom/bestbuy/android/api/lib/models/pdp/BundleManufacturer;)V
    .locals 0

    .prologue
    .line 43
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleItems;->bundleManufacturerId:Lcom/bestbuy/android/api/lib/models/pdp/BundleManufacturer;

    .line 44
    return-void
.end method

.method public setMedia(Lcom/bestbuy/android/api/lib/models/pdp/BundleMedia;)V
    .locals 0

    .prologue
    .line 51
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleItems;->media:Lcom/bestbuy/android/api/lib/models/pdp/BundleMedia;

    .line 52
    return-void
.end method

.method public setNames(Lcom/bestbuy/android/api/lib/models/pdp/BundleName;)V
    .locals 0

    .prologue
    .line 59
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleItems;->names:Lcom/bestbuy/android/api/lib/models/pdp/BundleName;

    .line 60
    return-void
.end method

.method public setSkuId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 67
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleItems;->skuId:Ljava/lang/String;

    .line 68
    return-void
.end method

.method public setUrl(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 75
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleItems;->url:Ljava/lang/String;

    .line 76
    return-void
.end method

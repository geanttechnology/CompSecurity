.class public Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# static fields
.field public static a:Landroid/widget/LinearLayout;

.field private static final l:Ljava/lang/String;


# instance fields
.field private b:Landroid/app/Activity;

.field private c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

.field private g:Landroid/view/View;

.field private h:Z

.field private i:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

.field private j:Landroid/widget/LinearLayout;

.field private k:Landroid/widget/LinearLayout;

.field private m:D

.field private n:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

.field private o:Ljava/lang/String;

.field private p:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 51
    const-class v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->l:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    .line 58
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 53
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->m:D

    .line 60
    return-void
.end method

.method public constructor <init>(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;ZLcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;)V
    .locals 2

    .prologue
    .line 74
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 53
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->m:D

    .line 75
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    .line 76
    iput-object p2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->i:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    .line 77
    iput-boolean p3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->h:Z

    .line 78
    iput-object p4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->n:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    .line 80
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 81
    const-string v1, "product"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 82
    const-string v1, "dnmProduct"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 83
    const-string v1, "pdpOverviewResponse"

    invoke-virtual {v0, v1, p4}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 84
    const-string v1, "isFromDNM"

    invoke-virtual {v0, v1, p3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 85
    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->setArguments(Landroid/os/Bundle;)V

    .line 86
    return-void
.end method

.method private a(Lcom/bestbuy/android/activities/mdot/MdotWebFragment;)V
    .locals 4

    .prologue
    .line 305
    :try_start_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->b:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->b:Landroid/app/Activity;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarShareVisibility(Landroid/app/Activity;Z)V

    .line 306
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->b:Landroid/app/Activity;

    check-cast v0, Landroid/support/v4/app/FragmentActivity;

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const v1, 0x7f0c0033

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 307
    instance-of v1, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v1, :cond_0

    .line 308
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 309
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->e()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 310
    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    const/4 v1, 0x1

    invoke-virtual {v0, p1, v1}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 315
    :cond_0
    :goto_0
    return-void

    .line 312
    :catch_0
    move-exception v0

    .line 313
    sget-object v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->l:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Error attempting to open delievery mDot punch out"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lkf;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;)V
    .locals 11

    .prologue
    const v10, 0x7f0c0293

    const v9, 0x7f0200d0

    const/4 v2, 0x4

    const/4 v3, 0x1

    const/4 v7, 0x0

    .line 163
    .line 164
    new-instance v1, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-direct {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;-><init>()V

    .line 165
    invoke-virtual {v1, p1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->setPriceBlock(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;)V

    .line 166
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getRestrictedPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 167
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getRestrictedPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getPrice()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->setRestrictedPrice(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;)V

    .line 169
    :cond_0
    new-instance v8, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    invoke-direct {v8}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;-><init>()V

    .line 170
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->isActive()Z

    move-result v0

    invoke-virtual {v8, v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->setActive(Z)V

    .line 171
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getAttributes()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;

    move-result-object v0

    invoke-virtual {v8, v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->setAttributes(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;)V

    .line 172
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getAvailability()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;

    move-result-object v0

    invoke-virtual {v8, v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->setAvailability(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;)V

    .line 173
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getBrand()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Brand;

    move-result-object v0

    invoke-virtual {v8, v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->setBrand(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Brand;)V

    .line 174
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getNames()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;

    move-result-object v0

    invoke-virtual {v8, v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->setNames(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;)V

    .line 175
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getMedia()Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;

    move-result-object v0

    invoke-virtual {v8, v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->setPdpMedia(Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;)V

    .line 178
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCondition()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v8, v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->setCondition(Ljava/lang/String;)V

    .line 179
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v0

    invoke-virtual {v8, v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->setCustomerRatings(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;)V

    .line 180
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getDepartment()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Department;

    move-result-object v0

    invoke-virtual {v8, v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->setDepartment(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Department;)V

    .line 181
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getDescriptions()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Descriptions;

    move-result-object v0

    invoke-virtual {v8, v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->setDescriptions(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Descriptions;)V

    .line 183
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProductId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v8, v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->setItemId(Ljava/lang/String;)V

    .line 184
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getManufacturerId()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Manufacturer;

    move-result-object v0

    invoke-virtual {v8, v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->setManufacturerId(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Manufacturer;)V

    .line 186
    new-instance v0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Properties;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Properties;-><init>()V

    .line 188
    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProperties()Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;->getFreeShippingCode()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Properties;->setChatType(Ljava/lang/String;)V

    .line 189
    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProperties()Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;->getContractCondition()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Properties;->setContractCondition(Ljava/lang/String;)V

    .line 190
    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProperties()Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;->getFileSize()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Properties;->setFileSize(Ljava/lang/String;)V

    .line 191
    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProperties()Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;->getFormat()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Properties;->setFormat(Ljava/lang/String;)V

    .line 192
    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProperties()Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;->getFreeShippingCode()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Properties;->setFreeShippingCode(Ljava/lang/String;)V

    .line 193
    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProperties()Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;->getMediaType()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Properties;->setMediaType(Ljava/lang/String;)V

    .line 194
    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProperties()Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;->getTopHat()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Properties;->setTopHat(Ljava/lang/String;)V

    .line 195
    invoke-virtual {v8, v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->setProperties(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Properties;)V

    .line 197
    invoke-virtual {v1, v8}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->setSummary(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;)V

    .line 198
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->g:Landroid/view/View;

    const v4, 0x7f0c028c

    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    sput-object v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->a:Landroid/widget/LinearLayout;

    .line 199
    sget-object v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->a:Landroid/widget/LinearLayout;

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->removeAllViewsInLayout()V

    .line 200
    if-eqz p1, :cond_1

    .line 201
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0, p1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->setPriceBlock(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;)V

    .line 202
    :cond_1
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->h:Z

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->i:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    if-eqz v0, :cond_2

    .line 203
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->h:Z

    if-eqz v0, :cond_7

    .line 205
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->i:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getSkuTypeCode()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_6

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->i:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getSkuTypeCode()Ljava/lang/String;

    move-result-object v0

    const v4, 0x7f080068

    invoke-virtual {p0, v4}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_6

    .line 206
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->i:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getSkuTypeCode()Ljava/lang/String;

    move-result-object v0

    const v4, 0x7f08003a

    invoke-virtual {p0, v4}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    move v5, v3

    .line 218
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->b:Landroid/app/Activity;

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->i:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->o:Ljava/lang/String;

    invoke-static/range {v0 .. v6}, Llp;->a(Landroid/app/Activity;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;IZLcom/bestbuy/android/api/lib/models/dnm/DNMProduct;ZLjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 222
    :goto_1
    sget-object v3, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->a:Landroid/widget/LinearLayout;

    invoke-virtual {v3, v0}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 224
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->i:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    if-eqz v0, :cond_8

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->i:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getOpenBoxCondition()Ljava/lang/String;

    move-result-object v0

    const-string v3, "Certified"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 225
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->k:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 226
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->k:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 270
    :cond_3
    :goto_2
    return-void

    .line 209
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->i:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getSkuDisplayable()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_5

    .line 210
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->i:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getSkuDisplayable()Ljava/lang/String;

    move-result-object v0

    const-string v4, "1"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_14

    move v5, v3

    .line 211
    goto :goto_0

    :cond_5
    move v5, v7

    .line 214
    goto :goto_0

    :cond_6
    move v5, v7

    .line 217
    goto :goto_0

    .line 220
    :cond_7
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->b:Landroid/app/Activity;

    const/4 v4, 0x0

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->o:Ljava/lang/String;

    move v3, v7

    move v5, v7

    invoke-static/range {v0 .. v6}, Llp;->a(Landroid/app/Activity;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;IZLcom/bestbuy/android/api/lib/models/dnm/DNMProduct;ZLjava/lang/String;)Landroid/view/View;

    move-result-object v0

    goto :goto_1

    .line 227
    :cond_8
    if-eqz v8, :cond_12

    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->h:Z

    if-nez v0, :cond_12

    .line 228
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->b:Landroid/app/Activity;

    const/4 v4, 0x0

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->o:Ljava/lang/String;

    move v3, v7

    move v5, v7

    invoke-static/range {v0 .. v6}, Llp;->a(Landroid/app/Activity;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;IZLcom/bestbuy/android/api/lib/models/dnm/DNMProduct;ZLjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 229
    sget-object v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->a:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v0}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 230
    invoke-virtual {v8}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getProperties()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Properties;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Properties;->getFreeShippingCode()Ljava/lang/String;

    move-result-object v2

    .line 231
    invoke-virtual {v8}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getAttributes()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;

    move-result-object v0

    if-eqz v0, :cond_9

    invoke-virtual {v8}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getAttributes()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;->isLowPriceGuaranteedProduct()Z

    move-result v0

    if-nez v0, :cond_a

    :cond_9
    if-eqz v2, :cond_11

    const-string v0, "freeShipping"

    invoke-virtual {v2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_a

    const-string v0, "freeDeliveryAppliance"

    invoke-virtual {v2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_a

    const-string v0, "freeDeliveryTVs50in"

    invoke-virtual {v2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_11

    .line 236
    :cond_a
    if-eqz v2, :cond_d

    const-string v0, "freeShipping"

    invoke-virtual {v2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_b

    const-string v0, "freeDeliveryAppliance"

    invoke-virtual {v2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_b

    const-string v0, "freeDeliveryTVs50in"

    invoke-virtual {v2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_d

    .line 237
    :cond_b
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->g:Landroid/view/View;

    const v1, 0x7f0c0292

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v7}, Landroid/view/View;->setVisibility(I)V

    .line 238
    const-string v0, ""

    .line 239
    const-string v1, "freeShipping"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_e

    .line 240
    const-string v0, "FREE SHIPPING"

    .line 251
    :cond_c
    :goto_3
    const-string v1, "freeDeliveryAppliance"

    invoke-virtual {v2, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_13

    .line 252
    const-string v0, "freeDeliveryAppliance"

    const-string v1, ""

    invoke-virtual {v2, v0, v1}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 253
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "FREE DELIVERY ON ORDERS $"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " & UP"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 254
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->g:Landroid/view/View;

    invoke-virtual {v0, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    invoke-virtual {v0, v9}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 256
    :goto_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->g:Landroid/view/View;

    const v2, 0x7f0c0294

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 257
    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 259
    :cond_d
    invoke-virtual {v8}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getAttributes()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;

    move-result-object v0

    if-eqz v0, :cond_3

    invoke-virtual {v8}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getAttributes()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;->isLowPriceGuaranteedProduct()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 260
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->g:Landroid/view/View;

    const v1, 0x7f0c0291

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v7}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_2

    .line 241
    :cond_e
    const-string v1, "freeDeliveryAppliance"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_f

    .line 242
    const-string v1, "FREE DELIVERY"

    .line 243
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->g:Landroid/view/View;

    invoke-virtual {v0, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    invoke-virtual {v0, v9}, Landroid/widget/ImageView;->setImageResource(I)V

    move-object v0, v1

    goto :goto_3

    .line 244
    :cond_f
    const-string v1, "freeDeliveryTVs50in"

    invoke-virtual {v2, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_10

    .line 245
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->g:Landroid/view/View;

    invoke-virtual {v0, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    invoke-virtual {v0, v9}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 246
    const-string v0, "FREE DELIVERY ON TVS 51\" AND LARGER"

    goto/16 :goto_3

    .line 248
    :cond_10
    const-string v1, "freeShipping"

    invoke-virtual {v2, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_c

    .line 249
    const-string v0, "freeShipping"

    const-string v1, ""

    invoke-virtual {v2, v0, v1}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 250
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "FREE SHIPPING ON ORDERS $"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " & UP"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_3

    .line 264
    :cond_11
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->g:Landroid/view/View;

    const v1, 0x7f0c0290

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_2

    .line 268
    :cond_12
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->g:Landroid/view/View;

    const v1, 0x7f0c0290

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_2

    :cond_13
    move-object v1, v0

    goto/16 :goto_4

    :cond_14
    move v5, v7

    goto/16 :goto_0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 95
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 96
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    if-eqz v0, :cond_0

    .line 97
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    .line 98
    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->a(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;)V

    .line 100
    :cond_0
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 90
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 91
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->b:Landroid/app/Activity;

    .line 92
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 5

    .prologue
    .line 274
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->j:Landroid/widget/LinearLayout;

    if-ne p1, v0, :cond_0

    .line 275
    iget-wide v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->m:D

    const-wide/16 v2, 0x0

    cmpl-double v0, v0, v2

    if-eqz v0, :cond_0

    .line 276
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 277
    const-string v1, "bb.ratingsReviews"

    const-string v2, "1"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 278
    const-string v1, "bb.reviewsInteraction"

    const-string v2, "Ratings & Reviews: PDP"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 279
    const-string v1, "bb.prevPageLink"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->o:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "pdp: reviews"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 280
    const-string v1, "&&products"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, ";"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSkuId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 281
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->o:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "pdp: reviews"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 283
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    .line 284
    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->n:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    invoke-direct {v1, v2, v3, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;-><init>(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;)V

    .line 285
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 286
    const-string v3, "BreadCrumb"

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->o:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 287
    const-string v3, "PDPOverviewResponseRoot"

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->p:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;

    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 288
    invoke-virtual {v1, v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->setArguments(Landroid/os/Bundle;)V

    .line 289
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 292
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->k:Landroid/widget/LinearLayout;

    if-ne p1, v0, :cond_1

    .line 293
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->b:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getCurrentActionBarTitle()Ljava/lang/String;

    move-result-object v0

    .line 294
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->f:Lnb;

    invoke-virtual {v1, v0}, Lnb;->i(Ljava/lang/String;)V

    .line 295
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->b:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0801b8

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 296
    new-instance v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;-><init>(Z)V

    .line 297
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 298
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080055

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    const-string v3, "file:///android_asset/geek-certified-info.html"

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 299
    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->setArguments(Landroid/os/Bundle;)V

    .line 300
    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->a(Lcom/bestbuy/android/activities/mdot/MdotWebFragment;)V

    .line 302
    :cond_1
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 103
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 104
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    if-nez v0, :cond_0

    .line 105
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    .line 106
    if-eqz v1, :cond_0

    .line 107
    const-string v0, "BreadCrumb"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->o:Ljava/lang/String;

    .line 108
    const-string v0, "PDPOverviewResponseRoot"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->p:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;

    .line 110
    const-string v0, "product"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    .line 111
    const-string v0, "dnmProduct"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->i:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    .line 112
    const-string v0, "isFromDNM"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->h:Z

    .line 113
    const-string v0, "pdpOverviewResponse"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->n:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    .line 116
    :cond_0
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 8

    .prologue
    const/4 v1, 0x0

    const/16 v6, 0x8

    .line 120
    .line 121
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->h:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->i:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    if-eqz v0, :cond_0

    .line 122
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->i:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getCustomerRating()D

    move-result-wide v2

    iput-wide v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->m:D

    .line 123
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->i:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getNumberOfReviews()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    move v3, v0

    .line 130
    :goto_0
    const v0, 0x7f0300aa

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->g:Landroid/view/View;

    .line 131
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->g:Landroid/view/View;

    const v1, 0x7f0c028d

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->j:Landroid/widget/LinearLayout;

    .line 132
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->g:Landroid/view/View;

    const v1, 0x7f0c0295

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->k:Landroid/widget/LinearLayout;

    .line 133
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->g:Landroid/view/View;

    const v1, 0x7f0c00cb

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RatingBar;

    .line 134
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->g:Landroid/view/View;

    const v2, 0x7f0c00cc

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 135
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->g:Landroid/view/View;

    const v4, 0x7f0c028e

    invoke-virtual {v2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 136
    const/4 v4, 0x5

    invoke-virtual {v0, v4}, Landroid/widget/RatingBar;->setNumStars(I)V

    .line 137
    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    if-eqz v4, :cond_1

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProductType()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_1

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProductType()Ljava/lang/String;

    move-result-object v4

    const-string v5, "bundle"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 138
    invoke-virtual {v0, v6}, Landroid/widget/RatingBar;->setVisibility(I)V

    .line 139
    invoke-virtual {v1, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 140
    invoke-virtual {v2, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 154
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->j:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 155
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->g:Landroid/view/View;

    return-object v0

    .line 125
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v0

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    move-result-object v0

    if-eqz v0, :cond_4

    .line 126
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;->getScore()D

    move-result-wide v2

    iput-wide v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->m:D

    .line 127
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->c:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getTotalCount()I

    move-result v0

    move v3, v0

    goto/16 :goto_0

    .line 142
    :cond_1
    iget-wide v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->m:D

    const-wide/16 v6, 0x0

    cmpl-double v4, v4, v6

    if-eqz v4, :cond_3

    .line 143
    iget-wide v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->m:D

    double-to-float v4, v4

    invoke-virtual {v0, v4}, Landroid/widget/RatingBar;->setRating(F)V

    .line 144
    const/4 v0, 0x1

    if-ne v3, v0, :cond_2

    .line 145
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "("

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, " "

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->b:Landroid/app/Activity;

    const v4, 0x7f0802df

    invoke-virtual {v3, v4}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 149
    :goto_2
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->m:D

    invoke-virtual {v0, v4, v5}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 147
    :cond_2
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "("

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, " "

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->b:Landroid/app/Activity;

    const v4, 0x7f0802e0

    invoke-virtual {v3, v4}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_2

    .line 151
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;->b:Landroid/app/Activity;

    const v2, 0x7f080394

    invoke-virtual {v0, v2}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_1

    :cond_4
    move v3, v1

    goto/16 :goto_0
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 159
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 160
    return-void
.end method

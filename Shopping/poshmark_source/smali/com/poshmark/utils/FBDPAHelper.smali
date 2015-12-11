.class public Lcom/poshmark/utils/FBDPAHelper;
.super Ljava/lang/Object;
.source "FBDPAHelper.java"


# static fields
.field public static CONTENT_TYPE_PRODUCT:Ljava/lang/String;

.field public static PM_EVENT_NAME_COMMENT:Ljava/lang/String;

.field public static PURCHASE_TYPE_BUNDLE:Ljava/lang/String;

.field public static PURCHASE_TYPE_OFFER:Ljava/lang/String;

.field public static PURCHASE_TYPE_SINGLE_LISTING:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 24
    const-string v0, "Comment"

    sput-object v0, Lcom/poshmark/utils/FBDPAHelper;->PM_EVENT_NAME_COMMENT:Ljava/lang/String;

    .line 25
    const-string v0, "product"

    sput-object v0, Lcom/poshmark/utils/FBDPAHelper;->CONTENT_TYPE_PRODUCT:Ljava/lang/String;

    .line 28
    const-string v0, "single"

    sput-object v0, Lcom/poshmark/utils/FBDPAHelper;->PURCHASE_TYPE_SINGLE_LISTING:Ljava/lang/String;

    .line 29
    const-string v0, "bundle"

    sput-object v0, Lcom/poshmark/utils/FBDPAHelper;->PURCHASE_TYPE_BUNDLE:Ljava/lang/String;

    .line 30
    const-string v0, "offer"

    sput-object v0, Lcom/poshmark/utils/FBDPAHelper;->PURCHASE_TYPE_OFFER:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static getBundleForTracking(Lcom/poshmark/data_model/models/ListingSummary;)Landroid/os/Bundle;
    .locals 5
    .param p0, "listing"    # Lcom/poshmark/data_model/models/ListingSummary;

    .prologue
    .line 128
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 129
    .local v0, "b":Landroid/os/Bundle;
    const-string v3, "brand"

    invoke-virtual {p0}, Lcom/poshmark/data_model/models/ListingSummary;->getBrand()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 130
    const-string v3, "category"

    invoke-virtual {p0}, Lcom/poshmark/data_model/models/ListingSummary;->getCategoryLabel()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 131
    invoke-virtual {p0}, Lcom/poshmark/data_model/models/ListingSummary;->getSubCategoryList()Ljava/util/List;

    move-result-object v2

    .line 132
    .local v2, "subcats":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    if-eqz v2, :cond_0

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v3

    if-lez v3, :cond_0

    .line 133
    const/4 v3, 0x0

    invoke-interface {v2, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/MetaItem;

    .line 134
    .local v1, "subCat":Lcom/poshmark/data_model/models/MetaItem;
    const-string v3, "subcategory"

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 136
    .end local v1    # "subCat":Lcom/poshmark/data_model/models/MetaItem;
    :cond_0
    const-string v3, "fb_content_type"

    sget-object v4, Lcom/poshmark/utils/FBDPAHelper;->CONTENT_TYPE_PRODUCT:Ljava/lang/String;

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 137
    const-string v3, "fb_content_id"

    invoke-virtual {p0}, Lcom/poshmark/data_model/models/ListingSummary;->getIdAsString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 138
    const-string v3, "fb_currency"

    const-string v4, "USD"

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 139
    return-object v0
.end method

.method public static trackAddToCart(Lcom/poshmark/data_model/models/ListingSummary;Ljava/lang/String;)V
    .locals 8
    .param p0, "listing"    # Lcom/poshmark/data_model/models/ListingSummary;
    .param p1, "purchaseType"    # Ljava/lang/String;

    .prologue
    .line 96
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getApplicationObject()Lcom/poshmark/application/PMApplication;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplication;->getTopActivity()Lcom/poshmark/ui/PMActivity;

    move-result-object v1

    .line 97
    .local v1, "context":Landroid/content/Context;
    const v4, 0x7f06010b

    invoke-virtual {v1, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v1, v4}, Lcom/facebook/appevents/AppEventsLogger;->newLogger(Landroid/content/Context;Ljava/lang/String;)Lcom/facebook/appevents/AppEventsLogger;

    move-result-object v2

    .line 99
    .local v2, "logger":Lcom/facebook/appevents/AppEventsLogger;
    invoke-static {p0}, Lcom/poshmark/utils/FBDPAHelper;->getBundleForTracking(Lcom/poshmark/data_model/models/ListingSummary;)Landroid/os/Bundle;

    move-result-object v0

    .line 100
    .local v0, "b":Landroid/os/Bundle;
    const-string v4, "type"

    invoke-virtual {v0, v4, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 101
    invoke-virtual {p0}, Lcom/poshmark/data_model/models/ListingSummary;->getPrice()Ljava/math/BigDecimal;

    move-result-object v4

    invoke-virtual {v4}, Ljava/math/BigDecimal;->floatValue()F

    move-result v3

    .line 102
    .local v3, "price":F
    const-string v4, "fb_mobile_add_to_cart"

    float-to-double v6, v3

    invoke-virtual {v2, v4, v6, v7, v0}, Lcom/facebook/appevents/AppEventsLogger;->logEvent(Ljava/lang/String;DLandroid/os/Bundle;)V

    .line 103
    return-void
.end method

.method public static trackBundlePurchaseInitiated(Lcom/poshmark/data_model/models/PMBundle;)V
    .locals 3
    .param p0, "bundleData"    # Lcom/poshmark/data_model/models/PMBundle;

    .prologue
    .line 86
    if-eqz p0, :cond_0

    .line 87
    invoke-virtual {p0}, Lcom/poshmark/data_model/models/PMBundle;->getList()Ljava/util/List;

    move-result-object v0

    .line 88
    .local v0, "items":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/ListingSummary;>;"
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_0

    .line 89
    const/4 v2, 0x0

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/ListingSummary;

    .line 90
    .local v1, "listing":Lcom/poshmark/data_model/models/ListingSummary;
    sget-object v2, Lcom/poshmark/utils/FBDPAHelper;->PURCHASE_TYPE_BUNDLE:Ljava/lang/String;

    invoke-static {v1, v2}, Lcom/poshmark/utils/FBDPAHelper;->trackListingPurchaseInitiated(Lcom/poshmark/data_model/models/ListingSummary;Ljava/lang/String;)V

    .line 93
    .end local v0    # "items":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/ListingSummary;>;"
    .end local v1    # "listing":Lcom/poshmark/data_model/models/ListingSummary;
    :cond_0
    return-void
.end method

.method public static trackComment(Lcom/poshmark/data_model/models/ListingSummary;)V
    .locals 5
    .param p0, "listing"    # Lcom/poshmark/data_model/models/ListingSummary;

    .prologue
    .line 116
    if-eqz p0, :cond_0

    .line 117
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0}, Lcom/poshmark/data_model/models/ListingSummary;->getUserId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 118
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getApplicationObject()Lcom/poshmark/application/PMApplication;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplication;->getTopActivity()Lcom/poshmark/ui/PMActivity;

    move-result-object v1

    .line 119
    .local v1, "context":Landroid/content/Context;
    const v3, 0x7f06010b

    invoke-virtual {v1, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3}, Lcom/facebook/appevents/AppEventsLogger;->newLogger(Landroid/content/Context;Ljava/lang/String;)Lcom/facebook/appevents/AppEventsLogger;

    move-result-object v2

    .line 121
    .local v2, "logger":Lcom/facebook/appevents/AppEventsLogger;
    invoke-static {p0}, Lcom/poshmark/utils/FBDPAHelper;->getBundleForTracking(Lcom/poshmark/data_model/models/ListingSummary;)Landroid/os/Bundle;

    move-result-object v0

    .line 122
    .local v0, "b":Landroid/os/Bundle;
    sget-object v3, Lcom/poshmark/utils/FBDPAHelper;->PM_EVENT_NAME_COMMENT:Ljava/lang/String;

    invoke-virtual {v2, v3, v0}, Lcom/facebook/appevents/AppEventsLogger;->logEvent(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 125
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v1    # "context":Landroid/content/Context;
    .end local v2    # "logger":Lcom/facebook/appevents/AppEventsLogger;
    :cond_0
    return-void
.end method

.method public static trackListingLike(Lcom/poshmark/data_model/models/ListingSummary;)V
    .locals 8
    .param p0, "listing"    # Lcom/poshmark/data_model/models/ListingSummary;

    .prologue
    .line 53
    if-eqz p0, :cond_0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0}, Lcom/poshmark/data_model/models/ListingSummary;->getUserId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 54
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getApplicationObject()Lcom/poshmark/application/PMApplication;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplication;->getTopActivity()Lcom/poshmark/ui/PMActivity;

    move-result-object v1

    .line 55
    .local v1, "context":Landroid/content/Context;
    const v4, 0x7f06010b

    invoke-virtual {v1, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v1, v4}, Lcom/facebook/appevents/AppEventsLogger;->newLogger(Landroid/content/Context;Ljava/lang/String;)Lcom/facebook/appevents/AppEventsLogger;

    move-result-object v2

    .line 57
    .local v2, "logger":Lcom/facebook/appevents/AppEventsLogger;
    invoke-static {p0}, Lcom/poshmark/utils/FBDPAHelper;->getBundleForTracking(Lcom/poshmark/data_model/models/ListingSummary;)Landroid/os/Bundle;

    move-result-object v0

    .line 58
    .local v0, "b":Landroid/os/Bundle;
    invoke-virtual {p0}, Lcom/poshmark/data_model/models/ListingSummary;->getPrice()Ljava/math/BigDecimal;

    move-result-object v4

    invoke-virtual {v4}, Ljava/math/BigDecimal;->floatValue()F

    move-result v3

    .line 60
    .local v3, "price":F
    const-string v4, "fb_mobile_add_to_wishlist"

    float-to-double v6, v3

    invoke-virtual {v2, v4, v6, v7, v0}, Lcom/facebook/appevents/AppEventsLogger;->logEvent(Ljava/lang/String;DLandroid/os/Bundle;)V

    .line 62
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v1    # "context":Landroid/content/Context;
    .end local v2    # "logger":Lcom/facebook/appevents/AppEventsLogger;
    .end local v3    # "price":F
    :cond_0
    return-void
.end method

.method public static trackListingPurchaseInitiated(Lcom/poshmark/data_model/models/ListingSummary;Ljava/lang/String;)V
    .locals 8
    .param p0, "listing"    # Lcom/poshmark/data_model/models/ListingSummary;
    .param p1, "purchaseType"    # Ljava/lang/String;

    .prologue
    .line 75
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getApplicationObject()Lcom/poshmark/application/PMApplication;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplication;->getTopActivity()Lcom/poshmark/ui/PMActivity;

    move-result-object v1

    .line 76
    .local v1, "context":Landroid/content/Context;
    const v4, 0x7f06010b

    invoke-virtual {v1, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v1, v4}, Lcom/facebook/appevents/AppEventsLogger;->newLogger(Landroid/content/Context;Ljava/lang/String;)Lcom/facebook/appevents/AppEventsLogger;

    move-result-object v2

    .line 78
    .local v2, "logger":Lcom/facebook/appevents/AppEventsLogger;
    invoke-static {p0}, Lcom/poshmark/utils/FBDPAHelper;->getBundleForTracking(Lcom/poshmark/data_model/models/ListingSummary;)Landroid/os/Bundle;

    move-result-object v0

    .line 79
    .local v0, "b":Landroid/os/Bundle;
    const-string v4, "type"

    invoke-virtual {v0, v4, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 81
    invoke-virtual {p0}, Lcom/poshmark/data_model/models/ListingSummary;->getPrice()Ljava/math/BigDecimal;

    move-result-object v4

    invoke-virtual {v4}, Ljava/math/BigDecimal;->floatValue()F

    move-result v3

    .line 82
    .local v3, "price":F
    const-string v4, "fb_mobile_initiated_checkout"

    float-to-double v6, v3

    invoke-virtual {v2, v4, v6, v7, v0}, Lcom/facebook/appevents/AppEventsLogger;->logEvent(Ljava/lang/String;DLandroid/os/Bundle;)V

    .line 83
    return-void
.end method

.method public static trackListingView(Lcom/poshmark/data_model/models/ListingDetails;Ljava/util/List;)V
    .locals 8
    .param p0, "listing"    # Lcom/poshmark/data_model/models/ListingDetails;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/data_model/models/ListingDetails;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "screenStack":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v7, 0x1

    .line 36
    if-eqz p0, :cond_1

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p0}, Lcom/poshmark/data_model/models/ListingDetails;->getUserId()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_1

    .line 38
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getApplicationObject()Lcom/poshmark/application/PMApplication;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplication;->getTopActivity()Lcom/poshmark/ui/PMActivity;

    move-result-object v1

    .line 39
    .local v1, "context":Landroid/content/Context;
    const v5, 0x7f06010b

    invoke-virtual {v1, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-static {v1, v5}, Lcom/facebook/appevents/AppEventsLogger;->newLogger(Landroid/content/Context;Ljava/lang/String;)Lcom/facebook/appevents/AppEventsLogger;

    move-result-object v2

    .line 41
    .local v2, "logger":Lcom/facebook/appevents/AppEventsLogger;
    invoke-static {p0}, Lcom/poshmark/utils/FBDPAHelper;->getBundleForTracking(Lcom/poshmark/data_model/models/ListingSummary;)Landroid/os/Bundle;

    move-result-object v0

    .line 42
    .local v0, "b":Landroid/os/Bundle;
    if-eqz p1, :cond_0

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v5

    if-le v5, v7, :cond_0

    .line 43
    invoke-interface {p1, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 44
    .local v3, "prevScreen":Ljava/lang/String;
    const-string v5, "vector"

    invoke-virtual {v0, v5, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 46
    .end local v3    # "prevScreen":Ljava/lang/String;
    :cond_0
    invoke-virtual {p0}, Lcom/poshmark/data_model/models/ListingDetails;->getPrice()Ljava/math/BigDecimal;

    move-result-object v5

    invoke-virtual {v5}, Ljava/math/BigDecimal;->floatValue()F

    move-result v4

    .line 48
    .local v4, "price":F
    const-string v5, "fb_mobile_content_view"

    float-to-double v6, v4

    invoke-virtual {v2, v5, v6, v7, v0}, Lcom/facebook/appevents/AppEventsLogger;->logEvent(Ljava/lang/String;DLandroid/os/Bundle;)V

    .line 50
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v1    # "context":Landroid/content/Context;
    .end local v2    # "logger":Lcom/facebook/appevents/AppEventsLogger;
    .end local v4    # "price":F
    :cond_1
    return-void
.end method

.method public static trackPurchase(Lcom/poshmark/utils/CheckoutFlowHandler;Ljava/math/BigDecimal;)V
    .locals 8
    .param p0, "flowHandler"    # Lcom/poshmark/utils/CheckoutFlowHandler;
    .param p1, "totalPrice"    # Ljava/math/BigDecimal;

    .prologue
    .line 107
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getApplicationObject()Lcom/poshmark/application/PMApplication;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplication;->getTopActivity()Lcom/poshmark/ui/PMActivity;

    move-result-object v1

    .line 108
    .local v1, "context":Landroid/content/Context;
    const v4, 0x7f06010b

    invoke-virtual {v1, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v1, v4}, Lcom/facebook/appevents/AppEventsLogger;->newLogger(Landroid/content/Context;Ljava/lang/String;)Lcom/facebook/appevents/AppEventsLogger;

    move-result-object v3

    .line 110
    .local v3, "logger":Lcom/facebook/appevents/AppEventsLogger;
    invoke-virtual {p0}, Lcom/poshmark/utils/CheckoutFlowHandler;->getListingDetails()Lcom/poshmark/data_model/models/ListingSummary;

    move-result-object v2

    .line 111
    .local v2, "listing":Lcom/poshmark/data_model/models/ListingSummary;
    invoke-static {v2}, Lcom/poshmark/utils/FBDPAHelper;->getBundleForTracking(Lcom/poshmark/data_model/models/ListingSummary;)Landroid/os/Bundle;

    move-result-object v0

    .line 112
    .local v0, "b":Landroid/os/Bundle;
    const-string v4, "fb_mobile_purchase"

    invoke-virtual {p1}, Ljava/math/BigDecimal;->doubleValue()D

    move-result-wide v6

    invoke-virtual {v3, v4, v6, v7, v0}, Lcom/facebook/appevents/AppEventsLogger;->logEvent(Ljava/lang/String;DLandroid/os/Bundle;)V

    .line 113
    return-void
.end method

.method public static trackSearch(Ljava/lang/String;)V
    .locals 5
    .param p0, "searchString"    # Ljava/lang/String;

    .prologue
    .line 65
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getApplicationObject()Lcom/poshmark/application/PMApplication;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplication;->getTopActivity()Lcom/poshmark/ui/PMActivity;

    move-result-object v1

    .line 66
    .local v1, "context":Landroid/content/Context;
    const v3, 0x7f06010b

    invoke-virtual {v1, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3}, Lcom/facebook/appevents/AppEventsLogger;->newLogger(Landroid/content/Context;Ljava/lang/String;)Lcom/facebook/appevents/AppEventsLogger;

    move-result-object v2

    .line 67
    .local v2, "logger":Lcom/facebook/appevents/AppEventsLogger;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 68
    .local v0, "b":Landroid/os/Bundle;
    const-string v3, "fb_content_type"

    sget-object v4, Lcom/poshmark/utils/FBDPAHelper;->CONTENT_TYPE_PRODUCT:Ljava/lang/String;

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 69
    const-string v3, "fb_search_string"

    invoke-virtual {v0, v3, p0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 71
    const-string v3, "fb_mobile_search"

    invoke-virtual {v2, v3, v0}, Lcom/facebook/appevents/AppEventsLogger;->logEvent(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 72
    return-void
.end method

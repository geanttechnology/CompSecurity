.class public final Lcom/amazon/mShop/control/item/ClickStreamTag;
.super Ljava/lang/Object;
.source "ClickStreamTag.java"


# static fields
.field public static final ORIGIN_BARCODE:Lcom/amazon/mShop/control/item/ClickStreamTag;

.field public static final ORIGIN_BARCODE_MATCH:Lcom/amazon/mShop/control/item/ClickStreamTag;

.field public static final ORIGIN_BROWSE:Lcom/amazon/mShop/control/item/ClickStreamTag;

.field public static final ORIGIN_CART:Lcom/amazon/mShop/control/item/ClickStreamTag;

.field public static final ORIGIN_DEAL:Lcom/amazon/mShop/control/item/ClickStreamTag;

.field public static final ORIGIN_DEFAULT:Lcom/amazon/mShop/control/item/ClickStreamTag;

.field public static final ORIGIN_HOME:Lcom/amazon/mShop/control/item/ClickStreamTag;

.field public static final ORIGIN_MOBILEADS:Lcom/amazon/mShop/control/item/ClickStreamTag;

.field public static final ORIGIN_NOTIFICATION:Lcom/amazon/mShop/control/item/ClickStreamTag;

.field public static final ORIGIN_ORDER:Lcom/amazon/mShop/control/item/ClickStreamTag;

.field public static final ORIGIN_PRICECHECK_HOME_SAVED_PRODUCT:Lcom/amazon/mShop/control/item/ClickStreamTag;

.field public static final ORIGIN_PUBLIC_URL:Lcom/amazon/mShop/control/item/ClickStreamTag;

.field public static final ORIGIN_RECOMMENDATIONS:Lcom/amazon/mShop/control/item/ClickStreamTag;

.field public static final ORIGIN_RECOMMENDEDITEMS:Lcom/amazon/mShop/control/item/ClickStreamTag;

.field public static final ORIGIN_REMEMBERS:Lcom/amazon/mShop/control/item/ClickStreamTag;

.field public static final ORIGIN_RVI:Lcom/amazon/mShop/control/item/ClickStreamTag;

.field public static final ORIGIN_SEARCH:Lcom/amazon/mShop/control/item/ClickStreamTag;

.field public static final ORIGIN_SEARCH_VOICE:Lcom/amazon/mShop/control/item/ClickStreamTag;

.field public static final ORIGIN_SEARCH_VOICE_CORRECTION:Lcom/amazon/mShop/control/item/ClickStreamTag;

.field public static final ORIGIN_SIMILAR_ITEMS:Lcom/amazon/mShop/control/item/ClickStreamTag;

.field public static final ORIGIN_SNAP_TELL:Lcom/amazon/mShop/control/item/ClickStreamTag;

.field public static final ORIGIN_VIEW_IT_BARCODE_ACTIVATED_FROM_DEEP_LINK:Lcom/amazon/mShop/control/item/ClickStreamTag;

.field public static final ORIGIN_VIEW_IT_BARCODE_ACTIVATED_FROM_HOME:Lcom/amazon/mShop/control/item/ClickStreamTag;

.field public static final ORIGIN_VIEW_IT_BARCODE_ACTIVATED_FROM_SEARCH:Lcom/amazon/mShop/control/item/ClickStreamTag;

.field public static final ORIGIN_VIEW_IT_FLOW_ACTIVATED_FROM_DEEP_LINK:Lcom/amazon/mShop/control/item/ClickStreamTag;

.field public static final ORIGIN_VIEW_IT_FLOW_ACTIVATED_FROM_SEARCH:Lcom/amazon/mShop/control/item/ClickStreamTag;

.field public static final ORIGIN_VIEW_IT_FLOW_ALL_MATCHES_BARCODE:Lcom/amazon/mShop/control/item/ClickStreamTag;

.field public static final ORIGIN_VIEW_IT_FLOW_ALL_MATCHES_IMAGE:Lcom/amazon/mShop/control/item/ClickStreamTag;

.field public static final ORIGIN_VIEW_IT_FLOW_EXPANDED_TRAY_BARCODE:Lcom/amazon/mShop/control/item/ClickStreamTag;

.field public static final ORIGIN_VIEW_IT_FLOW_EXPANDED_TRAY_IMAGE:Lcom/amazon/mShop/control/item/ClickStreamTag;

.field public static final ORIGIN_VIEW_IT_FLOW_MINI_TRAY_BARCODE:Lcom/amazon/mShop/control/item/ClickStreamTag;

.field public static final ORIGIN_VIEW_IT_FLOW_MINI_TRAY_IMAGE:Lcom/amazon/mShop/control/item/ClickStreamTag;

.field public static final ORIGIN_WEARABLES_GEAR:Lcom/amazon/mShop/control/item/ClickStreamTag;

.field public static final ORIGIN_WEARABLES_WEAR:Lcom/amazon/mShop/control/item/ClickStreamTag;

.field public static final ORIGIN_WISHLIST:Lcom/amazon/mShop/control/item/ClickStreamTag;


# instance fields
.field private final tag:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 13
    new-instance v0, Lcom/amazon/mShop/control/item/ClickStreamTag;

    const-string/jumbo v1, "Cart"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_CART:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 14
    new-instance v0, Lcom/amazon/mShop/control/item/ClickStreamTag;

    const-string/jumbo v1, "Home"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_HOME:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 15
    new-instance v0, Lcom/amazon/mShop/control/item/ClickStreamTag;

    const-string/jumbo v1, "Remembers"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_REMEMBERS:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 16
    new-instance v0, Lcom/amazon/mShop/control/item/ClickStreamTag;

    const-string/jumbo v1, "SnapTell"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_SNAP_TELL:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 17
    new-instance v0, Lcom/amazon/mShop/control/item/ClickStreamTag;

    const-string/jumbo v1, "Barcode"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_BARCODE:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 18
    new-instance v0, Lcom/amazon/mShop/control/item/ClickStreamTag;

    const-string/jumbo v1, "Search"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_SEARCH:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 19
    new-instance v0, Lcom/amazon/mShop/control/item/ClickStreamTag;

    const-string/jumbo v1, "List"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_WISHLIST:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 20
    new-instance v0, Lcom/amazon/mShop/control/item/ClickStreamTag;

    const-string/jumbo v1, "Deal"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_DEAL:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 21
    new-instance v0, Lcom/amazon/mShop/control/item/ClickStreamTag;

    const-string/jumbo v1, "UndefinedClickStreamOrigin"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_DEFAULT:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 22
    new-instance v0, Lcom/amazon/mShop/control/item/ClickStreamTag;

    const-string/jumbo v1, "Browse"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_BROWSE:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 23
    new-instance v0, Lcom/amazon/mShop/control/item/ClickStreamTag;

    const-string/jumbo v1, "Recommendations"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_RECOMMENDATIONS:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 24
    new-instance v0, Lcom/amazon/mShop/control/item/ClickStreamTag;

    const-string/jumbo v1, "RecommendedItems"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_RECOMMENDEDITEMS:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 25
    new-instance v0, Lcom/amazon/mShop/control/item/ClickStreamTag;

    const-string/jumbo v1, "Order"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_ORDER:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 27
    new-instance v0, Lcom/amazon/mShop/control/item/ClickStreamTag;

    const-string/jumbo v1, "SimilarItems"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_SIMILAR_ITEMS:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 28
    new-instance v0, Lcom/amazon/mShop/control/item/ClickStreamTag;

    const-string/jumbo v1, "SearchVoice"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_SEARCH_VOICE:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 29
    new-instance v0, Lcom/amazon/mShop/control/item/ClickStreamTag;

    const-string/jumbo v1, "SearchVoiceCorrection"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_SEARCH_VOICE_CORRECTION:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 30
    new-instance v0, Lcom/amazon/mShop/control/item/ClickStreamTag;

    const-string/jumbo v1, "BarcodeMatch"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_BARCODE_MATCH:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 31
    new-instance v0, Lcom/amazon/mShop/control/item/ClickStreamTag;

    const-string/jumbo v1, "RizzoSavedProduct"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_PRICECHECK_HOME_SAVED_PRODUCT:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 33
    new-instance v0, Lcom/amazon/mShop/control/item/ClickStreamTag;

    const-string/jumbo v1, "Ads"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_MOBILEADS:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 34
    new-instance v0, Lcom/amazon/mShop/control/item/ClickStreamTag;

    const-string/jumbo v1, "Notification"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_NOTIFICATION:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 35
    new-instance v0, Lcom/amazon/mShop/control/item/ClickStreamTag;

    const-string/jumbo v1, "RecentlyViewedItems"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_RVI:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 36
    new-instance v0, Lcom/amazon/mShop/control/item/ClickStreamTag;

    const-string/jumbo v1, "PublicURL"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_PUBLIC_URL:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 39
    new-instance v0, Lcom/amazon/mShop/control/item/ClickStreamTag;

    const-string/jumbo v1, "barcode_hp"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_VIEW_IT_BARCODE_ACTIVATED_FROM_HOME:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 41
    new-instance v0, Lcom/amazon/mShop/control/item/ClickStreamTag;

    const-string/jumbo v1, "barcode_search"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_VIEW_IT_BARCODE_ACTIVATED_FROM_SEARCH:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 43
    new-instance v0, Lcom/amazon/mShop/control/item/ClickStreamTag;

    const-string/jumbo v1, "barcode_link"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_VIEW_IT_BARCODE_ACTIVATED_FROM_DEEP_LINK:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 46
    new-instance v0, Lcom/amazon/mShop/control/item/ClickStreamTag;

    const-string/jumbo v1, "fl_search"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_VIEW_IT_FLOW_ACTIVATED_FROM_SEARCH:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 48
    new-instance v0, Lcom/amazon/mShop/control/item/ClickStreamTag;

    const-string/jumbo v1, "fl_link"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_VIEW_IT_FLOW_ACTIVATED_FROM_DEEP_LINK:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 51
    new-instance v0, Lcom/amazon/mShop/control/item/ClickStreamTag;

    const-string/jumbo v1, "fl_barcode_match"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_VIEW_IT_FLOW_MINI_TRAY_BARCODE:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 53
    new-instance v0, Lcom/amazon/mShop/control/item/ClickStreamTag;

    const-string/jumbo v1, "fl_image_match"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_VIEW_IT_FLOW_MINI_TRAY_IMAGE:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 55
    new-instance v0, Lcom/amazon/mShop/control/item/ClickStreamTag;

    const-string/jumbo v1, "fl_barcode_mhist"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_VIEW_IT_FLOW_EXPANDED_TRAY_BARCODE:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 57
    new-instance v0, Lcom/amazon/mShop/control/item/ClickStreamTag;

    const-string/jumbo v1, "fl_image_mhist"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_VIEW_IT_FLOW_EXPANDED_TRAY_IMAGE:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 59
    new-instance v0, Lcom/amazon/mShop/control/item/ClickStreamTag;

    const-string/jumbo v1, "fl_barcode_histoth"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_VIEW_IT_FLOW_ALL_MATCHES_BARCODE:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 61
    new-instance v0, Lcom/amazon/mShop/control/item/ClickStreamTag;

    const-string/jumbo v1, "fl_image_histoth"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_VIEW_IT_FLOW_ALL_MATCHES_IMAGE:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 64
    new-instance v0, Lcom/amazon/mShop/control/item/ClickStreamTag;

    const-string/jumbo v1, "wearable_gear"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_WEARABLES_GEAR:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 65
    new-instance v0, Lcom/amazon/mShop/control/item/ClickStreamTag;

    const-string/jumbo v1, "wearable_wear"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_WEARABLES_WEAR:Lcom/amazon/mShop/control/item/ClickStreamTag;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "tag"    # Ljava/lang/String;

    .prologue
    .line 68
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 69
    iput-object p1, p0, Lcom/amazon/mShop/control/item/ClickStreamTag;->tag:Ljava/lang/String;

    .line 70
    return-void
.end method

.method public static createFullClickstreamTag(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "tag"    # Ljava/lang/String;

    .prologue
    .line 106
    if-eqz p0, :cond_0

    .line 107
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "mshop_ap_am_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 109
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 3
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v0, 0x0

    .line 78
    if-ne p0, p1, :cond_1

    .line 79
    const/4 v0, 0x1

    .line 85
    .end local p1    # "obj":Ljava/lang/Object;
    :cond_0
    :goto_0
    return v0

    .line 80
    .restart local p1    # "obj":Ljava/lang/Object;
    :cond_1
    if-eqz p1, :cond_0

    .line 82
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    if-ne v1, v2, :cond_0

    .line 85
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ClickStreamTag;->tag:Ljava/lang/String;

    check-cast p1, Lcom/amazon/mShop/control/item/ClickStreamTag;

    .end local p1    # "obj":Ljava/lang/Object;
    iget-object v1, p1, Lcom/amazon/mShop/control/item/ClickStreamTag;->tag:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    goto :goto_0
.end method

.method public getTag()Ljava/lang/String;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ClickStreamTag;->tag:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 2

    .prologue
    .line 92
    const/16 v0, 0x11

    .line 93
    .local v0, "result":I
    iget-object v1, p0, Lcom/amazon/mShop/control/item/ClickStreamTag;->tag:Ljava/lang/String;

    if-nez v1, :cond_0

    const/4 v1, 0x0

    :goto_0
    add-int/lit16 v0, v1, 0x20f

    .line 94
    return v0

    .line 93
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/control/item/ClickStreamTag;->tag:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    goto :goto_0
.end method

.class public final enum Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;
.super Ljava/lang/Enum;
.source "WebViewOrderHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/order/WebViewOrderHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "OrderAction"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;

.field public static final enum CANCEL_ORDER:Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;

.field public static final enum TRACK_PACKAGE:Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;

.field public static final enum VIEW_ALL_ORDERS:Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;

.field public static final enum VIEW_ORDER:Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;


# instance fields
.field private mBaseUrlId:I

.field private mDataStoreDebugKey:Ljava/lang/String;

.field private mRequiredParams:[Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;


# direct methods
.method static constructor <clinit>()V
    .locals 12

    .prologue
    const/4 v11, 0x3

    const/4 v10, 0x2

    const/4 v9, 0x1

    const/4 v2, 0x0

    .line 43
    new-instance v0, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;

    const-string/jumbo v1, "CANCEL_ORDER"

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->cancel_order_web_page_url:I

    const-string/jumbo v4, "currentCancelOrderUrl"

    new-array v5, v9, [Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;

    sget-object v6, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;->ORDER_ID:Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;

    aput-object v6, v5, v2

    invoke-direct/range {v0 .. v5}, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;-><init>(Ljava/lang/String;IILjava/lang/String;[Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;)V

    sput-object v0, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;->CANCEL_ORDER:Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;

    .line 52
    new-instance v0, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;

    const-string/jumbo v1, "TRACK_PACKAGE"

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->ship_track_order_web_page_url:I

    new-array v4, v11, [Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;

    sget-object v5, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;->ORDER_ID:Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;

    aput-object v5, v4, v2

    sget-object v5, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;->TRACKING_ID:Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;

    aput-object v5, v4, v9

    sget-object v5, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;->SHIP_METHOD:Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;

    aput-object v5, v4, v10

    invoke-direct {v0, v1, v9, v3, v4}, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;-><init>(Ljava/lang/String;II[Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;)V

    sput-object v0, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;->TRACK_PACKAGE:Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;

    .line 58
    new-instance v3, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;

    const-string/jumbo v4, "VIEW_ALL_ORDERS"

    sget v6, Lcom/amazon/mShop/android/lib/R$string;->your_orders_web_page_url:I

    const-string/jumbo v7, "currentYourOrdersUrl"

    new-array v8, v2, [Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;

    move v5, v10

    invoke-direct/range {v3 .. v8}, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;-><init>(Ljava/lang/String;IILjava/lang/String;[Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;)V

    sput-object v3, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;->VIEW_ALL_ORDERS:Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;

    .line 64
    new-instance v3, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;

    const-string/jumbo v4, "VIEW_ORDER"

    sget v6, Lcom/amazon/mShop/android/lib/R$string;->order_detail_web_page_url:I

    const-string/jumbo v7, "currentOrderDetailUrl"

    new-array v8, v9, [Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;

    sget-object v0, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;->ORDER_ID:Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;

    aput-object v0, v8, v2

    move v5, v11

    invoke-direct/range {v3 .. v8}, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;-><init>(Ljava/lang/String;IILjava/lang/String;[Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;)V

    sput-object v3, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;->VIEW_ORDER:Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;

    .line 38
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;

    sget-object v1, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;->CANCEL_ORDER:Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;->TRACK_PACKAGE:Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;

    aput-object v1, v0, v9

    sget-object v1, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;->VIEW_ALL_ORDERS:Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;

    aput-object v1, v0, v10

    sget-object v1, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;->VIEW_ORDER:Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;

    aput-object v1, v0, v11

    sput-object v0, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;->$VALUES:[Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;

    return-void
.end method

.method private varargs constructor <init>(Ljava/lang/String;IILjava/lang/String;[Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;)V
    .locals 0
    .param p3, "baseUrlId"    # I
    .param p4, "dataStoreDebugKey"    # Ljava/lang/String;
    .param p5, "requiredParams"    # [Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/lang/String;",
            "[",
            "Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;",
            ")V"
        }
    .end annotation

    .prologue
    .line 90
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 91
    iput p3, p0, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;->mBaseUrlId:I

    .line 92
    iput-object p4, p0, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;->mDataStoreDebugKey:Ljava/lang/String;

    .line 93
    iput-object p5, p0, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;->mRequiredParams:[Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;

    .line 94
    return-void
.end method

.method private varargs constructor <init>(Ljava/lang/String;II[Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;)V
    .locals 6
    .param p3, "baseUrlId"    # I
    .param p4, "requiredParams"    # [Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I[",
            "Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;",
            ")V"
        }
    .end annotation

    .prologue
    .line 87
    const/4 v4, 0x0

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move v3, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;-><init>(Ljava/lang/String;IILjava/lang/String;[Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;)V

    .line 88
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 38
    const-class v0, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;
    .locals 1

    .prologue
    .line 38
    sget-object v0, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;->$VALUES:[Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;

    invoke-virtual {v0}, [Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;

    return-object v0
.end method


# virtual methods
.method public getUrl(Landroid/content/Context;Ljava/util/Map;Ljava/util/Map;)Ljava/lang/String;
    .locals 12
    .param p1, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/Map",
            "<",
            "Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 116
    .local p2, "params":Ljava/util/Map;, "Ljava/util/Map<Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;Ljava/lang/String;>;"
    .local p3, "queryParams":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v1, 0x0

    .line 119
    .local v1, "baseUrl":Ljava/lang/String;
    iget-object v7, p0, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;->mDataStoreDebugKey:Ljava/lang/String;

    invoke-static {v7}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_0

    .line 120
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v7

    invoke-interface {v7}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v7

    iget-object v8, p0, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;->mDataStoreDebugKey:Ljava/lang/String;

    invoke-interface {v7, v8}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 124
    :cond_0
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 125
    iget v7, p0, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;->mBaseUrlId:I

    invoke-virtual {p1, v7}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 129
    :cond_1
    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v7

    invoke-virtual {v7}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v5

    .line 132
    .local v5, "urlBuilder":Landroid/net/Uri$Builder;
    iget-object v7, p0, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;->mRequiredParams:[Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;

    invoke-static {v7}, Lcom/amazon/mShop/util/Util;->isEmpty([Ljava/lang/Object;)Z

    move-result v7

    if-nez v7, :cond_4

    .line 133
    iget-object v0, p0, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderAction;->mRequiredParams:[Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;

    .local v0, "arr$":[Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_4

    aget-object v4, v0, v2

    .line 134
    .local v4, "orderActionParam":Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;
    const-class v7, Ljava/lang/String;

    invoke-static {p2, v4, v7}, Lcom/amazon/mShop/util/Maps;->get(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    .line 135
    .local v6, "value":Ljava/lang/String;
    invoke-static {v6}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 136
    new-instance v7, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v8, "Value %s is invalid for %s"

    const/4 v9, 0x2

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    aput-object v6, v9, v10

    const/4 v10, 0x1

    invoke-virtual {v4}, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;->name()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v7

    .line 138
    :cond_2
    if-eqz p3, :cond_3

    # getter for: Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;->mKey:Ljava/lang/String;
    invoke-static {v4}, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;->access$000(Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;)Ljava/lang/String;

    move-result-object v7

    invoke-interface {p3, v7}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_3

    .line 139
    # getter for: Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;->mKey:Ljava/lang/String;
    invoke-static {v4}, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;->access$000(Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;)Ljava/lang/String;

    move-result-object v7

    invoke-interface {p3, v7}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 141
    :cond_3
    # getter for: Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;->mKey:Ljava/lang/String;
    invoke-static {v4}, Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;->access$000(Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v7, v6}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 133
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 146
    .end local v0    # "arr$":[Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;
    .end local v2    # "i$":I
    .end local v3    # "len$":I
    .end local v4    # "orderActionParam":Lcom/amazon/mShop/order/WebViewOrderHelper$OrderActionParams;
    .end local v6    # "value":Ljava/lang/String;
    :cond_4
    invoke-static {v5, p3}, Lcom/amazon/mShop/util/ActivityUtils;->appendParamsToURL(Landroid/net/Uri$Builder;Ljava/util/Map;)V

    .line 148
    invoke-virtual {v5}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v7

    invoke-virtual {v7}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v7

    return-object v7
.end method

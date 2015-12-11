.class Lcom/amazon/mShop/details/MarketPlaceView$1;
.super Ljava/lang/Object;
.source "MarketPlaceView.java"

# interfaces
.implements Landroid/widget/TabHost$OnTabChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/details/MarketPlaceView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/details/MarketPlaceView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/details/MarketPlaceView;)V
    .locals 0

    .prologue
    .line 44
    iput-object p1, p0, Lcom/amazon/mShop/details/MarketPlaceView$1;->this$0:Lcom/amazon/mShop/details/MarketPlaceView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTabChanged(Ljava/lang/String;)V
    .locals 2
    .param p1, "tabId"    # Ljava/lang/String;

    .prologue
    .line 49
    const/4 v0, 0x0

    .line 50
    .local v0, "refMarker":Ljava/lang/String;
    const-string/jumbo v1, "All Offers"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 51
    const-string/jumbo v0, "dp_olp_a"

    .line 63
    :cond_0
    :goto_0
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 64
    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 67
    :cond_1
    return-void

    .line 52
    :cond_2
    const-string/jumbo v1, "New"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 53
    const-string/jumbo v0, "dp_olp_n"

    goto :goto_0

    .line 54
    :cond_3
    const-string/jumbo v1, "Used"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 55
    const-string/jumbo v0, "dp_olp_u"

    goto :goto_0

    .line 56
    :cond_4
    const-string/jumbo v1, "Refurbished"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 57
    const-string/jumbo v0, "dp_olp_r"

    goto :goto_0

    .line 58
    :cond_5
    const-string/jumbo v1, "Collectible"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 59
    const-string/jumbo v0, "dp_olp_c"

    goto :goto_0
.end method

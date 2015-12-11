.class Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds$AdsTypeSpinnerOnSelectedListener;
.super Ljava/lang/Object;
.source "DebugSettingsActivityForAds.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemSelectedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "AdsTypeSpinnerOnSelectedListener"
.end annotation


# instance fields
.field private final mAdsId:Ljava/lang/String;

.field final synthetic this$0:Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;Ljava/lang/String;)V
    .locals 0
    .param p2, "adsId"    # Ljava/lang/String;

    .prologue
    .line 179
    iput-object p1, p0, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds$AdsTypeSpinnerOnSelectedListener;->this$0:Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 180
    iput-object p2, p0, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds$AdsTypeSpinnerOnSelectedListener;->mAdsId:Ljava/lang/String;

    .line 181
    return-void
.end method


# virtual methods
.method public onItemSelected(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 3
    .param p2, "v"    # Landroid/view/View;
    .param p3, "pos"    # I
    .param p4, "row"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 185
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    # getter for: Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->mMapAdsType:Ljava/util/Map;
    invoke-static {}, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->access$000()Ljava/util/Map;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds$AdsTypeSpinnerOnSelectedListener;->mAdsId:Ljava/lang/String;

    # getter for: Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->ADS_TYPE_ARRAY:[Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->access$200()[Ljava/lang/String;

    move-result-object v2

    aget-object v2, v2, p3

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 186
    return-void
.end method

.method public onNothingSelected(Landroid/widget/AdapterView;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 191
    .local p1, "arg0":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    return-void
.end method

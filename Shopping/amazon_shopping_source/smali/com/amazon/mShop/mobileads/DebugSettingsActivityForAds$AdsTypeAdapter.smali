.class Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds$AdsTypeAdapter;
.super Landroid/widget/ArrayAdapter;
.source "DebugSettingsActivityForAds.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "AdsTypeAdapter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/ArrayAdapter",
        "<",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 167
    const v1, 0x1090008

    invoke-direct {p0, p1, v1}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;I)V

    .line 168
    const v1, 0x1090009

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds$AdsTypeAdapter;->setDropDownViewResource(I)V

    .line 169
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    # getter for: Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->ADS_TYPE_ARRAY:[Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->access$200()[Ljava/lang/String;

    move-result-object v1

    array-length v1, v1

    if-ge v0, v1, :cond_0

    .line 170
    # getter for: Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->ADS_TYPE_ARRAY:[Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->access$200()[Ljava/lang/String;

    move-result-object v1

    aget-object v1, v1, v0

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds$AdsTypeAdapter;->add(Ljava/lang/Object;)V

    .line 169
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 172
    :cond_0
    return-void
.end method

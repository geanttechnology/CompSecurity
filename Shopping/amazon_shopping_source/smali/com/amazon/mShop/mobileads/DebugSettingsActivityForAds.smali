.class public Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;
.super Landroid/app/Activity;
.source "DebugSettingsActivityForAds.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds$AdsTypeSpinnerOnSelectedListener;,
        Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds$AdsTypeAdapter;
    }
.end annotation


# static fields
.field private static final ADS_ID_ARRAY:[Ljava/lang/String;

.field private static final ADS_TYPE_ARRAY:[Ljava/lang/String;

.field private static mMapAdsType:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static mMapAdsTypeKey:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 54
    new-array v0, v6, [Ljava/lang/String;

    const-string/jumbo v1, "GW_PROMO_LEFT"

    aput-object v1, v0, v2

    const-string/jumbo v1, "GW_PROMO_RIGHT"

    aput-object v1, v0, v3

    const-string/jumbo v1, "DEALS_TOP"

    aput-object v1, v0, v4

    const-string/jumbo v1, "THANK_YOU_BOTTOM"

    aput-object v1, v0, v5

    sput-object v0, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->ADS_ID_ARRAY:[Ljava/lang/String;

    .line 61
    new-array v0, v6, [Ljava/lang/String;

    const-string/jumbo v1, "NOT_SPECIFIED"

    aput-object v1, v0, v2

    const-string/jumbo v1, "IMAGE_HTML"

    aput-object v1, v0, v3

    const-string/jumbo v1, "IMAGE_MRAID"

    aput-object v1, v0, v4

    const-string/jumbo v1, "CELTRA"

    aput-object v1, v0, v5

    sput-object v0, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->ADS_TYPE_ARRAY:[Ljava/lang/String;

    .line 69
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->mMapAdsType:Ljava/util/Map;

    .line 72
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->mMapAdsTypeKey:Ljava/util/Map;

    .line 74
    sget-object v0, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->mMapAdsTypeKey:Ljava/util/Map;

    const-string/jumbo v1, "GW_PROMO_LEFT"

    const-string/jumbo v2, "AdsTypePromoLeft"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 75
    sget-object v0, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->mMapAdsTypeKey:Ljava/util/Map;

    const-string/jumbo v1, "GW_PROMO_RIGHT"

    const-string/jumbo v2, "AdsTypePromoRight"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 76
    sget-object v0, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->mMapAdsTypeKey:Ljava/util/Map;

    const-string/jumbo v1, "DEALS_TOP"

    const-string/jumbo v2, "AdsTypeDeal"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 77
    sget-object v0, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->mMapAdsTypeKey:Ljava/util/Map;

    const-string/jumbo v1, "THANK_YOU_BOTTOM"

    const-string/jumbo v2, "AdsTypeThankYouPage"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 78
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 175
    return-void
.end method

.method static synthetic access$000()Ljava/util/Map;
    .locals 1

    .prologue
    .line 28
    sget-object v0, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->mMapAdsType:Ljava/util/Map;

    return-object v0
.end method

.method static synthetic access$100()Ljava/util/Map;
    .locals 1

    .prologue
    .line 28
    sget-object v0, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->mMapAdsTypeKey:Ljava/util/Map;

    return-object v0
.end method

.method static synthetic access$200()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    sget-object v0, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->ADS_TYPE_ARRAY:[Ljava/lang/String;

    return-object v0
.end method

.method public static getAdIdWithTypePostfix(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "adsId"    # Ljava/lang/String;

    .prologue
    .line 222
    const-string/jumbo v3, "MobileAdsDataStore"

    const/4 v4, 0x0

    invoke-virtual {p0, v3, v4}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v2

    .line 223
    .local v2, "pref":Landroid/content/SharedPreferences;
    sget-object v3, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->mMapAdsTypeKey:Ljava/util/Map;

    invoke-interface {v3, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 224
    .local v1, "key":Ljava/lang/String;
    const-string/jumbo v3, "NOT_SPECIFIED"

    invoke-interface {v2, v1, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 225
    .local v0, "adsType":Ljava/lang/String;
    const-string/jumbo v3, "NOT_SPECIFIED"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 228
    .end local p1    # "adsId":Ljava/lang/String;
    :goto_0
    return-object p1

    .restart local p1    # "adsId":Ljava/lang/String;
    :cond_0
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "_"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    goto :goto_0
.end method

.method private getAdsTypeDropList(Ljava/lang/String;)Landroid/view/View;
    .locals 5
    .param p1, "adsId"    # Ljava/lang/String;

    .prologue
    .line 140
    new-instance v0, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds$AdsTypeAdapter;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds$AdsTypeAdapter;-><init>(Landroid/content/Context;)V

    .line 141
    .local v0, "adsTypeAdapter":Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds$AdsTypeAdapter;
    new-instance v2, Landroid/widget/LinearLayout;

    invoke-direct {v2, p0}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 142
    .local v2, "layout":Landroid/widget/LinearLayout;
    const/4 v4, 0x1

    invoke-virtual {v2, v4}, Landroid/widget/LinearLayout;->setOrientation(I)V

    .line 143
    new-instance v1, Landroid/widget/TextView;

    invoke-direct {v1, p0}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    .line 144
    .local v1, "label":Landroid/widget/TextView;
    invoke-virtual {v1, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 145
    invoke-virtual {v2, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 146
    new-instance v3, Landroid/widget/Spinner;

    invoke-direct {v3, p0}, Landroid/widget/Spinner;-><init>(Landroid/content/Context;)V

    .line 147
    .local v3, "spinner":Landroid/widget/Spinner;
    invoke-virtual {v3, v0}, Landroid/widget/Spinner;->setAdapter(Landroid/widget/SpinnerAdapter;)V

    .line 148
    new-instance v4, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds$AdsTypeSpinnerOnSelectedListener;

    invoke-direct {v4, p0, p1}, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds$AdsTypeSpinnerOnSelectedListener;-><init>(Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;Ljava/lang/String;)V

    invoke-virtual {v3, v4}, Landroid/widget/Spinner;->setOnItemSelectedListener(Landroid/widget/AdapterView$OnItemSelectedListener;)V

    .line 149
    invoke-static {p1}, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->getAdsTypeIndex(Ljava/lang/String;)I

    move-result v4

    invoke-virtual {v3, v4}, Landroid/widget/Spinner;->setSelection(I)V

    .line 150
    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 151
    return-object v2
.end method

.method private static getAdsTypeIndex(Ljava/lang/String;)I
    .locals 4
    .param p0, "adsId"    # Ljava/lang/String;

    .prologue
    .line 155
    sget-object v3, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->mMapAdsType:Ljava/util/Map;

    invoke-interface {v3, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 156
    .local v0, "adsType":Ljava/lang/String;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    sget-object v3, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->ADS_TYPE_ARRAY:[Ljava/lang/String;

    array-length v3, v3

    if-ge v1, v3, :cond_1

    .line 157
    sget-object v3, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->ADS_TYPE_ARRAY:[Ljava/lang/String;

    aget-object v2, v3, v1

    .line 158
    .local v2, "type":Ljava/lang/String;
    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 162
    .end local v1    # "i":I
    .end local v2    # "type":Ljava/lang/String;
    :goto_1
    return v1

    .line 156
    .restart local v1    # "i":I
    .restart local v2    # "type":Ljava/lang/String;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 162
    .end local v2    # "type":Ljava/lang/String;
    :cond_1
    const/4 v1, -0x1

    goto :goto_1
.end method

.method public static getChannel(Landroid/content/Context;)Ljava/lang/String;
    .locals 5
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 210
    const-string/jumbo v3, "MobileAdsDataStore"

    const/4 v4, 0x0

    invoke-virtual {p0, v3, v4}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v2

    .line 211
    .local v2, "pref":Landroid/content/SharedPreferences;
    const-string/jumbo v3, "Channel"

    const-string/jumbo v4, ""

    invoke-interface {v2, v3, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 212
    .local v0, "channel":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 213
    const-string/jumbo v0, "100"

    .line 214
    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    .line 215
    .local v1, "editor":Landroid/content/SharedPreferences$Editor;
    const-string/jumbo v3, "Channel"

    invoke-interface {v1, v3, v0}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 216
    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 218
    .end local v1    # "editor":Landroid/content/SharedPreferences$Editor;
    :cond_0
    return-object v0
.end method

.method public static isLogging(Landroid/content/Context;)Z
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v2, 0x0

    .line 205
    const-string/jumbo v1, "MobileAdsDataStore"

    invoke-virtual {p0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 206
    .local v0, "pref":Landroid/content/SharedPreferences;
    const-string/jumbo v1, "Logging"

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    return v1
.end method

.method private loadAdsTypeSettings()V
    .locals 6

    .prologue
    .line 195
    sget-object v4, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->mMapAdsType:Ljava/util/Map;

    invoke-interface {v4}, Ljava/util/Map;->clear()V

    .line 196
    const-string/jumbo v4, "MobileAdsDataStore"

    const/4 v5, 0x0

    invoke-virtual {p0, v4, v5}, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v3

    .line 197
    .local v3, "pref":Landroid/content/SharedPreferences;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    sget-object v4, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->ADS_ID_ARRAY:[Ljava/lang/String;

    array-length v4, v4

    if-ge v0, v4, :cond_0

    .line 198
    sget-object v4, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->ADS_ID_ARRAY:[Ljava/lang/String;

    aget-object v1, v4, v0

    .line 199
    .local v1, "id":Ljava/lang/String;
    sget-object v4, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->mMapAdsTypeKey:Ljava/util/Map;

    invoke-interface {v4, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 200
    .local v2, "key":Ljava/lang/String;
    sget-object v4, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->mMapAdsType:Ljava/util/Map;

    const-string/jumbo v5, "NOT_SPECIFIED"

    invoke-interface {v3, v2, v5}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v1, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 197
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 202
    .end local v1    # "id":Ljava/lang/String;
    .end local v2    # "key":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method public static writeSettingsMap(Landroid/content/Context;Ljava/util/Map;)V
    .locals 9
    .param p0, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "settingsMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v8, 0x0

    .line 232
    const-string/jumbo v7, "MobileAdsDataStore"

    invoke-virtual {p0, v7, v8}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v5

    .line 233
    .local v5, "pref":Landroid/content/SharedPreferences;
    invoke-interface {v5}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    .line 234
    .local v1, "editor":Landroid/content/SharedPreferences$Editor;
    invoke-interface {p1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_2

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 235
    .local v2, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 236
    .local v4, "key":Ljava/lang/String;
    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    .line 238
    .local v6, "value":Ljava/lang/String;
    const-string/jumbo v7, "Logging"

    invoke-virtual {v7, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 239
    invoke-interface {v5, v4, v8}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    .line 240
    .local v0, "currValue":Z
    if-nez v0, :cond_0

    .line 241
    invoke-static {v6}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v7

    invoke-interface {v1, v4, v7}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    goto :goto_0

    .line 247
    .end local v0    # "currValue":Z
    :cond_1
    const-string/jumbo v7, ""

    invoke-interface {v5, v4, v7}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 248
    .local v0, "currValue":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 249
    invoke-interface {v1, v4, v6}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    goto :goto_0

    .line 255
    .end local v0    # "currValue":Ljava/lang/String;
    .end local v2    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v4    # "key":Ljava/lang/String;
    .end local v6    # "value":Ljava/lang/String;
    :cond_2
    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 256
    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 11
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v10, 0x1

    const/4 v9, 0x0

    .line 81
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 82
    const-string/jumbo v8, "MobileAdsDataStore"

    invoke-virtual {p0, v8, v9}, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v6

    .line 84
    .local v6, "pref":Landroid/content/SharedPreferences;
    new-instance v4, Landroid/widget/CheckBox;

    invoke-direct {v4, p0}, Landroid/widget/CheckBox;-><init>(Landroid/content/Context;)V

    .line 85
    .local v4, "logOption":Landroid/widget/CheckBox;
    const-string/jumbo v8, "Logging"

    invoke-virtual {v4, v8}, Landroid/widget/CheckBox;->setText(Ljava/lang/CharSequence;)V

    .line 86
    const-string/jumbo v8, "Logging"

    invoke-interface {v6, v8, v9}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v8

    invoke-virtual {v4, v8}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 88
    new-instance v1, Landroid/widget/TextView;

    invoke-direct {v1, p0}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    .line 89
    .local v1, "channelSettingLabel":Landroid/widget/TextView;
    const-string/jumbo v8, "Test Channel (if left empty, then we will use 90 as default)"

    invoke-virtual {v1, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 90
    new-instance v0, Landroid/widget/EditText;

    invoke-direct {v0, p0}, Landroid/widget/EditText;-><init>(Landroid/content/Context;)V

    .line 91
    .local v0, "channelEditText":Landroid/widget/EditText;
    new-instance v5, Landroid/text/InputFilter$LengthFilter;

    const/16 v8, 0xa

    invoke-direct {v5, v8}, Landroid/text/InputFilter$LengthFilter;-><init>(I)V

    .line 92
    .local v5, "maxLengthFilter":Landroid/text/InputFilter;
    new-array v8, v10, [Landroid/text/InputFilter;

    aput-object v5, v8, v9

    invoke-virtual {v0, v8}, Landroid/widget/EditText;->setFilters([Landroid/text/InputFilter;)V

    .line 93
    const-string/jumbo v8, "Input the test channel number"

    invoke-virtual {v0, v8}, Landroid/widget/EditText;->setHint(Ljava/lang/CharSequence;)V

    .line 94
    const-string/jumbo v8, "Channel"

    const-string/jumbo v9, ""

    invoke-interface {v6, v8, v9}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v0, v8}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 96
    new-instance v7, Landroid/widget/Button;

    invoke-direct {v7, p0}, Landroid/widget/Button;-><init>(Landroid/content/Context;)V

    .line 97
    .local v7, "saveAndRestartButton":Landroid/widget/Button;
    const-string/jumbo v8, "Save and Restart"

    invoke-virtual {v7, v8}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 98
    new-instance v8, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds$1;

    invoke-direct {v8, p0, v6, v4, v0}, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds$1;-><init>(Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;Landroid/content/SharedPreferences;Landroid/widget/CheckBox;Landroid/widget/EditText;)V

    invoke-virtual {v7, v8}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 122
    new-instance v3, Landroid/widget/LinearLayout;

    invoke-direct {v3, p0}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 123
    .local v3, "layout":Landroid/widget/LinearLayout;
    invoke-virtual {v3, v10}, Landroid/widget/LinearLayout;->setOrientation(I)V

    .line 124
    invoke-virtual {v3, v7}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 125
    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 126
    invoke-virtual {v3, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 127
    invoke-virtual {v3, v0}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 129
    invoke-direct {p0}, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->loadAdsTypeSettings()V

    .line 130
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    sget-object v8, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->ADS_ID_ARRAY:[Ljava/lang/String;

    array-length v8, v8

    if-ge v2, v8, :cond_0

    .line 131
    sget-object v8, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->ADS_ID_ARRAY:[Ljava/lang/String;

    aget-object v8, v8, v2

    invoke-direct {p0, v8}, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->getAdsTypeDropList(Ljava/lang/String;)Landroid/view/View;

    move-result-object v8

    invoke-virtual {v3, v8}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 130
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 134
    :cond_0
    invoke-virtual {p0, v3}, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->setContentView(Landroid/view/View;)V

    .line 136
    const-string/jumbo v8, "Mobile Ads Debug Settings"

    invoke-virtual {p0, v8}, Lcom/amazon/mShop/mobileads/DebugSettingsActivityForAds;->setTitle(Ljava/lang/CharSequence;)V

    .line 137
    return-void
.end method

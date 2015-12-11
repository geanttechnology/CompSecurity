.class public Lcom/amazon/retailsearch/experiment/FeatureStateUtil;
.super Ljava/lang/Object;
.source "FeatureStateUtil.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    return-void
.end method

.method public static getAssetsWeblab(Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;)Ljava/lang/String;
    .locals 3
    .param p0, "featureConfig"    # Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;

    .prologue
    .line 34
    if-eqz p0, :cond_1

    :try_start_0
    const-string/jumbo v2, "SX_mShop_Android_Assets_Loading_Scheme"

    invoke-interface {p0, v2}, Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;->getFeatureState(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 36
    .local v0, "assetsTreatment":Ljava/lang/String;
    :goto_0
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    const-string/jumbo v0, "C"

    .line 40
    .end local v0    # "assetsTreatment":Ljava/lang/String;
    :cond_0
    :goto_1
    return-object v0

    .line 34
    :cond_1
    const-string/jumbo v0, "C"
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 38
    :catch_0
    move-exception v1

    .line 40
    .local v1, "e":Ljava/lang/Exception;
    const-string/jumbo v0, "C"

    goto :goto_1
.end method

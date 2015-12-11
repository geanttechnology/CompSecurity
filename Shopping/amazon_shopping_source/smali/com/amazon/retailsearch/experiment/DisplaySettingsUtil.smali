.class public Lcom/amazon/retailsearch/experiment/DisplaySettingsUtil;
.super Ljava/lang/Object;
.source "DisplaySettingsUtil.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static displaySettingsEnabled(Landroid/content/res/Resources;Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;)Z
    .locals 2
    .param p0, "res"    # Landroid/content/res/Resources;
    .param p1, "featureConfig"    # Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;

    .prologue
    .line 21
    const-string/jumbo v0, "true"

    sget v1, Lcom/amazon/retailsearch/R$string;->config_rs_display_settings_enabled:I

    invoke-virtual {p0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    if-eqz p1, :cond_0

    const-string/jumbo v0, "SX_mShop_Android_Dynamic_Display_Settings"

    invoke-interface {p1, v0}, Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;->isFeatureActivated(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

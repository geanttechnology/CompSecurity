.class public Lcom/amazon/mShop/opl/AddressPickerView;
.super Ljava/lang/Object;
.source "AddressPickerView.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getCVSDMapActivityIntent(Landroid/app/Activity;)Landroid/content/Intent;
    .locals 3
    .param p0, "activity"    # Landroid/app/Activity;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/ClassNotFoundException;
        }
    .end annotation

    .prologue
    .line 25
    const-string/jumbo v2, "com.amazon.mShop.cvsd.CVSDMapActivity"

    invoke-static {v2}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    .line 26
    .local v0, "clz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1, p0, v0}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 27
    .local v1, "intent":Landroid/content/Intent;
    return-object v1
.end method

.method public static hasCVSD(Landroid/content/Context;)Z
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 37
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->config_has_cvsd:I

    invoke-static {p0, v0}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(Landroid/content/Context;I)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/amazon/mShop/opl/AddressPickerView;->isDeviceHasGoogleMapLib()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static isDeviceHasGoogleMapLib()Z
    .locals 4

    .prologue
    .line 42
    const/4 v0, 0x0

    .line 47
    .local v0, "clz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :try_start_0
    const-string/jumbo v2, "com.amazon.mShop.cvsd.CVSDMapActivity"

    invoke-static {v2}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 55
    :goto_0
    if-eqz v0, :cond_0

    .line 56
    const/4 v2, 0x1

    .line 58
    :goto_1
    return v2

    .line 48
    :catch_0
    move-exception v1

    .line 51
    .local v1, "e":Ljava/lang/ClassNotFoundException;
    const-string/jumbo v2, "AddressPickerView"

    invoke-virtual {v1}, Ljava/lang/ClassNotFoundException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 58
    .end local v1    # "e":Ljava/lang/ClassNotFoundException;
    :cond_0
    const/4 v2, 0x0

    goto :goto_1
.end method

.class public Lcom/a9/creditcardreaderlibrary/helpers/ScreenSizeHelper;
.super Ljava/lang/Object;
.source "ScreenSizeHelper.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static isTabletDevice(Landroid/content/Context;)Z
    .locals 10
    .param p0, "activityContext"    # Landroid/content/Context;

    .prologue
    const/16 v9, 0xa0

    const/4 v5, 0x1

    const/4 v6, 0x0

    .line 14
    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    invoke-virtual {v7}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v7

    iget v7, v7, Landroid/content/res/Configuration;->screenLayout:I

    and-int/lit8 v7, v7, 0xf

    const/4 v8, 0x3

    if-ne v7, v8, :cond_1

    move v2, v5

    .line 16
    .local v2, "deviceLarge":Z
    :goto_0
    if-eqz v2, :cond_2

    .line 17
    new-instance v4, Landroid/util/DisplayMetrics;

    invoke-direct {v4}, Landroid/util/DisplayMetrics;-><init>()V

    .line 18
    .local v4, "metrics":Landroid/util/DisplayMetrics;
    move-object v0, p0

    check-cast v0, Landroid/app/Activity;

    move-object v1, v0

    .line 19
    .local v1, "activity":Landroid/app/Activity;
    invoke-virtual {v1}, Landroid/app/Activity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v7

    invoke-interface {v7}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v7

    invoke-virtual {v7, v4}, Landroid/view/Display;->getMetrics(Landroid/util/DisplayMetrics;)V

    .line 21
    iget v7, v4, Landroid/util/DisplayMetrics;->densityDpi:I

    if-eq v7, v9, :cond_0

    iget v7, v4, Landroid/util/DisplayMetrics;->densityDpi:I

    const/16 v8, 0xf0

    if-eq v7, v8, :cond_0

    iget v7, v4, Landroid/util/DisplayMetrics;->densityDpi:I

    if-eq v7, v9, :cond_0

    iget v7, v4, Landroid/util/DisplayMetrics;->densityDpi:I

    const/16 v8, 0xd5

    if-eq v7, v8, :cond_0

    iget v7, v4, Landroid/util/DisplayMetrics;->densityDpi:I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    const/16 v8, 0x140

    if-ne v7, v8, :cond_2

    .line 29
    .end local v1    # "activity":Landroid/app/Activity;
    .end local v2    # "deviceLarge":Z
    .end local v4    # "metrics":Landroid/util/DisplayMetrics;
    :cond_0
    :goto_1
    return v5

    :cond_1
    move v2, v6

    .line 14
    goto :goto_0

    .line 26
    :catch_0
    move-exception v3

    .line 27
    .local v3, "e":Ljava/lang/Exception;
    invoke-virtual {v3}, Ljava/lang/Exception;->printStackTrace()V

    .end local v3    # "e":Ljava/lang/Exception;
    :cond_2
    move v5, v6

    .line 29
    goto :goto_1
.end method

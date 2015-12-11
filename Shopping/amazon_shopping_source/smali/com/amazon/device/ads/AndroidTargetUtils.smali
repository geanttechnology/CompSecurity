.class Lcom/amazon/device/ads/AndroidTargetUtils;
.super Ljava/lang/Object;
.source "AndroidTargetUtils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/device/ads/AndroidTargetUtils$JellyBeanTargetUtils;,
        Lcom/amazon/device/ads/AndroidTargetUtils$HoneycombTargetUtils;,
        Lcom/amazon/device/ads/AndroidTargetUtils$GingerbreadTargetUtils;,
        Lcom/amazon/device/ads/AndroidTargetUtils$FroyoTargetUtils;,
        Lcom/amazon/device/ads/AndroidTargetUtils$EclairTargetUtils;
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 41
    return-void
.end method

.method public static final disableHardwareAcceleration(Landroid/view/View;)V
    .locals 0
    .param p0, "view"    # Landroid/view/View;

    .prologue
    .line 93
    invoke-static {p0}, Lcom/amazon/device/ads/AndroidTargetUtils$HoneycombTargetUtils;->disableHardwareAcceleration(Landroid/view/View;)V

    .line 94
    return-void
.end method

.method public static editorApply(Landroid/content/SharedPreferences$Editor;)V
    .locals 0
    .param p0, "editor"    # Landroid/content/SharedPreferences$Editor;

    .prologue
    .line 130
    invoke-static {p0}, Lcom/amazon/device/ads/AndroidTargetUtils$GingerbreadTargetUtils;->editorApply(Landroid/content/SharedPreferences$Editor;)V

    .line 131
    return-void
.end method

.method public static varargs executeAsyncTask(Landroid/os/AsyncTask;[Ljava/lang/Object;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Landroid/os/AsyncTask",
            "<TT;**>;[TT;)V"
        }
    .end annotation

    .prologue
    .line 193
    .local p0, "task":Landroid/os/AsyncTask;, "Landroid/os/AsyncTask<TT;**>;"
    .local p1, "params":[Ljava/lang/Object;, "[TT;"
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xb

    if-lt v0, v1, :cond_0

    .line 195
    invoke-static {p0, p1}, Lcom/amazon/device/ads/AndroidTargetUtils$HoneycombTargetUtils;->executeAsyncTaskWithThreadPooling(Landroid/os/AsyncTask;[Ljava/lang/Object;)V

    .line 201
    :goto_0
    return-void

    .line 199
    :cond_0
    invoke-virtual {p0, p1}, Landroid/os/AsyncTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

.method public static getNewBitmapDrawable(Landroid/content/res/Resources;Ljava/lang/String;)Landroid/graphics/drawable/BitmapDrawable;
    .locals 1
    .param p0, "r"    # Landroid/content/res/Resources;
    .param p1, "f"    # Ljava/lang/String;

    .prologue
    .line 61
    const/4 v0, 0x5

    invoke-static {v0}, Lcom/amazon/device/ads/AndroidTargetUtils;->isAtLeastAndroidAPI(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 63
    invoke-static {p0, p1}, Lcom/amazon/device/ads/AndroidTargetUtils$EclairTargetUtils;->getNewBitmapDrawable(Landroid/content/res/Resources;Ljava/lang/String;)Landroid/graphics/drawable/BitmapDrawable;

    move-result-object v0

    .line 68
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Landroid/graphics/drawable/BitmapDrawable;

    invoke-direct {v0, p1}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static getOrientation(Landroid/view/Display;)I
    .locals 1
    .param p0, "display"    # Landroid/view/Display;

    .prologue
    .line 175
    const/16 v0, 0x8

    invoke-static {v0}, Lcom/amazon/device/ads/AndroidTargetUtils;->isAtLeastAndroidAPI(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 177
    invoke-static {p0}, Lcom/amazon/device/ads/AndroidTargetUtils$FroyoTargetUtils;->getRotation(Landroid/view/Display;)I

    move-result v0

    .line 181
    :goto_0
    return v0

    :cond_0
    invoke-virtual {p0}, Landroid/view/Display;->getOrientation()I

    move-result v0

    goto :goto_0
.end method

.method public static getPackageCodePath(Landroid/content/Context;)Ljava/lang/String;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 103
    invoke-static {p0}, Lcom/amazon/device/ads/AndroidTargetUtils$FroyoTargetUtils;->getPackageCodePath(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static hideActionAndStatusBars(Landroid/app/Activity;)V
    .locals 0
    .param p0, "activity"    # Landroid/app/Activity;

    .prologue
    .line 209
    invoke-static {p0}, Lcom/amazon/device/ads/AndroidTargetUtils$HoneycombTargetUtils;->hideActionAndStatusBars(Landroid/app/Activity;)V

    .line 210
    return-void
.end method

.method public static isAtLeastAndroidAPI(I)Z
    .locals 1
    .param p0, "api"    # I

    .prologue
    .line 50
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt v0, p0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isInstanceOfSQLiteDatabaseLockedException(Landroid/database/sqlite/SQLiteException;)Z
    .locals 1
    .param p0, "e"    # Landroid/database/sqlite/SQLiteException;

    .prologue
    .line 83
    invoke-static {p0}, Lcom/amazon/device/ads/AndroidTargetUtils$HoneycombTargetUtils;->isInstanceOfSQLiteDatabaseLockedException(Landroid/database/sqlite/SQLiteException;)Z

    move-result v0

    return v0
.end method

.method public static setBackgroundDrawable(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V
    .locals 1
    .param p0, "view"    # Landroid/view/View;
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 157
    const/16 v0, 0x10

    invoke-static {v0}, Lcom/amazon/device/ads/AndroidTargetUtils;->isAtLeastAndroidAPI(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 159
    invoke-static {p0, p1}, Lcom/amazon/device/ads/AndroidTargetUtils$JellyBeanTargetUtils;->setBackgroundForLinerLayout(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V

    .line 166
    :goto_0
    return-void

    .line 164
    :cond_0
    invoke-virtual {p0, p1}, Landroid/view/View;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0
.end method

.method public static setImageButtonAlpha(Landroid/widget/ImageButton;I)V
    .locals 1
    .param p0, "imageButton"    # Landroid/widget/ImageButton;
    .param p1, "alpha"    # I

    .prologue
    .line 140
    const/16 v0, 0x10

    invoke-static {v0}, Lcom/amazon/device/ads/AndroidTargetUtils;->isAtLeastAndroidAPI(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 142
    invoke-static {p0, p1}, Lcom/amazon/device/ads/AndroidTargetUtils$JellyBeanTargetUtils;->setImageButtonAlpha(Landroid/widget/ImageButton;I)V

    .line 148
    :goto_0
    return-void

    .line 146
    :cond_0
    invoke-virtual {p0, p1}, Landroid/widget/ImageButton;->setAlpha(I)V

    goto :goto_0
.end method

.method public static webViewOnPause(Landroid/webkit/WebView;)V
    .locals 0
    .param p0, "webView"    # Landroid/webkit/WebView;

    .prologue
    .line 112
    invoke-static {p0}, Lcom/amazon/device/ads/AndroidTargetUtils$HoneycombTargetUtils;->webViewOnPause(Landroid/webkit/WebView;)V

    .line 113
    return-void
.end method

.method public static webViewOnResume(Landroid/webkit/WebView;)V
    .locals 0
    .param p0, "webView"    # Landroid/webkit/WebView;

    .prologue
    .line 121
    invoke-static {p0}, Lcom/amazon/device/ads/AndroidTargetUtils$HoneycombTargetUtils;->webViewOnResume(Landroid/webkit/WebView;)V

    .line 122
    return-void
.end method

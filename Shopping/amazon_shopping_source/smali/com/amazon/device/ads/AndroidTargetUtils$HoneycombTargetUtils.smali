.class Lcom/amazon/device/ads/AndroidTargetUtils$HoneycombTargetUtils;
.super Ljava/lang/Object;
.source "AndroidTargetUtils.java"


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0xb
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/AndroidTargetUtils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "HoneycombTargetUtils"
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 277
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static final disableHardwareAcceleration(Landroid/view/View;)V
    .locals 2
    .param p0, "view"    # Landroid/view/View;

    .prologue
    .line 296
    const/4 v0, 0x1

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Landroid/view/View;->setLayerType(ILandroid/graphics/Paint;)V

    .line 297
    return-void
.end method

.method protected static final varargs executeAsyncTaskWithThreadPooling(Landroid/os/AsyncTask;[Ljava/lang/Object;)V
    .locals 1
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
    .line 306
    .local p0, "task":Landroid/os/AsyncTask;, "Landroid/os/AsyncTask<TT;**>;"
    .local p1, "params":[Ljava/lang/Object;, "[TT;"
    sget-object v0, Landroid/os/AsyncTask;->THREAD_POOL_EXECUTOR:Ljava/util/concurrent/Executor;

    invoke-virtual {p0, v0, p1}, Landroid/os/AsyncTask;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 307
    return-void
.end method

.method protected static hideActionAndStatusBars(Landroid/app/Activity;)V
    .locals 3
    .param p0, "activity"    # Landroid/app/Activity;

    .prologue
    .line 333
    invoke-virtual {p0}, Landroid/app/Activity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 334
    .local v0, "actionBar":Landroid/app/ActionBar;
    if-eqz v0, :cond_0

    .line 336
    invoke-virtual {v0}, Landroid/app/ActionBar;->hide()V

    .line 338
    :cond_0
    invoke-virtual {p0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v1

    .line 339
    .local v1, "decorView":Landroid/view/View;
    const/4 v2, 0x4

    invoke-virtual {v1, v2}, Landroid/view/View;->setSystemUiVisibility(I)V

    .line 340
    return-void
.end method

.method public static isInstanceOfSQLiteDatabaseLockedException(Landroid/database/sqlite/SQLiteException;)Z
    .locals 1
    .param p0, "e"    # Landroid/database/sqlite/SQLiteException;

    .prologue
    .line 286
    instance-of v0, p0, Landroid/database/sqlite/SQLiteDatabaseLockedException;

    return v0
.end method

.method protected static webViewOnPause(Landroid/webkit/WebView;)V
    .locals 0
    .param p0, "webView"    # Landroid/webkit/WebView;

    .prologue
    .line 315
    invoke-virtual {p0}, Landroid/webkit/WebView;->onPause()V

    .line 316
    return-void
.end method

.method protected static webViewOnResume(Landroid/webkit/WebView;)V
    .locals 0
    .param p0, "webView"    # Landroid/webkit/WebView;

    .prologue
    .line 324
    invoke-virtual {p0}, Landroid/webkit/WebView;->onResume()V

    .line 325
    return-void
.end method

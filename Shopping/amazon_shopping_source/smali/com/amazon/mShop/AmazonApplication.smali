.class public Lcom/amazon/mShop/AmazonApplication;
.super Landroid/app/Application;
.source "AmazonApplication.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/AmazonApplication$CloudDriveInitializationRunnable;,
        Lcom/amazon/mShop/AmazonApplication$AIVUserListener;,
        Lcom/amazon/mShop/AmazonApplication$DexLoadJob;
    }
.end annotation


# static fields
.field private static final AIV_USER_LISTENER:Lcom/amazon/mShop/model/auth/UserListener;

.field private static mCloudDriveListener:Lcom/amazon/mShop/model/auth/UserListener;

.field private static sDeviceLocaleOnAppCreate:Ljava/util/Locale;

.field private static sWebViewCacheEmpty:Z


# instance fields
.field private final mCriticalJarList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final mSupplementalDexLoader:Lamazon/android/dexload/SupplementalDexLoader;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 126
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/AmazonApplication;->sDeviceLocaleOnAppCreate:Ljava/util/Locale;

    .line 132
    const/4 v0, 0x0

    sput-boolean v0, Lcom/amazon/mShop/AmazonApplication;->sWebViewCacheEmpty:Z

    .line 261
    new-instance v0, Lcom/amazon/mShop/AmazonApplication$AIVUserListener;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/amazon/mShop/AmazonApplication$AIVUserListener;-><init>(Lcom/amazon/mShop/AmazonApplication$1;)V

    sput-object v0, Lcom/amazon/mShop/AmazonApplication;->AIV_USER_LISTENER:Lcom/amazon/mShop/model/auth/UserListener;

    .line 320
    new-instance v0, Lcom/amazon/mShop/AmazonApplication$1;

    invoke-direct {v0}, Lcom/amazon/mShop/AmazonApplication$1;-><init>()V

    sput-object v0, Lcom/amazon/mShop/AmazonApplication;->mCloudDriveListener:Lcom/amazon/mShop/model/auth/UserListener;

    return-void
.end method

.method public constructor <init>()V
    .locals 4

    .prologue
    .line 119
    invoke-direct {p0}, Landroid/app/Application;-><init>()V

    .line 134
    invoke-static {}, Lamazon/android/dexload/SupplementalDexLoader;->getInstance()Lamazon/android/dexload/SupplementalDexLoader;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/AmazonApplication;->mSupplementalDexLoader:Lamazon/android/dexload/SupplementalDexLoader;

    .line 136
    new-instance v0, Ljava/util/LinkedList;

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string/jumbo v3, "appstore.jar"

    aput-object v3, v1, v2

    invoke-static {v1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/util/LinkedList;-><init>(Ljava/util/Collection;)V

    iput-object v0, p0, Lcom/amazon/mShop/AmazonApplication;->mCriticalJarList:Ljava/util/List;

    .line 290
    return-void
.end method

.method static synthetic access$200()Lcom/amazon/mShop/model/auth/UserListener;
    .locals 1

    .prologue
    .line 119
    sget-object v0, Lcom/amazon/mShop/AmazonApplication;->mCloudDriveListener:Lcom/amazon/mShop/model/auth/UserListener;

    return-object v0
.end method

.method static synthetic access$300(Z)V
    .locals 0
    .param p0, "x0"    # Z

    .prologue
    .line 119
    invoke-static {p0}, Lcom/amazon/mShop/AmazonApplication;->updateCloudDriveSignInStatus(Z)V

    return-void
.end method

.method public static getDeviceLocaleOnAppCreate()Ljava/util/Locale;
    .locals 1

    .prologue
    .line 142
    sget-object v0, Lcom/amazon/mShop/AmazonApplication;->sDeviceLocaleOnAppCreate:Ljava/util/Locale;

    return-object v0
.end method

.method private initializeAppStore(Ljava/util/concurrent/CountDownLatch;Lcom/amazon/device/crashmanager/CrashDetectionHelper;)V
    .locals 5
    .param p1, "appStoreLoadingLatch"    # Ljava/util/concurrent/CountDownLatch;
    .param p2, "crashHelper"    # Lcom/amazon/device/crashmanager/CrashDetectionHelper;

    .prologue
    .line 534
    :try_start_0
    invoke-virtual {p1}, Ljava/util/concurrent/CountDownLatch;->await()V

    .line 535
    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string/jumbo v4, "com.amazon.venezia.Application"

    aput-object v4, v2, v3

    invoke-direct {p0, v2}, Lcom/amazon/mShop/AmazonApplication;->initializeApplication([Ljava/lang/String;)V

    .line 536
    invoke-static {}, Lcom/amazon/mShop/appstore/AppstoreUtils;->setAppstoreInitialized()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 541
    :goto_0
    return-void

    .line 537
    :catch_0
    move-exception v0

    .line 538
    .local v0, "e":Ljava/lang/Exception;
    const-string/jumbo v1, "The appstore initialization failed"

    .line 539
    .local v1, "message":Ljava/lang/String;
    const-string/jumbo v2, "AmazonApplication"

    const-string/jumbo v3, "The appstore initialization failed"

    invoke-static {v2, v3, v0}, Lcom/amazon/mShop/util/DebugUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private varargs initializeApplication([Ljava/lang/String;)V
    .locals 14
    .param p1, "applicationNames"    # [Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/NoSuchMethodException;,
            Ljava/lang/InstantiationException;,
            Ljava/lang/IllegalAccessException;,
            Ljava/lang/reflect/InvocationTargetException;
        }
    .end annotation

    .prologue
    const/4 v13, 0x1

    const/4 v12, 0x0

    .line 505
    move-object v3, p1

    .local v3, "arr$":[Ljava/lang/String;
    array-length v7, v3

    .local v7, "len$":I
    const/4 v6, 0x0

    .local v6, "i$":I
    :goto_0
    if-ge v6, v7, :cond_0

    aget-object v0, v3, v6

    .line 507
    .local v0, "appName":Ljava/lang/String;
    iget-object v8, p0, Lcom/amazon/mShop/AmazonApplication;->mSupplementalDexLoader:Lamazon/android/dexload/SupplementalDexLoader;

    invoke-virtual {v8, v0, v12}, Lamazon/android/dexload/SupplementalDexLoader;->loadClass(Ljava/lang/String;Z)Ljava/lang/Class;

    move-result-object v2

    .line 508
    .local v2, "applicationClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    new-array v8, v12, [Ljava/lang/Class;

    invoke-virtual {v2, v8}, Ljava/lang/Class;->getConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v5

    .line 509
    .local v5, "cons":Ljava/lang/reflect/Constructor;, "Ljava/lang/reflect/Constructor<*>;"
    new-array v8, v12, [Ljava/lang/Object;

    invoke-virtual {v5, v8}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/app/Application;

    .line 510
    .local v1, "application":Landroid/app/Application;
    const-class v8, Landroid/app/Application;

    const-string/jumbo v9, "attach"

    new-array v10, v13, [Ljava/lang/Class;

    const-class v11, Landroid/content/Context;

    aput-object v11, v10, v12

    invoke-virtual {v8, v9, v10}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v4

    .line 511
    .local v4, "attachMethod":Ljava/lang/reflect/Method;
    invoke-virtual {v4, v13}, Ljava/lang/reflect/Method;->setAccessible(Z)V

    .line 512
    new-array v8, v13, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonApplication;->getBaseContext()Landroid/content/Context;

    move-result-object v9

    aput-object v9, v8, v12

    invoke-virtual {v4, v1, v8}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 513
    invoke-virtual {v1}, Landroid/app/Application;->onCreate()V

    .line 514
    const-string/jumbo v8, "AmazonApplication"

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v10, "Created Application object: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 505
    add-int/lit8 v6, v6, 0x1

    goto :goto_0

    .line 516
    .end local v0    # "appName":Ljava/lang/String;
    .end local v1    # "application":Landroid/app/Application;
    .end local v2    # "applicationClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v4    # "attachMethod":Ljava/lang/reflect/Method;
    .end local v5    # "cons":Ljava/lang/reflect/Constructor;, "Ljava/lang/reflect/Constructor<*>;"
    :cond_0
    return-void
.end method

.method private initializeCloudDrive()V
    .locals 4

    .prologue
    .line 287
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/amazon/mShop/AmazonApplication$CloudDriveInitializationRunnable;

    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonApplication;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    const/4 v3, 0x0

    invoke-direct {v1, v2, v3}, Lcom/amazon/mShop/AmazonApplication$CloudDriveInitializationRunnable;-><init>(Landroid/content/Context;Lcom/amazon/mShop/AmazonApplication$1;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 288
    return-void
.end method

.method private initializeDex(Ljava/util/List;Ljava/util/concurrent/CountDownLatch;)V
    .locals 3
    .param p2, "appStoreLoadingLatch"    # Ljava/util/concurrent/CountDownLatch;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/concurrent/CountDownLatch;",
            ")V"
        }
    .end annotation

    .prologue
    .line 220
    .local p1, "criticalJars":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/amazon/mShop/AmazonApplication$DexLoadJob;

    invoke-direct {v1, p0, p1, p2}, Lcom/amazon/mShop/AmazonApplication$DexLoadJob;-><init>(Landroid/content/Context;Ljava/util/List;Ljava/util/concurrent/CountDownLatch;)V

    const-string/jumbo v2, "DexLoading"

    invoke-direct {v0, v1, v2}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 221
    return-void
.end method

.method public static isWebViewCacheEmpty()Z
    .locals 1

    .prologue
    .line 465
    sget-boolean v0, Lcom/amazon/mShop/AmazonApplication;->sWebViewCacheEmpty:Z

    return v0
.end method

.method private setConfigCallbackForViewRoot()V
    .locals 7

    .prologue
    .line 384
    :try_start_0
    const-string/jumbo v3, "android.view.ViewRoot"

    invoke-static {v3}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    .line 385
    .local v0, "classViewRoot":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    if-eqz v0, :cond_0

    .line 386
    const-string/jumbo v3, "addConfigCallback"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Class;

    const/4 v5, 0x0

    const-class v6, Landroid/content/ComponentCallbacks;

    aput-object v6, v4, v5

    invoke-virtual {v0, v3, v4}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v2

    .line 387
    .local v2, "method":Ljava/lang/reflect/Method;
    const/4 v3, 0x0

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    new-instance v6, Lcom/amazon/mShop/AmazonApplication$2;

    invoke-direct {v6, p0}, Lcom/amazon/mShop/AmazonApplication$2;-><init>(Lcom/amazon/mShop/AmazonApplication;)V

    aput-object v6, v4, v5

    invoke-virtual {v2, v3, v4}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 415
    .end local v0    # "classViewRoot":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v2    # "method":Ljava/lang/reflect/Method;
    :cond_0
    :goto_0
    return-void

    .line 405
    :catch_0
    move-exception v1

    .line 413
    .local v1, "e":Ljava/lang/Exception;
    const-string/jumbo v3, "AmazonApplication"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "Unable to execute setConfigCallbackForViewRoot on Android Platform"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget-object v5, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public static setUp(Landroid/content/Context;)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 469
    invoke-static {p0}, Lcom/amazon/mShop/debug/DebugSettings;->setDebugEnabled(Landroid/content/Context;)V

    .line 470
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v0

    invoke-static {v0}, Lcom/amazon/mShop/AmazonApplication;->setWebviewDebugging(Z)V

    .line 480
    const-string/jumbo v0, "Amazon.com"

    invoke-static {p0, v0}, Lcom/amazon/mShop/platform/AndroidPlatform;->setUp(Landroid/content/Context;Ljava/lang/String;)V

    .line 481
    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/net/CookieBridge;->init(Landroid/content/Context;)V

    .line 482
    return-void
.end method

.method private setWebViewCacheEmptyFlag(Landroid/content/Context;)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v5, 0x0

    .line 445
    sget-object v3, Landroid/os/Build$VERSION;->SDK:Ljava/lang/String;

    invoke-static {v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    const/16 v4, 0x10

    if-lt v3, v4, :cond_0

    .line 446
    sput-boolean v5, Lcom/amazon/mShop/AmazonApplication;->sWebViewCacheEmpty:Z

    .line 462
    :goto_0
    return-void

    .line 451
    :cond_0
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 452
    .local v0, "applicationContext":Landroid/content/Context;
    const-string/jumbo v3, "webviewCache.db"

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual {v0, v3, v4, v5}, Landroid/content/Context;->openOrCreateDatabase(Ljava/lang/String;ILandroid/database/sqlite/SQLiteDatabase$CursorFactory;)Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 453
    .local v1, "cacheDb":Landroid/database/sqlite/SQLiteDatabase;
    if-eqz v1, :cond_1

    .line 454
    const/4 v3, 0x0

    sput-boolean v3, Lcom/amazon/mShop/AmazonApplication;->sWebViewCacheEmpty:Z

    .line 455
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->close()V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 458
    .end local v0    # "applicationContext":Landroid/content/Context;
    .end local v1    # "cacheDb":Landroid/database/sqlite/SQLiteDatabase;
    :catch_0
    move-exception v2

    .line 459
    .local v2, "t":Ljava/lang/Throwable;
    const-string/jumbo v3, "AmazonApplication"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "WebView is probably corrupted: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v2}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 461
    .end local v2    # "t":Ljava/lang/Throwable;
    :cond_1
    const/4 v3, 0x1

    sput-boolean v3, Lcom/amazon/mShop/AmazonApplication;->sWebViewCacheEmpty:Z

    goto :goto_0
.end method

.method private static setWebviewDebugging(Z)V
    .locals 2
    .param p0, "isEnabled"    # Z
    .annotation build Landroid/annotation/TargetApi;
        value = 0x13
    .end annotation

    .prologue
    .line 492
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x13

    if-lt v0, v1, :cond_0

    .line 493
    if-eqz p0, :cond_0

    .line 494
    const/4 v0, 0x1

    invoke-static {v0}, Landroid/webkit/WebView;->setWebContentsDebuggingEnabled(Z)V

    .line 495
    const-string/jumbo v0, "AmazonApplication"

    const-string/jumbo v1, "Enabled webview debugging"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 498
    :cond_0
    return-void
.end method

.method private static updateCloudDriveSignInStatus(Z)V
    .locals 8
    .param p0, "bSignedIn"    # Z

    .prologue
    .line 338
    :try_start_0
    invoke-static {}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getInstance()Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;

    move-result-object v6

    invoke-virtual {v6}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v6

    const-string/jumbo v7, "com.amazon.clouddrive.library.CloudDriveLibrary"

    invoke-virtual {v6, v7}, Ljava/lang/ClassLoader;->loadClass(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    .line 340
    .local v1, "cls":Ljava/lang/Class;
    const-string/jumbo v7, "getInstance"

    const/4 v6, 0x0

    check-cast v6, [Ljava/lang/Class;

    invoke-virtual {v1, v7, v6}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v3

    .line 341
    .local v3, "method":Ljava/lang/reflect/Method;
    const/4 v7, 0x0

    const/4 v6, 0x0

    check-cast v6, [Ljava/lang/Object;

    invoke-virtual {v3, v7, v6}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 342
    .local v0, "cdl":Ljava/lang/Object;
    if-eqz p0, :cond_0

    const-string/jumbo v5, "signIn"

    .line 343
    .local v5, "whichMethod":Ljava/lang/String;
    :goto_0
    const/4 v6, 0x0

    check-cast v6, [Ljava/lang/Class;

    invoke-virtual {v1, v5, v6}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v4

    .line 344
    .local v4, "signInOrOut":Ljava/lang/reflect/Method;
    const/4 v6, 0x0

    check-cast v6, [Ljava/lang/Object;

    invoke-virtual {v4, v0, v6}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 348
    .end local v0    # "cdl":Ljava/lang/Object;
    .end local v1    # "cls":Ljava/lang/Class;
    .end local v3    # "method":Ljava/lang/reflect/Method;
    .end local v4    # "signInOrOut":Ljava/lang/reflect/Method;
    .end local v5    # "whichMethod":Ljava/lang/String;
    :goto_1
    return-void

    .line 342
    .restart local v0    # "cdl":Ljava/lang/Object;
    .restart local v1    # "cls":Ljava/lang/Class;
    .restart local v3    # "method":Ljava/lang/reflect/Method;
    :cond_0
    const-string/jumbo v5, "signOut"
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 345
    .end local v0    # "cdl":Ljava/lang/Object;
    .end local v1    # "cls":Ljava/lang/Class;
    .end local v3    # "method":Ljava/lang/reflect/Method;
    :catch_0
    move-exception v2

    .line 346
    .local v2, "ex":Ljava/lang/Exception;
    const-string/jumbo v6, "AmazonApplication"

    const-string/jumbo v7, "Cloud Drive sign in failed."

    invoke-static {v6, v7, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_1
.end method


# virtual methods
.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 0
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .prologue
    .line 427
    invoke-static {p1}, Lcom/amazon/mShop/util/LocaleUtils;->ensureConfigLocale(Landroid/content/res/Configuration;)V

    .line 428
    invoke-super {p0, p1}, Landroid/app/Application;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 432
    invoke-static {p0}, Lcom/amazon/mShop/util/LocaleUtils;->ensureAppLocale(Landroid/content/Context;)V

    .line 433
    return-void
.end method

.method public onCreate()V
    .locals 10

    .prologue
    const/4 v6, 0x1

    .line 150
    invoke-static {p0}, Lcom/amazon/mShop/AmazonApplication;->setUp(Landroid/content/Context;)V

    .line 152
    new-instance v7, Ljava/util/concurrent/CountDownLatch;

    invoke-direct {v7, v6}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    .line 154
    .local v7, "appStoreLoadingLatch":Ljava/util/concurrent/CountDownLatch;
    iget-object v0, p0, Lcom/amazon/mShop/AmazonApplication;->mCriticalJarList:Ljava/util/List;

    invoke-direct {p0, v0, v7}, Lcom/amazon/mShop/AmazonApplication;->initializeDex(Ljava/util/List;Ljava/util/concurrent/CountDownLatch;)V

    .line 156
    new-instance v0, Lcom/amazon/mShop/mash/MShopMASHApplication;

    invoke-direct {v0}, Lcom/amazon/mShop/mash/MShopMASHApplication;-><init>()V

    invoke-static {v0}, Lcom/amazon/mobile/mash/MASHApplicationFactory;->setInstance(Lcom/amazon/mobile/mash/MASHApplication;)V

    .line 159
    invoke-static {p0}, Lcom/amazon/mShop/util/FeatureUtil;->loadFromRawFile(Landroid/content/Context;)V

    .line 162
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 163
    invoke-static {}, Lcom/amazon/mShop/debug/UncaughtExceptionHandler;->getInstance()Lcom/amazon/mShop/debug/UncaughtExceptionHandler;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Thread;->setDefaultUncaughtExceptionHandler(Ljava/lang/Thread$UncaughtExceptionHandler;)V

    .line 168
    :cond_0
    const-string/jumbo v0, "A1MPSLFC7L5AFK"

    invoke-static {p0, v0}, Lcom/amazon/mShop/DCMInitializer;->initialize(Landroid/content/Context;Ljava/lang/String;)V

    .line 172
    invoke-static {p0}, Lcom/amazon/identity/auth/device/api/MAPInit;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/api/MAPInit;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/MAPInit;->initialize()V

    .line 174
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonApplication;->setConfigCallbackForViewRoot()V

    .line 175
    invoke-super {p0}, Landroid/app/Application;->onCreate()V

    .line 176
    const-string/jumbo v0, "A1MPSLFC7L5AFK"

    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDeviceId()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/amazon/mShop/crash/EmptyOAuthHelper;

    invoke-direct {v2}, Lcom/amazon/mShop/crash/EmptyOAuthHelper;-><init>()V

    new-instance v3, Lcom/amazon/client/metrics/NullMetricsFactory;

    invoke-direct {v3}, Lcom/amazon/client/metrics/NullMetricsFactory;-><init>()V

    new-instance v4, Lcom/amazon/mShop/crash/ProdDomainChooser;

    invoke-direct {v4}, Lcom/amazon/mShop/crash/ProdDomainChooser;-><init>()V

    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonApplication;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    invoke-static/range {v0 .. v6}, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->setUpCrashDetection(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/device/utils/OAuthHelper;Lcom/amazon/client/metrics/MetricsFactory;Lcom/amazon/device/crashmanager/DomainChooser;Landroid/content/Context;Z)Lcom/amazon/device/crashmanager/CrashDetectionHelper;

    .line 177
    invoke-static {}, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->getInstance()Lcom/amazon/device/crashmanager/CrashDetectionHelper;

    move-result-object v8

    .line 179
    .local v8, "crashDetectionHelper":Lcom/amazon/device/crashmanager/CrashDetectionHelper;
    if-eqz v8, :cond_1

    .line 180
    invoke-static {}, Lcom/amazon/mShop/wearable/WearableCrashDetails;->getInstance()Lcom/amazon/mShop/wearable/WearableCrashDetails;

    move-result-object v0

    invoke-virtual {v8, v0}, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->appendCrashDetailsCollector(Lcom/amazon/device/crashmanager/CrashDetailsCollectable;)V

    .line 181
    new-instance v9, Lcom/amazon/mShop/crash/RtlaCrashDetailsProvider;

    invoke-direct {v9}, Lcom/amazon/mShop/crash/RtlaCrashDetailsProvider;-><init>()V

    .line 182
    .local v9, "rtlaDetails":Lcom/amazon/device/crashmanager/rtla/RtlaCrashDetails;
    new-instance v0, Lcom/amazon/device/crashmanager/rtla/RtlaCrashDetailsCollectable;

    invoke-direct {v0, v9}, Lcom/amazon/device/crashmanager/rtla/RtlaCrashDetailsCollectable;-><init>(Lcom/amazon/device/crashmanager/rtla/RtlaCrashDetails;)V

    invoke-virtual {v8, v0}, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->appendCrashDetailsCollector(Lcom/amazon/device/crashmanager/CrashDetailsCollectable;)V

    .line 183
    new-instance v0, Lcom/amazon/mShop/crash/CrashDetailsCollector;

    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonApplication;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/amazon/mShop/crash/CrashDetailsCollector;-><init>(Landroid/content/Context;)V

    invoke-virtual {v8, v0}, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->appendCrashDetailsCollector(Lcom/amazon/device/crashmanager/CrashDetailsCollectable;)V

    .line 185
    .end local v9    # "rtlaDetails":Lcom/amazon/device/crashmanager/rtla/RtlaCrashDetails;
    :cond_1
    invoke-static {p0}, Lcom/amazon/mShop/util/ConfigUtils;->injectDefaultDebugSettings(Landroid/content/Context;)V

    .line 187
    invoke-static {}, Lcom/amazon/mShop/crash/AmazonCrashHandler;->getInstance()Lcom/amazon/mShop/crash/AmazonCrashHandler;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/crash/AmazonCrashHandler;->setupCrashHandler()V

    .line 191
    invoke-direct {p0, p0}, Lcom/amazon/mShop/AmazonApplication;->setWebViewCacheEmptyFlag(Landroid/content/Context;)V

    .line 193
    invoke-static {p0}, Lcom/amazon/mShop/util/LocaleUtils;->ensureAppLocale(Landroid/content/Context;)V

    .line 195
    invoke-static {p0}, Lcom/amazon/mShop/gno/GNOMenuItemController;->init(Landroid/content/Context;)V

    .line 198
    invoke-static {}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getInstance()Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->init(Landroid/content/Context;)V

    .line 199
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonApplication;->initializeCloudDrive()V

    .line 202
    invoke-static {}, Lcom/amazon/mShop/voice/VoiceSearchInitializer;->getInstance()Lcom/amazon/mShop/voice/VoiceSearchInitializer;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/voice/VoiceSearchInitializer;->initialize(Landroid/content/Context;)V

    .line 204
    invoke-direct {p0, v7, v8}, Lcom/amazon/mShop/AmazonApplication;->initializeAppStore(Ljava/util/concurrent/CountDownLatch;Lcom/amazon/device/crashmanager/CrashDetectionHelper;)V

    .line 210
    invoke-static {}, Lcom/amazon/mShop/aiv/AIVAvailabilityUtils;->isAIVSupportedByDevice()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 211
    invoke-static {}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->getInstance()Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->initializeAIV(Landroid/content/Context;)V

    .line 212
    sget-object v0, Lcom/amazon/mShop/AmazonApplication;->AIV_USER_LISTENER:Lcom/amazon/mShop/model/auth/UserListener;

    invoke-static {v0}, Lcom/amazon/mShop/model/auth/User;->addUserListener(Lcom/amazon/mShop/model/auth/UserListener;)V

    .line 216
    :cond_2
    invoke-static {p0}, Lcom/amazon/mShop/AppExtensionsInitializer;->initializeSearch(Landroid/content/Context;)V

    .line 217
    return-void
.end method

.method public onLowMemory()V
    .locals 0

    .prologue
    .line 438
    invoke-static {}, Lcom/amazon/mShop/net/LRUCache;->onLowMemory()V

    .line 439
    return-void
.end method

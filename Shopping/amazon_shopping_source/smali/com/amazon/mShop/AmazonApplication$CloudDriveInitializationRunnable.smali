.class Lcom/amazon/mShop/AmazonApplication$CloudDriveInitializationRunnable;
.super Ljava/lang/Object;
.source "AmazonApplication.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/AmazonApplication;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "CloudDriveInitializationRunnable"
.end annotation


# instance fields
.field private final mContext:Landroid/content/Context;


# direct methods
.method private constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 293
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 294
    iput-object p1, p0, Lcom/amazon/mShop/AmazonApplication$CloudDriveInitializationRunnable;->mContext:Landroid/content/Context;

    .line 295
    return-void
.end method

.method synthetic constructor <init>(Landroid/content/Context;Lcom/amazon/mShop/AmazonApplication$1;)V
    .locals 0
    .param p1, "x0"    # Landroid/content/Context;
    .param p2, "x1"    # Lcom/amazon/mShop/AmazonApplication$1;

    .prologue
    .line 290
    invoke-direct {p0, p1}, Lcom/amazon/mShop/AmazonApplication$CloudDriveInitializationRunnable;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 10

    .prologue
    .line 299
    const/4 v4, 0x0

    .line 301
    .local v4, "initializedSuccessful":Z
    :try_start_0
    const-string/jumbo v6, "com.amazon.clouddrive.library.CloudDriveLibrary"

    const/4 v7, 0x1

    invoke-static {}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getInstance()Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;

    move-result-object v8

    invoke-virtual {v8}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v8

    invoke-static {v6, v7, v8}, Ljava/lang/Class;->forName(Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;

    move-result-object v1

    .line 303
    .local v1, "cls":Ljava/lang/Class;
    const-string/jumbo v7, "getInstance"

    const/4 v6, 0x0

    check-cast v6, [Ljava/lang/Class;

    invoke-virtual {v1, v7, v6}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v5

    .line 304
    .local v5, "method":Ljava/lang/reflect/Method;
    const/4 v7, 0x0

    const/4 v6, 0x0

    check-cast v6, [Ljava/lang/Object;

    invoke-virtual {v5, v7, v6}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 305
    .local v0, "cdl":Ljava/lang/Object;
    const-string/jumbo v6, "initialize"

    const/4 v7, 0x3

    new-array v7, v7, [Ljava/lang/Class;

    const/4 v8, 0x0

    const-class v9, Landroid/content/Context;

    aput-object v9, v7, v8

    const/4 v8, 0x1

    const-class v9, Ljava/lang/Class;

    aput-object v9, v7, v8

    const/4 v8, 0x2

    const-class v9, Ljava/lang/Class;

    aput-object v9, v7, v8

    invoke-virtual {v1, v6, v7}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v3

    .line 307
    .local v3, "init":Ljava/lang/reflect/Method;
    const/4 v6, 0x3

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    iget-object v8, p0, Lcom/amazon/mShop/AmazonApplication$CloudDriveInitializationRunnable;->mContext:Landroid/content/Context;

    aput-object v8, v6, v7

    const/4 v7, 0x1

    const-class v8, Lcom/amazon/mShop/clouddrive/CloudDriveUploadActivity;

    aput-object v8, v6, v7

    const/4 v7, 0x2

    const-class v8, Lcom/amazon/mShop/clouddrive/CloudDriveManageStorageActivity;

    aput-object v8, v6, v7

    invoke-virtual {v3, v0, v6}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 310
    # getter for: Lcom/amazon/mShop/AmazonApplication;->mCloudDriveListener:Lcom/amazon/mShop/model/auth/UserListener;
    invoke-static {}, Lcom/amazon/mShop/AmazonApplication;->access$200()Lcom/amazon/mShop/model/auth/UserListener;

    move-result-object v6

    invoke-static {v6}, Lcom/amazon/mShop/model/auth/User;->addUserListener(Lcom/amazon/mShop/model/auth/UserListener;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 311
    const/4 v4, 0x1

    .line 316
    .end local v0    # "cdl":Ljava/lang/Object;
    .end local v1    # "cls":Ljava/lang/Class;
    .end local v3    # "init":Ljava/lang/reflect/Method;
    .end local v5    # "method":Ljava/lang/reflect/Method;
    :goto_0
    invoke-static {}, Lcom/amazon/mShop/clouddrive/CloudDriveAvailability;->getInstance()Lcom/amazon/mShop/clouddrive/CloudDriveAvailability;

    move-result-object v6

    invoke-virtual {v6, v4}, Lcom/amazon/mShop/clouddrive/CloudDriveAvailability;->setCloudDriveInitialized(Z)V

    .line 317
    return-void

    .line 312
    :catch_0
    move-exception v2

    .line 313
    .local v2, "ex":Ljava/lang/Exception;
    const-string/jumbo v6, "AmazonApplication"

    const-string/jumbo v7, "Cloud Drive Photos initialization failed."

    invoke-static {v6, v7, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

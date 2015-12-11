.class public Lcom/amazon/android/webkit/AmazonWebKitFactories;
.super Ljava/lang/Object;
.source "AmazonWebKitFactories.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/android/webkit/AmazonWebKitFactories$Implementation;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;

.field private static defaultFactory:Ljava/lang/String;

.field private static defaultFactoryApiLevelCache:I

.field private static factoryCreated:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 34
    const-class v0, Lcom/amazon/android/webkit/AmazonWebKitFactories;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/AmazonWebKitFactories;->TAG:Ljava/lang/String;

    .line 37
    const/4 v0, 0x0

    sput-object v0, Lcom/amazon/android/webkit/AmazonWebKitFactories;->defaultFactory:Ljava/lang/String;

    .line 39
    const/4 v0, 0x0

    sput-boolean v0, Lcom/amazon/android/webkit/AmazonWebKitFactories;->factoryCreated:Z

    .line 44
    const/4 v0, -0x1

    sput v0, Lcom/amazon/android/webkit/AmazonWebKitFactories;->defaultFactoryApiLevelCache:I

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 51
    return-void
.end method

.method private static AWVIsLevel1()Z
    .locals 14

    .prologue
    const/4 v12, 0x4

    .line 283
    const/4 v7, 0x0

    .line 284
    .local v7, "retVal":Z
    const-string/jumbo v3, "com.amazon.webview"

    .line 287
    .local v3, "packageName":Ljava/lang/String;
    :try_start_0
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebKitFactories;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 290
    .local v0, "appContext":Landroid/content/Context;
    invoke-virtual {v0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v10

    const/16 v11, 0x80

    invoke-virtual {v10, v3, v11}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v6

    .line 292
    .local v6, "pi":Landroid/content/pm/PackageInfo;
    iget-object v9, v6, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    .line 297
    .local v9, "versionName":Ljava/lang/String;
    const-string/jumbo v10, "\\."

    const/4 v11, 0x4

    invoke-virtual {v9, v10, v11}, Ljava/lang/String;->split(Ljava/lang/String;I)[Ljava/lang/String;

    move-result-object v8

    .line 299
    .local v8, "tokens":[Ljava/lang/String;
    array-length v10, v8

    if-lt v10, v12, :cond_0

    .line 300
    const/4 v10, 0x3

    aget-object v10, v8, v10

    const/4 v11, 0x0

    const/4 v12, 0x3

    aget-object v12, v8, v12

    const-string/jumbo v13, "_"

    invoke-virtual {v12, v13}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v12

    invoke-virtual {v10, v11, v12}, Ljava/lang/String;->substring(II)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v5

    .line 302
    .local v5, "patchString":Ljava/lang/String;
    const/4 v10, 0x0

    :try_start_1
    aget-object v10, v8, v10

    invoke-static {v10}, Ljava/lang/Integer;->decode(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v2

    .line 303
    .local v2, "major":Ljava/lang/Integer;
    invoke-static {v5}, Ljava/lang/Integer;->decode(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v4

    .line 304
    .local v4, "patch":Ljava/lang/Integer;
    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v10

    const/16 v11, 0x19

    if-ne v10, v11, :cond_0

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I
    :try_end_1
    .catch Ljava/lang/NumberFormatException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    move-result v10

    if-nez v10, :cond_0

    .line 305
    const/4 v7, 0x1

    .line 315
    .end local v0    # "appContext":Landroid/content/Context;
    .end local v2    # "major":Ljava/lang/Integer;
    .end local v4    # "patch":Ljava/lang/Integer;
    .end local v5    # "patchString":Ljava/lang/String;
    .end local v6    # "pi":Landroid/content/pm/PackageInfo;
    .end local v8    # "tokens":[Ljava/lang/String;
    .end local v9    # "versionName":Ljava/lang/String;
    :cond_0
    :goto_0
    return v7

    .line 307
    .restart local v0    # "appContext":Landroid/content/Context;
    .restart local v5    # "patchString":Ljava/lang/String;
    .restart local v6    # "pi":Landroid/content/pm/PackageInfo;
    .restart local v8    # "tokens":[Ljava/lang/String;
    .restart local v9    # "versionName":Ljava/lang/String;
    :catch_0
    move-exception v1

    .line 308
    .local v1, "e":Ljava/lang/NumberFormatException;
    :try_start_2
    sget-object v10, Lcom/amazon/android/webkit/AmazonWebKitFactories;->TAG:Ljava/lang/String;

    const-string/jumbo v11, "exception getting package api level."

    invoke-static {v10, v11, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_0

    .line 311
    .end local v0    # "appContext":Landroid/content/Context;
    .end local v1    # "e":Ljava/lang/NumberFormatException;
    .end local v5    # "patchString":Ljava/lang/String;
    .end local v6    # "pi":Landroid/content/pm/PackageInfo;
    .end local v8    # "tokens":[Ljava/lang/String;
    .end local v9    # "versionName":Ljava/lang/String;
    :catch_1
    move-exception v1

    .line 312
    .local v1, "e":Ljava/lang/Exception;
    sget-object v10, Lcom/amazon/android/webkit/AmazonWebKitFactories;->TAG:Ljava/lang/String;

    const-string/jumbo v11, "exception in AWVIsLevel1()."

    invoke-static {v10, v11, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebKitFactories;->getExternalFactoryName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$100()Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    sget-object v0, Lcom/amazon/android/webkit/AmazonWebKitFactories;->defaultFactory:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$200(Ljava/lang/String;)I
    .locals 1
    .param p0, "x0"    # Ljava/lang/String;

    .prologue
    .line 24
    invoke-static {p0}, Lcom/amazon/android/webkit/AmazonWebKitFactories;->detectApiLevelForFactory(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method static synthetic access$300()Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    sget-object v0, Lcom/amazon/android/webkit/AmazonWebKitFactories;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$400()I
    .locals 1

    .prologue
    .line 24
    sget v0, Lcom/amazon/android/webkit/AmazonWebKitFactories;->defaultFactoryApiLevelCache:I

    return v0
.end method

.method static synthetic access$402(I)I
    .locals 0
    .param p0, "x0"    # I

    .prologue
    .line 24
    sput p0, Lcom/amazon/android/webkit/AmazonWebKitFactories;->defaultFactoryApiLevelCache:I

    return p0
.end method

.method private static detectApiLevelForFactory(Ljava/lang/String;)I
    .locals 7
    .param p0, "factory"    # Ljava/lang/String;

    .prologue
    .line 256
    const/4 v3, -0x1

    .line 259
    .local v3, "implementationApiLevel":I
    :try_start_0
    invoke-static {p0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    .line 260
    .local v1, "factoryClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-string/jumbo v4, "getMaxApiLevelSupportedStatic"

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Class;

    invoke-virtual {v1, v4, v5}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v2

    .line 261
    .local v2, "getApiLevelStatic":Ljava/lang/reflect/Method;
    const/4 v4, 0x0

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Object;

    invoke-virtual {v2, v4, v5}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Integer;

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I
    :try_end_0
    .catch Ljava/lang/NoSuchMethodException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    move-result v3

    .line 274
    .end local v1    # "factoryClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v2    # "getApiLevelStatic":Ljava/lang/reflect/Method;
    :cond_0
    :goto_0
    const/4 v4, -0x1

    if-eq v3, v4, :cond_1

    .line 275
    sget-object v4, Lcom/amazon/android/webkit/AmazonWebKitFactories;->TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "Successfully found API level for factory:"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, " level:"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 278
    :cond_1
    return v3

    .line 262
    :catch_0
    move-exception v0

    .line 267
    .local v0, "e":Ljava/lang/NoSuchMethodException;
    const-string/jumbo v4, "com.amazon.android.webkit.embedded.EmbeddedWebKitFactory"

    invoke-virtual {v4, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebKitFactories;->AWVIsLevel1()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 268
    const/4 v3, 0x1

    goto :goto_0

    .line 270
    .end local v0    # "e":Ljava/lang/NoSuchMethodException;
    :catch_1
    move-exception v0

    .line 271
    .local v0, "e":Ljava/lang/Exception;
    sget-object v4, Lcom/amazon/android/webkit/AmazonWebKitFactories;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "exception in detectApiLevelForFactory "

    invoke-static {v4, v5, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method private static getApplicationContext()Landroid/content/Context;
    .locals 6

    .prologue
    const/4 v3, 0x0

    .line 190
    :try_start_0
    const-string/jumbo v2, "android.app.ActivityThread"

    invoke-static {v2}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v2

    const-string/jumbo v4, "currentApplication"

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Class;

    invoke-virtual {v2, v4, v5}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    .line 192
    .local v1, "getCurrentApplication":Ljava/lang/reflect/Method;
    const/4 v4, 0x0

    const/4 v2, 0x0

    check-cast v2, [Ljava/lang/Object;

    invoke-virtual {v1, v4, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/content/Context;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 195
    :goto_0
    return-object v2

    .line 193
    :catch_0
    move-exception v0

    .line 194
    .local v0, "e":Ljava/lang/Exception;
    sget-object v2, Lcom/amazon/android/webkit/AmazonWebKitFactories;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "exception getting application context"

    invoke-static {v2, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    move-object v2, v3

    .line 195
    goto :goto_0
.end method

.method public static getDefaultFactory()Lcom/amazon/android/webkit/AmazonWebKitFactory;
    .locals 1

    .prologue
    .line 142
    const/4 v0, 0x1

    sput-boolean v0, Lcom/amazon/android/webkit/AmazonWebKitFactories;->factoryCreated:Z

    .line 143
    sget-object v0, Lcom/amazon/android/webkit/AmazonWebKitFactories$Implementation;->FACTORY:Lcom/amazon/android/webkit/AmazonWebKitFactory;

    return-object v0
.end method

.method private static getExternalFactoryName()Ljava/lang/String;
    .locals 15

    .prologue
    const/4 v10, 0x0

    .line 147
    const/4 v6, 0x0

    .line 148
    .local v6, "factory":Ljava/lang/String;
    const/4 v3, 0x0

    .line 151
    .local v3, "appName":Ljava/lang/String;
    const-string/jumbo v1, ".wv"

    .line 153
    .local v1, "SUFFIX":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebKitFactories;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 154
    .local v4, "context":Landroid/content/Context;
    if-eqz v4, :cond_0

    .line 156
    :try_start_0
    invoke-virtual {v4}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v9

    .line 157
    .local v9, "packageManager":Landroid/content/pm/PackageManager;
    invoke-virtual {v4}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v11

    const/16 v12, 0x80

    invoke-virtual {v9, v11, v12}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v2

    .line 159
    .local v2, "appInfo":Landroid/content/pm/ApplicationInfo;
    invoke-virtual {v9, v2}, Landroid/content/pm/PackageManager;->getApplicationLabel(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;

    move-result-object v8

    .line 160
    .local v8, "label":Ljava/lang/CharSequence;
    if-eqz v8, :cond_3

    invoke-virtual {v8}, Ljava/lang/Object;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 167
    .end local v2    # "appInfo":Landroid/content/pm/ApplicationInfo;
    .end local v8    # "label":Ljava/lang/CharSequence;
    .end local v9    # "packageManager":Landroid/content/pm/PackageManager;
    :cond_0
    :goto_0
    if-eqz v3, :cond_2

    .line 168
    :try_start_1
    const-string/jumbo v10, "android.os.SystemProperties"

    invoke-static {v10}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v10

    const-string/jumbo v11, "get"

    const/4 v12, 0x2

    new-array v12, v12, [Ljava/lang/Class;

    const/4 v13, 0x0

    const-class v14, Ljava/lang/String;

    aput-object v14, v12, v13

    const/4 v13, 0x1

    const-class v14, Ljava/lang/String;

    aput-object v14, v12, v13

    invoke-virtual {v10, v11, v12}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v7

    .line 173
    .local v7, "getSystemProperties":Ljava/lang/reflect/Method;
    const-string/jumbo v10, "android.os.SystemProperties"

    invoke-static {v10}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v10

    const-string/jumbo v11, "PROP_NAME_MAX"

    invoke-virtual {v10, v11}, Ljava/lang/Class;->getField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v10

    const/4 v11, 0x0

    invoke-virtual {v10, v11}, Ljava/lang/reflect/Field;->getInt(Ljava/lang/Object;)I

    move-result v0

    .line 176
    .local v0, "PROPERTY_MAX_LENGTH":I
    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v10

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v11

    sub-int v11, v0, v11

    if-le v10, v11, :cond_1

    .line 177
    const/4 v10, 0x0

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v11

    sub-int v11, v0, v11

    invoke-virtual {v3, v10, v11}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    .line 179
    :cond_1
    const/4 v10, 0x0

    const/4 v11, 0x2

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v12, 0x0

    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v13, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    aput-object v13, v11, v12

    const/4 v12, 0x1

    const/4 v13, 0x0

    aput-object v13, v11, v12

    invoke-virtual {v7, v10, v11}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    .end local v6    # "factory":Ljava/lang/String;
    check-cast v6, Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 182
    .end local v0    # "PROPERTY_MAX_LENGTH":I
    .end local v7    # "getSystemProperties":Ljava/lang/reflect/Method;
    .restart local v6    # "factory":Ljava/lang/String;
    :cond_2
    return-object v6

    .restart local v2    # "appInfo":Landroid/content/pm/ApplicationInfo;
    .restart local v8    # "label":Ljava/lang/CharSequence;
    .restart local v9    # "packageManager":Landroid/content/pm/PackageManager;
    :cond_3
    move-object v3, v10

    .line 160
    goto :goto_0

    .line 161
    .end local v2    # "appInfo":Landroid/content/pm/ApplicationInfo;
    .end local v8    # "label":Ljava/lang/CharSequence;
    .end local v9    # "packageManager":Landroid/content/pm/PackageManager;
    :catch_0
    move-exception v5

    .line 162
    .local v5, "e":Ljava/lang/Exception;
    sget-object v10, Lcom/amazon/android/webkit/AmazonWebKitFactories;->TAG:Ljava/lang/String;

    const-string/jumbo v11, "exception when getting application name."

    invoke-static {v10, v11, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 183
    .end local v5    # "e":Ljava/lang/Exception;
    .end local v6    # "factory":Ljava/lang/String;
    :catch_1
    move-exception v5

    .line 184
    .restart local v5    # "e":Ljava/lang/Exception;
    new-instance v10, Ljava/lang/RuntimeException;

    const-string/jumbo v11, "Unable to get External Factory Name"

    invoke-direct {v10, v11, v5}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v10
.end method

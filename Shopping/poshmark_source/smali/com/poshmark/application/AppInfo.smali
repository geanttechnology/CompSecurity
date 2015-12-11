.class public Lcom/poshmark/application/AppInfo;
.super Ljava/lang/Object;
.source "AppInfo.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/application/AppInfo$1;,
        Lcom/poshmark/application/AppInfo$SingletonHolder;
    }
.end annotation


# static fields
.field public static final apiVersion:Ljava/lang/String; = "0.2"

.field public static final appType:Ljava/lang/String; = "android"


# instance fields
.field public final deviceID:Ljava/lang/String;

.field public final deviceInfo:Ljava/util/Map;
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

.field public final deviceModel:Ljava/lang/String;

.field public final packageName:Ljava/lang/String;

.field public final userAgent:Ljava/lang/String;

.field public final versionCode:I

.field public final versionCodeString:Ljava/lang/String;

.field public final versionName:Ljava/lang/String;


# direct methods
.method private constructor <init>()V
    .locals 15

    .prologue
    const/4 v14, 0x2

    const/4 v13, 0x1

    const/4 v9, 0x0

    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    .line 35
    .local v1, "application":Landroid/content/Context;
    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v8

    iput-object v8, p0, Lcom/poshmark/application/AppInfo;->packageName:Ljava/lang/String;

    .line 36
    const/4 v6, 0x0

    .line 39
    .local v6, "pInfo":Landroid/content/pm/PackageInfo;
    :try_start_0
    invoke-virtual {v1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v8

    iget-object v10, p0, Lcom/poshmark/application/AppInfo;->packageName:Ljava/lang/String;

    const/4 v11, 0x0

    invoke-virtual {v8, v10, v11}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v6

    .line 43
    :goto_0
    if-eqz v6, :cond_0

    iget-object v8, v6, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    if-eqz v8, :cond_0

    iget-object v8, v6, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    :goto_1
    iput-object v8, p0, Lcom/poshmark/application/AppInfo;->versionName:Ljava/lang/String;

    .line 44
    if-eqz v6, :cond_1

    iget v8, v6, Landroid/content/pm/PackageInfo;->versionCode:I

    :goto_2
    iput v8, p0, Lcom/poshmark/application/AppInfo;->versionCode:I

    .line 45
    iget v8, p0, Lcom/poshmark/application/AppInfo;->versionCode:I

    invoke-static {v8}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v8

    iput-object v8, p0, Lcom/poshmark/application/AppInfo;->versionCodeString:Ljava/lang/String;

    .line 48
    const/4 v0, 0x0

    .line 50
    .local v0, "androidId":Ljava/lang/String;
    :try_start_1
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v8

    invoke-virtual {v8}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v8

    const-string v10, "android_id"

    invoke-static {v8, v10}, Landroid/provider/Settings$Secure;->getString(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v0

    .line 58
    :goto_3
    if-eqz v0, :cond_2

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "and1:"

    invoke-virtual {v8, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    :goto_4
    iput-object v8, p0, Lcom/poshmark/application/AppInfo;->deviceID:Ljava/lang/String;

    .line 61
    const-string v3, ""

    .line 63
    .local v3, "deviceBrandAndModel":Ljava/lang/String;
    :try_start_2
    sget-object v8, Landroid/os/Build;->BRAND:Ljava/lang/String;

    if-eqz v8, :cond_3

    sget-object v2, Landroid/os/Build;->BRAND:Ljava/lang/String;

    .line 64
    .local v2, "brand":Ljava/lang/String;
    :goto_5
    sget-object v8, Landroid/os/Build;->MODEL:Ljava/lang/String;

    if-eqz v8, :cond_4

    sget-object v5, Landroid/os/Build;->MODEL:Ljava/lang/String;

    .line 65
    .local v5, "model":Ljava/lang/String;
    :goto_6
    const-string v8, "%s/%s"

    const/4 v10, 0x2

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    aput-object v2, v10, v11

    const/4 v11, 0x1

    aput-object v5, v10, v11

    invoke-static {v8, v10}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_3

    move-result-object v3

    .line 68
    .end local v2    # "brand":Ljava/lang/String;
    .end local v5    # "model":Ljava/lang/String;
    :goto_7
    iput-object v3, p0, Lcom/poshmark/application/AppInfo;->deviceModel:Ljava/lang/String;

    .line 70
    new-instance v8, Ljava/util/HashMap;

    invoke-direct {v8}, Ljava/util/HashMap;-><init>()V

    iput-object v8, p0, Lcom/poshmark/application/AppInfo;->deviceInfo:Ljava/util/Map;

    .line 71
    iget-object v8, p0, Lcom/poshmark/application/AppInfo;->deviceInfo:Ljava/util/Map;

    const-string v10, "device_id"

    iget-object v11, p0, Lcom/poshmark/application/AppInfo;->deviceID:Ljava/lang/String;

    invoke-interface {v8, v10, v11}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 72
    iget-object v8, p0, Lcom/poshmark/application/AppInfo;->deviceInfo:Ljava/util/Map;

    const-string v10, "device_model"

    iget-object v11, p0, Lcom/poshmark/application/AppInfo;->deviceModel:Ljava/lang/String;

    invoke-interface {v8, v10, v11}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 73
    iget-object v8, p0, Lcom/poshmark/application/AppInfo;->deviceInfo:Ljava/util/Map;

    const-string v10, "os"

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "Android: "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    sget-object v12, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-interface {v8, v10, v11}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 75
    const-string v7, ""

    .line 77
    .local v7, "systemUserAgent":Ljava/lang/String;
    :try_start_3
    const-string v8, "http.agent"

    invoke-static {v8}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_2

    move-result-object v7

    .line 83
    :goto_8
    const-string v8, "%s PoshmarkAndroidApp/%s (%s)"

    const/4 v10, 0x3

    new-array v10, v10, [Ljava/lang/Object;

    aput-object v7, v10, v9

    iget-object v9, p0, Lcom/poshmark/application/AppInfo;->versionName:Ljava/lang/String;

    aput-object v9, v10, v13

    iget-object v9, p0, Lcom/poshmark/application/AppInfo;->versionCodeString:Ljava/lang/String;

    aput-object v9, v10, v14

    invoke-static {v8, v10}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    iput-object v8, p0, Lcom/poshmark/application/AppInfo;->userAgent:Ljava/lang/String;

    .line 85
    return-void

    .line 40
    .end local v0    # "androidId":Ljava/lang/String;
    .end local v3    # "deviceBrandAndModel":Ljava/lang/String;
    .end local v7    # "systemUserAgent":Ljava/lang/String;
    :catch_0
    move-exception v4

    .line 41
    .local v4, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v4}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto/16 :goto_0

    .line 43
    .end local v4    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_0
    const-string v8, ""

    goto/16 :goto_1

    :cond_1
    move v8, v9

    .line 44
    goto/16 :goto_2

    .line 52
    .restart local v0    # "androidId":Ljava/lang/String;
    :catch_1
    move-exception v4

    .line 54
    .local v4, "e":Ljava/lang/Exception;
    :try_start_4
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v8

    invoke-virtual {v8}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v8

    const-string v10, "android_id"

    invoke-static {v8, v10}, Landroid/provider/Settings$Secure;->getString(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_4

    move-result-object v0

    goto/16 :goto_3

    .line 58
    .end local v4    # "e":Ljava/lang/Exception;
    :cond_2
    const-string v8, ""

    goto/16 :goto_4

    .line 63
    .restart local v3    # "deviceBrandAndModel":Ljava/lang/String;
    :cond_3
    :try_start_5
    const-string v2, ""

    goto/16 :goto_5

    .line 64
    .restart local v2    # "brand":Ljava/lang/String;
    :cond_4
    const-string v5, ""
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_3

    goto/16 :goto_6

    .line 79
    .end local v2    # "brand":Ljava/lang/String;
    .restart local v7    # "systemUserAgent":Ljava/lang/String;
    :catch_2
    move-exception v8

    goto :goto_8

    .line 67
    .end local v7    # "systemUserAgent":Ljava/lang/String;
    :catch_3
    move-exception v8

    goto/16 :goto_7

    .line 56
    .end local v3    # "deviceBrandAndModel":Ljava/lang/String;
    .restart local v4    # "e":Ljava/lang/Exception;
    :catch_4
    move-exception v8

    goto/16 :goto_3
.end method

.method synthetic constructor <init>(Lcom/poshmark/application/AppInfo$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/poshmark/application/AppInfo$1;

    .prologue
    .line 16
    invoke-direct {p0}, Lcom/poshmark/application/AppInfo;-><init>()V

    return-void
.end method

.method public static getInstance()Lcom/poshmark/application/AppInfo;
    .locals 1

    .prologue
    .line 94
    sget-object v0, Lcom/poshmark/application/AppInfo$SingletonHolder;->INSTANCE:Lcom/poshmark/application/AppInfo;

    return-object v0
.end method

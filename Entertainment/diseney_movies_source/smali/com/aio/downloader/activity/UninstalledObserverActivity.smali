.class public Lcom/aio/downloader/activity/UninstalledObserverActivity;
.super Landroid/app/Activity;
.source "UninstalledObserverActivity.java"


# static fields
.field private static final TAG:Ljava/lang/String; = "UninstalledObserverActivity"


# instance fields
.field private mObserverProcessPid:I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 34
    const-string v0, "UninstalledObserverActivity"

    const-string v1, "load lib --> uninstalled_observer"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 35
    const-string v0, "uninstalled_observer"

    invoke-static {v0}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V

    .line 36
    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 20
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 25
    const/4 v0, -0x1

    iput v0, p0, Lcom/aio/downloader/activity/UninstalledObserverActivity;->mObserverProcessPid:I

    .line 20
    return-void
.end method

.method private getUserSerial()Ljava/lang/String;
    .locals 13

    .prologue
    const/4 v8, 0x0

    .line 69
    const-string v7, "user"

    invoke-virtual {p0, v7}, Lcom/aio/downloader/activity/UninstalledObserverActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    .line 70
    .local v4, "userManager":Ljava/lang/Object;
    if-nez v4, :cond_0

    .line 71
    const-string v7, "UninstalledObserverActivity"

    const-string v9, "userManager not exsit !!!"

    invoke-static {v7, v9}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    move-object v7, v8

    .line 96
    :goto_0
    return-object v7

    .line 76
    :cond_0
    :try_start_0
    const-class v7, Landroid/os/Process;

    .line 77
    const-string v9, "myUserHandle"

    const/4 v10, 0x0

    .line 76
    invoke-virtual {v7, v9, v10}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v3

    .line 79
    .local v3, "myUserHandleMethod":Ljava/lang/reflect/Method;
    const-class v7, Landroid/os/Process;

    const/4 v9, 0x0

    .line 78
    invoke-virtual {v3, v7, v9}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 81
    .local v2, "myUserHandle":Ljava/lang/Object;
    invoke-virtual {v4}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v7

    .line 82
    const-string v9, "getSerialNumberForUser"

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Class;

    const/4 v11, 0x0

    invoke-virtual {v2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v12

    aput-object v12, v10, v11

    .line 81
    invoke-virtual {v7, v9, v10}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    .line 83
    .local v1, "getSerialNumberForUser":Ljava/lang/reflect/Method;
    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v9, 0x0

    .line 84
    aput-object v2, v7, v9

    .line 83
    invoke-virtual {v1, v4, v7}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/Long;

    invoke-virtual {v7}, Ljava/lang/Long;->longValue()J

    move-result-wide v5

    .line 85
    .local v5, "userSerial":J
    invoke-static {v5, v6}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/NoSuchMethodException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_0 .. :try_end_0} :catch_3

    move-result-object v7

    goto :goto_0

    .line 86
    .end local v1    # "getSerialNumberForUser":Ljava/lang/reflect/Method;
    .end local v2    # "myUserHandle":Ljava/lang/Object;
    .end local v3    # "myUserHandleMethod":Ljava/lang/reflect/Method;
    .end local v5    # "userSerial":J
    :catch_0
    move-exception v0

    .line 87
    .local v0, "e":Ljava/lang/NoSuchMethodException;
    const-string v7, "UninstalledObserverActivity"

    const-string v9, ""

    invoke-static {v7, v9, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .end local v0    # "e":Ljava/lang/NoSuchMethodException;
    :goto_1
    move-object v7, v8

    .line 96
    goto :goto_0

    .line 88
    :catch_1
    move-exception v0

    .line 89
    .local v0, "e":Ljava/lang/IllegalArgumentException;
    const-string v7, "UninstalledObserverActivity"

    const-string v9, ""

    invoke-static {v7, v9, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_1

    .line 90
    .end local v0    # "e":Ljava/lang/IllegalArgumentException;
    :catch_2
    move-exception v0

    .line 91
    .local v0, "e":Ljava/lang/IllegalAccessException;
    const-string v7, "UninstalledObserverActivity"

    const-string v9, ""

    invoke-static {v7, v9, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_1

    .line 92
    .end local v0    # "e":Ljava/lang/IllegalAccessException;
    :catch_3
    move-exception v0

    .line 93
    .local v0, "e":Ljava/lang/reflect/InvocationTargetException;
    const-string v7, "UninstalledObserverActivity"

    const-string v9, ""

    invoke-static {v7, v9, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_1
.end method

.method private native init(Ljava/lang/String;)I
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 43
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 47
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x11

    if-ge v0, v1, :cond_0

    .line 48
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/aio/downloader/activity/UninstalledObserverActivity;->init(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/aio/downloader/activity/UninstalledObserverActivity;->mObserverProcessPid:I

    .line 54
    :goto_0
    return-void

    .line 52
    :cond_0
    invoke-direct {p0}, Lcom/aio/downloader/activity/UninstalledObserverActivity;->getUserSerial()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/aio/downloader/activity/UninstalledObserverActivity;->init(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/aio/downloader/activity/UninstalledObserverActivity;->mObserverProcessPid:I

    goto :goto_0
.end method

.method protected onDestroy()V
    .locals 0

    .prologue
    .line 58
    invoke-super {p0}, Landroid/app/Activity;->onDestroy()V

    .line 65
    return-void
.end method

.class public Lco/vine/android/VineApplication;
.super Landroid/app/Application;
.source "VineApplication.java"

# interfaces
.implements Ljava/lang/Thread$UncaughtExceptionHandler;


# static fields
.field private static INSTANCE:Lco/vine/android/VineApplication;


# instance fields
.field private sDefaultHandler:Ljava/lang/Thread$UncaughtExceptionHandler;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 30
    invoke-direct {p0}, Landroid/app/Application;-><init>()V

    return-void
.end method

.method static synthetic access$000()Lco/vine/android/VineApplication;
    .locals 1

    .prologue
    .line 30
    sget-object v0, Lco/vine/android/VineApplication;->INSTANCE:Lco/vine/android/VineApplication;

    return-object v0
.end method

.method public static getInstance()Lco/vine/android/VineApplication;
    .locals 1
    .annotation build Lorg/jetbrains/annotations/Nullable;
    .end annotation

    .prologue
    .line 108
    sget-object v0, Lco/vine/android/VineApplication;->INSTANCE:Lco/vine/android/VineApplication;

    return-object v0
.end method


# virtual methods
.method public getLocale()Ljava/util/Locale;
    .locals 1

    .prologue
    .line 156
    invoke-virtual {p0}, Lco/vine/android/VineApplication;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    iget-object v0, v0, Landroid/content/res/Configuration;->locale:Ljava/util/Locale;

    return-object v0
.end method

.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 6
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .prologue
    .line 113
    invoke-super {p0, p1}, Landroid/app/Application;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 115
    :try_start_0
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isI18nOn()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 116
    invoke-static {p0}, Lco/vine/android/util/Util;->getCustomLocale(Landroid/content/Context;)Ljava/util/Locale;

    move-result-object v1

    .line 117
    .local v1, "locale":Ljava/util/Locale;
    iget-object v2, p1, Landroid/content/res/Configuration;->locale:Ljava/util/Locale;

    if-eqz v2, :cond_0

    .line 118
    const-string v2, "locale"

    iget-object v3, p1, Landroid/content/res/Configuration;->locale:Ljava/util/Locale;

    invoke-virtual {v3}, Ljava/util/Locale;->getDisplayName()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lco/vine/android/util/CrashUtil;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 120
    :cond_0
    if-eqz v1, :cond_1

    iget-object v2, p1, Landroid/content/res/Configuration;->locale:Ljava/util/Locale;

    invoke-virtual {v1, v2}, Ljava/util/Locale;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 121
    new-instance v2, Landroid/os/Handler;

    invoke-direct {v2}, Landroid/os/Handler;-><init>()V

    new-instance v3, Lco/vine/android/VineApplication$1;

    invoke-direct {v3, p0, v1}, Lco/vine/android/VineApplication$1;-><init>(Lco/vine/android/VineApplication;Ljava/util/Locale;)V

    const-wide/16 v4, 0x1f4

    invoke-virtual {v2, v3, v4, v5}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 132
    .end local v1    # "locale":Ljava/util/Locale;
    :cond_1
    :goto_0
    return-void

    .line 129
    :catch_0
    move-exception v0

    .line 130
    .local v0, "e":Ljava/lang/Exception;
    invoke-static {v0}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public onCreate()V
    .locals 13

    .prologue
    const/4 v12, 0x0

    const/4 v10, 0x1

    .line 37
    invoke-super {p0}, Landroid/app/Application;->onCreate()V

    .line 38
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isI18nOn()Z

    move-result v8

    if-eqz v8, :cond_1

    .line 39
    invoke-virtual {p0}, Lco/vine/android/VineApplication;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    .line 40
    .local v6, "resources":Landroid/content/res/Resources;
    if-nez v6, :cond_0

    .line 99
    .end local v6    # "resources":Landroid/content/res/Resources;
    :goto_0
    return-void

    .line 43
    .restart local v6    # "resources":Landroid/content/res/Resources;
    :cond_0
    invoke-static {p0}, Lco/vine/android/util/Util;->forceCustomLocale(Landroid/content/Context;)V

    .line 45
    .end local v6    # "resources":Landroid/content/res/Resources;
    :cond_1
    invoke-static {}, Ljava/lang/Thread;->getDefaultUncaughtExceptionHandler()Ljava/lang/Thread$UncaughtExceptionHandler;

    move-result-object v1

    .line 46
    .local v1, "defaultHandler":Ljava/lang/Thread$UncaughtExceptionHandler;
    if-eq v1, p0, :cond_2

    .line 47
    iput-object v1, p0, Lco/vine/android/VineApplication;->sDefaultHandler:Ljava/lang/Thread$UncaughtExceptionHandler;

    .line 48
    invoke-static {p0}, Ljava/lang/Thread;->setDefaultUncaughtExceptionHandler(Ljava/lang/Thread$UncaughtExceptionHandler;)V

    .line 51
    :cond_2
    invoke-static {p0}, Lco/vine/android/util/CrashUtil;->start(Landroid/content/Context;)V

    .line 54
    :try_start_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 55
    .local v0, "commandLine":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    const-string v8, "logcat"

    invoke-virtual {v0, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 56
    const-string v8, "-c"

    invoke-virtual {v0, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 57
    invoke-static {}, Ljava/lang/Runtime;->getRuntime()Ljava/lang/Runtime;

    move-result-object v9

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v8

    new-array v8, v8, [Ljava/lang/String;

    invoke-virtual {v0, v8}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v8

    check-cast v8, [Ljava/lang/String;

    invoke-virtual {v9, v8}, Ljava/lang/Runtime;->exec([Ljava/lang/String;)Ljava/lang/Process;
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_3

    .line 63
    .end local v0    # "commandLine":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    :goto_1
    :try_start_1
    const-string v8, "RAM Budget"

    invoke-static {p0}, Lco/vine/android/util/SystemUtil;->getMemoryBudgetForLargeMemoryClass(Landroid/content/Context;)I

    move-result v9

    invoke-static {v8, v9}, Lco/vine/android/util/CrashUtil;->set(Ljava/lang/String;I)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 68
    :goto_2
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isExplore()Z

    move-result v8

    if-nez v8, :cond_5

    .line 69
    const-string v8, "Start changing value."

    invoke-static {v8}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 71
    :try_start_2
    const-class v8, Landroid/database/CursorWindow;

    const-string v9, "sCursorWindowSize"

    invoke-virtual {v8, v9}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v3

    .line 72
    .local v3, "field":Ljava/lang/reflect/Field;
    const/4 v8, 0x1

    invoke-virtual {v3, v8}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 73
    const/4 v8, 0x0

    invoke-virtual {v3, v8}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    .line 74
    .local v4, "original":Ljava/lang/Object;
    const-string v8, "Original value: {}."

    invoke-static {v8, v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 75
    const v7, 0x989680

    .line 76
    .local v7, "target":I
    invoke-static {p0}, Lco/vine/android/util/SystemUtil;->getMemoryBudgetForLargeMemoryClass(Landroid/content/Context;)I

    move-result v5

    .line 77
    .local v5, "ratio":I
    if-ne v5, v10, :cond_3

    .line 78
    int-to-double v8, v7

    const-wide v10, 0x3fe999999999999aL    # 0.8

    mul-double/2addr v8, v10

    double-to-int v7, v8

    .line 80
    :cond_3
    const-string v8, "Changing using weighted value: {}"

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-static {v8, v9}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 81
    check-cast v4, Ljava/lang/Integer;

    .end local v4    # "original":Ljava/lang/Object;
    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v8

    if-ge v8, v7, :cond_4

    .line 82
    const/4 v8, 0x0

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v3, v8, v9}, Ljava/lang/reflect/Field;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 84
    :cond_4
    const-string v8, "Sucessfully updated sCursorWindowSize."

    invoke-static {v8}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    .line 89
    .end local v3    # "field":Ljava/lang/reflect/Field;
    .end local v5    # "ratio":I
    .end local v7    # "target":I
    :goto_3
    :try_start_3
    const-class v8, Landroid/database/CursorWindow;

    const-string v9, "sCursorWindowSize"

    invoke-virtual {v8, v9}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v3

    .line 90
    .restart local v3    # "field":Ljava/lang/reflect/Field;
    const/4 v8, 0x1

    invoke-virtual {v3, v8}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 91
    const-string v8, "Verify value: {}."

    const/4 v9, 0x0

    invoke-virtual {v3, v9}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    invoke-static {v8, v9}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_2

    .line 95
    .end local v3    # "field":Ljava/lang/reflect/Field;
    :goto_4
    const-string v8, "End changing value."

    invoke-static {v8}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 98
    :cond_5
    sput-object p0, Lco/vine/android/VineApplication;->INSTANCE:Lco/vine/android/VineApplication;

    goto/16 :goto_0

    .line 64
    :catch_0
    move-exception v2

    .line 65
    .local v2, "e":Ljava/lang/Exception;
    const-string v8, "Failed to get ram budeget."

    invoke-static {v8}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    goto :goto_2

    .line 85
    .end local v2    # "e":Ljava/lang/Exception;
    :catch_1
    move-exception v2

    .line 86
    .restart local v2    # "e":Ljava/lang/Exception;
    const-string v8, "You are too evil."

    new-array v9, v12, [Ljava/lang/Object;

    invoke-static {v2, v8, v9}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_3

    .line 92
    .end local v2    # "e":Ljava/lang/Exception;
    :catch_2
    move-exception v2

    .line 93
    .restart local v2    # "e":Ljava/lang/Exception;
    const-string v8, "You are too evil."

    new-array v9, v12, [Ljava/lang/Object;

    invoke-static {v2, v8, v9}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_4

    .line 58
    .end local v2    # "e":Ljava/lang/Exception;
    :catch_3
    move-exception v8

    goto/16 :goto_1
.end method

.method public onLowMemory()V
    .locals 2

    .prologue
    .line 147
    invoke-super {p0}, Landroid/app/Application;->onLowMemory()V

    .line 148
    const-string v1, "onLowMemory happened."

    invoke-static {v1}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    .line 149
    invoke-static {p0}, Lco/vine/android/client/AppController;->getInstance(Landroid/content/Context;)Lco/vine/android/client/AppController;

    move-result-object v0

    .line 150
    .local v0, "instance":Lco/vine/android/client/AppController;
    if-eqz v0, :cond_0

    .line 151
    invoke-virtual {v0}, Lco/vine/android/client/AppController;->onLowMemory()V

    .line 153
    :cond_0
    return-void
.end method

.method public onTrimMemory(I)V
    .locals 5
    .param p1, "level"    # I
    .annotation build Landroid/annotation/TargetApi;
        value = 0xe
    .end annotation

    .prologue
    .line 137
    invoke-super {p0, p1}, Landroid/app/Application;->onTrimMemory(I)V

    .line 138
    const-string v1, "onTrimMemory happened: {}."

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 139
    invoke-static {p0}, Lco/vine/android/client/AppController;->getInstance(Landroid/content/Context;)Lco/vine/android/client/AppController;

    move-result-object v0

    .line 140
    .local v0, "instance":Lco/vine/android/client/AppController;
    if-eqz v0, :cond_0

    .line 141
    invoke-virtual {v0, p1}, Lco/vine/android/client/AppController;->onTrimMemory(I)V

    .line 143
    :cond_0
    return-void
.end method

.method public uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V
    .locals 3
    .param p1, "thread"    # Ljava/lang/Thread;
    .param p2, "ex"    # Ljava/lang/Throwable;

    .prologue
    .line 161
    if-eqz p2, :cond_0

    .line 162
    invoke-virtual {p2}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v0

    .line 163
    .local v0, "msg":Ljava/lang/String;
    if-eqz v0, :cond_0

    const-string v1, "detachFromGLContext"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 164
    const/16 v1, 0x12c

    invoke-static {p2}, Lco/vine/android/util/CrashUtil;->getDefaultIgnoreCountForLogCollection(Ljava/lang/Throwable;)I

    move-result v2

    invoke-static {v1, v2}, Lco/vine/android/util/CrashUtil;->collectLogs(II)V

    .line 167
    .end local v0    # "msg":Ljava/lang/String;
    :cond_0
    iget-object v1, p0, Lco/vine/android/VineApplication;->sDefaultHandler:Ljava/lang/Thread$UncaughtExceptionHandler;

    if-eqz v1, :cond_1

    .line 168
    iget-object v1, p0, Lco/vine/android/VineApplication;->sDefaultHandler:Ljava/lang/Thread$UncaughtExceptionHandler;

    invoke-interface {v1, p1, p2}, Ljava/lang/Thread$UncaughtExceptionHandler;->uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V

    .line 170
    :cond_1
    return-void
.end method

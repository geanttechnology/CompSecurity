.class public Lco/vine/android/util/SystemUtil;
.super Ljava/lang/Object;
.source "SystemUtil.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/util/SystemUtil$PrefBooleanState;
    }
.end annotation


# static fields
.field private static MEMORY_RATIO:D = 0.0

.field private static final TARGET_KEY_SINGLE_PLAYER:I = 0x1

.field private static final TARGET_KEY_VIEW_SERVER:I = 0x0

.field private static final TARGET_PROCESS_DEFAULT:Ljava/lang/String;

.field private static final TARGET_PROCESS_RECORD:Ljava/lang/String; = ":record"

.field private static final TARGET_SINGLE_PLAYER:Ljava/lang/String; = ":record"

.field private static final TARGET_VIEW_SERVER:Ljava/lang/String;

.field private static mProcessName:Ljava/lang/String;

.field private static mSubProcessName:Ljava/lang/String;

.field private static final mTargetProcessInfo:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 30
    const-wide/high16 v0, -0x4010000000000000L    # -1.0

    sput-wide v0, Lco/vine/android/util/SystemUtil;->MEMORY_RATIO:D

    .line 32
    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    sput-object v0, Lco/vine/android/util/SystemUtil;->mTargetProcessInfo:Landroid/util/SparseArray;

    .line 35
    const/4 v0, 0x0

    sput-object v0, Lco/vine/android/util/SystemUtil;->TARGET_PROCESS_DEFAULT:Ljava/lang/String;

    .line 38
    sget-object v0, Lco/vine/android/util/SystemUtil;->TARGET_PROCESS_DEFAULT:Ljava/lang/String;

    sput-object v0, Lco/vine/android/util/SystemUtil;->TARGET_VIEW_SERVER:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 111
    return-void
.end method

.method public static copyToClip(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "title"    # Ljava/lang/String;
    .param p2, "text"    # Ljava/lang/String;

    .prologue
    .line 164
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0xb

    if-ge v2, v3, :cond_0

    .line 165
    const-string v2, "clipboard"

    invoke-virtual {p0, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/text/ClipboardManager;

    .line 166
    .local v1, "clipboard":Landroid/text/ClipboardManager;
    invoke-virtual {v1, p2}, Landroid/text/ClipboardManager;->setText(Ljava/lang/CharSequence;)V

    .line 172
    .end local v1    # "clipboard":Landroid/text/ClipboardManager;
    :goto_0
    return-void

    .line 168
    :cond_0
    const-string v2, "clipboard"

    invoke-virtual {p0, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/content/ClipboardManager;

    .line 169
    .local v1, "clipboard":Landroid/content/ClipboardManager;
    invoke-static {p1, p2}, Landroid/content/ClipData;->newPlainText(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Landroid/content/ClipData;

    move-result-object v0

    .line 170
    .local v0, "clip":Landroid/content/ClipData;
    invoke-virtual {v1, v0}, Landroid/content/ClipboardManager;->setPrimaryClip(Landroid/content/ClipData;)V

    goto :goto_0
.end method

.method public static getDisplaySize(Landroid/app/Activity;)Landroid/graphics/Point;
    .locals 1
    .param p0, "activity"    # Landroid/app/Activity;

    .prologue
    .line 180
    invoke-virtual {p0}, Landroid/app/Activity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v0

    invoke-interface {v0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    invoke-static {v0}, Lco/vine/android/util/SystemUtil;->getDisplaySize(Landroid/view/Display;)Landroid/graphics/Point;

    move-result-object v0

    return-object v0
.end method

.method public static getDisplaySize(Landroid/content/Context;)Landroid/graphics/Point;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 175
    const-string v0, "window"

    invoke-virtual {p0, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/WindowManager;

    invoke-interface {v0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    invoke-static {v0}, Lco/vine/android/util/SystemUtil;->getDisplaySize(Landroid/view/Display;)Landroid/graphics/Point;

    move-result-object v0

    return-object v0
.end method

.method public static getDisplaySize(Landroid/view/Display;)Landroid/graphics/Point;
    .locals 4
    .param p0, "display"    # Landroid/view/Display;

    .prologue
    .line 151
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0xb

    if-lt v2, v3, :cond_0

    .line 152
    new-instance v0, Landroid/graphics/Point;

    invoke-direct {v0}, Landroid/graphics/Point;-><init>()V

    .line 153
    .local v0, "p":Landroid/graphics/Point;
    invoke-virtual {p0, v0}, Landroid/view/Display;->getSize(Landroid/graphics/Point;)V

    move-object v1, v0

    .line 159
    .end local v0    # "p":Landroid/graphics/Point;
    .local v1, "p":Ljava/lang/Object;
    :goto_0
    return-object v1

    .line 156
    .end local v1    # "p":Ljava/lang/Object;
    :cond_0
    new-instance v0, Landroid/graphics/Point;

    invoke-direct {v0}, Landroid/graphics/Point;-><init>()V

    .line 157
    .restart local v0    # "p":Landroid/graphics/Point;
    invoke-virtual {p0}, Landroid/view/Display;->getWidth()I

    move-result v2

    iput v2, v0, Landroid/graphics/Point;->x:I

    .line 158
    invoke-virtual {p0}, Landroid/view/Display;->getHeight()I

    move-result v2

    iput v2, v0, Landroid/graphics/Point;->y:I

    move-object v1, v0

    .line 159
    .restart local v1    # "p":Ljava/lang/Object;
    goto :goto_0
.end method

.method public static getMemoryBudgetForLargeMemoryClass(Landroid/content/Context;)I
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .annotation build Landroid/annotation/TargetApi;
        value = 0xe
    .end annotation

    .prologue
    .line 56
    const-string v0, "activity"

    invoke-virtual {p0, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/ActivityManager;

    invoke-virtual {v0}, Landroid/app/ActivityManager;->getLargeMemoryClass()I

    move-result v0

    return v0
.end method

.method public static getMemoryRatio(Landroid/content/Context;Z)D
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "isLargeMemoryClassEnabled"    # Z

    .prologue
    .line 64
    sget-wide v1, Lco/vine/android/util/SystemUtil;->MEMORY_RATIO:D

    const-wide/high16 v3, -0x4010000000000000L    # -1.0

    cmpl-double v1, v1, v3

    if-nez v1, :cond_0

    .line 65
    const/4 v0, 0x0

    .line 67
    .local v0, "mem":I
    if-eqz p1, :cond_1

    :try_start_0
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0xe

    if-lt v1, v2, :cond_1

    .line 68
    invoke-static {p0}, Lco/vine/android/util/SystemUtil;->getMemoryBudgetForLargeMemoryClass(Landroid/content/Context;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    .line 75
    :goto_0
    if-nez v0, :cond_2

    const-wide/high16 v1, 0x3ff0000000000000L    # 1.0

    :goto_1
    sput-wide v1, Lco/vine/android/util/SystemUtil;->MEMORY_RATIO:D

    .line 77
    .end local v0    # "mem":I
    :cond_0
    sget-wide v1, Lco/vine/android/util/SystemUtil;->MEMORY_RATIO:D

    return-wide v1

    .line 70
    .restart local v0    # "mem":I
    :cond_1
    :try_start_1
    const-string v1, "activity"

    invoke-virtual {p0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/app/ActivityManager;

    invoke-virtual {v1}, Landroid/app/ActivityManager;->getMemoryClass()I
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    move-result v0

    goto :goto_0

    .line 75
    :cond_2
    int-to-double v1, v0

    const-wide/high16 v3, 0x4060000000000000L    # 128.0

    div-double/2addr v1, v3

    goto :goto_1

    .line 72
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method public static getPathFromAsset(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "fileName"    # Ljava/lang/String;

    .prologue
    .line 103
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "file:///android_asset/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getPathFromResourceRaw(Landroid/content/Context;I)Ljava/lang/String;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "res"    # I

    .prologue
    .line 107
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "android.resource://"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static declared-synchronized initProcessName(Landroid/content/Context;)V
    .locals 8
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 81
    const-class v6, Lco/vine/android/util/SystemUtil;

    monitor-enter v6

    :try_start_0
    sget-object v5, Lco/vine/android/util/SystemUtil;->mProcessName:Ljava/lang/String;

    if-nez v5, :cond_2

    .line 82
    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v5

    sput-object v5, Lco/vine/android/util/SystemUtil;->mProcessName:Ljava/lang/String;

    .line 83
    const-string v5, "activity"

    invoke-virtual {p0, v5}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/ActivityManager;

    .line 84
    .local v0, "am":Landroid/app/ActivityManager;
    invoke-virtual {v0}, Landroid/app/ActivityManager;->getRunningAppProcesses()Ljava/util/List;

    move-result-object v4

    .line 85
    .local v4, "procInfos":Ljava/util/List;, "Ljava/util/List<Landroid/app/ActivityManager$RunningAppProcessInfo;>;"
    if-eqz v4, :cond_1

    .line 86
    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/app/ActivityManager$RunningAppProcessInfo;

    .line 87
    .local v3, "procInfo":Landroid/app/ActivityManager$RunningAppProcessInfo;
    invoke-static {}, Landroid/os/Process;->myPid()I

    move-result v5

    iget v7, v3, Landroid/app/ActivityManager$RunningAppProcessInfo;->pid:I

    if-ne v5, v7, :cond_0

    .line 88
    iget-object v5, v3, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    sput-object v5, Lco/vine/android/util/SystemUtil;->mProcessName:Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 81
    .end local v0    # "am":Landroid/app/ActivityManager;
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v3    # "procInfo":Landroid/app/ActivityManager$RunningAppProcessInfo;
    .end local v4    # "procInfos":Ljava/util/List;, "Ljava/util/List<Landroid/app/ActivityManager$RunningAppProcessInfo;>;"
    :catchall_0
    move-exception v5

    monitor-exit v6

    throw v5

    .line 92
    .restart local v0    # "am":Landroid/app/ActivityManager;
    .restart local v4    # "procInfos":Ljava/util/List;, "Ljava/util/List<Landroid/app/ActivityManager$RunningAppProcessInfo;>;"
    :cond_1
    :try_start_1
    sget-object v5, Lco/vine/android/util/SystemUtil;->mProcessName:Ljava/lang/String;

    const/16 v7, 0x3a

    invoke-virtual {v5, v7}, Ljava/lang/String;->indexOf(I)I

    move-result v2

    .line 93
    .local v2, "index":I
    const/4 v5, -0x1

    if-eq v2, v5, :cond_3

    .line 94
    sget-object v5, Lco/vine/android/util/SystemUtil;->mProcessName:Ljava/lang/String;

    invoke-virtual {v5, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v5

    sput-object v5, Lco/vine/android/util/SystemUtil;->mSubProcessName:Ljava/lang/String;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 99
    .end local v0    # "am":Landroid/app/ActivityManager;
    .end local v2    # "index":I
    .end local v4    # "procInfos":Ljava/util/List;, "Ljava/util/List<Landroid/app/ActivityManager$RunningAppProcessInfo;>;"
    :cond_2
    :goto_1
    monitor-exit v6

    return-void

    .line 96
    .restart local v0    # "am":Landroid/app/ActivityManager;
    .restart local v2    # "index":I
    .restart local v4    # "procInfos":Ljava/util/List;, "Ljava/util/List<Landroid/app/ActivityManager$RunningAppProcessInfo;>;"
    :cond_3
    :try_start_2
    const-string v5, ""

    sput-object v5, Lco/vine/android/util/SystemUtil;->mSubProcessName:Ljava/lang/String;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1
.end method

.method public static isNormalVideoPlayable(Landroid/content/Context;)Lco/vine/android/util/SystemUtil$PrefBooleanState;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 125
    const-string v1, "normalVideoTestPlayable"

    const/4 v2, 0x0

    invoke-virtual {p0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 126
    .local v0, "sharedPref":Landroid/content/SharedPreferences;
    const-string v1, "normalVideoTestPlayable"

    sget-object v2, Lco/vine/android/util/SystemUtil$PrefBooleanState;->UNKNOWN:Lco/vine/android/util/SystemUtil$PrefBooleanState;

    invoke-virtual {v2}, Lco/vine/android/util/SystemUtil$PrefBooleanState;->name()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lco/vine/android/util/SystemUtil$PrefBooleanState;->valueOf(Ljava/lang/String;)Lco/vine/android/util/SystemUtil$PrefBooleanState;

    move-result-object v1

    return-object v1
.end method

.method public static isOnMainThread()Z
    .locals 2

    .prologue
    .line 60
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/Looper;->getThread()Ljava/lang/Thread;

    move-result-object v0

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isSinglePlayerEnabled(Landroid/content/Context;)Z
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v0, 0x1

    .line 51
    sget-boolean v1, Lcom/edisonwang/android/slog/SLog;->sIsAmazon:Z

    if-nez v1, :cond_0

    const-string v1, ":record"

    invoke-static {p0, v0, v1}, Lco/vine/android/util/SystemUtil;->isTargetProcess(Landroid/content/Context;ILjava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static isTargetProcess(Landroid/content/Context;ILjava/lang/String;)Z
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "targetKey"    # I
    .param p2, "targetProcess"    # Ljava/lang/String;

    .prologue
    .line 136
    sget-object v1, Lco/vine/android/util/SystemUtil;->mTargetProcessInfo:Landroid/util/SparseArray;

    const/4 v2, 0x0

    invoke-virtual {v1, p1, v2}, Landroid/util/SparseArray;->get(ILjava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    .line 137
    .local v0, "oldInfo":Ljava/lang/Boolean;
    if-nez v0, :cond_0

    .line 138
    invoke-static {p0}, Lco/vine/android/util/SystemUtil;->initProcessName(Landroid/content/Context;)V

    .line 139
    if-nez p2, :cond_1

    .line 140
    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getAuthority()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lco/vine/android/util/SystemUtil;->mProcessName:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    .line 144
    :goto_0
    sget-object v1, Lco/vine/android/util/SystemUtil;->mTargetProcessInfo:Landroid/util/SparseArray;

    invoke-virtual {v1, p1, v0}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 145
    const-string v1, "Is target process for {} a {}: {}."

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-static {v1, v2, p2, v0}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 147
    :cond_0
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    return v1

    .line 142
    :cond_1
    sget-object v1, Lco/vine/android/util/SystemUtil;->mSubProcessName:Ljava/lang/String;

    invoke-virtual {p2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    goto :goto_0
.end method

.method public static isViewServerEnabled(Landroid/content/Context;)Z
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v0, 0x0

    .line 47
    sget-boolean v1, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v1, :cond_0

    sget-object v1, Lco/vine/android/util/SystemUtil;->TARGET_VIEW_SERVER:Ljava/lang/String;

    invoke-static {p0, v0, v1}, Lco/vine/android/util/SystemUtil;->isTargetProcess(Landroid/content/Context;ILjava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x1

    :cond_0
    return v0
.end method

.method public static quietlyEnsureParentExists(Ljava/io/File;)V
    .locals 4
    .param p0, "f"    # Ljava/io/File;

    .prologue
    .line 185
    :try_start_0
    invoke-virtual {p0}, Ljava/io/File;->exists()Z

    move-result v2

    if-nez v2, :cond_0

    .line 186
    invoke-virtual {p0}, Ljava/io/File;->getParentFile()Ljava/io/File;

    move-result-object v1

    .line 187
    .local v1, "parent":Ljava/io/File;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v2

    if-nez v2, :cond_0

    .line 188
    new-instance v2, Lco/vine/android/VineLoggingException;

    const-string v3, "Invalid folder, but we caught it."

    invoke-direct {v2, v3}, Lco/vine/android/VineLoggingException;-><init>(Ljava/lang/String;)V

    invoke-static {v2}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    .line 189
    invoke-virtual {v1}, Ljava/io/File;->mkdirs()Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 195
    .end local v1    # "parent":Ljava/io/File;
    :cond_0
    :goto_0
    return-void

    .line 192
    :catch_0
    move-exception v0

    .line 193
    .local v0, "e":Ljava/lang/Exception;
    new-instance v2, Lco/vine/android/VineLoggingException;

    const-string v3, "Failed to make parent folder."

    invoke-direct {v2, v3}, Lco/vine/android/VineLoggingException;-><init>(Ljava/lang/String;)V

    invoke-static {v2}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public static setNormalVideoPlayable(Landroid/content/Context;Z)V
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "isPlayable"    # Z

    .prologue
    .line 130
    const-string v0, "normalVideoTestPlayable"

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    const-string v2, "normalVideoTestPlayable"

    if-eqz p1, :cond_0

    sget-object v0, Lco/vine/android/util/SystemUtil$PrefBooleanState;->TRUE:Lco/vine/android/util/SystemUtil$PrefBooleanState;

    :goto_0
    invoke-virtual {v0}, Lco/vine/android/util/SystemUtil$PrefBooleanState;->name()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v1, v2, v0}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 133
    return-void

    .line 130
    :cond_0
    sget-object v0, Lco/vine/android/util/SystemUtil$PrefBooleanState;->FALSE:Lco/vine/android/util/SystemUtil$PrefBooleanState;

    goto :goto_0
.end method

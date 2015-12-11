.class public Lco/vine/android/DebugHomeActivity;
.super Lco/vine/android/BaseControllerActionBarActivity;
.source "DebugHomeActivity.java"


# static fields
.field private static final HIDE_SENSITIVE_DATA:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 48
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isLogsOn()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lco/vine/android/DebugHomeActivity;->HIDE_SENSITIVE_DATA:Z

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 47
    invoke-direct {p0}, Lco/vine/android/BaseControllerActionBarActivity;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lco/vine/android/DebugHomeActivity;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/DebugHomeActivity;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 47
    invoke-direct {p0, p1}, Lco/vine/android/DebugHomeActivity;->handleDebugQuery(Ljava/lang/String;)V

    return-void
.end method

.method private appendMemoryInfo(Ljava/lang/StringBuilder;)V
    .locals 5
    .param p1, "debugInfo"    # Ljava/lang/StringBuilder;
    .annotation build Landroid/annotation/TargetApi;
        value = 0xb
    .end annotation

    .prologue
    .line 263
    const-string v3, "activity"

    invoke-virtual {p0, v3}, Lco/vine/android/DebugHomeActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/ActivityManager;

    .line 264
    .local v0, "activityManager":Landroid/app/ActivityManager;
    new-instance v1, Landroid/app/ActivityManager$MemoryInfo;

    invoke-direct {v1}, Landroid/app/ActivityManager$MemoryInfo;-><init>()V

    .line 265
    .local v1, "info":Landroid/app/ActivityManager$MemoryInfo;
    invoke-virtual {v0, v1}, Landroid/app/ActivityManager;->getMemoryInfo(Landroid/app/ActivityManager$MemoryInfo;)V

    .line 267
    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0xb

    if-lt v3, v4, :cond_0

    invoke-static {}, Lco/vine/android/util/BuildUtil;->isExplore()Z

    move-result v3

    if-nez v3, :cond_0

    .line 268
    invoke-virtual {v0}, Landroid/app/ActivityManager;->getLargeMemoryClass()I

    move-result v2

    .line 272
    .local v2, "mb":I
    :goto_0
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "\nMemory Info: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "MB"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 273
    return-void

    .line 270
    .end local v2    # "mb":I
    :cond_0
    invoke-virtual {v0}, Landroid/app/ActivityManager;->getMemoryClass()I

    move-result v2

    .restart local v2    # "mb":I
    goto :goto_0
.end method

.method private getNumCores()I
    .locals 4

    .prologue
    .line 313
    :try_start_0
    new-instance v0, Ljava/io/File;

    const-string v3, "/sys/devices/system/cpu/"

    invoke-direct {v0, v3}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 315
    .local v0, "dir":Ljava/io/File;
    new-instance v3, Lco/vine/android/DebugHomeActivity$1CpuFilter;

    invoke-direct {v3, p0}, Lco/vine/android/DebugHomeActivity$1CpuFilter;-><init>(Lco/vine/android/DebugHomeActivity;)V

    invoke-virtual {v0, v3}, Ljava/io/File;->listFiles(Ljava/io/FileFilter;)[Ljava/io/File;

    move-result-object v2

    .line 317
    .local v2, "files":[Ljava/io/File;
    array-length v3, v2
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 320
    .end local v0    # "dir":Ljava/io/File;
    .end local v2    # "files":[Ljava/io/File;
    :goto_0
    return v3

    .line 318
    :catch_0
    move-exception v1

    .line 320
    .local v1, "e":Ljava/lang/Exception;
    const/4 v3, 0x1

    goto :goto_0
.end method

.method private handleDebugQuery(Ljava/lang/String;)V
    .locals 3
    .param p1, "query"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x2

    .line 285
    if-eqz p1, :cond_2

    .line 286
    const-string v0, "p:"

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 287
    invoke-virtual {p1, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v0

    invoke-static {p0, v0, v1}, Lco/vine/android/SingleActivity;->start(Landroid/content/Context;J)V

    .line 289
    :cond_0
    const-string v0, "s:"

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 290
    invoke-virtual {p1, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Lco/vine/android/SingleActivity;->start(Landroid/content/Context;Ljava/lang/String;)V

    .line 292
    :cond_1
    const-string v0, "u:"

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 293
    invoke-virtual {p1, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v0

    const-string v2, "Debug Screen"

    invoke-static {p0, v0, v1, v2}, Lco/vine/android/ProfileActivity;->start(Landroid/content/Context;JLjava/lang/String;)V

    .line 296
    :cond_2
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 26
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 52
    const v21, 0x7f030033

    const/16 v22, 0x1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move/from16 v2, v21

    move/from16 v3, v22

    invoke-super {v0, v1, v2, v3}, Lco/vine/android/BaseControllerActionBarActivity;->onCreate(Landroid/os/Bundle;IZ)V

    .line 54
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/DebugHomeActivity;->mAppController:Lco/vine/android/client/AppController;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v19

    .line 56
    .local v19, "session":Lco/vine/android/client/Session;
    const v21, 0x7f0a00ca

    move-object/from16 v0, p0

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Lco/vine/android/DebugHomeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v20

    check-cast v20, Landroid/widget/TextView;

    .line 57
    .local v20, "tv":Landroid/widget/TextView;
    const v21, 0x7f0a00cb

    move-object/from16 v0, p0

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Lco/vine/android/DebugHomeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroid/widget/Button;

    .line 58
    .local v8, "b":Landroid/widget/Button;
    sget-boolean v21, Lco/vine/android/DebugHomeActivity;->HIDE_SENSITIVE_DATA:Z

    if-nez v21, :cond_6

    .line 59
    new-instance v21, Lco/vine/android/DebugHomeActivity$1;

    move-object/from16 v0, v21

    move-object/from16 v1, p0

    move-object/from16 v2, v19

    invoke-direct {v0, v1, v2}, Lco/vine/android/DebugHomeActivity$1;-><init>(Lco/vine/android/DebugHomeActivity;Lco/vine/android/client/Session;)V

    move-object/from16 v0, v21

    invoke-virtual {v8, v0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 69
    :goto_0
    const/16 v21, 0x1

    invoke-static/range {v21 .. v21}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v21

    const/16 v22, 0x1

    invoke-static/range {v22 .. v22}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v22

    const/16 v23, 0x0

    const/16 v24, 0x1

    invoke-static/range {v24 .. v24}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v24

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    move-object/from16 v2, v22

    move-object/from16 v3, v23

    move-object/from16 v4, v24

    invoke-virtual {v0, v1, v2, v3, v4}, Lco/vine/android/DebugHomeActivity;->setupActionBar(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 71
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/DebugHomeActivity;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v5

    .line 72
    .local v5, "ab":Landroid/support/v7/app/ActionBar;
    if-eqz v5, :cond_0

    .line 73
    const-string v21, "Debug Screen"

    move-object/from16 v0, v21

    invoke-virtual {v5, v0}, Landroid/support/v7/app/ActionBar;->setTitle(Ljava/lang/CharSequence;)V

    .line 75
    :cond_0
    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    .line 77
    .local v12, "debugInfo":Ljava/lang/StringBuilder;
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "Device: "

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    sget-object v22, Landroid/os/Build;->DEVICE:Ljava/lang/String;

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 78
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "\nModel: "

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    sget-object v22, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 79
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "\nCPU ABI - ABI2: "

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    sget-object v22, Landroid/os/Build;->CPU_ABI:Ljava/lang/String;

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    const-string v22, " - "

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    sget-object v22, Landroid/os/Build;->CPU_ABI2:Ljava/lang/String;

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 80
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "\nHardware: "

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    sget-object v22, Landroid/os/Build;->HARDWARE:Ljava/lang/String;

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 81
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "\nBrand: "

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    sget-object v22, Landroid/os/Build;->BRAND:Ljava/lang/String;

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 82
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "\nProduct: "

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    sget-object v22, Landroid/os/Build;->PRODUCT:Ljava/lang/String;

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 83
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "\nManufacturer: "

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    sget-object v22, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 84
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "\nBoard: "

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    sget-object v22, Landroid/os/Build;->BOARD:Ljava/lang/String;

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 85
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "\nCores: "

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-direct/range {p0 .. p0}, Lco/vine/android/DebugHomeActivity;->getNumCores()I

    move-result v22

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v21

    const-string v22, "\n"

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 87
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "\nAndroid OS Version: "

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    sget-object v22, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    const-string v22, " "

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    sget v22, Landroid/os/Build$VERSION;->SDK_INT:I

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v21

    sget-object v22, Landroid/os/Build$VERSION;->INCREMENTAL:Ljava/lang/String;

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    const-string v22, " ("

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    sget-object v22, Landroid/os/Build$VERSION;->CODENAME:Ljava/lang/String;

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    const-string v22, ")"

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 91
    const-string v21, "\nApp: "

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 92
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isExplore()Z

    move-result v21

    if-eqz v21, :cond_7

    .line 93
    const-string v21, "Explore\n"

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 100
    :goto_1
    invoke-static/range {p0 .. p0}, Lco/vine/android/provider/VineDatabaseHelper;->getDatabasePath(Landroid/content/Context;)Ljava/io/File;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/io/File;->length()J

    move-result-wide v10

    .line 102
    .local v10, "dbSize":J
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "Main database size: "

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    long-to-double v0, v10

    move-wide/from16 v22, v0

    const-wide v24, 0x412e848000000000L    # 1000000.0

    div-double v22, v22, v24

    invoke-virtual/range {v21 .. v23}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v21

    const-string v22, " MB\n"

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 103
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "Authority: "

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    const-string v22, ""

    invoke-static/range {v22 .. v22}, Lco/vine/android/util/BuildUtil;->getAuthority(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    const-string v22, "\n"

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 105
    move-object/from16 v0, p0

    invoke-direct {v0, v12}, Lco/vine/android/DebugHomeActivity;->appendMemoryInfo(Ljava/lang/StringBuilder;)V

    .line 108
    :try_start_0
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/DebugHomeActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v21

    const-string v22, "co.vine.android"

    const/16 v23, 0x0

    invoke-virtual/range {v21 .. v23}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v16

    .line 109
    .local v16, "pi":Landroid/content/pm/PackageInfo;
    const-string v21, "\nVine for Android Version: "

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    move-object/from16 v0, v16

    iget-object v0, v0, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    move-object/from16 v22, v0

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 110
    const-string v21, "\nVine for Android Build: "

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    move-object/from16 v0, v16

    iget v0, v0, Landroid/content/pm/PackageInfo;->versionCode:I

    move/from16 v22, v0

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 111
    sget-boolean v21, Lco/vine/android/DebugHomeActivity;->HIDE_SENSITIVE_DATA:Z

    if-nez v21, :cond_1

    .line 112
    const-string v21, "\nInstalled: "

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    sget-object v22, Lco/vine/android/util/Util;->DATE_TIME_RFC1123:Ljava/text/SimpleDateFormat;

    new-instance v23, Ljava/util/Date;

    move-object/from16 v0, v16

    iget-wide v0, v0, Landroid/content/pm/PackageInfo;->firstInstallTime:J

    move-wide/from16 v24, v0

    invoke-direct/range {v23 .. v25}, Ljava/util/Date;-><init>(J)V

    invoke-virtual/range {v22 .. v23}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v22

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 113
    const-string v21, "\nUpdated: "

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    sget-object v22, Lco/vine/android/util/Util;->DATE_TIME_RFC1123:Ljava/text/SimpleDateFormat;

    new-instance v23, Ljava/util/Date;

    move-object/from16 v0, v16

    iget-wide v0, v0, Landroid/content/pm/PackageInfo;->lastUpdateTime:J

    move-wide/from16 v24, v0

    invoke-direct/range {v23 .. v25}, Ljava/util/Date;-><init>(J)V

    invoke-virtual/range {v22 .. v23}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v22

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 119
    .end local v16    # "pi":Landroid/content/pm/PackageInfo;
    :cond_1
    :goto_2
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "\nHW Encoding Mode: "

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-static {}, Lco/vine/android/util/BuildUtil;->isIsHwEncodingEnabled()Z

    move-result v22

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v21

    const-string v22, "\n"

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 121
    const-string v21, "\nBuild Revision: b25c2a494c6fbd61ea37490c8f868560b0a75aad\n"

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 122
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "Build Time: "

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    new-instance v22, Ljava/util/Date;

    const-string v23, "1412095829509"

    invoke-static/range {v23 .. v23}, Ljava/lang/Long;->valueOf(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Ljava/lang/Long;->longValue()J

    move-result-wide v23

    invoke-direct/range {v22 .. v24}, Ljava/util/Date;-><init>(J)V

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v21

    const-string v22, "\n"

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 124
    const-string v21, "Build Market: "

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 125
    invoke-static {}, Lco/vine/android/util/BuildUtil;->getMarket()I

    move-result v21

    packed-switch v21, :pswitch_data_0

    .line 139
    const-string v21, "Other\n"

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 144
    :goto_3
    new-instance v15, Landroid/util/DisplayMetrics;

    invoke-direct {v15}, Landroid/util/DisplayMetrics;-><init>()V

    .line 145
    .local v15, "metrics":Landroid/util/DisplayMetrics;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/DebugHomeActivity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v21

    invoke-interface/range {v21 .. v21}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v0, v15}, Landroid/view/Display;->getMetrics(Landroid/util/DisplayMetrics;)V

    .line 147
    const-string v21, "\nScreen Density: "

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 148
    iget v0, v15, Landroid/util/DisplayMetrics;->densityDpi:I

    move/from16 v21, v0

    sparse-switch v21, :sswitch_data_0

    .line 174
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, " UNKNOWN: "

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    iget v0, v15, Landroid/util/DisplayMetrics;->densityDpi:I

    move/from16 v22, v0

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 179
    :goto_4
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "\nScreen Size: "

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    iget v0, v15, Landroid/util/DisplayMetrics;->widthPixels:I

    move/from16 v22, v0

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v21

    const-string v22, "x"

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    iget v0, v15, Landroid/util/DisplayMetrics;->heightPixels:I

    move/from16 v22, v0

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 181
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "\nNormal Video Playable: "

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-static/range {p0 .. p0}, Lco/vine/android/util/SystemUtil;->isNormalVideoPlayable(Landroid/content/Context;)Lco/vine/android/util/SystemUtil$PrefBooleanState;

    move-result-object v22

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v21

    const-string v22, " account: "

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-static/range {p0 .. p0}, Lco/vine/android/client/VineAccountHelper;->isNormalVideoPlayable(Landroid/content/Context;)Lco/vine/android/util/SystemUtil$PrefBooleanState;

    move-result-object v22

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 183
    const-string v21, "\nLogged in user: "

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v19 .. v19}, Lco/vine/android/client/Session;->getLoginEmail()Ljava/lang/String;

    move-result-object v22

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 184
    sget-boolean v21, Lco/vine/android/DebugHomeActivity;->HIDE_SENSITIVE_DATA:Z

    if-nez v21, :cond_2

    .line 185
    const-string v21, "\nLogged in user id: "

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v19 .. v19}, Lco/vine/android/client/Session;->getUserId()J

    move-result-wide v22

    invoke-virtual/range {v21 .. v23}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    .line 186
    const-string v21, "\nLogged in session key: "

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v19 .. v19}, Lco/vine/android/client/Session;->getSessionKey()Ljava/lang/String;

    move-result-object v22

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 188
    :cond_2
    const-string v21, "\nLogged in name: "

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v19 .. v19}, Lco/vine/android/client/Session;->getName()Ljava/lang/String;

    move-result-object v22

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 189
    sget-boolean v21, Lco/vine/android/DebugHomeActivity;->HIDE_SENSITIVE_DATA:Z

    if-nez v21, :cond_3

    .line 190
    const-string v21, "\nLogged in avatar: "

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v19 .. v19}, Lco/vine/android/client/Session;->getAvatarUrl()Ljava/lang/String;

    move-result-object v22

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 193
    :cond_3
    invoke-static/range {p0 .. p0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v7

    .line 194
    .local v7, "am":Landroid/accounts/AccountManager;
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/DebugHomeActivity;->mAppController:Lco/vine/android/client/AppController;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Lco/vine/android/client/Session;->getLoginEmail()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-static {v0, v1}, Lco/vine/android/client/VineAccountHelper;->getAccount(Landroid/content/Context;Ljava/lang/String;)Landroid/accounts/Account;

    move-result-object v6

    .line 196
    .local v6, "acc":Landroid/accounts/Account;
    const-string v21, "account_login_type"

    move-object/from16 v0, v21

    invoke-virtual {v7, v6, v0}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v21

    invoke-static/range {v21 .. v21}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v21

    const/16 v22, 0x2

    move/from16 v0, v21

    move/from16 v1, v22

    if-ne v0, v1, :cond_9

    .line 198
    const-string v21, "\nLogged in with Twitter."

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 202
    :goto_5
    invoke-static {v7, v6}, Lco/vine/android/client/VineAccountHelper;->getTwitterToken(Landroid/accounts/AccountManager;Landroid/accounts/Account;)Ljava/lang/String;

    move-result-object v21

    invoke-static/range {v21 .. v21}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v21

    if-eqz v21, :cond_a

    .line 203
    const-string v21, "\nNot connected to Twitter."

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 208
    :goto_6
    sget-boolean v21, Lco/vine/android/DebugHomeActivity;->HIDE_SENSITIVE_DATA:Z

    if-nez v21, :cond_4

    .line 209
    invoke-static/range {p0 .. p0}, Lco/vine/android/service/GCMRegistrationService;->getGCMPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v17

    .line 210
    .local v17, "prefs":Landroid/content/SharedPreferences;
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "\n\nGCM: "

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    const-string v22, "registrationId"

    const-string v23, "Not registered"

    move-object/from16 v0, v17

    move-object/from16 v1, v22

    move-object/from16 v2, v23

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 211
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "\nGCM sent to vinepi: "

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    const-string v22, "registrationIdSent"

    const/16 v23, 0x0

    move-object/from16 v0, v17

    move-object/from16 v1, v22

    move/from16 v2, v23

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v22

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 212
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "\n\nAPI: "

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-static/range {p0 .. p0}, Lco/vine/android/client/VineAPI;->getInstance(Landroid/content/Context;)Lco/vine/android/client/VineAPI;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Lco/vine/android/client/VineAPI;->getBaseUrl()Ljava/lang/String;

    move-result-object v22

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 213
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "\nAmazon: "

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    const v22, 0x7f0e004b

    move-object/from16 v0, p0

    move/from16 v1, v22

    invoke-virtual {v0, v1}, Lco/vine/android/DebugHomeActivity;->getString(I)Ljava/lang/String;

    move-result-object v22

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 214
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "\nAmazon Bucket: "

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-static/range {p0 .. p0}, Lco/vine/android/util/BuildUtil;->getAmazonBucket(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v22

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 215
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "\nTwitter: "

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    const v22, 0x7f0e0251

    move-object/from16 v0, p0

    move/from16 v1, v22

    invoke-virtual {v0, v1}, Lco/vine/android/DebugHomeActivity;->getString(I)Ljava/lang/String;

    move-result-object v22

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 216
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "\nRTC: "

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-static/range {p0 .. p0}, Lco/vine/android/client/VineAPI;->getInstance(Landroid/content/Context;)Lco/vine/android/client/VineAPI;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Lco/vine/android/client/VineAPI;->getRtcUrl()Ljava/lang/String;

    move-result-object v22

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 217
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "\nMedia: "

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-static/range {p0 .. p0}, Lco/vine/android/client/VineAPI;->getInstance(Landroid/content/Context;)Lco/vine/android/client/VineAPI;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Lco/vine/android/client/VineAPI;->getMediaUrl()Ljava/lang/String;

    move-result-object v22

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 218
    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "\nExplore: "

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-static/range {p0 .. p0}, Lco/vine/android/client/VineAPI;->getInstance(Landroid/content/Context;)Lco/vine/android/client/VineAPI;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Lco/vine/android/client/VineAPI;->getExploreUrl()Ljava/lang/String;

    move-result-object v22

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 221
    .end local v17    # "prefs":Landroid/content/SharedPreferences;
    :cond_4
    invoke-static {}, Lco/vine/android/AppImpl;->getInstance()Lco/vine/android/AppImpl;

    move-result-object v21

    sget-boolean v22, Lco/vine/android/DebugHomeActivity;->HIDE_SENSITIVE_DATA:Z

    move-object/from16 v0, v21

    move-object/from16 v1, p0

    move/from16 v2, v22

    invoke-virtual {v0, v1, v12, v2}, Lco/vine/android/AppImpl;->appendDebugInfo(Landroid/content/Context;Ljava/lang/StringBuilder;Z)V

    .line 223
    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    invoke-virtual/range {v20 .. v21}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 225
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isLogsOn()Z

    move-result v21

    if-eqz v21, :cond_5

    .line 226
    new-instance v9, Landroid/widget/Button;

    move-object/from16 v0, p0

    invoke-direct {v9, v0}, Landroid/widget/Button;-><init>(Landroid/content/Context;)V

    .line 227
    .local v9, "button":Landroid/widget/Button;
    const-string v21, "Send Logs"

    move-object/from16 v0, v21

    invoke-virtual {v9, v0}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 228
    new-instance v21, Lco/vine/android/DebugHomeActivity$2;

    move-object/from16 v0, v21

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v12}, Lco/vine/android/DebugHomeActivity$2;-><init>(Lco/vine/android/DebugHomeActivity;Ljava/lang/StringBuilder;)V

    move-object/from16 v0, v21

    invoke-virtual {v9, v0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 244
    invoke-virtual/range {v20 .. v20}, Landroid/widget/TextView;->getParent()Landroid/view/ViewParent;

    move-result-object v21

    check-cast v21, Landroid/view/ViewGroup;

    move-object/from16 v0, v21

    invoke-virtual {v0, v9}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 247
    .end local v9    # "button":Landroid/widget/Button;
    :cond_5
    sget-boolean v21, Lco/vine/android/DebugHomeActivity;->HIDE_SENSITIVE_DATA:Z

    if-nez v21, :cond_b

    .line 248
    const v21, 0x7f0a00cd

    move-object/from16 v0, p0

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Lco/vine/android/DebugHomeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v18

    check-cast v18, Landroid/widget/EditText;

    .line 249
    .local v18, "query":Landroid/widget/EditText;
    const v21, 0x7f0a00ce

    move-object/from16 v0, p0

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Lco/vine/android/DebugHomeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v21

    new-instance v22, Lco/vine/android/DebugHomeActivity$3;

    move-object/from16 v0, v22

    move-object/from16 v1, p0

    move-object/from16 v2, v18

    invoke-direct {v0, v1, v2}, Lco/vine/android/DebugHomeActivity$3;-><init>(Lco/vine/android/DebugHomeActivity;Landroid/widget/EditText;)V

    invoke-virtual/range {v21 .. v22}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 259
    .end local v18    # "query":Landroid/widget/EditText;
    :goto_7
    return-void

    .line 66
    .end local v5    # "ab":Landroid/support/v7/app/ActionBar;
    .end local v6    # "acc":Landroid/accounts/Account;
    .end local v7    # "am":Landroid/accounts/AccountManager;
    .end local v10    # "dbSize":J
    .end local v12    # "debugInfo":Ljava/lang/StringBuilder;
    .end local v15    # "metrics":Landroid/util/DisplayMetrics;
    :cond_6
    const/16 v21, 0x8

    move/from16 v0, v21

    invoke-virtual {v8, v0}, Landroid/widget/Button;->setVisibility(I)V

    goto/16 :goto_0

    .line 94
    .restart local v5    # "ab":Landroid/support/v7/app/ActionBar;
    .restart local v12    # "debugInfo":Ljava/lang/StringBuilder;
    :cond_7
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isRegular()Z

    move-result v21

    if-eqz v21, :cond_8

    .line 95
    const-string v21, "Main\n"

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto/16 :goto_1

    .line 97
    :cond_8
    const-string v21, "Other\n"

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto/16 :goto_1

    .line 115
    .restart local v10    # "dbSize":J
    :catch_0
    move-exception v14

    .line 116
    .local v14, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    const-string v21, "Cannot parse some info."

    move-object/from16 v0, v21

    invoke-static {v0, v14}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_2

    .line 127
    .end local v14    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :pswitch_0
    const-string v21, "Google\n"

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto/16 :goto_3

    .line 131
    :pswitch_1
    const-string v21, "Amazon\n"

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto/16 :goto_3

    .line 135
    :pswitch_2
    const-string v21, "Astar\n"

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto/16 :goto_3

    .line 150
    .restart local v15    # "metrics":Landroid/util/DisplayMetrics;
    :sswitch_0
    const-string v21, " LDPI"

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto/16 :goto_4

    .line 154
    :sswitch_1
    const-string v21, " MDPI"

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto/16 :goto_4

    .line 158
    :sswitch_2
    const-string v21, " HDPI"

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto/16 :goto_4

    .line 162
    :sswitch_3
    const-string v21, " TVDPI"

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto/16 :goto_4

    .line 166
    :sswitch_4
    const-string v21, " XHDPI"

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto/16 :goto_4

    .line 170
    :sswitch_5
    const-string v21, " XXHDPI"

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto/16 :goto_4

    .line 200
    .restart local v6    # "acc":Landroid/accounts/Account;
    .restart local v7    # "am":Landroid/accounts/AccountManager;
    :cond_9
    const-string v21, "\nNot logged in with Twitter."

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto/16 :goto_5

    .line 205
    :cond_a
    const-string v21, "\nConnected to Twitter."

    move-object/from16 v0, v21

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto/16 :goto_6

    .line 256
    :cond_b
    const v21, 0x7f0a00cc

    move-object/from16 v0, p0

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Lco/vine/android/DebugHomeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v13

    check-cast v13, Landroid/widget/LinearLayout;

    .line 257
    .local v13, "debugQueryParent":Landroid/widget/LinearLayout;
    const/16 v21, 0x8

    move/from16 v0, v21

    invoke-virtual {v13, v0}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto/16 :goto_7

    .line 125
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch

    .line 148
    :sswitch_data_0
    .sparse-switch
        0x78 -> :sswitch_0
        0xa0 -> :sswitch_1
        0xd5 -> :sswitch_3
        0xf0 -> :sswitch_2
        0x140 -> :sswitch_4
        0x1e0 -> :sswitch_5
    .end sparse-switch
.end method

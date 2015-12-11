.class public Lcom/wjj/manager/BoostRuningAppManager;
.super Ljava/lang/Object;
.source "BoostRuningAppManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/wjj/manager/BoostRuningAppManager$BoostRuningAppManagerListener;
    }
.end annotation


# instance fields
.field private aManager:Landroid/app/ActivityManager;

.field private mcontext:Landroid/content/Context;

.field private pManager:Landroid/content/pm/PackageManager;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    const-string v0, "activity"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/ActivityManager;

    iput-object v0, p0, Lcom/wjj/manager/BoostRuningAppManager;->aManager:Landroid/app/ActivityManager;

    .line 25
    invoke-virtual {p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    iput-object v0, p0, Lcom/wjj/manager/BoostRuningAppManager;->pManager:Landroid/content/pm/PackageManager;

    .line 26
    iput-object p1, p0, Lcom/wjj/manager/BoostRuningAppManager;->mcontext:Landroid/content/Context;

    .line 27
    return-void
.end method


# virtual methods
.method public Killprogress(Ljava/lang/String;)V
    .locals 1
    .param p1, "packName"    # Ljava/lang/String;

    .prologue
    .line 66
    iget-object v0, p0, Lcom/wjj/manager/BoostRuningAppManager;->aManager:Landroid/app/ActivityManager;

    invoke-virtual {v0, p1}, Landroid/app/ActivityManager;->killBackgroundProcesses(Ljava/lang/String;)V

    .line 67
    return-void
.end method

.method public getRuningUserApp(Lcom/wjj/manager/BoostRuningAppManager$BoostRuningAppManagerListener;)I
    .locals 13
    .param p1, "listener"    # Lcom/wjj/manager/BoostRuningAppManager$BoostRuningAppManagerListener;

    .prologue
    const/4 v12, 0x1

    .line 32
    iget-object v8, p0, Lcom/wjj/manager/BoostRuningAppManager;->mcontext:Landroid/content/Context;

    invoke-virtual {v8}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v6

    .line 34
    .local v6, "pm":Landroid/content/pm/PackageManager;
    const/16 v8, 0x2000

    invoke-virtual {v6, v8}, Landroid/content/pm/PackageManager;->getInstalledApplications(I)Ljava/util/List;

    move-result-object v0

    .line 36
    .local v0, "ai":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ApplicationInfo;>;"
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v8

    if-lt v2, v8, :cond_0

    .line 61
    return v12

    .line 37
    :cond_0
    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/content/pm/ApplicationInfo;

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/content/pm/ApplicationInfo;

    iget v8, v8, Landroid/content/pm/ApplicationInfo;->flags:I

    and-int/lit8 v8, v8, 0x1

    if-nez v8, :cond_1

    .line 39
    :try_start_0
    iget-object v9, p0, Lcom/wjj/manager/BoostRuningAppManager;->pManager:Landroid/content/pm/PackageManager;

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/content/pm/ApplicationInfo;

    iget-object v8, v8, Landroid/content/pm/ApplicationInfo;->processName:Ljava/lang/String;

    const/4 v10, 0x0

    invoke-virtual {v9, v8, v10}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v1

    .line 40
    .local v1, "appinfo":Landroid/content/pm/ApplicationInfo;
    sget-object v8, Ljava/lang/System;->out:Ljava/io/PrintStream;

    invoke-virtual {v8}, Ljava/io/PrintStream;->println()V

    .line 41
    new-instance v3, Lcom/wjj/eneity/RuningApp;

    invoke-direct {v3}, Lcom/wjj/eneity/RuningApp;-><init>()V

    .line 43
    .local v3, "item":Lcom/wjj/eneity/RuningApp;
    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/content/pm/ApplicationInfo;

    iget-object v8, v8, Landroid/content/pm/ApplicationInfo;->processName:Ljava/lang/String;

    iput-object v8, v3, Lcom/wjj/eneity/RuningApp;->packname:Ljava/lang/String;

    .line 44
    const-string v9, "fff"

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/content/pm/ApplicationInfo;

    iget-object v8, v8, Landroid/content/pm/ApplicationInfo;->processName:Ljava/lang/String;

    invoke-static {v9, v8}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 46
    const/4 v8, 0x1

    new-array v5, v8, [I

    const/4 v9, 0x0

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/content/pm/ApplicationInfo;

    iget v8, v8, Landroid/content/pm/ApplicationInfo;->uid:I

    aput v8, v5, v9

    .line 47
    .local v5, "pids":[I
    iget-object v8, p0, Lcom/wjj/manager/BoostRuningAppManager;->aManager:Landroid/app/ActivityManager;

    invoke-virtual {v8, v5}, Landroid/app/ActivityManager;->getProcessMemoryInfo([I)[Landroid/os/Debug$MemoryInfo;

    move-result-object v8

    const/4 v9, 0x0

    aget-object v4, v8, v9

    .line 48
    .local v4, "memory":Landroid/os/Debug$MemoryInfo;
    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v8

    const-wide v10, 0x40b1940000000000L    # 4500.0

    mul-double/2addr v8, v10

    const-wide v10, 0x4097700000000000L    # 1500.0

    add-double/2addr v8, v10

    double-to-int v7, v8

    .line 49
    .local v7, "wycneicui":I
    mul-int/lit16 v8, v7, 0x400

    int-to-long v8, v8

    iput-wide v8, v3, Lcom/wjj/eneity/RuningApp;->memory:J

    .line 51
    iget-object v8, p0, Lcom/wjj/manager/BoostRuningAppManager;->pManager:Landroid/content/pm/PackageManager;

    iget-object v9, v3, Lcom/wjj/eneity/RuningApp;->packname:Ljava/lang/String;

    invoke-virtual {v8, v9}, Landroid/content/pm/PackageManager;->getApplicationIcon(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;

    move-result-object v8

    iput-object v8, v3, Lcom/wjj/eneity/RuningApp;->icon:Landroid/graphics/drawable/Drawable;

    .line 53
    iget-object v8, p0, Lcom/wjj/manager/BoostRuningAppManager;->pManager:Landroid/content/pm/PackageManager;

    invoke-virtual {v8, v1}, Landroid/content/pm/PackageManager;->getApplicationLabel(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;

    move-result-object v8

    invoke-interface {v8}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v8

    iput-object v8, v3, Lcom/wjj/eneity/RuningApp;->runingsoftname:Ljava/lang/String;

    .line 54
    const/4 v8, 0x0

    iput-boolean v8, v3, Lcom/wjj/eneity/RuningApp;->isSystem:Z

    .line 55
    const/4 v8, 0x1

    iput-boolean v8, v3, Lcom/wjj/eneity/RuningApp;->ischecked:Z

    .line 56
    iget-wide v8, v3, Lcom/wjj/eneity/RuningApp;->memory:J

    invoke-interface {p1, v8, v9, v3}, Lcom/wjj/manager/BoostRuningAppManager$BoostRuningAppManagerListener;->DownCountSize(JLcom/wjj/eneity/RuningApp;)V
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 36
    .end local v1    # "appinfo":Landroid/content/pm/ApplicationInfo;
    .end local v3    # "item":Lcom/wjj/eneity/RuningApp;
    .end local v4    # "memory":Landroid/os/Debug$MemoryInfo;
    .end local v5    # "pids":[I
    .end local v7    # "wycneicui":I
    :cond_1
    :goto_1
    add-int/lit8 v2, v2, 0x1

    goto/16 :goto_0

    .line 57
    :catch_0
    move-exception v8

    goto :goto_1
.end method

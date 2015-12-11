.class public Lcom/wjj/manager/RuningAppManager;
.super Ljava/lang/Object;
.source "RuningAppManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/wjj/manager/RuningAppManager$RuningAppManagerListener;
    }
.end annotation


# instance fields
.field private aManager:Landroid/app/ActivityManager;

.field private data:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/wjj/eneity/RuningApp;",
            ">;"
        }
    .end annotation
.end field

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

    iput-object v0, p0, Lcom/wjj/manager/RuningAppManager;->aManager:Landroid/app/ActivityManager;

    .line 25
    invoke-virtual {p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    iput-object v0, p0, Lcom/wjj/manager/RuningAppManager;->pManager:Landroid/content/pm/PackageManager;

    .line 26
    iput-object p1, p0, Lcom/wjj/manager/RuningAppManager;->mcontext:Landroid/content/Context;

    .line 27
    return-void
.end method


# virtual methods
.method public Killprogress(Ljava/lang/String;)V
    .locals 1
    .param p1, "packName"    # Ljava/lang/String;

    .prologue
    .line 104
    iget-object v0, p0, Lcom/wjj/manager/RuningAppManager;->aManager:Landroid/app/ActivityManager;

    invoke-virtual {v0, p1}, Landroid/app/ActivityManager;->killBackgroundProcesses(Ljava/lang/String;)V

    .line 105
    return-void
.end method

.method public getRuningSystemApp()Ljava/util/List;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/wjj/eneity/RuningApp;",
            ">;"
        }
    .end annotation

    .prologue
    .line 71
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    iput-object v6, p0, Lcom/wjj/manager/RuningAppManager;->data:Ljava/util/List;

    .line 74
    iget-object v6, p0, Lcom/wjj/manager/RuningAppManager;->aManager:Landroid/app/ActivityManager;

    invoke-virtual {v6}, Landroid/app/ActivityManager;->getRunningAppProcesses()Ljava/util/List;

    move-result-object v3

    .line 75
    .local v3, "list":Ljava/util/List;, "Ljava/util/List<Landroid/app/ActivityManager$RunningAppProcessInfo;>;"
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :cond_0
    :goto_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-nez v7, :cond_1

    .line 100
    iget-object v6, p0, Lcom/wjj/manager/RuningAppManager;->data:Ljava/util/List;

    return-object v6

    .line 75
    :cond_1
    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/app/ActivityManager$RunningAppProcessInfo;

    .line 76
    .local v1, "info":Landroid/app/ActivityManager$RunningAppProcessInfo;
    iget v7, v1, Landroid/app/ActivityManager$RunningAppProcessInfo;->importance:I

    const/16 v8, 0x12c

    if-lt v7, v8, :cond_0

    .line 78
    :try_start_0
    iget-object v7, p0, Lcom/wjj/manager/RuningAppManager;->pManager:Landroid/content/pm/PackageManager;

    iget-object v8, v1, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    const/4 v9, 0x0

    invoke-virtual {v7, v8, v9}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v0

    .line 79
    .local v0, "appinfo":Landroid/content/pm/ApplicationInfo;
    sget-object v7, Ljava/lang/System;->out:Ljava/io/PrintStream;

    invoke-virtual {v7}, Ljava/io/PrintStream;->println()V

    .line 80
    iget v7, v0, Landroid/content/pm/ApplicationInfo;->flags:I

    and-int/lit8 v7, v7, 0x1

    if-eqz v7, :cond_0

    .line 81
    new-instance v2, Lcom/wjj/eneity/RuningApp;

    invoke-direct {v2}, Lcom/wjj/eneity/RuningApp;-><init>()V

    .line 83
    .local v2, "item":Lcom/wjj/eneity/RuningApp;
    iget-object v7, v1, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    iput-object v7, v2, Lcom/wjj/eneity/RuningApp;->packname:Ljava/lang/String;

    .line 85
    const/4 v7, 0x1

    new-array v5, v7, [I

    const/4 v7, 0x0

    iget v8, v1, Landroid/app/ActivityManager$RunningAppProcessInfo;->pid:I

    aput v8, v5, v7

    .line 86
    .local v5, "pids":[I
    iget-object v7, p0, Lcom/wjj/manager/RuningAppManager;->aManager:Landroid/app/ActivityManager;

    invoke-virtual {v7, v5}, Landroid/app/ActivityManager;->getProcessMemoryInfo([I)[Landroid/os/Debug$MemoryInfo;

    move-result-object v7

    const/4 v8, 0x0

    aget-object v4, v7, v8

    .line 87
    .local v4, "memory":Landroid/os/Debug$MemoryInfo;
    invoke-virtual {v4}, Landroid/os/Debug$MemoryInfo;->getTotalPrivateDirty()I

    move-result v7

    mul-int/lit16 v7, v7, 0x400

    int-to-long v7, v7

    iput-wide v7, v2, Lcom/wjj/eneity/RuningApp;->memory:J

    .line 89
    iget-object v7, p0, Lcom/wjj/manager/RuningAppManager;->pManager:Landroid/content/pm/PackageManager;

    iget-object v8, v2, Lcom/wjj/eneity/RuningApp;->packname:Ljava/lang/String;

    invoke-virtual {v7, v8}, Landroid/content/pm/PackageManager;->getApplicationIcon(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;

    move-result-object v7

    iput-object v7, v2, Lcom/wjj/eneity/RuningApp;->icon:Landroid/graphics/drawable/Drawable;

    .line 91
    iget-object v7, p0, Lcom/wjj/manager/RuningAppManager;->pManager:Landroid/content/pm/PackageManager;

    invoke-virtual {v7, v0}, Landroid/content/pm/PackageManager;->getApplicationLabel(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;

    move-result-object v7

    invoke-interface {v7}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v7

    iput-object v7, v2, Lcom/wjj/eneity/RuningApp;->runingsoftname:Ljava/lang/String;

    .line 92
    const/4 v7, 0x1

    iput-boolean v7, v2, Lcom/wjj/eneity/RuningApp;->ischecked:Z

    .line 93
    iget-object v7, p0, Lcom/wjj/manager/RuningAppManager;->data:Ljava/util/List;

    invoke-interface {v7, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 96
    .end local v0    # "appinfo":Landroid/content/pm/ApplicationInfo;
    .end local v2    # "item":Lcom/wjj/eneity/RuningApp;
    .end local v4    # "memory":Landroid/os/Debug$MemoryInfo;
    .end local v5    # "pids":[I
    :catch_0
    move-exception v7

    goto :goto_0
.end method

.method public getRuningUserApp(Lcom/wjj/manager/RuningAppManager$RuningAppManagerListener;)Ljava/util/List;
    .locals 12
    .param p1, "listener"    # Lcom/wjj/manager/RuningAppManager$RuningAppManagerListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/wjj/manager/RuningAppManager$RuningAppManagerListener;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/wjj/eneity/RuningApp;",
            ">;"
        }
    .end annotation

    .prologue
    .line 30
    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    iput-object v8, p0, Lcom/wjj/manager/RuningAppManager;->data:Ljava/util/List;

    .line 34
    iget-object v8, p0, Lcom/wjj/manager/RuningAppManager;->mcontext:Landroid/content/Context;

    invoke-virtual {v8}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v6

    .line 36
    .local v6, "pm":Landroid/content/pm/PackageManager;
    const/16 v8, 0x2000

    invoke-virtual {v6, v8}, Landroid/content/pm/PackageManager;->getInstalledApplications(I)Ljava/util/List;

    move-result-object v0

    .line 37
    .local v0, "ai":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ApplicationInfo;>;"
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v8

    if-lt v2, v8, :cond_0

    .line 63
    iget-object v8, p0, Lcom/wjj/manager/RuningAppManager;->data:Ljava/util/List;

    return-object v8

    .line 38
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

    .line 40
    :try_start_0
    iget-object v9, p0, Lcom/wjj/manager/RuningAppManager;->pManager:Landroid/content/pm/PackageManager;

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/content/pm/ApplicationInfo;

    iget-object v8, v8, Landroid/content/pm/ApplicationInfo;->processName:Ljava/lang/String;

    const/4 v10, 0x0

    invoke-virtual {v9, v8, v10}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v1

    .line 41
    .local v1, "appinfo":Landroid/content/pm/ApplicationInfo;
    sget-object v8, Ljava/lang/System;->out:Ljava/io/PrintStream;

    invoke-virtual {v8}, Ljava/io/PrintStream;->println()V

    .line 42
    new-instance v3, Lcom/wjj/eneity/RuningApp;

    invoke-direct {v3}, Lcom/wjj/eneity/RuningApp;-><init>()V

    .line 44
    .local v3, "item":Lcom/wjj/eneity/RuningApp;
    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/content/pm/ApplicationInfo;

    iget-object v8, v8, Landroid/content/pm/ApplicationInfo;->processName:Ljava/lang/String;

    iput-object v8, v3, Lcom/wjj/eneity/RuningApp;->packname:Ljava/lang/String;

    .line 45
    const-string v9, "fff"

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/content/pm/ApplicationInfo;

    iget-object v8, v8, Landroid/content/pm/ApplicationInfo;->processName:Ljava/lang/String;

    invoke-static {v9, v8}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 47
    const/4 v8, 0x1

    new-array v5, v8, [I

    const/4 v9, 0x0

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/content/pm/ApplicationInfo;

    iget v8, v8, Landroid/content/pm/ApplicationInfo;->uid:I

    aput v8, v5, v9

    .line 48
    .local v5, "pids":[I
    iget-object v8, p0, Lcom/wjj/manager/RuningAppManager;->aManager:Landroid/app/ActivityManager;

    invoke-virtual {v8, v5}, Landroid/app/ActivityManager;->getProcessMemoryInfo([I)[Landroid/os/Debug$MemoryInfo;

    move-result-object v8

    const/4 v9, 0x0

    aget-object v4, v8, v9

    .line 49
    .local v4, "memory":Landroid/os/Debug$MemoryInfo;
    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v8

    const-wide v10, 0x40b1940000000000L    # 4500.0

    mul-double/2addr v8, v10

    const-wide v10, 0x4097700000000000L    # 1500.0

    add-double/2addr v8, v10

    double-to-int v7, v8

    .line 50
    .local v7, "wycneicui":I
    mul-int/lit16 v8, v7, 0x400

    int-to-long v8, v8

    iput-wide v8, v3, Lcom/wjj/eneity/RuningApp;->memory:J

    .line 52
    iget-object v8, p0, Lcom/wjj/manager/RuningAppManager;->pManager:Landroid/content/pm/PackageManager;

    iget-object v9, v3, Lcom/wjj/eneity/RuningApp;->packname:Ljava/lang/String;

    invoke-virtual {v8, v9}, Landroid/content/pm/PackageManager;->getApplicationIcon(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;

    move-result-object v8

    iput-object v8, v3, Lcom/wjj/eneity/RuningApp;->icon:Landroid/graphics/drawable/Drawable;

    .line 54
    iget-object v8, p0, Lcom/wjj/manager/RuningAppManager;->pManager:Landroid/content/pm/PackageManager;

    invoke-virtual {v8, v1}, Landroid/content/pm/PackageManager;->getApplicationLabel(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;

    move-result-object v8

    invoke-interface {v8}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v8

    iput-object v8, v3, Lcom/wjj/eneity/RuningApp;->runingsoftname:Ljava/lang/String;

    .line 55
    const/4 v8, 0x0

    iput-boolean v8, v3, Lcom/wjj/eneity/RuningApp;->isSystem:Z

    .line 56
    const/4 v8, 0x1

    iput-boolean v8, v3, Lcom/wjj/eneity/RuningApp;->ischecked:Z

    .line 57
    iget-wide v8, v3, Lcom/wjj/eneity/RuningApp;->memory:J

    invoke-interface {p1, v8, v9, v3}, Lcom/wjj/manager/RuningAppManager$RuningAppManagerListener;->DownCountSize(JLcom/wjj/eneity/RuningApp;)V

    .line 58
    iget-object v8, p0, Lcom/wjj/manager/RuningAppManager;->data:Ljava/util/List;

    invoke-interface {v8, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 37
    .end local v1    # "appinfo":Landroid/content/pm/ApplicationInfo;
    .end local v3    # "item":Lcom/wjj/eneity/RuningApp;
    .end local v4    # "memory":Landroid/os/Debug$MemoryInfo;
    .end local v5    # "pids":[I
    .end local v7    # "wycneicui":I
    :cond_1
    :goto_1
    add-int/lit8 v2, v2, 0x1

    goto/16 :goto_0

    .line 59
    :catch_0
    move-exception v8

    goto :goto_1
.end method

.method public getUserSoftwareNum()I
    .locals 6

    .prologue
    .line 123
    const/4 v1, 0x0

    .line 124
    .local v1, "i":I
    iget-object v4, p0, Lcom/wjj/manager/RuningAppManager;->pManager:Landroid/content/pm/PackageManager;

    const/16 v5, 0x2000

    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getInstalledPackages(I)Ljava/util/List;

    move-result-object v2

    .line 125
    .local v2, "listinfo":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/PackageInfo;>;"
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_0
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-nez v5, :cond_1

    .line 131
    return v1

    .line 125
    :cond_1
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/content/pm/PackageInfo;

    .line 126
    .local v3, "packageInfo":Landroid/content/pm/PackageInfo;
    iget-object v5, v3, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget v0, v5, Landroid/content/pm/ApplicationInfo;->flags:I

    .line 127
    .local v0, "flags":I
    and-int/lit8 v5, v0, 0x1

    if-nez v5, :cond_0

    .line 128
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

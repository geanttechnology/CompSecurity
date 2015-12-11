.class public Lcom/aio/downloader/cleaner/TaskInfoProvider;
.super Ljava/lang/Object;
.source "TaskInfoProvider.java"


# instance fields
.field private activityManager:Landroid/app/ActivityManager;

.field private defaultIcon:Landroid/graphics/drawable/Drawable;

.field private packageManager:Landroid/content/pm/PackageManager;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 23
    const v1, 0x7f0200eb

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 22
    iput-object v0, p0, Lcom/aio/downloader/cleaner/TaskInfoProvider;->defaultIcon:Landroid/graphics/drawable/Drawable;

    .line 24
    invoke-virtual {p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/cleaner/TaskInfoProvider;->packageManager:Landroid/content/pm/PackageManager;

    .line 26
    const-string v0, "activity"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/ActivityManager;

    .line 25
    iput-object v0, p0, Lcom/aio/downloader/cleaner/TaskInfoProvider;->activityManager:Landroid/app/ActivityManager;

    .line 27
    return-void
.end method


# virtual methods
.method public filterApp(Landroid/content/pm/ApplicationInfo;)Z
    .locals 2
    .param p1, "info"    # Landroid/content/pm/ApplicationInfo;

    .prologue
    const/4 v0, 0x1

    .line 77
    iget v1, p1, Landroid/content/pm/ApplicationInfo;->flags:I

    and-int/lit16 v1, v1, 0x80

    if-eqz v1, :cond_1

    .line 83
    :cond_0
    :goto_0
    return v0

    .line 79
    :cond_1
    iget v1, p1, Landroid/content/pm/ApplicationInfo;->flags:I

    and-int/lit8 v1, v1, 0x1

    if-eqz v1, :cond_0

    .line 83
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getAllTask(Ljava/util/List;)Ljava/util/List;
    .locals 15
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Landroid/app/ActivityManager$RunningAppProcessInfo;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/cleaner/TaskInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 30
    .local p1, "runningAppProcessInfos":Ljava/util/List;, "Ljava/util/List<Landroid/app/ActivityManager$RunningAppProcessInfo;>;"
    new-instance v10, Ljava/util/ArrayList;

    invoke-direct {v10}, Ljava/util/ArrayList;-><init>()V

    .line 32
    .local v10, "taskInfos":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/cleaner/TaskInfo;>;"
    invoke-interface/range {p1 .. p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v12

    :goto_0
    invoke-interface {v12}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-nez v11, :cond_0

    .line 70
    return-object v10

    .line 32
    :cond_0
    invoke-interface {v12}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/app/ActivityManager$RunningAppProcessInfo;

    .line 33
    .local v8, "runningAppProcessInfo":Landroid/app/ActivityManager$RunningAppProcessInfo;
    new-instance v9, Lcom/aio/downloader/cleaner/TaskInfo;

    invoke-direct {v9}, Lcom/aio/downloader/cleaner/TaskInfo;-><init>()V

    .line 34
    .local v9, "taskInfo":Lcom/aio/downloader/cleaner/TaskInfo;
    iget v3, v8, Landroid/app/ActivityManager$RunningAppProcessInfo;->pid:I

    .line 35
    .local v3, "id":I
    invoke-virtual {v9, v3}, Lcom/aio/downloader/cleaner/TaskInfo;->setId(I)V

    .line 36
    iget-object v7, v8, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    .line 37
    .local v7, "packageName":Ljava/lang/String;
    invoke-virtual {v9, v7}, Lcom/aio/downloader/cleaner/TaskInfo;->setPackageName(Ljava/lang/String;)V

    .line 40
    :try_start_0
    iget-object v11, p0, Lcom/aio/downloader/cleaner/TaskInfoProvider;->packageManager:Landroid/content/pm/PackageManager;

    .line 41
    const/4 v13, 0x0

    invoke-virtual {v11, v7, v13}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v11

    iget-object v0, v11, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    .line 43
    .local v0, "applicationInfo":Landroid/content/pm/ApplicationInfo;
    iget-object v11, p0, Lcom/aio/downloader/cleaner/TaskInfoProvider;->packageManager:Landroid/content/pm/PackageManager;

    invoke-virtual {v0, v11}, Landroid/content/pm/ApplicationInfo;->loadIcon(Landroid/content/pm/PackageManager;)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    .line 44
    .local v2, "icon":Landroid/graphics/drawable/Drawable;
    invoke-virtual {v9, v2}, Lcom/aio/downloader/cleaner/TaskInfo;->setIcon(Landroid/graphics/drawable/Drawable;)V

    .line 46
    iget-object v11, p0, Lcom/aio/downloader/cleaner/TaskInfoProvider;->packageManager:Landroid/content/pm/PackageManager;

    invoke-virtual {v0, v11}, Landroid/content/pm/ApplicationInfo;->loadLabel(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;

    move-result-object v11

    .line 47
    invoke-interface {v11}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v6

    .line 48
    .local v6, "name":Ljava/lang/String;
    invoke-virtual {v9, v6}, Lcom/aio/downloader/cleaner/TaskInfo;->setName(Ljava/lang/String;)V

    .line 51
    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/TaskInfoProvider;->filterApp(Landroid/content/pm/ApplicationInfo;)Z

    move-result v11

    if-eqz v11, :cond_1

    const/4 v11, 0x0

    :goto_1
    invoke-virtual {v9, v11}, Lcom/aio/downloader/cleaner/TaskInfo;->setSystemProcess(Z)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 62
    .end local v0    # "applicationInfo":Landroid/content/pm/ApplicationInfo;
    .end local v2    # "icon":Landroid/graphics/drawable/Drawable;
    .end local v6    # "name":Ljava/lang/String;
    :goto_2
    iget-object v11, p0, Lcom/aio/downloader/cleaner/TaskInfoProvider;->activityManager:Landroid/app/ActivityManager;

    .line 63
    const/4 v13, 0x1

    new-array v13, v13, [I

    const/4 v14, 0x0

    aput v3, v13, v14

    invoke-virtual {v11, v13}, Landroid/app/ActivityManager;->getProcessMemoryInfo([I)[Landroid/os/Debug$MemoryInfo;

    move-result-object v5

    .line 65
    .local v5, "memoryInfos":[Landroid/os/Debug$MemoryInfo;
    const/4 v11, 0x0

    aget-object v11, v5, v11

    invoke-virtual {v11}, Landroid/os/Debug$MemoryInfo;->getTotalPrivateDirty()I

    move-result v4

    .line 66
    .local v4, "memory":I
    invoke-virtual {v9, v4}, Lcom/aio/downloader/cleaner/TaskInfo;->setMemory(I)V

    .line 67
    invoke-interface {v10, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 51
    .end local v4    # "memory":I
    .end local v5    # "memoryInfos":[Landroid/os/Debug$MemoryInfo;
    .restart local v0    # "applicationInfo":Landroid/content/pm/ApplicationInfo;
    .restart local v2    # "icon":Landroid/graphics/drawable/Drawable;
    .restart local v6    # "name":Ljava/lang/String;
    :cond_1
    const/4 v11, 0x1

    goto :goto_1

    .line 52
    .end local v0    # "applicationInfo":Landroid/content/pm/ApplicationInfo;
    .end local v2    # "icon":Landroid/graphics/drawable/Drawable;
    .end local v6    # "name":Ljava/lang/String;
    :catch_0
    move-exception v1

    .line 53
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    .line 56
    invoke-virtual {v9, v7}, Lcom/aio/downloader/cleaner/TaskInfo;->setName(Ljava/lang/String;)V

    .line 57
    const/4 v11, 0x1

    invoke-virtual {v9, v11}, Lcom/aio/downloader/cleaner/TaskInfo;->setSystemProcess(Z)V

    .line 58
    iget-object v11, p0, Lcom/aio/downloader/cleaner/TaskInfoProvider;->defaultIcon:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v9, v11}, Lcom/aio/downloader/cleaner/TaskInfo;->setIcon(Landroid/graphics/drawable/Drawable;)V

    goto :goto_2
.end method

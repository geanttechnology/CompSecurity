.class public Lcom/wjj/manager/RubSoftwareManager;
.super Ljava/lang/Object;
.source "RubSoftwareManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/wjj/manager/RubSoftwareManager$RubSoftwareManagerListener;
    }
.end annotation


# instance fields
.field private PATH_CACHE:Ljava/lang/String;

.field private context:Landroid/content/Context;

.field private packagename:Ljava/lang/String;

.field private pm:Landroid/content/pm/PackageManager;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "/data/data/"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/wjj/manager/RubSoftwareManager;->packagename:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/cache"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wjj/manager/RubSoftwareManager;->PATH_CACHE:Ljava/lang/String;

    .line 33
    iput-object p1, p0, Lcom/wjj/manager/RubSoftwareManager;->context:Landroid/content/Context;

    .line 34
    invoke-virtual {p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    .line 35
    invoke-virtual {p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    iput-object v0, p0, Lcom/wjj/manager/RubSoftwareManager;->pm:Landroid/content/pm/PackageManager;

    .line 36
    return-void
.end method

.method public static delFile(Ljava/io/File;)V
    .locals 4
    .param p0, "file"    # Ljava/io/File;

    .prologue
    .line 129
    invoke-virtual {p0}, Ljava/io/File;->isDirectory()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 130
    invoke-virtual {p0}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v1

    .line 131
    .local v1, "files":[Ljava/io/File;
    if-eqz v1, :cond_0

    array-length v2, v1

    if-lez v2, :cond_0

    .line 132
    array-length v3, v1

    const/4 v2, 0x0

    :goto_0
    if-lt v2, v3, :cond_1

    .line 137
    .end local v1    # "files":[Ljava/io/File;
    :cond_0
    invoke-virtual {p0}, Ljava/io/File;->delete()Z

    .line 138
    return-void

    .line 132
    .restart local v1    # "files":[Ljava/io/File;
    :cond_1
    aget-object v0, v1, v2

    .line 133
    .local v0, "f":Ljava/io/File;
    invoke-static {v0}, Lcom/wjj/manager/RubSoftwareManager;->delFile(Ljava/io/File;)V

    .line 132
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method public static getSize(Ljava/io/File;)J
    .locals 8
    .param p0, "file"    # Ljava/io/File;

    .prologue
    .line 111
    invoke-virtual {p0}, Ljava/io/File;->isFile()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 112
    invoke-virtual {p0}, Ljava/io/File;->length()J

    move-result-wide v2

    .line 123
    :cond_0
    return-wide v2

    .line 114
    :cond_1
    const-wide/16 v2, 0x0

    .line 115
    .local v2, "size":J
    invoke-virtual {p0}, Ljava/io/File;->isDirectory()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 116
    invoke-virtual {p0}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v1

    .line 117
    .local v1, "files":[Ljava/io/File;
    if-eqz v1, :cond_0

    array-length v4, v1

    if-lez v4, :cond_0

    .line 118
    array-length v5, v1

    const/4 v4, 0x0

    :goto_0
    if-ge v4, v5, :cond_0

    aget-object v0, v1, v4

    .line 119
    .local v0, "f":Ljava/io/File;
    invoke-static {v0}, Lcom/wjj/manager/RubSoftwareManager;->getSize(Ljava/io/File;)J

    move-result-wide v6

    add-long/2addr v2, v6

    .line 118
    add-int/lit8 v4, v4, 0x1

    goto :goto_0
.end method


# virtual methods
.method public getApplicationInfo(Lcom/wjj/manager/RubSoftwareManager$RubSoftwareManagerListener;)Ljava/util/List;
    .locals 11
    .param p1, "listener"    # Lcom/wjj/manager/RubSoftwareManager$RubSoftwareManagerListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/wjj/manager/RubSoftwareManager$RubSoftwareManagerListener;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/wjj/eneity/RubSoftware;",
            ">;"
        }
    .end annotation

    .prologue
    .line 39
    iget-object v6, p0, Lcom/wjj/manager/RubSoftwareManager;->pm:Landroid/content/pm/PackageManager;

    const/16 v7, 0x2000

    invoke-virtual {v6, v7}, Landroid/content/pm/PackageManager;->getInstalledPackages(I)Ljava/util/List;

    move-result-object v4

    .line 41
    .local v4, "listInfo":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/PackageInfo;>;"
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 42
    .local v2, "data":Ljava/util/List;, "Ljava/util/List<Lcom/wjj/eneity/RubSoftware;>;"
    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :cond_0
    :goto_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-nez v7, :cond_1

    .line 64
    return-object v2

    .line 42
    :cond_1
    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/content/pm/PackageInfo;

    .line 43
    .local v1, "appInfo":Landroid/content/pm/PackageInfo;
    new-instance v0, Lcom/wjj/eneity/RubSoftware;

    invoke-direct {v0}, Lcom/wjj/eneity/RubSoftware;-><init>()V

    .line 44
    .local v0, "RubSoftware":Lcom/wjj/eneity/RubSoftware;
    iget-object v7, v1, Landroid/content/pm/PackageInfo;->packageName:Ljava/lang/String;

    iput-object v7, v0, Lcom/wjj/eneity/RubSoftware;->packnane:Ljava/lang/String;

    .line 45
    iget-object v7, v1, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    iput-object v7, v0, Lcom/wjj/eneity/RubSoftware;->version:Ljava/lang/String;

    .line 46
    iget-object v7, v1, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget-object v8, p0, Lcom/wjj/manager/RubSoftwareManager;->pm:Landroid/content/pm/PackageManager;

    invoke-virtual {v7, v8}, Landroid/content/pm/ApplicationInfo;->loadIcon(Landroid/content/pm/PackageManager;)Landroid/graphics/drawable/Drawable;

    move-result-object v7

    iput-object v7, v0, Lcom/wjj/eneity/RubSoftware;->icon:Landroid/graphics/drawable/Drawable;

    .line 47
    iget-object v7, v1, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget-object v8, p0, Lcom/wjj/manager/RubSoftwareManager;->pm:Landroid/content/pm/PackageManager;

    invoke-virtual {v7, v8}, Landroid/content/pm/ApplicationInfo;->loadLabel(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;

    move-result-object v7

    invoke-interface {v7}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v7

    iput-object v7, v0, Lcom/wjj/eneity/RubSoftware;->softname:Ljava/lang/String;

    .line 48
    new-instance v7, Ljava/io/File;

    iget-object v8, v1, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget-object v8, v8, Landroid/content/pm/ApplicationInfo;->publicSourceDir:Ljava/lang/String;

    invoke-direct {v7, v8}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7}, Ljava/io/File;->length()J

    move-result-wide v7

    const-wide/16 v9, 0x400

    div-long/2addr v7, v9

    iput-wide v7, v0, Lcom/wjj/eneity/RubSoftware;->size:J

    .line 49
    invoke-static {}, Landroid/os/Environment;->getExternalStorageState()Ljava/lang/String;

    move-result-object v7

    const-string v8, "mounted"

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 50
    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "data/data/"

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v8, v1, Landroid/content/pm/PackageInfo;->packageName:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "/cache"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 51
    .local v5, "path":Ljava/lang/String;
    new-instance v3, Ljava/io/File;

    invoke-direct {v3, v5}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 52
    .local v3, "file":Ljava/io/File;
    invoke-virtual {v3}, Ljava/io/File;->exists()Z

    move-result v7

    if-eqz v7, :cond_2

    .line 53
    iput-object v5, v0, Lcom/wjj/eneity/RubSoftware;->cachepath:Ljava/lang/String;

    .line 54
    invoke-static {v3}, Lcom/wjj/manager/RubSoftwareManager;->getSize(Ljava/io/File;)J

    move-result-wide v7

    iput-wide v7, v0, Lcom/wjj/eneity/RubSoftware;->allcache:J

    .line 58
    .end local v3    # "file":Ljava/io/File;
    .end local v5    # "path":Ljava/lang/String;
    :cond_2
    iget-wide v7, v0, Lcom/wjj/eneity/RubSoftware;->allcache:J

    const-wide/16 v9, 0x0

    cmp-long v7, v7, v9

    if-lez v7, :cond_0

    .line 59
    const/4 v7, 0x1

    iput-boolean v7, v0, Lcom/wjj/eneity/RubSoftware;->ischecked:Z

    .line 60
    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 61
    iget-wide v7, v0, Lcom/wjj/eneity/RubSoftware;->allcache:J

    invoke-interface {p1, v2, v7, v8}, Lcom/wjj/manager/RubSoftwareManager$RubSoftwareManagerListener;->DownCount(Ljava/util/List;J)V

    goto/16 :goto_0
.end method

.method public getSysRubSoftware(Lcom/wjj/manager/RubSoftwareManager$RubSoftwareManagerListener;)Ljava/util/List;
    .locals 10
    .param p1, "listener"    # Lcom/wjj/manager/RubSoftwareManager$RubSoftwareManagerListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/wjj/manager/RubSoftwareManager$RubSoftwareManagerListener;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/wjj/eneity/RubSoftware;",
            ">;"
        }
    .end annotation

    .prologue
    .line 69
    iget-object v7, p0, Lcom/wjj/manager/RubSoftwareManager;->pm:Landroid/content/pm/PackageManager;

    const/16 v8, 0x2000

    invoke-virtual {v7, v8}, Landroid/content/pm/PackageManager;->getInstalledPackages(I)Ljava/util/List;

    move-result-object v6

    .line 71
    .local v6, "listinfo":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/PackageInfo;>;"
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 72
    .local v4, "data":Ljava/util/List;, "Ljava/util/List<Lcom/wjj/eneity/RubSoftware;>;"
    const-wide/16 v1, 0x0

    .line 73
    .local v1, "allsize":J
    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :cond_0
    :goto_0
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-nez v8, :cond_1

    .line 87
    return-object v4

    .line 73
    :cond_1
    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/content/pm/PackageInfo;

    .line 74
    .local v3, "appinfo":Landroid/content/pm/PackageInfo;
    iget-object v8, v3, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget v5, v8, Landroid/content/pm/ApplicationInfo;->flags:I

    .line 75
    .local v5, "flags":I
    and-int/lit8 v8, v5, 0x1

    if-eqz v8, :cond_0

    .line 76
    new-instance v0, Lcom/wjj/eneity/RubSoftware;

    invoke-direct {v0}, Lcom/wjj/eneity/RubSoftware;-><init>()V

    .line 77
    .local v0, "RubSoftware":Lcom/wjj/eneity/RubSoftware;
    iget-object v8, v3, Landroid/content/pm/PackageInfo;->packageName:Ljava/lang/String;

    iput-object v8, v0, Lcom/wjj/eneity/RubSoftware;->packnane:Ljava/lang/String;

    .line 78
    iget-object v8, v3, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    iput-object v8, v0, Lcom/wjj/eneity/RubSoftware;->version:Ljava/lang/String;

    .line 79
    iget-object v8, v3, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget-object v9, p0, Lcom/wjj/manager/RubSoftwareManager;->pm:Landroid/content/pm/PackageManager;

    invoke-virtual {v8, v9}, Landroid/content/pm/ApplicationInfo;->loadIcon(Landroid/content/pm/PackageManager;)Landroid/graphics/drawable/Drawable;

    move-result-object v8

    iput-object v8, v0, Lcom/wjj/eneity/RubSoftware;->icon:Landroid/graphics/drawable/Drawable;

    .line 80
    iget-object v8, v3, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget-object v9, p0, Lcom/wjj/manager/RubSoftwareManager;->pm:Landroid/content/pm/PackageManager;

    invoke-virtual {v8, v9}, Landroid/content/pm/ApplicationInfo;->loadLabel(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;

    move-result-object v8

    invoke-interface {v8}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v8

    iput-object v8, v0, Lcom/wjj/eneity/RubSoftware;->softname:Ljava/lang/String;

    .line 81
    invoke-interface {v4, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public getUserRubSoftware(Lcom/wjj/manager/RubSoftwareManager$RubSoftwareManagerListener;)Ljava/util/List;
    .locals 8
    .param p1, "listener"    # Lcom/wjj/manager/RubSoftwareManager$RubSoftwareManagerListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/wjj/manager/RubSoftwareManager$RubSoftwareManagerListener;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/wjj/eneity/RubSoftware;",
            ">;"
        }
    .end annotation

    .prologue
    .line 91
    iget-object v5, p0, Lcom/wjj/manager/RubSoftwareManager;->pm:Landroid/content/pm/PackageManager;

    const/16 v6, 0x2000

    invoke-virtual {v5, v6}, Landroid/content/pm/PackageManager;->getInstalledPackages(I)Ljava/util/List;

    move-result-object v3

    .line 93
    .local v3, "listinfo":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/PackageInfo;>;"
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 94
    .local v1, "data":Ljava/util/List;, "Ljava/util/List<Lcom/wjj/eneity/RubSoftware;>;"
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_0
    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-nez v6, :cond_1

    .line 106
    return-object v1

    .line 94
    :cond_1
    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/content/pm/PackageInfo;

    .line 95
    .local v4, "packageInfo":Landroid/content/pm/PackageInfo;
    iget-object v6, v4, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget v2, v6, Landroid/content/pm/ApplicationInfo;->flags:I

    .line 96
    .local v2, "flags":I
    and-int/lit8 v6, v2, 0x1

    if-nez v6, :cond_0

    .line 97
    new-instance v0, Lcom/wjj/eneity/RubSoftware;

    invoke-direct {v0}, Lcom/wjj/eneity/RubSoftware;-><init>()V

    .line 98
    .local v0, "RubSoftware":Lcom/wjj/eneity/RubSoftware;
    iget-object v6, v4, Landroid/content/pm/PackageInfo;->packageName:Ljava/lang/String;

    iput-object v6, v0, Lcom/wjj/eneity/RubSoftware;->packnane:Ljava/lang/String;

    .line 99
    iget-object v6, v4, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    iput-object v6, v0, Lcom/wjj/eneity/RubSoftware;->version:Ljava/lang/String;

    .line 100
    iget-object v6, v4, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget-object v7, p0, Lcom/wjj/manager/RubSoftwareManager;->pm:Landroid/content/pm/PackageManager;

    invoke-virtual {v6, v7}, Landroid/content/pm/ApplicationInfo;->loadIcon(Landroid/content/pm/PackageManager;)Landroid/graphics/drawable/Drawable;

    move-result-object v6

    iput-object v6, v0, Lcom/wjj/eneity/RubSoftware;->icon:Landroid/graphics/drawable/Drawable;

    .line 101
    iget-object v6, v4, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget-object v7, p0, Lcom/wjj/manager/RubSoftwareManager;->pm:Landroid/content/pm/PackageManager;

    invoke-virtual {v6, v7}, Landroid/content/pm/ApplicationInfo;->loadLabel(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;

    move-result-object v6

    invoke-interface {v6}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v6

    iput-object v6, v0, Lcom/wjj/eneity/RubSoftware;->softname:Ljava/lang/String;

    .line 102
    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

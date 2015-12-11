.class public Lcom/wjj/manager/UnloadingResidueManager;
.super Ljava/lang/Object;
.source "UnloadingResidueManager.java"


# instance fields
.field private empty:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/io/File;",
            ">;"
        }
    .end annotation
.end field

.field private packnamelist:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private pm:Landroid/content/pm/PackageManager;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    invoke-virtual {p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    iput-object v0, p0, Lcom/wjj/manager/UnloadingResidueManager;->pm:Landroid/content/pm/PackageManager;

    .line 19
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/wjj/manager/UnloadingResidueManager;->empty:Ljava/util/List;

    .line 20
    return-void
.end method


# virtual methods
.method public GGGfile(Ljava/io/File;)Ljava/util/List;
    .locals 5
    .param p1, "root"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/File;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/io/File;",
            ">;"
        }
    .end annotation

    .prologue
    .line 25
    invoke-virtual {p1}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v1

    .line 26
    .local v1, "files":[Ljava/io/File;
    array-length v3, v1

    const/4 v2, 0x0

    :goto_0
    if-lt v2, v3, :cond_0

    .line 39
    iget-object v2, p0, Lcom/wjj/manager/UnloadingResidueManager;->empty:Ljava/util/List;

    return-object v2

    .line 26
    :cond_0
    aget-object v0, v1, v2

    .line 27
    .local v0, "ff":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-virtual {v0}, Ljava/io/File;->isDirectory()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 29
    :try_start_0
    invoke-virtual {v0}, Ljava/io/File;->list()[Ljava/lang/String;

    move-result-object v4

    array-length v4, v4

    if-lez v4, :cond_2

    .line 30
    invoke-virtual {p0, v0}, Lcom/wjj/manager/UnloadingResidueManager;->GGGfile(Ljava/io/File;)Ljava/util/List;

    .line 26
    :cond_1
    :goto_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 32
    :cond_2
    iget-object v4, p0, Lcom/wjj/manager/UnloadingResidueManager;->empty:Ljava/util/List;

    invoke-interface {v4, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 34
    :catch_0
    move-exception v4

    goto :goto_1
.end method

.method public delete(Ljava/io/File;)V
    .locals 2
    .param p1, "file"    # Ljava/io/File;

    .prologue
    .line 43
    invoke-virtual {p1}, Ljava/io/File;->isFile()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 44
    invoke-virtual {p1}, Ljava/io/File;->delete()Z

    .line 55
    :cond_0
    :goto_0
    return-void

    .line 47
    :cond_1
    invoke-virtual {p1}, Ljava/io/File;->isDirectory()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 48
    invoke-virtual {p1}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v0

    .line 49
    .local v0, "childFiles":[Ljava/io/File;
    if-eqz v0, :cond_2

    array-length v1, v0

    if-nez v1, :cond_3

    .line 50
    :cond_2
    invoke-virtual {p1}, Ljava/io/File;->delete()Z

    goto :goto_0

    .line 53
    :cond_3
    invoke-virtual {p1}, Ljava/io/File;->delete()Z

    goto :goto_0
.end method

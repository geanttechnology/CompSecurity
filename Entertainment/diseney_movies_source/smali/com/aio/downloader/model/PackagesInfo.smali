.class public Lcom/aio/downloader/model/PackagesInfo;
.super Ljava/lang/Object;
.source "PackagesInfo.java"


# instance fields
.field private appList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Landroid/content/pm/ApplicationInfo;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    .line 15
    .local v0, "pm":Landroid/content/pm/PackageManager;
    const/16 v1, 0x2000

    invoke-virtual {v0, v1}, Landroid/content/pm/PackageManager;->getInstalledApplications(I)Ljava/util/List;

    move-result-object v1

    iput-object v1, p0, Lcom/aio/downloader/model/PackagesInfo;->appList:Ljava/util/List;

    .line 16
    return-void
.end method


# virtual methods
.method public getInfo(Ljava/lang/String;)Landroid/content/pm/ApplicationInfo;
    .locals 4
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 27
    if-nez p1, :cond_0

    move-object v0, v1

    .line 35
    :goto_0
    return-object v0

    .line 30
    :cond_0
    iget-object v2, p0, Lcom/aio/downloader/model/PackagesInfo;->appList:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-nez v3, :cond_2

    move-object v0, v1

    .line 35
    goto :goto_0

    .line 30
    :cond_2
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/pm/ApplicationInfo;

    .line 31
    .local v0, "appinfo":Landroid/content/pm/ApplicationInfo;
    iget-object v3, v0, Landroid/content/pm/ApplicationInfo;->processName:Ljava/lang/String;

    invoke-virtual {p1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    goto :goto_0
.end method

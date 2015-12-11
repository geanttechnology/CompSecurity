.class public Lcom/aio/downloader/utils/MyAppInfo;
.super Ljava/lang/Object;
.source "MyAppInfo.java"


# instance fields
.field context:Landroid/content/Context;

.field pm:Landroid/content/pm/PackageManager;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    iput-object p1, p0, Lcom/aio/downloader/utils/MyAppInfo;->context:Landroid/content/Context;

    .line 16
    invoke-virtual {p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/utils/MyAppInfo;->pm:Landroid/content/pm/PackageManager;

    .line 17
    return-void
.end method


# virtual methods
.method public getAppIcon(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    .locals 3
    .param p1, "packname"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/content/pm/PackageManager$NameNotFoundException;
        }
    .end annotation

    .prologue
    .line 24
    iget-object v1, p0, Lcom/aio/downloader/utils/MyAppInfo;->pm:Landroid/content/pm/PackageManager;

    const/4 v2, 0x0

    invoke-virtual {v1, p1, v2}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v0

    .line 25
    .local v0, "info":Landroid/content/pm/ApplicationInfo;
    iget-object v1, p0, Lcom/aio/downloader/utils/MyAppInfo;->pm:Landroid/content/pm/PackageManager;

    invoke-virtual {v0, v1}, Landroid/content/pm/ApplicationInfo;->loadIcon(Landroid/content/pm/PackageManager;)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    return-object v1
.end method

.method public getAppName(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "packname"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/content/pm/PackageManager$NameNotFoundException;
        }
    .end annotation

    .prologue
    .line 43
    iget-object v1, p0, Lcom/aio/downloader/utils/MyAppInfo;->pm:Landroid/content/pm/PackageManager;

    const/4 v2, 0x0

    invoke-virtual {v1, p1, v2}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v0

    .line 44
    .local v0, "info":Landroid/content/pm/ApplicationInfo;
    iget-object v1, p0, Lcom/aio/downloader/utils/MyAppInfo;->pm:Landroid/content/pm/PackageManager;

    invoke-virtual {v0, v1}, Landroid/content/pm/ApplicationInfo;->loadLabel(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;

    move-result-object v1

    invoke-interface {v1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public getAppVersion(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "packname"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/content/pm/PackageManager$NameNotFoundException;
        }
    .end annotation

    .prologue
    .line 34
    iget-object v1, p0, Lcom/aio/downloader/utils/MyAppInfo;->pm:Landroid/content/pm/PackageManager;

    const/4 v2, 0x0

    invoke-virtual {v1, p1, v2}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v0

    .line 35
    .local v0, "packinfo":Landroid/content/pm/PackageInfo;
    iget-object v1, v0, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    return-object v1
.end method

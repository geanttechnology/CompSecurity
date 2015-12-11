.class public Lcom/wjj/manager/SoftApkManager;
.super Ljava/lang/Object;
.source "SoftApkManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/wjj/manager/SoftApkManager$SoftApkManagerListener;,
        Lcom/wjj/manager/SoftApkManager$SoftApkManagerListener2;
    }
.end annotation


# instance fields
.field private context:Landroid/content/Context;

.field private data:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/wjj/eneity/SoftApk;",
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
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    iput-object p1, p0, Lcom/wjj/manager/SoftApkManager;->context:Landroid/content/Context;

    .line 20
    invoke-virtual {p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    .line 21
    invoke-virtual {p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    iput-object v0, p0, Lcom/wjj/manager/SoftApkManager;->pm:Landroid/content/pm/PackageManager;

    .line 22
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/wjj/manager/SoftApkManager;->data:Ljava/util/List;

    .line 23
    return-void
.end method


# virtual methods
.method public GetAllApk(Lcom/wjj/manager/SoftApkManager$SoftApkManagerListener;Ljava/lang/String;)Ljava/util/List;
    .locals 5
    .param p1, "listener"    # Lcom/wjj/manager/SoftApkManager$SoftApkManagerListener;
    .param p2, "archiveFilePath"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/wjj/manager/SoftApkManager$SoftApkManagerListener;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/wjj/eneity/SoftApk;",
            ">;"
        }
    .end annotation

    .prologue
    .line 26
    iget-object v3, p0, Lcom/wjj/manager/SoftApkManager;->pm:Landroid/content/pm/PackageManager;

    .line 27
    const/4 v4, 0x1

    .line 26
    invoke-virtual {v3, p2, v4}, Landroid/content/pm/PackageManager;->getPackageArchiveInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v2

    .line 28
    .local v2, "packInfo":Landroid/content/pm/PackageInfo;
    new-instance v0, Lcom/wjj/eneity/SoftApk;

    invoke-direct {v0}, Lcom/wjj/eneity/SoftApk;-><init>()V

    .line 29
    .local v0, "apk":Lcom/wjj/eneity/SoftApk;
    iget-object v1, v2, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    .line 30
    .local v1, "applicationInfo":Landroid/content/pm/ApplicationInfo;
    iput-object p2, v1, Landroid/content/pm/ApplicationInfo;->sourceDir:Ljava/lang/String;

    .line 31
    iput-object p2, v1, Landroid/content/pm/ApplicationInfo;->publicSourceDir:Ljava/lang/String;

    .line 32
    iget-object v3, v1, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    iput-object v3, v0, Lcom/wjj/eneity/SoftApk;->apkpackname:Ljava/lang/String;

    .line 33
    iget-object v3, p0, Lcom/wjj/manager/SoftApkManager;->pm:Landroid/content/pm/PackageManager;

    invoke-virtual {v3, v1}, Landroid/content/pm/PackageManager;->getApplicationLabel(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;

    move-result-object v3

    invoke-interface {v3}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, v0, Lcom/wjj/eneity/SoftApk;->apkname:Ljava/lang/String;

    .line 34
    iget-object v3, v2, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    iput-object v3, v0, Lcom/wjj/eneity/SoftApk;->apkversioncode:Ljava/lang/String;

    .line 35
    iget-object v3, p0, Lcom/wjj/manager/SoftApkManager;->pm:Landroid/content/pm/PackageManager;

    invoke-virtual {v3, v1}, Landroid/content/pm/PackageManager;->getApplicationIcon(Landroid/content/pm/ApplicationInfo;)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    iput-object v3, v0, Lcom/wjj/eneity/SoftApk;->icon:Landroid/graphics/drawable/Drawable;

    .line 36
    new-instance v3, Ljava/io/File;

    iget-object v4, v2, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget-object v4, v4, Landroid/content/pm/ApplicationInfo;->publicSourceDir:Ljava/lang/String;

    invoke-direct {v3, v4}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/io/File;->length()J

    move-result-wide v3

    iput-wide v3, v0, Lcom/wjj/eneity/SoftApk;->apksize:J

    .line 37
    iget-object v3, p0, Lcom/wjj/manager/SoftApkManager;->data:Ljava/util/List;

    invoke-interface {v3, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 38
    iget-object v3, p0, Lcom/wjj/manager/SoftApkManager;->data:Ljava/util/List;

    invoke-interface {p1, v3}, Lcom/wjj/manager/SoftApkManager$SoftApkManagerListener;->DownCount(Ljava/util/List;)V

    .line 40
    iget-object v3, p0, Lcom/wjj/manager/SoftApkManager;->data:Ljava/util/List;

    return-object v3
.end method

.method public GetAllApk2(Lcom/wjj/manager/SoftApkManager$SoftApkManagerListener2;Ljava/lang/String;)Lcom/wjj/eneity/SoftApk;
    .locals 5
    .param p1, "li"    # Lcom/wjj/manager/SoftApkManager$SoftApkManagerListener2;
    .param p2, "archiveFilePath"    # Ljava/lang/String;

    .prologue
    .line 54
    iget-object v3, p0, Lcom/wjj/manager/SoftApkManager;->pm:Landroid/content/pm/PackageManager;

    .line 55
    const/4 v4, 0x1

    .line 54
    invoke-virtual {v3, p2, v4}, Landroid/content/pm/PackageManager;->getPackageArchiveInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v2

    .line 56
    .local v2, "packInfo":Landroid/content/pm/PackageInfo;
    new-instance v0, Lcom/wjj/eneity/SoftApk;

    invoke-direct {v0}, Lcom/wjj/eneity/SoftApk;-><init>()V

    .line 57
    .local v0, "apk":Lcom/wjj/eneity/SoftApk;
    iget-object v1, v2, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    .line 58
    .local v1, "applicationInfo":Landroid/content/pm/ApplicationInfo;
    iput-object p2, v1, Landroid/content/pm/ApplicationInfo;->sourceDir:Ljava/lang/String;

    .line 59
    iput-object p2, v1, Landroid/content/pm/ApplicationInfo;->publicSourceDir:Ljava/lang/String;

    .line 60
    iget-object v3, v1, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    iput-object v3, v0, Lcom/wjj/eneity/SoftApk;->apkpackname:Ljava/lang/String;

    .line 61
    iget-object v3, p0, Lcom/wjj/manager/SoftApkManager;->pm:Landroid/content/pm/PackageManager;

    invoke-virtual {v3, v1}, Landroid/content/pm/PackageManager;->getApplicationLabel(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;

    move-result-object v3

    invoke-interface {v3}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, v0, Lcom/wjj/eneity/SoftApk;->apkname:Ljava/lang/String;

    .line 62
    iget-object v3, v2, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    iput-object v3, v0, Lcom/wjj/eneity/SoftApk;->apkversioncode:Ljava/lang/String;

    .line 63
    iget-object v3, p0, Lcom/wjj/manager/SoftApkManager;->pm:Landroid/content/pm/PackageManager;

    invoke-virtual {v3, v1}, Landroid/content/pm/PackageManager;->getApplicationIcon(Landroid/content/pm/ApplicationInfo;)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    iput-object v3, v0, Lcom/wjj/eneity/SoftApk;->icon:Landroid/graphics/drawable/Drawable;

    .line 64
    new-instance v3, Ljava/io/File;

    iget-object v4, v2, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget-object v4, v4, Landroid/content/pm/ApplicationInfo;->publicSourceDir:Ljava/lang/String;

    invoke-direct {v3, v4}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/io/File;->length()J

    move-result-wide v3

    iput-wide v3, v0, Lcom/wjj/eneity/SoftApk;->apksize:J

    .line 65
    iget-wide v3, v0, Lcom/wjj/eneity/SoftApk;->apksize:J

    invoke-interface {p1, v3, v4}, Lcom/wjj/manager/SoftApkManager$SoftApkManagerListener2;->DownCount(J)V

    .line 67
    return-object v0
.end method

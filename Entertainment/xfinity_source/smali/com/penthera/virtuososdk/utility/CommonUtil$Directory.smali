.class public final Lcom/penthera/virtuososdk/utility/CommonUtil$Directory;
.super Ljava/lang/Object;
.source "CommonUtil.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/utility/CommonUtil;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Directory"
.end annotation


# static fields
.field public static NOMEDIA_FILENAME:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 604
    const-string v0, ".nomedia"

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$Directory;->NOMEDIA_FILENAME:Ljava/lang/String;

    .line 595
    return-void
.end method

.method public static createMediaRoot(Landroid/content/Context;)Z
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 627
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    .line 629
    .local v1, "mediaRootPath":Ljava/lang/StringBuffer;
    invoke-static {p0}, Lcom/penthera/virtuososdk/utility/CommonUtil$Directory;->getRoot(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    .line 630
    .local v2, "root":Ljava/lang/String;
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 631
    const/4 v3, 0x0

    .line 643
    :goto_0
    return v3

    .line 634
    :cond_0
    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 635
    const-string v3, "/"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 636
    const-string v3, "media"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 637
    const-string v3, "/"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 639
    new-instance v0, Ljava/io/File;

    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v3}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 640
    .local v0, "dirs":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 641
    const/4 v3, 0x1

    goto :goto_0

    .line 643
    :cond_1
    invoke-virtual {v0}, Ljava/io/File;->mkdirs()Z

    move-result v3

    goto :goto_0
.end method

.method public static createRoot(Landroid/content/Context;)Z
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 611
    const-string v1, "virtuoso"

    invoke-static {p0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Directory;->getExternalPath(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;

    move-result-object v0

    .line 613
    .local v0, "dir":Ljava/io/File;
    if-nez v0, :cond_0

    .line 614
    const/4 v1, 0x0

    .line 619
    :goto_0
    return v1

    .line 616
    :cond_0
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 617
    const/4 v1, 0x1

    goto :goto_0

    .line 619
    :cond_1
    invoke-virtual {v0}, Ljava/io/File;->mkdirs()Z

    move-result v1

    goto :goto_0
.end method

.method private static getExternalPath(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "path"    # Ljava/lang/String;

    .prologue
    .line 762
    const/4 v0, 0x1

    invoke-static {p0, p1, v0}, Lcom/penthera/virtuososdk/utility/CommonUtil$Directory;->getExternalPath(Landroid/content/Context;Ljava/lang/String;Z)Ljava/io/File;

    move-result-object v0

    return-object v0
.end method

.method private static getExternalPath(Landroid/content/Context;Ljava/lang/String;Z)Ljava/io/File;
    .locals 7
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "path"    # Ljava/lang/String;
    .param p2, "useExternalCache"    # Z

    .prologue
    const/4 v0, 0x0

    .line 772
    invoke-static {}, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->getInstance()Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;

    move-result-object v2

    .line 773
    .local v2, "info":Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;
    invoke-virtual {v2}, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->update()V

    .line 774
    invoke-virtual {v2}, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->isMounted()Z

    move-result v5

    if-nez v5, :cond_1

    invoke-virtual {v2}, Lcom/penthera/virtuososdk/monitor/ExternalStorageInfo;->isWritable()Z

    move-result v5

    if-nez v5, :cond_1

    .line 814
    :cond_0
    :goto_0
    return-object v0

    .line 777
    :cond_1
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    .line 778
    .local v4, "sb":Ljava/lang/StringBuilder;
    const/4 v3, 0x0

    .line 781
    .local v3, "root":Ljava/io/File;
    if-eqz p2, :cond_3

    .line 782
    if-nez p0, :cond_2

    .line 783
    const-string v5, "Directory"

    const-string v6, "getExternalPath: context is null"

    invoke-static {v5, v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 788
    :cond_2
    const/4 v5, 0x0

    :try_start_0
    invoke-virtual {p0, v5}, Landroid/content/Context;->getExternalFilesDir(Ljava/lang/String;)Ljava/io/File;
    :try_end_0
    .catch Ljava/lang/NoSuchMethodError; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 789
    if-eqz v3, :cond_0

    .line 797
    :cond_3
    :goto_1
    if-nez p2, :cond_4

    .line 798
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v3

    .line 801
    :cond_4
    if-eqz v3, :cond_0

    .line 806
    invoke-virtual {v3}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 807
    const-string v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 808
    if-eqz p1, :cond_5

    .line 810
    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 811
    const-string v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 813
    :cond_5
    new-instance v0, Ljava/io/File;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v0, v5}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 814
    .local v0, "dir":Ljava/io/File;
    goto :goto_0

    .line 791
    .end local v0    # "dir":Ljava/io/File;
    :catch_0
    move-exception v1

    .line 792
    .local v1, "e":Ljava/lang/NoSuchMethodError;
    const/4 p2, 0x0

    goto :goto_1
.end method

.method public static getMediaRoot(Landroid/content/Context;)Ljava/lang/String;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 729
    const-string v1, "virtuoso/media"

    invoke-static {p0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Directory;->getExternalPath(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;

    move-result-object v0

    .line 730
    .local v0, "path":Ljava/io/File;
    if-eqz v0, :cond_0

    .line 731
    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v1

    .line 733
    :goto_0
    return-object v1

    :cond_0
    const-string v1, ""

    goto :goto_0
.end method

.method public static getRoot(Landroid/content/Context;)Ljava/lang/String;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 715
    const-string v1, "virtuoso"

    invoke-static {p0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Directory;->getExternalPath(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;

    move-result-object v0

    .line 716
    .local v0, "path":Ljava/io/File;
    if-eqz v0, :cond_0

    .line 717
    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v1

    .line 719
    :goto_0
    return-object v1

    :cond_0
    const-string v1, ""

    goto :goto_0
.end method

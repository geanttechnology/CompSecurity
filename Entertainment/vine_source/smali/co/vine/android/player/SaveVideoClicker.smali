.class public Lco/vine/android/player/SaveVideoClicker;
.super Ljava/lang/Object;
.source "SaveVideoClicker.java"


# static fields
.field private static LONG_PRESS_SAVE_DIR:Ljava/io/File;


# instance fields
.field private mCount:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    const/4 v0, 0x0

    sput-object v0, Lco/vine/android/player/SaveVideoClicker;->LONG_PRESS_SAVE_DIR:Ljava/io/File;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    const/4 v0, 0x0

    iput v0, p0, Lco/vine/android/player/SaveVideoClicker;->mCount:I

    return-void
.end method

.method public static setLongPressSaveDir(Ljava/io/File;)V
    .locals 0
    .param p0, "dir"    # Ljava/io/File;

    .prologue
    .line 22
    sput-object p0, Lco/vine/android/player/SaveVideoClicker;->LONG_PRESS_SAVE_DIR:Ljava/io/File;

    .line 23
    return-void
.end method


# virtual methods
.method public onClick(Lco/vine/android/player/SdkVideoView;)V
    .locals 8
    .param p1, "view"    # Lco/vine/android/player/SdkVideoView;

    .prologue
    const/4 v7, 0x0

    .line 28
    sget-object v4, Lco/vine/android/player/SaveVideoClicker;->LONG_PRESS_SAVE_DIR:Ljava/io/File;

    if-eqz v4, :cond_1

    .line 29
    iget v4, p0, Lco/vine/android/player/SaveVideoClicker;->mCount:I

    add-int/lit8 v4, v4, 0x1

    iput v4, p0, Lco/vine/android/player/SaveVideoClicker;->mCount:I

    .line 30
    iget v4, p0, Lco/vine/android/player/SaveVideoClicker;->mCount:I

    const/16 v5, 0x14

    if-lt v4, v5, :cond_1

    .line 31
    invoke-virtual {p1}, Lco/vine/android/player/SdkVideoView;->getPath()Ljava/lang/String;

    move-result-object v3

    .line 33
    .local v3, "path":Ljava/lang/String;
    :try_start_0
    new-instance v4, Ljava/io/File;

    invoke-direct {v4, v3}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v2

    .line 34
    .local v2, "name":Ljava/lang/String;
    const-string v4, ".mp4"

    invoke-virtual {v2, v4}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 35
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ".mp4"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 37
    :cond_0
    new-instance v0, Ljava/io/File;

    sget-object v4, Lco/vine/android/player/SaveVideoClicker;->LONG_PRESS_SAVE_DIR:Ljava/io/File;

    invoke-direct {v0, v4, v2}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 38
    .local v0, "dest":Ljava/io/File;
    new-instance v4, Ljava/io/File;

    invoke-direct {v4, v3}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-static {v4, v0}, Lorg/apache/commons/io/FileUtils;->copyFile(Ljava/io/File;Ljava/io/File;)V

    .line 39
    invoke-virtual {p1}, Lco/vine/android/player/SdkVideoView;->getContext()Landroid/content/Context;

    move-result-object v4

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "File Saved: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x0

    invoke-static {v4, v5, v6}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v4

    invoke-virtual {v4}, Landroid/widget/Toast;->show()V

    .line 40
    invoke-virtual {p1}, Lco/vine/android/player/SdkVideoView;->getContext()Landroid/content/Context;

    move-result-object v4

    const/4 v5, 0x0

    invoke-static {v4, v0, v5}, Lco/vine/android/util/MediaUtil;->scanFile(Landroid/content/Context;Ljava/io/File;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 44
    .end local v0    # "dest":Ljava/io/File;
    .end local v2    # "name":Ljava/lang/String;
    :goto_0
    iput v7, p0, Lco/vine/android/player/SaveVideoClicker;->mCount:I

    .line 47
    .end local v3    # "path":Ljava/lang/String;
    :cond_1
    return-void

    .line 41
    .restart local v3    # "path":Ljava/lang/String;
    :catch_0
    move-exception v1

    .line 42
    .local v1, "e":Ljava/io/IOException;
    const-string v4, "Failed to save video"

    invoke-static {v4, v1}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

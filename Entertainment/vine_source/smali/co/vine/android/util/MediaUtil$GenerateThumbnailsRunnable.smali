.class public Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;
.super Ljava/lang/Object;
.source "MediaUtil.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/util/MediaUtil;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GenerateThumbnailsRunnable"
.end annotation


# instance fields
.field private final duration:J

.field private final lastFramePath:Ljava/lang/String;

.field private final thumbnailPath:Ljava/lang/String;

.field private final videoPath:Ljava/lang/String;


# direct methods
.method public constructor <init>(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "duration"    # J
    .param p3, "videoPath"    # Ljava/lang/String;
    .param p4, "thumbnailPath"    # Ljava/lang/String;
    .param p5, "lastFramePath"    # Ljava/lang/String;

    .prologue
    .line 104
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 105
    iput-wide p1, p0, Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;->duration:J

    .line 106
    iput-object p5, p0, Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;->lastFramePath:Ljava/lang/String;

    .line 107
    iput-object p3, p0, Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;->videoPath:Ljava/lang/String;

    .line 108
    iput-object p4, p0, Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;->thumbnailPath:Ljava/lang/String;

    .line 109
    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 114
    :try_start_0
    iget-wide v1, p0, Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;->duration:J

    iget-object v3, p0, Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;->videoPath:Ljava/lang/String;

    iget-object v4, p0, Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;->thumbnailPath:Ljava/lang/String;

    iget-object v5, p0, Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;->lastFramePath:Ljava/lang/String;

    invoke-static {v1, v2, v3, v4, v5}, Lco/vine/android/util/MediaUtil;->generateThumbnails(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 118
    return-void

    .line 115
    :catch_0
    move-exception v0

    .line 116
    .local v0, "e":Ljava/io/FileNotFoundException;
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

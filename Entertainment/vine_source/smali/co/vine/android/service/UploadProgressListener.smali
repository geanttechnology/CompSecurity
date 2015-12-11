.class public abstract Lco/vine/android/service/UploadProgressListener;
.super Ljava/lang/Object;
.source "UploadProgressListener.java"

# interfaces
.implements Lco/vine/android/util/VineProgressListener;


# instance fields
.field public currentSize:J

.field public lastProgress:I

.field public path:Ljava/lang/String;

.field public size:J

.field public thumbnail:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "path"    # Ljava/lang/String;

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    invoke-static {p1}, Lco/vine/android/recorder/RecordConfigUtils;->getThumbnailPath(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 20
    .local v0, "thumbnail":Ljava/lang/String;
    iput-object p1, p0, Lco/vine/android/service/UploadProgressListener;->path:Ljava/lang/String;

    .line 21
    iput-object v0, p0, Lco/vine/android/service/UploadProgressListener;->thumbnail:Ljava/lang/String;

    .line 22
    return-void
.end method


# virtual methods
.method public abstract onPostFinished(Z)V
.end method

.method public abstract onTranscodeStarted()V
.end method

.method public abstract progressChanged(Lco/vine/android/util/VineProgressEvent;)V
.end method

.method public showPostNotification(Ljava/lang/String;)V
    .locals 0
    .param p1, "thumbnail"    # Ljava/lang/String;

    .prologue
    .line 28
    return-void
.end method

.method public abstract updateTranscodeProgress(I)V
.end method

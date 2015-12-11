.class Lco/vine/android/recorder/RecordController$1;
.super Ljava/lang/Object;
.source "RecordController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/recorder/RecordController;->stop(ZZ)Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/recorder/RecordController;


# direct methods
.method constructor <init>(Lco/vine/android/recorder/RecordController;)V
    .locals 0

    .prologue
    .line 266
    iput-object p1, p0, Lco/vine/android/recorder/RecordController$1;->this$0:Lco/vine/android/recorder/RecordController;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 269
    iget-object v0, p0, Lco/vine/android/recorder/RecordController$1;->this$0:Lco/vine/android/recorder/RecordController;

    const-string v1, "Stop on thread."

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/RecordController;->releaseCameraAndPreview(Ljava/lang/String;)V

    .line 270
    return-void
.end method

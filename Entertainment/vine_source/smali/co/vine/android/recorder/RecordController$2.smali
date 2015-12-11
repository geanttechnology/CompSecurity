.class Lco/vine/android/recorder/RecordController$2;
.super Lco/vine/android/recorder/SwCombiningRunnable;
.source "RecordController.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/recorder/RecordController;->writeToFile(Ljava/util/ArrayList;[BLco/vine/android/recorder/AudioArray;ZI)Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/recorder/RecordController;


# direct methods
.method constructor <init>(Lco/vine/android/recorder/RecordController;Lco/vine/android/recorder/RecordingFile;ZLco/vine/android/recorder/AudioArray;[BLjava/util/ArrayList;Lco/vine/android/recorder/SwVineFrameRecorder;Lco/vine/android/recorder/BaseFinishProcessTask;Landroid/graphics/Bitmap;Lcom/googlecode/javacv/cpp/opencv_core$IplImage;)V
    .locals 10
    .param p2, "x0"    # Lco/vine/android/recorder/RecordingFile;
    .param p3, "x1"    # Z
    .param p4, "x2"    # Lco/vine/android/recorder/AudioArray;
    .param p5, "x3"    # [B
    .param p7, "x5"    # Lco/vine/android/recorder/SwVineFrameRecorder;
    .param p8, "x6"    # Lco/vine/android/recorder/BaseFinishProcessTask;
    .param p9, "x7"    # Landroid/graphics/Bitmap;
    .param p10, "x8"    # Lcom/googlecode/javacv/cpp/opencv_core$IplImage;

    .prologue
    .line 415
    .local p6, "x4":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/recorder/RecordSegment;>;"
    iput-object p1, p0, Lco/vine/android/recorder/RecordController$2;->this$0:Lco/vine/android/recorder/RecordController;

    move-object v0, p0

    move-object v1, p2

    move v2, p3

    move-object v3, p4

    move-object v4, p5

    move-object/from16 v5, p6

    move-object/from16 v6, p7

    move-object/from16 v7, p8

    move-object/from16 v8, p9

    move-object/from16 v9, p10

    invoke-direct/range {v0 .. v9}, Lco/vine/android/recorder/SwCombiningRunnable;-><init>(Lco/vine/android/recorder/RecordingFile;ZLco/vine/android/recorder/AudioArray;[BLjava/util/ArrayList;Lco/vine/android/recorder/SwVineFrameRecorder;Lco/vine/android/recorder/BaseFinishProcessTask;Landroid/graphics/Bitmap;Lcom/googlecode/javacv/cpp/opencv_core$IplImage;)V

    return-void
.end method

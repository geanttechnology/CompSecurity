.class public Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;
.super Ljava/lang/Object;
.source "RecordConfigUtils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/recorder/RecordConfigUtils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RecordConfig"
.end annotation


# static fields
.field private static final CAMERA_SWITCH_ENABLED:Z = true

.field public static final DISABLE_FACE_RECOGNITION:Z

.field private static final FLASH_SWITCH_ENABLED:Z = false

.field public static final FORCE_AUTO_FOCUS:Z

.field private static final INITIAL_VIDEO_BUFFER_COUNT:I = 0xaa

.field private static final INVALID_ASPECT_RATIO:F = 0.0f

.field public static final IS_ZERO_INDEX_BASED_ZOOM:Z

.field private static final KEY_ASPECT_RATIO_OVERRIDE_bf:Ljava/lang/String; = "aspect_ratio_or_bf"

.field private static final KEY_ASPECT_RATIO_OVERRIDE_ff:Ljava/lang/String; = "aspect_ratio_or_ff"

.field private static final KEY_BUFFER_SIZE:Ljava/lang/String; = "bufferSize"

.field private static final KEY_CAMERA_SWITCH_ENABLED:Ljava/lang/String; = "cameraSwitchEnabled"

.field private static final KEY_FLASH_SWITCH_ENABLED:Ljava/lang/String; = "flashSwitchEnabled"

.field private static final KEY_FRAME_RATE:Ljava/lang/String; = "frameRate"

.field private static final KEY_MAX_DURATION:Ljava/lang/String; = "maxDuration"

.field private static final KEY_PREALLOCATE_BUFFER:Ljava/lang/String; = "preAllocateBuffer"

.field private static final KEY_PREF:Ljava/lang/String; = "RecordConfig"

.field private static final KEY_PREVIEW_HEIGHT:Ljava/lang/String; = "previewHeight"

.field private static final KEY_PREVIEW_WIDTH:Ljava/lang/String; = "previewWidth"

.field private static final KEY_PRE_RATIO:Ljava/lang/String; = "pre_ratio"

.field private static final KEY_PROCESS_ON_SD:Ljava/lang/String; = "processOnSD"

.field private static final KEY_RECORDING_ENABLED:Ljava/lang/String; = "recordingEnabled"

.field private static final KEY_SET_RECORDING_HINT_bf:Ljava/lang/String; = "set_recording_hint_bf"

.field private static final KEY_SET_RECORDING_HINT_ff:Ljava/lang/String; = "set_recording_hint_ff"

.field private static final KEY_TARGET_SIZE:Ljava/lang/String; = "targetSize"

.field private static final KEY_UPDATE_TIME:Ljava/lang/String; = "updateTime"

.field private static final KEY_ZOOM_ENABLED:Ljava/lang/String; = "zoomEnabled"

.field private static final PREVIEW_WIDTH:I = 0x280

.field private static final PRE_ALLOCATE_RATIO:F = 1.5f

.field private static final PROCESS_ON_SD_CARD:Z

.field private static final PROGRESS_MAX:I = 0x1770

.field private static final SET_RECORDING_HINT_bf:Z = true

.field private static final SET_RECORDING_HINT_ff:Z = true

.field public static final SHOULD_DISABLE_BACKFACING_SET_RECORDING_HINT:Z

.field public static final SHOULD_DISABLE_FRONTFACING_SET_RECORDING_HINT:Z

.field public static final SHOULD_FORCE_SMOOTH_ZOOM:Z

.field public static final SHOULD_OVERRIDED_FRONTFACING_ASPECT_RATIO:Z = false

.field public static final SHOULD_OVERRIDE_BACKFACING_ASPECT_RATIO:Z = false

.field public static final SHOULD_SHOW_ZOOM_SLIDER:Z

.field private static final SIX_SECONDS:F = 6000.0f

.field private static final TARGET_FRAME_RATE:I = 0x1e

.field private static final ZOOM_ENABLED:Z = true


# instance fields
.field public final backFacingAspectRatioOverride:F

.field public final backFacingRecordingHint:Z

.field public final bufferCount:I

.field public final cameraSwitchEnabled:Z

.field public final flashSwitchEnabled:Z

.field public final frontFacingAspectRatioOverride:F

.field public final frontFacingRecordingHint:Z

.field public final highQuality:Z

.field public final isZoomButtonEnabled:Z

.field public final maxDuration:I

.field public final memRatio:D

.field public final preAllocRatio:D

.field public final preAllocateBuffer:Z

.field public final previewHeight:I

.field public final previewWidth:I

.field public final processDir:Ljava/io/File;

.field public final processOnSd:Z

.field public final recordingEnabled:Z

.field public final targetFrameRate:I

.field public final targetSize:I

.field public final zoomEnabled:Z


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 77
    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    const-string v3, "SM-C115"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    if-ne v0, v3, :cond_5

    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string v3, "SM-C11"

    invoke-virtual {v0, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_5

    move v0, v1

    :goto_0
    sput-boolean v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->SHOULD_FORCE_SMOOTH_ZOOM:Z

    .line 80
    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    const-string v3, "SM-C115"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    if-ne v0, v3, :cond_6

    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string v3, "SM-C11"

    invoke-virtual {v0, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_6

    move v0, v1

    :goto_1
    sput-boolean v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->DISABLE_FACE_RECOGNITION:Z

    .line 83
    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string v3, "Nexus 5"

    invoke-virtual {v0, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string v3, "SM-N900"

    invoke-virtual {v0, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_7

    :cond_0
    move v0, v1

    :goto_2
    sput-boolean v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->SHOULD_DISABLE_FRONTFACING_SET_RECORDING_HINT:Z

    .line 87
    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string v3, "SGH-I747"

    invoke-virtual {v0, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string v3, "SGH-T999"

    invoke-virtual {v0, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string v3, "SGH-N064"

    invoke-virtual {v0, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string v3, "SC-06D"

    invoke-virtual {v0, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string v3, "SCH-J021"

    invoke-virtual {v0, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string v3, "SCH-R530"

    invoke-virtual {v0, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string v3, "SCH-I535"

    invoke-virtual {v0, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string v3, "SCL21"

    invoke-virtual {v0, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string v3, "SCH-S960L"

    invoke-virtual {v0, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_8

    :cond_1
    move v0, v1

    :goto_3
    sput-boolean v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->SHOULD_DISABLE_BACKFACING_SET_RECORDING_HINT:Z

    .line 98
    sget-boolean v0, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-nez v0, :cond_2

    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string v3, "SM-C11"

    invoke-virtual {v0, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_9

    :cond_2
    move v0, v1

    :goto_4
    sput-boolean v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->SHOULD_SHOW_ZOOM_SLIDER:Z

    .line 101
    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    const-string v3, "SM-C115"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    if-ne v0, v3, :cond_a

    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string v3, "SM-C11"

    invoke-virtual {v0, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_a

    move v0, v1

    :goto_5
    sput-boolean v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->IS_ZERO_INDEX_BASED_ZOOM:Z

    .line 111
    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string v3, "GT-I9505"

    invoke-virtual {v0, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string v3, "GT-I9506"

    invoke-virtual {v0, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string v3, "GT-I9500"

    invoke-virtual {v0, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string v3, "SGH-I337"

    invoke-virtual {v0, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string v3, "SGH-M919"

    invoke-virtual {v0, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string v3, "SCH-I545"

    invoke-virtual {v0, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string v3, "SPH-L720"

    invoke-virtual {v0, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string v3, "GT-I9508"

    invoke-virtual {v0, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string v3, "SHV-E300"

    invoke-virtual {v0, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string v3, "SCH-R970"

    invoke-virtual {v0, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string v3, "SM-N900"

    invoke-virtual {v0, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string v3, "LG-D801"

    invoke-virtual {v0, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_4

    :cond_3
    move v2, v1

    :cond_4
    sput-boolean v2, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->FORCE_AUTO_FOCUS:Z

    .line 126
    sget-boolean v0, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    sput-boolean v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->PROCESS_ON_SD_CARD:Z

    return-void

    :cond_5
    move v0, v2

    .line 77
    goto/16 :goto_0

    :cond_6
    move v0, v2

    .line 80
    goto/16 :goto_1

    :cond_7
    move v0, v2

    .line 83
    goto/16 :goto_2

    :cond_8
    move v0, v2

    .line 87
    goto/16 :goto_3

    :cond_9
    move v0, v2

    .line 98
    goto/16 :goto_4

    :cond_a
    move v0, v2

    .line 101
    goto/16 :goto_5
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 14
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v13, 0x0

    const-wide/high16 v11, 0x3ff0000000000000L    # 1.0

    const-wide v7, 0x3fe999999999999aL    # 0.8

    const/4 v4, 0x0

    const/4 v3, 0x1

    .line 183
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 184
    invoke-static {p1, v3}, Lco/vine/android/util/SystemUtil;->getMemoryRatio(Landroid/content/Context;Z)D

    move-result-wide v5

    iput-wide v5, p0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->memRatio:D

    .line 186
    iget-wide v5, p0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->memRatio:D

    cmpl-double v5, v5, v11

    if-ltz v5, :cond_1

    move v0, v3

    .line 189
    .local v0, "defaultRecordingEnabled":Z
    :goto_0
    iput-boolean v3, p0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->highQuality:Z

    .line 191
    const-string v5, "RecordConfig"

    invoke-virtual {p1, v5, v4}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v2

    .line 192
    .local v2, "sp":Landroid/content/SharedPreferences;
    iget-wide v5, p0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->memRatio:D

    const-wide/high16 v9, 0x4000000000000000L    # 2.0

    cmpl-double v5, v5, v9

    if-ltz v5, :cond_2

    const-string v5, "pre_ratio"

    const/high16 v6, 0x3fc00000    # 1.5f

    invoke-interface {v2, v5, v6}, Landroid/content/SharedPreferences;->getFloat(Ljava/lang/String;F)F

    move-result v5

    float-to-double v5, v5

    :goto_1
    iput-wide v5, p0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->preAllocRatio:D

    .line 193
    const-string v5, "preAllocateBuffer"

    invoke-interface {v2, v5, v3}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v5

    iput-boolean v5, p0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->preAllocateBuffer:Z

    .line 194
    const-string v5, "recordingEnabled"

    invoke-interface {v2, v5, v0}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v5

    iput-boolean v5, p0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->recordingEnabled:Z

    .line 195
    const-string v5, "zoomEnabled"

    invoke-interface {v2, v5, v3}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v5

    iput-boolean v5, p0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->zoomEnabled:Z

    .line 196
    sget-boolean v5, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->PROCESS_ON_SD_CARD:Z

    if-nez v5, :cond_0

    const-string v5, "processOnSD"

    sget-boolean v6, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->PROCESS_ON_SD_CARD:Z

    invoke-interface {v2, v5, v6}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v5

    if-eqz v5, :cond_3

    :cond_0
    const-string v5, "mounted"

    invoke-static {}, Landroid/os/Environment;->getExternalStorageState()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_3

    move v5, v3

    :goto_2
    iput-boolean v5, p0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->processOnSd:Z

    .line 197
    iget-boolean v5, p0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->processOnSd:Z

    if-eqz v5, :cond_4

    # getter for: Lco/vine/android/recorder/RecordConfigUtils;->FOLDER_ROOT_PROCESS_DEBUG:Ljava/io/File;
    invoke-static {}, Lco/vine/android/recorder/RecordConfigUtils;->access$000()Ljava/io/File;

    move-result-object v5

    :goto_3
    iput-object v5, p0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->processDir:Ljava/io/File;

    .line 198
    const-string v5, "cameraSwitchEnabled"

    invoke-interface {v2, v5, v3}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v5

    if-eqz v5, :cond_5

    invoke-static {}, Lco/vine/android/recorder/CameraManager;->hasFrontFacingCamera()Z

    move-result v5

    if-eqz v5, :cond_5

    invoke-static {}, Lco/vine/android/recorder/CameraManager;->hasBackFacingCamera()Z

    move-result v5

    if-eqz v5, :cond_5

    move v5, v3

    :goto_4
    iput-boolean v5, p0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->cameraSwitchEnabled:Z

    .line 199
    const-string v5, "flashSwitchEnabled"

    invoke-interface {v2, v5, v4}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v5

    iput-boolean v5, p0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->flashSwitchEnabled:Z

    .line 200
    const-string v5, "frameRate"

    const/16 v6, 0x1e

    invoke-interface {v2, v5, v6}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v5

    iput v5, p0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->targetFrameRate:I

    .line 201
    const-string v5, "targetSize"

    const/16 v6, 0x1e0

    invoke-interface {v2, v5, v6}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v5

    iput v5, p0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->targetSize:I

    .line 202
    const-string v5, "previewWidth"

    const/16 v6, 0x280

    invoke-interface {v2, v5, v6}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v6

    iget-boolean v5, p0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->highQuality:Z

    if-eqz v5, :cond_6

    move v5, v3

    :goto_5
    div-int v5, v6, v5

    iput v5, p0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->previewWidth:I

    .line 203
    const-string v5, "previewHeight"

    const/16 v6, 0x1e0

    invoke-interface {v2, v5, v6}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v6

    iget-boolean v5, p0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->highQuality:Z

    if-eqz v5, :cond_7

    move v5, v3

    :goto_6
    div-int v5, v6, v5

    iput v5, p0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->previewHeight:I

    .line 205
    const-string v5, "maxDuration"

    const/16 v6, 0x1770

    invoke-interface {v2, v5, v6}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v5

    iput v5, p0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->maxDuration:I

    .line 207
    const-string v5, "bufferSize"

    const/16 v6, 0xaa

    invoke-interface {v2, v5, v6}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v5

    int-to-float v5, v5

    iget v6, p0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->maxDuration:I

    int-to-float v6, v6

    const v9, 0x45bb8000    # 6000.0f

    div-float/2addr v6, v9

    mul-float/2addr v5, v6

    float-to-int v1, v5

    .line 209
    .local v1, "initialBufferCount":I
    iget-wide v5, p0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->memRatio:D

    cmpl-double v5, v5, v11

    if-lez v5, :cond_8

    .end local v1    # "initialBufferCount":I
    :goto_7
    iput v1, p0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->bufferCount:I

    .line 210
    const-string v5, "aspect_ratio_or_ff"

    invoke-interface {v2, v5, v13}, Landroid/content/SharedPreferences;->getFloat(Ljava/lang/String;F)F

    move-result v5

    iput v5, p0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->frontFacingAspectRatioOverride:F

    .line 211
    const-string v5, "aspect_ratio_or_bf"

    invoke-interface {v2, v5, v13}, Landroid/content/SharedPreferences;->getFloat(Ljava/lang/String;F)F

    move-result v5

    iput v5, p0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->backFacingAspectRatioOverride:F

    .line 212
    sget-boolean v5, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->SHOULD_DISABLE_FRONTFACING_SET_RECORDING_HINT:Z

    if-eqz v5, :cond_9

    move v5, v4

    :goto_8
    iput-boolean v5, p0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->frontFacingRecordingHint:Z

    .line 213
    sget-boolean v5, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->SHOULD_DISABLE_BACKFACING_SET_RECORDING_HINT:Z

    if-eqz v5, :cond_a

    move v5, v4

    :goto_9
    iput-boolean v5, p0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->backFacingRecordingHint:Z

    .line 215
    sget-boolean v5, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->SHOULD_SHOW_ZOOM_SLIDER:Z

    if-eqz v5, :cond_b

    iget-boolean v5, p0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->zoomEnabled:Z

    if-eqz v5, :cond_b

    :goto_a
    iput-boolean v3, p0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->isZoomButtonEnabled:Z

    .line 216
    return-void

    .end local v0    # "defaultRecordingEnabled":Z
    .end local v2    # "sp":Landroid/content/SharedPreferences;
    :cond_1
    move v0, v4

    .line 186
    goto/16 :goto_0

    .restart local v0    # "defaultRecordingEnabled":Z
    .restart local v2    # "sp":Landroid/content/SharedPreferences;
    :cond_2
    move-wide v5, v7

    .line 192
    goto/16 :goto_1

    :cond_3
    move v5, v4

    .line 196
    goto/16 :goto_2

    .line 197
    :cond_4
    invoke-virtual {p1}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object v5

    goto/16 :goto_3

    :cond_5
    move v5, v4

    .line 198
    goto/16 :goto_4

    .line 202
    :cond_6
    const/4 v5, 0x2

    goto :goto_5

    .line 203
    :cond_7
    const/4 v5, 0x2

    goto :goto_6

    .line 209
    .restart local v1    # "initialBufferCount":I
    :cond_8
    int-to-double v5, v1

    mul-double/2addr v5, v7

    double-to-int v1, v5

    goto :goto_7

    .line 212
    .end local v1    # "initialBufferCount":I
    :cond_9
    const-string v5, "set_recording_hint_ff"

    invoke-interface {v2, v5, v3}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v5

    goto :goto_8

    .line 213
    :cond_a
    const-string v5, "set_recording_hint_bf"

    invoke-interface {v2, v5, v3}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v5

    goto :goto_9

    :cond_b
    move v3, v4

    .line 215
    goto :goto_a
.end method

.method public static needsUpdate(Landroid/content/Context;)Z
    .locals 7
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v0, 0x0

    .line 219
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    const-string v3, "RecordConfig"

    invoke-virtual {p0, v3, v0}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v3

    const-string v4, "updateTime"

    const-wide/16 v5, 0x0

    invoke-interface {v3, v4, v5, v6}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v3

    sub-long/2addr v1, v3

    const-wide/32 v3, 0x493e0

    cmp-long v1, v1, v3

    if-lez v1, :cond_0

    const/4 v0, 0x1

    :cond_0
    return v0
.end method

.method public static declared-synchronized update(Landroid/content/Context;Lorg/json/JSONObject;)Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;
    .locals 7
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "config"    # Lorg/json/JSONObject;

    .prologue
    .line 223
    const-class v3, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    monitor-enter v3

    :try_start_0
    const-string v2, "Update config: {}."

    invoke-static {v2, p1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 224
    new-instance v1, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    invoke-direct {v1, p0}, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;-><init>(Landroid/content/Context;)V

    .line 225
    .local v1, "oldConfig":Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;
    const-string v2, "RecordConfig"

    const/4 v4, 0x0

    invoke-virtual {p0, v2, v4}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v2

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 226
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v2, "preAllocateBuffer"

    const-string v4, "preAllocateBuffer"

    iget-boolean v5, v1, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->preAllocateBuffer:Z

    invoke-virtual {p1, v4, v5}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v4

    invoke-interface {v0, v2, v4}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 227
    const-string v2, "recordingEnabled"

    const-string v4, "recordingEnabled"

    iget-boolean v5, v1, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->recordingEnabled:Z

    invoke-virtual {p1, v4, v5}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v4

    invoke-interface {v0, v2, v4}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 228
    const-string v2, "zoomEnabled"

    const-string v4, "zoomEnabled"

    iget-boolean v5, v1, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->zoomEnabled:Z

    invoke-virtual {p1, v4, v5}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v4

    invoke-interface {v0, v2, v4}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 229
    const-string v2, "cameraSwitchEnabled"

    const-string v4, "cameraSwitchEnabled"

    iget-boolean v5, v1, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->cameraSwitchEnabled:Z

    invoke-virtual {p1, v4, v5}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v4

    invoke-interface {v0, v2, v4}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 230
    const-string v2, "flashSwitchEnabled"

    const-string v4, "flashSwitchEnabled"

    iget-boolean v5, v1, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->flashSwitchEnabled:Z

    invoke-virtual {p1, v4, v5}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v4

    invoke-interface {v0, v2, v4}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 231
    const-string v2, "processOnSD"

    const-string v4, "processOnSD"

    iget-boolean v5, v1, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->processOnSd:Z

    invoke-virtual {p1, v4, v5}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v4

    invoke-interface {v0, v2, v4}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 232
    const-string v2, "set_recording_hint_ff"

    const-string v4, "set_recording_hint_ff"

    iget-boolean v5, v1, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->frontFacingRecordingHint:Z

    invoke-virtual {p1, v4, v5}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v4

    invoke-interface {v0, v2, v4}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 233
    const-string v2, "set_recording_hint_bf"

    const-string v4, "set_recording_hint_bf"

    iget-boolean v5, v1, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->backFacingRecordingHint:Z

    invoke-virtual {p1, v4, v5}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v4

    invoke-interface {v0, v2, v4}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 234
    const-string v2, "frameRate"

    const-string v4, "frameRate"

    iget v5, v1, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->targetFrameRate:I

    invoke-virtual {p1, v4, v5}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;I)I

    move-result v4

    invoke-interface {v0, v2, v4}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 235
    const-string v2, "targetSize"

    const-string v4, "targetSize"

    iget v5, v1, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->targetSize:I

    invoke-virtual {p1, v4, v5}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;I)I

    move-result v4

    invoke-interface {v0, v2, v4}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 236
    const-string v2, "previewWidth"

    const-string v4, "previewWidth"

    iget v5, v1, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->previewWidth:I

    invoke-virtual {p1, v4, v5}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;I)I

    move-result v4

    invoke-interface {v0, v2, v4}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 237
    const-string v2, "previewHeight"

    const-string v4, "previewHeight"

    iget v5, v1, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->previewHeight:I

    invoke-virtual {p1, v4, v5}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;I)I

    move-result v4

    invoke-interface {v0, v2, v4}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 238
    const-string v2, "bufferSize"

    const-string v4, "bufferSize"

    iget v5, v1, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->bufferCount:I

    invoke-virtual {p1, v4, v5}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;I)I

    move-result v4

    invoke-interface {v0, v2, v4}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 239
    const-string v2, "maxDuration"

    const-string v4, "maxDuration"

    iget v5, v1, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->maxDuration:I

    invoke-virtual {p1, v4, v5}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;I)I

    move-result v4

    invoke-interface {v0, v2, v4}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 240
    const-string v2, "pre_ratio"

    const-string v4, "pre_ratio"

    iget-wide v5, v1, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->preAllocRatio:D

    invoke-virtual {p1, v4, v5, v6}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;D)D

    move-result-wide v4

    double-to-float v4, v4

    invoke-interface {v0, v2, v4}, Landroid/content/SharedPreferences$Editor;->putFloat(Ljava/lang/String;F)Landroid/content/SharedPreferences$Editor;

    .line 241
    const-string v2, "aspect_ratio_or_ff"

    const-string v4, "aspect_ratio_or_ff"

    iget v5, v1, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->frontFacingAspectRatioOverride:F

    float-to-double v5, v5

    invoke-virtual {p1, v4, v5, v6}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;D)D

    move-result-wide v4

    double-to-float v4, v4

    invoke-interface {v0, v2, v4}, Landroid/content/SharedPreferences$Editor;->putFloat(Ljava/lang/String;F)Landroid/content/SharedPreferences$Editor;

    .line 242
    const-string v2, "aspect_ratio_or_bf"

    const-string v4, "aspect_ratio_or_bf"

    iget v5, v1, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->backFacingAspectRatioOverride:F

    float-to-double v5, v5

    invoke-virtual {p1, v4, v5, v6}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;D)D

    move-result-wide v4

    double-to-float v4, v4

    invoke-interface {v0, v2, v4}, Landroid/content/SharedPreferences$Editor;->putFloat(Ljava/lang/String;F)Landroid/content/SharedPreferences$Editor;

    .line 243
    const-string v2, "updateTime"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    invoke-interface {v0, v2, v4, v5}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 244
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 245
    new-instance v2, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    invoke-direct {v2, p0}, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;-><init>(Landroid/content/Context;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v3

    return-object v2

    .line 223
    .end local v0    # "editor":Landroid/content/SharedPreferences$Editor;
    .end local v1    # "oldConfig":Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;
    :catchall_0
    move-exception v2

    monitor-exit v3

    throw v2
.end method

.class Lco/vine/android/InlineRecorderManager$StartInlineRecording;
.super Ljava/lang/Object;
.source "InlineRecorderManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/InlineRecorderManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "StartInlineRecording"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/InlineRecorderManager;


# direct methods
.method private constructor <init>(Lco/vine/android/InlineRecorderManager;)V
    .locals 0

    .prologue
    .line 246
    iput-object p1, p0, Lco/vine/android/InlineRecorderManager$StartInlineRecording;->this$0:Lco/vine/android/InlineRecorderManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lco/vine/android/InlineRecorderManager;Lco/vine/android/InlineRecorderManager$1;)V
    .locals 0
    .param p1, "x0"    # Lco/vine/android/InlineRecorderManager;
    .param p2, "x1"    # Lco/vine/android/InlineRecorderManager$1;

    .prologue
    .line 246
    invoke-direct {p0, p1}, Lco/vine/android/InlineRecorderManager$StartInlineRecording;-><init>(Lco/vine/android/InlineRecorderManager;)V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 249
    iget-object v0, p0, Lco/vine/android/InlineRecorderManager$StartInlineRecording;->this$0:Lco/vine/android/InlineRecorderManager;

    const/4 v1, 0x1

    # invokes: Lco/vine/android/InlineRecorderManager;->toggleRecorder(Z)V
    invoke-static {v0, v1}, Lco/vine/android/InlineRecorderManager;->access$200(Lco/vine/android/InlineRecorderManager;Z)V

    .line 250
    iget-object v0, p0, Lco/vine/android/InlineRecorderManager$StartInlineRecording;->this$0:Lco/vine/android/InlineRecorderManager;

    # getter for: Lco/vine/android/InlineRecorderManager;->mFinishProgressView:Lco/vine/android/recorder/ProgressView;
    invoke-static {v0}, Lco/vine/android/InlineRecorderManager;->access$300(Lco/vine/android/InlineRecorderManager;)Lco/vine/android/recorder/ProgressView;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/ProgressView;->setVisibility(I)V

    .line 251
    iget-object v0, p0, Lco/vine/android/InlineRecorderManager$StartInlineRecording;->this$0:Lco/vine/android/InlineRecorderManager;

    # getter for: Lco/vine/android/InlineRecorderManager;->mFinishProgressView:Lco/vine/android/recorder/ProgressView;
    invoke-static {v0}, Lco/vine/android/InlineRecorderManager;->access$300(Lco/vine/android/InlineRecorderManager;)Lco/vine/android/recorder/ProgressView;

    move-result-object v0

    const/high16 v1, 0x3f800000    # 1.0f

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/ProgressView;->setAlpha(F)V

    .line 252
    iget-object v0, p0, Lco/vine/android/InlineRecorderManager$StartInlineRecording;->this$0:Lco/vine/android/InlineRecorderManager;

    # getter for: Lco/vine/android/InlineRecorderManager;->mFinishProgressView:Lco/vine/android/recorder/ProgressView;
    invoke-static {v0}, Lco/vine/android/InlineRecorderManager;->access$300(Lco/vine/android/InlineRecorderManager;)Lco/vine/android/recorder/ProgressView;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/ProgressView;->setProgressRatio(F)V

    .line 253
    return-void
.end method

.class Lco/vine/android/RecordingFragment$5;
.super Ljava/lang/Object;
.source "RecordingFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/RecordingFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/RecordingFragment;


# direct methods
.method constructor <init>(Lco/vine/android/RecordingFragment;)V
    .locals 0

    .prologue
    .line 165
    iput-object p1, p0, Lco/vine/android/RecordingFragment$5;->this$0:Lco/vine/android/RecordingFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 168
    iget-object v2, p0, Lco/vine/android/RecordingFragment$5;->this$0:Lco/vine/android/RecordingFragment;

    invoke-virtual {v2}, Lco/vine/android/RecordingFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lco/vine/android/AbstractRecordingActivity;

    .line 169
    .local v0, "activity":Lco/vine/android/AbstractRecordingActivity;
    if-eqz v0, :cond_3

    .line 170
    iget-object v2, p0, Lco/vine/android/RecordingFragment$5;->this$0:Lco/vine/android/RecordingFragment;

    # getter for: Lco/vine/android/RecordingFragment;->mGridButton:Landroid/widget/ToggleButton;
    invoke-static {v2}, Lco/vine/android/RecordingFragment;->access$600(Lco/vine/android/RecordingFragment;)Landroid/widget/ToggleButton;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/ToggleButton;->isChecked()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 171
    iget-object v2, p0, Lco/vine/android/RecordingFragment$5;->this$0:Lco/vine/android/RecordingFragment;

    # getter for: Lco/vine/android/RecordingFragment;->mGridButton:Landroid/widget/ToggleButton;
    invoke-static {v2}, Lco/vine/android/RecordingFragment;->access$600(Lco/vine/android/RecordingFragment;)Landroid/widget/ToggleButton;

    move-result-object v2

    invoke-virtual {v2, v3}, Landroid/widget/ToggleButton;->setChecked(Z)V

    .line 173
    :cond_0
    iget-object v2, p0, Lco/vine/android/RecordingFragment$5;->this$0:Lco/vine/android/RecordingFragment;

    # getter for: Lco/vine/android/RecordingFragment;->mGhostButton:Landroid/widget/ToggleButton;
    invoke-static {v2}, Lco/vine/android/RecordingFragment;->access$700(Lco/vine/android/RecordingFragment;)Landroid/widget/ToggleButton;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/ToggleButton;->isChecked()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 174
    iget-object v2, p0, Lco/vine/android/RecordingFragment$5;->this$0:Lco/vine/android/RecordingFragment;

    # getter for: Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;
    invoke-static {v2}, Lco/vine/android/RecordingFragment;->access$800(Lco/vine/android/RecordingFragment;)Lco/vine/android/recorder/VineRecorder;

    move-result-object v2

    invoke-virtual {v2, v3}, Lco/vine/android/recorder/VineRecorder;->setGhostMode(Z)Z

    .line 176
    :cond_1
    iget-object v2, p0, Lco/vine/android/RecordingFragment$5;->this$0:Lco/vine/android/RecordingFragment;

    # getter for: Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;
    invoke-static {v2}, Lco/vine/android/RecordingFragment;->access$800(Lco/vine/android/RecordingFragment;)Lco/vine/android/recorder/VineRecorder;

    move-result-object v2

    iget-object v2, v2, Lco/vine/android/recorder/VineRecorder;->grabThumbnailsRunnable:Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;

    if-eqz v2, :cond_2

    .line 177
    iget-object v2, p0, Lco/vine/android/RecordingFragment$5;->this$0:Lco/vine/android/RecordingFragment;

    # getter for: Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;
    invoke-static {v2}, Lco/vine/android/RecordingFragment;->access$800(Lco/vine/android/RecordingFragment;)Lco/vine/android/recorder/VineRecorder;

    move-result-object v2

    iget-object v1, v2, Lco/vine/android/recorder/VineRecorder;->grabThumbnailsRunnable:Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;

    .line 178
    .local v1, "r":Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;
    invoke-virtual {v1}, Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;->run()V

    .line 179
    iget-object v2, p0, Lco/vine/android/RecordingFragment$5;->this$0:Lco/vine/android/RecordingFragment;

    # getter for: Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;
    invoke-static {v2}, Lco/vine/android/RecordingFragment;->access$800(Lco/vine/android/RecordingFragment;)Lco/vine/android/recorder/VineRecorder;

    move-result-object v2

    const/4 v3, 0x0

    iput-object v3, v2, Lco/vine/android/recorder/VineRecorder;->grabThumbnailsRunnable:Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;

    .line 181
    .end local v1    # "r":Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;
    :cond_2
    iget-object v2, p0, Lco/vine/android/RecordingFragment$5;->this$0:Lco/vine/android/RecordingFragment;

    # getter for: Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;
    invoke-static {v2}, Lco/vine/android/RecordingFragment;->access$800(Lco/vine/android/RecordingFragment;)Lco/vine/android/recorder/VineRecorder;

    move-result-object v2

    invoke-virtual {v2}, Lco/vine/android/recorder/VineRecorder;->isSavedSession()Z

    move-result v2

    if-eqz v2, :cond_4

    iget-object v2, p0, Lco/vine/android/RecordingFragment$5;->this$0:Lco/vine/android/RecordingFragment;

    # getter for: Lco/vine/android/RecordingFragment;->mRecorder:Lco/vine/android/recorder/VineRecorder;
    invoke-static {v2}, Lco/vine/android/RecordingFragment;->access$800(Lco/vine/android/RecordingFragment;)Lco/vine/android/recorder/VineRecorder;

    move-result-object v2

    invoke-virtual {v2}, Lco/vine/android/recorder/VineRecorder;->getFile()Lco/vine/android/recorder/RecordingFile;

    move-result-object v2

    iget-object v2, v2, Lco/vine/android/recorder/RecordingFile;->folder:Ljava/io/File;

    invoke-virtual {v2}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v2

    :goto_0
    invoke-virtual {v0, v2}, Lco/vine/android/AbstractRecordingActivity;->showDrafts(Ljava/lang/String;)V

    .line 185
    :cond_3
    return-void

    .line 181
    :cond_4
    const-string v2, "camera_preview"

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    goto :goto_0
.end method

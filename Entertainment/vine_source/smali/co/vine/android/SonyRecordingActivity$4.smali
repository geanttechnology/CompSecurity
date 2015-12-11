.class Lco/vine/android/SonyRecordingActivity$4;
.super Ljava/lang/Object;
.source "SonyRecordingActivity.java"

# interfaces
.implements Lcom/sonymobile/camera/addon/capturingmode/CapturingModeSelector$OnModeFinishListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/SonyRecordingActivity;->setupSonyOverlay()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/SonyRecordingActivity;


# direct methods
.method constructor <init>(Lco/vine/android/SonyRecordingActivity;)V
    .locals 0

    .prologue
    .line 143
    iput-object p1, p0, Lco/vine/android/SonyRecordingActivity$4;->this$0:Lco/vine/android/SonyRecordingActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onModeFinish()V
    .locals 2

    .prologue
    .line 146
    iget-object v0, p0, Lco/vine/android/SonyRecordingActivity$4;->this$0:Lco/vine/android/SonyRecordingActivity;

    # getter for: Lco/vine/android/SonyRecordingActivity;->mSonyCapturingModeSelector:Lcom/sonymobile/camera/addon/capturingmode/CapturingModeSelector;
    invoke-static {v0}, Lco/vine/android/SonyRecordingActivity;->access$000(Lco/vine/android/SonyRecordingActivity;)Lcom/sonymobile/camera/addon/capturingmode/CapturingModeSelector;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 147
    iget-object v0, p0, Lco/vine/android/SonyRecordingActivity$4;->this$0:Lco/vine/android/SonyRecordingActivity;

    # getter for: Lco/vine/android/SonyRecordingActivity;->mSonyCapturingModeSelector:Lcom/sonymobile/camera/addon/capturingmode/CapturingModeSelector;
    invoke-static {v0}, Lco/vine/android/SonyRecordingActivity;->access$000(Lco/vine/android/SonyRecordingActivity;)Lcom/sonymobile/camera/addon/capturingmode/CapturingModeSelector;

    move-result-object v0

    invoke-virtual {v0}, Lcom/sonymobile/camera/addon/capturingmode/CapturingModeSelector;->close()V

    .line 148
    iget-object v0, p0, Lco/vine/android/SonyRecordingActivity$4;->this$0:Lco/vine/android/SonyRecordingActivity;

    # getter for: Lco/vine/android/SonyRecordingActivity;->mSonyModeSelectorButton:Landroid/widget/ImageView;
    invoke-static {v0}, Lco/vine/android/SonyRecordingActivity;->access$200(Lco/vine/android/SonyRecordingActivity;)Landroid/widget/ImageView;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 150
    :cond_0
    return-void
.end method

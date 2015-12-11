.class Lco/vine/android/recorder/InlineVineRecorder$3;
.super Ljava/lang/Object;
.source "InlineVineRecorder.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/recorder/InlineVineRecorder;->adjustBoundaries(Lco/vine/android/recorder/CameraSetting;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/recorder/InlineVineRecorder;

.field final synthetic val$cameraViewParams:Landroid/widget/RelativeLayout$LayoutParams;

.field final synthetic val$topMaskParams:Landroid/widget/RelativeLayout$LayoutParams;


# direct methods
.method constructor <init>(Lco/vine/android/recorder/InlineVineRecorder;Landroid/widget/RelativeLayout$LayoutParams;Landroid/widget/RelativeLayout$LayoutParams;)V
    .locals 0

    .prologue
    .line 141
    iput-object p1, p0, Lco/vine/android/recorder/InlineVineRecorder$3;->this$0:Lco/vine/android/recorder/InlineVineRecorder;

    iput-object p2, p0, Lco/vine/android/recorder/InlineVineRecorder$3;->val$topMaskParams:Landroid/widget/RelativeLayout$LayoutParams;

    iput-object p3, p0, Lco/vine/android/recorder/InlineVineRecorder$3;->val$cameraViewParams:Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 144
    iget-object v1, p0, Lco/vine/android/recorder/InlineVineRecorder$3;->this$0:Lco/vine/android/recorder/InlineVineRecorder;

    iget-object v0, v1, Lco/vine/android/recorder/InlineVineRecorder;->mTopMaskView:Landroid/view/View;

    .line 145
    .local v0, "view":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 146
    iget-object v1, p0, Lco/vine/android/recorder/InlineVineRecorder$3;->val$topMaskParams:Landroid/widget/RelativeLayout$LayoutParams;

    invoke-virtual {v0, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 149
    :cond_0
    iget-object v1, p0, Lco/vine/android/recorder/InlineVineRecorder$3;->this$0:Lco/vine/android/recorder/InlineVineRecorder;

    iget-object v0, v1, Lco/vine/android/recorder/InlineVineRecorder;->mCameraView:Landroid/view/View;

    .line 150
    if-eqz v0, :cond_1

    .line 151
    iget-object v1, p0, Lco/vine/android/recorder/InlineVineRecorder$3;->val$cameraViewParams:Landroid/widget/RelativeLayout$LayoutParams;

    invoke-virtual {v0, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 153
    :cond_1
    return-void
.end method

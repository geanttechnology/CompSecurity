.class Lco/vine/android/AbstractRecordingActivity$12;
.super Lco/vine/android/animation/SimpleAnimationListener;
.source "AbstractRecordingActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/AbstractRecordingActivity;->handleDelete()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/AbstractRecordingActivity;

.field final synthetic val$margin:I

.field final synthetic val$offset:I

.field final synthetic val$prevFragment:Lco/vine/android/DraftFragment;

.field final synthetic val$prevView:Landroid/view/View;

.field final synthetic val$previewLocation:[I


# direct methods
.method constructor <init>(Lco/vine/android/AbstractRecordingActivity;Landroid/view/View;[IIILco/vine/android/DraftFragment;)V
    .locals 0

    .prologue
    .line 1840
    iput-object p1, p0, Lco/vine/android/AbstractRecordingActivity$12;->this$0:Lco/vine/android/AbstractRecordingActivity;

    iput-object p2, p0, Lco/vine/android/AbstractRecordingActivity$12;->val$prevView:Landroid/view/View;

    iput-object p3, p0, Lco/vine/android/AbstractRecordingActivity$12;->val$previewLocation:[I

    iput p4, p0, Lco/vine/android/AbstractRecordingActivity$12;->val$offset:I

    iput p5, p0, Lco/vine/android/AbstractRecordingActivity$12;->val$margin:I

    iput-object p6, p0, Lco/vine/android/AbstractRecordingActivity$12;->val$prevFragment:Lco/vine/android/DraftFragment;

    invoke-direct {p0}, Lco/vine/android/animation/SimpleAnimationListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 13
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    const/4 v10, 0x1

    const/4 v9, 0x0

    const-wide/high16 v6, 0x3ff0000000000000L    # 1.0

    .line 1843
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity$12;->this$0:Lco/vine/android/AbstractRecordingActivity;

    iget-object v1, p0, Lco/vine/android/AbstractRecordingActivity$12;->val$prevView:Landroid/view/View;

    iget-object v2, p0, Lco/vine/android/AbstractRecordingActivity$12;->this$0:Lco/vine/android/AbstractRecordingActivity;

    # getter for: Lco/vine/android/AbstractRecordingActivity;->mPreviewOverlay:Landroid/view/View;
    invoke-static {v2}, Lco/vine/android/AbstractRecordingActivity;->access$3400(Lco/vine/android/AbstractRecordingActivity;)Landroid/view/View;

    move-result-object v2

    iget-object v3, p0, Lco/vine/android/AbstractRecordingActivity$12;->val$prevView:Landroid/view/View;

    invoke-virtual {v3}, Landroid/view/View;->getWidth()I

    move-result v3

    iget-object v4, p0, Lco/vine/android/AbstractRecordingActivity$12;->val$previewLocation:[I

    aget v4, v4, v9

    iget-object v5, p0, Lco/vine/android/AbstractRecordingActivity$12;->val$previewLocation:[I

    aget v5, v5, v10

    iget v8, p0, Lco/vine/android/AbstractRecordingActivity$12;->val$offset:I

    sub-int/2addr v5, v8

    invoke-static/range {v0 .. v5}, Lco/vine/android/util/FloatingViewUtils;->buildFloatingViewFor(Landroid/content/Context;Landroid/view/View;Landroid/view/View;III)Landroid/graphics/Bitmap;

    .line 1847
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity$12;->this$0:Lco/vine/android/AbstractRecordingActivity;

    # getter for: Lco/vine/android/AbstractRecordingActivity;->mPreviewOverlay:Landroid/view/View;
    invoke-static {v0}, Lco/vine/android/AbstractRecordingActivity;->access$3400(Lco/vine/android/AbstractRecordingActivity;)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v9}, Landroid/view/View;->setVisibility(I)V

    .line 1849
    new-instance v0, Lco/vine/android/animation/MoveResizeAnimator;

    const/4 v1, 0x3

    iget-object v2, p0, Lco/vine/android/AbstractRecordingActivity$12;->this$0:Lco/vine/android/AbstractRecordingActivity;

    # getter for: Lco/vine/android/AbstractRecordingActivity;->mPreviewOverlay:Landroid/view/View;
    invoke-static {v2}, Lco/vine/android/AbstractRecordingActivity;->access$3400(Lco/vine/android/AbstractRecordingActivity;)Landroid/view/View;

    move-result-object v2

    iget-object v3, p0, Lco/vine/android/AbstractRecordingActivity$12;->this$0:Lco/vine/android/AbstractRecordingActivity;

    # getter for: Lco/vine/android/AbstractRecordingActivity;->mPreviewOverlay:Landroid/view/View;
    invoke-static {v3}, Lco/vine/android/AbstractRecordingActivity;->access$3400(Lco/vine/android/AbstractRecordingActivity;)Landroid/view/View;

    move-result-object v3

    iget-object v4, p0, Lco/vine/android/AbstractRecordingActivity$12;->this$0:Lco/vine/android/AbstractRecordingActivity;

    # getter for: Lco/vine/android/AbstractRecordingActivity;->mScreenSize:Landroid/graphics/Point;
    invoke-static {v4}, Lco/vine/android/AbstractRecordingActivity;->access$3300(Lco/vine/android/AbstractRecordingActivity;)Landroid/graphics/Point;

    move-result-object v4

    iget v4, v4, Landroid/graphics/Point;->x:I

    int-to-float v4, v4

    const/high16 v5, 0x3f800000    # 1.0f

    iget-object v8, p0, Lco/vine/android/AbstractRecordingActivity$12;->this$0:Lco/vine/android/AbstractRecordingActivity;

    iget v8, v8, Lco/vine/android/AbstractRecordingActivity;->mPreviewRatio:F

    sub-float/2addr v5, v8

    mul-float/2addr v4, v5

    float-to-int v4, v4

    iget v5, p0, Lco/vine/android/AbstractRecordingActivity$12;->val$margin:I

    mul-int/lit8 v5, v5, 0x5

    sub-int/2addr v4, v5

    iget-object v5, p0, Lco/vine/android/AbstractRecordingActivity$12;->val$previewLocation:[I

    aget v5, v5, v10

    iget v8, p0, Lco/vine/android/AbstractRecordingActivity$12;->val$offset:I

    sub-int/2addr v5, v8

    const/16 v10, 0x12c

    iget-object v11, p0, Lco/vine/android/AbstractRecordingActivity$12;->this$0:Lco/vine/android/AbstractRecordingActivity;

    iget-object v8, p0, Lco/vine/android/AbstractRecordingActivity$12;->val$prevFragment:Lco/vine/android/DraftFragment;

    invoke-virtual {v8}, Lco/vine/android/DraftFragment;->getView()Landroid/view/View;

    move-result-object v12

    move-wide v8, v6

    invoke-direct/range {v0 .. v12}, Lco/vine/android/animation/MoveResizeAnimator;-><init>(ILandroid/view/View;Landroid/view/View;IIDDILco/vine/android/animation/SmoothAnimator$AnimationListener;Ljava/lang/Object;)V

    invoke-virtual {v0}, Lco/vine/android/animation/MoveResizeAnimator;->start()V

    .line 1853
    return-void
.end method

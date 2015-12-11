.class public Lco/vine/android/RecordingFragment$PlusMinusTouchListener;
.super Lco/vine/android/views/FakeKeyEventTouchListener;
.source "RecordingFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/RecordingFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "PlusMinusTouchListener"
.end annotation


# instance fields
.field private final mDrawableId:I

.field private final mRes:Landroid/content/res/Resources;

.field private final mTarget:Landroid/widget/ImageView;

.field final synthetic this$0:Lco/vine/android/RecordingFragment;


# direct methods
.method public constructor <init>(Lco/vine/android/RecordingFragment;Landroid/widget/ImageView;I)V
    .locals 2
    .param p2, "target"    # Landroid/widget/ImageView;
    .param p3, "res"    # I

    .prologue
    .line 357
    iput-object p1, p0, Lco/vine/android/RecordingFragment$PlusMinusTouchListener;->this$0:Lco/vine/android/RecordingFragment;

    .line 358
    invoke-virtual {p1}, Lco/vine/android/RecordingFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v0, 0x7f020296

    if-ne p3, v0, :cond_0

    const/16 v0, 0xa9

    :goto_0
    invoke-direct {p0, v1, v0}, Lco/vine/android/views/FakeKeyEventTouchListener;-><init>(Landroid/app/Activity;I)V

    .line 359
    iput p3, p0, Lco/vine/android/RecordingFragment$PlusMinusTouchListener;->mDrawableId:I

    .line 360
    invoke-virtual {p1}, Lco/vine/android/RecordingFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/RecordingFragment$PlusMinusTouchListener;->mRes:Landroid/content/res/Resources;

    .line 361
    iput-object p2, p0, Lco/vine/android/RecordingFragment$PlusMinusTouchListener;->mTarget:Landroid/widget/ImageView;

    .line 362
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lco/vine/android/RecordingFragment$PlusMinusTouchListener;->changeColor(I)V

    .line 363
    return-void

    .line 358
    :cond_0
    const/16 v0, 0xa8

    goto :goto_0
.end method

.method private changeColor(I)V
    .locals 4
    .param p1, "action"    # I

    .prologue
    .line 372
    packed-switch p1, :pswitch_data_0

    .line 386
    :goto_0
    return-void

    .line 374
    :pswitch_0
    iget-object v0, p0, Lco/vine/android/RecordingFragment$PlusMinusTouchListener;->mRes:Landroid/content/res/Resources;

    iget-object v1, p0, Lco/vine/android/RecordingFragment$PlusMinusTouchListener;->this$0:Lco/vine/android/RecordingFragment;

    # getter for: Lco/vine/android/RecordingFragment;->mColor:I
    invoke-static {v1}, Lco/vine/android/RecordingFragment;->access$900(Lco/vine/android/RecordingFragment;)I

    move-result v1

    iget v2, p0, Lco/vine/android/RecordingFragment$PlusMinusTouchListener;->mDrawableId:I

    iget-object v3, p0, Lco/vine/android/RecordingFragment$PlusMinusTouchListener;->mTarget:Landroid/widget/ImageView;

    invoke-static {v0, v1, v2, v3}, Lco/vine/android/util/ViewUtil;->fillColor(Landroid/content/res/Resources;IILandroid/view/View;)V

    .line 376
    iget-object v0, p0, Lco/vine/android/RecordingFragment$PlusMinusTouchListener;->mTarget:Landroid/widget/ImageView;

    const/high16 v1, 0x3f800000    # 1.0f

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setAlpha(F)V

    goto :goto_0

    .line 380
    :pswitch_1
    iget-object v0, p0, Lco/vine/android/RecordingFragment$PlusMinusTouchListener;->mRes:Landroid/content/res/Resources;

    iget-object v1, p0, Lco/vine/android/RecordingFragment$PlusMinusTouchListener;->this$0:Lco/vine/android/RecordingFragment;

    # getter for: Lco/vine/android/RecordingFragment;->mColor:I
    invoke-static {v1}, Lco/vine/android/RecordingFragment;->access$900(Lco/vine/android/RecordingFragment;)I

    move-result v1

    iget v2, p0, Lco/vine/android/RecordingFragment$PlusMinusTouchListener;->mDrawableId:I

    iget-object v3, p0, Lco/vine/android/RecordingFragment$PlusMinusTouchListener;->mTarget:Landroid/widget/ImageView;

    invoke-static {v0, v1, v2, v3}, Lco/vine/android/util/ViewUtil;->fillColor(Landroid/content/res/Resources;IILandroid/view/View;)V

    .line 382
    iget-object v0, p0, Lco/vine/android/RecordingFragment$PlusMinusTouchListener;->mTarget:Landroid/widget/ImageView;

    const v1, 0x3eb33333    # 0.35f

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setAlpha(F)V

    goto :goto_0

    .line 372
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "v"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 367
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    invoke-direct {p0, v0}, Lco/vine/android/RecordingFragment$PlusMinusTouchListener;->changeColor(I)V

    .line 368
    invoke-super {p0, p1, p2}, Lco/vine/android/views/FakeKeyEventTouchListener;->onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z

    move-result v0

    return v0
.end method

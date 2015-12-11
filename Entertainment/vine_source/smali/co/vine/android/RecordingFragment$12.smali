.class Lco/vine/android/RecordingFragment$12;
.super Ljava/lang/Object;
.source "RecordingFragment.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/RecordingFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
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
    .line 697
    iput-object p1, p0, Lco/vine/android/RecordingFragment$12;->this$0:Lco/vine/android/RecordingFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 3
    .param p1, "v"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v0, 0x1

    .line 700
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v1

    packed-switch v1, :pswitch_data_0

    .line 711
    const/4 v0, 0x0

    :goto_0
    return v0

    .line 702
    :pswitch_0
    iget-object v1, p0, Lco/vine/android/RecordingFragment$12;->this$0:Lco/vine/android/RecordingFragment;

    # getter for: Lco/vine/android/RecordingFragment;->mDraftsButton:Landroid/widget/TextView;
    invoke-static {v1}, Lco/vine/android/RecordingFragment;->access$100(Lco/vine/android/RecordingFragment;)Landroid/widget/TextView;

    move-result-object v1

    const/high16 v2, 0x3f800000    # 1.0f

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setAlpha(F)V

    goto :goto_0

    .line 706
    :pswitch_1
    iget-object v1, p0, Lco/vine/android/RecordingFragment$12;->this$0:Lco/vine/android/RecordingFragment;

    # getter for: Lco/vine/android/RecordingFragment;->mDraftsButton:Landroid/widget/TextView;
    invoke-static {v1}, Lco/vine/android/RecordingFragment;->access$100(Lco/vine/android/RecordingFragment;)Landroid/widget/TextView;

    move-result-object v1

    const v2, 0x3eb33333    # 0.35f

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setAlpha(F)V

    .line 707
    iget-object v1, p0, Lco/vine/android/RecordingFragment$12;->this$0:Lco/vine/android/RecordingFragment;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lco/vine/android/RecordingFragment;->onSessionSwitchPressed(Landroid/view/View;)V

    goto :goto_0

    .line 700
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

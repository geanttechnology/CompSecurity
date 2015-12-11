.class Lco/vine/android/RecordingFragment$11;
.super Ljava/lang/Object;
.source "RecordingFragment.java"

# interfaces
.implements Landroid/widget/CompoundButton$OnCheckedChangeListener;


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

.field final synthetic val$res:Landroid/content/res/Resources;


# direct methods
.method constructor <init>(Lco/vine/android/RecordingFragment;Landroid/content/res/Resources;)V
    .locals 0

    .prologue
    .line 681
    iput-object p1, p0, Lco/vine/android/RecordingFragment$11;->this$0:Lco/vine/android/RecordingFragment;

    iput-object p2, p0, Lco/vine/android/RecordingFragment$11;->val$res:Landroid/content/res/Resources;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCheckedChanged(Landroid/widget/CompoundButton;Z)V
    .locals 4
    .param p1, "buttonView"    # Landroid/widget/CompoundButton;
    .param p2, "isChecked"    # Z

    .prologue
    const v3, 0x7f02018b

    .line 684
    if-eqz p2, :cond_0

    .line 685
    iget-object v0, p0, Lco/vine/android/RecordingFragment$11;->val$res:Landroid/content/res/Resources;

    iget-object v1, p0, Lco/vine/android/RecordingFragment$11;->this$0:Lco/vine/android/RecordingFragment;

    # getter for: Lco/vine/android/RecordingFragment;->mColor:I
    invoke-static {v1}, Lco/vine/android/RecordingFragment;->access$900(Lco/vine/android/RecordingFragment;)I

    move-result v1

    iget-object v2, p0, Lco/vine/android/RecordingFragment$11;->this$0:Lco/vine/android/RecordingFragment;

    # getter for: Lco/vine/android/RecordingFragment;->mGhostButton:Landroid/widget/ToggleButton;
    invoke-static {v2}, Lco/vine/android/RecordingFragment;->access$700(Lco/vine/android/RecordingFragment;)Landroid/widget/ToggleButton;

    move-result-object v2

    invoke-static {v0, v1, v3, v2}, Lco/vine/android/util/ViewUtil;->fillColor(Landroid/content/res/Resources;IILandroid/view/View;)V

    .line 686
    iget-object v0, p0, Lco/vine/android/RecordingFragment$11;->this$0:Lco/vine/android/RecordingFragment;

    # getter for: Lco/vine/android/RecordingFragment;->mGhostButton:Landroid/widget/ToggleButton;
    invoke-static {v0}, Lco/vine/android/RecordingFragment;->access$700(Lco/vine/android/RecordingFragment;)Landroid/widget/ToggleButton;

    move-result-object v0

    const/high16 v1, 0x3f800000    # 1.0f

    invoke-virtual {v0, v1}, Landroid/widget/ToggleButton;->setAlpha(F)V

    .line 691
    :goto_0
    return-void

    .line 688
    :cond_0
    iget-object v0, p0, Lco/vine/android/RecordingFragment$11;->val$res:Landroid/content/res/Resources;

    iget-object v1, p0, Lco/vine/android/RecordingFragment$11;->this$0:Lco/vine/android/RecordingFragment;

    # getter for: Lco/vine/android/RecordingFragment;->mColor:I
    invoke-static {v1}, Lco/vine/android/RecordingFragment;->access$900(Lco/vine/android/RecordingFragment;)I

    move-result v1

    iget-object v2, p0, Lco/vine/android/RecordingFragment$11;->this$0:Lco/vine/android/RecordingFragment;

    # getter for: Lco/vine/android/RecordingFragment;->mGhostButton:Landroid/widget/ToggleButton;
    invoke-static {v2}, Lco/vine/android/RecordingFragment;->access$700(Lco/vine/android/RecordingFragment;)Landroid/widget/ToggleButton;

    move-result-object v2

    invoke-static {v0, v1, v3, v2}, Lco/vine/android/util/ViewUtil;->fillColor(Landroid/content/res/Resources;IILandroid/view/View;)V

    .line 689
    iget-object v0, p0, Lco/vine/android/RecordingFragment$11;->this$0:Lco/vine/android/RecordingFragment;

    # getter for: Lco/vine/android/RecordingFragment;->mGhostButton:Landroid/widget/ToggleButton;
    invoke-static {v0}, Lco/vine/android/RecordingFragment;->access$700(Lco/vine/android/RecordingFragment;)Landroid/widget/ToggleButton;

    move-result-object v0

    const v1, 0x3eb33333    # 0.35f

    invoke-virtual {v0, v1}, Landroid/widget/ToggleButton;->setAlpha(F)V

    goto :goto_0
.end method

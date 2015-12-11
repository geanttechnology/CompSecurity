.class Lco/vine/android/RecordingPreviewFragment$1;
.super Ljava/lang/Object;
.source "RecordingPreviewFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/RecordingPreviewFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/RecordingPreviewFragment;


# direct methods
.method constructor <init>(Lco/vine/android/RecordingPreviewFragment;)V
    .locals 0

    .prologue
    .line 178
    iput-object p1, p0, Lco/vine/android/RecordingPreviewFragment$1;->this$0:Lco/vine/android/RecordingPreviewFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 181
    iget-object v0, p0, Lco/vine/android/RecordingPreviewFragment$1;->this$0:Lco/vine/android/RecordingPreviewFragment;

    iget-object v1, p0, Lco/vine/android/RecordingPreviewFragment$1;->this$0:Lco/vine/android/RecordingPreviewFragment;

    # getter for: Lco/vine/android/RecordingPreviewFragment;->mMaxLoop:I
    invoke-static {v1}, Lco/vine/android/RecordingPreviewFragment;->access$000(Lco/vine/android/RecordingPreviewFragment;)I

    move-result v1

    add-int/lit8 v1, v1, 0x1

    # getter for: Lco/vine/android/RecordingPreviewFragment;->VALID_MAX_LOOPS:[I
    invoke-static {}, Lco/vine/android/RecordingPreviewFragment;->access$100()[I

    move-result-object v2

    array-length v2, v2

    rem-int/2addr v1, v2

    # setter for: Lco/vine/android/RecordingPreviewFragment;->mMaxLoop:I
    invoke-static {v0, v1}, Lco/vine/android/RecordingPreviewFragment;->access$002(Lco/vine/android/RecordingPreviewFragment;I)I

    .line 182
    iget-object v0, p0, Lco/vine/android/RecordingPreviewFragment$1;->this$0:Lco/vine/android/RecordingPreviewFragment;

    # invokes: Lco/vine/android/RecordingPreviewFragment;->updateMessageLoopLimit()V
    invoke-static {v0}, Lco/vine/android/RecordingPreviewFragment;->access$200(Lco/vine/android/RecordingPreviewFragment;)V

    .line 183
    return-void
.end method

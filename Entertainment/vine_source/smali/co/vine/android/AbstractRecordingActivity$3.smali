.class Lco/vine/android/AbstractRecordingActivity$3;
.super Ljava/lang/Object;
.source "AbstractRecordingActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/AbstractRecordingActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/AbstractRecordingActivity;


# direct methods
.method constructor <init>(Lco/vine/android/AbstractRecordingActivity;)V
    .locals 0

    .prologue
    .line 379
    iput-object p1, p0, Lco/vine/android/AbstractRecordingActivity$3;->this$0:Lco/vine/android/AbstractRecordingActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 382
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity$3;->this$0:Lco/vine/android/AbstractRecordingActivity;

    iget v0, v0, Lco/vine/android/AbstractRecordingActivity;->mCurrentPage:I

    iget-object v1, p0, Lco/vine/android/AbstractRecordingActivity$3;->this$0:Lco/vine/android/AbstractRecordingActivity;

    # getter for: Lco/vine/android/AbstractRecordingActivity;->mDraftFragments:Landroid/util/SparseArray;
    invoke-static {v1}, Lco/vine/android/AbstractRecordingActivity;->access$000(Lco/vine/android/AbstractRecordingActivity;)Landroid/util/SparseArray;

    move-result-object v1

    invoke-virtual {v1}, Landroid/util/SparseArray;->size()I

    move-result v1

    if-eq v0, v1, :cond_0

    .line 383
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity$3;->this$0:Lco/vine/android/AbstractRecordingActivity;

    const/4 v1, 0x0

    # setter for: Lco/vine/android/AbstractRecordingActivity;->mDeleteWasDrag:Z
    invoke-static {v0, v1}, Lco/vine/android/AbstractRecordingActivity;->access$102(Lco/vine/android/AbstractRecordingActivity;Z)Z

    .line 384
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity$3;->this$0:Lco/vine/android/AbstractRecordingActivity;

    invoke-virtual {v0}, Lco/vine/android/AbstractRecordingActivity;->showDeleteDialog()V

    .line 386
    :cond_0
    return-void
.end method

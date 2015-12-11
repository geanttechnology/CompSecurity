.class Lco/vine/android/CommentsFragment$1;
.super Ljava/lang/Object;
.source "CommentsFragment.java"

# interfaces
.implements Landroid/support/v7/view/ActionMode$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/CommentsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/CommentsFragment;


# direct methods
.method constructor <init>(Lco/vine/android/CommentsFragment;)V
    .locals 0

    .prologue
    .line 341
    iput-object p1, p0, Lco/vine/android/CommentsFragment$1;->this$0:Lco/vine/android/CommentsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onActionItemClicked(Landroid/support/v7/view/ActionMode;Landroid/view/MenuItem;)Z
    .locals 5
    .param p1, "mode"    # Landroid/support/v7/view/ActionMode;
    .param p2, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 358
    iget-object v0, p0, Lco/vine/android/CommentsFragment$1;->this$0:Lco/vine/android/CommentsFragment;

    iget-object v1, p0, Lco/vine/android/CommentsFragment$1;->this$0:Lco/vine/android/CommentsFragment;

    iget-object v1, v1, Lco/vine/android/CommentsFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v2, p0, Lco/vine/android/CommentsFragment$1;->this$0:Lco/vine/android/CommentsFragment;

    # getter for: Lco/vine/android/CommentsFragment;->mPostId:J
    invoke-static {v2}, Lco/vine/android/CommentsFragment;->access$000(Lco/vine/android/CommentsFragment;)J

    move-result-wide v2

    # getter for: Lco/vine/android/CommentsFragment;->mSelectedCommentId:Ljava/lang/String;
    invoke-static {}, Lco/vine/android/CommentsFragment;->access$100()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v2, v3, v4}, Lco/vine/android/client/AppController;->deleteComment(JLjava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lco/vine/android/CommentsFragment;->addRequest(Ljava/lang/String;)Ljava/lang/String;

    .line 359
    invoke-virtual {p1}, Landroid/support/v7/view/ActionMode;->finish()V

    .line 360
    const/4 v0, 0x1

    return v0
.end method

.method public onCreateActionMode(Landroid/support/v7/view/ActionMode;Landroid/view/Menu;)Z
    .locals 2
    .param p1, "mode"    # Landroid/support/v7/view/ActionMode;
    .param p2, "menu"    # Landroid/view/Menu;

    .prologue
    .line 346
    invoke-virtual {p1}, Landroid/support/v7/view/ActionMode;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v0

    .line 347
    .local v0, "inflater":Landroid/view/MenuInflater;
    const v1, 0x7f100001

    invoke-virtual {v0, v1, p2}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 348
    const/4 v1, 0x1

    return v1
.end method

.method public onDestroyActionMode(Landroid/support/v7/view/ActionMode;)V
    .locals 2
    .param p1, "mode"    # Landroid/support/v7/view/ActionMode;

    .prologue
    .line 365
    iget-object v0, p0, Lco/vine/android/CommentsFragment$1;->this$0:Lco/vine/android/CommentsFragment;

    # getter for: Lco/vine/android/CommentsFragment;->mSelectedView:Landroid/view/View;
    invoke-static {v0}, Lco/vine/android/CommentsFragment;->access$200(Lco/vine/android/CommentsFragment;)Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 366
    iget-object v0, p0, Lco/vine/android/CommentsFragment$1;->this$0:Lco/vine/android/CommentsFragment;

    # getter for: Lco/vine/android/CommentsFragment;->mSelectedView:Landroid/view/View;
    invoke-static {v0}, Lco/vine/android/CommentsFragment;->access$200(Lco/vine/android/CommentsFragment;)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setSelected(Z)V

    .line 368
    :cond_0
    const/4 v0, 0x0

    # setter for: Lco/vine/android/CommentsFragment;->mActionMode:Landroid/support/v7/view/ActionMode;
    invoke-static {v0}, Lco/vine/android/CommentsFragment;->access$302(Landroid/support/v7/view/ActionMode;)Landroid/support/v7/view/ActionMode;

    .line 369
    return-void
.end method

.method public onPrepareActionMode(Landroid/support/v7/view/ActionMode;Landroid/view/Menu;)Z
    .locals 1
    .param p1, "mode"    # Landroid/support/v7/view/ActionMode;
    .param p2, "menu"    # Landroid/view/Menu;

    .prologue
    .line 353
    const/4 v0, 0x0

    return v0
.end method

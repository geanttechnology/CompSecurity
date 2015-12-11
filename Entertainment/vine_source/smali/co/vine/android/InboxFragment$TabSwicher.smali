.class public Lco/vine/android/InboxFragment$TabSwicher;
.super Ljava/lang/Object;
.source "InboxFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/InboxFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "TabSwicher"
.end annotation


# instance fields
.field public final targetAdapter:Landroid/widget/BaseAdapter;

.field final synthetic this$0:Lco/vine/android/InboxFragment;


# direct methods
.method public constructor <init>(Lco/vine/android/InboxFragment;Landroid/widget/BaseAdapter;)V
    .locals 0
    .param p2, "target"    # Landroid/widget/BaseAdapter;

    .prologue
    .line 432
    iput-object p1, p0, Lco/vine/android/InboxFragment$TabSwicher;->this$0:Lco/vine/android/InboxFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 433
    iput-object p2, p0, Lco/vine/android/InboxFragment$TabSwicher;->targetAdapter:Landroid/widget/BaseAdapter;

    .line 434
    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 438
    iget-object v0, p0, Lco/vine/android/InboxFragment$TabSwicher;->this$0:Lco/vine/android/InboxFragment;

    # getter for: Lco/vine/android/InboxFragment;->mActiveAdapter:Landroid/widget/BaseAdapter;
    invoke-static {v0}, Lco/vine/android/InboxFragment;->access$100(Lco/vine/android/InboxFragment;)Landroid/widget/BaseAdapter;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/InboxFragment$TabSwicher;->targetAdapter:Landroid/widget/BaseAdapter;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lco/vine/android/InboxFragment$TabSwicher;->this$0:Lco/vine/android/InboxFragment;

    # getter for: Lco/vine/android/InboxFragment;->mIsSwitching:Z
    invoke-static {v0}, Lco/vine/android/InboxFragment;->access$700(Lco/vine/android/InboxFragment;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 439
    iget-object v0, p0, Lco/vine/android/InboxFragment$TabSwicher;->this$0:Lco/vine/android/InboxFragment;

    const/4 v1, 0x1

    # setter for: Lco/vine/android/InboxFragment;->mIsSwitching:Z
    invoke-static {v0, v1}, Lco/vine/android/InboxFragment;->access$702(Lco/vine/android/InboxFragment;Z)Z

    .line 440
    iget-object v0, p0, Lco/vine/android/InboxFragment$TabSwicher;->this$0:Lco/vine/android/InboxFragment;

    iget-object v0, v0, Lco/vine/android/InboxFragment;->mHandler:Landroid/os/Handler;

    invoke-virtual {v0, p0}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 441
    iget-object v0, p0, Lco/vine/android/InboxFragment$TabSwicher;->this$0:Lco/vine/android/InboxFragment;

    iget-object v0, v0, Lco/vine/android/InboxFragment;->mHandler:Landroid/os/Handler;

    const-wide/16 v1, 0xc8

    invoke-virtual {v0, p0, v1, v2}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 443
    :cond_0
    return-void
.end method

.method public run()V
    .locals 2

    .prologue
    .line 447
    iget-object v0, p0, Lco/vine/android/InboxFragment$TabSwicher;->this$0:Lco/vine/android/InboxFragment;

    iget-object v1, p0, Lco/vine/android/InboxFragment$TabSwicher;->targetAdapter:Landroid/widget/BaseAdapter;

    # setter for: Lco/vine/android/InboxFragment;->mActiveAdapter:Landroid/widget/BaseAdapter;
    invoke-static {v0, v1}, Lco/vine/android/InboxFragment;->access$102(Lco/vine/android/InboxFragment;Landroid/widget/BaseAdapter;)Landroid/widget/BaseAdapter;

    .line 448
    iget-object v0, p0, Lco/vine/android/InboxFragment$TabSwicher;->this$0:Lco/vine/android/InboxFragment;

    iget-object v0, v0, Lco/vine/android/InboxFragment;->mListView:Landroid/widget/ListView;

    iget-object v1, p0, Lco/vine/android/InboxFragment$TabSwicher;->this$0:Lco/vine/android/InboxFragment;

    # getter for: Lco/vine/android/InboxFragment;->mActiveAdapter:Landroid/widget/BaseAdapter;
    invoke-static {v1}, Lco/vine/android/InboxFragment;->access$100(Lco/vine/android/InboxFragment;)Landroid/widget/BaseAdapter;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 449
    iget-object v0, p0, Lco/vine/android/InboxFragment$TabSwicher;->this$0:Lco/vine/android/InboxFragment;

    const/4 v1, 0x0

    # setter for: Lco/vine/android/InboxFragment;->mIsSwitching:Z
    invoke-static {v0, v1}, Lco/vine/android/InboxFragment;->access$702(Lco/vine/android/InboxFragment;Z)Z

    .line 450
    iget-object v0, p0, Lco/vine/android/InboxFragment$TabSwicher;->this$0:Lco/vine/android/InboxFragment;

    # invokes: Lco/vine/android/InboxFragment;->invalidateAdapters()V
    invoke-static {v0}, Lco/vine/android/InboxFragment;->access$800(Lco/vine/android/InboxFragment;)V

    .line 451
    return-void
.end method

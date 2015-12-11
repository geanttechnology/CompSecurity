.class Lco/vine/android/InboxFragment$3;
.super Ljava/lang/Object;
.source "InboxFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/InboxFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/InboxFragment;


# direct methods
.method constructor <init>(Lco/vine/android/InboxFragment;)V
    .locals 0

    .prologue
    .line 545
    iput-object p1, p0, Lco/vine/android/InboxFragment$3;->this$0:Lco/vine/android/InboxFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    const/4 v4, 0x1

    .line 548
    iget-object v5, p0, Lco/vine/android/InboxFragment$3;->this$0:Lco/vine/android/InboxFragment;

    # getter for: Lco/vine/android/InboxFragment;->mActiveAdapter:Landroid/widget/BaseAdapter;
    invoke-static {v5}, Lco/vine/android/InboxFragment;->access$100(Lco/vine/android/InboxFragment;)Landroid/widget/BaseAdapter;

    move-result-object v5

    iget-object v6, p0, Lco/vine/android/InboxFragment$3;->this$0:Lco/vine/android/InboxFragment;

    # getter for: Lco/vine/android/InboxFragment;->mSectionAdapter:Lco/vine/android/widget/SectionAdapter;
    invoke-static {v6}, Lco/vine/android/InboxFragment;->access$200(Lco/vine/android/InboxFragment;)Lco/vine/android/widget/SectionAdapter;

    move-result-object v6

    if-ne v5, v6, :cond_2

    .line 549
    iget-object v5, p0, Lco/vine/android/InboxFragment$3;->this$0:Lco/vine/android/InboxFragment;

    iget-object v5, v5, Lco/vine/android/InboxFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v5}, Landroid/widget/ListView;->getLastVisiblePosition()I

    move-result v2

    .line 550
    .local v2, "last":I
    const/4 v3, 0x1

    .line 552
    .local v3, "listViewFits":Z
    :try_start_0
    iget-object v5, p0, Lco/vine/android/InboxFragment$3;->this$0:Lco/vine/android/InboxFragment;

    iget-object v5, v5, Lco/vine/android/InboxFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v5}, Landroid/widget/ListView;->getCount()I

    move-result v5

    add-int/lit8 v5, v5, -0x1

    if-ne v2, v5, :cond_3

    iget-object v5, p0, Lco/vine/android/InboxFragment$3;->this$0:Lco/vine/android/InboxFragment;

    iget-object v5, v5, Lco/vine/android/InboxFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v5, v2}, Landroid/widget/ListView;->getChildAt(I)Landroid/view/View;

    move-result-object v5

    invoke-virtual {v5}, Landroid/view/View;->getBottom()I

    move-result v5

    iget-object v6, p0, Lco/vine/android/InboxFragment$3;->this$0:Lco/vine/android/InboxFragment;

    iget-object v6, v6, Lco/vine/android/InboxFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v6}, Landroid/widget/ListView;->getHeight()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v6

    if-gt v5, v6, :cond_3

    move v3, v4

    .line 557
    :goto_0
    const/4 v1, 0x0

    .line 560
    .local v1, "isEmpty":Z
    :try_start_1
    iget-object v5, p0, Lco/vine/android/InboxFragment$3;->this$0:Lco/vine/android/InboxFragment;

    iget-object v5, v5, Lco/vine/android/InboxFragment;->mInboxAdapter:Lco/vine/android/MessageBoxAdapter;

    invoke-virtual {v5}, Lco/vine/android/MessageBoxAdapter;->isEmpty()Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    move-result v1

    .line 565
    :goto_1
    iget-object v5, p0, Lco/vine/android/InboxFragment$3;->this$0:Lco/vine/android/InboxFragment;

    # getter for: Lco/vine/android/InboxFragment;->mIsAddressBookShowing:Z
    invoke-static {v5}, Lco/vine/android/InboxFragment;->access$1300(Lco/vine/android/InboxFragment;)Z

    move-result v5

    if-nez v5, :cond_1

    iget-object v5, p0, Lco/vine/android/InboxFragment$3;->this$0:Lco/vine/android/InboxFragment;

    invoke-virtual {v5, v4}, Lco/vine/android/InboxFragment;->isFetched(I)Z

    move-result v4

    if-eqz v4, :cond_0

    if-nez v1, :cond_1

    :cond_0
    iget-object v4, p0, Lco/vine/android/InboxFragment$3;->this$0:Lco/vine/android/InboxFragment;

    const/4 v5, 0x3

    invoke-virtual {v4, v5}, Lco/vine/android/InboxFragment;->isFetched(I)Z

    move-result v4

    if-eqz v4, :cond_2

    if-eqz v3, :cond_2

    .line 570
    :cond_1
    iget-object v4, p0, Lco/vine/android/InboxFragment$3;->this$0:Lco/vine/android/InboxFragment;

    invoke-virtual {v4}, Lco/vine/android/InboxFragment;->addEntriesToAddressAdapter()V

    .line 573
    .end local v1    # "isEmpty":Z
    .end local v2    # "last":I
    .end local v3    # "listViewFits":Z
    :cond_2
    return-void

    .line 552
    .restart local v2    # "last":I
    .restart local v3    # "listViewFits":Z
    :cond_3
    const/4 v3, 0x0

    goto :goto_0

    .line 553
    :catch_0
    move-exception v0

    .line 554
    .local v0, "e":Ljava/lang/Exception;
    const-string v5, "Cannot get listview state."

    invoke-static {v5}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;)V

    goto :goto_0

    .line 561
    .end local v0    # "e":Ljava/lang/Exception;
    .restart local v1    # "isEmpty":Z
    :catch_1
    move-exception v0

    .line 562
    .restart local v0    # "e":Ljava/lang/Exception;
    invoke-static {v0}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    goto :goto_1
.end method

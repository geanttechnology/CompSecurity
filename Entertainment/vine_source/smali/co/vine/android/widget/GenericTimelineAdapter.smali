.class public abstract Lco/vine/android/widget/GenericTimelineAdapter;
.super Lco/vine/android/widget/GenericVideoAdapter;
.source "GenericTimelineAdapter.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Lco/vine/android/widget/GenericFeedViewHolder;",
        ">",
        "Lco/vine/android/widget/GenericVideoAdapter",
        "<TT;>;"
    }
.end annotation


# instance fields
.field protected final mListView:Landroid/widget/ListView;

.field protected final mTimelineFragment:Lco/vine/android/BaseTimelineFragment;


# direct methods
.method public constructor <init>(Landroid/app/Activity;Landroid/widget/ListView;Lco/vine/android/LikeCache;Lco/vine/android/RevineCache;Lco/vine/android/BaseTimelineFragment;Ljava/lang/String;)V
    .locals 7
    .param p1, "context"    # Landroid/app/Activity;
    .param p2, "listView"    # Landroid/widget/ListView;
    .param p3, "likeCache"    # Lco/vine/android/LikeCache;
    .param p4, "revineCache"    # Lco/vine/android/RevineCache;
    .param p5, "timelineFragment"    # Lco/vine/android/BaseTimelineFragment;
    .param p6, "followEventSource"    # Ljava/lang/String;

    .prologue
    .line 24
    .local p0, "this":Lco/vine/android/widget/GenericTimelineAdapter;, "Lco/vine/android/widget/GenericTimelineAdapter<TT;>;"
    move-object v0, p0

    move-object v1, p1

    move-object v2, p3

    move-object v3, p4

    move-object v4, p5

    move-object v5, p5

    move-object v6, p6

    invoke-direct/range {v0 .. v6}, Lco/vine/android/widget/GenericVideoAdapter;-><init>(Landroid/app/Activity;Lco/vine/android/LikeCache;Lco/vine/android/RevineCache;Landroid/view/View$OnClickListener;Lco/vine/android/widget/SpanClickListener;Ljava/lang/String;)V

    .line 25
    iput-object p2, p0, Lco/vine/android/widget/GenericTimelineAdapter;->mListView:Landroid/widget/ListView;

    .line 26
    iget-object v0, p0, Lco/vine/android/widget/GenericTimelineAdapter;->mListView:Landroid/widget/ListView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setDivider(Landroid/graphics/drawable/Drawable;)V

    .line 27
    iget-object v0, p0, Lco/vine/android/widget/GenericTimelineAdapter;->mListView:Landroid/widget/ListView;

    invoke-virtual {v0, p5}, Landroid/widget/ListView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 28
    iput-object p5, p0, Lco/vine/android/widget/GenericTimelineAdapter;->mTimelineFragment:Lco/vine/android/BaseTimelineFragment;

    .line 29
    return-void
.end method


# virtual methods
.method public getViewAtPosition(I)Landroid/view/View;
    .locals 12
    .param p1, "wantedPosition"    # I

    .prologue
    .local p0, "this":Lco/vine/android/widget/GenericTimelineAdapter;, "Lco/vine/android/widget/GenericTimelineAdapter<TT;>;"
    const/4 v6, 0x4

    const/4 v11, 0x3

    const/4 v10, 0x2

    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 37
    iget-object v2, p0, Lco/vine/android/widget/GenericTimelineAdapter;->mListView:Landroid/widget/ListView;

    .line 38
    .local v2, "listView":Landroid/widget/ListView;
    const/4 v3, 0x0

    .line 39
    .local v3, "offset":I
    iget-object v5, p0, Lco/vine/android/widget/GenericTimelineAdapter;->mViewOffsetResolver:Lco/vine/android/ViewOffsetResolver;

    if-eqz v5, :cond_0

    .line 40
    iget-object v5, p0, Lco/vine/android/widget/GenericTimelineAdapter;->mViewOffsetResolver:Lco/vine/android/ViewOffsetResolver;

    invoke-interface {v5, p0}, Lco/vine/android/ViewOffsetResolver;->getOffset(Landroid/widget/BaseAdapter;)I

    move-result v3

    .line 42
    :cond_0
    invoke-virtual {v2}, Landroid/widget/ListView;->getHeaderViewsCount()I

    move-result v1

    .line 43
    .local v1, "headerViewCount":I
    invoke-virtual {v2}, Landroid/widget/ListView;->getFirstVisiblePosition()I

    move-result v5

    sub-int/2addr v5, v1

    sub-int v0, v5, v3

    .line 44
    .local v0, "firstPosition":I
    sub-int v4, p1, v0

    .line 45
    .local v4, "wantedChild":I
    if-ltz v4, :cond_1

    invoke-virtual {v2}, Landroid/widget/ListView;->getChildCount()I

    move-result v5

    if-lt v4, v5, :cond_3

    .line 46
    :cond_1
    sget-boolean v5, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v5, :cond_2

    .line 47
    const-string v5, "Unable to get view for desired position, because it\'s not being displayed on screen: {} {} {} {}."

    new-array v6, v6, [Ljava/lang/Object;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v6, v8

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v6, v9

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v6, v10

    invoke-virtual {v2}, Landroid/widget/ListView;->getChildCount()I

    move-result v7

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v6, v11

    invoke-static {v5, v6}, Lcom/edisonwang/android/slog/SLog;->w(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 49
    :cond_2
    const/4 v5, 0x0

    .line 56
    :goto_0
    return-object v5

    .line 51
    :cond_3
    sget-boolean v5, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v5, :cond_4

    .line 52
    const-string v5, "Get view for desired position: {} {} {} {}."

    new-array v6, v6, [Ljava/lang/Object;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v6, v8

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v6, v9

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v6, v10

    invoke-virtual {v2}, Landroid/widget/ListView;->getChildCount()I

    move-result v7

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v6, v11

    invoke-static {v5, v6}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 56
    :cond_4
    invoke-virtual {v2, v4}, Landroid/widget/ListView;->getChildAt(I)Landroid/view/View;

    move-result-object v5

    goto :goto_0
.end method

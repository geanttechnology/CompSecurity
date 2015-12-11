.class public Lco/vine/android/SingleFragment;
.super Lco/vine/android/BaseTimelineFragment;
.source "SingleFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/SingleFragment$SinglePostListener;
    }
.end annotation


# static fields
.field private static final EVENT_SOURCE_TITLE:Ljava/lang/String; = "Single Post"


# instance fields
.field private final mWrapper:Lco/vine/android/SingleFragmentWrapper;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 15
    invoke-direct {p0}, Lco/vine/android/BaseTimelineFragment;-><init>()V

    .line 17
    new-instance v0, Lco/vine/android/SingleFragmentWrapper;

    invoke-direct {v0}, Lco/vine/android/SingleFragmentWrapper;-><init>()V

    iput-object v0, p0, Lco/vine/android/SingleFragment;->mWrapper:Lco/vine/android/SingleFragmentWrapper;

    .line 94
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/SingleFragment;)Lco/vine/android/SingleFragmentWrapper;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/SingleFragment;

    .prologue
    .line 15
    iget-object v0, p0, Lco/vine/android/SingleFragment;->mWrapper:Lco/vine/android/SingleFragmentWrapper;

    return-object v0
.end method

.method private fetchPostId(I)V
    .locals 1
    .param p1, "fetchType"    # I

    .prologue
    .line 89
    iget-object v0, p0, Lco/vine/android/SingleFragment;->mWrapper:Lco/vine/android/SingleFragmentWrapper;

    invoke-virtual {v0}, Lco/vine/android/SingleFragmentWrapper;->isLocked()Z

    move-result v0

    if-nez v0, :cond_0

    .line 90
    iget-object v0, p0, Lco/vine/android/SingleFragment;->mWrapper:Lco/vine/android/SingleFragmentWrapper;

    invoke-virtual {v0}, Lco/vine/android/SingleFragmentWrapper;->fetchPostId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p1}, Lco/vine/android/SingleFragment;->addRequest(Ljava/lang/String;I)Ljava/lang/String;

    .line 92
    :cond_0
    return-void
.end method


# virtual methods
.method protected fetchContent(IZ)V
    .locals 0
    .param p1, "fetchType"    # I
    .param p2, "userInitiated"    # Z

    .prologue
    .line 80
    return-void
.end method

.method protected fetchPostContent(I)V
    .locals 1
    .param p1, "fetchType"    # I

    .prologue
    .line 83
    iget-object v0, p0, Lco/vine/android/SingleFragment;->mWrapper:Lco/vine/android/SingleFragmentWrapper;

    invoke-virtual {v0}, Lco/vine/android/SingleFragmentWrapper;->isLocked()Z

    move-result v0

    if-nez v0, :cond_0

    .line 84
    iget-object v0, p0, Lco/vine/android/SingleFragment;->mWrapper:Lco/vine/android/SingleFragmentWrapper;

    invoke-virtual {v0}, Lco/vine/android/SingleFragmentWrapper;->fetchPostContent()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p1}, Lco/vine/android/SingleFragment;->addRequest(Ljava/lang/String;I)Ljava/lang/String;

    .line 86
    :cond_0
    return-void
.end method

.method protected fetchPosts(IJZ)Ljava/lang/String;
    .locals 2
    .param p1, "page"    # I
    .param p2, "anchor"    # J
    .param p4, "userInitiated"    # Z

    .prologue
    .line 73
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Cannot fetch on single post"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 32
    invoke-super {p0, p1}, Lco/vine/android/BaseTimelineFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 33
    iget-object v0, p0, Lco/vine/android/SingleFragment;->mWrapper:Lco/vine/android/SingleFragmentWrapper;

    invoke-virtual {v0}, Lco/vine/android/SingleFragmentWrapper;->isLocked()Z

    move-result v0

    if-nez v0, :cond_0

    .line 34
    iget-object v0, p0, Lco/vine/android/SingleFragment;->mListView:Landroid/widget/ListView;

    iget-object v1, p0, Lco/vine/android/SingleFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 36
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 23
    invoke-super {p0, p1}, Lco/vine/android/BaseTimelineFragment;->onCreate(Landroid/os/Bundle;)V

    .line 24
    iget-object v0, p0, Lco/vine/android/SingleFragment;->mWrapper:Lco/vine/android/SingleFragmentWrapper;

    new-instance v1, Lco/vine/android/SingleFragment$SinglePostListener;

    invoke-direct {v1, p0}, Lco/vine/android/SingleFragment$SinglePostListener;-><init>(Lco/vine/android/SingleFragment;)V

    invoke-virtual {v0, p0, v1}, Lco/vine/android/SingleFragmentWrapper;->onCreate(Lco/vine/android/BaseControllerFragment;Lco/vine/android/client/AppSessionListener;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 25
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lco/vine/android/SingleFragment;->setFocused(Z)V

    .line 27
    :cond_0
    const-string v0, "Single Post"

    invoke-virtual {p0, v0}, Lco/vine/android/SingleFragment;->setFlurryEventSource(Ljava/lang/String;)V

    .line 28
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 41
    iget-object v0, p0, Lco/vine/android/SingleFragment;->mWrapper:Lco/vine/android/SingleFragmentWrapper;

    invoke-virtual {v0}, Lco/vine/android/SingleFragmentWrapper;->isLocked()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 42
    iget-object v0, p0, Lco/vine/android/SingleFragment;->mWrapper:Lco/vine/android/SingleFragmentWrapper;

    const v1, 0x7f03006a

    invoke-virtual {p0, p1, v1, p2}, Lco/vine/android/SingleFragment;->createView(Landroid/view/LayoutInflater;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v0, v1, p0}, Lco/vine/android/SingleFragmentWrapper;->onCreateLockedView(Landroid/view/View;Lco/vine/android/widget/SpanClickListener;)Landroid/view/View;

    move-result-object v0

    .line 44
    :goto_0
    return-object v0

    :cond_0
    invoke-super {p0, p1, p2, p3}, Lco/vine/android/BaseTimelineFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    move-result-object v0

    goto :goto_0
.end method

.method public onPause()V
    .locals 2

    .prologue
    .line 66
    invoke-super {p0}, Lco/vine/android/BaseTimelineFragment;->onPause()V

    .line 67
    iget-object v0, p0, Lco/vine/android/SingleFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {p0}, Lco/vine/android/SingleFragment;->isFocused()Z

    move-result v1

    invoke-virtual {v0, v1}, Lco/vine/android/widget/GenericTimelineAdapter;->onPause(Z)V

    .line 68
    iget-object v0, p0, Lco/vine/android/SingleFragment;->mWrapper:Lco/vine/android/SingleFragmentWrapper;

    invoke-virtual {v0}, Lco/vine/android/SingleFragmentWrapper;->onPause()V

    .line 69
    return-void
.end method

.method public onResume()V
    .locals 5

    .prologue
    const/4 v4, 0x3

    .line 50
    invoke-super {p0}, Lco/vine/android/BaseTimelineFragment;->onResume()V

    .line 51
    iget-object v0, p0, Lco/vine/android/SingleFragment;->mWrapper:Lco/vine/android/SingleFragmentWrapper;

    invoke-virtual {v0}, Lco/vine/android/SingleFragmentWrapper;->onResume()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 52
    iget-object v0, p0, Lco/vine/android/SingleFragment;->mFeedAdapter:Lco/vine/android/widget/GenericTimelineAdapter;

    invoke-virtual {p0}, Lco/vine/android/SingleFragment;->isFocused()Z

    move-result v1

    invoke-virtual {v0, v1}, Lco/vine/android/widget/GenericTimelineAdapter;->onResume(Z)V

    .line 54
    iget-boolean v0, p0, Lco/vine/android/SingleFragment;->mFetched:Z

    if-nez v0, :cond_0

    .line 55
    iget-object v0, p0, Lco/vine/android/SingleFragment;->mWrapper:Lco/vine/android/SingleFragmentWrapper;

    invoke-virtual {v0}, Lco/vine/android/SingleFragmentWrapper;->getPostId()J

    move-result-wide v0

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-lez v0, :cond_1

    .line 56
    invoke-virtual {p0, v4}, Lco/vine/android/SingleFragment;->fetchPostContent(I)V

    .line 62
    :cond_0
    :goto_0
    return-void

    .line 57
    :cond_1
    iget-object v0, p0, Lco/vine/android/SingleFragment;->mWrapper:Lco/vine/android/SingleFragmentWrapper;

    invoke-virtual {v0}, Lco/vine/android/SingleFragmentWrapper;->getSharedId()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 58
    invoke-direct {p0, v4}, Lco/vine/android/SingleFragment;->fetchPostId(I)V

    goto :goto_0
.end method

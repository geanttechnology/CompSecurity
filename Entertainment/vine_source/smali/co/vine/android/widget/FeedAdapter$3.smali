.class Lco/vine/android/widget/FeedAdapter$3;
.super Ljava/lang/Object;
.source "FeedAdapter.java"

# interfaces
.implements Lco/vine/android/player/VideoViewInterface$OnCompletionListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/widget/FeedAdapter;->initVideoView(ILco/vine/android/widget/FeedViewHolder;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/widget/FeedAdapter;

.field final synthetic val$tag:Lco/vine/android/widget/FeedViewHolder;


# direct methods
.method constructor <init>(Lco/vine/android/widget/FeedAdapter;Lco/vine/android/widget/FeedViewHolder;)V
    .locals 0

    .prologue
    .line 454
    iput-object p1, p0, Lco/vine/android/widget/FeedAdapter$3;->this$0:Lco/vine/android/widget/FeedAdapter;

    iput-object p2, p0, Lco/vine/android/widget/FeedAdapter$3;->val$tag:Lco/vine/android/widget/FeedViewHolder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCompletion(Lco/vine/android/player/VideoViewInterface;)V
    .locals 4
    .param p1, "videoView"    # Lco/vine/android/player/VideoViewInterface;

    .prologue
    .line 457
    const/4 v1, 0x0

    invoke-interface {p1, v1}, Lco/vine/android/player/VideoViewInterface;->seekTo(I)V

    .line 458
    iget-object v1, p0, Lco/vine/android/widget/FeedAdapter$3;->this$0:Lco/vine/android/widget/FeedAdapter;

    iget-object v2, p0, Lco/vine/android/widget/FeedAdapter$3;->val$tag:Lco/vine/android/widget/FeedViewHolder;

    iget-object v2, v2, Lco/vine/android/widget/FeedViewHolder;->post:Lco/vine/android/api/VinePost;

    iget-wide v2, v2, Lco/vine/android/api/VinePost;->postId:J

    # invokes: Lco/vine/android/widget/FeedAdapter;->countedMediaPlayerStart(Lco/vine/android/player/VideoViewInterface;J)V
    invoke-static {v1, p1, v2, v3}, Lco/vine/android/widget/FeedAdapter;->access$100(Lco/vine/android/widget/FeedAdapter;Lco/vine/android/player/VideoViewInterface;J)V

    .line 459
    iget-object v1, p0, Lco/vine/android/widget/FeedAdapter$3;->this$0:Lco/vine/android/widget/FeedAdapter;

    iget-object v2, p0, Lco/vine/android/widget/FeedAdapter$3;->this$0:Lco/vine/android/widget/FeedAdapter;

    # getter for: Lco/vine/android/widget/FeedAdapter;->mCurrentPlaying:I
    invoke-static {v2}, Lco/vine/android/widget/FeedAdapter;->access$000(Lco/vine/android/widget/FeedAdapter;)I

    move-result v2

    # invokes: Lco/vine/android/widget/FeedAdapter;->getPost(I)Lco/vine/android/api/VinePost;
    invoke-static {v1, v2}, Lco/vine/android/widget/FeedAdapter;->access$600(Lco/vine/android/widget/FeedAdapter;I)Lco/vine/android/api/VinePost;

    move-result-object v0

    .line 460
    .local v0, "post":Lco/vine/android/api/VinePost;
    if-eqz v0, :cond_0

    .line 461
    iget-object v1, p0, Lco/vine/android/widget/FeedAdapter$3;->val$tag:Lco/vine/android/widget/FeedViewHolder;

    iget-object v1, v1, Lco/vine/android/widget/FeedViewHolder;->counterView:Lco/vine/android/widget/CounterView;

    iget-wide v2, v0, Lco/vine/android/api/VinePost;->postId:J

    invoke-static {v2, v3}, Lco/vine/android/util/LoopManager;->getLocalLoopCount(J)I

    move-result v2

    int-to-long v2, v2

    invoke-virtual {v1, v2, v3}, Lco/vine/android/widget/CounterView;->adjustExtraCount(J)V

    .line 462
    iget-object v1, p0, Lco/vine/android/widget/FeedAdapter$3;->val$tag:Lco/vine/android/widget/FeedViewHolder;

    iget-object v1, v1, Lco/vine/android/widget/FeedViewHolder;->counterView:Lco/vine/android/widget/CounterView;

    invoke-virtual {v1}, Lco/vine/android/widget/CounterView;->invalidateCounterUI()V

    .line 464
    :cond_0
    invoke-static {}, Lco/vine/android/util/FlurryUtils;->trackVineLoopWatched()V

    .line 465
    return-void
.end method

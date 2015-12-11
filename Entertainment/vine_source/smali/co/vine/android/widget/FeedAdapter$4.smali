.class Lco/vine/android/widget/FeedAdapter$4;
.super Ljava/lang/Object;
.source "FeedAdapter.java"

# interfaces
.implements Lco/vine/android/player/SdkVideoView$SurfaceReadyListener;


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


# direct methods
.method constructor <init>(Lco/vine/android/widget/FeedAdapter;)V
    .locals 0

    .prologue
    .line 467
    iput-object p1, p0, Lco/vine/android/widget/FeedAdapter$4;->this$0:Lco/vine/android/widget/FeedAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onSurfaceTextureAvailable(Lco/vine/android/player/SdkVideoView;)V
    .locals 1
    .param p1, "videoView"    # Lco/vine/android/player/SdkVideoView;

    .prologue
    .line 470
    iget-object v0, p0, Lco/vine/android/widget/FeedAdapter$4;->this$0:Lco/vine/android/widget/FeedAdapter;

    # getter for: Lco/vine/android/widget/FeedAdapter;->mHasFocus:Z
    invoke-static {v0}, Lco/vine/android/widget/FeedAdapter;->access$700(Lco/vine/android/widget/FeedAdapter;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/widget/FeedAdapter$4;->this$0:Lco/vine/android/widget/FeedAdapter;

    # getter for: Lco/vine/android/widget/FeedAdapter;->mLastPlayer:Lco/vine/android/player/SdkVideoView;
    invoke-static {v0}, Lco/vine/android/widget/FeedAdapter;->access$800(Lco/vine/android/widget/FeedAdapter;)Lco/vine/android/player/SdkVideoView;

    move-result-object v0

    if-ne p1, v0, :cond_0

    .line 471
    invoke-virtual {p1}, Lco/vine/android/player/SdkVideoView;->startOpenVideo()V

    .line 473
    :cond_0
    return-void
.end method

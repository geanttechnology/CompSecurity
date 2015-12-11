.class Lco/vine/android/ConversationAdapter$5;
.super Ljava/lang/Object;
.source "ConversationAdapter.java"

# interfaces
.implements Lco/vine/android/player/VideoViewInterface$OnCompletionListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/ConversationAdapter;->initVideoView(ILco/vine/android/ConversationAdapter$ConversationViewHolder;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/ConversationAdapter;

.field final synthetic val$position:I

.field final synthetic val$view:Lco/vine/android/player/SdkVideoView;


# direct methods
.method constructor <init>(Lco/vine/android/ConversationAdapter;Lco/vine/android/player/SdkVideoView;I)V
    .locals 0

    .prologue
    .line 975
    iput-object p1, p0, Lco/vine/android/ConversationAdapter$5;->this$0:Lco/vine/android/ConversationAdapter;

    iput-object p2, p0, Lco/vine/android/ConversationAdapter$5;->val$view:Lco/vine/android/player/SdkVideoView;

    iput p3, p0, Lco/vine/android/ConversationAdapter$5;->val$position:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCompletion(Lco/vine/android/player/VideoViewInterface;)V
    .locals 3
    .param p1, "videoView"    # Lco/vine/android/player/VideoViewInterface;

    .prologue
    .line 978
    iget-object v0, p0, Lco/vine/android/ConversationAdapter$5;->this$0:Lco/vine/android/ConversationAdapter;

    iget-object v1, p0, Lco/vine/android/ConversationAdapter$5;->val$view:Lco/vine/android/player/SdkVideoView;

    iget v2, p0, Lco/vine/android/ConversationAdapter$5;->val$position:I

    # invokes: Lco/vine/android/ConversationAdapter;->onLoopFinished(Lco/vine/android/player/VideoViewInterface;I)Z
    invoke-static {v0, v1, v2}, Lco/vine/android/ConversationAdapter;->access$600(Lco/vine/android/ConversationAdapter;Lco/vine/android/player/VideoViewInterface;I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 979
    const/4 v0, 0x0

    invoke-interface {p1, v0}, Lco/vine/android/player/VideoViewInterface;->seekTo(I)V

    .line 980
    iget v0, p0, Lco/vine/android/ConversationAdapter$5;->val$position:I

    iget-object v1, p0, Lco/vine/android/ConversationAdapter$5;->this$0:Lco/vine/android/ConversationAdapter;

    # getter for: Lco/vine/android/ConversationAdapter;->mSingleLoopPosition:I
    invoke-static {v1}, Lco/vine/android/ConversationAdapter;->access$800(Lco/vine/android/ConversationAdapter;)I

    move-result v1

    if-eq v0, v1, :cond_0

    .line 981
    invoke-interface {p1}, Lco/vine/android/player/VideoViewInterface;->start()V

    .line 985
    :cond_0
    return-void
.end method

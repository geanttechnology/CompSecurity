.class Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity$2;
.super Ljava/lang/Object;
.source "VideoPlayerActivity.java"

# interfaces
.implements Lcom/comcast/cim/android/view/common/OrientationStrategy;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;

    .prologue
    .line 281
    iput-object p1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity$2;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAppropriateOrientation()I
    .locals 1

    .prologue
    .line 284
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity$2;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->access$100(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;)Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->getLandscapeOrientation()I

    move-result v0

    return v0
.end method

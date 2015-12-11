.class Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity$1;
.super Ljava/lang/Object;
.source "VideoPlayerActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->onCreate(Landroid/os/Bundle;)V
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
    .line 84
    iput-object p1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity$1;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 87
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity$1;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->appirater:Lcom/ijsbrandslob/appirater/Appirater;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->access$000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;)Lcom/ijsbrandslob/appirater/Appirater;

    move-result-object v0

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity$1;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;

    invoke-virtual {v0, v1, v2}, Lcom/ijsbrandslob/appirater/Appirater;->userDidSignificantEvent(ZLandroid/app/Activity;)V

    .line 88
    return-void
.end method

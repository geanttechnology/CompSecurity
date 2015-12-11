.class Lco/vine/android/player/SdkVideoView$8;
.super Ljava/lang/Object;
.source "SdkVideoView.java"

# interfaces
.implements Landroid/media/MediaPlayer$OnBufferingUpdateListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/player/SdkVideoView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/player/SdkVideoView;


# direct methods
.method constructor <init>(Lco/vine/android/player/SdkVideoView;)V
    .locals 0

    .prologue
    .line 603
    iput-object p1, p0, Lco/vine/android/player/SdkVideoView$8;->this$0:Lco/vine/android/player/SdkVideoView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onBufferingUpdate(Landroid/media/MediaPlayer;I)V
    .locals 1
    .param p1, "mp"    # Landroid/media/MediaPlayer;
    .param p2, "percent"    # I

    .prologue
    .line 605
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView$8;->this$0:Lco/vine/android/player/SdkVideoView;

    # setter for: Lco/vine/android/player/SdkVideoView;->mCurrentBufferPercentage:I
    invoke-static {v0, p2}, Lco/vine/android/player/SdkVideoView;->access$2202(Lco/vine/android/player/SdkVideoView;I)I

    .line 606
    return-void
.end method

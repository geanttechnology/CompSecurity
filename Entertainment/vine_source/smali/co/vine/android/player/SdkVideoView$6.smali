.class Lco/vine/android/player/SdkVideoView$6;
.super Ljava/lang/Object;
.source "SdkVideoView.java"

# interfaces
.implements Landroid/media/MediaPlayer$OnCompletionListener;


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
    .line 560
    iput-object p1, p0, Lco/vine/android/player/SdkVideoView$6;->this$0:Lco/vine/android/player/SdkVideoView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCompletion(Landroid/media/MediaPlayer;)V
    .locals 1
    .param p1, "mp"    # Landroid/media/MediaPlayer;

    .prologue
    .line 562
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView$6;->this$0:Lco/vine/android/player/SdkVideoView;

    # invokes: Lco/vine/android/player/SdkVideoView;->onComplete()V
    invoke-static {v0}, Lco/vine/android/player/SdkVideoView;->access$2000(Lco/vine/android/player/SdkVideoView;)V

    .line 563
    return-void
.end method

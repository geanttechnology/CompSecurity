.class Lco/vine/android/player/SdkVideoView$7;
.super Ljava/lang/Object;
.source "SdkVideoView.java"

# interfaces
.implements Landroid/media/MediaPlayer$OnErrorListener;


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
    .line 578
    iput-object p1, p0, Lco/vine/android/player/SdkVideoView$7;->this$0:Lco/vine/android/player/SdkVideoView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Landroid/media/MediaPlayer;II)Z
    .locals 1
    .param p1, "mp"    # Landroid/media/MediaPlayer;
    .param p2, "framework_err"    # I
    .param p3, "impl_err"    # I

    .prologue
    .line 580
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView$7;->this$0:Lco/vine/android/player/SdkVideoView;

    # invokes: Lco/vine/android/player/SdkVideoView;->onError(II)Z
    invoke-static {v0, p2, p3}, Lco/vine/android/player/SdkVideoView;->access$2100(Lco/vine/android/player/SdkVideoView;II)Z

    .line 581
    const/4 v0, 0x1

    return v0
.end method

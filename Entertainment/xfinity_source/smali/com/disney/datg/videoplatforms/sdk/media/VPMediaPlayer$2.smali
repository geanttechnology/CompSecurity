.class Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$2;
.super Ljava/lang/Object;
.source "VPMediaPlayer.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->setClosedCaptionContainer(Landroid/widget/RelativeLayout;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

.field final synthetic val$ccContainer:Landroid/widget/RelativeLayout;


# direct methods
.method constructor <init>(Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;Landroid/widget/RelativeLayout;)V
    .locals 0

    .prologue
    .line 978
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$2;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    iput-object p2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$2;->val$ccContainer:Landroid/widget/RelativeLayout;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 981
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$2;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$2;->val$ccContainer:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v1}, Lcom/uplynk/media/MediaPlayer;->setCaptionLayoutContainer(Landroid/widget/RelativeLayout;)V

    .line 982
    return-void
.end method

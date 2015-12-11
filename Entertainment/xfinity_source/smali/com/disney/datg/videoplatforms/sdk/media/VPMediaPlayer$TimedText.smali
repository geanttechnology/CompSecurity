.class public Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TimedText;
.super Ljava/lang/Object;
.source "VPMediaPlayer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "TimedText"
.end annotation


# instance fields
.field captionData:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;

.field text:Ljava/lang/String;

.field final synthetic this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;


# direct methods
.method protected constructor <init>(Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;)V
    .locals 0
    .param p2, "text"    # Ljava/lang/String;
    .param p3, "captionData"    # Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;

    .prologue
    .line 93
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TimedText;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 94
    iput-object p2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TimedText;->text:Ljava/lang/String;

    .line 95
    iput-object p3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TimedText;->captionData:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;

    .line 96
    return-void
.end method

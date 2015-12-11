.class Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer$1;
.super Ljava/lang/Object;
.source "AndroidPlayer.java"

# interfaces
.implements Landroid/media/MediaPlayer$OnBufferingUpdateListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;-><init>(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;)V
    .locals 0

    .prologue
    .line 51
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer$1;->this$0:Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onBufferingUpdate(Landroid/media/MediaPlayer;I)V
    .locals 0
    .param p1, "mp"    # Landroid/media/MediaPlayer;
    .param p2, "percent"    # I

    .prologue
    .line 55
    return-void
.end method

.class Lcom/livemixtapes/LMTService$1;
.super Landroid/media/session/MediaSession$Callback;
.source "LMTService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/LMTService;->playNextSong(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/LMTService;


# direct methods
.method constructor <init>(Lcom/livemixtapes/LMTService;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/LMTService$1;->this$0:Lcom/livemixtapes/LMTService;

    .line 479
    invoke-direct {p0}, Landroid/media/session/MediaSession$Callback;-><init>()V

    return-void
.end method

.class Lcom/espn/androidplayersdk/datamanager/PlaybackSession$2;
.super Ljava/lang/Object;
.source "PlaybackSession.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->removeMaintainRequest()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;


# direct methods
.method constructor <init>(Lcom/espn/androidplayersdk/datamanager/PlaybackSession;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession$2;->this$0:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    .line 88
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 91
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/Looper;->quit()V

    .line 92
    return-void
.end method

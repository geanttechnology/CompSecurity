.class Lcom/adobe/mediacore/DefaultMediaPlayer$9;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/ViewClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/adobe/mediacore/DefaultMediaPlayer;-><init>(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;


# direct methods
.method constructor <init>(Lcom/adobe/mediacore/DefaultMediaPlayer;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$9;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick()V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$9;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_adTimelineMonitor:Lcom/adobe/mediacore/TimelineMonitor;
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$900(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/TimelineMonitor;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$9;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_adTimelineMonitor:Lcom/adobe/mediacore/TimelineMonitor;
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$900(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/TimelineMonitor;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/TimelineMonitor;->processAdClick()V

    :cond_0
    return-void
.end method

.class Lcom/adobe/mediacore/TimelineMonitor$1;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/ContentChangedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/TimelineMonitor;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/adobe/mediacore/TimelineMonitor;


# direct methods
.method constructor <init>(Lcom/adobe/mediacore/TimelineMonitor;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/TimelineMonitor$1;->this$0:Lcom/adobe/mediacore/TimelineMonitor;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onChanged(IJ)V
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor$1;->this$0:Lcom/adobe/mediacore/TimelineMonitor;

    # invokes: Lcom/adobe/mediacore/TimelineMonitor;->contentChanged(IJ)V
    invoke-static {v0, p1, p2, p3}, Lcom/adobe/mediacore/TimelineMonitor;->access$000(Lcom/adobe/mediacore/TimelineMonitor;IJ)V

    return-void
.end method

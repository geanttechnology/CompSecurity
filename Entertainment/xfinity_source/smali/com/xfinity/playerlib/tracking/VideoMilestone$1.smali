.class final enum Lcom/xfinity/playerlib/tracking/VideoMilestone$1;
.super Lcom/xfinity/playerlib/tracking/VideoMilestone;
.source "VideoMilestone.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/tracking/VideoMilestone;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4008
    name = null
.end annotation


# direct methods
.method constructor <init>(Ljava/lang/String;I)V
    .locals 1

    .prologue
    .line 12
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/xfinity/playerlib/tracking/VideoMilestone;-><init>(Ljava/lang/String;ILcom/xfinity/playerlib/tracking/VideoMilestone$1;)V

    return-void
.end method


# virtual methods
.method public getEvent()Ljava/lang/String;
    .locals 2

    .prologue
    .line 15
    # getter for: Lcom/xfinity/playerlib/tracking/VideoMilestone;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/xfinity/playerlib/tracking/VideoMilestone;->access$100()Lorg/slf4j/Logger;

    move-result-object v0

    const-string v1, "getPositionInSeconds() unexpected invocation this={}"

    invoke-interface {v0, v1, p0}, Lorg/slf4j/Logger;->warn(Ljava/lang/String;Ljava/lang/Object;)V

    .line 16
    const/4 v0, 0x0

    return-object v0
.end method

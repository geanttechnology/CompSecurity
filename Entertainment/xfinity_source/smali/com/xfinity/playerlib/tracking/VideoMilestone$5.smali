.class final enum Lcom/xfinity/playerlib/tracking/VideoMilestone$5;
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
    .line 54
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/xfinity/playerlib/tracking/VideoMilestone;-><init>(Ljava/lang/String;ILcom/xfinity/playerlib/tracking/VideoMilestone$1;)V

    return-void
.end method


# virtual methods
.method public getEvent()Ljava/lang/String;
    .locals 1

    .prologue
    .line 57
    const-string v0, "75percentWatched"

    return-object v0
.end method

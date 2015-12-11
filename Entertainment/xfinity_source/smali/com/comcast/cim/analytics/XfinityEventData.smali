.class public Lcom/comcast/cim/analytics/XfinityEventData;
.super Lcom/comcast/cim/cmasl/analytics/EventData;
.source "XfinityEventData.java"


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "ev"    # Ljava/lang/String;

    .prologue
    .line 8
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/analytics/EventData;-><init>()V

    .line 9
    const-string v0, "ev"

    invoke-virtual {p0, v0, p1}, Lcom/comcast/cim/analytics/XfinityEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 10
    return-void
.end method

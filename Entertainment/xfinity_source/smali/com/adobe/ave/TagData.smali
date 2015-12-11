.class public Lcom/adobe/ave/TagData;
.super Ljava/lang/Object;
.source "TagData.java"


# instance fields
.field public data:Ljava/lang/String;

.field public time:J


# direct methods
.method private constructor <init>(Ljava/lang/String;J)V
    .locals 0
    .param p1, "aData"    # Ljava/lang/String;
    .param p2, "aTime"    # J

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    iput-object p1, p0, Lcom/adobe/ave/TagData;->data:Ljava/lang/String;

    .line 29
    iput-wide p2, p0, Lcom/adobe/ave/TagData;->time:J

    .line 30
    return-void
.end method

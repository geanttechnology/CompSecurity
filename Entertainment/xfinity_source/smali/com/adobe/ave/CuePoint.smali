.class public Lcom/adobe/ave/CuePoint;
.super Ljava/lang/Object;
.source "CuePoint.java"


# instance fields
.field public dictionary:Lcom/adobe/ave/Dictionary;

.field public localTime:J


# direct methods
.method private constructor <init>(JLcom/adobe/ave/Dictionary;)V
    .locals 1
    .param p1, "alocalTime"    # J
    .param p3, "aDictionary"    # Lcom/adobe/ave/Dictionary;

    .prologue
    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    iput-wide p1, p0, Lcom/adobe/ave/CuePoint;->localTime:J

    .line 39
    iput-object p3, p0, Lcom/adobe/ave/CuePoint;->dictionary:Lcom/adobe/ave/Dictionary;

    .line 40
    return-void
.end method

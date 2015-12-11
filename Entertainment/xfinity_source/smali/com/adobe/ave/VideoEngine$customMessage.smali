.class Lcom/adobe/ave/VideoEngine$customMessage;
.super Ljava/lang/Object;
.source "VideoEngine.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/ave/VideoEngine;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "customMessage"
.end annotation


# instance fields
.field m_l1:J

.field m_l2:J

.field m_n1:I

.field m_n2:I

.field m_obj:Ljava/lang/Object;


# direct methods
.method private constructor <init>(IIJJLjava/lang/Object;)V
    .locals 1
    .param p1, "n1"    # I
    .param p2, "n2"    # I
    .param p3, "l1"    # J
    .param p5, "l2"    # J
    .param p7, "aObj"    # Ljava/lang/Object;

    .prologue
    .line 1129
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1130
    iput p1, p0, Lcom/adobe/ave/VideoEngine$customMessage;->m_n1:I

    .line 1131
    iput p2, p0, Lcom/adobe/ave/VideoEngine$customMessage;->m_n2:I

    .line 1132
    iput-wide p3, p0, Lcom/adobe/ave/VideoEngine$customMessage;->m_l1:J

    .line 1133
    iput-wide p5, p0, Lcom/adobe/ave/VideoEngine$customMessage;->m_l2:J

    .line 1134
    iput-object p7, p0, Lcom/adobe/ave/VideoEngine$customMessage;->m_obj:Ljava/lang/Object;

    .line 1135
    return-void
.end method

.method synthetic constructor <init>(IIJJLjava/lang/Object;Lcom/adobe/ave/VideoEngine$1;)V
    .locals 1
    .param p1, "x0"    # I
    .param p2, "x1"    # I
    .param p3, "x2"    # J
    .param p5, "x3"    # J
    .param p7, "x4"    # Ljava/lang/Object;
    .param p8, "x5"    # Lcom/adobe/ave/VideoEngine$1;

    .prologue
    .line 1126
    invoke-direct/range {p0 .. p7}, Lcom/adobe/ave/VideoEngine$customMessage;-><init>(IIJJLjava/lang/Object;)V

    return-void
.end method

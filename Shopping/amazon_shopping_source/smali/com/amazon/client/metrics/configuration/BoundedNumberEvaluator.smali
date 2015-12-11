.class public Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;
.super Ljava/lang/Object;
.source "BoundedNumberEvaluator.java"


# instance fields
.field log:Lcom/amazon/dp/logger/DPLogger;

.field final mFieldName:Ljava/lang/String;

.field final mMax:J

.field final mMin:J

.field final mValue:J


# direct methods
.method public constructor <init>(Ljava/lang/String;JJJ)V
    .locals 7
    .param p1, "fieldName"    # Ljava/lang/String;
    .param p2, "min"    # J
    .param p4, "max"    # J
    .param p6, "value"    # J

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    new-instance v0, Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "BoundedNumberEvaluator"

    invoke-direct {v0, v1}, Lcom/amazon/dp/logger/DPLogger;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;->log:Lcom/amazon/dp/logger/DPLogger;

    .line 22
    iput-wide p2, p0, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;->mMin:J

    .line 23
    iput-wide p4, p0, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;->mMax:J

    .line 24
    iget-wide v0, p0, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;->mMin:J

    cmp-long v0, p6, v0

    if-gez v0, :cond_0

    .line 25
    iget-object v0, p0, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "fieldName"

    const-string/jumbo v2, "value"

    const/4 v3, 0x5

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {p6, p7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    const-string/jumbo v5, "less than min value"

    aput-object v5, v3, v4

    const/4 v4, 0x2

    iget-wide v5, p0, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;->mMin:J

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x3

    const-string/jumbo v5, "field name"

    aput-object v5, v3, v4

    const/4 v4, 0x4

    const-string/jumbo v5, "using min value"

    aput-object v5, v3, v4

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/dp/logger/DPLogger;->verbose(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 28
    iget-wide v0, p0, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;->mMin:J

    iput-wide v0, p0, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;->mValue:J

    .line 36
    :goto_0
    iput-object p1, p0, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;->mFieldName:Ljava/lang/String;

    .line 37
    return-void

    .line 29
    :cond_0
    iget-wide v0, p0, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;->mMax:J

    cmp-long v0, p6, v0

    if-lez v0, :cond_1

    .line 30
    iget-object v0, p0, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "fieldName"

    const-string/jumbo v2, "value"

    const/4 v3, 0x4

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {p6, p7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    const-string/jumbo v5, "greater than max value"

    aput-object v5, v3, v4

    const/4 v4, 0x2

    iget-wide v5, p0, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;->mMax:J

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x3

    const-string/jumbo v5, "using max value"

    aput-object v5, v3, v4

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/dp/logger/DPLogger;->verbose(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 32
    iget-wide v0, p0, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;->mMax:J

    iput-wide v0, p0, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;->mValue:J

    goto :goto_0

    .line 34
    :cond_1
    iput-wide p6, p0, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;->mValue:J

    goto :goto_0
.end method


# virtual methods
.method public getValue()J
    .locals 2

    .prologue
    .line 43
    iget-wide v0, p0, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;->mValue:J

    return-wide v0
.end method

.class Lcom/penthera/virtuososdk/download/Downloader$Throughput;
.super Ljava/lang/Object;
.source "Downloader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/download/Downloader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "Throughput"
.end annotation


# instance fields
.field private byteCount:D

.field private interFrom:J

.field private interval:J

.field final synthetic this$0:Lcom/penthera/virtuososdk/download/Downloader;


# direct methods
.method constructor <init>(Lcom/penthera/virtuososdk/download/Downloader;)V
    .locals 4

    .prologue
    const-wide/16 v2, 0x0

    .line 884
    iput-object p1, p0, Lcom/penthera/virtuososdk/download/Downloader$Throughput;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 885
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/penthera/virtuososdk/download/Downloader$Throughput;->byteCount:D

    .line 886
    iput-wide v2, p0, Lcom/penthera/virtuososdk/download/Downloader$Throughput;->interval:J

    .line 887
    iput-wide v2, p0, Lcom/penthera/virtuososdk/download/Downloader$Throughput;->interFrom:J

    return-void
.end method


# virtual methods
.method public mbs()D
    .locals 4

    .prologue
    .line 896
    iget-wide v0, p0, Lcom/penthera/virtuososdk/download/Downloader$Throughput;->interval:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-lez v0, :cond_0

    .line 897
    iget-wide v0, p0, Lcom/penthera/virtuososdk/download/Downloader$Throughput;->byteCount:D

    const-wide/high16 v2, 0x4100000000000000L    # 131072.0

    div-double/2addr v0, v2

    iget-wide v2, p0, Lcom/penthera/virtuososdk/download/Downloader$Throughput;->interval:J

    long-to-double v2, v2

    div-double/2addr v0, v2

    .line 899
    :goto_0
    return-wide v0

    :cond_0
    const-wide/16 v0, 0x0

    goto :goto_0
.end method

.method public reset()V
    .locals 2

    .prologue
    .line 902
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/penthera/virtuososdk/download/Downloader$Throughput;->interval:J

    .line 903
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/penthera/virtuososdk/download/Downloader$Throughput;->byteCount:D

    .line 904
    return-void
.end method

.method public signalStart()V
    .locals 4

    .prologue
    .line 888
    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    invoke-virtual {v0}, Ljava/util/Date;->getTime()J

    move-result-wide v0

    const-wide/16 v2, 0x3e8

    div-long/2addr v0, v2

    iput-wide v0, p0, Lcom/penthera/virtuososdk/download/Downloader$Throughput;->interFrom:J

    return-void
.end method

.method public update(J)V
    .locals 7
    .param p1, "bytes"    # J

    .prologue
    .line 890
    new-instance v2, Ljava/util/Date;

    invoke-direct {v2}, Ljava/util/Date;-><init>()V

    invoke-virtual {v2}, Ljava/util/Date;->getTime()J

    move-result-wide v2

    const-wide/16 v4, 0x3e8

    div-long v0, v2, v4

    .line 891
    .local v0, "curr":J
    iget-wide v2, p0, Lcom/penthera/virtuososdk/download/Downloader$Throughput;->interval:J

    iget-wide v4, p0, Lcom/penthera/virtuososdk/download/Downloader$Throughput;->interFrom:J

    sub-long v4, v0, v4

    add-long/2addr v2, v4

    iput-wide v2, p0, Lcom/penthera/virtuososdk/download/Downloader$Throughput;->interval:J

    .line 892
    iget-wide v2, p0, Lcom/penthera/virtuososdk/download/Downloader$Throughput;->byteCount:D

    long-to-double v4, p1

    add-double/2addr v2, v4

    iput-wide v2, p0, Lcom/penthera/virtuososdk/download/Downloader$Throughput;->byteCount:D

    .line 893
    iput-wide v0, p0, Lcom/penthera/virtuososdk/download/Downloader$Throughput;->interFrom:J

    .line 894
    return-void
.end method

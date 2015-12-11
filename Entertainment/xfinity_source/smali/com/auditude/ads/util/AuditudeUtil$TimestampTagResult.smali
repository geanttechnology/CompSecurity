.class public Lcom/auditude/ads/util/AuditudeUtil$TimestampTagResult;
.super Ljava/lang/Object;
.source "AuditudeUtil.java"

# interfaces
.implements Lcom/auditude/ads/util/AuditudeUtil$ITagResult;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/auditude/ads/util/AuditudeUtil;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TimestampTagResult"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 147
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getResult()Ljava/lang/String;
    .locals 4

    .prologue
    .line 151
    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    invoke-virtual {v0}, Ljava/util/Date;->getTime()J

    move-result-wide v0

    const-wide/16 v2, 0x3e8

    div-long/2addr v0, v2

    invoke-static {v0, v1}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

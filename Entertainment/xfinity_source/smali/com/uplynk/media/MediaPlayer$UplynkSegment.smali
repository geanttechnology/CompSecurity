.class public Lcom/uplynk/media/MediaPlayer$UplynkSegment;
.super Ljava/lang/Object;
.source "MediaPlayer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/uplynk/media/MediaPlayer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "UplynkSegment"
.end annotation


# instance fields
.field protected _assetId:Ljava/lang/String;

.field protected _duration:D

.field protected _offset:D

.field protected _type:C

.field final synthetic this$0:Lcom/uplynk/media/MediaPlayer;


# direct methods
.method protected constructor <init>(Lcom/uplynk/media/MediaPlayer;)V
    .locals 0

    .prologue
    .line 1493
    iput-object p1, p0, Lcom/uplynk/media/MediaPlayer$UplynkSegment;->this$0:Lcom/uplynk/media/MediaPlayer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method protected constructor <init>(Lcom/uplynk/media/MediaPlayer;CDDLjava/lang/String;)V
    .locals 1
    .param p2, "type"    # C
    .param p3, "duration"    # D
    .param p5, "offset"    # D
    .param p7, "assetId"    # Ljava/lang/String;

    .prologue
    .line 1495
    iput-object p1, p0, Lcom/uplynk/media/MediaPlayer$UplynkSegment;->this$0:Lcom/uplynk/media/MediaPlayer;

    .line 1494
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1496
    iput-char p2, p0, Lcom/uplynk/media/MediaPlayer$UplynkSegment;->_type:C

    .line 1497
    iput-wide p3, p0, Lcom/uplynk/media/MediaPlayer$UplynkSegment;->_duration:D

    .line 1498
    iput-wide p5, p0, Lcom/uplynk/media/MediaPlayer$UplynkSegment;->_offset:D

    .line 1499
    iput-object p7, p0, Lcom/uplynk/media/MediaPlayer$UplynkSegment;->_assetId:Ljava/lang/String;

    .line 1500
    return-void
.end method


# virtual methods
.method public getAssetId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1505
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer$UplynkSegment;->_assetId:Ljava/lang/String;

    return-object v0
.end method

.method public getDuration()D
    .locals 2

    .prologue
    .line 1503
    iget-wide v0, p0, Lcom/uplynk/media/MediaPlayer$UplynkSegment;->_duration:D

    return-wide v0
.end method

.method public getOffset()D
    .locals 2

    .prologue
    .line 1504
    iget-wide v0, p0, Lcom/uplynk/media/MediaPlayer$UplynkSegment;->_offset:D

    return-wide v0
.end method

.method public getType()C
    .locals 1

    .prologue
    .line 1502
    iget-char v0, p0, Lcom/uplynk/media/MediaPlayer$UplynkSegment;->_type:C

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 1508
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "["

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-char v1, p0, Lcom/uplynk/media/MediaPlayer$UplynkSegment;->_type:C

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "] "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/uplynk/media/MediaPlayer$UplynkSegment;->_assetId:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

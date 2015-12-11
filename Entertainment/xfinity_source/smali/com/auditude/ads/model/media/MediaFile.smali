.class public Lcom/auditude/ads/model/media/MediaFile;
.super Ljava/lang/Object;
.source "MediaFile.java"


# instance fields
.field public apiFramework:Ljava/lang/String;

.field public bitrate:I

.field public delivery:Ljava/lang/String;

.field public height:I

.field public id:Ljava/lang/String;

.field public maintainAspectRatio:Z

.field public mimeType:Ljava/lang/String;

.field public scalable:Z

.field public source:Ljava/lang/String;

.field public width:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    iput v0, p0, Lcom/auditude/ads/model/media/MediaFile;->bitrate:I

    .line 22
    iput v0, p0, Lcom/auditude/ads/model/media/MediaFile;->width:I

    .line 23
    iput v0, p0, Lcom/auditude/ads/model/media/MediaFile;->height:I

    .line 24
    return-void
.end method

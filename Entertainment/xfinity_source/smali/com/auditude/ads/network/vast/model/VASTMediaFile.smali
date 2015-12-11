.class public Lcom/auditude/ads/network/vast/model/VASTMediaFile;
.super Ljava/lang/Object;
.source "VASTMediaFile.java"


# instance fields
.field public apiFramework:Ljava/lang/String;

.field public bitrate:I

.field public delivery:Ljava/lang/String;

.field public height:I

.field public id:Ljava/lang/String;

.field public maintainAspectRatio:Z

.field public scalable:Z

.field public type:Ljava/lang/String;

.field public url:Ljava/lang/String;

.field public width:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    const/4 v0, 0x0

    iput v0, p0, Lcom/auditude/ads/network/vast/model/VASTMediaFile;->bitrate:I

    .line 6
    return-void
.end method

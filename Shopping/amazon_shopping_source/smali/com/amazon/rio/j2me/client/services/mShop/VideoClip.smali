.class public Lcom/amazon/rio/j2me/client/services/mShop/VideoClip;
.super Ljava/lang/Object;
.source "VideoClip.java"


# instance fields
.field private clipId:Ljava/lang/String;

.field private segmentId:Ljava/lang/String;

.field private slateImageHeight:Ljava/lang/Integer;

.field private slateImageUrl:Ljava/lang/String;

.field private slateImageWidth:Ljava/lang/Integer;

.field private title:Ljava/lang/String;

.field private videoFiles:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/VideoFile;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public setClipId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 28
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/VideoClip;->clipId:Ljava/lang/String;

    .line 29
    return-void
.end method

.method public setSegmentId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 38
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/VideoClip;->segmentId:Ljava/lang/String;

    .line 39
    return-void
.end method

.method public setSlateImageHeight(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 87
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/VideoClip;->slateImageHeight:Ljava/lang/Integer;

    .line 88
    return-void
.end method

.method public setSlateImageUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 61
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/VideoClip;->slateImageUrl:Ljava/lang/String;

    .line 62
    return-void
.end method

.method public setSlateImageWidth(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 74
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/VideoClip;->slateImageWidth:Ljava/lang/Integer;

    .line 75
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 48
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/VideoClip;->title:Ljava/lang/String;

    .line 49
    return-void
.end method

.method public setVideoFiles(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/VideoFile;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 97
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/VideoFile;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/VideoClip;->videoFiles:Ljava/util/List;

    .line 98
    return-void
.end method

.class public Lcom/amazon/rio/j2me/client/services/mShop/VideoFile;
.super Ljava/lang/Object;
.source "VideoFile.java"


# instance fields
.field private bitRate:I

.field private duration:Ljava/lang/String;

.field private mediaUrl:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public setBitRate(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 34
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/VideoFile;->bitRate:I

    .line 35
    return-void
.end method

.method public setDuration(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 24
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/VideoFile;->duration:Ljava/lang/String;

    .line 25
    return-void
.end method

.method public setMediaUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 44
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/VideoFile;->mediaUrl:Ljava/lang/String;

    .line 45
    return-void
.end method

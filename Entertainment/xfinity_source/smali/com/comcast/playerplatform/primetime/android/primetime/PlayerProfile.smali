.class public Lcom/comcast/playerplatform/primetime/android/primetime/PlayerProfile;
.super Ljava/lang/Object;
.source "PlayerProfile.java"


# instance fields
.field private bitrate:I

.field private height:I

.field private width:I


# direct methods
.method public constructor <init>(III)V
    .locals 0
    .param p1, "bitrate"    # I
    .param p2, "width"    # I
    .param p3, "height"    # I

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    iput p1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerProfile;->bitrate:I

    .line 14
    iput p2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerProfile;->width:I

    .line 15
    iput p3, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerProfile;->height:I

    .line 16
    return-void
.end method


# virtual methods
.method public getBitrate()I
    .locals 1

    .prologue
    .line 19
    iget v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerProfile;->bitrate:I

    return v0
.end method

.method public getHeight()I
    .locals 1

    .prologue
    .line 27
    iget v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerProfile;->height:I

    return v0
.end method

.method public getWidth()I
    .locals 1

    .prologue
    .line 23
    iget v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerProfile;->width:I

    return v0
.end method

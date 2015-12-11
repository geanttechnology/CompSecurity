.class public Lcom/amazon/rio/j2me/client/services/mShop/TrackListing;
.super Ljava/lang/Object;
.source "TrackListing.java"


# instance fields
.field private duration:Ljava/lang/String;

.field private mediaUrl:Ljava/lang/String;

.field private title:Ljava/lang/String;

.field private trackNumber:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public setDuration(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 48
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/TrackListing;->duration:Ljava/lang/String;

    .line 49
    return-void
.end method

.method public setMediaUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 61
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/TrackListing;->mediaUrl:Ljava/lang/String;

    .line 62
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 25
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/TrackListing;->title:Ljava/lang/String;

    .line 26
    return-void
.end method

.method public setTrackNumber(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 35
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/TrackListing;->trackNumber:Ljava/lang/String;

    .line 36
    return-void
.end method

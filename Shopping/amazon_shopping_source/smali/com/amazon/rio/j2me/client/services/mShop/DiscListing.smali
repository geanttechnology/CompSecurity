.class public Lcom/amazon/rio/j2me/client/services/mShop/DiscListing;
.super Ljava/lang/Object;
.source "DiscListing.java"


# instance fields
.field private title:Ljava/lang/String;

.field private tracks:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/TrackListing;",
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
.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 23
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/DiscListing;->title:Ljava/lang/String;

    .line 24
    return-void
.end method

.method public setTracks(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/TrackListing;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 33
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/TrackListing;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/DiscListing;->tracks:Ljava/util/List;

    .line 34
    return-void
.end method

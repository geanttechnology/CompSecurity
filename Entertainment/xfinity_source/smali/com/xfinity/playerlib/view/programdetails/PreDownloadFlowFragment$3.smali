.class final Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$3;
.super Ljava/lang/Object;
.source "PreDownloadFlowFragment.java"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 161
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public compare(Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;)I
    .locals 2
    .param p1, "a"    # Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;
    .param p2, "b"    # Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;

    .prologue
    .line 163
    invoke-virtual {p1}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;->getBandwidth()I

    move-result v0

    invoke-virtual {p2}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;->getBandwidth()I

    move-result v1

    if-ge v0, v1, :cond_0

    .line 164
    const/4 v0, -0x1

    .line 168
    :goto_0
    return v0

    .line 165
    :cond_0
    invoke-virtual {p1}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;->getBandwidth()I

    move-result v0

    invoke-virtual {p2}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;->getBandwidth()I

    move-result v1

    if-ne v0, v1, :cond_1

    .line 166
    const/4 v0, 0x0

    goto :goto_0

    .line 168
    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public bridge synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 161
    check-cast p1, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;

    check-cast p2, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;

    invoke-virtual {p0, p1, p2}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$3;->compare(Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;)I

    move-result v0

    return v0
.end method

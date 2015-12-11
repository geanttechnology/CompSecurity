.class final Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$4;
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
        "Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 173
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public compare(Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;)I
    .locals 4
    .param p1, "a"    # Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;
    .param p2, "b"    # Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;

    .prologue
    const/4 v1, 0x1

    const/4 v0, -0x1

    .line 177
    invoke-virtual {p1}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;->getLanguage()Ljava/lang/String;

    move-result-object v2

    const-string v3, "eng"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-virtual {p2}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;->getLanguage()Ljava/lang/String;

    move-result-object v2

    const-string v3, "eng"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 186
    :cond_0
    :goto_0
    return v0

    .line 179
    :cond_1
    invoke-virtual {p2}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;->getLanguage()Ljava/lang/String;

    move-result-object v2

    const-string v3, "eng"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-virtual {p1}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;->getLanguage()Ljava/lang/String;

    move-result-object v2

    const-string v3, "eng"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_2

    move v0, v1

    .line 180
    goto :goto_0

    .line 181
    :cond_2
    invoke-virtual {p1}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;->getLanguage()Ljava/lang/String;

    move-result-object v2

    const-string v3, "spa"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    invoke-virtual {p2}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;->getLanguage()Ljava/lang/String;

    move-result-object v2

    const-string v3, "spa"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 183
    :cond_3
    invoke-virtual {p2}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;->getLanguage()Ljava/lang/String;

    move-result-object v0

    const-string v2, "spa"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-virtual {p1}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;->getLanguage()Ljava/lang/String;

    move-result-object v0

    const-string v2, "spa"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_4

    move v0, v1

    .line 184
    goto :goto_0

    .line 186
    :cond_4
    invoke-virtual {p1}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;->getLanguage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;->getLanguage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v0

    goto :goto_0
.end method

.method public bridge synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 173
    check-cast p1, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;

    check-cast p2, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;

    invoke-virtual {p0, p1, p2}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$4;->compare(Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;)I

    move-result v0

    return v0
.end method

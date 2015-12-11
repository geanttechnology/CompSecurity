.class public Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;
.super Ljava/lang/Object;
.source "HalLiveStreamParseable.java"

# interfaces
.implements Landroid/os/Parcelable;
.implements Lcom/comcast/cim/cmasl/hal/model/HalParseable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field protected artworkLink:Ljava/lang/String;

.field private playbackLink:Ljava/lang/String;

.field private selfLink:Ljava/lang/String;

.field private title:Ljava/lang/String;

.field private type:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 87
    new-instance v0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable$1;

    invoke-direct {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable$1;-><init>()V

    sput-object v0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 1
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;->type:Ljava/lang/String;

    .line 24
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;->title:Ljava/lang/String;

    .line 25
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;->playbackLink:Ljava/lang/String;

    .line 26
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;->artworkLink:Ljava/lang/String;

    .line 27
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;->selfLink:Ljava/lang/String;

    .line 28
    return-void
.end method

.method public static getArtworkUrl(Ljava/lang/String;II)Ljava/lang/String;
    .locals 4
    .param p0, "template"    # Ljava/lang/String;
    .param p1, "width"    # I
    .param p2, "height"    # I

    .prologue
    .line 60
    :try_start_0
    invoke-static {p0}, Lcom/damnhandy/uri/template/UriTemplate;->fromTemplate(Ljava/lang/String;)Lcom/damnhandy/uri/template/UriTemplate;

    move-result-object v1

    const-string v2, "width"

    .line 61
    invoke-static {p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lcom/damnhandy/uri/template/UriTemplate;->set(Ljava/lang/String;Ljava/lang/Object;)Lcom/damnhandy/uri/template/UriTemplate;

    move-result-object v1

    const-string v2, "height"

    .line 62
    invoke-static {p2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lcom/damnhandy/uri/template/UriTemplate;->set(Ljava/lang/String;Ljava/lang/Object;)Lcom/damnhandy/uri/template/UriTemplate;

    move-result-object v1

    .line 63
    invoke-virtual {v1}, Lcom/damnhandy/uri/template/UriTemplate;->expand()Ljava/lang/String;
    :try_end_0
    .catch Lcom/damnhandy/uri/template/impl/ExpressionParseException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object p0

    .line 65
    .end local p0    # "template":Ljava/lang/String;
    :goto_0
    return-object p0

    .line 64
    .restart local p0    # "template":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 65
    .local v0, "e":Lcom/damnhandy/uri/template/impl/ExpressionParseException;
    goto :goto_0
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 75
    const/4 v0, 0x0

    return v0
.end method

.method public getArtworkLink()Ljava/lang/String;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;->artworkLink:Ljava/lang/String;

    return-object v0
.end method

.method public getExpandedArtworkLink(II)Ljava/lang/String;
    .locals 1
    .param p1, "width"    # I
    .param p2, "height"    # I

    .prologue
    .line 55
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;->artworkLink:Ljava/lang/String;

    invoke-static {v0, p1, p2}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;->getArtworkUrl(Ljava/lang/String;II)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getPlaybackLink()Ljava/lang/String;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;->playbackLink:Ljava/lang/String;

    return-object v0
.end method

.method public getSelfLink()Ljava/lang/String;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;->selfLink:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;->title:Ljava/lang/String;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;->type:Ljava/lang/String;

    return-object v0
.end method

.method public parseHalContent(Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;)V
    .locals 1
    .param p1, "resolver"    # Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;

    .prologue
    .line 32
    const-string v0, "playback"

    invoke-virtual {p1, v0}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalLinkAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;->playbackLink:Ljava/lang/String;

    .line 33
    const-string v0, "artwork"

    invoke-static {v0, p1}, Lcom/xfinity/playerlib/model/HalUtils;->resolveOptionalLink(Ljava/lang/String;Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;->artworkLink:Ljava/lang/String;

    .line 34
    const-string v0, "self"

    invoke-virtual {p1, v0}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalLinkAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;->selfLink:Ljava/lang/String;

    .line 35
    const-string v0, "title"

    invoke-virtual {p1, v0}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;->title:Ljava/lang/String;

    .line 36
    return-void
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1
    .param p1, "dest"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 80
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;->type:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 81
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;->title:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 82
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;->playbackLink:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 83
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;->artworkLink:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 84
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;->selfLink:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 85
    return-void
.end method

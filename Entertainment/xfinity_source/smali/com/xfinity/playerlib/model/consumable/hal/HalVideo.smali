.class public Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;
.super Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;
.source "HalVideo.java"


# instance fields
.field private contentRating:Ljava/lang/String;

.field private datePublished:Ljava/util/Date;

.field private durationInSeconds:I

.field private encodings:Ljava/util/List;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;",
            ">;"
        }
    .end annotation
.end field

.field private expirationDate:Ljava/util/Date;

.field private form:Ljava/lang/String;

.field private isAdult:Z
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "isAdult"
    .end annotation
.end field

.field private provider:Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

.field private subRating:Ljava/lang/String;

.field private videoId:J

.field private videoQuality:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 13
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;-><init>()V

    .line 31
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->encodings:Ljava/util/List;

    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 8
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 121
    if-ne p0, p1, :cond_1

    .line 165
    :cond_0
    :goto_0
    return v1

    .line 124
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 125
    goto :goto_0

    .line 127
    :cond_3
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_4

    move v1, v2

    .line 128
    goto :goto_0

    :cond_4
    move-object v0, p1

    .line 131
    check-cast v0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;

    .line 133
    .local v0, "halVideo":Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;
    iget v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->durationInSeconds:I

    iget v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->durationInSeconds:I

    if-eq v3, v4, :cond_5

    move v1, v2

    .line 134
    goto :goto_0

    .line 136
    :cond_5
    iget-boolean v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->isAdult:Z

    iget-boolean v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->isAdult:Z

    if-eq v3, v4, :cond_6

    move v1, v2

    .line 137
    goto :goto_0

    .line 139
    :cond_6
    iget-wide v4, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->videoId:J

    iget-wide v6, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->videoId:J

    cmp-long v3, v4, v6

    if-eqz v3, :cond_7

    move v1, v2

    .line 140
    goto :goto_0

    .line 142
    :cond_7
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->contentRating:Ljava/lang/String;

    if-eqz v3, :cond_9

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->contentRating:Ljava/lang/String;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->contentRating:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_a

    :cond_8
    move v1, v2

    .line 143
    goto :goto_0

    .line 142
    :cond_9
    iget-object v3, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->contentRating:Ljava/lang/String;

    if-nez v3, :cond_8

    .line 145
    :cond_a
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->datePublished:Ljava/util/Date;

    if-eqz v3, :cond_c

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->datePublished:Ljava/util/Date;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->datePublished:Ljava/util/Date;

    invoke-virtual {v3, v4}, Ljava/util/Date;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_d

    :cond_b
    move v1, v2

    .line 146
    goto :goto_0

    .line 145
    :cond_c
    iget-object v3, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->datePublished:Ljava/util/Date;

    if-nez v3, :cond_b

    .line 148
    :cond_d
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->encodings:Ljava/util/List;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->encodings:Ljava/util/List;

    invoke-interface {v3, v4}, Ljava/util/List;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_e

    move v1, v2

    .line 149
    goto :goto_0

    .line 151
    :cond_e
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->expirationDate:Ljava/util/Date;

    if-eqz v3, :cond_10

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->expirationDate:Ljava/util/Date;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->expirationDate:Ljava/util/Date;

    invoke-virtual {v3, v4}, Ljava/util/Date;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_11

    :cond_f
    move v1, v2

    .line 152
    goto :goto_0

    .line 151
    :cond_10
    iget-object v3, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->expirationDate:Ljava/util/Date;

    if-nez v3, :cond_f

    .line 154
    :cond_11
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->form:Ljava/lang/String;

    if-eqz v3, :cond_13

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->form:Ljava/lang/String;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->form:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_14

    :cond_12
    move v1, v2

    .line 155
    goto/16 :goto_0

    .line 154
    :cond_13
    iget-object v3, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->form:Ljava/lang/String;

    if-nez v3, :cond_12

    .line 157
    :cond_14
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->provider:Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    if-eqz v3, :cond_16

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->provider:Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->provider:Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_17

    :cond_15
    move v1, v2

    .line 158
    goto/16 :goto_0

    .line 157
    :cond_16
    iget-object v3, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->provider:Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    if-nez v3, :cond_15

    .line 161
    :cond_17
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->videoQuality:Ljava/lang/String;

    if-eqz v3, :cond_18

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->videoQuality:Ljava/lang/String;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->videoQuality:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    :goto_1
    move v1, v2

    .line 162
    goto/16 :goto_0

    .line 161
    :cond_18
    iget-object v3, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->videoQuality:Ljava/lang/String;

    if-eqz v3, :cond_0

    goto :goto_1
.end method

.method public getContentRating()Ljava/lang/String;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->contentRating:Ljava/lang/String;

    return-object v0
.end method

.method public getDatePublished()Ljava/util/Date;
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->datePublished:Ljava/util/Date;

    return-object v0
.end method

.method public getDurationInSeconds()I
    .locals 1

    .prologue
    .line 71
    iget v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->durationInSeconds:I

    return v0
.end method

.method public getEncoding()Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;
    .locals 2
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 110
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->encodings:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->encodings:Ljava/util/List;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getExpirationDate()Ljava/util/Date;
    .locals 1

    .prologue
    .line 79
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->expirationDate:Ljava/util/Date;

    return-object v0
.end method

.method public getForm()Ljava/lang/String;
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->form:Ljava/lang/String;

    return-object v0
.end method

.method public getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;
    .locals 1

    .prologue
    .line 116
    const/4 v0, 0x0

    return-object v0
.end method

.method public getProvider()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;
    .locals 1

    .prologue
    .line 103
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->provider:Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    return-object v0
.end method

.method public getSubRating()Ljava/lang/String;
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->subRating:Ljava/lang/String;

    return-object v0
.end method

.method public getVideoId()J
    .locals 2

    .prologue
    .line 67
    iget-wide v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->videoId:J

    return-wide v0
.end method

.method public getVideoQuality()Ljava/lang/String;
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->videoQuality:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 8

    .prologue
    const/4 v2, 0x0

    .line 170
    invoke-super {p0}, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->hashCode()I

    move-result v0

    .line 171
    .local v0, "result":I
    mul-int/lit8 v1, v0, 0x1f

    iget-wide v4, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->videoId:J

    iget-wide v6, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->videoId:J

    const/16 v3, 0x20

    ushr-long/2addr v6, v3

    xor-long/2addr v4, v6

    long-to-int v3, v4

    add-int v0, v1, v3

    .line 172
    mul-int/lit8 v1, v0, 0x1f

    iget v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->durationInSeconds:I

    add-int v0, v1, v3

    .line 173
    mul-int/lit8 v3, v0, 0x1f

    iget-object v1, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->datePublished:Ljava/util/Date;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->datePublished:Ljava/util/Date;

    invoke-virtual {v1}, Ljava/util/Date;->hashCode()I

    move-result v1

    :goto_0
    add-int v0, v3, v1

    .line 174
    mul-int/lit8 v3, v0, 0x1f

    iget-object v1, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->expirationDate:Ljava/util/Date;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->expirationDate:Ljava/util/Date;

    invoke-virtual {v1}, Ljava/util/Date;->hashCode()I

    move-result v1

    :goto_1
    add-int v0, v3, v1

    .line 175
    mul-int/lit8 v3, v0, 0x1f

    iget-object v1, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->videoQuality:Ljava/lang/String;

    if-eqz v1, :cond_3

    iget-object v1, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->videoQuality:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    :goto_2
    add-int v0, v3, v1

    .line 176
    mul-int/lit8 v3, v0, 0x1f

    iget-object v1, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->contentRating:Ljava/lang/String;

    if-eqz v1, :cond_4

    iget-object v1, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->contentRating:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    :goto_3
    add-int v0, v3, v1

    .line 177
    mul-int/lit8 v3, v0, 0x1f

    iget-boolean v1, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->isAdult:Z

    if-eqz v1, :cond_5

    const/4 v1, 0x1

    :goto_4
    add-int v0, v3, v1

    .line 178
    mul-int/lit8 v3, v0, 0x1f

    iget-object v1, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->form:Ljava/lang/String;

    if-eqz v1, :cond_6

    iget-object v1, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->form:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    :goto_5
    add-int v0, v3, v1

    .line 179
    mul-int/lit8 v1, v0, 0x1f

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->provider:Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    if-eqz v3, :cond_0

    iget-object v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->provider:Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->hashCode()I

    move-result v2

    :cond_0
    add-int v0, v1, v2

    .line 180
    mul-int/lit8 v1, v0, 0x1f

    iget-object v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->encodings:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->hashCode()I

    move-result v2

    add-int v0, v1, v2

    .line 181
    return v0

    :cond_1
    move v1, v2

    .line 173
    goto :goto_0

    :cond_2
    move v1, v2

    .line 174
    goto :goto_1

    :cond_3
    move v1, v2

    .line 175
    goto :goto_2

    :cond_4
    move v1, v2

    .line 176
    goto :goto_3

    :cond_5
    move v1, v2

    .line 177
    goto :goto_4

    :cond_6
    move v1, v2

    .line 178
    goto :goto_5
.end method

.method public isAdult()Z
    .locals 1

    .prologue
    .line 95
    iget-boolean v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->isAdult:Z

    return v0
.end method

.method public parseHalContent(Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;)V
    .locals 6
    .param p1, "resolver"    # Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;

    .prologue
    .line 36
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->parseHalContent(Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;)V

    .line 38
    const-string v4, "id"

    invoke-virtual {p1, v4}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/Long;->valueOf(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    iput-wide v4, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->videoId:J

    .line 39
    const-string v4, "duration/seconds"

    const/4 v5, 0x0

    invoke-virtual {p1, v4, v5}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalInt(Ljava/lang/String;I)I

    move-result v4

    iput v4, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->durationInSeconds:I

    .line 40
    const-string v4, "datePublished/availableDate"

    invoke-virtual {p1, v4}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v4}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->parseDate(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v4

    iput-object v4, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->datePublished:Ljava/util/Date;

    .line 41
    const-string v4, "expires/RFC1123"

    invoke-virtual {p1, v4}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v4}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->parseDate(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v4

    iput-object v4, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->expirationDate:Ljava/util/Date;

    .line 42
    const-string v4, "videoQuality"

    invoke-virtual {p1, v4}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->videoQuality:Ljava/lang/String;

    .line 43
    iget-object v4, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->videoQuality:Ljava/lang/String;

    if-nez v4, :cond_0

    const-string v4, ""

    iput-object v4, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->videoQuality:Ljava/lang/String;

    .line 44
    :cond_0
    const-string v4, "contentRating"

    invoke-virtual {p1, v4}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->contentRating:Ljava/lang/String;

    .line 45
    const-string v4, "subRating"

    invoke-virtual {p1, v4}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->subRating:Ljava/lang/String;

    .line 46
    const-string v4, "isAdult"

    const/4 v5, 0x1

    invoke-virtual {p1, v4, v5}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalBoolean(Ljava/lang/String;Z)Z

    move-result v4

    iput-boolean v4, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->isAdult:Z

    .line 47
    const-string v4, "form"

    invoke-virtual {p1, v4}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->form:Ljava/lang/String;

    .line 48
    iget-object v4, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->form:Ljava/lang/String;

    if-nez v4, :cond_1

    const-string v4, ""

    iput-object v4, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->form:Ljava/lang/String;

    .line 50
    :cond_1
    const-string v4, "provider"

    invoke-virtual {p1, v4}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalItem(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataItem;

    move-result-object v3

    .line 51
    .local v3, "providerItem":Lcom/comcast/cim/microdata/model/MicrodataItem;
    if-eqz v3, :cond_2

    .line 52
    new-instance v4, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    invoke-direct {v4}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;-><init>()V

    iput-object v4, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->provider:Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    .line 53
    iget-object v4, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->provider:Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    invoke-virtual {p1, v3}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->copy(Lcom/comcast/cim/microdata/model/MicrodataItem;)Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->parseHalContent(Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;)V

    .line 56
    :cond_2
    const-string v4, "encoding"

    invoke-virtual {p1, v4}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalItemList(Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    .line 57
    .local v1, "items":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataItem;>;"
    if-eqz v1, :cond_3

    .line 58
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_3

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/comcast/cim/microdata/model/MicrodataItem;

    .line 59
    .local v2, "nextItem":Lcom/comcast/cim/microdata/model/MicrodataItem;
    new-instance v0, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;

    invoke-direct {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;-><init>()V

    .line 60
    .local v0, "encoding":Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;
    invoke-virtual {p1, v2}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->copy(Lcom/comcast/cim/microdata/model/MicrodataItem;)Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;

    move-result-object v5

    invoke-virtual {v0, v5}, Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;->parseHalContent(Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;)V

    .line 61
    iget-object v5, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->encodings:Ljava/util/List;

    invoke-interface {v5, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 64
    .end local v0    # "encoding":Lcom/xfinity/playerlib/model/consumable/hal/HalEncoding;
    .end local v2    # "nextItem":Lcom/comcast/cim/microdata/model/MicrodataItem;
    :cond_3
    return-void
.end method

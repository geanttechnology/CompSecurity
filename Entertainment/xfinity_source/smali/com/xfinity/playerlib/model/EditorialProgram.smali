.class public abstract Lcom/xfinity/playerlib/model/EditorialProgram;
.super Ljava/lang/Object;
.source "EditorialProgram.java"

# interfaces
.implements Lcom/xfinity/playerlib/model/Program;


# instance fields
.field brand:Ljava/lang/String;

.field private episodeNumber:Ljava/lang/String;

.field private episodeTitle:Ljava/lang/String;

.field imageKey:Ljava/lang/String;

.field merlinId:Lcom/xfinity/playerlib/model/MerlinId;

.field private providerCode:Ljava/lang/String;

.field private seasonNumber:Ljava/lang/String;

.field title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getBrand()Ljava/lang/String;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/xfinity/playerlib/model/EditorialProgram;->brand:Ljava/lang/String;

    return-object v0
.end method

.method public getEpisodeNumber()Ljava/lang/String;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/xfinity/playerlib/model/EditorialProgram;->episodeNumber:Ljava/lang/String;

    return-object v0
.end method

.method public getEpisodeTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/xfinity/playerlib/model/EditorialProgram;->episodeTitle:Ljava/lang/String;

    return-object v0
.end method

.method public getImageKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/xfinity/playerlib/model/EditorialProgram;->imageKey:Ljava/lang/String;

    return-object v0
.end method

.method public getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/xfinity/playerlib/model/EditorialProgram;->merlinId:Lcom/xfinity/playerlib/model/MerlinId;

    return-object v0
.end method

.method public getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;
    .locals 1

    .prologue
    .line 51
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/EditorialProgram;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v0

    return-object v0
.end method

.method public getProviderCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/xfinity/playerlib/model/EditorialProgram;->providerCode:Ljava/lang/String;

    return-object v0
.end method

.method public getSeasonNumber()Ljava/lang/String;
    .locals 1

    .prologue
    .line 79
    iget-object v0, p0, Lcom/xfinity/playerlib/model/EditorialProgram;->seasonNumber:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/xfinity/playerlib/model/EditorialProgram;->title:Ljava/lang/String;

    return-object v0
.end method

.method public abstract parse(Ljava/util/LinkedHashMap;)V
.end method

.method public setBrand(Ljava/lang/String;)V
    .locals 0
    .param p1, "brand"    # Ljava/lang/String;

    .prologue
    .line 63
    iput-object p1, p0, Lcom/xfinity/playerlib/model/EditorialProgram;->brand:Ljava/lang/String;

    .line 64
    return-void
.end method

.method public setEpisodeNumber(Ljava/lang/String;)V
    .locals 0
    .param p1, "episodeNumber"    # Ljava/lang/String;

    .prologue
    .line 67
    iput-object p1, p0, Lcom/xfinity/playerlib/model/EditorialProgram;->episodeNumber:Ljava/lang/String;

    .line 68
    return-void
.end method

.method public setEpisodeTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "episodeTitle"    # Ljava/lang/String;

    .prologue
    .line 83
    iput-object p1, p0, Lcom/xfinity/playerlib/model/EditorialProgram;->episodeTitle:Ljava/lang/String;

    .line 84
    return-void
.end method

.method public setImageKey(Ljava/lang/String;)V
    .locals 0
    .param p1, "imageKey"    # Ljava/lang/String;

    .prologue
    .line 33
    iput-object p1, p0, Lcom/xfinity/playerlib/model/EditorialProgram;->imageKey:Ljava/lang/String;

    .line 34
    return-void
.end method

.method public setMerlinId(Lcom/xfinity/playerlib/model/MerlinId;)V
    .locals 0
    .param p1, "merlinId"    # Lcom/xfinity/playerlib/model/MerlinId;

    .prologue
    .line 55
    iput-object p1, p0, Lcom/xfinity/playerlib/model/EditorialProgram;->merlinId:Lcom/xfinity/playerlib/model/MerlinId;

    .line 56
    return-void
.end method

.method public setProviderCode(Ljava/lang/String;)V
    .locals 0
    .param p1, "data"    # Ljava/lang/String;

    .prologue
    .line 21
    iput-object p1, p0, Lcom/xfinity/playerlib/model/EditorialProgram;->providerCode:Ljava/lang/String;

    .line 22
    return-void
.end method

.method public setSeasonNumber(Ljava/lang/String;)V
    .locals 0
    .param p1, "seasonNumber"    # Ljava/lang/String;

    .prologue
    .line 75
    iput-object p1, p0, Lcom/xfinity/playerlib/model/EditorialProgram;->seasonNumber:Ljava/lang/String;

    .line 76
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "title"    # Ljava/lang/String;

    .prologue
    .line 41
    iput-object p1, p0, Lcom/xfinity/playerlib/model/EditorialProgram;->title:Ljava/lang/String;

    .line 42
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 94
    new-instance v0, Lorg/apache/commons/lang3/builder/ToStringBuilder;

    sget-object v1, Lorg/apache/commons/lang3/builder/ToStringStyle;->SHORT_PREFIX_STYLE:Lorg/apache/commons/lang3/builder/ToStringStyle;

    invoke-direct {v0, p0, v1}, Lorg/apache/commons/lang3/builder/ToStringBuilder;-><init>(Ljava/lang/Object;Lorg/apache/commons/lang3/builder/ToStringStyle;)V

    const-string v1, "imageKey"

    iget-object v2, p0, Lcom/xfinity/playerlib/model/EditorialProgram;->imageKey:Ljava/lang/String;

    .line 95
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "title"

    iget-object v2, p0, Lcom/xfinity/playerlib/model/EditorialProgram;->title:Ljava/lang/String;

    .line 96
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "merlinId"

    iget-object v2, p0, Lcom/xfinity/playerlib/model/EditorialProgram;->merlinId:Lcom/xfinity/playerlib/model/MerlinId;

    .line 97
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "brand"

    iget-object v2, p0, Lcom/xfinity/playerlib/model/EditorialProgram;->brand:Ljava/lang/String;

    .line 98
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "seasonNumber"

    iget-object v2, p0, Lcom/xfinity/playerlib/model/EditorialProgram;->seasonNumber:Ljava/lang/String;

    .line 99
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "episodeNumber"

    iget-object v2, p0, Lcom/xfinity/playerlib/model/EditorialProgram;->episodeNumber:Ljava/lang/String;

    .line 100
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "episodeTitle"

    iget-object v2, p0, Lcom/xfinity/playerlib/model/EditorialProgram;->episodeTitle:Ljava/lang/String;

    .line 101
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    .line 102
    invoke-virtual {v0}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

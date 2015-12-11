.class public Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field cover:Ljava/lang/String;

.field id:Ljava/lang/String;

.field isAlbum:Ljava/lang/Boolean;

.field itemCount:Ljava/lang/String;

.field name:Ljava/lang/String;

.field ownerId:Ljava/lang/String;

.field ownerName:Ljava/lang/String;

.field subsCount:Ljava/lang/String;

.field type:I


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V
    .locals 1

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->id:Ljava/lang/String;

    .line 17
    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->name:Ljava/lang/String;

    .line 18
    iput-object p3, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->ownerId:Ljava/lang/String;

    .line 19
    iput-object p4, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->ownerName:Ljava/lang/String;

    .line 20
    iput-object p5, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->itemCount:Ljava/lang/String;

    .line 21
    iput-object p6, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->subsCount:Ljava/lang/String;

    .line 22
    iput-object p7, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->cover:Ljava/lang/String;

    .line 23
    iput p8, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->type:I

    .line 24
    invoke-static {p9}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->isAlbum:Ljava/lang/Boolean;

    .line 25
    return-void
.end method


# virtual methods
.method public getIsAlbum()Z
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->isAlbum:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    return v0
.end method

.method public getPlaylistCover()Ljava/lang/String;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->cover:Ljava/lang/String;

    return-object v0
.end method

.method public getPlaylistId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getPlaylistItemCount()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->itemCount:Ljava/lang/String;

    return-object v0
.end method

.method public getPlaylistName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getPlaylistOwnerId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->ownerId:Ljava/lang/String;

    return-object v0
.end method

.method public getPlaylistOwnerName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->ownerName:Ljava/lang/String;

    return-object v0
.end method

.method public getPlaylistSubsCount()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->subsCount:Ljava/lang/String;

    return-object v0
.end method

.method public getPlaylistType()I
    .locals 1

    .prologue
    .line 64
    iget v0, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->type:I

    return v0
.end method

.method public putSubsCount(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 76
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->subsCount:Ljava/lang/String;

    .line 77
    return-void
.end method

.method public renamePlaylist(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 72
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->name:Ljava/lang/String;

    .line 73
    return-void
.end method

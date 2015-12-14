.class public Lcom/livemixtapes/MusicRetriever$Item;
.super Ljava/lang/Object;
.source "MusicRetriever.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/MusicRetriever;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Item"
.end annotation


# instance fields
.field album:Ljava/lang/String;

.field artist:Ljava/lang/String;

.field duration:J

.field id:J

.field title:Ljava/lang/String;


# direct methods
.method public constructor <init>(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V
    .locals 0
    .param p1, "id"    # J
    .param p3, "artist"    # Ljava/lang/String;
    .param p4, "title"    # Ljava/lang/String;
    .param p5, "album"    # Ljava/lang/String;
    .param p6, "duration"    # J

    .prologue
    .line 103
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 104
    iput-wide p1, p0, Lcom/livemixtapes/MusicRetriever$Item;->id:J

    .line 105
    iput-object p3, p0, Lcom/livemixtapes/MusicRetriever$Item;->artist:Ljava/lang/String;

    .line 106
    iput-object p4, p0, Lcom/livemixtapes/MusicRetriever$Item;->title:Ljava/lang/String;

    .line 107
    iput-object p5, p0, Lcom/livemixtapes/MusicRetriever$Item;->album:Ljava/lang/String;

    .line 108
    iput-wide p6, p0, Lcom/livemixtapes/MusicRetriever$Item;->duration:J

    .line 109
    return-void
.end method


# virtual methods
.method public getAlbum()Ljava/lang/String;
    .locals 1

    .prologue
    .line 120
    iget-object v0, p0, Lcom/livemixtapes/MusicRetriever$Item;->album:Ljava/lang/String;

    return-object v0
.end method

.method public getArtist()Ljava/lang/String;
    .locals 1

    .prologue
    .line 114
    iget-object v0, p0, Lcom/livemixtapes/MusicRetriever$Item;->artist:Ljava/lang/String;

    return-object v0
.end method

.method public getDuration()J
    .locals 2

    .prologue
    .line 123
    iget-wide v0, p0, Lcom/livemixtapes/MusicRetriever$Item;->duration:J

    return-wide v0
.end method

.method public getId()J
    .locals 2

    .prologue
    .line 111
    iget-wide v0, p0, Lcom/livemixtapes/MusicRetriever$Item;->id:J

    return-wide v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 117
    iget-object v0, p0, Lcom/livemixtapes/MusicRetriever$Item;->title:Ljava/lang/String;

    return-object v0
.end method

.method public getURI()Landroid/net/Uri;
    .locals 3

    .prologue
    .line 127
    sget-object v0, Landroid/provider/MediaStore$Audio$Media;->EXTERNAL_CONTENT_URI:Landroid/net/Uri;

    iget-wide v1, p0, Lcom/livemixtapes/MusicRetriever$Item;->id:J

    .line 126
    invoke-static {v0, v1, v2}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

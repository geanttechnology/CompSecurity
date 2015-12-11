.class public Lcom/aio/downloader/model/FeedItem;
.super Ljava/lang/Object;
.source "FeedItem.java"


# instance fields
.field private description:Ljava/lang/String;

.field private iconUrl:Ljava/lang/String;

.field private link:Ljava/lang/String;

.field private rating:Ljava/lang/Float;

.field private thumbnailurl:Ljava/lang/String;

.field private title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 4
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/aio/downloader/model/FeedItem;->description:Ljava/lang/String;

    return-object v0
.end method

.method public getIconUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lcom/aio/downloader/model/FeedItem;->iconUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getLink()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/aio/downloader/model/FeedItem;->link:Ljava/lang/String;

    return-object v0
.end method

.method public getRating()Ljava/lang/Float;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/aio/downloader/model/FeedItem;->rating:Ljava/lang/Float;

    return-object v0
.end method

.method public getThumbnailurl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/aio/downloader/model/FeedItem;->thumbnailurl:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 12
    iget-object v0, p0, Lcom/aio/downloader/model/FeedItem;->title:Ljava/lang/String;

    return-object v0
.end method

.method public setDescription(Ljava/lang/String;)V
    .locals 0
    .param p1, "description"    # Ljava/lang/String;

    .prologue
    .line 27
    iput-object p1, p0, Lcom/aio/downloader/model/FeedItem;->description:Ljava/lang/String;

    .line 28
    return-void
.end method

.method public setIconUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "iconUrl"    # Ljava/lang/String;

    .prologue
    .line 21
    iput-object p1, p0, Lcom/aio/downloader/model/FeedItem;->iconUrl:Ljava/lang/String;

    .line 22
    return-void
.end method

.method public setLink(Ljava/lang/String;)V
    .locals 0
    .param p1, "link"    # Ljava/lang/String;

    .prologue
    .line 33
    iput-object p1, p0, Lcom/aio/downloader/model/FeedItem;->link:Ljava/lang/String;

    .line 34
    return-void
.end method

.method public setRating(Ljava/lang/Float;)V
    .locals 0
    .param p1, "rating"    # Ljava/lang/Float;

    .prologue
    .line 45
    iput-object p1, p0, Lcom/aio/downloader/model/FeedItem;->rating:Ljava/lang/Float;

    .line 46
    return-void
.end method

.method public setThumbnailurl(Ljava/lang/String;)V
    .locals 0
    .param p1, "thumbnailurl"    # Ljava/lang/String;

    .prologue
    .line 39
    iput-object p1, p0, Lcom/aio/downloader/model/FeedItem;->thumbnailurl:Ljava/lang/String;

    .line 40
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "title"    # Ljava/lang/String;

    .prologue
    .line 15
    iput-object p1, p0, Lcom/aio/downloader/model/FeedItem;->title:Ljava/lang/String;

    .line 16
    return-void
.end method

.class public Lcom/aio/downloader/model/AppdetailModel;
.super Ljava/lang/Object;
.source "AppdetailModel.java"


# instance fields
.field private author_title:Ljava/lang/String;

.field private detail:Ljava/lang/String;

.field private downloads:Ljava/lang/String;

.field private has_apk:Ljava/lang/String;

.field private icon:Ljava/lang/String;

.field private id:Ljava/lang/String;

.field private price:Ljava/lang/String;

.field private rating:F

.field private release_date:Ljava/lang/String;

.field private screenshots:Ljava/lang/String;

.field private short_desc:Ljava/lang/String;

.field private size:Ljava/lang/String;

.field private title:Ljava/lang/String;

.field private version:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAuthor_title()Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/aio/downloader/model/AppdetailModel;->author_title:Ljava/lang/String;

    return-object v0
.end method

.method public getDetail()Ljava/lang/String;
    .locals 1

    .prologue
    .line 109
    iget-object v0, p0, Lcom/aio/downloader/model/AppdetailModel;->detail:Ljava/lang/String;

    return-object v0
.end method

.method public getDownloads()Ljava/lang/String;
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lcom/aio/downloader/model/AppdetailModel;->downloads:Ljava/lang/String;

    return-object v0
.end method

.method public getHas_apk()Ljava/lang/String;
    .locals 1

    .prologue
    .line 124
    iget-object v0, p0, Lcom/aio/downloader/model/AppdetailModel;->has_apk:Ljava/lang/String;

    return-object v0
.end method

.method public getIcon()Ljava/lang/String;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/aio/downloader/model/AppdetailModel;->icon:Ljava/lang/String;

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/aio/downloader/model/AppdetailModel;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 101
    iget-object v0, p0, Lcom/aio/downloader/model/AppdetailModel;->price:Ljava/lang/String;

    return-object v0
.end method

.method public getRating()F
    .locals 1

    .prologue
    .line 61
    iget v0, p0, Lcom/aio/downloader/model/AppdetailModel;->rating:F

    return v0
.end method

.method public getRelease_date()Ljava/lang/String;
    .locals 1

    .prologue
    .line 77
    iget-object v0, p0, Lcom/aio/downloader/model/AppdetailModel;->release_date:Ljava/lang/String;

    return-object v0
.end method

.method public getScreenshots()Ljava/lang/String;
    .locals 1

    .prologue
    .line 117
    iget-object v0, p0, Lcom/aio/downloader/model/AppdetailModel;->screenshots:Ljava/lang/String;

    return-object v0
.end method

.method public getShort_desc()Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/aio/downloader/model/AppdetailModel;->short_desc:Ljava/lang/String;

    return-object v0
.end method

.method public getSize()Ljava/lang/String;
    .locals 1

    .prologue
    .line 93
    iget-object v0, p0, Lcom/aio/downloader/model/AppdetailModel;->size:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/aio/downloader/model/AppdetailModel;->title:Ljava/lang/String;

    return-object v0
.end method

.method public getVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/aio/downloader/model/AppdetailModel;->version:Ljava/lang/String;

    return-object v0
.end method

.method public setAuthor_title(Ljava/lang/String;)V
    .locals 0
    .param p1, "author_title"    # Ljava/lang/String;

    .prologue
    .line 49
    iput-object p1, p0, Lcom/aio/downloader/model/AppdetailModel;->author_title:Ljava/lang/String;

    .line 50
    return-void
.end method

.method public setDetail(Ljava/lang/String;)V
    .locals 0
    .param p1, "detail"    # Ljava/lang/String;

    .prologue
    .line 113
    iput-object p1, p0, Lcom/aio/downloader/model/AppdetailModel;->detail:Ljava/lang/String;

    .line 114
    return-void
.end method

.method public setDownloads(Ljava/lang/String;)V
    .locals 0
    .param p1, "downloads"    # Ljava/lang/String;

    .prologue
    .line 89
    iput-object p1, p0, Lcom/aio/downloader/model/AppdetailModel;->downloads:Ljava/lang/String;

    .line 90
    return-void
.end method

.method public setHas_apk(Ljava/lang/String;)V
    .locals 0
    .param p1, "has_apk"    # Ljava/lang/String;

    .prologue
    .line 128
    iput-object p1, p0, Lcom/aio/downloader/model/AppdetailModel;->has_apk:Ljava/lang/String;

    .line 129
    return-void
.end method

.method public setIcon(Ljava/lang/String;)V
    .locals 0
    .param p1, "icon"    # Ljava/lang/String;

    .prologue
    .line 57
    iput-object p1, p0, Lcom/aio/downloader/model/AppdetailModel;->icon:Ljava/lang/String;

    .line 58
    return-void
.end method

.method public setId(Ljava/lang/String;)V
    .locals 0
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 33
    iput-object p1, p0, Lcom/aio/downloader/model/AppdetailModel;->id:Ljava/lang/String;

    .line 34
    return-void
.end method

.method public setPrice(Ljava/lang/String;)V
    .locals 0
    .param p1, "price"    # Ljava/lang/String;

    .prologue
    .line 105
    iput-object p1, p0, Lcom/aio/downloader/model/AppdetailModel;->price:Ljava/lang/String;

    .line 106
    return-void
.end method

.method public setRating(F)V
    .locals 0
    .param p1, "rating"    # F

    .prologue
    .line 65
    iput p1, p0, Lcom/aio/downloader/model/AppdetailModel;->rating:F

    .line 66
    return-void
.end method

.method public setRelease_date(Ljava/lang/String;)V
    .locals 0
    .param p1, "release_date"    # Ljava/lang/String;

    .prologue
    .line 81
    iput-object p1, p0, Lcom/aio/downloader/model/AppdetailModel;->release_date:Ljava/lang/String;

    .line 82
    return-void
.end method

.method public setScreenshots(Ljava/lang/String;)V
    .locals 0
    .param p1, "screenshots"    # Ljava/lang/String;

    .prologue
    .line 121
    iput-object p1, p0, Lcom/aio/downloader/model/AppdetailModel;->screenshots:Ljava/lang/String;

    .line 122
    return-void
.end method

.method public setShort_desc(Ljava/lang/String;)V
    .locals 0
    .param p1, "short_desc"    # Ljava/lang/String;

    .prologue
    .line 25
    iput-object p1, p0, Lcom/aio/downloader/model/AppdetailModel;->short_desc:Ljava/lang/String;

    .line 26
    return-void
.end method

.method public setSize(Ljava/lang/String;)V
    .locals 0
    .param p1, "size"    # Ljava/lang/String;

    .prologue
    .line 97
    iput-object p1, p0, Lcom/aio/downloader/model/AppdetailModel;->size:Ljava/lang/String;

    .line 98
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "title"    # Ljava/lang/String;

    .prologue
    .line 41
    iput-object p1, p0, Lcom/aio/downloader/model/AppdetailModel;->title:Ljava/lang/String;

    .line 42
    return-void
.end method

.method public setVersion(Ljava/lang/String;)V
    .locals 0
    .param p1, "version"    # Ljava/lang/String;

    .prologue
    .line 73
    iput-object p1, p0, Lcom/aio/downloader/model/AppdetailModel;->version:Ljava/lang/String;

    .line 74
    return-void
.end method

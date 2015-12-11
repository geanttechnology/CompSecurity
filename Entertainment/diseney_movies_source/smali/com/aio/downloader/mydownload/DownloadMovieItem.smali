.class public Lcom/aio/downloader/mydownload/DownloadMovieItem;
.super Ljava/lang/Object;
.source "DownloadMovieItem.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation runtime Lnet/tsz/afinal/annotation/sqlite/Table;
    name = "downloadtask"
.end annotation


# static fields
.field private static final serialVersionUID:J = 0xcL


# instance fields
.field private album_title:Ljava/lang/String;

.field private artist_title:Ljava/lang/String;

.field private author_title:Ljava/lang/String;

.field private banner_type:I

.field private bannerauthor_title:Ljava/lang/String;

.field private bannerhas_apk:Ljava/lang/String;

.field private bannericon:Ljava/lang/String;

.field private bannerid:Ljava/lang/String;

.field private bannerisoffical:Ljava/lang/String;

.field private bannerlink_url:Ljava/lang/String;

.field private bannerprice:Ljava/lang/String;

.field private bannerrating:Ljava/lang/String;

.field private bannerserial:Ljava/lang/String;

.field private bannersize:Ljava/lang/String;

.field private bannerstatus:Ljava/lang/String;

.field private bannertitle:Ljava/lang/String;

.field private cat:Ljava/lang/String;

.field private create_time:Ljava/lang/Long;

.field private currentProgress:Ljava/lang/Long;

.field private detail:Ljava/lang/String;

.field private downloadFile:Lcom/aio/downloader/mydownload/DownloadFile;

.field private downloadState:Ljava/lang/Integer;

.field private downloadUrl:Ljava/lang/String;

.field private downloads:Ljava/lang/String;

.field private editState:Z

.field private filePath:Ljava/lang/String;

.field private fileSize:Ljava/lang/String;

.field private file_id:Ljava/lang/String;

.field private has_apk:Ljava/lang/String;

.field private has_next_page:I

.field private icon:Ljava/lang/String;

.field private id:Ljava/lang/String;

.field private infotitle:Ljava/lang/String;

.field private isSelected:Z

.field private is_official:Ljava/lang/String;

.field private link:Ljava/lang/String;

.field private link_url:Ljava/lang/String;

.field private minigameicon:Ljava/lang/String;

.field private minigamestatus:Ljava/lang/String;

.field private minigametitle:Ljava/lang/String;

.field private movieHeadImage:Landroid/graphics/Bitmap;

.field private movieHeadImagePath:Ljava/lang/String;

.field private movieId:Ljava/lang/String;

.field private movieName:Ljava/lang/String;

.field private percentage:Ljava/lang/String;

.field private position:I

.field private ppshort_desc:Ljava/lang/String;

.field private price:Ljava/lang/String;

.field private progressCount:Ljava/lang/Long;

.field private rating:Ljava/lang/Float;

.field private release_date:Ljava/lang/String;

.field private screenshots:Ljava/lang/String;

.field private search_keyword:Ljava/lang/String;

.field private serial:I

.field private setCount:Ljava/lang/String;

.field private size:Ljava/lang/String;

.field private title:Ljava/lang/String;

.field private type:Ljava/lang/String;

.field private uuid:Ljava/lang/Long;

.field private version:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    const-wide/16 v1, 0x0

    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 33
    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->progressCount:Ljava/lang/Long;

    .line 34
    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->currentProgress:Ljava/lang/Long;

    .line 35
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->downloadState:Ljava/lang/Integer;

    .line 40
    const-string v0, "%0"

    iput-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->percentage:Ljava/lang/String;

    .line 25
    return-void
.end method

.method public static getSerialversionuid()J
    .locals 2

    .prologue
    .line 508
    const-wide/16 v0, 0xc

    return-wide v0
.end method


# virtual methods
.method public getAlbum_title()Ljava/lang/String;
    .locals 1

    .prologue
    .line 302
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->album_title:Ljava/lang/String;

    return-object v0
.end method

.method public getArtist_title()Ljava/lang/String;
    .locals 1

    .prologue
    .line 310
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->artist_title:Ljava/lang/String;

    return-object v0
.end method

.method public getAuthor_title()Ljava/lang/String;
    .locals 1

    .prologue
    .line 362
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->author_title:Ljava/lang/String;

    return-object v0
.end method

.method public getBanner_type()I
    .locals 1

    .prologue
    .line 238
    iget v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->banner_type:I

    return v0
.end method

.method public getBannerauthor_title()Ljava/lang/String;
    .locals 1

    .prologue
    .line 135
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->bannerauthor_title:Ljava/lang/String;

    return-object v0
.end method

.method public getBannerhas_apk()Ljava/lang/String;
    .locals 1

    .prologue
    .line 183
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->bannerhas_apk:Ljava/lang/String;

    return-object v0
.end method

.method public getBannericon()Ljava/lang/String;
    .locals 1

    .prologue
    .line 143
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->bannericon:Ljava/lang/String;

    return-object v0
.end method

.method public getBannerid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 111
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->bannerid:Ljava/lang/String;

    return-object v0
.end method

.method public getBannerisoffical()Ljava/lang/String;
    .locals 1

    .prologue
    .line 167
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->bannerisoffical:Ljava/lang/String;

    return-object v0
.end method

.method public getBannerlink_url()Ljava/lang/String;
    .locals 1

    .prologue
    .line 175
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->bannerlink_url:Ljava/lang/String;

    return-object v0
.end method

.method public getBannerprice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 103
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->bannerprice:Ljava/lang/String;

    return-object v0
.end method

.method public getBannerrating()Ljava/lang/String;
    .locals 1

    .prologue
    .line 159
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->bannerrating:Ljava/lang/String;

    return-object v0
.end method

.method public getBannerserial()Ljava/lang/String;
    .locals 1

    .prologue
    .line 119
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->bannerserial:Ljava/lang/String;

    return-object v0
.end method

.method public getBannersize()Ljava/lang/String;
    .locals 1

    .prologue
    .line 151
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->bannersize:Ljava/lang/String;

    return-object v0
.end method

.method public getBannerstatus()Ljava/lang/String;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->bannerstatus:Ljava/lang/String;

    return-object v0
.end method

.method public getBannertitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 127
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->bannertitle:Ljava/lang/String;

    return-object v0
.end method

.method public getCat()Ljava/lang/String;
    .locals 1

    .prologue
    .line 294
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->cat:Ljava/lang/String;

    return-object v0
.end method

.method public getCreate_time()Ljava/lang/Long;
    .locals 1

    .prologue
    .line 436
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->create_time:Ljava/lang/Long;

    return-object v0
.end method

.method public getCurrentProgress()Ljava/lang/Long;
    .locals 1

    .prologue
    .line 460
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->currentProgress:Ljava/lang/Long;

    return-object v0
.end method

.method public getDetail()Ljava/lang/String;
    .locals 1

    .prologue
    .line 286
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->detail:Ljava/lang/String;

    return-object v0
.end method

.method public getDownloadFile()Lcom/aio/downloader/mydownload/DownloadFile;
    .locals 1

    .prologue
    .line 529
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->downloadFile:Lcom/aio/downloader/mydownload/DownloadFile;

    return-object v0
.end method

.method public getDownloadState()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 468
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->downloadState:Ljava/lang/Integer;

    return-object v0
.end method

.method public getDownloadUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 521
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->downloadUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getDownloads()Ljava/lang/String;
    .locals 1

    .prologue
    .line 278
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->downloads:Ljava/lang/String;

    return-object v0
.end method

.method public getFilePath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 553
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->filePath:Ljava/lang/String;

    return-object v0
.end method

.method public getFileSize()Ljava/lang/String;
    .locals 1

    .prologue
    .line 492
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->fileSize:Ljava/lang/String;

    return-object v0
.end method

.method public getFile_id()Ljava/lang/String;
    .locals 1

    .prologue
    .line 428
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->file_id:Ljava/lang/String;

    return-object v0
.end method

.method public getHas_apk()Ljava/lang/String;
    .locals 1

    .prologue
    .line 402
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->has_apk:Ljava/lang/String;

    return-object v0
.end method

.method public getHas_next_page()I
    .locals 1

    .prologue
    .line 338
    iget v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->has_next_page:I

    return v0
.end method

.method public getIcon()Ljava/lang/String;
    .locals 1

    .prologue
    .line 370
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->icon:Ljava/lang/String;

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 569
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getInfotitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 198
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->infotitle:Ljava/lang/String;

    return-object v0
.end method

.method public getIs_official()Ljava/lang/String;
    .locals 1

    .prologue
    .line 420
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->is_official:Ljava/lang/String;

    return-object v0
.end method

.method public getLink()Ljava/lang/String;
    .locals 1

    .prologue
    .line 230
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->link:Ljava/lang/String;

    return-object v0
.end method

.method public getLink_url()Ljava/lang/String;
    .locals 1

    .prologue
    .line 246
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->link_url:Ljava/lang/String;

    return-object v0
.end method

.method public getMinigameicon()Ljava/lang/String;
    .locals 1

    .prologue
    .line 214
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->minigameicon:Ljava/lang/String;

    return-object v0
.end method

.method public getMinigamestatus()Ljava/lang/String;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->minigamestatus:Ljava/lang/String;

    return-object v0
.end method

.method public getMinigametitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 206
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->minigametitle:Ljava/lang/String;

    return-object v0
.end method

.method public getMovieHeadImage()Landroid/graphics/Bitmap;
    .locals 1

    .prologue
    .line 484
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->movieHeadImage:Landroid/graphics/Bitmap;

    return-object v0
.end method

.method public getMovieHeadImagePath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 585
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->movieHeadImagePath:Ljava/lang/String;

    return-object v0
.end method

.method public getMovieId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 593
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->movieId:Ljava/lang/String;

    return-object v0
.end method

.method public getMovieName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 500
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->movieName:Ljava/lang/String;

    return-object v0
.end method

.method public getPercentage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 537
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->percentage:Ljava/lang/String;

    return-object v0
.end method

.method public getPosition()I
    .locals 1

    .prologue
    .line 601
    iget v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->position:I

    return v0
.end method

.method public getPpshort_desc()Ljava/lang/String;
    .locals 1

    .prologue
    .line 320
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->ppshort_desc:Ljava/lang/String;

    return-object v0
.end method

.method public getPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 394
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->price:Ljava/lang/String;

    return-object v0
.end method

.method public getProgressCount()Ljava/lang/Long;
    .locals 1

    .prologue
    .line 452
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->progressCount:Ljava/lang/Long;

    return-object v0
.end method

.method public getRating()Ljava/lang/Float;
    .locals 1

    .prologue
    .line 386
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->rating:Ljava/lang/Float;

    return-object v0
.end method

.method public getRelease_date()Ljava/lang/String;
    .locals 1

    .prologue
    .line 270
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->release_date:Ljava/lang/String;

    return-object v0
.end method

.method public getScreenshots()Ljava/lang/String;
    .locals 1

    .prologue
    .line 254
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->screenshots:Ljava/lang/String;

    return-object v0
.end method

.method public getSearch_keyword()Ljava/lang/String;
    .locals 1

    .prologue
    .line 222
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->search_keyword:Ljava/lang/String;

    return-object v0
.end method

.method public getSerial()I
    .locals 1

    .prologue
    .line 346
    iget v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->serial:I

    return v0
.end method

.method public getSetCount()Ljava/lang/String;
    .locals 1

    .prologue
    .line 577
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setCount:Ljava/lang/String;

    return-object v0
.end method

.method public getShort_desc()Ljava/lang/String;
    .locals 1

    .prologue
    .line 328
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->ppshort_desc:Ljava/lang/String;

    return-object v0
.end method

.method public getSize()Ljava/lang/String;
    .locals 1

    .prologue
    .line 378
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->size:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 354
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->title:Ljava/lang/String;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 444
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->type:Ljava/lang/String;

    return-object v0
.end method

.method public getUuid()Ljava/lang/Long;
    .locals 1

    .prologue
    .line 545
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->uuid:Ljava/lang/Long;

    return-object v0
.end method

.method public getVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 262
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->version:Ljava/lang/String;

    return-object v0
.end method

.method public isEditState()Z
    .locals 1

    .prologue
    .line 476
    iget-boolean v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->editState:Z

    return v0
.end method

.method public isSelected()Z
    .locals 1

    .prologue
    .line 561
    iget-boolean v0, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->isSelected:Z

    return v0
.end method

.method public setAlbum_title(Ljava/lang/String;)V
    .locals 0
    .param p1, "album_title"    # Ljava/lang/String;

    .prologue
    .line 306
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->album_title:Ljava/lang/String;

    .line 307
    return-void
.end method

.method public setArtist_title(Ljava/lang/String;)V
    .locals 0
    .param p1, "artist_title"    # Ljava/lang/String;

    .prologue
    .line 314
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->artist_title:Ljava/lang/String;

    .line 315
    return-void
.end method

.method public setAuthor_title(Ljava/lang/String;)V
    .locals 0
    .param p1, "author_title"    # Ljava/lang/String;

    .prologue
    .line 366
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->author_title:Ljava/lang/String;

    .line 367
    return-void
.end method

.method public setBanner_type(I)V
    .locals 0
    .param p1, "banner_type"    # I

    .prologue
    .line 242
    iput p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->banner_type:I

    .line 243
    return-void
.end method

.method public setBannerauthor_title(Ljava/lang/String;)V
    .locals 0
    .param p1, "bannerauthor_title"    # Ljava/lang/String;

    .prologue
    .line 139
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->bannerauthor_title:Ljava/lang/String;

    .line 140
    return-void
.end method

.method public setBannerhas_apk(Ljava/lang/String;)V
    .locals 0
    .param p1, "bannerhas_apk"    # Ljava/lang/String;

    .prologue
    .line 187
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->bannerhas_apk:Ljava/lang/String;

    .line 188
    return-void
.end method

.method public setBannericon(Ljava/lang/String;)V
    .locals 0
    .param p1, "bannericon"    # Ljava/lang/String;

    .prologue
    .line 147
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->bannericon:Ljava/lang/String;

    .line 148
    return-void
.end method

.method public setBannerid(Ljava/lang/String;)V
    .locals 0
    .param p1, "bannerid"    # Ljava/lang/String;

    .prologue
    .line 115
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->bannerid:Ljava/lang/String;

    .line 116
    return-void
.end method

.method public setBannerisoffical(Ljava/lang/String;)V
    .locals 0
    .param p1, "bannerisoffical"    # Ljava/lang/String;

    .prologue
    .line 171
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->bannerisoffical:Ljava/lang/String;

    .line 172
    return-void
.end method

.method public setBannerlink_url(Ljava/lang/String;)V
    .locals 0
    .param p1, "bannerlink_url"    # Ljava/lang/String;

    .prologue
    .line 179
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->bannerlink_url:Ljava/lang/String;

    .line 180
    return-void
.end method

.method public setBannerprice(Ljava/lang/String;)V
    .locals 0
    .param p1, "bannerprice"    # Ljava/lang/String;

    .prologue
    .line 107
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->bannerprice:Ljava/lang/String;

    .line 108
    return-void
.end method

.method public setBannerrating(Ljava/lang/String;)V
    .locals 0
    .param p1, "bannerrating"    # Ljava/lang/String;

    .prologue
    .line 163
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->bannerrating:Ljava/lang/String;

    .line 164
    return-void
.end method

.method public setBannerserial(Ljava/lang/String;)V
    .locals 0
    .param p1, "bannerserial"    # Ljava/lang/String;

    .prologue
    .line 123
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->bannerserial:Ljava/lang/String;

    .line 124
    return-void
.end method

.method public setBannersize(Ljava/lang/String;)V
    .locals 0
    .param p1, "bannersize"    # Ljava/lang/String;

    .prologue
    .line 155
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->bannersize:Ljava/lang/String;

    .line 156
    return-void
.end method

.method public setBannerstatus(Ljava/lang/String;)V
    .locals 0
    .param p1, "bannerstatus"    # Ljava/lang/String;

    .prologue
    .line 99
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->bannerstatus:Ljava/lang/String;

    .line 100
    return-void
.end method

.method public setBannertitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "bannertitle"    # Ljava/lang/String;

    .prologue
    .line 131
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->bannertitle:Ljava/lang/String;

    .line 132
    return-void
.end method

.method public setCat(Ljava/lang/String;)V
    .locals 0
    .param p1, "cat"    # Ljava/lang/String;

    .prologue
    .line 298
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->cat:Ljava/lang/String;

    .line 299
    return-void
.end method

.method public setCreate_time(Ljava/lang/Long;)V
    .locals 0
    .param p1, "create_time"    # Ljava/lang/Long;

    .prologue
    .line 440
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->create_time:Ljava/lang/Long;

    .line 441
    return-void
.end method

.method public setCurrentProgress(Ljava/lang/Long;)V
    .locals 0
    .param p1, "currentProgress"    # Ljava/lang/Long;

    .prologue
    .line 464
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->currentProgress:Ljava/lang/Long;

    .line 465
    return-void
.end method

.method public setDetail(Ljava/lang/String;)V
    .locals 0
    .param p1, "detail"    # Ljava/lang/String;

    .prologue
    .line 290
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->detail:Ljava/lang/String;

    .line 291
    return-void
.end method

.method public setDownloadFile(Lcom/aio/downloader/mydownload/DownloadFile;)V
    .locals 0
    .param p1, "downloadFile"    # Lcom/aio/downloader/mydownload/DownloadFile;

    .prologue
    .line 533
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->downloadFile:Lcom/aio/downloader/mydownload/DownloadFile;

    .line 534
    return-void
.end method

.method public setDownloadState(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "downloadState"    # Ljava/lang/Integer;

    .prologue
    .line 472
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->downloadState:Ljava/lang/Integer;

    .line 473
    return-void
.end method

.method public setDownloadUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "downloadUrl"    # Ljava/lang/String;

    .prologue
    .line 525
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->downloadUrl:Ljava/lang/String;

    .line 526
    return-void
.end method

.method public setDownloads(Ljava/lang/String;)V
    .locals 0
    .param p1, "downloads"    # Ljava/lang/String;

    .prologue
    .line 282
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->downloads:Ljava/lang/String;

    .line 283
    return-void
.end method

.method public setEditState(Z)V
    .locals 0
    .param p1, "editState"    # Z

    .prologue
    .line 480
    iput-boolean p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->editState:Z

    .line 481
    return-void
.end method

.method public setFilePath(Ljava/lang/String;)V
    .locals 0
    .param p1, "filePath"    # Ljava/lang/String;

    .prologue
    .line 557
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->filePath:Ljava/lang/String;

    .line 558
    return-void
.end method

.method public setFileSize(Ljava/lang/String;)V
    .locals 0
    .param p1, "fileSize"    # Ljava/lang/String;

    .prologue
    .line 496
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->fileSize:Ljava/lang/String;

    .line 497
    return-void
.end method

.method public setFile_id(Ljava/lang/String;)V
    .locals 0
    .param p1, "file_id"    # Ljava/lang/String;

    .prologue
    .line 432
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->file_id:Ljava/lang/String;

    .line 433
    return-void
.end method

.method public setHas_apk(Ljava/lang/String;)V
    .locals 0
    .param p1, "has_apk"    # Ljava/lang/String;

    .prologue
    .line 406
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->has_apk:Ljava/lang/String;

    .line 407
    return-void
.end method

.method public setHas_next_page(I)V
    .locals 0
    .param p1, "has_next_page"    # I

    .prologue
    .line 342
    iput p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->has_next_page:I

    .line 343
    return-void
.end method

.method public setIcon(Ljava/lang/String;)V
    .locals 0
    .param p1, "icon"    # Ljava/lang/String;

    .prologue
    .line 374
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->icon:Ljava/lang/String;

    .line 375
    return-void
.end method

.method public setId(Ljava/lang/String;)V
    .locals 0
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 573
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->id:Ljava/lang/String;

    .line 574
    return-void
.end method

.method public setInfotitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "infotitle"    # Ljava/lang/String;

    .prologue
    .line 202
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->infotitle:Ljava/lang/String;

    .line 203
    return-void
.end method

.method public setIs_official(Ljava/lang/String;)V
    .locals 0
    .param p1, "is_official"    # Ljava/lang/String;

    .prologue
    .line 424
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->is_official:Ljava/lang/String;

    .line 425
    return-void
.end method

.method public setLink(Ljava/lang/String;)V
    .locals 0
    .param p1, "link"    # Ljava/lang/String;

    .prologue
    .line 234
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->link:Ljava/lang/String;

    .line 235
    return-void
.end method

.method public setLink_url(Ljava/lang/String;)V
    .locals 0
    .param p1, "link_url"    # Ljava/lang/String;

    .prologue
    .line 250
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->link_url:Ljava/lang/String;

    .line 251
    return-void
.end method

.method public setMinigameicon(Ljava/lang/String;)V
    .locals 0
    .param p1, "minigameicon"    # Ljava/lang/String;

    .prologue
    .line 218
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->minigameicon:Ljava/lang/String;

    .line 219
    return-void
.end method

.method public setMinigamestatus(Ljava/lang/String;)V
    .locals 0
    .param p1, "minigamestatus"    # Ljava/lang/String;

    .prologue
    .line 91
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->minigamestatus:Ljava/lang/String;

    .line 92
    return-void
.end method

.method public setMinigametitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "minigametitle"    # Ljava/lang/String;

    .prologue
    .line 210
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->minigametitle:Ljava/lang/String;

    .line 211
    return-void
.end method

.method public setMovieHeadImage(Landroid/graphics/Bitmap;)V
    .locals 0
    .param p1, "movieHeadImage"    # Landroid/graphics/Bitmap;

    .prologue
    .line 488
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->movieHeadImage:Landroid/graphics/Bitmap;

    .line 489
    return-void
.end method

.method public setMovieHeadImagePath(Ljava/lang/String;)V
    .locals 0
    .param p1, "movieHeadImagePath"    # Ljava/lang/String;

    .prologue
    .line 589
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->movieHeadImagePath:Ljava/lang/String;

    .line 590
    return-void
.end method

.method public setMovieId(Ljava/lang/String;)V
    .locals 0
    .param p1, "movieId"    # Ljava/lang/String;

    .prologue
    .line 597
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->movieId:Ljava/lang/String;

    .line 598
    return-void
.end method

.method public setMovieName(Ljava/lang/String;)V
    .locals 0
    .param p1, "movieName"    # Ljava/lang/String;

    .prologue
    .line 504
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->movieName:Ljava/lang/String;

    .line 505
    return-void
.end method

.method public setPercentage(Ljava/lang/String;)V
    .locals 0
    .param p1, "percentage"    # Ljava/lang/String;

    .prologue
    .line 541
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->percentage:Ljava/lang/String;

    .line 542
    return-void
.end method

.method public setPosition(I)V
    .locals 0
    .param p1, "position"    # I

    .prologue
    .line 605
    iput p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->position:I

    .line 606
    return-void
.end method

.method public setPpshort_desc(Ljava/lang/String;)V
    .locals 0
    .param p1, "ppshort_desc"    # Ljava/lang/String;

    .prologue
    .line 324
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->ppshort_desc:Ljava/lang/String;

    .line 325
    return-void
.end method

.method public setPrice(Ljava/lang/String;)V
    .locals 0
    .param p1, "price"    # Ljava/lang/String;

    .prologue
    .line 398
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->price:Ljava/lang/String;

    .line 399
    return-void
.end method

.method public setProgressCount(Ljava/lang/Long;)V
    .locals 0
    .param p1, "progressCount"    # Ljava/lang/Long;

    .prologue
    .line 456
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->progressCount:Ljava/lang/Long;

    .line 457
    return-void
.end method

.method public setRating(Ljava/lang/Float;)V
    .locals 0
    .param p1, "rating"    # Ljava/lang/Float;

    .prologue
    .line 390
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->rating:Ljava/lang/Float;

    .line 391
    return-void
.end method

.method public setRelease_date(Ljava/lang/String;)V
    .locals 0
    .param p1, "release_date"    # Ljava/lang/String;

    .prologue
    .line 274
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->release_date:Ljava/lang/String;

    .line 275
    return-void
.end method

.method public setScreenshots(Ljava/lang/String;)V
    .locals 0
    .param p1, "screenshots"    # Ljava/lang/String;

    .prologue
    .line 258
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->screenshots:Ljava/lang/String;

    .line 259
    return-void
.end method

.method public setSearch_keyword(Ljava/lang/String;)V
    .locals 0
    .param p1, "search_keyword"    # Ljava/lang/String;

    .prologue
    .line 226
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->search_keyword:Ljava/lang/String;

    .line 227
    return-void
.end method

.method public setSelected(Z)V
    .locals 0
    .param p1, "isSelected"    # Z

    .prologue
    .line 565
    iput-boolean p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->isSelected:Z

    .line 566
    return-void
.end method

.method public setSerial(I)V
    .locals 0
    .param p1, "serial"    # I

    .prologue
    .line 350
    iput p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->serial:I

    .line 351
    return-void
.end method

.method public setSetCount(Ljava/lang/String;)V
    .locals 0
    .param p1, "setCount"    # Ljava/lang/String;

    .prologue
    .line 581
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setCount:Ljava/lang/String;

    .line 582
    return-void
.end method

.method public setShort_desc(Ljava/lang/String;)V
    .locals 0
    .param p1, "short_desc"    # Ljava/lang/String;

    .prologue
    .line 332
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->ppshort_desc:Ljava/lang/String;

    .line 333
    return-void
.end method

.method public setSize(Ljava/lang/String;)V
    .locals 0
    .param p1, "size"    # Ljava/lang/String;

    .prologue
    .line 382
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->size:Ljava/lang/String;

    .line 383
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "title"    # Ljava/lang/String;

    .prologue
    .line 358
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->title:Ljava/lang/String;

    .line 359
    return-void
.end method

.method public setType(Ljava/lang/String;)V
    .locals 0
    .param p1, "type"    # Ljava/lang/String;

    .prologue
    .line 448
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->type:Ljava/lang/String;

    .line 449
    return-void
.end method

.method public setUuid(Ljava/lang/Long;)V
    .locals 0
    .param p1, "uuid"    # Ljava/lang/Long;

    .prologue
    .line 549
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->uuid:Ljava/lang/Long;

    .line 550
    return-void
.end method

.method public setVersion(Ljava/lang/String;)V
    .locals 0
    .param p1, "version"    # Ljava/lang/String;

    .prologue
    .line 266
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->version:Ljava/lang/String;

    .line 267
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 513
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "DownloadMovieItem [progressCount="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->progressCount:Ljava/lang/Long;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 514
    const-string v1, ", currentProgress="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->currentProgress:Ljava/lang/Long;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", downloadState="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 515
    iget-object v1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->downloadState:Ljava/lang/Integer;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", editState="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->editState:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 516
    const-string v1, ", movieHeadImage="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->movieHeadImage:Landroid/graphics/Bitmap;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", fileSize="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 517
    iget-object v1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->fileSize:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", movieName="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/mydownload/DownloadMovieItem;->movieName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 513
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

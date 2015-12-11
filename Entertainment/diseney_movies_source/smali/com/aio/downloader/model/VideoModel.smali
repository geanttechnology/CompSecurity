.class public Lcom/aio/downloader/model/VideoModel;
.super Ljava/lang/Object;
.source "VideoModel.java"


# instance fields
.field private video_item_format:Ljava/lang/String;

.field private video_item_id:Ljava/lang/String;

.field private video_item_img:Ljava/lang/String;

.field private video_item_quality:Ljava/lang/String;

.field private video_item_size:Ljava/lang/String;

.field private video_item_title:Ljava/lang/String;

.field private video_item_type:Ljava/lang/String;

.field private video_item_url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getVideo_item_format()Ljava/lang/String;
    .locals 1

    .prologue
    .line 16
    iget-object v0, p0, Lcom/aio/downloader/model/VideoModel;->video_item_format:Ljava/lang/String;

    return-object v0
.end method

.method public getVideo_item_id()Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/aio/downloader/model/VideoModel;->video_item_id:Ljava/lang/String;

    return-object v0
.end method

.method public getVideo_item_img()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/aio/downloader/model/VideoModel;->video_item_img:Ljava/lang/String;

    return-object v0
.end method

.method public getVideo_item_quality()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/aio/downloader/model/VideoModel;->video_item_quality:Ljava/lang/String;

    return-object v0
.end method

.method public getVideo_item_size()Ljava/lang/String;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/aio/downloader/model/VideoModel;->video_item_size:Ljava/lang/String;

    return-object v0
.end method

.method public getVideo_item_title()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/aio/downloader/model/VideoModel;->video_item_title:Ljava/lang/String;

    return-object v0
.end method

.method public getVideo_item_type()Ljava/lang/String;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/aio/downloader/model/VideoModel;->video_item_type:Ljava/lang/String;

    return-object v0
.end method

.method public getVideo_item_url()Ljava/lang/String;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/aio/downloader/model/VideoModel;->video_item_url:Ljava/lang/String;

    return-object v0
.end method

.method public setVideo_item_format(Ljava/lang/String;)V
    .locals 0
    .param p1, "video_item_format"    # Ljava/lang/String;

    .prologue
    .line 19
    iput-object p1, p0, Lcom/aio/downloader/model/VideoModel;->video_item_format:Ljava/lang/String;

    .line 20
    return-void
.end method

.method public setVideo_item_id(Ljava/lang/String;)V
    .locals 0
    .param p1, "video_item_id"    # Ljava/lang/String;

    .prologue
    .line 25
    iput-object p1, p0, Lcom/aio/downloader/model/VideoModel;->video_item_id:Ljava/lang/String;

    .line 26
    return-void
.end method

.method public setVideo_item_img(Ljava/lang/String;)V
    .locals 0
    .param p1, "video_item_img"    # Ljava/lang/String;

    .prologue
    .line 37
    iput-object p1, p0, Lcom/aio/downloader/model/VideoModel;->video_item_img:Ljava/lang/String;

    .line 38
    return-void
.end method

.method public setVideo_item_quality(Ljava/lang/String;)V
    .locals 0
    .param p1, "video_item_quality"    # Ljava/lang/String;

    .prologue
    .line 57
    iput-object p1, p0, Lcom/aio/downloader/model/VideoModel;->video_item_quality:Ljava/lang/String;

    .line 58
    return-void
.end method

.method public setVideo_item_size(Ljava/lang/String;)V
    .locals 0
    .param p1, "video_item_size"    # Ljava/lang/String;

    .prologue
    .line 45
    iput-object p1, p0, Lcom/aio/downloader/model/VideoModel;->video_item_size:Ljava/lang/String;

    .line 46
    return-void
.end method

.method public setVideo_item_title(Ljava/lang/String;)V
    .locals 0
    .param p1, "video_item_title"    # Ljava/lang/String;

    .prologue
    .line 31
    iput-object p1, p0, Lcom/aio/downloader/model/VideoModel;->video_item_title:Ljava/lang/String;

    .line 32
    return-void
.end method

.method public setVideo_item_type(Ljava/lang/String;)V
    .locals 0
    .param p1, "video_item_type"    # Ljava/lang/String;

    .prologue
    .line 63
    iput-object p1, p0, Lcom/aio/downloader/model/VideoModel;->video_item_type:Ljava/lang/String;

    .line 64
    return-void
.end method

.method public setVideo_item_url(Ljava/lang/String;)V
    .locals 0
    .param p1, "video_item_url"    # Ljava/lang/String;

    .prologue
    .line 51
    iput-object p1, p0, Lcom/aio/downloader/model/VideoModel;->video_item_url:Ljava/lang/String;

    .line 52
    return-void
.end method

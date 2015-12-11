.class public Lcom/aio/downloader/model/Fun_appModel;
.super Ljava/lang/Object;
.source "Fun_appModel.java"


# instance fields
.field private cat:Ljava/lang/String;

.field private create_time:Ljava/lang/String;

.field public funlist:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private has_next_page:I

.field private img_count:I

.field private img_src:Ljava/lang/String;

.field private like_count:Ljava/lang/String;

.field private likenum:Z

.field private save:Ljava/lang/String;

.field private serial:Ljava/lang/String;

.field private share_count:Ljava/lang/String;

.field private thu_path:Ljava/lang/String;

.field private title:Ljava/lang/String;

.field private video_src:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 45
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/aio/downloader/model/Fun_appModel;->likenum:Z

    .line 5
    return-void
.end method


# virtual methods
.method public getCat()Ljava/lang/String;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/aio/downloader/model/Fun_appModel;->cat:Ljava/lang/String;

    return-object v0
.end method

.method public getCreate_time()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/aio/downloader/model/Fun_appModel;->create_time:Ljava/lang/String;

    return-object v0
.end method

.method public getFunlist()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 130
    iget-object v0, p0, Lcom/aio/downloader/model/Fun_appModel;->funlist:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getHas_next_page()I
    .locals 1

    .prologue
    .line 104
    iget v0, p0, Lcom/aio/downloader/model/Fun_appModel;->has_next_page:I

    return v0
.end method

.method public getImg_count()I
    .locals 1

    .prologue
    .line 96
    iget v0, p0, Lcom/aio/downloader/model/Fun_appModel;->img_count:I

    return v0
.end method

.method public getImg_src()Ljava/lang/String;
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/aio/downloader/model/Fun_appModel;->img_src:Ljava/lang/String;

    return-object v0
.end method

.method public getLike_count()Ljava/lang/String;
    .locals 1

    .prologue
    .line 12
    iget-object v0, p0, Lcom/aio/downloader/model/Fun_appModel;->like_count:Ljava/lang/String;

    return-object v0
.end method

.method public getSave()Ljava/lang/String;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/aio/downloader/model/Fun_appModel;->save:Ljava/lang/String;

    return-object v0
.end method

.method public getSerial()Ljava/lang/String;
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/aio/downloader/model/Fun_appModel;->serial:Ljava/lang/String;

    return-object v0
.end method

.method public getShare_count()Ljava/lang/String;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/aio/downloader/model/Fun_appModel;->share_count:Ljava/lang/String;

    return-object v0
.end method

.method public getThu_path()Ljava/lang/String;
    .locals 1

    .prologue
    .line 120
    iget-object v0, p0, Lcom/aio/downloader/model/Fun_appModel;->thu_path:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 112
    iget-object v0, p0, Lcom/aio/downloader/model/Fun_appModel;->title:Ljava/lang/String;

    return-object v0
.end method

.method public getVideo_src()Ljava/lang/String;
    .locals 1

    .prologue
    .line 88
    iget-object v0, p0, Lcom/aio/downloader/model/Fun_appModel;->video_src:Ljava/lang/String;

    return-object v0
.end method

.method public isLikenum()Z
    .locals 1

    .prologue
    .line 48
    iget-boolean v0, p0, Lcom/aio/downloader/model/Fun_appModel;->likenum:Z

    return v0
.end method

.method public setCat(Ljava/lang/String;)V
    .locals 0
    .param p1, "cat"    # Ljava/lang/String;

    .prologue
    .line 68
    iput-object p1, p0, Lcom/aio/downloader/model/Fun_appModel;->cat:Ljava/lang/String;

    .line 69
    return-void
.end method

.method public setCreate_time(Ljava/lang/String;)V
    .locals 0
    .param p1, "create_time"    # Ljava/lang/String;

    .prologue
    .line 32
    iput-object p1, p0, Lcom/aio/downloader/model/Fun_appModel;->create_time:Ljava/lang/String;

    .line 33
    return-void
.end method

.method public setFunlist(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 134
    .local p1, "funlist":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/aio/downloader/model/Fun_appModel;->funlist:Ljava/util/ArrayList;

    .line 135
    return-void
.end method

.method public setHas_next_page(I)V
    .locals 0
    .param p1, "has_next_page"    # I

    .prologue
    .line 108
    iput p1, p0, Lcom/aio/downloader/model/Fun_appModel;->has_next_page:I

    .line 109
    return-void
.end method

.method public setImg_count(I)V
    .locals 0
    .param p1, "img_count"    # I

    .prologue
    .line 100
    iput p1, p0, Lcom/aio/downloader/model/Fun_appModel;->img_count:I

    .line 101
    return-void
.end method

.method public setImg_src(Ljava/lang/String;)V
    .locals 0
    .param p1, "img_src"    # Ljava/lang/String;

    .prologue
    .line 84
    iput-object p1, p0, Lcom/aio/downloader/model/Fun_appModel;->img_src:Ljava/lang/String;

    .line 85
    return-void
.end method

.method public setLike_count(Ljava/lang/String;)V
    .locals 0
    .param p1, "like_count"    # Ljava/lang/String;

    .prologue
    .line 16
    iput-object p1, p0, Lcom/aio/downloader/model/Fun_appModel;->like_count:Ljava/lang/String;

    .line 17
    return-void
.end method

.method public setLikenum(Z)V
    .locals 0
    .param p1, "likenum"    # Z

    .prologue
    .line 52
    iput-boolean p1, p0, Lcom/aio/downloader/model/Fun_appModel;->likenum:Z

    .line 53
    return-void
.end method

.method public setSave(Ljava/lang/String;)V
    .locals 0
    .param p1, "save"    # Ljava/lang/String;

    .prologue
    .line 60
    iput-object p1, p0, Lcom/aio/downloader/model/Fun_appModel;->save:Ljava/lang/String;

    .line 61
    return-void
.end method

.method public setSerial(Ljava/lang/String;)V
    .locals 0
    .param p1, "serial"    # Ljava/lang/String;

    .prologue
    .line 76
    iput-object p1, p0, Lcom/aio/downloader/model/Fun_appModel;->serial:Ljava/lang/String;

    .line 77
    return-void
.end method

.method public setShare_count(Ljava/lang/String;)V
    .locals 0
    .param p1, "share_count"    # Ljava/lang/String;

    .prologue
    .line 24
    iput-object p1, p0, Lcom/aio/downloader/model/Fun_appModel;->share_count:Ljava/lang/String;

    .line 25
    return-void
.end method

.method public setThu_path(Ljava/lang/String;)V
    .locals 0
    .param p1, "thu_path"    # Ljava/lang/String;

    .prologue
    .line 124
    iput-object p1, p0, Lcom/aio/downloader/model/Fun_appModel;->thu_path:Ljava/lang/String;

    .line 125
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "title"    # Ljava/lang/String;

    .prologue
    .line 116
    iput-object p1, p0, Lcom/aio/downloader/model/Fun_appModel;->title:Ljava/lang/String;

    .line 117
    return-void
.end method

.method public setVideo_src(Ljava/lang/String;)V
    .locals 0
    .param p1, "video_src"    # Ljava/lang/String;

    .prologue
    .line 92
    iput-object p1, p0, Lcom/aio/downloader/model/Fun_appModel;->video_src:Ljava/lang/String;

    .line 93
    return-void
.end method

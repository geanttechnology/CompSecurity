.class public Lcom/aio/downloader/model/FunModel;
.super Ljava/lang/Object;
.source "FunModel.java"


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

    .line 44
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/aio/downloader/model/FunModel;->likenum:Z

    .line 5
    return-void
.end method


# virtual methods
.method public getCat()Ljava/lang/String;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/aio/downloader/model/FunModel;->cat:Ljava/lang/String;

    return-object v0
.end method

.method public getCreate_time()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/aio/downloader/model/FunModel;->create_time:Ljava/lang/String;

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
    .line 129
    iget-object v0, p0, Lcom/aio/downloader/model/FunModel;->funlist:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getHas_next_page()I
    .locals 1

    .prologue
    .line 103
    iget v0, p0, Lcom/aio/downloader/model/FunModel;->has_next_page:I

    return v0
.end method

.method public getImg_count()I
    .locals 1

    .prologue
    .line 95
    iget v0, p0, Lcom/aio/downloader/model/FunModel;->img_count:I

    return v0
.end method

.method public getImg_src()Ljava/lang/String;
    .locals 1

    .prologue
    .line 79
    iget-object v0, p0, Lcom/aio/downloader/model/FunModel;->img_src:Ljava/lang/String;

    return-object v0
.end method

.method public getLike_count()Ljava/lang/String;
    .locals 1

    .prologue
    .line 12
    iget-object v0, p0, Lcom/aio/downloader/model/FunModel;->like_count:Ljava/lang/String;

    return-object v0
.end method

.method public getSave()Ljava/lang/String;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/aio/downloader/model/FunModel;->save:Ljava/lang/String;

    return-object v0
.end method

.method public getSerial()Ljava/lang/String;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/aio/downloader/model/FunModel;->serial:Ljava/lang/String;

    return-object v0
.end method

.method public getShare_count()Ljava/lang/String;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/aio/downloader/model/FunModel;->share_count:Ljava/lang/String;

    return-object v0
.end method

.method public getThu_path()Ljava/lang/String;
    .locals 1

    .prologue
    .line 119
    iget-object v0, p0, Lcom/aio/downloader/model/FunModel;->thu_path:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 111
    iget-object v0, p0, Lcom/aio/downloader/model/FunModel;->title:Ljava/lang/String;

    return-object v0
.end method

.method public getVideo_src()Ljava/lang/String;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/aio/downloader/model/FunModel;->video_src:Ljava/lang/String;

    return-object v0
.end method

.method public isLikenum()Z
    .locals 1

    .prologue
    .line 47
    iget-boolean v0, p0, Lcom/aio/downloader/model/FunModel;->likenum:Z

    return v0
.end method

.method public setCat(Ljava/lang/String;)V
    .locals 0
    .param p1, "cat"    # Ljava/lang/String;

    .prologue
    .line 67
    iput-object p1, p0, Lcom/aio/downloader/model/FunModel;->cat:Ljava/lang/String;

    .line 68
    return-void
.end method

.method public setCreate_time(Ljava/lang/String;)V
    .locals 0
    .param p1, "create_time"    # Ljava/lang/String;

    .prologue
    .line 32
    iput-object p1, p0, Lcom/aio/downloader/model/FunModel;->create_time:Ljava/lang/String;

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
    .line 133
    .local p1, "funlist":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/aio/downloader/model/FunModel;->funlist:Ljava/util/ArrayList;

    .line 134
    return-void
.end method

.method public setHas_next_page(I)V
    .locals 0
    .param p1, "has_next_page"    # I

    .prologue
    .line 107
    iput p1, p0, Lcom/aio/downloader/model/FunModel;->has_next_page:I

    .line 108
    return-void
.end method

.method public setImg_count(I)V
    .locals 0
    .param p1, "img_count"    # I

    .prologue
    .line 99
    iput p1, p0, Lcom/aio/downloader/model/FunModel;->img_count:I

    .line 100
    return-void
.end method

.method public setImg_src(Ljava/lang/String;)V
    .locals 0
    .param p1, "img_src"    # Ljava/lang/String;

    .prologue
    .line 83
    iput-object p1, p0, Lcom/aio/downloader/model/FunModel;->img_src:Ljava/lang/String;

    .line 84
    return-void
.end method

.method public setLike_count(Ljava/lang/String;)V
    .locals 0
    .param p1, "like_count"    # Ljava/lang/String;

    .prologue
    .line 16
    iput-object p1, p0, Lcom/aio/downloader/model/FunModel;->like_count:Ljava/lang/String;

    .line 17
    return-void
.end method

.method public setLikenum(Z)V
    .locals 0
    .param p1, "likenum"    # Z

    .prologue
    .line 51
    iput-boolean p1, p0, Lcom/aio/downloader/model/FunModel;->likenum:Z

    .line 52
    return-void
.end method

.method public setSave(Ljava/lang/String;)V
    .locals 0
    .param p1, "save"    # Ljava/lang/String;

    .prologue
    .line 59
    iput-object p1, p0, Lcom/aio/downloader/model/FunModel;->save:Ljava/lang/String;

    .line 60
    return-void
.end method

.method public setSerial(Ljava/lang/String;)V
    .locals 0
    .param p1, "serial"    # Ljava/lang/String;

    .prologue
    .line 75
    iput-object p1, p0, Lcom/aio/downloader/model/FunModel;->serial:Ljava/lang/String;

    .line 76
    return-void
.end method

.method public setShare_count(Ljava/lang/String;)V
    .locals 0
    .param p1, "share_count"    # Ljava/lang/String;

    .prologue
    .line 24
    iput-object p1, p0, Lcom/aio/downloader/model/FunModel;->share_count:Ljava/lang/String;

    .line 25
    return-void
.end method

.method public setThu_path(Ljava/lang/String;)V
    .locals 0
    .param p1, "thu_path"    # Ljava/lang/String;

    .prologue
    .line 123
    iput-object p1, p0, Lcom/aio/downloader/model/FunModel;->thu_path:Ljava/lang/String;

    .line 124
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "title"    # Ljava/lang/String;

    .prologue
    .line 115
    iput-object p1, p0, Lcom/aio/downloader/model/FunModel;->title:Ljava/lang/String;

    .line 116
    return-void
.end method

.method public setVideo_src(Ljava/lang/String;)V
    .locals 0
    .param p1, "video_src"    # Ljava/lang/String;

    .prologue
    .line 91
    iput-object p1, p0, Lcom/aio/downloader/model/FunModel;->video_src:Ljava/lang/String;

    .line 92
    return-void
.end method

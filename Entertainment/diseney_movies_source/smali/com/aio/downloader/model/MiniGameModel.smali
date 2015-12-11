.class public Lcom/aio/downloader/model/MiniGameModel;
.super Ljava/lang/Object;
.source "MiniGameModel.java"

# interfaces
.implements Ljava/io/Serializable;


# instance fields
.field private create_time:Ljava/lang/String;

.field private detail:Ljava/lang/String;

.field private hits:Ljava/lang/String;

.field private icon:Ljava/lang/String;

.field private is_safe:Ljava/lang/String;

.field private last_play_time:Ljava/lang/String;

.field private next:I

.field private play_url:Ljava/lang/String;

.field private proc:Ljava/lang/String;

.field private serial:Ljava/lang/String;

.field private short_desc:Ljava/lang/String;

.field private sound:Ljava/lang/String;

.field private title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCreate_time()Ljava/lang/String;
    .locals 1

    .prologue
    .line 112
    iget-object v0, p0, Lcom/aio/downloader/model/MiniGameModel;->create_time:Ljava/lang/String;

    return-object v0
.end method

.method public getDetail()Ljava/lang/String;
    .locals 1

    .prologue
    .line 88
    iget-object v0, p0, Lcom/aio/downloader/model/MiniGameModel;->detail:Ljava/lang/String;

    return-object v0
.end method

.method public getHits()Ljava/lang/String;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/aio/downloader/model/MiniGameModel;->hits:Ljava/lang/String;

    return-object v0
.end method

.method public getIcon()Ljava/lang/String;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/aio/downloader/model/MiniGameModel;->icon:Ljava/lang/String;

    return-object v0
.end method

.method public getIs_safe()Ljava/lang/String;
    .locals 1

    .prologue
    .line 120
    iget-object v0, p0, Lcom/aio/downloader/model/MiniGameModel;->is_safe:Ljava/lang/String;

    return-object v0
.end method

.method public getLast_play_time()Ljava/lang/String;
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lcom/aio/downloader/model/MiniGameModel;->last_play_time:Ljava/lang/String;

    return-object v0
.end method

.method public getNext()I
    .locals 1

    .prologue
    .line 24
    iget v0, p0, Lcom/aio/downloader/model/MiniGameModel;->next:I

    return v0
.end method

.method public getPlay_url()Ljava/lang/String;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/aio/downloader/model/MiniGameModel;->play_url:Ljava/lang/String;

    return-object v0
.end method

.method public getProc()Ljava/lang/String;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/aio/downloader/model/MiniGameModel;->proc:Ljava/lang/String;

    return-object v0
.end method

.method public getSerial()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/aio/downloader/model/MiniGameModel;->serial:Ljava/lang/String;

    return-object v0
.end method

.method public getShort_desc()Ljava/lang/String;
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/aio/downloader/model/MiniGameModel;->short_desc:Ljava/lang/String;

    return-object v0
.end method

.method public getSound()Ljava/lang/String;
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/aio/downloader/model/MiniGameModel;->sound:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/aio/downloader/model/MiniGameModel;->title:Ljava/lang/String;

    return-object v0
.end method

.method public setCreate_time(Ljava/lang/String;)V
    .locals 0
    .param p1, "create_time"    # Ljava/lang/String;

    .prologue
    .line 116
    iput-object p1, p0, Lcom/aio/downloader/model/MiniGameModel;->create_time:Ljava/lang/String;

    .line 117
    return-void
.end method

.method public setDetail(Ljava/lang/String;)V
    .locals 0
    .param p1, "detail"    # Ljava/lang/String;

    .prologue
    .line 92
    iput-object p1, p0, Lcom/aio/downloader/model/MiniGameModel;->detail:Ljava/lang/String;

    .line 93
    return-void
.end method

.method public setHits(Ljava/lang/String;)V
    .locals 0
    .param p1, "hits"    # Ljava/lang/String;

    .prologue
    .line 100
    iput-object p1, p0, Lcom/aio/downloader/model/MiniGameModel;->hits:Ljava/lang/String;

    .line 101
    return-void
.end method

.method public setIcon(Ljava/lang/String;)V
    .locals 0
    .param p1, "icon"    # Ljava/lang/String;

    .prologue
    .line 52
    iput-object p1, p0, Lcom/aio/downloader/model/MiniGameModel;->icon:Ljava/lang/String;

    .line 53
    return-void
.end method

.method public setIs_safe(Ljava/lang/String;)V
    .locals 0
    .param p1, "is_safe"    # Ljava/lang/String;

    .prologue
    .line 124
    iput-object p1, p0, Lcom/aio/downloader/model/MiniGameModel;->is_safe:Ljava/lang/String;

    .line 125
    return-void
.end method

.method public setLast_play_time(Ljava/lang/String;)V
    .locals 0
    .param p1, "last_play_time"    # Ljava/lang/String;

    .prologue
    .line 108
    iput-object p1, p0, Lcom/aio/downloader/model/MiniGameModel;->last_play_time:Ljava/lang/String;

    .line 109
    return-void
.end method

.method public setNext(I)V
    .locals 0
    .param p1, "next"    # I

    .prologue
    .line 28
    iput p1, p0, Lcom/aio/downloader/model/MiniGameModel;->next:I

    .line 29
    return-void
.end method

.method public setPlay_url(Ljava/lang/String;)V
    .locals 0
    .param p1, "play_url"    # Ljava/lang/String;

    .prologue
    .line 60
    iput-object p1, p0, Lcom/aio/downloader/model/MiniGameModel;->play_url:Ljava/lang/String;

    .line 61
    return-void
.end method

.method public setProc(Ljava/lang/String;)V
    .locals 0
    .param p1, "proc"    # Ljava/lang/String;

    .prologue
    .line 68
    iput-object p1, p0, Lcom/aio/downloader/model/MiniGameModel;->proc:Ljava/lang/String;

    .line 69
    return-void
.end method

.method public setSerial(Ljava/lang/String;)V
    .locals 0
    .param p1, "serial"    # Ljava/lang/String;

    .prologue
    .line 36
    iput-object p1, p0, Lcom/aio/downloader/model/MiniGameModel;->serial:Ljava/lang/String;

    .line 37
    return-void
.end method

.method public setShort_desc(Ljava/lang/String;)V
    .locals 0
    .param p1, "short_desc"    # Ljava/lang/String;

    .prologue
    .line 84
    iput-object p1, p0, Lcom/aio/downloader/model/MiniGameModel;->short_desc:Ljava/lang/String;

    .line 85
    return-void
.end method

.method public setSound(Ljava/lang/String;)V
    .locals 0
    .param p1, "sound"    # Ljava/lang/String;

    .prologue
    .line 76
    iput-object p1, p0, Lcom/aio/downloader/model/MiniGameModel;->sound:Ljava/lang/String;

    .line 77
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "title"    # Ljava/lang/String;

    .prologue
    .line 44
    iput-object p1, p0, Lcom/aio/downloader/model/MiniGameModel;->title:Ljava/lang/String;

    .line 45
    return-void
.end method

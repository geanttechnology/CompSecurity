.class public Lcom/aio/downloader/model/Model;
.super Ljava/lang/Object;
.source "Model.java"


# instance fields
.field private appurl:Ljava/lang/String;

.field private mp3searchurl:Ljava/lang/String;

.field private mp3url:Ljava/lang/String;

.field private ringtoneurl:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAppurl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 16
    iget-object v0, p0, Lcom/aio/downloader/model/Model;->appurl:Ljava/lang/String;

    return-object v0
.end method

.method public getMp3searchurl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 10
    iget-object v0, p0, Lcom/aio/downloader/model/Model;->mp3searchurl:Ljava/lang/String;

    return-object v0
.end method

.method public getMp3url()Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/aio/downloader/model/Model;->mp3url:Ljava/lang/String;

    return-object v0
.end method

.method public getRingtoneurl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/aio/downloader/model/Model;->ringtoneurl:Ljava/lang/String;

    return-object v0
.end method

.method public setAppurl(Ljava/lang/String;)V
    .locals 0
    .param p1, "appurl"    # Ljava/lang/String;

    .prologue
    .line 19
    iput-object p1, p0, Lcom/aio/downloader/model/Model;->appurl:Ljava/lang/String;

    .line 20
    return-void
.end method

.method public setMp3searchurl(Ljava/lang/String;)V
    .locals 0
    .param p1, "mp3searchurl"    # Ljava/lang/String;

    .prologue
    .line 13
    iput-object p1, p0, Lcom/aio/downloader/model/Model;->mp3searchurl:Ljava/lang/String;

    .line 14
    return-void
.end method

.method public setMp3url(Ljava/lang/String;)V
    .locals 0
    .param p1, "mp3url"    # Ljava/lang/String;

    .prologue
    .line 25
    iput-object p1, p0, Lcom/aio/downloader/model/Model;->mp3url:Ljava/lang/String;

    .line 26
    return-void
.end method

.method public setRingtoneurl(Ljava/lang/String;)V
    .locals 0
    .param p1, "ringtoneurl"    # Ljava/lang/String;

    .prologue
    .line 31
    iput-object p1, p0, Lcom/aio/downloader/model/Model;->ringtoneurl:Ljava/lang/String;

    .line 32
    return-void
.end method

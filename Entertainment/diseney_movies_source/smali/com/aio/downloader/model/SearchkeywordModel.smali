.class public Lcom/aio/downloader/model/SearchkeywordModel;
.super Ljava/lang/Object;
.source "SearchkeywordModel.java"


# instance fields
.field private id:Ljava/lang/String;

.field private keyword:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 7
    iget-object v0, p0, Lcom/aio/downloader/model/SearchkeywordModel;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getKeyword()Ljava/lang/String;
    .locals 1

    .prologue
    .line 13
    iget-object v0, p0, Lcom/aio/downloader/model/SearchkeywordModel;->keyword:Ljava/lang/String;

    return-object v0
.end method

.method public setId(Ljava/lang/String;)V
    .locals 0
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 10
    iput-object p1, p0, Lcom/aio/downloader/model/SearchkeywordModel;->id:Ljava/lang/String;

    .line 11
    return-void
.end method

.method public setKeyword(Ljava/lang/String;)V
    .locals 0
    .param p1, "keyword"    # Ljava/lang/String;

    .prologue
    .line 16
    iput-object p1, p0, Lcom/aio/downloader/model/SearchkeywordModel;->keyword:Ljava/lang/String;

    .line 17
    return-void
.end method

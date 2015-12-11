.class public Lcom/aio/downloader/model/SearcherPromitModel;
.super Ljava/lang/Object;
.source "SearcherPromitModel.java"


# instance fields
.field private s:Ljava/lang/String;

.field private t:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getS()Ljava/lang/String;
    .locals 1

    .prologue
    .line 16
    iget-object v0, p0, Lcom/aio/downloader/model/SearcherPromitModel;->s:Ljava/lang/String;

    return-object v0
.end method

.method public getT()Ljava/lang/String;
    .locals 1

    .prologue
    .line 8
    iget-object v0, p0, Lcom/aio/downloader/model/SearcherPromitModel;->t:Ljava/lang/String;

    return-object v0
.end method

.method public setS(Ljava/lang/String;)V
    .locals 0
    .param p1, "s"    # Ljava/lang/String;

    .prologue
    .line 20
    iput-object p1, p0, Lcom/aio/downloader/model/SearcherPromitModel;->s:Ljava/lang/String;

    .line 21
    return-void
.end method

.method public setT(Ljava/lang/String;)V
    .locals 0
    .param p1, "t"    # Ljava/lang/String;

    .prologue
    .line 12
    iput-object p1, p0, Lcom/aio/downloader/model/SearcherPromitModel;->t:Ljava/lang/String;

    .line 13
    return-void
.end method

.class public Lcom/aio/downloader/model/MinigamesearchModel;
.super Ljava/lang/Object;
.source "MinigamesearchModel.java"


# instance fields
.field private keywords:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getKeywords()Ljava/lang/String;
    .locals 1

    .prologue
    .line 7
    iget-object v0, p0, Lcom/aio/downloader/model/MinigamesearchModel;->keywords:Ljava/lang/String;

    return-object v0
.end method

.method public setKeywords(Ljava/lang/String;)V
    .locals 0
    .param p1, "keywords"    # Ljava/lang/String;

    .prologue
    .line 11
    iput-object p1, p0, Lcom/aio/downloader/model/MinigamesearchModel;->keywords:Ljava/lang/String;

    .line 12
    return-void
.end method

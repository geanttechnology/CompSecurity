.class public Lcom/aio/downloader/cleaner/Bean;
.super Ljava/lang/Object;
.source "Bean.java"


# instance fields
.field private Appname:Ljava/lang/String;

.field private Mysize:D

.field private Packagebname:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAppname()Ljava/lang/String;
    .locals 1

    .prologue
    .line 16
    iget-object v0, p0, Lcom/aio/downloader/cleaner/Bean;->Appname:Ljava/lang/String;

    return-object v0
.end method

.method public getMysize()D
    .locals 2

    .prologue
    .line 25
    iget-wide v0, p0, Lcom/aio/downloader/cleaner/Bean;->Mysize:D

    return-wide v0
.end method

.method public getPackagebname()Ljava/lang/String;
    .locals 1

    .prologue
    .line 7
    iget-object v0, p0, Lcom/aio/downloader/cleaner/Bean;->Packagebname:Ljava/lang/String;

    return-object v0
.end method

.method public setAppname(Ljava/lang/String;)V
    .locals 0
    .param p1, "appname"    # Ljava/lang/String;

    .prologue
    .line 20
    iput-object p1, p0, Lcom/aio/downloader/cleaner/Bean;->Appname:Ljava/lang/String;

    .line 21
    return-void
.end method

.method public setMysize(D)V
    .locals 0
    .param p1, "mysize"    # D

    .prologue
    .line 29
    iput-wide p1, p0, Lcom/aio/downloader/cleaner/Bean;->Mysize:D

    .line 30
    return-void
.end method

.method public setPackagebname(Ljava/lang/String;)V
    .locals 0
    .param p1, "packagebname"    # Ljava/lang/String;

    .prologue
    .line 11
    iput-object p1, p0, Lcom/aio/downloader/cleaner/Bean;->Packagebname:Ljava/lang/String;

    .line 12
    return-void
.end method

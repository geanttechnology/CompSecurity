.class public Lcom/aio/downloader/model/BackupModel;
.super Ljava/lang/Object;
.source "BackupModel.java"


# instance fields
.field private Img:Ljava/lang/String;

.field private Size:Ljava/lang/String;

.field private Version:Ljava/lang/String;

.field private app_name:Ljava/lang/String;

.field private package_name:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getApp_name()Ljava/lang/String;
    .locals 1

    .prologue
    .line 13
    iget-object v0, p0, Lcom/aio/downloader/model/BackupModel;->app_name:Ljava/lang/String;

    return-object v0
.end method

.method public getImg()Ljava/lang/String;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/aio/downloader/model/BackupModel;->Img:Ljava/lang/String;

    return-object v0
.end method

.method public getPackage_name()Ljava/lang/String;
    .locals 1

    .prologue
    .line 5
    iget-object v0, p0, Lcom/aio/downloader/model/BackupModel;->package_name:Ljava/lang/String;

    return-object v0
.end method

.method public getSize()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/aio/downloader/model/BackupModel;->Size:Ljava/lang/String;

    return-object v0
.end method

.method public getVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/aio/downloader/model/BackupModel;->Version:Ljava/lang/String;

    return-object v0
.end method

.method public setApp_name(Ljava/lang/String;)V
    .locals 0
    .param p1, "app_name"    # Ljava/lang/String;

    .prologue
    .line 17
    iput-object p1, p0, Lcom/aio/downloader/model/BackupModel;->app_name:Ljava/lang/String;

    .line 18
    return-void
.end method

.method public setImg(Ljava/lang/String;)V
    .locals 0
    .param p1, "img"    # Ljava/lang/String;

    .prologue
    .line 43
    iput-object p1, p0, Lcom/aio/downloader/model/BackupModel;->Img:Ljava/lang/String;

    .line 44
    return-void
.end method

.method public setPackage_name(Ljava/lang/String;)V
    .locals 0
    .param p1, "package_name"    # Ljava/lang/String;

    .prologue
    .line 9
    iput-object p1, p0, Lcom/aio/downloader/model/BackupModel;->package_name:Ljava/lang/String;

    .line 10
    return-void
.end method

.method public setSize(Ljava/lang/String;)V
    .locals 0
    .param p1, "size"    # Ljava/lang/String;

    .prologue
    .line 35
    iput-object p1, p0, Lcom/aio/downloader/model/BackupModel;->Size:Ljava/lang/String;

    .line 36
    return-void
.end method

.method public setVersion(Ljava/lang/String;)V
    .locals 0
    .param p1, "version"    # Ljava/lang/String;

    .prologue
    .line 27
    iput-object p1, p0, Lcom/aio/downloader/model/BackupModel;->Version:Ljava/lang/String;

    .line 28
    return-void
.end method

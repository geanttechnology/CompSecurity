.class public Lcom/aio/downloader/model/AppInstalledEntity;
.super Ljava/lang/Object;
.source "AppInstalledEntity.java"


# instance fields
.field private ackageinfo:Ljava/lang/String;

.field private apkpath:Ljava/lang/String;

.field private appId:Ljava/lang/String;

.field private appname:Ljava/lang/String;

.field private icon:Landroid/graphics/drawable/Drawable;

.field private size:Ljava/lang/String;

.field private version:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAckageinfo()Ljava/lang/String;
    .locals 1

    .prologue
    .line 15
    iget-object v0, p0, Lcom/aio/downloader/model/AppInstalledEntity;->ackageinfo:Ljava/lang/String;

    return-object v0
.end method

.method public getApkpath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/aio/downloader/model/AppInstalledEntity;->apkpath:Ljava/lang/String;

    return-object v0
.end method

.method public getAppId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/aio/downloader/model/AppInstalledEntity;->appId:Ljava/lang/String;

    return-object v0
.end method

.method public getAppname()Ljava/lang/String;
    .locals 1

    .prologue
    .line 7
    iget-object v0, p0, Lcom/aio/downloader/model/AppInstalledEntity;->appname:Ljava/lang/String;

    return-object v0
.end method

.method public getIcon()Landroid/graphics/drawable/Drawable;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/aio/downloader/model/AppInstalledEntity;->icon:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method public getSize()Ljava/lang/String;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/aio/downloader/model/AppInstalledEntity;->size:Ljava/lang/String;

    return-object v0
.end method

.method public getVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/aio/downloader/model/AppInstalledEntity;->version:Ljava/lang/String;

    return-object v0
.end method

.method public setAckageinfo(Ljava/lang/String;)V
    .locals 0
    .param p1, "ackageinfo"    # Ljava/lang/String;

    .prologue
    .line 19
    iput-object p1, p0, Lcom/aio/downloader/model/AppInstalledEntity;->ackageinfo:Ljava/lang/String;

    .line 20
    return-void
.end method

.method public setApkpath(Ljava/lang/String;)V
    .locals 0
    .param p1, "apkpath"    # Ljava/lang/String;

    .prologue
    .line 65
    iput-object p1, p0, Lcom/aio/downloader/model/AppInstalledEntity;->apkpath:Ljava/lang/String;

    .line 66
    return-void
.end method

.method public setAppId(Ljava/lang/String;)V
    .locals 0
    .param p1, "appId"    # Ljava/lang/String;

    .prologue
    .line 51
    iput-object p1, p0, Lcom/aio/downloader/model/AppInstalledEntity;->appId:Ljava/lang/String;

    .line 52
    return-void
.end method

.method public setAppname(Ljava/lang/String;)V
    .locals 0
    .param p1, "appname"    # Ljava/lang/String;

    .prologue
    .line 11
    iput-object p1, p0, Lcom/aio/downloader/model/AppInstalledEntity;->appname:Ljava/lang/String;

    .line 12
    return-void
.end method

.method public setIcon(Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .param p1, "icon"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 27
    iput-object p1, p0, Lcom/aio/downloader/model/AppInstalledEntity;->icon:Landroid/graphics/drawable/Drawable;

    .line 28
    return-void
.end method

.method public setSize(Ljava/lang/String;)V
    .locals 0
    .param p1, "size"    # Ljava/lang/String;

    .prologue
    .line 43
    iput-object p1, p0, Lcom/aio/downloader/model/AppInstalledEntity;->size:Ljava/lang/String;

    .line 44
    return-void
.end method

.method public setVersion(Ljava/lang/String;)V
    .locals 0
    .param p1, "version"    # Ljava/lang/String;

    .prologue
    .line 35
    iput-object p1, p0, Lcom/aio/downloader/model/AppInstalledEntity;->version:Ljava/lang/String;

    .line 36
    return-void
.end method

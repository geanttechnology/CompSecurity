.class public Lcom/aio/downloader/model/AppInfo;
.super Ljava/lang/Object;
.source "AppInfo.java"


# instance fields
.field private appname:Ljava/lang/String;

.field private avatar:Landroid/graphics/drawable/Drawable;

.field private p_name:Ljava/lang/String;

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
.method public getAppname()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/aio/downloader/model/AppInfo;->appname:Ljava/lang/String;

    return-object v0
.end method

.method public getAvatar()Landroid/graphics/drawable/Drawable;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/aio/downloader/model/AppInfo;->avatar:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method public getP_name()Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/aio/downloader/model/AppInfo;->p_name:Ljava/lang/String;

    return-object v0
.end method

.method public getVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 16
    iget-object v0, p0, Lcom/aio/downloader/model/AppInfo;->version:Ljava/lang/String;

    return-object v0
.end method

.method public setAppname(Ljava/lang/String;)V
    .locals 0
    .param p1, "appname"    # Ljava/lang/String;

    .prologue
    .line 36
    iput-object p1, p0, Lcom/aio/downloader/model/AppInfo;->appname:Ljava/lang/String;

    .line 37
    return-void
.end method

.method public setAvatar(Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 44
    iput-object p1, p0, Lcom/aio/downloader/model/AppInfo;->avatar:Landroid/graphics/drawable/Drawable;

    .line 45
    return-void
.end method

.method public setP_name(Ljava/lang/String;)V
    .locals 0
    .param p1, "p_name"    # Ljava/lang/String;

    .prologue
    .line 28
    iput-object p1, p0, Lcom/aio/downloader/model/AppInfo;->p_name:Ljava/lang/String;

    .line 29
    return-void
.end method

.method public setVersion(Ljava/lang/String;)V
    .locals 0
    .param p1, "version"    # Ljava/lang/String;

    .prologue
    .line 20
    iput-object p1, p0, Lcom/aio/downloader/model/AppInfo;->version:Ljava/lang/String;

    .line 21
    return-void
.end method

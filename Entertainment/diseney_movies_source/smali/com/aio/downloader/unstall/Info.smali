.class public Lcom/aio/downloader/unstall/Info;
.super Ljava/lang/Object;
.source "Info.java"


# instance fields
.field private icon:Landroid/graphics/drawable/Drawable;

.field private name:Ljava/lang/String;

.field private packagename:Ljava/lang/String;

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
.method public getIcon()Landroid/graphics/drawable/Drawable;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/aio/downloader/unstall/Info;->icon:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 11
    iget-object v0, p0, Lcom/aio/downloader/unstall/Info;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getPackagename()Ljava/lang/String;
    .locals 1

    .prologue
    .line 17
    iget-object v0, p0, Lcom/aio/downloader/unstall/Info;->packagename:Ljava/lang/String;

    return-object v0
.end method

.method public getVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/aio/downloader/unstall/Info;->version:Ljava/lang/String;

    return-object v0
.end method

.method public setIcon(Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .param p1, "icon"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 26
    iput-object p1, p0, Lcom/aio/downloader/unstall/Info;->icon:Landroid/graphics/drawable/Drawable;

    .line 27
    return-void
.end method

.method public setName(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 14
    iput-object p1, p0, Lcom/aio/downloader/unstall/Info;->name:Ljava/lang/String;

    .line 15
    return-void
.end method

.method public setPackagename(Ljava/lang/String;)V
    .locals 0
    .param p1, "packagename"    # Ljava/lang/String;

    .prologue
    .line 20
    iput-object p1, p0, Lcom/aio/downloader/unstall/Info;->packagename:Ljava/lang/String;

    .line 21
    return-void
.end method

.method public setVersion(Ljava/lang/String;)V
    .locals 0
    .param p1, "version"    # Ljava/lang/String;

    .prologue
    .line 32
    iput-object p1, p0, Lcom/aio/downloader/unstall/Info;->version:Ljava/lang/String;

    .line 33
    return-void
.end method

.class public Lcom/aio/downloader/model/Programe;
.super Ljava/lang/Object;
.source "Programe.java"


# instance fields
.field private icon:Landroid/graphics/drawable/Drawable;

.field private name:Ljava/lang/String;

.field private packagename:Ljava/lang/String;


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
    .line 22
    iget-object v0, p0, Lcom/aio/downloader/model/Programe;->icon:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/aio/downloader/model/Programe;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getPackagename()Ljava/lang/String;
    .locals 1

    .prologue
    .line 14
    iget-object v0, p0, Lcom/aio/downloader/model/Programe;->packagename:Ljava/lang/String;

    return-object v0
.end method

.method public setIcon(Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .param p1, "icon"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 26
    iput-object p1, p0, Lcom/aio/downloader/model/Programe;->icon:Landroid/graphics/drawable/Drawable;

    .line 27
    return-void
.end method

.method public setName(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/aio/downloader/model/Programe;->name:Ljava/lang/String;

    .line 35
    return-void
.end method

.method public setPackagename(Ljava/lang/String;)V
    .locals 0
    .param p1, "packagename"    # Ljava/lang/String;

    .prologue
    .line 18
    iput-object p1, p0, Lcom/aio/downloader/model/Programe;->packagename:Ljava/lang/String;

    .line 19
    return-void
.end method

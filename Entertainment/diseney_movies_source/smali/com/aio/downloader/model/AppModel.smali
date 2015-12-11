.class public Lcom/aio/downloader/model/AppModel;
.super Ljava/lang/Object;
.source "AppModel.java"


# instance fields
.field private author_title:Ljava/lang/String;

.field private has_apk:Ljava/lang/String;

.field private has_next_page:I

.field private icon:Ljava/lang/String;

.field private id:Ljava/lang/String;

.field private price:Ljava/lang/String;

.field private rating:Ljava/lang/Float;

.field private serial:Ljava/lang/String;

.field private size:Ljava/lang/String;

.field private title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAuthor_title()Ljava/lang/String;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/aio/downloader/model/AppModel;->author_title:Ljava/lang/String;

    return-object v0
.end method

.method public getHas_apk()Ljava/lang/String;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/aio/downloader/model/AppModel;->has_apk:Ljava/lang/String;

    return-object v0
.end method

.method public getHas_next_page()I
    .locals 1

    .prologue
    .line 15
    iget v0, p0, Lcom/aio/downloader/model/AppModel;->has_next_page:I

    return v0
.end method

.method public getIcon()Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/aio/downloader/model/AppModel;->icon:Ljava/lang/String;

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/aio/downloader/model/AppModel;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/aio/downloader/model/AppModel;->price:Ljava/lang/String;

    return-object v0
.end method

.method public getRating()Ljava/lang/Float;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/aio/downloader/model/AppModel;->rating:Ljava/lang/Float;

    return-object v0
.end method

.method public getSerial()Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/aio/downloader/model/AppModel;->serial:Ljava/lang/String;

    return-object v0
.end method

.method public getSize()Ljava/lang/String;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/aio/downloader/model/AppModel;->size:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/aio/downloader/model/AppModel;->title:Ljava/lang/String;

    return-object v0
.end method

.method public setAuthor_title(Ljava/lang/String;)V
    .locals 0
    .param p1, "author_title"    # Ljava/lang/String;

    .prologue
    .line 42
    iput-object p1, p0, Lcom/aio/downloader/model/AppModel;->author_title:Ljava/lang/String;

    .line 43
    return-void
.end method

.method public setHas_apk(Ljava/lang/String;)V
    .locals 0
    .param p1, "has_apk"    # Ljava/lang/String;

    .prologue
    .line 72
    iput-object p1, p0, Lcom/aio/downloader/model/AppModel;->has_apk:Ljava/lang/String;

    .line 73
    return-void
.end method

.method public setHas_next_page(I)V
    .locals 0
    .param p1, "has_next_page"    # I

    .prologue
    .line 18
    iput p1, p0, Lcom/aio/downloader/model/AppModel;->has_next_page:I

    .line 19
    return-void
.end method

.method public setIcon(Ljava/lang/String;)V
    .locals 0
    .param p1, "icon"    # Ljava/lang/String;

    .prologue
    .line 48
    iput-object p1, p0, Lcom/aio/downloader/model/AppModel;->icon:Ljava/lang/String;

    .line 49
    return-void
.end method

.method public setId(Ljava/lang/String;)V
    .locals 0
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 24
    iput-object p1, p0, Lcom/aio/downloader/model/AppModel;->id:Ljava/lang/String;

    .line 25
    return-void
.end method

.method public setPrice(Ljava/lang/String;)V
    .locals 0
    .param p1, "price"    # Ljava/lang/String;

    .prologue
    .line 66
    iput-object p1, p0, Lcom/aio/downloader/model/AppModel;->price:Ljava/lang/String;

    .line 67
    return-void
.end method

.method public setRating(Ljava/lang/Float;)V
    .locals 0
    .param p1, "rating"    # Ljava/lang/Float;

    .prologue
    .line 60
    iput-object p1, p0, Lcom/aio/downloader/model/AppModel;->rating:Ljava/lang/Float;

    .line 61
    return-void
.end method

.method public setSerial(Ljava/lang/String;)V
    .locals 0
    .param p1, "serial"    # Ljava/lang/String;

    .prologue
    .line 30
    iput-object p1, p0, Lcom/aio/downloader/model/AppModel;->serial:Ljava/lang/String;

    .line 31
    return-void
.end method

.method public setSize(Ljava/lang/String;)V
    .locals 0
    .param p1, "size"    # Ljava/lang/String;

    .prologue
    .line 54
    iput-object p1, p0, Lcom/aio/downloader/model/AppModel;->size:Ljava/lang/String;

    .line 55
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "title"    # Ljava/lang/String;

    .prologue
    .line 36
    iput-object p1, p0, Lcom/aio/downloader/model/AppModel;->title:Ljava/lang/String;

    .line 37
    return-void
.end method

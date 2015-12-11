.class public Lcom/poshmark/data_model/models/inner_models/Picture;
.super Ljava/lang/Object;
.source "Picture.java"


# instance fields
.field content_type:Ljava/lang/String;

.field created_at:Ljava/lang/String;

.field file:Landroid/net/Uri;

.field id:Ljava/lang/String;

.field originalFile:Landroid/net/Uri;

.field url:Ljava/lang/String;

.field url_small:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 11
    new-instance v0, Landroid/net/Uri$Builder;

    invoke-direct {v0}, Landroid/net/Uri$Builder;-><init>()V

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Picture;->file:Landroid/net/Uri;

    .line 12
    new-instance v0, Landroid/net/Uri$Builder;

    invoke-direct {v0}, Landroid/net/Uri$Builder;-><init>()V

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Picture;->originalFile:Landroid/net/Uri;

    .line 16
    return-void
.end method

.method public constructor <init>(Lcom/poshmark/data_model/models/inner_models/Picture;)V
    .locals 1
    .param p1, "p"    # Lcom/poshmark/data_model/models/inner_models/Picture;

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 11
    new-instance v0, Landroid/net/Uri$Builder;

    invoke-direct {v0}, Landroid/net/Uri$Builder;-><init>()V

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Picture;->file:Landroid/net/Uri;

    .line 12
    new-instance v0, Landroid/net/Uri$Builder;

    invoke-direct {v0}, Landroid/net/Uri$Builder;-><init>()V

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Picture;->originalFile:Landroid/net/Uri;

    .line 19
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/inner_models/Picture;->getId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Picture;->id:Ljava/lang/String;

    .line 20
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/Picture;->url:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Picture;->url:Ljava/lang/String;

    .line 21
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/Picture;->file:Landroid/net/Uri;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Picture;->file:Landroid/net/Uri;

    .line 22
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/Picture;->originalFile:Landroid/net/Uri;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Picture;->originalFile:Landroid/net/Uri;

    .line 23
    return-void
.end method


# virtual methods
.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Picture;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getOriginalPictureFileUri()Landroid/net/Uri;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Picture;->originalFile:Landroid/net/Uri;

    return-object v0
.end method

.method public getPictureFileUri()Landroid/net/Uri;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Picture;->file:Landroid/net/Uri;

    return-object v0
.end method

.method public getPictureUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Picture;->url:Ljava/lang/String;

    return-object v0
.end method

.method public isRemote()Z
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Picture;->url:Ljava/lang/String;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public setFileUri(Landroid/net/Uri;)V
    .locals 1
    .param p1, "imageFile"    # Landroid/net/Uri;

    .prologue
    .line 55
    if-eqz p1, :cond_0

    .line 56
    iput-object p1, p0, Lcom/poshmark/data_model/models/inner_models/Picture;->file:Landroid/net/Uri;

    .line 57
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Picture;->url:Ljava/lang/String;

    .line 59
    :cond_0
    return-void
.end method

.method public setId(Ljava/lang/String;)V
    .locals 0
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 39
    iput-object p1, p0, Lcom/poshmark/data_model/models/inner_models/Picture;->id:Ljava/lang/String;

    .line 40
    return-void
.end method

.method public setOriginalFileUri(Landroid/net/Uri;)V
    .locals 0
    .param p1, "originalFile"    # Landroid/net/Uri;

    .prologue
    .line 62
    iput-object p1, p0, Lcom/poshmark/data_model/models/inner_models/Picture;->originalFile:Landroid/net/Uri;

    .line 63
    return-void
.end method

.method public setPictureUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 43
    iput-object p1, p0, Lcom/poshmark/data_model/models/inner_models/Picture;->url:Ljava/lang/String;

    .line 44
    return-void
.end method

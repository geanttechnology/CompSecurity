.class public Lcom/amazon/searchapp/retailsearch/entity/ImageResourceEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "ImageResourceEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/ImageResource;


# instance fields
.field private displayHeight:I

.field private displayWidth:I

.field private height:I

.field private id:Ljava/lang/String;

.field private url:Ljava/lang/String;

.field private width:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getDisplayHeight()I
    .locals 1

    .prologue
    .line 96
    iget v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ImageResourceEntity;->displayHeight:I

    return v0
.end method

.method public getDisplayWidth()I
    .locals 1

    .prologue
    .line 56
    iget v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ImageResourceEntity;->displayWidth:I

    return v0
.end method

.method public getHeight()I
    .locals 1

    .prologue
    .line 136
    iget v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ImageResourceEntity;->height:I

    return v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 116
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ImageResourceEntity;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ImageResourceEntity;->url:Ljava/lang/String;

    return-object v0
.end method

.method public getWidth()I
    .locals 1

    .prologue
    .line 36
    iget v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ImageResourceEntity;->width:I

    return v0
.end method

.method public setDisplayHeight(I)V
    .locals 0
    .param p1, "displayHeight"    # I

    .prologue
    .line 106
    iput p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ImageResourceEntity;->displayHeight:I

    .line 107
    return-void
.end method

.method public setDisplayWidth(I)V
    .locals 0
    .param p1, "displayWidth"    # I

    .prologue
    .line 66
    iput p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ImageResourceEntity;->displayWidth:I

    .line 67
    return-void
.end method

.method public setHeight(I)V
    .locals 0
    .param p1, "height"    # I

    .prologue
    .line 146
    iput p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ImageResourceEntity;->height:I

    .line 147
    return-void
.end method

.method public setId(Ljava/lang/String;)V
    .locals 0
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 126
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ImageResourceEntity;->id:Ljava/lang/String;

    .line 127
    return-void
.end method

.method public setUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 86
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ImageResourceEntity;->url:Ljava/lang/String;

    .line 87
    return-void
.end method

.method public setWidth(I)V
    .locals 0
    .param p1, "width"    # I

    .prologue
    .line 46
    iput p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ImageResourceEntity;->width:I

    .line 47
    return-void
.end method

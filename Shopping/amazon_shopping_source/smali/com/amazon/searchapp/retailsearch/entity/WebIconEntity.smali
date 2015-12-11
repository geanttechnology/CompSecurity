.class public Lcom/amazon/searchapp/retailsearch/entity/WebIconEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "WebIconEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/WebIcon;


# instance fields
.field private altText:Ljava/lang/String;

.field private height:I

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
.method public getAltText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/WebIconEntity;->altText:Ljava/lang/String;

    return-object v0
.end method

.method public getHeight()I
    .locals 1

    .prologue
    .line 90
    iget v0, p0, Lcom/amazon/searchapp/retailsearch/entity/WebIconEntity;->height:I

    return v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/WebIconEntity;->url:Ljava/lang/String;

    return-object v0
.end method

.method public getWidth()I
    .locals 1

    .prologue
    .line 50
    iget v0, p0, Lcom/amazon/searchapp/retailsearch/entity/WebIconEntity;->width:I

    return v0
.end method

.method public setAltText(Ljava/lang/String;)V
    .locals 0
    .param p1, "altText"    # Ljava/lang/String;

    .prologue
    .line 80
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/WebIconEntity;->altText:Ljava/lang/String;

    .line 81
    return-void
.end method

.method public setHeight(I)V
    .locals 0
    .param p1, "height"    # I

    .prologue
    .line 100
    iput p1, p0, Lcom/amazon/searchapp/retailsearch/entity/WebIconEntity;->height:I

    .line 101
    return-void
.end method

.method public setUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 40
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/WebIconEntity;->url:Ljava/lang/String;

    .line 41
    return-void
.end method

.method public setWidth(I)V
    .locals 0
    .param p1, "width"    # I

    .prologue
    .line 60
    iput p1, p0, Lcom/amazon/searchapp/retailsearch/entity/WebIconEntity;->width:I

    .line 61
    return-void
.end method

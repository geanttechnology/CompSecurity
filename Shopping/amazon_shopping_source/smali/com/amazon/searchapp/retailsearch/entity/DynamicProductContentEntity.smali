.class public Lcom/amazon/searchapp/retailsearch/entity/DynamicProductContentEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "DynamicProductContentEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/DynamicProductContent;


# instance fields
.field private content:Lcom/amazon/searchapp/retailsearch/model/TypedContent;

.field private includesImage:Z

.field private message:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getContent()Lcom/amazon/searchapp/retailsearch/model/TypedContent;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/DynamicProductContentEntity;->content:Lcom/amazon/searchapp/retailsearch/model/TypedContent;

    return-object v0
.end method

.method public getIncludesImage()Z
    .locals 1

    .prologue
    .line 68
    iget-boolean v0, p0, Lcom/amazon/searchapp/retailsearch/entity/DynamicProductContentEntity;->includesImage:Z

    return v0
.end method

.method public getMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/DynamicProductContentEntity;->message:Ljava/lang/String;

    return-object v0
.end method

.method public setContent(Lcom/amazon/searchapp/retailsearch/model/TypedContent;)V
    .locals 0
    .param p1, "content"    # Lcom/amazon/searchapp/retailsearch/model/TypedContent;

    .prologue
    .line 38
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/DynamicProductContentEntity;->content:Lcom/amazon/searchapp/retailsearch/model/TypedContent;

    .line 39
    return-void
.end method

.method public setIncludesImage(Z)V
    .locals 0
    .param p1, "includesImage"    # Z

    .prologue
    .line 78
    iput-boolean p1, p0, Lcom/amazon/searchapp/retailsearch/entity/DynamicProductContentEntity;->includesImage:Z

    .line 79
    return-void
.end method

.method public setMessage(Ljava/lang/String;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 58
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/DynamicProductContentEntity;->message:Ljava/lang/String;

    .line 59
    return-void
.end method

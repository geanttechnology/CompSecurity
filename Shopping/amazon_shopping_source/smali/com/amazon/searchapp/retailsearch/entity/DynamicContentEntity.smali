.class public Lcom/amazon/searchapp/retailsearch/entity/DynamicContentEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "DynamicContentEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/DynamicContent;


# instance fields
.field private content:Lcom/amazon/searchapp/retailsearch/model/TypedContent;

.field private position:I

.field private priority:I


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
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/DynamicContentEntity;->content:Lcom/amazon/searchapp/retailsearch/model/TypedContent;

    return-object v0
.end method

.method public getPosition()I
    .locals 1

    .prologue
    .line 48
    iget v0, p0, Lcom/amazon/searchapp/retailsearch/entity/DynamicContentEntity;->position:I

    return v0
.end method

.method public getPriority()I
    .locals 1

    .prologue
    .line 68
    iget v0, p0, Lcom/amazon/searchapp/retailsearch/entity/DynamicContentEntity;->priority:I

    return v0
.end method

.method public setContent(Lcom/amazon/searchapp/retailsearch/model/TypedContent;)V
    .locals 0
    .param p1, "content"    # Lcom/amazon/searchapp/retailsearch/model/TypedContent;

    .prologue
    .line 38
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/DynamicContentEntity;->content:Lcom/amazon/searchapp/retailsearch/model/TypedContent;

    .line 39
    return-void
.end method

.method public setPosition(I)V
    .locals 0
    .param p1, "position"    # I

    .prologue
    .line 58
    iput p1, p0, Lcom/amazon/searchapp/retailsearch/entity/DynamicContentEntity;->position:I

    .line 59
    return-void
.end method

.method public setPriority(I)V
    .locals 0
    .param p1, "priority"    # I

    .prologue
    .line 78
    iput p1, p0, Lcom/amazon/searchapp/retailsearch/entity/DynamicContentEntity;->priority:I

    .line 79
    return-void
.end method

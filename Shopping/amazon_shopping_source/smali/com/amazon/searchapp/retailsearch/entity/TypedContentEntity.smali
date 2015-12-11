.class public Lcom/amazon/searchapp/retailsearch/entity/TypedContentEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "TypedContentEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/TypedContent;


# instance fields
.field private content:Ljava/lang/String;

.field private type:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getContent()Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/TypedContentEntity;->content:Ljava/lang/String;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/TypedContentEntity;->type:Ljava/lang/String;

    return-object v0
.end method

.method public setContent(Ljava/lang/String;)V
    .locals 0
    .param p1, "content"    # Ljava/lang/String;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/TypedContentEntity;->content:Ljava/lang/String;

    .line 35
    return-void
.end method

.method public setType(Ljava/lang/String;)V
    .locals 0
    .param p1, "type"    # Ljava/lang/String;

    .prologue
    .line 54
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/TypedContentEntity;->type:Ljava/lang/String;

    .line 55
    return-void
.end method

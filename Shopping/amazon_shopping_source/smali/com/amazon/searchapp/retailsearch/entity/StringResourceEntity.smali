.class public Lcom/amazon/searchapp/retailsearch/entity/StringResourceEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "StringResourceEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/StringResource;


# instance fields
.field private id:Ljava/lang/String;

.field private text:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/StringResourceEntity;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/StringResourceEntity;->text:Ljava/lang/String;

    return-object v0
.end method

.method public setId(Ljava/lang/String;)V
    .locals 0
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 54
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/StringResourceEntity;->id:Ljava/lang/String;

    .line 55
    return-void
.end method

.method public setText(Ljava/lang/String;)V
    .locals 0
    .param p1, "text"    # Ljava/lang/String;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/StringResourceEntity;->text:Ljava/lang/String;

    .line 35
    return-void
.end method

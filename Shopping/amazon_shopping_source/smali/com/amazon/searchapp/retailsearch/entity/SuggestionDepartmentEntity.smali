.class public Lcom/amazon/searchapp/retailsearch/entity/SuggestionDepartmentEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "SuggestionDepartmentEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/SuggestionDepartment;


# instance fields
.field private alias:Ljava/lang/String;

.field private name:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getAlias()Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SuggestionDepartmentEntity;->alias:Ljava/lang/String;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SuggestionDepartmentEntity;->name:Ljava/lang/String;

    return-object v0
.end method

.method public setAlias(Ljava/lang/String;)V
    .locals 0
    .param p1, "alias"    # Ljava/lang/String;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SuggestionDepartmentEntity;->alias:Ljava/lang/String;

    .line 35
    return-void
.end method

.method public setName(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 54
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SuggestionDepartmentEntity;->name:Ljava/lang/String;

    .line 55
    return-void
.end method

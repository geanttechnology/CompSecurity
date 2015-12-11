.class public Lcom/amazon/searchapp/retailsearch/entity/SuggestionEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "SuggestionEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/Suggestion;


# instance fields
.field private confidence:I

.field private departments:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/SuggestionDepartment;",
            ">;"
        }
    .end annotation
.end field

.field private source:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private spellCorrected:I

.field private suggestion:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getConfidence()I
    .locals 1

    .prologue
    .line 75
    iget v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SuggestionEntity;->confidence:I

    return v0
.end method

.method public getDepartments()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/SuggestionDepartment;",
            ">;"
        }
    .end annotation

    .prologue
    .line 115
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SuggestionEntity;->departments:Ljava/util/List;

    return-object v0
.end method

.method public getSource()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 55
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SuggestionEntity;->source:Ljava/util/List;

    return-object v0
.end method

.method public getSpellCorrected()I
    .locals 1

    .prologue
    .line 95
    iget v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SuggestionEntity;->spellCorrected:I

    return v0
.end method

.method public getSuggestion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SuggestionEntity;->suggestion:Ljava/lang/String;

    return-object v0
.end method

.method public setConfidence(I)V
    .locals 0
    .param p1, "confidence"    # I

    .prologue
    .line 85
    iput p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SuggestionEntity;->confidence:I

    .line 86
    return-void
.end method

.method public setDepartments(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/SuggestionDepartment;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 125
    .local p1, "departments":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/SuggestionDepartment;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SuggestionEntity;->departments:Ljava/util/List;

    .line 126
    return-void
.end method

.method public setSource(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 65
    .local p1, "source":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SuggestionEntity;->source:Ljava/util/List;

    .line 66
    return-void
.end method

.method public setSpellCorrected(I)V
    .locals 0
    .param p1, "spellCorrected"    # I

    .prologue
    .line 105
    iput p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SuggestionEntity;->spellCorrected:I

    .line 106
    return-void
.end method

.method public setSuggestion(Ljava/lang/String;)V
    .locals 0
    .param p1, "suggestion"    # Ljava/lang/String;

    .prologue
    .line 45
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SuggestionEntity;->suggestion:Ljava/lang/String;

    .line 46
    return-void
.end method

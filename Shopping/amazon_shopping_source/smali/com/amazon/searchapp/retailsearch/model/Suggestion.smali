.class public interface abstract Lcom/amazon/searchapp/retailsearch/model/Suggestion;
.super Ljava/lang/Object;
.source "Suggestion.java"


# virtual methods
.method public abstract getConfidence()I
.end method

.method public abstract getDepartments()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/SuggestionDepartment;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getSource()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getSpellCorrected()I
.end method

.method public abstract getSuggestion()Ljava/lang/String;
.end method

.method public abstract setConfidence(I)V
.end method

.method public abstract setDepartments(Ljava/util/List;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/SuggestionDepartment;",
            ">;)V"
        }
    .end annotation
.end method

.method public abstract setSource(Ljava/util/List;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation
.end method

.method public abstract setSpellCorrected(I)V
.end method

.method public abstract setSuggestion(Ljava/lang/String;)V
.end method

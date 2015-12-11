.class public Lcom/amazon/searchapp/retailsearch/entity/DidYouMeanEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "DidYouMeanEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/DidYouMean;


# instance fields
.field private correctedQuery:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Link;",
            ">;"
        }
    .end annotation
.end field

.field private detailLabel:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;"
        }
    .end annotation
.end field

.field private formattedLabel:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;"
        }
    .end annotation
.end field

.field private formattedOriginalQueryLabel:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;"
        }
    .end annotation
.end field

.field private label:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getCorrectedQuery()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Link;",
            ">;"
        }
    .end annotation

    .prologue
    .line 56
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/DidYouMeanEntity;->correctedQuery:Ljava/util/List;

    return-object v0
.end method

.method public getDetailLabel()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;"
        }
    .end annotation

    .prologue
    .line 76
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/DidYouMeanEntity;->detailLabel:Ljava/util/List;

    return-object v0
.end method

.method public getFormattedLabel()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;"
        }
    .end annotation

    .prologue
    .line 36
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/DidYouMeanEntity;->formattedLabel:Ljava/util/List;

    return-object v0
.end method

.method public getFormattedOriginalQueryLabel()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;"
        }
    .end annotation

    .prologue
    .line 96
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/DidYouMeanEntity;->formattedOriginalQueryLabel:Ljava/util/List;

    return-object v0
.end method

.method public getLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 116
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/DidYouMeanEntity;->label:Ljava/lang/String;

    return-object v0
.end method

.method public setCorrectedQuery(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Link;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 66
    .local p1, "correctedQuery":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/Link;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/DidYouMeanEntity;->correctedQuery:Ljava/util/List;

    .line 67
    return-void
.end method

.method public setDetailLabel(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 86
    .local p1, "detailLabel":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/StyledText;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/DidYouMeanEntity;->detailLabel:Ljava/util/List;

    .line 87
    return-void
.end method

.method public setFormattedLabel(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 46
    .local p1, "formattedLabel":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/StyledText;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/DidYouMeanEntity;->formattedLabel:Ljava/util/List;

    .line 47
    return-void
.end method

.method public setFormattedOriginalQueryLabel(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 106
    .local p1, "formattedOriginalQueryLabel":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/StyledText;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/DidYouMeanEntity;->formattedOriginalQueryLabel:Ljava/util/List;

    .line 107
    return-void
.end method

.method public setLabel(Ljava/lang/String;)V
    .locals 0
    .param p1, "label"    # Ljava/lang/String;

    .prologue
    .line 126
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/DidYouMeanEntity;->label:Ljava/lang/String;

    .line 127
    return-void
.end method

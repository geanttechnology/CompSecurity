.class public Lcom/amazon/searchapp/retailsearch/entity/RefinementFilterEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "RefinementFilterEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;


# instance fields
.field private ancestry:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/RefinementLink;",
            ">;"
        }
    .end annotation
.end field

.field private clearLink:Lcom/amazon/searchapp/retailsearch/model/RefinementLink;

.field private detail:Ljava/lang/String;

.field private group:Ljava/lang/String;

.field private id:Ljava/lang/String;

.field private label:Ljava/lang/String;

.field private removesSiblings:Z

.field private type:Ljava/lang/String;

.field private values:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/RefinementLink;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getAncestry()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/RefinementLink;",
            ">;"
        }
    .end annotation

    .prologue
    .line 147
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementFilterEntity;->ancestry:Ljava/util/List;

    return-object v0
.end method

.method public getClearLink()Lcom/amazon/searchapp/retailsearch/model/RefinementLink;
    .locals 1

    .prologue
    .line 127
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementFilterEntity;->clearLink:Lcom/amazon/searchapp/retailsearch/model/RefinementLink;

    return-object v0
.end method

.method public getDetail()Ljava/lang/String;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementFilterEntity;->detail:Ljava/lang/String;

    return-object v0
.end method

.method public getGroup()Ljava/lang/String;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementFilterEntity;->group:Ljava/lang/String;

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 207
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementFilterEntity;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 107
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementFilterEntity;->label:Ljava/lang/String;

    return-object v0
.end method

.method public getRemovesSiblings()Z
    .locals 1

    .prologue
    .line 67
    iget-boolean v0, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementFilterEntity;->removesSiblings:Z

    return v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 187
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementFilterEntity;->type:Ljava/lang/String;

    return-object v0
.end method

.method public getValues()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/RefinementLink;",
            ">;"
        }
    .end annotation

    .prologue
    .line 167
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementFilterEntity;->values:Ljava/util/List;

    return-object v0
.end method

.method public setAncestry(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/RefinementLink;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 157
    .local p1, "ancestry":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/RefinementLink;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementFilterEntity;->ancestry:Ljava/util/List;

    .line 158
    return-void
.end method

.method public setClearLink(Lcom/amazon/searchapp/retailsearch/model/RefinementLink;)V
    .locals 0
    .param p1, "clearLink"    # Lcom/amazon/searchapp/retailsearch/model/RefinementLink;

    .prologue
    .line 137
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementFilterEntity;->clearLink:Lcom/amazon/searchapp/retailsearch/model/RefinementLink;

    .line 138
    return-void
.end method

.method public setDetail(Ljava/lang/String;)V
    .locals 0
    .param p1, "detail"    # Ljava/lang/String;

    .prologue
    .line 97
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementFilterEntity;->detail:Ljava/lang/String;

    .line 98
    return-void
.end method

.method public setGroup(Ljava/lang/String;)V
    .locals 0
    .param p1, "group"    # Ljava/lang/String;

    .prologue
    .line 57
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementFilterEntity;->group:Ljava/lang/String;

    .line 58
    return-void
.end method

.method public setId(Ljava/lang/String;)V
    .locals 0
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 217
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementFilterEntity;->id:Ljava/lang/String;

    .line 218
    return-void
.end method

.method public setLabel(Ljava/lang/String;)V
    .locals 0
    .param p1, "label"    # Ljava/lang/String;

    .prologue
    .line 117
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementFilterEntity;->label:Ljava/lang/String;

    .line 118
    return-void
.end method

.method public setRemovesSiblings(Z)V
    .locals 0
    .param p1, "removesSiblings"    # Z

    .prologue
    .line 77
    iput-boolean p1, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementFilterEntity;->removesSiblings:Z

    .line 78
    return-void
.end method

.method public setType(Ljava/lang/String;)V
    .locals 0
    .param p1, "type"    # Ljava/lang/String;

    .prologue
    .line 197
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementFilterEntity;->type:Ljava/lang/String;

    .line 198
    return-void
.end method

.method public setValues(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/RefinementLink;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 177
    .local p1, "values":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/RefinementLink;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementFilterEntity;->values:Ljava/util/List;

    .line 178
    return-void
.end method

.class public Lcom/amazon/searchapp/retailsearch/entity/RefinementLinkEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "RefinementLinkEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/RefinementLink;


# instance fields
.field private availability:Z

.field private browseUrl:Ljava/lang/String;

.field private categories:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/RefinementLink;",
            ">;"
        }
    .end annotation
.end field

.field private count:J

.field private id:Ljava/lang/String;

.field private selected:Z

.field private styleText:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;"
        }
    .end annotation
.end field

.field private text:Ljava/lang/String;

.field private url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getAvailability()Z
    .locals 1

    .prologue
    .line 187
    iget-boolean v0, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementLinkEntity;->availability:Z

    return v0
.end method

.method public getBrowseUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 167
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementLinkEntity;->browseUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getCategories()Ljava/util/List;
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
    .line 207
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementLinkEntity;->categories:Ljava/util/List;

    return-object v0
.end method

.method public getCount()J
    .locals 2

    .prologue
    .line 47
    iget-wide v0, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementLinkEntity;->count:J

    return-wide v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 147
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementLinkEntity;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getSelected()Z
    .locals 1

    .prologue
    .line 127
    iget-boolean v0, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementLinkEntity;->selected:Z

    return v0
.end method

.method public getStyleText()Ljava/util/List;
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
    .line 67
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementLinkEntity;->styleText:Ljava/util/List;

    return-object v0
.end method

.method public getText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 107
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementLinkEntity;->text:Ljava/lang/String;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementLinkEntity;->url:Ljava/lang/String;

    return-object v0
.end method

.method public setAvailability(Z)V
    .locals 0
    .param p1, "availability"    # Z

    .prologue
    .line 197
    iput-boolean p1, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementLinkEntity;->availability:Z

    .line 198
    return-void
.end method

.method public setBrowseUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "browseUrl"    # Ljava/lang/String;

    .prologue
    .line 177
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementLinkEntity;->browseUrl:Ljava/lang/String;

    .line 178
    return-void
.end method

.method public setCategories(Ljava/util/List;)V
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
    .line 217
    .local p1, "categories":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/RefinementLink;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementLinkEntity;->categories:Ljava/util/List;

    .line 218
    return-void
.end method

.method public setCount(J)V
    .locals 0
    .param p1, "count"    # J

    .prologue
    .line 57
    iput-wide p1, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementLinkEntity;->count:J

    .line 58
    return-void
.end method

.method public setId(Ljava/lang/String;)V
    .locals 0
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 157
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementLinkEntity;->id:Ljava/lang/String;

    .line 158
    return-void
.end method

.method public setSelected(Z)V
    .locals 0
    .param p1, "selected"    # Z

    .prologue
    .line 137
    iput-boolean p1, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementLinkEntity;->selected:Z

    .line 138
    return-void
.end method

.method public setStyleText(Ljava/util/List;)V
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
    .line 77
    .local p1, "styleText":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/StyledText;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementLinkEntity;->styleText:Ljava/util/List;

    .line 78
    return-void
.end method

.method public setText(Ljava/lang/String;)V
    .locals 0
    .param p1, "text"    # Ljava/lang/String;

    .prologue
    .line 117
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementLinkEntity;->text:Ljava/lang/String;

    .line 118
    return-void
.end method

.method public setUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 97
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/RefinementLinkEntity;->url:Ljava/lang/String;

    .line 98
    return-void
.end method

.class public Lcom/amazon/searchapp/retailsearch/entity/FeaturedContentEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "FeaturedContentEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/FeaturedContent;


# instance fields
.field private content:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/FeaturedContentItem;",
            ">;"
        }
    .end annotation
.end field

.field private description:Ljava/lang/String;

.field private position:I

.field private priority:I

.field private style:Ljava/lang/String;

.field private title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getContent()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/FeaturedContentItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 38
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/FeaturedContentEntity;->content:Ljava/util/List;

    return-object v0
.end method

.method public getDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 98
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/FeaturedContentEntity;->description:Ljava/lang/String;

    return-object v0
.end method

.method public getPosition()I
    .locals 1

    .prologue
    .line 138
    iget v0, p0, Lcom/amazon/searchapp/retailsearch/entity/FeaturedContentEntity;->position:I

    return v0
.end method

.method public getPriority()I
    .locals 1

    .prologue
    .line 58
    iget v0, p0, Lcom/amazon/searchapp/retailsearch/entity/FeaturedContentEntity;->priority:I

    return v0
.end method

.method public getStyle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/FeaturedContentEntity;->style:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 118
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/FeaturedContentEntity;->title:Ljava/lang/String;

    return-object v0
.end method

.method public setContent(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/FeaturedContentItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 48
    .local p1, "content":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/FeaturedContentItem;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/FeaturedContentEntity;->content:Ljava/util/List;

    .line 49
    return-void
.end method

.method public setDescription(Ljava/lang/String;)V
    .locals 0
    .param p1, "description"    # Ljava/lang/String;

    .prologue
    .line 108
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/FeaturedContentEntity;->description:Ljava/lang/String;

    .line 109
    return-void
.end method

.method public setPosition(I)V
    .locals 0
    .param p1, "position"    # I

    .prologue
    .line 148
    iput p1, p0, Lcom/amazon/searchapp/retailsearch/entity/FeaturedContentEntity;->position:I

    .line 149
    return-void
.end method

.method public setPriority(I)V
    .locals 0
    .param p1, "priority"    # I

    .prologue
    .line 68
    iput p1, p0, Lcom/amazon/searchapp/retailsearch/entity/FeaturedContentEntity;->priority:I

    .line 69
    return-void
.end method

.method public setStyle(Ljava/lang/String;)V
    .locals 0
    .param p1, "style"    # Ljava/lang/String;

    .prologue
    .line 88
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/FeaturedContentEntity;->style:Ljava/lang/String;

    .line 89
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "title"    # Ljava/lang/String;

    .prologue
    .line 128
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/FeaturedContentEntity;->title:Ljava/lang/String;

    .line 129
    return-void
.end method

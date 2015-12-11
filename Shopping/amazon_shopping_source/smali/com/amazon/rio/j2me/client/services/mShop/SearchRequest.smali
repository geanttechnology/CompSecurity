.class public Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;
.super Ljava/lang/Object;
.source "SearchRequest.java"


# instance fields
.field private categoryRefinements:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private clickStreamOrigin:Ljava/lang/String;

.field private includeAddOnItems:Ljava/lang/Boolean;

.field private maxImageDimension:I

.field private page:I

.field private query:Ljava/lang/String;

.field private queryDescriptor:Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;

.field private returnRefinements:Ljava/lang/Boolean;

.field private size:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCategoryRefinements()Ljava/util/List;
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
    .line 41
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->categoryRefinements:Ljava/util/List;

    return-object v0
.end method

.method public getClickStreamOrigin()Ljava/lang/String;
    .locals 1

    .prologue
    .line 110
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->clickStreamOrigin:Ljava/lang/String;

    return-object v0
.end method

.method public getIncludeAddOnItems()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 123
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->includeAddOnItems:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getMaxImageDimension()I
    .locals 1

    .prologue
    .line 71
    iget v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->maxImageDimension:I

    return v0
.end method

.method public getPage()I
    .locals 1

    .prologue
    .line 51
    iget v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->page:I

    return v0
.end method

.method public getQuery()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->query:Ljava/lang/String;

    return-object v0
.end method

.method public getQueryDescriptor()Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;
    .locals 1

    .prologue
    .line 97
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->queryDescriptor:Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;

    return-object v0
.end method

.method public getReturnRefinements()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->returnRefinements:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getSize()I
    .locals 1

    .prologue
    .line 61
    iget v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->size:I

    return v0
.end method

.method public setCategoryRefinements(Ljava/util/List;)V
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
    .line 46
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->categoryRefinements:Ljava/util/List;

    .line 47
    return-void
.end method

.method public setClickStreamOrigin(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 115
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->clickStreamOrigin:Ljava/lang/String;

    .line 116
    return-void
.end method

.method public setIncludeAddOnItems(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 128
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->includeAddOnItems:Ljava/lang/Boolean;

    .line 129
    return-void
.end method

.method public setMaxImageDimension(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 76
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->maxImageDimension:I

    .line 77
    return-void
.end method

.method public setPage(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 56
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->page:I

    .line 57
    return-void
.end method

.method public setQuery(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 33
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->query:Ljava/lang/String;

    .line 34
    return-void
.end method

.method public setQueryDescriptor(Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;

    .prologue
    .line 102
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->queryDescriptor:Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;

    .line 103
    return-void
.end method

.method public setReturnRefinements(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 89
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->returnRefinements:Ljava/lang/Boolean;

    .line 90
    return-void
.end method

.method public setSize(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 66
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->size:I

    .line 67
    return-void
.end method

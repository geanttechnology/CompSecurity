.class public Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;
.super Ljava/lang/Object;
.source "AdvSearchRequest.java"


# instance fields
.field private clickStreamOrigin:Ljava/lang/String;

.field private count:Ljava/lang/Integer;

.field private filters:Ljava/lang/String;

.field private includeAddOnItems:Ljava/lang/Boolean;

.field private isPrefetch:Ljava/lang/Boolean;

.field private offset:Ljava/lang/Integer;

.field private query:Ljava/lang/String;

.field private returnCorrections:Ljava/lang/Boolean;

.field private returnProducts:Ljava/lang/Boolean;

.field private returnRefinements:Ljava/lang/Boolean;

.field private returnStubs:Ljava/lang/Boolean;

.field private sortId:Ljava/lang/String;

.field private toggleRefinements:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getClickStreamOrigin()Ljava/lang/String;
    .locals 1

    .prologue
    .line 175
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->clickStreamOrigin:Ljava/lang/String;

    return-object v0
.end method

.method public getCount()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->count:Ljava/lang/Integer;

    return-object v0
.end method

.method public getFilters()Ljava/lang/String;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->filters:Ljava/lang/String;

    return-object v0
.end method

.method public getIncludeAddOnItems()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 188
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->includeAddOnItems:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getIsPrefetch()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 162
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->isPrefetch:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getOffset()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->offset:Ljava/lang/Integer;

    return-object v0
.end method

.method public getQuery()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->query:Ljava/lang/String;

    return-object v0
.end method

.method public getReturnCorrections()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 149
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->returnCorrections:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getReturnProducts()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 110
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->returnProducts:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getReturnRefinements()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 136
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->returnRefinements:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getReturnStubs()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 123
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->returnStubs:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getSortId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 97
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->sortId:Ljava/lang/String;

    return-object v0
.end method

.method public getToggleRefinements()Ljava/util/List;
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
    .line 84
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->toggleRefinements:Ljava/util/List;

    return-object v0
.end method

.method public setClickStreamOrigin(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 180
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->clickStreamOrigin:Ljava/lang/String;

    .line 181
    return-void
.end method

.method public setCount(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 63
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->count:Ljava/lang/Integer;

    .line 64
    return-void
.end method

.method public setFilters(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 76
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->filters:Ljava/lang/String;

    .line 77
    return-void
.end method

.method public setIncludeAddOnItems(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 193
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->includeAddOnItems:Ljava/lang/Boolean;

    .line 194
    return-void
.end method

.method public setIsPrefetch(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 167
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->isPrefetch:Ljava/lang/Boolean;

    .line 168
    return-void
.end method

.method public setOffset(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 50
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->offset:Ljava/lang/Integer;

    .line 51
    return-void
.end method

.method public setQuery(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 37
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->query:Ljava/lang/String;

    .line 38
    return-void
.end method

.method public setReturnCorrections(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 154
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->returnCorrections:Ljava/lang/Boolean;

    .line 155
    return-void
.end method

.method public setReturnProducts(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 115
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->returnProducts:Ljava/lang/Boolean;

    .line 116
    return-void
.end method

.method public setReturnRefinements(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 141
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->returnRefinements:Ljava/lang/Boolean;

    .line 142
    return-void
.end method

.method public setReturnStubs(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 128
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->returnStubs:Ljava/lang/Boolean;

    .line 129
    return-void
.end method

.method public setSortId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 102
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->sortId:Ljava/lang/String;

    .line 103
    return-void
.end method

.method public setToggleRefinements(Ljava/util/List;)V
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
    .line 89
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->toggleRefinements:Ljava/util/List;

    .line 90
    return-void
.end method

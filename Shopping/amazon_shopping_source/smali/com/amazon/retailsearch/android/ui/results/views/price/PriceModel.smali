.class public Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;
.super Ljava/lang/Object;
.source "PriceModel.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$Builder;,
        Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$UIPriceInfo;
    }
.end annotation


# instance fields
.field private badgeId:Ljava/lang/String;

.field private editions:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$UIPriceInfo;",
            ">;"
        }
    .end annotation
.end field

.field private listPrice:Ljava/lang/String;

.field private mapTextId:Ljava/lang/Integer;

.field private price:Ljava/lang/String;

.field private somePrimeMsg:Ljava/lang/String;

.field private sponsoredPriceMsg:Ljava/lang/String;

.field private unitOrIssuePrice:Ljava/lang/String;

.field private useEditions:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 251
    return-void
.end method


# virtual methods
.method public getBadgeId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 168
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->badgeId:Ljava/lang/String;

    return-object v0
.end method

.method public getEditions()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$UIPriceInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 200
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->editions:Ljava/util/List;

    return-object v0
.end method

.method public getListPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->listPrice:Ljava/lang/String;

    return-object v0
.end method

.method public getMapTextId()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 136
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->mapTextId:Ljava/lang/Integer;

    return-object v0
.end method

.method public getPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 120
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->price:Ljava/lang/String;

    return-object v0
.end method

.method public getSomePrimeMsg()Ljava/lang/String;
    .locals 1

    .prologue
    .line 216
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->somePrimeMsg:Ljava/lang/String;

    return-object v0
.end method

.method public getSponsoredPriceMsg()Ljava/lang/String;
    .locals 1

    .prologue
    .line 233
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->sponsoredPriceMsg:Ljava/lang/String;

    return-object v0
.end method

.method public getUnitOrIssuePrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 152
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->unitOrIssuePrice:Ljava/lang/String;

    return-object v0
.end method

.method public getUseEditions()Z
    .locals 1

    .prologue
    .line 184
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->useEditions:Z

    return v0
.end method

.method protected setBadgeId(Ljava/lang/String;)V
    .locals 0
    .param p1, "badgeId"    # Ljava/lang/String;

    .prologue
    .line 176
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->badgeId:Ljava/lang/String;

    .line 177
    return-void
.end method

.method protected setEditions(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$UIPriceInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 208
    .local p1, "editions":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$UIPriceInfo;>;"
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->editions:Ljava/util/List;

    .line 209
    return-void
.end method

.method protected setListPrice(Ljava/lang/String;)V
    .locals 0
    .param p1, "listPrice"    # Ljava/lang/String;

    .prologue
    .line 112
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->listPrice:Ljava/lang/String;

    .line 113
    return-void
.end method

.method protected setMapTextId(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "mapTextId"    # Ljava/lang/Integer;

    .prologue
    .line 144
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->mapTextId:Ljava/lang/Integer;

    .line 145
    return-void
.end method

.method protected setPrice(Ljava/lang/String;)V
    .locals 0
    .param p1, "price"    # Ljava/lang/String;

    .prologue
    .line 128
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->price:Ljava/lang/String;

    .line 129
    return-void
.end method

.method protected setSomePrimeMsg(Ljava/lang/String;)V
    .locals 0
    .param p1, "somePrimeMsg"    # Ljava/lang/String;

    .prologue
    .line 225
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->somePrimeMsg:Ljava/lang/String;

    .line 226
    return-void
.end method

.method protected setSponsoredPriceMsg(Ljava/lang/String;)V
    .locals 0
    .param p1, "sponsoredPriceMsg"    # Ljava/lang/String;

    .prologue
    .line 242
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->sponsoredPriceMsg:Ljava/lang/String;

    .line 243
    return-void
.end method

.method protected setUnitOrIssuePrice(Ljava/lang/String;)V
    .locals 0
    .param p1, "unitOrIssuePrice"    # Ljava/lang/String;

    .prologue
    .line 160
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->unitOrIssuePrice:Ljava/lang/String;

    .line 161
    return-void
.end method

.method protected setUseEditions(Z)V
    .locals 0
    .param p1, "useEditions"    # Z

    .prologue
    .line 192
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->useEditions:Z

    .line 193
    return-void
.end method

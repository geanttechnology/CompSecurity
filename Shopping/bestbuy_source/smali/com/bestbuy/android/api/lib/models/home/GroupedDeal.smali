.class public Lcom/bestbuy/android/api/lib/models/home/GroupedDeal;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x7cf94052b17acd2eL


# instance fields
.field private offers:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;",
            ">;"
        }
    .end annotation
.end field

.field private offersWide:Ljava/lang/String;

.field private widgetType:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getOffers()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;",
            ">;"
        }
    .end annotation

    .prologue
    .line 24
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/GroupedDeal;->offers:Ljava/util/List;

    return-object v0
.end method

.method public getOffersWide()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/GroupedDeal;->offersWide:Ljava/lang/String;

    return-object v0
.end method

.method public getWidgetType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/GroupedDeal;->widgetType:Ljava/lang/String;

    return-object v0
.end method

.method public setOffers(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 42
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/GroupedDeal;->offers:Ljava/util/List;

    .line 43
    return-void
.end method

.method public setOffersWide(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 54
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/GroupedDeal;->offersWide:Ljava/lang/String;

    .line 55
    return-void
.end method

.method public setWidgetType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 48
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/GroupedDeal;->widgetType:Ljava/lang/String;

    .line 49
    return-void
.end method

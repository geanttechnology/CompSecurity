.class public Lcom/bestbuy/android/api/lib/models/home/Recommendation;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x6578cae1d418716aL


# instance fields
.field private recommendationsCount:Ljava/lang/String;

.field private recommendationsId:Ljava/lang/String;

.field private recommendationsType:Ljava/lang/String;

.field private size:Ljava/lang/String;

.field private url:Ljava/lang/String;

.field private widgetType:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getRecommendationsCount()Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/Recommendation;->recommendationsCount:Ljava/lang/String;

    return-object v0
.end method

.method public getRecommendationsId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/Recommendation;->recommendationsId:Ljava/lang/String;

    return-object v0
.end method

.method public getRecommendationsType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/Recommendation;->recommendationsType:Ljava/lang/String;

    return-object v0
.end method

.method public getSize()Ljava/lang/String;
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/Recommendation;->size:Ljava/lang/String;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/Recommendation;->url:Ljava/lang/String;

    return-object v0
.end method

.method public getWidgetType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/Recommendation;->widgetType:Ljava/lang/String;

    return-object v0
.end method

.method public setRecommendationsCount(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 33
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/Recommendation;->recommendationsCount:Ljava/lang/String;

    .line 34
    return-void
.end method

.method public setRecommendationsId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 93
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/Recommendation;->recommendationsId:Ljava/lang/String;

    .line 94
    return-void
.end method

.method public setRecommendationsType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 45
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/Recommendation;->recommendationsType:Ljava/lang/String;

    .line 46
    return-void
.end method

.method public setSize(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 81
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/Recommendation;->size:Ljava/lang/String;

    .line 82
    return-void
.end method

.method public setUrl(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 57
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/Recommendation;->url:Ljava/lang/String;

    .line 58
    return-void
.end method

.method public setWidgetType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 69
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/Recommendation;->widgetType:Ljava/lang/String;

    .line 70
    return-void
.end method

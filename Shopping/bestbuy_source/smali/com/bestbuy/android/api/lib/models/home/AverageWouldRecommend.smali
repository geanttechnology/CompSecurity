.class public Lcom/bestbuy/android/api/lib/models/home/AverageWouldRecommend;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x4630bddf21509f02L


# instance fields
.field private percent0To1:Ljava/lang/String;

.field private percent0To100:Ljava/lang/String;

.field private totalCount:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getPercent0To1()Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/AverageWouldRecommend;->percent0To1:Ljava/lang/String;

    return-object v0
.end method

.method public getPercent0To100()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/AverageWouldRecommend;->percent0To100:Ljava/lang/String;

    return-object v0
.end method

.method public getTotalCount()Ljava/lang/String;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/AverageWouldRecommend;->totalCount:Ljava/lang/String;

    return-object v0
.end method

.method public setPercent0To1(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 30
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/AverageWouldRecommend;->percent0To1:Ljava/lang/String;

    .line 31
    return-void
.end method

.method public setPercent0To100(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 42
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/AverageWouldRecommend;->percent0To100:Ljava/lang/String;

    .line 43
    return-void
.end method

.method public setTotalCount(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 54
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/AverageWouldRecommend;->totalCount:Ljava/lang/String;

    .line 55
    return-void
.end method

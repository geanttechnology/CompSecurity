.class public Lcom/amazon/searchapp/retailsearch/entity/PointsEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "PointsEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/Points;


# instance fields
.field private percentage:I

.field private points:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getPercentage()I
    .locals 1

    .prologue
    .line 24
    iget v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PointsEntity;->percentage:I

    return v0
.end method

.method public getPoints()J
    .locals 2

    .prologue
    .line 44
    iget-wide v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PointsEntity;->points:J

    return-wide v0
.end method

.method public setPercentage(I)V
    .locals 0
    .param p1, "percentage"    # I

    .prologue
    .line 34
    iput p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PointsEntity;->percentage:I

    .line 35
    return-void
.end method

.method public setPoints(J)V
    .locals 0
    .param p1, "points"    # J

    .prologue
    .line 54
    iput-wide p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PointsEntity;->points:J

    .line 55
    return-void
.end method

.class public Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x258866ef9d27ad3bL


# instance fields
.field private si:Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getSi()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;->si:Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;

    return-object v0
.end method

.method public setSi(Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;)V
    .locals 0

    .prologue
    .line 29
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;->si:Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;

    .line 30
    return-void
.end method

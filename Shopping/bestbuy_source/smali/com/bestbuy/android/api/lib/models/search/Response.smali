.class public Lcom/bestbuy/android/api/lib/models/search/Response;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private searchApi:Lcom/bestbuy/android/api/lib/models/search/SearchApi;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getSearchApi()Lcom/bestbuy/android/api/lib/models/search/SearchApi;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/Response;->searchApi:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    return-object v0
.end method

.method public setSearchApi(Lcom/bestbuy/android/api/lib/models/search/SearchApi;)V
    .locals 0

    .prologue
    .line 31
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/Response;->searchApi:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    .line 32
    return-void
.end method

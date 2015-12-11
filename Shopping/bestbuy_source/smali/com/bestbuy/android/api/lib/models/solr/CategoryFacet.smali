.class public Lcom/bestbuy/android/api/lib/models/solr/CategoryFacet;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private categoryName:Ljava/lang/String;

.field private categoryPath:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCategoryName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/solr/CategoryFacet;->categoryName:Ljava/lang/String;

    return-object v0
.end method

.method public getCategoryPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/solr/CategoryFacet;->categoryPath:Ljava/lang/String;

    return-object v0
.end method

.method public setCategoryName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 24
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/solr/CategoryFacet;->categoryName:Ljava/lang/String;

    .line 25
    return-void
.end method

.method public setCategoryPath(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 32
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/solr/CategoryFacet;->categoryPath:Ljava/lang/String;

    .line 33
    return-void
.end method

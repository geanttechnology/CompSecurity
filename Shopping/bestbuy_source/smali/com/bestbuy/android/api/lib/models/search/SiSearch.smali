.class public Lcom/bestbuy/android/api/lib/models/search/SiSearch;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private si:Lcom/bestbuy/android/api/lib/models/search/Si;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getSi()Lcom/bestbuy/android/api/lib/models/search/Si;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/SiSearch;->si:Lcom/bestbuy/android/api/lib/models/search/Si;

    return-object v0
.end method

.method public setSi(Lcom/bestbuy/android/api/lib/models/search/Si;)V
    .locals 0

    .prologue
    .line 33
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/SiSearch;->si:Lcom/bestbuy/android/api/lib/models/search/Si;

    .line 34
    return-void
.end method

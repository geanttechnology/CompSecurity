.class public Lcom/bestbuy/android/api/lib/models/pdpreviews/RepresentativeQuotes;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private highlightedQuote:Ljava/lang/String;

.field private id:Ljava/lang/String;

.field private quote:Ljava/lang/String;

.field private reviewId:Ljava/lang/String;

.field private userNickname:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getHighlightedQuote()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/RepresentativeQuotes;->highlightedQuote:Ljava/lang/String;

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/RepresentativeQuotes;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getQuote()Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/RepresentativeQuotes;->quote:Ljava/lang/String;

    return-object v0
.end method

.method public getReviewId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/RepresentativeQuotes;->reviewId:Ljava/lang/String;

    return-object v0
.end method

.method public getUserNickname()Ljava/lang/String;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/RepresentativeQuotes;->userNickname:Ljava/lang/String;

    return-object v0
.end method

.method public setHighlightedQuote(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 33
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/RepresentativeQuotes;->highlightedQuote:Ljava/lang/String;

    .line 34
    return-void
.end method

.method public setId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 57
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/RepresentativeQuotes;->id:Ljava/lang/String;

    .line 58
    return-void
.end method

.method public setQuote(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 25
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/RepresentativeQuotes;->quote:Ljava/lang/String;

    .line 26
    return-void
.end method

.method public setReviewId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 49
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/RepresentativeQuotes;->reviewId:Ljava/lang/String;

    .line 50
    return-void
.end method

.method public setUserNickname(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 41
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/RepresentativeQuotes;->userNickname:Ljava/lang/String;

    .line 42
    return-void
.end method

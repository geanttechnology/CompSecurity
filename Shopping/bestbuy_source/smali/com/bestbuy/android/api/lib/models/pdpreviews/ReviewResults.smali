.class public Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private rating:I

.field private reviewId:Ljava/lang/String;

.field private reviewText:Ljava/lang/String;

.field private sentiment:I

.field private submissionTime:Ljava/lang/String;

.field private title:Ljava/lang/String;

.field private userLocation:Ljava/lang/String;

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
.method public getRating()I
    .locals 1

    .prologue
    .line 72
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;->rating:I

    return v0
.end method

.method public getReviewId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;->reviewId:Ljava/lang/String;

    return-object v0
.end method

.method public getReviewText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;->reviewText:Ljava/lang/String;

    return-object v0
.end method

.method public getSentiment()I
    .locals 1

    .prologue
    .line 32
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;->sentiment:I

    return v0
.end method

.method public getSubmissionTime()Ljava/lang/String;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;->submissionTime:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;->title:Ljava/lang/String;

    return-object v0
.end method

.method public getUserLocation()Ljava/lang/String;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;->userLocation:Ljava/lang/String;

    return-object v0
.end method

.method public getUserNickname()Ljava/lang/String;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;->userNickname:Ljava/lang/String;

    return-object v0
.end method

.method public setRating(I)V
    .locals 0

    .prologue
    .line 76
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;->rating:I

    .line 77
    return-void
.end method

.method public setReviewId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 28
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;->reviewId:Ljava/lang/String;

    .line 29
    return-void
.end method

.method public setReviewText(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 84
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;->reviewText:Ljava/lang/String;

    .line 85
    return-void
.end method

.method public setSentiment(I)V
    .locals 0

    .prologue
    .line 36
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;->sentiment:I

    .line 37
    return-void
.end method

.method public setSubmissionTime(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 68
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;->submissionTime:Ljava/lang/String;

    .line 69
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 52
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;->title:Ljava/lang/String;

    .line 53
    return-void
.end method

.method public setUserLocation(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 44
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;->userLocation:Ljava/lang/String;

    .line 45
    return-void
.end method

.method public setUserNickname(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 60
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;->userNickname:Ljava/lang/String;

    .line 61
    return-void
.end method

.class public Lcom/amazon/rio/j2me/client/services/mShop/CustomerReview;
.super Ljava/lang/Object;
.source "CustomerReview.java"


# instance fields
.field private authorName:Ljava/lang/String;

.field private isVine:Ljava/lang/Boolean;

.field private overallRating:I

.field private submissionDate:Lcom/amazon/rio/j2me/client/services/mShop/Date;

.field private text:Ljava/lang/String;

.field private title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public setAuthorName(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 47
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CustomerReview;->authorName:Ljava/lang/String;

    .line 48
    return-void
.end method

.method public setIsVine(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 80
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CustomerReview;->isVine:Ljava/lang/Boolean;

    .line 81
    return-void
.end method

.method public setOverallRating(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 27
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CustomerReview;->overallRating:I

    .line 28
    return-void
.end method

.method public setSubmissionDate(Lcom/amazon/rio/j2me/client/services/mShop/Date;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/Date;

    .prologue
    .line 57
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CustomerReview;->submissionDate:Lcom/amazon/rio/j2me/client/services/mShop/Date;

    .line 58
    return-void
.end method

.method public setText(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 67
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CustomerReview;->text:Ljava/lang/String;

    .line 68
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 37
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CustomerReview;->title:Ljava/lang/String;

    .line 38
    return-void
.end method

.class public Lcom/xfinity/playerlib/view/videoplay/RatingsBug;
.super Ljava/lang/Object;
.source "RatingsBug.java"


# instance fields
.field private fadeRatingsBugIn:Landroid/view/animation/Animation;

.field private isMovie:Z

.field private ratingsBugView:Landroid/view/View;


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lcom/xfinity/playerlib/model/consumable/VideoFacade;)V
    .locals 9
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .prologue
    const/4 v8, 0x0

    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    iput-boolean v8, p0, Lcom/xfinity/playerlib/view/videoplay/RatingsBug;->isMovie:Z

    .line 32
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->isMovie()Z

    move-result v4

    iput-boolean v4, p0, Lcom/xfinity/playerlib/view/videoplay/RatingsBug;->isMovie:Z

    .line 34
    sget v4, Lcom/xfinity/playerlib/R$id;->ratings_bug:I

    invoke-virtual {p1, v4}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v4

    iput-object v4, p0, Lcom/xfinity/playerlib/view/videoplay/RatingsBug;->ratingsBugView:Landroid/view/View;

    .line 36
    iget-object v4, p0, Lcom/xfinity/playerlib/view/videoplay/RatingsBug;->ratingsBugView:Landroid/view/View;

    sget v5, Lcom/xfinity/playerlib/R$id;->rating_bug_program:I

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 37
    .local v1, "ratingsBugProgram":Landroid/widget/TextView;
    iget-object v4, p0, Lcom/xfinity/playerlib/view/videoplay/RatingsBug;->ratingsBugView:Landroid/view/View;

    sget v5, Lcom/xfinity/playerlib/R$id;->rating_bug_rating:I

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 38
    .local v0, "ratingBugRatingField":Landroid/widget/TextView;
    iget-object v4, p0, Lcom/xfinity/playerlib/view/videoplay/RatingsBug;->ratingsBugView:Landroid/view/View;

    sget v5, Lcom/xfinity/playerlib/R$id;->rating_bug_sub_rating:I

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 40
    .local v2, "txtSubRating":Landroid/widget/TextView;
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoRating()Lcom/comcast/cim/model/Rating;

    move-result-object v3

    .line 42
    .local v3, "videoRating":Lcom/comcast/cim/model/Rating;
    sget v4, Lcom/xfinity/playerlib/R$string;->TV:I

    invoke-virtual {p1, v4}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 44
    if-eqz v3, :cond_1

    .line 45
    invoke-virtual {v3}, Lcom/comcast/cim/model/Rating;->getRating()Ljava/lang/String;

    move-result-object v4

    sget-object v5, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v4, v5}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 50
    :goto_0
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoSubRating()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_0

    .line 52
    invoke-virtual {v2, v8}, Landroid/widget/TextView;->setVisibility(I)V

    .line 53
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoSubRating()Ljava/lang/String;

    move-result-object v4

    invoke-direct {p0, v4}, Lcom/xfinity/playerlib/view/videoplay/RatingsBug;->convertSubRatingsDelimitedString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 56
    :cond_0
    sget v4, Lcom/xfinity/playerlib/R$anim;->ratings_bug_fade:I

    invoke-static {p1, v4}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v4

    iput-object v4, p0, Lcom/xfinity/playerlib/view/videoplay/RatingsBug;->fadeRatingsBugIn:Landroid/view/animation/Animation;

    .line 58
    iget-object v4, p0, Lcom/xfinity/playerlib/view/videoplay/RatingsBug;->ratingsBugView:Landroid/view/View;

    sget v5, Lcom/xfinity/playerlib/R$string;->content_description_ratings_bug_info:I

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    invoke-virtual {v0}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v7

    aput-object v7, v6, v8

    const/4 v7, 0x1

    invoke-virtual {v2}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-virtual {p1, v5, v6}, Landroid/app/Activity;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/view/View;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 60
    return-void

    .line 47
    :cond_1
    const-string v4, ""

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method

.method private convertSubRatingsDelimitedString(Ljava/lang/String;)Ljava/lang/String;
    .locals 5
    .param p1, "delimitedString"    # Ljava/lang/String;

    .prologue
    .line 86
    const-string v3, ","

    invoke-virtual {p1, v3}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    .line 87
    .local v2, "split":[Ljava/lang/String;
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    .line 89
    .local v1, "sb":Ljava/lang/StringBuffer;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v3, v2

    if-ge v0, v3, :cond_1

    .line 90
    if-lez v0, :cond_0

    const-string v3, " "

    :goto_1
    invoke-virtual {v1, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v3

    aget-object v4, v2, v0

    invoke-virtual {v3, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 89
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 90
    :cond_0
    const-string v3, ""

    goto :goto_1

    .line 93
    :cond_1
    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3
.end method


# virtual methods
.method public start()V
    .locals 2

    .prologue
    .line 67
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/videoplay/RatingsBug;->isMovie:Z

    if-nez v0, :cond_0

    .line 68
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/RatingsBug;->ratingsBugView:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 69
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/RatingsBug;->ratingsBugView:Landroid/view/View;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/RatingsBug;->fadeRatingsBugIn:Landroid/view/animation/Animation;

    invoke-virtual {v0, v1}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    .line 71
    :cond_0
    return-void
.end method

.method public stop()V
    .locals 2

    .prologue
    .line 78
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/videoplay/RatingsBug;->isMovie:Z

    if-nez v0, :cond_0

    .line 79
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/RatingsBug;->ratingsBugView:Landroid/view/View;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 80
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/RatingsBug;->ratingsBugView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->clearAnimation()V

    .line 82
    :cond_0
    return-void
.end method

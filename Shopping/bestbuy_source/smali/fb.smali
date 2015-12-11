.class public Lfb;
.super Landroid/widget/ArrayAdapter;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/ArrayAdapter",
        "<",
        "Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;",
        ">;"
    }
.end annotation


# instance fields
.field private a:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;",
            ">;"
        }
    .end annotation
.end field

.field private b:Landroid/view/LayoutInflater;

.field private c:I

.field private d:Landroid/app/Activity;


# direct methods
.method public constructor <init>(Landroid/app/Activity;ILjava/util/ArrayList;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "I",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 27
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 28
    iput-object p1, p0, Lfb;->d:Landroid/app/Activity;

    .line 29
    iput-object p3, p0, Lfb;->a:Ljava/util/ArrayList;

    .line 30
    invoke-virtual {p1}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Lfb;->b:Landroid/view/LayoutInflater;

    .line 31
    return-void
.end method

.method static synthetic a(Lfb;)I
    .locals 1

    .prologue
    .line 19
    iget v0, p0, Lfb;->c:I

    return v0
.end method

.method static synthetic a(Lfb;I)I
    .locals 0

    .prologue
    .line 19
    iput p1, p0, Lfb;->c:I

    return p1
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;)I
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lfb;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lfb;->a:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public synthetic getPosition(Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 19
    check-cast p1, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;

    invoke-virtual {p0, p1}, Lfb;->a(Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;)I

    move-result v0

    return v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 8

    .prologue
    const v4, 0x7f080068

    const/16 v7, 0x8

    const/4 v6, 0x0

    .line 46
    if-nez p2, :cond_0

    .line 47
    new-instance v1, Lfc;

    invoke-direct {v1}, Lfc;-><init>()V

    .line 48
    iget-object v0, p0, Lfb;->b:Landroid/view/LayoutInflater;

    const v2, 0x7f0300d8

    invoke-virtual {v0, v2, p3, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p2

    .line 49
    const v0, 0x7f0c0354

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Lfc;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 50
    const v0, 0x7f0c0359

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Lfc;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 51
    const v0, 0x7f0c0355

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Lfc;->e:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 52
    const v0, 0x7f0c0356

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Lfc;->f:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 53
    const v0, 0x7f0c0357

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Lfc;->g:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 54
    const v0, 0x7f0c0358

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RatingBar;

    iput-object v0, v1, Lfc;->c:Landroid/widget/RatingBar;

    .line 55
    const v0, 0x7f0c02b8

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Lfc;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 56
    const v0, 0x7f0c035a

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Lfc;->h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 57
    const v0, 0x7f0c035b

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Lfc;->i:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 58
    invoke-virtual {p2, v1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 62
    :goto_0
    iget-object v2, v1, Lfc;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v0, p0, Lfb;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;->getTitle()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/CharSequence;)V

    .line 63
    iget-object v0, p0, Lfb;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;->getUserNickname()Ljava/lang/String;

    move-result-object v0

    .line 64
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_1

    iget-object v2, p0, Lfb;->d:Landroid/app/Activity;

    invoke-virtual {v2, v4}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 65
    iget-object v0, v1, Lfc;->e:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 66
    iget-object v2, v1, Lfc;->e:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "by "

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v0, p0, Lfb;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;->getUserNickname()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 70
    :goto_1
    iget-object v0, p0, Lfb;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;->getUserLocation()Ljava/lang/String;

    move-result-object v0

    .line 71
    if-eqz v0, :cond_2

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_2

    iget-object v2, p0, Lfb;->d:Landroid/app/Activity;

    invoke-virtual {v2, v4}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 72
    iget-object v2, v1, Lfc;->f:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "from "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 73
    iget-object v0, v1, Lfc;->f:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 77
    :goto_2
    iget-object v0, p0, Lfb;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;->getSubmissionTime()Ljava/lang/String;

    move-result-object v0

    .line 79
    iget-object v2, v1, Lfc;->g:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "on "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/4 v4, 0x5

    const/4 v5, 0x7

    invoke-virtual {v0, v4, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "/"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v4, 0xa

    invoke-virtual {v0, v7, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "/"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/4 v4, 0x4

    invoke-virtual {v0, v6, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 80
    iget-object v2, v1, Lfc;->c:Landroid/widget/RatingBar;

    iget-object v0, p0, Lfb;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;->getRating()I

    move-result v0

    int-to-float v0, v0

    invoke-virtual {v2, v0}, Landroid/widget/RatingBar;->setRating(F)V

    .line 81
    iget-object v2, v1, Lfc;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, ""

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v0, p0, Lfb;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;->getRating()I

    move-result v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 82
    iget-object v2, v1, Lfc;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v0, p0, Lfb;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;->getReviewText()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/CharSequence;)V

    .line 83
    iget-object v0, v1, Lfc;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v2, Lfb$1;

    invoke-direct {v2, p0, v1}, Lfb$1;-><init>(Lfb;Lfc;)V

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->post(Ljava/lang/Runnable;)Z

    .line 99
    iget-object v0, v1, Lfc;->h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v2, Lfb$2;

    invoke-direct {v2, p0, v1}, Lfb$2;-><init>(Lfb;Lfc;)V

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 115
    return-object p2

    .line 60
    :cond_0
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lfc;

    move-object v1, v0

    goto/16 :goto_0

    .line 68
    :cond_1
    iget-object v0, v1, Lfc;->e:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v7}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto/16 :goto_1

    .line 75
    :cond_2
    iget-object v0, v1, Lfc;->f:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v7}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto/16 :goto_2
.end method

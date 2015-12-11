.class public Lcom/bestbuy/android/activities/home/DealsHomeCard;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"


# static fields
.field private static final a:Ljava/lang/String;


# instance fields
.field private b:Landroid/support/v4/app/Fragment;

.field private c:Z

.field private g:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 45
    const-class v0, Lcom/bestbuy/android/activities/home/DealsHomeCard;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/activities/home/DealsHomeCard;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 51
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 47
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard;->c:Z

    .line 52
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/home/DealsHomeCard;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard;->g:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/home/DealsHomeCard;)Landroid/support/v4/app/Fragment;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard;->b:Landroid/support/v4/app/Fragment;

    return-object v0
.end method


# virtual methods
.method public onAttach(Landroid/app/Activity;)V
    .locals 1

    .prologue
    .line 66
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 67
    iput-object p1, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard;->d:Landroid/app/Activity;

    .line 68
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/DealsHomeCard;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard;->b:Landroid/support/v4/app/Fragment;

    .line 69
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 12

    .prologue
    const/4 v1, 0x0

    .line 73
    const v0, 0x7f03004e

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v5

    .line 74
    const v0, 0x7f0c011d

    invoke-virtual {v5, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 79
    new-instance v2, Lnc;

    invoke-direct {v2}, Lnc;-><init>()V

    .line 82
    :try_start_0
    iget-object v3, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard;->d:Landroid/app/Activity;

    sget-object v4, Lnb;->e:Ljava/lang/String;

    sget-object v6, Lnb;->d:[Ljava/lang/String;

    const/4 v7, 0x2

    aget-object v6, v6, v7

    invoke-virtual {v2, v3, v4, v6}, Lnc;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 83
    new-instance v6, Lmy;

    const-string v3, "Dealcards"

    invoke-direct {v6, v2, v3}, Lmy;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 86
    if-eqz v6, :cond_3

    .line 87
    new-instance v2, Landroid/view/View;

    invoke-virtual {v5}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-direct {v2, v3}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 88
    new-instance v3, Landroid/widget/RelativeLayout$LayoutParams;

    const/16 v4, 0xa

    const/4 v7, 0x1

    invoke-direct {v3, v4, v7}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v2, v3}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 89
    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    move v4, v1

    .line 90
    :goto_0
    invoke-virtual {v6}, Lmy;->a()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-ge v4, v1, :cond_3

    .line 91
    invoke-virtual {v6}, Lmy;->a()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lmx;

    .line 92
    invoke-virtual {v1}, Lmx;->b()Ljava/util/ArrayList;

    move-result-object v1

    .line 93
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :cond_0
    :goto_1
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_6

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lmw;

    .line 94
    iget-boolean v2, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard;->c:Z

    if-eqz v2, :cond_1

    invoke-virtual {v1}, Lmw;->i()Ljava/lang/String;

    move-result-object v2

    const v3, 0x7f080077

    invoke-virtual {p0, v3}, Lcom/bestbuy/android/activities/home/DealsHomeCard;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    invoke-virtual {v1}, Lmw;->i()Ljava/lang/String;

    move-result-object v2

    const v3, 0x7f080075

    invoke-virtual {p0, v3}, Lcom/bestbuy/android/activities/home/DealsHomeCard;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 97
    :cond_1
    iget-boolean v2, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard;->c:Z

    if-nez v2, :cond_2

    invoke-virtual {v1}, Lmw;->i()Ljava/lang/String;

    move-result-object v2

    const v3, 0x7f08008e

    invoke-virtual {p0, v3}, Lcom/bestbuy/android/activities/home/DealsHomeCard;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 100
    :cond_2
    const v2, 0x7f03004f

    const/4 v3, 0x0

    invoke-virtual {p1, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    .line 101
    const v3, 0x7f0c011f

    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    .line 102
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/DealsHomeCard;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    invoke-virtual {v1}, Lmw;->c()Ljava/lang/String;

    move-result-object v9

    const-string v10, "drawable"

    invoke-virtual {v5}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v11

    invoke-virtual {v11}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v8, v9, v10, v11}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v8

    .line 103
    if-nez v8, :cond_4

    .line 104
    sget-object v2, Lcom/bestbuy/android/activities/home/DealsHomeCard;->a:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Attempting to add image that does not exist: "

    invoke-virtual {v3, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v1}, Lmw;->c()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v2, v1}, Lkf;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_1

    .line 211
    :catch_0
    move-exception v0

    .line 212
    sget-object v1, Lcom/bestbuy/android/activities/home/DealsHomeCard;->a:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Error attempting to load & display deals cards: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lkf;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 214
    :cond_3
    return-object v5

    .line 106
    :cond_4
    :try_start_1
    invoke-virtual {v3, v8}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 107
    const/4 v8, 0x0

    invoke-virtual {v3, v8}, Landroid/widget/ImageView;->setFocusable(Z)V

    .line 108
    invoke-virtual {v1}, Lmw;->a()Ljava/lang/String;

    move-result-object v3

    .line 109
    if-eqz v3, :cond_5

    invoke-virtual {v3}, Ljava/lang/String;->isEmpty()Z

    move-result v8

    if-nez v8, :cond_5

    .line 110
    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 112
    :cond_5
    new-instance v3, Lcom/bestbuy/android/activities/home/DealsHomeCard$1;

    invoke-direct {v3, p0, v1}, Lcom/bestbuy/android/activities/home/DealsHomeCard$1;-><init>(Lcom/bestbuy/android/activities/home/DealsHomeCard;Lmw;)V

    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 201
    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 202
    new-instance v1, Landroid/view/View;

    invoke-virtual {v5}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 203
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/DealsHomeCard;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f090001

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v2

    float-to-int v2, v2

    .line 204
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/DealsHomeCard;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v8, 0x7f090002

    invoke-virtual {v3, v8}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v3

    float-to-int v3, v3

    .line 205
    new-instance v8, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v8, v2, v3}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v1, v8}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 206
    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_1

    .line 90
    :cond_6
    add-int/lit8 v1, v4, 0x1

    move v4, v1

    goto/16 :goto_0
.end method

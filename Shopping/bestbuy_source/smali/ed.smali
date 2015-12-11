.class public Led;
.super Landroid/widget/ArrayAdapter;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/ArrayAdapter",
        "<",
        "Lcom/bestbuy/android/api/lib/models/browse/Category;",
        ">;"
    }
.end annotation


# instance fields
.field private a:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/browse/Category;",
            ">;"
        }
    .end annotation
.end field

.field private b:Landroid/view/LayoutInflater;

.field private c:Landroid/content/Context;

.field private d:I


# direct methods
.method public constructor <init>(Landroid/content/Context;ILjava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "I",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/browse/Category;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 28
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 29
    iput-object p3, p0, Led;->a:Ljava/util/List;

    .line 30
    iput-object p1, p0, Led;->c:Landroid/content/Context;

    .line 31
    invoke-static {p1}, Lnf;->a(Landroid/content/Context;)I

    move-result v0

    iput v0, p0, Led;->d:I

    .line 32
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Led;->b:Landroid/view/LayoutInflater;

    .line 33
    return-void
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/browse/Category;)I
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Led;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public a(I)Lcom/bestbuy/android/api/lib/models/browse/Category;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Led;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/browse/Category;

    return-object v0
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Led;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public synthetic getItem(I)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 20
    invoke-virtual {p0, p1}, Led;->a(I)Lcom/bestbuy/android/api/lib/models/browse/Category;

    move-result-object v0

    return-object v0
.end method

.method public synthetic getPosition(Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 20
    check-cast p1, Lcom/bestbuy/android/api/lib/models/browse/Category;

    invoke-virtual {p0, p1}, Led;->a(Lcom/bestbuy/android/api/lib/models/browse/Category;)I

    move-result v0

    return v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 12

    .prologue
    const/16 v11, 0x258

    const/4 v10, 0x2

    const/high16 v9, 0x40400000    # 3.0f

    const/high16 v8, 0x41200000    # 10.0f

    .line 52
    invoke-virtual {p0, p1}, Led;->a(I)Lcom/bestbuy/android/api/lib/models/browse/Category;

    move-result-object v2

    .line 53
    if-nez p2, :cond_2

    .line 54
    iget-object v0, p0, Led;->b:Landroid/view/LayoutInflater;

    const v1, 0x7f030018

    const/4 v3, 0x0

    invoke-virtual {v0, v1, p3, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p2

    .line 55
    new-instance v1, Lee;

    invoke-direct {v1}, Lee;-><init>()V

    .line 56
    const v0, 0x7f0c0070

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Lee;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 57
    invoke-virtual {p2, v1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    move-object v0, v1

    .line 61
    :goto_0
    iget v1, p0, Led;->d:I

    if-le v1, v11, :cond_3

    const/16 v1, 0x1a

    .line 62
    :goto_1
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/browse/Category;->getWidgetType()Ljava/lang/String;

    move-result-object v3

    const-string v4, "group"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 63
    iget-object v3, v0, Lee;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {p0}, Led;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const/high16 v5, 0x7f0b0000

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v4

    invoke-virtual {v3, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextColor(I)V

    .line 64
    iget-object v3, v0, Lee;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v4, p0, Led;->c:Landroid/content/Context;

    const v5, 0x7f0e0037

    invoke-virtual {v3, v4, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextAppearance(Landroid/content/Context;I)V

    .line 65
    iget-object v3, v0, Lee;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {p0}, Led;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f0b0036

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v4

    invoke-virtual {v3, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setBackgroundColor(I)V

    .line 66
    iget-object v3, v0, Lee;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v4, p0, Led;->c:Landroid/content/Context;

    invoke-static {v8, v4}, Lnf;->b(FLandroid/content/Context;)I

    move-result v4

    int-to-float v5, v1

    iget-object v6, p0, Led;->c:Landroid/content/Context;

    invoke-static {v5, v6}, Lnf;->b(FLandroid/content/Context;)I

    move-result v5

    iget-object v6, p0, Led;->c:Landroid/content/Context;

    invoke-static {v8, v6}, Lnf;->b(FLandroid/content/Context;)I

    move-result v6

    int-to-float v1, v1

    iget-object v7, p0, Led;->c:Landroid/content/Context;

    invoke-static {v1, v7}, Lnf;->b(FLandroid/content/Context;)I

    move-result v1

    invoke-virtual {v3, v4, v5, v6, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setPadding(IIII)V

    .line 68
    iget v1, p0, Led;->d:I

    if-le v1, v11, :cond_4

    .line 69
    iget-object v1, v0, Lee;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/high16 v3, 0x41980000    # 19.0f

    invoke-virtual {v1, v10, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextSize(IF)V

    .line 74
    :cond_0
    :goto_2
    iget-object v1, v0, Lee;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/browse/Category;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 75
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/browse/Category;->getWidgetType()Ljava/lang/String;

    move-result-object v1

    const-string v3, "group"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 76
    iget-object v1, v0, Lee;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/browse/Category;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 77
    iget-object v1, v0, Lee;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {p0}, Led;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0b0006

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextColor(I)V

    .line 78
    iget-object v1, v0, Lee;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v2, p0, Led;->c:Landroid/content/Context;

    const v3, 0x7f0e003f

    invoke-virtual {v1, v2, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextAppearance(Landroid/content/Context;I)V

    .line 79
    iget-object v1, v0, Lee;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {p0}, Led;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0b0009

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setBackgroundColor(I)V

    .line 80
    iget-object v0, v0, Lee;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v1, p0, Led;->c:Landroid/content/Context;

    invoke-static {v8, v1}, Lnf;->b(FLandroid/content/Context;)I

    move-result v1

    iget-object v2, p0, Led;->c:Landroid/content/Context;

    invoke-static {v9, v2}, Lnf;->b(FLandroid/content/Context;)I

    move-result v2

    iget-object v3, p0, Led;->c:Landroid/content/Context;

    invoke-static {v8, v3}, Lnf;->b(FLandroid/content/Context;)I

    move-result v3

    iget-object v4, p0, Led;->c:Landroid/content/Context;

    invoke-static {v9, v4}, Lnf;->b(FLandroid/content/Context;)I

    move-result v4

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setPadding(IIII)V

    .line 84
    :cond_1
    return-object p2

    .line 59
    :cond_2
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lee;

    goto/16 :goto_0

    .line 61
    :cond_3
    const/16 v1, 0x11

    goto/16 :goto_1

    .line 71
    :cond_4
    iget-object v1, v0, Lee;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/high16 v3, 0x41800000    # 16.0f

    invoke-virtual {v1, v10, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextSize(IF)V

    goto/16 :goto_2
.end method

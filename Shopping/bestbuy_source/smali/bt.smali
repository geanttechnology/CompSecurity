.class public Lbt;
.super Landroid/widget/BaseAdapter;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;

.field private b:Landroid/content/Context;

.field private c:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;Landroid/content/Context;Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 277
    iput-object p1, p0, Lbt;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;

    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 278
    iput-object p2, p0, Lbt;->b:Landroid/content/Context;

    .line 279
    iput-object p3, p0, Lbt;->c:Ljava/util/List;

    .line 280
    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 284
    iget-object v0, p0, Lbt;->c:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 289
    const/4 v0, 0x0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2

    .prologue
    .line 294
    const-wide/16 v0, 0x0

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 299
    iget-object v0, p0, Lbt;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f03002b

    invoke-virtual {v0, v1, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 300
    const v0, 0x7f0c00b6

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 301
    iget-object v1, p0, Lbt;->c:Ljava/util/List;

    invoke-interface {v1, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/CharSequence;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 302
    iget-object v1, p0, Lbt;->c:Ljava/util/List;

    iget-object v3, p0, Lbt;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;

    invoke-static {v3}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->d(Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lbt;->c:Ljava/util/List;

    iget-object v3, p0, Lbt;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;

    invoke-static {v3}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->d(Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v1

    if-ne v1, p1, :cond_0

    .line 303
    const/4 v1, 0x1

    invoke-virtual {v0, v4, v1}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 304
    const/high16 v1, 0x41900000    # 18.0f

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextSize(F)V

    .line 309
    :goto_0
    return-object v2

    .line 306
    :cond_0
    const/4 v1, 0x0

    invoke-virtual {v0, v4, v1}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 307
    const/high16 v1, 0x41880000    # 17.0f

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextSize(F)V

    goto :goto_0
.end method

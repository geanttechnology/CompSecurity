.class public Lef;
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

.field private d:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


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
    .line 29
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 25
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lef;->d:Ljava/util/ArrayList;

    .line 30
    iput-object p3, p0, Lef;->a:Ljava/util/List;

    .line 31
    iput-object p1, p0, Lef;->c:Landroid/content/Context;

    .line 32
    invoke-static {p1}, Llq;->a(Landroid/content/Context;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lef;->d:Ljava/util/ArrayList;

    .line 33
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Lef;->b:Landroid/view/LayoutInflater;

    .line 34
    return-void
.end method

.method static synthetic a(Lef;)Ljava/util/List;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lef;->a:Ljava/util/List;

    return-object v0
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/browse/Category;)I
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lef;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public a(I)Lcom/bestbuy/android/api/lib/models/browse/Category;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lef;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/browse/Category;

    return-object v0
.end method

.method public a(Landroid/widget/ImageView;Lcom/bestbuy/android/api/lib/models/browse/Category;)V
    .locals 2

    .prologue
    const/16 v1, 0x8

    .line 75
    invoke-virtual {p1}, Landroid/widget/ImageView;->getVisibility()I

    move-result v0

    if-nez v0, :cond_1

    .line 76
    invoke-virtual {p1, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 77
    invoke-virtual {p2}, Lcom/bestbuy/android/api/lib/models/browse/Category;->getCategoryId()Ljava/lang/String;

    move-result-object v0

    .line 78
    iget-object v1, p0, Lef;->d:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 80
    :try_start_0
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->pushManager()Lcom/exacttarget/etpushsdk/ETPush;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/exacttarget/etpushsdk/ETPush;->removeTag(Ljava/lang/String;)V

    .line 81
    iget-object v1, p0, Lef;->c:Landroid/content/Context;

    invoke-static {v1, v0}, Llq;->b(Landroid/content/Context;Ljava/lang/String;)V
    :try_end_0
    .catch Lcom/exacttarget/etpushsdk/ETException; {:try_start_0 .. :try_end_0} :catch_0

    .line 97
    :cond_0
    :goto_0
    return-void

    .line 82
    :catch_0
    move-exception v0

    .line 83
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETException;->printStackTrace()V

    goto :goto_0

    .line 85
    :cond_1
    invoke-virtual {p1}, Landroid/widget/ImageView;->getVisibility()I

    move-result v0

    if-ne v0, v1, :cond_0

    .line 86
    invoke-virtual {p2}, Lcom/bestbuy/android/api/lib/models/browse/Category;->getCategoryId()Ljava/lang/String;

    move-result-object v0

    .line 87
    iget-object v1, p0, Lef;->d:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 89
    :try_start_1
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->pushManager()Lcom/exacttarget/etpushsdk/ETPush;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/exacttarget/etpushsdk/ETPush;->addTag(Ljava/lang/String;)V

    .line 90
    iget-object v1, p0, Lef;->c:Landroid/content/Context;

    invoke-static {v1, v0}, Llq;->a(Landroid/content/Context;Ljava/lang/String;)V
    :try_end_1
    .catch Lcom/exacttarget/etpushsdk/ETException; {:try_start_1 .. :try_end_1} :catch_1

    .line 94
    :goto_1
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 95
    const v0, 0x7f020076

    invoke-virtual {p1, v0}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_0

    .line 91
    :catch_1
    move-exception v0

    .line 92
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETException;->printStackTrace()V

    goto :goto_1
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lef;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public synthetic getItem(I)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 20
    invoke-virtual {p0, p1}, Lef;->a(I)Lcom/bestbuy/android/api/lib/models/browse/Category;

    move-result-object v0

    return-object v0
.end method

.method public synthetic getPosition(Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 20
    check-cast p1, Lcom/bestbuy/android/api/lib/models/browse/Category;

    invoke-virtual {p0, p1}, Lef;->a(Lcom/bestbuy/android/api/lib/models/browse/Category;)I

    move-result v0

    return v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5

    .prologue
    .line 52
    iget-object v0, p0, Lef;->b:Landroid/view/LayoutInflater;

    const v1, 0x7f030086

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 53
    const v0, 0x7f0c0070

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 54
    const v1, 0x7f0c01f1

    invoke-virtual {v2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 56
    invoke-virtual {p0, p1}, Lef;->a(I)Lcom/bestbuy/android/api/lib/models/browse/Category;

    move-result-object v3

    .line 57
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/browse/Category;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 58
    new-instance v0, Lef$1;

    invoke-direct {v0, p0, p1, v1}, Lef$1;-><init>(Lef;ILandroid/widget/ImageView;)V

    invoke-virtual {v2, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 65
    iget-object v0, p0, Lef;->d:Ljava/util/ArrayList;

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/browse/Category;->getCategoryId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 66
    const/4 v0, 0x0

    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 67
    const v0, 0x7f020076

    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 71
    :goto_0
    return-object v2

    .line 69
    :cond_0
    const/16 v0, 0x8

    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0
.end method

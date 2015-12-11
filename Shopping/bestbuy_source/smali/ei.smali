.class public Lei;
.super Landroid/widget/ArrayAdapter;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/ArrayAdapter",
        "<",
        "Lcom/bestbuy/android/api/lib/models/pdp/ContractOption;",
        ">;"
    }
.end annotation


# instance fields
.field private a:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/ContractOption;",
            ">;"
        }
    .end annotation
.end field

.field private b:Landroid/view/LayoutInflater;

.field private c:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;ILjava/util/ArrayList;Z)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "I",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/ContractOption;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 23
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 24
    iput-object p3, p0, Lei;->a:Ljava/util/ArrayList;

    .line 25
    iput-boolean p4, p0, Lei;->c:Z

    .line 26
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Lei;->b:Landroid/view/LayoutInflater;

    .line 27
    return-void
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/pdp/ContractOption;)I
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lei;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public a(I)Lcom/bestbuy/android/api/lib/models/pdp/ContractOption;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lei;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/ContractOption;

    return-object v0
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lei;->a:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public synthetic getItem(I)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 17
    invoke-virtual {p0, p1}, Lei;->a(I)Lcom/bestbuy/android/api/lib/models/pdp/ContractOption;

    move-result-object v0

    return-object v0
.end method

.method public synthetic getPosition(Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 17
    check-cast p1, Lcom/bestbuy/android/api/lib/models/pdp/ContractOption;

    invoke-virtual {p0, p1}, Lei;->a(Lcom/bestbuy/android/api/lib/models/pdp/ContractOption;)I

    move-result v0

    return v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 6

    .prologue
    const/16 v5, 0x8

    const/4 v4, 0x0

    .line 46
    if-nez p2, :cond_0

    .line 47
    iget-object v0, p0, Lei;->b:Landroid/view/LayoutInflater;

    const v1, 0x7f030093

    invoke-virtual {v0, v1, p3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p2

    .line 48
    new-instance v1, Lej;

    invoke-direct {v1}, Lej;-><init>()V

    .line 49
    const v0, 0x7f0c0070

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Lej;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 50
    const v0, 0x7f0c0243

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Lej;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 51
    const v0, 0x7f0c004c

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, v1, Lej;->c:Landroid/widget/ImageView;

    .line 52
    invoke-virtual {p2, v1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    move-object v0, v1

    .line 56
    :goto_0
    invoke-virtual {p0, p1}, Lei;->a(I)Lcom/bestbuy/android/api/lib/models/pdp/ContractOption;

    move-result-object v1

    .line 57
    iget-object v2, v0, Lej;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/ContractOption;->getType()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 58
    iget-boolean v2, p0, Lei;->c:Z

    if-eqz v2, :cond_1

    .line 59
    iget-object v2, v0, Lej;->c:Landroid/widget/ImageView;

    invoke-virtual {v2, v5}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 60
    iget-object v2, v0, Lej;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 61
    iget-object v0, v0, Lej;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/ContractOption;->getPrice()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 67
    :goto_1
    return-object p2

    .line 54
    :cond_0
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lej;

    goto :goto_0

    .line 63
    :cond_1
    iget-object v1, v0, Lej;->c:Landroid/widget/ImageView;

    invoke-virtual {v1, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 64
    iget-object v0, v0, Lej;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto :goto_1
.end method

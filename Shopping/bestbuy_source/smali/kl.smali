.class public Lkl;
.super Landroid/widget/LinearLayout;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/bestbuy/android/bbyobjects/ProductImageGallery;

.field private b:Landroid/content/Context;


# direct methods
.method public constructor <init>(Lcom/bestbuy/android/bbyobjects/ProductImageGallery;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 135
    iput-object p1, p0, Lkl;->a:Lcom/bestbuy/android/bbyobjects/ProductImageGallery;

    .line 136
    invoke-direct {p0, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 137
    iput-object p2, p0, Lkl;->b:Landroid/content/Context;

    .line 138
    return-void
.end method


# virtual methods
.method public a(I)V
    .locals 7

    .prologue
    const/16 v6, 0xa

    const/4 v5, -0x2

    const/4 v1, 0x0

    .line 144
    move v0, v1

    :goto_0
    if-ge v0, p1, :cond_1

    .line 145
    new-instance v2, Landroid/widget/ImageView;

    iget-object v3, p0, Lkl;->b:Landroid/content/Context;

    invoke-direct {v2, v3}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    .line 146
    const v3, 0x7f0200f7

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 147
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setTag(Ljava/lang/Object;)V

    .line 148
    if-nez v0, :cond_0

    .line 149
    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setSelected(Z)V

    .line 150
    :cond_0
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;

    const/high16 v4, 0x3f800000    # 1.0f

    invoke-direct {v3, v5, v5, v4}, Landroid/widget/LinearLayout$LayoutParams;-><init>(IIF)V

    .line 151
    invoke-virtual {v3, v6, v1, v6, v1}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 152
    invoke-virtual {p0, v2, v3}, Lkl;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 153
    new-instance v3, Lkl$1;

    invoke-direct {v3, p0, v2}, Lkl$1;-><init>(Lkl;Landroid/widget/ImageView;)V

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 144
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 163
    :cond_1
    return-void
.end method

.method public b(I)V
    .locals 4

    .prologue
    const/4 v2, 0x0

    .line 165
    move v1, v2

    :goto_0
    invoke-virtual {p0}, Lkl;->getChildCount()I

    move-result v0

    if-ge v1, v0, :cond_2

    .line 166
    invoke-virtual {p0, v1}, Lkl;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 167
    if-ne p1, v1, :cond_1

    .line 168
    if-eqz v0, :cond_0

    .line 169
    const/4 v3, 0x1

    invoke-virtual {v0, v3}, Landroid/widget/ImageView;->setSelected(Z)V

    .line 165
    :cond_0
    :goto_1
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 172
    :cond_1
    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setSelected(Z)V

    goto :goto_1

    .line 175
    :cond_2
    return-void
.end method

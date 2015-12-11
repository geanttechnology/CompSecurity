.class public Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;
.super Landroid/widget/BaseAdapter;
.source "FastBrowseListAdapter.java"


# annotations
.annotation build Landroid/annotation/SuppressLint;
    value = {
        "NewApi"
    }
.end annotation


# static fields
.field private static final TXT_NORMAL_SIZE:I = 0xf

.field private static final TXT_SMALL_SIZE:I = 0xd


# instance fields
.field private context:Landroid/content/Context;

.field private currentLayer:I

.field private fastBrowseItems:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/util/ArrayList;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p3, "baseLayer"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;",
            ">;I)V"
        }
    .end annotation

    .prologue
    .line 42
    .local p2, "fastBrowseItems":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;>;"
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 43
    iput-object p1, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;->context:Landroid/content/Context;

    .line 44
    iput-object p2, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;->fastBrowseItems:Ljava/util/ArrayList;

    .line 45
    iput p3, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;->currentLayer:I

    .line 46
    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;->fastBrowseItems:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public getCurrentLayer()I
    .locals 1

    .prologue
    .line 55
    iget v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;->currentLayer:I

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 67
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;->fastBrowseItems:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 73
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 8
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v7, 0x1

    const/16 v6, 0x8

    const/4 v5, 0x0

    .line 81
    if-nez p2, :cond_0

    .line 83
    iget-object v3, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;->context:Landroid/content/Context;

    invoke-static {v3}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v3

    sget v4, Lcom/amazon/retailsearch/R$layout;->rs_right_sliding_menu_items:I

    invoke-virtual {v3, v4, p3, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p2

    .line 87
    :cond_0
    sget v3, Lcom/amazon/retailsearch/R$id;->sliding_menu_icon:I

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 88
    .local v1, "imgIcon":Landroid/widget/ImageView;
    sget v3, Lcom/amazon/retailsearch/R$id;->sliding_menu_title:I

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 89
    .local v2, "txtTitle":Landroid/widget/TextView;
    sget v3, Lcom/amazon/retailsearch/R$id;->sliding_menu_gap:I

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 91
    .local v0, "gap":Landroid/view/View;
    iget-object v3, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;->fastBrowseItems:Ljava/util/ArrayList;

    invoke-virtual {v3, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;

    invoke-virtual {v3}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;->getIcon()I

    move-result v3

    invoke-virtual {v1, v3}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 92
    iget-object v3, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;->fastBrowseItems:Ljava/util/ArrayList;

    invoke-virtual {v3, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;

    invoke-virtual {v3}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;->getTitle()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 95
    iget v3, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;->currentLayer:I

    if-ge p1, v3, :cond_1

    .line 97
    invoke-virtual {v1, v5}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 98
    invoke-virtual {v0, v6}, Landroid/view/View;->setVisibility(I)V

    .line 110
    :goto_0
    iget v3, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;->currentLayer:I

    if-ne v3, p1, :cond_3

    .line 112
    invoke-virtual {v2}, Landroid/widget/TextView;->getPaint()Landroid/text/TextPaint;

    move-result-object v3

    invoke-virtual {v3, v7}, Landroid/text/TextPaint;->setFakeBoldText(Z)V

    .line 113
    const/high16 v3, 0x41700000    # 15.0f

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setTextSize(F)V

    .line 114
    iget-object v3, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;->context:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/retailsearch/R$drawable;->rs_right_menu_text_selected:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColorStateList(I)Landroid/content/res/ColorStateList;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setTextColor(Landroid/content/res/ColorStateList;)V

    .line 115
    invoke-virtual {p2, v7}, Landroid/view/View;->setClickable(Z)V

    .line 124
    :goto_1
    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0x10

    if-lt v3, v4, :cond_4

    .line 126
    iget-object v3, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;->context:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/retailsearch/R$drawable;->rs_list_selector:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    invoke-virtual {p2, v3}, Landroid/view/View;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 133
    :goto_2
    return-object p2

    .line 99
    :cond_1
    iget v3, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;->currentLayer:I

    if-ne p1, v3, :cond_2

    .line 101
    invoke-virtual {v1, v6}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 102
    invoke-virtual {v0, v5}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0

    .line 105
    :cond_2
    const/4 v3, 0x4

    invoke-virtual {v1, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 106
    invoke-virtual {v0, v6}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0

    .line 118
    :cond_3
    invoke-virtual {v2}, Landroid/widget/TextView;->getPaint()Landroid/text/TextPaint;

    move-result-object v3

    invoke-virtual {v3, v5}, Landroid/text/TextPaint;->setFakeBoldText(Z)V

    .line 119
    const/high16 v3, 0x41500000    # 13.0f

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setTextSize(F)V

    .line 120
    iget-object v3, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;->context:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/retailsearch/R$drawable;->rs_right_menu_text_previous:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColorStateList(I)Landroid/content/res/ColorStateList;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setTextColor(Landroid/content/res/ColorStateList;)V

    .line 121
    invoke-virtual {p2, v5}, Landroid/view/View;->setClickable(Z)V

    goto :goto_1

    .line 130
    :cond_4
    iget-object v3, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;->context:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/retailsearch/R$drawable;->rs_list_selector:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    invoke-virtual {p2, v3}, Landroid/view/View;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_2
.end method

.method public setCurrentLayer(I)V
    .locals 0
    .param p1, "currentLayer"    # I

    .prologue
    .line 50
    iput p1, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;->currentLayer:I

    .line 51
    return-void
.end method

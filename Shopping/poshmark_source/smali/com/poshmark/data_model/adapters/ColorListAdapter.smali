.class public Lcom/poshmark/data_model/adapters/ColorListAdapter;
.super Landroid/widget/ArrayAdapter;
.source "ColorListAdapter.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/ArrayAdapter",
        "<",
        "Lcom/poshmark/data_model/models/PMColor;",
        ">;"
    }
.end annotation


# instance fields
.field context:Landroid/content/Context;

.field currentSelection:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/PMColor;",
            ">;"
        }
    .end annotation
.end field

.field data:Lcom/poshmark/utils/meta_data/ColorPickerInfo;

.field filteredData:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/poshmark/data_model/models/IndexedMetaItem;",
            ">;"
        }
    .end annotation
.end field

.field layoutResourceId:I


# direct methods
.method public constructor <init>(Landroid/content/Context;ILcom/poshmark/utils/meta_data/ColorPickerInfo;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "layoutResourceId"    # I
    .param p3, "data"    # Lcom/poshmark/utils/meta_data/ColorPickerInfo;

    .prologue
    .line 35
    iget-object v0, p3, Lcom/poshmark/utils/meta_data/ColorPickerInfo;->allItems:Ljava/util/List;

    invoke-direct {p0, p1, p2, v0}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 36
    iput-object p3, p0, Lcom/poshmark/data_model/adapters/ColorListAdapter;->data:Lcom/poshmark/utils/meta_data/ColorPickerInfo;

    .line 37
    iput-object p1, p0, Lcom/poshmark/data_model/adapters/ColorListAdapter;->context:Landroid/content/Context;

    .line 38
    iput p2, p0, Lcom/poshmark/data_model/adapters/ColorListAdapter;->layoutResourceId:I

    .line 39
    iget-object v0, p3, Lcom/poshmark/utils/meta_data/ColorPickerInfo;->selectedColors:Ljava/util/List;

    iput-object v0, p0, Lcom/poshmark/data_model/adapters/ColorListAdapter;->currentSelection:Ljava/util/List;

    .line 40
    return-void
.end method

.method private constructor <init>(Landroid/content/Context;ILjava/util/ArrayList;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "layoutResourceId"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "I",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/poshmark/data_model/models/PMColor;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 43
    .local p3, "data":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/poshmark/data_model/models/PMColor;>;"
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 44
    return-void
.end method


# virtual methods
.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 10
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 48
    invoke-virtual {p0, p1}, Lcom/poshmark/data_model/adapters/ColorListAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/PMColor;

    .line 49
    .local v2, "colorItem":Lcom/poshmark/data_model/models/PMColor;
    move-object v6, p2

    .line 50
    .local v6, "row":Landroid/view/View;
    iget-object v8, p0, Lcom/poshmark/data_model/adapters/ColorListAdapter;->context:Landroid/content/Context;

    check-cast v8, Landroid/app/Activity;

    invoke-virtual {v8}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v5

    .line 51
    .local v5, "inflater":Landroid/view/LayoutInflater;
    if-nez v6, :cond_0

    .line 52
    iget v8, p0, Lcom/poshmark/data_model/adapters/ColorListAdapter;->layoutResourceId:I

    const/4 v9, 0x0

    invoke-virtual {v5, v8, p3, v9}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v6

    .line 55
    :cond_0
    const v8, 0x7f0c00d1

    invoke-virtual {v6, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/RelativeLayout;

    .line 56
    .local v3, "container":Landroid/widget/RelativeLayout;
    const v8, 0x7f0c00d5

    invoke-virtual {v6, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/TextView;

    .line 57
    .local v7, "textView":Landroid/widget/TextView;
    const v8, 0x7f0c00d3

    invoke-virtual {v6, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 58
    .local v0, "checkMark":Landroid/widget/ImageView;
    const v8, 0x7f0c00d4

    invoke-virtual {v6, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 61
    .local v1, "circle":Landroid/widget/ImageView;
    iget-object v8, p0, Lcom/poshmark/data_model/adapters/ColorListAdapter;->context:Landroid/content/Context;

    invoke-virtual {v8}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    const v9, 0x7f020038

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    check-cast v4, Landroid/graphics/drawable/GradientDrawable;

    .line 62
    .local v4, "drawable":Landroid/graphics/drawable/GradientDrawable;
    iget-object v8, v2, Lcom/poshmark/data_model/models/PMColor;->rgb:Ljava/lang/String;

    invoke-static {v8}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v8

    invoke-virtual {v4, v8}, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V

    .line 63
    invoke-virtual {v1, v4}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 65
    invoke-virtual {v2}, Lcom/poshmark/data_model/models/PMColor;->getName()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 66
    iget-object v8, p0, Lcom/poshmark/data_model/adapters/ColorListAdapter;->data:Lcom/poshmark/utils/meta_data/ColorPickerInfo;

    invoke-virtual {v8, v2}, Lcom/poshmark/utils/meta_data/ColorPickerInfo;->isColorInSelectColorList(Lcom/poshmark/data_model/models/PMColor;)Z

    move-result v8

    if-eqz v8, :cond_1

    .line 67
    iget-object v8, p0, Lcom/poshmark/data_model/adapters/ColorListAdapter;->context:Landroid/content/Context;

    invoke-virtual {v8}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    const v9, 0x7f02007e

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v8

    invoke-virtual {v0, v8}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 71
    :goto_0
    invoke-virtual {v6, v2}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 72
    return-object v6

    .line 69
    :cond_1
    const/4 v8, 0x0

    invoke-virtual {v0, v8}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0
.end method

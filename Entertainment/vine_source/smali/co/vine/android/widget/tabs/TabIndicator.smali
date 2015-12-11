.class public Lco/vine/android/widget/tabs/TabIndicator;
.super Landroid/widget/RelativeLayout;
.source "TabIndicator.java"


# instance fields
.field private mIcon:Landroid/widget/ImageView;

.field private mIconNewResId:I

.field private mIconResId:I

.field private mNew:Z

.field private mNewIndicator:Landroid/widget/ImageView;

.field private mTabText:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 30
    invoke-direct {p0, p1}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    .line 31
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 45
    invoke-direct {p0, p1, p2}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 46
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 49
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 50
    return-void
.end method

.method public static createTextColorList(II)Landroid/content/res/ColorStateList;
    .locals 8
    .param p0, "on"    # I
    .param p1, "off"    # I

    .prologue
    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 34
    new-instance v0, Landroid/content/res/ColorStateList;

    new-array v1, v7, [[I

    new-array v2, v5, [I

    const v3, 0x10100a1

    aput v3, v2, v4

    aput-object v2, v1, v4

    new-array v2, v5, [I

    const v3, 0x10100a7

    aput v3, v2, v4

    aput-object v2, v1, v5

    new-array v2, v4, [I

    aput-object v2, v1, v6

    new-array v2, v7, [I

    aput p0, v2, v4

    aput p0, v2, v5

    aput p1, v2, v6

    invoke-direct {v0, v1, v2}, Landroid/content/res/ColorStateList;-><init>([[I[I)V

    return-object v0
.end method

.method public static newIconIndicator(Landroid/view/LayoutInflater;ILandroid/widget/TabHost;II)Lco/vine/android/widget/tabs/TabIndicator;
    .locals 3
    .param p0, "inflater"    # Landroid/view/LayoutInflater;
    .param p1, "layout"    # I
    .param p2, "tabHost"    # Landroid/widget/TabHost;
    .param p3, "iconResId"    # I
    .param p4, "newResId"    # I

    .prologue
    .line 64
    invoke-virtual {p2}, Landroid/widget/TabHost;->getTabWidget()Landroid/widget/TabWidget;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {p0, p1, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lco/vine/android/widget/tabs/TabIndicator;

    .line 66
    .local v0, "indicator":Lco/vine/android/widget/tabs/TabIndicator;
    if-lez p3, :cond_0

    .line 67
    invoke-virtual {v0, p3, p4}, Lco/vine/android/widget/tabs/TabIndicator;->setTabIcon(II)V

    .line 69
    :cond_0
    return-object v0
.end method

.method public static newTextIndicator(Landroid/view/LayoutInflater;ILandroid/widget/TabHost;IZ)Lco/vine/android/widget/tabs/TabIndicator;
    .locals 3
    .param p0, "inflater"    # Landroid/view/LayoutInflater;
    .param p1, "layout"    # I
    .param p2, "tabHost"    # Landroid/widget/TabHost;
    .param p3, "tabTextId"    # I
    .param p4, "caps"    # Z

    .prologue
    .line 54
    invoke-virtual {p2}, Landroid/widget/TabHost;->getTabWidget()Landroid/widget/TabWidget;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {p0, p1, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lco/vine/android/widget/tabs/TabIndicator;

    .line 56
    .local v0, "indicator":Lco/vine/android/widget/tabs/TabIndicator;
    if-lez p3, :cond_0

    .line 57
    invoke-virtual {v0, p3, p4}, Lco/vine/android/widget/tabs/TabIndicator;->setTabText(IZ)V

    .line 59
    :cond_0
    return-object v0
.end method


# virtual methods
.method protected drawableStateChanged()V
    .locals 1

    .prologue
    .line 145
    invoke-super {p0}, Landroid/widget/RelativeLayout;->drawableStateChanged()V

    .line 146
    iget-object v0, p0, Lco/vine/android/widget/tabs/TabIndicator;->mTabText:Landroid/widget/TextView;

    if-eqz v0, :cond_0

    .line 151
    :cond_0
    return-void
.end method

.method public getIndicatorText()Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 154
    iget-object v0, p0, Lco/vine/android/widget/tabs/TabIndicator;->mTabText:Landroid/widget/TextView;

    return-object v0
.end method

.method public getNewIndicator()Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lco/vine/android/widget/tabs/TabIndicator;->mNewIndicator:Landroid/widget/ImageView;

    return-object v0
.end method

.method protected onFinishInflate()V
    .locals 1

    .prologue
    .line 75
    invoke-super {p0}, Landroid/widget/RelativeLayout;->onFinishInflate()V

    .line 76
    const v0, 0x7f0a00e5

    invoke-virtual {p0, v0}, Lco/vine/android/widget/tabs/TabIndicator;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lco/vine/android/widget/tabs/TabIndicator;->mTabText:Landroid/widget/TextView;

    .line 77
    const v0, 0x7f0a0071

    invoke-virtual {p0, v0}, Lco/vine/android/widget/tabs/TabIndicator;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lco/vine/android/widget/tabs/TabIndicator;->mNewIndicator:Landroid/widget/ImageView;

    .line 78
    const v0, 0x7f0a0049

    invoke-virtual {p0, v0}, Lco/vine/android/widget/tabs/TabIndicator;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lco/vine/android/widget/tabs/TabIndicator;->mIcon:Landroid/widget/ImageView;

    .line 79
    return-void
.end method

.method public setColor(I)V
    .locals 2
    .param p1, "color"    # I

    .prologue
    .line 106
    iget-object v0, p0, Lco/vine/android/widget/tabs/TabIndicator;->mIcon:Landroid/widget/ImageView;

    sget-object v1, Landroid/graphics/PorterDuff$Mode;->SRC_ATOP:Landroid/graphics/PorterDuff$Mode;

    invoke-virtual {v0, p1, v1}, Landroid/widget/ImageView;->setColorFilter(ILandroid/graphics/PorterDuff$Mode;)V

    .line 107
    iget-object v0, p0, Lco/vine/android/widget/tabs/TabIndicator;->mIcon:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->invalidate()V

    .line 108
    return-void
.end method

.method public setNew(Z)V
    .locals 2
    .param p1, "isNew"    # Z

    .prologue
    .line 86
    iget-boolean v0, p0, Lco/vine/android/widget/tabs/TabIndicator;->mNew:Z

    if-ne p1, v0, :cond_0

    .line 103
    :goto_0
    return-void

    .line 89
    :cond_0
    iget-object v0, p0, Lco/vine/android/widget/tabs/TabIndicator;->mNewIndicator:Landroid/widget/ImageView;

    if-eqz v0, :cond_3

    .line 90
    if-eqz p1, :cond_2

    .line 91
    iget-object v0, p0, Lco/vine/android/widget/tabs/TabIndicator;->mNewIndicator:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 102
    :cond_1
    :goto_1
    iput-boolean p1, p0, Lco/vine/android/widget/tabs/TabIndicator;->mNew:Z

    goto :goto_0

    .line 93
    :cond_2
    iget-object v0, p0, Lco/vine/android/widget/tabs/TabIndicator;->mNewIndicator:Landroid/widget/ImageView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_1

    .line 95
    :cond_3
    iget v0, p0, Lco/vine/android/widget/tabs/TabIndicator;->mIconNewResId:I

    if-lez v0, :cond_1

    .line 96
    if-eqz p1, :cond_4

    .line 97
    iget-object v0, p0, Lco/vine/android/widget/tabs/TabIndicator;->mIcon:Landroid/widget/ImageView;

    iget v1, p0, Lco/vine/android/widget/tabs/TabIndicator;->mIconNewResId:I

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_1

    .line 99
    :cond_4
    iget-object v0, p0, Lco/vine/android/widget/tabs/TabIndicator;->mIcon:Landroid/widget/ImageView;

    iget v1, p0, Lco/vine/android/widget/tabs/TabIndicator;->mIconResId:I

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_1
.end method

.method public setTabIcon(II)V
    .locals 2
    .param p1, "resId"    # I
    .param p2, "newResId"    # I

    .prologue
    .line 131
    iget-object v0, p0, Lco/vine/android/widget/tabs/TabIndicator;->mIcon:Landroid/widget/ImageView;

    if-eqz v0, :cond_0

    .line 132
    if-lez p1, :cond_1

    .line 133
    iget-object v0, p0, Lco/vine/android/widget/tabs/TabIndicator;->mIcon:Landroid/widget/ImageView;

    invoke-virtual {v0, p1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 134
    iget-object v0, p0, Lco/vine/android/widget/tabs/TabIndicator;->mIcon:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 139
    :cond_0
    :goto_0
    iput p1, p0, Lco/vine/android/widget/tabs/TabIndicator;->mIconResId:I

    .line 140
    iput p2, p0, Lco/vine/android/widget/tabs/TabIndicator;->mIconNewResId:I

    .line 141
    return-void

    .line 136
    :cond_1
    iget-object v0, p0, Lco/vine/android/widget/tabs/TabIndicator;->mIcon:Landroid/widget/ImageView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0
.end method

.method public setTabText(IZ)V
    .locals 3
    .param p1, "resId"    # I
    .param p2, "caps"    # Z

    .prologue
    .line 116
    iget-object v1, p0, Lco/vine/android/widget/tabs/TabIndicator;->mTabText:Landroid/widget/TextView;

    if-eqz v1, :cond_1

    .line 117
    invoke-virtual {p0}, Lco/vine/android/widget/tabs/TabIndicator;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, p1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 118
    .local v0, "text":Ljava/lang/String;
    if-eqz p2, :cond_0

    .line 119
    invoke-virtual {v0}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v0

    .line 121
    :cond_0
    if-lez p1, :cond_2

    .line 122
    iget-object v1, p0, Lco/vine/android/widget/tabs/TabIndicator;->mTabText:Landroid/widget/TextView;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 123
    iget-object v1, p0, Lco/vine/android/widget/tabs/TabIndicator;->mTabText:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 128
    .end local v0    # "text":Ljava/lang/String;
    :cond_1
    :goto_0
    return-void

    .line 125
    .restart local v0    # "text":Ljava/lang/String;
    :cond_2
    iget-object v1, p0, Lco/vine/android/widget/tabs/TabIndicator;->mTabText:Landroid/widget/TextView;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method

.method public unSetColor()V
    .locals 2

    .prologue
    .line 111
    iget-object v0, p0, Lco/vine/android/widget/tabs/TabIndicator;->mIcon:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setColorFilter(Landroid/graphics/ColorFilter;)V

    .line 112
    iget-object v0, p0, Lco/vine/android/widget/tabs/TabIndicator;->mIcon:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->invalidate()V

    .line 113
    return-void
.end method

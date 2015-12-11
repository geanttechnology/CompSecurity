.class public Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;
.super Ljava/lang/Object;
.source "StyleAttributesReader.java"


# static fields
.field private static final STYLE_ATTRIBUTES:[I


# instance fields
.field private context:Landroid/content/Context;

.field private imageAlign:Ljava/lang/Integer;

.field private imageHeight:Ljava/lang/Float;

.field private isBold:Ljava/lang/Boolean;

.field private isLink:Ljava/lang/Boolean;

.field private isStrikethrough:Ljava/lang/Boolean;

.field private res:Landroid/content/res/Resources;

.field private textColor:Ljava/lang/Integer;

.field private textSize:Ljava/lang/Float;

.field private textSizePixels:Ljava/lang/Integer;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 25
    const/4 v0, 0x7

    new-array v0, v0, [I

    const/4 v1, 0x0

    const v2, 0x1010098

    aput v2, v0, v1

    const/4 v1, 0x1

    const v2, 0x1010095

    aput v2, v0, v1

    const/4 v1, 0x2

    sget v2, Lcom/amazon/retailsearch/R$attr;->Rs_ImageHeight:I

    aput v2, v0, v1

    const/4 v1, 0x3

    sget v2, Lcom/amazon/retailsearch/R$attr;->Rs_ImageAlign:I

    aput v2, v0, v1

    const/4 v1, 0x4

    sget v2, Lcom/amazon/retailsearch/R$attr;->Rs_IsStrikethroughSpan:I

    aput v2, v0, v1

    const/4 v1, 0x5

    sget v2, Lcom/amazon/retailsearch/R$attr;->Rs_IsBoldSpan:I

    aput v2, v0, v1

    const/4 v1, 0x6

    sget v2, Lcom/amazon/retailsearch/R$attr;->Rs_IsLinkSpan:I

    aput v2, v0, v1

    sput-object v0, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->STYLE_ATTRIBUTES:[I

    .line 39
    sget-object v0, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->STYLE_ATTRIBUTES:[I

    invoke-static {v0}, Ljava/util/Arrays;->sort([I)V

    .line 40
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 123
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 124
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->context:Landroid/content/Context;

    .line 125
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->res:Landroid/content/res/Resources;

    .line 126
    return-void
.end method


# virtual methods
.method public getImageAlign()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->imageAlign:Ljava/lang/Integer;

    return-object v0
.end method

.method public getImageHeight()Ljava/lang/Float;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->imageHeight:Ljava/lang/Float;

    return-object v0
.end method

.method public getIsBold()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 106
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->isBold:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getIsLink()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 114
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->isLink:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getIsStrikethrough()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 98
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->isStrikethrough:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getTextColor()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->textColor:Ljava/lang/Integer;

    return-object v0
.end method

.method public getTextSize()Ljava/lang/Float;
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->textSize:Ljava/lang/Float;

    return-object v0
.end method

.method public getTextSizePixels()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->textSizePixels:Ljava/lang/Integer;

    return-object v0
.end method

.method public readStyle(ILcom/amazon/retailsearch/android/ui/results/ViewType;)V
    .locals 8
    .param p1, "baseStyleId"    # I
    .param p2, "viewType"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .prologue
    const/high16 v7, -0x40800000    # -1.0f

    const/4 v6, 0x0

    .line 140
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->res:Landroid/content/res/Resources;

    invoke-static {p1, p2, v4}, Lcom/amazon/retailsearch/android/ui/results/RetailSearchResultStyles;->getStyleId(ILcom/amazon/retailsearch/android/ui/results/ViewType;Landroid/content/res/Resources;)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v2

    .line 145
    .local v2, "styleId":I
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->context:Landroid/content/Context;

    sget-object v5, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->STYLE_ATTRIBUTES:[I

    invoke-virtual {v4, v2, v5}, Landroid/content/Context;->obtainStyledAttributes(I[I)Landroid/content/res/TypedArray;

    move-result-object v3

    .line 146
    .local v3, "ta":Landroid/content/res/TypedArray;
    const/4 v0, 0x0

    .local v0, "attrIndex":I
    :goto_0
    invoke-virtual {v3}, Landroid/content/res/TypedArray;->length()I

    move-result v4

    if-ge v0, v4, :cond_8

    .line 148
    invoke-virtual {v3, v0}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v4

    if-nez v4, :cond_1

    .line 146
    :cond_0
    :goto_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 155
    :cond_1
    sget-object v4, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->STYLE_ATTRIBUTES:[I

    aget v1, v4, v0

    .line 157
    .local v1, "attrResId":I
    const v4, 0x1010098

    if-ne v1, v4, :cond_2

    .line 159
    invoke-virtual {v3, v0, v6}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->textColor:Ljava/lang/Integer;

    goto :goto_1

    .line 161
    :cond_2
    const v4, 0x1010095

    if-ne v1, v4, :cond_3

    .line 163
    invoke-virtual {v3, v0, v7}, Landroid/content/res/TypedArray;->getDimension(IF)F

    move-result v4

    invoke-static {v4}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->textSize:Ljava/lang/Float;

    .line 164
    const/4 v4, -0x1

    invoke-virtual {v3, v0, v4}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->textSizePixels:Ljava/lang/Integer;

    goto :goto_1

    .line 166
    :cond_3
    sget v4, Lcom/amazon/retailsearch/R$attr;->Rs_ImageHeight:I

    if-ne v1, v4, :cond_4

    .line 168
    invoke-virtual {v3, v0, v7}, Landroid/content/res/TypedArray;->getDimension(IF)F

    move-result v4

    invoke-static {v4}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->imageHeight:Ljava/lang/Float;

    goto :goto_1

    .line 170
    :cond_4
    sget v4, Lcom/amazon/retailsearch/R$attr;->Rs_ImageAlign:I

    if-ne v1, v4, :cond_5

    .line 172
    invoke-virtual {v3, v0, v6}, Landroid/content/res/TypedArray;->getInteger(II)I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->imageAlign:Ljava/lang/Integer;

    goto :goto_1

    .line 174
    :cond_5
    sget v4, Lcom/amazon/retailsearch/R$attr;->Rs_IsStrikethroughSpan:I

    if-ne v1, v4, :cond_6

    .line 176
    invoke-virtual {v3, v0, v6}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v4

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->isStrikethrough:Ljava/lang/Boolean;

    goto :goto_1

    .line 178
    :cond_6
    sget v4, Lcom/amazon/retailsearch/R$attr;->Rs_IsBoldSpan:I

    if-ne v1, v4, :cond_7

    .line 180
    invoke-virtual {v3, v0, v6}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v4

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->isBold:Ljava/lang/Boolean;

    goto :goto_1

    .line 182
    :cond_7
    sget v4, Lcom/amazon/retailsearch/R$attr;->Rs_IsLinkSpan:I

    if-ne v1, v4, :cond_0

    .line 184
    invoke-virtual {v3, v0, v6}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v4

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/retailsearch/android/ui/StyleAttributesReader;->isLink:Ljava/lang/Boolean;

    goto :goto_1

    .line 188
    .end local v1    # "attrResId":I
    :cond_8
    invoke-virtual {v3}, Landroid/content/res/TypedArray;->recycle()V

    .line 189
    return-void
.end method

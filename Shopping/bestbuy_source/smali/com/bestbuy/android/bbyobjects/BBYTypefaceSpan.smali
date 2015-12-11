.class public Lcom/bestbuy/android/bbyobjects/BBYTypefaceSpan;
.super Landroid/text/style/TypefaceSpan;
.source "SourceFile"


# instance fields
.field private final a:Landroid/graphics/Typeface;


# direct methods
.method public constructor <init>(Ljava/lang/String;Landroid/graphics/Typeface;)V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0, p1}, Landroid/text/style/TypefaceSpan;-><init>(Ljava/lang/String;)V

    .line 17
    iput-object p2, p0, Lcom/bestbuy/android/bbyobjects/BBYTypefaceSpan;->a:Landroid/graphics/Typeface;

    .line 18
    return-void
.end method

.method private a(Landroid/graphics/Paint;Landroid/graphics/Typeface;)V
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 32
    invoke-virtual {p1}, Landroid/graphics/Paint;->getTypeface()Landroid/graphics/Typeface;

    move-result-object v0

    .line 33
    if-nez v0, :cond_1

    move v0, v1

    .line 39
    :goto_0
    invoke-virtual {p2}, Landroid/graphics/Typeface;->getStyle()I

    move-result v2

    xor-int/lit8 v2, v2, -0x1

    and-int/2addr v0, v2

    .line 40
    and-int/lit8 v2, v0, 0x1

    if-eqz v2, :cond_2

    .line 41
    const/4 v1, 0x1

    invoke-virtual {p1, v1}, Landroid/graphics/Paint;->setFakeBoldText(Z)V

    .line 45
    :goto_1
    and-int/lit8 v0, v0, 0x2

    if-eqz v0, :cond_0

    .line 46
    const/high16 v0, -0x41800000    # -0.25f

    invoke-virtual {p1, v0}, Landroid/graphics/Paint;->setTextSkewX(F)V

    .line 48
    :cond_0
    invoke-virtual {p1, p2}, Landroid/graphics/Paint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    .line 49
    return-void

    .line 36
    :cond_1
    invoke-virtual {v0}, Landroid/graphics/Typeface;->getStyle()I

    move-result v0

    goto :goto_0

    .line 43
    :cond_2
    invoke-virtual {p1, v1}, Landroid/graphics/Paint;->setFakeBoldText(Z)V

    goto :goto_1
.end method


# virtual methods
.method public updateDrawState(Landroid/text/TextPaint;)V
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYTypefaceSpan;->a:Landroid/graphics/Typeface;

    invoke-direct {p0, p1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTypefaceSpan;->a(Landroid/graphics/Paint;Landroid/graphics/Typeface;)V

    .line 23
    return-void
.end method

.method public updateMeasureState(Landroid/text/TextPaint;)V
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYTypefaceSpan;->a:Landroid/graphics/Typeface;

    invoke-direct {p0, p1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTypefaceSpan;->a(Landroid/graphics/Paint;Landroid/graphics/Typeface;)V

    .line 28
    return-void
.end method

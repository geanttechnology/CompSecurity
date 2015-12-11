.class public Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;
.super Landroid/text/style/TextAppearanceSpan;
.source "SourceFile"


# instance fields
.field private a:Landroid/graphics/Typeface;


# direct methods
.method public constructor <init>(Landroid/content/Context;ILandroid/graphics/Typeface;)V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0, p1, p2}, Landroid/text/style/TextAppearanceSpan;-><init>(Landroid/content/Context;I)V

    .line 18
    iput-object p3, p0, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;->a:Landroid/graphics/Typeface;

    .line 19
    return-void
.end method

.method private static a(Landroid/graphics/Paint;Landroid/graphics/Typeface;)V
    .locals 2

    .prologue
    .line 36
    invoke-virtual {p0}, Landroid/graphics/Paint;->getTypeface()Landroid/graphics/Typeface;

    move-result-object v0

    .line 37
    if-nez v0, :cond_2

    .line 38
    const/4 v0, 0x0

    .line 43
    :goto_0
    invoke-virtual {p1}, Landroid/graphics/Typeface;->getStyle()I

    move-result v1

    xor-int/lit8 v1, v1, -0x1

    and-int/2addr v0, v1

    .line 44
    and-int/lit8 v1, v0, 0x1

    if-eqz v1, :cond_0

    .line 45
    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Landroid/graphics/Paint;->setFakeBoldText(Z)V

    .line 47
    :cond_0
    and-int/lit8 v0, v0, 0x2

    if-eqz v0, :cond_1

    .line 48
    const/high16 v0, -0x41800000    # -0.25f

    invoke-virtual {p0, v0}, Landroid/graphics/Paint;->setTextSkewX(F)V

    .line 50
    :cond_1
    invoke-virtual {p0, p1}, Landroid/graphics/Paint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    .line 51
    return-void

    .line 40
    :cond_2
    invoke-virtual {v0}, Landroid/graphics/Typeface;->getStyle()I

    move-result v0

    goto :goto_0
.end method


# virtual methods
.method public updateDrawState(Landroid/text/TextPaint;)V
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;->a:Landroid/graphics/Typeface;

    invoke-static {p1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;->a(Landroid/graphics/Paint;Landroid/graphics/Typeface;)V

    .line 24
    invoke-super {p0, p1}, Landroid/text/style/TextAppearanceSpan;->updateDrawState(Landroid/text/TextPaint;)V

    .line 25
    return-void
.end method

.method public updateMeasureState(Landroid/text/TextPaint;)V
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;->a:Landroid/graphics/Typeface;

    invoke-static {p1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;->a(Landroid/graphics/Paint;Landroid/graphics/Typeface;)V

    .line 30
    invoke-super {p0, p1}, Landroid/text/style/TextAppearanceSpan;->updateMeasureState(Landroid/text/TextPaint;)V

    .line 31
    return-void
.end method

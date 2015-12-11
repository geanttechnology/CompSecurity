.class final Lcom/wishabi/flipp/util/StringHelper$1;
.super Landroid/text/style/SuperscriptSpan;
.source "SourceFile"


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 280
    invoke-direct {p0}, Landroid/text/style/SuperscriptSpan;-><init>()V

    return-void
.end method


# virtual methods
.method public final updateDrawState(Landroid/text/TextPaint;)V
    .locals 3

    .prologue
    const/high16 v2, 0x40000000    # 2.0f

    .line 283
    iget v0, p1, Landroid/text/TextPaint;->baselineShift:I

    invoke-virtual {p1}, Landroid/text/TextPaint;->ascent()F

    move-result v1

    div-float/2addr v1, v2

    float-to-int v1, v1

    add-int/2addr v0, v1

    iput v0, p1, Landroid/text/TextPaint;->baselineShift:I

    .line 284
    invoke-virtual {p1}, Landroid/text/TextPaint;->getTextSize()F

    move-result v0

    div-float/2addr v0, v2

    invoke-virtual {p1, v0}, Landroid/text/TextPaint;->setTextSize(F)V

    .line 285
    return-void
.end method

.method public final updateMeasureState(Landroid/text/TextPaint;)V
    .locals 3

    .prologue
    const/high16 v2, 0x40000000    # 2.0f

    .line 289
    iget v0, p1, Landroid/text/TextPaint;->baselineShift:I

    invoke-virtual {p1}, Landroid/text/TextPaint;->ascent()F

    move-result v1

    div-float/2addr v1, v2

    float-to-int v1, v1

    add-int/2addr v0, v1

    iput v0, p1, Landroid/text/TextPaint;->baselineShift:I

    .line 290
    invoke-virtual {p1}, Landroid/text/TextPaint;->getTextSize()F

    move-result v0

    div-float/2addr v0, v2

    invoke-virtual {p1, v0}, Landroid/text/TextPaint;->setTextSize(F)V

    .line 291
    return-void
.end method

.class public Lco/vine/android/widget/ColoredTypefacesSpan;
.super Lco/vine/android/widget/TypefacesSpan;
.source "ColoredTypefacesSpan.java"


# instance fields
.field private mColor:I


# direct methods
.method public constructor <init>(Landroid/graphics/Typeface;I)V
    .locals 1
    .param p1, "type"    # Landroid/graphics/Typeface;
    .param p2, "color"    # I

    .prologue
    .line 16
    const/4 v0, 0x0

    invoke-direct {p0, v0, p1}, Lco/vine/android/widget/TypefacesSpan;-><init>(Ljava/lang/String;Landroid/graphics/Typeface;)V

    .line 17
    iput p2, p0, Lco/vine/android/widget/ColoredTypefacesSpan;->mColor:I

    .line 18
    return-void
.end method

.method public constructor <init>(Lco/vine/android/widget/ColoredSpan;Lco/vine/android/widget/TypefacesSpan;)V
    .locals 2
    .param p1, "coloredSpan"    # Lco/vine/android/widget/ColoredSpan;
    .param p2, "typefacesSpan"    # Lco/vine/android/widget/TypefacesSpan;

    .prologue
    .line 26
    invoke-virtual {p2}, Lco/vine/android/widget/TypefacesSpan;->getFamily()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2}, Lco/vine/android/widget/TypefacesSpan;->getType()Landroid/graphics/Typeface;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lco/vine/android/widget/TypefacesSpan;-><init>(Ljava/lang/String;Landroid/graphics/Typeface;)V

    .line 27
    invoke-virtual {p1}, Lco/vine/android/widget/ColoredSpan;->getColor()I

    move-result v0

    iput v0, p0, Lco/vine/android/widget/ColoredTypefacesSpan;->mColor:I

    .line 28
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Landroid/graphics/Typeface;I)V
    .locals 0
    .param p1, "family"    # Ljava/lang/String;
    .param p2, "type"    # Landroid/graphics/Typeface;
    .param p3, "color"    # I

    .prologue
    .line 21
    invoke-direct {p0, p1, p2}, Lco/vine/android/widget/TypefacesSpan;-><init>(Ljava/lang/String;Landroid/graphics/Typeface;)V

    .line 22
    iput p3, p0, Lco/vine/android/widget/ColoredTypefacesSpan;->mColor:I

    .line 23
    return-void
.end method


# virtual methods
.method public setColor(I)V
    .locals 0
    .param p1, "color"    # I

    .prologue
    .line 31
    iput p1, p0, Lco/vine/android/widget/ColoredTypefacesSpan;->mColor:I

    .line 32
    return-void
.end method

.method public updateDrawState(Landroid/text/TextPaint;)V
    .locals 1
    .param p1, "ds"    # Landroid/text/TextPaint;
        .annotation build Lorg/jetbrains/annotations/NotNull;
        .end annotation
    .end param

    .prologue
    .line 36
    iget v0, p0, Lco/vine/android/widget/ColoredTypefacesSpan;->mColor:I

    invoke-virtual {p1, v0}, Landroid/text/TextPaint;->setColor(I)V

    .line 37
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/text/TextPaint;->setUnderlineText(Z)V

    .line 38
    invoke-super {p0, p1}, Lco/vine/android/widget/TypefacesSpan;->updateDrawState(Landroid/text/TextPaint;)V

    .line 39
    return-void
.end method

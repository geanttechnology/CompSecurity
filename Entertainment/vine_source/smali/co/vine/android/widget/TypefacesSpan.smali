.class public Lco/vine/android/widget/TypefacesSpan;
.super Landroid/text/style/TypefaceSpan;
.source "TypefacesSpan.java"


# instance fields
.field private final newType:Landroid/graphics/Typeface;


# direct methods
.method public constructor <init>(Landroid/graphics/Typeface;)V
    .locals 1
    .param p1, "type"    # Landroid/graphics/Typeface;

    .prologue
    .line 17
    const-string v0, ""

    invoke-direct {p0, v0}, Landroid/text/style/TypefaceSpan;-><init>(Ljava/lang/String;)V

    .line 18
    iput-object p1, p0, Lco/vine/android/widget/TypefacesSpan;->newType:Landroid/graphics/Typeface;

    .line 19
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Landroid/graphics/Typeface;)V
    .locals 0
    .param p1, "family"    # Ljava/lang/String;
    .param p2, "type"    # Landroid/graphics/Typeface;

    .prologue
    .line 22
    invoke-direct {p0, p1}, Landroid/text/style/TypefaceSpan;-><init>(Ljava/lang/String;)V

    .line 23
    iput-object p2, p0, Lco/vine/android/widget/TypefacesSpan;->newType:Landroid/graphics/Typeface;

    .line 24
    return-void
.end method

.method private static applyCustomTypeFace(Landroid/graphics/Paint;Landroid/graphics/Typeface;)V
    .locals 0
    .param p0, "paint"    # Landroid/graphics/Paint;
    .param p1, "tf"    # Landroid/graphics/Typeface;

    .prologue
    .line 37
    invoke-virtual {p0, p1}, Landroid/graphics/Paint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    .line 38
    return-void
.end method


# virtual methods
.method public getType()Landroid/graphics/Typeface;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lco/vine/android/widget/TypefacesSpan;->newType:Landroid/graphics/Typeface;

    return-object v0
.end method

.method public updateDrawState(Landroid/text/TextPaint;)V
    .locals 1
    .param p1, "ds"    # Landroid/text/TextPaint;
        .annotation build Lorg/jetbrains/annotations/NotNull;
        .end annotation
    .end param

    .prologue
    .line 28
    iget-object v0, p0, Lco/vine/android/widget/TypefacesSpan;->newType:Landroid/graphics/Typeface;

    invoke-static {p1, v0}, Lco/vine/android/widget/TypefacesSpan;->applyCustomTypeFace(Landroid/graphics/Paint;Landroid/graphics/Typeface;)V

    .line 29
    return-void
.end method

.method public updateMeasureState(Landroid/text/TextPaint;)V
    .locals 1
    .param p1, "paint"    # Landroid/text/TextPaint;
        .annotation build Lorg/jetbrains/annotations/NotNull;
        .end annotation
    .end param

    .prologue
    .line 33
    iget-object v0, p0, Lco/vine/android/widget/TypefacesSpan;->newType:Landroid/graphics/Typeface;

    invoke-static {p1, v0}, Lco/vine/android/widget/TypefacesSpan;->applyCustomTypeFace(Landroid/graphics/Paint;Landroid/graphics/Typeface;)V

    .line 34
    return-void
.end method

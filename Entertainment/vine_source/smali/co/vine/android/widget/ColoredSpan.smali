.class public Lco/vine/android/widget/ColoredSpan;
.super Landroid/text/style/CharacterStyle;
.source "ColoredSpan.java"


# instance fields
.field private mColor:I


# direct methods
.method public constructor <init>(I)V
    .locals 0
    .param p1, "color"    # I

    .prologue
    .line 15
    invoke-direct {p0}, Landroid/text/style/CharacterStyle;-><init>()V

    .line 16
    iput p1, p0, Lco/vine/android/widget/ColoredSpan;->mColor:I

    .line 17
    return-void
.end method


# virtual methods
.method public getColor()I
    .locals 1

    .prologue
    .line 30
    iget v0, p0, Lco/vine/android/widget/ColoredSpan;->mColor:I

    return v0
.end method

.method public setColor(I)V
    .locals 0
    .param p1, "color"    # I

    .prologue
    .line 20
    iput p1, p0, Lco/vine/android/widget/ColoredSpan;->mColor:I

    .line 21
    return-void
.end method

.method public updateDrawState(Landroid/text/TextPaint;)V
    .locals 1
    .param p1, "ds"    # Landroid/text/TextPaint;
        .annotation build Lorg/jetbrains/annotations/NotNull;
        .end annotation
    .end param

    .prologue
    .line 25
    iget v0, p0, Lco/vine/android/widget/ColoredSpan;->mColor:I

    invoke-virtual {p1, v0}, Landroid/text/TextPaint;->setColor(I)V

    .line 26
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/text/TextPaint;->setUnderlineText(Z)V

    .line 27
    return-void
.end method

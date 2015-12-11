.class public Lco/vine/android/widget/StyledClickableSpan;
.super Landroid/text/style/ClickableSpan;
.source "StyledClickableSpan.java"


# instance fields
.field private mColor:I

.field private final mListener:Lco/vine/android/widget/SpanClickListener;

.field private mSelected:Z

.field private mSetColor:Z

.field private final mTag:Ljava/lang/Object;

.field private final mType:I


# direct methods
.method public constructor <init>(ILjava/lang/Object;Lco/vine/android/widget/SpanClickListener;)V
    .locals 0
    .param p1, "type"    # I
    .param p2, "tag"    # Ljava/lang/Object;
    .param p3, "listener"    # Lco/vine/android/widget/SpanClickListener;

    .prologue
    .line 22
    invoke-direct {p0}, Landroid/text/style/ClickableSpan;-><init>()V

    .line 23
    iput p1, p0, Lco/vine/android/widget/StyledClickableSpan;->mType:I

    .line 24
    iput-object p2, p0, Lco/vine/android/widget/StyledClickableSpan;->mTag:Ljava/lang/Object;

    .line 25
    iput-object p3, p0, Lco/vine/android/widget/StyledClickableSpan;->mListener:Lco/vine/android/widget/SpanClickListener;

    .line 26
    return-void
.end method


# virtual methods
.method public isSelected()Z
    .locals 1

    .prologue
    .line 54
    iget-boolean v0, p0, Lco/vine/android/widget/StyledClickableSpan;->mSelected:Z

    return v0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 44
    iget-object v0, p0, Lco/vine/android/widget/StyledClickableSpan;->mListener:Lco/vine/android/widget/SpanClickListener;

    if-eqz v0, :cond_0

    .line 45
    iget-object v0, p0, Lco/vine/android/widget/StyledClickableSpan;->mListener:Lco/vine/android/widget/SpanClickListener;

    iget v1, p0, Lco/vine/android/widget/StyledClickableSpan;->mType:I

    iget-object v2, p0, Lco/vine/android/widget/StyledClickableSpan;->mTag:Ljava/lang/Object;

    invoke-interface {v0, p1, v1, v2}, Lco/vine/android/widget/SpanClickListener;->onSpanClicked(Landroid/view/View;ILjava/lang/Object;)V

    .line 47
    :cond_0
    return-void
.end method

.method public select(Z)V
    .locals 0
    .param p1, "selected"    # Z

    .prologue
    .line 50
    iput-boolean p1, p0, Lco/vine/android/widget/StyledClickableSpan;->mSelected:Z

    .line 51
    return-void
.end method

.method public setColor(I)V
    .locals 1
    .param p1, "color"    # I

    .prologue
    .line 29
    iput p1, p0, Lco/vine/android/widget/StyledClickableSpan;->mColor:I

    .line 30
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/widget/StyledClickableSpan;->mSetColor:Z

    .line 31
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
    iget-boolean v0, p0, Lco/vine/android/widget/StyledClickableSpan;->mSetColor:Z

    if-eqz v0, :cond_0

    .line 37
    iget v0, p0, Lco/vine/android/widget/StyledClickableSpan;->mColor:I

    invoke-virtual {p1, v0}, Landroid/text/TextPaint;->setColor(I)V

    .line 39
    :cond_0
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/text/TextPaint;->setUnderlineText(Z)V

    .line 40
    return-void
.end method

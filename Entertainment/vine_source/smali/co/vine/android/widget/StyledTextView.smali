.class public Lco/vine/android/widget/StyledTextView;
.super Lco/vine/android/widget/TypefacesTextView;
.source "StyledTextView.java"


# instance fields
.field init:Z

.field private mListener:Lco/vine/android/widget/SpanClickListener;

.field private mOriginalText:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 24
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lco/vine/android/widget/StyledTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 25
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 28
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lco/vine/android/widget/StyledTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 29
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 32
    invoke-direct {p0, p1, p2, p3}, Lco/vine/android/widget/TypefacesTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 21
    const/4 v0, 0x0

    iput-boolean v0, p0, Lco/vine/android/widget/StyledTextView;->init:Z

    .line 33
    return-void
.end method


# virtual methods
.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 0
    .param p1, "canvas"    # Landroid/graphics/Canvas;
        .annotation build Lorg/jetbrains/annotations/NotNull;
        .end annotation
    .end param

    .prologue
    .line 48
    invoke-super {p0, p1}, Lco/vine/android/widget/TypefacesTextView;->onDraw(Landroid/graphics/Canvas;)V

    .line 75
    return-void
.end method

.method public setSpanClickListener(Lco/vine/android/widget/SpanClickListener;)V
    .locals 0
    .param p1, "listener"    # Lco/vine/android/widget/SpanClickListener;

    .prologue
    .line 36
    iput-object p1, p0, Lco/vine/android/widget/StyledTextView;->mListener:Lco/vine/android/widget/SpanClickListener;

    .line 37
    return-void
.end method

.method public setStyledText(Ljava/lang/String;[Landroid/text/style/StyleSpan;)V
    .locals 2
    .param p1, "styledText"    # Ljava/lang/String;
    .param p2, "mStyleSpanBoldSingle"    # [Landroid/text/style/StyleSpan;

    .prologue
    .line 41
    iput-object p1, p0, Lco/vine/android/widget/StyledTextView;->mOriginalText:Ljava/lang/String;

    .line 42
    const/16 v0, 0x22

    invoke-static {p2, p1, v0}, Lco/vine/android/util/Util;->getSpannedText([Ljava/lang/Object;Ljava/lang/String;C)Landroid/text/Spanned;

    move-result-object v0

    sget-object v1, Landroid/widget/TextView$BufferType;->SPANNABLE:Landroid/widget/TextView$BufferType;

    invoke-virtual {p0, v0, v1}, Lco/vine/android/widget/StyledTextView;->setText(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V

    .line 44
    return-void
.end method

.class public Lco/vine/android/widget/TypefacesTextView;
.super Lco/vine/android/views/SdkTextView;
.source "TypefacesTextView.java"


# instance fields
.field private mWeight:I


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 24
    invoke-direct {p0, p1}, Lco/vine/android/views/SdkTextView;-><init>(Landroid/content/Context;)V

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

    invoke-direct {p0, p1, p2, v0}, Lco/vine/android/widget/TypefacesTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 29
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    const/4 v3, 0x0

    .line 32
    invoke-direct {p0, p1, p2, p3}, Lco/vine/android/views/SdkTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 34
    sget-object v2, Lco/vine/android/R$styleable;->VineTextView:[I

    invoke-virtual {p1, p2, v2, p3, v3}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 36
    .local v0, "a":Landroid/content/res/TypedArray;
    const/4 v2, 0x1

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v1

    .line 37
    .local v1, "style":I
    const/4 v2, 0x2

    invoke-virtual {v0, v3, v2}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v2

    iput v2, p0, Lco/vine/android/widget/TypefacesTextView;->mWeight:I

    .line 38
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 39
    invoke-static {p1}, Lco/vine/android/widget/Typefaces;->get(Landroid/content/Context;)Lco/vine/android/widget/Typefaces;

    move-result-object v2

    iget v3, p0, Lco/vine/android/widget/TypefacesTextView;->mWeight:I

    invoke-virtual {v2, v1, v3}, Lco/vine/android/widget/Typefaces;->getContentTypeface(II)Landroid/graphics/Typeface;

    move-result-object v2

    invoke-virtual {p0, v2, v1}, Lco/vine/android/widget/TypefacesTextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 40
    invoke-virtual {p0}, Lco/vine/android/widget/TypefacesTextView;->getPaintFlags()I

    move-result v2

    or-int/lit8 v2, v2, 0x1

    invoke-virtual {p0, v2}, Lco/vine/android/widget/TypefacesTextView;->setPaintFlags(I)V

    .line 41
    return-void
.end method


# virtual methods
.method public setTypeface(Landroid/graphics/Typeface;I)V
    .locals 2
    .param p1, "tf"    # Landroid/graphics/Typeface;
    .param p2, "style"    # I

    .prologue
    .line 49
    invoke-virtual {p0}, Lco/vine/android/widget/TypefacesTextView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lco/vine/android/widget/Typefaces;->get(Landroid/content/Context;)Lco/vine/android/widget/Typefaces;

    move-result-object v0

    iget v1, p0, Lco/vine/android/widget/TypefacesTextView;->mWeight:I

    invoke-virtual {v0, p2, v1}, Lco/vine/android/widget/Typefaces;->getContentTypeface(II)Landroid/graphics/Typeface;

    move-result-object v0

    invoke-super {p0, v0}, Lco/vine/android/views/SdkTextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 50
    return-void
.end method

.method public setWeight(I)V
    .locals 0
    .param p1, "weight"    # I

    .prologue
    .line 44
    iput p1, p0, Lco/vine/android/widget/TypefacesTextView;->mWeight:I

    .line 45
    return-void
.end method

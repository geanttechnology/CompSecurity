.class public Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;
.super Landroid/widget/ProgressBar;
.source "SourceFile"


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 25
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 26
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .prologue
    .line 29
    sget v0, Lfr/castorflex/android/smoothprogressbar/b;->spbStyle:I

    invoke-direct {p0, p1, p2, v0}, Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 30
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 12

    .prologue
    const/4 v11, 0x0

    .line 33
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ProgressBar;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 35
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    .line 36
    sget-object v0, Lfr/castorflex/android/smoothprogressbar/h;->SmoothProgressBar:[I

    invoke-virtual {p1, p2, v0, p3, v11}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 39
    const/4 v1, 0x1

    sget v3, Lfr/castorflex/android/smoothprogressbar/d;->spb_default_color:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v0, v1, v3}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v3

    .line 40
    const/4 v1, 0x4

    sget v4, Lfr/castorflex/android/smoothprogressbar/f;->spb_default_sections_count:I

    invoke-virtual {v2, v4}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v4

    invoke-virtual {v0, v1, v4}, Landroid/content/res/TypedArray;->getInteger(II)I

    move-result v4

    .line 41
    const/4 v1, 0x3

    sget v5, Lfr/castorflex/android/smoothprogressbar/e;->spb_default_stroke_separator_length:I

    invoke-virtual {v2, v5}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v5

    invoke-virtual {v0, v1, v5}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v5

    .line 42
    const/4 v1, 0x2

    sget v6, Lfr/castorflex/android/smoothprogressbar/e;->spb_default_stroke_width:I

    invoke-virtual {v2, v6}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v6

    invoke-virtual {v0, v1, v6}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v6

    .line 43
    const/4 v1, 0x5

    invoke-virtual {v0, v1}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v7

    .line 44
    const/4 v1, 0x6

    sget v8, Lfr/castorflex/android/smoothprogressbar/f;->spb_default_interpolator:I

    invoke-virtual {v2, v8}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v8

    invoke-virtual {v0, v1, v8}, Landroid/content/res/TypedArray;->getInteger(II)I

    move-result v1

    .line 45
    const/4 v8, 0x7

    sget v9, Lfr/castorflex/android/smoothprogressbar/c;->spb_default_reversed:I

    invoke-virtual {v2, v9}, Landroid/content/res/Resources;->getBoolean(I)Z

    move-result v9

    invoke-virtual {v0, v8, v9}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v8

    .line 46
    const/16 v9, 0x8

    sget v10, Lfr/castorflex/android/smoothprogressbar/c;->spb_default_mirror_mode:I

    invoke-virtual {v2, v10}, Landroid/content/res/Resources;->getBoolean(I)Z

    move-result v10

    invoke-virtual {v0, v9, v10}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v9

    .line 47
    const/16 v10, 0x9

    invoke-virtual {v0, v10, v11}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v10

    .line 48
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 52
    packed-switch v1, :pswitch_data_0

    .line 64
    new-instance v0, Landroid/view/animation/AccelerateInterpolator;

    invoke-direct {v0}, Landroid/view/animation/AccelerateInterpolator;-><init>()V

    move-object v1, v0

    .line 67
    :goto_0
    const/4 v0, 0x0

    .line 69
    if-eqz v10, :cond_0

    .line 70
    invoke-virtual {v2, v10}, Landroid/content/res/Resources;->getIntArray(I)[I

    move-result-object v0

    .line 73
    :cond_0
    new-instance v2, Lfr/castorflex/android/smoothprogressbar/k;

    invoke-direct {v2, p1}, Lfr/castorflex/android/smoothprogressbar/k;-><init>(Landroid/content/Context;)V

    iput-object v1, v2, Lfr/castorflex/android/smoothprogressbar/k;->a:Landroid/view/animation/Interpolator;

    if-gtz v4, :cond_1

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "SectionsCount must be > 0"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 54
    :pswitch_0
    new-instance v0, Landroid/view/animation/AccelerateDecelerateInterpolator;

    invoke-direct {v0}, Landroid/view/animation/AccelerateDecelerateInterpolator;-><init>()V

    move-object v1, v0

    .line 55
    goto :goto_0

    .line 57
    :pswitch_1
    new-instance v0, Landroid/view/animation/DecelerateInterpolator;

    invoke-direct {v0}, Landroid/view/animation/DecelerateInterpolator;-><init>()V

    move-object v1, v0

    .line 58
    goto :goto_0

    .line 60
    :pswitch_2
    new-instance v0, Landroid/view/animation/LinearInterpolator;

    invoke-direct {v0}, Landroid/view/animation/LinearInterpolator;-><init>()V

    move-object v1, v0

    .line 61
    goto :goto_0

    .line 73
    :cond_1
    iput v4, v2, Lfr/castorflex/android/smoothprogressbar/k;->b:I

    if-gez v5, :cond_2

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "SeparatorLength must be >= 0"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_2
    iput v5, v2, Lfr/castorflex/android/smoothprogressbar/k;->g:I

    invoke-virtual {v2, v6}, Lfr/castorflex/android/smoothprogressbar/k;->b(I)Lfr/castorflex/android/smoothprogressbar/k;

    move-result-object v1

    iput-boolean v8, v1, Lfr/castorflex/android/smoothprogressbar/k;->e:Z

    iput-boolean v9, v1, Lfr/castorflex/android/smoothprogressbar/k;->f:Z

    .line 81
    if-eqz v7, :cond_4

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v2

    const/4 v4, 0x0

    cmpg-float v4, v2, v4

    if-gez v4, :cond_3

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Speed must be >= 0"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_3
    iput v2, v1, Lfr/castorflex/android/smoothprogressbar/k;->d:F

    .line 82
    :cond_4
    if-eqz v0, :cond_7

    array-length v2, v0

    if-lez v2, :cond_7

    .line 83
    if-eqz v0, :cond_5

    array-length v2, v0

    if-nez v2, :cond_6

    :cond_5
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Your color array must not be empty"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_6
    iput-object v0, v1, Lfr/castorflex/android/smoothprogressbar/k;->c:[I

    .line 87
    :goto_1
    invoke-virtual {v1}, Lfr/castorflex/android/smoothprogressbar/k;->a()Lfr/castorflex/android/smoothprogressbar/i;

    move-result-object v0

    invoke-virtual {p0, v0}, Lfr/castorflex/android/smoothprogressbar/SmoothProgressBar;->setIndeterminateDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 88
    return-void

    .line 85
    :cond_7
    invoke-virtual {v1, v3}, Lfr/castorflex/android/smoothprogressbar/k;->a(I)Lfr/castorflex/android/smoothprogressbar/k;

    goto :goto_1

    .line 52
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

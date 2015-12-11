.class public final Lnet/hockeyapp/android/f/a;
.super Landroid/widget/LinearLayout;
.source "SourceFile"


# instance fields
.field private a:Landroid/widget/TextView;

.field private b:Landroid/widget/TextView;

.field private c:Landroid/widget/TextView;

.field private d:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 58
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lnet/hockeyapp/android/f/a;-><init>(Landroid/content/Context;B)V

    .line 59
    return-void
.end method

.method private constructor <init>(Landroid/content/Context;B)V
    .locals 8

    .prologue
    const/4 v7, 0x2

    const/4 v6, -0x2

    const/high16 v5, 0x3f800000    # 1.0f

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 62
    invoke-direct {p0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 64
    iput-boolean v4, p0, Lnet/hockeyapp/android/f/a;->d:Z

    .line 66
    invoke-virtual {p0, v4}, Lnet/hockeyapp/android/f/a;->setOrientation(I)V

    const/4 v0, 0x3

    invoke-virtual {p0, v0}, Lnet/hockeyapp/android/f/a;->setGravity(I)V

    const v0, -0x333334

    invoke-virtual {p0, v0}, Lnet/hockeyapp/android/f/a;->setBackgroundColor(I)V

    .line 67
    new-instance v0, Landroid/widget/TextView;

    invoke-direct {v0, p1}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lnet/hockeyapp/android/f/a;->a:Landroid/widget/TextView;

    iget-object v0, p0, Lnet/hockeyapp/android/f/a;->a:Landroid/widget/TextView;

    const/16 v1, 0x3001

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setId(I)V

    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {v0, v6, v6}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    const/high16 v1, 0x41a00000    # 20.0f

    invoke-virtual {p0}, Lnet/hockeyapp/android/f/a;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    invoke-static {v4, v1, v2}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v1

    float-to-int v1, v1

    invoke-virtual {v0, v1, v1, v1, v3}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    iget-object v1, p0, Lnet/hockeyapp/android/f/a;->a:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    iget-object v0, p0, Lnet/hockeyapp/android/f/a;->a:Landroid/widget/TextView;

    const/4 v1, 0x0

    const/4 v2, -0x1

    invoke-virtual {v0, v5, v1, v5, v2}, Landroid/widget/TextView;->setShadowLayer(FFFI)V

    iget-object v0, p0, Lnet/hockeyapp/android/f/a;->a:Landroid/widget/TextView;

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setSingleLine(Z)V

    iget-object v0, p0, Lnet/hockeyapp/android/f/a;->a:Landroid/widget/TextView;

    const v1, -0x777778

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    iget-object v0, p0, Lnet/hockeyapp/android/f/a;->a:Landroid/widget/TextView;

    const/high16 v1, 0x41700000    # 15.0f

    invoke-virtual {v0, v7, v1}, Landroid/widget/TextView;->setTextSize(IF)V

    iget-object v0, p0, Lnet/hockeyapp/android/f/a;->a:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1, v3}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;I)V

    iget-object v0, p0, Lnet/hockeyapp/android/f/a;->a:Landroid/widget/TextView;

    invoke-virtual {p0, v0}, Lnet/hockeyapp/android/f/a;->addView(Landroid/view/View;)V

    .line 68
    new-instance v0, Landroid/widget/TextView;

    invoke-direct {v0, p1}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lnet/hockeyapp/android/f/a;->b:Landroid/widget/TextView;

    iget-object v0, p0, Lnet/hockeyapp/android/f/a;->b:Landroid/widget/TextView;

    const/16 v1, 0x3002

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setId(I)V

    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {v0, v6, v6}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    const/high16 v1, 0x41a00000    # 20.0f

    invoke-virtual {p0}, Lnet/hockeyapp/android/f/a;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    invoke-static {v4, v1, v2}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v1

    float-to-int v1, v1

    invoke-virtual {v0, v1, v3, v1, v3}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    iget-object v1, p0, Lnet/hockeyapp/android/f/a;->b:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    iget-object v0, p0, Lnet/hockeyapp/android/f/a;->b:Landroid/widget/TextView;

    const/4 v1, 0x0

    const/4 v2, -0x1

    invoke-virtual {v0, v5, v1, v5, v2}, Landroid/widget/TextView;->setShadowLayer(FFFI)V

    iget-object v0, p0, Lnet/hockeyapp/android/f/a;->b:Landroid/widget/TextView;

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setSingleLine(Z)V

    iget-object v0, p0, Lnet/hockeyapp/android/f/a;->b:Landroid/widget/TextView;

    const v1, -0x777778

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    iget-object v0, p0, Lnet/hockeyapp/android/f/a;->b:Landroid/widget/TextView;

    const/high16 v1, 0x41700000    # 15.0f

    invoke-virtual {v0, v7, v1}, Landroid/widget/TextView;->setTextSize(IF)V

    iget-object v0, p0, Lnet/hockeyapp/android/f/a;->b:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1, v7}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;I)V

    iget-object v0, p0, Lnet/hockeyapp/android/f/a;->b:Landroid/widget/TextView;

    invoke-virtual {p0, v0}, Lnet/hockeyapp/android/f/a;->addView(Landroid/view/View;)V

    .line 69
    new-instance v0, Landroid/widget/TextView;

    invoke-direct {v0, p1}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lnet/hockeyapp/android/f/a;->c:Landroid/widget/TextView;

    iget-object v0, p0, Lnet/hockeyapp/android/f/a;->c:Landroid/widget/TextView;

    const/16 v1, 0x3003

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setId(I)V

    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {v0, v6, v6}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    const/high16 v1, 0x41a00000    # 20.0f

    invoke-virtual {p0}, Lnet/hockeyapp/android/f/a;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    invoke-static {v4, v1, v2}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v1

    float-to-int v1, v1

    invoke-virtual {v0, v1, v3, v1, v1}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    iget-object v1, p0, Lnet/hockeyapp/android/f/a;->c:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    iget-object v0, p0, Lnet/hockeyapp/android/f/a;->c:Landroid/widget/TextView;

    const/4 v1, 0x0

    const/4 v2, -0x1

    invoke-virtual {v0, v5, v1, v5, v2}, Landroid/widget/TextView;->setShadowLayer(FFFI)V

    iget-object v0, p0, Lnet/hockeyapp/android/f/a;->c:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setSingleLine(Z)V

    iget-object v0, p0, Lnet/hockeyapp/android/f/a;->c:Landroid/widget/TextView;

    const/high16 v1, -0x1000000

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    iget-object v0, p0, Lnet/hockeyapp/android/f/a;->c:Landroid/widget/TextView;

    const/high16 v1, 0x41900000    # 18.0f

    invoke-virtual {v0, v7, v1}, Landroid/widget/TextView;->setTextSize(IF)V

    iget-object v0, p0, Lnet/hockeyapp/android/f/a;->c:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1, v3}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;I)V

    iget-object v0, p0, Lnet/hockeyapp/android/f/a;->c:Landroid/widget/TextView;

    invoke-virtual {p0, v0}, Lnet/hockeyapp/android/f/a;->addView(Landroid/view/View;)V

    .line 70
    return-void
.end method

.method private setAuthorLaberColor(I)V
    .locals 1

    .prologue
    .line 108
    iget-object v0, p0, Lnet/hockeyapp/android/f/a;->a:Landroid/widget/TextView;

    if-eqz v0, :cond_0

    .line 109
    iget-object v0, p0, Lnet/hockeyapp/android/f/a;->a:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 111
    :cond_0
    return-void
.end method

.method private setDateLaberColor(I)V
    .locals 1

    .prologue
    .line 143
    iget-object v0, p0, Lnet/hockeyapp/android/f/a;->b:Landroid/widget/TextView;

    if-eqz v0, :cond_0

    .line 144
    iget-object v0, p0, Lnet/hockeyapp/android/f/a;->b:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 146
    :cond_0
    return-void
.end method

.method private setMessageLaberColor(I)V
    .locals 1

    .prologue
    .line 174
    iget-object v0, p0, Lnet/hockeyapp/android/f/a;->c:Landroid/widget/TextView;

    if-eqz v0, :cond_0

    .line 175
    iget-object v0, p0, Lnet/hockeyapp/android/f/a;->c:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 177
    :cond_0
    return-void
.end method


# virtual methods
.method public final setAuthorLabelText(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 102
    iget-object v0, p0, Lnet/hockeyapp/android/f/a;->a:Landroid/widget/TextView;

    if-eqz v0, :cond_0

    if-eqz p1, :cond_0

    .line 103
    iget-object v0, p0, Lnet/hockeyapp/android/f/a;->a:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 105
    :cond_0
    return-void
.end method

.method public final setDateLabelText(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 137
    iget-object v0, p0, Lnet/hockeyapp/android/f/a;->b:Landroid/widget/TextView;

    if-eqz v0, :cond_0

    if-eqz p1, :cond_0

    .line 138
    iget-object v0, p0, Lnet/hockeyapp/android/f/a;->b:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 140
    :cond_0
    return-void
.end method

.method public final setFeedbackMessageViewBgAndTextColor(I)V
    .locals 3

    .prologue
    const/4 v2, -0x1

    const v1, -0x333334

    .line 186
    if-nez p1, :cond_1

    .line 187
    invoke-virtual {p0, v1}, Lnet/hockeyapp/android/f/a;->setBackgroundColor(I)V

    .line 188
    invoke-direct {p0, v2}, Lnet/hockeyapp/android/f/a;->setAuthorLaberColor(I)V

    .line 189
    invoke-direct {p0, v2}, Lnet/hockeyapp/android/f/a;->setDateLaberColor(I)V

    .line 196
    :cond_0
    :goto_0
    const/high16 v0, -0x1000000

    invoke-direct {p0, v0}, Lnet/hockeyapp/android/f/a;->setMessageLaberColor(I)V

    .line 197
    return-void

    .line 190
    :cond_1
    const/4 v0, 0x1

    if-ne p1, v0, :cond_0

    .line 191
    invoke-virtual {p0, v2}, Lnet/hockeyapp/android/f/a;->setBackgroundColor(I)V

    .line 192
    invoke-direct {p0, v1}, Lnet/hockeyapp/android/f/a;->setAuthorLaberColor(I)V

    .line 193
    invoke-direct {p0, v1}, Lnet/hockeyapp/android/f/a;->setDateLaberColor(I)V

    goto :goto_0
.end method

.method public final setMessageLabelText(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 168
    iget-object v0, p0, Lnet/hockeyapp/android/f/a;->c:Landroid/widget/TextView;

    if-eqz v0, :cond_0

    if-eqz p1, :cond_0

    .line 169
    iget-object v0, p0, Lnet/hockeyapp/android/f/a;->c:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 171
    :cond_0
    return-void
.end method

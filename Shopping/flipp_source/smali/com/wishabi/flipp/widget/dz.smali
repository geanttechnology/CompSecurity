.class public Lcom/wishabi/flipp/widget/dz;
.super Landroid/widget/HorizontalScrollView;
.source "SourceFile"


# static fields
.field static final synthetic a:Z


# instance fields
.field private b:I

.field private c:Lcom/wishabi/flipp/widget/eb;

.field private d:Lcom/wishabi/flipp/widget/ec;

.field private final e:Lcom/wishabi/flipp/widget/ee;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 49
    const-class v0, Lcom/wishabi/flipp/widget/dz;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lcom/wishabi/flipp/widget/dz;->a:Z

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 95
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/wishabi/flipp/widget/dz;-><init>(Landroid/content/Context;B)V

    .line 96
    return-void
.end method

.method private constructor <init>(Landroid/content/Context;B)V
    .locals 1

    .prologue
    .line 99
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/wishabi/flipp/widget/dz;-><init>(Landroid/content/Context;C)V

    .line 100
    return-void
.end method

.method private constructor <init>(Landroid/content/Context;C)V
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 103
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0, v1}, Landroid/widget/HorizontalScrollView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 106
    invoke-virtual {p0, v1}, Lcom/wishabi/flipp/widget/dz;->setHorizontalScrollBarEnabled(Z)V

    .line 108
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/dz;->setFillViewport(Z)V

    .line 110
    const/high16 v0, 0x41c00000    # 24.0f

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/dz;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    iget v1, v1, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v0, v1

    float-to-int v0, v0

    iput v0, p0, Lcom/wishabi/flipp/widget/dz;->b:I

    .line 112
    new-instance v0, Lcom/wishabi/flipp/widget/ee;

    invoke-direct {v0, p1}, Lcom/wishabi/flipp/widget/ee;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/dz;->e:Lcom/wishabi/flipp/widget/ee;

    .line 113
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dz;->e:Lcom/wishabi/flipp/widget/ee;

    const/4 v1, -0x1

    const/4 v2, -0x2

    invoke-virtual {p0, v0, v1, v2}, Lcom/wishabi/flipp/widget/dz;->addView(Landroid/view/View;II)V

    .line 114
    return-void
.end method

.method static synthetic a(Lcom/wishabi/flipp/widget/dz;)Lcom/wishabi/flipp/widget/ee;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dz;->e:Lcom/wishabi/flipp/widget/ee;

    return-object v0
.end method

.method private a(I)V
    .locals 2

    .prologue
    .line 235
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dz;->e:Lcom/wishabi/flipp/widget/ee;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/ee;->getChildCount()I

    move-result v0

    .line 236
    if-eqz v0, :cond_0

    if-ltz p1, :cond_0

    if-lt p1, v0, :cond_1

    .line 252
    :cond_0
    :goto_0
    return-void

    .line 240
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dz;->e:Lcom/wishabi/flipp/widget/ee;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/ee;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 241
    if-eqz v0, :cond_0

    .line 242
    invoke-virtual {v0}, Landroid/view/View;->getLeft()I

    move-result v0

    add-int/lit8 v0, v0, 0x0

    .line 244
    if-lez p1, :cond_2

    .line 246
    iget v1, p0, Lcom/wishabi/flipp/widget/dz;->b:I

    sub-int/2addr v0, v1

    .line 249
    :cond_2
    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/widget/dz;->smoothScrollTo(II)V

    .line 250
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dz;->e:Lcom/wishabi/flipp/widget/ee;

    iput p1, v0, Lcom/wishabi/flipp/widget/ee;->a:I

    const/4 v1, 0x0

    iput v1, v0, Lcom/wishabi/flipp/widget/ee;->b:F

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/ee;->invalidate()V

    goto :goto_0
.end method

.method static synthetic a(Lcom/wishabi/flipp/widget/dz;I)V
    .locals 0

    .prologue
    .line 49
    invoke-direct {p0, p1}, Lcom/wishabi/flipp/widget/dz;->a(I)V

    return-void
.end method

.method static synthetic b(Lcom/wishabi/flipp/widget/dz;)Lcom/wishabi/flipp/widget/ec;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dz;->d:Lcom/wishabi/flipp/widget/ec;

    return-object v0
.end method


# virtual methods
.method protected onAttachedToWindow()V
    .locals 1

    .prologue
    .line 227
    invoke-super {p0}, Landroid/widget/HorizontalScrollView;->onAttachedToWindow()V

    .line 229
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dz;->c:Lcom/wishabi/flipp/widget/eb;

    if-eqz v0, :cond_0

    .line 230
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dz;->c:Lcom/wishabi/flipp/widget/eb;

    invoke-interface {v0}, Lcom/wishabi/flipp/widget/eb;->c()I

    move-result v0

    invoke-direct {p0, v0}, Lcom/wishabi/flipp/widget/dz;->a(I)V

    .line 232
    :cond_0
    return-void
.end method

.method public setCustomTabColorizer(Lcom/wishabi/flipp/widget/ed;)V
    .locals 1

    .prologue
    .line 124
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dz;->e:Lcom/wishabi/flipp/widget/ee;

    iput-object p1, v0, Lcom/wishabi/flipp/widget/ee;->c:Lcom/wishabi/flipp/widget/ed;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/ee;->invalidate()V

    .line 125
    return-void
.end method

.method public varargs setDividerColors([I)V
    .locals 2

    .prologue
    .line 142
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dz;->e:Lcom/wishabi/flipp/widget/ee;

    const/4 v1, 0x0

    iput-object v1, v0, Lcom/wishabi/flipp/widget/ee;->c:Lcom/wishabi/flipp/widget/ed;

    iget-object v1, v0, Lcom/wishabi/flipp/widget/ee;->d:Lcom/wishabi/flipp/widget/ef;

    iput-object p1, v1, Lcom/wishabi/flipp/widget/ef;->b:[I

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/ee;->invalidate()V

    .line 143
    return-void
.end method

.method public varargs setSelectedIndicatorColors([I)V
    .locals 2

    .prologue
    .line 133
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dz;->e:Lcom/wishabi/flipp/widget/ee;

    const/4 v1, 0x0

    iput-object v1, v0, Lcom/wishabi/flipp/widget/ee;->c:Lcom/wishabi/flipp/widget/ed;

    iget-object v1, v0, Lcom/wishabi/flipp/widget/ee;->d:Lcom/wishabi/flipp/widget/ef;

    iput-object p1, v1, Lcom/wishabi/flipp/widget/ef;->a:[I

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/ee;->invalidate()V

    .line 134
    return-void
.end method

.method public setTabAdapter(Lcom/wishabi/flipp/widget/eb;)V
    .locals 7

    .prologue
    const/4 v6, 0x1

    .line 148
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dz;->e:Lcom/wishabi/flipp/widget/ee;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/ee;->removeAllViews()V

    .line 149
    iput-object p1, p0, Lcom/wishabi/flipp/widget/dz;->c:Lcom/wishabi/flipp/widget/eb;

    .line 151
    if-eqz p1, :cond_4

    .line 152
    const/4 v0, 0x0

    :goto_0
    iget-object v1, p0, Lcom/wishabi/flipp/widget/dz;->c:Lcom/wishabi/flipp/widget/eb;

    invoke-interface {v1}, Lcom/wishabi/flipp/widget/eb;->a()I

    move-result v1

    if-ge v0, v1, :cond_4

    iget-object v1, p0, Lcom/wishabi/flipp/widget/dz;->c:Lcom/wishabi/flipp/widget/eb;

    invoke-interface {v1}, Lcom/wishabi/flipp/widget/eb;->b()Z

    move-result v1

    if-eqz v1, :cond_3

    iget-object v1, p0, Lcom/wishabi/flipp/widget/dz;->c:Lcom/wishabi/flipp/widget/eb;

    invoke-interface {v1, v0}, Lcom/wishabi/flipp/widget/eb;->a(I)Ljava/lang/String;

    move-result-object v2

    sget-boolean v1, Lcom/wishabi/flipp/widget/dz;->a:Z

    if-nez v1, :cond_0

    if-nez v2, :cond_0

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    :cond_0
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/dz;->getContext()Landroid/content/Context;

    move-result-object v3

    new-instance v1, Landroid/widget/TextView;

    invoke-direct {v1, v3}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    const/16 v3, 0x11

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setGravity(I)V

    const/4 v3, 0x2

    const/high16 v4, 0x41400000    # 12.0f

    invoke-virtual {v1, v3, v4}, Landroid/widget/TextView;->setTextSize(IF)V

    sget-object v3, Landroid/graphics/Typeface;->DEFAULT_BOLD:Landroid/graphics/Typeface;

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0xb

    if-lt v3, v4, :cond_1

    new-instance v3, Landroid/util/TypedValue;

    invoke-direct {v3}, Landroid/util/TypedValue;-><init>()V

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/dz;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v4

    const v5, 0x101030e

    invoke-virtual {v4, v5, v3, v6}, Landroid/content/res/Resources$Theme;->resolveAttribute(ILandroid/util/TypedValue;Z)Z

    iget v3, v3, Landroid/util/TypedValue;->resourceId:I

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setBackgroundResource(I)V

    :cond_1
    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0xe

    if-lt v3, v4, :cond_2

    invoke-virtual {v1, v6}, Landroid/widget/TextView;->setAllCaps(Z)V

    :cond_2
    const/high16 v3, 0x41800000    # 16.0f

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/dz;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v4

    iget v4, v4, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v3, v4

    float-to-int v3, v3

    invoke-virtual {v1, v3, v3, v3, v3}, Landroid/widget/TextView;->setPadding(IIII)V

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    :goto_1
    if-eqz v1, :cond_4

    new-instance v2, Lcom/wishabi/flipp/widget/ea;

    invoke-direct {v2, p0}, Lcom/wishabi/flipp/widget/ea;-><init>(Lcom/wishabi/flipp/widget/dz;)V

    invoke-virtual {v1, v2}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    iget-object v2, p0, Lcom/wishabi/flipp/widget/dz;->e:Lcom/wishabi/flipp/widget/ee;

    invoke-virtual {v2, v1}, Lcom/wishabi/flipp/widget/ee;->addView(Landroid/view/View;)V

    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_0

    :cond_3
    iget-object v1, p0, Lcom/wishabi/flipp/widget/dz;->c:Lcom/wishabi/flipp/widget/eb;

    iget-object v2, p0, Lcom/wishabi/flipp/widget/dz;->e:Lcom/wishabi/flipp/widget/ee;

    invoke-interface {v1, v2, v0}, Lcom/wishabi/flipp/widget/eb;->a(Landroid/view/ViewGroup;I)Landroid/view/View;

    move-result-object v1

    goto :goto_1

    .line 153
    :cond_4
    return-void
.end method

.method public setTabClickListener(Lcom/wishabi/flipp/widget/ec;)V
    .locals 0

    .prologue
    .line 157
    iput-object p1, p0, Lcom/wishabi/flipp/widget/dz;->d:Lcom/wishabi/flipp/widget/ec;

    .line 158
    return-void
.end method

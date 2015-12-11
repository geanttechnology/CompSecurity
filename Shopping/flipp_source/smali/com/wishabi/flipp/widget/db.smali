.class public final Lcom/wishabi/flipp/widget/db;
.super Landroid/widget/FrameLayout;
.source "SourceFile"


# instance fields
.field public a:Z

.field private final b:Landroid/widget/RelativeLayout;

.field private final c:Lcom/wishabi/flipp/widget/CustomEditText;

.field private final d:Landroid/widget/CheckBox;

.field private final e:Landroid/widget/TextView;

.field private final f:Landroid/widget/TextView;

.field private final g:Landroid/view/View;

.field private final h:Landroid/widget/TextView;

.field private final i:Landroid/widget/ImageView;

.field private final j:Landroid/widget/ImageView;

.field private final k:Landroid/widget/ProgressBar;

.field private final l:Landroid/widget/ImageView;

.field private final m:Landroid/widget/LinearLayout;

.field private final n:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/widget/ImageView;",
            ">;"
        }
    .end annotation
.end field

.field private o:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final p:Landroid/view/GestureDetector;

.field private q:I

.field private r:Lcom/wishabi/flipp/widget/dj;

.field private s:Landroid/animation/AnimatorSet;

.field private t:J

.field private u:I


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 73
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/wishabi/flipp/widget/db;-><init>(Landroid/content/Context;B)V

    .line 74
    return-void
.end method

.method private constructor <init>(Landroid/content/Context;B)V
    .locals 1

    .prologue
    .line 77
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/wishabi/flipp/widget/db;-><init>(Landroid/content/Context;C)V

    .line 78
    return-void
.end method

.method private constructor <init>(Landroid/content/Context;C)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 81
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0, v2}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 62
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/db;->n:Ljava/util/ArrayList;

    .line 68
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/wishabi/flipp/widget/db;->t:J

    .line 84
    const v0, 0x7f03004d

    invoke-static {p1, v0, p0}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 85
    const v0, 0x7f0b011e

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/db;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/db;->b:Landroid/widget/RelativeLayout;

    .line 86
    const v0, 0x7f0b0121

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/db;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/CustomEditText;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/db;->c:Lcom/wishabi/flipp/widget/CustomEditText;

    .line 87
    const v0, 0x7f0b0120

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/db;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/CheckBox;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/db;->d:Landroid/widget/CheckBox;

    .line 88
    const v0, 0x7f0b012c

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/db;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/db;->e:Landroid/widget/TextView;

    .line 89
    const v0, 0x7f0b012d

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/db;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/db;->f:Landroid/widget/TextView;

    .line 91
    const v0, 0x7f0b012b

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/db;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/widget/db;->g:Landroid/view/View;

    .line 92
    const v0, 0x7f0b0124

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/db;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/db;->h:Landroid/widget/TextView;

    .line 93
    const v0, 0x7f0b0123

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/db;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/db;->i:Landroid/widget/ImageView;

    .line 94
    const v0, 0x7f0b0125

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/db;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/db;->j:Landroid/widget/ImageView;

    .line 95
    const v0, 0x7f0b0126

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/db;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/db;->k:Landroid/widget/ProgressBar;

    .line 96
    const v0, 0x7f0b012e

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/db;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/db;->l:Landroid/widget/ImageView;

    .line 97
    const v0, 0x7f0b0122

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/db;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/db;->m:Landroid/widget/LinearLayout;

    .line 98
    iget-object v1, p0, Lcom/wishabi/flipp/widget/db;->n:Ljava/util/ArrayList;

    const v0, 0x7f0b0127

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/db;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 99
    iget-object v1, p0, Lcom/wishabi/flipp/widget/db;->n:Ljava/util/ArrayList;

    const v0, 0x7f0b0128

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/db;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 100
    iget-object v1, p0, Lcom/wishabi/flipp/widget/db;->n:Ljava/util/ArrayList;

    const v0, 0x7f0b0129

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/db;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 101
    iget-object v1, p0, Lcom/wishabi/flipp/widget/db;->n:Ljava/util/ArrayList;

    const v0, 0x7f0b012a

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/db;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 103
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->d:Landroid/widget/CheckBox;

    new-instance v1, Lcom/wishabi/flipp/widget/dc;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/widget/dc;-><init>(Lcom/wishabi/flipp/widget/db;)V

    invoke-virtual {v0, v1}, Landroid/widget/CheckBox;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 114
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->l:Landroid/widget/ImageView;

    new-instance v1, Lcom/wishabi/flipp/widget/dd;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/widget/dd;-><init>(Lcom/wishabi/flipp/widget/db;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 124
    new-instance v0, Landroid/view/GestureDetector;

    new-instance v1, Lcom/wishabi/flipp/widget/de;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/widget/de;-><init>(Lcom/wishabi/flipp/widget/db;)V

    invoke-direct {v0, p1, v1}, Landroid/view/GestureDetector;-><init>(Landroid/content/Context;Landroid/view/GestureDetector$OnGestureListener;)V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/db;->p:Landroid/view/GestureDetector;

    .line 147
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->b:Landroid/widget/RelativeLayout;

    new-instance v1, Lcom/wishabi/flipp/widget/df;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/widget/df;-><init>(Lcom/wishabi/flipp/widget/db;)V

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 154
    iput v2, p0, Lcom/wishabi/flipp/widget/db;->u:I

    .line 155
    sget v0, Lcom/wishabi/flipp/widget/dk;->b:I

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/db;->setState$282bce2c(I)V

    .line 156
    return-void
.end method

.method static synthetic a(Lcom/wishabi/flipp/widget/db;)Lcom/wishabi/flipp/widget/dj;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->r:Lcom/wishabi/flipp/widget/dj;

    return-object v0
.end method

.method static synthetic b(Lcom/wishabi/flipp/widget/db;)I
    .locals 1

    .prologue
    .line 33
    iget v0, p0, Lcom/wishabi/flipp/widget/db;->q:I

    return v0
.end method

.method static synthetic c(Lcom/wishabi/flipp/widget/db;)Landroid/view/GestureDetector;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->p:Landroid/view/GestureDetector;

    return-object v0
.end method

.method static synthetic d(Lcom/wishabi/flipp/widget/db;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->m:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic e(Lcom/wishabi/flipp/widget/db;)Z
    .locals 4

    .prologue
    const/4 v2, 0x0

    .line 33
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->n:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    move v1, v2

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    if-eqz v0, :cond_2

    add-int/lit8 v0, v1, 0x1

    :goto_1
    move v1, v0

    goto :goto_0

    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->o:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ne v1, v0, :cond_1

    const/4 v2, 0x1

    :cond_1
    return v2

    :cond_2
    move v0, v1

    goto :goto_1
.end method

.method static synthetic f(Lcom/wishabi/flipp/widget/db;)Landroid/animation/AnimatorSet;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->s:Landroid/animation/AnimatorSet;

    return-object v0
.end method

.method private setThumbnailsVisible(Z)V
    .locals 3

    .prologue
    .line 473
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->n:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    .line 474
    if-eqz p1, :cond_0

    const/4 v1, 0x0

    :goto_1
    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0

    :cond_0
    const/4 v1, 0x4

    goto :goto_1

    .line 476
    :cond_1
    return-void
.end method


# virtual methods
.method public final a()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 285
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->n:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 286
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/db;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Lcom/a/b/ad;->a(Landroid/content/Context;)Lcom/a/b/ad;

    move-result-object v2

    invoke-virtual {v2, v0}, Lcom/a/b/ad;->a(Ljava/lang/Object;)V

    .line 287
    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0

    .line 290
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->s:Landroid/animation/AnimatorSet;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->s:Landroid/animation/AnimatorSet;

    invoke-virtual {v0}, Landroid/animation/AnimatorSet;->isRunning()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 291
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->s:Landroid/animation/AnimatorSet;

    invoke-virtual {v0}, Landroid/animation/AnimatorSet;->cancel()V

    .line 293
    :cond_1
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/db;->getWidth()I

    move-result v0

    const/high16 v1, -0x80000000

    invoke-static {v0, v1}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v0

    invoke-static {v3, v3}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v1

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/widget/db;->measure(II)V

    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->n:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/db;->getMeasuredHeight()I

    move-result v2

    int-to-float v2, v2

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setTranslationY(F)V

    goto :goto_1

    :cond_2
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->g:Landroid/view/View;

    iget-object v1, p0, Lcom/wishabi/flipp/widget/db;->g:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getMeasuredWidth()I

    move-result v1

    int-to-float v1, v1

    invoke-virtual {v0, v1}, Landroid/view/View;->setTranslationX(F)V

    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->m:Landroid/widget/LinearLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setTranslationX(F)V

    .line 294
    return-void
.end method

.method public final b()V
    .locals 12

    .prologue
    .line 407
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->s:Landroid/animation/AnimatorSet;

    if-eqz v0, :cond_0

    .line 408
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->s:Landroid/animation/AnimatorSet;

    invoke-virtual {v0}, Landroid/animation/AnimatorSet;->cancel()V

    .line 410
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->o:Ljava/util/ArrayList;

    if-nez v0, :cond_2

    .line 411
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->r:Lcom/wishabi/flipp/widget/dj;

    if-eqz v0, :cond_1

    .line 412
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->r:Lcom/wishabi/flipp/widget/dj;

    invoke-interface {v0, p0}, Lcom/wishabi/flipp/widget/dj;->d(Lcom/wishabi/flipp/widget/db;)V

    .line 451
    :cond_1
    :goto_0
    return-void

    .line 416
    :cond_2
    sget v0, Lcom/wishabi/flipp/widget/dk;->b:I

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/db;->setState$282bce2c(I)V

    .line 417
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/db;->a()V

    .line 419
    new-instance v6, Landroid/animation/AnimatorSet;

    invoke-direct {v6}, Landroid/animation/AnimatorSet;-><init>()V

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/db;->getWidth()I

    move-result v0

    const/high16 v1, -0x80000000

    invoke-static {v0, v1}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v0

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-static {v1, v2}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v1

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/widget/db;->measure(II)V

    const-wide/16 v0, 0x0

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/db;->getMeasuredHeight()I

    move-result v2

    int-to-float v7, v2

    const/4 v3, 0x0

    iget-object v2, p0, Lcom/wishabi/flipp/widget/db;->n:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    iget-object v4, p0, Lcom/wishabi/flipp/widget/db;->o:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    sub-int/2addr v2, v4

    move v4, v2

    move-wide v10, v0

    move-object v0, v3

    move-wide v2, v10

    :goto_1
    iget-object v1, p0, Lcom/wishabi/flipp/widget/db;->n:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-ge v4, v1, :cond_3

    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->n:Ljava/util/ArrayList;

    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    const-string v1, "translationY"

    const/4 v5, 0x1

    new-array v5, v5, [F

    const/4 v8, 0x0

    const/4 v9, 0x0

    aput v9, v5, v8

    invoke-static {v0, v1, v5}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v1

    new-instance v5, Landroid/view/animation/DecelerateInterpolator;

    const v8, 0x3fb33333    # 1.4f

    invoke-direct {v5, v8}, Landroid/view/animation/DecelerateInterpolator;-><init>(F)V

    invoke-virtual {v1, v5}, Landroid/animation/ObjectAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    const-string v5, "translationY"

    const/4 v8, 0x1

    new-array v8, v8, [F

    const/4 v9, 0x0

    aput v7, v8, v9

    invoke-static {v0, v5, v8}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v5

    new-instance v0, Landroid/view/animation/AccelerateInterpolator;

    const v8, 0x3fb33333    # 1.4f

    invoke-direct {v0, v8}, Landroid/view/animation/AccelerateInterpolator;-><init>(F)V

    invoke-virtual {v5, v0}, Landroid/animation/ObjectAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    const-wide/16 v8, 0x1c2

    invoke-virtual {v1, v8, v9}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    const-wide/16 v8, 0x1c2

    invoke-virtual {v5, v8, v9}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    const-wide/16 v8, 0xb4

    mul-long/2addr v8, v2

    invoke-virtual {v1, v8, v9}, Landroid/animation/ObjectAnimator;->setStartDelay(J)V

    invoke-virtual {v6, v5}, Landroid/animation/AnimatorSet;->play(Landroid/animation/Animator;)Landroid/animation/AnimatorSet$Builder;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/animation/AnimatorSet$Builder;->after(Landroid/animation/Animator;)Landroid/animation/AnimatorSet$Builder;

    const-wide/16 v0, 0x1

    add-long/2addr v0, v2

    add-int/lit8 v2, v4, 0x1

    move v4, v2

    move-wide v2, v0

    move-object v0, v5

    goto :goto_1

    :cond_3
    iget-object v1, p0, Lcom/wishabi/flipp/widget/db;->g:Landroid/view/View;

    const-string v2, "translationX"

    const/4 v3, 0x2

    new-array v3, v3, [F

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/wishabi/flipp/widget/db;->g:Landroid/view/View;

    invoke-virtual {v5}, Landroid/view/View;->getMeasuredWidth()I

    move-result v5

    int-to-float v5, v5

    aput v5, v3, v4

    const/4 v4, 0x1

    const/4 v5, 0x0

    aput v5, v3, v4

    invoke-static {v1, v2, v3}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v1

    const-wide/16 v2, 0x190

    invoke-virtual {v1, v2, v3}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    if-eqz v0, :cond_5

    invoke-virtual {v6, v1}, Landroid/animation/AnimatorSet;->play(Landroid/animation/Animator;)Landroid/animation/AnimatorSet$Builder;

    move-result-object v2

    invoke-virtual {v2, v0}, Landroid/animation/AnimatorSet$Builder;->after(Landroid/animation/Animator;)Landroid/animation/AnimatorSet$Builder;

    :goto_2
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->g:Landroid/view/View;

    const-string v2, "translationX"

    const/4 v3, 0x1

    new-array v3, v3, [F

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/wishabi/flipp/widget/db;->g:Landroid/view/View;

    invoke-virtual {v5}, Landroid/view/View;->getMeasuredWidth()I

    move-result v5

    int-to-float v5, v5

    aput v5, v3, v4

    invoke-static {v0, v2, v3}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v0

    const-wide/16 v2, 0x1f4

    invoke-virtual {v0, v2, v3}, Landroid/animation/ObjectAnimator;->setStartDelay(J)V

    const-wide/16 v2, 0x190

    invoke-virtual {v0, v2, v3}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    invoke-virtual {v6, v0}, Landroid/animation/AnimatorSet;->play(Landroid/animation/Animator;)Landroid/animation/AnimatorSet$Builder;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/animation/AnimatorSet$Builder;->after(Landroid/animation/Animator;)Landroid/animation/AnimatorSet$Builder;

    const-string v0, "translationX"

    const/4 v2, 0x2

    new-array v2, v2, [F

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/wishabi/flipp/widget/db;->e:Landroid/widget/TextView;

    invoke-virtual {v4}, Landroid/widget/TextView;->getMeasuredWidth()I

    move-result v4

    neg-int v4, v4

    int-to-float v4, v4

    aput v4, v2, v3

    const/4 v3, 0x1

    const/4 v4, 0x0

    aput v4, v2, v3

    invoke-static {v0, v2}, Landroid/animation/PropertyValuesHolder;->ofFloat(Ljava/lang/String;[F)Landroid/animation/PropertyValuesHolder;

    move-result-object v0

    const-string v2, "alpha"

    const/4 v3, 0x2

    new-array v3, v3, [F

    fill-array-data v3, :array_0

    invoke-static {v2, v3}, Landroid/animation/PropertyValuesHolder;->ofFloat(Ljava/lang/String;[F)Landroid/animation/PropertyValuesHolder;

    move-result-object v2

    iget-object v3, p0, Lcom/wishabi/flipp/widget/db;->m:Landroid/widget/LinearLayout;

    const/4 v4, 0x2

    new-array v4, v4, [Landroid/animation/PropertyValuesHolder;

    const/4 v5, 0x0

    aput-object v0, v4, v5

    const/4 v0, 0x1

    aput-object v2, v4, v0

    invoke-static {v3, v4}, Landroid/animation/ObjectAnimator;->ofPropertyValuesHolder(Ljava/lang/Object;[Landroid/animation/PropertyValuesHolder;)Landroid/animation/ObjectAnimator;

    move-result-object v0

    const-wide/16 v2, 0x190

    invoke-virtual {v0, v2, v3}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    const-wide/16 v2, 0x1f4

    invoke-virtual {v0, v2, v3}, Landroid/animation/ObjectAnimator;->setStartDelay(J)V

    invoke-virtual {v6, v0}, Landroid/animation/AnimatorSet;->play(Landroid/animation/Animator;)Landroid/animation/AnimatorSet$Builder;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/animation/AnimatorSet$Builder;->after(Landroid/animation/Animator;)Landroid/animation/AnimatorSet$Builder;

    new-instance v0, Lcom/wishabi/flipp/widget/dg;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/widget/dg;-><init>(Lcom/wishabi/flipp/widget/db;)V

    invoke-virtual {v6, v0}, Landroid/animation/AnimatorSet;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    iput-object v6, p0, Lcom/wishabi/flipp/widget/db;->s:Landroid/animation/AnimatorSet;

    .line 421
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->o:Ljava/util/ArrayList;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->o:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_6

    .line 422
    :cond_4
    sget v0, Lcom/wishabi/flipp/widget/dk;->c:I

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/db;->setState$282bce2c(I)V

    .line 423
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->s:Landroid/animation/AnimatorSet;

    invoke-virtual {v0}, Landroid/animation/AnimatorSet;->start()V

    goto/16 :goto_0

    .line 419
    :cond_5
    invoke-virtual {v6, v1}, Landroid/animation/AnimatorSet;->play(Landroid/animation/Animator;)Landroid/animation/AnimatorSet$Builder;

    goto/16 :goto_2

    .line 427
    :cond_6
    const/4 v0, 0x0

    move v1, v0

    :goto_3
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->o:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_1

    .line 428
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/db;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/a/b/ad;->a(Landroid/content/Context;)Lcom/a/b/ad;

    move-result-object v2

    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->o:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v2, v0}, Lcom/a/b/ad;->a(Ljava/lang/String;)Lcom/a/b/aq;

    move-result-object v2

    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->n:Ljava/util/ArrayList;

    iget-object v3, p0, Lcom/wishabi/flipp/widget/db;->n:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    sub-int/2addr v3, v1

    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    new-instance v3, Lcom/wishabi/flipp/widget/dh;

    invoke-direct {v3, p0}, Lcom/wishabi/flipp/widget/dh;-><init>(Lcom/wishabi/flipp/widget/db;)V

    invoke-virtual {v2, v0, v3}, Lcom/a/b/aq;->a(Landroid/widget/ImageView;Lcom/a/b/j;)V

    .line 427
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_3

    .line 419
    :array_0
    .array-data 4
        0x0
        0x3f800000    # 1.0f
    .end array-data
.end method

.method public final getChecked()Z
    .locals 1

    .prologue
    .line 160
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->d:Landroid/widget/CheckBox;

    invoke-virtual {v0}, Landroid/widget/CheckBox;->isChecked()Z

    move-result v0

    return v0
.end method

.method public final getClipCount()I
    .locals 1

    .prologue
    .line 195
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->h:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public final getListener()Lcom/wishabi/flipp/widget/dj;
    .locals 1

    .prologue
    .line 458
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->r:Lcom/wishabi/flipp/widget/dj;

    return-object v0
.end method

.method public final getLongTag()J
    .locals 2

    .prologue
    .line 170
    iget-wide v0, p0, Lcom/wishabi/flipp/widget/db;->t:J

    return-wide v0
.end method

.method public final getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 158
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->c:Lcom/wishabi/flipp/widget/CustomEditText;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CustomEditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final getResultCount()I
    .locals 1

    .prologue
    .line 177
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->e:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public final getState$1599ee8e()I
    .locals 1

    .prologue
    .line 212
    iget v0, p0, Lcom/wishabi/flipp/widget/db;->q:I

    return v0
.end method

.method public final getThumbnailUrls()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 172
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->o:Ljava/util/ArrayList;

    return-object v0
.end method

.method protected final onLayout(ZIIII)V
    .locals 2

    .prologue
    .line 299
    invoke-super/range {p0 .. p5}, Landroid/widget/FrameLayout;->onLayout(ZIIII)V

    .line 301
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->c:Lcom/wishabi/flipp/widget/CustomEditText;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CustomEditText;->getRight()I

    move-result v0

    iget-object v1, p0, Lcom/wishabi/flipp/widget/db;->m:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->getLeft()I

    move-result v1

    if-le v0, v1, :cond_0

    .line 302
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->c:Lcom/wishabi/flipp/widget/CustomEditText;

    iget-object v1, p0, Lcom/wishabi/flipp/widget/db;->m:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->getLeft()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/CustomEditText;->setRight(I)V

    .line 303
    :cond_0
    return-void
.end method

.method public final setChecked(Z)V
    .locals 4

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 162
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->d:Landroid/widget/CheckBox;

    invoke-virtual {v0, p1}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 163
    iget-object v3, p0, Lcom/wishabi/flipp/widget/db;->c:Lcom/wishabi/flipp/widget/CustomEditText;

    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->c:Lcom/wishabi/flipp/widget/CustomEditText;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CustomEditText;->getPaintFlags()I

    move-result v0

    or-int/lit8 v0, v0, 0x10

    :goto_0
    invoke-virtual {v3, v0}, Lcom/wishabi/flipp/widget/CustomEditText;->setPaintFlags(I)V

    .line 167
    iget-object v3, p0, Lcom/wishabi/flipp/widget/db;->c:Lcom/wishabi/flipp/widget/CustomEditText;

    if-nez p1, :cond_1

    move v0, v1

    :goto_1
    invoke-virtual {v3, v0}, Lcom/wishabi/flipp/widget/CustomEditText;->setFocusableInTouchMode(Z)V

    .line 168
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->c:Lcom/wishabi/flipp/widget/CustomEditText;

    if-nez p1, :cond_2

    :goto_2
    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/CustomEditText;->setFocusable(Z)V

    .line 169
    return-void

    .line 163
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->c:Lcom/wishabi/flipp/widget/CustomEditText;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CustomEditText;->getPaintFlags()I

    move-result v0

    and-int/lit8 v0, v0, -0x11

    goto :goto_0

    :cond_1
    move v0, v2

    .line 167
    goto :goto_1

    :cond_2
    move v1, v2

    .line 168
    goto :goto_2
.end method

.method public final setClipCount(I)V
    .locals 2

    .prologue
    .line 199
    iput p1, p0, Lcom/wishabi/flipp/widget/db;->u:I

    .line 200
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->h:Landroid/widget/TextView;

    invoke-static {p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 201
    return-void
.end method

.method public final setListener(Lcom/wishabi/flipp/widget/dj;)V
    .locals 0

    .prologue
    .line 454
    iput-object p1, p0, Lcom/wishabi/flipp/widget/db;->r:Lcom/wishabi/flipp/widget/dj;

    .line 455
    return-void
.end method

.method public final setLongTag(J)V
    .locals 1

    .prologue
    .line 171
    iput-wide p1, p0, Lcom/wishabi/flipp/widget/db;->t:J

    return-void
.end method

.method public final setName(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 159
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->c:Lcom/wishabi/flipp/widget/CustomEditText;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/CustomEditText;->setText(Ljava/lang/CharSequence;)V

    return-void
.end method

.method public final setResultCount(I)V
    .locals 2

    .prologue
    .line 181
    if-nez p1, :cond_0

    .line 182
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->f:Landroid/widget/TextView;

    const v1, 0x7f0e0133

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 191
    :goto_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->e:Landroid/widget/TextView;

    invoke-static {p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 192
    return-void

    .line 184
    :cond_0
    const/4 v0, 0x1

    if-ne p1, v0, :cond_1

    .line 185
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->f:Landroid/widget/TextView;

    const v1, 0x7f0e0131

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    goto :goto_0

    .line 188
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->f:Landroid/widget/TextView;

    const v1, 0x7f0e0132

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    goto :goto_0
.end method

.method public final setState$282bce2c(I)V
    .locals 6

    .prologue
    const/high16 v5, 0x3f800000    # 1.0f

    const/4 v4, 0x1

    const/4 v1, 0x0

    const/4 v2, 0x4

    .line 216
    iput p1, p0, Lcom/wishabi/flipp/widget/db;->q:I

    .line 218
    sget-object v0, Lcom/wishabi/flipp/widget/di;->a:[I

    iget v3, p0, Lcom/wishabi/flipp/widget/db;->q:I

    add-int/lit8 v3, v3, -0x1

    aget v0, v0, v3

    packed-switch v0, :pswitch_data_0

    .line 280
    new-instance v0, Ljava/security/InvalidParameterException;

    const-string v1, "Invalid shopping cell state"

    invoke-direct {v0, v1}, Ljava/security/InvalidParameterException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 220
    :pswitch_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->b:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v4}, Landroid/widget/RelativeLayout;->setClickable(Z)V

    .line 221
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->p:Landroid/view/GestureDetector;

    invoke-virtual {v0, v4}, Landroid/view/GestureDetector;->setIsLongpressEnabled(Z)V

    .line 222
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->d:Landroid/widget/CheckBox;

    invoke-virtual {v0, v4}, Landroid/widget/CheckBox;->setEnabled(Z)V

    .line 223
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->k:Landroid/widget/ProgressBar;

    invoke-virtual {v0, v2}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 224
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->c:Lcom/wishabi/flipp/widget/CustomEditText;

    invoke-virtual {v0, v4}, Lcom/wishabi/flipp/widget/CustomEditText;->setEnabled(Z)V

    .line 225
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->j:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 226
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->m:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 227
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->m:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v5}, Landroid/widget/LinearLayout;->setAlpha(F)V

    .line 228
    iget-object v3, p0, Lcom/wishabi/flipp/widget/db;->h:Landroid/widget/TextView;

    iget v0, p0, Lcom/wishabi/flipp/widget/db;->u:I

    if-lez v0, :cond_0

    move v0, v1

    :goto_0
    invoke-virtual {v3, v0}, Landroid/widget/TextView;->setVisibility(I)V

    .line 229
    iget-object v3, p0, Lcom/wishabi/flipp/widget/db;->i:Landroid/widget/ImageView;

    iget v0, p0, Lcom/wishabi/flipp/widget/db;->u:I

    if-lez v0, :cond_1

    move v0, v1

    :goto_1
    invoke-virtual {v3, v0}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 230
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->l:Landroid/widget/ImageView;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 231
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->g:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 232
    invoke-direct {p0, v1}, Lcom/wishabi/flipp/widget/db;->setThumbnailsVisible(Z)V

    .line 278
    :goto_2
    return-void

    :cond_0
    move v0, v2

    .line 228
    goto :goto_0

    :cond_1
    move v0, v2

    .line 229
    goto :goto_1

    .line 235
    :pswitch_1
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->b:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v4}, Landroid/widget/RelativeLayout;->setClickable(Z)V

    .line 236
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->p:Landroid/view/GestureDetector;

    invoke-virtual {v0, v4}, Landroid/view/GestureDetector;->setIsLongpressEnabled(Z)V

    .line 237
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->d:Landroid/widget/CheckBox;

    invoke-virtual {v0, v4}, Landroid/widget/CheckBox;->setEnabled(Z)V

    .line 238
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->k:Landroid/widget/ProgressBar;

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 239
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->c:Lcom/wishabi/flipp/widget/CustomEditText;

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/CustomEditText;->setEnabled(Z)V

    .line 240
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->j:Landroid/widget/ImageView;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 241
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->m:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 242
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->m:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v5}, Landroid/widget/LinearLayout;->setAlpha(F)V

    .line 243
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->h:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 244
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->i:Landroid/widget/ImageView;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 245
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->l:Landroid/widget/ImageView;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 246
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->g:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 247
    invoke-direct {p0, v1}, Lcom/wishabi/flipp/widget/db;->setThumbnailsVisible(Z)V

    goto :goto_2

    .line 250
    :pswitch_2
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->b:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v4}, Landroid/widget/RelativeLayout;->setClickable(Z)V

    .line 251
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->p:Landroid/view/GestureDetector;

    invoke-virtual {v0, v4}, Landroid/view/GestureDetector;->setIsLongpressEnabled(Z)V

    .line 252
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->d:Landroid/widget/CheckBox;

    invoke-virtual {v0, v4}, Landroid/widget/CheckBox;->setEnabled(Z)V

    .line 253
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->k:Landroid/widget/ProgressBar;

    invoke-virtual {v0, v2}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 254
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->c:Lcom/wishabi/flipp/widget/CustomEditText;

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/CustomEditText;->setEnabled(Z)V

    .line 255
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->j:Landroid/widget/ImageView;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 256
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->m:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 257
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->m:Landroid/widget/LinearLayout;

    const/4 v3, 0x0

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->setAlpha(F)V

    .line 258
    iget-object v3, p0, Lcom/wishabi/flipp/widget/db;->h:Landroid/widget/TextView;

    iget v0, p0, Lcom/wishabi/flipp/widget/db;->u:I

    if-lez v0, :cond_2

    move v0, v1

    :goto_3
    invoke-virtual {v3, v0}, Landroid/widget/TextView;->setVisibility(I)V

    .line 259
    iget-object v3, p0, Lcom/wishabi/flipp/widget/db;->i:Landroid/widget/ImageView;

    iget v0, p0, Lcom/wishabi/flipp/widget/db;->u:I

    if-lez v0, :cond_3

    move v0, v1

    :goto_4
    invoke-virtual {v3, v0}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 260
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->l:Landroid/widget/ImageView;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 261
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->g:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 262
    invoke-direct {p0, v4}, Lcom/wishabi/flipp/widget/db;->setThumbnailsVisible(Z)V

    goto/16 :goto_2

    :cond_2
    move v0, v2

    .line 258
    goto :goto_3

    :cond_3
    move v0, v2

    .line 259
    goto :goto_4

    .line 265
    :pswitch_3
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->b:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setClickable(Z)V

    .line 266
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->p:Landroid/view/GestureDetector;

    invoke-virtual {v0, v1}, Landroid/view/GestureDetector;->setIsLongpressEnabled(Z)V

    .line 267
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->d:Landroid/widget/CheckBox;

    invoke-virtual {v0, v1}, Landroid/widget/CheckBox;->setEnabled(Z)V

    .line 268
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->k:Landroid/widget/ProgressBar;

    invoke-virtual {v0, v2}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 269
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->c:Lcom/wishabi/flipp/widget/CustomEditText;

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/CustomEditText;->setEnabled(Z)V

    .line 270
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->j:Landroid/widget/ImageView;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 271
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->m:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 272
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->m:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v5}, Landroid/widget/LinearLayout;->setAlpha(F)V

    .line 273
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->h:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 274
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->i:Landroid/widget/ImageView;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 275
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->l:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 276
    iget-object v0, p0, Lcom/wishabi/flipp/widget/db;->g:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 277
    invoke-direct {p0, v1}, Lcom/wishabi/flipp/widget/db;->setThumbnailsVisible(Z)V

    goto/16 :goto_2

    .line 218
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public final setSubmitted(Z)V
    .locals 0

    .prologue
    .line 208
    iput-boolean p1, p0, Lcom/wishabi/flipp/widget/db;->a:Z

    .line 209
    return-void
.end method

.method public final setThumbnailUrls(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 174
    iput-object p1, p0, Lcom/wishabi/flipp/widget/db;->o:Ljava/util/ArrayList;

    return-void
.end method

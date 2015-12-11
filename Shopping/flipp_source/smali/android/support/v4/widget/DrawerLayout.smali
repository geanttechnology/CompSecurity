.class public Landroid/support/v4/widget/DrawerLayout;
.super Landroid/view/ViewGroup;
.source "SourceFile"

# interfaces
.implements Landroid/support/v4/widget/m;


# static fields
.field static final h:Landroid/support/v4/widget/c;

.field private static final i:[I

.field private static final j:Z


# instance fields
.field private A:Landroid/graphics/drawable/Drawable;

.field private B:Ljava/lang/Object;

.field private C:Z

.field final a:Landroid/support/v4/widget/ah;

.field final b:Landroid/support/v4/widget/ah;

.field c:I

.field d:Z

.field e:Landroid/support/v4/widget/f;

.field f:Ljava/lang/CharSequence;

.field g:Ljava/lang/CharSequence;

.field private final k:Landroid/support/v4/widget/b;

.field private l:I

.field private m:I

.field private n:F

.field private o:Landroid/graphics/Paint;

.field private final p:Landroid/support/v4/widget/i;

.field private final q:Landroid/support/v4/widget/i;

.field private r:Z

.field private s:Z

.field private t:I

.field private u:I

.field private v:Z

.field private w:F

.field private x:F

.field private y:Landroid/graphics/drawable/Drawable;

.field private z:Landroid/graphics/drawable/Drawable;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 159
    new-array v2, v0, [I

    const v3, 0x10100b3

    aput v3, v2, v1

    sput-object v2, Landroid/support/v4/widget/DrawerLayout;->i:[I

    .line 164
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0x13

    if-lt v2, v3, :cond_0

    :goto_0
    sput-boolean v0, Landroid/support/v4/widget/DrawerLayout;->j:Z

    .line 303
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 304
    const/16 v1, 0x15

    if-lt v0, v1, :cond_1

    .line 305
    new-instance v0, Landroid/support/v4/widget/d;

    invoke-direct {v0}, Landroid/support/v4/widget/d;-><init>()V

    sput-object v0, Landroid/support/v4/widget/DrawerLayout;->h:Landroid/support/v4/widget/c;

    .line 309
    :goto_1
    return-void

    :cond_0
    move v0, v1

    .line 164
    goto :goto_0

    .line 307
    :cond_1
    new-instance v0, Landroid/support/v4/widget/e;

    invoke-direct {v0}, Landroid/support/v4/widget/e;-><init>()V

    sput-object v0, Landroid/support/v4/widget/DrawerLayout;->h:Landroid/support/v4/widget/c;

    goto :goto_1
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 314
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroid/support/v4/widget/DrawerLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 315
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .prologue
    .line 318
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Landroid/support/v4/widget/DrawerLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 319
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 322
    invoke-direct {p0, p1, p2, p3}, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 166
    new-instance v0, Landroid/support/v4/widget/b;

    invoke-direct {v0, p0}, Landroid/support/v4/widget/b;-><init>(Landroid/support/v4/widget/DrawerLayout;)V

    iput-object v0, p0, Landroid/support/v4/widget/DrawerLayout;->k:Landroid/support/v4/widget/b;

    .line 171
    const/high16 v0, -0x67000000

    iput v0, p0, Landroid/support/v4/widget/DrawerLayout;->m:I

    .line 173
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Landroid/support/v4/widget/DrawerLayout;->o:Landroid/graphics/Paint;

    .line 181
    iput-boolean v3, p0, Landroid/support/v4/widget/DrawerLayout;->s:Z

    .line 323
    const/high16 v0, 0x40000

    invoke-virtual {p0, v0}, Landroid/support/v4/widget/DrawerLayout;->setDescendantFocusability(I)V

    .line 324
    invoke-virtual {p0}, Landroid/support/v4/widget/DrawerLayout;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->density:F

    .line 325
    const/high16 v1, 0x42800000    # 64.0f

    mul-float/2addr v1, v0

    const/high16 v2, 0x3f000000    # 0.5f

    add-float/2addr v1, v2

    float-to-int v1, v1

    iput v1, p0, Landroid/support/v4/widget/DrawerLayout;->l:I

    .line 326
    const/high16 v1, 0x43c80000    # 400.0f

    mul-float/2addr v0, v1

    .line 328
    new-instance v1, Landroid/support/v4/widget/i;

    const/4 v2, 0x3

    invoke-direct {v1, p0, v2}, Landroid/support/v4/widget/i;-><init>(Landroid/support/v4/widget/DrawerLayout;I)V

    iput-object v1, p0, Landroid/support/v4/widget/DrawerLayout;->p:Landroid/support/v4/widget/i;

    .line 329
    new-instance v1, Landroid/support/v4/widget/i;

    const/4 v2, 0x5

    invoke-direct {v1, p0, v2}, Landroid/support/v4/widget/i;-><init>(Landroid/support/v4/widget/DrawerLayout;I)V

    iput-object v1, p0, Landroid/support/v4/widget/DrawerLayout;->q:Landroid/support/v4/widget/i;

    .line 331
    iget-object v1, p0, Landroid/support/v4/widget/DrawerLayout;->p:Landroid/support/v4/widget/i;

    invoke-static {p0, v1}, Landroid/support/v4/widget/ah;->a(Landroid/view/ViewGroup;Landroid/support/v4/widget/ak;)Landroid/support/v4/widget/ah;

    move-result-object v1

    iput-object v1, p0, Landroid/support/v4/widget/DrawerLayout;->a:Landroid/support/v4/widget/ah;

    .line 332
    iget-object v1, p0, Landroid/support/v4/widget/DrawerLayout;->a:Landroid/support/v4/widget/ah;

    iput v3, v1, Landroid/support/v4/widget/ah;->l:I

    .line 333
    iget-object v1, p0, Landroid/support/v4/widget/DrawerLayout;->a:Landroid/support/v4/widget/ah;

    iput v0, v1, Landroid/support/v4/widget/ah;->j:F

    .line 334
    iget-object v1, p0, Landroid/support/v4/widget/DrawerLayout;->p:Landroid/support/v4/widget/i;

    iget-object v2, p0, Landroid/support/v4/widget/DrawerLayout;->a:Landroid/support/v4/widget/ah;

    iput-object v2, v1, Landroid/support/v4/widget/i;->b:Landroid/support/v4/widget/ah;

    .line 336
    iget-object v1, p0, Landroid/support/v4/widget/DrawerLayout;->q:Landroid/support/v4/widget/i;

    invoke-static {p0, v1}, Landroid/support/v4/widget/ah;->a(Landroid/view/ViewGroup;Landroid/support/v4/widget/ak;)Landroid/support/v4/widget/ah;

    move-result-object v1

    iput-object v1, p0, Landroid/support/v4/widget/DrawerLayout;->b:Landroid/support/v4/widget/ah;

    .line 337
    iget-object v1, p0, Landroid/support/v4/widget/DrawerLayout;->b:Landroid/support/v4/widget/ah;

    const/4 v2, 0x2

    iput v2, v1, Landroid/support/v4/widget/ah;->l:I

    .line 338
    iget-object v1, p0, Landroid/support/v4/widget/DrawerLayout;->b:Landroid/support/v4/widget/ah;

    iput v0, v1, Landroid/support/v4/widget/ah;->j:F

    .line 339
    iget-object v0, p0, Landroid/support/v4/widget/DrawerLayout;->q:Landroid/support/v4/widget/i;

    iget-object v1, p0, Landroid/support/v4/widget/DrawerLayout;->b:Landroid/support/v4/widget/ah;

    iput-object v1, v0, Landroid/support/v4/widget/i;->b:Landroid/support/v4/widget/ah;

    .line 342
    invoke-virtual {p0, v3}, Landroid/support/v4/widget/DrawerLayout;->setFocusableInTouchMode(Z)V

    .line 344
    invoke-static {p0, v3}, Landroid/support/v4/view/ap;->c(Landroid/view/View;I)V

    .line 347
    new-instance v0, Landroid/support/v4/widget/a;

    invoke-direct {v0, p0}, Landroid/support/v4/widget/a;-><init>(Landroid/support/v4/widget/DrawerLayout;)V

    invoke-static {p0, v0}, Landroid/support/v4/view/ap;->a(Landroid/view/View;Landroid/support/v4/view/a;)V

    .line 348
    invoke-static {p0}, Landroid/support/v4/view/bn;->a(Landroid/view/ViewGroup;)V

    .line 349
    invoke-static {p0}, Landroid/support/v4/view/ap;->p(Landroid/view/View;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 350
    sget-object v0, Landroid/support/v4/widget/DrawerLayout;->h:Landroid/support/v4/widget/c;

    invoke-interface {v0, p0}, Landroid/support/v4/widget/c;->a(Landroid/view/View;)V

    .line 352
    :cond_0
    return-void
.end method

.method static synthetic a(Landroid/support/v4/widget/DrawerLayout;)Landroid/view/View;
    .locals 1

    .prologue
    .line 86
    invoke-direct {p0}, Landroid/support/v4/widget/DrawerLayout;->e()Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method private a(II)V
    .locals 3

    .prologue
    const/4 v2, 0x3

    .line 461
    invoke-static {p0}, Landroid/support/v4/view/ap;->h(Landroid/view/View;)I

    move-result v0

    invoke-static {p2, v0}, Landroid/support/v4/view/n;->a(II)I

    move-result v1

    .line 463
    if-ne v1, v2, :cond_3

    .line 464
    iput p1, p0, Landroid/support/v4/widget/DrawerLayout;->t:I

    .line 468
    :cond_0
    :goto_0
    if-eqz p1, :cond_1

    .line 470
    if-ne v1, v2, :cond_4

    iget-object v0, p0, Landroid/support/v4/widget/DrawerLayout;->a:Landroid/support/v4/widget/ah;

    .line 471
    :goto_1
    invoke-virtual {v0}, Landroid/support/v4/widget/ah;->a()V

    .line 473
    :cond_1
    packed-switch p1, :pswitch_data_0

    .line 488
    :cond_2
    :goto_2
    return-void

    .line 465
    :cond_3
    const/4 v0, 0x5

    if-ne v1, v0, :cond_0

    .line 466
    iput p1, p0, Landroid/support/v4/widget/DrawerLayout;->u:I

    goto :goto_0

    .line 470
    :cond_4
    iget-object v0, p0, Landroid/support/v4/widget/DrawerLayout;->b:Landroid/support/v4/widget/ah;

    goto :goto_1

    .line 475
    :pswitch_0
    invoke-virtual {p0, v1}, Landroid/support/v4/widget/DrawerLayout;->a(I)Landroid/view/View;

    move-result-object v0

    .line 476
    if-eqz v0, :cond_2

    .line 477
    invoke-virtual {p0, v0}, Landroid/support/v4/widget/DrawerLayout;->e(Landroid/view/View;)V

    goto :goto_2

    .line 481
    :pswitch_1
    invoke-virtual {p0, v1}, Landroid/support/v4/widget/DrawerLayout;->a(I)Landroid/view/View;

    move-result-object v0

    .line 482
    if-eqz v0, :cond_2

    .line 483
    invoke-virtual {p0, v0}, Landroid/support/v4/widget/DrawerLayout;->f(Landroid/view/View;)V

    goto :goto_2

    .line 473
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method static b(Landroid/view/View;)F
    .locals 1

    .prologue
    .line 699
    invoke-virtual {p0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/v4/widget/g;

    iget v0, v0, Landroid/support/v4/widget/g;->b:F

    return v0
.end method

.method public static b(I)Ljava/lang/String;
    .locals 2

    .prologue
    .line 766
    and-int/lit8 v0, p0, 0x3

    const/4 v1, 0x3

    if-ne v0, v1, :cond_0

    .line 767
    const-string v0, "LEFT"

    .line 772
    :goto_0
    return-object v0

    .line 769
    :cond_0
    and-int/lit8 v0, p0, 0x5

    const/4 v1, 0x5

    if-ne v0, v1, :cond_1

    .line 770
    const-string v0, "RIGHT"

    goto :goto_0

    .line 772
    :cond_1
    invoke-static {p0}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method static synthetic b()[I
    .locals 1

    .prologue
    .line 86
    sget-object v0, Landroid/support/v4/widget/DrawerLayout;->i:[I

    return-object v0
.end method

.method static synthetic c()Z
    .locals 1

    .prologue
    .line 86
    sget-boolean v0, Landroid/support/v4/widget/DrawerLayout;->j:Z

    return v0
.end method

.method private d()Landroid/view/View;
    .locals 4

    .prologue
    .line 717
    invoke-virtual {p0}, Landroid/support/v4/widget/DrawerLayout;->getChildCount()I

    move-result v3

    .line 718
    const/4 v0, 0x0

    move v2, v0

    :goto_0
    if-ge v2, v3, :cond_1

    .line 719
    invoke-virtual {p0, v2}, Landroid/support/v4/widget/DrawerLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 720
    invoke-virtual {v1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/v4/widget/g;

    iget-boolean v0, v0, Landroid/support/v4/widget/g;->d:Z

    if-eqz v0, :cond_0

    move-object v0, v1

    .line 724
    :goto_1
    return-object v0

    .line 718
    :cond_0
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_0

    .line 724
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method static d(Landroid/view/View;)Z
    .locals 2

    .prologue
    .line 1100
    invoke-virtual {p0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/v4/widget/g;

    iget v0, v0, Landroid/support/v4/widget/g;->a:I

    .line 1101
    invoke-static {p0}, Landroid/support/v4/view/ap;->h(Landroid/view/View;)I

    move-result v1

    invoke-static {v0, v1}, Landroid/support/v4/view/n;->a(II)I

    move-result v0

    .line 1103
    and-int/lit8 v0, v0, 0x7

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private e()Landroid/view/View;
    .locals 4

    .prologue
    .line 1444
    invoke-virtual {p0}, Landroid/support/v4/widget/DrawerLayout;->getChildCount()I

    move-result v2

    .line 1445
    const/4 v0, 0x0

    move v1, v0

    :goto_0
    if-ge v1, v2, :cond_1

    .line 1446
    invoke-virtual {p0, v1}, Landroid/support/v4/widget/DrawerLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 1447
    invoke-static {v0}, Landroid/support/v4/widget/DrawerLayout;->d(Landroid/view/View;)Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-static {v0}, Landroid/support/v4/widget/DrawerLayout;->g(Landroid/view/View;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 1451
    :goto_1
    return-object v0

    .line 1445
    :cond_0
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 1451
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public static g(Landroid/view/View;)Z
    .locals 3

    .prologue
    .line 1382
    invoke-static {p0}, Landroid/support/v4/widget/DrawerLayout;->d(Landroid/view/View;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1383
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "View "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " is not a drawer"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1385
    :cond_0
    invoke-virtual {p0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/v4/widget/g;

    iget v0, v0, Landroid/support/v4/widget/g;->b:F

    const/4 v1, 0x0

    cmpl-float v0, v0, v1

    if-lez v0, :cond_1

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method static synthetic h(Landroid/view/View;)Z
    .locals 2

    .prologue
    .line 86
    invoke-static {p0}, Landroid/support/v4/view/ap;->e(Landroid/view/View;)I

    move-result v0

    const/4 v1, 0x4

    if-eq v0, v1, :cond_0

    invoke-static {p0}, Landroid/support/v4/view/ap;->e(Landroid/view/View;)I

    move-result v0

    const/4 v1, 0x2

    if-eq v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static i(Landroid/view/View;)Z
    .locals 1

    .prologue
    .line 1096
    invoke-virtual {p0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/v4/widget/g;

    iget v0, v0, Landroid/support/v4/widget/g;->a:I

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public final a(Landroid/view/View;)I
    .locals 2

    .prologue
    .line 545
    invoke-virtual {p0, p1}, Landroid/support/v4/widget/DrawerLayout;->c(Landroid/view/View;)I

    move-result v0

    .line 546
    const/4 v1, 0x3

    if-ne v0, v1, :cond_0

    .line 547
    iget v0, p0, Landroid/support/v4/widget/DrawerLayout;->t:I

    .line 551
    :goto_0
    return v0

    .line 548
    :cond_0
    const/4 v1, 0x5

    if-ne v0, v1, :cond_1

    .line 549
    iget v0, p0, Landroid/support/v4/widget/DrawerLayout;->u:I

    goto :goto_0

    .line 551
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final a(I)Landroid/view/View;
    .locals 5

    .prologue
    .line 746
    invoke-static {p0}, Landroid/support/v4/view/ap;->h(Landroid/view/View;)I

    move-result v0

    invoke-static {p1, v0}, Landroid/support/v4/view/n;->a(II)I

    move-result v0

    and-int/lit8 v2, v0, 0x7

    .line 748
    invoke-virtual {p0}, Landroid/support/v4/widget/DrawerLayout;->getChildCount()I

    move-result v3

    .line 749
    const/4 v0, 0x0

    move v1, v0

    :goto_0
    if-ge v1, v3, :cond_1

    .line 750
    invoke-virtual {p0, v1}, Landroid/support/v4/widget/DrawerLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 751
    invoke-virtual {p0, v0}, Landroid/support/v4/widget/DrawerLayout;->c(Landroid/view/View;)I

    move-result v4

    .line 752
    and-int/lit8 v4, v4, 0x7

    if-ne v4, v2, :cond_0

    .line 756
    :goto_1
    return-object v0

    .line 749
    :cond_0
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 756
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method final a(Landroid/view/View;F)V
    .locals 2

    .prologue
    .line 689
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/v4/widget/g;

    .line 690
    iget v1, v0, Landroid/support/v4/widget/g;->b:F

    cmpl-float v1, p2, v1

    if-nez v1, :cond_1

    .line 696
    :cond_0
    :goto_0
    return-void

    .line 694
    :cond_1
    iput p2, v0, Landroid/support/v4/widget/g;->b:F

    .line 695
    iget-object v0, p0, Landroid/support/v4/widget/DrawerLayout;->e:Landroid/support/v4/widget/f;

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v4/widget/DrawerLayout;->e:Landroid/support/v4/widget/f;

    invoke-interface {v0, p2}, Landroid/support/v4/widget/f;->a(F)V

    goto :goto_0
.end method

.method final a(Landroid/view/View;Z)V
    .locals 4

    .prologue
    .line 666
    invoke-virtual {p0}, Landroid/support/v4/widget/DrawerLayout;->getChildCount()I

    move-result v1

    .line 667
    const/4 v0, 0x0

    :goto_0
    if-ge v0, v1, :cond_3

    .line 668
    invoke-virtual {p0, v0}, Landroid/support/v4/widget/DrawerLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .line 669
    if-nez p2, :cond_0

    invoke-static {v2}, Landroid/support/v4/widget/DrawerLayout;->d(Landroid/view/View;)Z

    move-result v3

    if-eqz v3, :cond_1

    :cond_0
    if-eqz p2, :cond_2

    if-ne v2, p1, :cond_2

    .line 673
    :cond_1
    const/4 v3, 0x1

    invoke-static {v2, v3}, Landroid/support/v4/view/ap;->c(Landroid/view/View;I)V

    .line 667
    :goto_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 676
    :cond_2
    const/4 v3, 0x4

    invoke-static {v2, v3}, Landroid/support/v4/view/ap;->c(Landroid/view/View;I)V

    goto :goto_1

    .line 680
    :cond_3
    return-void
.end method

.method public final a(Ljava/lang/Object;Z)V
    .locals 1

    .prologue
    .line 360
    iput-object p1, p0, Landroid/support/v4/widget/DrawerLayout;->B:Ljava/lang/Object;

    .line 361
    iput-boolean p2, p0, Landroid/support/v4/widget/DrawerLayout;->C:Z

    .line 362
    if-nez p2, :cond_0

    invoke-virtual {p0}, Landroid/support/v4/widget/DrawerLayout;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {p0, v0}, Landroid/support/v4/widget/DrawerLayout;->setWillNotDraw(Z)V

    .line 363
    invoke-virtual {p0}, Landroid/support/v4/widget/DrawerLayout;->requestLayout()V

    .line 364
    return-void

    .line 362
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final a(Z)V
    .locals 9

    .prologue
    const/4 v3, 0x0

    .line 1226
    .line 1227
    invoke-virtual {p0}, Landroid/support/v4/widget/DrawerLayout;->getChildCount()I

    move-result v4

    move v2, v3

    move v1, v3

    .line 1228
    :goto_0
    if-ge v2, v4, :cond_3

    .line 1229
    invoke-virtual {p0, v2}, Landroid/support/v4/widget/DrawerLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v5

    .line 1230
    invoke-virtual {v5}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/v4/widget/g;

    .line 1232
    invoke-static {v5}, Landroid/support/v4/widget/DrawerLayout;->d(Landroid/view/View;)Z

    move-result v6

    if-eqz v6, :cond_1

    if-eqz p1, :cond_0

    iget-boolean v6, v0, Landroid/support/v4/widget/g;->c:Z

    if-eqz v6, :cond_1

    .line 1233
    :cond_0
    invoke-virtual {v5}, Landroid/view/View;->getWidth()I

    move-result v6

    .line 1238
    const/4 v7, 0x3

    invoke-virtual {p0, v5, v7}, Landroid/support/v4/widget/DrawerLayout;->a(Landroid/view/View;I)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 1239
    iget-object v7, p0, Landroid/support/v4/widget/DrawerLayout;->a:Landroid/support/v4/widget/ah;

    neg-int v6, v6

    invoke-virtual {v5}, Landroid/view/View;->getTop()I

    move-result v8

    invoke-virtual {v7, v5, v6, v8}, Landroid/support/v4/widget/ah;->a(Landroid/view/View;II)Z

    move-result v5

    or-int/2addr v1, v5

    .line 1246
    :goto_1
    iput-boolean v3, v0, Landroid/support/v4/widget/g;->c:Z

    .line 1228
    :cond_1
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_0

    .line 1242
    :cond_2
    iget-object v6, p0, Landroid/support/v4/widget/DrawerLayout;->b:Landroid/support/v4/widget/ah;

    invoke-virtual {p0}, Landroid/support/v4/widget/DrawerLayout;->getWidth()I

    move-result v7

    invoke-virtual {v5}, Landroid/view/View;->getTop()I

    move-result v8

    invoke-virtual {v6, v5, v7, v8}, Landroid/support/v4/widget/ah;->a(Landroid/view/View;II)Z

    move-result v5

    or-int/2addr v1, v5

    goto :goto_1

    .line 1249
    :cond_3
    iget-object v0, p0, Landroid/support/v4/widget/DrawerLayout;->p:Landroid/support/v4/widget/i;

    invoke-virtual {v0}, Landroid/support/v4/widget/i;->a()V

    .line 1250
    iget-object v0, p0, Landroid/support/v4/widget/DrawerLayout;->q:Landroid/support/v4/widget/i;

    invoke-virtual {v0}, Landroid/support/v4/widget/i;->a()V

    .line 1252
    if-eqz v1, :cond_4

    .line 1253
    invoke-virtual {p0}, Landroid/support/v4/widget/DrawerLayout;->invalidate()V

    .line 1255
    :cond_4
    return-void
.end method

.method public final a()Z
    .locals 4

    .prologue
    .line 1366
    const v0, 0x800003

    invoke-virtual {p0, v0}, Landroid/support/v4/widget/DrawerLayout;->a(I)Landroid/view/View;

    move-result-object v0

    .line 1367
    if-eqz v0, :cond_1

    .line 1368
    invoke-static {v0}, Landroid/support/v4/widget/DrawerLayout;->d(Landroid/view/View;)Z

    move-result v1

    if-nez v1, :cond_0

    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "View "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, " is not a drawer"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_0
    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/v4/widget/g;

    iget-boolean v0, v0, Landroid/support/v4/widget/g;->d:Z

    .line 1370
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method final a(Landroid/view/View;I)Z
    .locals 1

    .prologue
    .line 712
    invoke-virtual {p0, p1}, Landroid/support/v4/widget/DrawerLayout;->c(Landroid/view/View;)I

    move-result v0

    .line 713
    and-int/2addr v0, p2

    if-ne v0, p2, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public addView(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V
    .locals 1

    .prologue
    .line 1524
    invoke-super {p0, p1, p2, p3}, Landroid/view/ViewGroup;->addView(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V

    .line 1526
    invoke-direct {p0}, Landroid/support/v4/widget/DrawerLayout;->d()Landroid/view/View;

    move-result-object v0

    .line 1527
    if-nez v0, :cond_0

    invoke-static {p1}, Landroid/support/v4/widget/DrawerLayout;->d(Landroid/view/View;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 1530
    :cond_0
    const/4 v0, 0x4

    invoke-static {p1, v0}, Landroid/support/v4/view/ap;->c(Landroid/view/View;I)V

    .line 1541
    :goto_0
    sget-boolean v0, Landroid/support/v4/widget/DrawerLayout;->j:Z

    if-nez v0, :cond_1

    .line 1542
    iget-object v0, p0, Landroid/support/v4/widget/DrawerLayout;->k:Landroid/support/v4/widget/b;

    invoke-static {p1, v0}, Landroid/support/v4/view/ap;->a(Landroid/view/View;Landroid/support/v4/view/a;)V

    .line 1544
    :cond_1
    return-void

    .line 1535
    :cond_2
    const/4 v0, 0x1

    invoke-static {p1, v0}, Landroid/support/v4/view/ap;->c(Landroid/view/View;I)V

    goto :goto_0
.end method

.method final c(Landroid/view/View;)I
    .locals 2

    .prologue
    .line 707
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/v4/widget/g;

    iget v0, v0, Landroid/support/v4/widget/g;->a:I

    .line 708
    invoke-static {p0}, Landroid/support/v4/view/ap;->h(Landroid/view/View;)I

    move-result v1

    invoke-static {v0, v1}, Landroid/support/v4/view/n;->a(II)I

    move-result v0

    return v0
.end method

.method protected checkLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Z
    .locals 1

    .prologue
    .line 1431
    instance-of v0, p1, Landroid/support/v4/widget/g;

    if-eqz v0, :cond_0

    invoke-super {p0, p1}, Landroid/view/ViewGroup;->checkLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public computeScroll()V
    .locals 4

    .prologue
    .line 968
    invoke-virtual {p0}, Landroid/support/v4/widget/DrawerLayout;->getChildCount()I

    move-result v3

    .line 969
    const/4 v1, 0x0

    .line 970
    const/4 v0, 0x0

    move v2, v1

    move v1, v0

    :goto_0
    if-ge v1, v3, :cond_0

    .line 971
    invoke-virtual {p0, v1}, Landroid/support/v4/widget/DrawerLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/v4/widget/g;

    iget v0, v0, Landroid/support/v4/widget/g;->b:F

    .line 972
    invoke-static {v2, v0}, Ljava/lang/Math;->max(FF)F

    move-result v2

    .line 970
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 974
    :cond_0
    iput v2, p0, Landroid/support/v4/widget/DrawerLayout;->n:F

    .line 977
    iget-object v0, p0, Landroid/support/v4/widget/DrawerLayout;->a:Landroid/support/v4/widget/ah;

    invoke-virtual {v0}, Landroid/support/v4/widget/ah;->c()Z

    move-result v0

    iget-object v1, p0, Landroid/support/v4/widget/DrawerLayout;->b:Landroid/support/v4/widget/ah;

    invoke-virtual {v1}, Landroid/support/v4/widget/ah;->c()Z

    move-result v1

    or-int/2addr v0, v1

    if-eqz v0, :cond_1

    .line 978
    invoke-static {p0}, Landroid/support/v4/view/ap;->d(Landroid/view/View;)V

    .line 980
    :cond_1
    return-void
.end method

.method protected drawChild(Landroid/graphics/Canvas;Landroid/view/View;J)Z
    .locals 11

    .prologue
    .line 1035
    invoke-virtual {p0}, Landroid/support/v4/widget/DrawerLayout;->getHeight()I

    move-result v4

    .line 1036
    invoke-static {p2}, Landroid/support/v4/widget/DrawerLayout;->i(Landroid/view/View;)Z

    move-result v5

    .line 1037
    const/4 v1, 0x0

    invoke-virtual {p0}, Landroid/support/v4/widget/DrawerLayout;->getWidth()I

    move-result v2

    .line 1039
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    move-result v6

    .line 1040
    if-eqz v5, :cond_6

    .line 1041
    invoke-virtual {p0}, Landroid/support/v4/widget/DrawerLayout;->getChildCount()I

    move-result v7

    .line 1042
    const/4 v0, 0x0

    move v3, v0

    :goto_0
    if-ge v3, v7, :cond_5

    .line 1043
    invoke-virtual {p0, v3}, Landroid/support/v4/widget/DrawerLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v8

    .line 1044
    if-eq v8, p2, :cond_4

    invoke-virtual {v8}, Landroid/view/View;->getVisibility()I

    move-result v0

    if-nez v0, :cond_4

    invoke-virtual {v8}, Landroid/view/View;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    if-eqz v0, :cond_2

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getOpacity()I

    move-result v0

    const/4 v9, -0x1

    if-ne v0, v9, :cond_1

    const/4 v0, 0x1

    :goto_1
    if-eqz v0, :cond_4

    invoke-static {v8}, Landroid/support/v4/widget/DrawerLayout;->d(Landroid/view/View;)Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-virtual {v8}, Landroid/view/View;->getHeight()I

    move-result v0

    if-lt v0, v4, :cond_4

    .line 1047
    const/4 v0, 0x3

    invoke-virtual {p0, v8, v0}, Landroid/support/v4/widget/DrawerLayout;->a(Landroid/view/View;I)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 1051
    invoke-virtual {v8}, Landroid/view/View;->getRight()I

    move-result v0

    .line 1052
    if-le v0, v1, :cond_a

    :goto_2
    move v1, v0

    move v0, v2

    .line 1042
    :cond_0
    :goto_3
    add-int/lit8 v2, v3, 0x1

    move v3, v2

    move v2, v0

    goto :goto_0

    .line 1044
    :cond_1
    const/4 v0, 0x0

    goto :goto_1

    :cond_2
    const/4 v0, 0x0

    goto :goto_1

    .line 1054
    :cond_3
    invoke-virtual {v8}, Landroid/view/View;->getLeft()I

    move-result v0

    .line 1055
    if-lt v0, v2, :cond_0

    :cond_4
    move v0, v2

    goto :goto_3

    .line 1058
    :cond_5
    const/4 v0, 0x0

    invoke-virtual {p0}, Landroid/support/v4/widget/DrawerLayout;->getHeight()I

    move-result v3

    invoke-virtual {p1, v1, v0, v2, v3}, Landroid/graphics/Canvas;->clipRect(IIII)Z

    :cond_6
    move v0, v2

    .line 1060
    invoke-super {p0, p1, p2, p3, p4}, Landroid/view/ViewGroup;->drawChild(Landroid/graphics/Canvas;Landroid/view/View;J)Z

    move-result v7

    .line 1061
    invoke-virtual {p1, v6}, Landroid/graphics/Canvas;->restoreToCount(I)V

    .line 1063
    iget v2, p0, Landroid/support/v4/widget/DrawerLayout;->n:F

    const/4 v3, 0x0

    cmpl-float v2, v2, v3

    if-lez v2, :cond_8

    if-eqz v5, :cond_8

    .line 1064
    iget v2, p0, Landroid/support/v4/widget/DrawerLayout;->m:I

    const/high16 v3, -0x1000000

    and-int/2addr v2, v3

    ushr-int/lit8 v2, v2, 0x18

    .line 1065
    int-to-float v2, v2

    iget v3, p0, Landroid/support/v4/widget/DrawerLayout;->n:F

    mul-float/2addr v2, v3

    float-to-int v2, v2

    .line 1066
    shl-int/lit8 v2, v2, 0x18

    iget v3, p0, Landroid/support/v4/widget/DrawerLayout;->m:I

    const v4, 0xffffff

    and-int/2addr v3, v4

    or-int/2addr v2, v3

    .line 1067
    iget-object v3, p0, Landroid/support/v4/widget/DrawerLayout;->o:Landroid/graphics/Paint;

    invoke-virtual {v3, v2}, Landroid/graphics/Paint;->setColor(I)V

    .line 1069
    int-to-float v1, v1

    const/4 v2, 0x0

    int-to-float v3, v0

    invoke-virtual {p0}, Landroid/support/v4/widget/DrawerLayout;->getHeight()I

    move-result v0

    int-to-float v4, v0

    iget-object v5, p0, Landroid/support/v4/widget/DrawerLayout;->o:Landroid/graphics/Paint;

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 1092
    :cond_7
    :goto_4
    return v7

    .line 1070
    :cond_8
    iget-object v0, p0, Landroid/support/v4/widget/DrawerLayout;->y:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_9

    const/4 v0, 0x3

    invoke-virtual {p0, p2, v0}, Landroid/support/v4/widget/DrawerLayout;->a(Landroid/view/View;I)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 1071
    iget-object v0, p0, Landroid/support/v4/widget/DrawerLayout;->y:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v0

    .line 1072
    invoke-virtual {p2}, Landroid/view/View;->getRight()I

    move-result v1

    .line 1073
    iget-object v2, p0, Landroid/support/v4/widget/DrawerLayout;->a:Landroid/support/v4/widget/ah;

    iget v2, v2, Landroid/support/v4/widget/ah;->k:I

    .line 1074
    const/4 v3, 0x0

    int-to-float v4, v1

    int-to-float v2, v2

    div-float v2, v4, v2

    const/high16 v4, 0x3f800000    # 1.0f

    invoke-static {v2, v4}, Ljava/lang/Math;->min(FF)F

    move-result v2

    invoke-static {v3, v2}, Ljava/lang/Math;->max(FF)F

    move-result v2

    .line 1076
    iget-object v3, p0, Landroid/support/v4/widget/DrawerLayout;->y:Landroid/graphics/drawable/Drawable;

    invoke-virtual {p2}, Landroid/view/View;->getTop()I

    move-result v4

    add-int/2addr v0, v1

    invoke-virtual {p2}, Landroid/view/View;->getBottom()I

    move-result v5

    invoke-virtual {v3, v1, v4, v0, v5}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 1078
    iget-object v0, p0, Landroid/support/v4/widget/DrawerLayout;->y:Landroid/graphics/drawable/Drawable;

    const/high16 v1, 0x437f0000    # 255.0f

    mul-float/2addr v1, v2

    float-to-int v1, v1

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->setAlpha(I)V

    .line 1079
    iget-object v0, p0, Landroid/support/v4/widget/DrawerLayout;->y:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    goto :goto_4

    .line 1080
    :cond_9
    iget-object v0, p0, Landroid/support/v4/widget/DrawerLayout;->z:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_7

    const/4 v0, 0x5

    invoke-virtual {p0, p2, v0}, Landroid/support/v4/widget/DrawerLayout;->a(Landroid/view/View;I)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 1081
    iget-object v0, p0, Landroid/support/v4/widget/DrawerLayout;->z:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v0

    .line 1082
    invoke-virtual {p2}, Landroid/view/View;->getLeft()I

    move-result v1

    .line 1083
    invoke-virtual {p0}, Landroid/support/v4/widget/DrawerLayout;->getWidth()I

    move-result v2

    sub-int/2addr v2, v1

    .line 1084
    iget-object v3, p0, Landroid/support/v4/widget/DrawerLayout;->b:Landroid/support/v4/widget/ah;

    iget v3, v3, Landroid/support/v4/widget/ah;->k:I

    .line 1085
    const/4 v4, 0x0

    int-to-float v2, v2

    int-to-float v3, v3

    div-float/2addr v2, v3

    const/high16 v3, 0x3f800000    # 1.0f

    invoke-static {v2, v3}, Ljava/lang/Math;->min(FF)F

    move-result v2

    invoke-static {v4, v2}, Ljava/lang/Math;->max(FF)F

    move-result v2

    .line 1087
    iget-object v3, p0, Landroid/support/v4/widget/DrawerLayout;->z:Landroid/graphics/drawable/Drawable;

    sub-int v0, v1, v0

    invoke-virtual {p2}, Landroid/view/View;->getTop()I

    move-result v4

    invoke-virtual {p2}, Landroid/view/View;->getBottom()I

    move-result v5

    invoke-virtual {v3, v0, v4, v1, v5}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 1089
    iget-object v0, p0, Landroid/support/v4/widget/DrawerLayout;->z:Landroid/graphics/drawable/Drawable;

    const/high16 v1, 0x437f0000    # 255.0f

    mul-float/2addr v1, v2

    float-to-int v1, v1

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->setAlpha(I)V

    .line 1090
    iget-object v0, p0, Landroid/support/v4/widget/DrawerLayout;->z:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    goto/16 :goto_4

    :cond_a
    move v0, v1

    goto/16 :goto_2
.end method

.method public final e(Landroid/view/View;)V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 1263
    invoke-static {p1}, Landroid/support/v4/widget/DrawerLayout;->d(Landroid/view/View;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1264
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "View "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " is not a sliding drawer"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1267
    :cond_0
    iget-boolean v0, p0, Landroid/support/v4/widget/DrawerLayout;->s:Z

    if-eqz v0, :cond_1

    .line 1268
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/v4/widget/g;

    .line 1269
    const/high16 v1, 0x3f800000    # 1.0f

    iput v1, v0, Landroid/support/v4/widget/g;->b:F

    .line 1270
    iput-boolean v2, v0, Landroid/support/v4/widget/g;->d:Z

    .line 1272
    invoke-virtual {p0, p1, v2}, Landroid/support/v4/widget/DrawerLayout;->a(Landroid/view/View;Z)V

    .line 1281
    :goto_0
    invoke-virtual {p0}, Landroid/support/v4/widget/DrawerLayout;->invalidate()V

    .line 1282
    return-void

    .line 1274
    :cond_1
    const/4 v0, 0x3

    invoke-virtual {p0, p1, v0}, Landroid/support/v4/widget/DrawerLayout;->a(Landroid/view/View;I)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 1275
    iget-object v0, p0, Landroid/support/v4/widget/DrawerLayout;->a:Landroid/support/v4/widget/ah;

    const/4 v1, 0x0

    invoke-virtual {p1}, Landroid/view/View;->getTop()I

    move-result v2

    invoke-virtual {v0, p1, v1, v2}, Landroid/support/v4/widget/ah;->a(Landroid/view/View;II)Z

    goto :goto_0

    .line 1277
    :cond_2
    iget-object v0, p0, Landroid/support/v4/widget/DrawerLayout;->b:Landroid/support/v4/widget/ah;

    invoke-virtual {p0}, Landroid/support/v4/widget/DrawerLayout;->getWidth()I

    move-result v1

    invoke-virtual {p1}, Landroid/view/View;->getWidth()I

    move-result v2

    sub-int/2addr v1, v2

    invoke-virtual {p1}, Landroid/view/View;->getTop()I

    move-result v2

    invoke-virtual {v0, p1, v1, v2}, Landroid/support/v4/widget/ah;->a(Landroid/view/View;II)Z

    goto :goto_0
.end method

.method public final f(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 1305
    invoke-static {p1}, Landroid/support/v4/widget/DrawerLayout;->d(Landroid/view/View;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1306
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "View "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " is not a sliding drawer"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1309
    :cond_0
    iget-boolean v0, p0, Landroid/support/v4/widget/DrawerLayout;->s:Z

    if-eqz v0, :cond_1

    .line 1310
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/v4/widget/g;

    .line 1311
    const/4 v1, 0x0

    iput v1, v0, Landroid/support/v4/widget/g;->b:F

    .line 1312
    const/4 v1, 0x0

    iput-boolean v1, v0, Landroid/support/v4/widget/g;->d:Z

    .line 1321
    :goto_0
    invoke-virtual {p0}, Landroid/support/v4/widget/DrawerLayout;->invalidate()V

    .line 1322
    return-void

    .line 1314
    :cond_1
    const/4 v0, 0x3

    invoke-virtual {p0, p1, v0}, Landroid/support/v4/widget/DrawerLayout;->a(Landroid/view/View;I)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 1315
    iget-object v0, p0, Landroid/support/v4/widget/DrawerLayout;->a:Landroid/support/v4/widget/ah;

    invoke-virtual {p1}, Landroid/view/View;->getWidth()I

    move-result v1

    neg-int v1, v1

    invoke-virtual {p1}, Landroid/view/View;->getTop()I

    move-result v2

    invoke-virtual {v0, p1, v1, v2}, Landroid/support/v4/widget/ah;->a(Landroid/view/View;II)Z

    goto :goto_0

    .line 1318
    :cond_2
    iget-object v0, p0, Landroid/support/v4/widget/DrawerLayout;->b:Landroid/support/v4/widget/ah;

    invoke-virtual {p0}, Landroid/support/v4/widget/DrawerLayout;->getWidth()I

    move-result v1

    invoke-virtual {p1}, Landroid/view/View;->getTop()I

    move-result v2

    invoke-virtual {v0, p1, v1, v2}, Landroid/support/v4/widget/ah;->a(Landroid/view/View;II)Z

    goto :goto_0
.end method

.method protected generateDefaultLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    .locals 1

    .prologue
    .line 1417
    new-instance v0, Landroid/support/v4/widget/g;

    invoke-direct {v0}, Landroid/support/v4/widget/g;-><init>()V

    return-object v0
.end method

.method public generateLayoutParams(Landroid/util/AttributeSet;)Landroid/view/ViewGroup$LayoutParams;
    .locals 2

    .prologue
    .line 1436
    new-instance v0, Landroid/support/v4/widget/g;

    invoke-virtual {p0}, Landroid/support/v4/widget/DrawerLayout;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1, p1}, Landroid/support/v4/widget/g;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    return-object v0
.end method

.method protected generateLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Landroid/view/ViewGroup$LayoutParams;
    .locals 1

    .prologue
    .line 1422
    instance-of v0, p1, Landroid/support/v4/widget/g;

    if-eqz v0, :cond_0

    new-instance v0, Landroid/support/v4/widget/g;

    check-cast p1, Landroid/support/v4/widget/g;

    invoke-direct {v0, p1}, Landroid/support/v4/widget/g;-><init>(Landroid/support/v4/widget/g;)V

    :goto_0
    return-object v0

    :cond_0
    instance-of v0, p1, Landroid/view/ViewGroup$MarginLayoutParams;

    if-eqz v0, :cond_1

    new-instance v0, Landroid/support/v4/widget/g;

    check-cast p1, Landroid/view/ViewGroup$MarginLayoutParams;

    invoke-direct {v0, p1}, Landroid/support/v4/widget/g;-><init>(Landroid/view/ViewGroup$MarginLayoutParams;)V

    goto :goto_0

    :cond_1
    new-instance v0, Landroid/support/v4/widget/g;

    invoke-direct {v0, p1}, Landroid/support/v4/widget/g;-><init>(Landroid/view/ViewGroup$LayoutParams;)V

    goto :goto_0
.end method

.method protected onAttachedToWindow()V
    .locals 1

    .prologue
    .line 783
    invoke-super {p0}, Landroid/view/ViewGroup;->onAttachedToWindow()V

    .line 784
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/widget/DrawerLayout;->s:Z

    .line 785
    return-void
.end method

.method protected onDetachedFromWindow()V
    .locals 1

    .prologue
    .line 777
    invoke-super {p0}, Landroid/view/ViewGroup;->onDetachedFromWindow()V

    .line 778
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/widget/DrawerLayout;->s:Z

    .line 779
    return-void
.end method

.method public onDraw(Landroid/graphics/Canvas;)V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 1023
    invoke-super {p0, p1}, Landroid/view/ViewGroup;->onDraw(Landroid/graphics/Canvas;)V

    .line 1024
    iget-boolean v0, p0, Landroid/support/v4/widget/DrawerLayout;->C:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v4/widget/DrawerLayout;->A:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 1025
    sget-object v0, Landroid/support/v4/widget/DrawerLayout;->h:Landroid/support/v4/widget/c;

    iget-object v1, p0, Landroid/support/v4/widget/DrawerLayout;->B:Ljava/lang/Object;

    invoke-interface {v0, v1}, Landroid/support/v4/widget/c;->a(Ljava/lang/Object;)I

    move-result v0

    .line 1026
    if-lez v0, :cond_0

    .line 1027
    iget-object v1, p0, Landroid/support/v4/widget/DrawerLayout;->A:Landroid/graphics/drawable/Drawable;

    invoke-virtual {p0}, Landroid/support/v4/widget/DrawerLayout;->getWidth()I

    move-result v2

    invoke-virtual {v1, v3, v3, v2, v0}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 1028
    iget-object v0, p0, Landroid/support/v4/widget/DrawerLayout;->A:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 1031
    :cond_0
    return-void
.end method

.method public onInterceptTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 9

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 1108
    invoke-static {p1}, Landroid/support/v4/view/z;->a(Landroid/view/MotionEvent;)I

    move-result v0

    .line 1111
    iget-object v3, p0, Landroid/support/v4/widget/DrawerLayout;->a:Landroid/support/v4/widget/ah;

    invoke-virtual {v3, p1}, Landroid/support/v4/widget/ah;->a(Landroid/view/MotionEvent;)Z

    move-result v3

    iget-object v4, p0, Landroid/support/v4/widget/DrawerLayout;->b:Landroid/support/v4/widget/ah;

    invoke-virtual {v4, p1}, Landroid/support/v4/widget/ah;->a(Landroid/view/MotionEvent;)Z

    move-result v4

    or-int/2addr v4, v3

    .line 1116
    packed-switch v0, :pswitch_data_0

    :cond_0
    :goto_0
    move v0, v2

    .line 1150
    :goto_1
    if-nez v4, :cond_1

    if-nez v0, :cond_1

    invoke-virtual {p0}, Landroid/support/v4/widget/DrawerLayout;->getChildCount()I

    move-result v4

    move v3, v2

    :goto_2
    if-ge v3, v4, :cond_9

    invoke-virtual {p0, v3}, Landroid/support/v4/widget/DrawerLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/v4/widget/g;

    iget-boolean v0, v0, Landroid/support/v4/widget/g;->c:Z

    if-eqz v0, :cond_8

    move v0, v1

    :goto_3
    if-nez v0, :cond_1

    iget-boolean v0, p0, Landroid/support/v4/widget/DrawerLayout;->d:Z

    if-eqz v0, :cond_2

    :cond_1
    move v2, v1

    :cond_2
    return v2

    .line 1118
    :pswitch_0
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v0

    .line 1119
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v3

    .line 1120
    iput v0, p0, Landroid/support/v4/widget/DrawerLayout;->w:F

    .line 1121
    iput v3, p0, Landroid/support/v4/widget/DrawerLayout;->x:F

    .line 1122
    iget v5, p0, Landroid/support/v4/widget/DrawerLayout;->n:F

    const/4 v6, 0x0

    cmpl-float v5, v5, v6

    if-lez v5, :cond_a

    .line 1123
    iget-object v5, p0, Landroid/support/v4/widget/DrawerLayout;->a:Landroid/support/v4/widget/ah;

    float-to-int v0, v0

    float-to-int v3, v3

    invoke-virtual {v5, v0, v3}, Landroid/support/v4/widget/ah;->a(II)Landroid/view/View;

    move-result-object v0

    .line 1124
    if-eqz v0, :cond_a

    invoke-static {v0}, Landroid/support/v4/widget/DrawerLayout;->i(Landroid/view/View;)Z

    move-result v0

    if-eqz v0, :cond_a

    move v0, v1

    .line 1128
    :goto_4
    iput-boolean v2, p0, Landroid/support/v4/widget/DrawerLayout;->v:Z

    .line 1129
    iput-boolean v2, p0, Landroid/support/v4/widget/DrawerLayout;->d:Z

    goto :goto_1

    .line 1135
    :pswitch_1
    iget-object v5, p0, Landroid/support/v4/widget/DrawerLayout;->a:Landroid/support/v4/widget/ah;

    iget-object v0, v5, Landroid/support/v4/widget/ah;->d:[F

    array-length v6, v0

    move v0, v2

    :goto_5
    if-ge v0, v6, :cond_7

    iget v3, v5, Landroid/support/v4/widget/ah;->h:I

    shl-int v7, v1, v0

    and-int/2addr v3, v7

    if-eqz v3, :cond_3

    move v3, v1

    :goto_6
    if-eqz v3, :cond_5

    iget-object v3, v5, Landroid/support/v4/widget/ah;->f:[F

    aget v3, v3, v0

    iget-object v7, v5, Landroid/support/v4/widget/ah;->d:[F

    aget v7, v7, v0

    sub-float/2addr v3, v7

    iget-object v7, v5, Landroid/support/v4/widget/ah;->g:[F

    aget v7, v7, v0

    iget-object v8, v5, Landroid/support/v4/widget/ah;->e:[F

    aget v8, v8, v0

    sub-float/2addr v7, v8

    mul-float/2addr v3, v3

    mul-float/2addr v7, v7

    add-float/2addr v3, v7

    iget v7, v5, Landroid/support/v4/widget/ah;->b:I

    iget v8, v5, Landroid/support/v4/widget/ah;->b:I

    mul-int/2addr v7, v8

    int-to-float v7, v7

    cmpl-float v3, v3, v7

    if-lez v3, :cond_4

    move v3, v1

    :goto_7
    if-eqz v3, :cond_6

    move v0, v1

    :goto_8
    if-eqz v0, :cond_0

    .line 1136
    iget-object v0, p0, Landroid/support/v4/widget/DrawerLayout;->p:Landroid/support/v4/widget/i;

    invoke-virtual {v0}, Landroid/support/v4/widget/i;->a()V

    .line 1137
    iget-object v0, p0, Landroid/support/v4/widget/DrawerLayout;->q:Landroid/support/v4/widget/i;

    invoke-virtual {v0}, Landroid/support/v4/widget/i;->a()V

    move v0, v2

    goto/16 :goto_1

    :cond_3
    move v3, v2

    .line 1135
    goto :goto_6

    :cond_4
    move v3, v2

    goto :goto_7

    :cond_5
    move v3, v2

    goto :goto_7

    :cond_6
    add-int/lit8 v0, v0, 0x1

    goto :goto_5

    :cond_7
    move v0, v2

    goto :goto_8

    .line 1144
    :pswitch_2
    invoke-virtual {p0, v1}, Landroid/support/v4/widget/DrawerLayout;->a(Z)V

    .line 1145
    iput-boolean v2, p0, Landroid/support/v4/widget/DrawerLayout;->v:Z

    .line 1146
    iput-boolean v2, p0, Landroid/support/v4/widget/DrawerLayout;->d:Z

    goto/16 :goto_0

    .line 1150
    :cond_8
    add-int/lit8 v0, v3, 0x1

    move v3, v0

    goto/16 :goto_2

    :cond_9
    move v0, v2

    goto/16 :goto_3

    :cond_a
    move v0, v2

    goto :goto_4

    .line 1116
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_2
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 1471
    const/4 v1, 0x4

    if-ne p1, v1, :cond_1

    invoke-direct {p0}, Landroid/support/v4/widget/DrawerLayout;->e()Landroid/view/View;

    move-result-object v1

    if-eqz v1, :cond_0

    move v1, v0

    :goto_0
    if-eqz v1, :cond_1

    .line 1472
    invoke-static {p2}, Landroid/support/v4/view/s;->c(Landroid/view/KeyEvent;)V

    .line 1475
    :goto_1
    return v0

    .line 1471
    :cond_0
    const/4 v1, 0x0

    goto :goto_0

    .line 1475
    :cond_1
    invoke-super {p0, p1, p2}, Landroid/view/ViewGroup;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v0

    goto :goto_1
.end method

.method public onKeyUp(ILandroid/view/KeyEvent;)Z
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 1480
    const/4 v1, 0x4

    if-ne p1, v1, :cond_2

    .line 1481
    invoke-direct {p0}, Landroid/support/v4/widget/DrawerLayout;->e()Landroid/view/View;

    move-result-object v1

    .line 1482
    if-eqz v1, :cond_0

    invoke-virtual {p0, v1}, Landroid/support/v4/widget/DrawerLayout;->a(Landroid/view/View;)I

    move-result v2

    if-nez v2, :cond_0

    .line 1483
    invoke-virtual {p0, v0}, Landroid/support/v4/widget/DrawerLayout;->a(Z)V

    .line 1485
    :cond_0
    if-eqz v1, :cond_1

    const/4 v0, 0x1

    .line 1487
    :cond_1
    :goto_0
    return v0

    :cond_2
    invoke-super {p0, p1, p2}, Landroid/view/ViewGroup;->onKeyUp(ILandroid/view/KeyEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method protected onLayout(ZIIII)V
    .locals 14

    .prologue
    .line 877
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/widget/DrawerLayout;->r:Z

    .line 878
    sub-int v6, p4, p2

    .line 879
    invoke-virtual {p0}, Landroid/support/v4/widget/DrawerLayout;->getChildCount()I

    move-result v7

    .line 880
    const/4 v0, 0x0

    move v5, v0

    :goto_0
    if-ge v5, v7, :cond_8

    .line 881
    invoke-virtual {p0, v5}, Landroid/support/v4/widget/DrawerLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v8

    .line 883
    invoke-virtual {v8}, Landroid/view/View;->getVisibility()I

    move-result v0

    const/16 v1, 0x8

    if-eq v0, v1, :cond_0

    .line 884
    invoke-virtual {v8}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/v4/widget/g;

    .line 889
    invoke-static {v8}, Landroid/support/v4/widget/DrawerLayout;->i(Landroid/view/View;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 890
    iget v1, v0, Landroid/support/v4/widget/g;->leftMargin:I

    iget v2, v0, Landroid/support/v4/widget/g;->topMargin:I

    iget v3, v0, Landroid/support/v4/widget/g;->leftMargin:I

    invoke-virtual {v8}, Landroid/view/View;->getMeasuredWidth()I

    move-result v4

    add-int/2addr v3, v4

    iget v0, v0, Landroid/support/v4/widget/g;->topMargin:I

    invoke-virtual {v8}, Landroid/view/View;->getMeasuredHeight()I

    move-result v4

    add-int/2addr v0, v4

    invoke-virtual {v8, v1, v2, v3, v0}, Landroid/view/View;->layout(IIII)V

    .line 880
    :cond_0
    :goto_1
    add-int/lit8 v0, v5, 0x1

    move v5, v0

    goto :goto_0

    .line 894
    :cond_1
    invoke-virtual {v8}, Landroid/view/View;->getMeasuredWidth()I

    move-result v9

    .line 895
    invoke-virtual {v8}, Landroid/view/View;->getMeasuredHeight()I

    move-result v10

    .line 899
    const/4 v1, 0x3

    invoke-virtual {p0, v8, v1}, Landroid/support/v4/widget/DrawerLayout;->a(Landroid/view/View;I)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 900
    neg-int v1, v9

    int-to-float v2, v9

    iget v3, v0, Landroid/support/v4/widget/g;->b:F

    mul-float/2addr v2, v3

    float-to-int v2, v2

    add-int/2addr v2, v1

    .line 901
    add-int v1, v9, v2

    int-to-float v1, v1

    int-to-float v3, v9

    div-float/2addr v1, v3

    .line 907
    :goto_2
    iget v3, v0, Landroid/support/v4/widget/g;->b:F

    cmpl-float v3, v1, v3

    if-eqz v3, :cond_4

    const/4 v3, 0x1

    .line 909
    :goto_3
    iget v4, v0, Landroid/support/v4/widget/g;->a:I

    and-int/lit8 v4, v4, 0x70

    .line 911
    sparse-switch v4, :sswitch_data_0

    .line 914
    iget v4, v0, Landroid/support/v4/widget/g;->topMargin:I

    add-int/2addr v9, v2

    iget v11, v0, Landroid/support/v4/widget/g;->topMargin:I

    add-int/2addr v10, v11

    invoke-virtual {v8, v2, v4, v9, v10}, Landroid/view/View;->layout(IIII)V

    .line 941
    :goto_4
    if-eqz v3, :cond_2

    .line 946
    invoke-virtual {p0, v8, v1}, Landroid/support/v4/widget/DrawerLayout;->a(Landroid/view/View;F)V

    .line 949
    :cond_2
    iget v0, v0, Landroid/support/v4/widget/g;->b:F

    const/4 v1, 0x0

    cmpl-float v0, v0, v1

    if-lez v0, :cond_7

    const/4 v0, 0x0

    .line 950
    :goto_5
    invoke-virtual {v8}, Landroid/view/View;->getVisibility()I

    move-result v1

    if-eq v1, v0, :cond_0

    .line 951
    invoke-virtual {v8, v0}, Landroid/view/View;->setVisibility(I)V

    goto :goto_1

    .line 903
    :cond_3
    int-to-float v1, v9

    iget v2, v0, Landroid/support/v4/widget/g;->b:F

    mul-float/2addr v1, v2

    float-to-int v1, v1

    sub-int v2, v6, v1

    .line 904
    sub-int v1, v6, v2

    int-to-float v1, v1

    int-to-float v3, v9

    div-float/2addr v1, v3

    goto :goto_2

    .line 907
    :cond_4
    const/4 v3, 0x0

    goto :goto_3

    .line 920
    :sswitch_0
    sub-int v4, p5, p3

    .line 921
    iget v10, v0, Landroid/support/v4/widget/g;->bottomMargin:I

    sub-int v10, v4, v10

    invoke-virtual {v8}, Landroid/view/View;->getMeasuredHeight()I

    move-result v11

    sub-int/2addr v10, v11

    add-int/2addr v9, v2

    iget v11, v0, Landroid/support/v4/widget/g;->bottomMargin:I

    sub-int/2addr v4, v11

    invoke-virtual {v8, v2, v10, v9, v4}, Landroid/view/View;->layout(IIII)V

    goto :goto_4

    .line 929
    :sswitch_1
    sub-int v11, p5, p3

    .line 930
    sub-int v4, v11, v10

    div-int/lit8 v4, v4, 0x2

    .line 934
    iget v12, v0, Landroid/support/v4/widget/g;->topMargin:I

    if-ge v4, v12, :cond_6

    .line 935
    iget v4, v0, Landroid/support/v4/widget/g;->topMargin:I

    .line 939
    :cond_5
    :goto_6
    add-int/2addr v9, v2

    add-int/2addr v10, v4

    invoke-virtual {v8, v2, v4, v9, v10}, Landroid/view/View;->layout(IIII)V

    goto :goto_4

    .line 936
    :cond_6
    add-int v12, v4, v10

    iget v13, v0, Landroid/support/v4/widget/g;->bottomMargin:I

    sub-int v13, v11, v13

    if-le v12, v13, :cond_5

    .line 937
    iget v4, v0, Landroid/support/v4/widget/g;->bottomMargin:I

    sub-int v4, v11, v4

    sub-int/2addr v4, v10

    goto :goto_6

    .line 949
    :cond_7
    const/4 v0, 0x4

    goto :goto_5

    .line 955
    :cond_8
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v4/widget/DrawerLayout;->r:Z

    .line 956
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v4/widget/DrawerLayout;->s:Z

    .line 957
    return-void

    .line 911
    :sswitch_data_0
    .sparse-switch
        0x10 -> :sswitch_1
        0x50 -> :sswitch_0
    .end sparse-switch
.end method

.method protected onMeasure(II)V
    .locals 12

    .prologue
    const/16 v1, 0x12c

    const/4 v4, 0x0

    const/high16 v7, -0x80000000

    const/high16 v11, 0x40000000    # 2.0f

    .line 789
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v3

    .line 790
    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v5

    .line 791
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v2

    .line 792
    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v0

    .line 794
    if-ne v3, v11, :cond_0

    if-eq v5, v11, :cond_b

    .line 795
    :cond_0
    invoke-virtual {p0}, Landroid/support/v4/widget/DrawerLayout;->isInEditMode()Z

    move-result v6

    if-eqz v6, :cond_4

    .line 800
    if-eq v3, v7, :cond_1

    .line 801
    if-nez v3, :cond_1

    move v2, v1

    .line 806
    :cond_1
    if-eq v5, v7, :cond_b

    .line 807
    if-nez v5, :cond_b

    .line 819
    :goto_0
    invoke-virtual {p0, v2, v1}, Landroid/support/v4/widget/DrawerLayout;->setMeasuredDimension(II)V

    .line 821
    iget-object v0, p0, Landroid/support/v4/widget/DrawerLayout;->B:Ljava/lang/Object;

    if-eqz v0, :cond_5

    invoke-static {p0}, Landroid/support/v4/view/ap;->p(Landroid/view/View;)Z

    move-result v0

    if-eqz v0, :cond_5

    const/4 v0, 0x1

    move v3, v0

    .line 822
    :goto_1
    invoke-static {p0}, Landroid/support/v4/view/ap;->h(Landroid/view/View;)I

    move-result v5

    .line 825
    invoke-virtual {p0}, Landroid/support/v4/widget/DrawerLayout;->getChildCount()I

    move-result v6

    .line 827
    :goto_2
    if-ge v4, v6, :cond_a

    .line 828
    invoke-virtual {p0, v4}, Landroid/support/v4/widget/DrawerLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v7

    .line 830
    invoke-virtual {v7}, Landroid/view/View;->getVisibility()I

    move-result v0

    const/16 v8, 0x8

    if-eq v0, v8, :cond_3

    .line 831
    invoke-virtual {v7}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/v4/widget/g;

    .line 836
    if-eqz v3, :cond_2

    .line 837
    iget v8, v0, Landroid/support/v4/widget/g;->a:I

    invoke-static {v8, v5}, Landroid/support/v4/view/n;->a(II)I

    move-result v8

    .line 838
    invoke-static {v7}, Landroid/support/v4/view/ap;->p(Landroid/view/View;)Z

    move-result v9

    if-eqz v9, :cond_6

    .line 839
    sget-object v9, Landroid/support/v4/widget/DrawerLayout;->h:Landroid/support/v4/widget/c;

    iget-object v10, p0, Landroid/support/v4/widget/DrawerLayout;->B:Ljava/lang/Object;

    invoke-interface {v9, v7, v10, v8}, Landroid/support/v4/widget/c;->a(Landroid/view/View;Ljava/lang/Object;I)V

    .line 845
    :cond_2
    :goto_3
    invoke-static {v7}, Landroid/support/v4/widget/DrawerLayout;->i(Landroid/view/View;)Z

    move-result v8

    if-eqz v8, :cond_7

    .line 847
    iget v8, v0, Landroid/support/v4/widget/g;->leftMargin:I

    sub-int v8, v2, v8

    iget v9, v0, Landroid/support/v4/widget/g;->rightMargin:I

    sub-int/2addr v8, v9

    invoke-static {v8, v11}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v8

    .line 849
    iget v9, v0, Landroid/support/v4/widget/g;->topMargin:I

    sub-int v9, v1, v9

    iget v0, v0, Landroid/support/v4/widget/g;->bottomMargin:I

    sub-int v0, v9, v0

    invoke-static {v0, v11}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v0

    .line 851
    invoke-virtual {v7, v8, v0}, Landroid/view/View;->measure(II)V

    .line 827
    :cond_3
    :goto_4
    add-int/lit8 v4, v4, 0x1

    goto :goto_2

    .line 814
    :cond_4
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "DrawerLayout must be measured with MeasureSpec.EXACTLY."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_5
    move v3, v4

    .line 821
    goto :goto_1

    .line 841
    :cond_6
    sget-object v9, Landroid/support/v4/widget/DrawerLayout;->h:Landroid/support/v4/widget/c;

    iget-object v10, p0, Landroid/support/v4/widget/DrawerLayout;->B:Ljava/lang/Object;

    invoke-interface {v9, v0, v10, v8}, Landroid/support/v4/widget/c;->a(Landroid/view/ViewGroup$MarginLayoutParams;Ljava/lang/Object;I)V

    goto :goto_3

    .line 852
    :cond_7
    invoke-static {v7}, Landroid/support/v4/widget/DrawerLayout;->d(Landroid/view/View;)Z

    move-result v8

    if-eqz v8, :cond_9

    .line 853
    invoke-virtual {p0, v7}, Landroid/support/v4/widget/DrawerLayout;->c(Landroid/view/View;)I

    move-result v8

    and-int/lit8 v8, v8, 0x7

    .line 855
    and-int/lit8 v9, v8, 0x0

    if-eqz v9, :cond_8

    .line 856
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Child drawer has absolute gravity "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v8}, Landroid/support/v4/widget/DrawerLayout;->b(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " but this DrawerLayout already has a drawer view along that edge"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 860
    :cond_8
    iget v8, p0, Landroid/support/v4/widget/DrawerLayout;->l:I

    iget v9, v0, Landroid/support/v4/widget/g;->leftMargin:I

    add-int/2addr v8, v9

    iget v9, v0, Landroid/support/v4/widget/g;->rightMargin:I

    add-int/2addr v8, v9

    iget v9, v0, Landroid/support/v4/widget/g;->width:I

    invoke-static {p1, v8, v9}, Landroid/support/v4/widget/DrawerLayout;->getChildMeasureSpec(III)I

    move-result v8

    .line 863
    iget v9, v0, Landroid/support/v4/widget/g;->topMargin:I

    iget v10, v0, Landroid/support/v4/widget/g;->bottomMargin:I

    add-int/2addr v9, v10

    iget v0, v0, Landroid/support/v4/widget/g;->height:I

    invoke-static {p2, v9, v0}, Landroid/support/v4/widget/DrawerLayout;->getChildMeasureSpec(III)I

    move-result v0

    .line 866
    invoke-virtual {v7, v8, v0}, Landroid/view/View;->measure(II)V

    goto :goto_4

    .line 868
    :cond_9
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Child "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " at index "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 873
    :cond_a
    return-void

    :cond_b
    move v1, v0

    goto/16 :goto_0
.end method

.method protected onRestoreInstanceState(Landroid/os/Parcelable;)V
    .locals 2

    .prologue
    .line 1492
    check-cast p1, Landroid/support/v4/widget/DrawerLayout$SavedState;

    .line 1493
    invoke-virtual {p1}, Landroid/support/v4/widget/DrawerLayout$SavedState;->getSuperState()Landroid/os/Parcelable;

    move-result-object v0

    invoke-super {p0, v0}, Landroid/view/ViewGroup;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    .line 1495
    iget v0, p1, Landroid/support/v4/widget/DrawerLayout$SavedState;->a:I

    if-eqz v0, :cond_0

    .line 1496
    iget v0, p1, Landroid/support/v4/widget/DrawerLayout$SavedState;->a:I

    invoke-virtual {p0, v0}, Landroid/support/v4/widget/DrawerLayout;->a(I)Landroid/view/View;

    move-result-object v0

    .line 1497
    if-eqz v0, :cond_0

    .line 1498
    invoke-virtual {p0, v0}, Landroid/support/v4/widget/DrawerLayout;->e(Landroid/view/View;)V

    .line 1502
    :cond_0
    iget v0, p1, Landroid/support/v4/widget/DrawerLayout$SavedState;->b:I

    const/4 v1, 0x3

    invoke-direct {p0, v0, v1}, Landroid/support/v4/widget/DrawerLayout;->a(II)V

    .line 1503
    iget v0, p1, Landroid/support/v4/widget/DrawerLayout$SavedState;->c:I

    const/4 v1, 0x5

    invoke-direct {p0, v0, v1}, Landroid/support/v4/widget/DrawerLayout;->a(II)V

    .line 1504
    return-void
.end method

.method protected onSaveInstanceState()Landroid/os/Parcelable;
    .locals 2

    .prologue
    .line 1508
    invoke-super {p0}, Landroid/view/ViewGroup;->onSaveInstanceState()Landroid/os/Parcelable;

    move-result-object v0

    .line 1509
    new-instance v1, Landroid/support/v4/widget/DrawerLayout$SavedState;

    invoke-direct {v1, v0}, Landroid/support/v4/widget/DrawerLayout$SavedState;-><init>(Landroid/os/Parcelable;)V

    .line 1511
    invoke-direct {p0}, Landroid/support/v4/widget/DrawerLayout;->d()Landroid/view/View;

    move-result-object v0

    .line 1512
    if-eqz v0, :cond_0

    .line 1513
    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/v4/widget/g;

    iget v0, v0, Landroid/support/v4/widget/g;->a:I

    iput v0, v1, Landroid/support/v4/widget/DrawerLayout$SavedState;->a:I

    .line 1516
    :cond_0
    iget v0, p0, Landroid/support/v4/widget/DrawerLayout;->t:I

    iput v0, v1, Landroid/support/v4/widget/DrawerLayout$SavedState;->b:I

    .line 1517
    iget v0, p0, Landroid/support/v4/widget/DrawerLayout;->u:I

    iput v0, v1, Landroid/support/v4/widget/DrawerLayout$SavedState;->c:I

    .line 1519
    return-object v1
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 7

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 1155
    iget-object v0, p0, Landroid/support/v4/widget/DrawerLayout;->a:Landroid/support/v4/widget/ah;

    invoke-virtual {v0, p1}, Landroid/support/v4/widget/ah;->b(Landroid/view/MotionEvent;)V

    .line 1156
    iget-object v0, p0, Landroid/support/v4/widget/DrawerLayout;->b:Landroid/support/v4/widget/ah;

    invoke-virtual {v0, p1}, Landroid/support/v4/widget/ah;->b(Landroid/view/MotionEvent;)V

    .line 1158
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    .line 1159
    and-int/lit16 v0, v0, 0xff

    packed-switch v0, :pswitch_data_0

    .line 1202
    :goto_0
    :pswitch_0
    return v1

    .line 1163
    :pswitch_1
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v0

    .line 1164
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v3

    .line 1165
    iput v0, p0, Landroid/support/v4/widget/DrawerLayout;->w:F

    .line 1166
    iput v3, p0, Landroid/support/v4/widget/DrawerLayout;->x:F

    .line 1167
    iput-boolean v2, p0, Landroid/support/v4/widget/DrawerLayout;->v:Z

    .line 1168
    iput-boolean v2, p0, Landroid/support/v4/widget/DrawerLayout;->d:Z

    goto :goto_0

    .line 1173
    :pswitch_2
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v0

    .line 1174
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v3

    .line 1176
    iget-object v4, p0, Landroid/support/v4/widget/DrawerLayout;->a:Landroid/support/v4/widget/ah;

    float-to-int v5, v0

    float-to-int v6, v3

    invoke-virtual {v4, v5, v6}, Landroid/support/v4/widget/ah;->a(II)Landroid/view/View;

    move-result-object v4

    .line 1177
    if-eqz v4, :cond_1

    invoke-static {v4}, Landroid/support/v4/widget/DrawerLayout;->i(Landroid/view/View;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 1178
    iget v4, p0, Landroid/support/v4/widget/DrawerLayout;->w:F

    sub-float/2addr v0, v4

    .line 1179
    iget v4, p0, Landroid/support/v4/widget/DrawerLayout;->x:F

    sub-float/2addr v3, v4

    .line 1180
    iget-object v4, p0, Landroid/support/v4/widget/DrawerLayout;->a:Landroid/support/v4/widget/ah;

    iget v4, v4, Landroid/support/v4/widget/ah;->b:I

    .line 1181
    mul-float/2addr v0, v0

    mul-float/2addr v3, v3

    add-float/2addr v0, v3

    mul-int v3, v4, v4

    int-to-float v3, v3

    cmpg-float v0, v0, v3

    if-gez v0, :cond_1

    .line 1183
    invoke-direct {p0}, Landroid/support/v4/widget/DrawerLayout;->d()Landroid/view/View;

    move-result-object v0

    .line 1184
    if-eqz v0, :cond_1

    .line 1185
    invoke-virtual {p0, v0}, Landroid/support/v4/widget/DrawerLayout;->a(Landroid/view/View;)I

    move-result v0

    const/4 v3, 0x2

    if-ne v0, v3, :cond_0

    move v0, v1

    .line 1189
    :goto_1
    invoke-virtual {p0, v0}, Landroid/support/v4/widget/DrawerLayout;->a(Z)V

    .line 1190
    iput-boolean v2, p0, Landroid/support/v4/widget/DrawerLayout;->v:Z

    goto :goto_0

    :cond_0
    move v0, v2

    .line 1185
    goto :goto_1

    .line 1195
    :pswitch_3
    invoke-virtual {p0, v1}, Landroid/support/v4/widget/DrawerLayout;->a(Z)V

    .line 1196
    iput-boolean v2, p0, Landroid/support/v4/widget/DrawerLayout;->v:Z

    .line 1197
    iput-boolean v2, p0, Landroid/support/v4/widget/DrawerLayout;->d:Z

    goto :goto_0

    :cond_1
    move v0, v1

    goto :goto_1

    .line 1159
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_2
        :pswitch_0
        :pswitch_3
    .end packed-switch
.end method

.method public requestDisallowInterceptTouchEvent(Z)V
    .locals 1

    .prologue
    .line 1210
    invoke-super {p0, p1}, Landroid/view/ViewGroup;->requestDisallowInterceptTouchEvent(Z)V

    .line 1212
    iput-boolean p1, p0, Landroid/support/v4/widget/DrawerLayout;->v:Z

    .line 1213
    if-eqz p1, :cond_0

    .line 1214
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Landroid/support/v4/widget/DrawerLayout;->a(Z)V

    .line 1216
    :cond_0
    return-void
.end method

.method public requestLayout()V
    .locals 1

    .prologue
    .line 961
    iget-boolean v0, p0, Landroid/support/v4/widget/DrawerLayout;->r:Z

    if-nez v0, :cond_0

    .line 962
    invoke-super {p0}, Landroid/view/ViewGroup;->requestLayout()V

    .line 964
    :cond_0
    return-void
.end method

.method public setDrawerListener(Landroid/support/v4/widget/f;)V
    .locals 0

    .prologue
    .line 420
    iput-object p1, p0, Landroid/support/v4/widget/DrawerLayout;->e:Landroid/support/v4/widget/f;

    .line 421
    return-void
.end method

.method public setDrawerLockMode(I)V
    .locals 1

    .prologue
    .line 437
    const/4 v0, 0x3

    invoke-direct {p0, p1, v0}, Landroid/support/v4/widget/DrawerLayout;->a(II)V

    .line 438
    const/4 v0, 0x5

    invoke-direct {p0, p1, v0}, Landroid/support/v4/widget/DrawerLayout;->a(II)V

    .line 439
    return-void
.end method

.method public setScrimColor(I)V
    .locals 0

    .prologue
    .line 409
    iput p1, p0, Landroid/support/v4/widget/DrawerLayout;->m:I

    .line 410
    invoke-virtual {p0}, Landroid/support/v4/widget/DrawerLayout;->invalidate()V

    .line 411
    return-void
.end method

.method public setStatusBarBackground(I)V
    .locals 1

    .prologue
    .line 1007
    if-eqz p1, :cond_0

    invoke-virtual {p0}, Landroid/support/v4/widget/DrawerLayout;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, p1}, Landroid/support/v4/a/a;->a(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    :goto_0
    iput-object v0, p0, Landroid/support/v4/widget/DrawerLayout;->A:Landroid/graphics/drawable/Drawable;

    .line 1008
    return-void

    .line 1007
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setStatusBarBackground(Landroid/graphics/drawable/Drawable;)V
    .locals 0

    .prologue
    .line 997
    iput-object p1, p0, Landroid/support/v4/widget/DrawerLayout;->A:Landroid/graphics/drawable/Drawable;

    .line 998
    return-void
.end method

.method public setStatusBarBackgroundColor(I)V
    .locals 1

    .prologue
    .line 1018
    new-instance v0, Landroid/graphics/drawable/ColorDrawable;

    invoke-direct {v0, p1}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    iput-object v0, p0, Landroid/support/v4/widget/DrawerLayout;->A:Landroid/graphics/drawable/Drawable;

    .line 1019
    return-void
.end method

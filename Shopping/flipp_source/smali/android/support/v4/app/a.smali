.class public final Landroid/support/v4/app/a;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/support/v4/widget/f;


# annotations
.annotation runtime Ljava/lang/Deprecated;
.end annotation


# static fields
.field private static final h:Landroid/support/v4/app/b;


# instance fields
.field public final a:Landroid/app/Activity;

.field public final b:Landroid/support/v4/widget/DrawerLayout;

.field public c:Z

.field public d:Z

.field public e:Landroid/graphics/drawable/Drawable;

.field public f:Landroid/graphics/drawable/Drawable;

.field public final g:I

.field private final i:Landroid/support/v4/app/f;

.field private j:Landroid/support/v4/app/h;

.field private final k:I

.field private final l:I

.field private m:Ljava/lang/Object;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 176
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 177
    const/16 v1, 0x12

    if-lt v0, v1, :cond_0

    .line 178
    new-instance v0, Landroid/support/v4/app/e;

    invoke-direct {v0, v2}, Landroid/support/v4/app/e;-><init>(B)V

    sput-object v0, Landroid/support/v4/app/a;->h:Landroid/support/v4/app/b;

    .line 184
    :goto_0
    return-void

    .line 179
    :cond_0
    const/16 v1, 0xb

    if-lt v0, v1, :cond_1

    .line 180
    new-instance v0, Landroid/support/v4/app/d;

    invoke-direct {v0, v2}, Landroid/support/v4/app/d;-><init>(B)V

    sput-object v0, Landroid/support/v4/app/a;->h:Landroid/support/v4/app/b;

    goto :goto_0

    .line 182
    :cond_1
    new-instance v0, Landroid/support/v4/app/c;

    invoke-direct {v0, v2}, Landroid/support/v4/app/c;-><init>(B)V

    sput-object v0, Landroid/support/v4/app/a;->h:Landroid/support/v4/app/b;

    goto :goto_0
.end method

.method public constructor <init>(Landroid/app/Activity;Landroid/support/v4/widget/DrawerLayout;)V
    .locals 4

    .prologue
    const/16 v3, 0x15

    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 229
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v2

    iget v2, v2, Landroid/content/pm/ApplicationInfo;->targetSdkVersion:I

    if-lt v2, v3, :cond_0

    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt v2, v3, :cond_0

    move v2, v0

    :goto_0
    if-nez v2, :cond_1

    :goto_1
    invoke-direct {p0, p1, p2, v0}, Landroid/support/v4/app/a;-><init>(Landroid/app/Activity;Landroid/support/v4/widget/DrawerLayout;Z)V

    .line 231
    return-void

    :cond_0
    move v2, v1

    .line 229
    goto :goto_0

    :cond_1
    move v0, v1

    goto :goto_1
.end method

.method private constructor <init>(Landroid/app/Activity;Landroid/support/v4/widget/DrawerLayout;Z)V
    .locals 3

    .prologue
    const v1, 0x7f0200ab

    .line 261
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 195
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/app/a;->c:Z

    .line 262
    iput-object p1, p0, Landroid/support/v4/app/a;->a:Landroid/app/Activity;

    .line 265
    instance-of v0, p1, Landroid/support/v4/app/g;

    if-eqz v0, :cond_0

    move-object v0, p1

    .line 266
    check-cast v0, Landroid/support/v4/app/g;

    invoke-interface {v0}, Landroid/support/v4/app/g;->a()Landroid/support/v4/app/f;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v4/app/a;->i:Landroid/support/v4/app/f;

    .line 271
    :goto_0
    iput-object p2, p0, Landroid/support/v4/app/a;->b:Landroid/support/v4/widget/DrawerLayout;

    .line 272
    iput v1, p0, Landroid/support/v4/app/a;->g:I

    .line 273
    const v0, 0x7f0e0101

    iput v0, p0, Landroid/support/v4/app/a;->k:I

    .line 274
    const v0, 0x7f0e0035

    iput v0, p0, Landroid/support/v4/app/a;->l:I

    .line 276
    invoke-virtual {p0}, Landroid/support/v4/app/a;->d()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v4/app/a;->e:Landroid/graphics/drawable/Drawable;

    .line 277
    invoke-static {p1, v1}, Landroid/support/v4/a/a;->a(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v4/app/a;->f:Landroid/graphics/drawable/Drawable;

    .line 278
    new-instance v0, Landroid/support/v4/app/h;

    iget-object v1, p0, Landroid/support/v4/app/a;->f:Landroid/graphics/drawable/Drawable;

    const/4 v2, 0x0

    invoke-direct {v0, p0, v1, v2}, Landroid/support/v4/app/h;-><init>(Landroid/support/v4/app/a;Landroid/graphics/drawable/Drawable;B)V

    iput-object v0, p0, Landroid/support/v4/app/a;->j:Landroid/support/v4/app/h;

    .line 279
    iget-object v1, p0, Landroid/support/v4/app/a;->j:Landroid/support/v4/app/h;

    if-eqz p3, :cond_1

    const v0, 0x3eaaaaab

    :goto_1
    iput v0, v1, Landroid/support/v4/app/h;->b:F

    invoke-virtual {v1}, Landroid/support/v4/app/h;->invalidateSelf()V

    .line 280
    return-void

    .line 268
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/support/v4/app/a;->i:Landroid/support/v4/app/f;

    goto :goto_0

    .line 279
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method static synthetic a(Landroid/support/v4/app/a;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Landroid/support/v4/app/a;->a:Landroid/app/Activity;

    return-object v0
.end method

.method private a(I)V
    .locals 3

    .prologue
    .line 493
    iget-object v0, p0, Landroid/support/v4/app/a;->i:Landroid/support/v4/app/f;

    if-eqz v0, :cond_0

    .line 499
    :goto_0
    return-void

    .line 497
    :cond_0
    sget-object v0, Landroid/support/v4/app/a;->h:Landroid/support/v4/app/b;

    iget-object v1, p0, Landroid/support/v4/app/a;->m:Ljava/lang/Object;

    iget-object v2, p0, Landroid/support/v4/app/a;->a:Landroid/app/Activity;

    invoke-interface {v0, v1, v2, p1}, Landroid/support/v4/app/b;->a(Ljava/lang/Object;Landroid/app/Activity;I)Ljava/lang/Object;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v4/app/a;->m:Ljava/lang/Object;

    goto :goto_0
.end method


# virtual methods
.method public final a()V
    .locals 5

    .prologue
    .line 292
    iget-object v0, p0, Landroid/support/v4/app/a;->b:Landroid/support/v4/widget/DrawerLayout;

    invoke-virtual {v0}, Landroid/support/v4/widget/DrawerLayout;->a()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 293
    iget-object v0, p0, Landroid/support/v4/app/a;->j:Landroid/support/v4/app/h;

    const/high16 v1, 0x3f800000    # 1.0f

    invoke-virtual {v0, v1}, Landroid/support/v4/app/h;->a(F)V

    .line 298
    :goto_0
    iget-boolean v0, p0, Landroid/support/v4/app/a;->c:Z

    if-eqz v0, :cond_0

    .line 299
    iget-object v1, p0, Landroid/support/v4/app/a;->j:Landroid/support/v4/app/h;

    iget-object v0, p0, Landroid/support/v4/app/a;->b:Landroid/support/v4/widget/DrawerLayout;

    invoke-virtual {v0}, Landroid/support/v4/widget/DrawerLayout;->a()Z

    move-result v0

    if-eqz v0, :cond_2

    iget v0, p0, Landroid/support/v4/app/a;->l:I

    :goto_1
    iget-object v2, p0, Landroid/support/v4/app/a;->i:Landroid/support/v4/app/f;

    if-nez v2, :cond_0

    sget-object v2, Landroid/support/v4/app/a;->h:Landroid/support/v4/app/b;

    iget-object v3, p0, Landroid/support/v4/app/a;->m:Ljava/lang/Object;

    iget-object v4, p0, Landroid/support/v4/app/a;->a:Landroid/app/Activity;

    invoke-interface {v2, v3, v4, v1, v0}, Landroid/support/v4/app/b;->a(Ljava/lang/Object;Landroid/app/Activity;Landroid/graphics/drawable/Drawable;I)Ljava/lang/Object;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v4/app/a;->m:Ljava/lang/Object;

    .line 302
    :cond_0
    return-void

    .line 295
    :cond_1
    iget-object v0, p0, Landroid/support/v4/app/a;->j:Landroid/support/v4/app/h;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/app/h;->a(F)V

    goto :goto_0

    .line 299
    :cond_2
    iget v0, p0, Landroid/support/v4/app/a;->k:I

    goto :goto_1
.end method

.method public final a(F)V
    .locals 4

    .prologue
    const/high16 v3, 0x40000000    # 2.0f

    const/high16 v2, 0x3f000000    # 0.5f

    .line 426
    iget-object v0, p0, Landroid/support/v4/app/a;->j:Landroid/support/v4/app/h;

    iget v0, v0, Landroid/support/v4/app/h;->a:F

    .line 427
    cmpl-float v1, p1, v2

    if-lez v1, :cond_0

    .line 428
    const/4 v1, 0x0

    sub-float v2, p1, v2

    invoke-static {v1, v2}, Ljava/lang/Math;->max(FF)F

    move-result v1

    mul-float/2addr v1, v3

    invoke-static {v0, v1}, Ljava/lang/Math;->max(FF)F

    move-result v0

    .line 432
    :goto_0
    iget-object v1, p0, Landroid/support/v4/app/a;->j:Landroid/support/v4/app/h;

    invoke-virtual {v1, v0}, Landroid/support/v4/app/h;->a(F)V

    .line 433
    return-void

    .line 430
    :cond_0
    mul-float v1, p1, v3

    invoke-static {v0, v1}, Ljava/lang/Math;->min(FF)F

    move-result v0

    goto :goto_0
.end method

.method public final b()V
    .locals 2

    .prologue
    .line 444
    iget-object v0, p0, Landroid/support/v4/app/a;->j:Landroid/support/v4/app/h;

    const/high16 v1, 0x3f800000    # 1.0f

    invoke-virtual {v0, v1}, Landroid/support/v4/app/h;->a(F)V

    .line 445
    iget-boolean v0, p0, Landroid/support/v4/app/a;->c:Z

    if-eqz v0, :cond_0

    .line 446
    iget v0, p0, Landroid/support/v4/app/a;->l:I

    invoke-direct {p0, v0}, Landroid/support/v4/app/a;->a(I)V

    .line 448
    :cond_0
    return-void
.end method

.method public final c()V
    .locals 2

    .prologue
    .line 459
    iget-object v0, p0, Landroid/support/v4/app/a;->j:Landroid/support/v4/app/h;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/app/h;->a(F)V

    .line 460
    iget-boolean v0, p0, Landroid/support/v4/app/a;->c:Z

    if-eqz v0, :cond_0

    .line 461
    iget v0, p0, Landroid/support/v4/app/a;->k:I

    invoke-direct {p0, v0}, Landroid/support/v4/app/a;->a(I)V

    .line 463
    :cond_0
    return-void
.end method

.method public final d()Landroid/graphics/drawable/Drawable;
    .locals 2

    .prologue
    .line 477
    iget-object v0, p0, Landroid/support/v4/app/a;->i:Landroid/support/v4/app/f;

    if-eqz v0, :cond_0

    .line 478
    iget-object v0, p0, Landroid/support/v4/app/a;->i:Landroid/support/v4/app/f;

    invoke-interface {v0}, Landroid/support/v4/app/f;->a()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 480
    :goto_0
    return-object v0

    :cond_0
    sget-object v0, Landroid/support/v4/app/a;->h:Landroid/support/v4/app/b;

    iget-object v1, p0, Landroid/support/v4/app/a;->a:Landroid/app/Activity;

    invoke-interface {v0, v1}, Landroid/support/v4/app/b;->a(Landroid/app/Activity;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    goto :goto_0
.end method

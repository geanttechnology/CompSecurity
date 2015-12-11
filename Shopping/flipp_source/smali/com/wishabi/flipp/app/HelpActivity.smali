.class public Lcom/wishabi/flipp/app/HelpActivity;
.super Landroid/app/Activity;
.source "SourceFile"


# instance fields
.field private a:Lcom/wishabi/flipp/app/cn;

.field private b:Ljava/lang/String;

.field private c:Z

.field private d:[Landroid/view/View;

.field private e:Landroid/support/v4/view/ViewPager;

.field private final f:Lcom/wishabi/flipp/app/cv;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 42
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 50
    new-instance v0, Lcom/wishabi/flipp/app/cg;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/app/cg;-><init>(Lcom/wishabi/flipp/app/HelpActivity;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/HelpActivity;->f:Lcom/wishabi/flipp/app/cv;

    .line 155
    return-void
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/HelpActivity;Lcom/wishabi/flipp/app/cn;)Lcom/wishabi/flipp/app/cn;
    .locals 0

    .prologue
    .line 42
    iput-object p1, p0, Lcom/wishabi/flipp/app/HelpActivity;->a:Lcom/wishabi/flipp/app/cn;

    return-object p1
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/HelpActivity;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .prologue
    .line 42
    iput-object p1, p0, Lcom/wishabi/flipp/app/HelpActivity;->b:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/HelpActivity;Z)Z
    .locals 0

    .prologue
    .line 42
    iput-boolean p1, p0, Lcom/wishabi/flipp/app/HelpActivity;->c:Z

    return p1
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/HelpActivity;)[Landroid/view/View;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/wishabi/flipp/app/HelpActivity;->d:[Landroid/view/View;

    return-object v0
.end method

.method static synthetic b(Lcom/wishabi/flipp/app/HelpActivity;)Lcom/wishabi/flipp/app/cv;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/wishabi/flipp/app/HelpActivity;->f:Lcom/wishabi/flipp/app/cv;

    return-object v0
.end method

.method static synthetic c(Lcom/wishabi/flipp/app/HelpActivity;)Lcom/wishabi/flipp/app/cn;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/wishabi/flipp/app/HelpActivity;->a:Lcom/wishabi/flipp/app/cn;

    return-object v0
.end method

.method static synthetic d(Lcom/wishabi/flipp/app/HelpActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/wishabi/flipp/app/HelpActivity;->b:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public dispatchTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1

    .prologue
    .line 107
    iget-boolean v0, p0, Lcom/wishabi/flipp/app/HelpActivity;->c:Z

    if-nez v0, :cond_0

    invoke-super {p0, p1}, Landroid/app/Activity;->dispatchTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 9

    .prologue
    const/4 v8, 0x3

    const/4 v1, 0x0

    .line 374
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 376
    const v0, 0x7f030002

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/HelpActivity;->setContentView(I)V

    .line 378
    sget-object v0, Lcom/wishabi/flipp/app/do;->a:Lcom/wishabi/flipp/app/do;

    invoke-static {}, Lcom/wishabi/flipp/app/FlippApplication;->b()Landroid/content/Context;

    move-result-object v2

    if-nez v2, :cond_4

    new-array v0, v1, [Landroid/view/View;

    :cond_0
    iput-object v0, p0, Lcom/wishabi/flipp/app/HelpActivity;->d:[Landroid/view/View;

    .line 380
    const v0, 0x7f0b0021

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/HelpActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 381
    new-instance v2, Lcom/wishabi/flipp/app/ci;

    invoke-direct {v2, p0}, Lcom/wishabi/flipp/app/ci;-><init>(Lcom/wishabi/flipp/app/HelpActivity;)V

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 388
    sget-object v2, Lcom/wishabi/flipp/app/do;->a:Lcom/wishabi/flipp/app/do;

    invoke-virtual {v2}, Lcom/wishabi/flipp/app/do;->a()I

    move-result v2

    .line 389
    if-eq v2, v8, :cond_1

    .line 390
    const/4 v3, 0x4

    invoke-virtual {v0, v3}, Landroid/widget/Button;->setVisibility(I)V

    .line 392
    :cond_1
    if-eqz p1, :cond_2

    .line 393
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/HelpActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    const-string v3, "postal_code_fragment"

    invoke-virtual {v0, p1, v3}, Landroid/app/FragmentManager;->getFragment(Landroid/os/Bundle;Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/app/cn;

    iput-object v0, p0, Lcom/wishabi/flipp/app/HelpActivity;->a:Lcom/wishabi/flipp/app/cn;

    .line 396
    iget-object v0, p0, Lcom/wishabi/flipp/app/HelpActivity;->a:Lcom/wishabi/flipp/app/cn;

    if-eqz v0, :cond_2

    .line 397
    iget-object v0, p0, Lcom/wishabi/flipp/app/HelpActivity;->a:Lcom/wishabi/flipp/app/cn;

    iget-object v3, p0, Lcom/wishabi/flipp/app/HelpActivity;->f:Lcom/wishabi/flipp/app/cv;

    iput-object v3, v0, Lcom/wishabi/flipp/app/cn;->a:Lcom/wishabi/flipp/app/cv;

    .line 402
    :cond_2
    const v0, 0x7f0b001f

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/HelpActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v4/view/ViewPager;

    iput-object v0, p0, Lcom/wishabi/flipp/app/HelpActivity;->e:Landroid/support/v4/view/ViewPager;

    .line 403
    iget-object v0, p0, Lcom/wishabi/flipp/app/HelpActivity;->e:Landroid/support/v4/view/ViewPager;

    new-instance v3, Lcom/wishabi/flipp/app/cj;

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/HelpActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v4

    invoke-direct {v3, p0, v4}, Lcom/wishabi/flipp/app/cj;-><init>(Lcom/wishabi/flipp/app/HelpActivity;Landroid/app/FragmentManager;)V

    invoke-virtual {v0, v3}, Landroid/support/v4/view/ViewPager;->setAdapter(Landroid/support/v4/view/ae;)V

    .line 427
    iget-object v3, p0, Lcom/wishabi/flipp/app/HelpActivity;->e:Landroid/support/v4/view/ViewPager;

    if-eq v2, v8, :cond_5

    move v0, v1

    :goto_0
    invoke-virtual {v3, v0}, Landroid/support/v4/view/ViewPager;->setCurrentItem(I)V

    .line 430
    const v0, 0x7f0b0020

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/HelpActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/ViewPagerIndicator;

    .line 432
    iget-object v1, p0, Lcom/wishabi/flipp/app/HelpActivity;->e:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/ViewPagerIndicator;->setViewPager(Landroid/support/v4/view/ViewPager;)V

    .line 434
    iget-object v1, p0, Lcom/wishabi/flipp/app/HelpActivity;->e:Landroid/support/v4/view/ViewPager;

    new-instance v3, Lcom/wishabi/flipp/app/ck;

    invoke-direct {v3, p0, v0}, Lcom/wishabi/flipp/app/ck;-><init>(Lcom/wishabi/flipp/app/HelpActivity;Lcom/wishabi/flipp/widget/ViewPagerIndicator;)V

    invoke-virtual {v1, v3}, Landroid/support/v4/view/ViewPager;->setOnPageChangeListener(Landroid/support/v4/view/cd;)V

    .line 457
    if-nez v2, :cond_3

    .line 458
    new-instance v0, Lcom/wishabi/flipp/app/cl;

    invoke-direct {v0, p0, p0}, Lcom/wishabi/flipp/app/cl;-><init>(Lcom/wishabi/flipp/app/HelpActivity;Landroid/content/Context;)V

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/cl;->a()V

    .line 466
    :cond_3
    return-void

    .line 378
    :cond_4
    invoke-static {v2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v3

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/do;->b()[I

    move-result-object v4

    array-length v0, v4

    new-array v0, v0, [Landroid/view/View;

    array-length v5, v0

    move v2, v1

    :goto_1
    if-ge v2, v5, :cond_0

    aget v6, v4, v2

    const/4 v7, 0x0

    invoke-virtual {v3, v6, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v6

    aput-object v6, v0, v2

    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 427
    :cond_5
    iget-object v0, p0, Lcom/wishabi/flipp/app/HelpActivity;->d:[Landroid/view/View;

    array-length v0, v0

    goto :goto_0
.end method

.method public onResume()V
    .locals 3

    .prologue
    .line 366
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 368
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "TutorialScreen"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/wishabi/flipp/app/HelpActivity;->e:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v2}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;)V

    .line 370
    return-void
.end method

.method protected onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 358
    invoke-super {p0, p1}, Landroid/app/Activity;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 359
    iget-object v0, p0, Lcom/wishabi/flipp/app/HelpActivity;->a:Lcom/wishabi/flipp/app/cn;

    if-eqz v0, :cond_0

    .line 360
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/HelpActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    const-string v1, "postal_code_fragment"

    iget-object v2, p0, Lcom/wishabi/flipp/app/HelpActivity;->a:Lcom/wishabi/flipp/app/cn;

    invoke-virtual {v0, p1, v1, v2}, Landroid/app/FragmentManager;->putFragment(Landroid/os/Bundle;Ljava/lang/String;Landroid/app/Fragment;)V

    .line 362
    :cond_0
    return-void
.end method

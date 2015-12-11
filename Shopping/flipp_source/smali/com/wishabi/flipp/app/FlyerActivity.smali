.class public Lcom/wishabi/flipp/app/FlyerActivity;
.super Landroid/app/Activity;
.source "SourceFile"


# instance fields
.field private a:Landroid/view/View;

.field private b:Lcom/wishabi/flipp/content/Flyer$Model;

.field private c:Landroid/os/Handler;

.field private d:Landroid/content/SharedPreferences;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 32
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/FlyerActivity;Landroid/view/View;)Landroid/view/View;
    .locals 0

    .prologue
    .line 32
    iput-object p1, p0, Lcom/wishabi/flipp/app/FlyerActivity;->a:Landroid/view/View;

    return-object p1
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/FlyerActivity;Lcom/wishabi/flipp/content/Flyer$Model;)Lcom/wishabi/flipp/content/Flyer$Model;
    .locals 0

    .prologue
    .line 32
    iput-object p1, p0, Lcom/wishabi/flipp/app/FlyerActivity;->b:Lcom/wishabi/flipp/content/Flyer$Model;

    return-object p1
.end method

.method private a()V
    .locals 2

    .prologue
    .line 244
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerActivity;->a:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 245
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerActivity;->a:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->clearAnimation()V

    .line 246
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerActivity;->a:Landroid/view/View;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 248
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerActivity;->c:Landroid/os/Handler;

    if-eqz v0, :cond_1

    .line 249
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerActivity;->c:Landroid/os/Handler;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    .line 250
    :cond_1
    return-void
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/FlyerActivity;)V
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 32
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerActivity;->b:Lcom/wishabi/flipp/content/Flyer$Model;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerActivity;->a:Landroid/view/View;

    if-nez v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerActivity;->b:Lcom/wishabi/flipp/content/Flyer$Model;

    iget-boolean v0, v0, Lcom/wishabi/flipp/content/Flyer$Model;->p:Z

    if-nez v0, :cond_2

    invoke-direct {p0}, Lcom/wishabi/flipp/app/FlyerActivity;->a()V

    goto :goto_0

    :cond_2
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerActivity;->a:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getAnimation()Landroid/view/animation/Animation;

    move-result-object v0

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerActivity;->a:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getAnimation()Landroid/view/animation/Animation;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/animation/Animation;->hasEnded()Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_3
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerActivity;->c:Landroid/os/Handler;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->hasMessages(I)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerActivity;->a:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    new-instance v0, Landroid/view/animation/AlphaAnimation;

    const/4 v1, 0x0

    const/high16 v2, 0x3f800000    # 1.0f

    invoke-direct {v0, v1, v2}, Landroid/view/animation/AlphaAnimation;-><init>(FF)V

    const-wide/16 v2, 0x1f4

    invoke-virtual {v0, v2, v3}, Landroid/view/animation/Animation;->setDuration(J)V

    iget-object v1, p0, Lcom/wishabi/flipp/app/FlyerActivity;->a:Landroid/view/View;

    invoke-virtual {v1, v0}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerActivity;->c:Landroid/os/Handler;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerActivity;->c:Landroid/os/Handler;

    new-instance v1, Lcom/wishabi/flipp/app/bd;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/app/bd;-><init>(Lcom/wishabi/flipp/app/FlyerActivity;)V

    const-wide/16 v2, 0xbb8

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_0
.end method

.method static synthetic b(Lcom/wishabi/flipp/app/FlyerActivity;)Landroid/view/View;
    .locals 5

    .prologue
    .line 32
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FlyerActivity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f030052

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FlyerActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    iget v1, v1, Landroid/util/DisplayMetrics;->density:F

    new-instance v2, Landroid/widget/FrameLayout$LayoutParams;

    const/high16 v3, 0x437a0000    # 250.0f

    mul-float/2addr v3, v1

    float-to-int v3, v3

    const/4 v4, -0x2

    invoke-direct {v2, v3, v4}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    const/16 v3, 0x35

    iput v3, v2, Landroid/widget/FrameLayout$LayoutParams;->gravity:I

    const/high16 v3, 0x40c00000    # 6.0f

    mul-float/2addr v3, v1

    float-to-int v3, v3

    iput v3, v2, Landroid/widget/FrameLayout$LayoutParams;->rightMargin:I

    const v3, 0x7f0b00ab

    invoke-virtual {p0, v3}, Lcom/wishabi/flipp/app/FlyerActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    const/4 v4, 0x2

    new-array v4, v4, [I

    invoke-virtual {v3, v4}, Landroid/view/View;->getLocationInWindow([I)V

    const/4 v3, 0x1

    aget v3, v4, v3

    const/high16 v4, 0x42200000    # 40.0f

    mul-float/2addr v4, v1

    float-to-int v4, v4

    sub-int/2addr v3, v4

    iput v3, v2, Landroid/widget/FrameLayout$LayoutParams;->topMargin:I

    iget v3, v2, Landroid/widget/FrameLayout$LayoutParams;->topMargin:I

    const/high16 v4, 0x41200000    # 10.0f

    mul-float/2addr v1, v4

    float-to-int v1, v1

    add-int/2addr v1, v3

    iput v1, v2, Landroid/widget/FrameLayout$LayoutParams;->topMargin:I

    invoke-virtual {v0, v2}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    return-object v0
.end method

.method static synthetic c(Lcom/wishabi/flipp/app/FlyerActivity;)Landroid/view/View;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/wishabi/flipp/app/FlyerActivity;->a:Landroid/view/View;

    return-object v0
.end method


# virtual methods
.method public onBackPressed()V
    .locals 2

    .prologue
    .line 156
    invoke-super {p0}, Landroid/app/Activity;->onBackPressed()V

    .line 157
    const/high16 v0, 0x7f040000

    const v1, 0x7f040003

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/app/FlyerActivity;->overridePendingTransition(II)V

    .line 159
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 48
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 50
    const v0, 0x7f030001

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/FlyerActivity;->setContentView(I)V

    .line 52
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FlyerActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    const v1, 0x7f0b001e

    invoke-virtual {v0, v1}, Landroid/app/FragmentManager;->findFragmentById(I)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    .line 55
    if-eqz v0, :cond_0

    .line 56
    new-instance v1, Lcom/wishabi/flipp/app/bb;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/app/bb;-><init>(Lcom/wishabi/flipp/app/FlyerActivity;)V

    iput-object v1, v0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->b:Lcom/wishabi/flipp/app/bn;

    .line 75
    :cond_0
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FlyerActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 76
    if-eqz v0, :cond_1

    .line 77
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 79
    :cond_1
    const-string v0, "com.wishabi.flipp.preferences"

    invoke-virtual {p0, v0, v3}, Lcom/wishabi/flipp/app/FlyerActivity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/FlyerActivity;->d:Landroid/content/SharedPreferences;

    .line 82
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FlyerActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    if-eqz v0, :cond_3

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FlyerActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_3

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FlyerActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    .line 86
    :goto_0
    if-eqz v0, :cond_2

    iget-object v1, p0, Lcom/wishabi/flipp/app/FlyerActivity;->d:Landroid/content/SharedPreferences;

    const-string v2, "has_seen_select_pop"

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    if-nez v1, :cond_2

    .line 87
    new-instance v1, Lcom/wishabi/flipp/app/bc;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/app/bc;-><init>(Lcom/wishabi/flipp/app/FlyerActivity;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewTreeObserver;->addOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 113
    :cond_2
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/app/FlyerActivity;->c:Landroid/os/Handler;

    .line 114
    return-void

    .line 82
    :cond_3
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 4

    .prologue
    const/4 v0, 0x1

    .line 129
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    sparse-switch v1, :sswitch_data_0

    .line 151
    invoke-super {p0, p1}, Landroid/app/Activity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    :goto_0
    return v0

    .line 131
    :sswitch_0
    invoke-static {p0}, Landroid/support/v4/app/bd;->a(Landroid/app/Activity;)Landroid/content/Intent;

    move-result-object v1

    .line 132
    invoke-static {p0, v1}, Landroid/support/v4/app/bd;->a(Landroid/app/Activity;Landroid/content/Intent;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 133
    invoke-static {p0}, Landroid/support/v4/app/dd;->a(Landroid/content/Context;)Landroid/support/v4/app/dd;

    move-result-object v1

    invoke-virtual {v1, p0}, Landroid/support/v4/app/dd;->a(Landroid/app/Activity;)Landroid/support/v4/app/dd;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/dd;->a()V

    goto :goto_0

    .line 135
    :cond_0
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FlyerActivity;->finish()V

    .line 136
    const/high16 v1, 0x7f040000

    const v2, 0x7f040003

    invoke-virtual {p0, v1, v2}, Lcom/wishabi/flipp/app/FlyerActivity;->overridePendingTransition(II)V

    goto :goto_0

    .line 141
    :sswitch_1
    iget-object v1, p0, Lcom/wishabi/flipp/app/FlyerActivity;->d:Landroid/content/SharedPreferences;

    const-string v2, "has_seen_select_pop"

    const/4 v3, 0x0

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    if-nez v1, :cond_1

    iget-object v1, p0, Lcom/wishabi/flipp/app/FlyerActivity;->b:Lcom/wishabi/flipp/content/Flyer$Model;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/wishabi/flipp/app/FlyerActivity;->b:Lcom/wishabi/flipp/content/Flyer$Model;

    iget-boolean v1, v1, Lcom/wishabi/flipp/content/Flyer$Model;->p:Z

    if-eqz v1, :cond_1

    .line 143
    iget-object v1, p0, Lcom/wishabi/flipp/app/FlyerActivity;->d:Landroid/content/SharedPreferences;

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    const-string v2, "has_seen_select_pop"

    invoke-interface {v1, v2, v0}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 144
    invoke-direct {p0}, Lcom/wishabi/flipp/app/FlyerActivity;->a()V

    .line 145
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/wishabi/flipp/app/FlyerActivity;->a:Landroid/view/View;

    .line 147
    :cond_1
    invoke-super {p0, p1}, Landroid/app/Activity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_0

    .line 129
    :sswitch_data_0
    .sparse-switch
        0x102002c -> :sswitch_0
        0x7f0b015f -> :sswitch_1
    .end sparse-switch
.end method

.method protected onPause()V
    .locals 1

    .prologue
    .line 163
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 164
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    invoke-virtual {v0}, Lcom/wishabi/flipp/b/a;->a()V

    .line 165
    return-void
.end method

.method protected onPostCreate(Landroid/os/Bundle;)V
    .locals 4

    .prologue
    const/4 v3, -0x1

    .line 118
    invoke-super {p0, p1}, Landroid/app/Activity;->onPostCreate(Landroid/os/Bundle;)V

    .line 120
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FlyerActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    const v1, 0x7f0b001e

    invoke-virtual {v0, v1}, Landroid/app/FragmentManager;->findFragmentById(I)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    .line 123
    if-eqz v0, :cond_2

    .line 124
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FlyerActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    iput-object v1, v0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->c:Landroid/os/Bundle;

    iget-object v1, v0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->c:Landroid/os/Bundle;

    const-string v2, "models"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getParcelableArray(Ljava/lang/String;)[Landroid/os/Parcelable;

    move-result-object v1

    iput-object v1, v0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->d:[Landroid/os/Parcelable;

    iget-object v1, v0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->e:Lfr/castorflex/android/verticalviewpager/VerticalViewPager;

    invoke-virtual {v1}, Lfr/castorflex/android/verticalviewpager/VerticalViewPager;->getAdapter()Landroid/support/v4/view/ae;

    move-result-object v1

    iget-object v1, v1, Landroid/support/v4/view/ae;->a:Landroid/database/DataSetObservable;

    invoke-virtual {v1}, Landroid/database/DataSetObservable;->notifyChanged()V

    iget-object v1, v0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->c:Landroid/os/Bundle;

    const-string v2, "flyer_mode"

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v1

    if-eq v1, v3, :cond_0

    invoke-static {}, Lcom/wishabi/flipp/app/bm;->a()[I

    move-result-object v2

    aget v1, v2, v1

    iput v1, v0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->j:I

    :cond_0
    iget-object v1, v0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->i:Ljava/lang/Integer;

    if-nez v1, :cond_3

    iget-object v1, v0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->c:Landroid/os/Bundle;

    const-string v2, "position"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    :goto_0
    iget-object v2, v0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->e:Lfr/castorflex/android/verticalviewpager/VerticalViewPager;

    invoke-virtual {v2}, Lfr/castorflex/android/verticalviewpager/VerticalViewPager;->getCurrentItem()I

    move-result v2

    iget-object v3, v0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->e:Lfr/castorflex/android/verticalviewpager/VerticalViewPager;

    invoke-virtual {v3, v1}, Lfr/castorflex/android/verticalviewpager/VerticalViewPager;->setCurrentItem(I)V

    iget-object v3, v0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->e:Lfr/castorflex/android/verticalviewpager/VerticalViewPager;

    invoke-virtual {v3}, Lfr/castorflex/android/verticalviewpager/VerticalViewPager;->getCurrentItem()I

    move-result v3

    if-ne v2, v3, :cond_1

    iget-object v2, v0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->a:Landroid/support/v4/view/ch;

    invoke-virtual {v2, v1}, Landroid/support/v4/view/ch;->a(I)V

    :cond_1
    iget-object v1, v0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->d:[Landroid/os/Parcelable;

    iget-object v2, v0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->e:Lfr/castorflex/android/verticalviewpager/VerticalViewPager;

    invoke-virtual {v2}, Lfr/castorflex/android/verticalviewpager/VerticalViewPager;->getCurrentItem()I

    move-result v2

    aget-object v1, v1, v2

    check-cast v1, Lcom/wishabi/flipp/content/Flyer$Model;

    iget-boolean v2, v1, Lcom/wishabi/flipp/content/Flyer$Model;->n:Z

    iput-boolean v2, v0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->g:Z

    iget v2, v1, Lcom/wishabi/flipp/content/Flyer$Model;->d:I

    iput v2, v0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->f:I

    iget v1, v1, Lcom/wishabi/flipp/content/Flyer$Model;->a:I

    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->h:Ljava/lang/String;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v1

    if-eqz v1, :cond_2

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3, v0}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    .line 125
    :cond_2
    return-void

    .line 124
    :cond_3
    iget-object v1, v0, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->i:Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    goto :goto_0
.end method

.method protected onResume()V
    .locals 2

    .prologue
    .line 169
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 170
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    const-string v1, "flyerView"

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;)V

    .line 171
    return-void
.end method

.method protected onStop()V
    .locals 0

    .prologue
    .line 175
    invoke-super {p0}, Landroid/app/Activity;->onStop()V

    .line 176
    invoke-direct {p0}, Lcom/wishabi/flipp/app/FlyerActivity;->a()V

    .line 177
    return-void
.end method

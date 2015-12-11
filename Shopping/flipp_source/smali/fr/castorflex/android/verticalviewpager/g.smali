.class final Lfr/castorflex/android/verticalviewpager/g;
.super Landroid/support/v4/view/a;
.source "SourceFile"


# instance fields
.field final synthetic b:Lfr/castorflex/android/verticalviewpager/VerticalViewPager;


# direct methods
.method constructor <init>(Lfr/castorflex/android/verticalviewpager/VerticalViewPager;)V
    .locals 0

    .prologue
    .line 2656
    iput-object p1, p0, Lfr/castorflex/android/verticalviewpager/g;->b:Lfr/castorflex/android/verticalviewpager/VerticalViewPager;

    invoke-direct {p0}, Landroid/support/v4/view/a;-><init>()V

    return-void
.end method

.method private a()Z
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 2710
    iget-object v1, p0, Lfr/castorflex/android/verticalviewpager/g;->b:Lfr/castorflex/android/verticalviewpager/VerticalViewPager;

    invoke-static {v1}, Lfr/castorflex/android/verticalviewpager/VerticalViewPager;->b(Lfr/castorflex/android/verticalviewpager/VerticalViewPager;)Landroid/support/v4/view/ae;

    move-result-object v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lfr/castorflex/android/verticalviewpager/g;->b:Lfr/castorflex/android/verticalviewpager/VerticalViewPager;

    invoke-static {v1}, Lfr/castorflex/android/verticalviewpager/VerticalViewPager;->b(Lfr/castorflex/android/verticalviewpager/VerticalViewPager;)Landroid/support/v4/view/ae;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/view/ae;->c()I

    move-result v1

    if-le v1, v0, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public final a(Landroid/view/View;Landroid/support/v4/view/a/e;)V
    .locals 2

    .prologue
    .line 2674
    invoke-super {p0, p1, p2}, Landroid/support/v4/view/a;->a(Landroid/view/View;Landroid/support/v4/view/a/e;)V

    .line 2675
    const-class v0, Landroid/support/v4/view/ViewPager;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Landroid/support/v4/view/a/e;->a(Ljava/lang/CharSequence;)V

    .line 2676
    invoke-direct {p0}, Lfr/castorflex/android/verticalviewpager/g;->a()Z

    move-result v0

    invoke-virtual {p2, v0}, Landroid/support/v4/view/a/e;->a(Z)V

    .line 2677
    iget-object v0, p0, Lfr/castorflex/android/verticalviewpager/g;->b:Lfr/castorflex/android/verticalviewpager/VerticalViewPager;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lfr/castorflex/android/verticalviewpager/VerticalViewPager;->a(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2678
    const/16 v0, 0x1000

    invoke-virtual {p2, v0}, Landroid/support/v4/view/a/e;->a(I)V

    .line 2680
    :cond_0
    iget-object v0, p0, Lfr/castorflex/android/verticalviewpager/g;->b:Lfr/castorflex/android/verticalviewpager/VerticalViewPager;

    const/4 v1, -0x1

    invoke-virtual {v0, v1}, Lfr/castorflex/android/verticalviewpager/VerticalViewPager;->a(I)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 2681
    const/16 v0, 0x2000

    invoke-virtual {p2, v0}, Landroid/support/v4/view/a/e;->a(I)V

    .line 2683
    :cond_1
    return-void
.end method

.method public final a(Landroid/view/View;ILandroid/os/Bundle;)Z
    .locals 4

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x1

    .line 2687
    invoke-super {p0, p1, p2, p3}, Landroid/support/v4/view/a;->a(Landroid/view/View;ILandroid/os/Bundle;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 2706
    :goto_0
    return v0

    .line 2690
    :cond_0
    sparse-switch p2, :sswitch_data_0

    move v0, v1

    .line 2706
    goto :goto_0

    .line 2692
    :sswitch_0
    iget-object v2, p0, Lfr/castorflex/android/verticalviewpager/g;->b:Lfr/castorflex/android/verticalviewpager/VerticalViewPager;

    invoke-virtual {v2, v0}, Lfr/castorflex/android/verticalviewpager/VerticalViewPager;->a(I)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 2693
    iget-object v1, p0, Lfr/castorflex/android/verticalviewpager/g;->b:Lfr/castorflex/android/verticalviewpager/VerticalViewPager;

    iget-object v2, p0, Lfr/castorflex/android/verticalviewpager/g;->b:Lfr/castorflex/android/verticalviewpager/VerticalViewPager;

    invoke-static {v2}, Lfr/castorflex/android/verticalviewpager/VerticalViewPager;->c(Lfr/castorflex/android/verticalviewpager/VerticalViewPager;)I

    move-result v2

    add-int/lit8 v2, v2, 0x1

    invoke-virtual {v1, v2}, Lfr/castorflex/android/verticalviewpager/VerticalViewPager;->setCurrentItem(I)V

    goto :goto_0

    :cond_1
    move v0, v1

    .line 2697
    goto :goto_0

    .line 2699
    :sswitch_1
    iget-object v2, p0, Lfr/castorflex/android/verticalviewpager/g;->b:Lfr/castorflex/android/verticalviewpager/VerticalViewPager;

    const/4 v3, -0x1

    invoke-virtual {v2, v3}, Lfr/castorflex/android/verticalviewpager/VerticalViewPager;->a(I)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 2700
    iget-object v1, p0, Lfr/castorflex/android/verticalviewpager/g;->b:Lfr/castorflex/android/verticalviewpager/VerticalViewPager;

    iget-object v2, p0, Lfr/castorflex/android/verticalviewpager/g;->b:Lfr/castorflex/android/verticalviewpager/VerticalViewPager;

    invoke-static {v2}, Lfr/castorflex/android/verticalviewpager/VerticalViewPager;->c(Lfr/castorflex/android/verticalviewpager/VerticalViewPager;)I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {v1, v2}, Lfr/castorflex/android/verticalviewpager/VerticalViewPager;->setCurrentItem(I)V

    goto :goto_0

    :cond_2
    move v0, v1

    .line 2704
    goto :goto_0

    .line 2690
    nop

    :sswitch_data_0
    .sparse-switch
        0x1000 -> :sswitch_0
        0x2000 -> :sswitch_1
    .end sparse-switch
.end method

.method public final d(Landroid/view/View;Landroid/view/accessibility/AccessibilityEvent;)V
    .locals 3

    .prologue
    .line 2660
    invoke-super {p0, p1, p2}, Landroid/support/v4/view/a;->d(Landroid/view/View;Landroid/view/accessibility/AccessibilityEvent;)V

    .line 2661
    const-class v0, Landroid/support/v4/view/ViewPager;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Landroid/view/accessibility/AccessibilityEvent;->setClassName(Ljava/lang/CharSequence;)V

    .line 2662
    invoke-static {}, Landroid/support/v4/view/a/ag;->a()Landroid/support/v4/view/a/ag;

    move-result-object v0

    .line 2663
    invoke-direct {p0}, Lfr/castorflex/android/verticalviewpager/g;->a()Z

    move-result v1

    invoke-virtual {v0, v1}, Landroid/support/v4/view/a/ag;->a(Z)V

    .line 2664
    invoke-virtual {p2}, Landroid/view/accessibility/AccessibilityEvent;->getEventType()I

    move-result v1

    const/16 v2, 0x1000

    if-ne v1, v2, :cond_0

    iget-object v1, p0, Lfr/castorflex/android/verticalviewpager/g;->b:Lfr/castorflex/android/verticalviewpager/VerticalViewPager;

    invoke-static {v1}, Lfr/castorflex/android/verticalviewpager/VerticalViewPager;->b(Lfr/castorflex/android/verticalviewpager/VerticalViewPager;)Landroid/support/v4/view/ae;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 2666
    iget-object v1, p0, Lfr/castorflex/android/verticalviewpager/g;->b:Lfr/castorflex/android/verticalviewpager/VerticalViewPager;

    invoke-static {v1}, Lfr/castorflex/android/verticalviewpager/VerticalViewPager;->b(Lfr/castorflex/android/verticalviewpager/VerticalViewPager;)Landroid/support/v4/view/ae;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/view/ae;->c()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/support/v4/view/a/ag;->a(I)V

    .line 2667
    iget-object v1, p0, Lfr/castorflex/android/verticalviewpager/g;->b:Lfr/castorflex/android/verticalviewpager/VerticalViewPager;

    invoke-static {v1}, Lfr/castorflex/android/verticalviewpager/VerticalViewPager;->c(Lfr/castorflex/android/verticalviewpager/VerticalViewPager;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/support/v4/view/a/ag;->b(I)V

    .line 2668
    iget-object v1, p0, Lfr/castorflex/android/verticalviewpager/g;->b:Lfr/castorflex/android/verticalviewpager/VerticalViewPager;

    invoke-static {v1}, Lfr/castorflex/android/verticalviewpager/VerticalViewPager;->c(Lfr/castorflex/android/verticalviewpager/VerticalViewPager;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/support/v4/view/a/ag;->c(I)V

    .line 2670
    :cond_0
    return-void
.end method

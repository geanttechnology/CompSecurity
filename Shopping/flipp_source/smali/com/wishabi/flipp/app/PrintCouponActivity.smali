.class public Lcom/wishabi/flipp/app/PrintCouponActivity;
.super Landroid/app/Activity;
.source "SourceFile"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method

.method public static a()Landroid/content/Intent;
    .locals 3

    .prologue
    .line 24
    invoke-static {}, Lcom/wishabi/flipp/app/FlippApplication;->b()Landroid/content/Context;

    move-result-object v1

    .line 25
    if-nez v1, :cond_0

    .line 26
    const/4 v0, 0x0

    .line 28
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Landroid/content/Intent;

    const-class v2, Lcom/wishabi/flipp/app/PrintCouponActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    goto :goto_0
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4

    .prologue
    const/4 v2, -0x1

    .line 33
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 36
    const/4 v0, 0x5

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/PrintCouponActivity;->requestWindowFeature(I)Z

    .line 38
    new-instance v0, Landroid/widget/FrameLayout;

    invoke-direct {v0, p0}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    new-instance v1, Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {v1, v2, v2}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/app/PrintCouponActivity;->setContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 42
    const v0, 0x7f0e0105

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/PrintCouponActivity;->setTitle(I)V

    .line 44
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/PrintCouponActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    .line 45
    const-string v0, "print_coupon_fragment"

    invoke-virtual {v1, v0}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/app/PrintCouponFragment;

    .line 48
    if-nez v0, :cond_0

    .line 49
    invoke-static {}, Lcom/wishabi/flipp/app/PrintCouponFragment;->a()Lcom/wishabi/flipp/app/PrintCouponFragment;

    move-result-object v0

    .line 50
    invoke-virtual {v1}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v1

    const v2, 0x1020002

    const-string v3, "print_coupon_fragment"

    invoke-virtual {v1, v2, v0, v3}, Landroid/app/FragmentTransaction;->add(ILandroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/FragmentTransaction;->commit()I

    .line 55
    :cond_0
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/PrintCouponActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 56
    if-eqz v0, :cond_1

    .line 57
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 58
    :cond_1
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 3

    .prologue
    .line 62
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    const v1, 0x102002c

    if-ne v0, v1, :cond_1

    .line 63
    invoke-static {p0}, Landroid/support/v4/app/bd;->a(Landroid/app/Activity;)Landroid/content/Intent;

    move-result-object v0

    .line 69
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x10

    if-lt v1, v2, :cond_0

    invoke-static {p0, v0}, Landroid/support/v4/app/bd;->a(Landroid/app/Activity;Landroid/content/Intent;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 71
    invoke-static {p0}, Landroid/support/v4/app/dd;->a(Landroid/content/Context;)Landroid/support/v4/app/dd;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/support/v4/app/dd;->a(Landroid/app/Activity;)Landroid/support/v4/app/dd;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/dd;->a()V

    .line 75
    :goto_0
    const/4 v0, 0x1

    .line 78
    :goto_1
    return v0

    .line 73
    :cond_0
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/PrintCouponActivity;->finish()V

    goto :goto_0

    .line 78
    :cond_1
    invoke-super {p0, p1}, Landroid/app/Activity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_1
.end method

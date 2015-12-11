.class public Lcom/wishabi/flipp/app/CouponDetailsActivity;
.super Landroid/app/Activity;
.source "SourceFile"

# interfaces
.implements Lcom/wishabi/flipp/app/dm;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method

.method public static a(Landroid/os/Bundle;)Landroid/content/Intent;
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 32
    if-nez p0, :cond_1

    .line 42
    :cond_0
    :goto_0
    return-object v0

    .line 35
    :cond_1
    invoke-static {}, Lcom/wishabi/flipp/app/FlippApplication;->b()Landroid/content/Context;

    move-result-object v1

    .line 36
    if-eqz v1, :cond_0

    .line 39
    new-instance v0, Landroid/content/Intent;

    const-class v2, Lcom/wishabi/flipp/app/CouponDetailsActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 40
    const-string v1, "coupon_details_fragment_params"

    invoke-virtual {v0, v1, p0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    goto :goto_0
.end method

.method public static a([IZLcom/wishabi/flipp/b/p;)Landroid/content/Intent;
    .locals 1

    .prologue
    .line 26
    invoke-static {p0, p1, p2}, Lcom/wishabi/flipp/app/n;->a([IZLcom/wishabi/flipp/b/p;)Landroid/os/Bundle;

    move-result-object v0

    .line 28
    invoke-static {v0}, Lcom/wishabi/flipp/app/CouponDetailsActivity;->a(Landroid/os/Bundle;)Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public final a(Ljava/lang/Class;Landroid/os/Bundle;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Landroid/os/Bundle;",
            ")V"
        }
    .end annotation

    .prologue
    .line 111
    const/4 v0, 0x0

    .line 112
    const-class v1, Lcom/wishabi/flipp/app/e;

    if-ne p1, v1, :cond_1

    .line 113
    invoke-static {p2}, Lcom/wishabi/flipp/app/BarcodeActivity;->a(Landroid/os/Bundle;)Landroid/content/Intent;

    move-result-object v0

    .line 117
    :cond_0
    :goto_0
    if-nez v0, :cond_2

    .line 123
    :goto_1
    return-void

    .line 114
    :cond_1
    const-class v1, Lcom/wishabi/flipp/app/z;

    if-ne p1, v1, :cond_0

    .line 115
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/wishabi/flipp/app/CouponHelpActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    goto :goto_0

    .line 120
    :cond_2
    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/CouponDetailsActivity;->startActivity(Landroid/content/Intent;)V

    .line 121
    const v0, 0x7f040001

    const v1, 0x7f040002

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/app/CouponDetailsActivity;->overridePendingTransition(II)V

    goto :goto_1
.end method

.method public final a(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 105
    invoke-virtual {p0, p1}, Lcom/wishabi/flipp/app/CouponDetailsActivity;->setTitle(Ljava/lang/CharSequence;)V

    .line 106
    return-void
.end method

.method public final a()Z
    .locals 1

    .prologue
    .line 127
    const/4 v0, 0x0

    return v0
.end method

.method public onBackPressed()V
    .locals 2

    .prologue
    .line 98
    invoke-super {p0}, Landroid/app/Activity;->onBackPressed()V

    .line 99
    const/high16 v0, 0x7f040000

    const v1, 0x7f040003

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/app/CouponDetailsActivity;->overridePendingTransition(II)V

    .line 101
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4

    .prologue
    const/4 v2, -0x1

    .line 47
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 49
    new-instance v0, Landroid/widget/FrameLayout;

    invoke-direct {v0, p0}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    new-instance v1, Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {v1, v2, v2}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/app/CouponDetailsActivity;->setContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 53
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/CouponDetailsActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    .line 54
    const-string v0, "coupon_details_fragment"

    invoke-virtual {v1, v0}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/app/n;

    .line 56
    if-nez v0, :cond_0

    .line 57
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/CouponDetailsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v2, "coupon_details_fragment_params"

    invoke-virtual {v0, v2}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 59
    invoke-static {v0}, Lcom/wishabi/flipp/app/n;->a(Landroid/os/Bundle;)Lcom/wishabi/flipp/app/n;

    move-result-object v0

    .line 61
    invoke-virtual {v1}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v1

    const v2, 0x1020002

    const-string v3, "coupon_details_fragment"

    invoke-virtual {v1, v2, v0, v3}, Landroid/app/FragmentTransaction;->add(ILandroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/FragmentTransaction;->commit()I

    .line 66
    :cond_0
    iput-object p0, v0, Lcom/wishabi/flipp/app/dl;->b:Lcom/wishabi/flipp/app/dm;

    .line 68
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/CouponDetailsActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 69
    if-eqz v0, :cond_1

    .line 70
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 71
    :cond_1
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 3

    .prologue
    .line 75
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    const v1, 0x102002c

    if-ne v0, v1, :cond_1

    .line 76
    invoke-static {p0}, Landroid/support/v4/app/bd;->a(Landroid/app/Activity;)Landroid/content/Intent;

    move-result-object v0

    .line 82
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x10

    if-lt v1, v2, :cond_0

    invoke-static {p0, v0}, Landroid/support/v4/app/bd;->a(Landroid/app/Activity;Landroid/content/Intent;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 84
    invoke-static {p0}, Landroid/support/v4/app/dd;->a(Landroid/content/Context;)Landroid/support/v4/app/dd;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/support/v4/app/dd;->a(Landroid/app/Activity;)Landroid/support/v4/app/dd;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/dd;->a()V

    .line 90
    :goto_0
    const/4 v0, 0x1

    .line 93
    :goto_1
    return v0

    .line 86
    :cond_0
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/CouponDetailsActivity;->finish()V

    .line 87
    const/high16 v0, 0x7f040000

    const v1, 0x7f040003

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/app/CouponDetailsActivity;->overridePendingTransition(II)V

    goto :goto_0

    .line 93
    :cond_1
    invoke-super {p0, p1}, Landroid/app/Activity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_1
.end method

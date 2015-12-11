.class public Lcom/wishabi/flipp/app/CouponHelpActivity;
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

    .line 88
    return-void
.end method


# virtual methods
.method public final a(Ljava/lang/Class;Landroid/os/Bundle;)V
    .locals 0
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
    .line 81
    return-void
.end method

.method public final a(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 77
    invoke-virtual {p0, p1}, Lcom/wishabi/flipp/app/CouponHelpActivity;->setTitle(Ljava/lang/CharSequence;)V

    .line 78
    return-void
.end method

.method public final a()Z
    .locals 1

    .prologue
    .line 85
    const/4 v0, 0x0

    return v0
.end method

.method public onBackPressed()V
    .locals 2

    .prologue
    .line 70
    invoke-super {p0}, Landroid/app/Activity;->onBackPressed()V

    .line 71
    const/high16 v0, 0x7f040000

    const v1, 0x7f040003

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/app/CouponHelpActivity;->overridePendingTransition(II)V

    .line 73
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4

    .prologue
    .line 26
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 28
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/CouponHelpActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    .line 29
    const-string v0, "coupon_help_fragment"

    invoke-virtual {v1, v0}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/app/z;

    .line 31
    if-nez v0, :cond_0

    .line 32
    new-instance v0, Lcom/wishabi/flipp/app/z;

    invoke-direct {v0}, Lcom/wishabi/flipp/app/z;-><init>()V

    .line 33
    invoke-virtual {v1}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v1

    const v2, 0x1020002

    const-string v3, "coupon_help_fragment"

    invoke-virtual {v1, v2, v0, v3}, Landroid/app/FragmentTransaction;->add(ILandroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/FragmentTransaction;->commit()I

    .line 38
    :cond_0
    iput-object p0, v0, Lcom/wishabi/flipp/app/dl;->b:Lcom/wishabi/flipp/app/dm;

    .line 40
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/CouponHelpActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 41
    if-eqz v0, :cond_1

    .line 42
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 43
    :cond_1
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 3

    .prologue
    .line 47
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    const v1, 0x102002c

    if-ne v0, v1, :cond_1

    .line 48
    invoke-static {p0}, Landroid/support/v4/app/bd;->a(Landroid/app/Activity;)Landroid/content/Intent;

    move-result-object v0

    .line 54
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x10

    if-lt v1, v2, :cond_0

    invoke-static {p0, v0}, Landroid/support/v4/app/bd;->a(Landroid/app/Activity;Landroid/content/Intent;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 56
    invoke-static {p0}, Landroid/support/v4/app/dd;->a(Landroid/content/Context;)Landroid/support/v4/app/dd;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/support/v4/app/dd;->a(Landroid/app/Activity;)Landroid/support/v4/app/dd;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/dd;->a()V

    .line 62
    :goto_0
    const/4 v0, 0x1

    .line 65
    :goto_1
    return v0

    .line 58
    :cond_0
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/CouponHelpActivity;->finish()V

    .line 59
    const/high16 v0, 0x7f040000

    const v1, 0x7f040003

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/app/CouponHelpActivity;->overridePendingTransition(II)V

    goto :goto_0

    .line 65
    :cond_1
    invoke-super {p0, p1}, Landroid/app/Activity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_1
.end method

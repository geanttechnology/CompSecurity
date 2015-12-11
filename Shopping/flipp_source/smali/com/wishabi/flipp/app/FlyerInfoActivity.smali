.class public Lcom/wishabi/flipp/app/FlyerInfoActivity;
.super Landroid/app/Activity;
.source "SourceFile"

# interfaces
.implements Lcom/wishabi/flipp/app/dm;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method

.method public static a(ILjava/lang/String;ZZ)Landroid/content/Intent;
    .locals 4

    .prologue
    .line 21
    invoke-static {p0, p1, p2, p3}, Lcom/wishabi/flipp/app/bx;->a(ILjava/lang/String;ZZ)Landroid/os/Bundle;

    move-result-object v1

    .line 23
    invoke-static {}, Lcom/wishabi/flipp/app/FlippApplication;->b()Landroid/content/Context;

    move-result-object v2

    if-nez v2, :cond_0

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Landroid/content/Intent;

    const-class v3, Lcom/wishabi/flipp/app/FlyerInfoActivity;

    invoke-direct {v0, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    const-string v2, "flyer_info_fragment_params"

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    goto :goto_0
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
    .line 95
    const/4 v0, 0x0

    .line 96
    const-class v1, Lcom/wishabi/flipp/app/fu;

    if-ne p1, v1, :cond_0

    .line 97
    invoke-static {p2}, Lcom/wishabi/flipp/app/WebViewActivity;->a(Landroid/os/Bundle;)Landroid/content/Intent;

    move-result-object v0

    .line 100
    :cond_0
    if-nez v0, :cond_1

    .line 106
    :goto_0
    return-void

    .line 103
    :cond_1
    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/FlyerInfoActivity;->startActivity(Landroid/content/Intent;)V

    .line 104
    const v0, 0x7f040001

    const v1, 0x7f040002

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/app/FlyerInfoActivity;->overridePendingTransition(II)V

    goto :goto_0
.end method

.method public final a(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 89
    invoke-virtual {p0, p1}, Lcom/wishabi/flipp/app/FlyerInfoActivity;->setTitle(Ljava/lang/CharSequence;)V

    .line 90
    return-void
.end method

.method public final a()Z
    .locals 1

    .prologue
    .line 110
    const/4 v0, 0x0

    return v0
.end method

.method public onBackPressed()V
    .locals 2

    .prologue
    .line 82
    invoke-super {p0}, Landroid/app/Activity;->onBackPressed()V

    .line 83
    const/high16 v0, 0x7f040000

    const v1, 0x7f040003

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/app/FlyerInfoActivity;->overridePendingTransition(II)V

    .line 85
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4

    .prologue
    .line 42
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 44
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FlyerInfoActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    .line 45
    const-string v1, "flyer_info"

    invoke-virtual {v0, v1}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/app/bx;

    .line 48
    if-nez v0, :cond_0

    .line 49
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FlyerInfoActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "flyer_info_fragment_params"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    .line 50
    new-instance v0, Lcom/wishabi/flipp/app/bx;

    invoke-direct {v0}, Lcom/wishabi/flipp/app/bx;-><init>()V

    .line 51
    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/app/bx;->setArguments(Landroid/os/Bundle;)V

    .line 52
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FlyerInfoActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v1

    const v2, 0x1020002

    const-string v3, "flyer_info"

    invoke-virtual {v1, v2, v0, v3}, Landroid/app/FragmentTransaction;->add(ILandroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/FragmentTransaction;->commit()I

    .line 56
    :cond_0
    iput-object p0, v0, Lcom/wishabi/flipp/app/dl;->b:Lcom/wishabi/flipp/app/dm;

    .line 58
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FlyerInfoActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 59
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FlyerInfoActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 60
    :cond_1
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2

    .prologue
    .line 64
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    const v1, 0x102002c

    if-ne v0, v1, :cond_1

    .line 65
    invoke-static {p0}, Landroid/support/v4/app/bd;->a(Landroid/app/Activity;)Landroid/content/Intent;

    move-result-object v0

    .line 66
    invoke-static {p0, v0}, Landroid/support/v4/app/bd;->a(Landroid/app/Activity;Landroid/content/Intent;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 67
    invoke-static {p0}, Landroid/support/v4/app/dd;->a(Landroid/content/Context;)Landroid/support/v4/app/dd;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/support/v4/app/dd;->a(Landroid/app/Activity;)Landroid/support/v4/app/dd;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/dd;->a()V

    .line 73
    :goto_0
    const/4 v0, 0x1

    .line 76
    :goto_1
    return v0

    .line 69
    :cond_0
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FlyerInfoActivity;->finish()V

    .line 70
    const/high16 v0, 0x7f040000

    const v1, 0x7f040003

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/app/FlyerInfoActivity;->overridePendingTransition(II)V

    goto :goto_0

    .line 76
    :cond_1
    invoke-super {p0, p1}, Landroid/app/Activity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_1
.end method

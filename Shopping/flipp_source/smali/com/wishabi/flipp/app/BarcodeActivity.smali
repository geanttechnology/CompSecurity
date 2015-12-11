.class public Lcom/wishabi/flipp/app/BarcodeActivity;
.super Landroid/app/Activity;
.source "SourceFile"

# interfaces
.implements Lcom/wishabi/flipp/app/dm;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method

.method public static a(Landroid/os/Bundle;)Landroid/content/Intent;
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 29
    if-nez p0, :cond_1

    .line 39
    :cond_0
    :goto_0
    return-object v0

    .line 32
    :cond_1
    invoke-static {}, Lcom/wishabi/flipp/app/FlippApplication;->b()Landroid/content/Context;

    move-result-object v1

    .line 33
    if-eqz v1, :cond_0

    .line 36
    new-instance v0, Landroid/content/Intent;

    const-class v2, Lcom/wishabi/flipp/app/BarcodeActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 37
    const-string v1, "barcode_fragment_params"

    invoke-virtual {v0, v1, p0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    goto :goto_0
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
    .line 103
    return-void
.end method

.method public final a(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 99
    invoke-virtual {p0, p1}, Lcom/wishabi/flipp/app/BarcodeActivity;->setTitle(Ljava/lang/CharSequence;)V

    .line 100
    return-void
.end method

.method public final a()Z
    .locals 1

    .prologue
    .line 107
    const/4 v0, 0x0

    return v0
.end method

.method public onBackPressed()V
    .locals 2

    .prologue
    .line 92
    invoke-super {p0}, Landroid/app/Activity;->onBackPressed()V

    .line 93
    const/high16 v0, 0x7f040000

    const v1, 0x7f040003

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/app/BarcodeActivity;->overridePendingTransition(II)V

    .line 95
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4

    .prologue
    const/4 v2, -0x1

    .line 44
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 46
    new-instance v0, Landroid/widget/FrameLayout;

    invoke-direct {v0, p0}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    new-instance v1, Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {v1, v2, v2}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/app/BarcodeActivity;->setContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 50
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/BarcodeActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    .line 51
    const-string v0, "barcode_fragment"

    invoke-virtual {v1, v0}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/app/e;

    .line 53
    if-nez v0, :cond_0

    .line 54
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/BarcodeActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v2, "barcode_fragment_params"

    invoke-virtual {v0, v2}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 55
    invoke-static {v0}, Lcom/wishabi/flipp/app/e;->a(Landroid/os/Bundle;)Lcom/wishabi/flipp/app/e;

    move-result-object v0

    .line 56
    invoke-virtual {v1}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v1

    const v2, 0x1020002

    const-string v3, "barcode_fragment"

    invoke-virtual {v1, v2, v0, v3}, Landroid/app/FragmentTransaction;->add(ILandroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/FragmentTransaction;->commit()I

    .line 60
    :cond_0
    iput-object p0, v0, Lcom/wishabi/flipp/app/dl;->b:Lcom/wishabi/flipp/app/dm;

    .line 62
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/BarcodeActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 63
    if-eqz v0, :cond_1

    .line 64
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 65
    :cond_1
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 3

    .prologue
    .line 69
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    const v1, 0x102002c

    if-ne v0, v1, :cond_1

    .line 70
    invoke-static {p0}, Landroid/support/v4/app/bd;->a(Landroid/app/Activity;)Landroid/content/Intent;

    move-result-object v0

    .line 76
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x10

    if-lt v1, v2, :cond_0

    invoke-static {p0, v0}, Landroid/support/v4/app/bd;->a(Landroid/app/Activity;Landroid/content/Intent;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 78
    invoke-static {p0}, Landroid/support/v4/app/dd;->a(Landroid/content/Context;)Landroid/support/v4/app/dd;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/support/v4/app/dd;->a(Landroid/app/Activity;)Landroid/support/v4/app/dd;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/dd;->a()V

    .line 84
    :goto_0
    const/4 v0, 0x1

    .line 87
    :goto_1
    return v0

    .line 80
    :cond_0
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/BarcodeActivity;->finish()V

    .line 81
    const/high16 v0, 0x7f040000

    const v1, 0x7f040003

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/app/BarcodeActivity;->overridePendingTransition(II)V

    goto :goto_0

    .line 87
    :cond_1
    invoke-super {p0, p1}, Landroid/app/Activity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_1
.end method

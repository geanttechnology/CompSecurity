.class public Lcom/wishabi/flipp/app/WebViewActivity;
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

.method public static a(Landroid/os/Bundle;)Landroid/content/Intent;
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 24
    if-nez p0, :cond_1

    .line 34
    :cond_0
    :goto_0
    return-object v0

    .line 27
    :cond_1
    invoke-static {}, Lcom/wishabi/flipp/app/FlippApplication;->b()Landroid/content/Context;

    move-result-object v1

    .line 28
    if-eqz v1, :cond_0

    .line 31
    new-instance v0, Landroid/content/Intent;

    const-class v2, Lcom/wishabi/flipp/app/WebViewActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 32
    const-string v1, "webview_fragment_params"

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
    .line 89
    return-void
.end method

.method public final a(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 85
    invoke-virtual {p0, p1}, Lcom/wishabi/flipp/app/WebViewActivity;->setTitle(Ljava/lang/CharSequence;)V

    .line 86
    return-void
.end method

.method public final a()Z
    .locals 1

    .prologue
    .line 93
    const/4 v0, 0x0

    return v0
.end method

.method public onBackPressed()V
    .locals 2

    .prologue
    .line 78
    invoke-super {p0}, Landroid/app/Activity;->onBackPressed()V

    .line 79
    const/high16 v0, 0x7f040000

    const v1, 0x7f040003

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/app/WebViewActivity;->overridePendingTransition(II)V

    .line 81
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4

    .prologue
    .line 39
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 41
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/WebViewActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    .line 42
    const-string v1, "webview"

    invoke-virtual {v0, v1}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/app/fu;

    .line 45
    if-nez v0, :cond_0

    .line 46
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/WebViewActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "webview_fragment_params"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    .line 47
    new-instance v0, Lcom/wishabi/flipp/app/fu;

    invoke-direct {v0}, Lcom/wishabi/flipp/app/fu;-><init>()V

    .line 48
    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/app/fu;->setArguments(Landroid/os/Bundle;)V

    .line 49
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/WebViewActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v1

    const v2, 0x1020002

    const-string v3, "webview"

    invoke-virtual {v1, v2, v0, v3}, Landroid/app/FragmentTransaction;->add(ILandroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/FragmentTransaction;->commit()I

    .line 53
    :cond_0
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/WebViewActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 54
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/WebViewActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 56
    :cond_1
    iput-object p0, v0, Lcom/wishabi/flipp/app/dl;->b:Lcom/wishabi/flipp/app/dm;

    .line 57
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2

    .prologue
    .line 61
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    const v1, 0x102002c

    if-ne v0, v1, :cond_1

    .line 62
    invoke-static {p0}, Landroid/support/v4/app/bd;->a(Landroid/app/Activity;)Landroid/content/Intent;

    move-result-object v0

    .line 63
    invoke-static {p0, v0}, Landroid/support/v4/app/bd;->a(Landroid/app/Activity;Landroid/content/Intent;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 64
    invoke-static {p0}, Landroid/support/v4/app/dd;->a(Landroid/content/Context;)Landroid/support/v4/app/dd;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/support/v4/app/dd;->a(Landroid/app/Activity;)Landroid/support/v4/app/dd;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/dd;->a()V

    .line 70
    :goto_0
    const/4 v0, 0x1

    .line 73
    :goto_1
    return v0

    .line 66
    :cond_0
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/WebViewActivity;->finish()V

    .line 67
    const/high16 v0, 0x7f040000

    const v1, 0x7f040003

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/app/WebViewActivity;->overridePendingTransition(II)V

    goto :goto_0

    .line 73
    :cond_1
    invoke-super {p0, p1}, Landroid/app/Activity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_1
.end method

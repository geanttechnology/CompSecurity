.class public Lcom/wishabi/flipp/app/SettingsActivity;
.super Landroid/app/Activity;
.source "SourceFile"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 60
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 29
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 30
    const v0, 0x7f0e0128

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/SettingsActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/SettingsActivity;->setTitle(Ljava/lang/CharSequence;)V

    .line 31
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/SettingsActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v0

    const v1, 0x1020002

    new-instance v2, Lcom/wishabi/flipp/app/eq;

    invoke-direct {v2}, Lcom/wishabi/flipp/app/eq;-><init>()V

    invoke-virtual {v0, v1, v2}, Landroid/app/FragmentTransaction;->replace(ILandroid/app/Fragment;)Landroid/app/FragmentTransaction;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/FragmentTransaction;->commit()I

    .line 34
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/SettingsActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 35
    if-eqz v0, :cond_0

    .line 36
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 37
    :cond_0
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 3

    .prologue
    .line 41
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    const v1, 0x102002c

    if-ne v0, v1, :cond_1

    .line 42
    invoke-static {p0}, Landroid/support/v4/app/bd;->a(Landroid/app/Activity;)Landroid/content/Intent;

    move-result-object v0

    .line 48
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x10

    if-lt v1, v2, :cond_0

    invoke-static {p0, v0}, Landroid/support/v4/app/bd;->a(Landroid/app/Activity;Landroid/content/Intent;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 50
    invoke-static {p0}, Landroid/support/v4/app/dd;->a(Landroid/content/Context;)Landroid/support/v4/app/dd;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/support/v4/app/dd;->a(Landroid/app/Activity;)Landroid/support/v4/app/dd;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/dd;->a()V

    .line 54
    :goto_0
    const/4 v0, 0x1

    .line 57
    :goto_1
    return v0

    .line 52
    :cond_0
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/SettingsActivity;->finish()V

    goto :goto_0

    .line 57
    :cond_1
    invoke-super {p0, p1}, Landroid/app/Activity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_1
.end method

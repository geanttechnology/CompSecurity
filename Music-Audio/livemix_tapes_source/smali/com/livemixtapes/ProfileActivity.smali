.class public Lcom/livemixtapes/ProfileActivity;
.super Lcom/livemixtapes/ui/BaseActivity;
.source "ProfileActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0}, Lcom/livemixtapes/ui/BaseActivity;-><init>()V

    return-void
.end method


# virtual methods
.method public onBackPressed()V
    .locals 2

    .prologue
    .line 72
    invoke-virtual {p0}, Lcom/livemixtapes/ProfileActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/FragmentManager;->getBackStackEntryCount()I

    move-result v0

    .line 74
    .local v0, "count":I
    if-eqz v0, :cond_1

    .line 78
    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 79
    invoke-virtual {p0}, Lcom/livemixtapes/ProfileActivity;->onResume()V

    .line 80
    :cond_0
    invoke-virtual {p0}, Lcom/livemixtapes/ProfileActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/FragmentManager;->popBackStack()V

    .line 82
    :cond_1
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 45
    const v0, 0x7f030031

    invoke-super {p0, p1, v0}, Lcom/livemixtapes/ui/BaseActivity;->onCreate(Landroid/os/Bundle;I)V

    .line 49
    invoke-virtual {p0}, Lcom/livemixtapes/ProfileActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    .line 50
    invoke-virtual {v0}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v0

    .line 51
    const v1, 0x7f0800cc

    new-instance v2, Lcom/livemixtapes/ProfileFragment;

    invoke-direct {v2}, Lcom/livemixtapes/ProfileFragment;-><init>()V

    invoke-virtual {v0, v1, v2}, Landroid/app/FragmentTransaction;->add(ILandroid/app/Fragment;)Landroid/app/FragmentTransaction;

    move-result-object v0

    .line 52
    invoke-virtual {v0}, Landroid/app/FragmentTransaction;->commit()I

    .line 53
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 2
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 58
    invoke-virtual {p0}, Lcom/livemixtapes/ProfileActivity;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v0

    .line 59
    .local v0, "inflator":Landroid/view/MenuInflater;
    const v1, 0x7f100002

    invoke-virtual {v0, v1, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 60
    const/4 v1, 0x1

    return v1
.end method

.method public bridge synthetic onCreateView(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;
    .locals 1

    .prologue
    .line 1
    invoke-super {p0, p1, p2, p3, p4}, Lcom/livemixtapes/ui/BaseActivity;->onCreateView(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic onCreateView(Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;
    .locals 1

    .prologue
    .line 1
    invoke-super {p0, p1, p2, p3}, Lcom/livemixtapes/ui/BaseActivity;->onCreateView(Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

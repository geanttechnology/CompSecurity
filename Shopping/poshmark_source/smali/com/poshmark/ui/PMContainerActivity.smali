.class public Lcom/poshmark/ui/PMContainerActivity;
.super Lcom/poshmark/ui/PMActivity;
.source "PMContainerActivity.java"


# instance fields
.field public backStackChangedListener:Landroid/support/v4/app/FragmentManager$OnBackStackChangedListener;

.field descendants:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field drawer:Lcom/poshmark/ui/customviews/PMDrawerLayout;

.field isFinishing:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 28
    invoke-direct {p0}, Lcom/poshmark/ui/PMActivity;-><init>()V

    .line 31
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/ui/PMContainerActivity;->isFinishing:Z

    .line 32
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/PMContainerActivity;->descendants:Ljava/util/List;

    .line 429
    new-instance v0, Lcom/poshmark/ui/PMContainerActivity$1;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/PMContainerActivity$1;-><init>(Lcom/poshmark/ui/PMContainerActivity;)V

    iput-object v0, p0, Lcom/poshmark/ui/PMContainerActivity;->backStackChangedListener:Landroid/support/v4/app/FragmentManager$OnBackStackChangedListener;

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/PMContainerActivity;)Lcom/poshmark/ui/fragments/PMFragment;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/PMContainerActivity;

    .prologue
    .line 28
    invoke-direct {p0}, Lcom/poshmark/ui/PMContainerActivity;->getTopFragmentFromBackStack()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v0

    return-object v0
.end method

.method private getTopFragmentFromBackStack()Lcom/poshmark/ui/fragments/PMFragment;
    .locals 3

    .prologue
    .line 411
    invoke-virtual {p0}, Lcom/poshmark/ui/PMContainerActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    .line 412
    .local v1, "fm":Landroid/support/v4/app/FragmentManager;
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->getBackStackEntryCount()I

    move-result v0

    .line 413
    .local v0, "count":I
    if-lez v0, :cond_0

    .line 414
    invoke-static {v0}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/fragments/PMFragment;

    .line 416
    :goto_0
    return-object v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method


# virtual methods
.method public closeDrawer()V
    .locals 2

    .prologue
    const/4 v1, 0x5

    .line 556
    const v0, 0x7f0c0048

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/PMContainerActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMDrawerLayout;

    iput-object v0, p0, Lcom/poshmark/ui/PMContainerActivity;->drawer:Lcom/poshmark/ui/customviews/PMDrawerLayout;

    .line 557
    iget-object v0, p0, Lcom/poshmark/ui/PMContainerActivity;->drawer:Lcom/poshmark/ui/customviews/PMDrawerLayout;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMDrawerLayout;->isDrawerOpen(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 558
    iget-object v0, p0, Lcom/poshmark/ui/PMContainerActivity;->drawer:Lcom/poshmark/ui/customviews/PMDrawerLayout;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMDrawerLayout;->closeDrawer(I)V

    .line 559
    :cond_0
    return-void
.end method

.method public enableDrawer(Z)V
    .locals 1
    .param p1, "flag"    # Z

    .prologue
    .line 447
    const v0, 0x7f0c0048

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/PMContainerActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMDrawerLayout;

    iput-object v0, p0, Lcom/poshmark/ui/PMContainerActivity;->drawer:Lcom/poshmark/ui/customviews/PMDrawerLayout;

    .line 448
    iget-object v0, p0, Lcom/poshmark/ui/PMContainerActivity;->drawer:Lcom/poshmark/ui/customviews/PMDrawerLayout;

    invoke-virtual {v0, p1}, Lcom/poshmark/ui/customviews/PMDrawerLayout;->enableDrawer(Z)V

    .line 449
    return-void
.end method

.method public getFragmentStack()Ljava/util/Stack;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Stack",
            "<",
            "Lcom/poshmark/ui/fragments/PMFragment;",
            ">;"
        }
    .end annotation

    .prologue
    .line 407
    const/4 v0, 0x0

    return-object v0
.end method

.method public getFragmentStackCount()I
    .locals 2

    .prologue
    .line 401
    invoke-virtual {p0}, Lcom/poshmark/ui/PMContainerActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 402
    .local v0, "fm":Landroid/support/v4/app/FragmentManager;
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->getBackStackEntryCount()I

    move-result v1

    return v1
.end method

.method public getScreenNavigationStack()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 131
    iget-object v0, p0, Lcom/poshmark/ui/PMContainerActivity;->descendants:Ljava/util/List;

    return-object v0
.end method

.method public getVisibleFragment()Lcom/poshmark/ui/fragments/PMFragment;
    .locals 3

    .prologue
    .line 374
    invoke-virtual {p0}, Lcom/poshmark/ui/PMContainerActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    .line 375
    .local v1, "fm":Landroid/support/v4/app/FragmentManager;
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->getBackStackEntryCount()I

    move-result v0

    .line 376
    .local v0, "count":I
    if-lez v0, :cond_0

    .line 377
    invoke-direct {p0}, Lcom/poshmark/ui/PMContainerActivity;->getTopFragmentFromBackStack()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v2

    .line 379
    :goto_0
    return-object v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public has_onSaveInstanceState_beenCalled()Z
    .locals 1

    .prologue
    .line 426
    iget-boolean v0, p0, Lcom/poshmark/ui/PMContainerActivity;->bSaveStateCalled:Z

    return v0
.end method

.method public hideDrawer()V
    .locals 1

    .prologue
    .line 515
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/PMContainerActivity;->enableDrawer(Z)V

    .line 516
    return-void
.end method

.method public isActivityInForeground()Z
    .locals 1

    .prologue
    .line 422
    iget-boolean v0, p0, Lcom/poshmark/ui/PMContainerActivity;->bIsInForeground:Z

    return v0
.end method

.method public isDrawerOpen()Z
    .locals 2

    .prologue
    .line 528
    const v0, 0x7f0c0048

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/PMContainerActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMDrawerLayout;

    iput-object v0, p0, Lcom/poshmark/ui/PMContainerActivity;->drawer:Lcom/poshmark/ui/customviews/PMDrawerLayout;

    .line 529
    iget-object v0, p0, Lcom/poshmark/ui/PMContainerActivity;->drawer:Lcom/poshmark/ui/customviews/PMDrawerLayout;

    if-eqz v0, :cond_0

    .line 530
    iget-object v0, p0, Lcom/poshmark/ui/PMContainerActivity;->drawer:Lcom/poshmark/ui/customviews/PMDrawerLayout;

    const/4 v1, 0x5

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMDrawerLayout;->isDrawerOpen(I)Z

    move-result v0

    .line 532
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public killDrawerFragment(Lcom/poshmark/ui/fragments/PMFragment;)V
    .locals 6
    .param p1, "ownerFragment"    # Lcom/poshmark/ui/fragments/PMFragment;

    .prologue
    const/4 v5, 0x0

    .line 496
    invoke-virtual {p0}, Lcom/poshmark/ui/PMContainerActivity;->has_onSaveInstanceState_beenCalled()Z

    move-result v4

    if-nez v4, :cond_1

    iget-boolean v4, p0, Lcom/poshmark/ui/PMContainerActivity;->isFinishing:Z

    if-nez v4, :cond_1

    .line 497
    invoke-virtual {p0}, Lcom/poshmark/ui/PMContainerActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v2

    .line 498
    .local v2, "fm":Landroid/support/v4/app/FragmentManager;
    invoke-virtual {p1}, Lcom/poshmark/ui/fragments/PMFragment;->getFragmentId()Ljava/util/UUID;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/fragments/PMFragment;

    .line 499
    .local v1, "drawerFragment":Lcom/poshmark/ui/fragments/PMFragment;
    if-eqz v1, :cond_1

    .line 500
    const v4, 0x7f0c0048

    invoke-virtual {p0, v4}, Lcom/poshmark/ui/PMContainerActivity;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/poshmark/ui/customviews/PMDrawerLayout;

    iput-object v4, p0, Lcom/poshmark/ui/PMContainerActivity;->drawer:Lcom/poshmark/ui/customviews/PMDrawerLayout;

    .line 501
    iget-object v4, p0, Lcom/poshmark/ui/PMContainerActivity;->drawer:Lcom/poshmark/ui/customviews/PMDrawerLayout;

    invoke-virtual {v4}, Lcom/poshmark/ui/customviews/PMDrawerLayout;->getCurrentFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v0

    .line 502
    .local v0, "currentDrawerFragment":Lcom/poshmark/ui/fragments/PMFragment;
    if-eqz v0, :cond_0

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/PMFragment;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 503
    iget-object v4, p0, Lcom/poshmark/ui/PMContainerActivity;->drawer:Lcom/poshmark/ui/customviews/PMDrawerLayout;

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/customviews/PMDrawerLayout;->setCurrentFragment(Lcom/poshmark/ui/fragments/PMFragment;)V

    .line 504
    iget-object v4, p0, Lcom/poshmark/ui/PMContainerActivity;->drawer:Lcom/poshmark/ui/customviews/PMDrawerLayout;

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/customviews/PMDrawerLayout;->setDrawerListener(Landroid/support/v4/widget/DrawerLayout$DrawerListener;)V

    .line 506
    :cond_0
    invoke-virtual {v2}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v3

    .line 507
    .local v3, "fragmentTransaction":Landroid/support/v4/app/FragmentTransaction;
    invoke-virtual {v3, v1}, Landroid/support/v4/app/FragmentTransaction;->remove(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 508
    invoke-virtual {v3}, Landroid/support/v4/app/FragmentTransaction;->commitAllowingStateLoss()I

    .line 509
    invoke-virtual {v2}, Landroid/support/v4/app/FragmentManager;->executePendingTransactions()Z

    .line 512
    .end local v0    # "currentDrawerFragment":Lcom/poshmark/ui/fragments/PMFragment;
    .end local v1    # "drawerFragment":Lcom/poshmark/ui/fragments/PMFragment;
    .end local v2    # "fm":Landroid/support/v4/app/FragmentManager;
    .end local v3    # "fragmentTransaction":Landroid/support/v4/app/FragmentTransaction;
    :cond_1
    return-void
.end method

.method public launchDialogFragmentForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V
    .locals 6
    .param p1, "dataForFragment"    # Landroid/os/Bundle;
    .param p2, "fragmentClass"    # Ljava/lang/Class;
    .param p3, "data"    # Ljava/lang/Object;
    .param p4, "callingFragment"    # Lcom/poshmark/ui/fragments/PMFragment;
    .param p5, "requestCode"    # I

    .prologue
    .line 313
    :try_start_0
    invoke-virtual {p2}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/fragments/PMDialogFragment;

    .line 314
    .local v2, "fragment":Lcom/poshmark/ui/fragments/PMDialogFragment;
    invoke-virtual {v2, p4, p5}, Lcom/poshmark/ui/fragments/PMDialogFragment;->setTargetFragment(Landroid/support/v4/app/Fragment;I)V

    .line 315
    invoke-virtual {v2, p1}, Lcom/poshmark/ui/fragments/PMDialogFragment;->setArguments(Landroid/os/Bundle;)V

    .line 316
    const/4 v5, 0x1

    invoke-virtual {v2, v5}, Lcom/poshmark/ui/fragments/PMDialogFragment;->setUserVisibleHint(Z)V

    .line 317
    if-eqz p3, :cond_0

    .line 318
    invoke-virtual {v2, p3}, Lcom/poshmark/ui/fragments/PMDialogFragment;->setFragmentData(Ljava/lang/Object;)V

    .line 321
    :cond_0
    invoke-virtual {p0}, Lcom/poshmark/ui/PMContainerActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    .line 322
    .local v1, "fm":Landroid/support/v4/app/FragmentManager;
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v3

    .line 323
    .local v3, "ft":Landroid/support/v4/app/FragmentTransaction;
    const-string v5, "dialog"

    invoke-virtual {v1, v5}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v4

    check-cast v4, Lcom/poshmark/ui/fragments/PMDialogFragment;

    .line 324
    .local v4, "prev":Lcom/poshmark/ui/fragments/PMDialogFragment;
    if-eqz v4, :cond_1

    .line 325
    invoke-virtual {v3, v4}, Landroid/support/v4/app/FragmentTransaction;->remove(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 327
    :cond_1
    const/4 v5, 0x0

    invoke-virtual {v3, v5}, Landroid/support/v4/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 329
    const-string v5, "dialog"

    invoke-virtual {v2, v1, v5}, Lcom/poshmark/ui/fragments/PMDialogFragment;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/InstantiationException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_2

    .line 341
    .end local v1    # "fm":Landroid/support/v4/app/FragmentManager;
    .end local v2    # "fragment":Lcom/poshmark/ui/fragments/PMDialogFragment;
    .end local v3    # "ft":Landroid/support/v4/app/FragmentTransaction;
    .end local v4    # "prev":Lcom/poshmark/ui/fragments/PMDialogFragment;
    :goto_0
    return-void

    .line 331
    :catch_0
    move-exception v0

    .line 333
    .local v0, "e":Ljava/lang/InstantiationException;
    invoke-virtual {v0}, Ljava/lang/InstantiationException;->printStackTrace()V

    goto :goto_0

    .line 334
    .end local v0    # "e":Ljava/lang/InstantiationException;
    :catch_1
    move-exception v0

    .line 336
    .local v0, "e":Ljava/lang/IllegalAccessException;
    invoke-virtual {v0}, Ljava/lang/IllegalAccessException;->printStackTrace()V

    goto :goto_0

    .line 337
    .end local v0    # "e":Ljava/lang/IllegalAccessException;
    :catch_2
    move-exception v0

    .line 339
    .local v0, "e":Ljava/lang/IllegalArgumentException;
    invoke-virtual {v0}, Ljava/lang/IllegalArgumentException;->printStackTrace()V

    goto :goto_0
.end method

.method public launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V
    .locals 7
    .param p1, "dataForFragment"    # Landroid/os/Bundle;
    .param p2, "fragmentClass"    # Ljava/lang/Class;
    .param p3, "data"    # Ljava/lang/Object;

    .prologue
    .line 181
    :try_start_0
    invoke-virtual {p2}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/poshmark/ui/fragments/PMFragment;

    .line 182
    .local v3, "fragment":Lcom/poshmark/ui/fragments/PMFragment;
    invoke-virtual {v3, p1}, Lcom/poshmark/ui/fragments/PMFragment;->setArguments(Landroid/os/Bundle;)V

    .line 183
    const/4 v5, 0x1

    invoke-virtual {v3, v5}, Lcom/poshmark/ui/fragments/PMFragment;->setUserVisibleHint(Z)V

    .line 184
    if-eqz p3, :cond_0

    .line 185
    invoke-virtual {v3, p3}, Lcom/poshmark/ui/fragments/PMFragment;->setFragmentData(Ljava/lang/Object;)V

    .line 187
    :cond_0
    iget-object v5, p0, Lcom/poshmark/ui/PMContainerActivity;->descendants:Ljava/util/List;

    invoke-virtual {v3, v5}, Lcom/poshmark/ui/fragments/PMFragment;->setNavigationList(Ljava/util/List;)V

    .line 189
    invoke-virtual {p0}, Lcom/poshmark/ui/PMContainerActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v2

    .line 190
    .local v2, "fm":Landroid/support/v4/app/FragmentManager;
    invoke-virtual {v2}, Landroid/support/v4/app/FragmentManager;->getBackStackEntryCount()I

    move-result v0

    .line 191
    .local v0, "count":I
    invoke-virtual {v2}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v4

    .line 192
    .local v4, "transaction":Landroid/support/v4/app/FragmentTransaction;
    const v5, 0x7f0c0049

    add-int/lit8 v6, v0, 0x1

    invoke-static {v6}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v3, v6}, Landroid/support/v4/app/FragmentTransaction;->replace(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 193
    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Landroid/support/v4/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 194
    invoke-virtual {v4}, Landroid/support/v4/app/FragmentTransaction;->commit()I
    :try_end_0
    .catch Ljava/lang/InstantiationException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_2

    .line 207
    .end local v0    # "count":I
    .end local v2    # "fm":Landroid/support/v4/app/FragmentManager;
    .end local v3    # "fragment":Lcom/poshmark/ui/fragments/PMFragment;
    .end local v4    # "transaction":Landroid/support/v4/app/FragmentTransaction;
    :goto_0
    return-void

    .line 197
    :catch_0
    move-exception v1

    .line 199
    .local v1, "e":Ljava/lang/InstantiationException;
    invoke-virtual {v1}, Ljava/lang/InstantiationException;->printStackTrace()V

    goto :goto_0

    .line 200
    .end local v1    # "e":Ljava/lang/InstantiationException;
    :catch_1
    move-exception v1

    .line 202
    .local v1, "e":Ljava/lang/IllegalAccessException;
    invoke-virtual {v1}, Ljava/lang/IllegalAccessException;->printStackTrace()V

    goto :goto_0

    .line 203
    .end local v1    # "e":Ljava/lang/IllegalAccessException;
    :catch_2
    move-exception v1

    .line 205
    .local v1, "e":Ljava/lang/IllegalArgumentException;
    invoke-virtual {v1}, Ljava/lang/IllegalArgumentException;->printStackTrace()V

    goto :goto_0
.end method

.method public launchFragmentForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V
    .locals 7
    .param p1, "dataForFragment"    # Landroid/os/Bundle;
    .param p2, "fragmentClass"    # Ljava/lang/Class;
    .param p3, "data"    # Ljava/lang/Object;
    .param p4, "callingFragment"    # Lcom/poshmark/ui/fragments/PMFragment;
    .param p5, "requestCode"    # I

    .prologue
    .line 213
    :try_start_0
    invoke-virtual {p2}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/poshmark/ui/fragments/PMFragment;

    .line 214
    .local v3, "fragment":Lcom/poshmark/ui/fragments/PMFragment;
    invoke-virtual {v3, p4, p5}, Lcom/poshmark/ui/fragments/PMFragment;->setTargetFragment(Landroid/support/v4/app/Fragment;I)V

    .line 215
    invoke-virtual {v3, p1}, Lcom/poshmark/ui/fragments/PMFragment;->setArguments(Landroid/os/Bundle;)V

    .line 216
    const/4 v5, 0x1

    invoke-virtual {v3, v5}, Lcom/poshmark/ui/fragments/PMFragment;->setUserVisibleHint(Z)V

    .line 217
    if-eqz p3, :cond_0

    .line 218
    invoke-virtual {v3, p3}, Lcom/poshmark/ui/fragments/PMFragment;->setFragmentData(Ljava/lang/Object;)V

    .line 220
    :cond_0
    iget-object v5, p0, Lcom/poshmark/ui/PMContainerActivity;->descendants:Ljava/util/List;

    invoke-virtual {v3, v5}, Lcom/poshmark/ui/fragments/PMFragment;->setNavigationList(Ljava/util/List;)V

    .line 222
    invoke-virtual {p0}, Lcom/poshmark/ui/PMContainerActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v2

    .line 223
    .local v2, "fm":Landroid/support/v4/app/FragmentManager;
    invoke-virtual {v2}, Landroid/support/v4/app/FragmentManager;->getBackStackEntryCount()I

    move-result v0

    .line 224
    .local v0, "count":I
    invoke-virtual {v2}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v4

    .line 225
    .local v4, "transaction":Landroid/support/v4/app/FragmentTransaction;
    const v5, 0x7f0c0049

    add-int/lit8 v6, v0, 0x1

    invoke-static {v6}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v3, v6}, Landroid/support/v4/app/FragmentTransaction;->replace(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 226
    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Landroid/support/v4/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 227
    invoke-virtual {v4}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 228
    invoke-virtual {v2}, Landroid/support/v4/app/FragmentManager;->executePendingTransactions()Z
    :try_end_0
    .catch Ljava/lang/InstantiationException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_2

    .line 242
    .end local v0    # "count":I
    .end local v2    # "fm":Landroid/support/v4/app/FragmentManager;
    .end local v3    # "fragment":Lcom/poshmark/ui/fragments/PMFragment;
    .end local v4    # "transaction":Landroid/support/v4/app/FragmentTransaction;
    :goto_0
    return-void

    .line 232
    :catch_0
    move-exception v1

    .line 234
    .local v1, "e":Ljava/lang/InstantiationException;
    invoke-virtual {v1}, Ljava/lang/InstantiationException;->printStackTrace()V

    goto :goto_0

    .line 235
    .end local v1    # "e":Ljava/lang/InstantiationException;
    :catch_1
    move-exception v1

    .line 237
    .local v1, "e":Ljava/lang/IllegalAccessException;
    invoke-virtual {v1}, Ljava/lang/IllegalAccessException;->printStackTrace()V

    goto :goto_0

    .line 238
    .end local v1    # "e":Ljava/lang/IllegalAccessException;
    :catch_2
    move-exception v1

    .line 240
    .local v1, "e":Ljava/lang/IllegalArgumentException;
    invoke-virtual {v1}, Ljava/lang/IllegalArgumentException;->printStackTrace()V

    goto :goto_0
.end method

.method public launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V
    .locals 4
    .param p1, "dataForFragment"    # Landroid/os/Bundle;
    .param p2, "fragmentClass"    # Ljava/lang/Class;
    .param p3, "data"    # Ljava/lang/Object;

    .prologue
    .line 246
    new-instance v1, Landroid/content/Intent;

    const-class v2, Lcom/poshmark/ui/PMContainerActivity;

    invoke-direct {v1, p0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 247
    .local v1, "intent":Landroid/content/Intent;
    const-string v2, "FRAGMENT"

    invoke-virtual {v1, v2, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 248
    const-string v2, "FRAGMENT_DATA"

    invoke-virtual {v1, v2, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 250
    if-eqz p3, :cond_0

    .line 251
    invoke-static {}, Lcom/poshmark/utils/ObjectPickupDropOff;->getUniqueKey()Ljava/util/UUID;

    move-result-object v0

    .line 252
    .local v0, "id":Ljava/util/UUID;
    invoke-static {v0, p3}, Lcom/poshmark/utils/ObjectPickupDropOff;->dropOffDataObject(Ljava/util/UUID;Ljava/lang/Object;)V

    .line 253
    const-string v2, "DATAKEY"

    new-instance v3, Landroid/os/ParcelUuid;

    invoke-direct {v3, v0}, Landroid/os/ParcelUuid;-><init>(Ljava/util/UUID;)V

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 257
    .end local v0    # "id":Ljava/util/UUID;
    :cond_0
    iget-object v2, p0, Lcom/poshmark/ui/PMContainerActivity;->descendants:Ljava/util/List;

    if-eqz v2, :cond_1

    .line 258
    invoke-static {}, Lcom/poshmark/utils/ObjectPickupDropOff;->getUniqueKey()Ljava/util/UUID;

    move-result-object v0

    .line 259
    .restart local v0    # "id":Ljava/util/UUID;
    iget-object v2, p0, Lcom/poshmark/ui/PMContainerActivity;->descendants:Ljava/util/List;

    invoke-static {v0, v2}, Lcom/poshmark/utils/ObjectPickupDropOff;->dropOffDataObject(Ljava/util/UUID;Ljava/lang/Object;)V

    .line 260
    const-string v2, "SCREENSTACK"

    new-instance v3, Landroid/os/ParcelUuid;

    invoke-direct {v3, v0}, Landroid/os/ParcelUuid;-><init>(Ljava/util/UUID;)V

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 262
    .end local v0    # "id":Ljava/util/UUID;
    :cond_1
    invoke-virtual {p0, v1}, Lcom/poshmark/ui/PMContainerActivity;->startActivity(Landroid/content/Intent;)V

    .line 263
    return-void
.end method

.method public launchFragmentInNewActivityForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V
    .locals 5
    .param p1, "dataForFragment"    # Landroid/os/Bundle;
    .param p2, "fragmentClass"    # Ljava/lang/Class;
    .param p3, "data"    # Ljava/lang/Object;
    .param p4, "callingFragment"    # Lcom/poshmark/ui/fragments/PMFragment;
    .param p5, "requestCode"    # I

    .prologue
    .line 280
    new-instance v1, Landroid/content/Intent;

    const-class v3, Lcom/poshmark/ui/PMContainerActivity;

    invoke-direct {v1, p0, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 281
    .local v1, "intent":Landroid/content/Intent;
    const-string v3, "FRAGMENT"

    invoke-virtual {v1, v3, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 282
    const-string v3, "FRAGMENT_DATA"

    invoke-virtual {v1, v3, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 284
    if-eqz p3, :cond_0

    .line 285
    invoke-static {}, Lcom/poshmark/utils/ObjectPickupDropOff;->getUniqueKey()Ljava/util/UUID;

    move-result-object v0

    .line 286
    .local v0, "id":Ljava/util/UUID;
    invoke-static {v0, p3}, Lcom/poshmark/utils/ObjectPickupDropOff;->dropOffDataObject(Ljava/util/UUID;Ljava/lang/Object;)V

    .line 287
    const-string v3, "DATAKEY"

    new-instance v4, Landroid/os/ParcelUuid;

    invoke-direct {v4, v0}, Landroid/os/ParcelUuid;-><init>(Ljava/util/UUID;)V

    invoke-virtual {v1, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 291
    .end local v0    # "id":Ljava/util/UUID;
    :cond_0
    iget-object v3, p0, Lcom/poshmark/ui/PMContainerActivity;->descendants:Ljava/util/List;

    if-eqz v3, :cond_1

    .line 292
    invoke-static {}, Lcom/poshmark/utils/ObjectPickupDropOff;->getUniqueKey()Ljava/util/UUID;

    move-result-object v0

    .line 293
    .restart local v0    # "id":Ljava/util/UUID;
    iget-object v3, p0, Lcom/poshmark/ui/PMContainerActivity;->descendants:Ljava/util/List;

    invoke-static {v0, v3}, Lcom/poshmark/utils/ObjectPickupDropOff;->dropOffDataObject(Ljava/util/UUID;Ljava/lang/Object;)V

    .line 294
    const-string v3, "SCREENSTACK"

    new-instance v4, Landroid/os/ParcelUuid;

    invoke-direct {v4, v0}, Landroid/os/ParcelUuid;-><init>(Ljava/util/UUID;)V

    invoke-virtual {v1, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 297
    .end local v0    # "id":Ljava/util/UUID;
    :cond_1
    invoke-virtual {p4}, Lcom/poshmark/ui/fragments/PMFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v2

    .line 298
    .local v2, "parent":Landroid/support/v4/app/Fragment;
    if-eqz v2, :cond_2

    .line 299
    invoke-virtual {v2, v1, p5}, Landroid/support/v4/app/Fragment;->startActivityForResult(Landroid/content/Intent;I)V

    .line 304
    :goto_0
    return-void

    .line 301
    :cond_2
    invoke-virtual {p4, v1, p5}, Lcom/poshmark/ui/fragments/PMFragment;->startActivityForResult(Landroid/content/Intent;I)V

    goto :goto_0
.end method

.method public launchSearchActivity()V
    .locals 0

    .prologue
    .line 276
    return-void
.end method

.method public lockDrawer()V
    .locals 2

    .prologue
    .line 542
    const v0, 0x7f0c0048

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/PMContainerActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMDrawerLayout;

    iput-object v0, p0, Lcom/poshmark/ui/PMContainerActivity;->drawer:Lcom/poshmark/ui/customviews/PMDrawerLayout;

    .line 543
    iget-object v0, p0, Lcom/poshmark/ui/PMContainerActivity;->drawer:Lcom/poshmark/ui/customviews/PMDrawerLayout;

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMDrawerLayout;->setDrawerLockMode(I)V

    .line 544
    return-void
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 1
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 79
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/PMActivity;->onActivityResult(IILandroid/content/Intent;)V

    .line 80
    invoke-static {p1}, Lcom/facebook/FacebookSdk;->isFacebookRequestCode(I)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 81
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->getCallbackManager()Lcom/facebook/CallbackManager;

    move-result-object v0

    invoke-interface {v0, p1, p2, p3}, Lcom/facebook/CallbackManager;->onActivityResult(IILandroid/content/Intent;)Z

    .line 87
    :cond_0
    :goto_0
    return-void

    .line 82
    :cond_1
    sget v0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->GP_REQUEST:I

    if-ne p1, v0, :cond_2

    .line 83
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;

    move-result-object v0

    invoke-virtual {v0, p1, p2, p3}, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;->handleResultFromActivity(IILandroid/content/Intent;)V

    goto :goto_0

    .line 84
    :cond_2
    const/16 v0, 0x2244

    if-eq p1, v0, :cond_3

    const/16 v0, 0x2516

    if-ne p1, v0, :cond_0

    .line 85
    :cond_3
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;

    move-result-object v0

    invoke-virtual {v0, p1, p2, p3}, Lcom/poshmark/fb_tmblr_twitter/PinterestHelper;->onActivityResult(IILandroid/content/Intent;)V

    goto :goto_0
.end method

.method public onBackPressed()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 92
    invoke-virtual {p0}, Lcom/poshmark/ui/PMContainerActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    .line 93
    .local v1, "fm":Landroid/support/v4/app/FragmentManager;
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->getBackStackEntryCount()I

    move-result v0

    .line 94
    .local v0, "count":I
    if-nez v0, :cond_1

    .line 95
    invoke-super {p0}, Lcom/poshmark/ui/PMActivity;->onBackPressed()V

    .line 122
    :cond_0
    :goto_0
    return-void

    .line 97
    :cond_1
    invoke-direct {p0}, Lcom/poshmark/ui/PMContainerActivity;->getTopFragmentFromBackStack()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v2

    .line 98
    .local v2, "fragment":Lcom/poshmark/ui/fragments/PMFragment;
    if-eqz v2, :cond_3

    .line 99
    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/PMFragment;->handleBack()Z

    move-result v3

    if-nez v3, :cond_0

    .line 100
    if-ne v0, v4, :cond_2

    .line 101
    iput-boolean v4, p0, Lcom/poshmark/ui/PMContainerActivity;->isFinishing:Z

    .line 102
    invoke-virtual {p0}, Lcom/poshmark/ui/PMContainerActivity;->finish()V

    goto :goto_0

    .line 104
    :cond_2
    invoke-virtual {p0, v2}, Lcom/poshmark/ui/PMContainerActivity;->killDrawerFragment(Lcom/poshmark/ui/fragments/PMFragment;)V

    .line 105
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->popBackStack()V

    goto :goto_0

    .line 113
    :cond_3
    if-ne v0, v4, :cond_4

    .line 114
    iput-boolean v4, p0, Lcom/poshmark/ui/PMContainerActivity;->isFinishing:Z

    .line 115
    invoke-virtual {p0}, Lcom/poshmark/ui/PMContainerActivity;->finish()V

    goto :goto_0

    .line 117
    :cond_4
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->popBackStack()V

    goto :goto_0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 7
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 43
    invoke-super {p0, p1}, Lcom/poshmark/ui/PMActivity;->onCreate(Landroid/os/Bundle;)V

    .line 44
    const v6, 0x7f030033

    invoke-virtual {p0, v6}, Lcom/poshmark/ui/PMContainerActivity;->setContentView(I)V

    .line 45
    if-nez p1, :cond_2

    .line 46
    invoke-virtual {p0}, Lcom/poshmark/ui/PMContainerActivity;->getIntent()Landroid/content/Intent;

    move-result-object v6

    invoke-virtual {v6}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v2

    .line 47
    .local v2, "extras":Landroid/os/Bundle;
    if-eqz v2, :cond_2

    .line 48
    const-string v6, "FRAGMENT"

    invoke-virtual {v2, v6}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v4

    check-cast v4, Ljava/lang/Class;

    .line 49
    .local v4, "fragmentClass":Ljava/lang/Class;
    const-string v6, "FRAGMENT_DATA"

    invoke-virtual {v2, v6}, Landroid/os/Bundle;->getBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    .line 50
    .local v1, "dataToPassToFragment":Landroid/os/Bundle;
    if-eqz v4, :cond_2

    .line 52
    const/4 v0, 0x0

    .line 53
    .local v0, "complexData":Ljava/lang/Object;
    const-string v6, "DATAKEY"

    invoke-virtual {v2, v6}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v5

    check-cast v5, Landroid/os/ParcelUuid;

    .line 54
    .local v5, "parcelUuid":Landroid/os/ParcelUuid;
    if-eqz v5, :cond_0

    .line 55
    invoke-virtual {v5}, Landroid/os/ParcelUuid;->getUuid()Ljava/util/UUID;

    move-result-object v6

    invoke-static {v6}, Lcom/poshmark/utils/ObjectPickupDropOff;->pickupDataObject(Ljava/util/UUID;)Ljava/lang/Object;

    move-result-object v0

    .line 59
    .end local v0    # "complexData":Ljava/lang/Object;
    :cond_0
    const-string v6, "SCREENSTACK"

    invoke-virtual {v2, v6}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v5

    .end local v5    # "parcelUuid":Landroid/os/ParcelUuid;
    check-cast v5, Landroid/os/ParcelUuid;

    .line 60
    .restart local v5    # "parcelUuid":Landroid/os/ParcelUuid;
    if-eqz v5, :cond_1

    .line 61
    invoke-virtual {v5}, Landroid/os/ParcelUuid;->getUuid()Ljava/util/UUID;

    move-result-object v6

    invoke-static {v6}, Lcom/poshmark/utils/ObjectPickupDropOff;->pickupDataObject(Ljava/util/UUID;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/List;

    iput-object v6, p0, Lcom/poshmark/ui/PMContainerActivity;->descendants:Ljava/util/List;

    .line 64
    :cond_1
    invoke-virtual {p0, v1, v4, v0}, Lcom/poshmark/ui/PMContainerActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 72
    .end local v1    # "dataToPassToFragment":Landroid/os/Bundle;
    .end local v2    # "extras":Landroid/os/Bundle;
    .end local v4    # "fragmentClass":Ljava/lang/Class;
    .end local v5    # "parcelUuid":Landroid/os/ParcelUuid;
    :cond_2
    invoke-virtual {p0}, Lcom/poshmark/ui/PMContainerActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v3

    .line 73
    .local v3, "fm":Landroid/support/v4/app/FragmentManager;
    iget-object v6, p0, Lcom/poshmark/ui/PMContainerActivity;->backStackChangedListener:Landroid/support/v4/app/FragmentManager$OnBackStackChangedListener;

    invoke-virtual {v3, v6}, Landroid/support/v4/app/FragmentManager;->addOnBackStackChangedListener(Landroid/support/v4/app/FragmentManager$OnBackStackChangedListener;)V

    .line 75
    return-void
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .locals 0
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 38
    invoke-super {p0, p1}, Lcom/poshmark/ui/PMActivity;->onNewIntent(Landroid/content/Intent;)V

    .line 39
    return-void
.end method

.method protected onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 389
    invoke-super {p0, p1}, Lcom/poshmark/ui/PMActivity;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 391
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/PMContainerActivity;->bSaveStateCalled:Z

    .line 392
    return-void
.end method

.method public onSearchRequested()Z
    .locals 1

    .prologue
    .line 396
    const/4 v0, 0x0

    return v0
.end method

.method public openDrawer()V
    .locals 2

    .prologue
    .line 551
    const v0, 0x7f0c0048

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/PMContainerActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMDrawerLayout;

    iput-object v0, p0, Lcom/poshmark/ui/PMContainerActivity;->drawer:Lcom/poshmark/ui/customviews/PMDrawerLayout;

    .line 552
    iget-object v0, p0, Lcom/poshmark/ui/PMContainerActivity;->drawer:Lcom/poshmark/ui/customviews/PMDrawerLayout;

    const/4 v1, 0x5

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMDrawerLayout;->openDrawer(I)V

    .line 553
    return-void
.end method

.method public openDrawerDelayed()V
    .locals 0

    .prologue
    .line 548
    return-void
.end method

.method public popTopFragment()V
    .locals 3

    .prologue
    .line 345
    invoke-virtual {p0}, Lcom/poshmark/ui/PMContainerActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    .line 346
    .local v1, "fm":Landroid/support/v4/app/FragmentManager;
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->getBackStackEntryCount()I

    move-result v0

    .line 347
    .local v0, "count":I
    const/4 v2, 0x1

    if-ne v0, v2, :cond_0

    .line 348
    invoke-virtual {p0}, Lcom/poshmark/ui/PMContainerActivity;->finish()V

    .line 353
    :goto_0
    return-void

    .line 350
    :cond_0
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->popBackStack()V

    goto :goto_0
.end method

.method public popTopNFragments(IZ)V
    .locals 2
    .param p1, "popCount"    # I
    .param p2, "bImmediate"    # Z

    .prologue
    .line 357
    invoke-virtual {p0}, Lcom/poshmark/ui/PMContainerActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    .line 358
    .local v1, "fm":Landroid/support/v4/app/FragmentManager;
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->getBackStackEntryCount()I

    move-result v0

    .line 359
    .local v0, "count":I
    if-le v0, p1, :cond_1

    .line 360
    :goto_0
    if-lez p1, :cond_1

    .line 361
    if-eqz p2, :cond_0

    .line 362
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->popBackStackImmediate()Z

    .line 367
    :goto_1
    add-int/lit8 p1, p1, -0x1

    goto :goto_0

    .line 364
    :cond_0
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->popBackStack()V

    goto :goto_1

    .line 370
    :cond_1
    return-void
.end method

.method public replaceFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V
    .locals 8
    .param p1, "dataForFragment"    # Landroid/os/Bundle;
    .param p2, "fragmentClass"    # Ljava/lang/Class;
    .param p3, "data"    # Ljava/lang/Object;

    .prologue
    .line 145
    :try_start_0
    invoke-virtual {p2}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/poshmark/ui/fragments/PMFragment;

    .line 146
    .local v4, "fragment":Lcom/poshmark/ui/fragments/PMFragment;
    invoke-virtual {v4, p1}, Lcom/poshmark/ui/fragments/PMFragment;->setArguments(Landroid/os/Bundle;)V

    .line 147
    const/4 v6, 0x1

    invoke-virtual {v4, v6}, Lcom/poshmark/ui/fragments/PMFragment;->setUserVisibleHint(Z)V

    .line 148
    if-eqz p3, :cond_0

    .line 149
    invoke-virtual {v4, p3}, Lcom/poshmark/ui/fragments/PMFragment;->setFragmentData(Ljava/lang/Object;)V

    .line 151
    :cond_0
    iget-object v6, p0, Lcom/poshmark/ui/PMContainerActivity;->descendants:Ljava/util/List;

    invoke-virtual {v4, v6}, Lcom/poshmark/ui/fragments/PMFragment;->setNavigationList(Ljava/util/List;)V

    .line 153
    invoke-virtual {p0}, Lcom/poshmark/ui/PMContainerActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v3

    .line 154
    .local v3, "fm":Landroid/support/v4/app/FragmentManager;
    invoke-virtual {v3}, Landroid/support/v4/app/FragmentManager;->getBackStackEntryCount()I

    move-result v0

    .line 155
    .local v0, "count":I
    invoke-virtual {v3}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v5

    .line 156
    .local v5, "transaction":Landroid/support/v4/app/FragmentTransaction;
    invoke-virtual {p0}, Lcom/poshmark/ui/PMContainerActivity;->getVisibleFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v1

    .line 157
    .local v1, "currentFragment":Lcom/poshmark/ui/fragments/PMFragment;
    if-eqz v1, :cond_1

    .line 158
    const/4 v6, 0x0

    invoke-virtual {v1, v6}, Lcom/poshmark/ui/fragments/PMFragment;->setUserVisibleHint(Z)V

    .line 159
    invoke-virtual {v5, v1}, Landroid/support/v4/app/FragmentTransaction;->hide(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 161
    :cond_1
    const v6, 0x7f0c0049

    add-int/lit8 v7, v0, 0x1

    invoke-static {v7}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v6, v4, v7}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 162
    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Landroid/support/v4/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 163
    invoke-virtual {v5}, Landroid/support/v4/app/FragmentTransaction;->commit()I
    :try_end_0
    .catch Ljava/lang/InstantiationException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_2

    .line 175
    .end local v0    # "count":I
    .end local v1    # "currentFragment":Lcom/poshmark/ui/fragments/PMFragment;
    .end local v3    # "fm":Landroid/support/v4/app/FragmentManager;
    .end local v4    # "fragment":Lcom/poshmark/ui/fragments/PMFragment;
    .end local v5    # "transaction":Landroid/support/v4/app/FragmentTransaction;
    :goto_0
    return-void

    .line 165
    :catch_0
    move-exception v2

    .line 167
    .local v2, "e":Ljava/lang/InstantiationException;
    invoke-virtual {v2}, Ljava/lang/InstantiationException;->printStackTrace()V

    goto :goto_0

    .line 168
    .end local v2    # "e":Ljava/lang/InstantiationException;
    :catch_1
    move-exception v2

    .line 170
    .local v2, "e":Ljava/lang/IllegalAccessException;
    invoke-virtual {v2}, Ljava/lang/IllegalAccessException;->printStackTrace()V

    goto :goto_0

    .line 171
    .end local v2    # "e":Ljava/lang/IllegalAccessException;
    :catch_2
    move-exception v2

    .line 173
    .local v2, "e":Ljava/lang/IllegalArgumentException;
    invoke-virtual {v2}, Ljava/lang/IllegalArgumentException;->printStackTrace()V

    goto :goto_0
.end method

.method public setDrawerData(Ljava/lang/Class;Lcom/poshmark/ui/fragments/PMFragment;Ljava/lang/Object;)Lcom/poshmark/ui/fragments/PMFragment;
    .locals 8
    .param p1, "fragmentClass"    # Ljava/lang/Class;
    .param p2, "owner"    # Lcom/poshmark/ui/fragments/PMFragment;
    .param p3, "fragmentData"    # Ljava/lang/Object;

    .prologue
    .line 452
    const/4 v2, 0x0

    .line 453
    .local v2, "drawerFragment":Lcom/poshmark/ui/fragments/PMFragment;
    invoke-virtual {p0}, Lcom/poshmark/ui/PMContainerActivity;->has_onSaveInstanceState_beenCalled()Z

    move-result v6

    if-nez v6, :cond_1

    .line 454
    const v6, 0x7f0c0048

    invoke-virtual {p0, v6}, Lcom/poshmark/ui/PMContainerActivity;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Lcom/poshmark/ui/customviews/PMDrawerLayout;

    iput-object v6, p0, Lcom/poshmark/ui/PMContainerActivity;->drawer:Lcom/poshmark/ui/customviews/PMDrawerLayout;

    .line 455
    invoke-virtual {p0}, Lcom/poshmark/ui/PMContainerActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v4

    .line 457
    .local v4, "fm":Landroid/support/v4/app/FragmentManager;
    invoke-virtual {p2}, Lcom/poshmark/ui/fragments/PMFragment;->getFragmentId()Ljava/util/UUID;

    move-result-object v6

    invoke-virtual {v6}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v2

    .end local v2    # "drawerFragment":Lcom/poshmark/ui/fragments/PMFragment;
    check-cast v2, Lcom/poshmark/ui/fragments/PMFragment;

    .line 458
    .restart local v2    # "drawerFragment":Lcom/poshmark/ui/fragments/PMFragment;
    if-nez v2, :cond_2

    .line 460
    :try_start_0
    invoke-virtual {p1}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v6

    move-object v0, v6

    check-cast v0, Lcom/poshmark/ui/fragments/PMFragment;

    move-object v2, v0

    .line 461
    invoke-virtual {v2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->setFragmentData(Ljava/lang/Object;)V

    .line 462
    invoke-virtual {v4}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v5

    .line 464
    .local v5, "fragmentTransaction":Landroid/support/v4/app/FragmentTransaction;
    iget-object v6, p0, Lcom/poshmark/ui/PMContainerActivity;->drawer:Lcom/poshmark/ui/customviews/PMDrawerLayout;

    invoke-virtual {v6}, Lcom/poshmark/ui/customviews/PMDrawerLayout;->getCurrentFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v1

    .line 465
    .local v1, "currentDrawerFragment":Lcom/poshmark/ui/fragments/PMFragment;
    if-eqz v1, :cond_0

    .line 466
    invoke-virtual {v5, v1}, Landroid/support/v4/app/FragmentTransaction;->hide(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 468
    :cond_0
    iget-object v6, p0, Lcom/poshmark/ui/PMContainerActivity;->drawer:Lcom/poshmark/ui/customviews/PMDrawerLayout;

    invoke-virtual {v6, v2}, Lcom/poshmark/ui/customviews/PMDrawerLayout;->setCurrentFragment(Lcom/poshmark/ui/fragments/PMFragment;)V

    .line 469
    const v6, 0x7f0c004b

    invoke-virtual {p2}, Lcom/poshmark/ui/fragments/PMFragment;->getFragmentId()Ljava/util/UUID;

    move-result-object v7

    invoke-virtual {v7}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v6, v2, v7}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 470
    invoke-virtual {v5}, Landroid/support/v4/app/FragmentTransaction;->commit()I
    :try_end_0
    .catch Ljava/lang/InstantiationException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_1

    .line 492
    .end local v1    # "currentDrawerFragment":Lcom/poshmark/ui/fragments/PMFragment;
    .end local v4    # "fm":Landroid/support/v4/app/FragmentManager;
    .end local v5    # "fragmentTransaction":Landroid/support/v4/app/FragmentTransaction;
    :cond_1
    :goto_0
    return-object v2

    .line 472
    .restart local v4    # "fm":Landroid/support/v4/app/FragmentManager;
    :catch_0
    move-exception v3

    .line 473
    .local v3, "e":Ljava/lang/InstantiationException;
    invoke-virtual {v3}, Ljava/lang/InstantiationException;->printStackTrace()V

    goto :goto_0

    .line 474
    .end local v3    # "e":Ljava/lang/InstantiationException;
    :catch_1
    move-exception v3

    .line 475
    .local v3, "e":Ljava/lang/IllegalAccessException;
    invoke-virtual {v3}, Ljava/lang/IllegalAccessException;->printStackTrace()V

    goto :goto_0

    .line 478
    .end local v3    # "e":Ljava/lang/IllegalAccessException;
    :cond_2
    invoke-virtual {v4}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v5

    .line 481
    .restart local v5    # "fragmentTransaction":Landroid/support/v4/app/FragmentTransaction;
    iget-object v6, p0, Lcom/poshmark/ui/PMContainerActivity;->drawer:Lcom/poshmark/ui/customviews/PMDrawerLayout;

    invoke-virtual {v6}, Lcom/poshmark/ui/customviews/PMDrawerLayout;->getCurrentFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v1

    .line 482
    .restart local v1    # "currentDrawerFragment":Lcom/poshmark/ui/fragments/PMFragment;
    if-eqz v1, :cond_3

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/PMFragment;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_1

    .line 483
    :cond_3
    if-eqz v1, :cond_4

    .line 484
    invoke-virtual {v5, v1}, Landroid/support/v4/app/FragmentTransaction;->hide(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 486
    :cond_4
    iget-object v6, p0, Lcom/poshmark/ui/PMContainerActivity;->drawer:Lcom/poshmark/ui/customviews/PMDrawerLayout;

    invoke-virtual {v6, v2}, Lcom/poshmark/ui/customviews/PMDrawerLayout;->setCurrentFragment(Lcom/poshmark/ui/fragments/PMFragment;)V

    .line 487
    invoke-virtual {v5, v2}, Landroid/support/v4/app/FragmentTransaction;->show(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 488
    invoke-virtual {v5}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    goto :goto_0
.end method

.method public setDrawerListener(Landroid/support/v4/widget/DrawerLayout$DrawerListener;)V
    .locals 1
    .param p1, "listener"    # Landroid/support/v4/widget/DrawerLayout$DrawerListener;

    .prologue
    .line 537
    const v0, 0x7f0c0048

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/PMContainerActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMDrawerLayout;

    iput-object v0, p0, Lcom/poshmark/ui/PMContainerActivity;->drawer:Lcom/poshmark/ui/customviews/PMDrawerLayout;

    .line 538
    iget-object v0, p0, Lcom/poshmark/ui/PMContainerActivity;->drawer:Lcom/poshmark/ui/customviews/PMDrawerLayout;

    invoke-virtual {v0, p1}, Lcom/poshmark/ui/customviews/PMDrawerLayout;->setDrawerListener(Landroid/support/v4/widget/DrawerLayout$DrawerListener;)V

    .line 539
    return-void
.end method

.method public setScreenNavigationStack(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 126
    .local p1, "list":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/poshmark/ui/PMContainerActivity;->descendants:Ljava/util/List;

    .line 127
    return-void
.end method

.method public toggleDrawer()V
    .locals 2

    .prologue
    const/4 v1, 0x5

    .line 519
    const v0, 0x7f0c0048

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/PMContainerActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMDrawerLayout;

    iput-object v0, p0, Lcom/poshmark/ui/PMContainerActivity;->drawer:Lcom/poshmark/ui/customviews/PMDrawerLayout;

    .line 520
    iget-object v0, p0, Lcom/poshmark/ui/PMContainerActivity;->drawer:Lcom/poshmark/ui/customviews/PMDrawerLayout;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMDrawerLayout;->isDrawerOpen(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 521
    iget-object v0, p0, Lcom/poshmark/ui/PMContainerActivity;->drawer:Lcom/poshmark/ui/customviews/PMDrawerLayout;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMDrawerLayout;->closeDrawer(I)V

    .line 525
    :goto_0
    return-void

    .line 523
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/PMContainerActivity;->drawer:Lcom/poshmark/ui/customviews/PMDrawerLayout;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMDrawerLayout;->openDrawer(I)V

    goto :goto_0
.end method

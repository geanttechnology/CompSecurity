.class public abstract Lcom/poshmark/ui/fragments/PMFragment;
.super Landroid/support/v4/app/Fragment;
.source "PMFragment.java"

# interfaces
.implements Lcom/poshmark/notifications/PMNotificationListener;
.implements Lcom/newrelic/agent/android/api/v2/TraceFieldInterface;


# annotations
.annotation build Lcom/newrelic/agent/android/instrumentation/Instrumented;
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/ui/fragments/PMFragment$FRAGMENT_TYPE;
    }
.end annotation


# instance fields
.field ancestorList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field bShouldHideActionBar:Z

.field bUpdateOnShow:Z

.field dialog:Lcom/poshmark/ui/customviews/PMProgressDialog;

.field drawerButtonListener:Landroid/view/View$OnClickListener;

.field private fragmentData:Ljava/lang/Object;

.field fragmentId:Ljava/util/UUID;

.field protected fragmentType:Lcom/poshmark/ui/fragments/PMFragment$FRAGMENT_TYPE;

.field fragmentViewsAlive:Z

.field fragmentVisible:Z

.field trackingList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field protected viewNameForAnalytics:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 44
    invoke-direct {p0}, Landroid/support/v4/app/Fragment;-><init>()V

    .line 53
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/PMFragment;->fragmentData:Ljava/lang/Object;

    .line 54
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/PMFragment;->bShouldHideActionBar:Z

    .line 55
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/PMFragment;->bUpdateOnShow:Z

    .line 58
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/PMFragment;->fragmentViewsAlive:Z

    .line 59
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/PMFragment;->fragmentVisible:Z

    .line 687
    new-instance v0, Lcom/poshmark/ui/fragments/PMFragment$1;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/PMFragment$1;-><init>(Lcom/poshmark/ui/fragments/PMFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/PMFragment;->drawerButtonListener:Landroid/view/View$OnClickListener;

    return-void
.end method

.method private createProgressDialogWithMessage(Ljava/lang/String;Z)V
    .locals 3
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "disableNav"    # Z

    .prologue
    const/4 v0, 0x0

    .line 321
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PMFragment;->dialog:Lcom/poshmark/ui/customviews/PMProgressDialog;

    if-nez v1, :cond_0

    .line 322
    new-instance v1, Lcom/poshmark/ui/customviews/PMProgressDialog;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/poshmark/ui/customviews/PMProgressDialog;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/poshmark/ui/fragments/PMFragment;->dialog:Lcom/poshmark/ui/customviews/PMProgressDialog;

    .line 324
    :cond_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PMFragment;->dialog:Lcom/poshmark/ui/customviews/PMProgressDialog;

    invoke-virtual {v1, v0}, Lcom/poshmark/ui/customviews/PMProgressDialog;->setAutoHideFlag(Z)V

    .line 325
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PMFragment;->dialog:Lcom/poshmark/ui/customviews/PMProgressDialog;

    if-nez p2, :cond_1

    const/4 v0, 0x1

    :cond_1
    invoke-virtual {v1, v0}, Lcom/poshmark/ui/customviews/PMProgressDialog;->setCancelable(Z)V

    .line 326
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PMFragment;->dialog:Lcom/poshmark/ui/customviews/PMProgressDialog;

    invoke-virtual {v0, p1}, Lcom/poshmark/ui/customviews/PMProgressDialog;->setMessage(Ljava/lang/String;)V

    .line 327
    return-void
.end method

.method private trackViewForAnalytics()V
    .locals 2

    .prologue
    .line 269
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/PMFragment;->viewNameForAnalytics:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/poshmark/analytics/Analytics;->trackView(Ljava/lang/String;)V

    .line 270
    return-void
.end method

.method private updateActionbarVisibility()V
    .locals 2

    .prologue
    .line 755
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 756
    .local v0, "actionBar":Landroid/app/ActionBar;
    iget-boolean v1, p0, Lcom/poshmark/ui/fragments/PMFragment;->bShouldHideActionBar:Z

    if-eqz v1, :cond_0

    .line 757
    invoke-virtual {v0}, Landroid/app/ActionBar;->hide()V

    .line 761
    :goto_0
    return-void

    .line 759
    :cond_0
    invoke-virtual {v0}, Landroid/app/ActionBar;->show()V

    goto :goto_0
.end method


# virtual methods
.method public finishActivity()V
    .locals 1

    .prologue
    .line 291
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 292
    .local v0, "parent":Landroid/app/Activity;
    if-eqz v0, :cond_0

    .line 293
    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    .line 295
    :cond_0
    return-void
.end method

.method public finishActivityWithResult(ILandroid/content/Intent;)V
    .locals 1
    .param p1, "resultCode"    # I
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 298
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 299
    .local v0, "parent":Landroid/app/Activity;
    if-eqz v0, :cond_0

    .line 300
    invoke-virtual {v0, p1, p2}, Landroid/app/Activity;->setResult(ILandroid/content/Intent;)V

    .line 301
    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    .line 303
    :cond_0
    return-void
.end method

.method public getDrawerActionButton(I)Landroid/widget/Button;
    .locals 4
    .param p1, "buttonId"    # I

    .prologue
    .line 677
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v4/app/FragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 678
    .local v0, "actionBar":Landroid/app/ActionBar;
    invoke-virtual {v0}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v2

    .line 679
    .local v2, "customView":Landroid/view/View;
    if-eqz v2, :cond_0

    .line 680
    invoke-virtual {v2, p1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 684
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;
    .locals 1
    .param p1, "objectClass"    # Ljava/lang/Class;

    .prologue
    .line 313
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PMFragment;->fragmentData:Ljava/lang/Object;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/ui/fragments/PMFragment;->fragmentData:Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 314
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PMFragment;->fragmentData:Ljava/lang/Object;

    .line 317
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getFragmentId()Ljava/util/UUID;
    .locals 1

    .prologue
    .line 287
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PMFragment;->fragmentId:Ljava/util/UUID;

    return-object v0
.end method

.method public getNextActionButton()Landroid/widget/Button;
    .locals 4

    .prologue
    .line 528
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v4/app/FragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 529
    .local v0, "actionBar":Landroid/app/ActionBar;
    invoke-virtual {v0}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v2

    .line 530
    .local v2, "customView":Landroid/view/View;
    if-eqz v2, :cond_0

    .line 531
    const v3, 0x7f0c003d

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 532
    .local v1, "actionButton":Landroid/widget/Button;
    const/4 v3, 0x0

    invoke-virtual {v1, v3}, Landroid/widget/Button;->setVisibility(I)V

    .line 535
    .end local v1    # "actionButton":Landroid/widget/Button;
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getParentActivity()Lcom/poshmark/ui/PMActivity;
    .locals 1

    .prologue
    .line 226
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    return-object v0
.end method

.method protected getTrackingLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 112
    const/4 v0, 0x0

    return-object v0
.end method

.method protected getTrackingList()Ljava/util/List;
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
    .line 122
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PMFragment;->trackingList:Ljava/util/List;

    return-object v0
.end method

.method public getViewNameForAnalytics()Ljava/lang/String;
    .locals 1

    .prologue
    .line 265
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PMFragment;->viewNameForAnalytics:Ljava/lang/String;

    return-object v0
.end method

.method public handleBack()Z
    .locals 1

    .prologue
    .line 372
    const/4 v0, 0x0

    return v0
.end method

.method public handleNotification(Landroid/content/Intent;)V
    .locals 0
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 234
    return-void
.end method

.method public handleResponse(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "data"    # Landroid/os/Bundle;

    .prologue
    .line 279
    return-void
.end method

.method public hideActionBar(Z)V
    .locals 0
    .param p1, "hideFlag"    # Z

    .prologue
    .line 764
    iput-boolean p1, p0, Lcom/poshmark/ui/fragments/PMFragment;->bShouldHideActionBar:Z

    .line 765
    return-void
.end method

.method protected hideActivityDrawer()V
    .locals 1

    .prologue
    .line 523
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMContainerActivity;

    .line 524
    .local v0, "parent":Lcom/poshmark/ui/PMContainerActivity;
    invoke-virtual {v0}, Lcom/poshmark/ui/PMContainerActivity;->hideDrawer()V

    .line 525
    return-void
.end method

.method public hideAllActionButtons(Z)V
    .locals 13
    .param p1, "hide"    # Z

    .prologue
    const/4 v12, 0x0

    const/16 v11, 0x8

    const/4 v10, 0x0

    .line 696
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v9

    invoke-virtual {v9}, Landroid/support/v4/app/FragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 697
    .local v0, "actionBar":Landroid/app/ActionBar;
    invoke-virtual {v0}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v2

    .line 698
    .local v2, "customView":Landroid/view/View;
    if-eqz v2, :cond_6

    .line 699
    const v9, 0x7f0c0033

    invoke-virtual {v2, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/FrameLayout;

    .line 700
    .local v4, "layout":Landroid/widget/FrameLayout;
    if-eqz v4, :cond_3

    .line 701
    invoke-virtual {v4}, Landroid/widget/FrameLayout;->getChildCount()I

    move-result v1

    .line 702
    .local v1, "childCount":I
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    if-ge v3, v1, :cond_3

    .line 703
    invoke-virtual {v4, v3}, Landroid/widget/FrameLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v8

    .line 704
    .local v8, "v":Landroid/view/View;
    instance-of v9, v8, Landroid/widget/ImageButton;

    if-nez v9, :cond_0

    instance-of v9, v8, Landroid/widget/Button;

    if-eqz v9, :cond_1

    .line 705
    :cond_0
    if-eqz p1, :cond_2

    .line 706
    const/4 v9, 0x4

    invoke-virtual {v8, v9}, Landroid/view/View;->setVisibility(I)V

    .line 707
    invoke-virtual {v8, v12}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 702
    :cond_1
    :goto_1
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 709
    :cond_2
    invoke-virtual {v8, v10}, Landroid/view/View;->setVisibility(I)V

    goto :goto_1

    .line 716
    .end local v1    # "childCount":I
    .end local v3    # "i":I
    .end local v8    # "v":Landroid/view/View;
    :cond_3
    const v9, 0x7f0c0039

    invoke-virtual {v2, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/ImageButton;

    .line 717
    .local v6, "searchButton":Landroid/widget/ImageButton;
    if-eqz v6, :cond_4

    .line 718
    if-eqz p1, :cond_7

    .line 719
    invoke-virtual {v6, v11}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 720
    invoke-virtual {v6, v12}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 727
    :cond_4
    :goto_2
    const v9, 0x7f0c003c

    invoke-virtual {v2, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/ImageButton;

    .line 728
    .local v5, "refreshButton":Landroid/widget/ImageButton;
    if-eqz v5, :cond_5

    .line 729
    if-eqz p1, :cond_8

    .line 730
    invoke-virtual {v5, v11}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 731
    invoke-virtual {v5, v12}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 738
    :cond_5
    :goto_3
    invoke-virtual {p0, v10}, Lcom/poshmark/ui/fragments/PMFragment;->showFindPeopleButton(Z)V

    .line 741
    const v9, 0x7f0c0036

    invoke-virtual {v2, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/TextView;

    .line 742
    .local v7, "subTitleTextView":Landroid/widget/TextView;
    if-eqz v7, :cond_6

    .line 743
    if-eqz p1, :cond_9

    .line 744
    invoke-virtual {v7, v11}, Landroid/widget/TextView;->setVisibility(I)V

    .line 752
    .end local v4    # "layout":Landroid/widget/FrameLayout;
    .end local v5    # "refreshButton":Landroid/widget/ImageButton;
    .end local v6    # "searchButton":Landroid/widget/ImageButton;
    .end local v7    # "subTitleTextView":Landroid/widget/TextView;
    :cond_6
    :goto_4
    return-void

    .line 722
    .restart local v4    # "layout":Landroid/widget/FrameLayout;
    .restart local v6    # "searchButton":Landroid/widget/ImageButton;
    :cond_7
    invoke-virtual {v6, v10}, Landroid/widget/ImageButton;->setVisibility(I)V

    goto :goto_2

    .line 733
    .restart local v5    # "refreshButton":Landroid/widget/ImageButton;
    :cond_8
    invoke-virtual {v5, v10}, Landroid/widget/ImageButton;->setVisibility(I)V

    goto :goto_3

    .line 746
    .restart local v7    # "subTitleTextView":Landroid/widget/TextView;
    :cond_9
    invoke-virtual {v7, v10}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_4
.end method

.method public hideKeyboard()V
    .locals 3

    .prologue
    .line 449
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const-string v2, "input_method"

    invoke-virtual {v1, v2}, Landroid/support/v4/app/FragmentActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 450
    .local v0, "imm":Landroid/view/inputmethod/InputMethodManager;
    invoke-virtual {v0}, Landroid/view/inputmethod/InputMethodManager;->isAcceptingText()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 451
    const/4 v1, 0x1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/inputmethod/InputMethodManager;->toggleSoftInput(II)V

    .line 453
    :cond_0
    return-void
.end method

.method public hideProgressDialog()V
    .locals 1

    .prologue
    .line 366
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PMFragment;->dialog:Lcom/poshmark/ui/customviews/PMProgressDialog;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/ui/fragments/PMFragment;->dialog:Lcom/poshmark/ui/customviews/PMProgressDialog;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMProgressDialog;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 367
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PMFragment;->dialog:Lcom/poshmark/ui/customviews/PMProgressDialog;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMProgressDialog;->dismiss()V

    .line 369
    :cond_0
    return-void
.end method

.method public logScreenTracking()V
    .locals 5

    .prologue
    .line 247
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/PMContainerActivity;

    .line 248
    .local v2, "parentActivity":Lcom/poshmark/ui/PMContainerActivity;
    if-eqz v2, :cond_1

    .line 250
    iget-object v3, p0, Lcom/poshmark/ui/fragments/PMFragment;->trackingList:Ljava/util/List;

    if-eqz v3, :cond_2

    .line 251
    iget-object v3, p0, Lcom/poshmark/ui/fragments/PMFragment;->trackingList:Ljava/util/List;

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/PMContainerActivity;->setScreenNavigationStack(Ljava/util/List;)V

    .line 252
    iget-object v3, p0, Lcom/poshmark/ui/fragments/PMFragment;->trackingList:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 253
    .local v0, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    new-instance v1, Ljava/lang/String;

    invoke-direct {v1}, Ljava/lang/String;-><init>()V

    .line 254
    .local v1, "output":Ljava/lang/String;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 255
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 257
    :cond_0
    const-string v3, "BACKSTACK"

    invoke-static {v3, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 262
    .end local v0    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    .end local v1    # "output":Ljava/lang/String;
    :cond_1
    :goto_1
    return-void

    .line 259
    :cond_2
    iget-object v3, p0, Lcom/poshmark/ui/fragments/PMFragment;->trackingList:Ljava/util/List;

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/PMContainerActivity;->setScreenNavigationStack(Ljava/util/List;)V

    goto :goto_1
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 214
    invoke-super {p0, p1}, Landroid/support/v4/app/Fragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 215
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 174
    invoke-super {p0, p1}, Landroid/support/v4/app/Fragment;->onAttach(Landroid/app/Activity;)V

    .line 175
    return-void
.end method

.method public onContentChanged()V
    .locals 0

    .prologue
    .line 284
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 5

    .prologue
    const-string v2, "PMFragment"

    invoke-static {v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->startTracing(Ljava/lang/String;)V

    :try_start_0
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PMFragment;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;

    const-string v3, "PMFragment#onCreate"

    const/4 v4, 0x0

    invoke-static {v2, v3, v4}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_0

    .line 73
    :goto_0
    invoke-super {p0, p1}, Landroid/support/v4/app/Fragment;->onCreate(Landroid/os/Bundle;)V

    .line 76
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-static {v2}, Lcom/poshmark/config/NewRelicWrapper;->setNewRelicFragmentClassName(Ljava/lang/Class;)V

    .line 78
    invoke-virtual {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->pullParametersFromState(Landroid/os/Bundle;)V

    .line 80
    sget-object v2, Lcom/poshmark/ui/fragments/PMFragment$FRAGMENT_TYPE;->REGULAR:Lcom/poshmark/ui/fragments/PMFragment$FRAGMENT_TYPE;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/PMFragment;->fragmentType:Lcom/poshmark/ui/fragments/PMFragment$FRAGMENT_TYPE;

    .line 82
    if-eqz p1, :cond_2

    .line 83
    const-string v2, "FRAGMENT_ID"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/os/ParcelUuid;

    .line 84
    .local v0, "key":Landroid/os/ParcelUuid;
    if-eqz v0, :cond_0

    .line 85
    invoke-virtual {v0}, Landroid/os/ParcelUuid;->getUuid()Ljava/util/UUID;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/PMFragment;->fragmentId:Ljava/util/UUID;

    .line 87
    :cond_0
    const-string v2, "TRACKING_LIST"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    .end local v0    # "key":Landroid/os/ParcelUuid;
    check-cast v0, Landroid/os/ParcelUuid;

    .line 88
    .restart local v0    # "key":Landroid/os/ParcelUuid;
    if-eqz v0, :cond_1

    .line 89
    invoke-virtual {v0}, Landroid/os/ParcelUuid;->getUuid()Ljava/util/UUID;

    move-result-object v2

    invoke-static {v2}, Lcom/poshmark/utils/ObjectPickupDropOff;->pickupDataObject(Ljava/util/UUID;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/ArrayList;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/PMFragment;->trackingList:Ljava/util/List;

    .line 106
    .end local v0    # "key":Landroid/os/ParcelUuid;
    .local v1, "label":Ljava/lang/String;
    :cond_1
    :goto_1
    invoke-static {}, Lcom/newrelic/agent/android/tracing/TraceMachine;->exitMethod()V

    return-void

    .line 4294967295
    .end local v1    # "label":Ljava/lang/String;
    :catch_0
    move-exception v2

    const/4 v2, 0x0

    :try_start_1
    const-string v3, "PMFragment#onCreate"

    const/4 v4, 0x0

    invoke-static {v2, v3, v4}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    .line 93
    :cond_2
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/PMFragment;->fragmentId:Ljava/util/UUID;

    .line 95
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, p0, Lcom/poshmark/ui/fragments/PMFragment;->trackingList:Ljava/util/List;

    .line 96
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getTrackingLabel()Ljava/lang/String;

    move-result-object v1

    .line 97
    .restart local v1    # "label":Ljava/lang/String;
    if-eqz v1, :cond_3

    .line 98
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PMFragment;->trackingList:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 101
    :cond_3
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PMFragment;->ancestorList:Ljava/util/List;

    if-eqz v2, :cond_1

    .line 102
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PMFragment;->trackingList:Ljava/util/List;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/PMFragment;->ancestorList:Ljava/util/List;

    invoke-interface {v2, v3}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    goto :goto_1
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 4

    .prologue
    const/4 v3, 0x0

    :try_start_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PMFragment;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;

    const-string v1, "PMFragment#onCreateView"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_0

    .line 138
    :goto_0
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;->updateActionbarVisibility()V

    .line 139
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->setViewNameForAnalytics()V

    .line 140
    invoke-static {}, Lcom/newrelic/agent/android/tracing/TraceMachine;->exitMethod()V

    return-object v3

    .line 4294967295
    :catch_0
    move-exception v0

    const/4 v0, 0x0

    :try_start_1
    const-string v1, "PMFragment#onCreateView"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method

.method public onDestroy()V
    .locals 1

    .prologue
    .line 145
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onDestroy()V

    .line 146
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/poshmark/notifications/PMNotificationManager;->unregisterAllEvents(Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 147
    instance-of v0, p0, Lcom/poshmark/notifications/ListingNotificationHandler;

    if-eqz v0, :cond_0

    .line 148
    invoke-static {}, Lcom/poshmark/notifications/ListingNotificationManager;->getListingNotificationManager()Lcom/poshmark/notifications/ListingNotificationManager;

    move-result-object v0

    check-cast p0, Lcom/poshmark/notifications/ListingNotificationHandler;

    .end local p0    # "this":Lcom/poshmark/ui/fragments/PMFragment;
    invoke-virtual {v0, p0}, Lcom/poshmark/notifications/ListingNotificationManager;->unregisterListingMessageHandler(Lcom/poshmark/notifications/ListingNotificationHandler;)V

    .line 157
    :cond_0
    return-void
.end method

.method public onDestroyView()V
    .locals 1

    .prologue
    .line 208
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onDestroy()V

    .line 209
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/PMFragment;->fragmentViewsAlive:Z

    .line 210
    return-void
.end method

.method public onDetach()V
    .locals 0

    .prologue
    .line 179
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onDetach()V

    .line 180
    return-void
.end method

.method public onFragmentResult(Landroid/os/Bundle;I)V
    .locals 0
    .param p1, "b"    # Landroid/os/Bundle;
    .param p2, "requestCode"    # I

    .prologue
    .line 274
    return-void
.end method

.method public onLoadingComplete()V
    .locals 0

    .prologue
    .line 134
    return-void
.end method

.method public onPMResume()V
    .locals 2

    .prologue
    .line 237
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getUserVisibleHint()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 238
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->logScreenTracking()V

    .line 239
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->setupActionBar()V

    .line 240
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PMFragment;->fragmentType:Lcom/poshmark/ui/fragments/PMFragment$FRAGMENT_TYPE;

    sget-object v1, Lcom/poshmark/ui/fragments/PMFragment$FRAGMENT_TYPE;->DRAWER:Lcom/poshmark/ui/fragments/PMFragment$FRAGMENT_TYPE;

    if-eq v0, v1, :cond_0

    .line 241
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;->trackViewForAnalytics()V

    .line 244
    :cond_0
    return-void
.end method

.method public onPause()V
    .locals 0

    .prologue
    .line 203
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onPause()V

    .line 204
    return-void
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 193
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onResume()V

    .line 194
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PMFragment;->dialog:Lcom/poshmark/ui/customviews/PMProgressDialog;

    if-nez v0, :cond_0

    .line 195
    new-instance v0, Lcom/poshmark/ui/customviews/PMProgressDialog;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/poshmark/ui/customviews/PMProgressDialog;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/PMFragment;->dialog:Lcom/poshmark/ui/customviews/PMProgressDialog;

    .line 197
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/PMFragment;->fragmentViewsAlive:Z

    .line 198
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onPMResume()V

    .line 199
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 161
    invoke-super {p0, p1}, Landroid/support/v4/app/Fragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 162
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PMFragment;->fragmentId:Ljava/util/UUID;

    if-eqz v1, :cond_0

    .line 163
    const-string v1, "FRAGMENT_ID"

    new-instance v2, Landroid/os/ParcelUuid;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/PMFragment;->fragmentId:Ljava/util/UUID;

    invoke-direct {v2, v3}, Landroid/os/ParcelUuid;-><init>(Ljava/util/UUID;)V

    invoke-virtual {p1, v1, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 165
    :cond_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PMFragment;->trackingList:Ljava/util/List;

    if-eqz v1, :cond_1

    .line 166
    invoke-static {}, Lcom/poshmark/utils/ObjectPickupDropOff;->getUniqueKey()Ljava/util/UUID;

    move-result-object v0

    .line 167
    .local v0, "id":Ljava/util/UUID;
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PMFragment;->trackingList:Ljava/util/List;

    invoke-static {v0, v1}, Lcom/poshmark/utils/ObjectPickupDropOff;->dropOffDataObject(Ljava/util/UUID;Ljava/lang/Object;)V

    .line 168
    const-string v1, "TRACKING_LIST"

    new-instance v2, Landroid/os/ParcelUuid;

    invoke-direct {v2, v0}, Landroid/os/ParcelUuid;-><init>(Ljava/util/UUID;)V

    invoke-virtual {p1, v1, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 170
    .end local v0    # "id":Ljava/util/UUID;
    :cond_1
    return-void
.end method

.method protected onStart()V
    .locals 1

    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onStart()V

    invoke-static {}, Lcom/newrelic/agent/android/background/ApplicationStateMonitor;->getInstance()Lcom/newrelic/agent/android/background/ApplicationStateMonitor;

    move-result-object v0

    invoke-virtual {v0}, Lcom/newrelic/agent/android/background/ApplicationStateMonitor;->activityStarted()V

    return-void
.end method

.method public onStop()V
    .locals 1

    .prologue
    invoke-static {}, Lcom/newrelic/agent/android/background/ApplicationStateMonitor;->getInstance()Lcom/newrelic/agent/android/background/ApplicationStateMonitor;

    move-result-object v0

    invoke-virtual {v0}, Lcom/newrelic/agent/android/background/ApplicationStateMonitor;->activityStopped()V

    .line 185
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onStop()V

    .line 186
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PMFragment;->dialog:Lcom/poshmark/ui/customviews/PMProgressDialog;

    if-eqz v0, :cond_0

    .line 187
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PMFragment;->dialog:Lcom/poshmark/ui/customviews/PMProgressDialog;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMProgressDialog;->dismiss()V

    .line 189
    :cond_0
    return-void
.end method

.method protected pullParametersFromState(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 109
    return-void
.end method

.method public replaceTrackingLabel(Ljava/lang/String;)V
    .locals 2
    .param p1, "label"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 126
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PMFragment;->trackingList:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 127
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PMFragment;->trackingList:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    .line 128
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PMFragment;->trackingList:Ljava/util/List;

    invoke-interface {v0, v1, p1}, Ljava/util/List;->add(ILjava/lang/Object;)V

    .line 130
    :cond_0
    return-void
.end method

.method public setCutomRightImageButton(Landroid/graphics/drawable/Drawable;Landroid/view/View$OnClickListener;)V
    .locals 5
    .param p1, "background"    # Landroid/graphics/drawable/Drawable;
    .param p2, "listener"    # Landroid/view/View$OnClickListener;

    .prologue
    .line 539
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    .line 540
    .local v2, "activity":Landroid/app/Activity;
    if-nez v2, :cond_1

    .line 554
    :cond_0
    :goto_0
    return-void

    .line 543
    :cond_1
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-virtual {v4}, Landroid/support/v4/app/FragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 544
    .local v0, "actionBar":Landroid/app/ActionBar;
    if-eqz v0, :cond_0

    .line 547
    invoke-virtual {v0}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v3

    .line 548
    .local v3, "customView":Landroid/view/View;
    if-eqz v3, :cond_0

    .line 549
    const v4, 0x7f0c003b

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageButton;

    .line 550
    .local v1, "actionButton":Landroid/widget/ImageButton;
    invoke-virtual {v1, p1}, Landroid/widget/ImageButton;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 551
    const/4 v4, 0x0

    invoke-virtual {v1, v4}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 552
    invoke-virtual {v1, p2}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0
.end method

.method public setDrawerActionButton(Ljava/lang/Class;Lcom/poshmark/ui/fragments/PMFragment;ILjava/lang/Object;)Lcom/poshmark/ui/fragments/PMFragment;
    .locals 6
    .param p1, "fragment"    # Ljava/lang/Class;
    .param p2, "owner"    # Lcom/poshmark/ui/fragments/PMFragment;
    .param p3, "buttonId"    # I
    .param p4, "fragmentData"    # Ljava/lang/Object;

    .prologue
    .line 661
    const/4 v3, 0x0

    .line 662
    .local v3, "drawerFragment":Lcom/poshmark/ui/fragments/PMFragment;
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    invoke-virtual {v5}, Landroid/support/v4/app/FragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 663
    .local v0, "actionBar":Landroid/app/ActionBar;
    invoke-virtual {v0}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v2

    .line 664
    .local v2, "customView":Landroid/view/View;
    if-eqz v2, :cond_0

    .line 665
    invoke-virtual {v2, p3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 666
    .local v1, "actionButton":Landroid/view/View;
    const/4 v5, 0x0

    invoke-virtual {v1, v5}, Landroid/view/View;->setVisibility(I)V

    .line 667
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    check-cast v4, Lcom/poshmark/ui/PMContainerActivity;

    .line 668
    .local v4, "parent":Lcom/poshmark/ui/PMContainerActivity;
    invoke-virtual {v4, p1, p2, p4}, Lcom/poshmark/ui/PMContainerActivity;->setDrawerData(Ljava/lang/Class;Lcom/poshmark/ui/fragments/PMFragment;Ljava/lang/Object;)Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v3

    .line 669
    const/4 v5, 0x1

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/PMContainerActivity;->enableDrawer(Z)V

    .line 670
    iget-object v5, p0, Lcom/poshmark/ui/fragments/PMFragment;->drawerButtonListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v5}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 671
    invoke-virtual {v0}, Landroid/app/ActionBar;->show()V

    .line 673
    .end local v1    # "actionButton":Landroid/view/View;
    .end local v4    # "parent":Lcom/poshmark/ui/PMContainerActivity;
    :cond_0
    return-object v3
.end method

.method public setFindPeopleActionButtonListener(Landroid/view/View$OnClickListener;)V
    .locals 5
    .param p1, "listener"    # Landroid/view/View$OnClickListener;

    .prologue
    .line 573
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    .line 574
    .local v2, "activity":Landroid/app/Activity;
    if-nez v2, :cond_1

    .line 586
    :cond_0
    :goto_0
    return-void

    .line 577
    :cond_1
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-virtual {v4}, Landroid/support/v4/app/FragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 578
    .local v0, "actionBar":Landroid/app/ActionBar;
    if-eqz v0, :cond_0

    .line 581
    invoke-virtual {v0}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v3

    .line 582
    .local v3, "customView":Landroid/view/View;
    if-eqz v3, :cond_0

    .line 583
    const v4, 0x7f0c003a

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageButton;

    .line 584
    .local v1, "actionButton":Landroid/widget/ImageButton;
    invoke-virtual {v1, p1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0
.end method

.method public setFragmentData(Ljava/lang/Object;)V
    .locals 0
    .param p1, "data"    # Ljava/lang/Object;

    .prologue
    .line 306
    iput-object p1, p0, Lcom/poshmark/ui/fragments/PMFragment;->fragmentData:Ljava/lang/Object;

    .line 307
    return-void
.end method

.method public setFragmentVisibilityFlag(Z)V
    .locals 0
    .param p1, "isVisible"    # Z

    .prologue
    .line 445
    iput-boolean p1, p0, Lcom/poshmark/ui/fragments/PMFragment;->fragmentVisible:Z

    .line 446
    return-void
.end method

.method public setNavigationList(Ljava/util/List;)V
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
    .line 309
    .local p1, "list":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/poshmark/ui/fragments/PMFragment;->ancestorList:Ljava/util/List;

    .line 310
    return-void
.end method

.method public setNextActionButton(Ljava/lang/String;Landroid/view/View$OnClickListener;)Landroid/widget/Button;
    .locals 4
    .param p1, "title"    # Ljava/lang/String;
    .param p2, "listener"    # Landroid/view/View$OnClickListener;

    .prologue
    .line 647
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v4/app/FragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 648
    .local v0, "actionBar":Landroid/app/ActionBar;
    invoke-virtual {v0}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v2

    .line 649
    .local v2, "customView":Landroid/view/View;
    if-eqz v2, :cond_0

    .line 650
    const v3, 0x7f0c003d

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 651
    .local v1, "actionButton":Landroid/widget/Button;
    invoke-virtual {p1}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 652
    invoke-virtual {v1, p2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 653
    const/4 v3, 0x0

    invoke-virtual {v1, v3}, Landroid/widget/Button;->setVisibility(I)V

    .line 657
    .end local v1    # "actionButton":Landroid/widget/Button;
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public setRefreshActionButtonListener(Landroid/view/View$OnClickListener;)V
    .locals 5
    .param p1, "listener"    # Landroid/view/View$OnClickListener;

    .prologue
    .line 557
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    .line 558
    .local v2, "activity":Landroid/app/Activity;
    if-nez v2, :cond_1

    .line 570
    :cond_0
    :goto_0
    return-void

    .line 561
    :cond_1
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-virtual {v4}, Landroid/support/v4/app/FragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 562
    .local v0, "actionBar":Landroid/app/ActionBar;
    if-eqz v0, :cond_0

    .line 565
    invoke-virtual {v0}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v3

    .line 566
    .local v3, "customView":Landroid/view/View;
    if-eqz v3, :cond_0

    .line 567
    const v4, 0x7f0c003c

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageButton;

    .line 568
    .local v1, "actionButton":Landroid/widget/ImageButton;
    invoke-virtual {v1, p1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0
.end method

.method public setSearchActionButtonListener(Landroid/view/View$OnClickListener;)V
    .locals 5
    .param p1, "listener"    # Landroid/view/View$OnClickListener;

    .prologue
    .line 590
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    .line 591
    .local v2, "activity":Landroid/app/Activity;
    if-nez v2, :cond_1

    .line 603
    :cond_0
    :goto_0
    return-void

    .line 594
    :cond_1
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-virtual {v4}, Landroid/support/v4/app/FragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 595
    .local v0, "actionBar":Landroid/app/ActionBar;
    if-eqz v0, :cond_0

    .line 598
    invoke-virtual {v0}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v3

    .line 599
    .local v3, "customView":Landroid/view/View;
    if-eqz v3, :cond_0

    .line 600
    const v4, 0x7f0c0039

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageButton;

    .line 601
    .local v1, "actionButton":Landroid/widget/ImageButton;
    invoke-virtual {v1, p1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0
.end method

.method public setSubTitle(Ljava/lang/String;)V
    .locals 9
    .param p1, "subTitle"    # Ljava/lang/String;

    .prologue
    .line 407
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    .line 408
    .local v1, "activity":Landroid/app/Activity;
    if-eqz v1, :cond_2

    .line 409
    invoke-virtual {v1}, Landroid/app/Activity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 410
    .local v0, "actionBar":Landroid/app/ActionBar;
    invoke-virtual {v0}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v2

    .line 411
    .local v2, "customView":Landroid/view/View;
    if-nez v2, :cond_0

    .line 412
    const/4 v7, 0x1

    invoke-virtual {v0, v7}, Landroid/app/ActionBar;->setDisplayShowCustomEnabled(Z)V

    .line 413
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v7

    const-string v8, "layout_inflater"

    invoke-virtual {v7, v8}, Landroid/support/v4/app/FragmentActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/view/LayoutInflater;

    .line 414
    .local v3, "inflater":Landroid/view/LayoutInflater;
    const v7, 0x7f030002

    const/4 v8, 0x0

    invoke-virtual {v3, v7, v8}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v6

    .line 415
    .local v6, "v":Landroid/view/View;
    invoke-virtual {v0, v6}, Landroid/app/ActionBar;->setCustomView(Landroid/view/View;)V

    .line 416
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->hideActivityDrawer()V

    .line 417
    invoke-virtual {v0}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v2

    .line 420
    .end local v3    # "inflater":Landroid/view/LayoutInflater;
    .end local v6    # "v":Landroid/view/View;
    :cond_0
    const v7, 0x7f0c0034

    invoke-virtual {v2, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ImageView;

    .line 421
    .local v4, "logoView":Landroid/widget/ImageView;
    if-eqz v4, :cond_1

    .line 422
    const/4 v7, 0x4

    invoke-virtual {v4, v7}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 425
    :cond_1
    const v7, 0x7f0c0036

    invoke-virtual {v2, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    .line 426
    .local v5, "titleView":Landroid/widget/TextView;
    if-eqz v5, :cond_2

    .line 427
    const/4 v7, 0x0

    invoke-virtual {v5, v7}, Landroid/widget/TextView;->setVisibility(I)V

    .line 428
    invoke-virtual {v5, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 431
    .end local v0    # "actionBar":Landroid/app/ActionBar;
    .end local v2    # "customView":Landroid/view/View;
    .end local v4    # "logoView":Landroid/widget/ImageView;
    .end local v5    # "titleView":Landroid/widget/TextView;
    :cond_2
    return-void
.end method

.method public setTitle(I)V
    .locals 1
    .param p1, "id"    # I

    .prologue
    .line 376
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/PMFragment;->setTitle(Ljava/lang/String;)V

    .line 377
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 9
    .param p1, "title"    # Ljava/lang/String;

    .prologue
    .line 380
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    .line 381
    .local v1, "activity":Landroid/app/Activity;
    if-eqz v1, :cond_2

    .line 382
    invoke-virtual {v1}, Landroid/app/Activity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 383
    .local v0, "actionBar":Landroid/app/ActionBar;
    invoke-virtual {v0}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v2

    .line 384
    .local v2, "customView":Landroid/view/View;
    if-nez v2, :cond_0

    .line 385
    const/4 v7, 0x1

    invoke-virtual {v0, v7}, Landroid/app/ActionBar;->setDisplayShowCustomEnabled(Z)V

    .line 386
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v7

    const-string v8, "layout_inflater"

    invoke-virtual {v7, v8}, Landroid/support/v4/app/FragmentActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/view/LayoutInflater;

    .line 387
    .local v3, "inflater":Landroid/view/LayoutInflater;
    const v7, 0x7f030002

    const/4 v8, 0x0

    invoke-virtual {v3, v7, v8}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v6

    .line 388
    .local v6, "v":Landroid/view/View;
    invoke-virtual {v0, v6}, Landroid/app/ActionBar;->setCustomView(Landroid/view/View;)V

    .line 389
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->hideActivityDrawer()V

    .line 390
    invoke-virtual {v0}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v2

    .line 393
    .end local v3    # "inflater":Landroid/view/LayoutInflater;
    .end local v6    # "v":Landroid/view/View;
    :cond_0
    const v7, 0x7f0c0034

    invoke-virtual {v2, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ImageView;

    .line 394
    .local v4, "logoView":Landroid/widget/ImageView;
    if-eqz v4, :cond_1

    .line 395
    const/4 v7, 0x4

    invoke-virtual {v4, v7}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 398
    :cond_1
    const v7, 0x7f0c0035

    invoke-virtual {v2, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    .line 399
    .local v5, "titleView":Landroid/widget/TextView;
    if-eqz v5, :cond_2

    .line 400
    const/4 v7, 0x0

    invoke-virtual {v5, v7}, Landroid/widget/TextView;->setVisibility(I)V

    .line 401
    invoke-virtual {v5, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 404
    .end local v0    # "actionBar":Landroid/app/ActionBar;
    .end local v2    # "customView":Landroid/view/View;
    .end local v4    # "logoView":Landroid/widget/ImageView;
    .end local v5    # "titleView":Landroid/widget/TextView;
    :cond_2
    return-void
.end method

.method protected setTrackingLabel(Ljava/lang/String;)V
    .locals 2
    .param p1, "label"    # Ljava/lang/String;

    .prologue
    .line 116
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PMFragment;->trackingList:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 117
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PMFragment;->trackingList:Ljava/util/List;

    const/4 v1, 0x0

    invoke-interface {v0, v1, p1}, Ljava/util/List;->add(ILjava/lang/Object;)V

    .line 119
    :cond_0
    return-void
.end method

.method public setUserVisibleHint(Z)V
    .locals 1
    .param p1, "isVisibleToUser"    # Z

    .prologue
    .line 219
    invoke-super {p0, p1}, Landroid/support/v4/app/Fragment;->setUserVisibleHint(Z)V

    .line 220
    if-eqz p1, :cond_0

    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/PMFragment;->fragmentViewsAlive:Z

    if-eqz v0, :cond_0

    .line 221
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onPMResume()V

    .line 223
    :cond_0
    return-void
.end method

.method public abstract setViewNameForAnalytics()V
.end method

.method public setupActionBar()V
    .locals 2

    .prologue
    .line 493
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PMFragment;->fragmentType:Lcom/poshmark/ui/fragments/PMFragment$FRAGMENT_TYPE;

    sget-object v1, Lcom/poshmark/ui/fragments/PMFragment$FRAGMENT_TYPE;->DRAWER:Lcom/poshmark/ui/fragments/PMFragment$FRAGMENT_TYPE;

    if-eq v0, v1, :cond_0

    .line 494
    const v0, 0x7f030002

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/PMFragment;->setupActionBar(I)V

    .line 497
    :cond_0
    return-void
.end method

.method public setupActionBar(I)V
    .locals 8
    .param p1, "layoutResourceId"    # I

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 500
    iget-object v4, p0, Lcom/poshmark/ui/fragments/PMFragment;->fragmentType:Lcom/poshmark/ui/fragments/PMFragment$FRAGMENT_TYPE;

    sget-object v5, Lcom/poshmark/ui/fragments/PMFragment$FRAGMENT_TYPE;->DRAWER:Lcom/poshmark/ui/fragments/PMFragment$FRAGMENT_TYPE;

    if-eq v4, v5, :cond_1

    .line 501
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-virtual {v4}, Landroid/support/v4/app/FragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 502
    .local v0, "actionBar":Landroid/app/ActionBar;
    invoke-virtual {v0, v6}, Landroid/app/ActionBar;->setDisplayShowHomeEnabled(Z)V

    .line 503
    invoke-virtual {v0, v6}, Landroid/app/ActionBar;->setDisplayShowTitleEnabled(Z)V

    .line 504
    invoke-virtual {v0, v6}, Landroid/app/ActionBar;->setDisplayUseLogoEnabled(Z)V

    .line 505
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;->updateActionbarVisibility()V

    .line 507
    invoke-virtual {v0, v7}, Landroid/app/ActionBar;->setDisplayShowCustomEnabled(Z)V

    .line 508
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    const-string v5, "layout_inflater"

    invoke-virtual {v4, v5}, Landroid/support/v4/app/FragmentActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/view/LayoutInflater;

    .line 509
    .local v2, "inflater":Landroid/view/LayoutInflater;
    const/4 v4, 0x0

    invoke-virtual {v2, p1, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v3

    .line 510
    .local v3, "v":Landroid/view/View;
    invoke-virtual {v0}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v1

    .line 511
    .local v1, "currentActionBarView":Landroid/view/View;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Landroid/view/View;->getId()I

    move-result v4

    invoke-virtual {v3}, Landroid/view/View;->getId()I

    move-result v5

    if-eq v4, v5, :cond_2

    .line 512
    :cond_0
    invoke-virtual {v0, v7}, Landroid/app/ActionBar;->setDisplayShowCustomEnabled(Z)V

    .line 513
    invoke-virtual {v0, v3}, Landroid/app/ActionBar;->setCustomView(Landroid/view/View;)V

    .line 514
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->hideActivityDrawer()V

    .line 521
    .end local v0    # "actionBar":Landroid/app/ActionBar;
    .end local v1    # "currentActionBarView":Landroid/view/View;
    .end local v2    # "inflater":Landroid/view/LayoutInflater;
    .end local v3    # "v":Landroid/view/View;
    :cond_1
    :goto_0
    return-void

    .line 517
    .restart local v0    # "actionBar":Landroid/app/ActionBar;
    .restart local v1    # "currentActionBarView":Landroid/view/View;
    .restart local v2    # "inflater":Landroid/view/LayoutInflater;
    .restart local v3    # "v":Landroid/view/View;
    :cond_2
    invoke-virtual {p0, v7}, Lcom/poshmark/ui/fragments/PMFragment;->hideAllActionButtons(Z)V

    .line 518
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->hideActivityDrawer()V

    goto :goto_0
.end method

.method public showAlertMessage(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "title"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    .line 461
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, v0}, Lcom/poshmark/ui/fragments/PMFragment;->showAlertMessage(Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnDismissListener;)V

    .line 462
    return-void
.end method

.method public showAlertMessage(Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnDismissListener;)V
    .locals 4
    .param p1, "title"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;
    .param p3, "listener"    # Landroid/content/DialogInterface$OnDismissListener;

    .prologue
    .line 465
    new-instance v1, Landroid/app/AlertDialog$Builder;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 466
    .local v0, "dlg":Landroid/app/AlertDialog;
    invoke-virtual {v0, p1}, Landroid/app/AlertDialog;->setTitle(Ljava/lang/CharSequence;)V

    .line 467
    invoke-virtual {v0, p2}, Landroid/app/AlertDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 468
    const/4 v2, -0x1

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v3, 0x7f0601e1

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    const/4 v1, 0x0

    check-cast v1, Landroid/os/Message;

    invoke-virtual {v0, v2, v3, v1}, Landroid/app/AlertDialog;->setButton(ILjava/lang/CharSequence;Landroid/os/Message;)V

    .line 469
    if-eqz p3, :cond_0

    .line 470
    invoke-virtual {v0, p3}, Landroid/app/AlertDialog;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V

    .line 472
    :cond_0
    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 473
    return-void
.end method

.method public showAutoHideProgressDialogWithMessage(Ljava/lang/String;)V
    .locals 3
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x1

    .line 341
    invoke-direct {p0, p1, v2}, Lcom/poshmark/ui/fragments/PMFragment;->createProgressDialogWithMessage(Ljava/lang/String;Z)V

    .line 342
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PMFragment;->dialog:Lcom/poshmark/ui/customviews/PMProgressDialog;

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMProgressDialog;->setAutoHideFlag(Z)V

    .line 343
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 344
    .local v0, "activity":Lcom/poshmark/ui/PMActivity;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/poshmark/ui/PMActivity;->isActivityInForeground()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 345
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PMFragment;->dialog:Lcom/poshmark/ui/customviews/PMProgressDialog;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/PMProgressDialog;->show()V

    .line 346
    :cond_0
    return-void
.end method

.method public showAutoHideProgressDialogWithMessage(Ljava/lang/String;Lcom/poshmark/ui/customviews/PMProgressDialog$ProgressDialogAutoDismissListener;)V
    .locals 3
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "listener"    # Lcom/poshmark/ui/customviews/PMProgressDialog$ProgressDialogAutoDismissListener;

    .prologue
    const/4 v2, 0x1

    .line 357
    invoke-direct {p0, p1, v2}, Lcom/poshmark/ui/fragments/PMFragment;->createProgressDialogWithMessage(Ljava/lang/String;Z)V

    .line 358
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PMFragment;->dialog:Lcom/poshmark/ui/customviews/PMProgressDialog;

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMProgressDialog;->setAutoHideFlag(Z)V

    .line 359
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PMFragment;->dialog:Lcom/poshmark/ui/customviews/PMProgressDialog;

    invoke-virtual {v1, p2}, Lcom/poshmark/ui/customviews/PMProgressDialog;->setDismissListener(Lcom/poshmark/ui/customviews/PMProgressDialog$ProgressDialogAutoDismissListener;)V

    .line 360
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 361
    .local v0, "activity":Lcom/poshmark/ui/PMActivity;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/poshmark/ui/PMActivity;->isActivityInForeground()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 362
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PMFragment;->dialog:Lcom/poshmark/ui/customviews/PMProgressDialog;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/PMProgressDialog;->show()V

    .line 363
    :cond_0
    return-void
.end method

.method public showAutoHideSuccessMessage(Ljava/lang/String;)V
    .locals 3
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x1

    .line 349
    invoke-direct {p0, p1, v2}, Lcom/poshmark/ui/fragments/PMFragment;->createProgressDialogWithMessage(Ljava/lang/String;Z)V

    .line 350
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PMFragment;->dialog:Lcom/poshmark/ui/customviews/PMProgressDialog;

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMProgressDialog;->setAutoHideFlag(Z)V

    .line 351
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 352
    .local v0, "activity":Lcom/poshmark/ui/PMActivity;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/poshmark/ui/PMActivity;->isActivityInForeground()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 353
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PMFragment;->dialog:Lcom/poshmark/ui/customviews/PMProgressDialog;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/PMProgressDialog;->show()V

    .line 354
    :cond_0
    return-void
.end method

.method public showConfirmationMessage(Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V
    .locals 6
    .param p1, "title"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;
    .param p3, "listener"    # Landroid/content/DialogInterface$OnClickListener;

    .prologue
    .line 489
    const v0, 0x7f0602cd

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/PMFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    const v0, 0x7f0601ce

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/PMFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v5, p3

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/fragments/PMFragment;->showConfirmationMessage(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V

    .line 490
    return-void
.end method

.method public showConfirmationMessage(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V
    .locals 3
    .param p1, "title"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;
    .param p3, "positiveText"    # Ljava/lang/String;
    .param p4, "negativeText"    # Ljava/lang/String;
    .param p5, "listener"    # Landroid/content/DialogInterface$OnClickListener;

    .prologue
    .line 477
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-direct {v0, v2}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 478
    .local v0, "alertDialogBuilder":Landroid/app/AlertDialog$Builder;
    invoke-virtual {v0, p1}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 479
    invoke-virtual {v0, p2}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 480
    if-eqz p3, :cond_0

    invoke-virtual {p3}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_0

    .line 481
    invoke-virtual {v0, p3, p5}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 482
    :cond_0
    if-eqz p4, :cond_1

    invoke-virtual {p4}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_1

    .line 483
    invoke-virtual {v0, p4, p5}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 484
    :cond_1
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v1

    .line 485
    .local v1, "dlg":Landroid/app/AlertDialog;
    invoke-virtual {v1}, Landroid/app/AlertDialog;->show()V

    .line 486
    return-void
.end method

.method public showError(Lcom/poshmark/ui/model/ActionErrorContext;)V
    .locals 2
    .param p1, "context"    # Lcom/poshmark/ui/model/ActionErrorContext;

    .prologue
    .line 768
    iget-object v0, p1, Lcom/poshmark/ui/model/ActionErrorContext;->severity:Lcom/poshmark/ui/model/ActionErrorContext$Severity;

    sget-object v1, Lcom/poshmark/ui/model/ActionErrorContext$Severity;->LOW:Lcom/poshmark/ui/model/ActionErrorContext$Severity;

    if-ne v0, v1, :cond_0

    .line 769
    iget-object v0, p1, Lcom/poshmark/ui/model/ActionErrorContext;->message:Ljava/lang/String;

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/PMFragment;->showAutoHideProgressDialogWithMessage(Ljava/lang/String;)V

    .line 774
    :goto_0
    return-void

    .line 772
    :cond_0
    const/4 v0, 0x0

    iget-object v1, p1, Lcom/poshmark/ui/model/ActionErrorContext;->message:Ljava/lang/String;

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/ui/fragments/PMFragment;->showAlertMessage(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public showError(Lcom/poshmark/ui/model/ActionErrorContext;Lcom/poshmark/ui/customviews/PMProgressDialog$ProgressDialogAutoDismissListener;)V
    .locals 2
    .param p1, "context"    # Lcom/poshmark/ui/model/ActionErrorContext;
    .param p2, "listener"    # Lcom/poshmark/ui/customviews/PMProgressDialog$ProgressDialogAutoDismissListener;

    .prologue
    .line 777
    iget-object v0, p1, Lcom/poshmark/ui/model/ActionErrorContext;->severity:Lcom/poshmark/ui/model/ActionErrorContext$Severity;

    sget-object v1, Lcom/poshmark/ui/model/ActionErrorContext$Severity;->LOW:Lcom/poshmark/ui/model/ActionErrorContext$Severity;

    if-ne v0, v1, :cond_0

    .line 778
    iget-object v0, p1, Lcom/poshmark/ui/model/ActionErrorContext;->message:Ljava/lang/String;

    invoke-virtual {p0, v0, p2}, Lcom/poshmark/ui/fragments/PMFragment;->showAutoHideProgressDialogWithMessage(Ljava/lang/String;Lcom/poshmark/ui/customviews/PMProgressDialog$ProgressDialogAutoDismissListener;)V

    .line 783
    :goto_0
    return-void

    .line 781
    :cond_0
    const/4 v0, 0x0

    iget-object v1, p1, Lcom/poshmark/ui/model/ActionErrorContext;->message:Ljava/lang/String;

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/ui/fragments/PMFragment;->showAlertMessage(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public showFindPeopleButton(Z)V
    .locals 4
    .param p1, "show"    # Z

    .prologue
    .line 632
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v4/app/FragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 633
    .local v0, "actionBar":Landroid/app/ActionBar;
    invoke-virtual {v0}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v2

    .line 634
    .local v2, "customView":Landroid/view/View;
    if-eqz v2, :cond_0

    .line 635
    const v3, 0x7f0c003a

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageButton;

    .line 636
    .local v1, "actionButton":Landroid/widget/ImageButton;
    if-eqz v1, :cond_0

    .line 637
    if-eqz p1, :cond_1

    .line 638
    const/4 v3, 0x0

    invoke-virtual {v1, v3}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 644
    .end local v1    # "actionButton":Landroid/widget/ImageButton;
    :cond_0
    :goto_0
    return-void

    .line 640
    .restart local v1    # "actionButton":Landroid/widget/ImageButton;
    :cond_1
    const/4 v3, 0x4

    invoke-virtual {v1, v3}, Landroid/widget/ImageButton;->setVisibility(I)V

    goto :goto_0
.end method

.method public showKeyboard()V
    .locals 3

    .prologue
    .line 456
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const-string v2, "input_method"

    invoke-virtual {v1, v2}, Landroid/support/v4/app/FragmentActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 457
    .local v0, "imm":Landroid/view/inputmethod/InputMethodManager;
    const/4 v1, 0x2

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/inputmethod/InputMethodManager;->toggleSoftInput(II)V

    .line 458
    return-void
.end method

.method public showLogoAsTitle()V
    .locals 5

    .prologue
    .line 435
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-virtual {v4}, Landroid/support/v4/app/FragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 436
    .local v0, "actionBar":Landroid/app/ActionBar;
    invoke-virtual {v0}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v1

    .line 437
    .local v1, "customView":Landroid/view/View;
    const v4, 0x7f0c0035

    invoke-virtual {v1, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 438
    .local v3, "titleView":Landroid/widget/TextView;
    const/4 v4, 0x4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 440
    const v4, 0x7f0c0034

    invoke-virtual {v1, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    .line 441
    .local v2, "logoView":Landroid/widget/ImageView;
    const/4 v4, 0x0

    invoke-virtual {v2, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 442
    return-void
.end method

.method public showProgressDialogWithMessage(Ljava/lang/String;)V
    .locals 1
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 337
    const/4 v0, 0x1

    invoke-virtual {p0, p1, v0}, Lcom/poshmark/ui/fragments/PMFragment;->showProgressDialogWithMessage(Ljava/lang/String;Z)V

    .line 338
    return-void
.end method

.method public showProgressDialogWithMessage(Ljava/lang/String;Z)V
    .locals 2
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "disableNav"    # Z

    .prologue
    .line 330
    invoke-direct {p0, p1, p2}, Lcom/poshmark/ui/fragments/PMFragment;->createProgressDialogWithMessage(Ljava/lang/String;Z)V

    .line 331
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 332
    .local v0, "activity":Lcom/poshmark/ui/PMActivity;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/poshmark/ui/PMActivity;->isActivityInForeground()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 333
    iget-object v1, p0, Lcom/poshmark/ui/fragments/PMFragment;->dialog:Lcom/poshmark/ui/customviews/PMProgressDialog;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/PMProgressDialog;->show()V

    .line 334
    :cond_0
    return-void
.end method

.method public showRefreshButton(Z)V
    .locals 4
    .param p1, "show"    # Z

    .prologue
    .line 606
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v4/app/FragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 607
    .local v0, "actionBar":Landroid/app/ActionBar;
    invoke-virtual {v0}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v2

    .line 608
    .local v2, "customView":Landroid/view/View;
    if-eqz v2, :cond_0

    .line 609
    const v3, 0x7f0c003c

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageButton;

    .line 610
    .local v1, "actionButton":Landroid/widget/ImageButton;
    if-eqz p1, :cond_1

    .line 611
    const/4 v3, 0x0

    invoke-virtual {v1, v3}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 616
    .end local v1    # "actionButton":Landroid/widget/ImageButton;
    :cond_0
    :goto_0
    return-void

    .line 613
    .restart local v1    # "actionButton":Landroid/widget/ImageButton;
    :cond_1
    const/4 v3, 0x4

    invoke-virtual {v1, v3}, Landroid/widget/ImageButton;->setVisibility(I)V

    goto :goto_0
.end method

.method public showSearchButton(Z)V
    .locals 4
    .param p1, "show"    # Z

    .prologue
    .line 619
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v4/app/FragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 620
    .local v0, "actionBar":Landroid/app/ActionBar;
    invoke-virtual {v0}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v2

    .line 621
    .local v2, "customView":Landroid/view/View;
    if-eqz v2, :cond_0

    .line 622
    const v3, 0x7f0c0039

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageButton;

    .line 623
    .local v1, "actionButton":Landroid/widget/ImageButton;
    if-eqz p1, :cond_1

    .line 624
    const/4 v3, 0x0

    invoke-virtual {v1, v3}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 629
    .end local v1    # "actionButton":Landroid/widget/ImageButton;
    :cond_0
    :goto_0
    return-void

    .line 626
    .restart local v1    # "actionButton":Landroid/widget/ImageButton;
    :cond_1
    const/4 v3, 0x4

    invoke-virtual {v1, v3}, Landroid/widget/ImageButton;->setVisibility(I)V

    goto :goto_0
.end method

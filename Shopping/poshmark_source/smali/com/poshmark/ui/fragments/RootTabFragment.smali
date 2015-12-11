.class public Lcom/poshmark/ui/fragments/RootTabFragment;
.super Landroid/support/v4/app/Fragment;
.source "RootTabFragment.java"

# interfaces
.implements Lcom/poshmark/notifications/PMNotificationListener;
.implements Lcom/newrelic/agent/android/api/v2/TraceFieldInterface;


# annotations
.annotation build Lcom/newrelic/agent/android/instrumentation/Instrumented;
.end annotation


# instance fields
.field bIsChildFragmentCreated:Z

.field bPopToTop:Z

.field childFragmentClass:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation
.end field

.field public fragmentContainerId:I

.field fragmentDataBundle:Landroid/os/Bundle;

.field isSaved:Z

.field stack:Ljava/util/Stack;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Stack",
            "<",
            "Lcom/poshmark/ui/fragments/PMFragment;",
            ">;"
        }
    .end annotation
.end field

.field tabButton:Lcom/poshmark/ui/customviews/PMTabButton;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 29
    invoke-direct {p0}, Landroid/support/v4/app/Fragment;-><init>()V

    .line 33
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/RootTabFragment;->bIsChildFragmentCreated:Z

    .line 35
    new-instance v0, Ljava/util/Stack;

    invoke-direct {v0}, Ljava/util/Stack;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/RootTabFragment;->stack:Ljava/util/Stack;

    .line 37
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/RootTabFragment;->bPopToTop:Z

    .line 38
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/RootTabFragment;->isSaved:Z

    return-void
.end method


# virtual methods
.method public attachTabButton(Lcom/poshmark/ui/customviews/PMTabButton;)V
    .locals 0
    .param p1, "pmTabButton"    # Lcom/poshmark/ui/customviews/PMTabButton;

    .prologue
    .line 238
    iput-object p1, p0, Lcom/poshmark/ui/fragments/RootTabFragment;->tabButton:Lcom/poshmark/ui/customviews/PMTabButton;

    .line 239
    return-void
.end method

.method public collapseAllSubfragments()V
    .locals 6

    .prologue
    .line 153
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/RootTabFragment;->isAdded()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 155
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/RootTabFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v2

    .line 156
    .local v2, "fm":Landroid/support/v4/app/FragmentManager;
    invoke-virtual {v2}, Landroid/support/v4/app/FragmentManager;->getBackStackEntryCount()I

    move-result v1

    .line 157
    .local v1, "count":I
    const/4 v3, 0x1

    .local v3, "i":I
    :goto_0
    if-ge v3, v1, :cond_1

    .line 158
    invoke-virtual {v2}, Landroid/support/v4/app/FragmentManager;->popBackStackImmediate()Z

    .line 157
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 163
    .end local v1    # "count":I
    .end local v2    # "fm":Landroid/support/v4/app/FragmentManager;
    .end local v3    # "i":I
    :cond_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/RootTabFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 164
    .local v0, "activity":Landroid/support/v4/app/FragmentActivity;
    if-eqz v0, :cond_1

    .line 165
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v2

    .line 166
    .restart local v2    # "fm":Landroid/support/v4/app/FragmentManager;
    invoke-virtual {v2}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v4

    .line 167
    .local v4, "trans":Landroid/support/v4/app/FragmentTransaction;
    invoke-virtual {v4, p0}, Landroid/support/v4/app/FragmentTransaction;->remove(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 168
    invoke-virtual {v4}, Landroid/support/v4/app/FragmentTransaction;->commitAllowingStateLoss()I

    .line 169
    invoke-virtual {v2}, Landroid/support/v4/app/FragmentManager;->executePendingTransactions()Z

    .line 170
    iget-object v5, p0, Lcom/poshmark/ui/fragments/RootTabFragment;->tabButton:Lcom/poshmark/ui/customviews/PMTabButton;

    invoke-virtual {v5}, Lcom/poshmark/ui/customviews/PMTabButton;->detachFragmentFromTabButton()V

    .line 175
    .end local v0    # "activity":Landroid/support/v4/app/FragmentActivity;
    .end local v2    # "fm":Landroid/support/v4/app/FragmentManager;
    .end local v4    # "trans":Landroid/support/v4/app/FragmentTransaction;
    :cond_1
    return-void
.end method

.method public getContainerId()I
    .locals 1

    .prologue
    .line 129
    iget v0, p0, Lcom/poshmark/ui/fragments/RootTabFragment;->fragmentContainerId:I

    return v0
.end method

.method public getCurrentActiveChildFragment()Lcom/poshmark/ui/fragments/PMFragment;
    .locals 1

    .prologue
    .line 201
    iget-object v0, p0, Lcom/poshmark/ui/fragments/RootTabFragment;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->peek()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/fragments/PMFragment;

    return-object v0
.end method

.method public handleBackPressed()Z
    .locals 9

    .prologue
    const/4 v6, 0x0

    const/4 v7, 0x1

    .line 207
    :try_start_0
    iget-object v8, p0, Lcom/poshmark/ui/fragments/RootTabFragment;->stack:Ljava/util/Stack;

    invoke-virtual {v8}, Ljava/util/Stack;->peek()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/poshmark/ui/fragments/PMFragment;

    .line 208
    .local v3, "fragment":Lcom/poshmark/ui/fragments/PMFragment;
    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/PMFragment;->handleBack()Z

    move-result v4

    .line 209
    .local v4, "handled":Z
    if-nez v4, :cond_1

    .line 210
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/RootTabFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v2

    .line 211
    .local v2, "fm":Landroid/support/v4/app/FragmentManager;
    invoke-virtual {v2}, Landroid/support/v4/app/FragmentManager;->getBackStackEntryCount()I

    move-result v0

    .line 212
    .local v0, "count":I
    if-ne v0, v7, :cond_0

    .line 228
    .end local v0    # "count":I
    .end local v2    # "fm":Landroid/support/v4/app/FragmentManager;
    .end local v3    # "fragment":Lcom/poshmark/ui/fragments/PMFragment;
    .end local v4    # "handled":Z
    :goto_0
    return v6

    .line 215
    .restart local v0    # "count":I
    .restart local v2    # "fm":Landroid/support/v4/app/FragmentManager;
    .restart local v3    # "fragment":Lcom/poshmark/ui/fragments/PMFragment;
    .restart local v4    # "handled":Z
    :cond_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/RootTabFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/PMContainerActivity;

    .line 216
    .local v5, "parent":Lcom/poshmark/ui/PMContainerActivity;
    invoke-virtual {v5, v3}, Lcom/poshmark/ui/PMContainerActivity;->killDrawerFragment(Lcom/poshmark/ui/fragments/PMFragment;)V

    .line 217
    invoke-virtual {v2}, Landroid/support/v4/app/FragmentManager;->popBackStackImmediate()Z

    .line 218
    iget-object v8, p0, Lcom/poshmark/ui/fragments/RootTabFragment;->stack:Ljava/util/Stack;

    invoke-virtual {v8}, Ljava/util/Stack;->pop()Ljava/lang/Object;
    :try_end_0
    .catch Ljava/util/EmptyStackException; {:try_start_0 .. :try_end_0} :catch_0

    move v6, v7

    .line 220
    goto :goto_0

    .end local v0    # "count":I
    .end local v2    # "fm":Landroid/support/v4/app/FragmentManager;
    .end local v5    # "parent":Lcom/poshmark/ui/PMContainerActivity;
    :cond_1
    move v6, v7

    .line 223
    goto :goto_0

    .line 225
    .end local v3    # "fragment":Lcom/poshmark/ui/fragments/PMFragment;
    .end local v4    # "handled":Z
    :catch_0
    move-exception v1

    .line 228
    .local v1, "e":Ljava/util/EmptyStackException;
    goto :goto_0
.end method

.method public handleNotification(Landroid/content/Intent;)V
    .locals 0
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 235
    return-void
.end method

.method public isStateSavingCompleted()Z
    .locals 1

    .prologue
    .line 133
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/RootTabFragment;->isSaved:Z

    return v0
.end method

.method public launchChildFragment()V
    .locals 5

    .prologue
    .line 108
    :try_start_0
    iget-object v4, p0, Lcom/poshmark/ui/fragments/RootTabFragment;->childFragmentClass:Ljava/lang/Class;

    invoke-virtual {v4}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/fragments/PMFragment;

    .line 109
    .local v1, "f":Lcom/poshmark/ui/fragments/PMFragment;
    iget-object v4, p0, Lcom/poshmark/ui/fragments/RootTabFragment;->fragmentDataBundle:Landroid/os/Bundle;

    invoke-virtual {v1, v4}, Lcom/poshmark/ui/fragments/PMFragment;->setArguments(Landroid/os/Bundle;)V

    .line 110
    const/4 v4, 0x1

    invoke-virtual {v1, v4}, Lcom/poshmark/ui/fragments/PMFragment;->setUserVisibleHint(Z)V

    .line 111
    if-eqz v1, :cond_0

    .line 113
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/RootTabFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v2

    .line 114
    .local v2, "fm":Landroid/support/v4/app/FragmentManager;
    invoke-virtual {v2}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v3

    .line 115
    .local v3, "ft":Landroid/support/v4/app/FragmentTransaction;
    iget v4, p0, Lcom/poshmark/ui/fragments/RootTabFragment;->fragmentContainerId:I

    invoke-virtual {v3, v4, v1}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 116
    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/support/v4/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 117
    invoke-virtual {v3}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 118
    iget-object v4, p0, Lcom/poshmark/ui/fragments/RootTabFragment;->stack:Ljava/util/Stack;

    invoke-virtual {v4, v1}, Ljava/util/Stack;->push(Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/InstantiationException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_1

    .line 126
    .end local v1    # "f":Lcom/poshmark/ui/fragments/PMFragment;
    .end local v2    # "fm":Landroid/support/v4/app/FragmentManager;
    .end local v3    # "ft":Landroid/support/v4/app/FragmentTransaction;
    :cond_0
    :goto_0
    return-void

    .line 121
    :catch_0
    move-exception v0

    .line 122
    .local v0, "e":Ljava/lang/InstantiationException;
    invoke-virtual {v0}, Ljava/lang/InstantiationException;->printStackTrace()V

    goto :goto_0

    .line 123
    .end local v0    # "e":Ljava/lang/InstantiationException;
    :catch_1
    move-exception v0

    .line 124
    .local v0, "e":Ljava/lang/IllegalAccessException;
    invoke-virtual {v0}, Ljava/lang/IllegalAccessException;->printStackTrace()V

    goto :goto_0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 92
    invoke-super {p0, p1}, Landroid/support/v4/app/Fragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 94
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/RootTabFragment;->bIsChildFragmentCreated:Z

    if-nez v0, :cond_0

    .line 95
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/RootTabFragment;->bIsChildFragmentCreated:Z

    .line 96
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/RootTabFragment;->launchChildFragment()V

    .line 98
    :cond_0
    return-void
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 1
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 59
    invoke-super {p0, p1, p2, p3}, Landroid/support/v4/app/Fragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 60
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/RootTabFragment;->getCurrentActiveChildFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v0

    .line 61
    .local v0, "childFragment":Lcom/poshmark/ui/fragments/PMFragment;
    if-eqz v0, :cond_0

    .line 62
    invoke-virtual {v0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 64
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 5

    .prologue
    const-string v2, "RootTabFragment"

    invoke-static {v2}, Lcom/newrelic/agent/android/tracing/TraceMachine;->startTracing(Ljava/lang/String;)V

    :try_start_0
    iget-object v2, p0, Lcom/poshmark/ui/fragments/RootTabFragment;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;

    const-string v3, "RootTabFragment#onCreate"

    const/4 v4, 0x0

    invoke-static {v2, v3, v4}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_0

    .line 42
    :goto_0
    invoke-super {p0, p1}, Landroid/support/v4/app/Fragment;->onCreate(Landroid/os/Bundle;)V

    .line 45
    :try_start_1
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/RootTabFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "FRAGMENT_CLASS"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 46
    .local v0, "className":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 47
    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/RootTabFragment;->childFragmentClass:Ljava/lang/Class;

    .line 48
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/RootTabFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "FRAGMENT_DATA"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/RootTabFragment;->fragmentDataBundle:Landroid/os/Bundle;

    .line 49
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v2

    const-string v3, "com.poshmark.intents.LOGOUT_COMPLETE"

    invoke-virtual {v2, v3, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V
    :try_end_1
    .catch Ljava/lang/ClassNotFoundException; {:try_start_1 .. :try_end_1} :catch_1

    .line 55
    :cond_0
    :goto_1
    invoke-static {}, Lcom/newrelic/agent/android/tracing/TraceMachine;->exitMethod()V

    return-void

    .line 4294967295
    .end local v0    # "className":Ljava/lang/String;
    :catch_0
    move-exception v2

    const/4 v2, 0x0

    :try_start_2
    const-string v3, "RootTabFragment#onCreate"

    const/4 v4, 0x0

    invoke-static {v2, v3, v4}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_2
    .catch Ljava/lang/NoSuchFieldError; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_0

    .line 51
    .restart local v0    # "className":Ljava/lang/String;
    :catch_1
    move-exception v1

    .line 52
    .local v1, "e":Ljava/lang/ClassNotFoundException;
    invoke-virtual {v1}, Ljava/lang/ClassNotFoundException;->printStackTrace()V

    goto :goto_1
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 4

    .prologue
    :try_start_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/RootTabFragment;->_nr_trace:Lcom/newrelic/agent/android/tracing/Trace;

    const-string v2, "RootTabFragment#onCreateView"

    const/4 v3, 0x0

    invoke-static {v1, v2, v3}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_0

    .line 85
    :goto_0
    const v1, 0x7f0300a9

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 86
    .local v0, "v":Landroid/view/View;
    const v1, 0x7f0c027a

    iput v1, p0, Lcom/poshmark/ui/fragments/RootTabFragment;->fragmentContainerId:I

    .line 87
    invoke-static {}, Lcom/newrelic/agent/android/tracing/TraceMachine;->exitMethod()V

    return-object v0

    .line 4294967295
    .end local v0    # "v":Landroid/view/View;
    :catch_0
    move-exception v1

    const/4 v1, 0x0

    :try_start_1
    const-string v2, "RootTabFragment#onCreateView"

    const/4 v3, 0x0

    invoke-static {v1, v2, v3}, Lcom/newrelic/agent/android/tracing/TraceMachine;->enterMethod(Lcom/newrelic/agent/android/tracing/Trace;Ljava/lang/String;Ljava/util/ArrayList;)V
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method

.method public onDestroy()V
    .locals 1

    .prologue
    .line 78
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onDestroy()V

    .line 79
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/RootTabFragment;->bIsChildFragmentCreated:Z

    .line 80
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/poshmark/notifications/PMNotificationManager;->unregisterAllEvents(Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 81
    return-void
.end method

.method public onResume()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 68
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onResume()V

    .line 69
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/RootTabFragment;->isSaved:Z

    .line 70
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/RootTabFragment;->bPopToTop:Z

    if-eqz v0, :cond_0

    .line 71
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/RootTabFragment;->bPopToTop:Z

    .line 72
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/RootTabFragment;->popFragmentsToTop()V

    .line 74
    :cond_0
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 102
    invoke-super {p0, p1}, Landroid/support/v4/app/Fragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 103
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/RootTabFragment;->isSaved:Z

    .line 104
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

.method protected onStop()V
    .locals 1

    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onStop()V

    invoke-static {}, Lcom/newrelic/agent/android/background/ApplicationStateMonitor;->getInstance()Lcom/newrelic/agent/android/background/ApplicationStateMonitor;

    move-result-object v0

    invoke-virtual {v0}, Lcom/newrelic/agent/android/background/ApplicationStateMonitor;->activityStopped()V

    return-void
.end method

.method public popFragmentsToTop()V
    .locals 4

    .prologue
    .line 137
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/RootTabFragment;->isAdded()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 139
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/RootTabFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    .line 140
    .local v1, "fm":Landroid/support/v4/app/FragmentManager;
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->getBackStackEntryCount()I

    move-result v0

    .line 141
    .local v0, "count":I
    const/4 v2, 0x1

    .local v2, "i":I
    :goto_0
    if-ge v2, v0, :cond_1

    .line 142
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->popBackStackImmediate()Z

    .line 143
    iget-object v3, p0, Lcom/poshmark/ui/fragments/RootTabFragment;->stack:Ljava/util/Stack;

    invoke-virtual {v3}, Ljava/util/Stack;->pop()Ljava/lang/Object;

    .line 141
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 147
    .end local v0    # "count":I
    .end local v1    # "fm":Landroid/support/v4/app/FragmentManager;
    .end local v2    # "i":I
    :cond_0
    const/4 v3, 0x1

    iput-boolean v3, p0, Lcom/poshmark/ui/fragments/RootTabFragment;->bPopToTop:Z

    .line 149
    :cond_1
    return-void
.end method

.method public replaceChildFragment(Lcom/poshmark/ui/fragments/PMFragment;)V
    .locals 4
    .param p1, "fragment"    # Lcom/poshmark/ui/fragments/PMFragment;

    .prologue
    .line 188
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/RootTabFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    .line 189
    .local v1, "fm":Landroid/support/v4/app/FragmentManager;
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v2

    .line 190
    .local v2, "transaction":Landroid/support/v4/app/FragmentTransaction;
    iget-object v3, p0, Lcom/poshmark/ui/fragments/RootTabFragment;->stack:Ljava/util/Stack;

    invoke-virtual {v3}, Ljava/util/Stack;->peek()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/Fragment;

    .line 191
    .local v0, "currentVisibleFragment":Landroid/support/v4/app/Fragment;
    if-eqz v0, :cond_0

    .line 192
    invoke-virtual {v2, v0}, Landroid/support/v4/app/FragmentTransaction;->hide(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 194
    :cond_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/RootTabFragment;->getContainerId()I

    move-result v3

    invoke-virtual {v2, v3, p1}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 195
    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/support/v4/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 196
    invoke-virtual {v2}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 197
    iget-object v3, p0, Lcom/poshmark/ui/fragments/RootTabFragment;->stack:Ljava/util/Stack;

    invoke-virtual {v3, p1}, Ljava/util/Stack;->push(Ljava/lang/Object;)Ljava/lang/Object;

    .line 198
    return-void
.end method

.method public startChildFragment(Lcom/poshmark/ui/fragments/PMFragment;)V
    .locals 3
    .param p1, "fragment"    # Lcom/poshmark/ui/fragments/PMFragment;

    .prologue
    .line 179
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/RootTabFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 180
    .local v0, "fm":Landroid/support/v4/app/FragmentManager;
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v1

    .line 181
    .local v1, "transaction":Landroid/support/v4/app/FragmentTransaction;
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/RootTabFragment;->getContainerId()I

    move-result v2

    invoke-virtual {v1, v2, p1}, Landroid/support/v4/app/FragmentTransaction;->replace(ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 182
    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/support/v4/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 183
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 184
    iget-object v2, p0, Lcom/poshmark/ui/fragments/RootTabFragment;->stack:Ljava/util/Stack;

    invoke-virtual {v2, p1}, Ljava/util/Stack;->push(Ljava/lang/Object;)Ljava/lang/Object;

    .line 185
    return-void
.end method

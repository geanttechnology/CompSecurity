.class public Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"


# instance fields
.field private a:Landroid/widget/ListView;

.field private b:Lii;

.field private c:Landroid/app/Activity;

.field private g:Landroid/view/View;

.field private h:Landroid/view/View;

.field private i:Lef;

.field private j:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/browse/Category;",
            ">;"
        }
    .end annotation
.end field

.field private k:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 38
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 36
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->k:Z

    .line 40
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 1

    .prologue
    .line 42
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 36
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->k:Z

    .line 43
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->k:Z

    .line 44
    return-void
.end method


# virtual methods
.method public a(Ljava/util/List;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/browse/Category;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 110
    iput-object p1, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->j:Ljava/util/List;

    .line 111
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->g:Landroid/view/View;

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->a(Landroid/view/View;)Landroid/widget/FrameLayout;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 112
    if-eqz p1, :cond_1

    invoke-interface {p1}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 114
    :try_start_0
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->pushManager()Lcom/exacttarget/etpushsdk/ETPush;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETPush;->getTags()Ljava/util/TreeSet;

    move-result-object v1

    .line 115
    const/4 v0, 0x0

    invoke-interface {p1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/browse/Category;

    .line 116
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/browse/Category;->getCategoryId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/TreeSet;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    iget-boolean v1, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->k:Z
    :try_end_0
    .catch Lcom/exacttarget/etpushsdk/ETException; {:try_start_0 .. :try_end_0} :catch_1

    if-eqz v1, :cond_0

    .line 118
    :try_start_1
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->pushManager()Lcom/exacttarget/etpushsdk/ETPush;

    move-result-object v1

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/browse/Category;->getCategoryId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/exacttarget/etpushsdk/ETPush;->addTag(Ljava/lang/String;)V

    .line 119
    iget-object v1, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->c:Landroid/app/Activity;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/browse/Category;->getCategoryId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Llq;->a(Landroid/content/Context;Ljava/lang/String;)V
    :try_end_1
    .catch Lcom/exacttarget/etpushsdk/ETException; {:try_start_1 .. :try_end_1} :catch_0

    .line 123
    :goto_0
    const/4 v0, 0x0

    :try_start_2
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->k:Z

    .line 125
    :cond_0
    new-instance v0, Lef;

    iget-object v1, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->c:Landroid/app/Activity;

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2, p1}, Lef;-><init>(Landroid/content/Context;ILjava/util/List;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->i:Lef;

    .line 126
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->a:Landroid/widget/ListView;

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setChoiceMode(I)V

    .line 127
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->a:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->i:Lef;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 132
    :cond_1
    :goto_1
    return-void

    .line 120
    :catch_0
    move-exception v0

    .line 121
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETException;->printStackTrace()V
    :try_end_2
    .catch Lcom/exacttarget/etpushsdk/ETException; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_0

    .line 128
    :catch_1
    move-exception v0

    .line 129
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETException;->printStackTrace()V

    goto :goto_1
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 87
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 88
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->b:Lii;

    invoke-virtual {v0}, Lii;->isCancelled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 89
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->b:Lii;

    invoke-virtual {v0}, Lii;->d()V

    .line 90
    :cond_0
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 53
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 54
    iput-object p1, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->c:Landroid/app/Activity;

    .line 55
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 48
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 49
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 6

    .prologue
    const v5, 0x7f0b0008

    const/4 v4, 0x1

    const/4 v3, 0x0

    const/4 v2, -0x1

    .line 59
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->g:Landroid/view/View;

    if-nez v0, :cond_0

    .line 60
    const v0, 0x7f030084

    invoke-virtual {p1, v0, p2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->g:Landroid/view/View;

    .line 61
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->g:Landroid/view/View;

    const v1, 0x7f0c0064

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->h:Landroid/view/View;

    .line 62
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->g:Landroid/view/View;

    const v1, 0x102000a

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->a:Landroid/widget/ListView;

    .line 63
    new-instance v0, Landroid/view/View;

    iget-object v1, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->c:Landroid/app/Activity;

    invoke-direct {v0, v1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 64
    new-instance v1, Landroid/widget/AbsListView$LayoutParams;

    invoke-direct {v1, v2, v4}, Landroid/widget/AbsListView$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 65
    invoke-virtual {v0, v5}, Landroid/view/View;->setBackgroundResource(I)V

    .line 66
    iget-object v1, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->a:Landroid/widget/ListView;

    invoke-virtual {v1, v0}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;)V

    .line 67
    new-instance v0, Landroid/view/View;

    iget-object v1, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->c:Landroid/app/Activity;

    invoke-direct {v0, v1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 68
    new-instance v1, Landroid/widget/AbsListView$LayoutParams;

    invoke-direct {v1, v2, v4}, Landroid/widget/AbsListView$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 69
    invoke-virtual {v0, v5}, Landroid/view/View;->setBackgroundResource(I)V

    .line 70
    iget-object v1, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->a:Landroid/widget/ListView;

    invoke-virtual {v1, v0}, Landroid/widget/ListView;->addFooterView(Landroid/view/View;)V

    .line 71
    new-instance v0, Lii;

    iget-object v1, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->c:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->h:Landroid/view/View;

    invoke-direct {v0, v1, p0, v2}, Lii;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->b:Lii;

    .line 72
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->b:Lii;

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v3, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lii;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 76
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->a:Landroid/widget/ListView;

    new-instance v1, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment$1;-><init>(Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 82
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->g:Landroid/view/View;

    return-object v0

    .line 74
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->g:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->g:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    goto :goto_0
.end method

.method public onPause()V
    .locals 2

    .prologue
    .line 103
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onPause()V

    .line 104
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->h:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    .line 105
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->h:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 106
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->b:Lii;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lii;->cancel(Z)Z

    .line 107
    return-void
.end method

.method public onResume()V
    .locals 3

    .prologue
    .line 94
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 95
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->c:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, ""

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 96
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->l()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 97
    new-instance v0, Lii;

    iget-object v1, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->c:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->h:Landroid/view/View;

    invoke-direct {v0, v1, p0, v2}, Lii;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->b:Lii;

    .line 98
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->b:Lii;

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lii;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 100
    :cond_0
    return-void
.end method

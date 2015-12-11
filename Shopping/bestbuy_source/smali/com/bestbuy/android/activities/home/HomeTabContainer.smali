.class public Lcom/bestbuy/android/activities/home/HomeTabContainer;
.super Lcom/bestbuy/android/activities/BaseTabContainer;
.source "SourceFile"


# static fields
.field public static a:Z


# instance fields
.field private b:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 15
    const/4 v0, 0x0

    sput-boolean v0, Lcom/bestbuy/android/activities/home/HomeTabContainer;->a:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Lcom/bestbuy/android/activities/BaseTabContainer;-><init>()V

    return-void
.end method


# virtual methods
.method public b()Landroid/support/v4/app/Fragment;
    .locals 2

    .prologue
    .line 40
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeTabContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 41
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeTabContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const v1, 0x7f0c009e

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 42
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public d()V
    .locals 2

    .prologue
    .line 32
    new-instance v0, Lcom/bestbuy/android/activities/home/HomeFragment;

    invoke-direct {v0}, Lcom/bestbuy/android/activities/home/HomeFragment;-><init>()V

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/bestbuy/android/activities/home/HomeTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 33
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 24
    invoke-super {p0, p1}, Lcom/bestbuy/android/activities/BaseTabContainer;->onActivityCreated(Landroid/os/Bundle;)V

    .line 25
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/home/HomeTabContainer;->b:Z

    if-nez v0, :cond_0

    .line 26
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/home/HomeTabContainer;->b:Z

    .line 27
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeTabContainer;->d()V

    .line 29
    :cond_0
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 19
    const v0, 0x7f0300d3

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 36
    invoke-super {p0}, Lcom/bestbuy/android/activities/BaseTabContainer;->onResume()V

    .line 37
    return-void
.end method

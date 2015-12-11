.class public Lco/vine/android/widget/tabs/IconTabHost;
.super Landroid/widget/TabHost;
.source "IconTabHost.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/widget/tabs/IconTabHost$OnTabClickedListener;
    }
.end annotation


# instance fields
.field private mOnTabClickedListener:Lco/vine/android/widget/tabs/IconTabHost$OnTabClickedListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 19
    invoke-direct {p0, p1, p2}, Landroid/widget/TabHost;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 20
    return-void
.end method


# virtual methods
.method public dispatchWindowFocusChanged(Z)V
    .locals 1
    .param p1, "hasFocus"    # Z

    .prologue
    .line 29
    invoke-virtual {p0}, Lco/vine/android/widget/tabs/IconTabHost;->getCurrentView()Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 30
    invoke-super {p0, p1}, Landroid/widget/TabHost;->dispatchWindowFocusChanged(Z)V

    .line 32
    :cond_0
    return-void
.end method

.method public setCurrentTab(I)V
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 36
    invoke-virtual {p0}, Lco/vine/android/widget/tabs/IconTabHost;->getCurrentTab()I

    move-result v0

    if-ne p1, v0, :cond_1

    .line 37
    iget-object v0, p0, Lco/vine/android/widget/tabs/IconTabHost;->mOnTabClickedListener:Lco/vine/android/widget/tabs/IconTabHost$OnTabClickedListener;

    if-eqz v0, :cond_0

    .line 38
    iget-object v0, p0, Lco/vine/android/widget/tabs/IconTabHost;->mOnTabClickedListener:Lco/vine/android/widget/tabs/IconTabHost$OnTabClickedListener;

    invoke-interface {v0}, Lco/vine/android/widget/tabs/IconTabHost$OnTabClickedListener;->onCurrentTabClicked()V

    .line 43
    :cond_0
    :goto_0
    return-void

    .line 41
    :cond_1
    invoke-super {p0, p1}, Landroid/widget/TabHost;->setCurrentTab(I)V

    goto :goto_0
.end method

.method public setOnTabClickedListener(Lco/vine/android/widget/tabs/IconTabHost$OnTabClickedListener;)V
    .locals 0
    .param p1, "listener"    # Lco/vine/android/widget/tabs/IconTabHost$OnTabClickedListener;

    .prologue
    .line 23
    iput-object p1, p0, Lco/vine/android/widget/tabs/IconTabHost;->mOnTabClickedListener:Lco/vine/android/widget/tabs/IconTabHost$OnTabClickedListener;

    .line 24
    return-void
.end method

.method public setTabExplicit(I)V
    .locals 0
    .param p1, "index"    # I

    .prologue
    .line 46
    invoke-super {p0, p1}, Landroid/widget/TabHost;->setCurrentTab(I)V

    .line 47
    return-void
.end method

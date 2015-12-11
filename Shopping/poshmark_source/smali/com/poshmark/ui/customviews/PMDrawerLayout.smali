.class public Lcom/poshmark/ui/customviews/PMDrawerLayout;
.super Landroid/support/v4/widget/DrawerLayout;
.source "PMDrawerLayout.java"


# instance fields
.field context:Landroid/content/Context;

.field drawerContentsFragment:Lcom/poshmark/ui/fragments/PMFragment;

.field parentActivity:Lcom/poshmark/ui/PMActivity;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 20
    invoke-direct {p0, p1, p2}, Landroid/support/v4/widget/DrawerLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 21
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMDrawerLayout;->context:Landroid/content/Context;

    .line 23
    return-void
.end method


# virtual methods
.method public enableDrawer(Z)V
    .locals 1
    .param p1, "enable"    # Z

    .prologue
    .line 28
    if-eqz p1, :cond_0

    .line 29
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/PMDrawerLayout;->setDrawerLockMode(I)V

    .line 34
    :goto_0
    return-void

    .line 31
    :cond_0
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/PMDrawerLayout;->setDrawerLockMode(I)V

    goto :goto_0
.end method

.method public getCurrentFragment()Lcom/poshmark/ui/fragments/PMFragment;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMDrawerLayout;->drawerContentsFragment:Lcom/poshmark/ui/fragments/PMFragment;

    return-object v0
.end method

.method public setCurrentFragment(Lcom/poshmark/ui/fragments/PMFragment;)V
    .locals 0
    .param p1, "fragment"    # Lcom/poshmark/ui/fragments/PMFragment;

    .prologue
    .line 37
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMDrawerLayout;->drawerContentsFragment:Lcom/poshmark/ui/fragments/PMFragment;

    .line 38
    return-void
.end method

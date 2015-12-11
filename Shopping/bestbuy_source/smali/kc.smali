.class public Lkc;
.super Landroid/support/v4/app/ActionBarDrawerToggle;
.source "SourceFile"


# direct methods
.method public constructor <init>(Landroid/app/Activity;Landroid/support/v4/widget/DrawerLayout;III)V
    .locals 0

    .prologue
    .line 13
    invoke-direct/range {p0 .. p5}, Landroid/support/v4/app/ActionBarDrawerToggle;-><init>(Landroid/app/Activity;Landroid/support/v4/widget/DrawerLayout;III)V

    .line 15
    return-void
.end method


# virtual methods
.method public onDrawerSlide(Landroid/view/View;F)V
    .locals 1

    .prologue
    .line 19
    const/4 v0, 0x0

    invoke-super {p0, p1, v0}, Landroid/support/v4/app/ActionBarDrawerToggle;->onDrawerSlide(Landroid/view/View;F)V

    .line 20
    return-void
.end method

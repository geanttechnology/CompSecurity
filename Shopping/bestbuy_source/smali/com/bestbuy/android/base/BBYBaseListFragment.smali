.class public Lcom/bestbuy/android/base/BBYBaseListFragment;
.super Landroid/support/v4/app/ListFragment;
.source "SourceFile"


# instance fields
.field protected a:Landroid/app/Activity;

.field protected b:Lnb;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Landroid/support/v4/app/ListFragment;-><init>()V

    return-void
.end method


# virtual methods
.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 23
    invoke-super {p0, p1}, Landroid/support/v4/app/ListFragment;->onAttach(Landroid/app/Activity;)V

    .line 24
    iput-object p1, p0, Lcom/bestbuy/android/base/BBYBaseListFragment;->a:Landroid/app/Activity;

    .line 25
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 29
    invoke-super {p0, p1}, Landroid/support/v4/app/ListFragment;->onCreate(Landroid/os/Bundle;)V

    .line 30
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/base/BBYBaseListFragment;->b:Lnb;

    .line 31
    return-void
.end method

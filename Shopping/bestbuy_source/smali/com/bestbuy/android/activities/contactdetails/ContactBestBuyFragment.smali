.class public Lcom/bestbuy/android/activities/contactdetails/ContactBestBuyFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"


# instance fields
.field private a:Landroid/app/Activity;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 23
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/contactdetails/ContactBestBuyFragment;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lcom/bestbuy/android/activities/contactdetails/ContactBestBuyFragment;->a:Landroid/app/Activity;

    return-object v0
.end method


# virtual methods
.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 27
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 28
    iput-object p1, p0, Lcom/bestbuy/android/activities/contactdetails/ContactBestBuyFragment;->a:Landroid/app/Activity;

    .line 29
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3

    .prologue
    .line 34
    const v0, 0x7f030025

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 35
    const v1, 0x7f0c00a6

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    new-instance v2, Lcom/bestbuy/android/activities/contactdetails/ContactBestBuyFragment$1;

    invoke-direct {v2, p0}, Lcom/bestbuy/android/activities/contactdetails/ContactBestBuyFragment$1;-><init>(Lcom/bestbuy/android/activities/contactdetails/ContactBestBuyFragment;)V

    invoke-virtual {v1, v2}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 51
    return-object v0
.end method

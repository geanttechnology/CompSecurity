.class Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/support/v4/view/ViewPager$OnPageChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->a(Ljava/util/ArrayList;)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;)V
    .locals 0

    .prologue
    .line 357
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment$3;->a:Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPageScrollStateChanged(I)V
    .locals 1

    .prologue
    .line 370
    if-nez p1, :cond_1

    .line 371
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment$3;->a:Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->c()V

    .line 375
    :cond_0
    :goto_0
    return-void

    .line 372
    :cond_1
    const/4 v0, 0x1

    if-ne p1, v0, :cond_0

    .line 373
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment$3;->a:Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->d()V

    goto :goto_0
.end method

.method public onPageScrolled(IFI)V
    .locals 0

    .prologue
    .line 361
    return-void
.end method

.method public onPageSelected(I)V
    .locals 0

    .prologue
    .line 366
    return-void
.end method

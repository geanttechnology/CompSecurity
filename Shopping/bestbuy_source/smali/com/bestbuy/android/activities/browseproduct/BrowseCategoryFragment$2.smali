.class Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/support/v4/view/ViewPager$OnPageChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->a(Ljava/util/ArrayList;)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;)V
    .locals 0

    .prologue
    .line 284
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPageScrollStateChanged(I)V
    .locals 1

    .prologue
    .line 297
    if-nez p1, :cond_1

    .line 298
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->c()V

    .line 302
    :cond_0
    :goto_0
    return-void

    .line 299
    :cond_1
    const/4 v0, 0x1

    if-ne p1, v0, :cond_0

    .line 300
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->d()V

    goto :goto_0
.end method

.method public onPageScrolled(IFI)V
    .locals 0

    .prologue
    .line 288
    return-void
.end method

.method public onPageSelected(I)V
    .locals 0

    .prologue
    .line 293
    return-void
.end method

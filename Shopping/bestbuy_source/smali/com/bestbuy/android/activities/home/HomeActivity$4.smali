.class Lcom/bestbuy/android/activities/home/HomeActivity$4;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnFocusChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/home/HomeActivity;->onCreateOptionsMenu(Landroid/view/Menu;)Z
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/home/HomeActivity;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/home/HomeActivity;)V
    .locals 0

    .prologue
    .line 362
    iput-object p1, p0, Lcom/bestbuy/android/activities/home/HomeActivity$4;->a:Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFocusChange(Landroid/view/View;Z)V
    .locals 3

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 365
    if-eqz p2, :cond_2

    .line 366
    sget-boolean v0, Lcom/bestbuy/android/activities/home/HomeActivity;->inStoresFragment:Z

    if-eqz v0, :cond_1

    .line 367
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity$4;->a:Lcom/bestbuy/android/activities/home/HomeActivity;

    # getter for: Lcom/bestbuy/android/activities/home/HomeActivity;->switchToListItem:Landroid/view/MenuItem;
    invoke-static {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->access$300(Lcom/bestbuy/android/activities/home/HomeActivity;)Landroid/view/MenuItem;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 368
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity$4;->a:Lcom/bestbuy/android/activities/home/HomeActivity;

    # getter for: Lcom/bestbuy/android/activities/home/HomeActivity;->switchToListItem:Landroid/view/MenuItem;
    invoke-static {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->access$300(Lcom/bestbuy/android/activities/home/HomeActivity;)Landroid/view/MenuItem;

    move-result-object v0

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 370
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity$4;->a:Lcom/bestbuy/android/activities/home/HomeActivity;

    # getter for: Lcom/bestbuy/android/activities/home/HomeActivity;->geoLocateItem:Landroid/view/MenuItem;
    invoke-static {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->access$400(Lcom/bestbuy/android/activities/home/HomeActivity;)Landroid/view/MenuItem;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 371
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity$4;->a:Lcom/bestbuy/android/activities/home/HomeActivity;

    # getter for: Lcom/bestbuy/android/activities/home/HomeActivity;->geoLocateItem:Landroid/view/MenuItem;
    invoke-static {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->access$400(Lcom/bestbuy/android/activities/home/HomeActivity;)Landroid/view/MenuItem;

    move-result-object v0

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 389
    :cond_1
    :goto_0
    return-void

    .line 375
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity$4;->a:Lcom/bestbuy/android/activities/home/HomeActivity;

    # getter for: Lcom/bestbuy/android/activities/home/HomeActivity;->searchMenuItem:Landroid/view/MenuItem;
    invoke-static {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->access$500(Lcom/bestbuy/android/activities/home/HomeActivity;)Landroid/view/MenuItem;

    move-result-object v0

    invoke-interface {v0}, Landroid/view/MenuItem;->collapseActionView()Z

    .line 376
    sget-boolean v0, Lcom/bestbuy/android/activities/home/HomeActivity;->inLifeEventsFragment:Z

    if-eqz v0, :cond_3

    .line 377
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity$4;->a:Lcom/bestbuy/android/activities/home/HomeActivity;

    # getter for: Lcom/bestbuy/android/activities/home/HomeActivity;->searchMenuItem:Landroid/view/MenuItem;
    invoke-static {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->access$500(Lcom/bestbuy/android/activities/home/HomeActivity;)Landroid/view/MenuItem;

    move-result-object v0

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 379
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity$4;->a:Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/app/ActionBar;->setDisplayShowHomeEnabled(Z)V

    .line 380
    sget-boolean v0, Lcom/bestbuy/android/activities/home/HomeActivity;->inStoresFragment:Z

    if-eqz v0, :cond_1

    .line 381
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity$4;->a:Lcom/bestbuy/android/activities/home/HomeActivity;

    # getter for: Lcom/bestbuy/android/activities/home/HomeActivity;->switchToListItem:Landroid/view/MenuItem;
    invoke-static {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->access$300(Lcom/bestbuy/android/activities/home/HomeActivity;)Landroid/view/MenuItem;

    move-result-object v0

    if-eqz v0, :cond_4

    .line 382
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity$4;->a:Lcom/bestbuy/android/activities/home/HomeActivity;

    # getter for: Lcom/bestbuy/android/activities/home/HomeActivity;->switchToListItem:Landroid/view/MenuItem;
    invoke-static {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->access$300(Lcom/bestbuy/android/activities/home/HomeActivity;)Landroid/view/MenuItem;

    move-result-object v0

    invoke-interface {v0, v2}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 384
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity$4;->a:Lcom/bestbuy/android/activities/home/HomeActivity;

    # getter for: Lcom/bestbuy/android/activities/home/HomeActivity;->geoLocateItem:Landroid/view/MenuItem;
    invoke-static {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->access$400(Lcom/bestbuy/android/activities/home/HomeActivity;)Landroid/view/MenuItem;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 385
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity$4;->a:Lcom/bestbuy/android/activities/home/HomeActivity;

    # getter for: Lcom/bestbuy/android/activities/home/HomeActivity;->geoLocateItem:Landroid/view/MenuItem;
    invoke-static {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->access$400(Lcom/bestbuy/android/activities/home/HomeActivity;)Landroid/view/MenuItem;

    move-result-object v0

    invoke-interface {v0, v2}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    goto :goto_0
.end method

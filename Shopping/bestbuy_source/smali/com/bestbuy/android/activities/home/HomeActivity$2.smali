.class Lcom/bestbuy/android/activities/home/HomeActivity$2;
.super Lkc;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/home/HomeActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/home/HomeActivity;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/home/HomeActivity;Landroid/app/Activity;Landroid/support/v4/widget/DrawerLayout;III)V
    .locals 6

    .prologue
    .line 248
    iput-object p1, p0, Lcom/bestbuy/android/activities/home/HomeActivity$2;->a:Lcom/bestbuy/android/activities/home/HomeActivity;

    move-object v0, p0

    move-object v1, p2

    move-object v2, p3

    move v3, p4

    move v4, p5

    move v5, p6

    invoke-direct/range {v0 .. v5}, Lkc;-><init>(Landroid/app/Activity;Landroid/support/v4/widget/DrawerLayout;III)V

    return-void
.end method


# virtual methods
.method public onDrawerClosed(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 250
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity$2;->a:Lcom/bestbuy/android/activities/home/HomeActivity;

    const/4 v1, 0x0

    # setter for: Lcom/bestbuy/android/activities/home/HomeActivity;->isNavigationDrawerOpened:Z
    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->access$002(Lcom/bestbuy/android/activities/home/HomeActivity;Z)Z

    .line 251
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity$2;->a:Lcom/bestbuy/android/activities/home/HomeActivity;

    # invokes: Lcom/bestbuy/android/activities/home/HomeActivity;->onDrawerAction()V
    invoke-static {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->access$100(Lcom/bestbuy/android/activities/home/HomeActivity;)V

    .line 252
    return-void
.end method

.method public onDrawerOpened(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 255
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 256
    sget-object v1, Llu;->bo:Ljava/lang/String;

    const-string v2, "browse,more"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 257
    sget-object v1, Llu;->bp:Ljava/lang/String;

    const-string v2, "NAV"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 258
    sget-object v1, Llu;->g:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 259
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity$2;->a:Lcom/bestbuy/android/activities/home/HomeActivity;

    const/4 v1, 0x1

    # setter for: Lcom/bestbuy/android/activities/home/HomeActivity;->isNavigationDrawerOpened:Z
    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->access$002(Lcom/bestbuy/android/activities/home/HomeActivity;Z)Z

    .line 260
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity$2;->a:Lcom/bestbuy/android/activities/home/HomeActivity;

    # invokes: Lcom/bestbuy/android/activities/home/HomeActivity;->onDrawerAction()V
    invoke-static {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->access$100(Lcom/bestbuy/android/activities/home/HomeActivity;)V

    .line 261
    return-void
.end method

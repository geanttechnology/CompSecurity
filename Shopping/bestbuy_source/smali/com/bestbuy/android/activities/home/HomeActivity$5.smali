.class Lcom/bestbuy/android/activities/home/HomeActivity$5;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


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
    .line 392
    iput-object p1, p0, Lcom/bestbuy/android/activities/home/HomeActivity$5;->a:Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 396
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity$5;->a:Lcom/bestbuy/android/activities/home/HomeActivity;

    # getter for: Lcom/bestbuy/android/activities/home/HomeActivity;->isFromPLPFragment:Z
    invoke-static {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->access$600(Lcom/bestbuy/android/activities/home/HomeActivity;)Z

    move-result v0

    if-nez v0, :cond_0

    sget-boolean v0, Lcom/bestbuy/android/activities/home/HomeActivity;->inLifeEventsFragment:Z

    if-nez v0, :cond_0

    sget-boolean v0, Lcom/bestbuy/android/activities/home/HomeActivity;->inStoresFragment:Z

    if-nez v0, :cond_0

    sget-boolean v0, Lcom/bestbuy/android/activities/home/HomeActivity;->inDNMFragment:Z

    if-eqz v0, :cond_1

    .line 397
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity$5;->a:Lcom/bestbuy/android/activities/home/HomeActivity;

    # getter for: Lcom/bestbuy/android/activities/home/HomeActivity;->query:Ljava/lang/String;
    invoke-static {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->access$700(Lcom/bestbuy/android/activities/home/HomeActivity;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 398
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity$5;->a:Lcom/bestbuy/android/activities/home/HomeActivity;

    # getter for: Lcom/bestbuy/android/activities/home/HomeActivity;->searchView:Landroid/widget/SearchView;
    invoke-static {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->access$200(Lcom/bestbuy/android/activities/home/HomeActivity;)Landroid/widget/SearchView;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeActivity$5;->a:Lcom/bestbuy/android/activities/home/HomeActivity;

    # getter for: Lcom/bestbuy/android/activities/home/HomeActivity;->query:Ljava/lang/String;
    invoke-static {v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->access$700(Lcom/bestbuy/android/activities/home/HomeActivity;)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/widget/SearchView;->setQuery(Ljava/lang/CharSequence;Z)V

    .line 401
    :cond_1
    return-void
.end method

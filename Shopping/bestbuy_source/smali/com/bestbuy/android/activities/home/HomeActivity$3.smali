.class Lcom/bestbuy/android/activities/home/HomeActivity$3;
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
    .line 345
    iput-object p1, p0, Lcom/bestbuy/android/activities/home/HomeActivity$3;->a:Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFocusChange(Landroid/view/View;Z)V
    .locals 4

    .prologue
    .line 348
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity$3;->a:Lcom/bestbuy/android/activities/home/HomeActivity;

    # getter for: Lcom/bestbuy/android/activities/home/HomeActivity;->searchView:Landroid/widget/SearchView;
    invoke-static {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->access$200(Lcom/bestbuy/android/activities/home/HomeActivity;)Landroid/widget/SearchView;

    move-result-object v0

    new-instance v1, Lcom/bestbuy/android/activities/home/HomeActivity$3$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/home/HomeActivity$3$1;-><init>(Lcom/bestbuy/android/activities/home/HomeActivity$3;)V

    const-wide/16 v2, 0x3e8

    invoke-virtual {v0, v1, v2, v3}, Landroid/widget/SearchView;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 355
    return-void
.end method

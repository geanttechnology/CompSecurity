.class Lcom/bestbuy/android/activities/home/HomeActivity$3$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/home/HomeActivity$3;->onFocusChange(Landroid/view/View;Z)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/home/HomeActivity$3;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/home/HomeActivity$3;)V
    .locals 0

    .prologue
    .line 348
    iput-object p1, p0, Lcom/bestbuy/android/activities/home/HomeActivity$3$1;->a:Lcom/bestbuy/android/activities/home/HomeActivity$3;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 351
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity$3$1;->a:Lcom/bestbuy/android/activities/home/HomeActivity$3;

    iget-object v0, v0, Lcom/bestbuy/android/activities/home/HomeActivity$3;->a:Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, "input_method"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 352
    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeActivity$3$1;->a:Lcom/bestbuy/android/activities/home/HomeActivity$3;

    iget-object v1, v1, Lcom/bestbuy/android/activities/home/HomeActivity$3;->a:Lcom/bestbuy/android/activities/home/HomeActivity;

    # getter for: Lcom/bestbuy/android/activities/home/HomeActivity;->searchView:Landroid/widget/SearchView;
    invoke-static {v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->access$200(Lcom/bestbuy/android/activities/home/HomeActivity;)Landroid/widget/SearchView;

    move-result-object v1

    const/4 v2, 0x2

    invoke-virtual {v0, v1, v2}, Landroid/view/inputmethod/InputMethodManager;->showSoftInput(Landroid/view/View;I)Z

    .line 353
    return-void
.end method

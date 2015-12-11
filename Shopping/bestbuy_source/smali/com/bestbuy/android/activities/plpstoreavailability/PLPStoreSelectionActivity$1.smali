.class Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/SearchView$OnQueryTextListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;)V
    .locals 0

    .prologue
    .line 141
    iput-object p1, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity$1;->a:Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onQueryTextChange(Ljava/lang/String;)Z
    .locals 1

    .prologue
    .line 156
    const/4 v0, 0x0

    return v0
.end method

.method public onQueryTextSubmit(Ljava/lang/String;)Z
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 145
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity$1;->a:Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;

    const-string v1, "input_method"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 146
    iget-object v1, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity$1;->a:Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;

    invoke-virtual {v1}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->getCurrentFocus()Landroid/view/View;

    move-result-object v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity$1;->a:Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;

    invoke-virtual {v1}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->getCurrentFocus()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 147
    iget-object v1, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity$1;->a:Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;

    invoke-virtual {v1}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->getCurrentFocus()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    invoke-virtual {v0, v1, v2}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 149
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity$1;->a:Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;

    invoke-static {v0, p1}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->a(Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;Ljava/lang/String;)Ljava/lang/String;

    .line 150
    iget-object v0, p0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity$1;->a:Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;

    invoke-virtual {v0, p1}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->a(Ljava/lang/String;)V

    .line 151
    return v2
.end method

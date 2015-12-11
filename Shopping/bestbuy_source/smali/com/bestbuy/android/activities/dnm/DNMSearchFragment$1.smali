.class Lcom/bestbuy/android/activities/dnm/DNMSearchFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/TextView$OnEditorActionListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;)V
    .locals 0

    .prologue
    .line 84
    iput-object p1, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onEditorAction(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 87
    const/4 v0, 0x3

    if-ne p2, v0, :cond_1

    .line 88
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->a(Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;)Landroid/app/Activity;

    move-result-object v0

    const-string v2, "input_method"

    invoke-virtual {v0, v2}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 89
    iget-object v2, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->b(Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;)Landroid/widget/EditText;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/EditText;->getWindowToken()Landroid/os/IBinder;

    move-result-object v2

    invoke-virtual {v0, v2, v1}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 90
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->b(Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;)Landroid/widget/EditText;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 91
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 92
    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;

    invoke-static {v1, v0}, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->a(Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;Ljava/lang/String;)V

    .line 94
    :cond_0
    const/4 v0, 0x1

    .line 96
    :goto_0
    return v0

    :cond_1
    move v0, v1

    goto :goto_0
.end method

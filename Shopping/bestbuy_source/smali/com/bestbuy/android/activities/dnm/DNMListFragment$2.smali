.class Lcom/bestbuy/android/activities/dnm/DNMListFragment$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/TextView$OnEditorActionListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/dnm/DNMListFragment;->b()V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)V
    .locals 0

    .prologue
    .line 184
    iput-object p1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$2;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onEditorAction(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 187
    const/4 v0, 0x3

    if-ne p2, v0, :cond_1

    .line 188
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$2;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->j(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)Landroid/app/Activity;

    move-result-object v0

    const-string v2, "input_method"

    invoke-virtual {v0, v2}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 189
    iget-object v2, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$2;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->k(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)Landroid/widget/EditText;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/EditText;->getWindowToken()Landroid/os/IBinder;

    move-result-object v2

    invoke-virtual {v0, v2, v1}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 190
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$2;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->k(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)Landroid/widget/EditText;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 191
    iget-object v2, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$2;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->k(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)Landroid/widget/EditText;

    move-result-object v2

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/widget/EditText;->setVisibility(I)V

    .line 192
    iget-object v2, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$2;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->l(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)Landroid/widget/LinearLayout;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 193
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_0

    .line 194
    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$2;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    invoke-static {v1, v0}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->a(Lcom/bestbuy/android/activities/dnm/DNMListFragment;Ljava/lang/String;)V

    .line 196
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$2;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->k(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)Landroid/widget/EditText;

    move-result-object v0

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 197
    const/4 v0, 0x1

    .line 199
    :goto_0
    return v0

    :cond_1
    move v0, v1

    goto :goto_0
.end method

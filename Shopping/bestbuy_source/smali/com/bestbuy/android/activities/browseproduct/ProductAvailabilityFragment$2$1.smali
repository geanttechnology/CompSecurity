.class Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;->onKey(Landroid/view/View;ILandroid/view/KeyEvent;)Z
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;)V
    .locals 0

    .prologue
    .line 244
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2$1;->a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    const/4 v3, 0x0

    const/16 v2, 0x8

    .line 247
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2$1;->a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;

    iget-object v0, v0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->a(Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;)Landroid/widget/LinearLayout;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 248
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2$1;->a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;

    iget-object v0, v0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->b(Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;)Landroid/widget/EditText;

    move-result-object v0

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 249
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2$1;->a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;

    iget-object v0, v0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->b(Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;)Landroid/widget/EditText;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/EditText;->requestFocus()Z

    .line 250
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2$1;->a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;

    iget-object v0, v0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->d:Landroid/app/Activity;

    const-string v1, "input_method"

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 251
    const/4 v1, 0x2

    invoke-virtual {v0, v1, v3}, Landroid/view/inputmethod/InputMethodManager;->toggleSoftInput(II)V

    .line 253
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2$1;->a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;

    iget-object v0, v0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->c(Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;)Landroid/widget/LinearLayout;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 254
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2$1;->a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;

    iget-object v0, v0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->d(Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;)Landroid/widget/LinearLayout;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 255
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2$1;->a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;

    iget-object v0, v0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->e(Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;)Landroid/widget/ListView;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/widget/ListView;->setVisibility(I)V

    .line 256
    return-void
.end method

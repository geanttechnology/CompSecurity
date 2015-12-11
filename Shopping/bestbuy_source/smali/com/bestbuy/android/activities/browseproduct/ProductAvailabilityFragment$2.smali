.class Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnKeyListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;)V
    .locals 0

    .prologue
    .line 230
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onKey(Landroid/view/View;ILandroid/view/KeyEvent;)Z
    .locals 8

    .prologue
    const/4 v3, 0x4

    const/16 v7, 0x8

    const/4 v6, 0x0

    .line 233
    invoke-virtual {p3}, Landroid/view/KeyEvent;->getAction()I

    move-result v0

    if-nez v0, :cond_1

    const/16 v0, 0x42

    if-ne p2, v0, :cond_1

    .line 234
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->f(Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v6}, Landroid/view/View;->setVisibility(I)V

    .line 235
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->a(Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;)Landroid/widget/LinearLayout;

    move-result-object v0

    invoke-virtual {v0, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 236
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->c(Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;)Landroid/widget/LinearLayout;

    move-result-object v0

    invoke-virtual {v0, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 237
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->d(Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;)Landroid/widget/LinearLayout;

    move-result-object v0

    invoke-virtual {v0, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 238
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->e(Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;)Landroid/widget/ListView;

    move-result-object v0

    invoke-virtual {v0, v7}, Landroid/widget/ListView;->setVisibility(I)V

    .line 240
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->b(Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;)Landroid/widget/EditText;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    .line 241
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->c(Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;)Landroid/widget/LinearLayout;

    move-result-object v0

    const v1, 0x7f0c0335

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 242
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Results for \""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\" "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 243
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->c(Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;)Landroid/widget/LinearLayout;

    move-result-object v0

    const v1, 0x7f0c0336

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 244
    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2$1;-><init>(Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;)V

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 257
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->d:Landroid/app/Activity;

    const-string v1, "input_method"

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 258
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->g(Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    invoke-virtual {v0, v1, v6}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 260
    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v0

    if-le v0, v3, :cond_0

    invoke-virtual {v4, v6, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lnr;->c(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 261
    new-instance v0, Lik;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    iget-object v1, v1, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    invoke-static {v3}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->f(Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;)Landroid/view/View;

    move-result-object v3

    iget-object v5, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    invoke-static {v5}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->h(Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;)Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-result-object v5

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSkuId()Ljava/lang/String;

    move-result-object v5

    invoke-direct/range {v0 .. v5}, Lik;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v6, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lik;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 266
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->a(Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;)Landroid/widget/LinearLayout;

    move-result-object v0

    invoke-virtual {v0, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 267
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->c(Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;)Landroid/widget/LinearLayout;

    move-result-object v0

    invoke-virtual {v0, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 268
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->d(Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;)Landroid/widget/LinearLayout;

    move-result-object v0

    invoke-virtual {v0, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 269
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->e(Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;)Landroid/widget/ListView;

    move-result-object v0

    invoke-virtual {v0, v6}, Landroid/widget/ListView;->setVisibility(I)V

    .line 271
    const/4 v0, 0x1

    .line 273
    :goto_1
    return v0

    .line 264
    :cond_0
    new-instance v0, Lip;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    iget-object v1, v1, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    invoke-static {v3}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->f(Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;)Landroid/view/View;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3, v4}, Lip;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v6, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lip;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    :cond_1
    move v0, v6

    .line 273
    goto :goto_1
.end method

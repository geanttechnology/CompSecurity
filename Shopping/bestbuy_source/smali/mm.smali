.class public Lmm;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public static a(Landroid/content/Context;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;ZZ)Landroid/view/View;
    .locals 4

    .prologue
    .line 34
    new-instance v1, Lmn;

    invoke-direct {v1}, Lmn;-><init>()V

    .line 36
    invoke-static {p0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 37
    const v2, 0x7f03011d

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 38
    const v0, 0x7f0c042c

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    invoke-static {v1, v0}, Lmn;->a(Lmn;Landroid/widget/LinearLayout;)Landroid/widget/LinearLayout;

    .line 39
    const v0, 0x7f0c042f

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    invoke-static {v1, v0}, Lmn;->b(Lmn;Landroid/widget/LinearLayout;)Landroid/widget/LinearLayout;

    .line 40
    const v0, 0x7f0c004f

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    invoke-static {v1, v0}, Lmn;->c(Lmn;Landroid/widget/LinearLayout;)Landroid/widget/LinearLayout;

    .line 41
    const v0, 0x7f0c042b

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    invoke-static {v1, v0}, Lmn;->a(Lmn;Landroid/widget/RelativeLayout;)Landroid/widget/RelativeLayout;

    .line 42
    const v0, 0x7f0c0431

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-static {v1, v0}, Lmn;->a(Lmn;Lcom/bestbuy/android/bbyobjects/BBYTextView;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 44
    if-eqz p5, :cond_0

    .line 45
    invoke-static {v1}, Lmn;->a(Lmn;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    const-string v3, "Registry ID"

    invoke-virtual {v0, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 50
    :goto_0
    invoke-static {v1}, Lmn;->b(Lmn;)Landroid/widget/RelativeLayout;

    move-result-object v0

    new-instance v3, Lmm$1;

    invoke-direct {v3}, Lmm$1;-><init>()V

    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 57
    invoke-static {v1}, Lmn;->c(Lmn;)Landroid/widget/LinearLayout;

    move-result-object v0

    new-instance v3, Lmm$2;

    invoke-direct {v3, p2, p0, p1, p3}, Lmm$2;-><init>(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Landroid/content/Context;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)V

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 78
    invoke-static {v1}, Lmn;->d(Lmn;)Landroid/widget/LinearLayout;

    move-result-object v0

    new-instance v3, Lmm$3;

    invoke-direct {v3, p2, p0, p1, p3}, Lmm$3;-><init>(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Landroid/content/Context;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)V

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 107
    invoke-static {v1}, Lmn;->e(Lmn;)Landroid/widget/LinearLayout;

    move-result-object v0

    new-instance v1, Lmm$4;

    invoke-direct {v1, p3, p1, p4, p2}, Lmm$4;-><init>(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Lcom/bestbuy/android/base/BBYBaseFragment;ZLcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)V

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 136
    return-object v2

    .line 47
    :cond_0
    invoke-static {v1}, Lmn;->a(Lmn;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    const-string v3, "List ID"

    invoke-virtual {v0, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_0
.end method

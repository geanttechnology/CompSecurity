.class final Lcom/wishabi/flipp/app/cw;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/wishabi/flipp/app/de;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/ItemDetailsActivity;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/ItemDetailsActivity;)V
    .locals 0

    .prologue
    .line 61
    iput-object p1, p0, Lcom/wishabi/flipp/app/cw;->a:Lcom/wishabi/flipp/app/ItemDetailsActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Lcom/wishabi/flipp/content/af;)V
    .locals 6

    .prologue
    const/4 v5, 0x1

    .line 64
    iget-object v0, p0, Lcom/wishabi/flipp/app/cw;->a:Lcom/wishabi/flipp/app/ItemDetailsActivity;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/ItemDetailsActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v2

    .line 65
    if-nez v2, :cond_1

    .line 86
    :cond_0
    :goto_0
    return-void

    .line 68
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/cw;->a:Lcom/wishabi/flipp/app/ItemDetailsActivity;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/ItemDetailsActivity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f030053

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v3

    .line 70
    if-eqz v3, :cond_0

    .line 73
    const v0, 0x7f0b0143

    invoke-virtual {v3, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 75
    iget-object v1, p1, Lcom/wishabi/flipp/content/af;->d:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 76
    const v0, 0x7f0b0144

    invoke-virtual {v3, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 78
    iget-object v1, p1, Lcom/wishabi/flipp/content/af;->q:Ljava/lang/String;

    iget-object v4, p1, Lcom/wishabi/flipp/content/af;->p:Ljava/lang/String;

    invoke-static {v1, v4}, Lcom/wishabi/flipp/util/q;->a(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 80
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_2

    iget-object v1, p0, Lcom/wishabi/flipp/app/cw;->a:Lcom/wishabi/flipp/app/ItemDetailsActivity;

    invoke-static {v1}, Lcom/wishabi/flipp/app/ItemDetailsActivity;->a(Lcom/wishabi/flipp/app/ItemDetailsActivity;)Ljava/lang/String;

    move-result-object v1

    :cond_2
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 82
    const/4 v0, 0x0

    invoke-virtual {v2, v0}, Landroid/app/ActionBar;->setDisplayShowTitleEnabled(Z)V

    .line 83
    invoke-virtual {v2, v5}, Landroid/app/ActionBar;->setDisplayShowCustomEnabled(Z)V

    .line 84
    invoke-virtual {v2, v5}, Landroid/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 85
    invoke-virtual {v2, v3}, Landroid/app/ActionBar;->setCustomView(Landroid/view/View;)V

    goto :goto_0
.end method

.class public final Lcom/wishabi/flipp/widget/cn;
.super Landroid/support/v7/widget/bi;
.source "SourceFile"


# instance fields
.field final k:Landroid/widget/TextView;

.field final l:Landroid/widget/EditText;

.field final m:Landroid/widget/LinearLayout;

.field final n:Lcom/wishabi/flipp/widget/cw;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/view/View;Landroid/text/TextWatcher;Lcom/wishabi/flipp/widget/cw;)V
    .locals 3

    .prologue
    .line 51
    invoke-direct {p0, p2}, Landroid/support/v7/widget/bi;-><init>(Landroid/view/View;)V

    .line 53
    const v0, 0x7f0b010a

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/cn;->k:Landroid/widget/TextView;

    .line 54
    const v0, 0x7f0b010b

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/cn;->l:Landroid/widget/EditText;

    .line 56
    const v0, 0x7f0b008b

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/cn;->m:Landroid/widget/LinearLayout;

    .line 57
    iput-object p4, p0, Lcom/wishabi/flipp/widget/cn;->n:Lcom/wishabi/flipp/widget/cw;

    .line 59
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cn;->l:Landroid/widget/EditText;

    const v1, 0x7f0e0123

    invoke-virtual {p1, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x6

    invoke-virtual {v0, v1, v2}, Landroid/widget/EditText;->setImeActionLabel(Ljava/lang/CharSequence;I)V

    .line 61
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cn;->l:Landroid/widget/EditText;

    new-instance v1, Lcom/wishabi/flipp/widget/co;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/widget/co;-><init>(Lcom/wishabi/flipp/widget/cn;)V

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setOnEditorActionListener(Landroid/widget/TextView$OnEditorActionListener;)V

    .line 75
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cn;->l:Landroid/widget/EditText;

    invoke-virtual {v0, p3}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 76
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cn;->l:Landroid/widget/EditText;

    new-instance v1, Lcom/wishabi/flipp/widget/cp;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/widget/cp;-><init>(Lcom/wishabi/flipp/widget/cn;)V

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

    .line 88
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cn;->m:Landroid/widget/LinearLayout;

    new-instance v1, Lcom/wishabi/flipp/widget/cq;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/widget/cq;-><init>(Lcom/wishabi/flipp/widget/cn;)V

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 95
    return-void
.end method

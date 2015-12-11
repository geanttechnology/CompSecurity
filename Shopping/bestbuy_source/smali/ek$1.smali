.class Lek$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lek;->getChildView(IIZLandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field final synthetic b:Lcom/bestbuy/android/api/lib/models/pdp/Specification;

.field final synthetic c:Lek;


# direct methods
.method constructor <init>(Lek;Lcom/bestbuy/android/bbyobjects/BBYTextView;Lcom/bestbuy/android/api/lib/models/pdp/Specification;)V
    .locals 0

    .prologue
    .line 365
    iput-object p1, p0, Lek$1;->c:Lek;

    iput-object p2, p0, Lek$1;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object p3, p0, Lek$1;->b:Lcom/bestbuy/android/api/lib/models/pdp/Specification;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 368
    iget-object v0, p0, Lek$1;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->isShown()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 369
    iget-object v0, p0, Lek$1;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 374
    :goto_0
    return-void

    .line 371
    :cond_0
    iget-object v0, p0, Lek$1;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 372
    iget-object v0, p0, Lek$1;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v1, p0, Lek$1;->b:Lcom/bestbuy/android/api/lib/models/pdp/Specification;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/Specification;->getDefinition()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_0
.end method

.class public final Lcom/wishabi/flipp/content/ax;
.super Landroid/support/v7/widget/bi;
.source "SourceFile"


# instance fields
.field public k:Lcom/wishabi/flipp/widget/db;

.field public l:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 97
    invoke-direct {p0, p1}, Landroid/support/v7/widget/bi;-><init>(Landroid/view/View;)V

    .line 100
    instance-of v0, p1, Lcom/wishabi/flipp/widget/db;

    if-eqz v0, :cond_0

    move-object v0, p1

    check-cast v0, Lcom/wishabi/flipp/widget/db;

    :goto_0
    iput-object v0, p0, Lcom/wishabi/flipp/content/ax;->k:Lcom/wishabi/flipp/widget/db;

    .line 103
    const v0, 0x7f0b0132

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/content/ax;->l:Landroid/widget/TextView;

    .line 104
    return-void

    .line 100
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

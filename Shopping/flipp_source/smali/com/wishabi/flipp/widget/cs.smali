.class public final Lcom/wishabi/flipp/widget/cs;
.super Landroid/support/v7/widget/bi;
.source "SourceFile"


# instance fields
.field final k:Landroid/widget/TextView;

.field final l:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 108
    invoke-direct {p0, p1}, Landroid/support/v7/widget/bi;-><init>(Landroid/view/View;)V

    .line 109
    const v0, 0x7f0b010c

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/cs;->k:Landroid/widget/TextView;

    .line 110
    const v0, 0x7f0b010d

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/cs;->l:Landroid/widget/TextView;

    .line 112
    return-void
.end method

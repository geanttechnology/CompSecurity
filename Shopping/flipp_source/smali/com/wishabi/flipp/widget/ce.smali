.class final Lcom/wishabi/flipp/widget/ce;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic a:I

.field final synthetic b:Lcom/wishabi/flipp/widget/cd;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/widget/cd;I)V
    .locals 0

    .prologue
    .line 93
    iput-object p1, p0, Lcom/wishabi/flipp/widget/ce;->b:Lcom/wishabi/flipp/widget/cd;

    iput p2, p0, Lcom/wishabi/flipp/widget/ce;->a:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 96
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ce;->b:Lcom/wishabi/flipp/widget/cd;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/cd;->a(Lcom/wishabi/flipp/widget/cd;)Lcom/wishabi/flipp/app/dn;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 97
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ce;->b:Lcom/wishabi/flipp/widget/cd;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/cd;->a(Lcom/wishabi/flipp/widget/cd;)Lcom/wishabi/flipp/app/dn;

    move-result-object v0

    iget v1, p0, Lcom/wishabi/flipp/widget/ce;->a:I

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/app/dn;->a(I)V

    .line 98
    :cond_0
    return-void
.end method

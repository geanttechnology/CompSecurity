.class final Lcom/wishabi/flipp/widget/b;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic a:I

.field final synthetic b:Lcom/wishabi/flipp/widget/a;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/widget/a;I)V
    .locals 0

    .prologue
    .line 107
    iput-object p1, p0, Lcom/wishabi/flipp/widget/b;->b:Lcom/wishabi/flipp/widget/a;

    iput p2, p0, Lcom/wishabi/flipp/widget/b;->a:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 110
    iget-object v0, p0, Lcom/wishabi/flipp/widget/b;->b:Lcom/wishabi/flipp/widget/a;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/a;->a(Lcom/wishabi/flipp/widget/a;)Lcom/wishabi/flipp/app/dn;

    move-result-object v0

    if-nez v0, :cond_0

    .line 114
    :goto_0
    return-void

    .line 113
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/b;->b:Lcom/wishabi/flipp/widget/a;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/a;->a(Lcom/wishabi/flipp/widget/a;)Lcom/wishabi/flipp/app/dn;

    move-result-object v0

    iget v1, p0, Lcom/wishabi/flipp/widget/b;->a:I

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/app/dn;->a(I)V

    goto :goto_0
.end method

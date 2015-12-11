.class final Lcom/wishabi/flipp/widget/ea;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/widget/dz;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/widget/dz;)V
    .locals 0

    .prologue
    .line 208
    iput-object p1, p0, Lcom/wishabi/flipp/widget/ea;->a:Lcom/wishabi/flipp/widget/dz;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 211
    const/4 v0, 0x0

    :goto_0
    iget-object v1, p0, Lcom/wishabi/flipp/widget/ea;->a:Lcom/wishabi/flipp/widget/dz;

    invoke-static {v1}, Lcom/wishabi/flipp/widget/dz;->a(Lcom/wishabi/flipp/widget/dz;)Lcom/wishabi/flipp/widget/ee;

    move-result-object v1

    invoke-virtual {v1}, Lcom/wishabi/flipp/widget/ee;->getChildCount()I

    move-result v1

    if-ge v0, v1, :cond_0

    .line 212
    iget-object v1, p0, Lcom/wishabi/flipp/widget/ea;->a:Lcom/wishabi/flipp/widget/dz;

    invoke-static {v1}, Lcom/wishabi/flipp/widget/dz;->a(Lcom/wishabi/flipp/widget/dz;)Lcom/wishabi/flipp/widget/ee;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/wishabi/flipp/widget/ee;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    if-ne p1, v1, :cond_1

    .line 213
    iget-object v1, p0, Lcom/wishabi/flipp/widget/ea;->a:Lcom/wishabi/flipp/widget/dz;

    invoke-static {v1}, Lcom/wishabi/flipp/widget/dz;->b(Lcom/wishabi/flipp/widget/dz;)Lcom/wishabi/flipp/widget/ec;

    move-result-object v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/wishabi/flipp/widget/ea;->a:Lcom/wishabi/flipp/widget/dz;

    invoke-static {v1}, Lcom/wishabi/flipp/widget/dz;->b(Lcom/wishabi/flipp/widget/dz;)Lcom/wishabi/flipp/widget/ec;

    move-result-object v1

    iget-object v2, p0, Lcom/wishabi/flipp/widget/ea;->a:Lcom/wishabi/flipp/widget/dz;

    invoke-static {v2}, Lcom/wishabi/flipp/widget/dz;->a(Lcom/wishabi/flipp/widget/dz;)Lcom/wishabi/flipp/widget/ee;

    move-result-object v2

    iget v2, v2, Lcom/wishabi/flipp/widget/ee;->a:I

    invoke-interface {v1, v2, v0}, Lcom/wishabi/flipp/widget/ec;->a(II)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 215
    iget-object v1, p0, Lcom/wishabi/flipp/widget/ea;->a:Lcom/wishabi/flipp/widget/dz;

    invoke-static {v1, v0}, Lcom/wishabi/flipp/widget/dz;->a(Lcom/wishabi/flipp/widget/dz;I)V

    .line 219
    :cond_0
    return-void

    .line 211
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

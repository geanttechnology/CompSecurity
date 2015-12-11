.class final Lcom/wishabi/flipp/widget/cg;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/a/b/j;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/widget/ItemDetailImageView;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/widget/ItemDetailImageView;)V
    .locals 0

    .prologue
    .line 64
    iput-object p1, p0, Lcom/wishabi/flipp/widget/cg;->a:Lcom/wishabi/flipp/widget/ItemDetailImageView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a()V
    .locals 2

    .prologue
    .line 67
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cg;->a:Lcom/wishabi/flipp/widget/ItemDetailImageView;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/ItemDetailImageView;->a(Lcom/wishabi/flipp/widget/ItemDetailImageView;)Landroid/widget/ProgressBar;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 68
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cg;->a:Lcom/wishabi/flipp/widget/ItemDetailImageView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/ItemDetailImageView;->requestLayout()V

    .line 69
    return-void
.end method

.method public final b()V
    .locals 2

    .prologue
    .line 73
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cg;->a:Lcom/wishabi/flipp/widget/ItemDetailImageView;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/ItemDetailImageView;->a(Lcom/wishabi/flipp/widget/ItemDetailImageView;)Landroid/widget/ProgressBar;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 74
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cg;->a:Lcom/wishabi/flipp/widget/ItemDetailImageView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/ItemDetailImageView;->requestLayout()V

    .line 75
    return-void
.end method

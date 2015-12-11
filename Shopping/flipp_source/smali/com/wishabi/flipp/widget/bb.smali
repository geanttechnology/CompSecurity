.class final Lcom/wishabi/flipp/widget/bb;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/widget/bc;

.field final synthetic b:Lcom/wishabi/flipp/widget/ba;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/widget/ba;Lcom/wishabi/flipp/widget/bc;)V
    .locals 0

    .prologue
    .line 163
    iput-object p1, p0, Lcom/wishabi/flipp/widget/bb;->b:Lcom/wishabi/flipp/widget/ba;

    iput-object p2, p0, Lcom/wishabi/flipp/widget/bb;->a:Lcom/wishabi/flipp/widget/bc;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 166
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bb;->a:Lcom/wishabi/flipp/widget/bc;

    iget-object v1, p0, Lcom/wishabi/flipp/widget/bb;->b:Lcom/wishabi/flipp/widget/ba;

    invoke-interface {v0, v1}, Lcom/wishabi/flipp/widget/bc;->a(Lcom/wishabi/flipp/widget/ba;)V

    .line 167
    return-void
.end method

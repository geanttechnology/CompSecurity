.class final Lcom/wishabi/flipp/widget/cu;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/widget/ct;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/widget/ct;)V
    .locals 0

    .prologue
    .line 135
    iput-object p1, p0, Lcom/wishabi/flipp/widget/cu;->a:Lcom/wishabi/flipp/widget/ct;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 138
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cu;->a:Lcom/wishabi/flipp/widget/ct;

    iget-object v0, v0, Lcom/wishabi/flipp/widget/ct;->l:Lcom/wishabi/flipp/widget/cv;

    if-nez v0, :cond_0

    .line 142
    :goto_0
    return-void

    .line 141
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cu;->a:Lcom/wishabi/flipp/widget/ct;

    iget-object v0, v0, Lcom/wishabi/flipp/widget/ct;->l:Lcom/wishabi/flipp/widget/cv;

    iget-object v1, p0, Lcom/wishabi/flipp/widget/cu;->a:Lcom/wishabi/flipp/widget/ct;

    invoke-interface {v0, v1}, Lcom/wishabi/flipp/widget/cv;->a(Lcom/wishabi/flipp/widget/ct;)V

    goto :goto_0
.end method

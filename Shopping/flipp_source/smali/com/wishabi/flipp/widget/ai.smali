.class final Lcom/wishabi/flipp/widget/ai;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/widget/af;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/widget/af;)V
    .locals 0

    .prologue
    .line 273
    iput-object p1, p0, Lcom/wishabi/flipp/widget/ai;->a:Lcom/wishabi/flipp/widget/af;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 276
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ai;->a:Lcom/wishabi/flipp/widget/af;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/af;->a(Lcom/wishabi/flipp/widget/af;)Lcom/wishabi/flipp/widget/ak;

    move-result-object v0

    if-nez v0, :cond_0

    .line 280
    :goto_0
    return-void

    .line 279
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ai;->a:Lcom/wishabi/flipp/widget/af;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/af;->a(Lcom/wishabi/flipp/widget/af;)Lcom/wishabi/flipp/widget/ak;

    move-result-object v0

    invoke-interface {v0}, Lcom/wishabi/flipp/widget/ak;->c()V

    goto :goto_0
.end method

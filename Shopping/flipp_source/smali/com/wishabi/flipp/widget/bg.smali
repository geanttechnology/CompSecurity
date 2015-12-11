.class final Lcom/wishabi/flipp/widget/bg;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/widget/FlyerToolbar;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/widget/FlyerToolbar;)V
    .locals 0

    .prologue
    .line 109
    iput-object p1, p0, Lcom/wishabi/flipp/widget/bg;->a:Lcom/wishabi/flipp/widget/FlyerToolbar;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 112
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bg;->a:Lcom/wishabi/flipp/widget/FlyerToolbar;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/FlyerToolbar;->c(Lcom/wishabi/flipp/widget/FlyerToolbar;)Lcom/wishabi/flipp/widget/bh;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 113
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bg;->a:Lcom/wishabi/flipp/widget/FlyerToolbar;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/FlyerToolbar;->c(Lcom/wishabi/flipp/widget/FlyerToolbar;)Lcom/wishabi/flipp/widget/bh;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/widget/bg;->a:Lcom/wishabi/flipp/widget/FlyerToolbar;

    invoke-interface {v0, v1}, Lcom/wishabi/flipp/widget/bh;->a(Lcom/wishabi/flipp/widget/FlyerToolbar;)V

    .line 114
    :cond_0
    return-void
.end method

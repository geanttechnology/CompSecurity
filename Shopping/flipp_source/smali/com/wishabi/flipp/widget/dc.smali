.class final Lcom/wishabi/flipp/widget/dc;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/widget/db;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/widget/db;)V
    .locals 0

    .prologue
    .line 103
    iput-object p1, p0, Lcom/wishabi/flipp/widget/dc;->a:Lcom/wishabi/flipp/widget/db;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 106
    check-cast p1, Landroid/widget/CheckBox;

    invoke-virtual {p1}, Landroid/widget/CheckBox;->isChecked()Z

    move-result v0

    .line 107
    iget-object v1, p0, Lcom/wishabi/flipp/widget/dc;->a:Lcom/wishabi/flipp/widget/db;

    invoke-static {v1}, Lcom/wishabi/flipp/widget/db;->a(Lcom/wishabi/flipp/widget/db;)Lcom/wishabi/flipp/widget/dj;

    move-result-object v1

    if-nez v1, :cond_0

    .line 111
    :goto_0
    return-void

    .line 110
    :cond_0
    iget-object v1, p0, Lcom/wishabi/flipp/widget/dc;->a:Lcom/wishabi/flipp/widget/db;

    invoke-static {v1}, Lcom/wishabi/flipp/widget/db;->a(Lcom/wishabi/flipp/widget/db;)Lcom/wishabi/flipp/widget/dj;

    move-result-object v1

    iget-object v2, p0, Lcom/wishabi/flipp/widget/dc;->a:Lcom/wishabi/flipp/widget/db;

    invoke-interface {v1, v2, v0}, Lcom/wishabi/flipp/widget/dj;->a(Lcom/wishabi/flipp/widget/db;Z)V

    goto :goto_0
.end method

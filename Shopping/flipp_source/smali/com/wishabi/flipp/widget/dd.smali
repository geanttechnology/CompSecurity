.class final Lcom/wishabi/flipp/widget/dd;
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
    .line 114
    iput-object p1, p0, Lcom/wishabi/flipp/widget/dd;->a:Lcom/wishabi/flipp/widget/db;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 117
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dd;->a:Lcom/wishabi/flipp/widget/db;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/db;->a(Lcom/wishabi/flipp/widget/db;)Lcom/wishabi/flipp/widget/dj;

    move-result-object v0

    if-nez v0, :cond_0

    .line 121
    :goto_0
    return-void

    .line 120
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dd;->a:Lcom/wishabi/flipp/widget/db;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/db;->a(Lcom/wishabi/flipp/widget/db;)Lcom/wishabi/flipp/widget/dj;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/widget/dd;->a:Lcom/wishabi/flipp/widget/db;

    invoke-interface {v0, v1}, Lcom/wishabi/flipp/widget/dj;->c(Lcom/wishabi/flipp/widget/db;)V

    goto :goto_0
.end method

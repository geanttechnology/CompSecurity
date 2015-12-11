.class final Lcom/wishabi/flipp/widget/e;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnLongClickListener;


# instance fields
.field final synthetic a:I

.field final synthetic b:Lcom/wishabi/flipp/widget/a;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/widget/a;I)V
    .locals 0

    .prologue
    .line 138
    iput-object p1, p0, Lcom/wishabi/flipp/widget/e;->b:Lcom/wishabi/flipp/widget/a;

    iput p2, p0, Lcom/wishabi/flipp/widget/e;->a:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onLongClick(Landroid/view/View;)Z
    .locals 1

    .prologue
    .line 141
    iget-object v0, p0, Lcom/wishabi/flipp/widget/e;->b:Lcom/wishabi/flipp/widget/a;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/a;->a(Lcom/wishabi/flipp/widget/a;)Lcom/wishabi/flipp/app/dn;

    move-result-object v0

    if-nez v0, :cond_0

    .line 142
    const/4 v0, 0x0

    .line 144
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/e;->b:Lcom/wishabi/flipp/widget/a;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/a;->a(Lcom/wishabi/flipp/widget/a;)Lcom/wishabi/flipp/app/dn;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/dn;->a()Z

    move-result v0

    goto :goto_0
.end method

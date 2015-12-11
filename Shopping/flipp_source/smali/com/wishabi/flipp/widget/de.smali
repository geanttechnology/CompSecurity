.class final Lcom/wishabi/flipp/widget/de;
.super Landroid/view/GestureDetector$SimpleOnGestureListener;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/widget/db;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/widget/db;)V
    .locals 0

    .prologue
    .line 125
    iput-object p1, p0, Lcom/wishabi/flipp/widget/de;->a:Lcom/wishabi/flipp/widget/db;

    invoke-direct {p0}, Landroid/view/GestureDetector$SimpleOnGestureListener;-><init>()V

    return-void
.end method


# virtual methods
.method public final onLongPress(Landroid/view/MotionEvent;)V
    .locals 2

    .prologue
    .line 139
    iget-object v0, p0, Lcom/wishabi/flipp/widget/de;->a:Lcom/wishabi/flipp/widget/db;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/db;->a(Lcom/wishabi/flipp/widget/db;)Lcom/wishabi/flipp/widget/dj;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/widget/de;->a:Lcom/wishabi/flipp/widget/db;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/db;->b(Lcom/wishabi/flipp/widget/db;)I

    move-result v0

    sget v1, Lcom/wishabi/flipp/widget/dk;->d:I

    if-ne v0, v1, :cond_1

    .line 143
    :cond_0
    :goto_0
    return-void

    .line 142
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/widget/de;->a:Lcom/wishabi/flipp/widget/db;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/db;->a(Lcom/wishabi/flipp/widget/db;)Lcom/wishabi/flipp/widget/dj;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/widget/de;->a:Lcom/wishabi/flipp/widget/db;

    invoke-interface {v0, v1}, Lcom/wishabi/flipp/widget/dj;->b(Lcom/wishabi/flipp/widget/db;)V

    goto :goto_0
.end method

.method public final onSingleTapConfirmed(Landroid/view/MotionEvent;)Z
    .locals 2

    .prologue
    .line 129
    iget-object v0, p0, Lcom/wishabi/flipp/widget/de;->a:Lcom/wishabi/flipp/widget/db;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/db;->a(Lcom/wishabi/flipp/widget/db;)Lcom/wishabi/flipp/widget/dj;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/widget/de;->a:Lcom/wishabi/flipp/widget/db;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/db;->b(Lcom/wishabi/flipp/widget/db;)I

    move-result v0

    sget v1, Lcom/wishabi/flipp/widget/dk;->d:I

    if-ne v0, v1, :cond_1

    .line 130
    :cond_0
    const/4 v0, 0x0

    .line 133
    :goto_0
    return v0

    .line 132
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/widget/de;->a:Lcom/wishabi/flipp/widget/db;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/db;->a(Lcom/wishabi/flipp/widget/db;)Lcom/wishabi/flipp/widget/dj;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/widget/de;->a:Lcom/wishabi/flipp/widget/db;

    invoke-interface {v0, v1}, Lcom/wishabi/flipp/widget/dj;->a(Lcom/wishabi/flipp/widget/db;)V

    .line 133
    const/4 v0, 0x1

    goto :goto_0
.end method

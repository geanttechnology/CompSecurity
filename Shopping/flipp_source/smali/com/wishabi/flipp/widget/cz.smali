.class public Lcom/wishabi/flipp/widget/cz;
.super Lcom/wishabi/flipp/widget/da;
.source "SourceFile"


# instance fields
.field private final a:Landroid/content/Context;

.field public final d:Landroid/database/Cursor;


# direct methods
.method protected constructor <init>(Landroid/content/Context;Landroid/database/Cursor;)V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/da;-><init>()V

    .line 15
    iput-object p1, p0, Lcom/wishabi/flipp/widget/cz;->a:Landroid/content/Context;

    .line 16
    iput-object p2, p0, Lcom/wishabi/flipp/widget/cz;->d:Landroid/database/Cursor;

    .line 17
    return-void
.end method


# virtual methods
.method protected final a(IILandroid/view/View;)Landroid/view/View;
    .locals 3

    .prologue
    .line 54
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cz;->d:Landroid/database/Cursor;

    invoke-virtual {p0, p1, p2}, Lcom/wishabi/flipp/widget/cz;->b(II)I

    move-result v1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->moveToPosition(I)Z

    move-result v0

    if-nez v0, :cond_0

    .line 55
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Couldn\'t move cursor to position "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, p1, p2}, Lcom/wishabi/flipp/widget/cz;->b(II)I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 58
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cz;->a:Landroid/content/Context;

    iget-object v1, p0, Lcom/wishabi/flipp/widget/cz;->d:Landroid/database/Cursor;

    invoke-virtual {p0, v0, v1, p1, p3}, Lcom/wishabi/flipp/widget/cz;->a(Landroid/content/Context;Landroid/database/Cursor;ILandroid/view/View;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method protected final a(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cz;->a:Landroid/content/Context;

    invoke-virtual {p0, v0, p1, p2, p3}, Lcom/wishabi/flipp/widget/cz;->a(Landroid/content/Context;ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method protected a(Landroid/content/Context;ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 1

    .prologue
    .line 68
    const/4 v0, 0x0

    return-object v0
.end method

.method protected a(Landroid/content/Context;Landroid/database/Cursor;ILandroid/view/View;)Landroid/view/View;
    .locals 1

    .prologue
    .line 63
    const/4 v0, 0x0

    return-object v0
.end method

.method public final a(I)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cz;->d:Landroid/database/Cursor;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/widget/cz;->d:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-ge p1, v0, :cond_0

    .line 26
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cz;->d:Landroid/database/Cursor;

    invoke-interface {v0, p1}, Landroid/database/Cursor;->moveToPosition(I)Z

    .line 27
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cz;->d:Landroid/database/Cursor;

    .line 30
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.class public final Lcom/wishabi/flipp/content/ad;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field public final a:Landroid/database/Cursor;

.field public final b:Lcom/wishabi/flipp/content/ae;

.field public final c:I


# direct methods
.method public constructor <init>(Landroid/database/Cursor;Lcom/wishabi/flipp/content/ae;I)V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    iput-object p1, p0, Lcom/wishabi/flipp/content/ad;->a:Landroid/database/Cursor;

    .line 20
    iput-object p2, p0, Lcom/wishabi/flipp/content/ad;->b:Lcom/wishabi/flipp/content/ae;

    .line 21
    iput p3, p0, Lcom/wishabi/flipp/content/ad;->c:I

    .line 22
    return-void
.end method


# virtual methods
.method public final a()I
    .locals 2

    .prologue
    .line 25
    iget-object v0, p0, Lcom/wishabi/flipp/content/ad;->a:Landroid/database/Cursor;

    iget v1, p0, Lcom/wishabi/flipp/content/ad;->c:I

    invoke-interface {v0, v1}, Landroid/database/Cursor;->moveToPosition(I)Z

    .line 26
    iget-object v0, p0, Lcom/wishabi/flipp/content/ad;->a:Landroid/database/Cursor;

    iget-object v1, p0, Lcom/wishabi/flipp/content/ad;->b:Lcom/wishabi/flipp/content/ae;

    iget v1, v1, Lcom/wishabi/flipp/content/ae;->a:I

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    return v0
.end method

.method public final b()I
    .locals 2

    .prologue
    .line 30
    iget-object v0, p0, Lcom/wishabi/flipp/content/ad;->a:Landroid/database/Cursor;

    iget v1, p0, Lcom/wishabi/flipp/content/ad;->c:I

    invoke-interface {v0, v1}, Landroid/database/Cursor;->moveToPosition(I)Z

    .line 31
    iget-object v0, p0, Lcom/wishabi/flipp/content/ad;->a:Landroid/database/Cursor;

    iget-object v1, p0, Lcom/wishabi/flipp/content/ad;->b:Lcom/wishabi/flipp/content/ae;

    iget v1, v1, Lcom/wishabi/flipp/content/ae;->b:I

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    return v0
.end method

.method public final c()I
    .locals 2

    .prologue
    .line 35
    iget-object v0, p0, Lcom/wishabi/flipp/content/ad;->a:Landroid/database/Cursor;

    iget v1, p0, Lcom/wishabi/flipp/content/ad;->c:I

    invoke-interface {v0, v1}, Landroid/database/Cursor;->moveToPosition(I)Z

    .line 36
    iget-object v0, p0, Lcom/wishabi/flipp/content/ad;->a:Landroid/database/Cursor;

    iget-object v1, p0, Lcom/wishabi/flipp/content/ad;->b:Lcom/wishabi/flipp/content/ae;

    iget v1, v1, Lcom/wishabi/flipp/content/ae;->c:I

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    return v0
.end method

.method public final d()I
    .locals 2

    .prologue
    .line 40
    iget-object v0, p0, Lcom/wishabi/flipp/content/ad;->a:Landroid/database/Cursor;

    iget v1, p0, Lcom/wishabi/flipp/content/ad;->c:I

    invoke-interface {v0, v1}, Landroid/database/Cursor;->moveToPosition(I)Z

    .line 41
    iget-object v0, p0, Lcom/wishabi/flipp/content/ad;->a:Landroid/database/Cursor;

    iget-object v1, p0, Lcom/wishabi/flipp/content/ad;->b:Lcom/wishabi/flipp/content/ae;

    iget v1, v1, Lcom/wishabi/flipp/content/ae;->d:I

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    return v0
.end method

.method public final e()J
    .locals 2

    .prologue
    .line 49
    iget-object v0, p0, Lcom/wishabi/flipp/content/ad;->a:Landroid/database/Cursor;

    iget v1, p0, Lcom/wishabi/flipp/content/ad;->c:I

    invoke-interface {v0, v1}, Landroid/database/Cursor;->moveToPosition(I)Z

    .line 50
    iget-object v0, p0, Lcom/wishabi/flipp/content/ad;->a:Landroid/database/Cursor;

    iget-object v1, p0, Lcom/wishabi/flipp/content/ad;->b:Lcom/wishabi/flipp/content/ae;

    iget v1, v1, Lcom/wishabi/flipp/content/ae;->e:I

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v0

    return-wide v0
.end method

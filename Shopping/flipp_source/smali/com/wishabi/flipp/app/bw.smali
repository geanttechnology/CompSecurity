.class final Lcom/wishabi/flipp/app/bw;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field a:I

.field b:I

.field c:I

.field d:I

.field e:I

.field f:I

.field g:I

.field h:I


# direct methods
.method private constructor <init>(Landroid/database/Cursor;)V
    .locals 1

    .prologue
    .line 177
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 178
    const-string v0, "id"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/app/bw;->a:I

    .line 179
    const-string v0, "flyer_id"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/app/bw;->b:I

    .line 180
    const-string v0, "left"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/app/bw;->c:I

    .line 181
    const-string v0, "bottom"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/app/bw;->d:I

    .line 182
    const-string v0, "right"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/app/bw;->e:I

    .line 183
    const-string v0, "top"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/app/bw;->f:I

    .line 184
    const-string v0, "name"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/app/bw;->g:I

    .line 185
    const-string v0, "page"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/app/bw;->h:I

    .line 186
    return-void
.end method

.method synthetic constructor <init>(Landroid/database/Cursor;B)V
    .locals 0

    .prologue
    .line 167
    invoke-direct {p0, p1}, Lcom/wishabi/flipp/app/bw;-><init>(Landroid/database/Cursor;)V

    return-void
.end method

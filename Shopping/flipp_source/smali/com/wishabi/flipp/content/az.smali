.class public final Lcom/wishabi/flipp/content/az;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field static a:I

.field private static e:I

.field private static f:I

.field private static g:I

.field private static h:I

.field private static i:I

.field private static j:I


# instance fields
.field public b:I

.field public c:Z

.field d:Landroid/database/Cursor;

.field private k:I

.field private l:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    const/4 v0, -0x1

    .line 12
    sput v0, Lcom/wishabi/flipp/content/az;->e:I

    .line 13
    sput v0, Lcom/wishabi/flipp/content/az;->f:I

    .line 14
    sput v0, Lcom/wishabi/flipp/content/az;->g:I

    .line 15
    sput v0, Lcom/wishabi/flipp/content/az;->h:I

    .line 16
    sput v0, Lcom/wishabi/flipp/content/az;->i:I

    .line 17
    sput v0, Lcom/wishabi/flipp/content/az;->a:I

    .line 18
    sput v0, Lcom/wishabi/flipp/content/az;->j:I

    return-void
.end method

.method public constructor <init>(Landroid/database/Cursor;I)V
    .locals 1

    .prologue
    const/4 v0, -0x1

    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    iput v0, p0, Lcom/wishabi/flipp/content/az;->b:I

    .line 22
    iput v0, p0, Lcom/wishabi/flipp/content/az;->k:I

    .line 23
    iput v0, p0, Lcom/wishabi/flipp/content/az;->l:I

    .line 27
    invoke-direct {p0, p1, p2}, Lcom/wishabi/flipp/content/az;->a(Landroid/database/Cursor;I)V

    .line 28
    return-void
.end method

.method public constructor <init>(Lcom/wishabi/flipp/content/az;Landroid/database/Cursor;I)V
    .locals 1

    .prologue
    const/4 v0, -0x1

    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    iput v0, p0, Lcom/wishabi/flipp/content/az;->b:I

    .line 22
    iput v0, p0, Lcom/wishabi/flipp/content/az;->k:I

    .line 23
    iput v0, p0, Lcom/wishabi/flipp/content/az;->l:I

    .line 31
    iget v0, p1, Lcom/wishabi/flipp/content/az;->b:I

    iput v0, p0, Lcom/wishabi/flipp/content/az;->b:I

    .line 32
    iget-boolean v0, p1, Lcom/wishabi/flipp/content/az;->c:Z

    iput-boolean v0, p0, Lcom/wishabi/flipp/content/az;->c:Z

    .line 33
    invoke-direct {p0, p2, p3}, Lcom/wishabi/flipp/content/az;->a(Landroid/database/Cursor;I)V

    .line 34
    return-void
.end method

.method private a(Landroid/database/Cursor;I)V
    .locals 2

    .prologue
    const/4 v1, -0x1

    .line 37
    sget v0, Lcom/wishabi/flipp/content/az;->e:I

    if-ne v0, v1, :cond_0

    .line 38
    const-string v0, "id"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    sput v0, Lcom/wishabi/flipp/content/az;->e:I

    .line 40
    :cond_0
    sget v0, Lcom/wishabi/flipp/content/az;->f:I

    if-ne v0, v1, :cond_1

    .line 41
    const-string v0, "name"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    sput v0, Lcom/wishabi/flipp/content/az;->f:I

    .line 43
    :cond_1
    sget v0, Lcom/wishabi/flipp/content/az;->g:I

    if-ne v0, v1, :cond_2

    .line 44
    const-string v0, "checked"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    sput v0, Lcom/wishabi/flipp/content/az;->g:I

    .line 46
    :cond_2
    sget v0, Lcom/wishabi/flipp/content/az;->h:I

    if-ne v0, v1, :cond_3

    .line 47
    const-string v0, "position"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    sput v0, Lcom/wishabi/flipp/content/az;->h:I

    .line 49
    :cond_3
    sget v0, Lcom/wishabi/flipp/content/az;->i:I

    if-ne v0, v1, :cond_4

    .line 50
    const-string v0, "datetime_updated"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    sput v0, Lcom/wishabi/flipp/content/az;->i:I

    .line 53
    :cond_4
    sget v0, Lcom/wishabi/flipp/content/az;->a:I

    if-ne v0, v1, :cond_5

    .line 54
    const-string v0, "category"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    sput v0, Lcom/wishabi/flipp/content/az;->a:I

    .line 56
    :cond_5
    sget v0, Lcom/wishabi/flipp/content/az;->j:I

    if-ne v0, v1, :cond_6

    .line 57
    const-string v0, "cat_position"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    sput v0, Lcom/wishabi/flipp/content/az;->j:I

    .line 59
    :cond_6
    iput-object p1, p0, Lcom/wishabi/flipp/content/az;->d:Landroid/database/Cursor;

    .line 60
    iput p2, p0, Lcom/wishabi/flipp/content/az;->k:I

    .line 61
    return-void
.end method


# virtual methods
.method public final a()J
    .locals 2

    .prologue
    .line 64
    invoke-virtual {p0}, Lcom/wishabi/flipp/content/az;->f()V

    .line 65
    iget-object v0, p0, Lcom/wishabi/flipp/content/az;->d:Landroid/database/Cursor;

    sget v1, Lcom/wishabi/flipp/content/az;->e:I

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v0

    .line 66
    invoke-virtual {p0}, Lcom/wishabi/flipp/content/az;->g()V

    .line 67
    return-wide v0
.end method

.method public final b()Ljava/lang/String;
    .locals 2

    .prologue
    .line 71
    invoke-virtual {p0}, Lcom/wishabi/flipp/content/az;->f()V

    .line 72
    iget-object v0, p0, Lcom/wishabi/flipp/content/az;->d:Landroid/database/Cursor;

    sget v1, Lcom/wishabi/flipp/content/az;->f:I

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 73
    invoke-virtual {p0}, Lcom/wishabi/flipp/content/az;->g()V

    .line 74
    return-object v0
.end method

.method public final c()Z
    .locals 3

    .prologue
    const/4 v0, 0x1

    .line 78
    invoke-virtual {p0}, Lcom/wishabi/flipp/content/az;->f()V

    .line 79
    iget-object v1, p0, Lcom/wishabi/flipp/content/az;->d:Landroid/database/Cursor;

    sget v2, Lcom/wishabi/flipp/content/az;->g:I

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    if-ne v1, v0, :cond_0

    .line 80
    :goto_0
    invoke-virtual {p0}, Lcom/wishabi/flipp/content/az;->g()V

    .line 81
    return v0

    .line 79
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final d()I
    .locals 2

    .prologue
    .line 103
    sget v0, Lcom/wishabi/flipp/content/az;->j:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 104
    new-instance v0, Ljava/lang/IllegalAccessError;

    const-string v1, "Trying to grab category postion for ShoppingListItem without joining on the query"

    invoke-direct {v0, v1}, Ljava/lang/IllegalAccessError;-><init>(Ljava/lang/String;)V

    throw v0

    .line 107
    :cond_0
    invoke-virtual {p0}, Lcom/wishabi/flipp/content/az;->f()V

    .line 108
    iget-object v0, p0, Lcom/wishabi/flipp/content/az;->d:Landroid/database/Cursor;

    sget v1, Lcom/wishabi/flipp/content/az;->j:I

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    .line 109
    invoke-virtual {p0}, Lcom/wishabi/flipp/content/az;->g()V

    .line 110
    return v0
.end method

.method public final e()J
    .locals 2

    .prologue
    .line 114
    invoke-virtual {p0}, Lcom/wishabi/flipp/content/az;->f()V

    .line 115
    iget-object v0, p0, Lcom/wishabi/flipp/content/az;->d:Landroid/database/Cursor;

    sget v1, Lcom/wishabi/flipp/content/az;->i:I

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    .line 116
    invoke-virtual {p0}, Lcom/wishabi/flipp/content/az;->g()V

    .line 117
    int-to-long v0, v0

    return-wide v0
.end method

.method final f()V
    .locals 2

    .prologue
    .line 146
    iget-object v0, p0, Lcom/wishabi/flipp/content/az;->d:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->getPosition()I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/content/az;->l:I

    .line 147
    iget-object v0, p0, Lcom/wishabi/flipp/content/az;->d:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->getPosition()I

    move-result v0

    iget v1, p0, Lcom/wishabi/flipp/content/az;->k:I

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/content/az;->d:Landroid/database/Cursor;

    iget v1, p0, Lcom/wishabi/flipp/content/az;->k:I

    invoke-interface {v0, v1}, Landroid/database/Cursor;->moveToPosition(I)Z

    move-result v0

    if-nez v0, :cond_0

    .line 149
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Shopping list item has no cursor row backing it"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 151
    :cond_0
    return-void
.end method

.method final g()V
    .locals 2

    .prologue
    .line 154
    iget-object v0, p0, Lcom/wishabi/flipp/content/az;->d:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->getPosition()I

    move-result v0

    iget v1, p0, Lcom/wishabi/flipp/content/az;->l:I

    if-eq v0, v1, :cond_0

    .line 155
    iget-object v0, p0, Lcom/wishabi/flipp/content/az;->d:Landroid/database/Cursor;

    iget v1, p0, Lcom/wishabi/flipp/content/az;->l:I

    invoke-interface {v0, v1}, Landroid/database/Cursor;->moveToPosition(I)Z

    .line 156
    :cond_0
    return-void
.end method

.class public final Lcom/wishabi/flipp/util/b;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Iterable;
.implements Ljava/util/Iterator;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/lang/Iterable",
        "<",
        "Lcom/wishabi/flipp/util/d;",
        ">;",
        "Ljava/util/Iterator",
        "<",
        "Lcom/wishabi/flipp/util/d;",
        ">;"
    }
.end annotation


# static fields
.field static final synthetic a:Z


# instance fields
.field private b:Landroid/database/Cursor;

.field private c:Landroid/database/Cursor;

.field private d:Z

.field private e:Lcom/wishabi/flipp/util/d;

.field private f:[I

.field private g:[I

.field private h:[Ljava/lang/Object;

.field private i:[I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 55
    const-class v0, Lcom/wishabi/flipp/util/b;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lcom/wishabi/flipp/util/b;->a:Z

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public constructor <init>(Landroid/database/Cursor;[Ljava/lang/String;Landroid/database/Cursor;[Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 88
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 89
    iput-object p1, p0, Lcom/wishabi/flipp/util/b;->b:Landroid/database/Cursor;

    .line 96
    iput-object p3, p0, Lcom/wishabi/flipp/util/b;->c:Landroid/database/Cursor;

    .line 98
    iget-object v0, p0, Lcom/wishabi/flipp/util/b;->b:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    .line 99
    iget-object v0, p0, Lcom/wishabi/flipp/util/b;->c:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    .line 101
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/wishabi/flipp/util/b;->d:Z

    .line 103
    invoke-static {p1, p2}, Lcom/wishabi/flipp/util/b;->a(Landroid/database/Cursor;[Ljava/lang/String;)[I

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/util/b;->f:[I

    .line 104
    invoke-static {p3, p4}, Lcom/wishabi/flipp/util/b;->a(Landroid/database/Cursor;[Ljava/lang/String;)[I

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/util/b;->g:[I

    .line 105
    invoke-interface {p1}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-lez v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/util/b;->f:[I

    invoke-static {p1, v0}, Lcom/wishabi/flipp/util/b;->a(Landroid/database/Cursor;[I)[I

    move-result-object v0

    :goto_0
    iput-object v0, p0, Lcom/wishabi/flipp/util/b;->i:[I

    .line 109
    iget-object v0, p0, Lcom/wishabi/flipp/util/b;->f:[I

    array-length v0, v0

    mul-int/lit8 v0, v0, 0x2

    new-array v0, v0, [Ljava/lang/Object;

    iput-object v0, p0, Lcom/wishabi/flipp/util/b;->h:[Ljava/lang/Object;

    .line 110
    return-void

    .line 105
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/util/b;->g:[I

    invoke-static {p3, v0}, Lcom/wishabi/flipp/util/b;->a(Landroid/database/Cursor;[I)[I

    move-result-object v0

    goto :goto_0
.end method

.method private static a([Ljava/lang/Object;[I)I
    .locals 6

    .prologue
    const/4 v5, 0x1

    const/4 v3, 0x0

    const/4 v4, -0x1

    .line 279
    array-length v0, p0

    rem-int/lit8 v0, v0, 0x2

    if-eqz v0, :cond_0

    .line 280
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "you must specify an even number of values"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    move v2, v3

    .line 283
    :goto_0
    array-length v0, p0

    if-ge v2, v0, :cond_1

    .line 284
    aget-object v0, p0, v2

    if-nez v0, :cond_2

    .line 285
    add-int/lit8 v0, v2, 0x1

    aget-object v0, p0, v0

    if-eqz v0, :cond_5

    move v3, v4

    .line 315
    :cond_1
    :goto_1
    return v3

    .line 289
    :cond_2
    add-int/lit8 v0, v2, 0x1

    aget-object v0, p0, v0

    if-nez v0, :cond_3

    move v3, v5

    .line 290
    goto :goto_1

    .line 293
    :cond_3
    div-int/lit8 v0, v2, 0x2

    .line 295
    aget v0, p1, v0

    packed-switch v0, :pswitch_data_0

    .line 306
    new-instance v0, Ljava/security/InvalidParameterException;

    const-string v1, "Trying to join on unsupported type"

    invoke-direct {v0, v1}, Ljava/security/InvalidParameterException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 297
    :pswitch_0
    aget-object v0, p0, v2

    check-cast v0, Ljava/lang/String;

    check-cast v0, Ljava/lang/String;

    add-int/lit8 v1, v2, 0x1

    aget-object v1, p0, v1

    check-cast v1, Ljava/lang/String;

    check-cast v1, Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v0

    .line 310
    :goto_2
    if-eqz v0, :cond_5

    .line 311
    if-gez v0, :cond_4

    move v3, v4

    goto :goto_1

    .line 300
    :pswitch_1
    aget-object v0, p0, v2

    check-cast v0, Ljava/lang/Long;

    check-cast v0, Ljava/lang/Long;

    add-int/lit8 v1, v2, 0x1

    aget-object v1, p0, v1

    check-cast v1, Ljava/lang/Long;

    check-cast v1, Ljava/lang/Long;

    invoke-virtual {v0, v1}, Ljava/lang/Long;->compareTo(Ljava/lang/Long;)I

    move-result v0

    goto :goto_2

    .line 303
    :pswitch_2
    aget-object v0, p0, v2

    check-cast v0, Ljava/lang/Float;

    check-cast v0, Ljava/lang/Float;

    add-int/lit8 v1, v2, 0x1

    aget-object v1, p0, v1

    check-cast v1, Ljava/lang/Float;

    check-cast v1, Ljava/lang/Float;

    invoke-virtual {v0, v1}, Ljava/lang/Float;->compareTo(Ljava/lang/Float;)I

    move-result v0

    goto :goto_2

    :cond_4
    move v3, v5

    .line 311
    goto :goto_1

    .line 283
    :cond_5
    add-int/lit8 v0, v2, 0x2

    move v2, v0

    goto :goto_0

    .line 295
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_2
        :pswitch_0
    .end packed-switch
.end method

.method private static a([Ljava/lang/Object;[ILandroid/database/Cursor;[II)V
    .locals 4

    .prologue
    .line 229
    sget-boolean v0, Lcom/wishabi/flipp/util/b;->a:Z

    if-nez v0, :cond_0

    if-eqz p4, :cond_0

    const/4 v0, 0x1

    if-eq p4, v0, :cond_0

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 230
    :cond_0
    const/4 v0, 0x0

    :goto_0
    array-length v1, p3

    if-ge v0, v1, :cond_1

    .line 231
    aget v1, p1, v0

    packed-switch v1, :pswitch_data_0

    .line 242
    new-instance v0, Ljava/security/InvalidParameterException;

    const-string v1, "Trying to join on unsupported type"

    invoke-direct {v0, v1}, Ljava/security/InvalidParameterException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 233
    :pswitch_0
    mul-int/lit8 v1, v0, 0x2

    add-int/2addr v1, p4

    aget v2, p3, v0

    invoke-interface {p2, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    aput-object v2, p0, v1

    .line 230
    :goto_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 236
    :pswitch_1
    mul-int/lit8 v1, v0, 0x2

    add-int/2addr v1, p4

    aget v2, p3, v0

    invoke-interface {p2, v2}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    aput-object v2, p0, v1

    goto :goto_1

    .line 239
    :pswitch_2
    mul-int/lit8 v1, v0, 0x2

    add-int/2addr v1, p4

    aget v2, p3, v0

    invoke-interface {p2, v2}, Landroid/database/Cursor;->getFloat(I)F

    move-result v2

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    aput-object v2, p0, v1

    goto :goto_1

    .line 246
    :cond_1
    return-void

    .line 231
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_2
        :pswitch_0
    .end packed-switch
.end method

.method private static a(Landroid/database/Cursor;[I)[I
    .locals 3

    .prologue
    .line 131
    array-length v0, p1

    new-array v1, v0, [I

    .line 132
    const/4 v0, 0x0

    :goto_0
    array-length v2, p1

    if-ge v0, v2, :cond_0

    .line 133
    aget v2, p1, v0

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getType(I)I

    move-result v2

    aput v2, v1, v0

    .line 132
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 135
    :cond_0
    return-object v1
.end method

.method private static a(Landroid/database/Cursor;[Ljava/lang/String;)[I
    .locals 3

    .prologue
    .line 123
    array-length v0, p1

    new-array v1, v0, [I

    .line 124
    const/4 v0, 0x0

    :goto_0
    array-length v2, p1

    if-ge v0, v2, :cond_0

    .line 125
    aget-object v2, p1, v0

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    aput v2, v1, v0

    .line 124
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 127
    :cond_0
    return-object v1
.end method


# virtual methods
.method public final hasNext()Z
    .locals 4

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 143
    iget-boolean v2, p0, Lcom/wishabi/flipp/util/b;->d:Z

    if-eqz v2, :cond_4

    .line 144
    sget-object v2, Lcom/wishabi/flipp/util/c;->a:[I

    iget-object v3, p0, Lcom/wishabi/flipp/util/b;->e:Lcom/wishabi/flipp/util/d;

    invoke-virtual {v3}, Lcom/wishabi/flipp/util/d;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    .line 155
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "bad value for mCompareResult, "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/wishabi/flipp/util/b;->e:Lcom/wishabi/flipp/util/d;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 146
    :pswitch_0
    iget-object v2, p0, Lcom/wishabi/flipp/util/b;->b:Landroid/database/Cursor;

    invoke-interface {v2}, Landroid/database/Cursor;->isLast()Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/wishabi/flipp/util/b;->c:Landroid/database/Cursor;

    invoke-interface {v2}, Landroid/database/Cursor;->isLast()Z

    move-result v2

    if-nez v2, :cond_1

    :cond_0
    move v0, v1

    .line 159
    :cond_1
    :goto_0
    return v0

    .line 149
    :pswitch_1
    iget-object v2, p0, Lcom/wishabi/flipp/util/b;->b:Landroid/database/Cursor;

    invoke-interface {v2}, Landroid/database/Cursor;->isLast()Z

    move-result v2

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/wishabi/flipp/util/b;->c:Landroid/database/Cursor;

    invoke-interface {v2}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v2

    if-nez v2, :cond_1

    :cond_2
    move v0, v1

    goto :goto_0

    .line 152
    :pswitch_2
    iget-object v2, p0, Lcom/wishabi/flipp/util/b;->b:Landroid/database/Cursor;

    invoke-interface {v2}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v2

    if-eqz v2, :cond_3

    iget-object v2, p0, Lcom/wishabi/flipp/util/b;->c:Landroid/database/Cursor;

    invoke-interface {v2}, Landroid/database/Cursor;->isLast()Z

    move-result v2

    if-nez v2, :cond_1

    :cond_3
    move v0, v1

    goto :goto_0

    .line 159
    :cond_4
    iget-object v2, p0, Lcom/wishabi/flipp/util/b;->b:Landroid/database/Cursor;

    invoke-interface {v2}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v2

    if-eqz v2, :cond_5

    iget-object v2, p0, Lcom/wishabi/flipp/util/b;->c:Landroid/database/Cursor;

    invoke-interface {v2}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v2

    if-nez v2, :cond_1

    :cond_5
    move v0, v1

    goto :goto_0

    .line 144
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public final iterator()Ljava/util/Iterator;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Iterator",
            "<",
            "Lcom/wishabi/flipp/util/d;",
            ">;"
        }
    .end annotation

    .prologue
    .line 113
    return-object p0
.end method

.method public final synthetic next()Ljava/lang/Object;
    .locals 6

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 55
    invoke-virtual {p0}, Lcom/wishabi/flipp/util/b;->hasNext()Z

    move-result v0

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "you must only call next() when hasNext() is true"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    iget-boolean v0, p0, Lcom/wishabi/flipp/util/b;->d:Z

    if-eqz v0, :cond_1

    sget-object v0, Lcom/wishabi/flipp/util/c;->a:[I

    iget-object v3, p0, Lcom/wishabi/flipp/util/b;->e:Lcom/wishabi/flipp/util/d;

    invoke-virtual {v3}, Lcom/wishabi/flipp/util/d;->ordinal()I

    move-result v3

    aget v0, v0, v3

    packed-switch v0, :pswitch_data_0

    :goto_0
    iput-boolean v2, p0, Lcom/wishabi/flipp/util/b;->d:Z

    :cond_1
    sget-boolean v0, Lcom/wishabi/flipp/util/b;->a:Z

    if-nez v0, :cond_2

    invoke-virtual {p0}, Lcom/wishabi/flipp/util/b;->hasNext()Z

    move-result v0

    if-nez v0, :cond_2

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    :pswitch_0
    iget-object v0, p0, Lcom/wishabi/flipp/util/b;->b:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z

    goto :goto_0

    :pswitch_1
    iget-object v0, p0, Lcom/wishabi/flipp/util/b;->c:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z

    goto :goto_0

    :pswitch_2
    iget-object v0, p0, Lcom/wishabi/flipp/util/b;->b:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z

    iget-object v0, p0, Lcom/wishabi/flipp/util/b;->c:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z

    goto :goto_0

    :cond_2
    iget-object v0, p0, Lcom/wishabi/flipp/util/b;->b:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v0

    if-nez v0, :cond_3

    move v0, v1

    :goto_1
    iget-object v3, p0, Lcom/wishabi/flipp/util/b;->c:Landroid/database/Cursor;

    invoke-interface {v3}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v3

    if-nez v3, :cond_4

    move v3, v1

    :goto_2
    if-eqz v0, :cond_5

    if-eqz v3, :cond_5

    iget-object v0, p0, Lcom/wishabi/flipp/util/b;->h:[Ljava/lang/Object;

    iget-object v3, p0, Lcom/wishabi/flipp/util/b;->i:[I

    iget-object v4, p0, Lcom/wishabi/flipp/util/b;->b:Landroid/database/Cursor;

    iget-object v5, p0, Lcom/wishabi/flipp/util/b;->f:[I

    invoke-static {v0, v3, v4, v5, v2}, Lcom/wishabi/flipp/util/b;->a([Ljava/lang/Object;[ILandroid/database/Cursor;[II)V

    iget-object v0, p0, Lcom/wishabi/flipp/util/b;->h:[Ljava/lang/Object;

    iget-object v2, p0, Lcom/wishabi/flipp/util/b;->i:[I

    iget-object v3, p0, Lcom/wishabi/flipp/util/b;->c:Landroid/database/Cursor;

    iget-object v4, p0, Lcom/wishabi/flipp/util/b;->g:[I

    invoke-static {v0, v2, v3, v4, v1}, Lcom/wishabi/flipp/util/b;->a([Ljava/lang/Object;[ILandroid/database/Cursor;[II)V

    iget-object v0, p0, Lcom/wishabi/flipp/util/b;->h:[Ljava/lang/Object;

    iget-object v2, p0, Lcom/wishabi/flipp/util/b;->i:[I

    invoke-static {v0, v2}, Lcom/wishabi/flipp/util/b;->a([Ljava/lang/Object;[I)I

    move-result v0

    packed-switch v0, :pswitch_data_1

    :goto_3
    iput-boolean v1, p0, Lcom/wishabi/flipp/util/b;->d:Z

    iget-object v0, p0, Lcom/wishabi/flipp/util/b;->e:Lcom/wishabi/flipp/util/d;

    return-object v0

    :cond_3
    move v0, v2

    goto :goto_1

    :cond_4
    move v3, v2

    goto :goto_2

    :pswitch_3
    sget-object v0, Lcom/wishabi/flipp/util/d;->b:Lcom/wishabi/flipp/util/d;

    iput-object v0, p0, Lcom/wishabi/flipp/util/b;->e:Lcom/wishabi/flipp/util/d;

    goto :goto_3

    :pswitch_4
    sget-object v0, Lcom/wishabi/flipp/util/d;->c:Lcom/wishabi/flipp/util/d;

    iput-object v0, p0, Lcom/wishabi/flipp/util/b;->e:Lcom/wishabi/flipp/util/d;

    goto :goto_3

    :pswitch_5
    sget-object v0, Lcom/wishabi/flipp/util/d;->a:Lcom/wishabi/flipp/util/d;

    iput-object v0, p0, Lcom/wishabi/flipp/util/b;->e:Lcom/wishabi/flipp/util/d;

    goto :goto_3

    :cond_5
    if-eqz v0, :cond_6

    sget-object v0, Lcom/wishabi/flipp/util/d;->b:Lcom/wishabi/flipp/util/d;

    iput-object v0, p0, Lcom/wishabi/flipp/util/b;->e:Lcom/wishabi/flipp/util/d;

    goto :goto_3

    :cond_6
    sget-boolean v0, Lcom/wishabi/flipp/util/b;->a:Z

    if-nez v0, :cond_7

    if-nez v3, :cond_7

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    :cond_7
    sget-object v0, Lcom/wishabi/flipp/util/d;->a:Lcom/wishabi/flipp/util/d;

    iput-object v0, p0, Lcom/wishabi/flipp/util/b;->e:Lcom/wishabi/flipp/util/d;

    goto :goto_3

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_0
        :pswitch_1
    .end packed-switch

    :pswitch_data_1
    .packed-switch -0x1
        :pswitch_3
        :pswitch_4
        :pswitch_5
    .end packed-switch
.end method

.method public final remove()V
    .locals 2

    .prologue
    .line 213
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "not implemented"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.class public final Lcom/wishabi/flipp/b/s;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/wishabi/flipp/b/s;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum a:I

.field public static final enum b:I

.field public static final enum c:I

.field public static final enum d:I

.field public static final enum e:I

.field public static final enum f:I

.field public static final enum g:I

.field public static final enum h:I

.field public static final enum i:I

.field public static final enum j:I

.field private static final synthetic k:[I


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x5

    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    .line 94
    sput v3, Lcom/wishabi/flipp/b/s;->a:I

    .line 95
    sput v4, Lcom/wishabi/flipp/b/s;->b:I

    .line 96
    sput v5, Lcom/wishabi/flipp/b/s;->c:I

    .line 97
    sput v6, Lcom/wishabi/flipp/b/s;->d:I

    .line 98
    sput v7, Lcom/wishabi/flipp/b/s;->e:I

    .line 99
    const/4 v0, 0x6

    sput v0, Lcom/wishabi/flipp/b/s;->f:I

    .line 100
    const/4 v0, 0x7

    sput v0, Lcom/wishabi/flipp/b/s;->g:I

    .line 101
    const/16 v0, 0x8

    sput v0, Lcom/wishabi/flipp/b/s;->h:I

    .line 102
    const/16 v0, 0x9

    sput v0, Lcom/wishabi/flipp/b/s;->i:I

    .line 103
    const/16 v0, 0xa

    sput v0, Lcom/wishabi/flipp/b/s;->j:I

    .line 93
    const/16 v0, 0xa

    new-array v0, v0, [I

    const/4 v1, 0x0

    sget v2, Lcom/wishabi/flipp/b/s;->a:I

    aput v2, v0, v1

    sget v1, Lcom/wishabi/flipp/b/s;->b:I

    aput v1, v0, v3

    sget v1, Lcom/wishabi/flipp/b/s;->c:I

    aput v1, v0, v4

    sget v1, Lcom/wishabi/flipp/b/s;->d:I

    aput v1, v0, v5

    sget v1, Lcom/wishabi/flipp/b/s;->e:I

    aput v1, v0, v6

    sget v1, Lcom/wishabi/flipp/b/s;->f:I

    aput v1, v0, v7

    const/4 v1, 0x6

    sget v2, Lcom/wishabi/flipp/b/s;->g:I

    aput v2, v0, v1

    const/4 v1, 0x7

    sget v2, Lcom/wishabi/flipp/b/s;->h:I

    aput v2, v0, v1

    const/16 v1, 0x8

    sget v2, Lcom/wishabi/flipp/b/s;->i:I

    aput v2, v0, v1

    const/16 v1, 0x9

    sget v2, Lcom/wishabi/flipp/b/s;->j:I

    aput v2, v0, v1

    sput-object v0, Lcom/wishabi/flipp/b/s;->k:[I

    return-void
.end method

.method public static a()[I
    .locals 1

    .prologue
    .line 93
    sget-object v0, Lcom/wishabi/flipp/b/s;->k:[I

    invoke-virtual {v0}, [I->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [I

    return-object v0
.end method

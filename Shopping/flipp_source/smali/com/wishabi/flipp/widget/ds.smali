.class final Lcom/wishabi/flipp/widget/ds;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/wishabi/flipp/widget/ds;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum a:I

.field public static final enum b:I

.field public static final enum c:I

.field public static final enum d:I

.field public static final enum e:I

.field private static final synthetic f:[I


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v0, 0x5

    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    .line 36
    sput v3, Lcom/wishabi/flipp/widget/ds;->a:I

    sput v4, Lcom/wishabi/flipp/widget/ds;->b:I

    sput v5, Lcom/wishabi/flipp/widget/ds;->c:I

    sput v6, Lcom/wishabi/flipp/widget/ds;->d:I

    sput v0, Lcom/wishabi/flipp/widget/ds;->e:I

    new-array v0, v0, [I

    const/4 v1, 0x0

    sget v2, Lcom/wishabi/flipp/widget/ds;->a:I

    aput v2, v0, v1

    sget v1, Lcom/wishabi/flipp/widget/ds;->b:I

    aput v1, v0, v3

    sget v1, Lcom/wishabi/flipp/widget/ds;->c:I

    aput v1, v0, v4

    sget v1, Lcom/wishabi/flipp/widget/ds;->d:I

    aput v1, v0, v5

    sget v1, Lcom/wishabi/flipp/widget/ds;->e:I

    aput v1, v0, v6

    sput-object v0, Lcom/wishabi/flipp/widget/ds;->f:[I

    return-void
.end method

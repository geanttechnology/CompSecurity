.class public final Lcom/wishabi/flipp/app/fq;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/wishabi/flipp/app/fq;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum a:I

.field public static final enum b:I

.field public static final enum c:I

.field private static final synthetic d:[I


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v0, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    .line 15
    sput v3, Lcom/wishabi/flipp/app/fq;->a:I

    sput v4, Lcom/wishabi/flipp/app/fq;->b:I

    sput v0, Lcom/wishabi/flipp/app/fq;->c:I

    new-array v0, v0, [I

    const/4 v1, 0x0

    sget v2, Lcom/wishabi/flipp/app/fq;->a:I

    aput v2, v0, v1

    sget v1, Lcom/wishabi/flipp/app/fq;->b:I

    aput v1, v0, v3

    sget v1, Lcom/wishabi/flipp/app/fq;->c:I

    aput v1, v0, v4

    sput-object v0, Lcom/wishabi/flipp/app/fq;->d:[I

    return-void
.end method

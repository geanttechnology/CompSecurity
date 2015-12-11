.class public final enum Lcom/wishabi/flipp/b/ap;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/wishabi/flipp/b/ap;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum a:Lcom/wishabi/flipp/b/ap;

.field public static final enum b:Lcom/wishabi/flipp/b/ap;

.field private static final synthetic d:[Lcom/wishabi/flipp/b/ap;


# instance fields
.field private final c:I


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 26
    new-instance v0, Lcom/wishabi/flipp/b/ap;

    const-string v1, "SUCCESS"

    const/16 v2, 0xc8

    invoke-direct {v0, v1, v3, v2}, Lcom/wishabi/flipp/b/ap;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/wishabi/flipp/b/ap;->a:Lcom/wishabi/flipp/b/ap;

    .line 27
    new-instance v0, Lcom/wishabi/flipp/b/ap;

    const-string v1, "ERROR"

    const/4 v2, -0x1

    invoke-direct {v0, v1, v4, v2}, Lcom/wishabi/flipp/b/ap;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/wishabi/flipp/b/ap;->b:Lcom/wishabi/flipp/b/ap;

    .line 25
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/wishabi/flipp/b/ap;

    sget-object v1, Lcom/wishabi/flipp/b/ap;->a:Lcom/wishabi/flipp/b/ap;

    aput-object v1, v0, v3

    sget-object v1, Lcom/wishabi/flipp/b/ap;->b:Lcom/wishabi/flipp/b/ap;

    aput-object v1, v0, v4

    sput-object v0, Lcom/wishabi/flipp/b/ap;->d:[Lcom/wishabi/flipp/b/ap;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    .prologue
    .line 30
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 31
    iput p3, p0, Lcom/wishabi/flipp/b/ap;->c:I

    .line 32
    return-void
.end method

.method public static a(I)Lcom/wishabi/flipp/b/ap;
    .locals 5

    .prologue
    .line 35
    invoke-static {}, Lcom/wishabi/flipp/b/ap;->values()[Lcom/wishabi/flipp/b/ap;

    move-result-object v2

    .line 36
    array-length v3, v2

    const/4 v0, 0x0

    move v1, v0

    :goto_0
    if-ge v1, v3, :cond_1

    aget-object v0, v2, v1

    .line 37
    iget v4, v0, Lcom/wishabi/flipp/b/ap;->c:I

    if-ne v4, p0, :cond_0

    .line 40
    :goto_1
    return-object v0

    .line 36
    :cond_0
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 40
    :cond_1
    sget-object v0, Lcom/wishabi/flipp/b/ap;->b:Lcom/wishabi/flipp/b/ap;

    goto :goto_1
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/wishabi/flipp/b/ap;
    .locals 1

    .prologue
    .line 25
    const-class v0, Lcom/wishabi/flipp/b/ap;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/b/ap;

    return-object v0
.end method

.method public static values()[Lcom/wishabi/flipp/b/ap;
    .locals 1

    .prologue
    .line 25
    sget-object v0, Lcom/wishabi/flipp/b/ap;->d:[Lcom/wishabi/flipp/b/ap;

    invoke-virtual {v0}, [Lcom/wishabi/flipp/b/ap;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/wishabi/flipp/b/ap;

    return-object v0
.end method

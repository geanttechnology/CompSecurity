.class public final enum Lcom/wishabi/flipp/content/f;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/wishabi/flipp/content/f;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum a:Lcom/wishabi/flipp/content/f;

.field public static final enum b:Lcom/wishabi/flipp/content/f;

.field public static final enum c:Lcom/wishabi/flipp/content/f;

.field private static final synthetic e:[Lcom/wishabi/flipp/content/f;


# instance fields
.field public final d:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 41
    new-instance v0, Lcom/wishabi/flipp/content/f;

    const-string v1, "AMOUNT_OFF"

    const-string v2, "amountoff"

    invoke-direct {v0, v1, v3, v2}, Lcom/wishabi/flipp/content/f;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/wishabi/flipp/content/f;->a:Lcom/wishabi/flipp/content/f;

    .line 42
    new-instance v0, Lcom/wishabi/flipp/content/f;

    const-string v1, "PERCENT_OFF"

    const-string v2, "percentoff"

    invoke-direct {v0, v1, v4, v2}, Lcom/wishabi/flipp/content/f;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/wishabi/flipp/content/f;->b:Lcom/wishabi/flipp/content/f;

    .line 43
    new-instance v0, Lcom/wishabi/flipp/content/f;

    const-string v1, "BUY_X_GET_Y"

    const-string v2, "buyxgety"

    invoke-direct {v0, v1, v5, v2}, Lcom/wishabi/flipp/content/f;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/wishabi/flipp/content/f;->c:Lcom/wishabi/flipp/content/f;

    .line 40
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/wishabi/flipp/content/f;

    sget-object v1, Lcom/wishabi/flipp/content/f;->a:Lcom/wishabi/flipp/content/f;

    aput-object v1, v0, v3

    sget-object v1, Lcom/wishabi/flipp/content/f;->b:Lcom/wishabi/flipp/content/f;

    aput-object v1, v0, v4

    sget-object v1, Lcom/wishabi/flipp/content/f;->c:Lcom/wishabi/flipp/content/f;

    aput-object v1, v0, v5

    sput-object v0, Lcom/wishabi/flipp/content/f;->e:[Lcom/wishabi/flipp/content/f;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 47
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 48
    iput-object p3, p0, Lcom/wishabi/flipp/content/f;->d:Ljava/lang/String;

    .line 49
    return-void
.end method

.method public static a(Ljava/lang/String;)Lcom/wishabi/flipp/content/f;
    .locals 5

    .prologue
    .line 52
    invoke-static {}, Lcom/wishabi/flipp/content/f;->values()[Lcom/wishabi/flipp/content/f;

    move-result-object v2

    .line 53
    array-length v3, v2

    const/4 v0, 0x0

    move v1, v0

    :goto_0
    if-ge v1, v3, :cond_1

    aget-object v0, v2, v1

    .line 54
    iget-object v4, v0, Lcom/wishabi/flipp/content/f;->d:Ljava/lang/String;

    invoke-virtual {v4, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 57
    :goto_1
    return-object v0

    .line 53
    :cond_0
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 57
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/wishabi/flipp/content/f;
    .locals 1

    .prologue
    .line 40
    const-class v0, Lcom/wishabi/flipp/content/f;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/content/f;

    return-object v0
.end method

.method public static values()[Lcom/wishabi/flipp/content/f;
    .locals 1

    .prologue
    .line 40
    sget-object v0, Lcom/wishabi/flipp/content/f;->e:[Lcom/wishabi/flipp/content/f;

    invoke-virtual {v0}, [Lcom/wishabi/flipp/content/f;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/wishabi/flipp/content/f;

    return-object v0
.end method

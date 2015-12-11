.class public final enum Lcom/wishabi/flipp/content/e;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/wishabi/flipp/content/e;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum a:Lcom/wishabi/flipp/content/e;

.field public static final enum b:Lcom/wishabi/flipp/content/e;

.field public static final enum c:Lcom/wishabi/flipp/content/e;

.field public static final enum d:Lcom/wishabi/flipp/content/e;

.field private static final synthetic f:[Lcom/wishabi/flipp/content/e;


# instance fields
.field public final e:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 67
    new-instance v0, Lcom/wishabi/flipp/content/e;

    const-string v1, "PRINT"

    const-string v2, "print"

    invoke-direct {v0, v1, v3, v2}, Lcom/wishabi/flipp/content/e;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/wishabi/flipp/content/e;->a:Lcom/wishabi/flipp/content/e;

    .line 68
    new-instance v0, Lcom/wishabi/flipp/content/e;

    const-string v1, "CARD"

    const-string v2, "card"

    invoke-direct {v0, v1, v4, v2}, Lcom/wishabi/flipp/content/e;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/wishabi/flipp/content/e;->b:Lcom/wishabi/flipp/content/e;

    .line 69
    new-instance v0, Lcom/wishabi/flipp/content/e;

    const-string v1, "MOBILE"

    const-string v2, "mobile"

    invoke-direct {v0, v1, v5, v2}, Lcom/wishabi/flipp/content/e;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/wishabi/flipp/content/e;->c:Lcom/wishabi/flipp/content/e;

    .line 70
    new-instance v0, Lcom/wishabi/flipp/content/e;

    const-string v1, "PICTURE"

    const-string v2, "picture"

    invoke-direct {v0, v1, v6, v2}, Lcom/wishabi/flipp/content/e;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/wishabi/flipp/content/e;->d:Lcom/wishabi/flipp/content/e;

    .line 66
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/wishabi/flipp/content/e;

    sget-object v1, Lcom/wishabi/flipp/content/e;->a:Lcom/wishabi/flipp/content/e;

    aput-object v1, v0, v3

    sget-object v1, Lcom/wishabi/flipp/content/e;->b:Lcom/wishabi/flipp/content/e;

    aput-object v1, v0, v4

    sget-object v1, Lcom/wishabi/flipp/content/e;->c:Lcom/wishabi/flipp/content/e;

    aput-object v1, v0, v5

    sget-object v1, Lcom/wishabi/flipp/content/e;->d:Lcom/wishabi/flipp/content/e;

    aput-object v1, v0, v6

    sput-object v0, Lcom/wishabi/flipp/content/e;->f:[Lcom/wishabi/flipp/content/e;

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
    .line 74
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 75
    iput-object p3, p0, Lcom/wishabi/flipp/content/e;->e:Ljava/lang/String;

    .line 76
    return-void
.end method

.method public static a(Ljava/lang/String;)Lcom/wishabi/flipp/content/e;
    .locals 5

    .prologue
    .line 79
    invoke-static {}, Lcom/wishabi/flipp/content/e;->values()[Lcom/wishabi/flipp/content/e;

    move-result-object v2

    .line 80
    array-length v3, v2

    const/4 v0, 0x0

    move v1, v0

    :goto_0
    if-ge v1, v3, :cond_1

    aget-object v0, v2, v1

    .line 81
    iget-object v4, v0, Lcom/wishabi/flipp/content/e;->e:Ljava/lang/String;

    invoke-virtual {v4, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 84
    :goto_1
    return-object v0

    .line 80
    :cond_0
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 84
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/wishabi/flipp/content/e;
    .locals 1

    .prologue
    .line 66
    const-class v0, Lcom/wishabi/flipp/content/e;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/content/e;

    return-object v0
.end method

.method public static values()[Lcom/wishabi/flipp/content/e;
    .locals 1

    .prologue
    .line 66
    sget-object v0, Lcom/wishabi/flipp/content/e;->f:[Lcom/wishabi/flipp/content/e;

    invoke-virtual {v0}, [Lcom/wishabi/flipp/content/e;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/wishabi/flipp/content/e;

    return-object v0
.end method

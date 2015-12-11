.class final enum Larh;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Larh;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum a:Larh;

.field public static final enum b:Larh;

.field public static final enum c:Larh;

.field private static final synthetic d:[Larh;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    new-instance v0, Larh;

    const-string v1, "NONE"

    invoke-direct {v0, v1, v2}, Larh;-><init>(Ljava/lang/String;I)V

    sput-object v0, Larh;->a:Larh;

    new-instance v0, Larh;

    const-string v1, "CONTAINER"

    invoke-direct {v0, v1, v3}, Larh;-><init>(Ljava/lang/String;I)V

    sput-object v0, Larh;->b:Larh;

    new-instance v0, Larh;

    const-string v1, "CONTAINER_DEBUG"

    invoke-direct {v0, v1, v4}, Larh;-><init>(Ljava/lang/String;I)V

    sput-object v0, Larh;->c:Larh;

    const/4 v0, 0x3

    new-array v0, v0, [Larh;

    sget-object v1, Larh;->a:Larh;

    aput-object v1, v0, v2

    sget-object v1, Larh;->b:Larh;

    aput-object v1, v0, v3

    sget-object v1, Larh;->c:Larh;

    aput-object v1, v0, v4

    sput-object v0, Larh;->d:[Larh;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static a()[Larh;
    .locals 1

    sget-object v0, Larh;->d:[Larh;

    invoke-virtual {v0}, [Larh;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Larh;

    return-object v0
.end method

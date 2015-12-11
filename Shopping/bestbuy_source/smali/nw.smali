.class public final enum Lnw;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lnw;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum a:Lnw;

.field public static final enum b:Lnw;

.field public static final enum c:Lnw;

.field private static final synthetic d:[Lnw;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    new-instance v0, Lnw;

    const-string v1, "UNKNOWN"

    invoke-direct {v0, v1, v2}, Lnw;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lnw;->a:Lnw;

    new-instance v0, Lnw;

    const-string v1, "MALE"

    invoke-direct {v0, v1, v3}, Lnw;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lnw;->b:Lnw;

    new-instance v0, Lnw;

    const-string v1, "FEMALE"

    invoke-direct {v0, v1, v4}, Lnw;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lnw;->c:Lnw;

    const/4 v0, 0x3

    new-array v0, v0, [Lnw;

    sget-object v1, Lnw;->a:Lnw;

    aput-object v1, v0, v2

    sget-object v1, Lnw;->b:Lnw;

    aput-object v1, v0, v3

    sget-object v1, Lnw;->c:Lnw;

    aput-object v1, v0, v4

    sput-object v0, Lnw;->d:[Lnw;

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

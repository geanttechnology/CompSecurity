.class public final enum Lbr;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lbr;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum a:Lbr;

.field public static final enum b:Lbr;

.field public static final enum c:Lbr;

.field public static final enum d:Lbr;

.field private static final synthetic e:[Lbr;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 73
    new-instance v0, Lbr;

    const-string v1, "NATIVE_APP_INTENT"

    invoke-direct {v0, v1, v2}, Lbr;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lbr;->a:Lbr;

    .line 74
    new-instance v0, Lbr;

    const-string v1, "PRODUCT_SEARCH_LINK"

    invoke-direct {v0, v1, v3}, Lbr;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lbr;->b:Lbr;

    .line 75
    new-instance v0, Lbr;

    const-string v1, "ZXING_LINK"

    invoke-direct {v0, v1, v4}, Lbr;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lbr;->c:Lbr;

    .line 76
    new-instance v0, Lbr;

    const-string v1, "NONE"

    invoke-direct {v0, v1, v5}, Lbr;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lbr;->d:Lbr;

    .line 72
    const/4 v0, 0x4

    new-array v0, v0, [Lbr;

    sget-object v1, Lbr;->a:Lbr;

    aput-object v1, v0, v2

    sget-object v1, Lbr;->b:Lbr;

    aput-object v1, v0, v3

    sget-object v1, Lbr;->c:Lbr;

    aput-object v1, v0, v4

    sget-object v1, Lbr;->d:Lbr;

    aput-object v1, v0, v5

    sput-object v0, Lbr;->e:[Lbr;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 72
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

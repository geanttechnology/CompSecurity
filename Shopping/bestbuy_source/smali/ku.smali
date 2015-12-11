.class public final enum Lku;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lku;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum a:Lku;

.field public static final enum b:Lku;

.field public static final enum c:Lku;

.field private static final synthetic d:[Lku;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 28
    new-instance v0, Lku;

    const-string v1, "DEAL_OF_THE_DAY"

    invoke-direct {v0, v1, v2}, Lku;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lku;->a:Lku;

    .line 29
    new-instance v0, Lku;

    const-string v1, "WEEKLY_DEALS"

    invoke-direct {v0, v1, v3}, Lku;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lku;->b:Lku;

    .line 30
    new-instance v0, Lku;

    const-string v1, "UNKNOWN"

    invoke-direct {v0, v1, v4}, Lku;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lku;->c:Lku;

    .line 27
    const/4 v0, 0x3

    new-array v0, v0, [Lku;

    sget-object v1, Lku;->a:Lku;

    aput-object v1, v0, v2

    sget-object v1, Lku;->b:Lku;

    aput-object v1, v0, v3

    sget-object v1, Lku;->c:Lku;

    aput-object v1, v0, v4

    sput-object v0, Lku;->d:[Lku;

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
    .line 27
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

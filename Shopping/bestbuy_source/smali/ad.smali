.class public final enum Lad;
.super Ljava/lang/Enum;
.source "SourceFile"


# static fields
.field public static final enum a:Lad;

.field public static final enum b:Lad;

.field public static final enum c:Lad;

.field private static final synthetic d:[Lad;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 11
    new-instance v0, Lad;

    const-string v1, "ABOUT_TO_SEND"

    invoke-direct {v0, v1, v2}, Lad;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lad;->a:Lad;

    .line 12
    new-instance v0, Lad;

    const-string v1, "REQUEST_SENT"

    invoke-direct {v0, v1, v3}, Lad;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lad;->b:Lad;

    .line 13
    new-instance v0, Lad;

    const-string v1, "ERROR"

    invoke-direct {v0, v1, v4}, Lad;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lad;->c:Lad;

    .line 10
    const/4 v0, 0x3

    new-array v0, v0, [Lad;

    sget-object v1, Lad;->a:Lad;

    aput-object v1, v0, v2

    sget-object v1, Lad;->b:Lad;

    aput-object v1, v0, v3

    sget-object v1, Lad;->c:Lad;

    aput-object v1, v0, v4

    sput-object v0, Lad;->d:[Lad;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static a()[Lad;
    .locals 1

    .prologue
    .line 10
    sget-object v0, Lad;->d:[Lad;

    invoke-virtual {v0}, [Lad;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lad;

    return-object v0
.end method

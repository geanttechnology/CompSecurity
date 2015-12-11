.class public final enum Lfv;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lfv;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum a:Lfv;

.field public static final enum b:Lfv;

.field private static final synthetic e:[Lfv;


# instance fields
.field public c:Ljava/lang/String;

.field public d:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 43
    new-instance v0, Lfv;

    const-string v1, "PROD"

    const-string v2, "http://api.remix.bestbuy.com/v1"

    const-string v3, "k79nejwehxtssudf9ktp8ncr"

    invoke-direct {v0, v1, v4, v2, v3}, Lfv;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lfv;->a:Lfv;

    .line 44
    new-instance v0, Lfv;

    const-string v1, "CUSTOM"

    const-string v2, ""

    const-string v3, ""

    invoke-direct {v0, v1, v5, v2, v3}, Lfv;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lfv;->b:Lfv;

    .line 42
    const/4 v0, 0x2

    new-array v0, v0, [Lfv;

    sget-object v1, Lfv;->a:Lfv;

    aput-object v1, v0, v4

    sget-object v1, Lfv;->b:Lfv;

    aput-object v1, v0, v5

    sput-object v0, Lfv;->e:[Lfv;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 49
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 50
    iput-object p3, p0, Lfv;->c:Ljava/lang/String;

    .line 52
    iput-object p4, p0, Lfv;->d:Ljava/lang/String;

    .line 53
    return-void
.end method

.method public static a(Ljava/lang/String;)Lfv;
    .locals 1

    .prologue
    .line 42
    const-class v0, Lfv;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lfv;

    return-object v0
.end method

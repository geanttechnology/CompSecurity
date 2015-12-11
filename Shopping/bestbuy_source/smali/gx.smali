.class public final enum Lgx;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lgx;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum a:Lgx;

.field public static final enum b:Lgx;

.field public static final enum c:Lgx;

.field public static final enum d:Lgx;

.field private static final synthetic f:[Lgx;


# instance fields
.field private e:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 65
    new-instance v0, Lgx;

    const-string v1, "GET"

    const-string v2, "GET"

    invoke-direct {v0, v1, v3, v2}, Lgx;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lgx;->a:Lgx;

    .line 66
    new-instance v0, Lgx;

    const-string v1, "POST"

    const-string v2, "POST"

    invoke-direct {v0, v1, v4, v2}, Lgx;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lgx;->b:Lgx;

    .line 67
    new-instance v0, Lgx;

    const-string v1, "PUT"

    const-string v2, "PUT"

    invoke-direct {v0, v1, v5, v2}, Lgx;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lgx;->c:Lgx;

    .line 68
    new-instance v0, Lgx;

    const-string v1, "DELETE"

    const-string v2, "DELETE"

    invoke-direct {v0, v1, v6, v2}, Lgx;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lgx;->d:Lgx;

    .line 64
    const/4 v0, 0x4

    new-array v0, v0, [Lgx;

    sget-object v1, Lgx;->a:Lgx;

    aput-object v1, v0, v3

    sget-object v1, Lgx;->b:Lgx;

    aput-object v1, v0, v4

    sget-object v1, Lgx;->c:Lgx;

    aput-object v1, v0, v5

    sget-object v1, Lgx;->d:Lgx;

    aput-object v1, v0, v6

    sput-object v0, Lgx;->f:[Lgx;

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
    .line 72
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 73
    iput-object p3, p0, Lgx;->e:Ljava/lang/String;

    .line 74
    return-void
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 77
    iget-object v0, p0, Lgx;->e:Ljava/lang/String;

    return-object v0
.end method

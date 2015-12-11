.class public final enum Lgp;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lgp;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum a:Lgp;

.field public static final enum b:Lgp;

.field public static final enum c:Lgp;

.field public static final enum d:Lgp;

.field private static final synthetic f:[Lgp;


# instance fields
.field public e:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 16
    new-instance v0, Lgp;

    const-string v1, "PROD"

    const-string v2, "https://www-ssl.bestbuy.com"

    invoke-direct {v0, v1, v3, v2}, Lgp;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lgp;->a:Lgp;

    .line 17
    new-instance v0, Lgp;

    const-string v1, "QA1"

    const-string v2, "http://www.qa.bestbuy.com/api/"

    invoke-direct {v0, v1, v4, v2}, Lgp;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lgp;->b:Lgp;

    .line 18
    new-instance v0, Lgp;

    const-string v1, "QA3"

    const-string v2, "http://bby-qa3.bestbuy.com"

    invoke-direct {v0, v1, v5, v2}, Lgp;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lgp;->c:Lgp;

    .line 19
    new-instance v0, Lgp;

    const-string v1, "CUSTOM"

    const-string v2, ""

    invoke-direct {v0, v1, v6, v2}, Lgp;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lgp;->d:Lgp;

    .line 15
    const/4 v0, 0x4

    new-array v0, v0, [Lgp;

    sget-object v1, Lgp;->a:Lgp;

    aput-object v1, v0, v3

    sget-object v1, Lgp;->b:Lgp;

    aput-object v1, v0, v4

    sget-object v1, Lgp;->c:Lgp;

    aput-object v1, v0, v5

    sget-object v1, Lgp;->d:Lgp;

    aput-object v1, v0, v6

    sput-object v0, Lgp;->f:[Lgp;

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
    .line 23
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 24
    iput-object p3, p0, Lgp;->e:Ljava/lang/String;

    .line 25
    return-void
.end method

.class public final enum Lgl;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lgl;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum a:Lgl;

.field public static final enum b:Lgl;

.field public static final enum c:Lgl;

.field public static final enum d:Lgl;

.field public static final enum e:Lgl;

.field private static final synthetic g:[Lgl;


# instance fields
.field public f:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 32
    new-instance v0, Lgl;

    const-string v1, "PROD"

    const-string v2, "https://app-ssl.bestbuy.com"

    invoke-direct {v0, v1, v3, v2}, Lgl;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lgl;->a:Lgl;

    .line 33
    new-instance v0, Lgl;

    const-string v1, "QA1"

    const-string v2, "https://qa1.iam-secure.bestbuy.com"

    invoke-direct {v0, v1, v4, v2}, Lgl;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lgl;->b:Lgl;

    .line 34
    new-instance v0, Lgl;

    const-string v1, "STAGE"

    const-string v2, "https://app-ssl.stage.bestbuy.com"

    invoke-direct {v0, v1, v5, v2}, Lgl;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lgl;->c:Lgl;

    .line 35
    new-instance v0, Lgl;

    const-string v1, "CLOUD_TEST"

    const-string v2, "https://app-ssl.cloud-test.bestbuy.com"

    invoke-direct {v0, v1, v6, v2}, Lgl;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lgl;->d:Lgl;

    .line 36
    new-instance v0, Lgl;

    const-string v1, "CUSTOM"

    const-string v2, ""

    invoke-direct {v0, v1, v7, v2}, Lgl;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lgl;->e:Lgl;

    .line 31
    const/4 v0, 0x5

    new-array v0, v0, [Lgl;

    sget-object v1, Lgl;->a:Lgl;

    aput-object v1, v0, v3

    sget-object v1, Lgl;->b:Lgl;

    aput-object v1, v0, v4

    sget-object v1, Lgl;->c:Lgl;

    aput-object v1, v0, v5

    sget-object v1, Lgl;->d:Lgl;

    aput-object v1, v0, v6

    sget-object v1, Lgl;->e:Lgl;

    aput-object v1, v0, v7

    sput-object v0, Lgl;->g:[Lgl;

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
    .line 40
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 41
    iput-object p3, p0, Lgl;->f:Ljava/lang/String;

    .line 42
    return-void
.end method

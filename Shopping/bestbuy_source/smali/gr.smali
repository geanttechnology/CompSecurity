.class public final enum Lgr;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lgr;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum a:Lgr;

.field public static final enum b:Lgr;

.field public static final enum c:Lgr;

.field public static final enum d:Lgr;

.field public static final enum e:Lgr;

.field private static final synthetic g:[Lgr;


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

    .line 105
    new-instance v0, Lgr;

    const-string v1, "PROD"

    const-string v2, "https://app-ssl.bestbuy.com"

    invoke-direct {v0, v1, v3, v2}, Lgr;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lgr;->a:Lgr;

    .line 106
    new-instance v0, Lgr;

    const-string v1, "QA1"

    const-string v2, "http://qa1-serviceinterceptor.cdc.bestbuy.com"

    invoke-direct {v0, v1, v4, v2}, Lgr;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lgr;->b:Lgr;

    .line 107
    new-instance v0, Lgr;

    const-string v1, "QA3"

    const-string v2, "http://app-ssl.qa3.bestbuy.com"

    invoke-direct {v0, v1, v5, v2}, Lgr;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lgr;->c:Lgr;

    .line 108
    new-instance v0, Lgr;

    const-string v1, "STAGE"

    const-string v2, "https://app-ssl.stage.bestbuy.com"

    invoke-direct {v0, v1, v6, v2}, Lgr;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lgr;->d:Lgr;

    .line 109
    new-instance v0, Lgr;

    const-string v1, "CUSTOM"

    const-string v2, ""

    invoke-direct {v0, v1, v7, v2}, Lgr;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lgr;->e:Lgr;

    .line 104
    const/4 v0, 0x5

    new-array v0, v0, [Lgr;

    sget-object v1, Lgr;->a:Lgr;

    aput-object v1, v0, v3

    sget-object v1, Lgr;->b:Lgr;

    aput-object v1, v0, v4

    sget-object v1, Lgr;->c:Lgr;

    aput-object v1, v0, v5

    sget-object v1, Lgr;->d:Lgr;

    aput-object v1, v0, v6

    sget-object v1, Lgr;->e:Lgr;

    aput-object v1, v0, v7

    sput-object v0, Lgr;->g:[Lgr;

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
    .line 113
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 114
    iput-object p3, p0, Lgr;->f:Ljava/lang/String;

    .line 115
    return-void
.end method

.method public static a(Ljava/lang/String;)Lgr;
    .locals 1

    .prologue
    .line 104
    const-class v0, Lgr;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lgr;

    return-object v0
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 118
    iget-object v0, p0, Lgr;->f:Ljava/lang/String;

    return-object v0
.end method

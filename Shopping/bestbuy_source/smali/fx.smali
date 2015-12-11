.class public final enum Lfx;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lfx;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum a:Lfx;

.field public static final enum b:Lfx;

.field public static final enum c:Lfx;

.field public static final enum d:Lfx;

.field private static final synthetic f:[Lfx;


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

    .line 18
    new-instance v0, Lfx;

    const-string v1, "PROD"

    const-string v2, "https://www-ssl.bestbuy.com/api/"

    invoke-direct {v0, v1, v3, v2}, Lfx;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lfx;->a:Lfx;

    .line 19
    new-instance v0, Lfx;

    const-string v1, "QA1"

    const-string v2, "http://www.qa.bestbuy.com/api/"

    invoke-direct {v0, v1, v4, v2}, Lfx;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lfx;->b:Lfx;

    .line 20
    new-instance v0, Lfx;

    const-string v1, "QA3"

    const-string v2, "http://bby-qa3.bestbuy.com/api/"

    invoke-direct {v0, v1, v5, v2}, Lfx;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lfx;->c:Lfx;

    .line 21
    new-instance v0, Lfx;

    const-string v1, "CUSTOM"

    const-string v2, ""

    invoke-direct {v0, v1, v6, v2}, Lfx;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lfx;->d:Lfx;

    .line 17
    const/4 v0, 0x4

    new-array v0, v0, [Lfx;

    sget-object v1, Lfx;->a:Lfx;

    aput-object v1, v0, v3

    sget-object v1, Lfx;->b:Lfx;

    aput-object v1, v0, v4

    sget-object v1, Lfx;->c:Lfx;

    aput-object v1, v0, v5

    sget-object v1, Lfx;->d:Lfx;

    aput-object v1, v0, v6

    sput-object v0, Lfx;->f:[Lfx;

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
    .line 25
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 26
    iput-object p3, p0, Lfx;->e:Ljava/lang/String;

    .line 27
    return-void
.end method

.method public static a(Ljava/lang/String;)Lfx;
    .locals 1

    .prologue
    .line 17
    const-class v0, Lfx;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lfx;

    return-object v0
.end method

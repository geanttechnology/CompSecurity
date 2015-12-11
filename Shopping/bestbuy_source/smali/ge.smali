.class public final enum Lge;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lge;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum a:Lge;

.field public static final enum b:Lge;

.field public static final enum c:Lge;

.field private static final synthetic f:[Lge;


# instance fields
.field public d:Ljava/lang/String;

.field public e:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 35
    new-instance v0, Lge;

    const-string v1, "PROD"

    const-string v2, "http://api.deals.bestbuy.com/v1"

    const-string v3, "kus5hgbf8sgaen7fjegqdcfb"

    invoke-direct {v0, v1, v4, v2, v3}, Lge;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lge;->a:Lge;

    .line 36
    new-instance v0, Lge;

    const-string v1, "PROD_LIKE"

    const-string v2, "http://pl.deals.bestbuy.com/v1"

    const-string v3, "kus5hgbf8sgaen7fjegqdcfb"

    invoke-direct {v0, v1, v5, v2, v3}, Lge;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lge;->b:Lge;

    .line 37
    new-instance v0, Lge;

    const-string v1, "CUSTOM"

    const-string v2, ""

    const-string v3, ""

    invoke-direct {v0, v1, v6, v2, v3}, Lge;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lge;->c:Lge;

    .line 34
    const/4 v0, 0x3

    new-array v0, v0, [Lge;

    sget-object v1, Lge;->a:Lge;

    aput-object v1, v0, v4

    sget-object v1, Lge;->b:Lge;

    aput-object v1, v0, v5

    sget-object v1, Lge;->c:Lge;

    aput-object v1, v0, v6

    sput-object v0, Lge;->f:[Lge;

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
    .line 42
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 43
    iput-object p3, p0, Lge;->d:Ljava/lang/String;

    .line 44
    iput-object p4, p0, Lge;->e:Ljava/lang/String;

    .line 45
    return-void
.end method

.method public static a(Ljava/lang/String;)Lge;
    .locals 1

    .prologue
    .line 34
    const-class v0, Lge;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lge;

    return-object v0
.end method

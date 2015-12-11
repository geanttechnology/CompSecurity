.class public final enum Lgb;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lgb;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum a:Lgb;

.field public static final enum b:Lgb;

.field public static final enum c:Lgb;

.field public static final enum d:Lgb;

.field public static final enum e:Lgb;

.field public static final enum f:Lgb;

.field private static final synthetic h:[Lgb;


# instance fields
.field public g:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 33
    new-instance v0, Lgb;

    const-string v1, "PROD"

    const-string v2, "http://www.bestbuy.com/cartitems/cart/"

    invoke-direct {v0, v1, v4, v2}, Lgb;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lgb;->a:Lgb;

    .line 34
    new-instance v0, Lgb;

    const-string v1, "QA1"

    const-string v2, "http://www.qa.bestbuy.com/cartitems/cart/"

    invoke-direct {v0, v1, v5, v2}, Lgb;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lgb;->b:Lgb;

    .line 35
    new-instance v0, Lgb;

    const-string v1, "QA3"

    const-string v2, "http://bby-qa3.bestbuy.com/cartitems/cart/"

    invoke-direct {v0, v1, v6, v2}, Lgb;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lgb;->c:Lgb;

    .line 36
    new-instance v0, Lgb;

    const-string v1, "STAGE"

    const-string v2, "http://www.stage.bestbuy.com/cartitems/cart/"

    invoke-direct {v0, v1, v7, v2}, Lgb;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lgb;->d:Lgb;

    .line 37
    new-instance v0, Lgb;

    const-string v1, "CDC"

    const-string v2, "https://ets-commerceproductteam-cart1541release-atgci.cdc.bestbuy.com/cartitems/cart/"

    invoke-direct {v0, v1, v8, v2}, Lgb;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lgb;->e:Lgb;

    .line 38
    new-instance v0, Lgb;

    const-string v1, "CUSTOM"

    const/4 v2, 0x5

    const-string v3, ""

    invoke-direct {v0, v1, v2, v3}, Lgb;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lgb;->f:Lgb;

    .line 32
    const/4 v0, 0x6

    new-array v0, v0, [Lgb;

    sget-object v1, Lgb;->a:Lgb;

    aput-object v1, v0, v4

    sget-object v1, Lgb;->b:Lgb;

    aput-object v1, v0, v5

    sget-object v1, Lgb;->c:Lgb;

    aput-object v1, v0, v6

    sget-object v1, Lgb;->d:Lgb;

    aput-object v1, v0, v7

    sget-object v1, Lgb;->e:Lgb;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lgb;->f:Lgb;

    aput-object v2, v0, v1

    sput-object v0, Lgb;->h:[Lgb;

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
    .line 42
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 43
    iput-object p3, p0, Lgb;->g:Ljava/lang/String;

    .line 44
    return-void
.end method

.method public static a(Ljava/lang/String;)Lgb;
    .locals 1

    .prologue
    .line 32
    const-class v0, Lgb;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lgb;

    return-object v0
.end method

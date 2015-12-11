.class public final enum Lgh;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lgh;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum a:Lgh;

.field public static final enum b:Lgh;

.field public static final enum c:Lgh;

.field public static final enum d:Lgh;

.field public static final enum e:Lgh;

.field private static final synthetic k:[Lgh;


# instance fields
.field public f:Ljava/lang/String;

.field public g:Ljava/lang/String;

.field public h:Ljava/lang/String;

.field public i:Ljava/lang/String;

.field public j:Z


# direct methods
.method static constructor <clinit>()V
    .locals 15

    .prologue
    const/4 v14, 0x4

    const/4 v13, 0x3

    const/4 v12, 0x2

    const/4 v2, 0x0

    const/4 v11, 0x1

    .line 36
    new-instance v0, Lgh;

    const-string v1, "PROD"

    const-string v3, "http://context.bestbuy.com"

    const-string v4, "TA1:MXRVMEFJUTRZajJCb25ERC9HLy91cytNdkdrNXF4RlJCS0N3bUlFNDR4OD0="

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    const-string v6, ""

    const-string v7, ""

    invoke-direct/range {v0 .. v7}, Lgh;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lgh;->a:Lgh;

    .line 37
    new-instance v3, Lgh;

    const-string v4, "PROD_LIKE"

    const-string v6, "http://pl.context.bestbuy.com"

    const-string v7, "TA1:WHdjUkV4dkhZYnRIeWo2dU1OOFRwa3NZMytoV1BrWk5KY0VWQmVJYXBqVT0="

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v8

    const-string v9, ""

    const-string v10, ""

    move v5, v11

    invoke-direct/range {v3 .. v10}, Lgh;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V

    sput-object v3, Lgh;->b:Lgh;

    .line 38
    new-instance v3, Lgh;

    const-string v4, "QA"

    const-string v6, "http://qa.context.bestbuy.com"

    const-string v7, ""

    invoke-static {v11}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v8

    const-string v9, "bby_context"

    const-string v10, "BestBuy1"

    move v5, v12

    invoke-direct/range {v3 .. v10}, Lgh;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V

    sput-object v3, Lgh;->c:Lgh;

    .line 39
    new-instance v3, Lgh;

    const-string v4, "DEV"

    const-string v6, "http://dev.context.bestbuy.com"

    const-string v7, ""

    invoke-static {v11}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v8

    const-string v9, "bby_context"

    const-string v10, "BestBuy1"

    move v5, v13

    invoke-direct/range {v3 .. v10}, Lgh;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V

    sput-object v3, Lgh;->d:Lgh;

    .line 40
    new-instance v3, Lgh;

    const-string v4, "CUSTOM"

    const-string v6, ""

    const-string v7, ""

    invoke-static {v11}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v8

    const-string v9, "bby_context"

    const-string v10, "BestBuy1"

    move v5, v14

    invoke-direct/range {v3 .. v10}, Lgh;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V

    sput-object v3, Lgh;->e:Lgh;

    .line 34
    const/4 v0, 0x5

    new-array v0, v0, [Lgh;

    sget-object v1, Lgh;->a:Lgh;

    aput-object v1, v0, v2

    sget-object v1, Lgh;->b:Lgh;

    aput-object v1, v0, v11

    sget-object v1, Lgh;->c:Lgh;

    aput-object v1, v0, v12

    sget-object v1, Lgh;->d:Lgh;

    aput-object v1, v0, v13

    sget-object v1, Lgh;->e:Lgh;

    aput-object v1, v0, v14

    sput-object v0, Lgh;->k:[Lgh;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/Boolean;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 48
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 49
    iput-object p3, p0, Lgh;->f:Ljava/lang/String;

    .line 50
    iput-object p4, p0, Lgh;->g:Ljava/lang/String;

    .line 51
    invoke-virtual {p5}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    iput-boolean v0, p0, Lgh;->j:Z

    .line 52
    iput-object p6, p0, Lgh;->h:Ljava/lang/String;

    .line 53
    iput-object p7, p0, Lgh;->i:Ljava/lang/String;

    .line 54
    return-void
.end method

.method public static a(Ljava/lang/String;)Lgh;
    .locals 1

    .prologue
    .line 34
    const-class v0, Lgh;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lgh;

    return-object v0
.end method

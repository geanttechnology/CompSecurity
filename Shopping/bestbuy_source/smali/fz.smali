.class final enum Lfz;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lfz;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum a:Lfz;

.field public static final enum b:Lfz;

.field public static final enum c:Lfz;

.field public static final enum d:Lfz;

.field public static final enum e:Lfz;

.field private static final synthetic h:[Lfz;


# instance fields
.field private f:Ljava/lang/String;

.field private g:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 40
    new-instance v0, Lfz;

    const-string v1, "PROD"

    const-string v2, "https://commerce-ssl.bestbuy.com"

    const-string v3, "3f96af3f-912d-4a66-b6a9-639be43e3911"

    invoke-direct {v0, v1, v4, v2, v3}, Lfz;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lfz;->a:Lfz;

    .line 41
    new-instance v0, Lfz;

    const-string v1, "QA"

    const-string v2, "https://commerce.qa.bestbuy.com"

    const-string v3, "f97cb11e-d3a3-429a-9b4e-db86a671c182"

    invoke-direct {v0, v1, v5, v2, v3}, Lfz;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lfz;->b:Lfz;

    .line 42
    new-instance v0, Lfz;

    const-string v1, "QA2"

    const-string v2, "https://commerce-qa2.bestbuy.com"

    const-string v3, "f97cb11e-d3a3-429a-9b4e-db86a671c182"

    invoke-direct {v0, v1, v6, v2, v3}, Lfz;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lfz;->c:Lfz;

    .line 43
    new-instance v0, Lfz;

    const-string v1, "QA3"

    const-string v2, "https://commerce-qa3.bestbuy.com"

    const-string v3, "f97cb11e-d3a3-429a-9b4e-db86a671c182"

    invoke-direct {v0, v1, v7, v2, v3}, Lfz;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lfz;->d:Lfz;

    .line 44
    new-instance v0, Lfz;

    const-string v1, "STAGING"

    const-string v2, "https://commerce-ssl.stage.bestbuy.com"

    const-string v3, "f97cb11e-d3a3-429a-9b4e-db86a671c182"

    invoke-direct {v0, v1, v8, v2, v3}, Lfz;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lfz;->e:Lfz;

    .line 39
    const/4 v0, 0x5

    new-array v0, v0, [Lfz;

    sget-object v1, Lfz;->a:Lfz;

    aput-object v1, v0, v4

    sget-object v1, Lfz;->b:Lfz;

    aput-object v1, v0, v5

    sget-object v1, Lfz;->c:Lfz;

    aput-object v1, v0, v6

    sget-object v1, Lfz;->d:Lfz;

    aput-object v1, v0, v7

    sget-object v1, Lfz;->e:Lfz;

    aput-object v1, v0, v8

    sput-object v0, Lfz;->h:[Lfz;

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
    iput-object p3, p0, Lfz;->f:Ljava/lang/String;

    .line 51
    iput-object p4, p0, Lfz;->g:Ljava/lang/String;

    .line 52
    return-void
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lfz;->f:Ljava/lang/String;

    return-object v0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lfz;->g:Ljava/lang/String;

    return-object v0
.end method

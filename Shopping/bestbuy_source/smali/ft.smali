.class public final enum Lft;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lft;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum a:Lft;

.field public static final enum b:Lft;

.field public static final enum c:Lft;

.field public static final enum d:Lft;

.field public static final enum e:Lft;

.field public static final enum f:Lft;

.field public static final enum g:Lft;

.field public static final enum h:Lft;

.field public static final enum i:Lft;

.field public static final enum j:Lft;

.field public static final enum k:Lft;

.field public static final enum l:Lft;

.field private static final synthetic m:[Lft;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 115
    new-instance v0, Lft;

    const-string v1, "PROD"

    invoke-direct {v0, v1, v3}, Lft;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lft;->a:Lft;

    .line 116
    new-instance v0, Lft;

    const-string v1, "PROD_LIKE"

    invoke-direct {v0, v1, v4}, Lft;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lft;->b:Lft;

    .line 117
    new-instance v0, Lft;

    const-string v1, "CLOUD_TEST"

    invoke-direct {v0, v1, v5}, Lft;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lft;->c:Lft;

    .line 118
    new-instance v0, Lft;

    const-string v1, "STAGE"

    invoke-direct {v0, v1, v6}, Lft;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lft;->d:Lft;

    .line 119
    new-instance v0, Lft;

    const-string v1, "QA"

    invoke-direct {v0, v1, v7}, Lft;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lft;->e:Lft;

    .line 120
    new-instance v0, Lft;

    const-string v1, "QA1"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lft;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lft;->f:Lft;

    .line 121
    new-instance v0, Lft;

    const-string v1, "QA2"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lft;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lft;->g:Lft;

    .line 122
    new-instance v0, Lft;

    const-string v1, "QA3"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lft;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lft;->h:Lft;

    .line 123
    new-instance v0, Lft;

    const-string v1, "CDC"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lft;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lft;->i:Lft;

    .line 124
    new-instance v0, Lft;

    const-string v1, "DEV"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Lft;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lft;->j:Lft;

    .line 125
    new-instance v0, Lft;

    const-string v1, "LOCAL"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Lft;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lft;->k:Lft;

    .line 126
    new-instance v0, Lft;

    const-string v1, "CUSTOM"

    const/16 v2, 0xb

    invoke-direct {v0, v1, v2}, Lft;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lft;->l:Lft;

    .line 114
    const/16 v0, 0xc

    new-array v0, v0, [Lft;

    sget-object v1, Lft;->a:Lft;

    aput-object v1, v0, v3

    sget-object v1, Lft;->b:Lft;

    aput-object v1, v0, v4

    sget-object v1, Lft;->c:Lft;

    aput-object v1, v0, v5

    sget-object v1, Lft;->d:Lft;

    aput-object v1, v0, v6

    sget-object v1, Lft;->e:Lft;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lft;->f:Lft;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lft;->g:Lft;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lft;->h:Lft;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lft;->i:Lft;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lft;->j:Lft;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lft;->k:Lft;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lft;->l:Lft;

    aput-object v2, v0, v1

    sput-object v0, Lft;->m:[Lft;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 114
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.class public final enum Lcom/poshmark/config/Env;
.super Ljava/lang/Enum;
.source "Env.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/poshmark/config/Env;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/poshmark/config/Env;

.field public static final enum DEV:Lcom/poshmark/config/Env;

.field public static final enum DEVTEAM:Lcom/poshmark/config/Env;

.field public static final enum PRODUCTION:Lcom/poshmark/config/Env;

.field public static final enum RC:Lcom/poshmark/config/Env;

.field public static final enum STAGE:Lcom/poshmark/config/Env;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 9
    new-instance v0, Lcom/poshmark/config/Env;

    const-string v1, "DEV"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/config/Env;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/config/Env;->DEV:Lcom/poshmark/config/Env;

    .line 10
    new-instance v0, Lcom/poshmark/config/Env;

    const-string v1, "DEVTEAM"

    invoke-direct {v0, v1, v3}, Lcom/poshmark/config/Env;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/config/Env;->DEVTEAM:Lcom/poshmark/config/Env;

    .line 11
    new-instance v0, Lcom/poshmark/config/Env;

    const-string v1, "STAGE"

    invoke-direct {v0, v1, v4}, Lcom/poshmark/config/Env;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/config/Env;->STAGE:Lcom/poshmark/config/Env;

    .line 12
    new-instance v0, Lcom/poshmark/config/Env;

    const-string v1, "PRODUCTION"

    invoke-direct {v0, v1, v5}, Lcom/poshmark/config/Env;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/config/Env;->PRODUCTION:Lcom/poshmark/config/Env;

    .line 13
    new-instance v0, Lcom/poshmark/config/Env;

    const-string v1, "RC"

    invoke-direct {v0, v1, v6}, Lcom/poshmark/config/Env;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/config/Env;->RC:Lcom/poshmark/config/Env;

    .line 7
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/poshmark/config/Env;

    sget-object v1, Lcom/poshmark/config/Env;->DEV:Lcom/poshmark/config/Env;

    aput-object v1, v0, v2

    sget-object v1, Lcom/poshmark/config/Env;->DEVTEAM:Lcom/poshmark/config/Env;

    aput-object v1, v0, v3

    sget-object v1, Lcom/poshmark/config/Env;->STAGE:Lcom/poshmark/config/Env;

    aput-object v1, v0, v4

    sget-object v1, Lcom/poshmark/config/Env;->PRODUCTION:Lcom/poshmark/config/Env;

    aput-object v1, v0, v5

    sget-object v1, Lcom/poshmark/config/Env;->RC:Lcom/poshmark/config/Env;

    aput-object v1, v0, v6

    sput-object v0, Lcom/poshmark/config/Env;->$VALUES:[Lcom/poshmark/config/Env;

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
    .line 7
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/poshmark/config/Env;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 7
    const-class v0, Lcom/poshmark/config/Env;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/poshmark/config/Env;

    return-object v0
.end method

.method public static values()[Lcom/poshmark/config/Env;
    .locals 1

    .prologue
    .line 7
    sget-object v0, Lcom/poshmark/config/Env;->$VALUES:[Lcom/poshmark/config/Env;

    invoke-virtual {v0}, [Lcom/poshmark/config/Env;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/poshmark/config/Env;

    return-object v0
.end method

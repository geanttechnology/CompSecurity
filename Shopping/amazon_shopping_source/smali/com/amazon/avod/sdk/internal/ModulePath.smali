.class final enum Lcom/amazon/avod/sdk/internal/ModulePath;
.super Ljava/lang/Enum;
.source "ModulePath.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/avod/sdk/internal/ModulePath;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/avod/sdk/internal/ModulePath;

.field public static final enum BASIC:Lcom/amazon/avod/sdk/internal/ModulePath;

.field public static final enum ITEM:Lcom/amazon/avod/sdk/internal/ModulePath;

.field public static final enum SEARCH:Lcom/amazon/avod/sdk/internal/ModulePath;


# instance fields
.field private mPath:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 10
    new-instance v0, Lcom/amazon/avod/sdk/internal/ModulePath;

    const-string/jumbo v1, "ITEM"

    const-string/jumbo v2, "item"

    invoke-direct {v0, v1, v3, v2}, Lcom/amazon/avod/sdk/internal/ModulePath;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/sdk/internal/ModulePath;->ITEM:Lcom/amazon/avod/sdk/internal/ModulePath;

    .line 11
    new-instance v0, Lcom/amazon/avod/sdk/internal/ModulePath;

    const-string/jumbo v1, "SEARCH"

    const-string/jumbo v2, "search"

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/avod/sdk/internal/ModulePath;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/sdk/internal/ModulePath;->SEARCH:Lcom/amazon/avod/sdk/internal/ModulePath;

    .line 12
    new-instance v0, Lcom/amazon/avod/sdk/internal/ModulePath;

    const-string/jumbo v1, "BASIC"

    const-string/jumbo v2, "basic"

    invoke-direct {v0, v1, v5, v2}, Lcom/amazon/avod/sdk/internal/ModulePath;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/avod/sdk/internal/ModulePath;->BASIC:Lcom/amazon/avod/sdk/internal/ModulePath;

    .line 9
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/amazon/avod/sdk/internal/ModulePath;

    sget-object v1, Lcom/amazon/avod/sdk/internal/ModulePath;->ITEM:Lcom/amazon/avod/sdk/internal/ModulePath;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/avod/sdk/internal/ModulePath;->SEARCH:Lcom/amazon/avod/sdk/internal/ModulePath;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/avod/sdk/internal/ModulePath;->BASIC:Lcom/amazon/avod/sdk/internal/ModulePath;

    aput-object v1, v0, v5

    sput-object v0, Lcom/amazon/avod/sdk/internal/ModulePath;->$VALUES:[Lcom/amazon/avod/sdk/internal/ModulePath;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p3, "path"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 16
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 17
    iput-object p3, p0, Lcom/amazon/avod/sdk/internal/ModulePath;->mPath:Ljava/lang/String;

    .line 18
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/avod/sdk/internal/ModulePath;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 9
    const-class v0, Lcom/amazon/avod/sdk/internal/ModulePath;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/avod/sdk/internal/ModulePath;

    return-object v0
.end method

.method public static values()[Lcom/amazon/avod/sdk/internal/ModulePath;
    .locals 1

    .prologue
    .line 9
    sget-object v0, Lcom/amazon/avod/sdk/internal/ModulePath;->$VALUES:[Lcom/amazon/avod/sdk/internal/ModulePath;

    invoke-virtual {v0}, [Lcom/amazon/avod/sdk/internal/ModulePath;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/avod/sdk/internal/ModulePath;

    return-object v0
.end method


# virtual methods
.method public get()Ljava/lang/String;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/amazon/avod/sdk/internal/ModulePath;->mPath:Ljava/lang/String;

    return-object v0
.end method

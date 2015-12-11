.class public final enum Lcom/xfinity/playerlib/IVStatus;
.super Ljava/lang/Enum;
.source "IVStatus.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/xfinity/playerlib/IVStatus;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/xfinity/playerlib/IVStatus;

.field public static final enum IV_FAILED:Lcom/xfinity/playerlib/IVStatus;

.field public static final enum IV_SUCCESS:Lcom/xfinity/playerlib/IVStatus;

.field public static final enum PENDING:Lcom/xfinity/playerlib/IVStatus;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 4
    new-instance v0, Lcom/xfinity/playerlib/IVStatus;

    const-string v1, "PENDING"

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/IVStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/IVStatus;->PENDING:Lcom/xfinity/playerlib/IVStatus;

    .line 5
    new-instance v0, Lcom/xfinity/playerlib/IVStatus;

    const-string v1, "IV_FAILED"

    invoke-direct {v0, v1, v3}, Lcom/xfinity/playerlib/IVStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/IVStatus;->IV_FAILED:Lcom/xfinity/playerlib/IVStatus;

    .line 6
    new-instance v0, Lcom/xfinity/playerlib/IVStatus;

    const-string v1, "IV_SUCCESS"

    invoke-direct {v0, v1, v4}, Lcom/xfinity/playerlib/IVStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/IVStatus;->IV_SUCCESS:Lcom/xfinity/playerlib/IVStatus;

    .line 3
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/xfinity/playerlib/IVStatus;

    sget-object v1, Lcom/xfinity/playerlib/IVStatus;->PENDING:Lcom/xfinity/playerlib/IVStatus;

    aput-object v1, v0, v2

    sget-object v1, Lcom/xfinity/playerlib/IVStatus;->IV_FAILED:Lcom/xfinity/playerlib/IVStatus;

    aput-object v1, v0, v3

    sget-object v1, Lcom/xfinity/playerlib/IVStatus;->IV_SUCCESS:Lcom/xfinity/playerlib/IVStatus;

    aput-object v1, v0, v4

    sput-object v0, Lcom/xfinity/playerlib/IVStatus;->$VALUES:[Lcom/xfinity/playerlib/IVStatus;

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
    .line 3
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/xfinity/playerlib/IVStatus;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 3
    const-class v0, Lcom/xfinity/playerlib/IVStatus;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/IVStatus;

    return-object v0
.end method

.method public static values()[Lcom/xfinity/playerlib/IVStatus;
    .locals 1

    .prologue
    .line 3
    sget-object v0, Lcom/xfinity/playerlib/IVStatus;->$VALUES:[Lcom/xfinity/playerlib/IVStatus;

    invoke-virtual {v0}, [Lcom/xfinity/playerlib/IVStatus;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/xfinity/playerlib/IVStatus;

    return-object v0
.end method

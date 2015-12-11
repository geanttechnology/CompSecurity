.class public final enum Lcom/amazon/identity/auth/device/utils/KeyType;
.super Ljava/lang/Enum;
.source "KeyType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/identity/auth/device/utils/KeyType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/identity/auth/device/utils/KeyType;

.field public static final enum Debug:Lcom/amazon/identity/auth/device/utils/KeyType;

.field public static final enum Release:Lcom/amazon/identity/auth/device/utils/KeyType;

.field public static final enum ReleaseDebug:Lcom/amazon/identity/auth/device/utils/KeyType;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 7
    new-instance v0, Lcom/amazon/identity/auth/device/utils/KeyType;

    const-string/jumbo v1, "Debug"

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/auth/device/utils/KeyType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/utils/KeyType;->Debug:Lcom/amazon/identity/auth/device/utils/KeyType;

    .line 8
    new-instance v0, Lcom/amazon/identity/auth/device/utils/KeyType;

    const-string/jumbo v1, "ReleaseDebug"

    invoke-direct {v0, v1, v3}, Lcom/amazon/identity/auth/device/utils/KeyType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/utils/KeyType;->ReleaseDebug:Lcom/amazon/identity/auth/device/utils/KeyType;

    .line 9
    new-instance v0, Lcom/amazon/identity/auth/device/utils/KeyType;

    const-string/jumbo v1, "Release"

    invoke-direct {v0, v1, v4}, Lcom/amazon/identity/auth/device/utils/KeyType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/utils/KeyType;->Release:Lcom/amazon/identity/auth/device/utils/KeyType;

    .line 5
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/amazon/identity/auth/device/utils/KeyType;

    sget-object v1, Lcom/amazon/identity/auth/device/utils/KeyType;->Debug:Lcom/amazon/identity/auth/device/utils/KeyType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/identity/auth/device/utils/KeyType;->ReleaseDebug:Lcom/amazon/identity/auth/device/utils/KeyType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/identity/auth/device/utils/KeyType;->Release:Lcom/amazon/identity/auth/device/utils/KeyType;

    aput-object v1, v0, v4

    sput-object v0, Lcom/amazon/identity/auth/device/utils/KeyType;->$VALUES:[Lcom/amazon/identity/auth/device/utils/KeyType;

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
    .line 5
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/identity/auth/device/utils/KeyType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 5
    const-class v0, Lcom/amazon/identity/auth/device/utils/KeyType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/utils/KeyType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/identity/auth/device/utils/KeyType;
    .locals 1

    .prologue
    .line 5
    sget-object v0, Lcom/amazon/identity/auth/device/utils/KeyType;->$VALUES:[Lcom/amazon/identity/auth/device/utils/KeyType;

    invoke-virtual {v0}, [Lcom/amazon/identity/auth/device/utils/KeyType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/identity/auth/device/utils/KeyType;

    return-object v0
.end method

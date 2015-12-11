.class public final enum Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;
.super Ljava/lang/Enum;
.source "SecurityTokenType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

.field public static final enum ACCT:Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

.field public static final enum META:Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

.field public static final enum XACT:Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

.field public static final enum XSCT:Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 11
    new-instance v0, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    const-string v1, "ACCT"

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;->ACCT:Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    new-instance v0, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    const-string v1, "XSCT"

    invoke-direct {v0, v1, v3}, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;->XSCT:Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    new-instance v0, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    const-string v1, "XACT"

    invoke-direct {v0, v1, v4}, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;->XACT:Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    new-instance v0, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    const-string v1, "META"

    invoke-direct {v0, v1, v5}, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;->META:Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    .line 10
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    sget-object v1, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;->ACCT:Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;->XSCT:Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;->XACT:Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;->META:Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    aput-object v1, v0, v5

    sput-object v0, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;->$VALUES:[Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

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
    .line 10
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 10
    const-class v0, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    return-object v0
.end method

.method public static values()[Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;
    .locals 1

    .prologue
    .line 10
    sget-object v0, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;->$VALUES:[Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    invoke-virtual {v0}, [Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    return-object v0
.end method

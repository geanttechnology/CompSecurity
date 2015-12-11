.class public final enum Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;
.super Ljava/lang/Enum;
.source "FlowStateEngineInterface.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/flow/android/engine/library/FlowStateEngineInterface;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "CallbackServerFailure"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;

.field public static final enum NO_NETWORK:Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;

.field public static final enum SERVER_ERROR:Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;

.field public static final enum UNAUTHORIZED_ACCESS:Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;

.field public static final enum UNKNOWN:Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 27
    new-instance v0, Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;

    const-string/jumbo v1, "NO_NETWORK"

    invoke-direct {v0, v1, v2}, Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;->NO_NETWORK:Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;

    .line 28
    new-instance v0, Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;

    const-string/jumbo v1, "UNAUTHORIZED_ACCESS"

    invoke-direct {v0, v1, v3}, Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;->UNAUTHORIZED_ACCESS:Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;

    .line 29
    new-instance v0, Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;

    const-string/jumbo v1, "SERVER_ERROR"

    invoke-direct {v0, v1, v4}, Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;->SERVER_ERROR:Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;

    .line 30
    new-instance v0, Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;

    const-string/jumbo v1, "UNKNOWN"

    invoke-direct {v0, v1, v5}, Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;->UNKNOWN:Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;

    .line 26
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;

    sget-object v1, Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;->NO_NETWORK:Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;

    aput-object v1, v0, v2

    sget-object v1, Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;->UNAUTHORIZED_ACCESS:Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;

    aput-object v1, v0, v3

    sget-object v1, Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;->SERVER_ERROR:Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;

    aput-object v1, v0, v4

    sget-object v1, Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;->UNKNOWN:Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;

    aput-object v1, v0, v5

    sput-object v0, Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;->$VALUES:[Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;

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
    .line 26
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 26
    const-class v0, Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;

    return-object v0
.end method

.method public static values()[Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;
    .locals 1

    .prologue
    .line 26
    sget-object v0, Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;->$VALUES:[Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;

    invoke-virtual {v0}, [Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;

    return-object v0
.end method

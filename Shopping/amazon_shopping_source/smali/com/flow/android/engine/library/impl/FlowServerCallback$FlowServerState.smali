.class final enum Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;
.super Ljava/lang/Enum;
.source "FlowServerCallback.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/flow/android/engine/library/impl/FlowServerCallback;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "FlowServerState"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;

.field public static final enum FLOW_ENGINE_SHUTDOWN:Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;

.field public static final enum FLOW_SERVER_IDLE:Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;

.field public static final enum FLOW_SERVER_RESPONSE_RECEIVED:Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;

.field public static final enum FLOW_SERVER_WAITING_RESPONSE:Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 23
    new-instance v0, Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;

    const-string/jumbo v1, "FLOW_SERVER_IDLE"

    invoke-direct {v0, v1, v2}, Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;->FLOW_SERVER_IDLE:Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;

    .line 24
    new-instance v0, Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;

    const-string/jumbo v1, "FLOW_SERVER_WAITING_RESPONSE"

    invoke-direct {v0, v1, v3}, Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;->FLOW_SERVER_WAITING_RESPONSE:Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;

    .line 25
    new-instance v0, Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;

    const-string/jumbo v1, "FLOW_SERVER_RESPONSE_RECEIVED"

    invoke-direct {v0, v1, v4}, Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;->FLOW_SERVER_RESPONSE_RECEIVED:Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;

    .line 26
    new-instance v0, Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;

    const-string/jumbo v1, "FLOW_ENGINE_SHUTDOWN"

    invoke-direct {v0, v1, v5}, Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;->FLOW_ENGINE_SHUTDOWN:Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;

    .line 22
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;

    sget-object v1, Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;->FLOW_SERVER_IDLE:Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;

    aput-object v1, v0, v2

    sget-object v1, Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;->FLOW_SERVER_WAITING_RESPONSE:Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;

    aput-object v1, v0, v3

    sget-object v1, Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;->FLOW_SERVER_RESPONSE_RECEIVED:Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;

    aput-object v1, v0, v4

    sget-object v1, Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;->FLOW_ENGINE_SHUTDOWN:Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;

    aput-object v1, v0, v5

    sput-object v0, Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;->$VALUES:[Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;

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
    .line 22
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 22
    const-class v0, Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;

    return-object v0
.end method

.method public static values()[Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;
    .locals 1

    .prologue
    .line 22
    sget-object v0, Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;->$VALUES:[Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;

    invoke-virtual {v0}, [Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;

    return-object v0
.end method

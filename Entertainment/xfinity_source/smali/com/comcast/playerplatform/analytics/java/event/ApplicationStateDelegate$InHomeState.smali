.class public final enum Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;
.super Ljava/lang/Enum;
.source "ApplicationStateDelegate.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "InHomeState"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;

.field public static final enum IN_HOME:Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;

.field public static final enum OUT_OF_HOME:Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;

.field public static final enum UNKNOWN:Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 18
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;

    const-string v1, "OUT_OF_HOME"

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;->OUT_OF_HOME:Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;

    .line 19
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;

    const-string v1, "IN_HOME"

    invoke-direct {v0, v1, v3}, Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;->IN_HOME:Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;

    .line 20
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;

    const-string v1, "UNKNOWN"

    invoke-direct {v0, v1, v4}, Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;->UNKNOWN:Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;

    .line 17
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;

    sget-object v1, Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;->OUT_OF_HOME:Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;

    aput-object v1, v0, v2

    sget-object v1, Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;->IN_HOME:Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;

    aput-object v1, v0, v3

    sget-object v1, Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;->UNKNOWN:Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;

    aput-object v1, v0, v4

    sput-object v0, Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;->$VALUES:[Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;

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
    .line 17
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 17
    const-class v0, Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;

    return-object v0
.end method

.method public static values()[Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;
    .locals 1

    .prologue
    .line 17
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;->$VALUES:[Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;

    invoke-virtual {v0}, [Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;

    return-object v0
.end method

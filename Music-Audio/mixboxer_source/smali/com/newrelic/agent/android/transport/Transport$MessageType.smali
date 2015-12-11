.class public final enum Lcom/newrelic/agent/android/transport/Transport$MessageType;
.super Ljava/lang/Enum;
.source "Transport.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/newrelic/agent/android/transport/Transport;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "MessageType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/newrelic/agent/android/transport/Transport$MessageType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/newrelic/agent/android/transport/Transport$MessageType;

.field public static final enum CONNECT:Lcom/newrelic/agent/android/transport/Transport$MessageType;

.field public static final enum DATA:Lcom/newrelic/agent/android/transport/Transport$MessageType;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 7
    new-instance v0, Lcom/newrelic/agent/android/transport/Transport$MessageType;

    const-string v1, "CONNECT"

    invoke-direct {v0, v1, v2}, Lcom/newrelic/agent/android/transport/Transport$MessageType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/newrelic/agent/android/transport/Transport$MessageType;->CONNECT:Lcom/newrelic/agent/android/transport/Transport$MessageType;

    .line 8
    new-instance v0, Lcom/newrelic/agent/android/transport/Transport$MessageType;

    const-string v1, "DATA"

    invoke-direct {v0, v1, v3}, Lcom/newrelic/agent/android/transport/Transport$MessageType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/newrelic/agent/android/transport/Transport$MessageType;->DATA:Lcom/newrelic/agent/android/transport/Transport$MessageType;

    .line 6
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/newrelic/agent/android/transport/Transport$MessageType;

    sget-object v1, Lcom/newrelic/agent/android/transport/Transport$MessageType;->CONNECT:Lcom/newrelic/agent/android/transport/Transport$MessageType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/newrelic/agent/android/transport/Transport$MessageType;->DATA:Lcom/newrelic/agent/android/transport/Transport$MessageType;

    aput-object v1, v0, v3

    sput-object v0, Lcom/newrelic/agent/android/transport/Transport$MessageType;->$VALUES:[Lcom/newrelic/agent/android/transport/Transport$MessageType;

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
    .line 6
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/newrelic/agent/android/transport/Transport$MessageType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 6
    const-class v0, Lcom/newrelic/agent/android/transport/Transport$MessageType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/newrelic/agent/android/transport/Transport$MessageType;

    return-object v0
.end method

.method public static values()[Lcom/newrelic/agent/android/transport/Transport$MessageType;
    .locals 1

    .prologue
    .line 6
    sget-object v0, Lcom/newrelic/agent/android/transport/Transport$MessageType;->$VALUES:[Lcom/newrelic/agent/android/transport/Transport$MessageType;

    invoke-virtual {v0}, [Lcom/newrelic/agent/android/transport/Transport$MessageType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/newrelic/agent/android/transport/Transport$MessageType;

    return-object v0
.end method

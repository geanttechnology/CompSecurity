.class public final enum Lcom/espn/androidplayersdk/utilities/EPEventType;
.super Ljava/lang/Enum;
.source "EPEventType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/espn/androidplayersdk/utilities/EPEventType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic ENUM$VALUES:[Lcom/espn/androidplayersdk/utilities/EPEventType;

.field public static final enum LIVE:Lcom/espn/androidplayersdk/utilities/EPEventType;

.field public static final enum REPLAY:Lcom/espn/androidplayersdk/utilities/EPEventType;

.field public static final enum STREAM:Lcom/espn/androidplayersdk/utilities/EPEventType;

.field public static final enum UPCOMING:Lcom/espn/androidplayersdk/utilities/EPEventType;


# instance fields
.field private event:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 5
    new-instance v0, Lcom/espn/androidplayersdk/utilities/EPEventType;

    const-string v1, "LIVE"

    const-string v2, "live"

    invoke-direct {v0, v1, v3, v2}, Lcom/espn/androidplayersdk/utilities/EPEventType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/espn/androidplayersdk/utilities/EPEventType;->LIVE:Lcom/espn/androidplayersdk/utilities/EPEventType;

    .line 6
    new-instance v0, Lcom/espn/androidplayersdk/utilities/EPEventType;

    const-string v1, "REPLAY"

    const-string v2, "replay"

    invoke-direct {v0, v1, v4, v2}, Lcom/espn/androidplayersdk/utilities/EPEventType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/espn/androidplayersdk/utilities/EPEventType;->REPLAY:Lcom/espn/androidplayersdk/utilities/EPEventType;

    .line 7
    new-instance v0, Lcom/espn/androidplayersdk/utilities/EPEventType;

    const-string v1, "UPCOMING"

    const-string v2, "upcoming"

    invoke-direct {v0, v1, v5, v2}, Lcom/espn/androidplayersdk/utilities/EPEventType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/espn/androidplayersdk/utilities/EPEventType;->UPCOMING:Lcom/espn/androidplayersdk/utilities/EPEventType;

    .line 8
    new-instance v0, Lcom/espn/androidplayersdk/utilities/EPEventType;

    const-string v1, "STREAM"

    const-string v2, "stream"

    invoke-direct {v0, v1, v6, v2}, Lcom/espn/androidplayersdk/utilities/EPEventType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/espn/androidplayersdk/utilities/EPEventType;->STREAM:Lcom/espn/androidplayersdk/utilities/EPEventType;

    .line 3
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/espn/androidplayersdk/utilities/EPEventType;

    sget-object v1, Lcom/espn/androidplayersdk/utilities/EPEventType;->LIVE:Lcom/espn/androidplayersdk/utilities/EPEventType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/espn/androidplayersdk/utilities/EPEventType;->REPLAY:Lcom/espn/androidplayersdk/utilities/EPEventType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/espn/androidplayersdk/utilities/EPEventType;->UPCOMING:Lcom/espn/androidplayersdk/utilities/EPEventType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/espn/androidplayersdk/utilities/EPEventType;->STREAM:Lcom/espn/androidplayersdk/utilities/EPEventType;

    aput-object v1, v0, v6

    sput-object v0, Lcom/espn/androidplayersdk/utilities/EPEventType;->ENUM$VALUES:[Lcom/espn/androidplayersdk/utilities/EPEventType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p3, "eventStr"    # Ljava/lang/String;

    .prologue
    .line 12
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 14
    iput-object p3, p0, Lcom/espn/androidplayersdk/utilities/EPEventType;->event:Ljava/lang/String;

    .line 15
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/espn/androidplayersdk/utilities/EPEventType;
    .locals 1

    .prologue
    .line 1
    const-class v0, Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/espn/androidplayersdk/utilities/EPEventType;

    return-object v0
.end method

.method public static values()[Lcom/espn/androidplayersdk/utilities/EPEventType;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 1
    sget-object v0, Lcom/espn/androidplayersdk/utilities/EPEventType;->ENUM$VALUES:[Lcom/espn/androidplayersdk/utilities/EPEventType;

    array-length v1, v0

    new-array v2, v1, [Lcom/espn/androidplayersdk/utilities/EPEventType;

    invoke-static {v0, v3, v2, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-object v2
.end method


# virtual methods
.method public getEventStr()Ljava/lang/String;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lcom/espn/androidplayersdk/utilities/EPEventType;->event:Ljava/lang/String;

    return-object v0
.end method

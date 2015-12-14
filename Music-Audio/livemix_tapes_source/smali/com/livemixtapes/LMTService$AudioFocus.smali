.class final enum Lcom/livemixtapes/LMTService$AudioFocus;
.super Ljava/lang/Enum;
.source "LMTService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/LMTService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4018
    name = "AudioFocus"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/livemixtapes/LMTService$AudioFocus;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic ENUM$VALUES:[Lcom/livemixtapes/LMTService$AudioFocus;

.field public static final enum Focused:Lcom/livemixtapes/LMTService$AudioFocus;

.field public static final enum NoFocusCanDuck:Lcom/livemixtapes/LMTService$AudioFocus;

.field public static final enum NoFocusNoDuck:Lcom/livemixtapes/LMTService$AudioFocus;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 99
    new-instance v0, Lcom/livemixtapes/LMTService$AudioFocus;

    const-string v1, "NoFocusNoDuck"

    invoke-direct {v0, v1, v2}, Lcom/livemixtapes/LMTService$AudioFocus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/livemixtapes/LMTService$AudioFocus;->NoFocusNoDuck:Lcom/livemixtapes/LMTService$AudioFocus;

    .line 100
    new-instance v0, Lcom/livemixtapes/LMTService$AudioFocus;

    const-string v1, "NoFocusCanDuck"

    invoke-direct {v0, v1, v3}, Lcom/livemixtapes/LMTService$AudioFocus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/livemixtapes/LMTService$AudioFocus;->NoFocusCanDuck:Lcom/livemixtapes/LMTService$AudioFocus;

    .line 101
    new-instance v0, Lcom/livemixtapes/LMTService$AudioFocus;

    const-string v1, "Focused"

    invoke-direct {v0, v1, v4}, Lcom/livemixtapes/LMTService$AudioFocus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/livemixtapes/LMTService$AudioFocus;->Focused:Lcom/livemixtapes/LMTService$AudioFocus;

    .line 98
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/livemixtapes/LMTService$AudioFocus;

    sget-object v1, Lcom/livemixtapes/LMTService$AudioFocus;->NoFocusNoDuck:Lcom/livemixtapes/LMTService$AudioFocus;

    aput-object v1, v0, v2

    sget-object v1, Lcom/livemixtapes/LMTService$AudioFocus;->NoFocusCanDuck:Lcom/livemixtapes/LMTService$AudioFocus;

    aput-object v1, v0, v3

    sget-object v1, Lcom/livemixtapes/LMTService$AudioFocus;->Focused:Lcom/livemixtapes/LMTService$AudioFocus;

    aput-object v1, v0, v4

    sput-object v0, Lcom/livemixtapes/LMTService$AudioFocus;->ENUM$VALUES:[Lcom/livemixtapes/LMTService$AudioFocus;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0

    .prologue
    .line 98
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/livemixtapes/LMTService$AudioFocus;
    .locals 1

    .prologue
    .line 1
    const-class v0, Lcom/livemixtapes/LMTService$AudioFocus;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/livemixtapes/LMTService$AudioFocus;

    return-object v0
.end method

.method public static values()[Lcom/livemixtapes/LMTService$AudioFocus;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 1
    sget-object v0, Lcom/livemixtapes/LMTService$AudioFocus;->ENUM$VALUES:[Lcom/livemixtapes/LMTService$AudioFocus;

    array-length v1, v0

    new-array v2, v1, [Lcom/livemixtapes/LMTService$AudioFocus;

    invoke-static {v0, v3, v2, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-object v2
.end method

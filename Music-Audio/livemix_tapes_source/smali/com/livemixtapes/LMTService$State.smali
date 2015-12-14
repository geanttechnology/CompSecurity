.class final enum Lcom/livemixtapes/LMTService$State;
.super Ljava/lang/Enum;
.source "LMTService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/LMTService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4018
    name = "State"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/livemixtapes/LMTService$State;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic ENUM$VALUES:[Lcom/livemixtapes/LMTService$State;

.field public static final enum Paused:Lcom/livemixtapes/LMTService$State;

.field public static final enum Playing:Lcom/livemixtapes/LMTService$State;

.field public static final enum Preparing:Lcom/livemixtapes/LMTService$State;

.field public static final enum Retrieving:Lcom/livemixtapes/LMTService$State;

.field public static final enum Stopped:Lcom/livemixtapes/LMTService$State;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 76
    new-instance v0, Lcom/livemixtapes/LMTService$State;

    const-string v1, "Retrieving"

    invoke-direct {v0, v1, v2}, Lcom/livemixtapes/LMTService$State;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/livemixtapes/LMTService$State;->Retrieving:Lcom/livemixtapes/LMTService$State;

    .line 77
    new-instance v0, Lcom/livemixtapes/LMTService$State;

    const-string v1, "Stopped"

    invoke-direct {v0, v1, v3}, Lcom/livemixtapes/LMTService$State;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/livemixtapes/LMTService$State;->Stopped:Lcom/livemixtapes/LMTService$State;

    .line 78
    new-instance v0, Lcom/livemixtapes/LMTService$State;

    const-string v1, "Preparing"

    invoke-direct {v0, v1, v4}, Lcom/livemixtapes/LMTService$State;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/livemixtapes/LMTService$State;->Preparing:Lcom/livemixtapes/LMTService$State;

    .line 79
    new-instance v0, Lcom/livemixtapes/LMTService$State;

    const-string v1, "Playing"

    invoke-direct {v0, v1, v5}, Lcom/livemixtapes/LMTService$State;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/livemixtapes/LMTService$State;->Playing:Lcom/livemixtapes/LMTService$State;

    .line 82
    new-instance v0, Lcom/livemixtapes/LMTService$State;

    const-string v1, "Paused"

    invoke-direct {v0, v1, v6}, Lcom/livemixtapes/LMTService$State;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/livemixtapes/LMTService$State;->Paused:Lcom/livemixtapes/LMTService$State;

    .line 75
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/livemixtapes/LMTService$State;

    sget-object v1, Lcom/livemixtapes/LMTService$State;->Retrieving:Lcom/livemixtapes/LMTService$State;

    aput-object v1, v0, v2

    sget-object v1, Lcom/livemixtapes/LMTService$State;->Stopped:Lcom/livemixtapes/LMTService$State;

    aput-object v1, v0, v3

    sget-object v1, Lcom/livemixtapes/LMTService$State;->Preparing:Lcom/livemixtapes/LMTService$State;

    aput-object v1, v0, v4

    sget-object v1, Lcom/livemixtapes/LMTService$State;->Playing:Lcom/livemixtapes/LMTService$State;

    aput-object v1, v0, v5

    sget-object v1, Lcom/livemixtapes/LMTService$State;->Paused:Lcom/livemixtapes/LMTService$State;

    aput-object v1, v0, v6

    sput-object v0, Lcom/livemixtapes/LMTService$State;->ENUM$VALUES:[Lcom/livemixtapes/LMTService$State;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0

    .prologue
    .line 75
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/livemixtapes/LMTService$State;
    .locals 1

    .prologue
    .line 1
    const-class v0, Lcom/livemixtapes/LMTService$State;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/livemixtapes/LMTService$State;

    return-object v0
.end method

.method public static values()[Lcom/livemixtapes/LMTService$State;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 1
    sget-object v0, Lcom/livemixtapes/LMTService$State;->ENUM$VALUES:[Lcom/livemixtapes/LMTService$State;

    array-length v1, v0

    new-array v2, v1, [Lcom/livemixtapes/LMTService$State;

    invoke-static {v0, v3, v2, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-object v2
.end method

.class final enum Lcom/livemixtapes/LMTService$PauseReason;
.super Ljava/lang/Enum;
.source "LMTService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/LMTService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4018
    name = "PauseReason"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/livemixtapes/LMTService$PauseReason;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic ENUM$VALUES:[Lcom/livemixtapes/LMTService$PauseReason;

.field public static final enum FocusLoss:Lcom/livemixtapes/LMTService$PauseReason;

.field public static final enum UserRequest:Lcom/livemixtapes/LMTService$PauseReason;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 92
    new-instance v0, Lcom/livemixtapes/LMTService$PauseReason;

    const-string v1, "UserRequest"

    invoke-direct {v0, v1, v2}, Lcom/livemixtapes/LMTService$PauseReason;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/livemixtapes/LMTService$PauseReason;->UserRequest:Lcom/livemixtapes/LMTService$PauseReason;

    .line 93
    new-instance v0, Lcom/livemixtapes/LMTService$PauseReason;

    const-string v1, "FocusLoss"

    invoke-direct {v0, v1, v3}, Lcom/livemixtapes/LMTService$PauseReason;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/livemixtapes/LMTService$PauseReason;->FocusLoss:Lcom/livemixtapes/LMTService$PauseReason;

    .line 91
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/livemixtapes/LMTService$PauseReason;

    sget-object v1, Lcom/livemixtapes/LMTService$PauseReason;->UserRequest:Lcom/livemixtapes/LMTService$PauseReason;

    aput-object v1, v0, v2

    sget-object v1, Lcom/livemixtapes/LMTService$PauseReason;->FocusLoss:Lcom/livemixtapes/LMTService$PauseReason;

    aput-object v1, v0, v3

    sput-object v0, Lcom/livemixtapes/LMTService$PauseReason;->ENUM$VALUES:[Lcom/livemixtapes/LMTService$PauseReason;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0

    .prologue
    .line 91
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/livemixtapes/LMTService$PauseReason;
    .locals 1

    .prologue
    .line 1
    const-class v0, Lcom/livemixtapes/LMTService$PauseReason;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/livemixtapes/LMTService$PauseReason;

    return-object v0
.end method

.method public static values()[Lcom/livemixtapes/LMTService$PauseReason;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 1
    sget-object v0, Lcom/livemixtapes/LMTService$PauseReason;->ENUM$VALUES:[Lcom/livemixtapes/LMTService$PauseReason;

    array-length v1, v0

    new-array v2, v1, [Lcom/livemixtapes/LMTService$PauseReason;

    invoke-static {v0, v3, v2, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-object v2
.end method

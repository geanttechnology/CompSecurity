.class public final enum Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;
.super Ljava/lang/Enum;
.source "Common.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/Common;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "EVirtuosoDownloadEngineStatus"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic ENUM$VALUES:[Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

.field public static final enum kVDE_AuthenticationFailure:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

.field public static final enum kVDE_Blocked:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

.field public static final enum kVDE_Disabled:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

.field public static final enum kVDE_Downloading:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

.field public static final enum kVDE_Errors:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

.field public static final enum kVDE_Idle:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

.field public static final enum kVDE_Paused:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 66
    new-instance v0, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    const-string v1, "kVDE_Downloading"

    invoke-direct {v0, v1, v3}, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;-><init>(Ljava/lang/String;I)V

    .line 69
    sput-object v0, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Downloading:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    .line 73
    new-instance v0, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    const-string v1, "kVDE_Idle"

    invoke-direct {v0, v1, v4}, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Idle:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    .line 77
    new-instance v0, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    const-string v1, "kVDE_Paused"

    invoke-direct {v0, v1, v5}, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Paused:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    .line 81
    new-instance v0, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    const-string v1, "kVDE_Disabled"

    invoke-direct {v0, v1, v6}, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Disabled:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    .line 85
    new-instance v0, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    const-string v1, "kVDE_Blocked"

    invoke-direct {v0, v1, v7}, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Blocked:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    .line 89
    new-instance v0, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    const-string v1, "kVDE_Errors"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Errors:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    .line 94
    new-instance v0, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    const-string v1, "kVDE_AuthenticationFailure"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_AuthenticationFailure:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    .line 65
    const/4 v0, 0x7

    new-array v0, v0, [Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    sget-object v1, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Downloading:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    aput-object v1, v0, v3

    sget-object v1, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Idle:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    aput-object v1, v0, v4

    sget-object v1, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Paused:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    aput-object v1, v0, v5

    sget-object v1, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Disabled:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    aput-object v1, v0, v6

    sget-object v1, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Blocked:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Errors:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_AuthenticationFailure:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    aput-object v2, v0, v1

    sput-object v0, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->ENUM$VALUES:[Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0

    .prologue
    .line 65
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;
    .locals 1

    .prologue
    .line 1
    const-class v0, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    return-object v0
.end method

.method public static values()[Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 1
    sget-object v0, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->ENUM$VALUES:[Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    array-length v1, v0

    new-array v2, v1, [Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    invoke-static {v0, v3, v2, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-object v2
.end method

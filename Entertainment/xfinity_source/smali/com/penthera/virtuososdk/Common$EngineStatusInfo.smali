.class public final enum Lcom/penthera/virtuososdk/Common$EngineStatusInfo;
.super Ljava/lang/Enum;
.source "Common.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/Common;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "EngineStatusInfo"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/penthera/virtuososdk/Common$EngineStatusInfo;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum EBlockedAuthentication:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

.field public static final enum EBlockedBattery:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

.field public static final enum EBlockedCell:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

.field public static final enum EBlockedErrorHTTP:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

.field public static final enum EBlockedHeadroom:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

.field public static final enum EBlockedPaused:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

.field public static final enum EBlockedStorage:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

.field public static final enum EErrorExpired:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

.field public static final enum EErrorFile:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

.field public static final enum EErrorFileCorrupt:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

.field public static final enum EErrorFileExpectedSize:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

.field public static final enum EErrorFileMimeType:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

.field public static final enum EErrorNetwork:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

.field public static final enum EErrorUnknown:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

.field public static final enum EErrorsMaxed:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

.field public static final enum EFileExpired:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

.field public static final enum EFileRemoved:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

.field private static final synthetic ENUM$VALUES:[Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

.field public static final enum ENoError:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

.field public static final enum EPriorityChange:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 107
    new-instance v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    const-string v1, "ENoError"

    invoke-direct {v0, v1, v3}, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;-><init>(Ljava/lang/String;I)V

    .line 110
    sput-object v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->ENoError:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    .line 111
    new-instance v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    const-string v1, "EBlockedCell"

    invoke-direct {v0, v1, v4}, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;-><init>(Ljava/lang/String;I)V

    .line 114
    sput-object v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EBlockedCell:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    .line 118
    new-instance v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    const-string v1, "EBlockedPaused"

    invoke-direct {v0, v1, v5}, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EBlockedPaused:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    .line 122
    new-instance v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    const-string v1, "EBlockedBattery"

    invoke-direct {v0, v1, v6}, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EBlockedBattery:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    .line 126
    new-instance v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    const-string v1, "EBlockedHeadroom"

    invoke-direct {v0, v1, v7}, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EBlockedHeadroom:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    .line 131
    new-instance v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    const-string v1, "EBlockedStorage"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EBlockedStorage:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    .line 135
    new-instance v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    const-string v1, "EBlockedErrorHTTP"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EBlockedErrorHTTP:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    .line 139
    new-instance v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    const-string v1, "EErrorNetwork"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EErrorNetwork:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    .line 143
    new-instance v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    const-string v1, "EErrorFile"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EErrorFile:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    .line 147
    new-instance v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    const-string v1, "EErrorFileMimeType"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EErrorFileMimeType:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    .line 151
    new-instance v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    const-string v1, "EErrorFileExpectedSize"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EErrorFileExpectedSize:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    .line 155
    new-instance v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    const-string v1, "EErrorFileCorrupt"

    const/16 v2, 0xb

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EErrorFileCorrupt:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    .line 159
    new-instance v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    const-string v1, "EErrorsMaxed"

    const/16 v2, 0xc

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EErrorsMaxed:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    .line 163
    new-instance v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    const-string v1, "EErrorExpired"

    const/16 v2, 0xd

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EErrorExpired:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    .line 167
    new-instance v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    const-string v1, "EErrorUnknown"

    const/16 v2, 0xe

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EErrorUnknown:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    .line 171
    new-instance v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    const-string v1, "EPriorityChange"

    const/16 v2, 0xf

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EPriorityChange:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    .line 175
    new-instance v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    const-string v1, "EFileRemoved"

    const/16 v2, 0x10

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EFileRemoved:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    .line 179
    new-instance v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    const-string v1, "EFileExpired"

    const/16 v2, 0x11

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EFileExpired:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    .line 183
    new-instance v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    const-string v1, "EBlockedAuthentication"

    const/16 v2, 0x12

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EBlockedAuthentication:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    .line 106
    const/16 v0, 0x13

    new-array v0, v0, [Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    sget-object v1, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->ENoError:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    aput-object v1, v0, v3

    sget-object v1, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EBlockedCell:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    aput-object v1, v0, v4

    sget-object v1, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EBlockedPaused:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    aput-object v1, v0, v5

    sget-object v1, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EBlockedBattery:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    aput-object v1, v0, v6

    sget-object v1, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EBlockedHeadroom:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EBlockedStorage:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EBlockedErrorHTTP:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EErrorNetwork:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EErrorFile:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EErrorFileMimeType:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EErrorFileExpectedSize:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EErrorFileCorrupt:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EErrorsMaxed:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EErrorExpired:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EErrorUnknown:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EPriorityChange:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EFileRemoved:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    aput-object v2, v0, v1

    const/16 v1, 0x11

    sget-object v2, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EFileExpired:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    aput-object v2, v0, v1

    const/16 v1, 0x12

    sget-object v2, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EBlockedAuthentication:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    aput-object v2, v0, v1

    sput-object v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->ENUM$VALUES:[Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0

    .prologue
    .line 106
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/penthera/virtuososdk/Common$EngineStatusInfo;
    .locals 1

    .prologue
    .line 1
    const-class v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    return-object v0
.end method

.method public static values()[Lcom/penthera/virtuososdk/Common$EngineStatusInfo;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 1
    sget-object v0, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->ENUM$VALUES:[Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    array-length v1, v0

    new-array v2, v1, [Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    invoke-static {v0, v3, v2, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-object v2
.end method

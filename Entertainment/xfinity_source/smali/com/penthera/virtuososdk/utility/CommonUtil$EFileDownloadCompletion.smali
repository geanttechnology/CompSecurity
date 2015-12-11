.class public final enum Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
.super Ljava/lang/Enum;
.source "CommonUtil.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/utility/CommonUtil;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "EFileDownloadCompletion"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum EDownloadBlockedAuthentication:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

.field public static final enum EDownloadBlockedBattery:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

.field public static final enum EDownloadBlockedCell:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

.field public static final enum EDownloadBlockedErrorExpired:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

.field public static final enum EDownloadBlockedErrorFile:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

.field public static final enum EDownloadBlockedErrorFileCorrupt:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

.field public static final enum EDownloadBlockedErrorFileExpectedSize:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

.field public static final enum EDownloadBlockedErrorFileMimeType:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

.field public static final enum EDownloadBlockedErrorHTTP:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

.field public static final enum EDownloadBlockedErrorNetwork:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

.field public static final enum EDownloadBlockedErrorsMaxed:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

.field public static final enum EDownloadBlockedHeadroom:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

.field public static final enum EDownloadBlockedPaused:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

.field public static final enum EDownloadBlockedStorage:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

.field public static final enum EDownloadBlockedUnknown:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

.field public static final enum EDownloadComplete:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

.field public static final enum EDownloadFileExpired:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

.field public static final enum EDownloadFileRemoved:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

.field public static final enum EDownloadPriorityChange:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

.field public static final enum EInternalErrorRetryOn416:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

.field private static final synthetic ENUM$VALUES:[Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 110
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    const-string v1, "EDownloadComplete"

    invoke-direct {v0, v1, v3}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadComplete:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .line 111
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    const-string v1, "EDownloadBlockedCell"

    invoke-direct {v0, v1, v4}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedCell:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .line 112
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    const-string v1, "EDownloadBlockedPaused"

    invoke-direct {v0, v1, v5}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedPaused:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .line 113
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    const-string v1, "EDownloadBlockedBattery"

    invoke-direct {v0, v1, v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedBattery:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .line 114
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    const-string v1, "EDownloadBlockedHeadroom"

    invoke-direct {v0, v1, v7}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedHeadroom:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .line 115
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    const-string v1, "EDownloadBlockedStorage"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedStorage:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .line 116
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    const-string v1, "EDownloadBlockedErrorHTTP"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorHTTP:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .line 117
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    const-string v1, "EDownloadBlockedErrorNetwork"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorNetwork:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .line 118
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    const-string v1, "EDownloadBlockedErrorFile"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorFile:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .line 119
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    const-string v1, "EDownloadBlockedErrorFileMimeType"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorFileMimeType:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .line 120
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    const-string v1, "EDownloadBlockedErrorFileExpectedSize"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorFileExpectedSize:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .line 121
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    const-string v1, "EDownloadBlockedErrorFileCorrupt"

    const/16 v2, 0xb

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorFileCorrupt:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .line 122
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    const-string v1, "EDownloadBlockedErrorsMaxed"

    const/16 v2, 0xc

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorsMaxed:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .line 123
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    const-string v1, "EDownloadBlockedErrorExpired"

    const/16 v2, 0xd

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorExpired:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .line 124
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    const-string v1, "EDownloadBlockedUnknown"

    const/16 v2, 0xe

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedUnknown:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .line 125
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    const-string v1, "EDownloadPriorityChange"

    const/16 v2, 0xf

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadPriorityChange:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .line 126
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    const-string v1, "EDownloadFileRemoved"

    const/16 v2, 0x10

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadFileRemoved:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .line 127
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    const-string v1, "EDownloadFileExpired"

    const/16 v2, 0x11

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadFileExpired:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .line 128
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    const-string v1, "EDownloadBlockedAuthentication"

    const/16 v2, 0x12

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedAuthentication:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .line 130
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    const-string v1, "EInternalErrorRetryOn416"

    const/16 v2, 0x13

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EInternalErrorRetryOn416:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .line 109
    const/16 v0, 0x14

    new-array v0, v0, [Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadComplete:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    aput-object v1, v0, v3

    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedCell:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    aput-object v1, v0, v4

    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedPaused:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    aput-object v1, v0, v5

    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedBattery:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    aput-object v1, v0, v6

    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedHeadroom:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedStorage:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorHTTP:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorNetwork:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorFile:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorFileMimeType:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorFileExpectedSize:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorFileCorrupt:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorsMaxed:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorExpired:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedUnknown:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadPriorityChange:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadFileRemoved:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    aput-object v2, v0, v1

    const/16 v1, 0x11

    sget-object v2, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadFileExpired:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    aput-object v2, v0, v1

    const/16 v1, 0x12

    sget-object v2, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedAuthentication:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    aput-object v2, v0, v1

    const/16 v1, 0x13

    sget-object v2, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EInternalErrorRetryOn416:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    aput-object v2, v0, v1

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ENUM$VALUES:[Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0

    .prologue
    .line 109
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    .locals 1

    .prologue
    .line 1
    const-class v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    return-object v0
.end method

.method public static values()[Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 1
    sget-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ENUM$VALUES:[Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    array-length v1, v0

    new-array v2, v1, [Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    invoke-static {v0, v3, v2, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-object v2
.end method

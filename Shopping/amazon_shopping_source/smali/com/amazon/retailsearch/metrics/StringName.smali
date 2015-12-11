.class final enum Lcom/amazon/retailsearch/metrics/StringName;
.super Ljava/lang/Enum;
.source "StringName.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/retailsearch/metrics/StringName;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/retailsearch/metrics/StringName;

.field public static final enum AndroidId:Lcom/amazon/retailsearch/metrics/StringName;

.field public static final enum BuildFingerprint:Lcom/amazon/retailsearch/metrics/StringName;

.field public static final enum BuildProduct:Lcom/amazon/retailsearch/metrics/StringName;

.field public static final enum ClientRequestId:Lcom/amazon/retailsearch/metrics/StringName;

.field public static final enum DeviceModel:Lcom/amazon/retailsearch/metrics/StringName;

.field public static final enum ExceptionMessage:Lcom/amazon/retailsearch/metrics/StringName;

.field public static final enum ExceptionName:Lcom/amazon/retailsearch/metrics/StringName;

.field public static final enum Manufacturer:Lcom/amazon/retailsearch/metrics/StringName;

.field public static final enum Message:Lcom/amazon/retailsearch/metrics/StringName;

.field public static final enum NetworkName:Lcom/amazon/retailsearch/metrics/StringName;

.field public static final enum OsVersion:Lcom/amazon/retailsearch/metrics/StringName;

.field public static final enum RequestHeaders:Lcom/amazon/retailsearch/metrics/StringName;

.field public static final enum RequestMethod:Lcom/amazon/retailsearch/metrics/StringName;

.field public static final enum RequestParameters:Lcom/amazon/retailsearch/metrics/StringName;

.field public static final enum RequestUrl:Lcom/amazon/retailsearch/metrics/StringName;

.field public static final enum SerialNumber:Lcom/amazon/retailsearch/metrics/StringName;

.field public static final enum StackTrace:Lcom/amazon/retailsearch/metrics/StringName;

.field public static final enum TelephonyDeviceId:Lcom/amazon/retailsearch/metrics/StringName;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 5
    new-instance v0, Lcom/amazon/retailsearch/metrics/StringName;

    const-string/jumbo v1, "Message"

    invoke-direct {v0, v1, v3}, Lcom/amazon/retailsearch/metrics/StringName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/StringName;->Message:Lcom/amazon/retailsearch/metrics/StringName;

    .line 6
    new-instance v0, Lcom/amazon/retailsearch/metrics/StringName;

    const-string/jumbo v1, "ExceptionName"

    invoke-direct {v0, v1, v4}, Lcom/amazon/retailsearch/metrics/StringName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/StringName;->ExceptionName:Lcom/amazon/retailsearch/metrics/StringName;

    .line 7
    new-instance v0, Lcom/amazon/retailsearch/metrics/StringName;

    const-string/jumbo v1, "ExceptionMessage"

    invoke-direct {v0, v1, v5}, Lcom/amazon/retailsearch/metrics/StringName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/StringName;->ExceptionMessage:Lcom/amazon/retailsearch/metrics/StringName;

    .line 8
    new-instance v0, Lcom/amazon/retailsearch/metrics/StringName;

    const-string/jumbo v1, "StackTrace"

    invoke-direct {v0, v1, v6}, Lcom/amazon/retailsearch/metrics/StringName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/StringName;->StackTrace:Lcom/amazon/retailsearch/metrics/StringName;

    .line 9
    new-instance v0, Lcom/amazon/retailsearch/metrics/StringName;

    const-string/jumbo v1, "OsVersion"

    invoke-direct {v0, v1, v7}, Lcom/amazon/retailsearch/metrics/StringName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/StringName;->OsVersion:Lcom/amazon/retailsearch/metrics/StringName;

    .line 10
    new-instance v0, Lcom/amazon/retailsearch/metrics/StringName;

    const-string/jumbo v1, "DeviceModel"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/StringName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/StringName;->DeviceModel:Lcom/amazon/retailsearch/metrics/StringName;

    .line 11
    new-instance v0, Lcom/amazon/retailsearch/metrics/StringName;

    const-string/jumbo v1, "Manufacturer"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/StringName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/StringName;->Manufacturer:Lcom/amazon/retailsearch/metrics/StringName;

    .line 12
    new-instance v0, Lcom/amazon/retailsearch/metrics/StringName;

    const-string/jumbo v1, "BuildProduct"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/StringName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/StringName;->BuildProduct:Lcom/amazon/retailsearch/metrics/StringName;

    .line 13
    new-instance v0, Lcom/amazon/retailsearch/metrics/StringName;

    const-string/jumbo v1, "BuildFingerprint"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/StringName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/StringName;->BuildFingerprint:Lcom/amazon/retailsearch/metrics/StringName;

    .line 14
    new-instance v0, Lcom/amazon/retailsearch/metrics/StringName;

    const-string/jumbo v1, "SerialNumber"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/StringName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/StringName;->SerialNumber:Lcom/amazon/retailsearch/metrics/StringName;

    .line 15
    new-instance v0, Lcom/amazon/retailsearch/metrics/StringName;

    const-string/jumbo v1, "AndroidId"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/StringName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/StringName;->AndroidId:Lcom/amazon/retailsearch/metrics/StringName;

    .line 16
    new-instance v0, Lcom/amazon/retailsearch/metrics/StringName;

    const-string/jumbo v1, "TelephonyDeviceId"

    const/16 v2, 0xb

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/StringName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/StringName;->TelephonyDeviceId:Lcom/amazon/retailsearch/metrics/StringName;

    .line 17
    new-instance v0, Lcom/amazon/retailsearch/metrics/StringName;

    const-string/jumbo v1, "NetworkName"

    const/16 v2, 0xc

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/StringName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/StringName;->NetworkName:Lcom/amazon/retailsearch/metrics/StringName;

    .line 18
    new-instance v0, Lcom/amazon/retailsearch/metrics/StringName;

    const-string/jumbo v1, "RequestMethod"

    const/16 v2, 0xd

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/StringName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/StringName;->RequestMethod:Lcom/amazon/retailsearch/metrics/StringName;

    .line 19
    new-instance v0, Lcom/amazon/retailsearch/metrics/StringName;

    const-string/jumbo v1, "RequestUrl"

    const/16 v2, 0xe

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/StringName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/StringName;->RequestUrl:Lcom/amazon/retailsearch/metrics/StringName;

    .line 20
    new-instance v0, Lcom/amazon/retailsearch/metrics/StringName;

    const-string/jumbo v1, "RequestParameters"

    const/16 v2, 0xf

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/StringName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/StringName;->RequestParameters:Lcom/amazon/retailsearch/metrics/StringName;

    .line 21
    new-instance v0, Lcom/amazon/retailsearch/metrics/StringName;

    const-string/jumbo v1, "RequestHeaders"

    const/16 v2, 0x10

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/StringName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/StringName;->RequestHeaders:Lcom/amazon/retailsearch/metrics/StringName;

    .line 22
    new-instance v0, Lcom/amazon/retailsearch/metrics/StringName;

    const-string/jumbo v1, "ClientRequestId"

    const/16 v2, 0x11

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/StringName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/metrics/StringName;->ClientRequestId:Lcom/amazon/retailsearch/metrics/StringName;

    .line 3
    const/16 v0, 0x12

    new-array v0, v0, [Lcom/amazon/retailsearch/metrics/StringName;

    sget-object v1, Lcom/amazon/retailsearch/metrics/StringName;->Message:Lcom/amazon/retailsearch/metrics/StringName;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/retailsearch/metrics/StringName;->ExceptionName:Lcom/amazon/retailsearch/metrics/StringName;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/retailsearch/metrics/StringName;->ExceptionMessage:Lcom/amazon/retailsearch/metrics/StringName;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/retailsearch/metrics/StringName;->StackTrace:Lcom/amazon/retailsearch/metrics/StringName;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/retailsearch/metrics/StringName;->OsVersion:Lcom/amazon/retailsearch/metrics/StringName;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/retailsearch/metrics/StringName;->DeviceModel:Lcom/amazon/retailsearch/metrics/StringName;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/retailsearch/metrics/StringName;->Manufacturer:Lcom/amazon/retailsearch/metrics/StringName;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/amazon/retailsearch/metrics/StringName;->BuildProduct:Lcom/amazon/retailsearch/metrics/StringName;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/amazon/retailsearch/metrics/StringName;->BuildFingerprint:Lcom/amazon/retailsearch/metrics/StringName;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/amazon/retailsearch/metrics/StringName;->SerialNumber:Lcom/amazon/retailsearch/metrics/StringName;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/amazon/retailsearch/metrics/StringName;->AndroidId:Lcom/amazon/retailsearch/metrics/StringName;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/amazon/retailsearch/metrics/StringName;->TelephonyDeviceId:Lcom/amazon/retailsearch/metrics/StringName;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/amazon/retailsearch/metrics/StringName;->NetworkName:Lcom/amazon/retailsearch/metrics/StringName;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/amazon/retailsearch/metrics/StringName;->RequestMethod:Lcom/amazon/retailsearch/metrics/StringName;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/amazon/retailsearch/metrics/StringName;->RequestUrl:Lcom/amazon/retailsearch/metrics/StringName;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/amazon/retailsearch/metrics/StringName;->RequestParameters:Lcom/amazon/retailsearch/metrics/StringName;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lcom/amazon/retailsearch/metrics/StringName;->RequestHeaders:Lcom/amazon/retailsearch/metrics/StringName;

    aput-object v2, v0, v1

    const/16 v1, 0x11

    sget-object v2, Lcom/amazon/retailsearch/metrics/StringName;->ClientRequestId:Lcom/amazon/retailsearch/metrics/StringName;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/retailsearch/metrics/StringName;->$VALUES:[Lcom/amazon/retailsearch/metrics/StringName;

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
    .line 3
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/retailsearch/metrics/StringName;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 3
    const-class v0, Lcom/amazon/retailsearch/metrics/StringName;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/metrics/StringName;

    return-object v0
.end method

.method public static values()[Lcom/amazon/retailsearch/metrics/StringName;
    .locals 1

    .prologue
    .line 3
    sget-object v0, Lcom/amazon/retailsearch/metrics/StringName;->$VALUES:[Lcom/amazon/retailsearch/metrics/StringName;

    invoke-virtual {v0}, [Lcom/amazon/retailsearch/metrics/StringName;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/retailsearch/metrics/StringName;

    return-object v0
.end method

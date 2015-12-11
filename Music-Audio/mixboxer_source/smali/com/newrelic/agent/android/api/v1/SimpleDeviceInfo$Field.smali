.class final enum Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;
.super Ljava/lang/Enum;
.source "SimpleDeviceInfo.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "Field"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

.field public static final enum AGENT_NAME:Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

.field public static final enum AGENT_VERSION:Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

.field public static final enum COUNTRY_CODE:Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

.field public static final enum DEVICE_ID:Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

.field public static final enum MANUFACTURER:Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

.field public static final enum MANUFACTURER_MODEL:Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

.field public static final enum MISC:Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

.field public static final enum OS_NAME:Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

.field public static final enum OS_VERSION:Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

.field public static final enum REGION_CODE:Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 12
    new-instance v0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    const-string v1, "OS_NAME"

    invoke-direct {v0, v1, v3}, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;->OS_NAME:Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    .line 13
    new-instance v0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    const-string v1, "OS_VERSION"

    invoke-direct {v0, v1, v4}, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;->OS_VERSION:Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    .line 14
    new-instance v0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    const-string v1, "MANUFACTURER_MODEL"

    invoke-direct {v0, v1, v5}, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;->MANUFACTURER_MODEL:Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    .line 15
    new-instance v0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    const-string v1, "AGENT_NAME"

    invoke-direct {v0, v1, v6}, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;->AGENT_NAME:Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    .line 16
    new-instance v0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    const-string v1, "AGENT_VERSION"

    invoke-direct {v0, v1, v7}, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;->AGENT_VERSION:Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    .line 17
    new-instance v0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    const-string v1, "DEVICE_ID"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;->DEVICE_ID:Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    .line 18
    new-instance v0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    const-string v1, "COUNTRY_CODE"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;->COUNTRY_CODE:Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    .line 19
    new-instance v0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    const-string v1, "REGION_CODE"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;->REGION_CODE:Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    .line 20
    new-instance v0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    const-string v1, "MANUFACTURER"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;->MANUFACTURER:Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    .line 21
    new-instance v0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    const-string v1, "MISC"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;->MISC:Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    .line 11
    const/16 v0, 0xa

    new-array v0, v0, [Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    sget-object v1, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;->OS_NAME:Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    aput-object v1, v0, v3

    sget-object v1, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;->OS_VERSION:Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    aput-object v1, v0, v4

    sget-object v1, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;->MANUFACTURER_MODEL:Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    aput-object v1, v0, v5

    sget-object v1, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;->AGENT_NAME:Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    aput-object v1, v0, v6

    sget-object v1, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;->AGENT_VERSION:Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;->DEVICE_ID:Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;->COUNTRY_CODE:Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;->REGION_CODE:Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;->MANUFACTURER:Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;->MISC:Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    aput-object v2, v0, v1

    sput-object v0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;->$VALUES:[Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

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
    .line 11
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 11
    const-class v0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    return-object v0
.end method

.method public static values()[Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;
    .locals 1

    .prologue
    .line 11
    sget-object v0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;->$VALUES:[Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    invoke-virtual {v0}, [Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    return-object v0
.end method

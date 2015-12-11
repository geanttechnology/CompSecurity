.class public Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;
.super Lcom/newrelic/agent/android/harvest/type/HarvestableObject;
.source "DeviceInfo.java"


# instance fields
.field private OSBuild:Ljava/lang/String;

.field private OSVersion:Ljava/lang/String;

.field private architecture:Ljava/lang/String;

.field private deviceName:Ljava/lang/String;

.field private deviceUuid:Ljava/lang/String;

.field private diskAvailable:[J

.field private memoryUsage:J

.field private modelNumber:Ljava/lang/String;

.field private networkStatus:Ljava/lang/String;

.field private orientation:I

.field private runTime:Ljava/lang/String;

.field private screenResolution:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Lcom/newrelic/agent/android/harvest/type/HarvestableObject;-><init>()V

    .line 29
    return-void
.end method

.method public constructor <init>(Lcom/newrelic/agent/android/harvest/DeviceInformation;Lcom/newrelic/agent/android/harvest/EnvironmentInformation;)V
    .locals 2
    .param p1, "devInfo"    # Lcom/newrelic/agent/android/harvest/DeviceInformation;
    .param p2, "envInfo"    # Lcom/newrelic/agent/android/harvest/EnvironmentInformation;

    .prologue
    .line 32
    invoke-direct {p0}, Lcom/newrelic/agent/android/harvest/type/HarvestableObject;-><init>()V

    .line 34
    invoke-virtual {p2}, Lcom/newrelic/agent/android/harvest/EnvironmentInformation;->getMemoryUsage()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;->memoryUsage:J

    .line 35
    invoke-virtual {p2}, Lcom/newrelic/agent/android/harvest/EnvironmentInformation;->getOrientation()I

    move-result v0

    iput v0, p0, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;->orientation:I

    .line 36
    invoke-virtual {p2}, Lcom/newrelic/agent/android/harvest/EnvironmentInformation;->getNetworkStatus()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;->networkStatus:Ljava/lang/String;

    .line 37
    invoke-virtual {p2}, Lcom/newrelic/agent/android/harvest/EnvironmentInformation;->getDiskAvailable()[J

    move-result-object v0

    iput-object v0, p0, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;->diskAvailable:[J

    .line 38
    invoke-virtual {p1}, Lcom/newrelic/agent/android/harvest/DeviceInformation;->getOsVersion()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;->OSVersion:Ljava/lang/String;

    .line 39
    invoke-virtual {p1}, Lcom/newrelic/agent/android/harvest/DeviceInformation;->getManufacturer()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;->deviceName:Ljava/lang/String;

    .line 40
    invoke-virtual {p1}, Lcom/newrelic/agent/android/harvest/DeviceInformation;->getOsBuild()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;->OSBuild:Ljava/lang/String;

    .line 41
    invoke-virtual {p1}, Lcom/newrelic/agent/android/harvest/DeviceInformation;->getArchitecture()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;->architecture:Ljava/lang/String;

    .line 42
    invoke-virtual {p1}, Lcom/newrelic/agent/android/harvest/DeviceInformation;->getModel()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;->modelNumber:Ljava/lang/String;

    .line 43
    invoke-virtual {p1}, Lcom/newrelic/agent/android/harvest/DeviceInformation;->getSize()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;->screenResolution:Ljava/lang/String;

    .line 44
    invoke-virtual {p1}, Lcom/newrelic/agent/android/harvest/DeviceInformation;->getDeviceId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;->deviceUuid:Ljava/lang/String;

    .line 45
    invoke-virtual {p1}, Lcom/newrelic/agent/android/harvest/DeviceInformation;->getRunTime()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;->runTime:Ljava/lang/String;

    .line 46
    return-void
.end method

.method private getDiskAvailableAsJson()Lcom/newrelic/com/google/gson/JsonArray;
    .locals 7

    .prologue
    .line 100
    new-instance v1, Lcom/newrelic/com/google/gson/JsonArray;

    invoke-direct {v1}, Lcom/newrelic/com/google/gson/JsonArray;-><init>()V

    .line 102
    .local v1, "data":Lcom/newrelic/com/google/gson/JsonArray;
    iget-object v0, p0, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;->diskAvailable:[J

    .local v0, "arr$":[J
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_0

    aget-wide v4, v0, v2

    .line 103
    .local v4, "value":J
    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-static {v6}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/Number;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v6

    invoke-virtual {v1, v6}, Lcom/newrelic/com/google/gson/JsonArray;->add(Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 102
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 106
    .end local v4    # "value":J
    :cond_0
    return-object v1
.end method

.method private static longArrayFromJsonArray(Lcom/newrelic/com/google/gson/JsonArray;)[J
    .locals 8
    .param p0, "jsonArray"    # Lcom/newrelic/com/google/gson/JsonArray;

    .prologue
    .line 89
    invoke-virtual {p0}, Lcom/newrelic/com/google/gson/JsonArray;->size()I

    move-result v5

    new-array v0, v5, [J

    .line 90
    .local v0, "array":[J
    const/4 v1, 0x0

    .line 92
    .local v1, "i":I
    invoke-virtual {p0}, Lcom/newrelic/com/google/gson/JsonArray;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/newrelic/com/google/gson/JsonElement;

    .line 93
    .local v4, "jsonElement":Lcom/newrelic/com/google/gson/JsonElement;
    add-int/lit8 v2, v1, 0x1

    .end local v1    # "i":I
    .local v2, "i":I
    invoke-virtual {v4}, Lcom/newrelic/com/google/gson/JsonElement;->getAsLong()J

    move-result-wide v6

    aput-wide v6, v0, v1

    move v1, v2

    .line 94
    .end local v2    # "i":I
    .restart local v1    # "i":I
    goto :goto_0

    .line 96
    .end local v4    # "jsonElement":Lcom/newrelic/com/google/gson/JsonElement;
    :cond_0
    return-object v0
.end method

.method public static newFromJson(Lcom/newrelic/com/google/gson/JsonObject;)Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;
    .locals 4
    .param p0, "jsonObject"    # Lcom/newrelic/com/google/gson/JsonObject;

    .prologue
    .line 69
    new-instance v0, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;

    invoke-direct {v0}, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;-><init>()V

    .line 71
    .local v0, "info":Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;
    const-string v1, "memoryUsage"

    invoke-virtual {p0, v1}, Lcom/newrelic/com/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonElement;

    move-result-object v1

    invoke-virtual {v1}, Lcom/newrelic/com/google/gson/JsonElement;->getAsLong()J

    move-result-wide v2

    iput-wide v2, v0, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;->memoryUsage:J

    .line 72
    const-string v1, "orientation"

    invoke-virtual {p0, v1}, Lcom/newrelic/com/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonElement;

    move-result-object v1

    invoke-virtual {v1}, Lcom/newrelic/com/google/gson/JsonElement;->getAsInt()I

    move-result v1

    iput v1, v0, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;->orientation:I

    .line 73
    const-string v1, "networkStatus"

    invoke-virtual {p0, v1}, Lcom/newrelic/com/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonElement;

    move-result-object v1

    invoke-virtual {v1}, Lcom/newrelic/com/google/gson/JsonElement;->getAsString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;->networkStatus:Ljava/lang/String;

    .line 74
    const-string v1, "diskAvailable"

    invoke-virtual {p0, v1}, Lcom/newrelic/com/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonElement;

    move-result-object v1

    invoke-virtual {v1}, Lcom/newrelic/com/google/gson/JsonElement;->getAsJsonArray()Lcom/newrelic/com/google/gson/JsonArray;

    move-result-object v1

    invoke-static {v1}, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;->longArrayFromJsonArray(Lcom/newrelic/com/google/gson/JsonArray;)[J

    move-result-object v1

    iput-object v1, v0, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;->diskAvailable:[J

    .line 75
    const-string v1, "osVersion"

    invoke-virtual {p0, v1}, Lcom/newrelic/com/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonElement;

    move-result-object v1

    invoke-virtual {v1}, Lcom/newrelic/com/google/gson/JsonElement;->getAsString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;->OSVersion:Ljava/lang/String;

    .line 76
    const-string v1, "deviceName"

    invoke-virtual {p0, v1}, Lcom/newrelic/com/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonElement;

    move-result-object v1

    invoke-virtual {v1}, Lcom/newrelic/com/google/gson/JsonElement;->getAsString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;->deviceName:Ljava/lang/String;

    .line 77
    const-string v1, "osBuild"

    invoke-virtual {p0, v1}, Lcom/newrelic/com/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonElement;

    move-result-object v1

    invoke-virtual {v1}, Lcom/newrelic/com/google/gson/JsonElement;->getAsString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;->OSBuild:Ljava/lang/String;

    .line 78
    const-string v1, "architecture"

    invoke-virtual {p0, v1}, Lcom/newrelic/com/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonElement;

    move-result-object v1

    invoke-virtual {v1}, Lcom/newrelic/com/google/gson/JsonElement;->getAsString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;->architecture:Ljava/lang/String;

    .line 79
    const-string v1, "runTime"

    invoke-virtual {p0, v1}, Lcom/newrelic/com/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonElement;

    move-result-object v1

    invoke-virtual {v1}, Lcom/newrelic/com/google/gson/JsonElement;->getAsString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;->runTime:Ljava/lang/String;

    .line 80
    const-string v1, "modelNumber"

    invoke-virtual {p0, v1}, Lcom/newrelic/com/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonElement;

    move-result-object v1

    invoke-virtual {v1}, Lcom/newrelic/com/google/gson/JsonElement;->getAsString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;->modelNumber:Ljava/lang/String;

    .line 81
    const-string v1, "screenResolution"

    invoke-virtual {p0, v1}, Lcom/newrelic/com/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonElement;

    move-result-object v1

    invoke-virtual {v1}, Lcom/newrelic/com/google/gson/JsonElement;->getAsString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;->screenResolution:Ljava/lang/String;

    .line 82
    const-string v1, "deviceUuid"

    invoke-virtual {p0, v1}, Lcom/newrelic/com/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonElement;

    move-result-object v1

    invoke-virtual {v1}, Lcom/newrelic/com/google/gson/JsonElement;->getAsString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;->deviceUuid:Ljava/lang/String;

    .line 84
    return-object v0
.end method


# virtual methods
.method public asJsonObject()Lcom/newrelic/com/google/gson/JsonObject;
    .locals 4

    .prologue
    .line 50
    new-instance v0, Lcom/newrelic/com/google/gson/JsonObject;

    invoke-direct {v0}, Lcom/newrelic/com/google/gson/JsonObject;-><init>()V

    .line 52
    .local v0, "data":Lcom/newrelic/com/google/gson/JsonObject;
    const-string v1, "memoryUsage"

    iget-wide v2, p0, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;->memoryUsage:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-static {v2}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/Number;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 53
    const-string v1, "orientation"

    iget v2, p0, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;->orientation:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-static {v2}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/Number;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 54
    const-string v1, "networkStatus"

    iget-object v2, p0, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;->networkStatus:Ljava/lang/String;

    invoke-static {v2}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 55
    const-string v1, "diskAvailable"

    invoke-direct {p0}, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;->getDiskAvailableAsJson()Lcom/newrelic/com/google/gson/JsonArray;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 56
    const-string v1, "osVersion"

    iget-object v2, p0, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;->OSVersion:Ljava/lang/String;

    invoke-static {v2}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 57
    const-string v1, "deviceName"

    iget-object v2, p0, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;->deviceName:Ljava/lang/String;

    invoke-static {v2}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 58
    const-string v1, "osBuild"

    iget-object v2, p0, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;->OSBuild:Ljava/lang/String;

    invoke-static {v2}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 59
    const-string v1, "architecture"

    iget-object v2, p0, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;->architecture:Ljava/lang/String;

    invoke-static {v2}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 60
    const-string v1, "runTime"

    iget-object v2, p0, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;->runTime:Ljava/lang/String;

    invoke-static {v2}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 61
    const-string v1, "modelNumber"

    iget-object v2, p0, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;->modelNumber:Ljava/lang/String;

    invoke-static {v2}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 62
    const-string v1, "screenResolution"

    iget-object v2, p0, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;->screenResolution:Ljava/lang/String;

    invoke-static {v2}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 63
    const-string v1, "deviceUuid"

    iget-object v2, p0, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;->deviceUuid:Ljava/lang/String;

    invoke-static {v2}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 65
    return-object v0
.end method

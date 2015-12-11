.class public Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;
.super Lcom/newrelic/agent/android/harvest/type/HarvestableObject;
.source "ApplicationInfo.java"


# instance fields
.field private applicationBuild:Ljava/lang/String;

.field private applicationName:Ljava/lang/String;

.field private applicationVersion:Ljava/lang/String;

.field private bundleId:Ljava/lang/String;

.field private processId:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 20
    invoke-direct {p0}, Lcom/newrelic/agent/android/harvest/type/HarvestableObject;-><init>()V

    .line 13
    const-string v0, ""

    iput-object v0, p0, Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;->applicationName:Ljava/lang/String;

    .line 14
    const-string v0, ""

    iput-object v0, p0, Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;->applicationVersion:Ljava/lang/String;

    .line 15
    const-string v0, ""

    iput-object v0, p0, Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;->applicationBuild:Ljava/lang/String;

    .line 16
    const-string v0, ""

    iput-object v0, p0, Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;->bundleId:Ljava/lang/String;

    .line 17
    const/4 v0, 0x0

    iput v0, p0, Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;->processId:I

    .line 21
    return-void
.end method

.method public constructor <init>(Lcom/newrelic/agent/android/harvest/ApplicationInformation;)V
    .locals 1
    .param p1, "applicationInformation"    # Lcom/newrelic/agent/android/harvest/ApplicationInformation;

    .prologue
    .line 23
    invoke-direct {p0}, Lcom/newrelic/agent/android/harvest/type/HarvestableObject;-><init>()V

    .line 13
    const-string v0, ""

    iput-object v0, p0, Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;->applicationName:Ljava/lang/String;

    .line 14
    const-string v0, ""

    iput-object v0, p0, Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;->applicationVersion:Ljava/lang/String;

    .line 15
    const-string v0, ""

    iput-object v0, p0, Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;->applicationBuild:Ljava/lang/String;

    .line 16
    const-string v0, ""

    iput-object v0, p0, Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;->bundleId:Ljava/lang/String;

    .line 17
    const/4 v0, 0x0

    iput v0, p0, Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;->processId:I

    .line 24
    invoke-virtual {p1}, Lcom/newrelic/agent/android/harvest/ApplicationInformation;->getAppName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;->applicationName:Ljava/lang/String;

    .line 25
    invoke-virtual {p1}, Lcom/newrelic/agent/android/harvest/ApplicationInformation;->getAppVersion()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;->applicationVersion:Ljava/lang/String;

    .line 26
    invoke-virtual {p1}, Lcom/newrelic/agent/android/harvest/ApplicationInformation;->getAppBuild()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;->applicationBuild:Ljava/lang/String;

    .line 27
    invoke-virtual {p1}, Lcom/newrelic/agent/android/harvest/ApplicationInformation;->getPackageId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;->bundleId:Ljava/lang/String;

    .line 28
    return-void
.end method

.method public static newFromJson(Lcom/newrelic/com/google/gson/JsonObject;)Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;
    .locals 2
    .param p0, "jsonObject"    # Lcom/newrelic/com/google/gson/JsonObject;

    .prologue
    .line 49
    new-instance v0, Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;

    invoke-direct {v0}, Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;-><init>()V

    .line 51
    .local v0, "info":Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;
    const-string v1, "appName"

    invoke-virtual {p0, v1}, Lcom/newrelic/com/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonElement;

    move-result-object v1

    invoke-virtual {v1}, Lcom/newrelic/com/google/gson/JsonElement;->getAsString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;->applicationName:Ljava/lang/String;

    .line 52
    const-string v1, "appVersion"

    invoke-virtual {p0, v1}, Lcom/newrelic/com/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonElement;

    move-result-object v1

    invoke-virtual {v1}, Lcom/newrelic/com/google/gson/JsonElement;->getAsString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;->applicationVersion:Ljava/lang/String;

    .line 53
    const-string v1, "appBuild"

    invoke-virtual {p0, v1}, Lcom/newrelic/com/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonElement;

    move-result-object v1

    invoke-virtual {v1}, Lcom/newrelic/com/google/gson/JsonElement;->getAsString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;->applicationBuild:Ljava/lang/String;

    .line 54
    const-string v1, "bundleId"

    invoke-virtual {p0, v1}, Lcom/newrelic/com/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonElement;

    move-result-object v1

    invoke-virtual {v1}, Lcom/newrelic/com/google/gson/JsonElement;->getAsString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;->bundleId:Ljava/lang/String;

    .line 55
    const-string v1, "processId"

    invoke-virtual {p0, v1}, Lcom/newrelic/com/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonElement;

    move-result-object v1

    invoke-virtual {v1}, Lcom/newrelic/com/google/gson/JsonElement;->getAsInt()I

    move-result v1

    iput v1, v0, Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;->processId:I

    .line 57
    return-object v0
.end method


# virtual methods
.method public asJsonObject()Lcom/newrelic/com/google/gson/JsonObject;
    .locals 3

    .prologue
    .line 32
    new-instance v0, Lcom/newrelic/com/google/gson/JsonObject;

    invoke-direct {v0}, Lcom/newrelic/com/google/gson/JsonObject;-><init>()V

    .line 39
    .local v0, "data":Lcom/newrelic/com/google/gson/JsonObject;
    const-string v1, "appName"

    iget-object v2, p0, Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;->applicationName:Ljava/lang/String;

    invoke-static {v2}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 40
    const-string v1, "appVersion"

    iget-object v2, p0, Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;->applicationVersion:Ljava/lang/String;

    invoke-static {v2}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 41
    const-string v1, "appBuild"

    iget-object v2, p0, Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;->applicationBuild:Ljava/lang/String;

    invoke-static {v2}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 42
    const-string v1, "bundleId"

    iget-object v2, p0, Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;->bundleId:Ljava/lang/String;

    invoke-static {v2}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 43
    const-string v1, "processId"

    iget v2, p0, Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;->processId:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-static {v2}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/Number;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 45
    return-object v0
.end method

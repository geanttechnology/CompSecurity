.class public Lcom/comcast/playerplatform/analytics/java/xua/XuaApplicationInfo;
.super Ljava/lang/Object;
.source "XuaApplicationInfo.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/annotation/JsonInclude;
    value = .enum Lcom/fasterxml/jackson/annotation/JsonInclude$Include;->NON_NULL:Lcom/fasterxml/jackson/annotation/JsonInclude$Include;
.end annotation


# instance fields
.field private accountId:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "AID"
    .end annotation
.end field

.field private applicationName:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "APP_NAME"
    .end annotation
.end field

.field private applicationVersion:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "APP_VER"
    .end annotation
.end field

.field private pluginName:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "PLUGIN_NAME"
    .end annotation
.end field

.field private pluginVersion:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "PLUGIN_VER"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 48
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 52
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "applicationName"    # Ljava/lang/String;
    .param p2, "applicationVersion"    # Ljava/lang/String;
    .param p3, "pluginName"    # Ljava/lang/String;
    .param p4, "pluginVersion"    # Ljava/lang/String;
    .param p5, "accountId"    # Ljava/lang/String;

    .prologue
    .line 54
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 55
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaApplicationInfo;->applicationName:Ljava/lang/String;

    .line 56
    iput-object p2, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaApplicationInfo;->applicationVersion:Ljava/lang/String;

    .line 57
    iput-object p3, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaApplicationInfo;->pluginName:Ljava/lang/String;

    .line 58
    iput-object p4, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaApplicationInfo;->pluginVersion:Ljava/lang/String;

    .line 59
    invoke-virtual {p0, p5}, Lcom/comcast/playerplatform/analytics/java/xua/XuaApplicationInfo;->setAccountId(Ljava/lang/String;)V

    .line 60
    return-void
.end method

.method private toMD5(Ljava/lang/String;)Ljava/lang/String;
    .locals 7
    .param p1, "md5"    # Ljava/lang/String;

    .prologue
    .line 115
    :try_start_0
    const-string v4, "MD5"

    invoke-static {v4}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v2

    .line 116
    .local v2, "md":Ljava/security/MessageDigest;
    invoke-virtual {p1}, Ljava/lang/String;->getBytes()[B

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/security/MessageDigest;->digest([B)[B

    move-result-object v0

    .line 117
    .local v0, "array":[B
    new-instance v3, Ljava/lang/StringBuffer;

    invoke-direct {v3}, Ljava/lang/StringBuffer;-><init>()V

    .line 118
    .local v3, "sb":Ljava/lang/StringBuffer;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v4, v0

    if-ge v1, v4, :cond_0

    .line 119
    aget-byte v4, v0, v1

    and-int/lit16 v4, v4, 0xff

    or-int/lit16 v4, v4, 0x100

    invoke-static {v4}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x1

    const/4 v6, 0x3

    invoke-virtual {v4, v5, v6}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 118
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 121
    :cond_0
    invoke-virtual {v3}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v4

    .line 124
    .end local v0    # "array":[B
    .end local v1    # "i":I
    .end local v2    # "md":Ljava/security/MessageDigest;
    .end local v3    # "sb":Ljava/lang/StringBuffer;
    :goto_1
    return-object v4

    .line 122
    :catch_0
    move-exception v4

    .line 124
    const/4 v4, 0x0

    goto :goto_1
.end method


# virtual methods
.method public getAccountId()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 104
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaApplicationInfo;->accountId:Ljava/lang/String;

    return-object v0
.end method

.method public getApplicationName()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 68
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaApplicationInfo;->applicationName:Ljava/lang/String;

    return-object v0
.end method

.method public getApplicationVersion()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 77
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaApplicationInfo;->applicationVersion:Ljava/lang/String;

    return-object v0
.end method

.method public getPluginName()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 86
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaApplicationInfo;->pluginName:Ljava/lang/String;

    return-object v0
.end method

.method public getPluginVersion()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 95
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaApplicationInfo;->pluginVersion:Ljava/lang/String;

    return-object v0
.end method

.method public setAccountId(Ljava/lang/String;)V
    .locals 1
    .param p1, "accountId"    # Ljava/lang/String;

    .prologue
    .line 108
    if-eqz p1, :cond_0

    .line 109
    invoke-direct {p0, p1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaApplicationInfo;->toMD5(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaApplicationInfo;->accountId:Ljava/lang/String;

    .line 111
    :cond_0
    return-void
.end method

.method public setApplicationName(Ljava/lang/String;)V
    .locals 0
    .param p1, "applicationName"    # Ljava/lang/String;

    .prologue
    .line 72
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaApplicationInfo;->applicationName:Ljava/lang/String;

    .line 73
    return-void
.end method

.method public setApplicationVersion(Ljava/lang/String;)V
    .locals 0
    .param p1, "applicationVersion"    # Ljava/lang/String;

    .prologue
    .line 81
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaApplicationInfo;->applicationVersion:Ljava/lang/String;

    .line 82
    return-void
.end method

.method public setPluginName(Ljava/lang/String;)V
    .locals 0
    .param p1, "pluginName"    # Ljava/lang/String;

    .prologue
    .line 90
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaApplicationInfo;->pluginName:Ljava/lang/String;

    .line 91
    return-void
.end method

.method public setPluginVersion(Ljava/lang/String;)V
    .locals 0
    .param p1, "pluginVersion"    # Ljava/lang/String;

    .prologue
    .line 99
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaApplicationInfo;->pluginVersion:Ljava/lang/String;

    .line 100
    return-void
.end method

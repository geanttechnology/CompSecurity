.class public Lcom/igexin/sdk/data/PhoneInfo;
.super Ljava/lang/Object;
.source "PhoneInfo.java"


# instance fields
.field private channelid:Ljava/lang/String;

.field private deviceid:Ljava/lang/String;

.field private imei:Ljava/lang/String;

.field private model:Ljava/lang/String;

.field private system_version:Ljava/lang/String;

.field private type:Ljava/lang/String;

.field private uuid:Ljava/lang/String;

.field private version:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getImei()Ljava/lang/String;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/igexin/sdk/data/PhoneInfo;->imei:Ljava/lang/String;

    return-object v0
.end method

.method public getJsonMap()Ljava/util/Map;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 81
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 82
    .local v0, "infoMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string/jumbo v1, "model"

    iget-object v2, p0, Lcom/igexin/sdk/data/PhoneInfo;->model:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 83
    const-string/jumbo v1, "type"

    iget-object v2, p0, Lcom/igexin/sdk/data/PhoneInfo;->type:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 84
    const-string/jumbo v1, "system_version"

    iget-object v2, p0, Lcom/igexin/sdk/data/PhoneInfo;->system_version:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 87
    const-string/jumbo v1, "sim"

    iget-object v2, p0, Lcom/igexin/sdk/data/PhoneInfo;->uuid:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 88
    const-string/jumbo v1, "imei"

    iget-object v2, p0, Lcom/igexin/sdk/data/PhoneInfo;->uuid:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 89
    const-string/jumbo v1, "version"

    iget-object v2, p0, Lcom/igexin/sdk/data/PhoneInfo;->version:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 90
    const-string/jumbo v1, "channelid"

    iget-object v2, p0, Lcom/igexin/sdk/data/PhoneInfo;->channelid:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 91
    const-string/jumbo v1, "deviceid"

    iget-object v2, p0, Lcom/igexin/sdk/data/PhoneInfo;->deviceid:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 92
    return-object v0
.end method

.method public getUuid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/igexin/sdk/data/PhoneInfo;->uuid:Ljava/lang/String;

    return-object v0
.end method

.method public setChannelid(Ljava/lang/String;)V
    .locals 0
    .param p1, "channelid"    # Ljava/lang/String;

    .prologue
    .line 71
    iput-object p1, p0, Lcom/igexin/sdk/data/PhoneInfo;->channelid:Ljava/lang/String;

    .line 72
    return-void
.end method

.method public setDeviceid(Ljava/lang/String;)V
    .locals 0
    .param p1, "deviceid"    # Ljava/lang/String;

    .prologue
    .line 77
    iput-object p1, p0, Lcom/igexin/sdk/data/PhoneInfo;->deviceid:Ljava/lang/String;

    .line 78
    return-void
.end method

.method public setImei(Ljava/lang/String;)V
    .locals 0
    .param p1, "imei"    # Ljava/lang/String;

    .prologue
    .line 59
    iput-object p1, p0, Lcom/igexin/sdk/data/PhoneInfo;->imei:Ljava/lang/String;

    .line 60
    return-void
.end method

.method public setModel(Ljava/lang/String;)V
    .locals 0
    .param p1, "model"    # Ljava/lang/String;

    .prologue
    .line 36
    iput-object p1, p0, Lcom/igexin/sdk/data/PhoneInfo;->model:Ljava/lang/String;

    .line 37
    return-void
.end method

.method public setSystem_version(Ljava/lang/String;)V
    .locals 0
    .param p1, "system_version"    # Ljava/lang/String;

    .prologue
    .line 48
    iput-object p1, p0, Lcom/igexin/sdk/data/PhoneInfo;->system_version:Ljava/lang/String;

    .line 49
    return-void
.end method

.method public setType(Ljava/lang/String;)V
    .locals 0
    .param p1, "type"    # Ljava/lang/String;

    .prologue
    .line 42
    iput-object p1, p0, Lcom/igexin/sdk/data/PhoneInfo;->type:Ljava/lang/String;

    .line 43
    return-void
.end method

.method public setUuid(Ljava/lang/String;)V
    .locals 0
    .param p1, "uuid"    # Ljava/lang/String;

    .prologue
    .line 30
    iput-object p1, p0, Lcom/igexin/sdk/data/PhoneInfo;->uuid:Ljava/lang/String;

    .line 31
    return-void
.end method

.method public setVersion(Ljava/lang/String;)V
    .locals 0
    .param p1, "version"    # Ljava/lang/String;

    .prologue
    .line 65
    iput-object p1, p0, Lcom/igexin/sdk/data/PhoneInfo;->version:Ljava/lang/String;

    .line 66
    return-void
.end method

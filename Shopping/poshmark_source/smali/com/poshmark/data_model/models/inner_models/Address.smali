.class public Lcom/poshmark/data_model/models/inner_models/Address;
.super Ljava/lang/Object;
.source "Address.java"


# instance fields
.field private city:Ljava/lang/String;

.field private name:Ljava/lang/String;

.field private phone:Ljava/lang/String;

.field private state:Ljava/lang/String;

.field private street:Ljava/lang/String;

.field private street2:Ljava/lang/String;

.field private type:Ljava/lang/String;

.field private zip:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public copy(Lcom/poshmark/data_model/models/inner_models/Address;)V
    .locals 1
    .param p1, "address"    # Lcom/poshmark/data_model/models/inner_models/Address;

    .prologue
    .line 18
    if-eqz p1, :cond_0

    .line 19
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/Address;->name:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Address;->name:Ljava/lang/String;

    .line 20
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/Address;->street:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Address;->street:Ljava/lang/String;

    .line 21
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/Address;->street2:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Address;->street2:Ljava/lang/String;

    .line 22
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/Address;->city:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Address;->city:Ljava/lang/String;

    .line 23
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/Address;->state:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Address;->state:Ljava/lang/String;

    .line 24
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/Address;->zip:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Address;->zip:Ljava/lang/String;

    .line 25
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/Address;->phone:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Address;->phone:Ljava/lang/String;

    .line 26
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/Address;->type:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Address;->type:Ljava/lang/String;

    .line 28
    :cond_0
    return-void
.end method

.method public getCity()Ljava/lang/String;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Address;->city:Ljava/lang/String;

    return-object v0
.end method

.method public getJsonString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 140
    new-instance v0, Lcom/google/gson/GsonBuilder;

    invoke-direct {v0}, Lcom/google/gson/GsonBuilder;-><init>()V

    .line 141
    .local v0, "b":Lcom/google/gson/GsonBuilder;
    invoke-virtual {v0}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v1

    .line 142
    .local v1, "gson":Lcom/google/gson/Gson;
    const-class v2, Lcom/poshmark/data_model/models/inner_models/Address;

    instance-of v3, v1, Lcom/google/gson/Gson;

    if-nez v3, :cond_0

    invoke-virtual {v1, p0, v2}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v2

    .end local v1    # "gson":Lcom/google/gson/Gson;
    :goto_0
    return-object v2

    .restart local v1    # "gson":Lcom/google/gson/Gson;
    :cond_0
    check-cast v1, Lcom/google/gson/Gson;

    .end local v1    # "gson":Lcom/google/gson/Gson;
    invoke-static {v1, p0, v2}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->toJson(Lcom/google/gson/Gson;Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v2

    goto :goto_0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Address;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getPhone()Ljava/lang/String;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Address;->phone:Ljava/lang/String;

    return-object v0
.end method

.method public getState()Ljava/lang/String;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Address;->state:Ljava/lang/String;

    return-object v0
.end method

.method public getStreet()Ljava/lang/String;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Address;->street:Ljava/lang/String;

    return-object v0
.end method

.method public getStreet2()Ljava/lang/String;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Address;->street2:Ljava/lang/String;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Address;->type:Ljava/lang/String;

    return-object v0
.end method

.method public getZip()Ljava/lang/String;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Address;->zip:Ljava/lang/String;

    return-object v0
.end method

.method public isDataAvailable()Z
    .locals 2

    .prologue
    .line 130
    const/4 v0, 0x1

    .line 132
    .local v0, "retVal":Z
    iget-object v1, p0, Lcom/poshmark/data_model/models/inner_models/Address;->name:Ljava/lang/String;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/data_model/models/inner_models/Address;->street:Ljava/lang/String;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/data_model/models/inner_models/Address;->city:Ljava/lang/String;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/data_model/models/inner_models/Address;->state:Ljava/lang/String;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/data_model/models/inner_models/Address;->zip:Ljava/lang/String;

    if-nez v1, :cond_1

    .line 133
    :cond_0
    const/4 v0, 0x0

    .line 136
    :cond_1
    return v0
.end method

.method public isSameAs(Lcom/poshmark/data_model/models/inner_models/Address;)Z
    .locals 3
    .param p1, "address"    # Lcom/poshmark/data_model/models/inner_models/Address;

    .prologue
    const/4 v0, 0x0

    .line 97
    if-nez p1, :cond_1

    .line 126
    :cond_0
    :goto_0
    return v0

    .line 100
    :cond_1
    iget-object v1, p0, Lcom/poshmark/data_model/models/inner_models/Address;->street:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p1, Lcom/poshmark/data_model/models/inner_models/Address;->street:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 104
    iget-object v1, p0, Lcom/poshmark/data_model/models/inner_models/Address;->city:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p1, Lcom/poshmark/data_model/models/inner_models/Address;->city:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 108
    iget-object v1, p0, Lcom/poshmark/data_model/models/inner_models/Address;->state:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p1, Lcom/poshmark/data_model/models/inner_models/Address;->state:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 112
    iget-object v1, p0, Lcom/poshmark/data_model/models/inner_models/Address;->zip:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p1, Lcom/poshmark/data_model/models/inner_models/Address;->zip:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 117
    iget-object v1, p0, Lcom/poshmark/data_model/models/inner_models/Address;->street2:Ljava/lang/String;

    if-eqz v1, :cond_3

    iget-object v1, p1, Lcom/poshmark/data_model/models/inner_models/Address;->street2:Ljava/lang/String;

    if-eqz v1, :cond_3

    .line 118
    iget-object v1, p0, Lcom/poshmark/data_model/models/inner_models/Address;->street2:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p1, Lcom/poshmark/data_model/models/inner_models/Address;->street2:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 126
    :cond_2
    const/4 v0, 0x1

    goto :goto_0

    .line 122
    :cond_3
    iget-object v1, p0, Lcom/poshmark/data_model/models/inner_models/Address;->street2:Ljava/lang/String;

    if-nez v1, :cond_4

    iget-object v1, p1, Lcom/poshmark/data_model/models/inner_models/Address;->street2:Ljava/lang/String;

    if-nez v1, :cond_0

    :cond_4
    iget-object v1, p0, Lcom/poshmark/data_model/models/inner_models/Address;->street2:Ljava/lang/String;

    if-eqz v1, :cond_2

    iget-object v1, p1, Lcom/poshmark/data_model/models/inner_models/Address;->street2:Ljava/lang/String;

    if-nez v1, :cond_2

    goto :goto_0
.end method

.method public setCity(Ljava/lang/String;)V
    .locals 0
    .param p1, "city"    # Ljava/lang/String;

    .prologue
    .line 76
    iput-object p1, p0, Lcom/poshmark/data_model/models/inner_models/Address;->city:Ljava/lang/String;

    .line 77
    return-void
.end method

.method public setName(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 64
    iput-object p1, p0, Lcom/poshmark/data_model/models/inner_models/Address;->name:Ljava/lang/String;

    .line 65
    return-void
.end method

.method public setPhone(Ljava/lang/String;)V
    .locals 0
    .param p1, "phone"    # Ljava/lang/String;

    .prologue
    .line 88
    iput-object p1, p0, Lcom/poshmark/data_model/models/inner_models/Address;->phone:Ljava/lang/String;

    .line 89
    return-void
.end method

.method public setState(Ljava/lang/String;)V
    .locals 0
    .param p1, "state"    # Ljava/lang/String;

    .prologue
    .line 80
    iput-object p1, p0, Lcom/poshmark/data_model/models/inner_models/Address;->state:Ljava/lang/String;

    .line 81
    return-void
.end method

.method public setStreet(Ljava/lang/String;)V
    .locals 0
    .param p1, "street"    # Ljava/lang/String;

    .prologue
    .line 68
    iput-object p1, p0, Lcom/poshmark/data_model/models/inner_models/Address;->street:Ljava/lang/String;

    .line 69
    return-void
.end method

.method public setStreet2(Ljava/lang/String;)V
    .locals 0
    .param p1, "street2"    # Ljava/lang/String;

    .prologue
    .line 72
    iput-object p1, p0, Lcom/poshmark/data_model/models/inner_models/Address;->street2:Ljava/lang/String;

    .line 73
    return-void
.end method

.method public setType(Ljava/lang/String;)V
    .locals 0
    .param p1, "type"    # Ljava/lang/String;

    .prologue
    .line 92
    iput-object p1, p0, Lcom/poshmark/data_model/models/inner_models/Address;->type:Ljava/lang/String;

    .line 93
    return-void
.end method

.method public setZip(Ljava/lang/String;)V
    .locals 0
    .param p1, "zip"    # Ljava/lang/String;

    .prologue
    .line 84
    iput-object p1, p0, Lcom/poshmark/data_model/models/inner_models/Address;->zip:Ljava/lang/String;

    .line 85
    return-void
.end method

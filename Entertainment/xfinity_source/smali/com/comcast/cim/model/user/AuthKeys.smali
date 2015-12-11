.class public Lcom/comcast/cim/model/user/AuthKeys;
.super Ljava/lang/Object;
.source "AuthKeys.java"


# instance fields
.field private consumerKey:Ljava/lang/String;

.field private consumerSecret:Ljava/lang/String;

.field private flags:Ljava/lang/String;

.field private greetingName:Ljava/lang/String;

.field private omnitureTrackingKey:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    return-void
.end method


# virtual methods
.method public getConsumerKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/comcast/cim/model/user/AuthKeys;->consumerKey:Ljava/lang/String;

    return-object v0
.end method

.method public getConsumerSecret()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/comcast/cim/model/user/AuthKeys;->consumerSecret:Ljava/lang/String;

    return-object v0
.end method

.method public getFlags()Ljava/lang/String;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/comcast/cim/model/user/AuthKeys;->flags:Ljava/lang/String;

    return-object v0
.end method

.method public getGreetingName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/comcast/cim/model/user/AuthKeys;->greetingName:Ljava/lang/String;

    return-object v0
.end method

.method public getOmnitureTrackingKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/comcast/cim/model/user/AuthKeys;->omnitureTrackingKey:Ljava/lang/String;

    return-object v0
.end method

.method public setConsumerKey(Ljava/lang/String;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 28
    iput-object p1, p0, Lcom/comcast/cim/model/user/AuthKeys;->consumerKey:Ljava/lang/String;

    .line 29
    return-void
.end method

.method public setConsumerSecret(Ljava/lang/String;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 36
    iput-object p1, p0, Lcom/comcast/cim/model/user/AuthKeys;->consumerSecret:Ljava/lang/String;

    .line 37
    return-void
.end method

.method public setFlags(Ljava/lang/String;)V
    .locals 0
    .param p1, "flags"    # Ljava/lang/String;

    .prologue
    .line 60
    iput-object p1, p0, Lcom/comcast/cim/model/user/AuthKeys;->flags:Ljava/lang/String;

    .line 61
    return-void
.end method

.method public setGreetingName(Ljava/lang/String;)V
    .locals 0
    .param p1, "greetingName"    # Ljava/lang/String;

    .prologue
    .line 44
    iput-object p1, p0, Lcom/comcast/cim/model/user/AuthKeys;->greetingName:Ljava/lang/String;

    .line 45
    return-void
.end method

.method public setOmnitureTrackingKey(Ljava/lang/String;)V
    .locals 0
    .param p1, "omnitureTrackingKey"    # Ljava/lang/String;

    .prologue
    .line 52
    iput-object p1, p0, Lcom/comcast/cim/model/user/AuthKeys;->omnitureTrackingKey:Ljava/lang/String;

    .line 53
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 65
    new-instance v0, Lorg/apache/commons/lang3/builder/ToStringBuilder;

    sget-object v1, Lorg/apache/commons/lang3/builder/ToStringStyle;->SHORT_PREFIX_STYLE:Lorg/apache/commons/lang3/builder/ToStringStyle;

    invoke-direct {v0, p0, v1}, Lorg/apache/commons/lang3/builder/ToStringBuilder;-><init>(Ljava/lang/Object;Lorg/apache/commons/lang3/builder/ToStringStyle;)V

    const-string v1, "consumerKey"

    iget-object v2, p0, Lcom/comcast/cim/model/user/AuthKeys;->consumerKey:Ljava/lang/String;

    .line 66
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "consumerSecret"

    iget-object v2, p0, Lcom/comcast/cim/model/user/AuthKeys;->consumerSecret:Ljava/lang/String;

    .line 67
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "greetingName"

    iget-object v2, p0, Lcom/comcast/cim/model/user/AuthKeys;->greetingName:Ljava/lang/String;

    .line 68
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "omnitureTrackingKey"

    iget-object v2, p0, Lcom/comcast/cim/model/user/AuthKeys;->omnitureTrackingKey:Ljava/lang/String;

    .line 69
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "flags"

    iget-object v2, p0, Lcom/comcast/cim/model/user/AuthKeys;->flags:Ljava/lang/String;

    .line 70
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    .line 71
    invoke-virtual {v0}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.class public Lcom/comcast/cim/microdata/model/NameValuePair;
.super Ljava/lang/Object;
.source "NameValuePair.java"


# instance fields
.field private final name:Ljava/lang/String;

.field private final value:Ljava/lang/String;


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/NameValuePair;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/NameValuePair;->value:Ljava/lang/String;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 33
    new-instance v0, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    invoke-direct {v0, p0}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;-><init>(Ljava/lang/Object;)V

    .line 34
    .local v0, "builder":Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;
    const-string v1, "name"

    iget-object v2, p0, Lcom/comcast/cim/microdata/model/NameValuePair;->name:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    .line 35
    const-string v1, "value"

    iget-object v2, p0, Lcom/comcast/cim/microdata/model/NameValuePair;->value:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    .line 36
    invoke-virtual {v0}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

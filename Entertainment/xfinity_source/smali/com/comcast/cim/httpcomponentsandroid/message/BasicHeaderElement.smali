.class public Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElement;
.super Ljava/lang/Object;
.source "BasicHeaderElement.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
.implements Ljava/lang/Cloneable;


# instance fields
.field private final name:Ljava/lang/String;

.field private final parameters:[Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;

.field private final value:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;[Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;
    .param p3, "parameters"    # [Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;

    .prologue
    .line 58
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 59
    if-nez p1, :cond_0

    .line 60
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Name may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 62
    :cond_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElement;->name:Ljava/lang/String;

    .line 63
    iput-object p2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElement;->value:Ljava/lang/String;

    .line 64
    if-eqz p3, :cond_1

    .line 65
    iput-object p3, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElement;->parameters:[Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;

    .line 69
    :goto_0
    return-void

    .line 67
    :cond_1
    const/4 v0, 0x0

    new-array v0, v0, [Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElement;->parameters:[Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;

    goto :goto_0
.end method


# virtual methods
.method public clone()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    .line 156
    invoke-super {p0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "object"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 118
    if-ne p0, p1, :cond_1

    .line 125
    :cond_0
    :goto_0
    return v1

    .line 119
    :cond_1
    instance-of v3, p1, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    if-eqz v3, :cond_3

    move-object v0, p1

    .line 120
    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElement;

    .line 121
    .local v0, "that":Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElement;
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElement;->name:Ljava/lang/String;

    iget-object v4, v0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElement;->name:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElement;->value:Ljava/lang/String;

    iget-object v4, v0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElement;->value:Ljava/lang/String;

    invoke-static {v3, v4}, Lcom/comcast/cim/httpcomponentsandroid/util/LangUtils;->equals(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElement;->parameters:[Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;

    iget-object v4, v0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElement;->parameters:[Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;

    invoke-static {v3, v4}, Lcom/comcast/cim/httpcomponentsandroid/util/LangUtils;->equals([Ljava/lang/Object;[Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    :cond_2
    move v1, v2

    goto :goto_0

    .end local v0    # "that":Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElement;
    :cond_3
    move v1, v2

    .line 125
    goto :goto_0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElement;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getParameterByName(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;
    .locals 5
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 103
    if-nez p1, :cond_0

    .line 104
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string v4, "Name may not be null"

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 106
    :cond_0
    const/4 v1, 0x0

    .line 107
    .local v1, "found":Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElement;->parameters:[Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;

    array-length v3, v3

    if-ge v2, v3, :cond_1

    .line 108
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElement;->parameters:[Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;

    aget-object v0, v3, v2

    .line 109
    .local v0, "current":Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 110
    move-object v1, v0

    .line 114
    .end local v0    # "current":Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;
    :cond_1
    return-object v1

    .line 107
    .restart local v0    # "current":Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;
    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method public getParameterCount()I
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElement;->parameters:[Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;

    array-length v0, v0

    return v0
.end method

.method public getParameters()[Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElement;->parameters:[Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;

    invoke-virtual {v0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;

    check-cast v0, [Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;

    return-object v0
.end method

.method public getValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElement;->value:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    .prologue
    .line 130
    const/16 v0, 0x11

    .line 131
    .local v0, "hash":I
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElement;->name:Ljava/lang/String;

    invoke-static {v0, v2}, Lcom/comcast/cim/httpcomponentsandroid/util/LangUtils;->hashCode(ILjava/lang/Object;)I

    move-result v0

    .line 132
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElement;->value:Ljava/lang/String;

    invoke-static {v0, v2}, Lcom/comcast/cim/httpcomponentsandroid/util/LangUtils;->hashCode(ILjava/lang/Object;)I

    move-result v0

    .line 133
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElement;->parameters:[Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;

    array-length v2, v2

    if-ge v1, v2, :cond_0

    .line 134
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElement;->parameters:[Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;

    aget-object v2, v2, v1

    invoke-static {v0, v2}, Lcom/comcast/cim/httpcomponentsandroid/util/LangUtils;->hashCode(ILjava/lang/Object;)I

    move-result v0

    .line 133
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 136
    :cond_0
    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 140
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    const/16 v2, 0x40

    invoke-direct {v0, v2}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;-><init>(I)V

    .line 141
    .local v0, "buffer":Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElement;->name:Ljava/lang/String;

    invoke-virtual {v0, v2}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 142
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElement;->value:Ljava/lang/String;

    if-eqz v2, :cond_0

    .line 143
    const-string v2, "="

    invoke-virtual {v0, v2}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 144
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElement;->value:Ljava/lang/String;

    invoke-virtual {v0, v2}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 146
    :cond_0
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElement;->parameters:[Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;

    array-length v2, v2

    if-ge v1, v2, :cond_1

    .line 147
    const-string v2, "; "

    invoke-virtual {v0, v2}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 148
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElement;->parameters:[Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;

    aget-object v2, v2, v1

    invoke-virtual {v0, v2}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/Object;)V

    .line 146
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 150
    :cond_1
    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

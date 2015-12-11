.class public final Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
.super Ljava/lang/Object;
.source "HttpHost.java"

# interfaces
.implements Ljava/io/Serializable;
.implements Ljava/lang/Cloneable;


# instance fields
.field protected final hostname:Ljava/lang/String;

.field protected final lcHostname:Ljava/lang/String;

.field protected final port:I

.field protected final schemeName:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;I)V
    .locals 1
    .param p1, "hostname"    # Ljava/lang/String;
    .param p2, "port"    # I

    .prologue
    .line 99
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    .line 100
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 2
    .param p1, "hostname"    # Ljava/lang/String;
    .param p2, "port"    # I
    .param p3, "scheme"    # Ljava/lang/String;

    .prologue
    .line 77
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 78
    if-nez p1, :cond_0

    .line 79
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Host name may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 81
    :cond_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->hostname:Ljava/lang/String;

    .line 82
    sget-object v0, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {p1, v0}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->lcHostname:Ljava/lang/String;

    .line 83
    if-eqz p3, :cond_1

    .line 84
    sget-object v0, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {p3, v0}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->schemeName:Ljava/lang/String;

    .line 88
    :goto_0
    iput p2, p0, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->port:I

    .line 89
    return-void

    .line 86
    :cond_1
    const-string v0, "http"

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->schemeName:Ljava/lang/String;

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
    .line 213
    invoke-super {p0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 190
    if-ne p0, p1, :cond_1

    .line 197
    :cond_0
    :goto_0
    return v1

    .line 191
    :cond_1
    instance-of v3, p1, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    if-eqz v3, :cond_3

    move-object v0, p1

    .line 192
    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    .line 193
    .local v0, "that":Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->lcHostname:Ljava/lang/String;

    iget-object v4, v0, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->lcHostname:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    iget v3, p0, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->port:I

    iget v4, v0, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->port:I

    if-ne v3, v4, :cond_2

    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->schemeName:Ljava/lang/String;

    iget-object v4, v0, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->schemeName:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    :cond_2
    move v1, v2

    goto :goto_0

    .end local v0    # "that":Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    :cond_3
    move v1, v2

    .line 197
    goto :goto_0
.end method

.method public getHostName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->hostname:Ljava/lang/String;

    return-object v0
.end method

.method public getPort()I
    .locals 1

    .prologue
    .line 135
    iget v0, p0, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->port:I

    return v0
.end method

.method public getSchemeName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 144
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->schemeName:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 2

    .prologue
    .line 205
    const/16 v0, 0x11

    .line 206
    .local v0, "hash":I
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->lcHostname:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/LangUtils;->hashCode(ILjava/lang/Object;)I

    move-result v0

    .line 207
    iget v1, p0, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->port:I

    invoke-static {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/LangUtils;->hashCode(II)I

    move-result v0

    .line 208
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->schemeName:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/LangUtils;->hashCode(ILjava/lang/Object;)I

    move-result v0

    .line 209
    return v0
.end method

.method public toHostString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 171
    iget v1, p0, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->port:I

    const/4 v2, -0x1

    if-eq v1, v2, :cond_0

    .line 173
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->hostname:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    add-int/lit8 v1, v1, 0x6

    invoke-direct {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;-><init>(I)V

    .line 174
    .local v0, "buffer":Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->hostname:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 175
    const-string v1, ":"

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 176
    iget v1, p0, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->port:I

    invoke-static {v1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 177
    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    .line 179
    .end local v0    # "buffer":Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    :goto_0
    return-object v1

    :cond_0
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->hostname:Ljava/lang/String;

    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 185
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->toURI()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public toURI()Ljava/lang/String;
    .locals 3

    .prologue
    .line 153
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    const/16 v1, 0x20

    invoke-direct {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;-><init>(I)V

    .line 154
    .local v0, "buffer":Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->schemeName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 155
    const-string v1, "://"

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 156
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->hostname:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 157
    iget v1, p0, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->port:I

    const/4 v2, -0x1

    if-eq v1, v2, :cond_0

    .line 158
    const/16 v1, 0x3a

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(C)V

    .line 159
    iget v1, p0, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->port:I

    invoke-static {v1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 161
    :cond_0
    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.class public Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
.super Ljava/lang/Object;
.source "ProtocolVersion.java"

# interfaces
.implements Ljava/io/Serializable;
.implements Ljava/lang/Cloneable;


# instance fields
.field protected final major:I

.field protected final minor:I

.field protected final protocol:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;II)V
    .locals 2
    .param p1, "protocol"    # Ljava/lang/String;
    .param p2, "major"    # I
    .param p3, "minor"    # I

    .prologue
    .line 67
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 68
    if-nez p1, :cond_0

    .line 69
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Protocol name must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 72
    :cond_0
    if-gez p2, :cond_1

    .line 73
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Protocol major version number must not be negative."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 76
    :cond_1
    if-gez p3, :cond_2

    .line 77
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Protocol minor version number may not be negative"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 80
    :cond_2
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->protocol:Ljava/lang/String;

    .line 81
    iput p2, p0, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->major:I

    .line 82
    iput p3, p0, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->minor:I

    .line 83
    return-void
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
    .line 273
    invoke-super {p0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public compareToVersion(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)I
    .locals 4
    .param p1, "that"    # Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    .prologue
    .line 209
    if-nez p1, :cond_0

    .line 210
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Protocol version must not be null."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 213
    :cond_0
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->protocol:Ljava/lang/String;

    iget-object v2, p1, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->protocol:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 214
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    const-string v3, "Versions for different protocols cannot be compared. "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    move-result-object v2

    const-string v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 219
    :cond_1
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->getMajor()I

    move-result v1

    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->getMajor()I

    move-result v2

    sub-int v0, v1, v2

    .line 220
    .local v0, "delta":I
    if-nez v0, :cond_2

    .line 221
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->getMinor()I

    move-result v1

    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->getMinor()I

    move-result v2

    sub-int v0, v1, v2

    .line 223
    :cond_2
    return v0
.end method

.method public final equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 163
    if-ne p0, p1, :cond_1

    .line 171
    :cond_0
    :goto_0
    return v1

    .line 166
    :cond_1
    instance-of v3, p1, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    if-nez v3, :cond_2

    move v1, v2

    .line 167
    goto :goto_0

    :cond_2
    move-object v0, p1

    .line 169
    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    .line 171
    .local v0, "that":Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->protocol:Ljava/lang/String;

    iget-object v4, v0, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->protocol:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    iget v3, p0, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->major:I

    iget v4, v0, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->major:I

    if-ne v3, v4, :cond_3

    iget v3, p0, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->minor:I

    iget v4, v0, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->minor:I

    if-eq v3, v4, :cond_0

    :cond_3
    move v1, v2

    goto :goto_0
.end method

.method public forVersion(II)Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    .locals 2
    .param p1, "major"    # I
    .param p2, "minor"    # I

    .prologue
    .line 130
    iget v0, p0, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->major:I

    if-ne p1, v0, :cond_0

    iget v0, p0, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->minor:I

    if-ne p2, v0, :cond_0

    .line 135
    .end local p0    # "this":Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    :goto_0
    return-object p0

    .restart local p0    # "this":Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    :cond_0
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->protocol:Ljava/lang/String;

    invoke-direct {v0, v1, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;-><init>(Ljava/lang/String;II)V

    move-object p0, v0

    goto :goto_0
.end method

.method public final getMajor()I
    .locals 1

    .prologue
    .line 100
    iget v0, p0, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->major:I

    return v0
.end method

.method public final getMinor()I
    .locals 1

    .prologue
    .line 109
    iget v0, p0, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->minor:I

    return v0
.end method

.method public final getProtocol()Ljava/lang/String;
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->protocol:Ljava/lang/String;

    return-object v0
.end method

.method public final hashCode()I
    .locals 3

    .prologue
    .line 145
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->protocol:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    iget v1, p0, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->major:I

    const v2, 0x186a0

    mul-int/2addr v1, v2

    xor-int/2addr v0, v1

    iget v1, p0, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->minor:I

    xor-int/2addr v0, v1

    return v0
.end method

.method public isComparable(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)Z
    .locals 2
    .param p1, "that"    # Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    .prologue
    .line 188
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->protocol:Ljava/lang/String;

    iget-object v1, p1, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->protocol:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final lessEquals(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)Z
    .locals 1
    .param p1, "version"    # Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    .prologue
    .line 253
    invoke-virtual {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->isComparable(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->compareToVersion(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)I

    move-result v0

    if-gtz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 263
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    const/16 v1, 0x10

    invoke-direct {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;-><init>(I)V

    .line 264
    .local v0, "buffer":Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->protocol:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 265
    const/16 v1, 0x2f

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(C)V

    .line 266
    iget v1, p0, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->major:I

    invoke-static {v1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 267
    const/16 v1, 0x2e

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(C)V

    .line 268
    iget v1, p0, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;->minor:I

    invoke-static {v1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 269
    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

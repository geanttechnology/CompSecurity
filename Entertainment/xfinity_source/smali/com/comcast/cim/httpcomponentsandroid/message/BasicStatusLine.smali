.class public Lcom/comcast/cim/httpcomponentsandroid/message/BasicStatusLine;
.super Ljava/lang/Object;
.source "BasicStatusLine.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/StatusLine;
.implements Ljava/io/Serializable;
.implements Ljava/lang/Cloneable;


# instance fields
.field private final protoVersion:Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

.field private final reasonPhrase:Ljava/lang/String;

.field private final statusCode:I


# direct methods
.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;ILjava/lang/String;)V
    .locals 2
    .param p1, "version"    # Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;

    .prologue
    .line 68
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 69
    if-nez p1, :cond_0

    .line 70
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Protocol version may not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 73
    :cond_0
    if-gez p2, :cond_1

    .line 74
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Status code may not be negative."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 77
    :cond_1
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicStatusLine;->protoVersion:Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    .line 78
    iput p2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicStatusLine;->statusCode:I

    .line 79
    iput-object p3, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicStatusLine;->reasonPhrase:Ljava/lang/String;

    .line 80
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
    .line 103
    invoke-super {p0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getProtocolVersion()Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    .locals 1

    .prologue
    .line 89
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicStatusLine;->protoVersion:Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    return-object v0
.end method

.method public getReasonPhrase()Ljava/lang/String;
    .locals 1

    .prologue
    .line 93
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicStatusLine;->reasonPhrase:Ljava/lang/String;

    return-object v0
.end method

.method public getStatusCode()I
    .locals 1

    .prologue
    .line 85
    iget v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicStatusLine;->statusCode:I

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 98
    sget-object v0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineFormatter;->DEFAULT:Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineFormatter;

    const/4 v1, 0x0

    invoke-virtual {v0, v1, p0}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineFormatter;->formatStatusLine(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/StatusLine;)Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.class public Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;
.super Ljava/lang/Object;
.source "BasicHeader.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/Header;
.implements Ljava/io/Serializable;
.implements Ljava/lang/Cloneable;


# instance fields
.field private final name:Ljava/lang/String;

.field private final value:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 55
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 56
    if-nez p1, :cond_0

    .line 57
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Name may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 59
    :cond_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;->name:Ljava/lang/String;

    .line 60
    iput-object p2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;->value:Ljava/lang/String;

    .line 61
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
    .line 86
    invoke-super {p0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getElements()[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/ParseException;
        }
    .end annotation

    .prologue
    .line 77
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;->value:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 79
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;->value:Ljava/lang/String;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderValueParser;->parseElements(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/message/HeaderValueParser;)[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    move-result-object v0

    .line 81
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    new-array v0, v0, [Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    goto :goto_0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;->value:Ljava/lang/String;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 73
    sget-object v0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineFormatter;->DEFAULT:Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineFormatter;

    const/4 v1, 0x0

    invoke-virtual {v0, v1, p0}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicLineFormatter;->formatHeader(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/Header;)Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

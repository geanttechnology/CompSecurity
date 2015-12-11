.class public final Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;
.super Ljava/lang/Object;
.source "Scheme.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# instance fields
.field private final defaultPort:I

.field private final layered:Z

.field private final name:Ljava/lang/String;

.field private final socketFactory:Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeSocketFactory;

.field private stringRep:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;ILcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeSocketFactory;)V
    .locals 3
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "port"    # I
    .param p3, "factory"    # Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeSocketFactory;

    .prologue
    .line 84
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 85
    if-nez p1, :cond_0

    .line 86
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Scheme name may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 88
    :cond_0
    if-lez p2, :cond_1

    const v0, 0xffff

    if-le p2, v0, :cond_2

    .line 89
    :cond_1
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Port is invalid: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 91
    :cond_2
    if-nez p3, :cond_3

    .line 92
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Socket factory may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 94
    :cond_3
    sget-object v0, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {p1, v0}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;->name:Ljava/lang/String;

    .line 95
    iput-object p3, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;->socketFactory:Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeSocketFactory;

    .line 96
    iput p2, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;->defaultPort:I

    .line 97
    instance-of v0, p3, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/LayeredSchemeSocketFactory;

    iput-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;->layered:Z

    .line 98
    return-void
.end method


# virtual methods
.method public final equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 240
    if-ne p0, p1, :cond_1

    .line 247
    :cond_0
    :goto_0
    return v1

    .line 241
    :cond_1
    instance-of v3, p1, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;

    if-eqz v3, :cond_3

    move-object v0, p1

    .line 242
    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;

    .line 243
    .local v0, "that":Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;->name:Ljava/lang/String;

    iget-object v4, v0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;->name:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    iget v3, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;->defaultPort:I

    iget v4, v0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;->defaultPort:I

    if-ne v3, v4, :cond_2

    iget-boolean v3, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;->layered:Z

    iget-boolean v4, v0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;->layered:Z

    if-eq v3, v4, :cond_0

    :cond_2
    move v1, v2

    goto :goto_0

    .end local v0    # "that":Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;
    :cond_3
    move v1, v2

    .line 247
    goto :goto_0
.end method

.method public final getDefaultPort()I
    .locals 1

    .prologue
    .line 149
    iget v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;->defaultPort:I

    return v0
.end method

.method public final getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 195
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;->name:Ljava/lang/String;

    return-object v0
.end method

.method public final getSchemeSocketFactory()Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeSocketFactory;
    .locals 1

    .prologue
    .line 186
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;->socketFactory:Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeSocketFactory;

    return-object v0
.end method

.method public final getSocketFactory()Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SocketFactory;
    .locals 2
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 164
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;->socketFactory:Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeSocketFactory;

    instance-of v0, v0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeSocketFactoryAdaptor;

    if-eqz v0, :cond_0

    .line 165
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;->socketFactory:Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeSocketFactory;

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeSocketFactoryAdaptor;

    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeSocketFactoryAdaptor;->getFactory()Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SocketFactory;

    move-result-object v0

    .line 171
    :goto_0
    return-object v0

    .line 167
    :cond_0
    iget-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;->layered:Z

    if-eqz v0, :cond_1

    .line 168
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/LayeredSocketFactoryAdaptor;

    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;->socketFactory:Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeSocketFactory;

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/LayeredSchemeSocketFactory;

    invoke-direct {v1, v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/LayeredSocketFactoryAdaptor;-><init>(Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/LayeredSchemeSocketFactory;)V

    move-object v0, v1

    goto :goto_0

    .line 171
    :cond_1
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SocketFactoryAdaptor;

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;->socketFactory:Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeSocketFactory;

    invoke-direct {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SocketFactoryAdaptor;-><init>(Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeSocketFactory;)V

    goto :goto_0
.end method

.method public hashCode()I
    .locals 2

    .prologue
    .line 253
    const/16 v0, 0x11

    .line 254
    .local v0, "hash":I
    iget v1, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;->defaultPort:I

    invoke-static {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/LangUtils;->hashCode(II)I

    move-result v0

    .line 255
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;->name:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/LangUtils;->hashCode(ILjava/lang/Object;)I

    move-result v0

    .line 256
    iget-boolean v1, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;->layered:Z

    invoke-static {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/LangUtils;->hashCode(IZ)I

    move-result v0

    .line 257
    return v0
.end method

.method public final isLayered()Z
    .locals 1

    .prologue
    .line 205
    iget-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;->layered:Z

    return v0
.end method

.method public final resolvePort(I)I
    .locals 0
    .param p1, "port"    # I

    .prologue
    .line 218
    if-gtz p1, :cond_0

    iget p1, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;->defaultPort:I

    .end local p1    # "port":I
    :cond_0
    return p1
.end method

.method public final toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 228
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;->stringRep:Ljava/lang/String;

    if-nez v1, :cond_0

    .line 229
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 230
    .local v0, "buffer":Ljava/lang/StringBuilder;
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;->name:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 231
    const/16 v1, 0x3a

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 232
    iget v1, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;->defaultPort:I

    invoke-static {v1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 233
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;->stringRep:Ljava/lang/String;

    .line 235
    .end local v0    # "buffer":Ljava/lang/StringBuilder;
    :cond_0
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;->stringRep:Ljava/lang/String;

    return-object v1
.end method

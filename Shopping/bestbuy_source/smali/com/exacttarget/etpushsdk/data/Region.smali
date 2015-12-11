.class public Lcom/exacttarget/etpushsdk/data/Region;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private a:Ljava/lang/Integer;

.field private b:Ljava/lang/String;

.field private c:Ljava/lang/String;

.field private d:Lcom/exacttarget/etpushsdk/util/l;

.field private e:Ljava/lang/Double;

.field private f:Ljava/lang/Double;

.field private g:Ljava/lang/Integer;

.field private h:Ljava/util/List;

.field private i:Ljava/lang/Boolean;

.field private j:Ljava/lang/String;

.field private k:Ljava/lang/Integer;

.field private l:Ljava/lang/Integer;

.field private m:Ljava/lang/Integer;

.field private n:Ljava/lang/Integer;

.field private o:Ljava/lang/String;

.field private p:Ljava/lang/Boolean;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 56
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/Region;->a:Ljava/lang/Integer;

    .line 68
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/Region;->m:Ljava/lang/Integer;

    .line 69
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/Region;->n:Ljava/lang/Integer;

    .line 71
    sget-object v0, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/Region;->p:Ljava/lang/Boolean;

    return-void
.end method


# virtual methods
.method public a()Lahs;
    .locals 7

    .prologue
    .line 216
    const-string v0, "~~m@g1c_f3nc3~~"

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/data/Region;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 218
    const/4 v0, 0x2

    .line 223
    :goto_0
    new-instance v1, Laht;

    invoke-direct {v1}, Laht;-><init>()V

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/data/Region;->b:Ljava/lang/String;

    invoke-virtual {v1, v2}, Laht;->a(Ljava/lang/String;)Laht;

    move-result-object v1

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/data/Region;->e:Ljava/lang/Double;

    invoke-virtual {v2}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v2

    iget-object v4, p0, Lcom/exacttarget/etpushsdk/data/Region;->f:Ljava/lang/Double;

    invoke-virtual {v4}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v4

    iget-object v6, p0, Lcom/exacttarget/etpushsdk/data/Region;->g:Ljava/lang/Integer;

    invoke-virtual {v6}, Ljava/lang/Integer;->intValue()I

    move-result v6

    int-to-float v6, v6

    invoke-virtual/range {v1 .. v6}, Laht;->a(DDF)Laht;

    move-result-object v1

    invoke-virtual {v1, v0}, Laht;->a(I)Laht;

    move-result-object v0

    const-wide/16 v2, -0x1

    invoke-virtual {v0, v2, v3}, Laht;->a(J)Laht;

    move-result-object v0

    invoke-virtual {v0}, Laht;->a()Lahs;

    move-result-object v0

    return-object v0

    .line 221
    :cond_0
    const/4 v0, 0x3

    goto :goto_0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 2

    .prologue
    .line 233
    instance-of v0, p1, Lcom/exacttarget/etpushsdk/data/Region;

    if-eqz v0, :cond_1

    .line 234
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Region;->b:Ljava/lang/String;

    if-nez v0, :cond_0

    move-object v0, p1

    check-cast v0, Lcom/exacttarget/etpushsdk/data/Region;

    iget-object v0, v0, Lcom/exacttarget/etpushsdk/data/Region;->b:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 235
    const/4 v0, 0x1

    .line 240
    :goto_0
    return v0

    .line 236
    :cond_0
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Region;->b:Ljava/lang/String;

    if-eqz v0, :cond_1

    .line 237
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Region;->b:Ljava/lang/String;

    check-cast p1, Lcom/exacttarget/etpushsdk/data/Region;

    iget-object v1, p1, Lcom/exacttarget/etpushsdk/data/Region;->b:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    goto :goto_0

    .line 240
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getActive()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 144
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Region;->i:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getCenter()Lcom/exacttarget/etpushsdk/util/l;
    .locals 1

    .prologue
    .line 102
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Region;->d:Lcom/exacttarget/etpushsdk/util/l;

    return-object v0
.end method

.method public getDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 192
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Region;->o:Ljava/lang/String;

    return-object v0
.end method

.method public getEntryCount()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 176
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Region;->m:Ljava/lang/Integer;

    return-object v0
.end method

.method public getExitCount()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 184
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Region;->n:Ljava/lang/Integer;

    return-object v0
.end method

.method public getGuid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 152
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Region;->j:Ljava/lang/String;

    return-object v0
.end method

.method public getHasEntered()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 200
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Region;->p:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Region;->b:Ljava/lang/String;

    return-object v0
.end method

.method public getLatitude()Ljava/lang/Double;
    .locals 1

    .prologue
    .line 112
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Region;->e:Ljava/lang/Double;

    return-object v0
.end method

.method public getLocationType()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Region;->a:Ljava/lang/Integer;

    if-nez v0, :cond_0

    .line 91
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/Region;->a:Ljava/lang/Integer;

    .line 93
    :cond_0
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Region;->a:Ljava/lang/Integer;

    return-object v0
.end method

.method public getLongitude()Ljava/lang/Double;
    .locals 1

    .prologue
    .line 120
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Region;->f:Ljava/lang/Double;

    return-object v0
.end method

.method public getMajor()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 160
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Region;->k:Ljava/lang/Integer;

    return-object v0
.end method

.method public getMessages()Ljava/util/List;
    .locals 1

    .prologue
    .line 136
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Region;->h:Ljava/util/List;

    return-object v0
.end method

.method public getMinor()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 168
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Region;->l:Ljava/lang/Integer;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Region;->c:Ljava/lang/String;

    return-object v0
.end method

.method public getRadius()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 128
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Region;->g:Ljava/lang/Integer;

    return-object v0
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 245
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Region;->b:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    return v0
.end method

.method public setActive(Ljava/lang/Boolean;)V
    .locals 0

    .prologue
    .line 148
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Region;->i:Ljava/lang/Boolean;

    .line 149
    return-void
.end method

.method public setCenter(Lcom/exacttarget/etpushsdk/util/l;)V
    .locals 1

    .prologue
    .line 106
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Region;->d:Lcom/exacttarget/etpushsdk/util/l;

    .line 107
    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/util/l;->a()Ljava/lang/Double;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/exacttarget/etpushsdk/data/Region;->setLatitude(Ljava/lang/Double;)V

    .line 108
    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/util/l;->b()Ljava/lang/Double;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/exacttarget/etpushsdk/data/Region;->setLongitude(Ljava/lang/Double;)V

    .line 109
    return-void
.end method

.method public setDescription(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 196
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Region;->o:Ljava/lang/String;

    .line 197
    return-void
.end method

.method public setEntryCount(Ljava/lang/Integer;)V
    .locals 0

    .prologue
    .line 180
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Region;->m:Ljava/lang/Integer;

    .line 181
    return-void
.end method

.method public setExitCount(Ljava/lang/Integer;)V
    .locals 0

    .prologue
    .line 188
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Region;->n:Ljava/lang/Integer;

    .line 189
    return-void
.end method

.method public setGuid(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 156
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Region;->j:Ljava/lang/String;

    .line 157
    return-void
.end method

.method public setHasEntered(Ljava/lang/Boolean;)V
    .locals 0

    .prologue
    .line 204
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Region;->p:Ljava/lang/Boolean;

    .line 205
    return-void
.end method

.method public setId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 78
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Region;->b:Ljava/lang/String;

    .line 79
    return-void
.end method

.method public setLatitude(Ljava/lang/Double;)V
    .locals 0

    .prologue
    .line 116
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Region;->e:Ljava/lang/Double;

    .line 117
    return-void
.end method

.method public setLocationType(Ljava/lang/Integer;)V
    .locals 0

    .prologue
    .line 97
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Region;->a:Ljava/lang/Integer;

    .line 98
    return-void
.end method

.method public setLongitude(Ljava/lang/Double;)V
    .locals 0

    .prologue
    .line 124
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Region;->f:Ljava/lang/Double;

    .line 125
    return-void
.end method

.method public setMajor(Ljava/lang/Integer;)V
    .locals 0

    .prologue
    .line 164
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Region;->k:Ljava/lang/Integer;

    .line 165
    return-void
.end method

.method public setMessages(Ljava/util/List;)V
    .locals 0

    .prologue
    .line 140
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Region;->h:Ljava/util/List;

    .line 141
    return-void
.end method

.method public setMinor(Ljava/lang/Integer;)V
    .locals 0

    .prologue
    .line 172
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Region;->l:Ljava/lang/Integer;

    .line 173
    return-void
.end method

.method public setName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 86
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Region;->c:Ljava/lang/String;

    .line 87
    return-void
.end method

.method public setRadius(Ljava/lang/Integer;)V
    .locals 0

    .prologue
    .line 132
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Region;->g:Ljava/lang/Integer;

    .line 133
    return-void
.end method

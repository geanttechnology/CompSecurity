.class public final Ltwitter4j/OEmbedRequest;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = -0x3c1968462120d9abL


# instance fields
.field private align:Ltwitter4j/OEmbedRequest$Align;

.field private hideMedia:Z

.field private hideThread:Z

.field private lang:Ljava/lang/String;

.field private maxWidth:I

.field private omitScript:Z

.field private related:[Ljava/lang/String;

.field private final statusId:J

.field private final url:Ljava/lang/String;


# direct methods
.method public constructor <init>(JLjava/lang/String;)V
    .locals 3

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 42
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    iput-boolean v0, p0, Ltwitter4j/OEmbedRequest;->hideMedia:Z

    .line 36
    iput-boolean v0, p0, Ltwitter4j/OEmbedRequest;->hideThread:Z

    .line 37
    iput-boolean v1, p0, Ltwitter4j/OEmbedRequest;->omitScript:Z

    .line 38
    sget-object v0, Ltwitter4j/OEmbedRequest$Align;->NONE:Ltwitter4j/OEmbedRequest$Align;

    iput-object v0, p0, Ltwitter4j/OEmbedRequest;->align:Ltwitter4j/OEmbedRequest$Align;

    .line 39
    new-array v0, v1, [Ljava/lang/String;

    iput-object v0, p0, Ltwitter4j/OEmbedRequest;->related:[Ljava/lang/String;

    .line 43
    iput-wide p1, p0, Ltwitter4j/OEmbedRequest;->statusId:J

    .line 44
    iput-object p3, p0, Ltwitter4j/OEmbedRequest;->url:Ljava/lang/String;

    .line 45
    return-void
.end method

.method private appendParameter(Ljava/lang/String;JLjava/util/List;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "J",
            "Ljava/util/List",
            "<",
            "Ltwitter4j/internal/http/HttpParameter;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 141
    const-wide/16 v0, 0x0

    cmp-long v0, v0, p2

    if-gtz v0, :cond_0

    .line 142
    new-instance v0, Ltwitter4j/internal/http/HttpParameter;

    invoke-static {p2, p3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, p1, v1}, Ltwitter4j/internal/http/HttpParameter;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {p4, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 144
    :cond_0
    return-void
.end method

.method private appendParameter(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ltwitter4j/internal/http/HttpParameter;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 135
    if-eqz p2, :cond_0

    .line 136
    new-instance v0, Ltwitter4j/internal/http/HttpParameter;

    invoke-direct {v0, p1, p2}, Ltwitter4j/internal/http/HttpParameter;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {p3, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 138
    :cond_0
    return-void
.end method


# virtual methods
.method public final HideMedia(Z)Ltwitter4j/OEmbedRequest;
    .locals 0

    .prologue
    .line 61
    iput-boolean p1, p0, Ltwitter4j/OEmbedRequest;->hideMedia:Z

    .line 62
    return-object p0
.end method

.method public final HideThread(Z)Ltwitter4j/OEmbedRequest;
    .locals 0

    .prologue
    .line 70
    iput-boolean p1, p0, Ltwitter4j/OEmbedRequest;->hideThread:Z

    .line 71
    return-object p0
.end method

.method public final MaxWidth(I)Ltwitter4j/OEmbedRequest;
    .locals 0

    .prologue
    .line 52
    iput p1, p0, Ltwitter4j/OEmbedRequest;->maxWidth:I

    .line 53
    return-object p0
.end method

.method public final align(Ltwitter4j/OEmbedRequest$Align;)Ltwitter4j/OEmbedRequest;
    .locals 0

    .prologue
    .line 88
    iput-object p1, p0, Ltwitter4j/OEmbedRequest;->align:Ltwitter4j/OEmbedRequest$Align;

    .line 89
    return-object p0
.end method

.method final asHttpParameterArray()[Ltwitter4j/internal/http/HttpParameter;
    .locals 4

    .prologue
    .line 118
    new-instance v0, Ljava/util/ArrayList;

    const/16 v1, 0xc

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    .line 119
    const-string v1, "id"

    iget-wide v2, p0, Ltwitter4j/OEmbedRequest;->statusId:J

    invoke-direct {p0, v1, v2, v3, v0}, Ltwitter4j/OEmbedRequest;->appendParameter(Ljava/lang/String;JLjava/util/List;)V

    .line 120
    const-string v1, "url"

    iget-object v2, p0, Ltwitter4j/OEmbedRequest;->url:Ljava/lang/String;

    invoke-direct {p0, v1, v2, v0}, Ltwitter4j/OEmbedRequest;->appendParameter(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V

    .line 121
    const-string v1, "maxwidth"

    iget v2, p0, Ltwitter4j/OEmbedRequest;->maxWidth:I

    int-to-long v2, v2

    invoke-direct {p0, v1, v2, v3, v0}, Ltwitter4j/OEmbedRequest;->appendParameter(Ljava/lang/String;JLjava/util/List;)V

    .line 122
    new-instance v1, Ltwitter4j/internal/http/HttpParameter;

    const-string v2, "hide_media"

    iget-boolean v3, p0, Ltwitter4j/OEmbedRequest;->hideMedia:Z

    invoke-direct {v1, v2, v3}, Ltwitter4j/internal/http/HttpParameter;-><init>(Ljava/lang/String;Z)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 123
    new-instance v1, Ltwitter4j/internal/http/HttpParameter;

    const-string v2, "hide_thread"

    iget-boolean v3, p0, Ltwitter4j/OEmbedRequest;->hideThread:Z

    invoke-direct {v1, v2, v3}, Ltwitter4j/internal/http/HttpParameter;-><init>(Ljava/lang/String;Z)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 124
    new-instance v1, Ltwitter4j/internal/http/HttpParameter;

    const-string v2, "omit_script"

    iget-boolean v3, p0, Ltwitter4j/OEmbedRequest;->omitScript:Z

    invoke-direct {v1, v2, v3}, Ltwitter4j/internal/http/HttpParameter;-><init>(Ljava/lang/String;Z)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 125
    new-instance v1, Ltwitter4j/internal/http/HttpParameter;

    const-string v2, "align"

    iget-object v3, p0, Ltwitter4j/OEmbedRequest;->align:Ltwitter4j/OEmbedRequest$Align;

    invoke-virtual {v3}, Ltwitter4j/OEmbedRequest$Align;->name()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Ltwitter4j/internal/http/HttpParameter;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 126
    iget-object v1, p0, Ltwitter4j/OEmbedRequest;->related:[Ljava/lang/String;

    array-length v1, v1

    if-lez v1, :cond_0

    .line 127
    const-string v1, "related"

    iget-object v2, p0, Ltwitter4j/OEmbedRequest;->related:[Ljava/lang/String;

    invoke-static {v2}, Ltwitter4j/internal/util/z_T4JInternalStringUtil;->join([Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v1, v2, v0}, Ltwitter4j/OEmbedRequest;->appendParameter(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V

    .line 129
    :cond_0
    const-string v1, "lang"

    iget-object v2, p0, Ltwitter4j/OEmbedRequest;->lang:Ljava/lang/String;

    invoke-direct {p0, v1, v2, v0}, Ltwitter4j/OEmbedRequest;->appendParameter(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V

    .line 130
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v1

    new-array v1, v1, [Ltwitter4j/internal/http/HttpParameter;

    .line 131
    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ltwitter4j/internal/http/HttpParameter;

    return-object v0
.end method

.method public final equals(Ljava/lang/Object;)Z
    .locals 6

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 148
    if-ne p0, p1, :cond_1

    .line 163
    :cond_0
    :goto_0
    return v0

    .line 149
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    if-eq v2, v3, :cond_3

    :cond_2
    move v0, v1

    goto :goto_0

    .line 151
    :cond_3
    check-cast p1, Ltwitter4j/OEmbedRequest;

    .line 153
    iget-boolean v2, p0, Ltwitter4j/OEmbedRequest;->hideMedia:Z

    iget-boolean v3, p1, Ltwitter4j/OEmbedRequest;->hideMedia:Z

    if-eq v2, v3, :cond_4

    move v0, v1

    goto :goto_0

    .line 154
    :cond_4
    iget-boolean v2, p0, Ltwitter4j/OEmbedRequest;->hideThread:Z

    iget-boolean v3, p1, Ltwitter4j/OEmbedRequest;->hideThread:Z

    if-eq v2, v3, :cond_5

    move v0, v1

    goto :goto_0

    .line 155
    :cond_5
    iget v2, p0, Ltwitter4j/OEmbedRequest;->maxWidth:I

    iget v3, p1, Ltwitter4j/OEmbedRequest;->maxWidth:I

    if-eq v2, v3, :cond_6

    move v0, v1

    goto :goto_0

    .line 156
    :cond_6
    iget-boolean v2, p0, Ltwitter4j/OEmbedRequest;->omitScript:Z

    iget-boolean v3, p1, Ltwitter4j/OEmbedRequest;->omitScript:Z

    if-eq v2, v3, :cond_7

    move v0, v1

    goto :goto_0

    .line 157
    :cond_7
    iget-wide v2, p0, Ltwitter4j/OEmbedRequest;->statusId:J

    iget-wide v4, p1, Ltwitter4j/OEmbedRequest;->statusId:J

    cmp-long v2, v2, v4

    if-eqz v2, :cond_8

    move v0, v1

    goto :goto_0

    .line 158
    :cond_8
    iget-object v2, p0, Ltwitter4j/OEmbedRequest;->align:Ltwitter4j/OEmbedRequest$Align;

    iget-object v3, p1, Ltwitter4j/OEmbedRequest;->align:Ltwitter4j/OEmbedRequest$Align;

    if-eq v2, v3, :cond_9

    move v0, v1

    goto :goto_0

    .line 159
    :cond_9
    iget-object v2, p0, Ltwitter4j/OEmbedRequest;->lang:Ljava/lang/String;

    if-eqz v2, :cond_b

    iget-object v2, p0, Ltwitter4j/OEmbedRequest;->lang:Ljava/lang/String;

    iget-object v3, p1, Ltwitter4j/OEmbedRequest;->lang:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_c

    :cond_a
    move v0, v1

    goto :goto_0

    :cond_b
    iget-object v2, p1, Ltwitter4j/OEmbedRequest;->lang:Ljava/lang/String;

    if-nez v2, :cond_a

    .line 160
    :cond_c
    iget-object v2, p0, Ltwitter4j/OEmbedRequest;->related:[Ljava/lang/String;

    iget-object v3, p1, Ltwitter4j/OEmbedRequest;->related:[Ljava/lang/String;

    invoke-static {v2, v3}, Ljava/util/Arrays;->equals([Ljava/lang/Object;[Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_d

    move v0, v1

    goto :goto_0

    .line 161
    :cond_d
    iget-object v2, p0, Ltwitter4j/OEmbedRequest;->url:Ljava/lang/String;

    if-eqz v2, :cond_e

    iget-object v2, p0, Ltwitter4j/OEmbedRequest;->url:Ljava/lang/String;

    iget-object v3, p1, Ltwitter4j/OEmbedRequest;->url:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    :goto_1
    move v0, v1

    goto :goto_0

    :cond_e
    iget-object v2, p1, Ltwitter4j/OEmbedRequest;->url:Ljava/lang/String;

    if-eqz v2, :cond_0

    goto :goto_1
.end method

.method public final hashCode()I
    .locals 8

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 168
    iget-wide v4, p0, Ltwitter4j/OEmbedRequest;->statusId:J

    iget-wide v6, p0, Ltwitter4j/OEmbedRequest;->statusId:J

    const/16 v0, 0x20

    ushr-long/2addr v6, v0

    xor-long/2addr v4, v6

    long-to-int v0, v4

    .line 169
    mul-int/lit8 v3, v0, 0x1f

    iget-object v0, p0, Ltwitter4j/OEmbedRequest;->url:Ljava/lang/String;

    if-eqz v0, :cond_1

    iget-object v0, p0, Ltwitter4j/OEmbedRequest;->url:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    :goto_0
    add-int/2addr v0, v3

    .line 170
    mul-int/lit8 v0, v0, 0x1f

    iget v3, p0, Ltwitter4j/OEmbedRequest;->maxWidth:I

    add-int/2addr v0, v3

    .line 171
    mul-int/lit8 v3, v0, 0x1f

    iget-boolean v0, p0, Ltwitter4j/OEmbedRequest;->hideMedia:Z

    if-eqz v0, :cond_2

    move v0, v2

    :goto_1
    add-int/2addr v0, v3

    .line 172
    mul-int/lit8 v3, v0, 0x1f

    iget-boolean v0, p0, Ltwitter4j/OEmbedRequest;->hideThread:Z

    if-eqz v0, :cond_3

    move v0, v2

    :goto_2
    add-int/2addr v0, v3

    .line 173
    mul-int/lit8 v0, v0, 0x1f

    iget-boolean v3, p0, Ltwitter4j/OEmbedRequest;->omitScript:Z

    if-eqz v3, :cond_4

    :goto_3
    add-int/2addr v0, v2

    .line 174
    mul-int/lit8 v2, v0, 0x1f

    iget-object v0, p0, Ltwitter4j/OEmbedRequest;->align:Ltwitter4j/OEmbedRequest$Align;

    if-eqz v0, :cond_5

    iget-object v0, p0, Ltwitter4j/OEmbedRequest;->align:Ltwitter4j/OEmbedRequest$Align;

    invoke-virtual {v0}, Ltwitter4j/OEmbedRequest$Align;->hashCode()I

    move-result v0

    :goto_4
    add-int/2addr v0, v2

    .line 175
    mul-int/lit8 v2, v0, 0x1f

    iget-object v0, p0, Ltwitter4j/OEmbedRequest;->related:[Ljava/lang/String;

    if-eqz v0, :cond_6

    iget-object v0, p0, Ltwitter4j/OEmbedRequest;->related:[Ljava/lang/String;

    invoke-static {v0}, Ljava/util/Arrays;->hashCode([Ljava/lang/Object;)I

    move-result v0

    :goto_5
    add-int/2addr v0, v2

    .line 176
    mul-int/lit8 v0, v0, 0x1f

    iget-object v2, p0, Ltwitter4j/OEmbedRequest;->lang:Ljava/lang/String;

    if-eqz v2, :cond_0

    iget-object v1, p0, Ltwitter4j/OEmbedRequest;->lang:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    :cond_0
    add-int/2addr v0, v1

    .line 177
    return v0

    :cond_1
    move v0, v1

    .line 169
    goto :goto_0

    :cond_2
    move v0, v1

    .line 171
    goto :goto_1

    :cond_3
    move v0, v1

    .line 172
    goto :goto_2

    :cond_4
    move v2, v1

    .line 173
    goto :goto_3

    :cond_5
    move v0, v1

    .line 174
    goto :goto_4

    :cond_6
    move v0, v1

    .line 175
    goto :goto_5
.end method

.method public final lang(Ljava/lang/String;)Ltwitter4j/OEmbedRequest;
    .locals 0

    .prologue
    .line 106
    iput-object p1, p0, Ltwitter4j/OEmbedRequest;->lang:Ljava/lang/String;

    .line 107
    return-object p0
.end method

.method public final omitScript(Z)Ltwitter4j/OEmbedRequest;
    .locals 0

    .prologue
    .line 79
    iput-boolean p1, p0, Ltwitter4j/OEmbedRequest;->omitScript:Z

    .line 80
    return-object p0
.end method

.method public final related([Ljava/lang/String;)Ltwitter4j/OEmbedRequest;
    .locals 0

    .prologue
    .line 97
    iput-object p1, p0, Ltwitter4j/OEmbedRequest;->related:[Ljava/lang/String;

    .line 98
    return-object p0
.end method

.method public final setAlign(Ltwitter4j/OEmbedRequest$Align;)V
    .locals 0

    .prologue
    .line 84
    iput-object p1, p0, Ltwitter4j/OEmbedRequest;->align:Ltwitter4j/OEmbedRequest$Align;

    .line 85
    return-void
.end method

.method public final setHideMedia(Z)V
    .locals 0

    .prologue
    .line 57
    iput-boolean p1, p0, Ltwitter4j/OEmbedRequest;->hideMedia:Z

    .line 58
    return-void
.end method

.method public final setHideThread(Z)V
    .locals 0

    .prologue
    .line 66
    iput-boolean p1, p0, Ltwitter4j/OEmbedRequest;->hideThread:Z

    .line 67
    return-void
.end method

.method public final setLang(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 102
    iput-object p1, p0, Ltwitter4j/OEmbedRequest;->lang:Ljava/lang/String;

    .line 103
    return-void
.end method

.method public final setMaxWidth(I)V
    .locals 0

    .prologue
    .line 48
    iput p1, p0, Ltwitter4j/OEmbedRequest;->maxWidth:I

    .line 49
    return-void
.end method

.method public final setOmitScript(Z)V
    .locals 0

    .prologue
    .line 75
    iput-boolean p1, p0, Ltwitter4j/OEmbedRequest;->omitScript:Z

    .line 76
    return-void
.end method

.method public final setRelated([Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 93
    iput-object p1, p0, Ltwitter4j/OEmbedRequest;->related:[Ljava/lang/String;

    .line 94
    return-void
.end method

.method public final toString()Ljava/lang/String;
    .locals 5

    .prologue
    const/16 v4, 0x27

    .line 182
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "OEmbedRequest{statusId="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-wide v2, p0, Ltwitter4j/OEmbedRequest;->statusId:J

    invoke-virtual {v0, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", url=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Ltwitter4j/OEmbedRequest;->url:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", maxWidth="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Ltwitter4j/OEmbedRequest;->maxWidth:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", hideMedia="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Ltwitter4j/OEmbedRequest;->hideMedia:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", hideThread="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Ltwitter4j/OEmbedRequest;->hideThread:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", omitScript="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Ltwitter4j/OEmbedRequest;->omitScript:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", align="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Ltwitter4j/OEmbedRequest;->align:Ltwitter4j/OEmbedRequest$Align;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", related="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v0, p0, Ltwitter4j/OEmbedRequest;->related:[Ljava/lang/String;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", lang=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Ltwitter4j/OEmbedRequest;->lang:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0x7d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_0
    iget-object v0, p0, Ltwitter4j/OEmbedRequest;->related:[Ljava/lang/String;

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    goto :goto_0
.end method

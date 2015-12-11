.class public final Lb/a/a/b/v;
.super Lb/a/a/b/a;
.source "SourceFile"


# direct methods
.method private constructor <init>(Lb/a/a/a;Lb/a/a/i;)V
    .locals 0

    .prologue
    .line 81
    invoke-direct {p0, p1, p2}, Lb/a/a/b/a;-><init>(Lb/a/a/a;Ljava/lang/Object;)V

    .line 82
    return-void
.end method

.method public static a(Lb/a/a/a;Lb/a/a/i;)Lb/a/a/b/v;
    .locals 2

    .prologue
    .line 55
    if-nez p0, :cond_0

    .line 56
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Must supply a chronology"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 58
    :cond_0
    invoke-virtual {p0}, Lb/a/a/a;->b()Lb/a/a/a;

    move-result-object v0

    .line 59
    if-nez v0, :cond_1

    .line 60
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "UTC chronology must not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 62
    :cond_1
    if-nez p1, :cond_2

    .line 63
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "DateTimeZone must not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 65
    :cond_2
    new-instance v1, Lb/a/a/b/v;

    invoke-direct {v1, v0, p1}, Lb/a/a/b/v;-><init>(Lb/a/a/a;Lb/a/a/i;)V

    return-object v1
.end method

.method private a(Lb/a/a/c;Ljava/util/HashMap;)Lb/a/a/c;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lb/a/a/c;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Object;",
            "Ljava/lang/Object;",
            ">;)",
            "Lb/a/a/c;"
        }
    .end annotation

    .prologue
    .line 209
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lb/a/a/c;->c()Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    move-object v0, p1

    .line 221
    :goto_0
    return-object v0

    .line 212
    :cond_1
    invoke-virtual {p2, p1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 213
    invoke-virtual {p2, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lb/a/a/c;

    goto :goto_0

    .line 215
    :cond_2
    new-instance v0, Lb/a/a/b/w;

    iget-object v2, p0, Lb/a/a/b/a;->b:Ljava/lang/Object;

    check-cast v2, Lb/a/a/i;

    invoke-virtual {p1}, Lb/a/a/c;->d()Lb/a/a/l;

    move-result-object v1

    invoke-direct {p0, v1, p2}, Lb/a/a/b/v;->a(Lb/a/a/l;Ljava/util/HashMap;)Lb/a/a/l;

    move-result-object v3

    invoke-virtual {p1}, Lb/a/a/c;->e()Lb/a/a/l;

    move-result-object v1

    invoke-direct {p0, v1, p2}, Lb/a/a/b/v;->a(Lb/a/a/l;Ljava/util/HashMap;)Lb/a/a/l;

    move-result-object v4

    invoke-virtual {p1}, Lb/a/a/c;->f()Lb/a/a/l;

    move-result-object v1

    invoke-direct {p0, v1, p2}, Lb/a/a/b/v;->a(Lb/a/a/l;Ljava/util/HashMap;)Lb/a/a/l;

    move-result-object v5

    move-object v1, p1

    invoke-direct/range {v0 .. v5}, Lb/a/a/b/w;-><init>(Lb/a/a/c;Lb/a/a/i;Lb/a/a/l;Lb/a/a/l;Lb/a/a/l;)V

    .line 220
    invoke-virtual {p2, p1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method private a(Lb/a/a/l;Ljava/util/HashMap;)Lb/a/a/l;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lb/a/a/l;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Object;",
            "Ljava/lang/Object;",
            ">;)",
            "Lb/a/a/l;"
        }
    .end annotation

    .prologue
    .line 197
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lb/a/a/l;->b()Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    move-object v0, p1

    .line 205
    :goto_0
    return-object v0

    .line 200
    :cond_1
    invoke-virtual {p2, p1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 201
    invoke-virtual {p2, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lb/a/a/l;

    goto :goto_0

    .line 203
    :cond_2
    new-instance v1, Lb/a/a/b/x;

    iget-object v0, p0, Lb/a/a/b/a;->b:Ljava/lang/Object;

    check-cast v0, Lb/a/a/i;

    invoke-direct {v1, p1, v0}, Lb/a/a/b/x;-><init>(Lb/a/a/l;Lb/a/a/i;)V

    .line 204
    invoke-virtual {p2, p1, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-object v0, v1

    .line 205
    goto :goto_0
.end method

.method static a(Lb/a/a/l;)Z
    .locals 4

    .prologue
    .line 71
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Lb/a/a/l;->d()J

    move-result-wide v0

    const-wide/32 v2, 0x2932e00

    cmp-long v0, v0, v2

    if-gez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public final a(Lb/a/a/i;)Lb/a/a/a;
    .locals 2

    .prologue
    .line 93
    if-nez p1, :cond_0

    .line 94
    invoke-static {}, Lb/a/a/i;->a()Lb/a/a/i;

    move-result-object p1

    .line 96
    :cond_0
    iget-object v0, p0, Lb/a/a/b/a;->b:Ljava/lang/Object;

    if-ne p1, v0, :cond_1

    .line 102
    :goto_0
    return-object p0

    .line 99
    :cond_1
    sget-object v0, Lb/a/a/i;->a:Lb/a/a/i;

    if-ne p1, v0, :cond_2

    .line 100
    iget-object p0, p0, Lb/a/a/b/a;->a:Lb/a/a/a;

    goto :goto_0

    .line 102
    :cond_2
    new-instance v0, Lb/a/a/b/v;

    iget-object v1, p0, Lb/a/a/b/a;->a:Lb/a/a/a;

    invoke-direct {v0, v1, p1}, Lb/a/a/b/v;-><init>(Lb/a/a/a;Lb/a/a/i;)V

    move-object p0, v0

    goto :goto_0
.end method

.method public final a()Lb/a/a/i;
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lb/a/a/b/a;->b:Ljava/lang/Object;

    check-cast v0, Lb/a/a/i;

    return-object v0
.end method

.method protected final a(Lb/a/a/b/b;)V
    .locals 2

    .prologue
    .line 150
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 154
    iget-object v1, p1, Lb/a/a/b/b;->l:Lb/a/a/l;

    invoke-direct {p0, v1, v0}, Lb/a/a/b/v;->a(Lb/a/a/l;Ljava/util/HashMap;)Lb/a/a/l;

    move-result-object v1

    iput-object v1, p1, Lb/a/a/b/b;->l:Lb/a/a/l;

    .line 155
    iget-object v1, p1, Lb/a/a/b/b;->k:Lb/a/a/l;

    invoke-direct {p0, v1, v0}, Lb/a/a/b/v;->a(Lb/a/a/l;Ljava/util/HashMap;)Lb/a/a/l;

    move-result-object v1

    iput-object v1, p1, Lb/a/a/b/b;->k:Lb/a/a/l;

    .line 156
    iget-object v1, p1, Lb/a/a/b/b;->j:Lb/a/a/l;

    invoke-direct {p0, v1, v0}, Lb/a/a/b/v;->a(Lb/a/a/l;Ljava/util/HashMap;)Lb/a/a/l;

    move-result-object v1

    iput-object v1, p1, Lb/a/a/b/b;->j:Lb/a/a/l;

    .line 157
    iget-object v1, p1, Lb/a/a/b/b;->i:Lb/a/a/l;

    invoke-direct {p0, v1, v0}, Lb/a/a/b/v;->a(Lb/a/a/l;Ljava/util/HashMap;)Lb/a/a/l;

    move-result-object v1

    iput-object v1, p1, Lb/a/a/b/b;->i:Lb/a/a/l;

    .line 158
    iget-object v1, p1, Lb/a/a/b/b;->h:Lb/a/a/l;

    invoke-direct {p0, v1, v0}, Lb/a/a/b/v;->a(Lb/a/a/l;Ljava/util/HashMap;)Lb/a/a/l;

    move-result-object v1

    iput-object v1, p1, Lb/a/a/b/b;->h:Lb/a/a/l;

    .line 159
    iget-object v1, p1, Lb/a/a/b/b;->g:Lb/a/a/l;

    invoke-direct {p0, v1, v0}, Lb/a/a/b/v;->a(Lb/a/a/l;Ljava/util/HashMap;)Lb/a/a/l;

    move-result-object v1

    iput-object v1, p1, Lb/a/a/b/b;->g:Lb/a/a/l;

    .line 160
    iget-object v1, p1, Lb/a/a/b/b;->f:Lb/a/a/l;

    invoke-direct {p0, v1, v0}, Lb/a/a/b/v;->a(Lb/a/a/l;Ljava/util/HashMap;)Lb/a/a/l;

    move-result-object v1

    iput-object v1, p1, Lb/a/a/b/b;->f:Lb/a/a/l;

    .line 162
    iget-object v1, p1, Lb/a/a/b/b;->e:Lb/a/a/l;

    invoke-direct {p0, v1, v0}, Lb/a/a/b/v;->a(Lb/a/a/l;Ljava/util/HashMap;)Lb/a/a/l;

    move-result-object v1

    iput-object v1, p1, Lb/a/a/b/b;->e:Lb/a/a/l;

    .line 163
    iget-object v1, p1, Lb/a/a/b/b;->d:Lb/a/a/l;

    invoke-direct {p0, v1, v0}, Lb/a/a/b/v;->a(Lb/a/a/l;Ljava/util/HashMap;)Lb/a/a/l;

    move-result-object v1

    iput-object v1, p1, Lb/a/a/b/b;->d:Lb/a/a/l;

    .line 164
    iget-object v1, p1, Lb/a/a/b/b;->c:Lb/a/a/l;

    invoke-direct {p0, v1, v0}, Lb/a/a/b/v;->a(Lb/a/a/l;Ljava/util/HashMap;)Lb/a/a/l;

    move-result-object v1

    iput-object v1, p1, Lb/a/a/b/b;->c:Lb/a/a/l;

    .line 165
    iget-object v1, p1, Lb/a/a/b/b;->b:Lb/a/a/l;

    invoke-direct {p0, v1, v0}, Lb/a/a/b/v;->a(Lb/a/a/l;Ljava/util/HashMap;)Lb/a/a/l;

    move-result-object v1

    iput-object v1, p1, Lb/a/a/b/b;->b:Lb/a/a/l;

    .line 166
    iget-object v1, p1, Lb/a/a/b/b;->a:Lb/a/a/l;

    invoke-direct {p0, v1, v0}, Lb/a/a/b/v;->a(Lb/a/a/l;Ljava/util/HashMap;)Lb/a/a/l;

    move-result-object v1

    iput-object v1, p1, Lb/a/a/b/b;->a:Lb/a/a/l;

    .line 170
    iget-object v1, p1, Lb/a/a/b/b;->E:Lb/a/a/c;

    invoke-direct {p0, v1, v0}, Lb/a/a/b/v;->a(Lb/a/a/c;Ljava/util/HashMap;)Lb/a/a/c;

    move-result-object v1

    iput-object v1, p1, Lb/a/a/b/b;->E:Lb/a/a/c;

    .line 171
    iget-object v1, p1, Lb/a/a/b/b;->F:Lb/a/a/c;

    invoke-direct {p0, v1, v0}, Lb/a/a/b/v;->a(Lb/a/a/c;Ljava/util/HashMap;)Lb/a/a/c;

    move-result-object v1

    iput-object v1, p1, Lb/a/a/b/b;->F:Lb/a/a/c;

    .line 172
    iget-object v1, p1, Lb/a/a/b/b;->G:Lb/a/a/c;

    invoke-direct {p0, v1, v0}, Lb/a/a/b/v;->a(Lb/a/a/c;Ljava/util/HashMap;)Lb/a/a/c;

    move-result-object v1

    iput-object v1, p1, Lb/a/a/b/b;->G:Lb/a/a/c;

    .line 173
    iget-object v1, p1, Lb/a/a/b/b;->H:Lb/a/a/c;

    invoke-direct {p0, v1, v0}, Lb/a/a/b/v;->a(Lb/a/a/c;Ljava/util/HashMap;)Lb/a/a/c;

    move-result-object v1

    iput-object v1, p1, Lb/a/a/b/b;->H:Lb/a/a/c;

    .line 174
    iget-object v1, p1, Lb/a/a/b/b;->I:Lb/a/a/c;

    invoke-direct {p0, v1, v0}, Lb/a/a/b/v;->a(Lb/a/a/c;Ljava/util/HashMap;)Lb/a/a/c;

    move-result-object v1

    iput-object v1, p1, Lb/a/a/b/b;->I:Lb/a/a/c;

    .line 175
    iget-object v1, p1, Lb/a/a/b/b;->x:Lb/a/a/c;

    invoke-direct {p0, v1, v0}, Lb/a/a/b/v;->a(Lb/a/a/c;Ljava/util/HashMap;)Lb/a/a/c;

    move-result-object v1

    iput-object v1, p1, Lb/a/a/b/b;->x:Lb/a/a/c;

    .line 176
    iget-object v1, p1, Lb/a/a/b/b;->y:Lb/a/a/c;

    invoke-direct {p0, v1, v0}, Lb/a/a/b/v;->a(Lb/a/a/c;Ljava/util/HashMap;)Lb/a/a/c;

    move-result-object v1

    iput-object v1, p1, Lb/a/a/b/b;->y:Lb/a/a/c;

    .line 177
    iget-object v1, p1, Lb/a/a/b/b;->z:Lb/a/a/c;

    invoke-direct {p0, v1, v0}, Lb/a/a/b/v;->a(Lb/a/a/c;Ljava/util/HashMap;)Lb/a/a/c;

    move-result-object v1

    iput-object v1, p1, Lb/a/a/b/b;->z:Lb/a/a/c;

    .line 178
    iget-object v1, p1, Lb/a/a/b/b;->D:Lb/a/a/c;

    invoke-direct {p0, v1, v0}, Lb/a/a/b/v;->a(Lb/a/a/c;Ljava/util/HashMap;)Lb/a/a/c;

    move-result-object v1

    iput-object v1, p1, Lb/a/a/b/b;->D:Lb/a/a/c;

    .line 179
    iget-object v1, p1, Lb/a/a/b/b;->A:Lb/a/a/c;

    invoke-direct {p0, v1, v0}, Lb/a/a/b/v;->a(Lb/a/a/c;Ljava/util/HashMap;)Lb/a/a/c;

    move-result-object v1

    iput-object v1, p1, Lb/a/a/b/b;->A:Lb/a/a/c;

    .line 180
    iget-object v1, p1, Lb/a/a/b/b;->B:Lb/a/a/c;

    invoke-direct {p0, v1, v0}, Lb/a/a/b/v;->a(Lb/a/a/c;Ljava/util/HashMap;)Lb/a/a/c;

    move-result-object v1

    iput-object v1, p1, Lb/a/a/b/b;->B:Lb/a/a/c;

    .line 181
    iget-object v1, p1, Lb/a/a/b/b;->C:Lb/a/a/c;

    invoke-direct {p0, v1, v0}, Lb/a/a/b/v;->a(Lb/a/a/c;Ljava/util/HashMap;)Lb/a/a/c;

    move-result-object v1

    iput-object v1, p1, Lb/a/a/b/b;->C:Lb/a/a/c;

    .line 183
    iget-object v1, p1, Lb/a/a/b/b;->m:Lb/a/a/c;

    invoke-direct {p0, v1, v0}, Lb/a/a/b/v;->a(Lb/a/a/c;Ljava/util/HashMap;)Lb/a/a/c;

    move-result-object v1

    iput-object v1, p1, Lb/a/a/b/b;->m:Lb/a/a/c;

    .line 184
    iget-object v1, p1, Lb/a/a/b/b;->n:Lb/a/a/c;

    invoke-direct {p0, v1, v0}, Lb/a/a/b/v;->a(Lb/a/a/c;Ljava/util/HashMap;)Lb/a/a/c;

    move-result-object v1

    iput-object v1, p1, Lb/a/a/b/b;->n:Lb/a/a/c;

    .line 185
    iget-object v1, p1, Lb/a/a/b/b;->o:Lb/a/a/c;

    invoke-direct {p0, v1, v0}, Lb/a/a/b/v;->a(Lb/a/a/c;Ljava/util/HashMap;)Lb/a/a/c;

    move-result-object v1

    iput-object v1, p1, Lb/a/a/b/b;->o:Lb/a/a/c;

    .line 186
    iget-object v1, p1, Lb/a/a/b/b;->p:Lb/a/a/c;

    invoke-direct {p0, v1, v0}, Lb/a/a/b/v;->a(Lb/a/a/c;Ljava/util/HashMap;)Lb/a/a/c;

    move-result-object v1

    iput-object v1, p1, Lb/a/a/b/b;->p:Lb/a/a/c;

    .line 187
    iget-object v1, p1, Lb/a/a/b/b;->q:Lb/a/a/c;

    invoke-direct {p0, v1, v0}, Lb/a/a/b/v;->a(Lb/a/a/c;Ljava/util/HashMap;)Lb/a/a/c;

    move-result-object v1

    iput-object v1, p1, Lb/a/a/b/b;->q:Lb/a/a/c;

    .line 188
    iget-object v1, p1, Lb/a/a/b/b;->r:Lb/a/a/c;

    invoke-direct {p0, v1, v0}, Lb/a/a/b/v;->a(Lb/a/a/c;Ljava/util/HashMap;)Lb/a/a/c;

    move-result-object v1

    iput-object v1, p1, Lb/a/a/b/b;->r:Lb/a/a/c;

    .line 189
    iget-object v1, p1, Lb/a/a/b/b;->s:Lb/a/a/c;

    invoke-direct {p0, v1, v0}, Lb/a/a/b/v;->a(Lb/a/a/c;Ljava/util/HashMap;)Lb/a/a/c;

    move-result-object v1

    iput-object v1, p1, Lb/a/a/b/b;->s:Lb/a/a/c;

    .line 190
    iget-object v1, p1, Lb/a/a/b/b;->u:Lb/a/a/c;

    invoke-direct {p0, v1, v0}, Lb/a/a/b/v;->a(Lb/a/a/c;Ljava/util/HashMap;)Lb/a/a/c;

    move-result-object v1

    iput-object v1, p1, Lb/a/a/b/b;->u:Lb/a/a/c;

    .line 191
    iget-object v1, p1, Lb/a/a/b/b;->t:Lb/a/a/c;

    invoke-direct {p0, v1, v0}, Lb/a/a/b/v;->a(Lb/a/a/c;Ljava/util/HashMap;)Lb/a/a/c;

    move-result-object v1

    iput-object v1, p1, Lb/a/a/b/b;->t:Lb/a/a/c;

    .line 192
    iget-object v1, p1, Lb/a/a/b/b;->v:Lb/a/a/c;

    invoke-direct {p0, v1, v0}, Lb/a/a/b/v;->a(Lb/a/a/c;Ljava/util/HashMap;)Lb/a/a/c;

    move-result-object v1

    iput-object v1, p1, Lb/a/a/b/b;->v:Lb/a/a/c;

    .line 193
    iget-object v1, p1, Lb/a/a/b/b;->w:Lb/a/a/c;

    invoke-direct {p0, v1, v0}, Lb/a/a/b/v;->a(Lb/a/a/c;Ljava/util/HashMap;)Lb/a/a/c;

    move-result-object v0

    iput-object v0, p1, Lb/a/a/b/b;->w:Lb/a/a/c;

    .line 194
    return-void
.end method

.method public final b()Lb/a/a/a;
    .locals 1

    .prologue
    .line 89
    iget-object v0, p0, Lb/a/a/b/a;->a:Lb/a/a/a;

    return-object v0
.end method

.method public final equals(Ljava/lang/Object;)Z
    .locals 4

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 234
    if-ne p0, p1, :cond_0

    move v0, v2

    .line 241
    :goto_0
    return v0

    .line 237
    :cond_0
    instance-of v0, p1, Lb/a/a/b/v;

    if-nez v0, :cond_1

    move v0, v3

    .line 238
    goto :goto_0

    .line 240
    :cond_1
    check-cast p1, Lb/a/a/b/v;

    .line 241
    iget-object v0, p0, Lb/a/a/b/a;->a:Lb/a/a/a;

    iget-object v1, p1, Lb/a/a/b/a;->a:Lb/a/a/a;

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lb/a/a/b/a;->b:Ljava/lang/Object;

    check-cast v0, Lb/a/a/i;

    iget-object v1, p1, Lb/a/a/b/a;->b:Ljava/lang/Object;

    check-cast v1, Lb/a/a/i;

    invoke-virtual {v0, v1}, Lb/a/a/i;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    move v0, v2

    goto :goto_0

    :cond_2
    move v0, v3

    goto :goto_0
.end method

.method public final hashCode()I
    .locals 2

    .prologue
    .line 253
    const v1, 0x4fba5

    iget-object v0, p0, Lb/a/a/b/a;->b:Ljava/lang/Object;

    check-cast v0, Lb/a/a/i;

    invoke-virtual {v0}, Lb/a/a/i;->hashCode()I

    move-result v0

    mul-int/lit8 v0, v0, 0xb

    add-int/2addr v0, v1

    iget-object v1, p0, Lb/a/a/b/a;->a:Lb/a/a/a;

    invoke-virtual {v1}, Ljava/lang/Object;->hashCode()I

    move-result v1

    mul-int/lit8 v1, v1, 0x7

    add-int/2addr v0, v1

    return v0
.end method

.method public final toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 262
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "ZonedChronology["

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lb/a/a/b/a;->a:Lb/a/a/a;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v0, p0, Lb/a/a/b/a;->b:Ljava/lang/Object;

    check-cast v0, Lb/a/a/i;

    iget-object v0, v0, Lb/a/a/i;->c:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0x5d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

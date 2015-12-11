.class public final Lcom/a/a/a/a/z;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field static final a:Ljava/lang/String;

.field static final b:Ljava/lang/String;

.field static final c:Ljava/lang/String;

.field static final d:Ljava/lang/String;


# instance fields
.field final e:Ljava/net/URI;

.field final f:Lcom/a/a/a/a/v;

.field g:Ljava/util/Date;

.field h:Ljava/util/Date;

.field i:Ljava/util/Date;

.field j:J

.field k:J

.field l:Z

.field m:I

.field n:Z

.field o:Ljava/lang/String;

.field p:I

.field public q:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field r:Ljava/lang/String;

.field s:I

.field t:Ljava/lang/String;

.field private u:Z

.field private v:I

.field private w:Z

.field private x:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 38
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/a/a/a/m;->a()Lcom/a/a/a/m;

    invoke-static {}, Lcom/a/a/a/m;->b()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "-Sent-Millis"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/a/a/a/a/z;->a:Ljava/lang/String;

    .line 41
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/a/a/a/m;->a()Lcom/a/a/a/m;

    invoke-static {}, Lcom/a/a/a/m;->b()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "-Received-Millis"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/a/a/a/a/z;->b:Ljava/lang/String;

    .line 44
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/a/a/a/m;->a()Lcom/a/a/a/m;

    invoke-static {}, Lcom/a/a/a/m;->b()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "-Response-Source"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/a/a/a/a/z;->c:Ljava/lang/String;

    .line 47
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/a/a/a/m;->a()Lcom/a/a/a/m;

    invoke-static {}, Lcom/a/a/a/m;->b()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "-Selected-Transport"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/a/a/a/a/z;->d:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Ljava/net/URI;Lcom/a/a/a/a/v;)V
    .locals 8

    .prologue
    const/4 v1, 0x0

    const/4 v2, -0x1

    .line 120
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 91
    iput v2, p0, Lcom/a/a/a/a/z;->m:I

    .line 98
    iput v2, p0, Lcom/a/a/a/a/z;->v:I

    .line 110
    iput v2, p0, Lcom/a/a/a/a/z;->p:I

    .line 113
    invoke-static {}, Ljava/util/Collections;->emptySet()Ljava/util/Set;

    move-result-object v0

    iput-object v0, p0, Lcom/a/a/a/a/z;->q:Ljava/util/Set;

    .line 117
    iput v2, p0, Lcom/a/a/a/a/z;->s:I

    .line 121
    iput-object p1, p0, Lcom/a/a/a/a/z;->e:Ljava/net/URI;

    .line 122
    iput-object p2, p0, Lcom/a/a/a/a/z;->f:Lcom/a/a/a/a/v;

    .line 124
    new-instance v3, Lcom/a/a/a/a/aa;

    invoke-direct {v3, p0}, Lcom/a/a/a/a/aa;-><init>(Lcom/a/a/a/a/z;)V

    move v0, v1

    .line 142
    :goto_0
    invoke-virtual {p2}, Lcom/a/a/a/a/v;->a()I

    move-result v2

    if-ge v0, v2, :cond_f

    .line 143
    invoke-virtual {p2, v0}, Lcom/a/a/a/a/v;->a(I)Ljava/lang/String;

    move-result-object v2

    .line 144
    invoke-virtual {p2, v0}, Lcom/a/a/a/a/v;->b(I)Ljava/lang/String;

    move-result-object v4

    .line 145
    const-string v5, "Cache-Control"

    invoke-virtual {v5, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 146
    invoke-static {v4, v3}, Lcom/a/a/a/a/b;->a(Ljava/lang/String;Lcom/a/a/a/a/c;)V

    .line 142
    :cond_0
    :goto_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 147
    :cond_1
    const-string v5, "Date"

    invoke-virtual {v5, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 148
    invoke-static {v4}, Lcom/a/a/a/a/f;->a(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v2

    iput-object v2, p0, Lcom/a/a/a/a/z;->g:Ljava/util/Date;

    goto :goto_1

    .line 149
    :cond_2
    const-string v5, "Expires"

    invoke-virtual {v5, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 150
    invoke-static {v4}, Lcom/a/a/a/a/f;->a(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v2

    iput-object v2, p0, Lcom/a/a/a/a/z;->i:Ljava/util/Date;

    goto :goto_1

    .line 151
    :cond_3
    const-string v5, "Last-Modified"

    invoke-virtual {v5, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 152
    invoke-static {v4}, Lcom/a/a/a/a/f;->a(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v2

    iput-object v2, p0, Lcom/a/a/a/a/z;->h:Ljava/util/Date;

    goto :goto_1

    .line 153
    :cond_4
    const-string v5, "ETag"

    invoke-virtual {v5, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_5

    .line 154
    iput-object v4, p0, Lcom/a/a/a/a/z;->o:Ljava/lang/String;

    goto :goto_1

    .line 155
    :cond_5
    const-string v5, "Pragma"

    invoke-virtual {v5, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_6

    .line 156
    const-string v2, "no-cache"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 157
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/a/a/a/a/z;->l:Z

    goto :goto_1

    .line 159
    :cond_6
    const-string v5, "Age"

    invoke-virtual {v5, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_7

    .line 160
    invoke-static {v4}, Lcom/a/a/a/a/b;->a(Ljava/lang/String;)I

    move-result v2

    iput v2, p0, Lcom/a/a/a/a/z;->p:I

    goto :goto_1

    .line 161
    :cond_7
    const-string v5, "Vary"

    invoke-virtual {v5, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_9

    .line 163
    iget-object v2, p0, Lcom/a/a/a/a/z;->q:Ljava/util/Set;

    invoke-interface {v2}, Ljava/util/Set;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_8

    .line 164
    new-instance v2, Ljava/util/TreeSet;

    sget-object v5, Ljava/lang/String;->CASE_INSENSITIVE_ORDER:Ljava/util/Comparator;

    invoke-direct {v2, v5}, Ljava/util/TreeSet;-><init>(Ljava/util/Comparator;)V

    iput-object v2, p0, Lcom/a/a/a/a/z;->q:Ljava/util/Set;

    .line 166
    :cond_8
    const-string v2, ","

    invoke-virtual {v4, v2}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v4

    array-length v5, v4

    move v2, v1

    :goto_2
    if-ge v2, v5, :cond_0

    aget-object v6, v4, v2

    .line 167
    iget-object v7, p0, Lcom/a/a/a/a/z;->q:Ljava/util/Set;

    invoke-virtual {v6}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v7, v6}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 166
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    .line 169
    :cond_9
    const-string v5, "Content-Encoding"

    invoke-virtual {v5, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_a

    .line 170
    iput-object v4, p0, Lcom/a/a/a/a/z;->r:Ljava/lang/String;

    goto/16 :goto_1

    .line 171
    :cond_a
    const-string v5, "Transfer-Encoding"

    invoke-virtual {v5, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_b

    .line 172
    iput-object v4, p0, Lcom/a/a/a/a/z;->x:Ljava/lang/String;

    goto/16 :goto_1

    .line 173
    :cond_b
    const-string v5, "Content-Length"

    invoke-virtual {v5, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_c

    .line 175
    :try_start_0
    invoke-static {v4}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    iput v2, p0, Lcom/a/a/a/a/z;->s:I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_1

    .line 177
    :catch_0
    move-exception v2

    goto/16 :goto_1

    .line 178
    :cond_c
    const-string v5, "Connection"

    invoke-virtual {v5, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_d

    .line 179
    iput-object v4, p0, Lcom/a/a/a/a/z;->t:Ljava/lang/String;

    goto/16 :goto_1

    .line 180
    :cond_d
    sget-object v5, Lcom/a/a/a/a/z;->a:Ljava/lang/String;

    invoke-virtual {v5, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_e

    .line 181
    invoke-static {v4}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v4

    iput-wide v4, p0, Lcom/a/a/a/a/z;->j:J

    goto/16 :goto_1

    .line 182
    :cond_e
    sget-object v5, Lcom/a/a/a/a/z;->b:Ljava/lang/String;

    invoke-virtual {v5, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 183
    invoke-static {v4}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v4

    iput-wide v4, p0, Lcom/a/a/a/a/z;->k:J

    goto/16 :goto_1

    .line 186
    :cond_f
    return-void
.end method

.method static synthetic a(Lcom/a/a/a/a/z;I)I
    .locals 0

    .prologue
    .line 35
    iput p1, p0, Lcom/a/a/a/a/z;->m:I

    return p1
.end method

.method static synthetic b(Lcom/a/a/a/a/z;I)I
    .locals 0

    .prologue
    .line 35
    iput p1, p0, Lcom/a/a/a/a/z;->v:I

    return p1
.end method

.method static synthetic b(Lcom/a/a/a/a/z;)Z
    .locals 1

    .prologue
    .line 35
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/a/a/a/a/z;->l:Z

    return v0
.end method

.method private static b(Ljava/lang/String;)Z
    .locals 1

    .prologue
    .line 496
    const-string v0, "Connection"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "Keep-Alive"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "Proxy-Authenticate"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "Proxy-Authorization"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "TE"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "Trailers"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "Transfer-Encoding"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "Upgrade"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method static synthetic c(Lcom/a/a/a/a/z;)Z
    .locals 1

    .prologue
    .line 35
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/a/a/a/a/z;->u:Z

    return v0
.end method

.method static synthetic d(Lcom/a/a/a/a/z;)Z
    .locals 1

    .prologue
    .line 35
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/a/a/a/a/z;->w:Z

    return v0
.end method

.method static synthetic e(Lcom/a/a/a/a/z;)Z
    .locals 1

    .prologue
    .line 35
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/a/a/a/a/z;->n:Z

    return v0
.end method


# virtual methods
.method public final a(Lcom/a/a/a/a/z;)Lcom/a/a/a/a/z;
    .locals 6

    .prologue
    const/4 v1, 0x0

    .line 467
    new-instance v2, Lcom/a/a/a/a/v;

    invoke-direct {v2}, Lcom/a/a/a/a/v;-><init>()V

    .line 468
    iget-object v0, p0, Lcom/a/a/a/a/z;->f:Lcom/a/a/a/a/v;

    iget-object v0, v0, Lcom/a/a/a/a/v;->b:Ljava/lang/String;

    invoke-virtual {v2, v0}, Lcom/a/a/a/a/v;->b(Ljava/lang/String;)V

    move v0, v1

    .line 470
    :goto_0
    iget-object v3, p0, Lcom/a/a/a/a/z;->f:Lcom/a/a/a/a/v;

    invoke-virtual {v3}, Lcom/a/a/a/a/v;->a()I

    move-result v3

    if-ge v0, v3, :cond_3

    .line 471
    iget-object v3, p0, Lcom/a/a/a/a/z;->f:Lcom/a/a/a/a/v;

    invoke-virtual {v3, v0}, Lcom/a/a/a/a/v;->a(I)Ljava/lang/String;

    move-result-object v3

    .line 472
    iget-object v4, p0, Lcom/a/a/a/a/z;->f:Lcom/a/a/a/a/v;

    invoke-virtual {v4, v0}, Lcom/a/a/a/a/v;->b(I)Ljava/lang/String;

    move-result-object v4

    .line 473
    const-string v5, "Warning"

    invoke-virtual {v5, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    const-string v5, "1"

    invoke-virtual {v4, v5}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_2

    .line 474
    :cond_0
    invoke-static {v3}, Lcom/a/a/a/a/z;->b(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_1

    iget-object v5, p1, Lcom/a/a/a/a/z;->f:Lcom/a/a/a/a/v;

    invoke-virtual {v5, v3}, Lcom/a/a/a/a/v;->e(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    if-nez v5, :cond_2

    .line 477
    :cond_1
    invoke-virtual {v2, v3, v4}, Lcom/a/a/a/a/v;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 470
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 481
    :cond_3
    :goto_1
    iget-object v0, p1, Lcom/a/a/a/a/z;->f:Lcom/a/a/a/a/v;

    invoke-virtual {v0}, Lcom/a/a/a/a/v;->a()I

    move-result v0

    if-ge v1, v0, :cond_5

    .line 482
    iget-object v0, p1, Lcom/a/a/a/a/z;->f:Lcom/a/a/a/a/v;

    invoke-virtual {v0, v1}, Lcom/a/a/a/a/v;->a(I)Ljava/lang/String;

    move-result-object v0

    .line 483
    invoke-static {v0}, Lcom/a/a/a/a/z;->b(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 484
    iget-object v3, p1, Lcom/a/a/a/a/z;->f:Lcom/a/a/a/a/v;

    invoke-virtual {v3, v1}, Lcom/a/a/a/a/v;->b(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v0, v3}, Lcom/a/a/a/a/v;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 481
    :cond_4
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 488
    :cond_5
    new-instance v0, Lcom/a/a/a/a/z;

    iget-object v1, p0, Lcom/a/a/a/a/z;->e:Ljava/net/URI;

    invoke-direct {v0, v1, v2}, Lcom/a/a/a/a/z;-><init>(Ljava/net/URI;Lcom/a/a/a/a/v;)V

    return-object v0
.end method

.method public final a(Lcom/a/a/u;)V
    .locals 4

    .prologue
    .line 282
    iget-object v0, p0, Lcom/a/a/a/a/z;->f:Lcom/a/a/a/a/v;

    sget-object v1, Lcom/a/a/a/a/z;->c:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Lcom/a/a/u;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/a/a/a/a/z;->f:Lcom/a/a/a/a/v;

    iget v3, v3, Lcom/a/a/a/a/v;->d:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/a/a/a/a/v;->b(Ljava/lang/String;Ljava/lang/String;)V

    .line 283
    return-void
.end method

.method public final a(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 286
    iget-object v0, p0, Lcom/a/a/a/a/z;->f:Lcom/a/a/a/a/v;

    sget-object v1, Lcom/a/a/a/a/z;->d:Ljava/lang/String;

    invoke-virtual {v0, v1, p1}, Lcom/a/a/a/a/v;->b(Ljava/lang/String;Ljava/lang/String;)V

    .line 287
    return-void
.end method

.method public final a()Z
    .locals 2

    .prologue
    .line 203
    const-string v0, "chunked"

    iget-object v1, p0, Lcom/a/a/a/a/z;->x:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public final a(Lcom/a/a/a/a/x;)Z
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 343
    iget-object v1, p0, Lcom/a/a/a/a/z;->f:Lcom/a/a/a/a/v;

    iget v1, v1, Lcom/a/a/a/a/v;->d:I

    .line 344
    const/16 v2, 0xc8

    if-eq v1, v2, :cond_1

    const/16 v2, 0xcb

    if-eq v1, v2, :cond_1

    const/16 v2, 0x12c

    if-eq v1, v2, :cond_1

    const/16 v2, 0x12d

    if-eq v1, v2, :cond_1

    const/16 v2, 0x19a

    if-eq v1, v2, :cond_1

    .line 362
    :cond_0
    :goto_0
    return v0

    .line 354
    :cond_1
    iget-boolean v1, p1, Lcom/a/a/a/a/x;->g:Z

    if-eqz v1, :cond_2

    iget-boolean v1, p0, Lcom/a/a/a/a/z;->w:Z

    if-nez v1, :cond_2

    iget-boolean v1, p0, Lcom/a/a/a/a/z;->n:Z

    if-nez v1, :cond_2

    iget v1, p0, Lcom/a/a/a/a/z;->v:I

    const/4 v2, -0x1

    if-eq v1, v2, :cond_0

    .line 358
    :cond_2
    iget-boolean v1, p0, Lcom/a/a/a/a/z;->u:Z

    if-nez v1, :cond_0

    .line 362
    const/4 v0, 0x1

    goto :goto_0
.end method

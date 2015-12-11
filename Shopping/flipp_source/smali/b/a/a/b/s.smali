.class public final Lb/a/a/b/s;
.super Lb/a/a/b/i;
.source "SourceFile"


# static fields
.field private static final l:Lb/a/a/b/s;

.field private static final m:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lb/a/a/i;",
            "[",
            "Lb/a/a/b/s;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 68
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lb/a/a/b/s;->m:Ljava/util/Map;

    .line 71
    sget-object v0, Lb/a/a/i;->a:Lb/a/a/i;

    const/4 v1, 0x4

    invoke-static {v0, v1}, Lb/a/a/b/s;->a(Lb/a/a/i;I)Lb/a/a/b/s;

    move-result-object v0

    sput-object v0, Lb/a/a/b/s;->l:Lb/a/a/b/s;

    .line 72
    return-void
.end method

.method private constructor <init>(Lb/a/a/a;I)V
    .locals 0

    .prologue
    .line 148
    invoke-direct {p0, p1, p2}, Lb/a/a/b/i;-><init>(Lb/a/a/a;I)V

    .line 149
    return-void
.end method

.method public static U()Lb/a/a/b/s;
    .locals 1

    .prologue
    .line 81
    sget-object v0, Lb/a/a/b/s;->l:Lb/a/a/b/s;

    return-object v0
.end method

.method private static a(Lb/a/a/i;I)Lb/a/a/b/s;
    .locals 4

    .prologue
    .line 111
    if-nez p0, :cond_0

    .line 112
    invoke-static {}, Lb/a/a/i;->a()Lb/a/a/i;

    move-result-object p0

    .line 115
    :cond_0
    sget-object v2, Lb/a/a/b/s;->m:Ljava/util/Map;

    monitor-enter v2

    .line 116
    :try_start_0
    sget-object v0, Lb/a/a/b/s;->m:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lb/a/a/b/s;

    .line 117
    if-nez v0, :cond_1

    .line 118
    const/4 v0, 0x7

    new-array v0, v0, [Lb/a/a/b/s;

    .line 119
    sget-object v1, Lb/a/a/b/s;->m:Ljava/util/Map;

    invoke-interface {v1, p0, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_1
    move-object v1, v0

    .line 122
    add-int/lit8 v0, p1, -0x1

    :try_start_1
    aget-object v0, v1, v0
    :try_end_1
    .catch Ljava/lang/ArrayIndexOutOfBoundsException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 127
    if-nez v0, :cond_2

    .line 128
    :try_start_2
    sget-object v0, Lb/a/a/i;->a:Lb/a/a/i;

    if-ne p0, v0, :cond_3

    .line 129
    new-instance v0, Lb/a/a/b/s;

    const/4 v3, 0x0

    invoke-direct {v0, v3, p1}, Lb/a/a/b/s;-><init>(Lb/a/a/a;I)V

    .line 135
    :goto_0
    add-int/lit8 v3, p1, -0x1

    aput-object v0, v1, v3

    .line 137
    :cond_2
    monitor-exit v2

    .line 138
    return-object v0

    .line 124
    :catch_0
    move-exception v0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v3, "Invalid min days in first week: "

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 137
    :catchall_0
    move-exception v0

    monitor-exit v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v0

    .line 131
    :cond_3
    :try_start_3
    sget-object v0, Lb/a/a/i;->a:Lb/a/a/i;

    invoke-static {v0, p1}, Lb/a/a/b/s;->a(Lb/a/a/i;I)Lb/a/a/b/s;

    move-result-object v3

    .line 132
    new-instance v0, Lb/a/a/b/s;

    invoke-static {v3, p0}, Lb/a/a/b/v;->a(Lb/a/a/a;Lb/a/a/i;)Lb/a/a/b/v;

    move-result-object v3

    invoke-direct {v0, v3, p1}, Lb/a/a/b/s;-><init>(Lb/a/a/a;I)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0
.end method


# virtual methods
.method final N()I
    .locals 1

    .prologue
    .line 221
    const v0, -0x116bc36e

    return v0
.end method

.method final O()I
    .locals 1

    .prologue
    .line 225
    const v0, 0x116bd2d1

    return v0
.end method

.method final Q()J
    .locals 2

    .prologue
    .line 229
    const-wide v0, 0x758f0dfc0L

    return-wide v0
.end method

.method final R()J
    .locals 2

    .prologue
    .line 237
    const-wide v0, 0x9cbebd50L

    return-wide v0
.end method

.method public final a(Lb/a/a/i;)Lb/a/a/a;
    .locals 1

    .prologue
    .line 181
    if-nez p1, :cond_0

    .line 182
    invoke-static {}, Lb/a/a/i;->a()Lb/a/a/i;

    move-result-object p1

    .line 184
    :cond_0
    invoke-virtual {p0}, Lb/a/a/b/s;->a()Lb/a/a/i;

    move-result-object v0

    if-ne p1, v0, :cond_1

    .line 187
    :goto_0
    return-object p0

    :cond_1
    const/4 v0, 0x4

    invoke-static {p1, v0}, Lb/a/a/b/s;->a(Lb/a/a/i;I)Lb/a/a/b/s;

    move-result-object p0

    goto :goto_0
.end method

.method protected final a(Lb/a/a/b/b;)V
    .locals 1

    .prologue
    .line 191
    iget-object v0, p0, Lb/a/a/b/a;->a:Lb/a/a/a;

    if-nez v0, :cond_0

    .line 192
    invoke-super {p0, p1}, Lb/a/a/b/i;->a(Lb/a/a/b/b;)V

    .line 194
    :cond_0
    return-void
.end method

.method public final b()Lb/a/a/a;
    .locals 1

    .prologue
    .line 171
    sget-object v0, Lb/a/a/b/s;->l:Lb/a/a/b/s;

    return-object v0
.end method

.method final c(I)Z
    .locals 1

    .prologue
    .line 197
    and-int/lit8 v0, p1, 0x3

    if-nez v0, :cond_1

    rem-int/lit8 v0, p1, 0x64

    if-nez v0, :cond_0

    rem-int/lit16 v0, p1, 0x190

    if-nez v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method final d(I)J
    .locals 6

    .prologue
    .line 202
    div-int/lit8 v0, p1, 0x64

    .line 203
    if-gez p1, :cond_1

    .line 209
    add-int/lit8 v1, p1, 0x3

    shr-int/lit8 v1, v1, 0x2

    sub-int/2addr v1, v0

    add-int/lit8 v0, v0, 0x3

    shr-int/lit8 v0, v0, 0x2

    add-int/2addr v0, v1

    add-int/lit8 v0, v0, -0x1

    .line 217
    :cond_0
    :goto_0
    int-to-long v2, p1

    const-wide/16 v4, 0x16d

    mul-long/2addr v2, v4

    const v1, 0xafaa7

    sub-int/2addr v0, v1

    int-to-long v0, v0

    add-long/2addr v0, v2

    const-wide/32 v2, 0x5265c00

    mul-long/2addr v0, v2

    return-wide v0

    .line 211
    :cond_1
    shr-int/lit8 v1, p1, 0x2

    sub-int/2addr v1, v0

    shr-int/lit8 v0, v0, 0x2

    add-int/2addr v0, v1

    .line 212
    invoke-virtual {p0, p1}, Lb/a/a/b/s;->c(I)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 213
    add-int/lit8 v0, v0, -0x1

    goto :goto_0
.end method

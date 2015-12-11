.class final Law;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private final a:Lav;

.field private final b:Lao;

.field private final c:Lah;

.field private final d:Ljava/io/File;

.field private final e:[C


# direct methods
.method public constructor <init>(Lav;Lao;Lah;)V
    .locals 1

    .prologue
    .line 231
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 229
    const/16 v0, 0x1000

    new-array v0, v0, [C

    iput-object v0, p0, Law;->e:[C

    .line 232
    iput-object p1, p0, Law;->a:Lav;

    .line 233
    iput-object p2, p0, Law;->b:Lao;

    .line 234
    iput-object p3, p0, Law;->c:Lah;

    .line 235
    invoke-static {p1}, Lav;->a(Lav;)Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lav;->a(Landroid/content/Context;)Ljava/io/File;

    move-result-object v0

    iput-object v0, p0, Law;->d:Ljava/io/File;

    .line 236
    return-void
.end method

.method private a(Ljava/io/File;Ljava/lang/StringBuilder;)Lorg/json/JSONObject;
    .locals 7

    .prologue
    const/4 v0, 0x0

    const/4 v5, 0x0

    .line 295
    .line 298
    :try_start_0
    new-instance v1, Ljava/io/FileReader;

    invoke-direct {v1, p1}, Ljava/io/FileReader;-><init>(Ljava/io/File;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 299
    :goto_0
    :try_start_1
    iget-object v2, p0, Law;->e:[C

    invoke-virtual {v1, v2}, Ljava/io/FileReader;->read([C)I

    move-result v2

    const/4 v3, -0x1

    if-eq v2, v3, :cond_0

    .line 300
    iget-object v3, p0, Law;->e:[C

    const/4 v4, 0x0

    invoke-virtual {p2, v3, v4, v2}, Ljava/lang/StringBuilder;->append([CII)Ljava/lang/StringBuilder;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    goto :goto_0

    .line 305
    :catch_0
    move-exception v2

    :goto_1
    :try_start_2
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Failure converting contents of file: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " to json. Deleting it immediately"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lbc;->a(Ljava/lang/String;)V

    .line 306
    invoke-virtual {p1}, Ljava/io/File;->delete()Z
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 307
    invoke-virtual {p2, v5}, Ljava/lang/StringBuilder;->setLength(I)V

    .line 310
    invoke-static {v1}, Lbc;->a(Ljava/io/Closeable;)V

    :goto_2
    return-object v0

    .line 303
    :cond_0
    :try_start_3
    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Laz;->a(Ljava/lang/String;)Lorg/json/JSONObject;
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    move-result-object v0

    .line 309
    invoke-virtual {p2, v5}, Ljava/lang/StringBuilder;->setLength(I)V

    .line 310
    invoke-static {v1}, Lbc;->a(Ljava/io/Closeable;)V

    goto :goto_2

    .line 309
    :catchall_0
    move-exception v1

    move-object v6, v1

    move-object v1, v0

    move-object v0, v6

    :goto_3
    invoke-virtual {p2, v5}, Ljava/lang/StringBuilder;->setLength(I)V

    .line 310
    invoke-static {v1}, Lbc;->a(Ljava/io/Closeable;)V

    throw v0

    .line 309
    :catchall_1
    move-exception v0

    goto :goto_3

    .line 305
    :catch_1
    move-exception v1

    move-object v1, v0

    goto :goto_1
.end method


# virtual methods
.method public final run()V
    .locals 9

    .prologue
    const/4 v3, 0x4

    const/4 v1, 0x0

    .line 240
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v2, "Contents of folder = "

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Law;->d:Ljava/io/File;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ", is = "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v2, p0, Law;->d:Ljava/io/File;

    invoke-virtual {v2}, Ljava/io/File;->list()[Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/util/Arrays;->toString([Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lbc;->a(Ljava/lang/String;)V

    .line 241
    iget-object v0, p0, Law;->d:Ljava/io/File;

    new-instance v2, Law$1;

    invoke-direct {v2, p0}, Law$1;-><init>(Law;)V

    invoke-virtual {v0, v2}, Ljava/io/File;->listFiles(Ljava/io/FilenameFilter;)[Ljava/io/File;

    move-result-object v0

    .line 248
    array-length v2, v0

    if-le v2, v3, :cond_0

    .line 249
    new-instance v2, Law$2;

    invoke-direct {v2, p0}, Law$2;-><init>(Law;)V

    invoke-static {v0, v2}, Ljava/util/Arrays;->sort([Ljava/lang/Object;Ljava/util/Comparator;)V

    .line 261
    invoke-static {v0, v3}, Ljava/util/Arrays;->copyOf([Ljava/lang/Object;I)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ljava/io/File;

    .line 264
    :cond_0
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 265
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    .line 266
    array-length v5, v0

    move v2, v1

    :goto_0
    if-ge v2, v5, :cond_2

    aget-object v6, v0, v2

    .line 267
    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "Read contents of file: "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Lbc;->a(Ljava/lang/String;)V

    .line 268
    invoke-direct {p0, v6, v4}, Law;->a(Ljava/io/File;Ljava/lang/StringBuilder;)Lorg/json/JSONObject;

    move-result-object v6

    .line 269
    if-eqz v6, :cond_1

    .line 270
    invoke-interface {v3, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 266
    :cond_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 274
    :cond_2
    invoke-interface {v3}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 292
    :goto_1
    return-void

    .line 282
    :cond_3
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v2, "Deleting contents of crash reports folder: "

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Law;->d:Ljava/io/File;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lbc;->a(Ljava/lang/String;)V

    .line 283
    iget-object v0, p0, Law;->d:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v2

    array-length v4, v2

    move v0, v1

    :goto_2
    if-ge v0, v4, :cond_4

    aget-object v1, v2, v0

    .line 284
    invoke-virtual {v1}, Ljava/io/File;->delete()Z

    .line 283
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 287
    :cond_4
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Total number of reports sent: "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lbc;->a(Ljava/lang/String;)V

    .line 288
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_3
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_5

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/json/JSONObject;

    .line 289
    iget-object v2, p0, Law;->b:Lao;

    invoke-virtual {v2, v0}, Lao;->b(Lorg/json/JSONObject;)V

    goto :goto_3

    .line 291
    :cond_5
    iget-object v0, p0, Law;->c:Lah;

    invoke-virtual {v0}, Lah;->a()V

    goto :goto_1
.end method

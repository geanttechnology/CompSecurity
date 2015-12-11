.class final Li;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private final a:J

.field private final b:Lb$1;

.field private synthetic c:Lg;


# direct methods
.method private constructor <init>(Lg;J)V
    .locals 2

    .prologue
    .line 253
    iput-object p1, p0, Li;->c:Lg;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 251
    sget-object v0, Ll;->d:Lb$1;

    iput-object v0, p0, Li;->b:Lb$1;

    .line 254
    iput-wide p2, p0, Li;->a:J

    .line 255
    return-void
.end method

.method synthetic constructor <init>(Lg;JB)V
    .locals 0

    .prologue
    .line 249
    invoke-direct {p0, p1, p2, p3}, Li;-><init>(Lg;J)V

    return-void
.end method

.method private a(Ljava/io/File;)Z
    .locals 5

    .prologue
    const/4 v0, 0x0

    .line 330
    const-string v1, "Deleting %s"

    invoke-virtual {p1}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lbc;->a(Ljava/lang/String;Ljava/lang/Object;)V

    .line 331
    invoke-virtual {p1}, Ljava/io/File;->isDirectory()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 332
    invoke-virtual {p1}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v2

    array-length v3, v2

    move v1, v0

    :goto_0
    if-ge v1, v3, :cond_1

    aget-object v4, v2, v1

    .line 333
    invoke-direct {p0, v4}, Li;->a(Ljava/io/File;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 339
    :goto_1
    return v0

    .line 332
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 339
    :cond_1
    invoke-virtual {p1}, Ljava/io/File;->delete()Z

    move-result v0

    goto :goto_1
.end method

.method private a(Lk;)Z
    .locals 5

    .prologue
    .line 344
    :try_start_0
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Size of dex file = "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p1, Lk;->c:Ljava/io/File;

    invoke-virtual {v1}, Ljava/io/File;->length()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lbc;->a(Ljava/lang/String;)V

    .line 345
    new-instance v0, Ldalvik/system/DexClassLoader;

    iget-object v1, p1, Lk;->c:Ljava/io/File;

    invoke-virtual {v1}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p1, Lk;->d:Ljava/io/File;

    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    const-class v4, Lg;

    invoke-virtual {v4}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v4

    invoke-direct {v0, v1, v2, v3, v4}, Ldalvik/system/DexClassLoader;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V

    .line 351
    iget-object v1, p0, Li;->c:Lg;

    invoke-static {v1, v0}, Lg;->a(Lg;Ljava/lang/ClassLoader;)Lh;

    move-result-object v0

    .line 352
    const-string v1, "Finished verifying the downloaded dex file @ %s. Total number of info points enabled for next restart is #%d."

    iget-object v2, p1, Lk;->c:Ljava/io/File;

    invoke-interface {v0}, Lh;->b()I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-static {v1, v2, v0}, Lbc;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 354
    const/4 v0, 0x1

    .line 357
    :goto_0
    return v0

    .line 355
    :catch_0
    move-exception v0

    .line 356
    const-string v1, "Error attempting to verify downloaded dex file"

    invoke-static {v1, v0}, Lp;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 357
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public final run()V
    .locals 6

    .prologue
    .line 260
    :try_start_0
    iget-object v0, p0, Li;->b:Lb$1;

    invoke-virtual {v0}, Lb$1;->e()J

    move-result-wide v0

    .line 261
    iget-wide v2, p0, Li;->a:J

    cmp-long v0, v0, v2

    if-ltz v0, :cond_0

    .line 327
    :goto_0
    return-void

    .line 266
    :cond_0
    iget-object v0, p0, Li;->c:Lg;

    invoke-static {v0}, Lg;->b(Lg;)Le;

    move-result-object v0

    .line 267
    const-string v1, "Info point version has changed to #%s on the server. Attempting to download info points from %s"

    iget-wide v2, p0, Li;->a:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0}, Le;->a()Ljava/net/URL;

    move-result-object v3

    invoke-static {v1, v2, v3}, Lbc;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 269
    const-string v1, "infopVersion"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-wide v4, p0, Li;->a:J

    invoke-virtual {v2, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Le;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 270
    new-instance v1, Lk;

    sget-object v2, Ll;->c:Ll;

    iget-object v2, v2, Ll;->m:Landroid/content/Context;

    iget-wide v4, p0, Li;->a:J

    const/4 v3, 0x0

    invoke-direct {v1, v2, v4, v5, v3}, Lk;-><init>(Landroid/content/Context;JB)V

    .line 274
    iget-object v2, v1, Lk;->a:Ljava/io/File;

    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_2

    iget-object v2, v1, Lk;->a:Ljava/io/File;

    invoke-direct {p0, v2}, Li;->a(Ljava/io/File;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 275
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Failed to delete files under:"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, v1, Lk;->a:Ljava/io/File;

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 326
    :catch_0
    move-exception v0

    .line 319
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Error while attempting to download dex with version = "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-wide v2, p0, Li;->a:J

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v0}, Lbc;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 321
    iget-object v1, p0, Li;->c:Lg;

    monitor-enter v1

    .line 322
    :try_start_1
    iget-object v0, p0, Li;->c:Lg;

    invoke-static {v0}, Lg;->a(Lg;)J

    move-result-wide v2

    iget-wide v4, p0, Li;->a:J

    cmp-long v0, v2, v4

    if-nez v0, :cond_1

    .line 323
    iget-object v0, p0, Li;->c:Lg;

    const-wide/16 v2, -0x1

    invoke-static {v0, v2, v3}, Lg;->a(Lg;J)J

    .line 325
    :cond_1
    monitor-exit v1

    goto/16 :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0

    .line 278
    :cond_2
    :try_start_2
    iget-object v2, v1, Lk;->a:Ljava/io/File;

    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v2

    if-nez v2, :cond_3

    iget-object v2, v1, Lk;->a:Ljava/io/File;

    invoke-virtual {v2}, Ljava/io/File;->mkdirs()Z

    move-result v2

    if-nez v2, :cond_3

    .line 279
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Failed to create parent dex directory: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, v1, Lk;->a:Ljava/io/File;

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ". Info points cannot run"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 282
    :cond_3
    iget-object v2, v1, Lk;->b:Ljava/io/File;

    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v2

    if-nez v2, :cond_4

    iget-object v2, v1, Lk;->b:Ljava/io/File;

    invoke-virtual {v2}, Ljava/io/File;->mkdirs()Z

    move-result v2

    if-nez v2, :cond_4

    .line 283
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Failed to create dex directory: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, v1, Lk;->b:Ljava/io/File;

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ". Info points cannot run"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 286
    :cond_4
    iget-object v2, v1, Lk;->d:Ljava/io/File;

    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v2

    if-nez v2, :cond_5

    iget-object v2, v1, Lk;->d:Ljava/io/File;

    invoke-virtual {v2}, Ljava/io/File;->mkdirs()Z

    move-result v2

    if-nez v2, :cond_5

    .line 287
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Failed to create optimized cache directory for dex loading: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, v1, Lk;->d:Ljava/io/File;

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 291
    :cond_5
    invoke-virtual {v0}, Le;->h()I

    move-result v2

    const/16 v3, 0xc8

    if-eq v2, v3, :cond_6

    .line 292
    new-instance v1, Ljava/io/IOException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Invalid response code "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Le;->h()I

    move-result v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, " from the server."

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 295
    :cond_6
    new-instance v2, Ljava/io/FileOutputStream;

    iget-object v3, v1, Lk;->c:Ljava/io/File;

    invoke-direct {v2, v3}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    .line 296
    new-instance v3, Ljava/io/BufferedInputStream;

    invoke-virtual {v0}, Le;->g()Ljava/io/InputStream;

    move-result-object v0

    invoke-direct {v3, v0}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V

    .line 297
    const/16 v0, 0x1000

    new-array v0, v0, [B

    .line 299
    :goto_1
    invoke-virtual {v3, v0}, Ljava/io/BufferedInputStream;->read([B)I

    move-result v4

    const/4 v5, -0x1

    if-eq v4, v5, :cond_7

    .line 300
    const/4 v5, 0x0

    invoke-virtual {v2, v0, v5, v4}, Ljava/io/FileOutputStream;->write([BII)V

    goto :goto_1

    .line 304
    :cond_7
    invoke-virtual {v2}, Ljava/io/FileOutputStream;->close()V

    .line 305
    invoke-virtual {v3}, Ljava/io/BufferedInputStream;->close()V

    .line 307
    invoke-direct {p0, v1}, Li;->a(Lk;)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 308
    const-string v0, "Finished downloading info points. Updating info point version and enabled flag."

    invoke-static {v0}, Lbc;->a(Ljava/lang/String;)V

    .line 309
    iget-object v0, p0, Li;->b:Lb$1;

    iget-wide v2, p0, Li;->a:J

    invoke-virtual {v0, v2, v3}, Lb$1;->a(J)V

    goto/16 :goto_0

    .line 311
    :cond_8
    iget-object v0, p0, Li;->c:Lg;

    iget-object v1, p0, Li;->b:Lb$1;

    invoke-static {v0, v1}, Lg;->a(Lg;Lb$1;)V

    .line 312
    iget-object v1, p0, Li;->c:Lg;

    monitor-enter v1
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    .line 313
    :try_start_3
    iget-object v0, p0, Li;->c:Lg;

    invoke-static {v0}, Lg;->a(Lg;)J

    move-result-wide v2

    iget-wide v4, p0, Li;->a:J

    cmp-long v0, v2, v4

    if-nez v0, :cond_9

    .line 314
    iget-object v0, p0, Li;->c:Lg;

    const-wide/16 v2, -0x1

    invoke-static {v0, v2, v3}, Lg;->a(Lg;J)J

    .line 316
    :cond_9
    monitor-exit v1

    goto/16 :goto_0

    :catchall_1
    move-exception v0

    monitor-exit v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    :try_start_4
    throw v0
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0
.end method

.class Lcom/exacttarget/etpushsdk/util/h;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:[Ljava/lang/Object;

.field final synthetic b:Ljava/lang/String;

.field final synthetic c:Ljava/lang/String;

.field final synthetic d:Lcom/exacttarget/etpushsdk/util/ETLogger;


# direct methods
.method constructor <init>(Lcom/exacttarget/etpushsdk/util/ETLogger;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 238
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/util/h;->d:Lcom/exacttarget/etpushsdk/util/ETLogger;

    iput-object p2, p0, Lcom/exacttarget/etpushsdk/util/h;->a:[Ljava/lang/Object;

    iput-object p3, p0, Lcom/exacttarget/etpushsdk/util/h;->b:Ljava/lang/String;

    iput-object p4, p0, Lcom/exacttarget/etpushsdk/util/h;->c:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 10

    .prologue
    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 242
    .line 243
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/util/h;->a:[Ljava/lang/Object;

    if-eqz v0, :cond_a

    iget-object v0, p0, Lcom/exacttarget/etpushsdk/util/h;->a:[Ljava/lang/Object;

    array-length v0, v0

    if-lez v0, :cond_a

    .line 244
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/util/h;->a:[Ljava/lang/Object;

    aget-object v0, v0, v2

    instance-of v0, v0, Ljava/lang/Throwable;

    if-eqz v0, :cond_a

    .line 245
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/util/h;->a:[Ljava/lang/Object;

    aget-object v0, v0, v2

    check-cast v0, Ljava/lang/Throwable;

    .line 251
    :goto_0
    iget-object v3, p0, Lcom/exacttarget/etpushsdk/util/h;->b:Ljava/lang/String;

    if-eqz v3, :cond_9

    .line 252
    iget-object v3, p0, Lcom/exacttarget/etpushsdk/util/h;->b:Ljava/lang/String;

    const-string v4, "\n"

    invoke-virtual {v3, v4}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 253
    iget-object v3, p0, Lcom/exacttarget/etpushsdk/util/h;->b:Ljava/lang/String;

    const-string v4, "\n"

    invoke-virtual {v3, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    move-object v4, v3

    .line 260
    :goto_1
    if-eqz v0, :cond_8

    .line 261
    invoke-virtual {v0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    .line 262
    invoke-virtual {v0}, Ljava/lang/Throwable;->getStackTrace()[Ljava/lang/StackTraceElement;

    move-result-object v0

    .line 264
    array-length v0, v0

    add-int/lit8 v0, v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    move-object v3, v0

    .line 267
    :goto_2
    if-nez v4, :cond_1

    if-nez v3, :cond_1

    .line 301
    :goto_3
    return-void

    .line 255
    :cond_0
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    iget-object v4, p0, Lcom/exacttarget/etpushsdk/util/h;->b:Ljava/lang/String;

    aput-object v4, v3, v2

    move-object v4, v3

    goto :goto_1

    .line 272
    :cond_1
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    .line 274
    # getter for: Lcom/exacttarget/etpushsdk/util/ETLogger;->inMemoryLog:Ljava/lang/StringBuilder;
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/ETLogger;->access$000()Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->length()I

    move-result v0

    if-nez v0, :cond_2

    .line 275
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/util/h;->d:Lcom/exacttarget/etpushsdk/util/ETLogger;

    # invokes: Lcom/exacttarget/etpushsdk/util/ETLogger;->addVersionInfo()Ljava/lang/String;
    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/ETLogger;->access$100(Lcom/exacttarget/etpushsdk/util/ETLogger;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 278
    :cond_2
    if-eqz v4, :cond_4

    .line 279
    array-length v6, v4

    move v0, v2

    :goto_4
    if-ge v0, v6, :cond_4

    aget-object v7, v4, v0

    .line 280
    invoke-static {v7}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v8

    if-nez v8, :cond_3

    .line 281
    iget-object v8, p0, Lcom/exacttarget/etpushsdk/util/h;->d:Lcom/exacttarget/etpushsdk/util/ETLogger;

    iget-object v9, p0, Lcom/exacttarget/etpushsdk/util/h;->c:Ljava/lang/String;

    # invokes: Lcom/exacttarget/etpushsdk/util/ETLogger;->formatLogLine(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    invoke-static {v8, v9, v7}, Lcom/exacttarget/etpushsdk/util/ETLogger;->access$200(Lcom/exacttarget/etpushsdk/util/ETLogger;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 279
    :cond_3
    add-int/lit8 v0, v0, 0x1

    goto :goto_4

    .line 286
    :cond_4
    if-eqz v3, :cond_6

    .line 287
    array-length v4, v3

    move v0, v2

    :goto_5
    if-ge v0, v4, :cond_6

    aget-object v2, v3, v0

    .line 288
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_5

    .line 289
    iget-object v6, p0, Lcom/exacttarget/etpushsdk/util/h;->d:Lcom/exacttarget/etpushsdk/util/ETLogger;

    iget-object v7, p0, Lcom/exacttarget/etpushsdk/util/h;->c:Ljava/lang/String;

    # invokes: Lcom/exacttarget/etpushsdk/util/ETLogger;->formatLogLine(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    invoke-static {v6, v7, v2}, Lcom/exacttarget/etpushsdk/util/ETLogger;->access$200(Lcom/exacttarget/etpushsdk/util/ETLogger;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 287
    :cond_5
    add-int/lit8 v0, v0, 0x1

    goto :goto_5

    .line 294
    :cond_6
    # getter for: Lcom/exacttarget/etpushsdk/util/ETLogger;->inMemoryLog:Ljava/lang/StringBuilder;
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/ETLogger;->access$000()Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->length()I

    move-result v0

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->length()I

    move-result v2

    add-int/2addr v0, v2

    int-to-long v2, v0

    # getter for: Lcom/exacttarget/etpushsdk/util/ETLogger;->maxMemorySize:J
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/ETLogger;->access$300()J

    move-result-wide v6

    cmp-long v0, v2, v6

    if-lez v0, :cond_7

    .line 296
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/util/h;->d:Lcom/exacttarget/etpushsdk/util/ETLogger;

    # invokes: Lcom/exacttarget/etpushsdk/util/ETLogger;->flushLogToFile(Ljava/lang/String;)V
    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/ETLogger;->access$400(Lcom/exacttarget/etpushsdk/util/ETLogger;Ljava/lang/String;)V

    .line 299
    :cond_7
    # getter for: Lcom/exacttarget/etpushsdk/util/ETLogger;->inMemoryLog:Ljava/lang/StringBuilder;
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/ETLogger;->access$000()Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_3

    :cond_8
    move-object v3, v1

    goto/16 :goto_2

    :cond_9
    move-object v4, v1

    goto/16 :goto_1

    :cond_a
    move-object v0, v1

    goto/16 :goto_0
.end method

.class Lcom/exacttarget/etpushsdk/y;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Lcom/exacttarget/etpushsdk/ETPush;


# direct methods
.method constructor <init>(Lcom/exacttarget/etpushsdk/ETPush;)V
    .locals 0

    .prologue
    .line 1279
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/y;->a:Lcom/exacttarget/etpushsdk/ETPush;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 1282
    :try_start_0
    const-string v0, "~!ETPush"

    const-string v1, "Requesting GCM Registration"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1283
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->k()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lsg;->a(Landroid/content/Context;)Lsg;

    move-result-object v0

    .line 1285
    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->d()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-virtual {v0, v1}, Lsg;->a([Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1287
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->n()Lcom/exacttarget/etpushsdk/data/Registration;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/exacttarget/etpushsdk/data/Registration;->setSystemTokenInCache(Ljava/lang/String;)V

    .line 1289
    const-string v1, "~!ETPush"

    const-string v2, "GCM Registration complete. System Token received: %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1293
    :goto_0
    return-void

    .line 1290
    :catch_0
    move-exception v0

    .line 1291
    const-string v1, "~!ETPush"

    invoke-virtual {v0}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.class public Lcom/livemixtapes/AsyncHttp;
.super Ljava/lang/Object;
.source "AsyncHttp.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/livemixtapes/AsyncHttp$AsyncGet;,
        Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;,
        Lcom/livemixtapes/AsyncHttp$AsyncPost;,
        Lcom/livemixtapes/AsyncHttp$AsyncRequest;,
        Lcom/livemixtapes/AsyncHttp$HttpResponseData;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final get(Ljava/lang/String;)V
    .locals 2
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 265
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {p0, p1, v1, v1, v0}, Lcom/livemixtapes/AsyncHttp;->get(Ljava/lang/String;Ljava/util/Map;Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;Ljava/lang/Boolean;)V

    .line 266
    return-void
.end method

.method public final get(Ljava/lang/String;Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;)V
    .locals 2
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "callback"    # Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;

    .prologue
    .line 257
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {p0, p1, v0, p2, v1}, Lcom/livemixtapes/AsyncHttp;->get(Ljava/lang/String;Ljava/util/Map;Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;Ljava/lang/Boolean;)V

    .line 258
    return-void
.end method

.method public final get(Ljava/lang/String;Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;Ljava/lang/Boolean;)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "callback"    # Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;
    .param p3, "json"    # Ljava/lang/Boolean;

    .prologue
    .line 253
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0, p2, p3}, Lcom/livemixtapes/AsyncHttp;->get(Ljava/lang/String;Ljava/util/Map;Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;Ljava/lang/Boolean;)V

    .line 254
    return-void
.end method

.method public final get(Ljava/lang/String;Ljava/lang/Boolean;)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "json"    # Ljava/lang/Boolean;

    .prologue
    const/4 v0, 0x0

    .line 261
    invoke-virtual {p0, p1, v0, v0, p2}, Lcom/livemixtapes/AsyncHttp;->get(Ljava/lang/String;Ljava/util/Map;Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;Ljava/lang/Boolean;)V

    .line 262
    return-void
.end method

.method public final get(Ljava/lang/String;Ljava/util/Map;Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;
    .param p3, "callback"    # Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;",
            ")V"
        }
    .end annotation

    .prologue
    .line 249
    .local p2, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {p0, p1, p2, p3, v0}, Lcom/livemixtapes/AsyncHttp;->get(Ljava/lang/String;Ljava/util/Map;Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;Ljava/lang/Boolean;)V

    .line 250
    return-void
.end method

.method public final get(Ljava/lang/String;Ljava/util/Map;Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;Ljava/lang/Boolean;)V
    .locals 6
    .param p1, "url"    # Ljava/lang/String;
    .param p3, "callback"    # Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;
    .param p4, "json"    # Ljava/lang/Boolean;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;",
            "Ljava/lang/Boolean;",
            ")V"
        }
    .end annotation

    .prologue
    .line 245
    .local p2, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v0, Lcom/livemixtapes/AsyncHttp$AsyncGet;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/livemixtapes/AsyncHttp$AsyncGet;-><init>(Lcom/livemixtapes/AsyncHttp;Ljava/lang/String;Ljava/util/Map;Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;Ljava/lang/Boolean;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/livemixtapes/AsyncHttp$AsyncGet;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 246
    return-void
.end method

.method public final post(Ljava/lang/String;)V
    .locals 2
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 291
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {p0, p1, v1, v1, v0}, Lcom/livemixtapes/AsyncHttp;->post(Ljava/lang/String;Ljava/util/Map;Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;Ljava/lang/Boolean;)V

    .line 292
    return-void
.end method

.method public final post(Ljava/lang/String;Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;)V
    .locals 2
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "callback"    # Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;

    .prologue
    .line 283
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {p0, p1, v0, p2, v1}, Lcom/livemixtapes/AsyncHttp;->post(Ljava/lang/String;Ljava/util/Map;Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;Ljava/lang/Boolean;)V

    .line 284
    return-void
.end method

.method public final post(Ljava/lang/String;Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;Ljava/lang/Boolean;)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "callback"    # Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;
    .param p3, "json"    # Ljava/lang/Boolean;

    .prologue
    .line 279
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0, p2, p3}, Lcom/livemixtapes/AsyncHttp;->post(Ljava/lang/String;Ljava/util/Map;Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;Ljava/lang/Boolean;)V

    .line 280
    return-void
.end method

.method public final post(Ljava/lang/String;Ljava/lang/Boolean;)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "json"    # Ljava/lang/Boolean;

    .prologue
    const/4 v0, 0x0

    .line 287
    invoke-virtual {p0, p1, v0, v0, p2}, Lcom/livemixtapes/AsyncHttp;->post(Ljava/lang/String;Ljava/util/Map;Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;Ljava/lang/Boolean;)V

    .line 288
    return-void
.end method

.method public final post(Ljava/lang/String;Ljava/util/Map;Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;
    .param p3, "callback"    # Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;",
            ")V"
        }
    .end annotation

    .prologue
    .line 275
    .local p2, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {p0, p1, p2, p3, v0}, Lcom/livemixtapes/AsyncHttp;->post(Ljava/lang/String;Ljava/util/Map;Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;Ljava/lang/Boolean;)V

    .line 276
    return-void
.end method

.method public final post(Ljava/lang/String;Ljava/util/Map;Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;Ljava/lang/Boolean;)V
    .locals 7
    .param p1, "url"    # Ljava/lang/String;
    .param p3, "callback"    # Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;
    .param p4, "json"    # Ljava/lang/Boolean;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;",
            "Ljava/lang/Boolean;",
            ")V"
        }
    .end annotation

    .prologue
    .local p2, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v6, 0x0

    .line 270
    new-instance v0, Lcom/livemixtapes/AsyncHttp$AsyncPost;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/livemixtapes/AsyncHttp$AsyncPost;-><init>(Lcom/livemixtapes/AsyncHttp;Ljava/lang/String;Ljava/util/Map;Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;Ljava/lang/Boolean;)V

    new-array v1, v6, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/livemixtapes/AsyncHttp$AsyncPost;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/Object;

    .line 271
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "POSTING URL: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    aput-object v1, v0, v6

    invoke-static {v0}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 272
    return-void
.end method

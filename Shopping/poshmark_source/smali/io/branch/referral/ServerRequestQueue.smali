.class Lio/branch/referral/ServerRequestQueue;
.super Ljava/lang/Object;
.source "ServerRequestQueue.java"


# static fields
.field private static final MAX_ITEMS:I = 0x19

.field private static final PREF_KEY:Ljava/lang/String; = "BNCServerRequestQueue"

.field private static SharedInstance:Lio/branch/referral/ServerRequestQueue;


# instance fields
.field private editor:Landroid/content/SharedPreferences$Editor;

.field private final queue:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lio/branch/referral/ServerRequest;",
            ">;"
        }
    .end annotation
.end field

.field private sharedPref:Landroid/content/SharedPreferences;


# direct methods
.method private constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "c"    # Landroid/content/Context;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "CommitPrefEdits"
        }
    .end annotation

    .prologue
    .line 59
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 60
    const-string v0, "BNC_Server_Request_Queue"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lio/branch/referral/ServerRequestQueue;->sharedPref:Landroid/content/SharedPreferences;

    .line 61
    iget-object v0, p0, Lio/branch/referral/ServerRequestQueue;->sharedPref:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    iput-object v0, p0, Lio/branch/referral/ServerRequestQueue;->editor:Landroid/content/SharedPreferences$Editor;

    .line 62
    invoke-direct {p0, p1}, Lio/branch/referral/ServerRequestQueue;->retrieve(Landroid/content/Context;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lio/branch/referral/ServerRequestQueue;->queue:Ljava/util/List;

    .line 63
    return-void
.end method

.method static synthetic access$000(Lio/branch/referral/ServerRequestQueue;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lio/branch/referral/ServerRequestQueue;

    .prologue
    .line 23
    iget-object v0, p0, Lio/branch/referral/ServerRequestQueue;->queue:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$100(Lio/branch/referral/ServerRequestQueue;)Landroid/content/SharedPreferences$Editor;
    .locals 1
    .param p0, "x0"    # Lio/branch/referral/ServerRequestQueue;

    .prologue
    .line 23
    iget-object v0, p0, Lio/branch/referral/ServerRequestQueue;->editor:Landroid/content/SharedPreferences$Editor;

    return-object v0
.end method

.method public static getInstance(Landroid/content/Context;)Lio/branch/referral/ServerRequestQueue;
    .locals 2
    .param p0, "c"    # Landroid/content/Context;

    .prologue
    .line 42
    sget-object v0, Lio/branch/referral/ServerRequestQueue;->SharedInstance:Lio/branch/referral/ServerRequestQueue;

    if-nez v0, :cond_1

    .line 43
    const-class v1, Lio/branch/referral/ServerRequestQueue;

    monitor-enter v1

    .line 44
    :try_start_0
    sget-object v0, Lio/branch/referral/ServerRequestQueue;->SharedInstance:Lio/branch/referral/ServerRequestQueue;

    if-nez v0, :cond_0

    .line 45
    new-instance v0, Lio/branch/referral/ServerRequestQueue;

    invoke-direct {v0, p0}, Lio/branch/referral/ServerRequestQueue;-><init>(Landroid/content/Context;)V

    sput-object v0, Lio/branch/referral/ServerRequestQueue;->SharedInstance:Lio/branch/referral/ServerRequestQueue;

    .line 47
    :cond_0
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 49
    :cond_1
    sget-object v0, Lio/branch/referral/ServerRequestQueue;->SharedInstance:Lio/branch/referral/ServerRequestQueue;

    return-object v0

    .line 47
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method private persist()V
    .locals 2

    .prologue
    .line 66
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lio/branch/referral/ServerRequestQueue$1;

    invoke-direct {v1, p0}, Lio/branch/referral/ServerRequestQueue$1;-><init>(Lio/branch/referral/ServerRequestQueue;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 90
    return-void
.end method

.method private retrieve(Landroid/content/Context;)Ljava/util/List;
    .locals 9
    .param p1, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            ")",
            "Ljava/util/List",
            "<",
            "Lio/branch/referral/ServerRequest;",
            ">;"
        }
    .end annotation

    .prologue
    .line 93
    new-instance v6, Ljava/util/LinkedList;

    invoke-direct {v6}, Ljava/util/LinkedList;-><init>()V

    invoke-static {v6}, Ljava/util/Collections;->synchronizedList(Ljava/util/List;)Ljava/util/List;

    move-result-object v5

    .line 94
    .local v5, "result":Ljava/util/List;, "Ljava/util/List<Lio/branch/referral/ServerRequest;>;"
    iget-object v6, p0, Lio/branch/referral/ServerRequestQueue;->sharedPref:Landroid/content/SharedPreferences;

    const-string v7, "BNCServerRequestQueue"

    const/4 v8, 0x0

    invoke-interface {v6, v7, v8}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 96
    .local v3, "jsonStr":Ljava/lang/String;
    if-eqz v3, :cond_1

    .line 98
    :try_start_0
    new-instance v6, Lorg/json/JSONArray;

    invoke-static {v3}, Lcom/newrelic/agent/android/instrumentation/JSONArrayInstrumentation;->init(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    .line 99
    .local v2, "jsonArr":Lorg/json/JSONArray;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v6

    const/16 v7, 0x19

    invoke-static {v6, v7}, Ljava/lang/Math;->min(II)I

    move-result v6

    if-ge v0, v6, :cond_1

    .line 100
    invoke-virtual {v2, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v1

    .line 101
    .local v1, "json":Lorg/json/JSONObject;
    invoke-static {v1, p1}, Lio/branch/referral/ServerRequest;->fromJSON(Lorg/json/JSONObject;Landroid/content/Context;)Lio/branch/referral/ServerRequest;

    move-result-object v4

    .line 102
    .local v4, "req":Lio/branch/referral/ServerRequest;
    if-eqz v4, :cond_0

    .line 103
    invoke-interface {v5, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 99
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 106
    .end local v0    # "i":I
    .end local v1    # "json":Lorg/json/JSONObject;
    .end local v2    # "jsonArr":Lorg/json/JSONArray;
    .end local v4    # "req":Lio/branch/referral/ServerRequest;
    :catch_0
    move-exception v6

    .line 110
    :cond_1
    return-object v5
.end method


# virtual methods
.method public clear()V
    .locals 1

    .prologue
    .line 255
    :try_start_0
    iget-object v0, p0, Lio/branch/referral/ServerRequestQueue;->queue:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 256
    invoke-direct {p0}, Lio/branch/referral/ServerRequestQueue;->persist()V
    :try_end_0
    .catch Ljava/lang/UnsupportedOperationException; {:try_start_0 .. :try_end_0} :catch_0

    .line 259
    :goto_0
    return-void

    .line 257
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public containsClose()Z
    .locals 5

    .prologue
    .line 268
    iget-object v3, p0, Lio/branch/referral/ServerRequestQueue;->queue:Ljava/util/List;

    monitor-enter v3

    .line 269
    :try_start_0
    iget-object v2, p0, Lio/branch/referral/ServerRequestQueue;->queue:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lio/branch/referral/ServerRequest;

    .line 270
    .local v1, "req":Lio/branch/referral/ServerRequest;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Lio/branch/referral/ServerRequest;->getRequestPath()Ljava/lang/String;

    move-result-object v2

    sget-object v4, Lio/branch/referral/Defines$RequestPath;->RegisterClose:Lio/branch/referral/Defines$RequestPath;

    invoke-virtual {v4}, Lio/branch/referral/Defines$RequestPath;->getPath()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 272
    const/4 v2, 0x1

    monitor-exit v3

    .line 276
    .end local v1    # "req":Lio/branch/referral/ServerRequest;
    :goto_0
    return v2

    .line 275
    :cond_1
    monitor-exit v3

    .line 276
    const/4 v2, 0x0

    goto :goto_0

    .line 275
    .end local v0    # "i$":Ljava/util/Iterator;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2
.end method

.method public containsInstallOrOpen()Z
    .locals 4

    .prologue
    .line 287
    iget-object v3, p0, Lio/branch/referral/ServerRequestQueue;->queue:Ljava/util/List;

    monitor-enter v3

    .line 288
    :try_start_0
    iget-object v2, p0, Lio/branch/referral/ServerRequestQueue;->queue:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lio/branch/referral/ServerRequest;

    .line 289
    .local v1, "req":Lio/branch/referral/ServerRequest;
    if-eqz v1, :cond_0

    instance-of v2, v1, Lio/branch/referral/ServerRequestRegisterInstall;

    if-nez v2, :cond_1

    instance-of v2, v1, Lio/branch/referral/ServerRequestRegisterOpen;

    if-eqz v2, :cond_0

    .line 291
    :cond_1
    const/4 v2, 0x1

    monitor-exit v3

    .line 295
    .end local v1    # "req":Lio/branch/referral/ServerRequest;
    :goto_0
    return v2

    .line 294
    :cond_2
    monitor-exit v3

    .line 295
    const/4 v2, 0x0

    goto :goto_0

    .line 294
    .end local v0    # "i$":Ljava/util/Iterator;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2
.end method

.method public dequeue()Lio/branch/referral/ServerRequest;
    .locals 4

    .prologue
    .line 146
    const/4 v1, 0x0

    .line 148
    .local v1, "req":Lio/branch/referral/ServerRequest;
    :try_start_0
    iget-object v2, p0, Lio/branch/referral/ServerRequestQueue;->queue:Ljava/util/List;

    const/4 v3, 0x0

    invoke-interface {v2, v3}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    move-result-object v2

    move-object v0, v2

    check-cast v0, Lio/branch/referral/ServerRequest;

    move-object v1, v0

    .line 149
    invoke-direct {p0}, Lio/branch/referral/ServerRequestQueue;->persist()V
    :try_end_0
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/util/NoSuchElementException; {:try_start_0 .. :try_end_0} :catch_0

    .line 153
    :goto_0
    return-object v1

    .line 151
    :catch_0
    move-exception v2

    goto :goto_0

    .line 150
    :catch_1
    move-exception v2

    goto :goto_0
.end method

.method public enqueue(Lio/branch/referral/ServerRequest;)V
    .locals 2
    .param p1, "request"    # Lio/branch/referral/ServerRequest;

    .prologue
    .line 130
    if-eqz p1, :cond_1

    .line 131
    iget-object v0, p0, Lio/branch/referral/ServerRequestQueue;->queue:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 132
    invoke-virtual {p0}, Lio/branch/referral/ServerRequestQueue;->getSize()I

    move-result v0

    const/16 v1, 0x19

    if-lt v0, v1, :cond_0

    .line 133
    iget-object v0, p0, Lio/branch/referral/ServerRequestQueue;->queue:Ljava/util/List;

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    .line 135
    :cond_0
    invoke-direct {p0}, Lio/branch/referral/ServerRequestQueue;->persist()V

    .line 137
    :cond_1
    return-void
.end method

.method public getSize()I
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lio/branch/referral/ServerRequestQueue;->queue:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public insert(Lio/branch/referral/ServerRequest;I)V
    .locals 1
    .param p1, "request"    # Lio/branch/referral/ServerRequest;
    .param p2, "index"    # I

    .prologue
    .line 205
    :try_start_0
    iget-object v0, p0, Lio/branch/referral/ServerRequestQueue;->queue:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge v0, p2, :cond_0

    .line 206
    iget-object v0, p0, Lio/branch/referral/ServerRequestQueue;->queue:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result p2

    .line 208
    :cond_0
    iget-object v0, p0, Lio/branch/referral/ServerRequestQueue;->queue:Ljava/util/List;

    invoke-interface {v0, p2, p1}, Ljava/util/List;->add(ILjava/lang/Object;)V

    .line 209
    invoke-direct {p0}, Lio/branch/referral/ServerRequestQueue;->persist()V
    :try_end_0
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_0 .. :try_end_0} :catch_0

    .line 212
    :goto_0
    return-void

    .line 210
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public moveInstallOrOpenToFront(Lio/branch/referral/ServerRequest;ILio/branch/referral/Branch$BranchReferralInitListener;)V
    .locals 4
    .param p1, "request"    # Lio/branch/referral/ServerRequest;
    .param p2, "networkCount"    # I
    .param p3, "callback"    # Lio/branch/referral/Branch$BranchReferralInitListener;

    .prologue
    .line 309
    iget-object v3, p0, Lio/branch/referral/ServerRequestQueue;->queue:Ljava/util/List;

    monitor-enter v3

    .line 310
    :try_start_0
    iget-object v2, p0, Lio/branch/referral/ServerRequestQueue;->queue:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 311
    .local v0, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Lio/branch/referral/ServerRequest;>;"
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 312
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lio/branch/referral/ServerRequest;

    .line 313
    .local v1, "req":Lio/branch/referral/ServerRequest;
    if-eqz v1, :cond_0

    instance-of v2, v1, Lio/branch/referral/ServerRequestRegisterInstall;

    if-nez v2, :cond_1

    instance-of v2, v1, Lio/branch/referral/ServerRequestRegisterOpen;

    if-eqz v2, :cond_0

    .line 316
    :cond_1
    invoke-interface {v0}, Ljava/util/Iterator;->remove()V

    .line 320
    .end local v1    # "req":Lio/branch/referral/ServerRequest;
    :cond_2
    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 322
    if-nez p2, :cond_3

    .line 323
    const/4 v2, 0x0

    invoke-virtual {p0, p1, v2}, Lio/branch/referral/ServerRequestQueue;->insert(Lio/branch/referral/ServerRequest;I)V

    .line 327
    :goto_0
    return-void

    .line 320
    .end local v0    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Lio/branch/referral/ServerRequest;>;"
    :catchall_0
    move-exception v2

    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v2

    .line 325
    .restart local v0    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Lio/branch/referral/ServerRequest;>;"
    :cond_3
    const/4 v2, 0x1

    invoke-virtual {p0, p1, v2}, Lio/branch/referral/ServerRequestQueue;->insert(Lio/branch/referral/ServerRequest;I)V

    goto :goto_0
.end method

.method public peek()Lio/branch/referral/ServerRequest;
    .locals 4

    .prologue
    .line 163
    const/4 v1, 0x0

    .line 165
    .local v1, "req":Lio/branch/referral/ServerRequest;
    :try_start_0
    iget-object v2, p0, Lio/branch/referral/ServerRequestQueue;->queue:Ljava/util/List;

    const/4 v3, 0x0

    invoke-interface {v2, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    move-object v0, v2

    check-cast v0, Lio/branch/referral/ServerRequest;

    move-object v1, v0
    :try_end_0
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/util/NoSuchElementException; {:try_start_0 .. :try_end_0} :catch_0

    .line 169
    :goto_0
    return-object v1

    .line 167
    :catch_0
    move-exception v2

    goto :goto_0

    .line 166
    :catch_1
    move-exception v2

    goto :goto_0
.end method

.method public peekAt(I)Lio/branch/referral/ServerRequest;
    .locals 3
    .param p1, "index"    # I

    .prologue
    .line 184
    const/4 v1, 0x0

    .line 186
    .local v1, "req":Lio/branch/referral/ServerRequest;
    :try_start_0
    iget-object v2, p0, Lio/branch/referral/ServerRequestQueue;->queue:Ljava/util/List;

    invoke-interface {v2, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    move-object v0, v2

    check-cast v0, Lio/branch/referral/ServerRequest;

    move-object v1, v0
    :try_end_0
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/util/NoSuchElementException; {:try_start_0 .. :try_end_0} :catch_0

    .line 190
    :goto_0
    return-object v1

    .line 188
    :catch_0
    move-exception v2

    goto :goto_0

    .line 187
    :catch_1
    move-exception v2

    goto :goto_0
.end method

.method public remove(Lio/branch/referral/ServerRequest;)Z
    .locals 2
    .param p1, "request"    # Lio/branch/referral/ServerRequest;

    .prologue
    .line 241
    const/4 v0, 0x0

    .line 243
    .local v0, "isRemoved":Z
    :try_start_0
    iget-object v1, p0, Lio/branch/referral/ServerRequestQueue;->queue:Ljava/util/List;

    invoke-interface {v1, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    move-result v0

    .line 244
    invoke-direct {p0}, Lio/branch/referral/ServerRequestQueue;->persist()V
    :try_end_0
    .catch Ljava/lang/UnsupportedOperationException; {:try_start_0 .. :try_end_0} :catch_0

    .line 247
    :goto_0
    return v0

    .line 245
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method public removeAt(I)Lio/branch/referral/ServerRequest;
    .locals 3
    .param p1, "index"    # I

    .prologue
    .line 224
    const/4 v1, 0x0

    .line 226
    .local v1, "req":Lio/branch/referral/ServerRequest;
    :try_start_0
    iget-object v2, p0, Lio/branch/referral/ServerRequestQueue;->queue:Ljava/util/List;

    invoke-interface {v2, p1}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    move-result-object v2

    move-object v0, v2

    check-cast v0, Lio/branch/referral/ServerRequest;

    move-object v1, v0

    .line 227
    invoke-direct {p0}, Lio/branch/referral/ServerRequestQueue;->persist()V
    :try_end_0
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_0 .. :try_end_0} :catch_0

    .line 230
    :goto_0
    return-object v1

    .line 228
    :catch_0
    move-exception v2

    goto :goto_0
.end method

.method public setInstallOrOpenCallback(Lio/branch/referral/Branch$BranchReferralInitListener;)V
    .locals 4
    .param p1, "callback"    # Lio/branch/referral/Branch$BranchReferralInitListener;

    .prologue
    .line 335
    iget-object v3, p0, Lio/branch/referral/ServerRequestQueue;->queue:Ljava/util/List;

    monitor-enter v3

    .line 336
    :try_start_0
    iget-object v2, p0, Lio/branch/referral/ServerRequestQueue;->queue:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 337
    .local v0, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Lio/branch/referral/ServerRequest;>;"
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 338
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lio/branch/referral/ServerRequest;

    .line 339
    .local v1, "req":Lio/branch/referral/ServerRequest;
    if-eqz v1, :cond_0

    .line 340
    instance-of v2, v1, Lio/branch/referral/ServerRequestRegisterInstall;

    if-eqz v2, :cond_1

    .line 341
    check-cast v1, Lio/branch/referral/ServerRequestRegisterInstall;

    .end local v1    # "req":Lio/branch/referral/ServerRequest;
    invoke-virtual {v1, p1}, Lio/branch/referral/ServerRequestRegisterInstall;->setInitFinishedCallback(Lio/branch/referral/Branch$BranchReferralInitListener;)V

    goto :goto_0

    .line 348
    .end local v0    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Lio/branch/referral/ServerRequest;>;"
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .line 342
    .restart local v0    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Lio/branch/referral/ServerRequest;>;"
    .restart local v1    # "req":Lio/branch/referral/ServerRequest;
    :cond_1
    :try_start_1
    instance-of v2, v1, Lio/branch/referral/ServerRequestRegisterOpen;

    if-eqz v2, :cond_0

    .line 343
    check-cast v1, Lio/branch/referral/ServerRequestRegisterOpen;

    .end local v1    # "req":Lio/branch/referral/ServerRequest;
    invoke-virtual {v1, p1}, Lio/branch/referral/ServerRequestRegisterOpen;->setInitFinishedCallback(Lio/branch/referral/Branch$BranchReferralInitListener;)V

    goto :goto_0

    .line 348
    :cond_2
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 349
    return-void
.end method

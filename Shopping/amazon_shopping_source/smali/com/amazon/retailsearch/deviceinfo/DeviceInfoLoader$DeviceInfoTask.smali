.class Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$DeviceInfoTask;
.super Ljava/lang/Object;
.source "DeviceInfoLoader.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "DeviceInfoTask"
.end annotation


# instance fields
.field private final context:Landroid/content/Context;

.field final synthetic this$0:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;

.field private final ver:I


# direct methods
.method public constructor <init>(Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;Landroid/content/Context;)V
    .locals 1
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 258
    iput-object p1, p0, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$DeviceInfoTask;->this$0:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 259
    iput-object p2, p0, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$DeviceInfoTask;->context:Landroid/content/Context;

    .line 260
    # getter for: Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->version:Ljava/util/concurrent/atomic/AtomicInteger;
    invoke-static {p1}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->access$000(Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;)Ljava/util/concurrent/atomic/AtomicInteger;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->incrementAndGet()I

    move-result v0

    iput v0, p0, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$DeviceInfoTask;->ver:I

    .line 261
    return-void
.end method

.method private fetch()V
    .locals 9

    .prologue
    .line 278
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;

    iget-object v6, p0, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$DeviceInfoTask;->context:Landroid/content/Context;

    # invokes: Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->createDefaultDeviceInfo(Landroid/content/Context;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;
    invoke-static {v6}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->access$200(Landroid/content/Context;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;

    move-result-object v6

    invoke-direct {v0, v6}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;-><init>(Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;)V

    .line 283
    .local v0, "deviceBuilder":Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;
    new-instance v6, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoClient;

    invoke-direct {v6}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoClient;-><init>()V

    iget-object v7, p0, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$DeviceInfoTask;->context:Landroid/content/Context;

    invoke-virtual {v6, v7}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoClient;->getDeviceInfo(Landroid/content/Context;)Ljava/util/Map;

    move-result-object v4

    .line 285
    .local v4, "properties":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz v4, :cond_0

    invoke-interface {v4}, Ljava/util/Map;->isEmpty()Z

    move-result v6

    if-nez v6, :cond_0

    iget v6, p0, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$DeviceInfoTask;->ver:I

    iget-object v7, p0, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$DeviceInfoTask;->this$0:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;

    # getter for: Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->version:Ljava/util/concurrent/atomic/AtomicInteger;
    invoke-static {v7}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->access$000(Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;)Ljava/util/concurrent/atomic/AtomicInteger;

    move-result-object v7

    invoke-virtual {v7}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v7

    if-eq v6, v7, :cond_1

    .line 321
    :cond_0
    :goto_0
    return-void

    .line 290
    :cond_1
    invoke-interface {v4}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_2
    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_3

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 292
    .local v1, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 294
    .local v3, "key":Ljava/lang/String;
    if-eqz v3, :cond_2

    .line 299
    sget-object v6, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->SearchContext:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    invoke-virtual {v6}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_2

    sget-object v6, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->DeviceInfo:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    invoke-virtual {v6}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_2

    .line 304
    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    invoke-direct {p0, v3, v6, v0}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$DeviceInfoTask;->readValue(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;)V

    goto :goto_1

    .line 307
    .end local v1    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v3    # "key":Ljava/lang/String;
    :cond_3
    sget-object v6, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->SearchContext:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    invoke-virtual {v6}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v4, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    .line 309
    .local v5, "value":Ljava/lang/String;
    if-eqz v5, :cond_4

    .line 311
    invoke-direct {p0, v5, v0}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$DeviceInfoTask;->readSearchContext(Ljava/lang/String;Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;)V

    .line 314
    :cond_4
    iget-object v6, p0, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$DeviceInfoTask;->this$0:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;

    # getter for: Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->updateLock:Ljava/lang/Object;
    invoke-static {v6}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->access$300(Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;)Ljava/lang/Object;

    move-result-object v7

    monitor-enter v7

    .line 316
    :try_start_0
    iget v6, p0, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$DeviceInfoTask;->ver:I

    iget-object v8, p0, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$DeviceInfoTask;->this$0:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;

    # getter for: Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->version:Ljava/util/concurrent/atomic/AtomicInteger;
    invoke-static {v8}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->access$000(Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;)Ljava/util/concurrent/atomic/AtomicInteger;

    move-result-object v8

    invoke-virtual {v8}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v8

    if-ne v6, v8, :cond_5

    .line 318
    iget-object v6, p0, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$DeviceInfoTask;->this$0:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;

    move-result-object v8

    # setter for: Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->deviceInfo:Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;
    invoke-static {v6, v8}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->access$402(Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;

    .line 320
    :cond_5
    monitor-exit v7

    goto :goto_0

    :catchall_0
    move-exception v6

    monitor-exit v7
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v6
.end method

.method private readSearchContext(Ljava/lang/String;Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;)V
    .locals 7
    .param p1, "value"    # Ljava/lang/String;
    .param p2, "db"    # Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;

    .prologue
    .line 390
    :try_start_0
    new-instance v4, Lorg/json/JSONObject;

    invoke-direct {v4, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 391
    .local v4, "obj":Lorg/json/JSONObject;
    sget-object v5, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->DeviceInfo:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    invoke-virtual {v5}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 393
    .local v1, "info":Lorg/json/JSONObject;
    if-nez v1, :cond_1

    .line 414
    .end local v1    # "info":Lorg/json/JSONObject;
    .end local v4    # "obj":Lorg/json/JSONObject;
    :cond_0
    :goto_0
    return-void

    .line 398
    .restart local v1    # "info":Lorg/json/JSONObject;
    .restart local v4    # "obj":Lorg/json/JSONObject;
    :cond_1
    invoke-virtual {v1}, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;

    move-result-object v3

    .line 400
    .local v3, "keys":Ljava/util/Iterator;, "Ljava/util/Iterator<*>;"
    :cond_2
    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 402
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 404
    .local v2, "key":Ljava/lang/String;
    if-eqz v2, :cond_2

    .line 409
    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-direct {p0, v2, v5, p2}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$DeviceInfoTask;->readValue(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 411
    .end local v1    # "info":Lorg/json/JSONObject;
    .end local v2    # "key":Ljava/lang/String;
    .end local v3    # "keys":Ljava/util/Iterator;, "Ljava/util/Iterator<*>;"
    .end local v4    # "obj":Lorg/json/JSONObject;
    :catch_0
    move-exception v0

    .line 412
    .local v0, "e":Ljava/lang/Exception;
    # getter for: Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->log:Lcom/amazon/retailsearch/log/MessageLogger;
    invoke-static {}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->access$100()Lcom/amazon/retailsearch/log/MessageLogger;

    move-result-object v5

    const-string/jumbo v6, "Parse searchContext"

    invoke-interface {v5, v6, v0}, Lcom/amazon/retailsearch/log/MessageLogger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private readValue(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;)V
    .locals 4
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;
    .param p3, "db"    # Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;

    .prologue
    .line 325
    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    .line 385
    :cond_0
    :goto_0
    return-void

    .line 330
    :cond_1
    invoke-static {p1}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->find(Ljava/lang/String;)Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;

    move-result-object v0

    .line 332
    .local v0, "field":Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;
    if-nez v0, :cond_2

    .line 334
    # getter for: Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->log:Lcom/amazon/retailsearch/log/MessageLogger;
    invoke-static {}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->access$100()Lcom/amazon/retailsearch/log/MessageLogger;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Unknown device info field: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ": "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Lcom/amazon/retailsearch/log/MessageLogger;->warn(Ljava/lang/String;)V

    goto :goto_0

    .line 338
    :cond_2
    sget-object v1, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$1;->$SwitchMap$com$amazon$retailsearch$deviceinfo$DeviceInfoLoader$MasField:[I

    invoke-virtual {v0}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    goto :goto_0

    .line 341
    :pswitch_0
    invoke-virtual {p3, p2}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->setBuildFingerprint(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;

    goto :goto_0

    .line 344
    :pswitch_1
    invoke-virtual {p3, p2}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->setBuildProduct(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;

    goto :goto_0

    .line 347
    :pswitch_2
    invoke-virtual {p3, p2}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->setCarrier(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;

    goto :goto_0

    .line 350
    :pswitch_3
    invoke-virtual {p3, p2}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->setDeviceDensityClassification(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;

    goto :goto_0

    .line 353
    :pswitch_4
    invoke-virtual {p3, p2}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->setDeviceDescriptorId(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;

    goto :goto_0

    .line 356
    :pswitch_5
    invoke-virtual {p3, p2}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->setDeviceScreenLayout(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;

    goto :goto_0

    .line 359
    :pswitch_6
    invoke-virtual {p3, p2}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->setDeviceType(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;

    goto :goto_0

    .line 362
    :pswitch_7
    invoke-virtual {p3, p2}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->setManufacturer(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;

    goto :goto_0

    .line 365
    :pswitch_8
    invoke-virtual {p3, p2}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->setModel(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;

    goto :goto_0

    .line 368
    :pswitch_9
    invoke-virtual {p3, p2}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->setOsVersion(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;

    goto :goto_0

    .line 371
    :pswitch_a
    invoke-virtual {p3, p2}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->setPhoneType(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;

    goto :goto_0

    .line 374
    :pswitch_b
    invoke-virtual {p3, p2}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->setRef(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;

    goto :goto_0

    .line 377
    :pswitch_c
    invoke-virtual {p3, p2}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->setSerial(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;

    goto :goto_0

    .line 380
    :pswitch_d
    invoke-virtual {p3, p2}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->setSimOperator(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;

    goto :goto_0

    .line 338
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_9
        :pswitch_a
        :pswitch_b
        :pswitch_c
        :pswitch_d
    .end packed-switch
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 268
    :try_start_0
    invoke-direct {p0}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$DeviceInfoTask;->fetch()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 274
    :goto_0
    return-void

    .line 270
    :catch_0
    move-exception v0

    .line 272
    .local v0, "e":Ljava/lang/Exception;
    # getter for: Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->log:Lcom/amazon/retailsearch/log/MessageLogger;
    invoke-static {}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->access$100()Lcom/amazon/retailsearch/log/MessageLogger;

    move-result-object v1

    const-string/jumbo v2, "Device info load"

    invoke-interface {v1, v2, v0}, Lcom/amazon/retailsearch/log/MessageLogger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

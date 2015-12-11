.class public Lcom/amazon/retailsearch/client/SearchCallInterceptor;
.super Ljava/lang/Object;
.source "SearchCallInterceptor.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallInterceptor;


# static fields
.field private static final DYNAMIC_DISPLAY_SETTINGS_PARAM:Ljava/lang/String; = "ma_dds"

.field private static final UA_APP_NAME_PARAM:Ljava/lang/String; = "uaAppName"

.field private static final UA_APP_TYPE_PARAM:Ljava/lang/String; = "uaAppType"

.field private static final UA_APP_VERSION_PARAM:Ljava/lang/String; = "uaAppVersion"

.field private static final log:Lcom/amazon/retailsearch/log/MessageLogger;


# instance fields
.field context:Landroid/content/Context;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field featureConfig:Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 36
    const-class v0, Lcom/amazon/retailsearch/client/AndroidRetailSearchClient;

    invoke-static {v0}, Lcom/amazon/retailsearch/log/AppLog;->getLog(Ljava/lang/Class;)Lcom/amazon/retailsearch/log/MessageLogger;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/client/SearchCallInterceptor;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    invoke-static {}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getInstance()Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getRetailSearchLogger()Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/client/SearchCallInterceptor;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    .line 48
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 49
    return-void
.end method

.method private addClickstreamParameters(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 145
    .local p1, "addParams":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v4, p0, Lcom/amazon/retailsearch/client/SearchCallInterceptor;->context:Landroid/content/Context;

    if-eqz v4, :cond_0

    iget-object v4, p0, Lcom/amazon/retailsearch/client/SearchCallInterceptor;->context:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    if-eqz v4, :cond_0

    if-nez p1, :cond_1

    .line 168
    :cond_0
    :goto_0
    return-void

    .line 150
    :cond_1
    iget-object v4, p0, Lcom/amazon/retailsearch/client/SearchCallInterceptor;->context:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 151
    .local v0, "res":Landroid/content/res/Resources;
    sget v4, Lcom/amazon/retailsearch/R$string;->config_rs_ua_app_name:I

    invoke-virtual {v0, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 152
    .local v1, "uaAppName":Ljava/lang/String;
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_2

    .line 154
    const-string/jumbo v4, "uaAppName"

    invoke-virtual {p1, v4, v1}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->add(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 157
    :cond_2
    sget v4, Lcom/amazon/retailsearch/R$string;->config_rs_ua_app_type:I

    invoke-virtual {v0, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 158
    .local v2, "uaAppType":Ljava/lang/String;
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_3

    .line 160
    const-string/jumbo v4, "uaAppType"

    invoke-virtual {p1, v4, v2}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->add(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 163
    :cond_3
    invoke-static {}, Lcom/amazon/retailsearch/client/AndroidRetailSearchClient;->getAppVersion()Ljava/lang/String;

    move-result-object v3

    .line 164
    .local v3, "uaAppVersion":Ljava/lang/String;
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 166
    const-string/jumbo v4, "uaAppVersion"

    invoke-virtual {p1, v4, v3}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->add(Ljava/lang/Object;Ljava/lang/Object;)V

    goto :goto_0
.end method


# virtual methods
.method public process(Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;)V
    .locals 22
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall",
            "<*>;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 56
    .local p1, "serviceCall":Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall<*>;"
    :try_start_0
    new-instance v2, Ljava/net/URI;

    invoke-virtual/range {p1 .. p1}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->getScheme()Ljava/lang/String;

    move-result-object v3

    invoke-virtual/range {p1 .. p1}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->getUserInfo()Ljava/lang/String;

    move-result-object v4

    invoke-virtual/range {p1 .. p1}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->getHost()Ljava/lang/String;

    move-result-object v5

    invoke-virtual/range {p1 .. p1}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->getPort()I

    move-result v6

    invoke-virtual/range {p1 .. p1}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->getPath()Ljava/lang/String;

    move-result-object v7

    const/4 v8, 0x0

    const/4 v9, 0x0

    invoke-direct/range {v2 .. v9}, Ljava/net/URI;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 60
    .local v2, "uri":Ljava/net/URI;
    invoke-static {}, Ljava/net/CookieHandler;->getDefault()Ljava/net/CookieHandler;

    move-result-object v13

    .line 62
    .local v13, "defaultCookieHandler":Ljava/net/CookieHandler;
    if-nez v13, :cond_1

    .line 64
    sget-object v3, Lcom/amazon/retailsearch/client/SearchCallInterceptor;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    const-string/jumbo v4, "No default CookieHandler found"

    invoke-interface {v3, v4}, Lcom/amazon/retailsearch/log/MessageLogger;->warn(Ljava/lang/String;)V

    .line 136
    .end local v2    # "uri":Ljava/net/URI;
    .end local v13    # "defaultCookieHandler":Ljava/net/CookieHandler;
    :cond_0
    :goto_0
    return-void

    .line 68
    .restart local v2    # "uri":Ljava/net/URI;
    .restart local v13    # "defaultCookieHandler":Ljava/net/CookieHandler;
    :cond_1
    const/4 v3, 0x0

    invoke-virtual {v13, v2, v3}, Ljava/net/CookieHandler;->get(Ljava/net/URI;Ljava/util/Map;)Ljava/util/Map;

    move-result-object v11

    .line 70
    .local v11, "cookieMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    if-eqz v11, :cond_0

    .line 75
    sget-object v3, Lcom/amazon/searchapp/retailsearch/client/web/HttpHeader;->COOKIE:Lcom/amazon/searchapp/retailsearch/client/web/HttpHeader;

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/web/HttpHeader;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v11, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/util/List;

    .line 77
    .local v12, "cookies":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz v12, :cond_0

    invoke-interface {v12}, Ljava/util/List;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_0

    .line 82
    invoke-virtual/range {p1 .. p1}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->getHeaders()Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    move-result-object v3

    sget-object v4, Lcom/amazon/searchapp/retailsearch/client/web/HttpHeader;->COOKIE:Lcom/amazon/searchapp/retailsearch/client/web/HttpHeader;

    invoke-virtual {v4}, Lcom/amazon/searchapp/retailsearch/client/web/HttpHeader;->getName()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    invoke-interface {v12, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 86
    new-instance v10, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    invoke-direct {v10}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;-><init>()V

    .line 87
    .local v10, "addParams":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    move-object/from16 v0, p0

    invoke-direct {v0, v10}, Lcom/amazon/retailsearch/client/SearchCallInterceptor;->addClickstreamParameters(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)V

    .line 89
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/retailsearch/client/SearchCallInterceptor;->featureConfig:Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;

    if-eqz v3, :cond_2

    .line 96
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/retailsearch/client/SearchCallInterceptor;->featureConfig:Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;

    const-string/jumbo v4, "SX_mShop_Android_Dynamic_Display_Settings"

    invoke-interface {v3, v4}, Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;->getFeatureState(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v19

    .line 99
    .local v19, "state":Ljava/lang/String;
    invoke-static/range {v19 .. v19}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 101
    const-string/jumbo v3, "ma_dds"

    move-object/from16 v0, v19

    invoke-virtual {v10, v3, v0}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->add(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 107
    .end local v19    # "state":Ljava/lang/String;
    :cond_2
    invoke-virtual/range {p1 .. p1}, Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;->getParameters()Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;

    move-result-object v18

    .line 109
    .local v18, "params":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz v18, :cond_4

    .line 111
    invoke-virtual {v10}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->entrySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v15

    :cond_3
    invoke-interface {v15}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_4

    invoke-interface {v15}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v17

    check-cast v17, Ljava/util/Map$Entry;

    .line 113
    .local v17, "item":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    invoke-interface/range {v17 .. v17}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v16

    .local v16, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_3

    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v21

    check-cast v21, Ljava/lang/String;

    .line 115
    .local v21, "val":Ljava/lang/String;
    invoke-interface/range {v17 .. v17}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    move-object/from16 v0, v18

    move-object/from16 v1, v21

    invoke-virtual {v0, v3, v1}, Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;->add(Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 132
    .end local v2    # "uri":Ljava/net/URI;
    .end local v10    # "addParams":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v11    # "cookieMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    .end local v12    # "cookies":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v13    # "defaultCookieHandler":Ljava/net/CookieHandler;
    .end local v16    # "i$":Ljava/util/Iterator;
    .end local v17    # "item":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    .end local v18    # "params":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v21    # "val":Ljava/lang/String;
    :catch_0
    move-exception v14

    .line 134
    .local v14, "e":Ljava/lang/Exception;
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/retailsearch/client/SearchCallInterceptor;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    const-string/jumbo v4, "SearchCallInterceptor encountered an error while processing the service call"

    invoke-interface {v3, v4, v14}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_0

    .line 120
    .end local v14    # "e":Ljava/lang/Exception;
    .restart local v2    # "uri":Ljava/net/URI;
    .restart local v10    # "addParams":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    .restart local v11    # "cookieMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    .restart local v12    # "cookies":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .restart local v13    # "defaultCookieHandler":Ljava/net/CookieHandler;
    .restart local v18    # "params":Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;, "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_4
    :try_start_1
    invoke-static {}, Lcom/amazon/retailsearch/android/api/init/DebugMode;->enabled()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 122
    new-instance v20, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;

    move-object/from16 v0, v20

    invoke-direct {v0, v2}, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;-><init>(Ljava/net/URI;)V

    .line 124
    .local v20, "um":Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;
    if-eqz v18, :cond_5

    .line 126
    move-object/from16 v0, v20

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->setQuery(Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;)Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;

    .line 129
    :cond_5
    sget-object v3, Lcom/amazon/retailsearch/client/SearchCallInterceptor;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "URL: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual/range {v20 .. v20}, Lcom/amazon/searchapp/retailsearch/client/web/UrlMaker;->build()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Lcom/amazon/retailsearch/log/MessageLogger;->debug(Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_0
.end method

.class abstract Lcom/adobe/mobile/Message;
.super Ljava/lang/Object;
.source "Message.java"


# static fields
.field protected static final JSON_CONFIG_ASSETS:Ljava/lang/String; = "assets"

.field private static final JSON_CONFIG_AUDIENCES:Ljava/lang/String; = "audiences"

.field private static final JSON_CONFIG_END_DATE:Ljava/lang/String; = "endDate"

.field private static final JSON_CONFIG_MESSAGE_ID:Ljava/lang/String; = "messageId"

.field private static final JSON_CONFIG_SHOW_OFFLINE:Ljava/lang/String; = "showOffline"

.field private static final JSON_CONFIG_SHOW_RULE:Ljava/lang/String; = "showRule"

.field private static final JSON_CONFIG_START_DATE:Ljava/lang/String; = "startDate"

.field private static final JSON_CONFIG_TEMPLATE:Ljava/lang/String; = "template"

.field private static final JSON_CONFIG_TRIGGERS:Ljava/lang/String; = "triggers"

.field private static final JSON_DEFAULT_SHOW_OFFLINE:Z = false

.field private static final JSON_DEFAULT_START_DATE:Ljava/lang/Long;

.field private static final MESSAGE_ENUM_STRING_UNKNOWN:Ljava/lang/String; = "unknown"

.field protected static final MESSAGE_IMAGE_CACHE_DIR:Ljava/lang/String; = "messageImages"

.field protected static final MESSAGE_JSON_PAYLOAD:Ljava/lang/String; = "payload"

.field private static final MESSAGE_SHOW_RULE_STRING_ALWAYS:Ljava/lang/String; = "always"

.field private static final MESSAGE_SHOW_RULE_STRING_ONCE:Ljava/lang/String; = "once"

.field private static final MESSAGE_SHOW_RULE_STRING_UNTIL_CLICK:Ljava/lang/String; = "untilClick"

.field private static final MESSAGE_TEMPLATE_STRING_ALERT:Ljava/lang/String; = "alert"

.field private static final MESSAGE_TEMPLATE_STRING_CALLBACK:Ljava/lang/String; = "callback"

.field private static final MESSAGE_TEMPLATE_STRING_FULLSCREEN:Ljava/lang/String; = "fullscreen"

.field private static final MESSAGE_TEMPLATE_STRING_LOCAL_NOTIFICATION:Ljava/lang/String; = "local"

.field private static final SHARED_PREFERENCES_BLACK_LIST:Ljava/lang/String; = "messagesBlackList"

.field private static _blacklist:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private static final _blacklistMutex:Ljava/lang/Object;

.field private static final _messageTypeDictionary:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Class;",
            ">;"
        }
    .end annotation
.end field

.field private static final _showRuleEnumDictionary:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/adobe/mobile/Messages$MessageShowRule;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field protected assets:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field

.field protected audiences:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/adobe/mobile/MessageMatcher;",
            ">;"
        }
    .end annotation
.end field

.field protected endDate:Ljava/util/Date;

.field protected isVisible:Z

.field protected messageId:Ljava/lang/String;

.field protected orientationWhenShown:I

.field protected showOffline:Z

.field protected showRule:Lcom/adobe/mobile/Messages$MessageShowRule;

.field protected startDate:Ljava/util/Date;

.field protected triggers:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/adobe/mobile/MessageMatcher;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 72
    const-wide/16 v0, 0x0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    sput-object v0, Lcom/adobe/mobile/Message;->JSON_DEFAULT_START_DATE:Ljava/lang/Long;

    .line 91
    new-instance v0, Lcom/adobe/mobile/Message$1;

    invoke-direct {v0}, Lcom/adobe/mobile/Message$1;-><init>()V

    sput-object v0, Lcom/adobe/mobile/Message;->_messageTypeDictionary:Ljava/util/Map;

    .line 234
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/adobe/mobile/Message;->_blacklistMutex:Ljava/lang/Object;

    .line 410
    new-instance v0, Lcom/adobe/mobile/Message$2;

    invoke-direct {v0}, Lcom/adobe/mobile/Message$2;-><init>()V

    sput-object v0, Lcom/adobe/mobile/Message;->_showRuleEnumDictionary:Ljava/util/Map;

    return-void
.end method

.method constructor <init>()V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private mapFromString(Ljava/lang/String;)Ljava/util/HashMap;
    .locals 9
    .param p1, "string"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 423
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    .line 425
    .local v3, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Integer;>;"
    :try_start_0
    new-instance v4, Lorg/json/JSONObject;

    invoke-direct {v4, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 426
    .local v4, "obj":Lorg/json/JSONObject;
    invoke-virtual {v4}, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;

    move-result-object v2

    .line 427
    .local v2, "keys":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 428
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 429
    .local v1, "key":Ljava/lang/String;
    invoke-virtual {v4, v1}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v1, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 431
    .end local v1    # "key":Ljava/lang/String;
    .end local v2    # "keys":Ljava/util/Iterator;
    .end local v4    # "obj":Lorg/json/JSONObject;
    :catch_0
    move-exception v0

    .line 432
    .local v0, "ex":Lorg/json/JSONException;
    const-string v5, "Messages- Unable to deserialize blacklist(%s)"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    invoke-virtual {v0}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-static {v5, v6}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 435
    .end local v0    # "ex":Lorg/json/JSONException;
    :cond_0
    return-object v3
.end method

.method private static messageShowRuleFromString(Ljava/lang/String;)Lcom/adobe/mobile/Messages$MessageShowRule;
    .locals 1
    .param p0, "showRule"    # Ljava/lang/String;

    .prologue
    .line 419
    sget-object v0, Lcom/adobe/mobile/Message;->_showRuleEnumDictionary:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mobile/Messages$MessageShowRule;

    return-object v0
.end method

.method protected static messageWithJsonObject(Lorg/json/JSONObject;)Lcom/adobe/mobile/Message;
    .locals 10
    .param p0, "dictionary"    # Lorg/json/JSONObject;

    .prologue
    const/4 v7, 0x1

    const/4 v9, 0x0

    const/4 v5, 0x0

    .line 99
    const-string v4, ""

    .line 105
    .local v4, "messageTypeString":Ljava/lang/String;
    :try_start_0
    const-string v6, "template"

    invoke-virtual {p0, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 106
    sget-object v6, Lcom/adobe/mobile/Message;->_messageTypeDictionary:Ljava/util/Map;

    invoke-interface {v6, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Class;

    .line 107
    .local v3, "messageClass":Ljava/lang/Class;
    invoke-virtual {v3}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/adobe/mobile/Message;

    .line 108
    .local v2, "message":Lcom/adobe/mobile/Message;
    invoke-virtual {v2, p0}, Lcom/adobe/mobile/Message;->initWithPayloadObject(Lorg/json/JSONObject;)Z
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/InstantiationException; {:try_start_0 .. :try_end_0} :catch_3

    move-result v1

    .line 127
    .local v1, "initComplete":Z
    if-eqz v1, :cond_0

    .end local v2    # "message":Lcom/adobe/mobile/Message;
    :goto_0
    move-object v5, v2

    .end local v1    # "initComplete":Z
    .end local v3    # "messageClass":Ljava/lang/Class;
    :goto_1
    return-object v5

    .line 110
    :catch_0
    move-exception v0

    .line 111
    .local v0, "ex":Lorg/json/JSONException;
    const-string v6, "Messages - template is required for in-app message"

    new-array v7, v9, [Ljava/lang/Object;

    invoke-static {v6, v7}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1

    .line 114
    .end local v0    # "ex":Lorg/json/JSONException;
    :catch_1
    move-exception v0

    .line 115
    .local v0, "ex":Ljava/lang/NullPointerException;
    const-string v6, "Messages - invalid template specified for message (%s)"

    new-array v7, v7, [Ljava/lang/Object;

    aput-object v4, v7, v9

    invoke-static {v6, v7}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1

    .line 118
    .end local v0    # "ex":Ljava/lang/NullPointerException;
    :catch_2
    move-exception v0

    .line 119
    .local v0, "ex":Ljava/lang/IllegalAccessException;
    const-string v6, "Messages - unable to create instance of message (%s)"

    new-array v7, v7, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/IllegalAccessException;->getMessage()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v7, v9

    invoke-static {v6, v7}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1

    .line 122
    .end local v0    # "ex":Ljava/lang/IllegalAccessException;
    :catch_3
    move-exception v0

    .line 123
    .local v0, "ex":Ljava/lang/InstantiationException;
    const-string v6, "Messages - unable to create instance of message (%s)"

    new-array v7, v7, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/InstantiationException;->getMessage()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v7, v9

    invoke-static {v6, v7}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1

    .end local v0    # "ex":Ljava/lang/InstantiationException;
    .restart local v1    # "initComplete":Z
    .restart local v2    # "message":Lcom/adobe/mobile/Message;
    .restart local v3    # "messageClass":Ljava/lang/Class;
    :cond_0
    move-object v2, v5

    .line 127
    goto :goto_0
.end method

.method private stringFromMap(Ljava/util/Map;)Ljava/lang/String;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 439
    .local p1, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Integer;>;"
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p1}, Lorg/json/JSONObject;-><init>(Ljava/util/Map;)V

    .line 440
    .local v0, "obj":Lorg/json/JSONObject;
    invoke-virtual {v0}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method


# virtual methods
.method protected blacklist()V
    .locals 7

    .prologue
    .line 236
    sget-object v3, Lcom/adobe/mobile/Message;->_blacklistMutex:Ljava/lang/Object;

    monitor-enter v3

    .line 237
    :try_start_0
    sget-object v2, Lcom/adobe/mobile/Message;->_blacklist:Ljava/util/HashMap;

    if-nez v2, :cond_0

    .line 238
    invoke-virtual {p0}, Lcom/adobe/mobile/Message;->loadBlacklist()Ljava/util/HashMap;

    move-result-object v2

    sput-object v2, Lcom/adobe/mobile/Message;->_blacklist:Ljava/util/HashMap;

    .line 241
    :cond_0
    sget-object v2, Lcom/adobe/mobile/Message;->_blacklist:Ljava/util/HashMap;

    iget-object v4, p0, Lcom/adobe/mobile/Message;->messageId:Ljava/lang/String;

    iget-object v5, p0, Lcom/adobe/mobile/Message;->showRule:Lcom/adobe/mobile/Messages$MessageShowRule;

    invoke-virtual {v5}, Lcom/adobe/mobile/Messages$MessageShowRule;->getValue()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v2, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 242
    const-string v2, "Messages - adding message \"%s\" to blacklist"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    iget-object v6, p0, Lcom/adobe/mobile/Message;->messageId:Ljava/lang/String;

    aput-object v6, v4, v5

    invoke-static {v2, v4}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 245
    :try_start_1
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferencesEditor()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    .line 246
    .local v1, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v2, "messagesBlackList"

    sget-object v4, Lcom/adobe/mobile/Message;->_blacklist:Ljava/util/HashMap;

    invoke-direct {p0, v4}, Lcom/adobe/mobile/Message;->stringFromMap(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v2, v4}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 247
    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z
    :try_end_1
    .catch Lcom/adobe/mobile/StaticMethods$NullContextException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 252
    .end local v1    # "editor":Landroid/content/SharedPreferences$Editor;
    :goto_0
    :try_start_2
    monitor-exit v3

    .line 253
    return-void

    .line 249
    :catch_0
    move-exception v0

    .line 250
    .local v0, "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    const-string v2, "Messages - Error persisting blacklist map (%s)."

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {v0}, Lcom/adobe/mobile/StaticMethods$NullContextException;->getMessage()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v2, v4}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 252
    .end local v0    # "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v2
.end method

.method protected clickedThrough()V
    .locals 4

    .prologue
    .line 383
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 384
    .local v0, "contextData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v1, "a.message.id"

    iget-object v2, p0, Lcom/adobe/mobile/Message;->messageId:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 385
    const-string v1, "a.message.clicked"

    const/4 v2, 0x1

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 386
    const-string v1, "In-App Message"

    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getTimeSince1970()J

    move-result-wide v2

    invoke-static {v1, v0, v2, v3}, Lcom/adobe/mobile/AnalyticsTrackInternal;->trackInternal(Ljava/lang/String;Ljava/util/Map;J)V

    .line 389
    iget-object v1, p0, Lcom/adobe/mobile/Message;->showRule:Lcom/adobe/mobile/Messages$MessageShowRule;

    sget-object v2, Lcom/adobe/mobile/Messages$MessageShowRule;->MESSAGE_SHOW_RULE_ONCE:Lcom/adobe/mobile/Messages$MessageShowRule;

    if-eq v1, v2, :cond_0

    iget-object v1, p0, Lcom/adobe/mobile/Message;->showRule:Lcom/adobe/mobile/Messages$MessageShowRule;

    sget-object v2, Lcom/adobe/mobile/Messages$MessageShowRule;->MESSAGE_SHOW_RULE_UNTIL_CLICK:Lcom/adobe/mobile/Messages$MessageShowRule;

    if-ne v1, v2, :cond_1

    .line 391
    :cond_0
    invoke-virtual {p0}, Lcom/adobe/mobile/Message;->blacklist()V

    .line 395
    :cond_1
    const/4 v1, 0x0

    invoke-static {v1}, Lcom/adobe/mobile/Messages;->setCurrentMessage(Lcom/adobe/mobile/Message;)V

    .line 396
    return-void
.end method

.method protected description()Ljava/lang/String;
    .locals 2

    .prologue
    .line 399
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Message ID: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mobile/Message;->messageId:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "; Show Rule: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mobile/Message;->showRule:Lcom/adobe/mobile/Messages$MessageShowRule;

    .line 402
    invoke-virtual {v1}, Lcom/adobe/mobile/Messages$MessageShowRule;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "; Blacklisted: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 404
    invoke-virtual {p0}, Lcom/adobe/mobile/Message;->isBlacklisted()Z

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected initWithPayloadObject(Lorg/json/JSONObject;)Z
    .locals 20
    .param p1, "dictionary"    # Lorg/json/JSONObject;

    .prologue
    .line 132
    if-eqz p1, :cond_0

    invoke-virtual/range {p1 .. p1}, Lorg/json/JSONObject;->length()I

    move-result v14

    if-nez v14, :cond_1

    .line 133
    :cond_0
    const/4 v14, 0x0

    .line 227
    :goto_0
    return v14

    .line 138
    :cond_1
    :try_start_0
    const-string v14, "messageId"

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v14

    move-object/from16 v0, p0

    iput-object v14, v0, Lcom/adobe/mobile/Message;->messageId:Ljava/lang/String;

    .line 139
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/adobe/mobile/Message;->messageId:Ljava/lang/String;

    invoke-virtual {v14}, Ljava/lang/String;->length()I

    move-result v14

    if-gtz v14, :cond_2

    .line 140
    const-string v14, "Messages - Unable to create message, messageId is empty"

    const/4 v15, 0x0

    new-array v15, v15, [Ljava/lang/Object;

    invoke-static {v14, v15}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 141
    const/4 v14, 0x0

    goto :goto_0

    .line 144
    :catch_0
    move-exception v3

    .line 145
    .local v3, "ex":Lorg/json/JSONException;
    const-string v14, "Messages - Unable to create message, messageId is required"

    const/4 v15, 0x0

    new-array v15, v15, [Ljava/lang/Object;

    invoke-static {v14, v15}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 146
    const/4 v14, 0x0

    goto :goto_0

    .line 150
    .end local v3    # "ex":Lorg/json/JSONException;
    :cond_2
    :try_start_1
    const-string v14, "showRule"

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    .line 151
    .local v10, "showRuleString":Ljava/lang/String;
    invoke-static {v10}, Lcom/adobe/mobile/Message;->messageShowRuleFromString(Ljava/lang/String;)Lcom/adobe/mobile/Messages$MessageShowRule;

    move-result-object v14

    move-object/from16 v0, p0

    iput-object v14, v0, Lcom/adobe/mobile/Message;->showRule:Lcom/adobe/mobile/Messages$MessageShowRule;

    .line 152
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/adobe/mobile/Message;->showRule:Lcom/adobe/mobile/Messages$MessageShowRule;

    if-eqz v14, :cond_3

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/adobe/mobile/Message;->showRule:Lcom/adobe/mobile/Messages$MessageShowRule;

    sget-object v15, Lcom/adobe/mobile/Messages$MessageShowRule;->MESSAGE_SHOW_RULE_UNKNOWN:Lcom/adobe/mobile/Messages$MessageShowRule;

    if-ne v14, v15, :cond_4

    .line 154
    :cond_3
    const-string v14, "Messages - Unable to create message \"%s\", showRule not valid (%s)"

    const/4 v15, 0x2

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/mobile/Message;->messageId:Ljava/lang/String;

    move-object/from16 v17, v0

    aput-object v17, v15, v16

    const/16 v16, 0x1

    aput-object v10, v15, v16

    invoke-static {v14, v15}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    .line 155
    const/4 v14, 0x0

    goto :goto_0

    .line 158
    .end local v10    # "showRuleString":Ljava/lang/String;
    :catch_1
    move-exception v3

    .line 159
    .restart local v3    # "ex":Lorg/json/JSONException;
    const-string v14, "Messages - Unable to create message \"%s\", showRule is required"

    const/4 v15, 0x1

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/mobile/Message;->messageId:Ljava/lang/String;

    move-object/from16 v17, v0

    aput-object v17, v15, v16

    invoke-static {v14, v15}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 160
    const/4 v14, 0x0

    goto :goto_0

    .line 165
    .end local v3    # "ex":Lorg/json/JSONException;
    .restart local v10    # "showRuleString":Ljava/lang/String;
    :cond_4
    :try_start_2
    const-string v14, "startDate"

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Lorg/json/JSONObject;->getLong(Ljava/lang/String;)J

    move-result-wide v12

    .line 166
    .local v12, "startDateConfig":J
    new-instance v14, Ljava/util/Date;

    const-wide/16 v16, 0x3e8

    mul-long v16, v16, v12

    move-wide/from16 v0, v16

    invoke-direct {v14, v0, v1}, Ljava/util/Date;-><init>(J)V

    move-object/from16 v0, p0

    iput-object v14, v0, Lcom/adobe/mobile/Message;->startDate:Ljava/util/Date;
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_2

    .line 175
    .end local v12    # "startDateConfig":J
    :goto_1
    :try_start_3
    const-string v14, "endDate"

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Lorg/json/JSONObject;->getLong(Ljava/lang/String;)J

    move-result-wide v4

    .line 176
    .local v4, "endDateConfig":J
    new-instance v14, Ljava/util/Date;

    const-wide/16 v16, 0x3e8

    mul-long v16, v16, v4

    move-wide/from16 v0, v16

    invoke-direct {v14, v0, v1}, Ljava/util/Date;-><init>(J)V

    move-object/from16 v0, p0

    iput-object v14, v0, Lcom/adobe/mobile/Message;->endDate:Ljava/util/Date;
    :try_end_3
    .catch Lorg/json/JSONException; {:try_start_3 .. :try_end_3} :catch_3

    .line 184
    .end local v4    # "endDateConfig":J
    :goto_2
    :try_start_4
    const-string v14, "showOffline"

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v14

    move-object/from16 v0, p0

    iput-boolean v14, v0, Lcom/adobe/mobile/Message;->showOffline:Z
    :try_end_4
    .catch Lorg/json/JSONException; {:try_start_4 .. :try_end_4} :catch_4

    .line 192
    :goto_3
    new-instance v14, Ljava/util/ArrayList;

    invoke-direct {v14}, Ljava/util/ArrayList;-><init>()V

    move-object/from16 v0, p0

    iput-object v14, v0, Lcom/adobe/mobile/Message;->audiences:Ljava/util/ArrayList;

    .line 194
    :try_start_5
    const-string v14, "audiences"

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v7

    .line 195
    .local v7, "jsonAudiences":Lorg/json/JSONArray;
    invoke-virtual {v7}, Lorg/json/JSONArray;->length()I

    move-result v2

    .line 196
    .local v2, "audienceCount":I
    const/4 v6, 0x0

    .local v6, "i":I
    :goto_4
    if-ge v6, v2, :cond_5

    .line 197
    invoke-virtual {v7, v6}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v9

    .line 198
    .local v9, "matcher":Lorg/json/JSONObject;
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/adobe/mobile/Message;->audiences:Ljava/util/ArrayList;

    invoke-static {v9}, Lcom/adobe/mobile/MessageMatcher;->messageMatcherWithJsonObject(Lorg/json/JSONObject;)Lcom/adobe/mobile/MessageMatcher;

    move-result-object v15

    invoke-virtual {v14, v15}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_5
    .catch Lorg/json/JSONException; {:try_start_5 .. :try_end_5} :catch_5

    .line 196
    add-int/lit8 v6, v6, 0x1

    goto :goto_4

    .line 168
    .end local v2    # "audienceCount":I
    .end local v6    # "i":I
    .end local v7    # "jsonAudiences":Lorg/json/JSONArray;
    .end local v9    # "matcher":Lorg/json/JSONObject;
    :catch_2
    move-exception v3

    .line 169
    .restart local v3    # "ex":Lorg/json/JSONException;
    const-string v14, "Messages - Tried to read startDate from message \"%s\" but none found. Using default value"

    const/4 v15, 0x1

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/mobile/Message;->messageId:Ljava/lang/String;

    move-object/from16 v17, v0

    aput-object v17, v15, v16

    invoke-static {v14, v15}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 170
    new-instance v14, Ljava/util/Date;

    sget-object v15, Lcom/adobe/mobile/Message;->JSON_DEFAULT_START_DATE:Ljava/lang/Long;

    invoke-virtual {v15}, Ljava/lang/Long;->longValue()J

    move-result-wide v16

    const-wide/16 v18, 0x3e8

    mul-long v16, v16, v18

    move-wide/from16 v0, v16

    invoke-direct {v14, v0, v1}, Ljava/util/Date;-><init>(J)V

    move-object/from16 v0, p0

    iput-object v14, v0, Lcom/adobe/mobile/Message;->startDate:Ljava/util/Date;

    goto :goto_1

    .line 178
    .end local v3    # "ex":Lorg/json/JSONException;
    :catch_3
    move-exception v3

    .line 179
    .restart local v3    # "ex":Lorg/json/JSONException;
    const-string v14, "Messages - Tried to read endDate from message \"%s\" but none found. Using default value"

    const/4 v15, 0x1

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/mobile/Message;->messageId:Ljava/lang/String;

    move-object/from16 v17, v0

    aput-object v17, v15, v16

    invoke-static {v14, v15}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_2

    .line 186
    .end local v3    # "ex":Lorg/json/JSONException;
    :catch_4
    move-exception v3

    .line 187
    .restart local v3    # "ex":Lorg/json/JSONException;
    const-string v14, "Messages - Tried to read showOffline from message \"%s\" but none found. Using default value"

    const/4 v15, 0x1

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/mobile/Message;->messageId:Ljava/lang/String;

    move-object/from16 v17, v0

    aput-object v17, v15, v16

    invoke-static {v14, v15}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 188
    const/4 v14, 0x0

    move-object/from16 v0, p0

    iput-boolean v14, v0, Lcom/adobe/mobile/Message;->showOffline:Z

    goto :goto_3

    .line 201
    .end local v3    # "ex":Lorg/json/JSONException;
    :catch_5
    move-exception v3

    .line 202
    .restart local v3    # "ex":Lorg/json/JSONException;
    const-string v14, "Messages - failed to read audience for message \"%s\", error: %s"

    const/4 v15, 0x2

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/mobile/Message;->messageId:Ljava/lang/String;

    move-object/from16 v17, v0

    aput-object v17, v15, v16

    const/16 v16, 0x1

    invoke-virtual {v3}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v17

    aput-object v17, v15, v16

    invoke-static {v14, v15}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 206
    .end local v3    # "ex":Lorg/json/JSONException;
    :cond_5
    new-instance v14, Ljava/util/ArrayList;

    invoke-direct {v14}, Ljava/util/ArrayList;-><init>()V

    move-object/from16 v0, p0

    iput-object v14, v0, Lcom/adobe/mobile/Message;->triggers:Ljava/util/ArrayList;

    .line 208
    :try_start_6
    const-string v14, "triggers"

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v8

    .line 209
    .local v8, "jsonTriggers":Lorg/json/JSONArray;
    invoke-virtual {v8}, Lorg/json/JSONArray;->length()I

    move-result v11

    .line 210
    .local v11, "triggersCount":I
    const/4 v6, 0x0

    .restart local v6    # "i":I
    :goto_5
    if-ge v6, v11, :cond_6

    .line 211
    invoke-virtual {v8, v6}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v9

    .line 212
    .restart local v9    # "matcher":Lorg/json/JSONObject;
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/adobe/mobile/Message;->triggers:Ljava/util/ArrayList;

    invoke-static {v9}, Lcom/adobe/mobile/MessageMatcher;->messageMatcherWithJsonObject(Lorg/json/JSONObject;)Lcom/adobe/mobile/MessageMatcher;

    move-result-object v15

    invoke-virtual {v14, v15}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_6
    .catch Lorg/json/JSONException; {:try_start_6 .. :try_end_6} :catch_6

    .line 210
    add-int/lit8 v6, v6, 0x1

    goto :goto_5

    .line 215
    .end local v6    # "i":I
    .end local v8    # "jsonTriggers":Lorg/json/JSONArray;
    .end local v9    # "matcher":Lorg/json/JSONObject;
    .end local v11    # "triggersCount":I
    :catch_6
    move-exception v3

    .line 216
    .restart local v3    # "ex":Lorg/json/JSONException;
    const-string v14, "Messages - failed to read trigger for message \"%s\", error: %s"

    const/4 v15, 0x2

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/mobile/Message;->messageId:Ljava/lang/String;

    move-object/from16 v17, v0

    aput-object v17, v15, v16

    const/16 v16, 0x1

    invoke-virtual {v3}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v17

    aput-object v17, v15, v16

    invoke-static {v14, v15}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 220
    .end local v3    # "ex":Lorg/json/JSONException;
    :cond_6
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/adobe/mobile/Message;->triggers:Ljava/util/ArrayList;

    invoke-virtual {v14}, Ljava/util/ArrayList;->size()I

    move-result v14

    if-gtz v14, :cond_7

    .line 221
    const-string v14, "Messages - Unable to load message \"%s\" - at least one valid trigger is required for a message"

    const/4 v15, 0x1

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/mobile/Message;->messageId:Ljava/lang/String;

    move-object/from16 v17, v0

    aput-object v17, v15, v16

    invoke-static {v14, v15}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 222
    const/4 v14, 0x0

    goto/16 :goto_0

    .line 225
    :cond_7
    const/4 v14, 0x0

    move-object/from16 v0, p0

    iput-boolean v14, v0, Lcom/adobe/mobile/Message;->isVisible:Z

    .line 227
    const/4 v14, 0x1

    goto/16 :goto_0
.end method

.method protected isBlacklisted()Z
    .locals 3

    .prologue
    .line 274
    sget-object v1, Lcom/adobe/mobile/Message;->_blacklistMutex:Ljava/lang/Object;

    monitor-enter v1

    .line 275
    :try_start_0
    sget-object v0, Lcom/adobe/mobile/Message;->_blacklist:Ljava/util/HashMap;

    if-nez v0, :cond_0

    .line 276
    invoke-virtual {p0}, Lcom/adobe/mobile/Message;->loadBlacklist()Ljava/util/HashMap;

    move-result-object v0

    sput-object v0, Lcom/adobe/mobile/Message;->_blacklist:Ljava/util/HashMap;

    .line 279
    :cond_0
    sget-object v0, Lcom/adobe/mobile/Message;->_blacklist:Ljava/util/HashMap;

    iget-object v2, p0, Lcom/adobe/mobile/Message;->messageId:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_1

    const/4 v0, 0x1

    :goto_0
    monitor-exit v1

    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    .line 280
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method protected loadBlacklist()Ljava/util/HashMap;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 285
    :try_start_0
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v2

    const-string v3, "messagesBlackList"

    const/4 v4, 0x0

    invoke-interface {v2, v3, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 286
    .local v0, "blackListString":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 287
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 293
    .end local v0    # "blackListString":Ljava/lang/String;
    :goto_0
    return-object v2

    .line 290
    .restart local v0    # "blackListString":Ljava/lang/String;
    :cond_0
    invoke-direct {p0, v0}, Lcom/adobe/mobile/Message;->mapFromString(Ljava/lang/String;)Ljava/util/HashMap;
    :try_end_0
    .catch Lcom/adobe/mobile/StaticMethods$NullContextException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    goto :goto_0

    .line 291
    .end local v0    # "blackListString":Ljava/lang/String;
    :catch_0
    move-exception v1

    .line 292
    .local v1, "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    const-string v2, "Messaging - Unable to get shared preferences while loading blacklist. (%s)"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {v1}, Lcom/adobe/mobile/StaticMethods$NullContextException;->getMessage()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 293
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    goto :goto_0
.end method

.method protected removeFromBlacklist()V
    .locals 7

    .prologue
    .line 256
    invoke-virtual {p0}, Lcom/adobe/mobile/Message;->isBlacklisted()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 257
    sget-object v3, Lcom/adobe/mobile/Message;->_blacklistMutex:Ljava/lang/Object;

    monitor-enter v3

    .line 258
    :try_start_0
    sget-object v2, Lcom/adobe/mobile/Message;->_blacklist:Ljava/util/HashMap;

    iget-object v4, p0, Lcom/adobe/mobile/Message;->messageId:Ljava/lang/String;

    invoke-virtual {v2, v4}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 259
    const-string v2, "Messages - removing message \"%s\" from blacklist"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    iget-object v6, p0, Lcom/adobe/mobile/Message;->messageId:Ljava/lang/String;

    aput-object v6, v4, v5

    invoke-static {v2, v4}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 262
    :try_start_1
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferencesEditor()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    .line 263
    .local v1, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v2, "messagesBlackList"

    sget-object v4, Lcom/adobe/mobile/Message;->_blacklist:Ljava/util/HashMap;

    invoke-direct {p0, v4}, Lcom/adobe/mobile/Message;->stringFromMap(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v2, v4}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 264
    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z
    :try_end_1
    .catch Lcom/adobe/mobile/StaticMethods$NullContextException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 269
    .end local v1    # "editor":Landroid/content/SharedPreferences$Editor;
    :goto_0
    :try_start_2
    monitor-exit v3

    .line 271
    :cond_0
    return-void

    .line 266
    :catch_0
    move-exception v0

    .line 267
    .local v0, "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    const-string v2, "Messages - Error persisting blacklist map (%s)."

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {v0}, Lcom/adobe/mobile/StaticMethods$NullContextException;->getMessage()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v2, v4}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 269
    .end local v0    # "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v2
.end method

.method protected shouldShowForVariables(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Z
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .local p1, "vars":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    .local p2, "cdata":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    .local p3, "lifecycleData":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 300
    iget-boolean v5, p0, Lcom/adobe/mobile/Message;->isVisible:Z

    if-eqz v5, :cond_1

    iget v5, p0, Lcom/adobe/mobile/Message;->orientationWhenShown:I

    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getCurrentOrientation()I

    move-result v6

    if-eq v5, v6, :cond_1

    instance-of v5, p0, Lcom/adobe/mobile/MessageAlert;

    if-eqz v5, :cond_1

    .line 353
    :cond_0
    :goto_0
    return v3

    .line 305
    :cond_1
    invoke-static {}, Lcom/adobe/mobile/Messages;->getCurrentMessage()Lcom/adobe/mobile/Message;

    move-result-object v5

    if-eqz v5, :cond_2

    .line 306
    instance-of v5, p0, Lcom/adobe/mobile/MessageLocalNotification;

    if-nez v5, :cond_2

    instance-of v5, p0, Lcom/adobe/mobile/MessageTemplateCallback;

    if-nez v5, :cond_2

    move v3, v4

    .line 307
    goto :goto_0

    .line 312
    :cond_2
    if-eqz p1, :cond_3

    invoke-interface {p1}, Ljava/util/Map;->size()I

    move-result v5

    if-gtz v5, :cond_5

    :cond_3
    if-eqz p2, :cond_4

    invoke-interface {p2}, Ljava/util/Map;->size()I

    move-result v5

    if-gtz v5, :cond_5

    :cond_4
    move v3, v4

    .line 313
    goto :goto_0

    .line 317
    :cond_5
    invoke-virtual {p0}, Lcom/adobe/mobile/Message;->isBlacklisted()Z

    move-result v5

    if-eqz v5, :cond_6

    move v3, v4

    .line 318
    goto :goto_0

    .line 322
    :cond_6
    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v5

    invoke-virtual {v5}, Lcom/adobe/mobile/MobileConfig;->networkConnectivity()Z

    move-result v5

    if-nez v5, :cond_7

    .line 323
    iget-boolean v5, p0, Lcom/adobe/mobile/Message;->showOffline:Z

    if-nez v5, :cond_7

    move v3, v4

    .line 324
    goto :goto_0

    .line 329
    :cond_7
    new-instance v2, Ljava/util/Date;

    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getTimeSince1970()J

    move-result-wide v6

    const-wide/16 v8, 0x3e8

    mul-long/2addr v6, v8

    invoke-direct {v2, v6, v7}, Ljava/util/Date;-><init>(J)V

    .line 330
    .local v2, "now":Ljava/util/Date;
    iget-object v5, p0, Lcom/adobe/mobile/Message;->startDate:Ljava/util/Date;

    invoke-virtual {v2, v5}, Ljava/util/Date;->before(Ljava/util/Date;)Z

    move-result v5

    if-eqz v5, :cond_8

    move v3, v4

    .line 331
    goto :goto_0

    .line 333
    :cond_8
    iget-object v5, p0, Lcom/adobe/mobile/Message;->endDate:Ljava/util/Date;

    if-eqz v5, :cond_9

    iget-object v5, p0, Lcom/adobe/mobile/Message;->endDate:Ljava/util/Date;

    invoke-virtual {v2, v5}, Ljava/util/Date;->after(Ljava/util/Date;)Z

    move-result v5

    if-eqz v5, :cond_9

    move v3, v4

    .line 334
    goto :goto_0

    .line 338
    :cond_9
    iget-object v5, p0, Lcom/adobe/mobile/Message;->audiences:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_a
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_b

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/adobe/mobile/MessageMatcher;

    .line 339
    .local v1, "matcher":Lcom/adobe/mobile/MessageMatcher;
    new-array v6, v3, [Ljava/util/Map;

    aput-object p3, v6, v4

    invoke-virtual {v1, v6}, Lcom/adobe/mobile/MessageMatcher;->matchesInMaps([Ljava/util/Map;)Z

    move-result v6

    if-nez v6, :cond_a

    move v3, v4

    .line 340
    goto :goto_0

    .line 345
    .end local v1    # "matcher":Lcom/adobe/mobile/MessageMatcher;
    :cond_b
    invoke-static {p2}, Lcom/adobe/mobile/StaticMethods;->cleanContextDataDictionary(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    .line 347
    .local v0, "cdataCleaned":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    iget-object v5, p0, Lcom/adobe/mobile/Message;->triggers:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_c
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/adobe/mobile/MessageMatcher;

    .line 348
    .restart local v1    # "matcher":Lcom/adobe/mobile/MessageMatcher;
    const/4 v6, 0x2

    new-array v6, v6, [Ljava/util/Map;

    aput-object p1, v6, v4

    aput-object v0, v6, v3

    invoke-virtual {v1, v6}, Lcom/adobe/mobile/MessageMatcher;->matchesInMaps([Ljava/util/Map;)Z

    move-result v6

    if-nez v6, :cond_c

    move v3, v4

    .line 349
    goto/16 :goto_0
.end method

.method protected show()V
    .locals 1

    .prologue
    .line 358
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getCurrentOrientation()I

    move-result v0

    iput v0, p0, Lcom/adobe/mobile/Message;->orientationWhenShown:I

    .line 361
    invoke-static {p0}, Lcom/adobe/mobile/Messages;->setCurrentMessage(Lcom/adobe/mobile/Message;)V

    .line 362
    return-void
.end method

.method protected viewed()V
    .locals 4

    .prologue
    .line 368
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 369
    .local v0, "contextData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v1, "a.message.id"

    iget-object v2, p0, Lcom/adobe/mobile/Message;->messageId:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 370
    const-string v1, "a.message.viewed"

    const/4 v2, 0x1

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 371
    const-string v1, "In-App Message"

    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getTimeSince1970()J

    move-result-wide v2

    invoke-static {v1, v0, v2, v3}, Lcom/adobe/mobile/AnalyticsTrackInternal;->trackInternal(Ljava/lang/String;Ljava/util/Map;J)V

    .line 374
    iget-object v1, p0, Lcom/adobe/mobile/Message;->showRule:Lcom/adobe/mobile/Messages$MessageShowRule;

    sget-object v2, Lcom/adobe/mobile/Messages$MessageShowRule;->MESSAGE_SHOW_RULE_ONCE:Lcom/adobe/mobile/Messages$MessageShowRule;

    if-ne v1, v2, :cond_0

    .line 375
    invoke-virtual {p0}, Lcom/adobe/mobile/Message;->blacklist()V

    .line 379
    :cond_0
    const/4 v1, 0x0

    invoke-static {v1}, Lcom/adobe/mobile/Messages;->setCurrentMessage(Lcom/adobe/mobile/Message;)V

    .line 380
    return-void
.end method

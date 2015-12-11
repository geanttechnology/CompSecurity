.class public Lcom/comcast/playerplatform/util/android/ConfigurationManager;
.super Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;
.source "ConfigurationManager.java"


# static fields
.field private static instance:Lcom/comcast/playerplatform/util/android/ConfigurationManager;


# instance fields
.field private configValues:Ljava/util/Map;

.field private executorService:Ljava/util/concurrent/ExecutorService;

.field private isEspnReady:Z

.field private isReady:Z

.field private listeners:Ljava/util/concurrent/CopyOnWriteArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/CopyOnWriteArrayList",
            "<",
            "Lcom/comcast/playerplatform/util/android/IConfigurationEventListener;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method private constructor <init>()V
    .locals 1

    .prologue
    .line 56
    invoke-direct {p0}, Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;-><init>()V

    .line 50
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->isReady:Z

    .line 57
    invoke-static {}, Ljava/util/concurrent/Executors;->newSingleThreadExecutor()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->executorService:Ljava/util/concurrent/ExecutorService;

    .line 58
    new-instance v0, Ljava/util/Hashtable;

    invoke-direct {v0}, Ljava/util/Hashtable;-><init>()V

    iput-object v0, p0, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->configValues:Ljava/util/Map;

    .line 59
    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->listeners:Ljava/util/concurrent/CopyOnWriteArrayList;

    .line 60
    return-void
.end method

.method static synthetic access$000(Lcom/comcast/playerplatform/util/android/ConfigurationManager;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/util/android/ConfigurationManager;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 37
    invoke-direct {p0, p1}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->parseConfiguration(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$100(Lcom/comcast/playerplatform/util/android/ConfigurationManager;)Ljava/util/concurrent/CopyOnWriteArrayList;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/util/android/ConfigurationManager;

    .prologue
    .line 37
    iget-object v0, p0, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->listeners:Ljava/util/concurrent/CopyOnWriteArrayList;

    return-object v0
.end method

.method static synthetic access$202(Lcom/comcast/playerplatform/util/android/ConfigurationManager;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/util/android/ConfigurationManager;
    .param p1, "x1"    # Z

    .prologue
    .line 37
    iput-boolean p1, p0, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->isEspnReady:Z

    return p1
.end method

.method public static declared-synchronized getInstance()Lcom/comcast/playerplatform/util/android/ConfigurationManager;
    .locals 2

    .prologue
    .line 64
    const-class v1, Lcom/comcast/playerplatform/util/android/ConfigurationManager;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->instance:Lcom/comcast/playerplatform/util/android/ConfigurationManager;

    if-nez v0, :cond_0

    .line 65
    new-instance v0, Lcom/comcast/playerplatform/util/android/ConfigurationManager;

    invoke-direct {v0}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;-><init>()V

    sput-object v0, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->instance:Lcom/comcast/playerplatform/util/android/ConfigurationManager;

    .line 67
    :cond_0
    sget-object v0, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->instance:Lcom/comcast/playerplatform/util/android/ConfigurationManager;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 64
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private parseConfiguration(Ljava/lang/String;)V
    .locals 13
    .param p1, "xmlString"    # Ljava/lang/String;

    .prologue
    .line 120
    invoke-static {}, Ljavax/xml/parsers/DocumentBuilderFactory;->newInstance()Ljavax/xml/parsers/DocumentBuilderFactory;

    move-result-object v2

    .line 121
    .local v2, "factory":Ljavax/xml/parsers/DocumentBuilderFactory;
    const/4 v0, 0x0

    .line 122
    .local v0, "builder":Ljavax/xml/parsers/DocumentBuilder;
    const/4 v9, 0x0

    invoke-direct {p0, v9}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->setIsReady(Z)V

    .line 125
    :try_start_0
    iget-object v10, p0, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->configValues:Ljava/util/Map;

    monitor-enter v10
    :try_end_0
    .catch Ljavax/xml/parsers/ParserConfigurationException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lorg/xml/sax/SAXException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_2

    .line 126
    :try_start_1
    iget-object v9, p0, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->configValues:Ljava/util/Map;

    invoke-interface {v9}, Ljava/util/Map;->clear()V

    .line 127
    invoke-virtual {v2}, Ljavax/xml/parsers/DocumentBuilderFactory;->newDocumentBuilder()Ljavax/xml/parsers/DocumentBuilder;

    move-result-object v0

    .line 129
    new-instance v9, Lorg/xml/sax/InputSource;

    new-instance v11, Ljava/io/StringReader;

    invoke-direct {v11, p1}, Ljava/io/StringReader;-><init>(Ljava/lang/String;)V

    invoke-direct {v9, v11}, Lorg/xml/sax/InputSource;-><init>(Ljava/io/Reader;)V

    invoke-virtual {v0, v9}, Ljavax/xml/parsers/DocumentBuilder;->parse(Lorg/xml/sax/InputSource;)Lorg/w3c/dom/Document;

    move-result-object v8

    .line 130
    .local v8, "xml":Lorg/w3c/dom/Document;
    const-string v9, "add"

    invoke-interface {v8, v9}, Lorg/w3c/dom/Document;->getElementsByTagName(Ljava/lang/String;)Lorg/w3c/dom/NodeList;

    move-result-object v6

    .line 131
    .local v6, "nodeList":Lorg/w3c/dom/NodeList;
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    invoke-interface {v6}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v9

    if-ge v3, v9, :cond_3

    .line 132
    invoke-interface {v6, v3}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v5

    .line 133
    .local v5, "node":Lorg/w3c/dom/Node;
    invoke-interface {v5}, Lorg/w3c/dom/Node;->getAttributes()Lorg/w3c/dom/NamedNodeMap;

    move-result-object v4

    .line 134
    .local v4, "map":Lorg/w3c/dom/NamedNodeMap;
    const-string v9, "key"

    invoke-interface {v4, v9}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v9

    invoke-interface {v9}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v9

    const-string v11, "CustomParams"

    invoke-virtual {v9, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_0

    const-string v9, "key"

    invoke-interface {v4, v9}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v9

    invoke-interface {v9}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v9

    const-string v11, "ComscoreParams"

    invoke-virtual {v9, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_2

    .line 136
    :cond_0
    new-instance v7, Ljava/lang/StringBuffer;

    invoke-direct {v7}, Ljava/lang/StringBuffer;-><init>()V

    .line 137
    .local v7, "sb":Ljava/lang/StringBuffer;
    iget-object v9, p0, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->configValues:Ljava/util/Map;

    const-string v11, "key"

    invoke-interface {v4, v11}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v11

    invoke-interface {v11}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v11

    invoke-interface {v9, v11}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_1

    .line 138
    iget-object v9, p0, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->configValues:Ljava/util/Map;

    const-string v11, "key"

    invoke-interface {v4, v11}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v11

    invoke-interface {v11}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v11

    invoke-interface {v9, v11}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    invoke-virtual {v7, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    .line 141
    :cond_1
    const-string v9, "paramKey"

    invoke-interface {v4, v9}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v9

    invoke-interface {v9}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v9

    const-string v11, "="

    invoke-virtual {v9, v11}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v9

    const-string v11, "paramValue"

    invoke-interface {v4, v11}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v11

    invoke-interface {v11}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v9, v11}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v9

    const-string v11, ";"

    invoke-virtual {v9, v11}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 143
    iget-object v9, p0, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->configValues:Ljava/util/Map;

    const-string v11, "key"

    invoke-interface {v4, v11}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v11

    invoke-interface {v11}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v7}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-interface {v9, v11, v12}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 131
    .end local v7    # "sb":Ljava/lang/StringBuffer;
    :goto_1
    add-int/lit8 v3, v3, 0x1

    goto/16 :goto_0

    .line 145
    :cond_2
    iget-object v9, p0, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->configValues:Ljava/util/Map;

    const-string v11, "key"

    invoke-interface {v4, v11}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v11

    invoke-interface {v11}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v11

    const-string v12, "value"

    invoke-interface {v4, v12}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v12

    invoke-interface {v12}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v12

    invoke-interface {v9, v11, v12}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 149
    .end local v3    # "i":I
    .end local v4    # "map":Lorg/w3c/dom/NamedNodeMap;
    .end local v5    # "node":Lorg/w3c/dom/Node;
    .end local v6    # "nodeList":Lorg/w3c/dom/NodeList;
    .end local v8    # "xml":Lorg/w3c/dom/Document;
    :catchall_0
    move-exception v9

    monitor-exit v10
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    throw v9
    :try_end_2
    .catch Ljavax/xml/parsers/ParserConfigurationException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Lorg/xml/sax/SAXException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_2

    .line 153
    :catch_0
    move-exception v1

    .line 154
    .local v1, "e":Ljavax/xml/parsers/ParserConfigurationException;
    invoke-virtual {v1}, Ljavax/xml/parsers/ParserConfigurationException;->printStackTrace()V

    .line 155
    invoke-direct {p0, p1}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->sendFailedEvent(Ljava/lang/String;)V

    .line 163
    .end local v1    # "e":Ljavax/xml/parsers/ParserConfigurationException;
    :goto_2
    return-void

    .line 149
    .restart local v3    # "i":I
    .restart local v6    # "nodeList":Lorg/w3c/dom/NodeList;
    .restart local v8    # "xml":Lorg/w3c/dom/Document;
    :cond_3
    :try_start_3
    monitor-exit v10
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 151
    :try_start_4
    invoke-direct {p0}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->setConfigReady()V
    :try_end_4
    .catch Ljavax/xml/parsers/ParserConfigurationException; {:try_start_4 .. :try_end_4} :catch_0
    .catch Lorg/xml/sax/SAXException; {:try_start_4 .. :try_end_4} :catch_1
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_2

    goto :goto_2

    .line 156
    .end local v3    # "i":I
    .end local v6    # "nodeList":Lorg/w3c/dom/NodeList;
    .end local v8    # "xml":Lorg/w3c/dom/Document;
    :catch_1
    move-exception v1

    .line 157
    .local v1, "e":Lorg/xml/sax/SAXException;
    invoke-virtual {v1}, Lorg/xml/sax/SAXException;->printStackTrace()V

    .line 158
    invoke-direct {p0, p1}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->sendFailedEvent(Ljava/lang/String;)V

    goto :goto_2

    .line 159
    .end local v1    # "e":Lorg/xml/sax/SAXException;
    :catch_2
    move-exception v1

    .line 160
    .local v1, "e":Ljava/io/IOException;
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    .line 161
    invoke-direct {p0, p1}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->sendFailedEvent(Ljava/lang/String;)V

    goto :goto_2
.end method

.method private sendFailedEvent(Ljava/lang/String;)V
    .locals 2
    .param p1, "xmlString"    # Ljava/lang/String;

    .prologue
    .line 166
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->setIsReady(Z)V

    .line 167
    invoke-static {}, Lcom/comcast/playerplatform/util/android/ThreadManager;->getInstance()Lcom/comcast/playerplatform/util/android/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/util/android/ConfigurationManager$3;

    invoke-direct {v1, p0, p1}, Lcom/comcast/playerplatform/util/android/ConfigurationManager$3;-><init>(Lcom/comcast/playerplatform/util/android/ConfigurationManager;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/util/android/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 177
    return-void
.end method

.method private setConfigReady()V
    .locals 2

    .prologue
    .line 180
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->setIsReady(Z)V

    .line 181
    invoke-static {}, Lcom/comcast/playerplatform/util/android/ThreadManager;->getInstance()Lcom/comcast/playerplatform/util/android/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/util/android/ConfigurationManager$4;

    invoke-direct {v1, p0}, Lcom/comcast/playerplatform/util/android/ConfigurationManager$4;-><init>(Lcom/comcast/playerplatform/util/android/ConfigurationManager;)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/util/android/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 191
    return-void
.end method

.method private declared-synchronized setIsReady(Z)V
    .locals 1
    .param p1, "isReady"    # Z

    .prologue
    .line 106
    monitor-enter p0

    :try_start_0
    iput-boolean p1, p0, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->isReady:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 107
    monitor-exit p0

    return-void

    .line 106
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method


# virtual methods
.method public addListener(Lcom/comcast/playerplatform/util/android/IConfigurationEventListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/comcast/playerplatform/util/android/IConfigurationEventListener;

    .prologue
    .line 210
    iget-object v0, p0, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->listeners:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/CopyOnWriteArrayList;->add(Ljava/lang/Object;)Z

    .line 211
    return-void
.end method

.method public containsKey(Ljava/lang/String;)Z
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 98
    iget-object v0, p0, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->configValues:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public getConfigValue(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 90
    iget-object v0, p0, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->configValues:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->configValues:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 91
    iget-object v0, p0, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->configValues:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 94
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public initializeESPN(Landroid/content/Context;Z)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "isQA"    # Z

    .prologue
    .line 219
    invoke-static {p2}, Lcom/espn/androidplayersdk/datamanager/ESPNPlayerSdk;->setIsQA(Z)V

    .line 221
    new-instance v1, Lcom/comcast/playerplatform/util/android/ConfigurationManager$6;

    invoke-direct {v1, p0}, Lcom/comcast/playerplatform/util/android/ConfigurationManager$6;-><init>(Lcom/comcast/playerplatform/util/android/ConfigurationManager;)V

    .line 229
    .local v1, "mReceiver":Landroid/content/BroadcastReceiver;
    new-instance v0, Landroid/content/IntentFilter;

    const-string v2, "com.espn.action.CONFIG_UPDATED"

    invoke-direct {v0, v2}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    .line 230
    .local v0, "intentFilter":Landroid/content/IntentFilter;
    invoke-virtual {p1, v1, v0}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 232
    const-string v2, "comcast"

    invoke-static {p1, v2}, Lcom/espn/androidplayersdk/datamanager/ESPNPlayerSdk;->init(Landroid/content/Context;Ljava/lang/String;)V

    .line 233
    return-void
.end method

.method public isEspnReady()Z
    .locals 1

    .prologue
    .line 241
    iget-boolean v0, p0, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->isEspnReady:Z

    return v0
.end method

.method public declared-synchronized isReady()Z
    .locals 1

    .prologue
    .line 102
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->isReady:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public loadConfigurationFromXml(Ljava/lang/String;)V
    .locals 2
    .param p1, "xmlString"    # Ljava/lang/String;

    .prologue
    .line 71
    iget-object v0, p0, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->executorService:Ljava/util/concurrent/ExecutorService;

    new-instance v1, Lcom/comcast/playerplatform/util/android/ConfigurationManager$1;

    invoke-direct {v1, p0, p1}, Lcom/comcast/playerplatform/util/android/ConfigurationManager$1;-><init>(Lcom/comcast/playerplatform/util/android/ConfigurationManager;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V

    .line 78
    return-void
.end method

.method public removeListener(Lcom/comcast/playerplatform/util/android/IConfigurationEventListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/comcast/playerplatform/util/android/IConfigurationEventListener;

    .prologue
    .line 214
    iget-object v0, p0, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->listeners:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/CopyOnWriteArrayList;->remove(Ljava/lang/Object;)Z

    .line 215
    return-void
.end method

.method public requestFailed(Ljava/lang/String;)V
    .locals 2
    .param p1, "response"    # Ljava/lang/String;

    .prologue
    .line 195
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->setIsReady(Z)V

    .line 196
    invoke-static {}, Lcom/comcast/playerplatform/util/android/ThreadManager;->getInstance()Lcom/comcast/playerplatform/util/android/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/util/android/ConfigurationManager$5;

    invoke-direct {v1, p0, p1}, Lcom/comcast/playerplatform/util/android/ConfigurationManager$5;-><init>(Lcom/comcast/playerplatform/util/android/ConfigurationManager;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/util/android/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 207
    return-void
.end method

.method public responseReceived(Ljava/lang/String;)V
    .locals 2
    .param p1, "response"    # Ljava/lang/String;

    .prologue
    .line 111
    iget-object v0, p0, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->executorService:Ljava/util/concurrent/ExecutorService;

    new-instance v1, Lcom/comcast/playerplatform/util/android/ConfigurationManager$2;

    invoke-direct {v1, p0, p1}, Lcom/comcast/playerplatform/util/android/ConfigurationManager$2;-><init>(Lcom/comcast/playerplatform/util/android/ConfigurationManager;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V

    .line 117
    return-void
.end method

.method public unInitializeEspn()V
    .locals 1

    .prologue
    .line 236
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->isEspnReady:Z

    .line 237
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/ESPNPlayerSdk;->unInit()V

    .line 238
    return-void
.end method

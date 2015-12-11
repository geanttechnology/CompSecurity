.class public Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;
.super Ljava/lang/Object;
.source "InMemoryConfiguration.java"

# interfaces
.implements Lcom/amazon/device/analytics/configuration/Configuration;
.implements Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;


# static fields
.field private static logger:Lcom/amazon/device/analytics/log/Logger;


# instance fields
.field private changedListeners:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;",
            "Ljava/lang/Boolean;",
            ">;>;"
        }
    .end annotation
.end field

.field protected parentConfiguration:Lcom/amazon/device/analytics/configuration/Configuration;

.field protected properties:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private refreshListeners:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/amazon/device/analytics/configuration/ConfigurationRefreshListener;",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 14
    const-class v0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;

    invoke-static {v0}, Lcom/amazon/device/analytics/log/Logging;->getLogger(Ljava/lang/Class;)Lcom/amazon/device/analytics/log/Logger;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->logger:Lcom/amazon/device/analytics/log/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 22
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;-><init>(Lcom/amazon/device/analytics/configuration/Configuration;)V

    .line 23
    return-void
.end method

.method public constructor <init>(Lcom/amazon/device/analytics/configuration/Configuration;)V
    .locals 3
    .param p1, "parentConfiguration"    # Lcom/amazon/device/analytics/configuration/Configuration;

    .prologue
    .line 26
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    new-instance v1, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v1}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    new-instance v2, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v2}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    invoke-direct {p0, p1, v0, v1, v2}, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;-><init>(Lcom/amazon/device/analytics/configuration/Configuration;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V

    .line 30
    return-void
.end method

.method public constructor <init>(Lcom/amazon/device/analytics/configuration/Configuration;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V
    .locals 1
    .param p1, "parentConfiguration"    # Lcom/amazon/device/analytics/configuration/Configuration;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/device/analytics/configuration/Configuration;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;",
            "Ljava/lang/Boolean;",
            ">;>;",
            "Ljava/util/Map",
            "<",
            "Lcom/amazon/device/analytics/configuration/ConfigurationRefreshListener;",
            "Ljava/lang/Boolean;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 35
    .local p2, "properties":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .local p3, "changedListeners":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/Map<Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;Ljava/lang/Boolean;>;>;"
    .local p4, "refreshListeners":Ljava/util/Map;, "Ljava/util/Map<Lcom/amazon/device/analytics/configuration/ConfigurationRefreshListener;Ljava/lang/Boolean;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 36
    iput-object p2, p0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->properties:Ljava/util/Map;

    .line 37
    if-eqz p3, :cond_0

    .line 38
    iput-object p3, p0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->changedListeners:Ljava/util/Map;

    .line 42
    :goto_0
    if-eqz p4, :cond_1

    .line 43
    iput-object p4, p0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->refreshListeners:Ljava/util/Map;

    .line 47
    :goto_1
    invoke-virtual {p0, p1}, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->setParentConfiguration(Lcom/amazon/device/analytics/configuration/Configuration;)V

    .line 48
    return-void

    .line 40
    :cond_0
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->changedListeners:Ljava/util/Map;

    goto :goto_0

    .line 45
    :cond_1
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->refreshListeners:Ljava/util/Map;

    goto :goto_1
.end method


# virtual methods
.method public getAllProperties()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 215
    iget-object v0, p0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->properties:Ljava/util/Map;

    return-object v0
.end method

.method public getBoolean(Ljava/lang/String;)Ljava/lang/Boolean;
    .locals 6
    .param p1, "propertyName"    # Ljava/lang/String;

    .prologue
    .line 121
    const/4 v1, 0x0

    .line 123
    .local v1, "value":Ljava/lang/Boolean;
    :try_start_0
    iget-object v2, p0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->properties:Ljava/util/Map;

    invoke-interface {v2, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 124
    iget-object v2, p0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->properties:Ljava/util/Map;

    invoke-interface {v2, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v2

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 129
    :cond_0
    :goto_0
    if-nez v1, :cond_1

    .line 130
    iget-object v2, p0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->parentConfiguration:Lcom/amazon/device/analytics/configuration/Configuration;

    if-eqz v2, :cond_1

    .line 131
    iget-object v2, p0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->parentConfiguration:Lcom/amazon/device/analytics/configuration/Configuration;

    invoke-interface {v2, p1}, Lcom/amazon/device/analytics/configuration/Configuration;->getBoolean(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v1

    .line 134
    :cond_1
    return-object v1

    .line 126
    :catch_0
    move-exception v0

    .line 127
    .local v0, "ex":Ljava/lang/Exception;
    sget-object v2, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->logger:Lcom/amazon/device/analytics/log/Logger;

    const-string/jumbo v3, "Could not get Boolean for propertyName: %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object p1, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3, v0}, Lcom/amazon/device/analytics/log/Logger;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public getInt(Ljava/lang/String;)Ljava/lang/Integer;
    .locals 6
    .param p1, "propertyName"    # Ljava/lang/String;

    .prologue
    .line 85
    const/4 v1, 0x0

    .line 87
    .local v1, "value":Ljava/lang/Integer;
    :try_start_0
    iget-object v2, p0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->properties:Ljava/util/Map;

    invoke-interface {v2, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 88
    iget-object v2, p0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->properties:Ljava/util/Map;

    invoke-interface {v2, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/Integer;->decode(Ljava/lang/String;)Ljava/lang/Integer;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 93
    :cond_0
    :goto_0
    if-nez v1, :cond_1

    .line 94
    iget-object v2, p0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->parentConfiguration:Lcom/amazon/device/analytics/configuration/Configuration;

    if-eqz v2, :cond_1

    .line 95
    iget-object v2, p0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->parentConfiguration:Lcom/amazon/device/analytics/configuration/Configuration;

    invoke-interface {v2, p1}, Lcom/amazon/device/analytics/configuration/Configuration;->getInt(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v1

    .line 98
    :cond_1
    return-object v1

    .line 90
    :catch_0
    move-exception v0

    .line 91
    .local v0, "ex":Ljava/lang/Exception;
    sget-object v2, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->logger:Lcom/amazon/device/analytics/log/Logger;

    const-string/jumbo v3, "Could not get Integer for propertyName: %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object p1, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3, v0}, Lcom/amazon/device/analytics/log/Logger;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public getString(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "propertyName"    # Ljava/lang/String;

    .prologue
    .line 71
    const/4 v0, 0x0

    .line 72
    .local v0, "value":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->properties:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 73
    iget-object v1, p0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->properties:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "value":Ljava/lang/String;
    check-cast v0, Ljava/lang/String;

    .line 75
    .restart local v0    # "value":Ljava/lang/String;
    :cond_0
    if-nez v0, :cond_1

    .line 76
    iget-object v1, p0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->parentConfiguration:Lcom/amazon/device/analytics/configuration/Configuration;

    if-eqz v1, :cond_1

    .line 77
    iget-object v1, p0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->parentConfiguration:Lcom/amazon/device/analytics/configuration/Configuration;

    invoke-interface {v1, p1}, Lcom/amazon/device/analytics/configuration/Configuration;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 80
    :cond_1
    return-object v0
.end method

.method public notifyChangedListeners(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 7
    .param p1, "propertyName"    # Ljava/lang/String;
    .param p2, "propertyValue"    # Ljava/lang/Object;

    .prologue
    .line 279
    iget-object v4, p0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->changedListeners:Ljava/util/Map;

    const-string/jumbo v5, "_ALL_"

    invoke-interface {v4, v5}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 280
    sget-object v4, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->logger:Lcom/amazon/device/analytics/log/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "Notifying PropertyChangedListeners of all events that propertyName:"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, " changed with propertyValue:"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/amazon/device/analytics/log/Logger;->v(Ljava/lang/String;)V

    .line 281
    iget-object v4, p0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->changedListeners:Ljava/util/Map;

    const-string/jumbo v5, "_ALL_"

    invoke-interface {v4, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    .line 282
    .local v0, "allChangedListenerSet":Ljava/util/Map;, "Ljava/util/Map<Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;Ljava/lang/Boolean;>;"
    invoke-interface {v0}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;

    .line 283
    .local v2, "listener":Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;
    invoke-interface {v2, p1, p2}, Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;->onPropertyChanged(Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_0

    .line 286
    .end local v0    # "allChangedListenerSet":Ljava/util/Map;, "Ljava/util/Map<Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;Ljava/lang/Boolean;>;"
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "listener":Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;
    :cond_0
    iget-object v4, p0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->changedListeners:Ljava/util/Map;

    invoke-interface {v4, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 287
    sget-object v4, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->logger:Lcom/amazon/device/analytics/log/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "Notifying PropertyChangedListeners of propertyName:"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, " changed with propertyValue:"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/amazon/device/analytics/log/Logger;->v(Ljava/lang/String;)V

    .line 288
    iget-object v4, p0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->changedListeners:Ljava/util/Map;

    invoke-interface {v4, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/Map;

    .line 289
    .local v3, "propertyChangedListenerSet":Ljava/util/Map;, "Ljava/util/Map<Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;Ljava/lang/Boolean;>;"
    invoke-interface {v3}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .restart local v1    # "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;

    .line 290
    .restart local v2    # "listener":Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;
    invoke-interface {v2, p1, p2}, Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;->onPropertyChanged(Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_1

    .line 293
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "listener":Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;
    .end local v3    # "propertyChangedListenerSet":Ljava/util/Map;, "Ljava/util/Map<Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;Ljava/lang/Boolean;>;"
    :cond_1
    return-void
.end method

.method public notifyRefreshListeners()V
    .locals 4

    .prologue
    .line 329
    sget-object v2, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->logger:Lcom/amazon/device/analytics/log/Logger;

    const-string/jumbo v3, "Notifying refresh listeners that the configuration has changed"

    invoke-virtual {v2, v3}, Lcom/amazon/device/analytics/log/Logger;->v(Ljava/lang/String;)V

    .line 330
    iget-object v2, p0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->refreshListeners:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/device/analytics/configuration/ConfigurationRefreshListener;

    .line 331
    .local v1, "listener":Lcom/amazon/device/analytics/configuration/ConfigurationRefreshListener;
    invoke-interface {v1, p0}, Lcom/amazon/device/analytics/configuration/ConfigurationRefreshListener;->onRefresh(Lcom/amazon/device/analytics/configuration/Configuration;)V

    goto :goto_0

    .line 333
    .end local v1    # "listener":Lcom/amazon/device/analytics/configuration/ConfigurationRefreshListener;
    :cond_0
    return-void
.end method

.method public onPropertyChanged(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 1
    .param p1, "propertyName"    # Ljava/lang/String;
    .param p2, "propertyValue"    # Ljava/lang/Object;

    .prologue
    .line 298
    iget-object v0, p0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->properties:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 299
    invoke-virtual {p0, p1, p2}, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->notifyChangedListeners(Ljava/lang/String;Ljava/lang/Object;)V

    .line 301
    :cond_0
    return-void
.end method

.method public optBoolean(Ljava/lang/String;Ljava/lang/Boolean;)Ljava/lang/Boolean;
    .locals 1
    .param p1, "propertyName"    # Ljava/lang/String;
    .param p2, "optValue"    # Ljava/lang/Boolean;

    .prologue
    .line 201
    invoke-virtual {p0, p1}, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->getBoolean(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v0

    .line 202
    .local v0, "value":Ljava/lang/Boolean;
    if-eqz v0, :cond_0

    .end local v0    # "value":Ljava/lang/Boolean;
    :goto_0
    return-object v0

    .restart local v0    # "value":Ljava/lang/Boolean;
    :cond_0
    move-object v0, p2

    goto :goto_0
.end method

.method public optInt(Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/Integer;
    .locals 1
    .param p1, "propertyName"    # Ljava/lang/String;
    .param p2, "optValue"    # Ljava/lang/Integer;

    .prologue
    .line 183
    invoke-virtual {p0, p1}, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->getInt(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v0

    .line 184
    .local v0, "value":Ljava/lang/Integer;
    if-eqz v0, :cond_0

    .end local v0    # "value":Ljava/lang/Integer;
    :goto_0
    return-object v0

    .restart local v0    # "value":Ljava/lang/Integer;
    :cond_0
    move-object v0, p2

    goto :goto_0
.end method

.method public optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "propertyName"    # Ljava/lang/String;
    .param p2, "optValue"    # Ljava/lang/String;

    .prologue
    .line 177
    invoke-virtual {p0, p1}, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 178
    .local v0, "value":Ljava/lang/String;
    if-eqz v0, :cond_0

    .end local v0    # "value":Ljava/lang/String;
    :goto_0
    return-object v0

    .restart local v0    # "value":Ljava/lang/String;
    :cond_0
    move-object v0, p2

    goto :goto_0
.end method

.method public refresh()V
    .locals 1

    .prologue
    .line 207
    iget-object v0, p0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->parentConfiguration:Lcom/amazon/device/analytics/configuration/Configuration;

    if-eqz v0, :cond_0

    .line 208
    iget-object v0, p0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->parentConfiguration:Lcom/amazon/device/analytics/configuration/Configuration;

    invoke-interface {v0}, Lcom/amazon/device/analytics/configuration/Configuration;->refresh()V

    .line 210
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->notifyRefreshListeners()V

    .line 211
    return-void
.end method

.method public registerChangedListener(Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;

    .prologue
    .line 233
    const-string/jumbo v0, "_ALL_"

    invoke-virtual {p0, v0, p1}, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->registerChangedListener(Ljava/lang/String;Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;)V

    .line 234
    return-void
.end method

.method public registerChangedListener(Ljava/lang/String;Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;)V
    .locals 4
    .param p1, "propertyName"    # Ljava/lang/String;
    .param p2, "listener"    # Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;

    .prologue
    .line 238
    invoke-static {p1}, Lcom/amazon/device/analytics/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    if-nez p2, :cond_2

    .line 239
    :cond_0
    if-nez p2, :cond_1

    .line 240
    sget-object v1, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->logger:Lcom/amazon/device/analytics/log/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Null listener provided to registerChangedListener. propertyName:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/device/analytics/log/Logger;->v(Ljava/lang/String;)V

    .line 251
    :goto_0
    return-void

    .line 242
    :cond_1
    sget-object v1, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->logger:Lcom/amazon/device/analytics/log/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Null propertyName provided to registerChangedListener. listener:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/device/analytics/log/Logger;->v(Ljava/lang/String;)V

    goto :goto_0

    .line 246
    :cond_2
    iget-object v1, p0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->changedListeners:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_3

    .line 247
    iget-object v1, p0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->changedListeners:Ljava/util/Map;

    new-instance v2, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v2}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    invoke-interface {v1, p1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 249
    :cond_3
    iget-object v1, p0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->changedListeners:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    .line 250
    .local v0, "changedListenerSet":Ljava/util/Map;, "Ljava/util/Map<Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;Ljava/lang/Boolean;>;"
    const/4 v1, 0x1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-interface {v0, p2, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method public registerRefreshListener(Lcom/amazon/device/analytics/configuration/ConfigurationRefreshListener;)V
    .locals 2
    .param p1, "listener"    # Lcom/amazon/device/analytics/configuration/ConfigurationRefreshListener;

    .prologue
    .line 305
    if-nez p1, :cond_1

    .line 306
    sget-object v0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->logger:Lcom/amazon/device/analytics/log/Logger;

    const-string/jumbo v1, "Null listener provided to registerRefreshListener"

    invoke-virtual {v0, v1}, Lcom/amazon/device/analytics/log/Logger;->v(Ljava/lang/String;)V

    .line 313
    :cond_0
    :goto_0
    return-void

    .line 310
    :cond_1
    iget-object v0, p0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->refreshListeners:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 311
    iget-object v0, p0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->refreshListeners:Ljava/util/Map;

    const/4 v1, 0x1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-interface {v0, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method public setParentConfiguration(Lcom/amazon/device/analytics/configuration/Configuration;)V
    .locals 1
    .param p1, "parentConfiguration"    # Lcom/amazon/device/analytics/configuration/Configuration;

    .prologue
    .line 220
    if-eqz p1, :cond_0

    .line 221
    invoke-interface {p1, p0}, Lcom/amazon/device/analytics/configuration/Configuration;->registerChangedListener(Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;)V

    .line 224
    :cond_0
    iget-object v0, p0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->parentConfiguration:Lcom/amazon/device/analytics/configuration/Configuration;

    if-eqz v0, :cond_1

    .line 225
    iget-object v0, p0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->parentConfiguration:Lcom/amazon/device/analytics/configuration/Configuration;

    invoke-interface {v0, p0}, Lcom/amazon/device/analytics/configuration/Configuration;->unregisterChangedListener(Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;)V

    .line 228
    :cond_1
    iput-object p1, p0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->parentConfiguration:Lcom/amazon/device/analytics/configuration/Configuration;

    .line 229
    return-void
.end method

.method public setProperty(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 2
    .param p1, "propertyName"    # Ljava/lang/String;
    .param p2, "propertyValue"    # Ljava/lang/Object;

    .prologue
    .line 157
    invoke-static {p1}, Lcom/amazon/device/analytics/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 158
    iget-object v0, p0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->properties:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 159
    if-eqz p2, :cond_1

    iget-object v0, p0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->properties:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 168
    :cond_0
    :goto_0
    return-void

    .line 163
    :cond_1
    if-eqz p2, :cond_0

    .line 164
    iget-object v0, p0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->properties:Ljava/util/Map;

    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 165
    invoke-virtual {p0, p1, p2}, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->notifyChangedListeners(Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public unregisterChangedListener(Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;

    .prologue
    .line 255
    const-string/jumbo v0, "_ALL_"

    invoke-virtual {p0, v0, p1}, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->unregisterChangedListener(Ljava/lang/String;Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;)V

    .line 256
    return-void
.end method

.method public unregisterChangedListener(Ljava/lang/String;Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;)V
    .locals 4
    .param p1, "propertyName"    # Ljava/lang/String;
    .param p2, "listener"    # Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;

    .prologue
    .line 260
    invoke-static {p1}, Lcom/amazon/device/analytics/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    if-nez p2, :cond_3

    .line 261
    :cond_0
    if-nez p2, :cond_2

    .line 262
    sget-object v1, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->logger:Lcom/amazon/device/analytics/log/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Null listener provided to registerChangedListener. propertyName:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/device/analytics/log/Logger;->v(Ljava/lang/String;)V

    .line 275
    :cond_1
    :goto_0
    return-void

    .line 264
    :cond_2
    sget-object v1, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->logger:Lcom/amazon/device/analytics/log/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Null propertyName provided to registerChangedListener. listener:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/device/analytics/log/Logger;->v(Ljava/lang/String;)V

    goto :goto_0

    .line 269
    :cond_3
    iget-object v1, p0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->changedListeners:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 270
    iget-object v1, p0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->changedListeners:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    .line 271
    .local v0, "changedListenerSet":Ljava/util/Map;, "Ljava/util/Map<Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;Ljava/lang/Boolean;>;"
    invoke-interface {v0, p2}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 272
    invoke-interface {v0, p2}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

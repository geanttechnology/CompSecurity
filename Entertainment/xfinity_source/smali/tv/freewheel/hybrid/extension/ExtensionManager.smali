.class public Ltv/freewheel/hybrid/extension/ExtensionManager;
.super Ljava/lang/Object;
.source "ExtensionManager.java"


# static fields
.field public static EXTENSIONS:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Class",
            "<+",
            "Ltv/freewheel/hybrid/extension/IExtension;",
            ">;>;"
        }
    .end annotation
.end field

.field public static internalExtensions:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static logger:Ltv/freewheel/hybrid/utils/Logger;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 14
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->synchronizedMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    sput-object v0, Ltv/freewheel/hybrid/extension/ExtensionManager;->EXTENSIONS:Ljava/util/Map;

    .line 19
    const-string v0, "ExtensionManager"

    invoke-static {v0}, Ltv/freewheel/hybrid/utils/Logger;->getLogger(Ljava/lang/String;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    sput-object v0, Ltv/freewheel/hybrid/extension/ExtensionManager;->logger:Ltv/freewheel/hybrid/utils/Logger;

    .line 21
    sget-object v0, Ltv/freewheel/hybrid/extension/ExtensionManager;->EXTENSIONS:Ljava/util/Map;

    const-string v1, "PauseAdExtension"

    const-class v2, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 22
    sget-object v0, Ltv/freewheel/hybrid/extension/ExtensionManager;->EXTENSIONS:Ljava/util/Map;

    const-string v1, "MedialetsExtension"

    const-class v2, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 23
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Ltv/freewheel/hybrid/extension/ExtensionManager;->internalExtensions:Ljava/util/ArrayList;

    .line 24
    sget-object v0, Ltv/freewheel/hybrid/extension/ExtensionManager;->internalExtensions:Ljava/util/ArrayList;

    const-string v1, "PauseAdExtension"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 25
    sget-object v0, Ltv/freewheel/hybrid/extension/ExtensionManager;->internalExtensions:Ljava/util/ArrayList;

    const-string v1, "MedialetsExtension"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 26
    return-void
.end method

.method public static loadExtension(Ljava/lang/String;Ltv/freewheel/hybrid/ad/AdContext;)Ltv/freewheel/hybrid/extension/IExtension;
    .locals 5
    .param p0, "name"    # Ljava/lang/String;
    .param p1, "context"    # Ltv/freewheel/hybrid/ad/AdContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalAccessException;,
            Ljava/lang/InstantiationException;
        }
    .end annotation

    .prologue
    .line 49
    sget-object v2, Ltv/freewheel/hybrid/extension/ExtensionManager;->EXTENSIONS:Ljava/util/Map;

    invoke-interface {v2, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Class;

    .line 50
    .local v0, "cls":Ljava/lang/Class;, "Ljava/lang/Class<+Ltv/freewheel/hybrid/extension/IExtension;>;"
    if-nez v0, :cond_0

    .line 51
    sget-object v2, Ltv/freewheel/hybrid/extension/ExtensionManager;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "can not get extension class for name:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->error(Ljava/lang/String;)V

    .line 52
    const/4 v1, 0x0

    .line 58
    :goto_0
    return-object v1

    .line 55
    :cond_0
    invoke-virtual {v0}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ltv/freewheel/hybrid/extension/IExtension;

    .line 56
    .local v1, "ext":Ltv/freewheel/hybrid/extension/IExtension;
    invoke-interface {v1, p1}, Ltv/freewheel/hybrid/extension/IExtension;->init(Ltv/freewheel/hybrid/ad/interfaces/IAdContext;)V

    .line 57
    iget-object v2, p1, Ltv/freewheel/hybrid/ad/AdContext;->loadedExtensions:Ljava/util/HashMap;

    invoke-virtual {v2, p0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method public static unregisterAdContext(Ltv/freewheel/hybrid/ad/AdContext;)V
    .locals 7
    .param p0, "adContext"    # Ltv/freewheel/hybrid/ad/AdContext;

    .prologue
    .line 33
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdContext;->loadedExtensions:Ljava/util/HashMap;

    invoke-virtual {v4}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 34
    .local v3, "name":Ljava/lang/String;
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdContext;->loadedExtensions:Ljava/util/HashMap;

    invoke-virtual {v4, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ltv/freewheel/hybrid/extension/IExtension;

    .line 36
    .local v1, "ext":Ltv/freewheel/hybrid/extension/IExtension;
    :try_start_0
    invoke-interface {v1}, Ltv/freewheel/hybrid/extension/IExtension;->stop()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 37
    :catch_0
    move-exception v0

    .line 38
    .local v0, "e":Ljava/lang/Exception;
    sget-object v4, Ltv/freewheel/hybrid/extension/ExtensionManager;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Exception happened when stop "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/utils/Logger;->warn(Ljava/lang/String;)V

    goto :goto_0

    .line 41
    .end local v0    # "e":Ljava/lang/Exception;
    .end local v1    # "ext":Ltv/freewheel/hybrid/extension/IExtension;
    .end local v3    # "name":Ljava/lang/String;
    :cond_0
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/AdContext;->loadedExtensions:Ljava/util/HashMap;

    invoke-virtual {v4}, Ljava/util/HashMap;->clear()V

    .line 42
    return-void
.end method

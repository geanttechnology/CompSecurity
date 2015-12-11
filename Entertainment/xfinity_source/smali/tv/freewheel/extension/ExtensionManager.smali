.class public Ltv/freewheel/extension/ExtensionManager;
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
            "Ltv/freewheel/extension/IExtension;",
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

.field private static logger:Ltv/freewheel/utils/Logger;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 15
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->synchronizedMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    sput-object v0, Ltv/freewheel/extension/ExtensionManager;->EXTENSIONS:Ljava/util/Map;

    .line 20
    const-string v0, "ExtensionManager"

    invoke-static {v0}, Ltv/freewheel/utils/Logger;->getLogger(Ljava/lang/String;)Ltv/freewheel/utils/Logger;

    move-result-object v0

    sput-object v0, Ltv/freewheel/extension/ExtensionManager;->logger:Ltv/freewheel/utils/Logger;

    .line 22
    sget-object v0, Ltv/freewheel/extension/ExtensionManager;->EXTENSIONS:Ljava/util/Map;

    const-string v1, "PauseAdExtension"

    const-class v2, Ltv/freewheel/extension/pausead/PauseAdExtension;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 23
    sget-object v0, Ltv/freewheel/extension/ExtensionManager;->EXTENSIONS:Ljava/util/Map;

    const-string v1, "MedialetsExtension"

    const-class v2, Ltv/freewheel/extension/medialets/MedialetsExtension;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 24
    sget-object v0, Ltv/freewheel/extension/ExtensionManager;->EXTENSIONS:Ljava/util/Map;

    const-string v1, "BlueKaiDataExtension"

    const-class v2, Ltv/freewheel/extension/blueKai/BlueKaiDataExtension;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 25
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Ltv/freewheel/extension/ExtensionManager;->internalExtensions:Ljava/util/ArrayList;

    .line 26
    sget-object v0, Ltv/freewheel/extension/ExtensionManager;->internalExtensions:Ljava/util/ArrayList;

    const-string v1, "PauseAdExtension"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 27
    sget-object v0, Ltv/freewheel/extension/ExtensionManager;->internalExtensions:Ljava/util/ArrayList;

    const-string v1, "MedialetsExtension"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 28
    sget-object v0, Ltv/freewheel/extension/ExtensionManager;->internalExtensions:Ljava/util/ArrayList;

    const-string v1, "BlueKaiDataExtension"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 29
    return-void
.end method

.method public static loadExtension(Ljava/lang/String;Ltv/freewheel/ad/AdContext;)Ltv/freewheel/extension/IExtension;
    .locals 5
    .param p0, "name"    # Ljava/lang/String;
    .param p1, "context"    # Ltv/freewheel/ad/AdContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalAccessException;,
            Ljava/lang/InstantiationException;
        }
    .end annotation

    .prologue
    .line 52
    sget-object v2, Ltv/freewheel/extension/ExtensionManager;->EXTENSIONS:Ljava/util/Map;

    invoke-interface {v2, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Class;

    .line 53
    .local v0, "cls":Ljava/lang/Class;, "Ljava/lang/Class<+Ltv/freewheel/extension/IExtension;>;"
    if-nez v0, :cond_0

    .line 54
    sget-object v2, Ltv/freewheel/extension/ExtensionManager;->logger:Ltv/freewheel/utils/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "can not get extension class for name:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->error(Ljava/lang/String;)V

    .line 55
    const/4 v1, 0x0

    .line 61
    :goto_0
    return-object v1

    .line 58
    :cond_0
    invoke-virtual {v0}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ltv/freewheel/extension/IExtension;

    .line 59
    .local v1, "ext":Ltv/freewheel/extension/IExtension;
    invoke-interface {v1, p1}, Ltv/freewheel/extension/IExtension;->init(Ltv/freewheel/ad/interfaces/IAdContext;)V

    .line 60
    iget-object v2, p1, Ltv/freewheel/ad/AdContext;->loadedExtensions:Ljava/util/HashMap;

    invoke-virtual {v2, p0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

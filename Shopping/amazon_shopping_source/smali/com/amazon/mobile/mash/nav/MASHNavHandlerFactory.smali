.class public abstract Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory;
.super Ljava/lang/Object;
.source "MASHNavHandlerFactory.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory$ModalCloseHandlerFactory;,
        Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory$ModalOpenHandlerFactory;,
        Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory$ReplaceHandlerFactory;,
        Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory$ForwardHandlerFactory;,
        Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory$BackHandlerFactory;
    }
.end annotation


# static fields
.field private static sNavHandlerFactoryMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 17
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory;->sNavHandlerFactoryMap:Ljava/util/Map;

    .line 20
    const-string/jumbo v0, "back"

    new-instance v1, Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory$BackHandlerFactory;

    invoke-direct {v1}, Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory$BackHandlerFactory;-><init>()V

    invoke-static {v0, v1}, Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory;->registerMap(Ljava/lang/String;Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory;)V

    .line 21
    const-string/jumbo v0, "forward"

    new-instance v1, Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory$ForwardHandlerFactory;

    invoke-direct {v1}, Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory$ForwardHandlerFactory;-><init>()V

    invoke-static {v0, v1}, Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory;->registerMap(Ljava/lang/String;Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory;)V

    .line 22
    const-string/jumbo v0, "replace"

    new-instance v1, Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory$ReplaceHandlerFactory;

    invoke-direct {v1}, Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory$ReplaceHandlerFactory;-><init>()V

    invoke-static {v0, v1}, Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory;->registerMap(Ljava/lang/String;Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory;)V

    .line 23
    const-string/jumbo v0, "modalOpen"

    new-instance v1, Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory$ModalOpenHandlerFactory;

    invoke-direct {v1}, Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory$ModalOpenHandlerFactory;-><init>()V

    invoke-static {v0, v1}, Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory;->registerMap(Ljava/lang/String;Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory;)V

    .line 24
    const-string/jumbo v0, "modalClose"

    new-instance v1, Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory$ModalCloseHandlerFactory;

    invoke-direct {v1}, Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory$ModalCloseHandlerFactory;-><init>()V

    invoke-static {v0, v1}, Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory;->registerMap(Ljava/lang/String;Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory;)V

    .line 25
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 126
    return-void
.end method

.method public static getMASHNavHandlerFactoryImpl(Ljava/lang/String;)Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory;
    .locals 3
    .param p0, "key"    # Ljava/lang/String;

    .prologue
    .line 43
    move-object v1, p0

    .line 44
    .local v1, "newKey":Ljava/lang/String;
    const-string/jumbo v2, "back"

    invoke-virtual {p0, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 45
    const-string/jumbo v1, "back"

    .line 47
    :cond_0
    sget-object v2, Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory;->sNavHandlerFactoryMap:Ljava/util/Map;

    invoke-interface {v2, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory;

    .line 48
    .local v0, "factory":Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory;
    return-object v0
.end method

.method public static registerMap(Ljava/lang/String;Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory;)V
    .locals 1
    .param p0, "key"    # Ljava/lang/String;
    .param p1, "factory"    # Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory;

    .prologue
    .line 33
    sget-object v0, Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory;->sNavHandlerFactoryMap:Ljava/util/Map;

    invoke-interface {v0, p0, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 34
    return-void
.end method


# virtual methods
.method public abstract createOperationHandler(Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;Ljava/util/List;I)Lcom/amazon/mobile/mash/nav/MASHNavHandler;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mobile/mash/nav/MASHNavOperation;",
            ">;I)",
            "Lcom/amazon/mobile/mash/nav/MASHNavHandler;"
        }
    .end annotation
.end method

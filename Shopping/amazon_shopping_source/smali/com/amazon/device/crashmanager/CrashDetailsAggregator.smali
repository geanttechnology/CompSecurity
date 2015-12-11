.class public Lcom/amazon/device/crashmanager/CrashDetailsAggregator;
.super Ljava/lang/Object;
.source "CrashDetailsAggregator.java"

# interfaces
.implements Lcom/amazon/device/crashmanager/CrashDetailsCollectable;


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private collectors:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/device/crashmanager/CrashDetailsCollectable;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 11
    const-class v0, Lcom/amazon/device/crashmanager/CrashDetailsAggregator;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/crashmanager/CrashDetailsAggregator;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/device/crashmanager/CrashDetailsAggregator;->collectors:Ljava/util/List;

    return-void
.end method


# virtual methods
.method public appendCollector(Lcom/amazon/device/crashmanager/CrashDetailsCollectable;)V
    .locals 1
    .param p1, "crashDetailsCollector"    # Lcom/amazon/device/crashmanager/CrashDetailsCollectable;

    .prologue
    .line 21
    iget-object v0, p0, Lcom/amazon/device/crashmanager/CrashDetailsAggregator;->collectors:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 22
    return-void
.end method

.method public collect(Ljava/lang/Throwable;)Ljava/util/Map;
    .locals 7
    .param p1, "ex"    # Ljava/lang/Throwable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Throwable;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 26
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 27
    .local v1, "details":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v4, p0, Lcom/amazon/device/crashmanager/CrashDetailsAggregator;->collectors:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/device/crashmanager/CrashDetailsCollectable;

    .line 30
    .local v0, "cdc":Lcom/amazon/device/crashmanager/CrashDetailsCollectable;
    :try_start_0
    invoke-interface {v0, p1}, Lcom/amazon/device/crashmanager/CrashDetailsCollectable;->collect(Ljava/lang/Throwable;)Ljava/util/Map;

    move-result-object v4

    invoke-interface {v1, v4}, Ljava/util/Map;->putAll(Ljava/util/Map;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 31
    :catch_0
    move-exception v2

    .line 32
    .local v2, "exceptExtra":Ljava/lang/Exception;
    sget-object v4, Lcom/amazon/device/crashmanager/CrashDetailsAggregator;->TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "crash data collector: \'"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, "\' threw exception: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 36
    .end local v0    # "cdc":Lcom/amazon/device/crashmanager/CrashDetailsCollectable;
    .end local v2    # "exceptExtra":Ljava/lang/Exception;
    :cond_0
    return-object v1
.end method

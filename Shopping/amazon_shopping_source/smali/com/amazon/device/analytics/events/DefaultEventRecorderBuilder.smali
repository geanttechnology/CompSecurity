.class public Lcom/amazon/device/analytics/events/DefaultEventRecorderBuilder;
.super Ljava/lang/Object;
.source "DefaultEventRecorderBuilder.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private applicationKey:Ljava/lang/String;

.field private observers:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/device/analytics/events/observers/EventObserver;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/device/analytics/events/DefaultEventRecorderBuilder;->observers:Ljava/util/List;

    return-void
.end method


# virtual methods
.method public build()Lcom/amazon/device/analytics/events/EventRecorder;
    .locals 1

    .prologue
    .line 51
    new-instance v0, Lcom/amazon/device/analytics/events/DefaultEventRecorder;

    invoke-direct {v0, p0}, Lcom/amazon/device/analytics/events/DefaultEventRecorder;-><init>(Lcom/amazon/device/analytics/events/DefaultEventRecorderBuilder;)V

    return-object v0
.end method

.method protected getApplicationKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/amazon/device/analytics/events/DefaultEventRecorderBuilder;->applicationKey:Ljava/lang/String;

    return-object v0
.end method

.method protected getObservers()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/device/analytics/events/observers/EventObserver;",
            ">;"
        }
    .end annotation

    .prologue
    .line 43
    iget-object v0, p0, Lcom/amazon/device/analytics/events/DefaultEventRecorderBuilder;->observers:Ljava/util/List;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 56
    new-instance v0, Lcom/amazon/device/analytics/util/JSONBuilder;

    invoke-direct {v0, p0}, Lcom/amazon/device/analytics/util/JSONBuilder;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v0}, Lcom/amazon/device/analytics/util/JSONBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public withApplicationKey(Ljava/lang/String;)Lcom/amazon/device/analytics/events/DefaultEventRecorderBuilder;
    .locals 0
    .param p1, "applicationKey"    # Ljava/lang/String;

    .prologue
    .line 24
    iput-object p1, p0, Lcom/amazon/device/analytics/events/DefaultEventRecorderBuilder;->applicationKey:Ljava/lang/String;

    .line 25
    return-object p0
.end method

.method public withObserver(Lcom/amazon/device/analytics/events/observers/EventObserver;)Lcom/amazon/device/analytics/events/DefaultEventRecorderBuilder;
    .locals 1
    .param p1, "observer"    # Lcom/amazon/device/analytics/events/observers/EventObserver;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/amazon/device/analytics/events/DefaultEventRecorderBuilder;->observers:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 39
    return-object p0
.end method

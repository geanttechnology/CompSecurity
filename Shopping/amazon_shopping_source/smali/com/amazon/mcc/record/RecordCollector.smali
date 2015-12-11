.class public abstract Lcom/amazon/mcc/record/RecordCollector;
.super Ljava/lang/Object;
.source "RecordCollector.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mcc/record/RecordCollector$RecordObserver;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    return-void
.end method


# virtual methods
.method public abstract handle(Lcom/amazon/mcc/record/PropertyMap;)V
.end method

.method public register()V
    .locals 3

    .prologue
    .line 33
    new-instance v0, Lcom/amazon/mcc/record/RecordCollector$RecordObserver;

    invoke-direct {v0, p0}, Lcom/amazon/mcc/record/RecordCollector$RecordObserver;-><init>(Lcom/amazon/mcc/record/RecordCollector;)V

    .line 35
    .local v0, "observer":Lcom/amazon/mcc/record/RecordCollector$RecordObserver;
    sget-object v1, Lcom/amazon/mcc/record/BasicRecorder;->BROKER:Lcom/amazon/mcc/nps/broker/Broker;

    sget-object v2, Lcom/amazon/mcc/record/RecordConstants;->RECORD_TOPIC:Ljava/lang/String;

    invoke-static {v2}, Lcom/amazon/mcc/nps/Topic;->of(Ljava/lang/String;)Lcom/amazon/mcc/nps/Topic;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Lcom/amazon/mcc/nps/broker/Broker;->register(Lcom/amazon/mcc/nps/Topic;Lcom/amazon/mcc/nps/Observer;)Z

    .line 36
    return-void
.end method

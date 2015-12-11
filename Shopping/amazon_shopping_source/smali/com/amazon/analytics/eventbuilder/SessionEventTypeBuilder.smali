.class public abstract Lcom/amazon/analytics/eventbuilder/SessionEventTypeBuilder;
.super Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;
.source "SessionEventTypeBuilder.java"

# interfaces
.implements Lcom/amazon/analytics/eventbuilder/AnalyticsBuilderInterfaces$ActivityNameView;
.implements Lcom/amazon/analytics/eventbuilder/AnalyticsBuilderInterfaces$SessionTypeBuilder;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/analytics/eventbuilder/SessionEventTypeBuilder$1;,
        Lcom/amazon/analytics/eventbuilder/SessionEventTypeBuilder$OnResumeBuilder;,
        Lcom/amazon/analytics/eventbuilder/SessionEventTypeBuilder$OnPauseBuilder;
    }
.end annotation


# static fields
.field private static final logger:Lcom/amazon/device/analytics/log/Logger;


# instance fields
.field activityName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    const-class v0, Lcom/amazon/analytics/eventbuilder/SessionEventTypeBuilder;

    invoke-static {v0}, Lcom/amazon/device/analytics/log/Logging;->getLogger(Ljava/lang/Class;)Lcom/amazon/device/analytics/log/Logger;

    move-result-object v0

    sput-object v0, Lcom/amazon/analytics/eventbuilder/SessionEventTypeBuilder;->logger:Lcom/amazon/device/analytics/log/Logger;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/analytics/eventbuilder/SessionEventTypeBuilder$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/analytics/eventbuilder/SessionEventTypeBuilder$1;

    .prologue
    .line 17
    invoke-direct {p0}, Lcom/amazon/analytics/eventbuilder/SessionEventTypeBuilder;-><init>()V

    return-void
.end method


# virtual methods
.method processEvent(Lcom/amazon/device/analytics/events/Event;)V
    .locals 5
    .param p1, "event"    # Lcom/amazon/device/analytics/events/Event;

    .prologue
    .line 46
    new-instance v0, Lcom/amazon/analytics/util/Message;

    invoke-direct {v0}, Lcom/amazon/analytics/util/Message;-><init>()V

    .line 47
    .local v0, "message":Lcom/amazon/analytics/util/Message;
    invoke-virtual {v0}, Lcom/amazon/analytics/util/Message;->getExtras()Ljava/util/Map;

    move-result-object v1

    const-string/jumbo v2, "TimeStamp"

    iget-wide v3, p0, Lcom/amazon/analytics/eventbuilder/SessionEventTypeBuilder;->timestamp:J

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 48
    invoke-virtual {v0}, Lcom/amazon/analytics/util/Message;->getExtras()Ljava/util/Map;

    move-result-object v1

    const-string/jumbo v2, "PackageName"

    iget-object v3, p0, Lcom/amazon/analytics/eventbuilder/SessionEventTypeBuilder;->packageName:Ljava/lang/String;

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 49
    invoke-virtual {v0}, Lcom/amazon/analytics/util/Message;->getExtras()Ljava/util/Map;

    move-result-object v2

    const-string/jumbo v3, "SessionFlag"

    invoke-virtual {p0}, Lcom/amazon/analytics/eventbuilder/SessionEventTypeBuilder;->getType()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v4, "onResume"

    invoke-virtual {v1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v1, 0x0

    :goto_0
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v2, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 50
    invoke-virtual {v0}, Lcom/amazon/analytics/util/Message;->getExtras()Ljava/util/Map;

    move-result-object v1

    const-string/jumbo v2, "TailwindEvent"

    invoke-interface {v1, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 51
    invoke-virtual {v0}, Lcom/amazon/analytics/util/Message;->getExtras()Ljava/util/Map;

    move-result-object v1

    const-string/jumbo v2, "topic"

    invoke-virtual {p0}, Lcom/amazon/analytics/eventbuilder/SessionEventTypeBuilder;->getType()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 54
    iget-object v1, p0, Lcom/amazon/analytics/eventbuilder/SessionEventTypeBuilder;->queue:Lcom/amazon/analytics/session/PriorityQueue;

    invoke-virtual {v1, v0}, Lcom/amazon/analytics/session/PriorityQueue;->enqueue(Lcom/amazon/analytics/util/Message;)V

    .line 55
    sget-object v1, Lcom/amazon/analytics/eventbuilder/SessionEventTypeBuilder;->logger:Lcom/amazon/device/analytics/log/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Published an "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Lcom/amazon/analytics/eventbuilder/SessionEventTypeBuilder;->getType()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, " Session event at "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/amazon/analytics/util/Message;->getExtras()Ljava/util/Map;

    move-result-object v3

    const-string/jumbo v4, "TimeStamp"

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, " for package "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/analytics/eventbuilder/SessionEventTypeBuilder;->packageName:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/device/analytics/log/Logger;->d(Ljava/lang/String;)V

    .line 57
    return-void

    .line 49
    :cond_0
    const/4 v1, 0x1

    goto :goto_0
.end method

.method setupEventAttributesAndMetrics(Lcom/amazon/device/analytics/events/Event;)V
    .locals 2
    .param p1, "event"    # Lcom/amazon/device/analytics/events/Event;

    .prologue
    .line 38
    invoke-super {p0, p1}, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;->setupEventAttributesAndMetrics(Lcom/amazon/device/analytics/events/Event;)V

    .line 39
    const-string/jumbo v0, "an"

    iget-object v1, p0, Lcom/amazon/analytics/eventbuilder/SessionEventTypeBuilder;->activityName:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Lcom/amazon/device/analytics/events/Event;->addAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 40
    const-string/jumbo v0, "os"

    sget-object v1, Landroid/os/Build$VERSION;->CODENAME:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Lcom/amazon/device/analytics/events/Event;->addAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 41
    const-string/jumbo v0, "ov"

    sget-object v1, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Lcom/amazon/device/analytics/events/Event;->addAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 42
    return-void
.end method

.method public withActivityName(Ljava/lang/String;)Lcom/amazon/analytics/eventbuilder/AnalyticsBuilderInterfaces$BaseAnalyticsBuilder;
    .locals 1
    .param p1, "activityName"    # Ljava/lang/String;

    .prologue
    .line 32
    invoke-static {p1}, Lcom/amazon/analytics/util/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/amazon/analytics/eventbuilder/SessionEventTypeBuilder;->activityName:Ljava/lang/String;

    .line 33
    return-object p0
.end method

.class public Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;
.super Ljava/lang/Object;
.source "AnalyticsEventBuilder.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InjectPoint"
.end annotation


# static fields
.field private static final injectPoint:Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;


# instance fields
.field config:Lcom/amazon/analytics/AnalyticsConfiguration;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field execService:Ljava/util/concurrent/ScheduledExecutorService;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation

    .annotation runtime Ljavax/inject/Named;
        value = "TailwindExecutorService"
    .end annotation
.end field

.field initializer:Lcom/amazon/analytics/AnalyticsConfigurationInitializer;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field queue:Lcom/amazon/analytics/session/PriorityQueue;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field recorder:Lcom/amazon/device/analytics/events/EventRecorder;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 127
    new-instance v0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;

    invoke-direct {v0}, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;-><init>()V

    sput-object v0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;->injectPoint:Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 126
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static inject(Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;)V
    .locals 1
    .param p0, "builder"    # Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;

    .prologue
    .line 137
    sget-object v0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;->injectPoint:Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;

    invoke-static {v0}, Lcom/amazon/android/dagger/DaggerAndroid;->inject(Ljava/lang/Object;)V

    .line 138
    sget-object v0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;->injectPoint:Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;

    iget-object v0, v0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;->initializer:Lcom/amazon/analytics/AnalyticsConfigurationInitializer;

    iput-object v0, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;->initializer:Lcom/amazon/analytics/AnalyticsConfigurationInitializer;

    .line 139
    sget-object v0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;->injectPoint:Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;

    iget-object v0, v0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;->recorder:Lcom/amazon/device/analytics/events/EventRecorder;

    iput-object v0, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;->recorder:Lcom/amazon/device/analytics/events/EventRecorder;

    .line 140
    sget-object v0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;->injectPoint:Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;

    iget-object v0, v0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;->config:Lcom/amazon/analytics/AnalyticsConfiguration;

    iput-object v0, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;->config:Lcom/amazon/analytics/AnalyticsConfiguration;

    .line 141
    sget-object v0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;->injectPoint:Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;

    iget-object v0, v0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;->queue:Lcom/amazon/analytics/session/PriorityQueue;

    iput-object v0, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;->queue:Lcom/amazon/analytics/session/PriorityQueue;

    .line 142
    sget-object v0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;->injectPoint:Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;

    iget-object v0, v0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;->execService:Ljava/util/concurrent/ScheduledExecutorService;

    iput-object v0, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;->execService:Ljava/util/concurrent/ExecutorService;

    .line 143
    return-void
.end method

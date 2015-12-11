.class Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$1;
.super Ljava/lang/Object;
.source "AnalyticsEventBuilder.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;->record()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;

.field final synthetic val$event:Lcom/amazon/device/analytics/events/Event;


# direct methods
.method constructor <init>(Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;Lcom/amazon/device/analytics/events/Event;)V
    .locals 0

    .prologue
    .line 169
    iput-object p1, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$1;->this$0:Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;

    iput-object p2, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$1;->val$event:Lcom/amazon/device/analytics/events/Event;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 172
    iget-object v0, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$1;->this$0:Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;

    iget-object v1, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$1;->val$event:Lcom/amazon/device/analytics/events/Event;

    invoke-virtual {v0, v1}, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;->processEvent(Lcom/amazon/device/analytics/events/Event;)V

    .line 173
    return-void
.end method

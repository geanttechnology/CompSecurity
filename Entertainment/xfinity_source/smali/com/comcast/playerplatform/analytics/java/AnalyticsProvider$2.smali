.class Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$2;
.super Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;
.source "AnalyticsProvider.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->sendDataToServer(Ljava/util/List;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

.field final synthetic val$dataMessages:Ljava/util/List;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 261
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$2;->this$0:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    iput-object p2, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$2;->val$dataMessages:Ljava/util/List;

    invoke-direct {p0}, Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;-><init>()V

    return-void
.end method


# virtual methods
.method public requestFailed(Ljava/lang/String;)V
    .locals 2
    .param p1, "response"    # Ljava/lang/String;

    .prologue
    .line 269
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$2;->this$0:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    # getter for: Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->analyticsEventListener:Lcom/comcast/playerplatform/analytics/java/event/AbstractPlayerPlatformAnalyticsEvent;
    invoke-static {v0}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->access$200(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;)Lcom/comcast/playerplatform/analytics/java/event/AbstractPlayerPlatformAnalyticsEvent;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$2;->val$dataMessages:Ljava/util/List;

    invoke-virtual {v0, p1, v1}, Lcom/comcast/playerplatform/analytics/java/event/AbstractPlayerPlatformAnalyticsEvent;->messagesFailed(Ljava/lang/String;Ljava/util/Collection;)V

    .line 270
    return-void
.end method

.method public responseReceived(Ljava/lang/String;)V
    .locals 2
    .param p1, "response"    # Ljava/lang/String;

    .prologue
    .line 264
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$2;->this$0:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    # getter for: Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->analyticsEventListener:Lcom/comcast/playerplatform/analytics/java/event/AbstractPlayerPlatformAnalyticsEvent;
    invoke-static {v0}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->access$200(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;)Lcom/comcast/playerplatform/analytics/java/event/AbstractPlayerPlatformAnalyticsEvent;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$2;->val$dataMessages:Ljava/util/List;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/analytics/java/event/AbstractPlayerPlatformAnalyticsEvent;->messagesSent(Ljava/util/Collection;)V

    .line 265
    return-void
.end method

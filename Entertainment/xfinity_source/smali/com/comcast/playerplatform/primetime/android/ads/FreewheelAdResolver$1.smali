.class Lcom/comcast/playerplatform/primetime/android/ads/FreewheelAdResolver$1;
.super Ljava/lang/Object;
.source "FreewheelAdResolver.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/primetime/android/ads/FreewheelAdResolver;->doResolveAds(Lcom/adobe/mediacore/metadata/Metadata;Lcom/adobe/mediacore/timeline/PlacementOpportunity;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/ads/FreewheelAdResolver;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/ads/FreewheelAdResolver;)V
    .locals 0

    .prologue
    .line 29
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/ads/FreewheelAdResolver$1;->this$0:Lcom/comcast/playerplatform/primetime/android/ads/FreewheelAdResolver;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 32
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/FreewheelAdResolver$1;->this$0:Lcom/comcast/playerplatform/primetime/android/ads/FreewheelAdResolver;

    iget-object v1, v1, Lcom/comcast/playerplatform/primetime/android/ads/FreewheelAdResolver;->freewheelManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->getAdProposals()Ljava/util/Vector;

    move-result-object v0

    .line 33
    .local v0, "proposals":Ljava/util/Vector;, "Ljava/util/Vector<Lcom/adobe/mediacore/timeline/TimelineOperation;>;"
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v1

    new-instance v2, Lcom/comcast/playerplatform/primetime/android/ads/FreewheelAdResolver$1$1;

    invoke-direct {v2, p0, v0}, Lcom/comcast/playerplatform/primetime/android/ads/FreewheelAdResolver$1$1;-><init>(Lcom/comcast/playerplatform/primetime/android/ads/FreewheelAdResolver$1;Ljava/util/Vector;)V

    invoke-virtual {v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 39
    return-void
.end method

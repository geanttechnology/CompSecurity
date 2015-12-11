.class Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager$1;
.super Ljava/lang/Object;
.source "FreewheelManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;)V
    .locals 0

    .prologue
    .line 173
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager$1;->this$0:Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 176
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager$1;->this$0:Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->adContext:Ltv/freewheel/ad/interfaces/IAdContext;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->access$400(Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;)Ltv/freewheel/ad/interfaces/IAdContext;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager$1;->this$0:Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->adConstants:Ltv/freewheel/ad/interfaces/IConstants;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->access$000(Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;)Ltv/freewheel/ad/interfaces/IConstants;

    move-result-object v1

    invoke-interface {v1}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_REQUEST_COMPLETE()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager$1$1;

    invoke-direct {v2, p0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager$1$1;-><init>(Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager$1;)V

    invoke-interface {v0, v1, v2}, Ltv/freewheel/ad/interfaces/IAdContext;->addEventListener(Ljava/lang/String;Ltv/freewheel/ad/interfaces/IEventListener;)V

    .line 197
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager$1;->this$0:Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;

    # getter for: Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->adContext:Ltv/freewheel/ad/interfaces/IAdContext;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->access$400(Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;)Ltv/freewheel/ad/interfaces/IAdContext;

    move-result-object v0

    const-wide/high16 v2, 0x4008000000000000L    # 3.0

    invoke-interface {v0, v2, v3}, Ltv/freewheel/ad/interfaces/IAdContext;->submitRequest(D)V

    .line 198
    return-void
.end method

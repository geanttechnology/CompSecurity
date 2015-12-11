.class Lcom/comcast/playerplatform/primetime/android/ads/FreewheelAdResolver$1$1;
.super Ljava/lang/Object;
.source "FreewheelAdResolver.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/primetime/android/ads/FreewheelAdResolver$1;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/comcast/playerplatform/primetime/android/ads/FreewheelAdResolver$1;

.field final synthetic val$proposals:Ljava/util/Vector;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/ads/FreewheelAdResolver$1;Ljava/util/Vector;)V
    .locals 0

    .prologue
    .line 33
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/ads/FreewheelAdResolver$1$1;->this$1:Lcom/comcast/playerplatform/primetime/android/ads/FreewheelAdResolver$1;

    iput-object p2, p0, Lcom/comcast/playerplatform/primetime/android/ads/FreewheelAdResolver$1$1;->val$proposals:Ljava/util/Vector;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 36
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/FreewheelAdResolver$1$1;->this$1:Lcom/comcast/playerplatform/primetime/android/ads/FreewheelAdResolver$1;

    iget-object v0, v0, Lcom/comcast/playerplatform/primetime/android/ads/FreewheelAdResolver$1;->this$0:Lcom/comcast/playerplatform/primetime/android/ads/FreewheelAdResolver;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/ads/FreewheelAdResolver$1$1;->val$proposals:Ljava/util/Vector;

    # invokes: Lcom/comcast/playerplatform/primetime/android/ads/FreewheelAdResolver;->notifyResolveComplete(Ljava/util/List;)V
    invoke-static {v0, v1}, Lcom/comcast/playerplatform/primetime/android/ads/FreewheelAdResolver;->access$000(Lcom/comcast/playerplatform/primetime/android/ads/FreewheelAdResolver;Ljava/util/List;)V

    .line 37
    return-void
.end method

.class Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$6;
.super Ljava/lang/Object;
.source "PrimeTimePlayer.java"

# interfaces
.implements Lcom/adobe/ave/drm/DRMOperationErrorCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)V
    .locals 0

    .prologue
    .line 1105
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$6;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public OperationError(JJLjava/lang/Exception;)V
    .locals 3
    .param p1, "l"    # J
    .param p3, "l1"    # J
    .param p5, "e"    # Ljava/lang/Exception;

    .prologue
    .line 1108
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$6;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$200(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    move-result-object v0

    const-string v1, "DRM Operation Error"

    invoke-virtual {p5}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 1109
    return-void
.end method

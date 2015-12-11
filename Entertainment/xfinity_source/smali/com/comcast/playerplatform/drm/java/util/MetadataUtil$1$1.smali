.class Lcom/comcast/playerplatform/drm/java/util/MetadataUtil$1$1;
.super Ljava/lang/Object;
.source "MetadataUtil.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/drm/java/util/MetadataUtil$1;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/drm/java/util/MetadataUtil$1;

.field final synthetic val$manifestString:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/drm/java/util/MetadataUtil$1;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 31
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/util/MetadataUtil$1$1;->this$0:Lcom/comcast/playerplatform/drm/java/util/MetadataUtil$1;

    iput-object p2, p0, Lcom/comcast/playerplatform/drm/java/util/MetadataUtil$1$1;->val$manifestString:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 34
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/util/MetadataUtil$1$1;->this$0:Lcom/comcast/playerplatform/drm/java/util/MetadataUtil$1;

    iget-object v0, v0, Lcom/comcast/playerplatform/drm/java/util/MetadataUtil$1;->val$responseEventListener:Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;

    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/util/MetadataUtil$1$1;->val$manifestString:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;->responseReceived(Ljava/lang/String;)V

    .line 35
    return-void
.end method

.class final Lcom/comcast/playerplatform/drm/java/util/MetadataUtil$2;
.super Ljava/lang/Object;
.source "MetadataUtil.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/drm/java/util/MetadataUtil;->attachMetadata(Ljava/lang/String;Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$manifestUri:Ljava/lang/String;

.field final synthetic val$responseEventListener:Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 57
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/util/MetadataUtil$2;->val$responseEventListener:Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;

    iput-object p2, p0, Lcom/comcast/playerplatform/drm/java/util/MetadataUtil$2;->val$manifestUri:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 60
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/util/MetadataUtil$2;->val$responseEventListener:Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "manifest not found:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/util/MetadataUtil$2;->val$manifestUri:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;->requestFailed(Ljava/lang/String;)V

    .line 66
    return-void
.end method

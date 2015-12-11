.class final Lcom/comcast/playerplatform/drm/java/util/MetadataUtil$1;
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

.field final synthetic val$uri:Ljava/net/URI;


# direct methods
.method constructor <init>(Ljava/net/URI;Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 26
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/util/MetadataUtil$1;->val$uri:Ljava/net/URI;

    iput-object p2, p0, Lcom/comcast/playerplatform/drm/java/util/MetadataUtil$1;->val$responseEventListener:Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;

    iput-object p3, p0, Lcom/comcast/playerplatform/drm/java/util/MetadataUtil$1;->val$manifestUri:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 30
    :try_start_0
    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/util/MetadataUtil$1;->val$uri:Ljava/net/URI;

    invoke-virtual {v2}, Ljava/net/URI;->getScheme()Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_0

    const-string v2, "file:/"

    invoke-static {v2}, Ljava/net/URI;->create(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/playerplatform/drm/java/util/MetadataUtil$1;->val$uri:Ljava/net/URI;

    invoke-virtual {v2, v3}, Ljava/net/URI;->resolve(Ljava/net/URI;)Ljava/net/URI;

    move-result-object v2

    # invokes: Lcom/comcast/playerplatform/drm/java/util/MetadataUtil;->readFile(Ljava/net/URI;)Ljava/lang/String;
    invoke-static {v2}, Lcom/comcast/playerplatform/drm/java/util/MetadataUtil;->access$000(Ljava/net/URI;)Ljava/lang/String;

    move-result-object v1

    .line 31
    .local v1, "manifestString":Ljava/lang/String;
    :goto_0
    invoke-static {}, Lcom/comcast/playerplatform/drm/java/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/drm/java/util/ThreadManager;

    move-result-object v2

    new-instance v3, Lcom/comcast/playerplatform/drm/java/util/MetadataUtil$1$1;

    invoke-direct {v3, p0, v1}, Lcom/comcast/playerplatform/drm/java/util/MetadataUtil$1$1;-><init>(Lcom/comcast/playerplatform/drm/java/util/MetadataUtil$1;Ljava/lang/String;)V

    invoke-virtual {v2, v3}, Lcom/comcast/playerplatform/drm/java/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 51
    .end local v1    # "manifestString":Ljava/lang/String;
    :goto_1
    return-void

    .line 30
    :cond_0
    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/util/MetadataUtil$1;->val$uri:Ljava/net/URI;

    # invokes: Lcom/comcast/playerplatform/drm/java/util/MetadataUtil;->readFile(Ljava/net/URI;)Ljava/lang/String;
    invoke-static {v2}, Lcom/comcast/playerplatform/drm/java/util/MetadataUtil;->access$000(Ljava/net/URI;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    goto :goto_0

    .line 37
    :catch_0
    move-exception v0

    .line 38
    .local v0, "e":Ljava/lang/Exception;
    invoke-static {}, Lcom/comcast/playerplatform/drm/java/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/drm/java/util/ThreadManager;

    move-result-object v2

    new-instance v3, Lcom/comcast/playerplatform/drm/java/util/MetadataUtil$1$2;

    invoke-direct {v3, p0}, Lcom/comcast/playerplatform/drm/java/util/MetadataUtil$1$2;-><init>(Lcom/comcast/playerplatform/drm/java/util/MetadataUtil$1;)V

    invoke-virtual {v2, v3}, Lcom/comcast/playerplatform/drm/java/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    goto :goto_1
.end method

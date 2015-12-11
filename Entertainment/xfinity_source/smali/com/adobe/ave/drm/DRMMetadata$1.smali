.class Lcom/adobe/ave/drm/DRMMetadata$1;
.super Ljava/lang/Object;
.source "DRMMetadata.java"

# interfaces
.implements Lcom/adobe/ave/drm/DRMMetadataCreatedCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/adobe/ave/drm/DRMMetadata;-><init>(Lcom/adobe/ave/drm/DRMManager;[BLcom/adobe/ave/drm/DRMOperationErrorCallback;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/adobe/ave/drm/DRMMetadata;


# direct methods
.method constructor <init>(Lcom/adobe/ave/drm/DRMMetadata;)V
    .locals 0
    .param p1, "this$0"    # Lcom/adobe/ave/drm/DRMMetadata;

    .prologue
    .line 56
    iput-object p1, p0, Lcom/adobe/ave/drm/DRMMetadata$1;->this$0:Lcom/adobe/ave/drm/DRMMetadata;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public MetadataCreated(J)V
    .locals 1
    .param p1, "inPeerObject"    # J

    .prologue
    .line 59
    iget-object v0, p0, Lcom/adobe/ave/drm/DRMMetadata$1;->this$0:Lcom/adobe/ave/drm/DRMMetadata;

    iput-wide p1, v0, Lcom/adobe/ave/drm/DRMMetadata;->peerObject:J

    .line 60
    return-void
.end method

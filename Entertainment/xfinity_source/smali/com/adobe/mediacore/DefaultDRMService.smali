.class public final Lcom/adobe/mediacore/DefaultDRMService;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/DRMService;


# static fields
.field public static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private _drmHasTriedToInitialize:Z

.field private _drmInitialized:Z

.field private _drmManager:Lcom/adobe/ave/drm/DRMManager;

.field private _listener:Lcom/adobe/mediacore/DRMService$DRMEventListener;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[PSDK]::"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-class v1, Lcom/adobe/mediacore/DefaultDRMService;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/adobe/mediacore/DefaultDRMService;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-boolean v0, p0, Lcom/adobe/mediacore/DefaultDRMService;->_drmInitialized:Z

    iput-boolean v0, p0, Lcom/adobe/mediacore/DefaultDRMService;->_drmHasTriedToInitialize:Z

    invoke-static {p1}, Lcom/adobe/ave/drm/DRMManager;->getSharedManager(Landroid/content/Context;)Lcom/adobe/ave/drm/DRMManager;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/DefaultDRMService;->_drmManager:Lcom/adobe/ave/drm/DRMManager;

    return-void
.end method

.method static synthetic access$000(Lcom/adobe/mediacore/DefaultDRMService;)Lcom/adobe/mediacore/DRMService$DRMEventListener;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultDRMService;->_listener:Lcom/adobe/mediacore/DRMService$DRMEventListener;

    return-object v0
.end method

.method static synthetic access$102(Lcom/adobe/mediacore/DefaultDRMService;Z)Z
    .locals 0

    iput-boolean p1, p0, Lcom/adobe/mediacore/DefaultDRMService;->_drmInitialized:Z

    return p1
.end method


# virtual methods
.method public getManager()Lcom/adobe/ave/drm/DRMManager;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultDRMService;->_drmManager:Lcom/adobe/ave/drm/DRMManager;

    return-object v0
.end method

.method public hasTriedToInitialize()Z
    .locals 1

    iget-boolean v0, p0, Lcom/adobe/mediacore/DefaultDRMService;->_drmHasTriedToInitialize:Z

    return v0
.end method

.method public initialize()V
    .locals 3

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/adobe/mediacore/DefaultDRMService;->_drmHasTriedToInitialize:Z

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultDRMService;->_drmManager:Lcom/adobe/ave/drm/DRMManager;

    new-instance v1, Lcom/adobe/mediacore/DefaultDRMService$1;

    invoke-direct {v1, p0}, Lcom/adobe/mediacore/DefaultDRMService$1;-><init>(Lcom/adobe/mediacore/DefaultDRMService;)V

    new-instance v2, Lcom/adobe/mediacore/DefaultDRMService$2;

    invoke-direct {v2, p0}, Lcom/adobe/mediacore/DefaultDRMService$2;-><init>(Lcom/adobe/mediacore/DefaultDRMService;)V

    invoke-virtual {v0, v1, v2}, Lcom/adobe/ave/drm/DRMManager;->initialize(Lcom/adobe/ave/drm/DRMOperationErrorCallback;Lcom/adobe/ave/drm/DRMOperationCompleteCallback;)V

    return-void
.end method

.method public isInitialized()Z
    .locals 1

    iget-boolean v0, p0, Lcom/adobe/mediacore/DefaultDRMService;->_drmInitialized:Z

    return v0
.end method

.method public setDRMEventListener(Lcom/adobe/mediacore/DRMService$DRMEventListener;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/DefaultDRMService;->_listener:Lcom/adobe/mediacore/DRMService$DRMEventListener;

    return-void
.end method

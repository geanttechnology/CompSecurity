.class public interface abstract Lcom/adobe/mediacore/DRMService;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/mediacore/DRMService$DRMEventListener;
    }
.end annotation


# virtual methods
.method public abstract getManager()Lcom/adobe/ave/drm/DRMManager;
.end method

.method public abstract hasTriedToInitialize()Z
.end method

.method public abstract initialize()V
.end method

.method public abstract isInitialized()Z
.end method

.method public abstract setDRMEventListener(Lcom/adobe/mediacore/DRMService$DRMEventListener;)V
.end method

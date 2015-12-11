.class final enum Lcom/adobe/ave/drm/DRMAuthenticationMethod$1;
.super Lcom/adobe/ave/drm/DRMAuthenticationMethod;
.source "DRMAuthenticationMethod.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/ave/drm/DRMAuthenticationMethod;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4008
    name = null
.end annotation


# direct methods
.method constructor <init>(Ljava/lang/String;I)V
    .locals 1

    .prologue
    .line 28
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/adobe/ave/drm/DRMAuthenticationMethod;-><init>(Ljava/lang/String;ILcom/adobe/ave/drm/DRMAuthenticationMethod$1;)V

    return-void
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    const-string v0, "USERNAMEANDPASSWORD"

    return-object v0
.end method

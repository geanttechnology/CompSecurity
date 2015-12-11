.class public Lcom/adobe/mediacore/info/ClosedCaptionsTrack;
.super Lcom/adobe/mediacore/info/Track;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/mediacore/info/ClosedCaptionsTrack$DefaultCCTypes;
    }
.end annotation


# instance fields
.field private _isActive:Z

.field private _serviceType:I


# direct methods
.method public constructor <init>(Ljava/lang/String;ILjava/lang/String;ZZ)V
    .locals 0

    invoke-direct {p0, p1, p3, p4}, Lcom/adobe/mediacore/info/Track;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    iput p2, p0, Lcom/adobe/mediacore/info/ClosedCaptionsTrack;->_serviceType:I

    iput-boolean p5, p0, Lcom/adobe/mediacore/info/ClosedCaptionsTrack;->_isActive:Z

    return-void
.end method


# virtual methods
.method public getServiceType()I
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/info/ClosedCaptionsTrack;->_serviceType:I

    return v0
.end method

.method public isActive()Z
    .locals 1

    iget-boolean v0, p0, Lcom/adobe/mediacore/info/ClosedCaptionsTrack;->_isActive:Z

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "ClosedCaptionsTrack { name: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/adobe/mediacore/info/ClosedCaptionsTrack;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " serviceType: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/adobe/mediacore/info/ClosedCaptionsTrack;->getServiceType()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " }"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

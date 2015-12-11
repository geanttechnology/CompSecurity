.class public Lcom/adobe/ave/drm/DRMError;
.super Ljava/lang/Object;
.source "DRMError.java"


# instance fields
.field major:J

.field minor:J

.field serverErrorString:Ljava/lang/String;

.field serverErrorUrl:Ljava/lang/String;


# direct methods
.method protected constructor <init>(JJLjava/lang/String;)V
    .locals 3
    .param p1, "major"    # J
    .param p3, "minor"    # J
    .param p5, "serverErrorString"    # Ljava/lang/String;

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 33
    iput-wide p1, p0, Lcom/adobe/ave/drm/DRMError;->major:J

    .line 34
    iput-wide p3, p0, Lcom/adobe/ave/drm/DRMError;->minor:J

    .line 35
    if-eqz p5, :cond_0

    .line 36
    iput-object p5, p0, Lcom/adobe/ave/drm/DRMError;->serverErrorString:Ljava/lang/String;

    .line 41
    :goto_0
    return-void

    .line 38
    :cond_0
    new-instance v0, Ljava/lang/String;

    const-string v1, ""

    invoke-direct {v0, v1}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/adobe/ave/drm/DRMError;->serverErrorString:Ljava/lang/String;

    goto :goto_0
.end method


# virtual methods
.method public getMajorError()J
    .locals 2

    .prologue
    .line 43
    iget-wide v0, p0, Lcom/adobe/ave/drm/DRMError;->major:J

    return-wide v0
.end method

.method public getMinorError()J
    .locals 2

    .prologue
    .line 45
    iget-wide v0, p0, Lcom/adobe/ave/drm/DRMError;->minor:J

    return-wide v0
.end method

.method public getServerErrorString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/adobe/ave/drm/DRMError;->serverErrorString:Ljava/lang/String;

    return-object v0
.end method

.class public Lcom/auditude/ads/util/AuditudeUtil$WidthTagResult;
.super Ljava/lang/Object;
.source "AuditudeUtil.java"

# interfaces
.implements Lcom/auditude/ads/util/AuditudeUtil$ITagResult;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/auditude/ads/util/AuditudeUtil;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "WidthTagResult"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 198
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getResult()Ljava/lang/String;
    .locals 1

    .prologue
    .line 202
    sget-object v0, Lcom/auditude/ads/util/AuditudeUtil;->AuditudePluginSize:Lcom/auditude/ads/util/Size;

    if-eqz v0, :cond_0

    sget-object v0, Lcom/auditude/ads/util/AuditudeUtil;->AuditudePluginSize:Lcom/auditude/ads/util/Size;

    iget v0, v0, Lcom/auditude/ads/util/Size;->width:I

    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const-string v0, "0"

    goto :goto_0
.end method

.class public Lcom/auditude/ads/util/AuditudeUtil$ContentPlayhead;
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
    name = "ContentPlayhead"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 228
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getResult()Ljava/lang/String;
    .locals 1

    .prologue
    .line 232
    # getter for: Lcom/auditude/ads/util/AuditudeUtil;->contentPlayhead:I
    invoke-static {}, Lcom/auditude/ads/util/AuditudeUtil;->access$0()I

    move-result v0

    if-ltz v0, :cond_0

    .line 234
    # getter for: Lcom/auditude/ads/util/AuditudeUtil;->contentPlayhead:I
    invoke-static {}, Lcom/auditude/ads/util/AuditudeUtil;->access$0()I

    move-result v0

    div-int/lit16 v0, v0, 0x3e8

    int-to-float v0, v0

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v0

    invoke-static {v0}, Lcom/auditude/ads/util/StringUtil;->convertToHHMMSS(I)Ljava/lang/String;

    move-result-object v0

    .line 238
    :goto_0
    return-object v0

    :cond_0
    const-string v0, "[CONTENTPLAYHEAD]"

    goto :goto_0
.end method

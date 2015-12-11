.class Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$NoUnderlineSpan;
.super Landroid/text/style/UnderlineSpan;
.source "SourceFile"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 1461
    invoke-direct {p0}, Landroid/text/style/UnderlineSpan;-><init>()V

    .line 1462
    return-void
.end method


# virtual methods
.method public updateDrawState(Landroid/text/TextPaint;)V
    .locals 1

    .prologue
    .line 1466
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/text/TextPaint;->setUnderlineText(Z)V

    .line 1467
    return-void
.end method

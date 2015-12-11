.class public Lcom/auditude/ads/util/Size;
.super Ljava/lang/Object;
.source "Size.java"


# instance fields
.field public height:I

.field public width:I


# direct methods
.method public constructor <init>(II)V
    .locals 0
    .param p1, "width"    # I
    .param p2, "height"    # I

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 10
    iput p1, p0, Lcom/auditude/ads/util/Size;->width:I

    .line 11
    iput p2, p0, Lcom/auditude/ads/util/Size;->height:I

    .line 12
    return-void
.end method

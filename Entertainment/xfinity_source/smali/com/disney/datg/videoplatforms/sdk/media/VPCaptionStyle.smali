.class public Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle;
.super Ljava/lang/Object;
.source "VPCaptionStyle.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType;,
        Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;
    }
.end annotation


# instance fields
.field private backgroundColor:I

.field private edgeType:I

.field private textColor:I

.field private textSize:I

.field private typeFace:Landroid/graphics/Typeface;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 43
    const/16 v0, 0x64

    invoke-virtual {p0, v0}, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle;->setTextSize(I)V

    .line 44
    const/high16 v0, -0x1000000

    invoke-virtual {p0, v0}, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle;->setBackgroundColor(I)V

    .line 45
    const/4 v0, -0x1

    invoke-virtual {p0, v0}, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle;->setTextColor(I)V

    .line 46
    sget-object v0, Landroid/graphics/Typeface;->MONOSPACE:Landroid/graphics/Typeface;

    invoke-virtual {p0, v0}, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle;->setTypeFace(Landroid/graphics/Typeface;)V

    .line 47
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType;->EDGE_TYPE_NONE:Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType;

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType;->ordinal()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle;->setEdgeType(I)V

    .line 48
    return-void
.end method


# virtual methods
.method public getBackgroundColor()I
    .locals 1

    .prologue
    .line 92
    iget v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle;->backgroundColor:I

    return v0
.end method

.method public getEdgeType()I
    .locals 1

    .prologue
    .line 84
    iget v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle;->edgeType:I

    return v0
.end method

.method public getTextColor()I
    .locals 1

    .prologue
    .line 51
    iget v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle;->textColor:I

    return v0
.end method

.method public getTextSize()I
    .locals 1

    .prologue
    .line 59
    iget v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle;->textSize:I

    return v0
.end method

.method public getTypeFace()Landroid/graphics/Typeface;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle;->typeFace:Landroid/graphics/Typeface;

    return-object v0
.end method

.method public setBackgroundColor(I)V
    .locals 0
    .param p1, "backgroundColor"    # I

    .prologue
    .line 96
    iput p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle;->backgroundColor:I

    .line 97
    return-void
.end method

.method public setEdgeType(I)V
    .locals 0
    .param p1, "edgeType"    # I

    .prologue
    .line 88
    iput p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle;->edgeType:I

    .line 89
    return-void
.end method

.method public setTextColor(I)V
    .locals 0
    .param p1, "textColor"    # I

    .prologue
    .line 55
    iput p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle;->textColor:I

    .line 56
    return-void
.end method

.method public setTextSize(I)V
    .locals 1
    .param p1, "textSize"    # I

    .prologue
    .line 63
    const/16 v0, 0x32

    if-lt p1, v0, :cond_0

    const/16 v0, 0xc8

    if-le p1, v0, :cond_1

    .line 65
    :cond_0
    :goto_0
    return-void

    .line 64
    :cond_1
    iput p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle;->textSize:I

    goto :goto_0
.end method

.method public setTypeFace(Landroid/graphics/Typeface;)V
    .locals 0
    .param p1, "typeFace"    # Landroid/graphics/Typeface;

    .prologue
    .line 80
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle;->typeFace:Landroid/graphics/Typeface;

    .line 81
    return-void
.end method

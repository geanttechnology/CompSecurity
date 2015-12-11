.class public Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;
.super Ljava/lang/Object;
.source "ClosedCaptionsFormat.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;,
        Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;,
        Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;,
        Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;
    }
.end annotation


# instance fields
.field private backgroundColor:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

.field private backgroundOpacity:I

.field private edgeColor:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

.field private fillColor:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

.field private fillOpacity:I

.field private font:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

.field private fontColor:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

.field private fontEdge:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

.field private fontOpacity:I

.field private fontSize:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, -0x1

    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->DEFAULT:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->fontColor:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    .line 14
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->DEFAULT:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->backgroundColor:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    .line 15
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->DEFAULT:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->fillColor:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    .line 16
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->DEFAULT:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->edgeColor:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    .line 17
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;->DEFAULT:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->fontSize:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

    .line 18
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;->DEFAULT:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->fontEdge:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    .line 19
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;->DEFAULT:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->font:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    .line 20
    iput v1, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->fontOpacity:I

    .line 21
    iput v1, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->backgroundOpacity:I

    .line 22
    iput v1, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->fillOpacity:I

    .line 142
    return-void
.end method


# virtual methods
.method public getBackgroundColor()Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->backgroundColor:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    return-object v0
.end method

.method public getBackgroundOpacity()I
    .locals 1

    .prologue
    .line 91
    iget v0, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->backgroundOpacity:I

    return v0
.end method

.method public getEdgeColor()Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->edgeColor:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    return-object v0
.end method

.method public getFillColor()Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->fillColor:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    return-object v0
.end method

.method public getFillOpacity()I
    .locals 1

    .prologue
    .line 99
    iget v0, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->fillOpacity:I

    return v0
.end method

.method public getFont()Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->font:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    return-object v0
.end method

.method public getFontColor()Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->fontColor:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    return-object v0
.end method

.method public getFontEdge()Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->fontEdge:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    return-object v0
.end method

.method public getFontOpacity()I
    .locals 1

    .prologue
    .line 83
    iget v0, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->fontOpacity:I

    return v0
.end method

.method public getFontSize()Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->fontSize:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

    return-object v0
.end method

.method public setBackgroundColor(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;)V
    .locals 0
    .param p1, "backgroundColor"    # Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    .prologue
    .line 39
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->backgroundColor:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    .line 40
    return-void
.end method

.method public setBackgroundOpacity(I)V
    .locals 0
    .param p1, "backgroundOpacity"    # I

    .prologue
    .line 95
    iput p1, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->backgroundOpacity:I

    .line 96
    return-void
.end method

.method public setEdgeColor(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;)V
    .locals 0
    .param p1, "edgeColor"    # Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    .prologue
    .line 55
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->edgeColor:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    .line 56
    return-void
.end method

.method public setFillColor(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;)V
    .locals 0
    .param p1, "fillColor"    # Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    .prologue
    .line 47
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->fillColor:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    .line 48
    return-void
.end method

.method public setFillOpacity(I)V
    .locals 0
    .param p1, "fillOpacity"    # I

    .prologue
    .line 103
    iput p1, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->fillOpacity:I

    .line 104
    return-void
.end method

.method public setFont(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;)V
    .locals 0
    .param p1, "font"    # Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    .prologue
    .line 79
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->font:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    .line 80
    return-void
.end method

.method public setFontColor(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;)V
    .locals 0
    .param p1, "fontColor"    # Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    .prologue
    .line 31
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->fontColor:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    .line 32
    return-void
.end method

.method public setFontEdge(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;)V
    .locals 0
    .param p1, "fontEdge"    # Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    .prologue
    .line 71
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->fontEdge:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    .line 72
    return-void
.end method

.method public setFontOpacity(I)V
    .locals 0
    .param p1, "fontOpacity"    # I

    .prologue
    .line 87
    iput p1, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->fontOpacity:I

    .line 88
    return-void
.end method

.method public setFontSize(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;)V
    .locals 0
    .param p1, "fontSize"    # Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

    .prologue
    .line 63
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->fontSize:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

    .line 64
    return-void
.end method

.class public Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;
.super Ljava/lang/Object;
.source "ClosedCaptionFormatBuilder.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder$1;
    }
.end annotation


# instance fields
.field private closedCaptionsFormat:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;

    invoke-direct {v0}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;-><init>()V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->closedCaptionsFormat:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;

    .line 23
    return-void
.end method

.method private getColorForDisney(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;)I
    .locals 4
    .param p1, "textFormatColor"    # Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    .prologue
    .line 144
    if-eqz p1, :cond_2

    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->name()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    .line 146
    .local v1, "colorName":Ljava/lang/String;
    :goto_0
    const/4 v0, -0x1

    .line 148
    .local v0, "color":I
    const-string v2, "bright"

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 149
    const-string v2, "bright_"

    const-string v3, ""

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    .line 152
    :cond_0
    const-string v2, "dark"

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 153
    const-string v2, "dark_"

    const-string v3, ""

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    .line 157
    :cond_1
    :try_start_0
    invoke-static {v1}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    .line 162
    :goto_1
    return v0

    .line 144
    .end local v0    # "color":I
    .end local v1    # "colorName":Ljava/lang/String;
    :cond_2
    sget-object v2, Lcom/adobe/mediacore/TextFormat$Color;->DEFAULT:Lcom/adobe/mediacore/TextFormat$Color;

    invoke-virtual {v2}, Lcom/adobe/mediacore/TextFormat$Color;->name()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 158
    .restart local v0    # "color":I
    .restart local v1    # "colorName":Ljava/lang/String;
    :catch_0
    move-exception v2

    goto :goto_1
.end method

.method private getDisneySize()I
    .locals 3

    .prologue
    .line 126
    const/16 v0, 0x64

    .line 127
    .local v0, "size":I
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->closedCaptionsFormat:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->getFontSize()Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 128
    sget-object v1, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder$1;->$SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Size:[I

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->closedCaptionsFormat:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;

    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->getFontSize()Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

    move-result-object v2

    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 140
    :cond_0
    :goto_0
    return v0

    .line 130
    :pswitch_0
    const/16 v0, 0x4b

    .line 131
    goto :goto_0

    .line 133
    :pswitch_1
    const/16 v0, 0x96

    .line 134
    goto :goto_0

    .line 128
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method private getEdgeForDisney()Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType;
    .locals 3

    .prologue
    .line 166
    const/4 v0, 0x0

    .line 170
    .local v0, "edgeType":Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType;
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->closedCaptionsFormat:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->getFontEdge()Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 171
    sget-object v1, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder$1;->$SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$FontEdge:[I

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->closedCaptionsFormat:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;

    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->getFontEdge()Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    move-result-object v2

    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 181
    :cond_0
    :goto_0
    return-object v0

    .line 174
    :pswitch_0
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType;->EDGE_TYPE_DROP_SHADOW:Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType;

    .line 175
    goto :goto_0

    .line 171
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method

.method private getTypefaceForDisney()Landroid/graphics/Typeface;
    .locals 3

    .prologue
    .line 185
    const/4 v0, 0x0

    .line 186
    .local v0, "disneyFont":Landroid/graphics/Typeface;
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->closedCaptionsFormat:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->getFont()Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 187
    sget-object v1, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder$1;->$SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Font:[I

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->closedCaptionsFormat:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;

    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->getFont()Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    move-result-object v2

    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 203
    :cond_0
    :goto_0
    return-object v0

    .line 190
    :pswitch_0
    sget-object v0, Landroid/graphics/Typeface;->MONOSPACE:Landroid/graphics/Typeface;

    .line 191
    goto :goto_0

    .line 193
    :pswitch_1
    sget-object v0, Landroid/graphics/Typeface;->SANS_SERIF:Landroid/graphics/Typeface;

    .line 194
    goto :goto_0

    .line 196
    :pswitch_2
    sget-object v0, Landroid/graphics/Typeface;->SERIF:Landroid/graphics/Typeface;

    .line 197
    goto :goto_0

    .line 187
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method


# virtual methods
.method public setBackgroundColor(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;
    .locals 1
    .param p1, "color"    # Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    .prologue
    .line 43
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->closedCaptionsFormat:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->setBackgroundColor(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;)V

    .line 44
    return-object p0
.end method

.method public setBackgroundOpacity(I)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;
    .locals 1
    .param p1, "opacity"    # I

    .prologue
    .line 68
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->closedCaptionsFormat:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->setBackgroundOpacity(I)V

    .line 69
    return-object p0
.end method

.method public setEdgeColor(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;
    .locals 1
    .param p1, "color"    # Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->closedCaptionsFormat:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->setEdgeColor(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;)V

    .line 49
    return-object p0
.end method

.method public setFont(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;
    .locals 1
    .param p1, "font"    # Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->closedCaptionsFormat:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->setFont(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;)V

    .line 39
    return-object p0
.end method

.method public setFontColor(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;
    .locals 1
    .param p1, "color"    # Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    .prologue
    .line 73
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->closedCaptionsFormat:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->setFontColor(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;)V

    .line 74
    return-object p0
.end method

.method public setFontEdge(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;
    .locals 1
    .param p1, "fontEdge"    # Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    .prologue
    .line 58
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->closedCaptionsFormat:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->setFontEdge(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;)V

    .line 59
    return-object p0
.end method

.method public setSize(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;
    .locals 1
    .param p1, "size"    # Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

    .prologue
    .line 53
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->closedCaptionsFormat:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->setFontSize(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;)V

    .line 54
    return-object p0
.end method

.method public toTextFormat()Lcom/adobe/mediacore/TextFormat;
    .locals 2

    .prologue
    .line 78
    new-instance v0, Lcom/adobe/mediacore/TextFormatBuilder;

    invoke-direct {v0}, Lcom/adobe/mediacore/TextFormatBuilder;-><init>()V

    .line 79
    .local v0, "textFormatBuilder":Lcom/adobe/mediacore/TextFormatBuilder;
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->closedCaptionsFormat:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->getFont()Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    move-result-object v1

    if-nez v1, :cond_0

    sget-object v1, Lcom/adobe/mediacore/TextFormat$Font;->DEFAULT:Lcom/adobe/mediacore/TextFormat$Font;

    :goto_0
    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/TextFormatBuilder;->setFont(Lcom/adobe/mediacore/TextFormat$Font;)Lcom/adobe/mediacore/TextFormatBuilder;

    .line 80
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->closedCaptionsFormat:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->getFontSize()Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

    move-result-object v1

    if-nez v1, :cond_1

    sget-object v1, Lcom/adobe/mediacore/TextFormat$Size;->DEFAULT:Lcom/adobe/mediacore/TextFormat$Size;

    :goto_1
    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/TextFormatBuilder;->setSize(Lcom/adobe/mediacore/TextFormat$Size;)Lcom/adobe/mediacore/TextFormatBuilder;

    .line 81
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->closedCaptionsFormat:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->getFontEdge()Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    move-result-object v1

    if-nez v1, :cond_2

    sget-object v1, Lcom/adobe/mediacore/TextFormat$FontEdge;->DEFAULT:Lcom/adobe/mediacore/TextFormat$FontEdge;

    :goto_2
    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/TextFormatBuilder;->setFontEdge(Lcom/adobe/mediacore/TextFormat$FontEdge;)Lcom/adobe/mediacore/TextFormatBuilder;

    .line 82
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->closedCaptionsFormat:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->getFontColor()Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    move-result-object v1

    if-nez v1, :cond_3

    sget-object v1, Lcom/adobe/mediacore/TextFormat$Color;->DEFAULT:Lcom/adobe/mediacore/TextFormat$Color;

    :goto_3
    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/TextFormatBuilder;->setFontColor(Lcom/adobe/mediacore/TextFormat$Color;)Lcom/adobe/mediacore/TextFormatBuilder;

    .line 83
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->closedCaptionsFormat:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->getBackgroundColor()Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    move-result-object v1

    if-nez v1, :cond_4

    sget-object v1, Lcom/adobe/mediacore/TextFormat$Color;->DEFAULT:Lcom/adobe/mediacore/TextFormat$Color;

    :goto_4
    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/TextFormatBuilder;->setBackgroundColor(Lcom/adobe/mediacore/TextFormat$Color;)Lcom/adobe/mediacore/TextFormatBuilder;

    .line 84
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->closedCaptionsFormat:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->getFillColor()Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    move-result-object v1

    if-nez v1, :cond_5

    sget-object v1, Lcom/adobe/mediacore/TextFormat$Color;->DEFAULT:Lcom/adobe/mediacore/TextFormat$Color;

    :goto_5
    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/TextFormatBuilder;->setFillColor(Lcom/adobe/mediacore/TextFormat$Color;)Lcom/adobe/mediacore/TextFormatBuilder;

    .line 85
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->closedCaptionsFormat:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->getEdgeColor()Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    move-result-object v1

    if-nez v1, :cond_6

    const/4 v1, 0x0

    :goto_6
    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/TextFormatBuilder;->setEdgeColor(Lcom/adobe/mediacore/TextFormat$Color;)Lcom/adobe/mediacore/TextFormatBuilder;

    .line 86
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->closedCaptionsFormat:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->getFontOpacity()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/TextFormatBuilder;->setFontOpacity(I)Lcom/adobe/mediacore/TextFormatBuilder;

    .line 87
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->closedCaptionsFormat:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->getBackgroundOpacity()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/TextFormatBuilder;->setBackgroundOpacity(I)Lcom/adobe/mediacore/TextFormatBuilder;

    .line 88
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->closedCaptionsFormat:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->getFillOpacity()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/TextFormatBuilder;->setFillOpacity(I)Lcom/adobe/mediacore/TextFormatBuilder;

    .line 90
    invoke-virtual {v0}, Lcom/adobe/mediacore/TextFormatBuilder;->toTextFormat()Lcom/adobe/mediacore/TextFormat;

    move-result-object v1

    return-object v1

    .line 79
    :cond_0
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->closedCaptionsFormat:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->getFont()Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;->textFormatValue()Lcom/adobe/mediacore/TextFormat$Font;

    move-result-object v1

    goto :goto_0

    .line 80
    :cond_1
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->closedCaptionsFormat:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->getFontSize()Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;->textFormatValue()Lcom/adobe/mediacore/TextFormat$Size;

    move-result-object v1

    goto :goto_1

    .line 81
    :cond_2
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->closedCaptionsFormat:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->getFontEdge()Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;->textFormatValue()Lcom/adobe/mediacore/TextFormat$FontEdge;

    move-result-object v1

    goto :goto_2

    .line 82
    :cond_3
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->closedCaptionsFormat:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->getFontColor()Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->textFormatValue()Lcom/adobe/mediacore/TextFormat$Color;

    move-result-object v1

    goto :goto_3

    .line 83
    :cond_4
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->closedCaptionsFormat:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->getBackgroundColor()Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->textFormatValue()Lcom/adobe/mediacore/TextFormat$Color;

    move-result-object v1

    goto :goto_4

    .line 84
    :cond_5
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->closedCaptionsFormat:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->getFillColor()Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->textFormatValue()Lcom/adobe/mediacore/TextFormat$Color;

    move-result-object v1

    goto :goto_5

    .line 85
    :cond_6
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->closedCaptionsFormat:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->getEdgeColor()Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->textFormatValue()Lcom/adobe/mediacore/TextFormat$Color;

    move-result-object v1

    goto :goto_6
.end method

.method public toVPCaptionStyle()Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle;
    .locals 8

    .prologue
    const/4 v7, -0x1

    .line 94
    new-instance v5, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle;

    invoke-direct {v5}, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle;-><init>()V

    .line 96
    .local v5, "vpCaptionStyle":Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle;
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->getDisneySize()I

    move-result v3

    .line 97
    .local v3, "textSize":I
    invoke-virtual {v5, v3}, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle;->setTextSize(I)V

    .line 99
    iget-object v6, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->closedCaptionsFormat:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;

    invoke-virtual {v6}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->getBackgroundColor()Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    move-result-object v6

    invoke-direct {p0, v6}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->getColorForDisney(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;)I

    move-result v0

    .line 100
    .local v0, "backgroundColor":I
    if-eq v0, v7, :cond_0

    .line 101
    invoke-virtual {v5, v0}, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle;->setBackgroundColor(I)V

    .line 104
    :cond_0
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->getEdgeForDisney()Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType;

    move-result-object v1

    .line 105
    .local v1, "edge":Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType;
    if-eqz v1, :cond_1

    .line 106
    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType;->ordinal()I

    move-result v6

    invoke-virtual {v5, v6}, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle;->setEdgeType(I)V

    .line 109
    :cond_1
    iget-object v6, p0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->closedCaptionsFormat:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;

    invoke-virtual {v6}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat;->getFontColor()Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    move-result-object v6

    invoke-direct {p0, v6}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->getColorForDisney(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;)I

    move-result v2

    .line 110
    .local v2, "textColor":I
    if-eq v2, v7, :cond_2

    .line 111
    invoke-virtual {v5, v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle;->setTextColor(I)V

    .line 114
    :cond_2
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->getTypefaceForDisney()Landroid/graphics/Typeface;

    move-result-object v4

    .line 115
    .local v4, "typeface":Landroid/graphics/Typeface;
    if-eqz v4, :cond_3

    .line 116
    invoke-virtual {v5, v4}, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle;->setTypeFace(Landroid/graphics/Typeface;)V

    .line 119
    :cond_3
    return-object v5
.end method

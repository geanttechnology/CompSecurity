.class public Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;
.super Landroid/preference/Preference;
.source "CCPreviewPreference.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$1;,
        Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;
    }
.end annotation


# instance fields
.field private ccPrefStore:Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;

.field private previewText:Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 26
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 27
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 22
    invoke-direct {p0, p1, p2, p3}, Landroid/preference/Preference;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 23
    return-void
.end method

.method public static convertColor(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;Ljava/lang/String;)I
    .locals 3
    .param p0, "color"    # Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;
    .param p1, "alpha"    # Ljava/lang/String;

    .prologue
    .line 97
    new-instance v0, Ljava/lang/StringBuilder;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "#"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 98
    .local v0, "colorBuilder":Ljava/lang/StringBuilder;
    sget-object v1, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$1;->$SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Color:[I

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 167
    const-string v1, "000000"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 171
    :goto_0
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v1

    return v1

    .line 101
    :pswitch_0
    const-string v1, "000000"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 104
    :pswitch_1
    const-string v1, "808080"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 107
    :pswitch_2
    const-string v1, "c0c0c0"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 110
    :pswitch_3
    const-string v1, "ffffff"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 113
    :pswitch_4
    const-string v1, "400000"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 116
    :pswitch_5
    const-string v1, "c00000"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 119
    :pswitch_6
    const-string v1, "ff0000"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 122
    :pswitch_7
    const-string v1, "004000"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 125
    :pswitch_8
    const-string v1, "00c000"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 128
    :pswitch_9
    const-string v1, "00ff00"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 131
    :pswitch_a
    const-string v1, "000040"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 134
    :pswitch_b
    const-string v1, "0000c0"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 137
    :pswitch_c
    const-string v1, "0000ff"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 140
    :pswitch_d
    const-string v1, "404000"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 143
    :pswitch_e
    const-string v1, "c0c000"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 146
    :pswitch_f
    const-string v1, "ffff00"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 149
    :pswitch_10
    const-string v1, "400040"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 152
    :pswitch_11
    const-string v1, "c000c0"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 155
    :pswitch_12
    const-string v1, "ff00ff"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 158
    :pswitch_13
    const-string v1, "004040"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 161
    :pswitch_14
    const-string v1, "00c0c0"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto/16 :goto_0

    .line 164
    :pswitch_15
    const-string v1, "00ffff"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto/16 :goto_0

    .line 98
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_9
        :pswitch_a
        :pswitch_b
        :pswitch_c
        :pswitch_d
        :pswitch_e
        :pswitch_f
        :pswitch_10
        :pswitch_11
        :pswitch_12
        :pswitch_13
        :pswitch_14
        :pswitch_15
    .end packed-switch
.end method


# virtual methods
.method convertBackgroundColor(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;Ljava/lang/String;)I
    .locals 1
    .param p1, "color"    # Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;
    .param p2, "alpha"    # Ljava/lang/String;

    .prologue
    .line 81
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->DEFAULT:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    if-ne p1, v0, :cond_0

    .line 82
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->BLACK:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    invoke-static {v0, p2}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;->convertColor(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;Ljava/lang/String;)I

    move-result v0

    .line 84
    :goto_0
    return v0

    :cond_0
    invoke-static {p1, p2}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;->convertColor(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;Ljava/lang/String;)I

    move-result v0

    goto :goto_0
.end method

.method convertEdgeColor(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;Ljava/lang/String;)I
    .locals 1
    .param p1, "color"    # Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;
    .param p2, "alpha"    # Ljava/lang/String;

    .prologue
    .line 89
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->DEFAULT:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    if-ne p1, v0, :cond_0

    .line 90
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->GRAY:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    invoke-static {v0, p2}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;->convertColor(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;Ljava/lang/String;)I

    move-result v0

    .line 92
    :goto_0
    return v0

    :cond_0
    invoke-static {p1, p2}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;->convertColor(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;Ljava/lang/String;)I

    move-result v0

    goto :goto_0
.end method

.method convertFont(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;)Landroid/graphics/Typeface;
    .locals 2
    .param p1, "font"    # Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    .prologue
    .line 175
    sget-object v0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$1;->$SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Font:[I

    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 183
    sget-object v0, Landroid/graphics/Typeface;->DEFAULT:Landroid/graphics/Typeface;

    :goto_0
    return-object v0

    .line 177
    :pswitch_0
    sget-object v0, Landroid/graphics/Typeface;->SERIF:Landroid/graphics/Typeface;

    goto :goto_0

    .line 179
    :pswitch_1
    sget-object v0, Landroid/graphics/Typeface;->SANS_SERIF:Landroid/graphics/Typeface;

    goto :goto_0

    .line 181
    :pswitch_2
    sget-object v0, Landroid/graphics/Typeface;->MONOSPACE:Landroid/graphics/Typeface;

    goto :goto_0

    .line 175
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method convertTextColor(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;Ljava/lang/String;)I
    .locals 1
    .param p1, "color"    # Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;
    .param p2, "alpha"    # Ljava/lang/String;

    .prologue
    .line 73
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->DEFAULT:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    if-ne p1, v0, :cond_0

    .line 74
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->WHITE:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    invoke-static {v0, p2}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;->convertColor(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;Ljava/lang/String;)I

    move-result v0

    .line 76
    :goto_0
    return v0

    :cond_0
    invoke-static {p1, p2}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;->convertColor(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;Ljava/lang/String;)I

    move-result v0

    goto :goto_0
.end method

.method getTextSize(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;)F
    .locals 2
    .param p1, "size"    # Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

    .prologue
    .line 61
    sget-object v0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$1;->$SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Size:[I

    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 68
    const/high16 v0, 0x41c00000    # 24.0f

    :goto_0
    return v0

    .line 63
    :pswitch_0
    const/high16 v0, 0x41400000    # 12.0f

    goto :goto_0

    .line 65
    :pswitch_1
    const/high16 v0, 0x42100000    # 36.0f

    goto :goto_0

    .line 61
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method protected onCreateView(Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 4
    .param p1, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 31
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;->getContext()Landroid/content/Context;

    move-result-object v2

    const-string v3, "layout_inflater"

    invoke-virtual {v2, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    .line 32
    .local v0, "inflater":Landroid/view/LayoutInflater;
    sget v2, Lcom/comcast/cim/cmasl/android708compatlib/R$layout;->cc_preview:I

    const/4 v3, 0x0

    invoke-virtual {v0, v2, p1, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    .line 34
    .local v1, "layout":Landroid/widget/LinearLayout;
    sget v2, Lcom/comcast/cim/cmasl/android708compatlib/R$id;->preview_text:I

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;

    iput-object v2, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;->previewText:Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;

    .line 35
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;->updatePreviewText()V

    .line 36
    return-object v1
.end method

.method public setCcPrefStore(Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;)V
    .locals 0
    .param p1, "store"    # Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;

    .prologue
    .line 40
    iput-object p1, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;->ccPrefStore:Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;

    .line 41
    return-void
.end method

.method public updatePreviewText()V
    .locals 9

    .prologue
    .line 44
    iget-object v7, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;->ccPrefStore:Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;

    invoke-interface {v7}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;->getCCEdgeType()I

    move-result v7

    invoke-static {v7}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;->valueOfOrdinal(I)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    move-result-object v4

    .line 45
    .local v4, "fontEdge":Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;
    iget-object v7, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;->ccPrefStore:Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;

    invoke-interface {v7}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;->getCCTextSize()I

    move-result v7

    invoke-static {v7}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;->valueOfOrdinal(I)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

    move-result-object v5

    .line 46
    .local v5, "size":Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;
    iget-object v7, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;->ccPrefStore:Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;

    invoke-interface {v7}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;->getCCTextColor()I

    move-result v7

    invoke-static {v7}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->valueOfOrdinal(I)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    move-result-object v6

    .line 47
    .local v6, "textColor":Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;
    iget-object v7, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;->ccPrefStore:Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;

    invoke-interface {v7}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;->getCCEdgeColor()I

    move-result v7

    invoke-static {v7}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->valueOfOrdinal(I)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    move-result-object v2

    .line 48
    .local v2, "edgeColor":Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;
    iget-object v7, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;->ccPrefStore:Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;

    invoke-interface {v7}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;->getCCBackgroundColor()I

    move-result v7

    invoke-static {v7}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->valueOfOrdinal(I)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    move-result-object v1

    .line 49
    .local v1, "backgroundColor":Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;
    iget-object v7, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;->ccPrefStore:Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;

    invoke-interface {v7}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;->getCCFontFamily()I

    move-result v7

    invoke-static {v7}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;->valueOfOrdinal(I)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    move-result-object v3

    .line 51
    .local v3, "font":Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;
    iget-object v7, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;->ccPrefStore:Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;

    invoke-interface {v7}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;->getCCBackgroundOpacity()I

    move-result v7

    int-to-float v7, v7

    const/high16 v8, 0x42c80000    # 100.0f

    div-float/2addr v7, v8

    const/high16 v8, 0x437f0000    # 255.0f

    mul-float/2addr v7, v8

    float-to-int v7, v7

    invoke-static {v7}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v0

    .line 53
    .local v0, "backgroundAlpha":Ljava/lang/String;
    iget-object v7, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;->previewText:Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;

    invoke-virtual {p0, v5}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;->getTextSize(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;)F

    move-result v8

    invoke-virtual {v7, v8}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;->setTextSize(F)V

    .line 54
    iget-object v7, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;->previewText:Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;

    const-string v8, "ff"

    invoke-virtual {p0, v6, v8}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;->convertTextColor(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;Ljava/lang/String;)I

    move-result v8

    invoke-virtual {v7, v8}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;->setTextColor(I)V

    .line 55
    iget-object v7, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;->previewText:Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;

    const-string v8, "ff"

    invoke-virtual {p0, v2, v8}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;->convertEdgeColor(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;Ljava/lang/String;)I

    move-result v8

    invoke-virtual {v7, v4, v8}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;->setEdge(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;I)V

    .line 56
    iget-object v7, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;->previewText:Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;

    invoke-virtual {p0, v3}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;->convertFont(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;)Landroid/graphics/Typeface;

    move-result-object v8

    invoke-virtual {v7, v8}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 57
    iget-object v7, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;->previewText:Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;

    invoke-virtual {p0, v1, v0}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;->convertBackgroundColor(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;Ljava/lang/String;)I

    move-result v8

    invoke-virtual {v7, v8}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;->setBackgroundColor(I)V

    .line 58
    return-void
.end method

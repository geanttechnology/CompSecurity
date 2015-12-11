.class synthetic Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder$1;
.super Ljava/lang/Object;
.source "ClosedCaptionFormatBuilder.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1008
    name = null
.end annotation


# static fields
.field static final synthetic $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Font:[I

.field static final synthetic $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$FontEdge:[I

.field static final synthetic $SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Size:[I


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 187
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;->values()[Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder$1;->$SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Font:[I

    :try_start_0
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder$1;->$SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Font:[I

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;->MONSPACED_WITHOUT_SERIFS:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_7

    :goto_0
    :try_start_1
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder$1;->$SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Font:[I

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;->MONOSPACED_WITH_SERIFS:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_6

    :goto_1
    :try_start_2
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder$1;->$SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Font:[I

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;->PROPORTIONAL_WITHOUT_SERIFS:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;->ordinal()I

    move-result v1

    const/4 v2, 0x3

    aput v2, v0, v1
    :try_end_2
    .catch Ljava/lang/NoSuchFieldError; {:try_start_2 .. :try_end_2} :catch_5

    :goto_2
    :try_start_3
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder$1;->$SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Font:[I

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;->PROPORTIONAL_WITH_SERIFS:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;->ordinal()I

    move-result v1

    const/4 v2, 0x4

    aput v2, v0, v1
    :try_end_3
    .catch Ljava/lang/NoSuchFieldError; {:try_start_3 .. :try_end_3} :catch_4

    .line 171
    :goto_3
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;->values()[Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder$1;->$SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$FontEdge:[I

    :try_start_4
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder$1;->$SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$FontEdge:[I

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;->DROP_SHADOW_RIGHT:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_4
    .catch Ljava/lang/NoSuchFieldError; {:try_start_4 .. :try_end_4} :catch_3

    :goto_4
    :try_start_5
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder$1;->$SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$FontEdge:[I

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;->DROP_SHADOW_LEFT:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_5
    .catch Ljava/lang/NoSuchFieldError; {:try_start_5 .. :try_end_5} :catch_2

    .line 128
    :goto_5
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;->values()[Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder$1;->$SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Size:[I

    :try_start_6
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder$1;->$SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Size:[I

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;->SMALL:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_6
    .catch Ljava/lang/NoSuchFieldError; {:try_start_6 .. :try_end_6} :catch_1

    :goto_6
    :try_start_7
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder$1;->$SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$Size:[I

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;->LARGE:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_7
    .catch Ljava/lang/NoSuchFieldError; {:try_start_7 .. :try_end_7} :catch_0

    :goto_7
    return-void

    :catch_0
    move-exception v0

    goto :goto_7

    :catch_1
    move-exception v0

    goto :goto_6

    .line 171
    :catch_2
    move-exception v0

    goto :goto_5

    :catch_3
    move-exception v0

    goto :goto_4

    .line 187
    :catch_4
    move-exception v0

    goto :goto_3

    :catch_5
    move-exception v0

    goto :goto_2

    :catch_6
    move-exception v0

    goto :goto_1

    :catch_7
    move-exception v0

    goto :goto_0
.end method

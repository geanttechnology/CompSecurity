.class public Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;
.super Ljava/lang/Object;
.source "CaptionData.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$1;,
        Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;,
        Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;
    }
.end annotation


# instance fields
.field private channel:I

.field private cues:Ljava/util/Vector;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Vector",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;",
            ">;"
        }
    .end annotation
.end field

.field private eventType:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;

.field private mode:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0}, Ljava/util/Vector;-><init>()V

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;->cues:Ljava/util/Vector;

    .line 18
    const/4 v0, 0x0

    iput v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;->channel:I

    return-void
.end method


# virtual methods
.method protected addCue(Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;)V
    .locals 1
    .param p1, "cue"    # Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;

    .prologue
    .line 85
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;->cues:Ljava/util/Vector;

    invoke-virtual {v0, p1}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    .line 86
    return-void
.end method

.method public getWebVTT()Ljava/lang/String;
    .locals 4

    .prologue
    .line 26
    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    .line 27
    .local v2, "output":Ljava/lang/StringBuffer;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;->cues:Ljava/util/Vector;

    invoke-virtual {v3}, Ljava/util/Vector;->size()I

    move-result v3

    if-ge v1, v3, :cond_2

    .line 29
    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;->cues:Ljava/util/Vector;

    invoke-virtual {v3, v1}, Ljava/util/Vector;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;

    .line 30
    .local v0, "cue":Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;
    if-eqz v0, :cond_1

    .line 32
    if-nez v1, :cond_0

    .line 33
    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;->getHeader()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 34
    :cond_0
    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;->getWebVTT()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 27
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 37
    .end local v0    # "cue":Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;
    :cond_2
    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3
.end method

.method protected setEventType(Lcom/uplynk/media/CaptionEvent$CaptionEventType;)V
    .locals 2
    .param p1, "eventType"    # Lcom/uplynk/media/CaptionEvent$CaptionEventType;

    .prologue
    .line 66
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$1;->$SwitchMap$com$uplynk$media$CaptionEvent$CaptionEventType:[I

    invoke-virtual {p1}, Lcom/uplynk/media/CaptionEvent$CaptionEventType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 78
    :goto_0
    return-void

    .line 69
    :pswitch_0
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;->LINEBREAK:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;->eventType:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;

    goto :goto_0

    .line 72
    :pswitch_1
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;->TEXT:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;->eventType:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;

    goto :goto_0

    .line 75
    :pswitch_2
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;->CLEAR:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;->eventType:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;

    goto :goto_0

    .line 66
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method protected setMode(Lcom/uplynk/media/CaptionEvent$CaptionMode;)V
    .locals 2
    .param p1, "mode"    # Lcom/uplynk/media/CaptionEvent$CaptionMode;

    .prologue
    .line 41
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$1;->$SwitchMap$com$uplynk$media$CaptionEvent$CaptionMode:[I

    invoke-virtual {p1}, Lcom/uplynk/media/CaptionEvent$CaptionMode;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 59
    :goto_0
    return-void

    .line 44
    :pswitch_0
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;->UNKNOWN:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;->mode:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;

    goto :goto_0

    .line 47
    :pswitch_1
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;->POP_ON:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;->mode:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;

    goto :goto_0

    .line 50
    :pswitch_2
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;->ROLL_UP:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;->mode:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;

    goto :goto_0

    .line 53
    :pswitch_3
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;->PAINT_ON:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;->mode:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;

    goto :goto_0

    .line 56
    :pswitch_4
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;->TEXT:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;->mode:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;

    goto :goto_0

    .line 41
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method

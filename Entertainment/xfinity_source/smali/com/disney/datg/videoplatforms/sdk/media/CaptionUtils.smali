.class public Lcom/disney/datg/videoplatforms/sdk/media/CaptionUtils;
.super Ljava/lang/Object;
.source "CaptionUtils.java"


# direct methods
.method public static parseEvent(Lcom/uplynk/media/CaptionEvent;Ljava/lang/String;Ljava/lang/String;)Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;
    .locals 14
    .param p0, "event"    # Lcom/uplynk/media/CaptionEvent;
    .param p1, "startTimestamp"    # Ljava/lang/String;
    .param p2, "endTimestamp"    # Ljava/lang/String;

    .prologue
    .line 17
    new-instance v9, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;

    invoke-direct {v9}, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;-><init>()V

    .line 18
    .local v9, "captionData":Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;
    iget-object v2, p0, Lcom/uplynk/media/CaptionEvent;->eventType:Lcom/uplynk/media/CaptionEvent$CaptionEventType;

    invoke-virtual {v9, v2}, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;->setEventType(Lcom/uplynk/media/CaptionEvent$CaptionEventType;)V

    .line 19
    iget-object v2, p0, Lcom/uplynk/media/CaptionEvent;->mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    invoke-virtual {v9, v2}, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;->setMode(Lcom/uplynk/media/CaptionEvent$CaptionMode;)V

    .line 22
    iget-object v2, p0, Lcom/uplynk/media/CaptionEvent;->mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v3, Lcom/uplynk/media/CaptionEvent$CaptionMode;->POP_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-ne v2, v3, :cond_0

    .line 25
    iget-object v13, p0, Lcom/uplynk/media/CaptionEvent;->rows:Landroid/util/SparseArray;

    .line 26
    .local v13, "rows":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Lcom/uplynk/media/CaptionEvent$CaptionRow;>;"
    const/4 v11, 0x0

    .local v11, "i":I
    :goto_0
    invoke-virtual {v13}, Landroid/util/SparseArray;->size()I

    move-result v2

    if-ge v11, v2, :cond_3

    .line 28
    invoke-virtual {v13, v11}, Landroid/util/SparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Lcom/uplynk/media/CaptionEvent$CaptionRow;

    .line 29
    .local v12, "row":Lcom/uplynk/media/CaptionEvent$CaptionRow;
    invoke-virtual {v12}, Lcom/uplynk/media/CaptionEvent$CaptionRow;->getCharacters()Ljava/util/Vector;

    move-result-object v2

    invoke-static {v2}, Lcom/disney/datg/videoplatforms/sdk/media/CaptionUtils;->parsePopOnEventString(Ljava/util/Vector;)Ljava/lang/String;

    move-result-object v1

    .line 30
    .local v1, "output":Ljava/lang/String;
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;

    invoke-virtual {v12}, Lcom/uplynk/media/CaptionEvent$CaptionRow;->getRow()I

    move-result v4

    invoke-virtual {v12}, Lcom/uplynk/media/CaptionEvent$CaptionRow;->getColumn()I

    move-result v5

    invoke-virtual {v12}, Lcom/uplynk/media/CaptionEvent$CaptionRow;->getIndent()I

    move-result v6

    move-object v2, p1

    move-object/from16 v3, p2

    invoke-direct/range {v0 .. v6}, Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;III)V

    .line 31
    .local v0, "cue":Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;
    invoke-virtual {v12}, Lcom/uplynk/media/CaptionEvent$CaptionRow;->getText()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;->setRawText(Ljava/lang/String;)V

    .line 32
    invoke-virtual {v9, v0}, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;->addCue(Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;)V

    .line 26
    add-int/lit8 v11, v11, 0x1

    goto :goto_0

    .line 36
    .end local v0    # "cue":Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;
    .end local v1    # "output":Ljava/lang/String;
    .end local v11    # "i":I
    .end local v12    # "row":Lcom/uplynk/media/CaptionEvent$CaptionRow;
    .end local v13    # "rows":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Lcom/uplynk/media/CaptionEvent$CaptionRow;>;"
    :cond_0
    iget-object v2, p0, Lcom/uplynk/media/CaptionEvent;->mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v3, Lcom/uplynk/media/CaptionEvent$CaptionMode;->ROLL_UP:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-eq v2, v3, :cond_1

    iget-object v2, p0, Lcom/uplynk/media/CaptionEvent;->mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v3, Lcom/uplynk/media/CaptionEvent$CaptionMode;->PAINT_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-ne v2, v3, :cond_3

    .line 38
    :cond_1
    const/4 v0, 0x0

    .line 39
    .restart local v0    # "cue":Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;
    iget-object v2, p0, Lcom/uplynk/media/CaptionEvent;->eventType:Lcom/uplynk/media/CaptionEvent$CaptionEventType;

    sget-object v3, Lcom/uplynk/media/CaptionEvent$CaptionEventType;->TEXT:Lcom/uplynk/media/CaptionEvent$CaptionEventType;

    if-ne v2, v3, :cond_4

    .line 40
    iget-object v10, p0, Lcom/uplynk/media/CaptionEvent;->character:Lcom/uplynk/media/CaptionEvent$CaptionCharacter;

    .line 41
    .local v10, "cc":Lcom/uplynk/media/CaptionEvent$CaptionCharacter;
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;

    .end local v0    # "cue":Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;
    invoke-virtual {v10}, Lcom/uplynk/media/CaptionEvent$CaptionCharacter;->character()C

    move-result v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(C)Ljava/lang/String;

    move-result-object v3

    const/4 v6, -0x1

    const/4 v7, -0x1

    const/4 v8, -0x1

    move-object v2, v0

    move-object v4, p1

    move-object/from16 v5, p2

    invoke-direct/range {v2 .. v8}, Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;III)V

    .line 42
    .restart local v0    # "cue":Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;
    invoke-virtual {v10}, Lcom/uplynk/media/CaptionEvent$CaptionCharacter;->character()C

    move-result v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(C)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;->setRawText(Ljava/lang/String;)V

    .line 48
    .end local v10    # "cc":Lcom/uplynk/media/CaptionEvent$CaptionCharacter;
    :cond_2
    :goto_1
    invoke-virtual {v9, v0}, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;->addCue(Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;)V

    .line 51
    .end local v0    # "cue":Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;
    :cond_3
    return-object v9

    .line 43
    .restart local v0    # "cue":Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;
    :cond_4
    iget-object v2, p0, Lcom/uplynk/media/CaptionEvent;->eventType:Lcom/uplynk/media/CaptionEvent$CaptionEventType;

    sget-object v3, Lcom/uplynk/media/CaptionEvent$CaptionEventType;->LINEBREAK:Lcom/uplynk/media/CaptionEvent$CaptionEventType;

    if-ne v2, v3, :cond_2

    .line 45
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;

    .end local v0    # "cue":Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;
    const-string v3, "\n"

    const/4 v6, -0x1

    const/4 v7, -0x1

    const/4 v8, -0x1

    move-object v2, v0

    move-object v4, p1

    move-object/from16 v5, p2

    invoke-direct/range {v2 .. v8}, Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;III)V

    .line 46
    .restart local v0    # "cue":Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;
    const-string v2, "\n"

    invoke-virtual {v0, v2}, Lcom/disney/datg/videoplatforms/sdk/media/CaptionCue;->setRawText(Ljava/lang/String;)V

    goto :goto_1
.end method

.method private static parsePopOnEventString(Ljava/util/Vector;)Ljava/lang/String;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Vector",
            "<",
            "Lcom/uplynk/media/CaptionEvent$CaptionCharacter;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 56
    .local p0, "characters":Ljava/util/Vector;, "Ljava/util/Vector<Lcom/uplynk/media/CaptionEvent$CaptionCharacter;>;"
    new-instance v3, Ljava/lang/StringBuffer;

    invoke-direct {v3}, Ljava/lang/StringBuffer;-><init>()V

    .line 57
    .local v3, "outBuffer":Ljava/lang/StringBuffer;
    const/4 v1, 0x0

    .line 58
    .local v1, "isItalicOn":Z
    const/4 v2, 0x0

    .line 60
    .local v2, "isUnderlinedOn":Z
    const/4 v4, 0x0

    .local v4, "x":I
    :goto_0
    invoke-virtual {p0}, Ljava/util/Vector;->size()I

    move-result v5

    if-ge v4, v5, :cond_6

    .line 63
    invoke-virtual {p0, v4}, Ljava/util/Vector;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/uplynk/media/CaptionEvent$CaptionCharacter;

    .line 65
    .local v0, "cc":Lcom/uplynk/media/CaptionEvent$CaptionCharacter;
    invoke-virtual {v0}, Lcom/uplynk/media/CaptionEvent$CaptionCharacter;->isItalic()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-virtual {v0}, Lcom/uplynk/media/CaptionEvent$CaptionCharacter;->character()C

    move-result v5

    invoke-static {v5}, Ljava/lang/Character;->isISOControl(C)Z

    move-result v5

    if-nez v5, :cond_0

    invoke-virtual {v0}, Lcom/uplynk/media/CaptionEvent$CaptionCharacter;->character()C

    move-result v5

    invoke-static {v5}, Ljava/lang/Character;->isSpaceChar(C)Z

    move-result v5

    if-nez v5, :cond_0

    .line 67
    if-nez v1, :cond_0

    .line 69
    const-string v5, "<i>"

    invoke-virtual {v3, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 70
    const/4 v1, 0x1

    .line 74
    :cond_0
    invoke-virtual {v0}, Lcom/uplynk/media/CaptionEvent$CaptionCharacter;->isUnderlined()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-virtual {v0}, Lcom/uplynk/media/CaptionEvent$CaptionCharacter;->character()C

    move-result v5

    invoke-static {v5}, Ljava/lang/Character;->isISOControl(C)Z

    move-result v5

    if-nez v5, :cond_1

    invoke-virtual {v0}, Lcom/uplynk/media/CaptionEvent$CaptionCharacter;->character()C

    move-result v5

    invoke-static {v5}, Ljava/lang/Character;->isSpaceChar(C)Z

    move-result v5

    if-nez v5, :cond_1

    .line 76
    if-nez v2, :cond_1

    .line 78
    const-string v5, "<u>"

    invoke-virtual {v3, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 79
    const/4 v2, 0x1

    .line 83
    :cond_1
    invoke-virtual {v0}, Lcom/uplynk/media/CaptionEvent$CaptionCharacter;->character()C

    move-result v5

    invoke-virtual {v3, v5}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 85
    invoke-virtual {v0}, Lcom/uplynk/media/CaptionEvent$CaptionCharacter;->isUnderlined()Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-virtual {p0}, Ljava/util/Vector;->size()I

    move-result v5

    add-int/lit8 v5, v5, -0x1

    if-ne v4, v5, :cond_3

    .line 87
    :cond_2
    if-eqz v2, :cond_3

    .line 89
    const-string v5, "</u>"

    invoke-virtual {v3, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 90
    const/4 v2, 0x0

    .line 93
    :cond_3
    invoke-virtual {v0}, Lcom/uplynk/media/CaptionEvent$CaptionCharacter;->isItalic()Z

    move-result v5

    if-eqz v5, :cond_4

    invoke-virtual {p0}, Ljava/util/Vector;->size()I

    move-result v5

    add-int/lit8 v5, v5, -0x1

    if-ne v4, v5, :cond_5

    .line 95
    :cond_4
    if-eqz v1, :cond_5

    .line 97
    const-string v5, "</i>"

    invoke-virtual {v3, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 98
    const/4 v1, 0x0

    .line 60
    :cond_5
    add-int/lit8 v4, v4, 0x1

    goto/16 :goto_0

    .line 103
    .end local v0    # "cc":Lcom/uplynk/media/CaptionEvent$CaptionCharacter;
    :cond_6
    invoke-virtual {v3}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v5

    return-object v5
.end method

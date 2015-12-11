.class public abstract Lcom/comcast/cim/android/accessibility/SpeechRecognizer;
.super Lcom/comcast/cim/android/view/common/BaseActivity;
.source "SpeechRecognizer.java"

# interfaces
.implements Landroid/speech/RecognitionListener;


# instance fields
.field protected final alternateInterfaceUtil:Lcom/comcast/cim/android/accessibility/AlternateInterfaceUtil;

.field handler:Landroid/os/Handler;

.field private prompt:Ljava/lang/String;

.field private sr:Landroid/speech/SpeechRecognizer;

.field utteranceProgressListener:Landroid/speech/tts/UtteranceProgressListener;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 21
    invoke-direct {p0}, Lcom/comcast/cim/android/view/common/BaseActivity;-><init>()V

    .line 23
    invoke-static {}, Lcom/comcast/cim/container/CALContainer;->getInstance()Lcom/comcast/cim/container/CALContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/CALContainer;->getAlternateInterfaceUtil()Lcom/comcast/cim/android/accessibility/AlternateInterfaceUtil;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->alternateInterfaceUtil:Lcom/comcast/cim/android/accessibility/AlternateInterfaceUtil;

    .line 35
    new-instance v0, Lcom/comcast/cim/android/accessibility/SpeechRecognizer$1;

    invoke-direct {v0, p0}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer$1;-><init>(Lcom/comcast/cim/android/accessibility/SpeechRecognizer;)V

    iput-object v0, p0, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->handler:Landroid/os/Handler;

    .line 178
    new-instance v0, Lcom/comcast/cim/android/accessibility/SpeechRecognizer$4;

    invoke-direct {v0, p0}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer$4;-><init>(Lcom/comcast/cim/android/accessibility/SpeechRecognizer;)V

    iput-object v0, p0, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->utteranceProgressListener:Landroid/speech/tts/UtteranceProgressListener;

    return-void
.end method

.method static synthetic access$000(Lcom/comcast/cim/android/accessibility/SpeechRecognizer;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/accessibility/SpeechRecognizer;

    .prologue
    .line 21
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->prompt:Ljava/lang/String;

    return-object v0
.end method

.method private isLaunchByNumberFollowedByItemThenNumber([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechActions;)Z
    .locals 3
    .param p1, "wordsUp"    # [Ljava/lang/String;
    .param p2, "speechAction"    # Lcom/comcast/cim/android/accessibility/SpeechActions;

    .prologue
    const/4 v0, 0x1

    .line 317
    sget-object v1, Lcom/comcast/cim/android/accessibility/SpeechActions;->OPEN:Lcom/comcast/cim/android/accessibility/SpeechActions;

    if-eq p2, v1, :cond_0

    sget-object v1, Lcom/comcast/cim/android/accessibility/SpeechActions;->PLAY:Lcom/comcast/cim/android/accessibility/SpeechActions;

    if-ne p2, v1, :cond_1

    :cond_0
    array-length v1, p1

    if-le v1, v0, :cond_1

    aget-object v1, p1, v0

    const-string v2, "item"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private isSearchFollowedByTheWordFor([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechActions;)Z
    .locals 3
    .param p1, "wordsUp"    # [Ljava/lang/String;
    .param p2, "speechAction"    # Lcom/comcast/cim/android/accessibility/SpeechActions;

    .prologue
    const/4 v0, 0x1

    .line 321
    sget-object v1, Lcom/comcast/cim/android/accessibility/SpeechActions;->SEARCH:Lcom/comcast/cim/android/accessibility/SpeechActions;

    if-ne p2, v1, :cond_0

    array-length v1, p1

    if-le v1, v0, :cond_0

    aget-object v1, p1, v0

    const-string v2, "for"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public abstract attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
.end method

.method protected cleanup()V
    .locals 1

    .prologue
    .line 130
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->sr:Landroid/speech/SpeechRecognizer;

    invoke-virtual {v0}, Landroid/speech/SpeechRecognizer;->stopListening()V

    .line 131
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->sr:Landroid/speech/SpeechRecognizer;

    invoke-virtual {v0}, Landroid/speech/SpeechRecognizer;->destroy()V

    .line 132
    return-void
.end method

.method protected closeWithIgnore()V
    .locals 5

    .prologue
    .line 340
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 341
    .local v1, "callingActivityIntent":Landroid/content/Intent;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 343
    .local v0, "bundle":Landroid/os/Bundle;
    const-string v2, "KEY_ACTION"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/comcast/cim/android/accessibility/SpeechActions;->IGNORE_REENTRY:Lcom/comcast/cim/android/accessibility/SpeechActions;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 344
    invoke-virtual {v1, v0}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 346
    const/4 v2, -0x1

    invoke-virtual {p0, v2, v1}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->setResult(ILandroid/content/Intent;)V

    .line 348
    invoke-virtual {p0}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->finish()V

    .line 349
    return-void
.end method

.method protected filterTerms([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechActions;)[Ljava/lang/String;
    .locals 2
    .param p1, "wordsUp"    # [Ljava/lang/String;
    .param p2, "speechAction"    # Lcom/comcast/cim/android/accessibility/SpeechActions;

    .prologue
    .line 305
    const/4 v0, 0x1

    .line 307
    .local v0, "ignoreCount":I
    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->isSearchFollowedByTheWordFor([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechActions;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 308
    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->isLaunchByNumberFollowedByItemThenNumber([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechActions;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 310
    :cond_0
    const/4 v0, 0x2

    .line 313
    :cond_1
    array-length v1, p1

    invoke-static {p1, v0, v1}, Ljava/util/Arrays;->copyOfRange([Ljava/lang/Object;II)[Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Ljava/lang/String;

    return-object v1
.end method

.method public getOrientationStrategy()Lcom/comcast/cim/android/view/common/OrientationStrategy;
    .locals 1

    .prologue
    .line 373
    new-instance v0, Lcom/comcast/cim/android/accessibility/SpeechRecognizer$5;

    invoke-direct {v0, p0}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer$5;-><init>(Lcom/comcast/cim/android/accessibility/SpeechRecognizer;)V

    return-object v0
.end method

.method public getSpeech()V
    .locals 3

    .prologue
    .line 146
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.speech.action.RECOGNIZE_SPEECH"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 147
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "android.speech.extra.LANGUAGE_MODEL"

    const-string v2, "free_form"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 150
    iget-object v1, p0, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->sr:Landroid/speech/SpeechRecognizer;

    invoke-virtual {v1, v0}, Landroid/speech/SpeechRecognizer;->startListening(Landroid/content/Intent;)V

    .line 151
    return-void
.end method

.method public listen()V
    .locals 4

    .prologue
    .line 160
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->handler:Landroid/os/Handler;

    new-instance v1, Lcom/comcast/cim/android/accessibility/SpeechRecognizer$2;

    invoke-direct {v1, p0}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer$2;-><init>(Lcom/comcast/cim/android/accessibility/SpeechRecognizer;)V

    const-wide/16 v2, 0xa

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 166
    return-void
.end method

.method public onBeginningOfSpeech()V
    .locals 2

    .prologue
    .line 87
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->handler:Landroid/os/Handler;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    .line 88
    return-void
.end method

.method public onBufferReceived([B)V
    .locals 0
    .param p1, "bytes"    # [B

    .prologue
    .line 97
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 6
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 55
    invoke-virtual {p0}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->setupTalkDelegateDefault()V

    .line 57
    const-string v1, ""

    invoke-virtual {p0, v1}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->setTitle(Ljava/lang/CharSequence;)V

    .line 59
    invoke-static {p0}, Landroid/speech/SpeechRecognizer;->createSpeechRecognizer(Landroid/content/Context;)Landroid/speech/SpeechRecognizer;

    move-result-object v1

    iput-object v1, p0, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->sr:Landroid/speech/SpeechRecognizer;

    .line 60
    iget-object v1, p0, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->sr:Landroid/speech/SpeechRecognizer;

    invoke-virtual {v1, p0}, Landroid/speech/SpeechRecognizer;->setRecognitionListener(Landroid/speech/RecognitionListener;)V

    .line 62
    invoke-virtual {p0}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->getIntent()Landroid/content/Intent;

    move-result-object v0

    .line 64
    .local v0, "intent":Landroid/content/Intent;
    if-eqz v0, :cond_0

    .line 65
    invoke-virtual {p0}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->getIntent()Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "android.speech.extra.PROMPT"

    sget v3, Lcom/comcast/cim/android/R$string;->speech_dialog_caption_default:I

    invoke-virtual {p0, v3}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->prompt:Ljava/lang/String;

    .line 70
    :goto_0
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/common/BaseActivity;->onCreate(Landroid/os/Bundle;)V

    .line 72
    sget v1, Lcom/comcast/cim/android/R$layout;->speech_recognizer_shell:I

    invoke-virtual {p0, v1}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->setContentView(I)V

    .line 74
    invoke-virtual {p0}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->utteranceProgressListener:Landroid/speech/tts/UtteranceProgressListener;

    invoke-interface {v1, v2}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->setUtteranceListener(Landroid/speech/tts/UtteranceProgressListener;)V

    .line 76
    iget-object v1, p0, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->handler:Landroid/os/Handler;

    const/16 v2, 0x9

    const-wide/16 v4, 0xbb8

    invoke-virtual {v1, v2, v4, v5}, Landroid/os/Handler;->sendEmptyMessageDelayed(IJ)Z

    .line 77
    return-void

    .line 67
    :cond_0
    sget v1, Lcom/comcast/cim/android/R$string;->speech_dialog_caption_default:I

    invoke-virtual {p0, v1}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->prompt:Ljava/lang/String;

    goto :goto_0
.end method

.method protected onDestroy()V
    .locals 2

    .prologue
    .line 366
    invoke-super {p0}, Lcom/comcast/cim/android/view/common/BaseActivity;->onDestroy()V

    .line 367
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->handler:Landroid/os/Handler;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    .line 368
    return-void
.end method

.method public onEndOfSpeech()V
    .locals 0

    .prologue
    .line 101
    return-void
.end method

.method public onError(I)V
    .locals 3
    .param p1, "i"    # I

    .prologue
    .line 106
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 107
    .local v1, "stringArray":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    const-string v2, "~ERROR~"

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 109
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 111
    .local v0, "bundle":Landroid/os/Bundle;
    const-string v2, "results_recognition"

    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 112
    invoke-virtual {p0, v0}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->onResults(Landroid/os/Bundle;)V

    .line 114
    return-void
.end method

.method public onEvent(ILandroid/os/Bundle;)V
    .locals 0
    .param p1, "i"    # I
    .param p2, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 142
    return-void
.end method

.method public onPartialResults(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 137
    return-void
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 124
    invoke-super {p0}, Lcom/comcast/cim/android/view/common/BaseActivity;->onPause()V

    .line 125
    invoke-virtual {p0}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->cleanup()V

    .line 126
    invoke-virtual {p0}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->closeWithIgnore()V

    .line 127
    return-void
.end method

.method public onReadyForSpeech(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 81
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->handler:Landroid/os/Handler;

    const/16 v1, 0x9

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    .line 82
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->handler:Landroid/os/Handler;

    const/16 v1, 0x8

    const-wide/16 v2, 0x1388

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->sendEmptyMessageDelayed(IJ)Z

    .line 83
    return-void
.end method

.method public onResults(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "results"    # Landroid/os/Bundle;

    .prologue
    .line 118
    invoke-virtual {p0}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->cleanup()V

    .line 119
    const-string v0, "results_recognition"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->translateCommand(Ljava/util/ArrayList;)V

    .line 120
    return-void
.end method

.method public onRmsChanged(F)V
    .locals 0
    .param p1, "v"    # F

    .prologue
    .line 92
    return-void
.end method

.method public talk()V
    .locals 4

    .prologue
    .line 170
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->handler:Landroid/os/Handler;

    new-instance v1, Lcom/comcast/cim/android/accessibility/SpeechRecognizer$3;

    invoke-direct {v1, p0}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer$3;-><init>(Lcom/comcast/cim/android/accessibility/SpeechRecognizer;)V

    const-wide/16 v2, 0x1f4

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 176
    return-void
.end method

.method protected translateCommand(Ljava/util/ArrayList;)V
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "wordsUp":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 198
    new-instance v3, Landroid/content/Intent;

    invoke-direct {v3}, Landroid/content/Intent;-><init>()V

    .line 199
    .local v3, "intent":Landroid/content/Intent;
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 202
    .local v1, "bundle":Landroid/os/Bundle;
    new-array v5, v9, [Ljava/lang/String;

    const-string v6, "~UNRECOGNIZED~"

    aput-object v6, v5, v8

    .line 204
    .local v5, "terms":[Ljava/lang/String;
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v6

    if-lez v6, :cond_0

    .line 205
    invoke-virtual {p1, v8}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    invoke-virtual {v6}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v6

    const-string v7, " "

    invoke-virtual {v6, v7}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v5

    .line 208
    :cond_0
    aget-object v2, v5, v8

    .line 210
    .local v2, "firstWord":Ljava/lang/String;
    const-string v6, "~UNRECOGNIZED~"

    invoke-virtual {v2, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 212
    sget-object v0, Lcom/comcast/cim/android/accessibility/SpeechActions;->UNRECOGNIZED:Lcom/comcast/cim/android/accessibility/SpeechActions;

    .line 294
    .local v0, "action":Lcom/comcast/cim/android/accessibility/SpeechActions;
    :goto_0
    const-string v6, "KEY_TERMS"

    sget-object v7, Lcom/comcast/cim/android/accessibility/SpeechActions;->UNRECOGNIZED:Lcom/comcast/cim/android/accessibility/SpeechActions;

    invoke-virtual {p0, v5, v7}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->filterTerms([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechActions;)[Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v1, v6, v7}, Landroid/os/Bundle;->putStringArray(Ljava/lang/String;[Ljava/lang/String;)V

    .line 295
    const-string v6, "KEY_ACTION"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ""

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v1, v6, v7}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 296
    invoke-virtual {v3, v1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 298
    const/4 v6, -0x1

    invoke-virtual {p0, v6, v3}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->setResult(ILandroid/content/Intent;)V

    .line 300
    invoke-virtual {p0}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->finish()V

    .line 301
    .end local v0    # "action":Lcom/comcast/cim/android/accessibility/SpeechActions;
    :goto_1
    return-void

    .line 214
    :cond_1
    const-string v6, "search"

    invoke-virtual {v2, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 216
    sget-object v6, Lcom/comcast/cim/android/accessibility/SpeechActions;->SEARCH:Lcom/comcast/cim/android/accessibility/SpeechActions;

    invoke-virtual {p0, v5, v6}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->filterTerms([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechActions;)[Ljava/lang/String;

    move-result-object v6

    sget-object v7, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;->SEARCH:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    invoke-virtual {p0, v6, v7}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V

    goto :goto_1

    .line 219
    :cond_2
    const-string v6, "open"

    invoke-virtual {v2, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_3

    const-string v6, "show"

    invoke-virtual {v2, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_3

    const-string v6, "item"

    invoke-virtual {v2, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_4

    .line 221
    :cond_3
    sget-object v6, Lcom/comcast/cim/android/accessibility/SpeechActions;->OPEN:Lcom/comcast/cim/android/accessibility/SpeechActions;

    invoke-virtual {p0, v5, v6}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->filterTerms([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechActions;)[Ljava/lang/String;

    move-result-object v6

    sget-object v7, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;->OPEN:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    invoke-virtual {p0, v6, v7}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V

    goto :goto_1

    .line 224
    :cond_4
    const-string v6, "play"

    invoke-virtual {v2, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_5

    const-string v6, "watch"

    invoke-virtual {v2, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_5

    const-string v6, "resume"

    invoke-virtual {v2, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_7

    .line 226
    :cond_5
    array-length v6, v5

    if-ne v6, v9, :cond_6

    .line 227
    sget-object v0, Lcom/comcast/cim/android/accessibility/SpeechActions;->PLAY:Lcom/comcast/cim/android/accessibility/SpeechActions;

    .restart local v0    # "action":Lcom/comcast/cim/android/accessibility/SpeechActions;
    goto/16 :goto_0

    .line 229
    .end local v0    # "action":Lcom/comcast/cim/android/accessibility/SpeechActions;
    :cond_6
    sget-object v6, Lcom/comcast/cim/android/accessibility/SpeechActions;->PLAY:Lcom/comcast/cim/android/accessibility/SpeechActions;

    invoke-virtual {p0, v5, v6}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->filterTerms([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechActions;)[Ljava/lang/String;

    move-result-object v6

    sget-object v7, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;->PLAY:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    invoke-virtual {p0, v6, v7}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V

    goto :goto_1

    .line 233
    :cond_7
    const-string v6, "pause"

    invoke-virtual {v2, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_8

    const-string v6, "paws"

    invoke-virtual {v2, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_9

    .line 235
    :cond_8
    sget-object v0, Lcom/comcast/cim/android/accessibility/SpeechActions;->PAUSE:Lcom/comcast/cim/android/accessibility/SpeechActions;

    .restart local v0    # "action":Lcom/comcast/cim/android/accessibility/SpeechActions;
    goto/16 :goto_0

    .line 237
    .end local v0    # "action":Lcom/comcast/cim/android/accessibility/SpeechActions;
    :cond_9
    const-string v6, "skip"

    invoke-virtual {v2, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_a

    const-string v6, "forward"

    .line 238
    invoke-virtual {v2, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_a

    const-string v6, "seek"

    .line 239
    invoke-virtual {v2, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_b

    .line 241
    :cond_a
    sget-object v0, Lcom/comcast/cim/android/accessibility/SpeechActions;->SEEK:Lcom/comcast/cim/android/accessibility/SpeechActions;

    .restart local v0    # "action":Lcom/comcast/cim/android/accessibility/SpeechActions;
    goto/16 :goto_0

    .line 243
    .end local v0    # "action":Lcom/comcast/cim/android/accessibility/SpeechActions;
    :cond_b
    const-string v6, "repeat"

    invoke-virtual {v2, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_c

    .line 245
    sget-object v0, Lcom/comcast/cim/android/accessibility/SpeechActions;->REPEAT:Lcom/comcast/cim/android/accessibility/SpeechActions;

    .restart local v0    # "action":Lcom/comcast/cim/android/accessibility/SpeechActions;
    goto/16 :goto_0

    .line 247
    .end local v0    # "action":Lcom/comcast/cim/android/accessibility/SpeechActions;
    :cond_c
    const-string v6, "clear"

    invoke-virtual {v2, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_d

    .line 249
    sget-object v0, Lcom/comcast/cim/android/accessibility/SpeechActions;->CLEAR:Lcom/comcast/cim/android/accessibility/SpeechActions;

    .restart local v0    # "action":Lcom/comcast/cim/android/accessibility/SpeechActions;
    goto/16 :goto_0

    .line 251
    .end local v0    # "action":Lcom/comcast/cim/android/accessibility/SpeechActions;
    :cond_d
    const-string v6, "close"

    invoke-virtual {v2, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_e

    .line 253
    sget-object v0, Lcom/comcast/cim/android/accessibility/SpeechActions;->CLOSE:Lcom/comcast/cim/android/accessibility/SpeechActions;

    .restart local v0    # "action":Lcom/comcast/cim/android/accessibility/SpeechActions;
    goto/16 :goto_0

    .line 255
    .end local v0    # "action":Lcom/comcast/cim/android/accessibility/SpeechActions;
    :cond_e
    const-string v6, "shush"

    invoke-virtual {v2, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_f

    const-string v6, "cancel"

    .line 256
    invoke-virtual {v2, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_10

    .line 258
    :cond_f
    sget-object v0, Lcom/comcast/cim/android/accessibility/SpeechActions;->CANCEL:Lcom/comcast/cim/android/accessibility/SpeechActions;

    .restart local v0    # "action":Lcom/comcast/cim/android/accessibility/SpeechActions;
    goto/16 :goto_0

    .line 260
    .end local v0    # "action":Lcom/comcast/cim/android/accessibility/SpeechActions;
    :cond_10
    const-string v6, "less"

    invoke-virtual {v2, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_11

    .line 262
    sget-object v0, Lcom/comcast/cim/android/accessibility/SpeechActions;->LESS:Lcom/comcast/cim/android/accessibility/SpeechActions;

    .restart local v0    # "action":Lcom/comcast/cim/android/accessibility/SpeechActions;
    goto/16 :goto_0

    .line 265
    .end local v0    # "action":Lcom/comcast/cim/android/accessibility/SpeechActions;
    :cond_11
    const-string v6, "back"

    invoke-virtual {v2, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_12

    const-string v6, "rewind"

    invoke-virtual {v2, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_13

    .line 267
    :cond_12
    sget-object v0, Lcom/comcast/cim/android/accessibility/SpeechActions;->REWIND:Lcom/comcast/cim/android/accessibility/SpeechActions;

    .restart local v0    # "action":Lcom/comcast/cim/android/accessibility/SpeechActions;
    goto/16 :goto_0

    .line 270
    .end local v0    # "action":Lcom/comcast/cim/android/accessibility/SpeechActions;
    :cond_13
    const-string v6, "more"

    invoke-virtual {v2, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_14

    const-string v6, "next"

    .line 271
    invoke-virtual {v2, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_15

    .line 273
    :cond_14
    sget-object v0, Lcom/comcast/cim/android/accessibility/SpeechActions;->MORE:Lcom/comcast/cim/android/accessibility/SpeechActions;

    .restart local v0    # "action":Lcom/comcast/cim/android/accessibility/SpeechActions;
    goto/16 :goto_0

    .line 278
    .end local v0    # "action":Lcom/comcast/cim/android/accessibility/SpeechActions;
    :cond_15
    iget-object v6, p0, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->alternateInterfaceUtil:Lcom/comcast/cim/android/accessibility/AlternateInterfaceUtil;

    invoke-virtual {v6, v2}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceUtil;->interpretIfNumber(Ljava/lang/String;)I

    move-result v4

    .line 280
    .local v4, "onlyNumber":I
    if-lez v4, :cond_16

    .line 282
    sget-object v0, Lcom/comcast/cim/android/accessibility/SpeechActions;->JUST_A_NUMBER:Lcom/comcast/cim/android/accessibility/SpeechActions;

    .line 284
    .restart local v0    # "action":Lcom/comcast/cim/android/accessibility/SpeechActions;
    invoke-virtual {p1}, Ljava/util/ArrayList;->clear()V

    .line 285
    const-string v6, "dummy"

    invoke-virtual {p1, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 286
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, ""

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p1, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_0

    .line 290
    .end local v0    # "action":Lcom/comcast/cim/android/accessibility/SpeechActions;
    :cond_16
    sget-object v0, Lcom/comcast/cim/android/accessibility/SpeechActions;->UNRECOGNIZED:Lcom/comcast/cim/android/accessibility/SpeechActions;

    .restart local v0    # "action":Lcom/comcast/cim/android/accessibility/SpeechActions;
    goto/16 :goto_0
.end method

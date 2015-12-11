.class public Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;
.super Ljava/lang/Object;
.source "DefaultTalkDelegate.java"

# interfaces
.implements Landroid/speech/tts/TextToSpeech$OnInitListener;
.implements Lcom/comcast/cim/android/accessibility/TalkDelegate;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$UtteranceID;
    }
.end annotation


# instance fields
.field private final LOG:Lorg/slf4j/Logger;

.field protected final context:Landroid/app/Activity;

.field protected currentToast:Landroid/widget/Toast;

.field protected handler:Landroid/os/Handler;

.field private ignoreAnnounceTitle:Z

.field private spokenTitle:Ljava/lang/String;

.field protected tts:Landroid/speech/tts/TextToSpeech;


# direct methods
.method public constructor <init>(Landroid/app/Activity;)V
    .locals 1
    .param p1, "context"    # Landroid/app/Activity;

    .prologue
    const/4 v0, 0x0

    .line 51
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    iput-object v0, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->currentToast:Landroid/widget/Toast;

    .line 22
    iput-object v0, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->spokenTitle:Ljava/lang/String;

    .line 23
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->ignoreAnnounceTitle:Z

    .line 31
    const-class v0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->LOG:Lorg/slf4j/Logger;

    .line 33
    new-instance v0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$1;

    invoke-direct {v0, p0}, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$1;-><init>(Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;)V

    iput-object v0, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->handler:Landroid/os/Handler;

    .line 52
    iput-object p1, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->context:Landroid/app/Activity;

    .line 53
    new-instance v0, Landroid/speech/tts/TextToSpeech;

    invoke-direct {v0, p1, p0}, Landroid/speech/tts/TextToSpeech;-><init>(Landroid/content/Context;Landroid/speech/tts/TextToSpeech$OnInitListener;)V

    iput-object v0, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->tts:Landroid/speech/tts/TextToSpeech;

    .line 54
    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Z)V
    .locals 1
    .param p1, "context"    # Landroid/app/Activity;
    .param p2, "inAccessibilityMode"    # Z

    .prologue
    const/4 v0, 0x0

    .line 56
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    iput-object v0, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->currentToast:Landroid/widget/Toast;

    .line 22
    iput-object v0, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->spokenTitle:Ljava/lang/String;

    .line 23
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->ignoreAnnounceTitle:Z

    .line 31
    const-class v0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->LOG:Lorg/slf4j/Logger;

    .line 33
    new-instance v0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$1;

    invoke-direct {v0, p0}, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$1;-><init>(Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;)V

    iput-object v0, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->handler:Landroid/os/Handler;

    .line 57
    iput-object p1, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->context:Landroid/app/Activity;

    .line 59
    if-nez p2, :cond_0

    .line 60
    new-instance v0, Landroid/speech/tts/TextToSpeech;

    invoke-direct {v0, p1, p0}, Landroid/speech/tts/TextToSpeech;-><init>(Landroid/content/Context;Landroid/speech/tts/TextToSpeech$OnInitListener;)V

    iput-object v0, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->tts:Landroid/speech/tts/TextToSpeech;

    .line 62
    :cond_0
    return-void
.end method

.method static synthetic access$000(Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;

    .prologue
    .line 16
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->spokenTitle:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public announceTitle()V
    .locals 1

    .prologue
    .line 161
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->spokenTitle:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 162
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->context:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getTitle()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->spokenTitle:Ljava/lang/String;

    .line 165
    :cond_0
    iget-boolean v0, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->ignoreAnnounceTitle:Z

    if-eqz v0, :cond_1

    .line 166
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->ignoreAnnounceTitle:Z

    .line 171
    :goto_0
    return-void

    .line 170
    :cond_1
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->spokenTitle:Ljava/lang/String;

    invoke-virtual {p0, v0}, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->speak(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public cancelAllMessages()V
    .locals 2

    .prologue
    .line 150
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->handler:Landroid/os/Handler;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    .line 151
    return-void
.end method

.method public ignoreAnnounceTitleOnce()V
    .locals 1

    .prologue
    .line 175
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->ignoreAnnounceTitle:Z

    .line 176
    return-void
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    .line 130
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->handler:Landroid/os/Handler;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    .line 132
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->tts:Landroid/speech/tts/TextToSpeech;

    if-eqz v0, :cond_0

    .line 133
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->tts:Landroid/speech/tts/TextToSpeech;

    invoke-virtual {v0}, Landroid/speech/tts/TextToSpeech;->stop()I

    .line 134
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->tts:Landroid/speech/tts/TextToSpeech;

    invoke-virtual {v0}, Landroid/speech/tts/TextToSpeech;->shutdown()V

    .line 136
    :cond_0
    return-void
.end method

.method public onInit(I)V
    .locals 3
    .param p1, "status"    # I

    .prologue
    .line 117
    if-nez p1, :cond_0

    .line 119
    iget-object v1, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->tts:Landroid/speech/tts/TextToSpeech;

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v1, v2}, Landroid/speech/tts/TextToSpeech;->setLanguage(Ljava/util/Locale;)I

    move-result v0

    .line 121
    .local v0, "result":I
    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    const/4 v1, -0x2

    if-eq v0, v1, :cond_0

    .line 123
    const-string v1, ""

    invoke-virtual {p0, v1}, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->speak(Ljava/lang/String;)V

    .line 126
    .end local v0    # "result":I
    :cond_0
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "title"    # Ljava/lang/String;

    .prologue
    .line 155
    iput-object p1, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->spokenTitle:Ljava/lang/String;

    .line 156
    return-void
.end method

.method public setUtteranceListener(Landroid/speech/tts/UtteranceProgressListener;)V
    .locals 1
    .param p1, "listener"    # Landroid/speech/tts/UtteranceProgressListener;

    .prologue
    .line 69
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->tts:Landroid/speech/tts/TextToSpeech;

    invoke-virtual {v0, p1}, Landroid/speech/tts/TextToSpeech;->setOnUtteranceProgressListener(Landroid/speech/tts/UtteranceProgressListener;)I

    .line 70
    return-void
.end method

.method public speak(I)V
    .locals 1
    .param p1, "sayWhatResId"    # I

    .prologue
    .line 84
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->context:Landroid/app/Activity;

    invoke-virtual {v0, p1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->speak(Ljava/lang/String;)V

    .line 85
    return-void
.end method

.method public speak(Ljava/lang/String;)V
    .locals 1
    .param p1, "sayWhat"    # Ljava/lang/String;

    .prologue
    .line 88
    const/4 v0, 0x1

    invoke-virtual {p0, p1, v0}, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->speak(Ljava/lang/String;I)V

    .line 89
    return-void
.end method

.method public speak(Ljava/lang/String;I)V
    .locals 2
    .param p1, "sayWhat"    # Ljava/lang/String;
    .param p2, "queueMode"    # I

    .prologue
    .line 94
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->tts:Landroid/speech/tts/TextToSpeech;

    if-eqz v0, :cond_0

    .line 95
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->tts:Landroid/speech/tts/TextToSpeech;

    const/4 v1, 0x0

    invoke-virtual {v0, p1, p2, v1}, Landroid/speech/tts/TextToSpeech;->speak(Ljava/lang/String;ILjava/util/HashMap;)I

    .line 97
    :cond_0
    return-void
.end method

.method public speakManagedMessage(I)V
    .locals 1
    .param p1, "messageId"    # I

    .prologue
    .line 144
    invoke-virtual {p0}, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->cancelAllMessages()V

    .line 145
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->handler:Landroid/os/Handler;

    invoke-virtual {v0, p1}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 146
    return-void
.end method

.method public speakThenListen(Ljava/lang/String;)V
    .locals 3
    .param p1, "sayWhat"    # Ljava/lang/String;

    .prologue
    .line 102
    const/4 v0, 0x0

    .line 104
    .local v0, "myHashAlarm":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_0

    .line 105
    new-instance v0, Ljava/util/HashMap;

    .end local v0    # "myHashAlarm":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 106
    .restart local v0    # "myHashAlarm":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v1, "utteranceId"

    sget-object v2, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$UtteranceID;->FOLLOWUP_WITH_LISTEN:Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$UtteranceID;

    invoke-virtual {v2}, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$UtteranceID;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 109
    :cond_0
    iget-object v1, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->tts:Landroid/speech/tts/TextToSpeech;

    if-eqz v1, :cond_1

    .line 110
    iget-object v1, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->tts:Landroid/speech/tts/TextToSpeech;

    const/4 v2, 0x0

    invoke-virtual {v1, p1, v2, v0}, Landroid/speech/tts/TextToSpeech;->speak(Ljava/lang/String;ILjava/util/HashMap;)I

    .line 112
    :cond_1
    return-void
.end method

.method public stopSpeaking()V
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->tts:Landroid/speech/tts/TextToSpeech;

    if-eqz v0, :cond_0

    .line 75
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->tts:Landroid/speech/tts/TextToSpeech;

    invoke-virtual {v0}, Landroid/speech/tts/TextToSpeech;->stop()I

    .line 78
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->currentToast:Landroid/widget/Toast;

    if-eqz v0, :cond_1

    .line 79
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->currentToast:Landroid/widget/Toast;

    invoke-virtual {v0}, Landroid/widget/Toast;->cancel()V

    .line 81
    :cond_1
    return-void
.end method

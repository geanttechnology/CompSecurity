.class public Lcom/comcast/cim/android/accessibility/DummyTalkDelegate;
.super Ljava/lang/Object;
.source "DummyTalkDelegate.java"

# interfaces
.implements Lcom/comcast/cim/android/accessibility/TalkDelegate;


# direct methods
.method public constructor <init>(Landroid/app/Activity;)V
    .locals 0
    .param p1, "context"    # Landroid/app/Activity;

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    return-void
.end method


# virtual methods
.method public announceTitle()V
    .locals 0

    .prologue
    .line 67
    return-void
.end method

.method public cancelAllMessages()V
    .locals 0

    .prologue
    .line 57
    return-void
.end method

.method public ignoreAnnounceTitleOnce()V
    .locals 0

    .prologue
    .line 72
    return-void
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 17
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "title"    # Ljava/lang/String;

    .prologue
    .line 62
    return-void
.end method

.method public setUtteranceListener(Landroid/speech/tts/UtteranceProgressListener;)V
    .locals 0
    .param p1, "listener"    # Landroid/speech/tts/UtteranceProgressListener;

    .prologue
    .line 47
    return-void
.end method

.method public speak(I)V
    .locals 0
    .param p1, "sayWhatResId"    # I

    .prologue
    .line 27
    return-void
.end method

.method public speak(Ljava/lang/String;)V
    .locals 0
    .param p1, "sayWhat"    # Ljava/lang/String;

    .prologue
    .line 32
    return-void
.end method

.method public speakManagedMessage(I)V
    .locals 0
    .param p1, "messageStringResId"    # I

    .prologue
    .line 52
    return-void
.end method

.method public speakThenListen(Ljava/lang/String;)V
    .locals 0
    .param p1, "sayWhat"    # Ljava/lang/String;

    .prologue
    .line 42
    return-void
.end method

.method public stopSpeaking()V
    .locals 0

    .prologue
    .line 22
    return-void
.end method

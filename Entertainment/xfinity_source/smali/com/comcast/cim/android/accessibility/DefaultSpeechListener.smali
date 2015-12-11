.class public Lcom/comcast/cim/android/accessibility/DefaultSpeechListener;
.super Ljava/lang/Object;
.source "DefaultSpeechListener.java"

# interfaces
.implements Lcom/comcast/cim/android/accessibility/SpeechListener;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onSpeechResponseCancel()Z
    .locals 1

    .prologue
    .line 32
    const/4 v0, 0x0

    return v0
.end method

.method public onSpeechResponseClear()Z
    .locals 1

    .prologue
    .line 22
    const/4 v0, 0x0

    return v0
.end method

.method public onSpeechResponseClose()Z
    .locals 1

    .prologue
    .line 27
    const/4 v0, 0x0

    return v0
.end method

.method public onSpeechResponseFeedback(Ljava/lang/String;)Z
    .locals 1
    .param p1, "feedback"    # Ljava/lang/String;

    .prologue
    .line 52
    const/4 v0, 0x0

    return v0
.end method

.method public onSpeechResponseIgnoreReentry()Z
    .locals 1

    .prologue
    .line 82
    const/4 v0, 0x1

    return v0
.end method

.method public onSpeechResponseLess()Z
    .locals 1

    .prologue
    .line 12
    const/4 v0, 0x0

    return v0
.end method

.method public onSpeechResponseMore()Z
    .locals 1

    .prologue
    .line 7
    const/4 v0, 0x0

    return v0
.end method

.method public onSpeechResponseOpen([Ljava/lang/String;)Z
    .locals 1
    .param p1, "searchTerms"    # [Ljava/lang/String;

    .prologue
    .line 62
    const/4 v0, 0x0

    return v0
.end method

.method public onSpeechResponsePause()Z
    .locals 1

    .prologue
    .line 72
    const/4 v0, 0x0

    return v0
.end method

.method public onSpeechResponsePlay([Ljava/lang/String;)Z
    .locals 1
    .param p1, "searchTerms"    # [Ljava/lang/String;

    .prologue
    .line 67
    const/4 v0, 0x0

    return v0
.end method

.method public onSpeechResponseRepeat()Z
    .locals 1

    .prologue
    .line 17
    const/4 v0, 0x0

    return v0
.end method

.method public onSpeechResponseSearch([Ljava/lang/String;)Z
    .locals 1
    .param p1, "searchTerms"    # [Ljava/lang/String;

    .prologue
    .line 42
    const/4 v0, 0x0

    return v0
.end method

.method public onSpeechResponseSeek([Ljava/lang/String;)Z
    .locals 1
    .param p1, "terms"    # [Ljava/lang/String;

    .prologue
    .line 77
    const/4 v0, 0x0

    return v0
.end method

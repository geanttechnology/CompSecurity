.class public Lcom/comcast/cim/android/accessibility/SpeechDelegate;
.super Ljava/lang/Object;
.source "SpeechDelegate.java"


# instance fields
.field private final activity:Landroid/app/Activity;

.field private isTriggered:Z

.field private speechListeners:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Lcom/comcast/cim/android/accessibility/SpeechListener;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/app/Activity;)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/comcast/cim/android/accessibility/SpeechDelegate;->isTriggered:Z

    .line 28
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/android/accessibility/SpeechDelegate;->speechListeners:Ljava/util/HashSet;

    .line 31
    iput-object p1, p0, Lcom/comcast/cim/android/accessibility/SpeechDelegate;->activity:Landroid/app/Activity;

    .line 32
    return-void
.end method

.method private onSpeechResponse(Ljava/lang/String;[Ljava/lang/String;)Z
    .locals 6
    .param p1, "action"    # Ljava/lang/String;
    .param p2, "terms"    # [Ljava/lang/String;

    .prologue
    .line 50
    invoke-static {p1}, Lcom/comcast/cim/android/accessibility/SpeechActions;->valueOf(Ljava/lang/String;)Lcom/comcast/cim/android/accessibility/SpeechActions;

    move-result-object v1

    .line 51
    .local v1, "speechAction":Lcom/comcast/cim/android/accessibility/SpeechActions;
    const/4 v0, 0x0

    .line 53
    .local v0, "actionConsumed":Z
    iget-object v3, p0, Lcom/comcast/cim/android/accessibility/SpeechDelegate;->speechListeners:Ljava/util/HashSet;

    invoke-virtual {v3}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/comcast/cim/android/accessibility/SpeechListener;

    .line 55
    .local v2, "speechListener":Lcom/comcast/cim/android/accessibility/SpeechListener;
    sget-object v4, Lcom/comcast/cim/android/accessibility/SpeechActions;->SEARCH:Lcom/comcast/cim/android/accessibility/SpeechActions;

    if-ne v4, v1, :cond_1

    .line 57
    invoke-interface {v2, p2}, Lcom/comcast/cim/android/accessibility/SpeechListener;->onSpeechResponseSearch([Ljava/lang/String;)Z

    .line 58
    const/4 v0, 0x1

    goto :goto_0

    .line 62
    :cond_1
    sget-object v4, Lcom/comcast/cim/android/accessibility/SpeechActions;->CLEAR:Lcom/comcast/cim/android/accessibility/SpeechActions;

    if-ne v4, v1, :cond_6

    .line 63
    invoke-interface {v2}, Lcom/comcast/cim/android/accessibility/SpeechListener;->onSpeechResponseClear()Z

    move-result v0

    .line 107
    :cond_2
    :goto_1
    if-eqz v0, :cond_0

    .line 112
    .end local v2    # "speechListener":Lcom/comcast/cim/android/accessibility/SpeechListener;
    :cond_3
    if-nez v0, :cond_5

    .line 113
    iget-object v3, p0, Lcom/comcast/cim/android/accessibility/SpeechDelegate;->speechListeners:Ljava/util/HashSet;

    invoke-virtual {v3}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_4
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_5

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/comcast/cim/android/accessibility/SpeechListener;

    .line 114
    .restart local v2    # "speechListener":Lcom/comcast/cim/android/accessibility/SpeechListener;
    iget-object v4, p0, Lcom/comcast/cim/android/accessibility/SpeechDelegate;->activity:Landroid/app/Activity;

    sget v5, Lcom/comcast/cim/android/R$string;->command_not_avail:I

    invoke-virtual {v4, v5}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v4}, Lcom/comcast/cim/android/accessibility/SpeechListener;->onSpeechResponseFeedback(Ljava/lang/String;)Z

    move-result v0

    .line 116
    if-eqz v0, :cond_4

    .line 120
    .end local v2    # "speechListener":Lcom/comcast/cim/android/accessibility/SpeechListener;
    :cond_5
    return v0

    .line 65
    .restart local v2    # "speechListener":Lcom/comcast/cim/android/accessibility/SpeechListener;
    :cond_6
    sget-object v4, Lcom/comcast/cim/android/accessibility/SpeechActions;->CLOSE:Lcom/comcast/cim/android/accessibility/SpeechActions;

    if-ne v4, v1, :cond_7

    .line 66
    invoke-interface {v2}, Lcom/comcast/cim/android/accessibility/SpeechListener;->onSpeechResponseClose()Z

    move-result v0

    goto :goto_1

    .line 68
    :cond_7
    sget-object v4, Lcom/comcast/cim/android/accessibility/SpeechActions;->CANCEL:Lcom/comcast/cim/android/accessibility/SpeechActions;

    if-ne v4, v1, :cond_8

    .line 69
    invoke-interface {v2}, Lcom/comcast/cim/android/accessibility/SpeechListener;->onSpeechResponseCancel()Z

    move-result v0

    goto :goto_1

    .line 71
    :cond_8
    sget-object v4, Lcom/comcast/cim/android/accessibility/SpeechActions;->REPEAT:Lcom/comcast/cim/android/accessibility/SpeechActions;

    if-ne v4, v1, :cond_9

    .line 72
    invoke-interface {v2}, Lcom/comcast/cim/android/accessibility/SpeechListener;->onSpeechResponseRepeat()Z

    move-result v0

    goto :goto_1

    .line 74
    :cond_9
    sget-object v4, Lcom/comcast/cim/android/accessibility/SpeechActions;->MORE:Lcom/comcast/cim/android/accessibility/SpeechActions;

    if-ne v4, v1, :cond_a

    .line 75
    invoke-interface {v2}, Lcom/comcast/cim/android/accessibility/SpeechListener;->onSpeechResponseMore()Z

    move-result v0

    goto :goto_1

    .line 77
    :cond_a
    sget-object v4, Lcom/comcast/cim/android/accessibility/SpeechActions;->LESS:Lcom/comcast/cim/android/accessibility/SpeechActions;

    if-ne v4, v1, :cond_b

    .line 78
    invoke-interface {v2}, Lcom/comcast/cim/android/accessibility/SpeechListener;->onSpeechResponseLess()Z

    move-result v0

    goto :goto_1

    .line 80
    :cond_b
    sget-object v4, Lcom/comcast/cim/android/accessibility/SpeechActions;->PLAY:Lcom/comcast/cim/android/accessibility/SpeechActions;

    if-ne v4, v1, :cond_c

    .line 81
    invoke-interface {v2, p2}, Lcom/comcast/cim/android/accessibility/SpeechListener;->onSpeechResponsePlay([Ljava/lang/String;)Z

    move-result v0

    goto :goto_1

    .line 83
    :cond_c
    sget-object v4, Lcom/comcast/cim/android/accessibility/SpeechActions;->OPEN:Lcom/comcast/cim/android/accessibility/SpeechActions;

    if-ne v4, v1, :cond_d

    .line 84
    invoke-interface {v2, p2}, Lcom/comcast/cim/android/accessibility/SpeechListener;->onSpeechResponseOpen([Ljava/lang/String;)Z

    move-result v0

    goto :goto_1

    .line 86
    :cond_d
    sget-object v4, Lcom/comcast/cim/android/accessibility/SpeechActions;->PAUSE:Lcom/comcast/cim/android/accessibility/SpeechActions;

    if-ne v4, v1, :cond_e

    .line 87
    invoke-interface {v2}, Lcom/comcast/cim/android/accessibility/SpeechListener;->onSpeechResponsePause()Z

    move-result v0

    goto :goto_1

    .line 89
    :cond_e
    sget-object v4, Lcom/comcast/cim/android/accessibility/SpeechActions;->SEEK:Lcom/comcast/cim/android/accessibility/SpeechActions;

    if-ne v4, v1, :cond_f

    .line 90
    invoke-interface {v2, p2}, Lcom/comcast/cim/android/accessibility/SpeechListener;->onSpeechResponseSeek([Ljava/lang/String;)Z

    move-result v0

    goto :goto_1

    .line 92
    :cond_f
    sget-object v4, Lcom/comcast/cim/android/accessibility/SpeechActions;->REWIND:Lcom/comcast/cim/android/accessibility/SpeechActions;

    if-eq v4, v1, :cond_2

    .line 96
    sget-object v4, Lcom/comcast/cim/android/accessibility/SpeechActions;->IGNORE_REENTRY:Lcom/comcast/cim/android/accessibility/SpeechActions;

    if-ne v4, v1, :cond_10

    .line 97
    invoke-interface {v2}, Lcom/comcast/cim/android/accessibility/SpeechListener;->onSpeechResponseIgnoreReentry()Z

    move-result v0

    goto/16 :goto_1

    .line 99
    :cond_10
    sget-object v4, Lcom/comcast/cim/android/accessibility/SpeechActions;->FEEDBACK:Lcom/comcast/cim/android/accessibility/SpeechActions;

    if-ne v4, v1, :cond_2

    .line 100
    const-string v4, "todo: jva - add message here"

    invoke-interface {v2, v4}, Lcom/comcast/cim/android/accessibility/SpeechListener;->onSpeechResponseFeedback(Ljava/lang/String;)Z

    move-result v0

    goto/16 :goto_1
.end method


# virtual methods
.method public addSpeechListener(Lcom/comcast/cim/android/accessibility/SpeechListener;)V
    .locals 1
    .param p1, "speechListener"    # Lcom/comcast/cim/android/accessibility/SpeechListener;

    .prologue
    .line 189
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/SpeechDelegate;->speechListeners:Ljava/util/HashSet;

    invoke-virtual {v0, p1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 190
    return-void
.end method

.method public getSpeechInput(Ljava/lang/Class;)V
    .locals 1
    .param p1, "clazz"    # Ljava/lang/Class;

    .prologue
    .line 124
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    invoke-virtual {p0, p1, v0}, Lcom/comcast/cim/android/accessibility/SpeechDelegate;->getSpeechInput(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 125
    return-void
.end method

.method public getSpeechInput(Ljava/lang/Class;Landroid/os/Bundle;)V
    .locals 1
    .param p1, "clazz"    # Ljava/lang/Class;
    .param p2, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 129
    iget-boolean v0, p0, Lcom/comcast/cim/android/accessibility/SpeechDelegate;->isTriggered:Z

    if-nez v0, :cond_0

    .line 130
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/comcast/cim/android/accessibility/SpeechDelegate;->isTriggered:Z

    .line 131
    invoke-virtual {p0, p1, p2}, Lcom/comcast/cim/android/accessibility/SpeechDelegate;->getSpeechInputHandMade(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 133
    :cond_0
    return-void
.end method

.method protected getSpeechInputHandMade(Ljava/lang/Class;Landroid/os/Bundle;)V
    .locals 4
    .param p1, "clazz"    # Ljava/lang/Class;
    .param p2, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 137
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/comcast/cim/android/accessibility/SpeechDelegate;->activity:Landroid/app/Activity;

    invoke-direct {v0, v1, p1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 139
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "android.speech.extra.PROMPT"

    iget-object v2, p0, Lcom/comcast/cim/android/accessibility/SpeechDelegate;->activity:Landroid/app/Activity;

    sget v3, Lcom/comcast/cim/android/R$string;->speech_dialog_caption_default:I

    invoke-virtual {v2, v3}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p2, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 140
    invoke-virtual {v0, p2}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 141
    iget-object v1, p0, Lcom/comcast/cim/android/accessibility/SpeechDelegate;->activity:Landroid/app/Activity;

    const/16 v2, 0x2711

    invoke-virtual {v1, v0, v2}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 142
    return-void
.end method

.method public onActivityResult(IILandroid/content/Intent;)Z
    .locals 2
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    const/16 v1, 0x2711

    const/4 v0, 0x0

    .line 36
    if-ne p1, v1, :cond_0

    .line 37
    iput-boolean v0, p0, Lcom/comcast/cim/android/accessibility/SpeechDelegate;->isTriggered:Z

    .line 40
    :cond_0
    if-ne p1, v1, :cond_1

    const/4 v1, -0x1

    if-ne p2, v1, :cond_1

    .line 41
    const-string v0, "KEY_ACTION"

    invoke-virtual {p3, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "KEY_TERMS"

    invoke-virtual {p3, v1}, Landroid/content/Intent;->getStringArrayExtra(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/comcast/cim/android/accessibility/SpeechDelegate;->onSpeechResponse(Ljava/lang/String;[Ljava/lang/String;)Z

    .line 42
    const/4 v0, 0x1

    .line 45
    :cond_1
    return v0
.end method

.method public removeSpeechListener(Lcom/comcast/cim/android/accessibility/SpeechListener;)V
    .locals 1
    .param p1, "speechListener"    # Lcom/comcast/cim/android/accessibility/SpeechListener;

    .prologue
    .line 193
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/SpeechDelegate;->speechListeners:Ljava/util/HashSet;

    invoke-virtual {v0, p1}, Ljava/util/HashSet;->remove(Ljava/lang/Object;)Z

    .line 194
    return-void
.end method

.method public startSearch(Ljava/lang/Class;[Ljava/lang/String;)V
    .locals 3
    .param p1, "searchClass"    # Ljava/lang/Class;
    .param p2, "searchTerms"    # [Ljava/lang/String;

    .prologue
    .line 197
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/comcast/cim/android/accessibility/SpeechDelegate;->activity:Landroid/app/Activity;

    invoke-direct {v0, v1, p1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 198
    .local v0, "searchIntent":Landroid/content/Intent;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/comcast/cim/android/accessibility/SpeechActions;->SEARCH:Lcom/comcast/cim/android/accessibility/SpeechActions;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 199
    const-string v1, "KEY_TERMS"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/Intent;

    .line 200
    iget-object v1, p0, Lcom/comcast/cim/android/accessibility/SpeechDelegate;->activity:Landroid/app/Activity;

    invoke-virtual {v1, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 201
    return-void
.end method

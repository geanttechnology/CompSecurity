.class public Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsActivity;
.super Lcom/xfinity/playerlib/view/networkcollections/NetworkActivity;
.source "NetworkProgramsActivity.java"

# interfaces
.implements Lcom/comcast/cim/android/view/flow/FilterRequestObserver;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/networkcollections/NetworkActivity;-><init>()V

    return-void
.end method


# virtual methods
.method protected getLayoutId()I
    .locals 1

    .prologue
    .line 22
    sget v0, Lcom/xfinity/playerlib/R$layout;->flyin_network_programs:I

    return v0
.end method

.method protected getSpeechRecognizerClass()Ljava/lang/Class;
    .locals 1

    .prologue
    .line 27
    const-class v0, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;

    return-object v0
.end method

.method public onSpeechSwipe()V
    .locals 4

    .prologue
    .line 33
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    .line 34
    .local v1, "intent":Landroid/content/Intent;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 36
    .local v0, "bundle":Landroid/os/Bundle;
    if-eqz v1, :cond_0

    .line 37
    invoke-virtual {v1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 40
    :cond_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsActivity;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v2

    invoke-interface {v2}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->stopSpeaking()V

    .line 41
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsActivity;->getSpeechDelegate()Lcom/comcast/cim/android/accessibility/SpeechDelegate;

    move-result-object v2

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsActivity;->getSpeechRecognizerClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v2, v3, v0}, Lcom/comcast/cim/android/accessibility/SpeechDelegate;->getSpeechInput(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 42
    return-void
.end method

.method public showFilter(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "filterBundle"    # Landroid/os/Bundle;

    .prologue
    .line 15
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFilterDialog;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 16
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {v0, p1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 17
    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 18
    return-void
.end method

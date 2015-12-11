.class public Lcom/comcast/cim/android/accessibility/SpeechRecognizerFragment;
.super Landroid/app/Fragment;
.source "SpeechRecognizerFragment.java"


# static fields
.field private static TALKBACKMODE_ON:Z


# instance fields
.field private caption:Landroid/widget/TextView;

.field private speechRecognizer:Lcom/comcast/cim/android/accessibility/SpeechRecognizer;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 18
    const/4 v0, 0x1

    sput-boolean v0, Lcom/comcast/cim/android/accessibility/SpeechRecognizerFragment;->TALKBACKMODE_ON:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    return-void
.end method


# virtual methods
.method public onAttach(Landroid/app/Activity;)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 41
    invoke-super {p0, p1}, Landroid/app/Fragment;->onAttach(Landroid/app/Activity;)V

    .line 43
    invoke-virtual {p0}, Lcom/comcast/cim/android/accessibility/SpeechRecognizerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;

    iput-object v0, p0, Lcom/comcast/cim/android/accessibility/SpeechRecognizerFragment;->speechRecognizer:Lcom/comcast/cim/android/accessibility/SpeechRecognizer;

    .line 44
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 22
    iget-object v3, p0, Lcom/comcast/cim/android/accessibility/SpeechRecognizerFragment;->speechRecognizer:Lcom/comcast/cim/android/accessibility/SpeechRecognizer;

    invoke-virtual {v3}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->getIntent()Landroid/content/Intent;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 24
    .local v0, "bundle":Landroid/os/Bundle;
    const-string v3, "android.speech.extra.PROMPT"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 26
    .local v2, "prompt":Ljava/lang/String;
    sget v3, Lcom/comcast/cim/android/R$layout;->speech_recognizer:I

    const/4 v4, 0x0

    invoke-virtual {p1, v3, p2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/view/ViewGroup;

    .line 28
    .local v1, "layout":Landroid/view/ViewGroup;
    sget v3, Lcom/comcast/cim/android/R$id;->caption:I

    invoke-virtual {v1, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    iput-object v3, p0, Lcom/comcast/cim/android/accessibility/SpeechRecognizerFragment;->caption:Landroid/widget/TextView;

    .line 31
    iget-object v3, p0, Lcom/comcast/cim/android/accessibility/SpeechRecognizerFragment;->caption:Landroid/widget/TextView;

    invoke-virtual {v3, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 36
    return-object v1
.end method

.method public onStart()V
    .locals 1

    .prologue
    .line 49
    invoke-super {p0}, Landroid/app/Fragment;->onStart()V

    .line 51
    sget-boolean v0, Lcom/comcast/cim/android/accessibility/SpeechRecognizerFragment;->TALKBACKMODE_ON:Z

    if-eqz v0, :cond_0

    .line 52
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/SpeechRecognizerFragment;->speechRecognizer:Lcom/comcast/cim/android/accessibility/SpeechRecognizer;

    invoke-virtual {v0}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->talk()V

    .line 56
    :goto_0
    return-void

    .line 54
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/SpeechRecognizerFragment;->speechRecognizer:Lcom/comcast/cim/android/accessibility/SpeechRecognizer;

    invoke-virtual {v0}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->listen()V

    goto :goto_0
.end method

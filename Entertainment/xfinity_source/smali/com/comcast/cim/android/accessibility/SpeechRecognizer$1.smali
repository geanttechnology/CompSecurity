.class Lcom/comcast/cim/android/accessibility/SpeechRecognizer$1;
.super Landroid/os/Handler;
.source "SpeechRecognizer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/android/accessibility/SpeechRecognizer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/android/accessibility/SpeechRecognizer;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/accessibility/SpeechRecognizer;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/android/accessibility/SpeechRecognizer;

    .prologue
    .line 35
    iput-object p1, p0, Lcom/comcast/cim/android/accessibility/SpeechRecognizer$1;->this$0:Lcom/comcast/cim/android/accessibility/SpeechRecognizer;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 3
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 40
    iget v0, p1, Landroid/os/Message;->what:I

    const/16 v1, 0x8

    if-ne v0, v1, :cond_0

    .line 41
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/SpeechRecognizer$1;->this$0:Lcom/comcast/cim/android/accessibility/SpeechRecognizer;

    invoke-virtual {v0}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/android/accessibility/SpeechRecognizer$1;->this$0:Lcom/comcast/cim/android/accessibility/SpeechRecognizer;

    sget v2, Lcom/comcast/cim/android/R$string;->speech_dialog_timeout:I

    invoke-virtual {v1, v2}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speak(Ljava/lang/String;)V

    .line 42
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/SpeechRecognizer$1;->this$0:Lcom/comcast/cim/android/accessibility/SpeechRecognizer;

    invoke-virtual {v0}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->finish()V

    .line 49
    :goto_0
    return-void

    .line 43
    :cond_0
    iget v0, p1, Landroid/os/Message;->what:I

    const/16 v1, 0x9

    if-ne v0, v1, :cond_1

    .line 44
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/SpeechRecognizer$1;->this$0:Lcom/comcast/cim/android/accessibility/SpeechRecognizer;

    invoke-virtual {v0}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/android/accessibility/SpeechRecognizer$1;->this$0:Lcom/comcast/cim/android/accessibility/SpeechRecognizer;

    sget v2, Lcom/comcast/cim/android/R$string;->speech_dialog_timeout_service_unavail:I

    invoke-virtual {v1, v2}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speak(Ljava/lang/String;)V

    .line 45
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/SpeechRecognizer$1;->this$0:Lcom/comcast/cim/android/accessibility/SpeechRecognizer;

    invoke-virtual {v0}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->finish()V

    goto :goto_0

    .line 47
    :cond_1
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    goto :goto_0
.end method

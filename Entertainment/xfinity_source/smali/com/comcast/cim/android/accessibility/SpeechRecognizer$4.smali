.class Lcom/comcast/cim/android/accessibility/SpeechRecognizer$4;
.super Landroid/speech/tts/UtteranceProgressListener;
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
    .line 178
    iput-object p1, p0, Lcom/comcast/cim/android/accessibility/SpeechRecognizer$4;->this$0:Lcom/comcast/cim/android/accessibility/SpeechRecognizer;

    invoke-direct {p0}, Landroid/speech/tts/UtteranceProgressListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onDone(Ljava/lang/String;)V
    .locals 2
    .param p1, "s"    # Ljava/lang/String;

    .prologue
    .line 186
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$UtteranceID;->FOLLOWUP_WITH_LISTEN:Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$UtteranceID;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 187
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/SpeechRecognizer$4;->this$0:Lcom/comcast/cim/android/accessibility/SpeechRecognizer;

    invoke-virtual {v0}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->listen()V

    .line 189
    :cond_0
    return-void
.end method

.method public onError(Ljava/lang/String;)V
    .locals 0
    .param p1, "s"    # Ljava/lang/String;

    .prologue
    .line 193
    return-void
.end method

.method public onStart(Ljava/lang/String;)V
    .locals 0
    .param p1, "s"    # Ljava/lang/String;

    .prologue
    .line 181
    return-void
.end method

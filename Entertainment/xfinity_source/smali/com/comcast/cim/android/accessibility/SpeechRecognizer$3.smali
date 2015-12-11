.class Lcom/comcast/cim/android/accessibility/SpeechRecognizer$3;
.super Ljava/lang/Object;
.source "SpeechRecognizer.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->talk()V
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
    .line 170
    iput-object p1, p0, Lcom/comcast/cim/android/accessibility/SpeechRecognizer$3;->this$0:Lcom/comcast/cim/android/accessibility/SpeechRecognizer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 173
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/SpeechRecognizer$3;->this$0:Lcom/comcast/cim/android/accessibility/SpeechRecognizer;

    invoke-virtual {v0}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/android/accessibility/SpeechRecognizer$3;->this$0:Lcom/comcast/cim/android/accessibility/SpeechRecognizer;

    # getter for: Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->prompt:Ljava/lang/String;
    invoke-static {v1}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->access$000(Lcom/comcast/cim/android/accessibility/SpeechRecognizer;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speakThenListen(Ljava/lang/String;)V

    .line 174
    return-void
.end method

.class Lcom/comcast/cim/android/accessibility/SpeechRecognizer$5;
.super Ljava/lang/Object;
.source "SpeechRecognizer.java"

# interfaces
.implements Lcom/comcast/cim/android/view/common/OrientationStrategy;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->getOrientationStrategy()Lcom/comcast/cim/android/view/common/OrientationStrategy;
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
    .line 373
    iput-object p1, p0, Lcom/comcast/cim/android/accessibility/SpeechRecognizer$5;->this$0:Lcom/comcast/cim/android/accessibility/SpeechRecognizer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAppropriateOrientation()I
    .locals 1

    .prologue
    .line 376
    const/4 v0, -0x1

    return v0
.end method

.class Lcom/comcast/cim/android/accessibility/AccessibleTalkDelegate$SpeakDelayRunnable;
.super Ljava/lang/Object;
.source "AccessibleTalkDelegate.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/android/accessibility/AccessibleTalkDelegate;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SpeakDelayRunnable"
.end annotation


# instance fields
.field final sayWhat:Ljava/lang/String;

.field final synthetic this$0:Lcom/comcast/cim/android/accessibility/AccessibleTalkDelegate;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/android/accessibility/AccessibleTalkDelegate;Ljava/lang/String;)V
    .locals 0
    .param p2, "saywhat"    # Ljava/lang/String;

    .prologue
    .line 55
    iput-object p1, p0, Lcom/comcast/cim/android/accessibility/AccessibleTalkDelegate$SpeakDelayRunnable;->this$0:Lcom/comcast/cim/android/accessibility/AccessibleTalkDelegate;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 56
    iput-object p2, p0, Lcom/comcast/cim/android/accessibility/AccessibleTalkDelegate$SpeakDelayRunnable;->sayWhat:Ljava/lang/String;

    .line 57
    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 61
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/AccessibleTalkDelegate$SpeakDelayRunnable;->this$0:Lcom/comcast/cim/android/accessibility/AccessibleTalkDelegate;

    iget-object v1, p0, Lcom/comcast/cim/android/accessibility/AccessibleTalkDelegate$SpeakDelayRunnable;->sayWhat:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/comcast/cim/android/accessibility/AccessibleTalkDelegate;->speakNow(Ljava/lang/String;)V

    .line 62
    return-void
.end method

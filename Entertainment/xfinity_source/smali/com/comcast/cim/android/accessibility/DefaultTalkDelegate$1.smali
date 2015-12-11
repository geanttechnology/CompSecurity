.class Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$1;
.super Landroid/os/Handler;
.source "DefaultTalkDelegate.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;

    .prologue
    .line 33
    iput-object p1, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$1;->this$0:Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 6
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 38
    iget v0, p1, Landroid/os/Message;->what:I

    sget v1, Lcom/comcast/cim/android/R$id;->ACCESSIBILITY_ANNOUNCE_LOADED:I

    if-ne v0, v1, :cond_0

    .line 39
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$1;->this$0:Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;

    iget-object v1, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$1;->this$0:Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;

    iget-object v1, v1, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->context:Landroid/app/Activity;

    sget v2, Lcom/comcast/cim/android/R$string;->speech_loaded_x:I

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$1;->this$0:Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;

    # getter for: Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->spokenTitle:Ljava/lang/String;
    invoke-static {v5}, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->access$000(Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v1, v2, v3}, Landroid/app/Activity;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->speak(Ljava/lang/String;)V

    .line 47
    :goto_0
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 48
    return-void

    .line 43
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$1;->this$0:Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;

    iget v1, p1, Landroid/os/Message;->what:I

    invoke-virtual {v0, v1}, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->speak(I)V

    .line 44
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate$1;->this$0:Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;

    iget-object v0, v0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;->handler:Landroid/os/Handler;

    iget v1, p1, Landroid/os/Message;->what:I

    const-wide/16 v2, 0x1388

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->sendEmptyMessageDelayed(IJ)Z

    goto :goto_0
.end method

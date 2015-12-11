.class public Lcom/comcast/cim/android/view/common/BaseActivity$ActivitySpeechListener;
.super Lcom/comcast/cim/android/accessibility/DefaultSpeechListener;
.source "BaseActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/android/view/common/BaseActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "ActivitySpeechListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/android/view/common/BaseActivity;


# direct methods
.method protected constructor <init>(Lcom/comcast/cim/android/view/common/BaseActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/android/view/common/BaseActivity;

    .prologue
    .line 187
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/BaseActivity$ActivitySpeechListener;->this$0:Lcom/comcast/cim/android/view/common/BaseActivity;

    invoke-direct {p0}, Lcom/comcast/cim/android/accessibility/DefaultSpeechListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onSpeechResponseCancel()Z
    .locals 1

    .prologue
    .line 209
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivity$ActivitySpeechListener;->this$0:Lcom/comcast/cim/android/view/common/BaseActivity;

    invoke-virtual {v0}, Lcom/comcast/cim/android/view/common/BaseActivity;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->stopSpeaking()V

    .line 210
    const/4 v0, 0x1

    return v0
.end method

.method public onSpeechResponseClose()Z
    .locals 1

    .prologue
    .line 191
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivity$ActivitySpeechListener;->this$0:Lcom/comcast/cim/android/view/common/BaseActivity;

    invoke-virtual {v0}, Lcom/comcast/cim/android/view/common/BaseActivity;->finish()V

    .line 192
    const/4 v0, 0x1

    return v0
.end method

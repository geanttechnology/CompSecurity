.class Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad$1;
.super Ljava/lang/Object;
.source "NumericKeypad.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad;->init(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad;


# direct methods
.method constructor <init>(Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad;)V
    .locals 0

    .prologue
    .line 42
    iput-object p1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad$1;->this$0:Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 44
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad$1;->this$0:Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad;

    # getter for: Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad;->keyPressedListener:Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad$KeyPressedListener;
    invoke-static {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad;->access$000(Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad;)Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad$KeyPressedListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 45
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad$1;->this$0:Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad;

    # getter for: Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad;->keyPressedListener:Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad$KeyPressedListener;
    invoke-static {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad;->access$000(Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad;)Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad$KeyPressedListener;

    move-result-object v1

    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_0
    invoke-interface {v1, v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/NumericKeypad$KeyPressedListener;->onKeyPressed(Ljava/lang/String;)V

    .line 47
    :cond_0
    return-void

    .line 45
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.class Lco/vine/android/widget/TypingEditText$TypingTextWatcher;
.super Ljava/lang/Object;
.source "TypingEditText.java"

# interfaces
.implements Landroid/text/TextWatcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/widget/TypingEditText;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "TypingTextWatcher"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/widget/TypingEditText;


# direct methods
.method private constructor <init>(Lco/vine/android/widget/TypingEditText;)V
    .locals 0

    .prologue
    .line 65
    iput-object p1, p0, Lco/vine/android/widget/TypingEditText$TypingTextWatcher;->this$0:Lco/vine/android/widget/TypingEditText;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lco/vine/android/widget/TypingEditText;Lco/vine/android/widget/TypingEditText$1;)V
    .locals 0
    .param p1, "x0"    # Lco/vine/android/widget/TypingEditText;
    .param p2, "x1"    # Lco/vine/android/widget/TypingEditText$1;

    .prologue
    .line 65
    invoke-direct {p0, p1}, Lco/vine/android/widget/TypingEditText$TypingTextWatcher;-><init>(Lco/vine/android/widget/TypingEditText;)V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 0
    .param p1, "s"    # Landroid/text/Editable;

    .prologue
    .line 81
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "count"    # I
    .param p4, "after"    # I

    .prologue
    .line 69
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 4
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "before"    # I
    .param p4, "count"    # I

    .prologue
    const/4 v2, 0x1

    .line 73
    iget-object v0, p0, Lco/vine/android/widget/TypingEditText$TypingTextWatcher;->this$0:Lco/vine/android/widget/TypingEditText;

    # getter for: Lco/vine/android/widget/TypingEditText;->mHandler:Landroid/os/Handler;
    invoke-static {v0}, Lco/vine/android/widget/TypingEditText;->access$100(Lco/vine/android/widget/TypingEditText;)Landroid/os/Handler;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 74
    iget-object v0, p0, Lco/vine/android/widget/TypingEditText$TypingTextWatcher;->this$0:Lco/vine/android/widget/TypingEditText;

    # getter for: Lco/vine/android/widget/TypingEditText;->mHandler:Landroid/os/Handler;
    invoke-static {v0}, Lco/vine/android/widget/TypingEditText;->access$100(Lco/vine/android/widget/TypingEditText;)Landroid/os/Handler;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/os/Handler;->removeMessages(I)V

    .line 75
    iget-object v0, p0, Lco/vine/android/widget/TypingEditText$TypingTextWatcher;->this$0:Lco/vine/android/widget/TypingEditText;

    # getter for: Lco/vine/android/widget/TypingEditText;->mHandler:Landroid/os/Handler;
    invoke-static {v0}, Lco/vine/android/widget/TypingEditText;->access$100(Lco/vine/android/widget/TypingEditText;)Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/widget/TypingEditText$TypingTextWatcher;->this$0:Lco/vine/android/widget/TypingEditText;

    # getter for: Lco/vine/android/widget/TypingEditText;->mHandler:Landroid/os/Handler;
    invoke-static {v1}, Lco/vine/android/widget/TypingEditText;->access$100(Lco/vine/android/widget/TypingEditText;)Landroid/os/Handler;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/widget/TypingEditText$TypingTextWatcher;->this$0:Lco/vine/android/widget/TypingEditText;

    # getter for: Lco/vine/android/widget/TypingEditText;->mTimeout:J
    invoke-static {v2}, Lco/vine/android/widget/TypingEditText;->access$200(Lco/vine/android/widget/TypingEditText;)J

    move-result-wide v2

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z

    .line 77
    :cond_0
    return-void
.end method

.class Lcom/livemixtapes/SignUp$7;
.super Ljava/lang/Object;
.source "SignUp.java"

# interfaces
.implements Landroid/view/View$OnFocusChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/SignUp;->setListeners()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/SignUp;


# direct methods
.method constructor <init>(Lcom/livemixtapes/SignUp;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/SignUp$7;->this$0:Lcom/livemixtapes/SignUp;

    .line 244
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFocusChange(Landroid/view/View;Z)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;
    .param p2, "hasFocus"    # Z

    .prologue
    .line 247
    if-nez p2, :cond_0

    .line 248
    iget-object v0, p0, Lcom/livemixtapes/SignUp$7;->this$0:Lcom/livemixtapes/SignUp;

    # invokes: Lcom/livemixtapes/SignUp;->hideKeyboard(Landroid/view/View;)V
    invoke-static {v0, p1}, Lcom/livemixtapes/SignUp;->access$7(Lcom/livemixtapes/SignUp;Landroid/view/View;)V

    .line 250
    :cond_0
    return-void
.end method

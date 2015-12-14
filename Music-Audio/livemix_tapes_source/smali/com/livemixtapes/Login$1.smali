.class Lcom/livemixtapes/Login$1;
.super Ljava/lang/Object;
.source "Login.java"

# interfaces
.implements Landroid/view/View$OnFocusChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/Login;->setListeners()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/Login;


# direct methods
.method constructor <init>(Lcom/livemixtapes/Login;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/Login$1;->this$0:Lcom/livemixtapes/Login;

    .line 99
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFocusChange(Landroid/view/View;Z)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;
    .param p2, "hasFocus"    # Z

    .prologue
    .line 102
    if-eqz p2, :cond_0

    .line 103
    iget-object v0, p0, Lcom/livemixtapes/Login$1;->this$0:Lcom/livemixtapes/Login;

    # invokes: Lcom/livemixtapes/Login;->hideKeyboards()V
    invoke-static {v0}, Lcom/livemixtapes/Login;->access$0(Lcom/livemixtapes/Login;)V

    .line 105
    :cond_0
    return-void
.end method

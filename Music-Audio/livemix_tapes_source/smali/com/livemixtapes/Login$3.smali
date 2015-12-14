.class Lcom/livemixtapes/Login$3;
.super Ljava/lang/Object;
.source "Login.java"

# interfaces
.implements Landroid/widget/TextView$OnEditorActionListener;


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
    iput-object p1, p0, Lcom/livemixtapes/Login$3;->this$0:Lcom/livemixtapes/Login;

    .line 119
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onEditorAction(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "v"    # Landroid/widget/TextView;
    .param p2, "actionId"    # I
    .param p3, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 123
    const/4 v0, 0x2

    if-eq p2, v0, :cond_0

    .line 124
    if-nez p2, :cond_1

    .line 125
    :cond_0
    iget-object v0, p0, Lcom/livemixtapes/Login$3;->this$0:Lcom/livemixtapes/Login;

    # getter for: Lcom/livemixtapes/Login;->loginBtn:Landroid/widget/FrameLayout;
    invoke-static {v0}, Lcom/livemixtapes/Login;->access$2(Lcom/livemixtapes/Login;)Landroid/widget/FrameLayout;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/FrameLayout;->performClick()Z

    .line 126
    const/4 v0, 0x1

    .line 129
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

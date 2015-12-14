.class Lcom/livemixtapes/SignUp$3;
.super Ljava/lang/Object;
.source "SignUp.java"

# interfaces
.implements Landroid/view/View$OnFocusChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/SignUp;->setBoxBehavior(Landroid/widget/EditText;Landroid/widget/ImageButton;)V
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
    iput-object p1, p0, Lcom/livemixtapes/SignUp$3;->this$0:Lcom/livemixtapes/SignUp;

    .line 186
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFocusChange(Landroid/view/View;Z)V
    .locals 0
    .param p1, "v"    # Landroid/view/View;
    .param p2, "hasFocus"    # Z

    .prologue
    .line 192
    return-void
.end method

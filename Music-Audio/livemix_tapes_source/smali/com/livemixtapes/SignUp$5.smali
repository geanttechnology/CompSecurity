.class Lcom/livemixtapes/SignUp$5;
.super Ljava/lang/Object;
.source "SignUp.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


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

.field private final synthetic val$box_text:Landroid/widget/EditText;


# direct methods
.method constructor <init>(Lcom/livemixtapes/SignUp;Landroid/widget/EditText;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/SignUp$5;->this$0:Lcom/livemixtapes/SignUp;

    iput-object p2, p0, Lcom/livemixtapes/SignUp$5;->val$box_text:Landroid/widget/EditText;

    .line 220
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 223
    iget-object v0, p0, Lcom/livemixtapes/SignUp$5;->val$box_text:Landroid/widget/EditText;

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 224
    iget-object v0, p0, Lcom/livemixtapes/SignUp$5;->val$box_text:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->requestFocus()Z

    .line 225
    return-void
.end method

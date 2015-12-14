.class Lcom/livemixtapes/SignUp$4;
.super Ljava/lang/Object;
.source "SignUp.java"

# interfaces
.implements Landroid/text/TextWatcher;


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

.field private final synthetic val$box_clear:Landroid/widget/ImageButton;

.field private final synthetic val$box_text:Landroid/widget/EditText;


# direct methods
.method constructor <init>(Lcom/livemixtapes/SignUp;Landroid/widget/EditText;Landroid/widget/ImageButton;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/SignUp$4;->this$0:Lcom/livemixtapes/SignUp;

    iput-object p2, p0, Lcom/livemixtapes/SignUp$4;->val$box_text:Landroid/widget/EditText;

    iput-object p3, p0, Lcom/livemixtapes/SignUp$4;->val$box_clear:Landroid/widget/ImageButton;

    .line 198
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 2
    .param p1, "s"    # Landroid/text/Editable;

    .prologue
    .line 201
    iget-object v0, p0, Lcom/livemixtapes/SignUp$4;->val$box_text:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 202
    iget-object v0, p0, Lcom/livemixtapes/SignUp$4;->val$box_clear:Landroid/widget/ImageButton;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 207
    :goto_0
    return-void

    .line 205
    :cond_0
    iget-object v0, p0, Lcom/livemixtapes/SignUp$4;->val$box_clear:Landroid/widget/ImageButton;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setVisibility(I)V

    goto :goto_0
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "count"    # I
    .param p4, "after"    # I

    .prologue
    .line 211
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "before"    # I
    .param p4, "count"    # I

    .prologue
    .line 215
    return-void
.end method

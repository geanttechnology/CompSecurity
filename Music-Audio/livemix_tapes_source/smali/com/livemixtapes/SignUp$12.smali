.class Lcom/livemixtapes/SignUp$12;
.super Ljava/lang/Object;
.source "SignUp.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


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
    iput-object p1, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    .line 339
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 15
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 342
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # invokes: Lcom/livemixtapes/SignUp;->hideKeyboards()V
    invoke-static {v11}, Lcom/livemixtapes/SignUp;->access$6(Lcom/livemixtapes/SignUp;)V

    .line 351
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->username:Landroid/widget/EditText;
    invoke-static {v11}, Lcom/livemixtapes/SignUp;->access$8(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v11

    invoke-virtual {v11}, Landroid/widget/EditText;->length()I

    move-result v11

    if-nez v11, :cond_0

    .line 352
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    iget-object v12, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->usernameBox:Landroid/widget/LinearLayout;
    invoke-static {v12}, Lcom/livemixtapes/SignUp;->access$12(Lcom/livemixtapes/SignUp;)Landroid/widget/LinearLayout;

    move-result-object v12

    # invokes: Lcom/livemixtapes/SignUp;->shake(Landroid/view/View;)V
    invoke-static {v11, v12}, Lcom/livemixtapes/SignUp;->access$13(Lcom/livemixtapes/SignUp;Landroid/view/View;)V

    .line 353
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->username:Landroid/widget/EditText;
    invoke-static {v11}, Lcom/livemixtapes/SignUp;->access$8(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v11

    invoke-virtual {v11}, Landroid/widget/EditText;->requestFocus()Z

    .line 439
    :goto_0
    return-void

    .line 356
    :cond_0
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_email:Landroid/widget/EditText;
    invoke-static {v11}, Lcom/livemixtapes/SignUp;->access$14(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v11

    invoke-virtual {v11}, Landroid/widget/EditText;->length()I

    move-result v11

    if-nez v11, :cond_1

    .line 357
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    iget-object v12, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_emailbox:Landroid/widget/LinearLayout;
    invoke-static {v12}, Lcom/livemixtapes/SignUp;->access$15(Lcom/livemixtapes/SignUp;)Landroid/widget/LinearLayout;

    move-result-object v12

    # invokes: Lcom/livemixtapes/SignUp;->shake(Landroid/view/View;)V
    invoke-static {v11, v12}, Lcom/livemixtapes/SignUp;->access$13(Lcom/livemixtapes/SignUp;Landroid/view/View;)V

    .line 358
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_email:Landroid/widget/EditText;
    invoke-static {v11}, Lcom/livemixtapes/SignUp;->access$14(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v11

    invoke-virtual {v11}, Landroid/widget/EditText;->requestFocus()Z

    goto :goto_0

    .line 360
    :cond_1
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_confirmemail:Landroid/widget/EditText;
    invoke-static {v11}, Lcom/livemixtapes/SignUp;->access$16(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v11

    invoke-virtual {v11}, Landroid/widget/EditText;->length()I

    move-result v11

    if-nez v11, :cond_2

    .line 361
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    iget-object v12, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_confirmemailbox:Landroid/widget/LinearLayout;
    invoke-static {v12}, Lcom/livemixtapes/SignUp;->access$17(Lcom/livemixtapes/SignUp;)Landroid/widget/LinearLayout;

    move-result-object v12

    # invokes: Lcom/livemixtapes/SignUp;->shake(Landroid/view/View;)V
    invoke-static {v11, v12}, Lcom/livemixtapes/SignUp;->access$13(Lcom/livemixtapes/SignUp;Landroid/view/View;)V

    .line 362
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_confirmemail:Landroid/widget/EditText;
    invoke-static {v11}, Lcom/livemixtapes/SignUp;->access$16(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v11

    invoke-virtual {v11}, Landroid/widget/EditText;->requestFocus()Z

    goto :goto_0

    .line 364
    :cond_2
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->password:Landroid/widget/EditText;
    invoke-static {v11}, Lcom/livemixtapes/SignUp;->access$10(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v11

    invoke-virtual {v11}, Landroid/widget/EditText;->length()I

    move-result v11

    if-nez v11, :cond_3

    .line 365
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    iget-object v12, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->passwordBox:Landroid/widget/LinearLayout;
    invoke-static {v12}, Lcom/livemixtapes/SignUp;->access$18(Lcom/livemixtapes/SignUp;)Landroid/widget/LinearLayout;

    move-result-object v12

    # invokes: Lcom/livemixtapes/SignUp;->shake(Landroid/view/View;)V
    invoke-static {v11, v12}, Lcom/livemixtapes/SignUp;->access$13(Lcom/livemixtapes/SignUp;Landroid/view/View;)V

    .line 366
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->password:Landroid/widget/EditText;
    invoke-static {v11}, Lcom/livemixtapes/SignUp;->access$10(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v11

    invoke-virtual {v11}, Landroid/widget/EditText;->requestFocus()Z

    goto :goto_0

    .line 368
    :cond_3
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_password:Landroid/widget/EditText;
    invoke-static {v11}, Lcom/livemixtapes/SignUp;->access$19(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v11

    invoke-virtual {v11}, Landroid/widget/EditText;->length()I

    move-result v11

    if-nez v11, :cond_4

    .line 369
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    iget-object v12, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_passwordbox:Landroid/widget/LinearLayout;
    invoke-static {v12}, Lcom/livemixtapes/SignUp;->access$20(Lcom/livemixtapes/SignUp;)Landroid/widget/LinearLayout;

    move-result-object v12

    # invokes: Lcom/livemixtapes/SignUp;->shake(Landroid/view/View;)V
    invoke-static {v11, v12}, Lcom/livemixtapes/SignUp;->access$13(Lcom/livemixtapes/SignUp;Landroid/view/View;)V

    .line 370
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_password:Landroid/widget/EditText;
    invoke-static {v11}, Lcom/livemixtapes/SignUp;->access$19(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v11

    invoke-virtual {v11}, Landroid/widget/EditText;->requestFocus()Z

    goto/16 :goto_0

    .line 372
    :cond_4
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_confirmpassword:Landroid/widget/EditText;
    invoke-static {v11}, Lcom/livemixtapes/SignUp;->access$21(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v11

    invoke-virtual {v11}, Landroid/widget/EditText;->length()I

    move-result v11

    if-nez v11, :cond_5

    .line 373
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    iget-object v12, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_confirmpasswordbox:Landroid/widget/LinearLayout;
    invoke-static {v12}, Lcom/livemixtapes/SignUp;->access$22(Lcom/livemixtapes/SignUp;)Landroid/widget/LinearLayout;

    move-result-object v12

    # invokes: Lcom/livemixtapes/SignUp;->shake(Landroid/view/View;)V
    invoke-static {v11, v12}, Lcom/livemixtapes/SignUp;->access$13(Lcom/livemixtapes/SignUp;Landroid/view/View;)V

    .line 374
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_confirmpassword:Landroid/widget/EditText;
    invoke-static {v11}, Lcom/livemixtapes/SignUp;->access$21(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v11

    invoke-virtual {v11}, Landroid/widget/EditText;->requestFocus()Z

    goto/16 :goto_0

    .line 376
    :cond_5
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_firstname:Landroid/widget/EditText;
    invoke-static {v11}, Lcom/livemixtapes/SignUp;->access$23(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v11

    invoke-virtual {v11}, Landroid/widget/EditText;->length()I

    move-result v11

    if-nez v11, :cond_6

    .line 377
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    iget-object v12, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_firstnamebox:Landroid/widget/LinearLayout;
    invoke-static {v12}, Lcom/livemixtapes/SignUp;->access$24(Lcom/livemixtapes/SignUp;)Landroid/widget/LinearLayout;

    move-result-object v12

    # invokes: Lcom/livemixtapes/SignUp;->shake(Landroid/view/View;)V
    invoke-static {v11, v12}, Lcom/livemixtapes/SignUp;->access$13(Lcom/livemixtapes/SignUp;Landroid/view/View;)V

    .line 378
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_firstname:Landroid/widget/EditText;
    invoke-static {v11}, Lcom/livemixtapes/SignUp;->access$23(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v11

    invoke-virtual {v11}, Landroid/widget/EditText;->requestFocus()Z

    goto/16 :goto_0

    .line 380
    :cond_6
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_lastname:Landroid/widget/EditText;
    invoke-static {v11}, Lcom/livemixtapes/SignUp;->access$25(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v11

    invoke-virtual {v11}, Landroid/widget/EditText;->length()I

    move-result v11

    if-nez v11, :cond_7

    .line 381
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    iget-object v12, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_lastnamebox:Landroid/widget/LinearLayout;
    invoke-static {v12}, Lcom/livemixtapes/SignUp;->access$26(Lcom/livemixtapes/SignUp;)Landroid/widget/LinearLayout;

    move-result-object v12

    # invokes: Lcom/livemixtapes/SignUp;->shake(Landroid/view/View;)V
    invoke-static {v11, v12}, Lcom/livemixtapes/SignUp;->access$13(Lcom/livemixtapes/SignUp;Landroid/view/View;)V

    .line 382
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_lastname:Landroid/widget/EditText;
    invoke-static {v11}, Lcom/livemixtapes/SignUp;->access$25(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v11

    invoke-virtual {v11}, Landroid/widget/EditText;->requestFocus()Z

    goto/16 :goto_0

    .line 384
    :cond_7
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_postalcode:Landroid/widget/EditText;
    invoke-static {v11}, Lcom/livemixtapes/SignUp;->access$27(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v11

    invoke-virtual {v11}, Landroid/widget/EditText;->length()I

    move-result v11

    if-nez v11, :cond_8

    .line 385
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    iget-object v12, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_postalcodebox:Landroid/widget/LinearLayout;
    invoke-static {v12}, Lcom/livemixtapes/SignUp;->access$28(Lcom/livemixtapes/SignUp;)Landroid/widget/LinearLayout;

    move-result-object v12

    # invokes: Lcom/livemixtapes/SignUp;->shake(Landroid/view/View;)V
    invoke-static {v11, v12}, Lcom/livemixtapes/SignUp;->access$13(Lcom/livemixtapes/SignUp;Landroid/view/View;)V

    .line 386
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_postalcode:Landroid/widget/EditText;
    invoke-static {v11}, Lcom/livemixtapes/SignUp;->access$27(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v11

    invoke-virtual {v11}, Landroid/widget/EditText;->requestFocus()Z

    goto/16 :goto_0

    .line 388
    :cond_8
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->genderMale:Landroid/widget/RadioButton;
    invoke-static {v11}, Lcom/livemixtapes/SignUp;->access$29(Lcom/livemixtapes/SignUp;)Landroid/widget/RadioButton;

    move-result-object v11

    invoke-virtual {v11}, Landroid/widget/RadioButton;->isChecked()Z

    move-result v11

    if-nez v11, :cond_9

    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->genderFemale:Landroid/widget/RadioButton;
    invoke-static {v11}, Lcom/livemixtapes/SignUp;->access$30(Lcom/livemixtapes/SignUp;)Landroid/widget/RadioButton;

    move-result-object v11

    invoke-virtual {v11}, Landroid/widget/RadioButton;->isChecked()Z

    move-result v11

    if-nez v11, :cond_9

    .line 389
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    iget-object v12, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_genderbox:Landroid/widget/LinearLayout;
    invoke-static {v12}, Lcom/livemixtapes/SignUp;->access$31(Lcom/livemixtapes/SignUp;)Landroid/widget/LinearLayout;

    move-result-object v12

    # invokes: Lcom/livemixtapes/SignUp;->shake(Landroid/view/View;)V
    invoke-static {v11, v12}, Lcom/livemixtapes/SignUp;->access$13(Lcom/livemixtapes/SignUp;Landroid/view/View;)V

    .line 390
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->genderMale:Landroid/widget/RadioButton;
    invoke-static {v11}, Lcom/livemixtapes/SignUp;->access$29(Lcom/livemixtapes/SignUp;)Landroid/widget/RadioButton;

    move-result-object v11

    invoke-virtual {v11}, Landroid/widget/RadioButton;->requestFocus()Z

    goto/16 :goto_0

    .line 392
    :cond_9
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_birthdate:Landroid/widget/EditText;
    invoke-static {v11}, Lcom/livemixtapes/SignUp;->access$32(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v11

    invoke-virtual {v11}, Landroid/widget/EditText;->length()I

    move-result v11

    if-nez v11, :cond_a

    .line 393
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    iget-object v12, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_birthdatebox:Landroid/widget/LinearLayout;
    invoke-static {v12}, Lcom/livemixtapes/SignUp;->access$33(Lcom/livemixtapes/SignUp;)Landroid/widget/LinearLayout;

    move-result-object v12

    # invokes: Lcom/livemixtapes/SignUp;->shake(Landroid/view/View;)V
    invoke-static {v11, v12}, Lcom/livemixtapes/SignUp;->access$13(Lcom/livemixtapes/SignUp;Landroid/view/View;)V

    .line 394
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_birthdate:Landroid/widget/EditText;
    invoke-static {v11}, Lcom/livemixtapes/SignUp;->access$32(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v11

    invoke-virtual {v11}, Landroid/widget/EditText;->requestFocus()Z

    goto/16 :goto_0

    .line 396
    :cond_a
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_tos:Landroid/widget/CheckBox;
    invoke-static {v11}, Lcom/livemixtapes/SignUp;->access$34(Lcom/livemixtapes/SignUp;)Landroid/widget/CheckBox;

    move-result-object v11

    invoke-virtual {v11}, Landroid/widget/CheckBox;->isChecked()Z

    move-result v11

    if-nez v11, :cond_b

    .line 397
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    iget-object v12, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_toscheckbox:Landroid/widget/LinearLayout;
    invoke-static {v12}, Lcom/livemixtapes/SignUp;->access$35(Lcom/livemixtapes/SignUp;)Landroid/widget/LinearLayout;

    move-result-object v12

    # invokes: Lcom/livemixtapes/SignUp;->shake(Landroid/view/View;)V
    invoke-static {v11, v12}, Lcom/livemixtapes/SignUp;->access$13(Lcom/livemixtapes/SignUp;Landroid/view/View;)V

    .line 398
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_tos:Landroid/widget/CheckBox;
    invoke-static {v11}, Lcom/livemixtapes/SignUp;->access$34(Lcom/livemixtapes/SignUp;)Landroid/widget/CheckBox;

    move-result-object v11

    invoke-virtual {v11}, Landroid/widget/CheckBox;->requestFocus()Z

    goto/16 :goto_0

    .line 406
    :cond_b
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    invoke-virtual {v11}, Lcom/livemixtapes/SignUp;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    const v12, 0x7f0f0001

    invoke-virtual {v11, v12}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v1

    .line 407
    .local v1, "country_array":[Ljava/lang/String;
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->countrySelector:Landroid/widget/Spinner;
    invoke-static {v11}, Lcom/livemixtapes/SignUp;->access$36(Lcom/livemixtapes/SignUp;)Landroid/widget/Spinner;

    move-result-object v11

    invoke-virtual {v11}, Landroid/widget/Spinner;->getSelectedItemPosition()I

    move-result v11

    aget-object v2, v1, v11

    .line 408
    .local v2, "form_country":Ljava/lang/String;
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_birthdate:Landroid/widget/EditText;
    invoke-static {v11}, Lcom/livemixtapes/SignUp;->access$32(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v11

    invoke-virtual {v11}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v11

    invoke-interface {v11}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v0

    .line 410
    .local v0, "all_birthday":Ljava/lang/String;
    const-string v11, "/"

    invoke-virtual {v0, v11}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v10

    .line 411
    .local v10, "split_birthday":[Ljava/lang/String;
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_email:Landroid/widget/EditText;
    invoke-static {v11}, Lcom/livemixtapes/SignUp;->access$14(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v11

    invoke-virtual {v11}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v11

    invoke-interface {v11}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v3

    .line 412
    .local v3, "form_email":Ljava/lang/String;
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_firstname:Landroid/widget/EditText;
    invoke-static {v11}, Lcom/livemixtapes/SignUp;->access$23(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v11

    invoke-virtual {v11}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v11

    invoke-interface {v11}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v4

    .local v4, "form_firstname":Ljava/lang/String;
    const/4 v11, 0x1

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v12, 0x0

    .line 414
    const/4 v13, 0x0

    aget-object v13, v10, v13

    aput-object v13, v11, v12

    invoke-static {v11}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 415
    const/4 v5, 0x0

    .line 417
    .local v5, "form_gender":Ljava/lang/String;
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->genderMale:Landroid/widget/RadioButton;
    invoke-static {v11}, Lcom/livemixtapes/SignUp;->access$29(Lcom/livemixtapes/SignUp;)Landroid/widget/RadioButton;

    move-result-object v11

    invoke-virtual {v11}, Landroid/widget/RadioButton;->isChecked()Z

    move-result v11

    if-eqz v11, :cond_d

    .line 419
    const-string v5, "M"

    .line 426
    :cond_c
    :goto_1
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_lastname:Landroid/widget/EditText;
    invoke-static {v11}, Lcom/livemixtapes/SignUp;->access$25(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v11

    invoke-virtual {v11}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v11

    invoke-interface {v11}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v6

    .line 427
    .local v6, "form_lastname":Ljava/lang/String;
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_password:Landroid/widget/EditText;
    invoke-static {v11}, Lcom/livemixtapes/SignUp;->access$19(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v11

    invoke-virtual {v11}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v11

    invoke-interface {v11}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v7

    .line 428
    .local v7, "form_password":Ljava/lang/String;
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->username:Landroid/widget/EditText;
    invoke-static {v11}, Lcom/livemixtapes/SignUp;->access$8(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v11

    invoke-virtual {v11}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v11

    invoke-interface {v11}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v9

    .line 429
    .local v9, "form_username":Ljava/lang/String;
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_postalcode:Landroid/widget/EditText;
    invoke-static {v11}, Lcom/livemixtapes/SignUp;->access$27(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v11

    invoke-virtual {v11}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v11

    invoke-interface {v11}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v8

    .local v8, "form_postalcode":Ljava/lang/String;
    const/4 v11, 0x1

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v12, 0x0

    .line 431
    new-instance v13, Ljava/lang/StringBuilder;

    const-string v14, "country="

    invoke-direct {v13, v14}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v13, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    const-string v14, "&dob_day="

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    const/4 v14, 0x1

    aget-object v14, v10, v14

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    const-string v14, "&dob_month="

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    const/4 v14, 0x0

    aget-object v14, v10, v14

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    const-string v14, "&dob_year="

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    const/4 v14, 0x2

    aget-object v14, v10, v14

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    .line 432
    const-string v14, "&email="

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    const-string v14, "&firstname="

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    const-string v14, "&gender="

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    const-string v14, "&lastname="

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    .line 433
    const-string v14, "&password="

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    const-string v14, "&tos=1"

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    const-string v14, "&username="

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    const-string v14, "&zip="

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    .line 431
    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    aput-object v13, v11, v12

    invoke-static {v11}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 435
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # invokes: Lcom/livemixtapes/SignUp;->signup()V
    invoke-static {v11}, Lcom/livemixtapes/SignUp;->access$37(Lcom/livemixtapes/SignUp;)V

    goto/16 :goto_0

    .line 421
    .end local v6    # "form_lastname":Ljava/lang/String;
    .end local v7    # "form_password":Ljava/lang/String;
    .end local v8    # "form_postalcode":Ljava/lang/String;
    .end local v9    # "form_username":Ljava/lang/String;
    :cond_d
    iget-object v11, p0, Lcom/livemixtapes/SignUp$12;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->genderFemale:Landroid/widget/RadioButton;
    invoke-static {v11}, Lcom/livemixtapes/SignUp;->access$30(Lcom/livemixtapes/SignUp;)Landroid/widget/RadioButton;

    move-result-object v11

    invoke-virtual {v11}, Landroid/widget/RadioButton;->isChecked()Z

    move-result v11

    if-eqz v11, :cond_c

    .line 423
    const-string v5, "F"

    goto/16 :goto_1
.end method

.class Lco/vine/android/ResetPasswordActivity$ResetPasswordListener;
.super Lco/vine/android/client/AppSessionListener;
.source "ResetPasswordActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/ResetPasswordActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ResetPasswordListener"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/ResetPasswordActivity;


# direct methods
.method private constructor <init>(Lco/vine/android/ResetPasswordActivity;)V
    .locals 0

    .prologue
    .line 116
    iput-object p1, p0, Lco/vine/android/ResetPasswordActivity$ResetPasswordListener;->this$0:Lco/vine/android/ResetPasswordActivity;

    invoke-direct {p0}, Lco/vine/android/client/AppSessionListener;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lco/vine/android/ResetPasswordActivity;Lco/vine/android/ResetPasswordActivity$1;)V
    .locals 0
    .param p1, "x0"    # Lco/vine/android/ResetPasswordActivity;
    .param p2, "x1"    # Lco/vine/android/ResetPasswordActivity$1;

    .prologue
    .line 116
    invoke-direct {p0, p1}, Lco/vine/android/ResetPasswordActivity$ResetPasswordListener;-><init>(Lco/vine/android/ResetPasswordActivity;)V

    return-void
.end method


# virtual methods
.method public onResetPasswordComplete(Ljava/lang/String;ILjava/lang/String;)V
    .locals 3
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;

    .prologue
    .line 120
    iget-object v2, p0, Lco/vine/android/ResetPasswordActivity$ResetPasswordListener;->this$0:Lco/vine/android/ResetPasswordActivity;

    invoke-virtual {v2}, Lco/vine/android/ResetPasswordActivity;->dismissDialog()V

    .line 123
    sparse-switch p2, :sswitch_data_0

    .line 133
    const v0, 0x7f0e016f

    .line 138
    .local v0, "error":I
    :goto_0
    const/4 v2, 0x1

    invoke-static {v2}, Lco/vine/android/widgets/PromptDialogSupportFragment;->newInstance(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v1

    .line 140
    .local v1, "f":Lco/vine/android/widgets/PromptDialogSupportFragment;
    invoke-virtual {v1, v0}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setMessage(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 141
    const v2, 0x7f0e0163

    invoke-virtual {v1, v2}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setPositiveButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 142
    iget-object v2, p0, Lco/vine/android/ResetPasswordActivity$ResetPasswordListener;->this$0:Lco/vine/android/ResetPasswordActivity;

    invoke-virtual {v2}, Lco/vine/android/ResetPasswordActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v2

    invoke-virtual {v1, v2}, Lco/vine/android/widgets/PromptDialogSupportFragment;->show(Landroid/support/v4/app/FragmentManager;)V

    .line 143
    return-void

    .line 125
    .end local v0    # "error":I
    .end local v1    # "f":Lco/vine/android/widgets/PromptDialogSupportFragment;
    :sswitch_0
    const v0, 0x7f0e016e

    .line 126
    .restart local v0    # "error":I
    goto :goto_0

    .line 129
    .end local v0    # "error":I
    :sswitch_1
    const v0, 0x7f0e0170

    .line 130
    .restart local v0    # "error":I
    goto :goto_0

    .line 123
    nop

    :sswitch_data_0
    .sparse-switch
        0xc8 -> :sswitch_0
        0x194 -> :sswitch_1
    .end sparse-switch
.end method
